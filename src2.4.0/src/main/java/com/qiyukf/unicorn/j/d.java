package com.qiyukf.unicorn.j;

import android.content.Context;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.a.a;
import java.lang.Thread.UncaughtExceptionHandler;

public final class d {
    public static void a(final Context context) {
        final UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public final void uncaughtException(Thread thread, Throwable th) {
                try {
                    if (Log.getStackTraceString(th).contains("com.qiyukf")) {
                        StringBuilder stringBuilder = new StringBuilder("************* crash *************\n** Thread: ");
                        stringBuilder.append(context.getPackageName());
                        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
                        stringBuilder.append(thread.getName());
                        stringBuilder.append(" **");
                        a.b("APP", stringBuilder.toString(), th);
                        com.qiyukf.unicorn.analytics.a.b(th);
                    }
                } catch (Throwable unused) {
                }
                defaultUncaughtExceptionHandler.uncaughtException(thread, th);
            }
        });
    }
}
