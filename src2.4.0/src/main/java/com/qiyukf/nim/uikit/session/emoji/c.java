package com.qiyukf.nim.uikit.session.emoji;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.qiyukf.unicorn.R;

public final class c {
    public OnItemClickListener a = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int currentItem = (c.this.b.getCurrentItem() * 27) + i;
            if (c.this.f != null) {
                int a = b.a();
                if (i == 27 || currentItem >= a) {
                    c.this.f.a("/DEL");
                } else {
                    String a2 = b.a((int) j);
                    if (!TextUtils.isEmpty(a2)) {
                        c.this.f.a(a2);
                    }
                }
            }
        }
    };
    private ViewPager b;
    private LinearLayout c;
    private int d;
    private Context e;
    private d f;
    private a g = new a(this, (byte) 0);

    private class a extends PagerAdapter {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final int getCount() {
            return c.this.d == 0 ? 1 : c.this.d;
        }

        public final int getItemPosition(Object obj) {
            return -2;
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            c.this.c.setVisibility(0);
            GridView gridView = new GridView(c.this.e);
            gridView.setOnItemClickListener(c.this.a);
            gridView.setAdapter(new a(c.this.e, i * 27));
            gridView.setNumColumns(7);
            gridView.setGravity(17);
            gridView.setSelector(R.drawable.ysf_emoji_item_selector);
            viewGroup.addView(gridView);
            return gridView;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public c(Context context, d dVar, ViewPager viewPager, LinearLayout linearLayout) {
        this.e = context.getApplicationContext();
        this.f = dVar;
        this.c = linearLayout;
        this.b = viewPager;
        this.b.setOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageScrollStateChanged(int i) {
            }

            public final void onPageScrolled(int i, float f, int i2) {
            }

            public final void onPageSelected(int i) {
                c.this.a(i);
            }
        });
        this.b.setAdapter(this.g);
        this.b.setOffscreenPageLimit(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0055  */
    private void a(int r10) {
        /*
        r9 = this;
        r0 = r9.d;
        r1 = r9.c;
        r1 = r1.getChildCount();
        r2 = java.lang.Math.max(r1, r0);
        r3 = 0;
        r4 = r3;
    L_0x000e:
        if (r4 >= r2) goto L_0x0061;
    L_0x0010:
        if (r0 > r1) goto L_0x0029;
    L_0x0012:
        if (r4 < r0) goto L_0x0020;
    L_0x0014:
        r5 = r9.c;
        r5 = r5.getChildAt(r4);
        r6 = 8;
        r5.setVisibility(r6);
        goto L_0x005e;
    L_0x0020:
        r5 = r9.c;
        r5 = r5.getChildAt(r4);
        r5 = (android.widget.ImageView) r5;
        goto L_0x0050;
    L_0x0029:
        if (r4 >= r1) goto L_0x002c;
    L_0x002b:
        goto L_0x0020;
    L_0x002c:
        r5 = new android.widget.ImageView;
        r6 = r9.e;
        r5.<init>(r6);
        r6 = com.qiyukf.unicorn.R.drawable.ysf_view_pager_indicator_selector;
        r5.setBackgroundResource(r6);
        r6 = new android.widget.LinearLayout$LayoutParams;
        r7 = -2;
        r6.<init>(r7, r7);
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = com.qiyukf.basesdk.c.d.d.a(r7);
        r7 = com.qiyukf.basesdk.c.d.d.a(r7);
        r6.setMargins(r8, r3, r7, r3);
        r7 = r9.c;
        r7.addView(r5, r6);
    L_0x0050:
        r5.setId(r4);
        if (r4 != r10) goto L_0x0057;
    L_0x0055:
        r6 = 1;
        goto L_0x0058;
    L_0x0057:
        r6 = r3;
    L_0x0058:
        r5.setSelected(r6);
        r5.setVisibility(r3);
    L_0x005e:
        r4 = r4 + 1;
        goto L_0x000e;
    L_0x0061:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.emoji.c.a(int):void");
    }

    public final void a() {
        this.d = (int) Math.ceil((double) (((float) b.a()) / 27.0f));
        this.g.notifyDataSetChanged();
        a(0);
        this.b.setCurrentItem(0, false);
    }

    public final void b() {
        this.g.notifyDataSetChanged();
    }
}
