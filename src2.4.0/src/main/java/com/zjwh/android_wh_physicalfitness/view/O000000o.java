package com.zjwh.android_wh_physicalfitness.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* compiled from: DividerItemBigDecoration */
public class O000000o extends ItemDecoration {
    private int O000000o;

    public O000000o(int i) {
        this.O000000o = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        rect.set(0, 0, 0, this.O000000o);
    }
}
