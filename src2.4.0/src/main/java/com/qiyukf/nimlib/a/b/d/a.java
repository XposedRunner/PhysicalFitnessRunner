package com.qiyukf.nimlib.a.b.d;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import com.qiyukf.nimlib.a.b.g;
import com.qiyukf.nimlib.a.d;
import com.qiyukf.nimlib.h.c.b.b;
import com.qiyukf.nimlib.sdk.NimIntent;
import com.qiyukf.nimlib.sdk.msg.SystemMessageObserver;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SystemMessageStatus;
import com.qiyukf.nimlib.sdk.msg.constant.SystemMessageType;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.SystemMessage;
import com.qiyukf.unicorn.f.a.e;
import com.umeng.commonsdk.framework.c;
import java.util.ArrayList;
import java.util.List;

public final class a extends g {
    private static int a(b bVar, boolean z) {
        int b = bVar.b(1);
        if (b == 100 || b == 101 || b == 102) {
            CustomNotification customNotification = new CustomNotification();
            String a = bVar.a(3);
            String a2 = bVar.a(5);
            StringBuilder stringBuilder = new StringBuilder("receive custom notification: sessionId: ");
            stringBuilder.append(a);
            stringBuilder.append(", content: ");
            stringBuilder.append(a2);
            com.qiyukf.basesdk.a.a.b("test", stringBuilder.toString());
            customNotification.setAttachStr(a2);
            if (customNotification.getAttachment() != null) {
                int i;
                SessionTypeEnum sessionTypeEnum;
                String a3;
                StringBuilder stringBuilder2;
                Intent intent;
                Context a4;
                StringBuilder stringBuilder3;
                if (z) {
                    e attachment = customNotification.getAttachment();
                    i = (attachment == null || !attachment.supportOffline()) ? 0 : 1;
                    if (i == 0) {
                        return 0;
                    }
                }
                customNotification.setTime(bVar.c(0));
                customNotification.setFromAccount(bVar.a(3));
                customNotification.setApnsText(bVar.a(8));
                if (bVar.c(6) > 0) {
                    customNotification.setSendToOnlineUserOnly(false);
                }
                i = bVar.b(1);
                if (i == 100) {
                    sessionTypeEnum = SessionTypeEnum.P2P;
                } else if (i == 101) {
                    customNotification.setSessionType(SessionTypeEnum.Team);
                    a3 = bVar.a(2);
                    customNotification.setSessionId(a3);
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(com.qiyukf.nimlib.b.a().getPackageName());
                    stringBuilder2.append(NimIntent.ACTION_RECEIVE_CUSTOM_NOTIFICATION);
                    intent = new Intent(stringBuilder2.toString());
                    intent.putExtra(NimIntent.EXTRA_BROADCAST_MSG, customNotification);
                    a4 = com.qiyukf.nimlib.b.a();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(com.qiyukf.nimlib.b.a().getPackageName());
                    stringBuilder3.append(NimIntent.PERMISSION_RECEIVE_MSG);
                    a4.sendBroadcast(intent, stringBuilder3.toString());
                    com.qiyukf.nimlib.e.b.a(customNotification);
                } else {
                    if (i == 102) {
                        sessionTypeEnum = SessionTypeEnum.Ysf;
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(com.qiyukf.nimlib.b.a().getPackageName());
                    stringBuilder2.append(NimIntent.ACTION_RECEIVE_CUSTOM_NOTIFICATION);
                    intent = new Intent(stringBuilder2.toString());
                    intent.putExtra(NimIntent.EXTRA_BROADCAST_MSG, customNotification);
                    a4 = com.qiyukf.nimlib.b.a();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(com.qiyukf.nimlib.b.a().getPackageName());
                    stringBuilder3.append(NimIntent.PERMISSION_RECEIVE_MSG);
                    a4.sendBroadcast(intent, stringBuilder3.toString());
                    com.qiyukf.nimlib.e.b.a(customNotification);
                }
                customNotification.setSessionType(sessionTypeEnum);
                a3 = bVar.a(3);
                customNotification.setSessionId(a3);
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(com.qiyukf.nimlib.b.a().getPackageName());
                stringBuilder2.append(NimIntent.ACTION_RECEIVE_CUSTOM_NOTIFICATION);
                intent = new Intent(stringBuilder2.toString());
                intent.putExtra(NimIntent.EXTRA_BROADCAST_MSG, customNotification);
                a4 = com.qiyukf.nimlib.b.a();
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(com.qiyukf.nimlib.b.a().getPackageName());
                stringBuilder3.append(NimIntent.PERMISSION_RECEIVE_MSG);
                a4.sendBroadcast(intent, stringBuilder3.toString());
                com.qiyukf.nimlib.e.b.a(customNotification);
            }
        } else {
            SystemMessageType typeOfValue = SystemMessageType.typeOfValue(b);
            if (typeOfValue != SystemMessageType.undefined) {
                SystemMessage systemMessage = new SystemMessage();
                systemMessage.setFromAccount(bVar.a(3));
                systemMessage.setTargetId(bVar.a(2));
                systemMessage.setType(bVar.b(1));
                systemMessage.setTime(bVar.c(0));
                systemMessage.setContent(bVar.a(4));
                systemMessage.setAttach(bVar.a(5));
                systemMessage.setStatus(SystemMessageStatus.init);
                ContentValues contentValues = new ContentValues(8);
                contentValues.put("id", systemMessage.getTargetId());
                contentValues.put("fromid", systemMessage.getFromAccount());
                contentValues.put("type", Integer.valueOf(systemMessage.getType().getValue()));
                contentValues.put("time", Long.valueOf(systemMessage.getTime()));
                contentValues.put("status", Integer.valueOf(systemMessage.getStatus().getValue()));
                contentValues.put(c.a, systemMessage.getContent());
                contentValues.put("attach", systemMessage.getAttach());
                systemMessage.setMessageId(com.qiyukf.nimlib.c.c.a().d().a("system_msg", contentValues));
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(SystemMessageObserver.class.getSimpleName());
                stringBuilder4.append("/observeReceiveSystemMsg");
                com.qiyukf.nimlib.e.a.a(stringBuilder4.toString(), systemMessage);
                return typeOfValue == SystemMessageType.DeleteFriend ? 0 : 1;
            }
        }
        return 0;
    }

    private static void a(byte b, List<Long> list) {
        com.qiyukf.nimlib.a.c.a aVar = new com.qiyukf.nimlib.a.c.b.a();
        aVar.a(b);
        aVar.b((byte) 3);
        aVar.a((List) list);
        com.qiyukf.nimlib.a.c.a().a(aVar, com.qiyukf.nimlib.a.f.a.d);
    }

    public final void a(com.qiyukf.nimlib.a.d.a aVar) {
        if (aVar.b()) {
            int i = 0;
            if (aVar instanceof com.qiyukf.nimlib.a.d.d.a) {
                i = 0 + a(((com.qiyukf.nimlib.a.d.d.a) aVar).f(), false);
            } else if (aVar instanceof com.qiyukf.nimlib.a.d.b.a) {
                List<b> f = ((com.qiyukf.nimlib.a.d.b.a) aVar).f();
                List arrayList = new ArrayList();
                for (b bVar : f) {
                    i += a(bVar, true);
                    long c = bVar.c(6);
                    if (c > 0) {
                        arrayList.add(Long.valueOf(c));
                    }
                }
                a(aVar.a().h() == (byte) 6 ? (byte) 7 : (byte) 101, arrayList);
            }
            if (i > 0) {
                i += d.a();
                d.a(i);
                com.qiyukf.nimlib.e.b.a(i);
            }
        }
    }
}
