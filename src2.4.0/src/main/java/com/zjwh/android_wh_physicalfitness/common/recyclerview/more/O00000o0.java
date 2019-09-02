package com.zjwh.android_wh_physicalfitness.common.recyclerview.more;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

/* compiled from: HeaderAndFooterRecyclerViewAdapter */
public class O00000o0 extends Adapter<ViewHolder> {
    private static final int O000000o = Integer.MIN_VALUE;
    private static final int O00000Oo = -2147483646;
    private ArrayList<View> O00000o = new ArrayList();
    private Adapter O00000o0;
    private ArrayList<View> O00000oO = new ArrayList();
    private AdapterDataObserver O00000oo = new AdapterDataObserver() {
        public void onChanged() {
            super.onChanged();
            O00000o0.this.notifyDataSetChanged();
        }

        public void onItemRangeChanged(int i, int i2) {
            super.onItemRangeChanged(i, i2);
            O00000o0.this.notifyItemRangeChanged(i + O00000o0.this.O00000o(), i2);
        }

        public void onItemRangeInserted(int i, int i2) {
            super.onItemRangeInserted(i, i2);
            O00000o0.this.notifyItemRangeInserted(i + O00000o0.this.O00000o(), i2);
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            super.onItemRangeMoved(i, i2, i3);
            int O00000o = O00000o0.this.O00000o();
            O00000o0.this.notifyItemRangeChanged(i + O00000o, (i2 + O00000o) + i3);
        }

        public void onItemRangeRemoved(int i, int i2) {
            super.onItemRangeRemoved(i, i2);
            O00000o0.this.notifyItemRangeRemoved(i + O00000o0.this.O00000o(), i2);
        }
    };

    /* compiled from: HeaderAndFooterRecyclerViewAdapter */
    public static class O000000o extends ViewHolder {
        public O000000o(View view) {
            super(view);
        }
    }

    public O00000o0(Adapter adapter) {
        O000000o(adapter);
    }

    public Adapter O000000o() {
        return this.O00000o0;
    }

    public void O000000o(Adapter adapter) {
        if (adapter != null) {
            if (this.O00000o0 != null) {
                notifyItemRangeRemoved(O00000o(), this.O00000o0.getItemCount());
                this.O00000o0.unregisterAdapterDataObserver(this.O00000oo);
            }
            this.O00000o0 = adapter;
            this.O00000o0.registerAdapterDataObserver(this.O00000oo);
            notifyItemRangeInserted(O00000o(), this.O00000o0.getItemCount());
        }
    }

    public void O000000o(View view) {
        if (view == null) {
            throw new RuntimeException("header is null");
        }
        this.O00000o.add(view);
        notifyDataSetChanged();
    }

    public boolean O000000o(int i) {
        return O00000o() > 0 && i == 0;
    }

    public View O00000Oo() {
        return O00000oO() > 0 ? (View) this.O00000oO.get(0) : null;
    }

    public void O00000Oo(View view) {
        if (view == null) {
            throw new RuntimeException("footer is null");
        }
        this.O00000oO.add(view);
        notifyItemInserted(getItemCount());
    }

    public boolean O00000Oo(int i) {
        return O00000oO() > 0 && i == getItemCount() - 1;
    }

    public int O00000o() {
        return this.O00000o.size();
    }

    public void O00000o(View view) {
        if (view != null) {
            this.O00000oO.remove(view);
            notifyItemRemoved(getItemCount());
        }
    }

    public View O00000o0() {
        return O00000o() > 0 ? (View) this.O00000o.get(0) : null;
    }

    public void O00000o0(View view) {
        this.O00000o.remove(view);
        notifyDataSetChanged();
    }

    public int O00000oO() {
        return this.O00000oO.size();
    }

    public int getItemCount() {
        return (O00000o() + O00000oO()) + this.O00000o0.getItemCount();
    }

    public int getItemViewType(int i) {
        int itemCount = this.O00000o0.getItemCount();
        int O00000o = O00000o();
        if (i < O00000o) {
            return Integer.MIN_VALUE + i;
        }
        if (i >= O00000o + itemCount) {
            return ((O00000Oo + i) - O00000o) - itemCount;
        }
        i = this.O00000o0.getItemViewType(i - O00000o);
        if (i < 1073741823) {
            return i + 1073741823;
        }
        throw new IllegalArgumentException("your adapter's return value of getViewTypeCount() must < Integer.MAX_VALUE / 2");
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        int O00000o = O00000o();
        if (i < O00000o || i >= this.O00000o0.getItemCount() + O00000o) {
            LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
                return;
            }
            return;
        }
        this.O00000o0.onBindViewHolder(viewHolder, i - O00000o);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i < O00000o() + Integer.MIN_VALUE ? new O000000o((View) this.O00000o.get(i - Integer.MIN_VALUE)) : (i < O00000Oo || i >= 1073741823) ? this.O00000o0.onCreateViewHolder(viewGroup, i - 1073741823) : new O000000o((View) this.O00000oO.get(i - O00000Oo));
    }
}
