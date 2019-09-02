package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import cn.jpush.android.service.JPushMessageReceiver;

public class a {
    private static a a;
    private Handler b;

    private a() {
        try {
            HandlerThread handlerThread = new HandlerThread("MessageReceiver");
            handlerThread.start();
            this.b = new Handler(handlerThread.getLooper());
        } catch (Throwable unused) {
            this.b = new Handler();
        }
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public final void a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        this.b.post(new b(this, context, jPushMessageReceiver, intent));
    }
}
