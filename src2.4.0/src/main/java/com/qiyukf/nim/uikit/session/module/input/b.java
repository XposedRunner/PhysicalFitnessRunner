package com.qiyukf.nim.uikit.session.module.input;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import java.util.ArrayList;
import java.util.List;

public final class b extends PagerAdapter {
    private final int a = 8;
    private final Context b;
    private final List<BaseAction> c;
    private final ViewPager d;
    private final int e;

    public b(ViewPager viewPager, List<BaseAction> list) {
        this.b = viewPager.getContext();
        this.c = new ArrayList(list);
        this.d = viewPager;
        this.e = ((list.size() + 8) - 1) / 8;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    public final int getCount() {
        return this.e;
    }

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        Runnable anonymousClass1;
        int i2 = (i + 1) << 3;
        if (i2 > this.c.size()) {
            i2 = this.c.size();
        }
        List subList = this.c.subList(i << 3, i2);
        GridView gridView = new GridView(this.b);
        gridView.setAdapter(new a(this.b, subList));
        if (this.c.size() > 4) {
            gridView.setNumColumns(4);
            anonymousClass1 = new Runnable() {
                public final void run() {
                    LayoutParams layoutParams = b.this.d.getLayoutParams();
                    layoutParams.height = b.this.b.getResources().getDimensionPixelOffset(R.dimen.ysf_message_action_list_height_modify);
                    b.this.d.setLayoutParams(layoutParams);
                }
            };
        } else {
            gridView.setNumColumns(4);
            anonymousClass1 = new Runnable() {
                public final void run() {
                    LayoutParams layoutParams = b.this.d.getLayoutParams();
                    layoutParams.height = b.this.b.getResources().getDimensionPixelOffset(R.dimen.ysf_message_action_list_height) / 2;
                    b.this.d.setLayoutParams(layoutParams);
                }
            };
        }
        viewGroup.post(anonymousClass1);
        gridView.setSelector(17170445);
        gridView.setHorizontalSpacing(0);
        gridView.setVerticalSpacing(0);
        gridView.setGravity(17);
        gridView.setTag(Integer.valueOf(i));
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ((BaseAction) b.this.c.get((((Integer) adapterView.getTag()).intValue() << 3) + i)).onClick();
            }
        });
        viewGroup.addView(gridView);
        return gridView;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
