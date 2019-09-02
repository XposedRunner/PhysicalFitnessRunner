package com.qiyukf.unicorn.f.a;

import android.content.Context;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import org.json.JSONObject;

public abstract class d implements MsgAttachment {
    /* Access modifiers changed, original: protected */
    public void afterParse(JSONObject jSONObject) {
    }

    public boolean countToUnread() {
        return false;
    }

    public final void fromJson(JSONObject jSONObject) {
        b.a((Object) this, jSONObject);
        afterParse(jSONObject);
    }

    public String getContent(Context context) {
        return context.getString(R.string.ysf_msg_notify_custom_default);
    }
}
