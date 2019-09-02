package com.qiyukf.nim.uikit.session.b;

import com.qiyukf.nim.uikit.common.media.a.b;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;

public class a implements b {
    private IMMessage a;

    public a(IMMessage iMMessage) {
        this.a = iMMessage;
    }

    public final long a() {
        return ((AudioAttachment) this.a.getAttachment()).getDuration();
    }

    public final boolean a(b bVar) {
        return a.class.isInstance(bVar) ? this.a.isTheSame(((a) bVar).a) : false;
    }

    public final String b() {
        return ((AudioAttachment) this.a.getAttachment()).getPath();
    }

    public final IMMessage c() {
        return this.a;
    }
}
