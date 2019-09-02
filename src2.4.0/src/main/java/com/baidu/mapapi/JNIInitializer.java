package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;

public class JNIInitializer {
    private static Context a;

    public static Context getCachedContext() {
        return a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        } else if (a == null) {
            a = application;
        }
    }
}
