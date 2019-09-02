package com.zjwh.android_wh_physicalfitness.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: ItemDecorationLR */
public class O00000o0 extends ItemDecoration {
    private int O000000o;

    public O00000o0(int i) {
        this.O000000o = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        rect.set(this.O000000o, 0, this.O000000o, 0);
    }
}
