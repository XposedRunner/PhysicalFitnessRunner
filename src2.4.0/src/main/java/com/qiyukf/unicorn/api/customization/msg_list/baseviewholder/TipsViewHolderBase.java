package com.qiyukf.unicorn.api.customization.msg_list.baseviewholder;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.qiyukf.nim.uikit.session.emoji.e;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.f.a.d.a;
import com.qiyukf.unicorn.f.a.d.k;
import com.qiyukf.unicorn.f.a.d.m;

public abstract class TipsViewHolderBase extends UnicornMessageViewHolder {
    private String getDisplayText() {
        MsgAttachment attachment = this.message.getAttachment();
        return attachment instanceof a ? ((a) attachment).a(this.context).toString() : attachment instanceof m ? ((m) attachment).a() : attachment instanceof k ? ((k) attachment).d() : this.message.getContent();
    }

    private void handleTextNotification(String str) {
        e.a(this.context, getMainTextView(), str, this.message.getSessionId());
        getMainTextView().setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void bindContentView(IMMessage iMMessage, Context context) {
        handleTextNotification(getDisplayText());
    }

    public abstract TextView getMainTextView();

    /* Access modifiers changed, original: protected */
    public boolean isMiddleItem() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean showAvatar() {
        return false;
    }
}
