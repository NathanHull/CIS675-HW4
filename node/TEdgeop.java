/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class TEdgeop extends Token
{
    public TEdgeop()
    {
        super.setText("->");
    }

    public TEdgeop(int line, int pos)
    {
        super.setText("->");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TEdgeop(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTEdgeop(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TEdgeop text.");
    }
}