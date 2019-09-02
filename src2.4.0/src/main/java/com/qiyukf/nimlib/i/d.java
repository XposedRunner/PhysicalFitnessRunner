package com.qiyukf.nimlib.i;

import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.qiyukf.basesdk.b.a.b.a;
import com.qiyukf.basesdk.b.a.b.a.c;
import com.qiyukf.nimlib.a.c.d.e;
import com.qiyukf.nimlib.e.b;
import com.qiyukf.nimlib.e.i;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.nimlib.sdk.msg.constant.AttachStatusEnum;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.RecentContact;
import com.qiyukf.unicorn.api.RequestCallback;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.AudioAttachment;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ImageAttachment;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;

public final class d {
    public static c a(final FileAttachment fileAttachment, final i iVar) {
        a(fileAttachment);
        return a.a().a(fileAttachment.getPath(), fileAttachment.getMd5(), iVar, new com.qiyukf.basesdk.b.a.b.c<i>() {
            private void b(int i) {
                iVar.a(i);
                com.qiyukf.nimlib.e.a.c(iVar);
            }

            public final /* synthetic */ void a() {
                b(SecExceptionCode.SEC_ERROR_DYN_ENC);
            }

            public final /* synthetic */ void a(long j, long j2) {
                b.a(fileAttachment.getPath(), j, j2);
            }
        });
    }

    public static void a(final a aVar, final boolean z, final i iVar) {
        if (TextUtils.isEmpty(aVar.getSessionId())) {
            com.qiyukf.basesdk.a.a.c("core", "no message receiver");
            throw new IllegalArgumentException("Receiver cannot be null");
        }
        boolean z2;
        Object obj = null;
        if (z) {
            long b = f.b(aVar.getUuid());
            aVar.a(b);
            z2 = b > 0;
        } else {
            z2 = z;
        }
        if (z2) {
            f.b(aVar, MsgStatusEnum.fail);
        } else {
            f.a(aVar, MsgStatusEnum.fail);
        }
        RecentContact b2 = g.b(aVar);
        b.a().a(aVar.getUuid());
        b2.setMsgStatus(MsgStatusEnum.sending);
        b.a(b2);
        MsgAttachment attachment = aVar.getAttachment();
        if (attachment != null && (attachment instanceof FileAttachment)) {
            FileAttachment fileAttachment = (FileAttachment) attachment;
            if (TextUtils.isEmpty(fileAttachment.getUrl())) {
                aVar.setAttachStatus(AttachStatusEnum.transferring);
                if (TextUtils.isEmpty(fileAttachment.getExtension())) {
                    String str = fileAttachment instanceof ImageAttachment ? "jpg" : fileAttachment instanceof VideoAttachment ? "mp4" : "";
                    fileAttachment.setExtension(str);
                }
                a(fileAttachment);
                final FileAttachment fileAttachment2 = (FileAttachment) aVar.getAttachment();
                a.a().a(fileAttachment2.getPath(), fileAttachment2.getMd5(), iVar, new com.qiyukf.basesdk.b.a.b.c<i>() {
                    private void b() {
                        aVar.setStatus(MsgStatusEnum.fail);
                        aVar.setAttachStatus(AttachStatusEnum.fail);
                        b.a(aVar);
                        b.a().b(aVar.getUuid());
                    }

                    public final /* synthetic */ void a() {
                        b();
                    }

                    public final /* synthetic */ void a(long j, long j2) {
                        b.a(aVar.getUuid(), j, j2);
                    }
                });
            } else if (fileAttachment instanceof AudioAttachment) {
                AudioAttachment audioAttachment = (AudioAttachment) fileAttachment;
                if (audioAttachment.getAutoTransform()) {
                    aVar.setAttachStatus(AttachStatusEnum.transferring);
                    b(audioAttachment, aVar, iVar);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            c(aVar, z, iVar);
        }
    }

    private static void a(FileAttachment fileAttachment) {
        if (TextUtils.isEmpty(fileAttachment.getMd5())) {
            fileAttachment.setMd5(com.qiyukf.basesdk.c.c.c.b(fileAttachment.getPath()));
        }
    }

    private static void b(final AudioAttachment audioAttachment, final a aVar, final i iVar) {
        ((MsgService) NIMClient.getService(MsgService.class)).transVoiceToText(audioAttachment.getUrl(), audioAttachment.getPath(), audioAttachment.getDuration()).setCallback(new RequestCallback() {
            public final void onException(Throwable th) {
                d.a(aVar);
            }

            public final void onFailed(int i) {
                d.a(aVar);
            }

            public final void onSuccess(Object obj) {
                audioAttachment.setText(obj.toString());
                aVar.setAttachment(audioAttachment);
                ((MsgService) NIMClient.getService(MsgService.class)).updateMessage(aVar, true);
                a aVar = new a();
                aVar.a(aVar.getUuid());
                aVar.b(aVar.getSessionId());
                aVar.setFromAccount(com.qiyukf.nimlib.b.b());
                aVar.setDirect(MsgDirectionEnum.Out);
                aVar.setStatus(MsgStatusEnum.sending);
                aVar.a(aVar.getSessionType());
                aVar.setTime(aVar.getTime());
                aVar.a(aVar.a());
                aVar.a(MsgTypeEnum.text.getValue());
                aVar.setContent(obj.toString());
                d.c(aVar, false, iVar);
            }
        });
    }

    private static void c(a aVar, boolean z, i iVar) {
        e eVar;
        int i;
        if (aVar.getSessionType() == SessionTypeEnum.P2P) {
            eVar = new e();
        } else if (aVar.getSessionType() == SessionTypeEnum.Ysf) {
            eVar = new com.qiyukf.nimlib.a.c.e.b();
        } else {
            throw new IllegalArgumentException("support Ysf message only");
        }
        com.qiyukf.nimlib.h.c.b.b bVar = new com.qiyukf.nimlib.h.c.b.b();
        switch (aVar.getSessionType()) {
            case Team:
                i = 1;
                break;
            case P2P:
            case Ysf:
                break;
            default:
                com.qiyukf.basesdk.a.a.a("SYSMSG", "unknown session type to system msg type");
                break;
        }
        i = 0;
        bVar.a(0, i);
        bVar.a(1, aVar.getSessionId());
        bVar.a(9, aVar.getContent());
        bVar.a(8, aVar.getMsgType().getValue());
        bVar.a(11, aVar.getUuid());
        String a = aVar.a(true);
        if (!TextUtils.isEmpty(a)) {
            bVar.a(10, a);
        }
        if (z) {
            bVar.a(13, 1);
        }
        if (aVar.getSessionId().equals(com.qiyukf.nimlib.b.b())) {
            bVar.a(5, com.qiyukf.nimlib.h.e.a());
        }
        if (aVar.d() != null) {
            if (!aVar.d().enableHistory) {
                bVar.a(100, 0);
            }
            if (!aVar.d().enableRoaming) {
                bVar.a(101, 0);
            }
            if (!aVar.d().enableSelfSync) {
                bVar.a(102, 0);
            }
        }
        eVar.a(iVar);
        eVar.a(bVar);
        com.qiyukf.nimlib.a.c.a().a(new com.qiyukf.nimlib.a.c.d.d(eVar, com.qiyukf.nimlib.a.f.a.b));
    }
}
