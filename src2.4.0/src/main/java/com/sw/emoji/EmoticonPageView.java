package com.sw.emoji;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public class EmoticonPageView extends RelativeLayout {
    private RecyclerView O000000o;

    public EmoticonPageView(Context context) {
        this(context, null);
    }

    public EmoticonPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O000000o = (RecyclerView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.item_emoticonpage, this).findViewById(R.id.gv_emotion);
        this.O000000o.setLayoutManager(new GridLayoutManager(context, 8));
        this.O000000o.addItemDecoration(new r(8, s.O000000o(context, 9.0f), false));
    }

    public RecyclerView getRecyclerView() {
        return this.O000000o;
    }
}
