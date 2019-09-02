package com.qiyukf.unicorn.ui.b.a;

import com.qiyukf.nim.uikit.session.viewholder.b;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.OnBotEventListener;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.f.a.a.b.c;

public abstract class e extends b {
    public abstract void a();

    public final void a(String str) {
        OnBotEventListener onBotEventListener = d.e().onBotEventListener;
        if (onBotEventListener != null) {
            onBotEventListener.onUrlClick(this.context, str);
        }
    }

    public void a(String str, String str2) {
    }

    public final void a(String str, String str2, String str3) {
        c cVar = new c();
        cVar.a(str3);
        com.qiyukf.unicorn.a.a.a.a.b bVar = new com.qiyukf.unicorn.a.a.a.a.b();
        if (str == null) {
            str = "";
        }
        bVar.a(str);
        if (str2 == null) {
            str2 = "";
        }
        bVar.b(str2);
        bVar.a(cVar.c());
        cVar.a(bVar);
        getAdapter().d().c(MessageBuilder.createCustomMessage(this.message.getSessionId(), SessionTypeEnum.Ysf, cVar));
    }

    /* Access modifiers changed, original: protected */
    public boolean b() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bindContentView() {
        if (b() && this.contentContainer.getChildCount() == 1) {
            this.contentContainer.getChildAt(0).setBackgroundResource(isReceivedMessage() ? R.drawable.ysf_message_left_bg_no_padding_selector : R.drawable.ysf_message_right_bg_no_padding_selector);
        }
        a();
    }

    public void c() {
    }

    /* Access modifiers changed, original: protected|final */
    public final int leftBackground() {
        return 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final int rightBackground() {
        return 0;
    }
}
