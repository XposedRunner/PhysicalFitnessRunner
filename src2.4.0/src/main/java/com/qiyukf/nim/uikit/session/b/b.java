package com.qiyukf.nim.uikit.session.b;

import android.content.Context;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nim.uikit.common.a.d;
import com.qiyukf.nim.uikit.common.media.a.a;
import com.qiyukf.nimlib.k.c.c;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;

public class b extends a<IMMessage> {
    private static b j;
    private boolean k = false;
    private d l = null;
    private IMMessage m = null;

    private b(Context context) {
        super(context);
    }

    private void a(IMMessage iMMessage, int i, boolean z, long j) {
        if (c.a()) {
            if (a(new a(iMMessage), i, z, j) && a(iMMessage)) {
                iMMessage.setStatus(MsgStatusEnum.read);
                ((MsgService) NIMClient.getService(MsgService.class)).updateIMMessageStatus(iMMessage, false);
                return;
            }
        }
        g.b(R.string.ysf_audio_record_sdcard_not_exist_error);
    }

    private static boolean a(IMMessage iMMessage) {
        return iMMessage.getMsgType() == MsgTypeEnum.audio && iMMessage.getDirect() == MsgDirectionEnum.In && iMMessage.getAttachStatus() == AttachStatusEnum.transferred && iMMessage.getStatus() != MsgStatusEnum.read;
    }

    public static b i() {
        if (j == null) {
            synchronized (b.class) {
                if (j == null) {
                    j = new b(com.qiyukf.nim.uikit.b.a());
                }
            }
        }
        return j;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(com.qiyukf.nim.uikit.common.media.a.b bVar) {
        this.d.setOnPlayListener(new com.qiyukf.nim.uikit.common.media.a.a.b(this.d, bVar) {
            public final void onCompletion() {
                if (a()) {
                    b.this.c();
                    boolean z = false;
                    if (!(!b.this.k || b.this.l == null || b.this.m == null)) {
                        z = b.a(b.this, b.this.l, b.this.m);
                    }
                    if (!z) {
                        b.this.b(b.this.e);
                        b.this.a();
                    }
                }
            }

            public final void onError(String str) {
                if (a()) {
                    super.onError(str);
                    b.this.a(false, null, null);
                }
            }

            public final void onInterrupt() {
                if (a()) {
                    super.onInterrupt();
                    b.this.a(false, null, null);
                }
            }
        });
    }

    public final void a(IMMessage iMMessage, int i) {
        a(iMMessage, i, true, 500);
    }

    public final void a(boolean z, d dVar, IMMessage iMMessage) {
        this.k = z;
        this.l = dVar;
        this.m = iMMessage;
    }

    public final void e() {
        super.e();
        a(false, null, null);
    }

    public final IMMessage j() {
        return (d() && a.class.isInstance(this.e)) ? ((a) this.e).c() : null;
    }
}
