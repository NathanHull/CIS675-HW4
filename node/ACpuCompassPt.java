/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class ACpuCompassPt extends PCompassPt
{
    private TU _u_;

    public ACpuCompassPt()
    {
        // Constructor
    }

    public ACpuCompassPt(
        @SuppressWarnings("hiding") TU _u_)
    {
        // Constructor
        setU(_u_);

    }

    @Override
    public Object clone()
    {
        return new ACpuCompassPt(
            cloneNode(this._u_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACpuCompassPt(this);
    }

    public TU getU()
    {
        return this._u_;
    }

    public void setU(TU node)
    {
        if(this._u_ != null)
        {
            this._u_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._u_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._u_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._u_ == child)
        {
            this._u_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._u_ == oldChild)
        {
            setU((TU) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}