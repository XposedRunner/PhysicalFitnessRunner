package com.qiyukf.nim.uikit.session.emoji;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;

public final class a extends BaseAdapter {
    private Context a;
    private int b;

    public a(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    public final int getCount() {
        return Math.min((b.a() - this.b) + 1, 28);
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) (this.b + i);
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.ysf_emoji_item, null);
            view.setLayoutParams(new LayoutParams((d.c() / 7) - 10, com.qiyukf.nim.uikit.session.module.input.d.b() / 4));
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.imgEmoji);
        int a = b.a();
        int i2 = this.b + i;
        if (i == 27 || i2 == a) {
            imageView.setBackgroundResource(R.drawable.ysf_emoji_del);
        } else if (i2 < a) {
            imageView.setBackgroundDrawable(b.a(this.a, i2));
            return view;
        }
        return view;
    }
}
