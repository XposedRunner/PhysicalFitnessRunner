package com.qiyukf.nimlib.k.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.model.AttachmentProgress;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static a a;
    private Map<String, AbortableFuture<Void>> b = new HashMap();
    private Map<String, AttachmentProgress> c = new HashMap();
    private a d;
    private Observer<IMMessage> e = new Observer<IMMessage>() {
        public final /* synthetic */ void onEvent(Object obj) {
            IMMessage iMMessage = (IMMessage) obj;
            if (a.this.b.containsKey(iMMessage.getUuid()) && a.this.d != null) {
                if (iMMessage.getAttachStatus() == AttachStatusEnum.transferred && a.d(iMMessage)) {
                    a.this.d.onSuccess(iMMessage);
                    a.a(a.this, iMMessage);
                } else if (iMMessage.getAttachStatus() == AttachStatusEnum.fail) {
                    a.this.d.onFail(iMMessage);
                    a.a(a.this, iMMessage);
                }
            }
        }
    };
    private Observer<AttachmentProgress> f = new Observer<AttachmentProgress>() {
        public final /* synthetic */ void onEvent(Object obj) {
            AttachmentProgress attachmentProgress = (AttachmentProgress) obj;
            if (a.this.b.containsKey(attachmentProgress.getUuid())) {
                a.this.c.put(attachmentProgress.getUuid(), attachmentProgress);
                if (a.this.d != null) {
                    a.this.d.onProgress(attachmentProgress);
                }
            }
        }
    };

    public interface a {
        void onFail(IMMessage iMMessage);

        void onProgress(AttachmentProgress attachmentProgress);

        void onSuccess(IMMessage iMMessage);
    }

    private a() {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeMsgStatus(this.e, true);
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeAttachmentProgress(this.f, true);
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    static /* synthetic */ void a(a aVar, IMMessage iMMessage) {
        aVar.b.remove(iMMessage.getUuid());
        aVar.c.remove(iMMessage.getUuid());
    }

    public static boolean d(@NonNull IMMessage iMMessage) {
        String path = ((FileAttachment) iMMessage.getAttachment()).getPath();
        return !TextUtils.isEmpty(path) ? new File(path).exists() : false;
    }

    public static boolean e(@NonNull IMMessage iMMessage) {
        long expire = ((FileAttachment) iMMessage.getAttachment()).getExpire();
        if (expire <= 0) {
            expire = iMMessage.getTime() + 604800000;
        }
        return System.currentTimeMillis() > expire;
    }

    public final AttachmentProgress a(IMMessage iMMessage) {
        return (AttachmentProgress) this.c.get(iMMessage.getUuid());
    }

    public final void a(a aVar) {
        this.d = aVar;
    }

    public final void b(IMMessage iMMessage) {
        this.b.put(iMMessage.getUuid(), ((MsgService) NIMClient.getService(MsgService.class)).downloadAttachment(iMMessage, false));
    }

    public final void c(IMMessage iMMessage) {
        AbortableFuture abortableFuture = (AbortableFuture) this.b.remove(iMMessage.getUuid());
        this.c.remove(iMMessage.getUuid());
        if (abortableFuture != null) {
            abortableFuture.abort();
        }
    }
}
