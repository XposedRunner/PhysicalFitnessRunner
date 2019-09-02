package com.qiyukf.unicorn.ui.b.a;

import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.m;

public class q extends e {
    private TextView a;
    private ImageView b;
    private TextView c;
    private LinearLayout d;

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        m mVar = (m) this.message.getAttachment();
        this.a.setText(mVar.c());
        this.c.setText(mVar.d().b());
        this.b.setSelected(TextUtils.equals(mVar.d().a(), "success"));
        this.d.removeAllViews();
        for (String str : mVar.e()) {
            TextView textView = (TextView) LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_bot_text, this.d, false);
            textView.setTextSize(14.0f);
            textView.setTextColor(ContextCompat.getColor(this.context, R.color.ysf_grey_666666));
            textView.setText(str);
            LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = d.a(10.0f);
            this.d.addView(textView, layoutParams);
        }
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_refund;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (TextView) findViewById(R.id.ysf_tv_refund_label);
        this.b = (ImageView) findViewById(R.id.ysf_iv_refund_state_icon);
        this.c = (TextView) findViewById(R.id.ysf_tv_refund_state);
        this.d = (LinearLayout) findViewById(R.id.ysf_ll_refund_item_container);
    }
}
