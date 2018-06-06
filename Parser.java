// Nathan Hull
// CIS675 HW3

// Input:
// digraph G {
//		main [shape=box]; /* this is a comment */
//		main -> parse [weight=8];
//		parse -> execute;
//		main -> init [style=dotted];
//		main -> cleanup;
//		execute -> make_string;
//		init -> make_string;
//		main -> printf [style=bold,label="100 times"];
//		make_string [label="make a\nstring"];
//		node [shape=box,style=filled,color=".7 .3 1.0"];
// 		execute -> compare;
// }

// Grammar
// 	graph 	: 	[ strict ] (graph | digraph) [ ID ] '{' stmt_list '}'
// 	stmt_list 	: 	[ stmt [ ';' ] stmt_list ]
// 	stmt 	: 	node_stmt
// 	| 	edge_stmt
// 	| 	attr_stmt
// 	| 	ID '=' ID
// 	| 	subgraph
// 	attr_stmt 	: 	(graph | node | edge) attr_list
// 	attr_list 	: 	'[' [ a_list ] ']' [ attr_list ]
// 	a_list 	: 	ID '=' ID [ (';' | ',') ] [ a_list ]
// 	edge_stmt 	: 	(node_id | subgraph) edgeRHS [ attr_list ]
// 	edgeRHS 	: 	edgeop (node_id | subgraph) [ edgeRHS ]
// 	node_stmt 	: 	node_id [ attr_list ]
// 	node_id 	: 	ID [ port ]
// 	port 	: 	':' ID [ ':' compass_pt ]
// 	| 	':' compass_pt
// 	subgraph 	: 	[ subgraph [ ID ] ] '{' stmt_list '}'
// 	compass_pt 	: 	(n | ne | e | se | s | sw | w | nw | c | _)

import java.util.*;

import java.io.*;

class Parser {

	static List<List<String>> lines;
	static String currentToken = "";
	static int lineNumber = 0;
	static int tokenNumber = 0;
	static int checkCtr = 0;

	static Node rootNode;
	static Node currentNode;
	static Node nextNode;

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println(args.length);
			System.out.println("Input error");
			return;
		}

		System.out.println("Lexing file " + args[0]);
		lines = Lexer.lexFile(args[0]);

		if (lines.size() > 0) {
			currentToken = lines.get(0).get(0);
		}

		System.out.println("\n============");
		System.out.println("Parsing file");

		lineNumber = 0;
		tokenNumber = 0;
		checkCtr = 0;

		rootNode = new Node();
		rootNode.type = "begin";
		currentNode = rootNode;

		parseGraph();
		System.out.println("\nParse tree: ");
		rootNode.printChildren();
		System.out.println();
	}

	// Check if next token is sent string, if so move forward
	static boolean accept(String token) {
		boolean isMatching;
		checkCtr++;
		if (checkCtr > 100) {
			System.out.println("Line " + lineNumber + ": infinite loop error");
		}

		if (currentToken.equals(token)) {
			isMatching = true;
			checkCtr = 0;

			// If more tokens, iterate forward
			if (!currentToken.equals("EOF")) {
				tokenNumber++;
				if (tokenNumber >= lines.get(lineNumber).size()) {
					lineNumber++;
					tokenNumber = 0;
		
					if (lineNumber >= lines.size()) {
						currentToken = "EOF";
					}
				}

				currentToken = lines.get(lineNumber).get(tokenNumber);
			}
		} else {
			isMatching = false;
		}

		return isMatching;
	}

	static void parseGraph() {
		nextNode = new Node("graph");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		if (accept("STRICT")) {
			// Is strict
			thisNode.addChild(new Node("STRICT"));
		}
		
		if (accept("GRAPH")) {
			// Is graph
			thisNode.addChild(new Node("GRAPH"));
		} else if (accept("DIGRAPH")) {
			// Is digraph
			thisNode.addChild(new Node("DIGRAPH"));
		} else {
			// Error: graph or digraph required
			System.out.println("Line " + lineNumber + ": missing graph or digraph keyword");
			System.exit(1);
		}

		if (!accept("ID")) {
			// Error: missing graph ID
			System.out.println("Line " + lineNumber + ": missing graph ID");
			System.exit(1);
		}
		thisNode.addChild(new Node("ID"));

		if (accept("LEFT-BRACE")) {
			// Begin graph description
			thisNode.addChild(new Node("LEFT-BRACE"));
			parseStmtList();
		} else {
			System.out.println("Line " + lineNumber + ": missing left bracket");
			System.exit(1);
		}

		// Check if finished
		if (accept("RIGHT-BRACE")) {
			// End graph
			// No error if no stmt in stmt_list
			thisNode.addChild(new Node("RIGHT-BRACE"));
			if (accept("EOF")) {
				// Finished
				System.out.println("No errors found");
			} else {
				// Error: code after finish
				System.out.println("Line " + lineNumber + ": code after program termination");
				System.exit(1);
			}
		} else if (accept("EOF")) {
			// Error: missing closing bracket
			System.out.println("Line " + lineNumber + ": missing closing brace");
			System.exit(1);
		}
	}

	static void parseStmtList() {
		nextNode = new Node("stmt_list");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		parseStmt();
		if (accept("SEMICOLON")) {
			thisNode.addChild(new Node("SEMICOLON"));
			parseStmtList();
			thisNode.addChild(new Node("stmt_list"));
		}
	}

	static void parseStmt() {
		nextNode = new Node("stmt");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		if (accept("ID")) {
			// can be node_stmt, edge_stmt, or ID '=' ID
			thisNode.addChild(new Node("ID"));
			parseNodeId();
			if (accept("GRAPH") || accept("NODE") || accept("EDGE")) {
				// is attr_stmt
				if (accept("LEFT-BRACKET")) {
					thisNode.addChild(new Node("LEFT-BRACKET"));
					parseAttrList();
				} else {
					System.out.println("Line " + lineNumber + ": missing attr_stmt brace");
				}
			} else if (accept("EDGEOP")) {
				thisNode.addChild(new Node("EDGEOP"));
				// is edge_stmt
				parseEdgeStmt();
				if (accept("LEFT-BRACKET")) {
					thisNode.addChild(new Node("LEFT-BRACKET"));
					parseAttrList();
				}
			} else if (accept("ASSIGNMENT")) {
				thisNode.addChild(new Node("ASSIGNMENT"));
				// is ID '=' ID
				if (!accept("ID")) {
					System.out.println("Line " + lineNumber + ": missing ID after assignment");
					System.exit(1);
				}
				thisNode.addChild(new Node("ID"));
			} else if (accept("LEFT-BRACKET")) {
				thisNode.addChild(new Node("LEFT-BRACKET"));
				// is node_stmt
				parseNodeStmt();
			}
		} else if (accept("SUBGRAPH")) {
			parseSubgraph();
		} else if (accept("LEFT-BRACE")) {
			// move r-value subgraph up to this level
			parseStmtList();
			if (!accept("RIGHT-BRACE")) {
				System.out.println("Line " + lineNumber + ": missing closing brace");
				System.exit(1);
			}
		}
	}

	static void parseNodeStmt() {
		nextNode = new Node("node_stmt");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		parseAttrList();
	}

	static void parseEdgeStmt() {
		nextNode = new Node("edge_stmt");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		parseEdgeRHS();
	}

	static void parseNodeId() {
		nextNode = new Node("node_id");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		if (accept("COLON")) {
			thisNode.addChild(new Node("COLON"));
			parsePort();
		}
	}

	static void parsePort() {
		nextNode = new Node("port");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		if (accept("ID")) {
			thisNode.addChild(new Node("ID"));
			if (accept("COLON")) {
				thisNode.addChild(new Node("COLON"));
				parseCompassPt();
			}
		} else {
			System.out.println("Line " + lineNumber + ": missing port ID");
			System.exit(1);
		}
	}
	
	static void parseCompassPt() {
		nextNode = new Node("compass_pt");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		if (accept("N") || accept("NE") || accept("E") || accept("SE") || accept("S") || accept("SW") || accept("W") || accept("NW") || accept("C") || accept("_")) {
			// is valid compass point
			thisNode.addChild(new Node("COMPASS_PT"));
		} else {
			System.out.println("Line " + lineNumber + ": invalid compass point");
			System.exit(1);
		}
	}

	static void parseAttrList() {
		nextNode = new Node("attr_list");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		if (accept("ID")) {
			thisNode.addChild(new Node("ID"));
			parseAList();
		}
		if (accept("LEFT-BRACKET")) {
			thisNode.addChild(new Node("LEFT-BRACKET"));
			parseAttrList();
		}
		if (!accept("RIGHT-BRACKET")) {
			System.out.println("Line " + lineNumber + ": missing closing bracket");
			System.exit(1);
		}
		thisNode.addChild(new Node("RIGHT-BRACKET"));
	}

	static void parseAList() {
		nextNode = new Node("a_list");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		if (accept("ASSIGNMENT")) {
			thisNode.addChild(new Node("ASSIGNMENT"));
			if (accept("ID")) {
				thisNode.addChild(new Node("ID"));
				// Optionals
				// accept("SEMICOLON");
				if (accept("COMMA")) {
					thisNode.addChild(new Node("COMMA"));
				}
				if (accept("ID")) {
					thisNode.addChild(new Node("ID"));
					parseAList();
				}
			} else {
				System.out.println("Line " + lineNumber + ": missing assigned value");
				System.exit(1);
			}
		} else {
			System.out.println("Line " + lineNumber + ": missing assignment");
			System.exit(1);
		}
	}

	static void parseEdgeRHS() {
		nextNode = new Node("edge_RHS");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		if (accept("ID")) {
			thisNode.addChild(new Node("ID"));
			parseNodeId();
			if (accept("EDGEOP")) {
				thisNode.addChild(new Node("EDGEOP"));
				parseEdgeRHS();
			}
		} else if (accept("SUBGRAPH")) {
			thisNode.addChild(new Node("SUBGRAPH"));
			parseNodeId();
			if (accept("EDGEOP")) {
				thisNode.addChild(new Node("EDGEOP"));
				parseEdgeRHS();
			}
		} else {
			System.out.println("Line " + lineNumber + ": missing target node ID");
			System.exit(1);
		}
	}

	static void parseSubgraph() {
		nextNode = new Node("subgraph");
		currentNode.addChild(nextNode);
		currentNode = nextNode;
		Node thisNode = nextNode;

		if (accept("ID")) {
			thisNode.addChild(new Node("ID"));
		}
		if (accept("LEFT-BRACKET")) {
			thisNode.addChild(new Node("LEFT-BRACKET"));
			parseStmtList();
			if (!accept("RIGHT-BRACKET")) {
				System.out.println("Line " + lineNumber + ": missing closing bracket");
				System.exit(1);
			}
			thisNode.addChild(new Node("RIGHT-BRACKET"));
		} else {
			System.out.println("Line " + lineNumber + ": missing bracket");
			System.exit(1);
		}
	}

	// Grammar
// 	graph 	: 	[ strict ] (graph | digraph) [ ID ] '{' stmt_list '}'
// 	stmt_list 	: 	[ stmt [ ';' ] stmt_list ]
// 	stmt 	: 	node_stmt
// 	| 	edge_stmt
// 	| 	attr_stmt
// 	| 	ID '=' ID
// 	| 	subgraph
// 	attr_stmt 	: 	(graph | node | edge) attr_list
// 	attr_list 	: 	'[' [ a_list ] ']' [ attr_list ]
// 	a_list 	: 	ID '=' ID [ (';' | ',') ] [ a_list ]
// 	edge_stmt 	: 	(node_id | subgraph) edgeRHS [ attr_list ]
// 	edgeRHS 	: 	edgeop (node_id | subgraph) [ edgeRHS ]
// 	node_stmt 	: 	node_id [ attr_list ]
// 	node_id 	: 	ID [ port ]
// 	port 	: 	':' ID [ ':' compass_pt ]
// 	| 	':' compass_pt
// 	subgraph 	: 	[ subgraph [ ID ] ] '{' stmt_list '}'
// 	compass_pt 	: 	(n | ne | e | se | s | sw | w | nw | c | _)
}

class Node {
	String type;
	ArrayList<Node> children;

	Node() {
		type = "";
		children = new ArrayList<Node>();
	}

	Node(String s) {
		type = s;
		children = new ArrayList<Node>();
	}

	void addChild(Node child) {
		children.add(child);
	}

	void printChildren() {
		// Queue<Node> queue = new LinkedList<Node>();
		// queue.add(this);

		// while (!queue.isEmpty()) {
		// 	Node temp = queue.remove();
		// 	System.out.print(temp.type + "\t");

		// 	for (Node n : temp.children) {
		// 		queue.add(n);
		// 		System.out.print(n.type + "\t");
		// 	}
		// 	System.out.println();
		// }

		if (!this.children.isEmpty()) {
			System.out.println("\n" + this.type + " children:");
			for (Node n : this.children) {
				System.out.print(n.type + " ");
			}
			System.out.println();
			for (Node n : this.children) {
				n.printChildren();
			}
		}
	}
}