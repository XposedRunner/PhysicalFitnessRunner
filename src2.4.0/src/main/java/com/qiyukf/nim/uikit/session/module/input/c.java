package com.qiyukf.nim.uikit.session.module.input;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.customization.action.BaseAction;
import java.util.List;

public final class c {
    public static void a(View view, List<BaseAction> list) {
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        final ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.actions_page_indicator);
        b bVar = new b(viewPager, list);
        viewPager.setAdapter(bVar);
        final int count = bVar.getCount();
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageScrollStateChanged(int i) {
            }

            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                c.b(viewGroup, count, i);
            }
        });
        b(viewGroup, count, 0);
    }

    private static void b(ViewGroup viewGroup, int i, int i2) {
        if (i <= 1) {
            viewGroup.removeAllViews();
            return;
        }
        viewGroup.removeAllViews();
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        int i3 = 0;
        layoutParams.setMargins(d.a(2.0f), 0, d.a(2.0f), 0);
        while (i3 < i) {
            ImageView imageView = new ImageView(viewGroup.getContext());
            imageView.setId(i3);
            imageView.setBackgroundResource(i3 == i2 ? R.drawable.ysf_moon_page_selected : R.drawable.ysf_moon_page_unselected);
            viewGroup.addView(imageView, layoutParams);
            i3++;
        }
    }
}
