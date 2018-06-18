/* This file was generated by SableCC (http://www.sablecc.org/). */

package analysis;

import java.util.*;
import node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPGraph().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inAGraphGraph(AGraphGraph node)
    {
        defaultIn(node);
    }

    public void outAGraphGraph(AGraphGraph node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGraphGraph(AGraphGraph node)
    {
        inAGraphGraph(node);
        if(node.getStrict() != null)
        {
            node.getStrict().apply(this);
        }
        if(node.getGraphk() != null)
        {
            node.getGraphk().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getLeftbrace() != null)
        {
            node.getLeftbrace().apply(this);
        }
        if(node.getStmtList() != null)
        {
            node.getStmtList().apply(this);
        }
        if(node.getRightbrace() != null)
        {
            node.getRightbrace().apply(this);
        }
        outAGraphGraph(node);
    }

    public void inADigraphGraph(ADigraphGraph node)
    {
        defaultIn(node);
    }

    public void outADigraphGraph(ADigraphGraph node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADigraphGraph(ADigraphGraph node)
    {
        inADigraphGraph(node);
        if(node.getStrict() != null)
        {
            node.getStrict().apply(this);
        }
        if(node.getDigraphk() != null)
        {
            node.getDigraphk().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getLeftbrace() != null)
        {
            node.getLeftbrace().apply(this);
        }
        if(node.getStmtList() != null)
        {
            node.getStmtList().apply(this);
        }
        if(node.getRightbrace() != null)
        {
            node.getRightbrace().apply(this);
        }
        outADigraphGraph(node);
    }

    public void inAContinueStmtList(AContinueStmtList node)
    {
        defaultIn(node);
    }

    public void outAContinueStmtList(AContinueStmtList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAContinueStmtList(AContinueStmtList node)
    {
        inAContinueStmtList(node);
        if(node.getStmt() != null)
        {
            node.getStmt().apply(this);
        }
        if(node.getSemicolon() != null)
        {
            node.getSemicolon().apply(this);
        }
        if(node.getStmtList() != null)
        {
            node.getStmtList().apply(this);
        }
        outAContinueStmtList(node);
    }

    public void inAEmptyStmtList(AEmptyStmtList node)
    {
        defaultIn(node);
    }

    public void outAEmptyStmtList(AEmptyStmtList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEmptyStmtList(AEmptyStmtList node)
    {
        inAEmptyStmtList(node);
        outAEmptyStmtList(node);
    }

    public void inANstmtStmt(ANstmtStmt node)
    {
        defaultIn(node);
    }

    public void outANstmtStmt(ANstmtStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANstmtStmt(ANstmtStmt node)
    {
        inANstmtStmt(node);
        if(node.getNodeStmt() != null)
        {
            node.getNodeStmt().apply(this);
        }
        outANstmtStmt(node);
    }

    public void inAEstmtStmt(AEstmtStmt node)
    {
        defaultIn(node);
    }

    public void outAEstmtStmt(AEstmtStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEstmtStmt(AEstmtStmt node)
    {
        inAEstmtStmt(node);
        if(node.getEdgeStmt() != null)
        {
            node.getEdgeStmt().apply(this);
        }
        outAEstmtStmt(node);
    }

    public void inAAtstmtStmt(AAtstmtStmt node)
    {
        defaultIn(node);
    }

    public void outAAtstmtStmt(AAtstmtStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAtstmtStmt(AAtstmtStmt node)
    {
        inAAtstmtStmt(node);
        if(node.getAttrStmt() != null)
        {
            node.getAttrStmt().apply(this);
        }
        outAAtstmtStmt(node);
    }

    public void inAAsstmtStmt(AAsstmtStmt node)
    {
        defaultIn(node);
    }

    public void outAAsstmtStmt(AAsstmtStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAsstmtStmt(AAsstmtStmt node)
    {
        inAAsstmtStmt(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        if(node.getAssignment() != null)
        {
            node.getAssignment().apply(this);
        }
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        outAAsstmtStmt(node);
    }

    public void inASstmtStmt(ASstmtStmt node)
    {
        defaultIn(node);
    }

    public void outASstmtStmt(ASstmtStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASstmtStmt(ASstmtStmt node)
    {
        inASstmtStmt(node);
        if(node.getSubgraph() != null)
        {
            node.getSubgraph().apply(this);
        }
        outASstmtStmt(node);
    }

    public void inAGraphasAttrStmt(AGraphasAttrStmt node)
    {
        defaultIn(node);
    }

    public void outAGraphasAttrStmt(AGraphasAttrStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGraphasAttrStmt(AGraphasAttrStmt node)
    {
        inAGraphasAttrStmt(node);
        if(node.getGraphk() != null)
        {
            node.getGraphk().apply(this);
        }
        if(node.getAttrList() != null)
        {
            node.getAttrList().apply(this);
        }
        outAGraphasAttrStmt(node);
    }

    public void inANodeasAttrStmt(ANodeasAttrStmt node)
    {
        defaultIn(node);
    }

    public void outANodeasAttrStmt(ANodeasAttrStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANodeasAttrStmt(ANodeasAttrStmt node)
    {
        inANodeasAttrStmt(node);
        if(node.getNodek() != null)
        {
            node.getNodek().apply(this);
        }
        if(node.getAttrList() != null)
        {
            node.getAttrList().apply(this);
        }
        outANodeasAttrStmt(node);
    }

    public void inAEdgeasAttrStmt(AEdgeasAttrStmt node)
    {
        defaultIn(node);
    }

    public void outAEdgeasAttrStmt(AEdgeasAttrStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEdgeasAttrStmt(AEdgeasAttrStmt node)
    {
        inAEdgeasAttrStmt(node);
        if(node.getEdgek() != null)
        {
            node.getEdgek().apply(this);
        }
        if(node.getAttrList() != null)
        {
            node.getAttrList().apply(this);
        }
        outAEdgeasAttrStmt(node);
    }

    public void inAAttrList(AAttrList node)
    {
        defaultIn(node);
    }

    public void outAAttrList(AAttrList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAttrList(AAttrList node)
    {
        inAAttrList(node);
        if(node.getLeftbracket() != null)
        {
            node.getLeftbracket().apply(this);
        }
        if(node.getAList() != null)
        {
            node.getAList().apply(this);
        }
        if(node.getRightbracket() != null)
        {
            node.getRightbracket().apply(this);
        }
        if(node.getAttrList() != null)
        {
            node.getAttrList().apply(this);
        }
        outAAttrList(node);
    }

    public void inACommasepAList(ACommasepAList node)
    {
        defaultIn(node);
    }

    public void outACommasepAList(ACommasepAList node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACommasepAList(ACommasepAList node)
    {
        inACommasepAList(node);
        if(node.getL() != null)
        {
            node.getL().apply(this);
        }
        if(node.getAssignment() != null)
        {
            node.getAssignment().apply(this);
        }
        if(node.getR() != null)
        {
            node.getR().apply(this);
        }
        if(node.getComma() != null)
        {
            node.getComma().apply(this);
        }
        if(node.getAList() != null)
        {
            node.getAList().apply(this);
        }
        outACommasepAList(node);
    }

    public void inANodeesEdgeStmt(ANodeesEdgeStmt node)
    {
        defaultIn(node);
    }

    public void outANodeesEdgeStmt(ANodeesEdgeStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANodeesEdgeStmt(ANodeesEdgeStmt node)
    {
        inANodeesEdgeStmt(node);
        if(node.getNodeId() != null)
        {
            node.getNodeId().apply(this);
        }
        if(node.getEdgerhs() != null)
        {
            node.getEdgerhs().apply(this);
        }
        if(node.getAttrList() != null)
        {
            node.getAttrList().apply(this);
        }
        outANodeesEdgeStmt(node);
    }

    public void inASubesEdgeStmt(ASubesEdgeStmt node)
    {
        defaultIn(node);
    }

    public void outASubesEdgeStmt(ASubesEdgeStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubesEdgeStmt(ASubesEdgeStmt node)
    {
        inASubesEdgeStmt(node);
        if(node.getSubgraph() != null)
        {
            node.getSubgraph().apply(this);
        }
        if(node.getEdgerhs() != null)
        {
            node.getEdgerhs().apply(this);
        }
        if(node.getAttrList() != null)
        {
            node.getAttrList().apply(this);
        }
        outASubesEdgeStmt(node);
    }

    public void inANodeerEdgerhs(ANodeerEdgerhs node)
    {
        defaultIn(node);
    }

    public void outANodeerEdgerhs(ANodeerEdgerhs node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANodeerEdgerhs(ANodeerEdgerhs node)
    {
        inANodeerEdgerhs(node);
        if(node.getEdgeop() != null)
        {
            node.getEdgeop().apply(this);
        }
        if(node.getNodeId() != null)
        {
            node.getNodeId().apply(this);
        }
        if(node.getEdgerhs() != null)
        {
            node.getEdgerhs().apply(this);
        }
        outANodeerEdgerhs(node);
    }

    public void inASuberEdgerhs(ASuberEdgerhs node)
    {
        defaultIn(node);
    }

    public void outASuberEdgerhs(ASuberEdgerhs node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASuberEdgerhs(ASuberEdgerhs node)
    {
        inASuberEdgerhs(node);
        if(node.getEdgeop() != null)
        {
            node.getEdgeop().apply(this);
        }
        if(node.getSubgraph() != null)
        {
            node.getSubgraph().apply(this);
        }
        if(node.getEdgerhs() != null)
        {
            node.getEdgerhs().apply(this);
        }
        outASuberEdgerhs(node);
    }

    public void inANodestmtNodeStmt(ANodestmtNodeStmt node)
    {
        defaultIn(node);
    }

    public void outANodestmtNodeStmt(ANodestmtNodeStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANodestmtNodeStmt(ANodestmtNodeStmt node)
    {
        inANodestmtNodeStmt(node);
        if(node.getNodeId() != null)
        {
            node.getNodeId().apply(this);
        }
        if(node.getAttrList() != null)
        {
            node.getAttrList().apply(this);
        }
        outANodestmtNodeStmt(node);
    }

    public void inANodeId(ANodeId node)
    {
        defaultIn(node);
    }

    public void outANodeId(ANodeId node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANodeId(ANodeId node)
    {
        inANodeId(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getPort() != null)
        {
            node.getPort().apply(this);
        }
        outANodeId(node);
    }

    public void inAIportPort(AIportPort node)
    {
        defaultIn(node);
    }

    public void outAIportPort(AIportPort node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIportPort(AIportPort node)
    {
        inAIportPort(node);
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAIportPort(node);
    }

    public void inANportPort(ANportPort node)
    {
        defaultIn(node);
    }

    public void outANportPort(ANportPort node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANportPort(ANportPort node)
    {
        inANportPort(node);
        if(node.getFirst() != null)
        {
            node.getFirst().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getSecond() != null)
        {
            node.getSecond().apply(this);
        }
        if(node.getCompassPt() != null)
        {
            node.getCompassPt().apply(this);
        }
        outANportPort(node);
    }

    public void inACportPort(ACportPort node)
    {
        defaultIn(node);
    }

    public void outACportPort(ACportPort node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACportPort(ACportPort node)
    {
        inACportPort(node);
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }
        if(node.getCompassPt() != null)
        {
            node.getCompassPt().apply(this);
        }
        outACportPort(node);
    }

    public void inASubgSubgraph(ASubgSubgraph node)
    {
        defaultIn(node);
    }

    public void outASubgSubgraph(ASubgSubgraph node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubgSubgraph(ASubgSubgraph node)
    {
        inASubgSubgraph(node);
        if(node.getLeftbrace() != null)
        {
            node.getLeftbrace().apply(this);
        }
        if(node.getStmtList() != null)
        {
            node.getStmtList().apply(this);
        }
        if(node.getRightbrace() != null)
        {
            node.getRightbrace().apply(this);
        }
        outASubgSubgraph(node);
    }

    public void inANsubgSubgraph(ANsubgSubgraph node)
    {
        defaultIn(node);
    }

    public void outANsubgSubgraph(ANsubgSubgraph node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANsubgSubgraph(ANsubgSubgraph node)
    {
        inANsubgSubgraph(node);
        if(node.getSubgraphk() != null)
        {
            node.getSubgraphk().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getLeftbrace() != null)
        {
            node.getLeftbrace().apply(this);
        }
        if(node.getStmtList() != null)
        {
            node.getStmtList().apply(this);
        }
        if(node.getRightbrace() != null)
        {
            node.getRightbrace().apply(this);
        }
        outANsubgSubgraph(node);
    }

    public void inADsubgSubgraph(ADsubgSubgraph node)
    {
        defaultIn(node);
    }

    public void outADsubgSubgraph(ADsubgSubgraph node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADsubgSubgraph(ADsubgSubgraph node)
    {
        inADsubgSubgraph(node);
        if(node.getSubgraphk() != null)
        {
            node.getSubgraphk().apply(this);
        }
        if(node.getLeftbrace() != null)
        {
            node.getLeftbrace().apply(this);
        }
        if(node.getStmtList() != null)
        {
            node.getStmtList().apply(this);
        }
        if(node.getRightbrace() != null)
        {
            node.getRightbrace().apply(this);
        }
        outADsubgSubgraph(node);
    }

    public void inACpnCompassPt(ACpnCompassPt node)
    {
        defaultIn(node);
    }

    public void outACpnCompassPt(ACpnCompassPt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpnCompassPt(ACpnCompassPt node)
    {
        inACpnCompassPt(node);
        if(node.getN() != null)
        {
            node.getN().apply(this);
        }
        outACpnCompassPt(node);
    }

    public void inACpneCompassPt(ACpneCompassPt node)
    {
        defaultIn(node);
    }

    public void outACpneCompassPt(ACpneCompassPt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpneCompassPt(ACpneCompassPt node)
    {
        inACpneCompassPt(node);
        if(node.getNe() != null)
        {
            node.getNe().apply(this);
        }
        outACpneCompassPt(node);
    }

    public void inACpeCompassPt(ACpeCompassPt node)
    {
        defaultIn(node);
    }

    public void outACpeCompassPt(ACpeCompassPt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpeCompassPt(ACpeCompassPt node)
    {
        inACpeCompassPt(node);
        if(node.getE() != null)
        {
            node.getE().apply(this);
        }
        outACpeCompassPt(node);
    }

    public void inACpseCompassPt(ACpseCompassPt node)
    {
        defaultIn(node);
    }

    public void outACpseCompassPt(ACpseCompassPt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpseCompassPt(ACpseCompassPt node)
    {
        inACpseCompassPt(node);
        if(node.getSe() != null)
        {
            node.getSe().apply(this);
        }
        outACpseCompassPt(node);
    }

    public void inACpsCompassPt(ACpsCompassPt node)
    {
        defaultIn(node);
    }

    public void outACpsCompassPt(ACpsCompassPt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpsCompassPt(ACpsCompassPt node)
    {
        inACpsCompassPt(node);
        if(node.getS() != null)
        {
            node.getS().apply(this);
        }
        outACpsCompassPt(node);
    }

    public void inACpswCompassPt(ACpswCompassPt node)
    {
        defaultIn(node);
    }

    public void outACpswCompassPt(ACpswCompassPt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpswCompassPt(ACpswCompassPt node)
    {
        inACpswCompassPt(node);
        if(node.getSw() != null)
        {
            node.getSw().apply(this);
        }
        outACpswCompassPt(node);
    }

    public void inACpwCompassPt(ACpwCompassPt node)
    {
        defaultIn(node);
    }

    public void outACpwCompassPt(ACpwCompassPt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpwCompassPt(ACpwCompassPt node)
    {
        inACpwCompassPt(node);
        if(node.getW() != null)
        {
            node.getW().apply(this);
        }
        outACpwCompassPt(node);
    }

    public void inACpnwCompassPt(ACpnwCompassPt node)
    {
        defaultIn(node);
    }

    public void outACpnwCompassPt(ACpnwCompassPt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpnwCompassPt(ACpnwCompassPt node)
    {
        inACpnwCompassPt(node);
        if(node.getNw() != null)
        {
            node.getNw().apply(this);
        }
        outACpnwCompassPt(node);
    }

    public void inACpcCompassPt(ACpcCompassPt node)
    {
        defaultIn(node);
    }

    public void outACpcCompassPt(ACpcCompassPt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpcCompassPt(ACpcCompassPt node)
    {
        inACpcCompassPt(node);
        if(node.getC() != null)
        {
            node.getC().apply(this);
        }
        outACpcCompassPt(node);
    }

    public void inACpuCompassPt(ACpuCompassPt node)
    {
        defaultIn(node);
    }

    public void outACpuCompassPt(ACpuCompassPt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACpuCompassPt(ACpuCompassPt node)
    {
        inACpuCompassPt(node);
        if(node.getU() != null)
        {
            node.getU().apply(this);
        }
        outACpuCompassPt(node);
    }
}
