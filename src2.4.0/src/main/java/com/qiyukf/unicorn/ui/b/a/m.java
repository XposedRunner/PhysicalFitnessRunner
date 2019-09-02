package com.qiyukf.unicorn.ui.b.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.h;
import com.qiyukf.unicorn.f.a.a.a.h.a;
import com.qiyukf.unicorn.f.a.a.b.b;

public class m extends e {
    private TextView a;
    private LinearLayout b;

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        h hVar = (h) this.message.getAttachment();
        this.a.setText(hVar.c());
        this.b.removeAllViews();
        for (final a aVar : hVar.d()) {
            TextView textView = (TextView) LayoutInflater.from(this.context).inflate(R.layout.ysf_message_tv_mix_reply, this.b, false);
            textView.setText(aVar.a());
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    b bVar = new b();
                    bVar.a(aVar.a());
                    bVar.b(aVar.b());
                    com.qiyukf.unicorn.a.a.a.a.b bVar2 = new com.qiyukf.unicorn.a.a.a.a.b();
                    bVar2.a(aVar.c() == null ? "" : aVar.c());
                    bVar2.b(aVar.d() == null ? "" : aVar.d());
                    bVar2.c(aVar.a());
                    bVar2.d(aVar.b());
                    bVar2.a(bVar.d());
                    bVar.a(bVar2);
                    m.this.getAdapter().d().c(MessageBuilder.createCustomMessage(m.this.message.getSessionId(), SessionTypeEnum.Ysf, bVar));
                }
            });
            LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = d.a(0.0f);
            this.b.addView(textView, layoutParams);
        }
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_mix_reply;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (TextView) findViewById(R.id.ysf_tv_mix_reply_label);
        this.b = (LinearLayout) findViewById(R.id.ysf_ll_mix_reply_question_container);
    }
}
