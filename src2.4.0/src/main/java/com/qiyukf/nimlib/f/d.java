package com.qiyukf.nimlib.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.util.Pair;
import com.qiyukf.nimlib.h.f;
import com.qiyukf.nimlib.h.g;
import com.qiyukf.nimlib.sdk.StatusCode;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.service.WakeupService;
import com.qiyukf.unicorn.api.SavePowerConfig;
import com.qiyukf.unicorn.g.c;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private final Messenger a;
    private Messenger b;
    private final List<Pair<Integer, Object>> c;

    private static class a {
        static d a = new d();
    }

    private class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1:
                        d.a(d.this, message);
                        break;
                    case 10:
                        f.a().a((LoginInfo) a.a(message));
                        return;
                    case 11:
                        f.a().b();
                        return;
                    case 13:
                        com.qiyukf.nimlib.f.a.a aVar = (com.qiyukf.nimlib.f.a.a) a.a(message);
                        if (aVar != null) {
                            f.a().a(aVar);
                            return;
                        }
                        break;
                    case 101:
                        ((Integer) a.b(message)).intValue();
                        c.a(com.qiyukf.nimlib.b.a());
                        return;
                    case 102:
                        com.qiyukf.unicorn.g.d.a().a((SavePowerConfig) a.b(message));
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            } catch (Throwable th) {
                com.qiyukf.basesdk.a.a.d("RemoteAgent", "handle message error.", th);
            }
        }
    }

    private d() {
        this.c = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("RemoteAgent");
        handlerThread.start();
        this.a = new Messenger(new b(handlerThread.getLooper()));
    }

    /* synthetic */ d(byte b) {
        this();
    }

    public static void a() {
        if (com.qiyukf.nimlib.d.b()) {
            a(16, g.b());
        }
    }

    private static void a(int i, Object obj) {
        Object obj2 = null;
        try {
            if (com.qiyukf.nimlib.d.b() && a.a.b != null) {
                a.a.b.send(a.a(i, obj));
                obj2 = 1;
            }
        } catch (Exception unused) {
            String str;
            String str2 = "RemoteAgent send message exception";
            if (a.a == null) {
                str = "remoteagent is null";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a.a.toString());
                stringBuilder.append(i);
                stringBuilder.append(obj.toString());
                str = stringBuilder.toString();
            }
            com.qiyukf.basesdk.a.a.a(str2, str);
        }
        if (obj2 == null) {
            synchronized (a.a.c) {
                a.a.c.add(new Pair(Integer.valueOf(i), obj));
            }
            com.qiyukf.basesdk.a.a.a("RemoteAgent", "awake UI process and bind core");
            WakeupService.a(com.qiyukf.nimlib.b.a());
        }
    }

    public static void a(com.qiyukf.nimlib.a.d.a.a aVar) {
        for (Object a : new com.qiyukf.nimlib.f.a.a(aVar).a()) {
            a(14, a);
        }
    }

    public static void a(StatusCode statusCode) {
        if (com.qiyukf.nimlib.d.b() || statusCode.wontAutoLogin()) {
            a(15, new com.qiyukf.nimlib.f.a.b(statusCode, com.qiyukf.nimlib.d.h(), com.qiyukf.nimlib.b.e()));
        }
    }

    public static void b() {
        a(103, Boolean.valueOf(true));
    }

    public static void c() {
        a(17, com.qiyukf.nimlib.b.b.e().c());
    }

    public static IBinder d() {
        return a.a.a.getBinder();
    }

    public static void e() {
        if (!com.qiyukf.nimlib.d.b()) {
            com.qiyukf.basesdk.a.a.a("RemoteAgent", "UI process bound!");
            com.qiyukf.nimlib.d.b(true);
            a(com.qiyukf.nimlib.d.e());
            a();
        }
    }
}
