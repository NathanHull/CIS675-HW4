/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class TSw extends Token
{
    public TSw()
    {
        super.setText("sw");
    }

    public TSw(int line, int pos)
    {
        super.setText("sw");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TSw(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTSw(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TSw text.");
    }
}
