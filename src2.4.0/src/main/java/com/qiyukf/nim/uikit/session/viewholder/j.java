package com.qiyukf.nim.uikit.session.viewholder;

import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.f.a.d.a;
import com.qiyukf.unicorn.f.a.d.k;
import com.qiyukf.unicorn.f.a.d.m;

public class j extends f {
    /* Access modifiers changed, original: protected|final */
    public final String a() {
        MsgAttachment attachment = this.message.getAttachment();
        return attachment instanceof a ? ((a) attachment).a(this.context).toString() : attachment instanceof m ? ((m) attachment).a() : attachment instanceof k ? ((k) attachment).d() : this.message.getContent();
    }
}
