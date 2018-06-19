import analysis.*;
import node.*;

public class TranslateGraph extends DepthFirstAdapter {
	public void outAGraphGraph(AGraphGraph node) {
		System.out.println("graph: " + node);
	}

	public void outADigraphGraph(ADigraphGraph node) {
		System.out.println("digraph: " + node);
	}

	public void outAEmptyStmtList(AEmptyStmtList node) {
		System.out.println("empty: " + node);
	}

	public void outAContinueStmtList(AContinueStmtList node) {
		System.out.println("cont: " + node);
	}

	public void outANstmtStmt(ANstmtStmt node) {
		System.out.println("stmt(n): " + node);
	}

	public void outAEstmtStmt(AEstmtStmt node) {
		System.out.println("stmt(e): " + node);
	}

	public void outAAtstmtStmt(AAtstmtStmt node) {
		System.out.println("stmt(atr): " + node);
	}

	public void outAsstmtStmt(ASstmtStmt node) {
		System.out.println("stmt(asn);: " + node);
	}

	public void outAGraphasAttrStmt(AGraphasAttrStmt node) {
		System.out.println("graphAttrStmt: " + node);
	}

	public void outANodeasAttrStmt(ANodeasAttrStmt node) {
		System.out.println("nodeAttrStmt: " + node);
	}

	public void outAEdgeasAttrStmt(AEdgeasAttrStmt node)
    {
		System.out.println("edgeAttrStmt: " + node);
	}
	
	public void outAAttrList(AAttrList node)
    {
		System.out.println("attrlist: " + node);
	}
	
	public void outACommasepAList(ACommasepAList node)
    {
        System.out.println("aList: " + node);
	}
	
	public void outANodeesEdgeStmt(ANodeesEdgeStmt node)
    {
        System.out.println("nodeEdgeStmt: " + node);
    }

	public void outASubesEdgeStmt(ASubesEdgeStmt node)
    {
        System.out.println("subgraphEdgeStmt: " + node);
	}
	
	public void outANodeerEdgerhs(ANodeerEdgerhs node)
    {
        System.out.println("nodeEdgeRhs: " + node);
	}
	
	public void outASuberEdgerhs(ASuberEdgerhs node)
    {
        System.out.println("subEdgeRhs: " + node);
	}
	
	public void outANodeStmt(ANodeStmt node)
    {
        System.out.println("nodeStmt: " + node);
	}
	
	public void outANodeId(ANodeId node)
    {
        System.out.println("nodeId: " + node);
	}
	
	public void outASubgSubgraph(ASubgSubgraph node)
    {
        System.out.println("subgraph: " + node);
	}
	
	public void outANsubgSubgraph(ANsubgSubgraph node)
    {
        System.out.println("subgraphn: " + node);
	}
	
	public void outADsubgSubgraph(ADsubgSubgraph node)
    {
        System.out.println("subgraphd: " + node);
    }
}