package com.qiyukf.unicorn.h;

import android.text.TextUtils;
import com.qiyukf.nim.uikit.session.module.b;
import com.qiyukf.nimlib.sdk.InvocationFuture;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.nimlib.sdk.msg.model.IMMessage;
import com.qiyukf.unicorn.f.a.e;
import org.json.JSONObject;

public final class c {
    private static b a;

    public static int a(IMMessage iMMessage) {
        JSONObject extension = iMMessage.getExtension();
        return extension != null ? extension.optInt("type") : 0;
    }

    public static InvocationFuture<Void> a(e eVar, String str, boolean z) {
        CustomNotification createCustomNotification = MessageBuilder.createCustomNotification(eVar, str);
        return z ? ((MsgService) NIMClient.getService(MsgService.class)).sendImportantNotification(createCustomNotification) : ((MsgService) NIMClient.getService(MsgService.class)).sendCustomNotification(createCustomNotification);
    }

    public static String a() {
        String c = com.qiyukf.unicorn.b.b.c();
        return !TextUtils.isEmpty(c) ? c : "-1";
    }

    public static void a(b bVar) {
        a = bVar;
    }

    public static void b(final IMMessage iMMessage) {
        com.qiyukf.unicorn.j.e.a(new Runnable() {
            public final void run() {
                if (c.a != null) {
                    c.a.sendMessage(iMMessage, false);
                }
            }
        });
    }

    public static boolean b() {
        return a != null && a.isAllowSendMessage(false);
    }
}
