package com.baidu.location.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.location.f;
import java.util.Map;

public abstract class e {
    private static String a = "10.0.0.172";
    private static int b = 80;
    public static int g = a.g;
    protected static int p;
    public String h = null;
    public int i = 3;
    public String j = null;
    public Map<String, Object> k = null;
    public String l = null;
    public byte[] m = null;
    public byte[] n = null;
    public String o = null;

    /* JADX WARNING: Missing block: B:18:0x0047, code skipped:
            if (r1.equals("null") == false) goto L_0x0049;
     */
    /* JADX WARNING: Missing block: B:36:0x0085, code skipped:
            if (r1.equals("null") == false) goto L_0x0049;
     */
    /* JADX WARNING: Missing block: B:45:0x00ad, code skipped:
            if ("10.0.0.200".equals(r1.trim()) != false) goto L_0x00af;
     */
    private static int a(android.content.Context r1, android.net.NetworkInfo r2) {
        /*
        if (r2 == 0) goto L_0x0088;
    L_0x0002:
        r1 = r2.getExtraInfo();
        if (r1 == 0) goto L_0x0088;
    L_0x0008:
        r1 = r2.getExtraInfo();
        r1 = r1.toLowerCase();
        if (r1 == 0) goto L_0x0088;
    L_0x0012:
        r2 = "cmwap";
        r2 = r1.startsWith(r2);
        if (r2 != 0) goto L_0x0071;
    L_0x001a:
        r2 = "uniwap";
        r2 = r1.startsWith(r2);
        if (r2 != 0) goto L_0x0071;
    L_0x0022:
        r2 = "3gwap";
        r2 = r1.startsWith(r2);
        if (r2 == 0) goto L_0x002b;
    L_0x002a:
        goto L_0x0071;
    L_0x002b:
        r2 = "ctwap";
        r2 = r1.startsWith(r2);
        if (r2 == 0) goto L_0x004e;
    L_0x0033:
        r1 = android.net.Proxy.getDefaultHost();
        if (r1 == 0) goto L_0x00af;
    L_0x0039:
        r2 = "";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x00af;
    L_0x0041:
        r2 = "null";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x00af;
    L_0x0049:
        a = r1;
        r1 = com.baidu.location.g.a.d;
        return r1;
    L_0x004e:
        r2 = "cmnet";
        r2 = r1.startsWith(r2);
        if (r2 != 0) goto L_0x006e;
    L_0x0056:
        r2 = "uninet";
        r2 = r1.startsWith(r2);
        if (r2 != 0) goto L_0x006e;
    L_0x005e:
        r2 = "ctnet";
        r2 = r1.startsWith(r2);
        if (r2 != 0) goto L_0x006e;
    L_0x0066:
        r2 = "3gnet";
        r1 = r1.startsWith(r2);
        if (r1 == 0) goto L_0x0088;
    L_0x006e:
        r1 = com.baidu.location.g.a.e;
        return r1;
    L_0x0071:
        r1 = android.net.Proxy.getDefaultHost();
        if (r1 == 0) goto L_0x00a0;
    L_0x0077:
        r2 = "";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x00a0;
    L_0x007f:
        r2 = "null";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x00a0;
    L_0x0087:
        goto L_0x0049;
    L_0x0088:
        r1 = android.net.Proxy.getDefaultHost();
        if (r1 == 0) goto L_0x00b2;
    L_0x008e:
        r2 = r1.length();
        if (r2 <= 0) goto L_0x00b2;
    L_0x0094:
        r2 = "10.0.0.172";
        r0 = r1.trim();
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x00a3;
    L_0x00a0:
        r1 = "10.0.0.172";
        goto L_0x0049;
    L_0x00a3:
        r2 = "10.0.0.200";
        r1 = r1.trim();
        r1 = r2.equals(r1);
        if (r1 == 0) goto L_0x00b2;
    L_0x00af:
        r1 = "10.0.0.200";
        goto L_0x0049;
    L_0x00b2:
        r1 = com.baidu.location.g.a.e;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.g.e.a(android.content.Context, android.net.NetworkInfo):int");
    }

    private void b() {
        g = c();
    }

    private int c() {
        Context serviceContext = f.getServiceContext();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) serviceContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                return a.g;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    if (activeNetworkInfo.getType() != 1) {
                        return a(serviceContext, activeNetworkInfo);
                    }
                    String defaultHost = Proxy.getDefaultHost();
                    return (defaultHost == null || defaultHost.length() <= 0) ? a.f : a.h;
                }
            }
            return a.g;
        } catch (Exception unused) {
            return a.g;
        }
    }

    public abstract void a();

    public abstract void a(boolean z);

    public void a(boolean z, String str) {
        try {
            new g(this, str, z).start();
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void c(String str) {
        try {
            new h(this, str).start();
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void d() {
        try {
            new f(this).start();
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void e() {
        a(false, "loc.map.baidu.com");
    }
}
