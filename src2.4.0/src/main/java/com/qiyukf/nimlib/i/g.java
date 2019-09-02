package com.qiyukf.nimlib.i;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.basesdk.a.a;
import com.qiyukf.nimlib.b;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.MsgStatusEnum;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.api.msg.attachment.MsgAttachment;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;

public final class g {
    public static int a(SessionTypeEnum sessionTypeEnum) {
        switch (sessionTypeEnum) {
            case Team:
                return 101;
            case P2P:
                return 100;
            case Ysf:
                return 102;
            default:
                a.a("SYSMSG", "unknown session type to system msg type");
                return 100;
        }
    }

    public static h a(a aVar) {
        return a(aVar, aVar.getStatus(), 0);
    }

    public static h a(a aVar, int i) {
        return a(aVar, aVar.getStatus(), i);
    }

    private static h a(a aVar, MsgStatusEnum msgStatusEnum, int i) {
        String sessionId = aVar.getSessionId();
        if (TextUtils.isEmpty(sessionId)) {
            return null;
        }
        h hVar = new h();
        hVar.a(aVar.getSessionId());
        hVar.b(aVar.getFromAccount());
        hVar.c(aVar.getUuid());
        hVar.d(a((IMMessage) aVar));
        hVar.a(aVar.getSessionType());
        hVar.a(aVar.getTime());
        hVar.setMsgStatus(aVar.getStatus());
        hVar.b(aVar.b());
        boolean z = false;
        hVar.e(aVar.a(false));
        hVar.setMsgStatus(msgStatusEnum);
        h a = f.a(sessionId, aVar.getSessionType());
        if (a != null) {
            if (aVar.getDirect() == MsgDirectionEnum.In) {
                z = true;
            }
            if (z) {
                hVar.a(i + a.getUnreadCount());
            }
            hVar.setTag(a.getTag());
        } else {
            hVar.a(i);
        }
        f.a(hVar);
        return hVar;
    }

    public static h a(String str, SessionTypeEnum sessionTypeEnum) {
        h hVar = new h();
        hVar.a(str);
        hVar.c("");
        hVar.d("");
        hVar.a(sessionTypeEnum);
        hVar.a(0);
        hVar.setMsgStatus(MsgStatusEnum.success);
        hVar.e("");
        hVar.a(0);
        f.a(hVar);
        return hVar;
    }

    public static MsgTypeEnum a(int i) {
        for (MsgTypeEnum msgTypeEnum : MsgTypeEnum.values()) {
            if (msgTypeEnum.getValue() == i) {
                return msgTypeEnum;
            }
        }
        return MsgTypeEnum.undef;
    }

    public static String a(IMMessage iMMessage) {
        if (iMMessage.getMsgType() == MsgTypeEnum.text || iMMessage.getMsgType() == MsgTypeEnum.notification || iMMessage.getMsgType() == MsgTypeEnum.tips) {
            return iMMessage.getContent();
        }
        Context a = b.a();
        MsgAttachment attachment = iMMessage.getAttachment();
        if (attachment == null || a == null) {
            return iMMessage.getContent();
        }
        int i;
        String content = attachment.getContent(a);
        if (TextUtils.isEmpty(content)) {
            i = R.string.ysf_msg_notify_custom_default;
        } else if (!(attachment instanceof ProductAttachment)) {
            return content;
        } else {
            i = R.string.ysf_msg_notify_custom_send;
        }
        return a.getString(i);
    }

    public static String a(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("_");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static h b(a aVar) {
        return a(aVar, MsgStatusEnum.fail, 0);
    }
}
