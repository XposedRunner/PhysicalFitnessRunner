package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObserver;
import com.baidu.mapsdkplatform.comjni.map.commonmemcache.a;

public class SysUpdateUtil implements SysUpdateObserver {
    static a a = new a();
    public static boolean b = false;
    public static String c = "";
    public static int d;

    public void init() {
        if (a != null) {
            a.a();
            a.b();
        }
    }

    public void updateNetworkInfo(Context context) {
        NetworkUtil.updateNetworkProxy(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00db  */
    /* JADX WARNING: Missing block: B:45:0x00c6, code skipped:
            if ("10.0.0.200".equals(r8.trim()) != false) goto L_0x00c8;
     */
    public void updateNetworkProxy(android.content.Context r8) {
        /*
        r7 = this;
        r8 = com.baidu.mapapi.NetworkUtil.getActiveNetworkInfo(r8);
        if (r8 == 0) goto L_0x00de;
    L_0x0006:
        r0 = r8.isAvailable();
        if (r0 == 0) goto L_0x00de;
    L_0x000c:
        r0 = r8.getTypeName();
        r0 = r0.toLowerCase();
        r1 = "wifi";
        r1 = r0.equals(r1);
        r2 = 0;
        r3 = 0;
        if (r1 == 0) goto L_0x002a;
    L_0x001e:
        r1 = r8.isConnected();
        if (r1 == 0) goto L_0x002a;
    L_0x0024:
        com.baidu.mapsdkplatform.comjni.engine.AppEngine.SetProxyInfo(r2, r3);
        b = r3;
        return;
    L_0x002a:
        r1 = "mobile";
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x0040;
    L_0x0032:
        r1 = "wifi";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00de;
    L_0x003a:
        r0 = com.baidu.mapapi.NetworkUtil.isWifiConnected(r8);
        if (r0 != 0) goto L_0x00de;
    L_0x0040:
        r8 = r8.getExtraInfo();
        b = r3;
        r0 = 80;
        r1 = 1;
        if (r8 == 0) goto L_0x0097;
    L_0x004b:
        r8 = r8.toLowerCase();
        r4 = "cmwap";
        r4 = r8.startsWith(r4);
        if (r4 != 0) goto L_0x0094;
    L_0x0057:
        r4 = "uniwap";
        r4 = r8.startsWith(r4);
        if (r4 != 0) goto L_0x0094;
    L_0x005f:
        r4 = "3gwap";
        r4 = r8.startsWith(r4);
        if (r4 == 0) goto L_0x0068;
    L_0x0067:
        goto L_0x0094;
    L_0x0068:
        r4 = "ctwap";
        r4 = r8.startsWith(r4);
        if (r4 == 0) goto L_0x0071;
    L_0x0070:
        goto L_0x00c8;
    L_0x0071:
        r0 = "cmnet";
        r0 = r8.startsWith(r0);
        if (r0 != 0) goto L_0x0091;
    L_0x0079:
        r0 = "uninet";
        r0 = r8.startsWith(r0);
        if (r0 != 0) goto L_0x0091;
    L_0x0081:
        r0 = "ctnet";
        r0 = r8.startsWith(r0);
        if (r0 != 0) goto L_0x0091;
    L_0x0089:
        r0 = "3gnet";
        r8 = r8.startsWith(r0);
        if (r8 == 0) goto L_0x00cf;
    L_0x0091:
        b = r3;
        goto L_0x00cf;
    L_0x0094:
        r8 = "10.0.0.172";
        goto L_0x00ca;
    L_0x0097:
        r8 = android.net.Proxy.getDefaultHost();
        r4 = android.net.Proxy.getDefaultPort();
        if (r8 == 0) goto L_0x00cf;
    L_0x00a1:
        r5 = r8.length();
        if (r5 <= 0) goto L_0x00cf;
    L_0x00a7:
        r5 = "10.0.0.172";
        r6 = r8.trim();
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00bc;
    L_0x00b3:
        r8 = "10.0.0.172";
        c = r8;
        d = r4;
    L_0x00b9:
        b = r1;
        goto L_0x00cf;
    L_0x00bc:
        r4 = "10.0.0.200";
        r8 = r8.trim();
        r8 = r4.equals(r8);
        if (r8 == 0) goto L_0x00cf;
    L_0x00c8:
        r8 = "10.0.0.200";
    L_0x00ca:
        c = r8;
        d = r0;
        goto L_0x00b9;
    L_0x00cf:
        r8 = b;
        if (r8 != r1) goto L_0x00db;
    L_0x00d3:
        r8 = c;
        r0 = d;
        com.baidu.mapsdkplatform.comjni.engine.AppEngine.SetProxyInfo(r8, r0);
        return;
    L_0x00db:
        com.baidu.mapsdkplatform.comjni.engine.AppEngine.SetProxyInfo(r2, r3);
    L_0x00de:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil.updateNetworkProxy(android.content.Context):void");
    }

    public void updatePhoneInfo() {
        if (a != null) {
            a.b();
        }
    }
}
