package com.qiyukf.unicorn.f.a.e;

import android.annotation.TargetApi;
import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import com.qiyukf.unicorn.f.a.e;
import java.net.NetworkInterface;
import java.util.Collections;

@b(a = 208)
public final class r extends e {
    @a(a = "appKey")
    private String a;
    @a(a = "deviceId")
    private String b;
    @a(a = "source")
    private int c;
    @a(a = "imei")
    private String d;
    @a(a = "mac")
    private String e;
    @a(a = "androidId")
    private String f;
    @a(a = "brand")
    private String g;
    @a(a = "model")
    private String h;
    @a(a = "os")
    private String i;
    @a(a = "timestamp")
    private long j;

    /* JADX WARNING: Missing block: B:7:0x0039, code skipped:
            if (android.text.TextUtils.isEmpty(r0) == false) goto L_0x003e;
     */
    public r(android.content.Context r3) {
        /*
        r2 = this;
        r2.<init>();
        r0 = com.qiyukf.unicorn.d.d();
        r2.a = r0;
        r0 = com.qiyukf.unicorn.b.b.d();
        r2.b = r0;
        r0 = 1;
        r2.c = r0;
        r0 = com.qiyukf.nimlib.d.b.a.b.c(r3);
        r2.d = r0;
        r0 = com.qiyukf.nimlib.d.b.a.b.b(r3);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x002b;
    L_0x0022:
        r1 = "02:00:00:00:00:00";
        r1 = r0.equalsIgnoreCase(r1);
        if (r1 != 0) goto L_0x002b;
    L_0x002a:
        goto L_0x003e;
    L_0x002b:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 9;
        if (r0 < r1) goto L_0x003c;
    L_0x0031:
        r0 = a();
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x003c;
    L_0x003b:
        goto L_0x003e;
    L_0x003c:
        r0 = "";
    L_0x003e:
        r2.e = r0;
        r3 = com.qiyukf.nimlib.d.b.a.b.h(r3);
        r2.f = r3;
        r3 = android.os.Build.BRAND;
        r2.g = r3;
        r3 = android.os.Build.MODEL;
        r2.h = r3;
        r3 = new java.lang.StringBuilder;
        r0 = "Android ";
        r3.<init>(r0);
        r0 = android.os.Build.VERSION.RELEASE;
        r3.append(r0);
        r3 = r3.toString();
        r2.i = r3;
        r0 = java.lang.System.currentTimeMillis();
        r2.j = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.f.a.e.r.<init>(android.content.Context):void");
    }

    @TargetApi(9)
    private static String a() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    return stringBuilder.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
