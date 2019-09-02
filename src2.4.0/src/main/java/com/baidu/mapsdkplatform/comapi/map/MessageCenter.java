package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import com.baidu.mapsdkplatform.comjni.engine.a;

public class MessageCenter {
    public static void registMessage(int i, Handler handler) {
        a.a(i, handler);
    }

    public static void unregistMessage(int i, Handler handler) {
        a.b(i, handler);
    }
}
