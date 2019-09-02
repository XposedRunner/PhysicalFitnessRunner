package com.qiyukf.unicorn.ui.b.a;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.l;
import com.qiyukf.unicorn.f.a.a.a.l.a;

public class p extends e {
    private TextView a;
    private LinearLayout b;

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        l lVar = (l) this.message.getAttachment();
        this.a.setText(lVar.c());
        this.b.removeAllViews();
        TextView textView = (TextView) LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_bot_text, this.b, false);
        textView.setTextSize(14.0f);
        textView.setTextColor(ContextCompat.getColor(this.context, R.color.ysf_grey_666666));
        textView.setText(lVar.d());
        this.b.addView(textView);
        for (final a aVar : lVar.e()) {
            TextView textView2 = (TextView) LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_bot_button, this.b, false);
            textView2.setText(aVar.c());
            textView2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    p.this.a(aVar.a(), aVar.b(), aVar.c());
                }
            });
            LayoutParams layoutParams = (LayoutParams) textView2.getLayoutParams();
            layoutParams.topMargin = d.a(10.0f);
            this.b.addView(textView2, layoutParams);
        }
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_order_status;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (TextView) findViewById(R.id.ysf_tv_order_status_label);
        this.b = (LinearLayout) findViewById(R.id.ysf_order_status_action_container);
    }
}
