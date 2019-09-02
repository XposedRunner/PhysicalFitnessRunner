package com.amap.api.mapcore.util;

import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;

/* compiled from: EngineStyleKeyItem */
public class OO0O0O {
    int O000000o;
    int[] O00000Oo;
    int O00000o;
    int O00000o0;
    String O00000oO;
    String O00000oo;
    String O0000O0o;

    public OO0O0O(int i, int[] iArr, String str, String str2, String str3) {
        Object str4;
        this.O000000o = i;
        this.O00000Oo = iArr;
        this.O00000oO = str4;
        this.O00000oo = str2;
        this.O0000O0o = str3;
        if (TextUtils.isEmpty(str4)) {
            str4 = str2;
        }
        this.O00000o0 = NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        if ("regions".equals(str4)) {
            this.O00000o0 = 1001;
        } else if ("water".equals(str4)) {
            this.O00000o0 = 1002;
        } else if ("buildings".equals(str4)) {
            this.O00000o0 = 1003;
        } else if ("roads".equals(str4)) {
            this.O00000o0 = 1004;
        } else if ("labels".equals(str4)) {
            this.O00000o0 = 1005;
        } else if ("borders".equals(str4)) {
            this.O00000o0 = 1006;
        }
        this.O00000o = (i * 1000) + iArr.hashCode();
    }
}
