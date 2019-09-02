package com.qiyukf.unicorn.ui.b.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.a;
import com.tencent.open.SocialConstants;

public class c extends e {
    private TextView a;
    private LinearLayout b;

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        a aVar = (a) this.message.getAttachment();
        this.a.setText(aVar.c());
        this.b.removeAllViews();
        for (final a.a aVar2 : aVar.d()) {
            TextView textView = (TextView) LayoutInflater.from(this.context).inflate(R.layout.ysf_message_item_bot_button, this.b, false);
            textView.setText(aVar2.a());
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (TextUtils.equals(SocialConstants.PARAM_URL, aVar2.b())) {
                        c.this.a(aVar2.c());
                    } else {
                        c.this.a(aVar2.c(), aVar2.d(), aVar2.a());
                    }
                }
            });
            LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = d.a(15.0f);
            this.b.addView(textView, layoutParams);
        }
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_action_list;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (TextView) findViewById(R.id.ysf_tv_action_list_label);
        this.b = (LinearLayout) findViewById(R.id.ysf_ll_action_list_action_container);
    }
}
