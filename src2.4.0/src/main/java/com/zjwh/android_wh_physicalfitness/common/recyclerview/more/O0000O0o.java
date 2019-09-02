package com.zjwh.android_wh_physicalfitness.common.recyclerview.more;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter.O000000o;

/* compiled from: RecyclerViewStateUtils */
public class O0000O0o {
    public static O000000o O000000o(RecyclerView recyclerView) {
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null && (adapter instanceof O00000o0)) {
            O00000o0 o00000o0 = (O00000o0) adapter;
            if (o00000o0.O00000oO() > 0) {
                return ((LoadingFooter) o00000o0.O00000Oo()).getState();
            }
        }
        return O000000o.Normal;
    }

    public static void O000000o(Activity activity, final RecyclerView recyclerView, int i, O000000o o000000o, OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing()) {
            Adapter adapter = recyclerView.getAdapter();
            if (adapter instanceof O00000o0) {
                final O00000o0 o00000o0 = (O00000o0) adapter;
                if (o00000o0.O000000o().getItemCount() >= i) {
                    if (o00000o0.O00000oO() > 0) {
                        LoadingFooter loadingFooter = (LoadingFooter) o00000o0.O00000Oo();
                        loadingFooter.setState(o000000o);
                        if (o000000o == O000000o.NetWorkError) {
                            loadingFooter.setOnClickListener(onClickListener);
                        }
                        recyclerView.scrollToPosition(o00000o0.getItemCount() - 1);
                    } else {
                        View loadingFooter2 = new LoadingFooter(activity);
                        loadingFooter2.setState(o000000o);
                        if (o000000o == O000000o.NetWorkError) {
                            loadingFooter2.setOnClickListener(onClickListener);
                        }
                        o00000o0.O00000Oo(loadingFooter2);
                        final LayoutManager layoutManager = recyclerView.getLayoutManager();
                        if (layoutManager instanceof GridLayoutManager) {
                            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new SpanSizeLookup() {
                                public int getSpanSize(int i) {
                                    return (i != recyclerView.getAdapter().getItemCount() - 1 || o00000o0.O00000Oo() == null) ? 1 : ((GridLayoutManager) layoutManager).getSpanCount();
                                }
                            });
                        }
                        if (o000000o != O000000o.TheEnd) {
                            recyclerView.scrollToPosition(o00000o0.getItemCount() - 1);
                        }
                    }
                }
            }
        }
    }

    public static void O000000o(RecyclerView recyclerView, O000000o o000000o) {
        Adapter adapter = recyclerView.getAdapter();
        if (adapter != null && (adapter instanceof O00000o0)) {
            O00000o0 o00000o0 = (O00000o0) adapter;
            if (o00000o0.O00000oO() > 0) {
                ((LoadingFooter) o00000o0.O00000Oo()).setState(o000000o);
            }
        }
    }
}
