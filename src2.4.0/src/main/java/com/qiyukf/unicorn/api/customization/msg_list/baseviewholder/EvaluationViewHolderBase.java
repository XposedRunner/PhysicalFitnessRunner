package com.qiyukf.unicorn.api.customization.msg_list.baseviewholder;

import android.content.Context;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.b;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.f.a.e.c;

public abstract class EvaluationViewHolderBase extends UnicornMessageViewHolder {
    public final void bindContentView(IMMessage iMMessage, Context context) {
        c cVar = (c) iMMessage.getAttachment();
        bindEvaluationMsgView(context, cVar.a(), cVar.a(context));
    }

    public abstract void bindEvaluationMsgView(Context context, boolean z, CharSequence charSequence);

    public final void evaluationBtnClinck() {
        if (b.a().b() != null) {
            b.a();
        } else {
            d.g().c().a(this.context, this.message);
        }
    }
}
