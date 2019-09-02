package com.zjwh.android_wh_physicalfitness.common.recyclerview.more;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/* compiled from: EndlessRecyclerOnScrollListener */
public class O00000Oo extends OnScrollListener implements O00000o {
    private static final String O000000o = "O00000Oo";
    protected O000000o O00000Oo;
    private int O00000o;
    private int[] O00000o0;
    private int O00000oO = 0;

    /* compiled from: EndlessRecyclerOnScrollListener */
    public enum O000000o {
        LinearLayout,
        StaggeredGridLayout,
        GridLayout
    }

    private int O000000o(int[] iArr) {
        int i = 0;
        int i2 = iArr[0];
        int length = iArr.length;
        while (i < length) {
            int i3 = iArr[i];
            if (i3 > i2) {
                i2 = i3;
            }
            i++;
        }
        return i2;
    }

    public void O000000o(View view) {
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        this.O00000oO = i;
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        i = layoutManager.getItemCount();
        if (childCount > 0 && this.O00000oO == 0 && this.O00000o >= i - 1 && O0000O0o.O000000o(recyclerView) != com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter.O000000o.Loading) {
            O000000o((View) recyclerView);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (this.O00000Oo == null) {
            if (layoutManager instanceof LinearLayoutManager) {
                this.O00000Oo = O000000o.LinearLayout;
            } else if (layoutManager instanceof GridLayoutManager) {
                this.O00000Oo = O000000o.GridLayout;
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                this.O00000Oo = O000000o.StaggeredGridLayout;
            } else {
                throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
            }
        }
        switch (this.O00000Oo) {
            case LinearLayout:
                this.O00000o = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                return;
            case GridLayout:
                this.O00000o = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                return;
            case StaggeredGridLayout:
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                if (this.O00000o0 == null) {
                    this.O00000o0 = new int[staggeredGridLayoutManager.getSpanCount()];
                }
                staggeredGridLayoutManager.findLastVisibleItemPositions(this.O00000o0);
                this.O00000o = O000000o(this.O00000o0);
                return;
            default:
                return;
        }
    }
}
