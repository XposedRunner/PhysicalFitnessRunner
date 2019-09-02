package com.qiyukf.nim.uikit.session.viewholder;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.helper.a;
import com.qiyukf.nim.uikit.session.helper.b;
import com.qiyukf.nim.uikit.session.helper.e;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.h.c;

public class h extends b {
    protected OnClickListener a = new OnClickListener() {
        public final void onClick(View view) {
            b.a(h.this.context, h.this.f, "");
        }
    };
    private TextView b;
    private TextView c;
    private LinearLayout d;
    private TextView e;
    private String f;

    /* Access modifiers changed, original: protected */
    public void a(TextView textView) {
        textView.setText(e.a(this.context, c.a(this.message) == 2 ? com.qiyukf.nim.uikit.session.emoji.e.a(this.context, this.message.getContent(), this.message.getSessionId()) : com.qiyukf.nim.uikit.session.emoji.e.a(this.context, this.message.getContent())));
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0110  */
    public void bindContentView() {
        /*
        r4 = this;
        r0 = r4.isReceivedMessage();
        if (r0 == 0) goto L_0x0033;
    L_0x0006:
        r0 = r4.d;
        r1 = com.qiyukf.unicorn.d.e();
        r1 = r1.uiCustomization;
        if (r1 == 0) goto L_0x0017;
    L_0x0010:
        r2 = r1.msgItemBackgroundLeft;
        if (r2 <= 0) goto L_0x0017;
    L_0x0014:
        r1 = r1.msgItemBackgroundLeft;
        goto L_0x0019;
    L_0x0017:
        r1 = com.qiyukf.unicorn.R.drawable.ysf_message_left_bg_selector;
    L_0x0019:
        r0.setBackgroundResource(r1);
        r0 = r4.b;
        r1 = com.qiyukf.unicorn.d.e();
        r1 = r1.uiCustomization;
        if (r1 == 0) goto L_0x002d;
    L_0x0026:
        r2 = r1.textMsgColorLeft;
        if (r2 == 0) goto L_0x002d;
    L_0x002a:
        r1 = r1.textMsgColorLeft;
        goto L_0x002f;
    L_0x002d:
        r1 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
    L_0x002f:
        r0.setTextColor(r1);
        goto L_0x005c;
    L_0x0033:
        r0 = r4.d;
        r1 = com.qiyukf.unicorn.d.e();
        r1 = r1.uiCustomization;
        if (r1 == 0) goto L_0x0044;
    L_0x003d:
        r2 = r1.msgItemBackgroundRight;
        if (r2 <= 0) goto L_0x0044;
    L_0x0041:
        r1 = r1.msgItemBackgroundRight;
        goto L_0x0046;
    L_0x0044:
        r1 = com.qiyukf.unicorn.R.drawable.ysf_message_right_bg_selector;
    L_0x0046:
        r0.setBackgroundResource(r1);
        r0 = r4.b;
        r1 = com.qiyukf.unicorn.d.e();
        r1 = r1.uiCustomization;
        if (r1 == 0) goto L_0x005a;
    L_0x0053:
        r2 = r1.textMsgColorRight;
        if (r2 == 0) goto L_0x005a;
    L_0x0057:
        r1 = r1.textMsgColorRight;
        goto L_0x002f;
    L_0x005a:
        r1 = -1;
        goto L_0x002f;
    L_0x005c:
        r0 = r4.b;
        r1 = r4.b;
        r2 = com.qiyukf.unicorn.d.e();
        r2 = r2.uiCustomization;
        if (r2 == 0) goto L_0x0082;
    L_0x0068:
        r3 = r4.isReceivedMessage();
        if (r3 == 0) goto L_0x0075;
    L_0x006e:
        r3 = r2.hyperLinkColorLeft;
        if (r3 == 0) goto L_0x0075;
    L_0x0072:
        r1 = r2.hyperLinkColorLeft;
        goto L_0x0098;
    L_0x0075:
        r3 = r4.isReceivedMessage();
        if (r3 != 0) goto L_0x0082;
    L_0x007b:
        r3 = r2.hyperLinkColorRight;
        if (r3 == 0) goto L_0x0082;
    L_0x007f:
        r1 = r2.hyperLinkColorRight;
        goto L_0x0098;
    L_0x0082:
        r2 = r1.getCurrentTextColor();
        r3 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        r3 = r3 & r2;
        if (r3 == 0) goto L_0x008e;
    L_0x008c:
        r1 = r2;
        goto L_0x0098;
    L_0x008e:
        r1 = r1.getResources();
        r2 = com.qiyukf.unicorn.R.color.ysf_text_link_color_blue;
        r1 = r1.getColor(r2);
    L_0x0098:
        r0.setLinkTextColor(r1);
        r0 = r4.b;
        r4.a(r0);
        r0 = r4.message;
        r0 = r0.getExtension();
        r1 = "action";
        r0 = com.qiyukf.basesdk.c.b.f(r0, r1);
        if (r0 == 0) goto L_0x0110;
    L_0x00ae:
        r1 = r4.c;
        r2 = 0;
        r1.setVisibility(r2);
        r1 = r4.e;
        r1.setVisibility(r2);
        r1 = com.qiyukf.unicorn.d.e();
        r1 = r1.uiCustomization;
        if (r1 == 0) goto L_0x00cd;
    L_0x00c1:
        r2 = r1.msgItemBackgroundLeft;
        if (r2 <= 0) goto L_0x00cd;
    L_0x00c5:
        r2 = r4.d;
        r1 = r1.msgItemBackgroundLeft;
        r2.setBackgroundResource(r1);
        goto L_0x00db;
    L_0x00cd:
        r1 = r4.b;
        r2 = 35;
        r1.setPadding(r2, r2, r2, r2);
        r1 = r4.d;
        r2 = com.qiyukf.unicorn.R.drawable.ysf_message_left_bg_selector;
        r1.setBackgroundResource(r2);
    L_0x00db:
        r1 = "label";
        r1 = com.qiyukf.basesdk.c.b.e(r0, r1);
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00f3;
    L_0x00e7:
        r1 = r4.c;
        r2 = "label";
        r2 = com.qiyukf.basesdk.c.b.e(r0, r2);
    L_0x00ef:
        r1.setText(r2);
        goto L_0x00f8;
    L_0x00f3:
        r1 = r4.c;
        r2 = "知道了";
        goto L_0x00ef;
    L_0x00f8:
        r1 = "url";
        r0 = com.qiyukf.basesdk.c.b.e(r0, r1);
        r4.f = r0;
        r0 = r4.f;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x010f;
    L_0x0108:
        r0 = r4.c;
        r1 = r4.a;
        r0.setOnClickListener(r1);
    L_0x010f:
        return;
    L_0x0110:
        r0 = r4.c;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r4.e;
        r0.setVisibility(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.session.viewholder.h.bindContentView():void");
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_text;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.b = (TextView) findViewById(R.id.nim_message_item_text_body);
        this.c = (TextView) findViewById(R.id.tv_nim_message_item_url_button);
        this.d = (LinearLayout) findViewById(R.id.ll_nim_message_item_text_parent);
        this.e = (TextView) findViewById(R.id.tv_nim_message_item_url_line);
        this.b.setOnTouchListener(a.a());
        UICustomization uICustomization = d.e().uiCustomization;
        if (uICustomization != null && uICustomization.textMsgSize > 0.0f) {
            ((TextView) findViewById(R.id.nim_message_item_text_body)).setTextSize(uICustomization.textMsgSize);
        }
    }

    /* Access modifiers changed, original: protected */
    public int leftBackground() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public int rightBackground() {
        return 0;
    }
}
