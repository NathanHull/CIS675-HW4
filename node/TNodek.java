/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class TNodek extends Token
{
    public TNodek()
    {
        super.setText("node");
    }

    public TNodek(int line, int pos)
    {
        super.setText("node");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TNodek(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNodek(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TNodek text.");
    }
}
