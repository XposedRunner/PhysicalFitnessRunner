package com.qiyukf.unicorn.j;

import com.qiyukf.basesdk.c.b;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.api.msg.MsgTypeEnum;
import com.qiyukf.unicorn.f.a.d.h;

public final class f {
    public static String a(IMMessage iMMessage) {
        return iMMessage.getDirect() != MsgDirectionEnum.Out ? null : ((iMMessage.getMsgType() == MsgTypeEnum.text || iMMessage.getMsgType() == MsgTypeEnum.image || (iMMessage.getAttachment() instanceof h)) && b.b(iMMessage.getExtension(), "auditResult") == 1) ? "消息包含违禁信息，发送失败" : null;
    }
}
