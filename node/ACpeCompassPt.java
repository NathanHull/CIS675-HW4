/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class ACpeCompassPt extends PCompassPt
{
    private TE _e_;

    public ACpeCompassPt()
    {
        // Constructor
    }

    public ACpeCompassPt(
        @SuppressWarnings("hiding") TE _e_)
    {
        // Constructor
        setE(_e_);

    }

    @Override
    public Object clone()
    {
        return new ACpeCompassPt(
            cloneNode(this._e_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACpeCompassPt(this);
    }

    public TE getE()
    {
        return this._e_;
    }

    public void setE(TE node)
    {
        if(this._e_ != null)
        {
            this._e_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._e_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._e_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._e_ == child)
        {
            this._e_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._e_ == oldChild)
        {
            setE((TE) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
