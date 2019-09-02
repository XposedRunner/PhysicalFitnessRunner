package com.baidu.location.a;

import android.os.HandlerThread;

public class v {
    private static HandlerThread a;

    public static synchronized HandlerThread a() {
        HandlerThread handlerThread;
        synchronized (v.class) {
            if (a == null) {
                a = new HandlerThread("ServiceStartArguments", 10);
                a.start();
            }
            handlerThread = a;
        }
        return handlerThread;
    }
}
