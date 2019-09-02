package com.qiyukf.basesdk.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;

public final class a {
    private static a a;
    private static Handler b;
    private final HashMap<String, HandlerThread> c = new HashMap();

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public static Handler b() {
        if (b == null) {
            b = new Handler(Looper.getMainLooper());
        }
        return b;
    }

    private HandlerThread b(String str) {
        HandlerThread handlerThread;
        synchronized (this.c) {
            handlerThread = (HandlerThread) this.c.get(str);
            if (handlerThread == null) {
                StringBuilder stringBuilder = new StringBuilder("HT-");
                stringBuilder.append(TextUtils.isEmpty(str) ? "Default" : str);
                handlerThread = new HandlerThread(stringBuilder.toString());
                handlerThread.start();
                this.c.put(str, handlerThread);
            }
        }
        return handlerThread;
    }

    public final Handler a(String str) {
        return new Handler(b(str).getLooper());
    }

    public final Handler c() {
        return a("Default");
    }
}
