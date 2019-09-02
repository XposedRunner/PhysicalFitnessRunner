package com.qiyukf.nimlib.a.b.d;

import android.text.TextUtils;
import com.qiyukf.nimlib.a.b.g;
import com.qiyukf.nimlib.a.d.a;
import com.qiyukf.nimlib.e.i;
import com.qiyukf.nimlib.h.c.b.b;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.d;
import com.qiyukf.unicorn.j.f;
import java.util.Locale;

public final class c extends g {
    public final void a(a aVar) {
        long c;
        b f = ((com.qiyukf.nimlib.a.d.d.c) aVar).f();
        if (aVar.b()) {
            c = f.c(7);
            f.c(12);
        } else {
            c = 0;
        }
        IMMessage iMMessage = null;
        com.qiyukf.nimlib.a.c.a a = com.qiyukf.nimlib.a.c.a().a(aVar);
        if (!(a == null || a.e() == null || !(a.e() instanceof i))) {
            i iVar = (i) a.e();
            com.qiyukf.nimlib.i.a aVar2 = (com.qiyukf.nimlib.i.a) iVar.b()[0];
            iVar.a(aVar.e());
            com.qiyukf.nimlib.e.a.c(iVar);
            iMMessage = aVar2;
        }
        MsgStatusEnum msgStatusEnum = aVar.b() ? MsgStatusEnum.success : MsgStatusEnum.fail;
        if (iMMessage != null && d.g().l(iMMessage.getSessionId()) != null && "1".equals(d.g().l(iMMessage.getSessionId()).a()) && iMMessage.getSessionId() != null && d.g().e(iMMessage.getSessionId()) == 0 && ((iMMessage.getMsgType() == MsgTypeEnum.text || iMMessage.getMsgType() == MsgTypeEnum.image || iMMessage.getMsgType() == MsgTypeEnum.file || iMMessage.getMsgType() == MsgTypeEnum.video || (iMMessage.getAttachment() instanceof ProductAttachment)) && TextUtils.isEmpty(f.a(iMMessage)))) {
            msgStatusEnum = aVar.b() ? MsgStatusEnum.unread : MsgStatusEnum.fail;
        }
        int value = msgStatusEnum.getValue();
        if (iMMessage != null) {
            if (msgStatusEnum != MsgStatusEnum.fail) {
                StringBuilder stringBuilder;
                long a2 = iMMessage.a();
                if (c > 0) {
                    stringBuilder = new StringBuilder("UPDATE msghistory set status='");
                    stringBuilder.append(value);
                    stringBuilder.append("', time='");
                    stringBuilder.append(c);
                    stringBuilder.append("', time='");
                    stringBuilder.append(c);
                } else {
                    stringBuilder = new StringBuilder("UPDATE msghistory set status='");
                    stringBuilder.append(value);
                }
                stringBuilder.append("' where messageid='");
                stringBuilder.append(a2);
                stringBuilder.append("'");
                com.qiyukf.nimlib.c.c.a().d().a(stringBuilder.toString());
                String uuid = iMMessage.getUuid();
                com.qiyukf.nimlib.c.c.a().d().a(c <= 0 ? String.format(Locale.getDefault(), "UPDATE lstmsg set msgstatus='%d' where messageId='%s'", new Object[]{Integer.valueOf(value), uuid}) : String.format(Locale.getDefault(), "UPDATE lstmsg set msgstatus='%d',time='%d' where messageId='%s'", new Object[]{Integer.valueOf(value), Long.valueOf(c), uuid}));
            }
            iMMessage.setStatus(msgStatusEnum);
            com.qiyukf.nimlib.e.b.a(iMMessage);
            com.qiyukf.nimlib.i.b.a().b(iMMessage.getUuid());
        }
    }
}
