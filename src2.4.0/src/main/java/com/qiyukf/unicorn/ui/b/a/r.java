package com.qiyukf.unicorn.ui.b.a;

import android.widget.TextView;
import com.qiyukf.nim.uikit.session.helper.e;
import com.qiyukf.nim.uikit.session.viewholder.h;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.f.a.a.a.n;
import com.qiyukf.unicorn.f.a.a.b.b;
import com.qiyukf.unicorn.f.a.a.b.c;

public class r extends h {
    /* Access modifiers changed, original: protected|final */
    public final void a(TextView textView) {
        String str = "";
        MsgAttachment attachment = this.message.getAttachment();
        if (attachment instanceof n) {
            str = ((n) attachment).c();
        } else if (attachment instanceof c) {
            str = ((c) attachment).d();
        } else if (attachment instanceof b) {
            str = ((b) attachment).c();
        }
        textView.setText(e.a(this.context, com.qiyukf.nim.uikit.session.emoji.e.a(this.context, str, this.message.getSessionId())));
    }
}
