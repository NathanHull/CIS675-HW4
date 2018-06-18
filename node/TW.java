/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class TW extends Token
{
    public TW()
    {
        super.setText("w");
    }

    public TW(int line, int pos)
    {
        super.setText("w");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TW(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTW(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TW text.");
    }
}