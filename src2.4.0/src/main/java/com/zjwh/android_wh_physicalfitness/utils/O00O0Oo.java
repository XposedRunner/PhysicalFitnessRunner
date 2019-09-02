package com.zjwh.android_wh_physicalfitness.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: GridSpacingItemDecoration */
public class O00O0Oo extends ItemDecoration {
    private int O000000o;
    private int O00000Oo;
    private boolean O00000o0;

    public O00O0Oo(int i, int i2, boolean z) {
        this.O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = childAdapterPosition % this.O000000o;
        if (this.O00000o0) {
            rect.left = this.O00000Oo - ((this.O00000Oo * i) / this.O000000o);
            rect.right = ((i + 1) * this.O00000Oo) / this.O000000o;
            if (childAdapterPosition < this.O000000o) {
                rect.top = this.O00000Oo;
            }
            rect.bottom = this.O00000Oo;
            return;
        }
        rect.left = (this.O00000Oo * i) / this.O000000o;
        rect.right = this.O00000Oo - (((i + 1) * this.O00000Oo) / this.O000000o);
        if (childAdapterPosition >= this.O000000o) {
            rect.top = this.O00000Oo;
        }
    }
}
