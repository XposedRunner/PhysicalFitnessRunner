package com.qiyukf.unicorn.api.customization.msg_list.baseviewholder;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.qiyukf.basesdk.c.b;
import com.qiyukf.nim.uikit.session.helper.e;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.h.c;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

public abstract class TextViewHolderBase extends UnicornMessageViewHolder {
    public final void bindContentView(IMMessage iMMessage, Context context) {
        String e;
        SpannableStringBuilder a = e.a(context, c.a(iMMessage) == 2 ? com.qiyukf.nim.uikit.session.emoji.e.a(context, iMMessage.getContent(), iMMessage.getSessionId()) : com.qiyukf.nim.uikit.session.emoji.e.a(context, iMMessage.getContent()));
        JSONObject f = b.f(iMMessage.getExtension(), "action");
        String str = null;
        if (f != null) {
            str = !TextUtils.isEmpty(b.e(f, "label")) ? b.e(f, "label") : "知道了";
            e = b.e(f, SocialConstants.PARAM_URL);
        } else {
            e = null;
        }
        bindTextMsgView(context, a, str, e);
    }

    public abstract void bindTextMsgView(Context context, CharSequence charSequence, String str, String str2);
}
