package com.autonavi.amap.mapcore;

import android.os.Build;
import android.os.Build.VERSION;
import com.amap.api.mapcore.util.oO0O0O00;

public class MsgProcessor {
    public native void nativeCall();

    public native void nativeInit(int i, String str);

    public void nativeInitMsg() {
        try {
            nativeInit(VERSION.SDK_INT, Build.MODEL);
        } catch (Throwable unused) {
        }
    }

    public void nativeMsgProcessor(String str) {
        oO0O0O00.O000000o().O000000o(str);
    }
}
