all: Lexer.java parser.java
	javac Lexer.java
	javac Parser.java
	java Parser cleanInput.txt
