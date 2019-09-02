package com.qiyukf.unicorn.ui.b.a;

import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.j;

public class n extends e {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private View e;
    private TextView f;
    private LinearLayout g;

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        j jVar = (j) this.message.getAttachment();
        this.a.setText(jVar.c());
        this.b.setText(jVar.d());
        this.c.setText(jVar.e());
        this.d.setText(jVar.f());
        if (TextUtils.isEmpty(jVar.g())) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        this.f.setText(jVar.g());
        this.g.removeAllViews();
        for (String str : jVar.h()) {
            TextView textView = (TextView) LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_bot_text, this.g, false);
            textView.setTextSize(14.0f);
            textView.setTextColor(ContextCompat.getColor(this.context, R.color.ysf_grey_666666));
            textView.setText(str);
            LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = d.a(2.0f);
            this.g.addView(textView, layoutParams);
        }
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_order_detail;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (TextView) findViewById(R.id.ysf_tv_order_detail_label);
        this.b = (TextView) findViewById(R.id.ysf_tv_order_detail_status);
        this.c = (TextView) findViewById(R.id.ysf_tv_order_detail_person);
        this.d = (TextView) findViewById(R.id.ysf_tv_order_detail_address);
        this.e = findViewById(R.id.ysf_ll_order_detail_order_container);
        this.f = (TextView) findViewById(R.id.ysf_tv_order_detail_order);
        this.g = (LinearLayout) findViewById(R.id.ysf_ll_order_detail_order_item_container);
    }
}
