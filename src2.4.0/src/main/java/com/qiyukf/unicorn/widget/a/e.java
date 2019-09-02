package com.qiyukf.unicorn.widget.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;

final class e extends b<e> {
    private LinearLayout d;
    private View e;

    public e(Context context) {
        super(context);
        this.d = new LinearLayout(context);
        this.d.setOrientation(1);
        this.d.setGravity(1);
        this.b.a.removeAllViews();
        this.b.a.addView(this.d, -1, -2);
    }

    private boolean b() {
        return this.b.b.getVisibility() == 0 || this.b.c.getVisibility() == 0;
    }

    public final e a(CharSequence[] charSequenceArr) {
        this.d.removeAllViews();
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        LayoutParams layoutParams2 = new LayoutParams(-1, d.a(0.5f));
        for (int i = 0; i < charSequenceArr.length; i++) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.ysf_include_divider, this.d, false);
            this.d.addView(inflate, layoutParams2);
            TextView textView = (TextView) LayoutInflater.from(this.a).inflate(R.layout.ysf_dialog_content_item_list_item, this.d, false);
            textView.setText(charSequenceArr[i]);
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    e.this.b.cancel();
                    if (e.this.c != null) {
                        e.this.c.a(i);
                    }
                }
            });
            this.d.addView(textView, layoutParams);
            if (i == 0) {
                this.e = inflate;
            }
        }
        return this;
    }

    /* JADX WARNING: Missing block: B:24:0x0064, code skipped:
            if (r2 == (r0.size() - 1)) goto L_0x0066;
     */
    public final void a() {
        /*
        r5 = this;
        r0 = r5.e;
        r1 = r5.b();
        r2 = 0;
        if (r1 == 0) goto L_0x000b;
    L_0x0009:
        r1 = r2;
        goto L_0x000d;
    L_0x000b:
        r1 = 8;
    L_0x000d:
        r0.setVisibility(r1);
        r0 = new java.util.ArrayList;
        r1 = r5.d;
        r1 = r1.getChildCount();
        r0.<init>(r1);
        r1 = r2;
    L_0x001c:
        r3 = r5.d;
        r3 = r3.getChildCount();
        if (r1 >= r3) goto L_0x0036;
    L_0x0024:
        r3 = r5.d;
        r3 = r3.getChildAt(r1);
        r4 = r3 instanceof android.widget.TextView;
        if (r4 == 0) goto L_0x0033;
    L_0x002e:
        r3 = (android.widget.TextView) r3;
        r0.add(r3);
    L_0x0033:
        r1 = r1 + 1;
        goto L_0x001c;
    L_0x0036:
        r1 = r0.size();
        if (r2 >= r1) goto L_0x0072;
    L_0x003c:
        r1 = r0.get(r2);
        r1 = (android.widget.TextView) r1;
        r3 = 1;
        if (r2 != 0) goto L_0x005f;
    L_0x0045:
        r4 = r0.size();
        if (r4 != r3) goto L_0x0055;
    L_0x004b:
        r3 = r5.b();
        if (r3 == 0) goto L_0x0052;
    L_0x0051:
        goto L_0x0066;
    L_0x0052:
        r3 = com.qiyukf.unicorn.R.drawable.ysf_dialog_item_single_selector;
        goto L_0x0068;
    L_0x0055:
        r3 = r5.b();
        if (r3 == 0) goto L_0x005c;
    L_0x005b:
        goto L_0x006c;
    L_0x005c:
        r3 = com.qiyukf.unicorn.R.drawable.ysf_dialog_item_top_selector;
        goto L_0x0068;
    L_0x005f:
        r4 = r0.size();
        r4 = r4 - r3;
        if (r2 != r4) goto L_0x006c;
    L_0x0066:
        r3 = com.qiyukf.unicorn.R.drawable.ysf_dialog_item_bottom_selector;
    L_0x0068:
        r1.setBackgroundResource(r3);
        goto L_0x006f;
    L_0x006c:
        r3 = com.qiyukf.unicorn.R.drawable.ysf_dialog_item_middle_selector;
        goto L_0x0068;
    L_0x006f:
        r2 = r2 + 1;
        goto L_0x0036;
    L_0x0072:
        super.a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.widget.a.e.a():void");
    }
}
