package com.qiyukf.nim.uikit.session.module.input;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import java.util.List;

public final class a extends BaseAdapter {
    private Context a;
    private List<BaseAction> b;

    public a(Context context, List<BaseAction> list) {
        this.a = context;
        this.b = list;
    }

    public final int getCount() {
        return this.b.size();
    }

    public final Object getItem(int i) {
        return this.b.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.ysf_actions_item_layout, null);
        }
        BaseAction baseAction = (BaseAction) this.b.get(i);
        ((ImageView) view.findViewById(R.id.imageView)).setBackgroundResource(baseAction.getIconResId());
        ((TextView) view.findViewById(R.id.textView)).setText(this.a.getString(baseAction.getTitleId()));
        ((TextView) view.findViewById(R.id.textView)).setTextColor(baseAction.getActionFontColor());
        return view;
    }
}
