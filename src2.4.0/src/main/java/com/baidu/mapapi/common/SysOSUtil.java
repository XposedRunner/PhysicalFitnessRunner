package com.baidu.mapapi.common;

import com.baidu.mapsdkplatform.comapi.util.h;

public class SysOSUtil {
    public static float getDensity() {
        return h.x;
    }

    public static int getDensityDpi() {
        return h.l();
    }

    public static String getDeviceID() {
        return h.p();
    }

    public static String getModuleFileName() {
        return h.o();
    }

    public static String getPhoneType() {
        return h.g();
    }

    public static int getScreenSizeX() {
        return h.h();
    }

    public static int getScreenSizeY() {
        return h.j();
    }
}
