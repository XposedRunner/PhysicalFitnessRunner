package cn.jiguang.a.a.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import cn.jiguang.d.d.x;
import com.alibaba.wireless.security.SecExceptionCode;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class h extends Thread {
    private static final Object i = new Object();
    private int a;
    private Context b;
    private WifiManager c;
    private String d;
    private String e;
    private String f;
    private int g;
    private boolean[] h;

    private h(WifiManager wifiManager, String str, String str2, String str3, Context context, int i, int i2) {
        this.g = 2;
        this.c = wifiManager;
        this.a = i;
        this.b = context;
        this.g = i2;
        this.d = str2;
        this.e = str3;
        this.f = str;
        if (i2 == 2) {
            this.h = new boolean[3];
        }
    }

    /* synthetic */ h(WifiManager wifiManager, String str, String str2, String str3, Context context, int i, int i2, byte b) {
        this(wifiManager, str, str2, str3, context, SecExceptionCode.SEC_ERROR_STA_ENC, 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x007c A:{SYNTHETIC, Splitter:B:52:0x007c} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006f A:{SYNTHETIC, Splitter:B:43:0x006f} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025 A:{LOOP_START, SYNTHETIC, LOOP:0: B:11:0x0025->B:57:0x0025, Splitter:B:11:0x0025} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007c A:{SYNTHETIC, Splitter:B:52:0x007c} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006f A:{SYNTHETIC, Splitter:B:43:0x006f} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x007c A:{SYNTHETIC, Splitter:B:52:0x007c} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0060 A:{Splitter:B:9:0x001d, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|(4:14|15|(3:23|24|62)|57)(1:25)) */
    /* JADX WARNING: Missing block: B:27:0x005a, code skipped:
            if (r1 == null) goto L_0x0082;
     */
    /* JADX WARNING: Missing block: B:29:0x005c, code skipped:
            r1.destroy();
     */
    /* JADX WARNING: Missing block: B:30:0x005f, code skipped:
            return r3;
     */
    /* JADX WARNING: Missing block: B:31:0x0060, code skipped:
            r7 = th;
     */
    /* JADX WARNING: Missing block: B:32:0x0062, code skipped:
            r3 = null;
     */
    /* JADX WARNING: Missing block: B:54:0x007f, code skipped:
            if (r1 != null) goto L_0x005c;
     */
    /* JADX WARNING: Missing block: B:56:0x0082, code skipped:
            return r3;
     */
    private java.util.ArrayList<cn.jiguang.a.a.a.b> a(java.lang.String r7) {
        /*
        r6 = this;
        r0 = 0;
        r1 = "cat /proc/net/arp";
        r1 = cn.jiguang.a.a.a.c.b(r1);	 Catch:{ IOException -> 0x0078, all -> 0x006a }
        if (r1 != 0) goto L_0x000f;
    L_0x0009:
        if (r1 == 0) goto L_0x000e;
    L_0x000b:
        r1.destroy();
    L_0x000e:
        return r0;
    L_0x000f:
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        r3 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        r4 = r1.getInputStream();	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        r3.<init>(r4);	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        r2.readLine();	 Catch:{ IOException -> 0x0062, all -> 0x0060 }
        r3 = new java.util.ArrayList;	 Catch:{ IOException -> 0x0062, all -> 0x0060 }
        r3.<init>();	 Catch:{ IOException -> 0x0062, all -> 0x0060 }
    L_0x0025:
        r0 = r2.readLine();	 Catch:{ IOException -> 0x0063, all -> 0x0060 }
        if (r0 == 0) goto L_0x0057;
    L_0x002b:
        r0 = b(r0);	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x0025;
    L_0x0031:
        r4 = r0.b();	 Catch:{ Exception -> 0x0025 }
        r5 = "0x2";
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0025 }
        if (r4 == 0) goto L_0x0025;
    L_0x003d:
        r4 = r0.a();	 Catch:{ Exception -> 0x0025 }
        r4 = r7.equals(r4);	 Catch:{ Exception -> 0x0025 }
        if (r4 != 0) goto L_0x0025;
    L_0x0047:
        r4 = r0.c();	 Catch:{ Exception -> 0x0025 }
        r5 = "00:00:00:00:00:00";
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0025 }
        if (r4 != 0) goto L_0x0025;
    L_0x0053:
        r3.add(r0);	 Catch:{ Exception -> 0x0025 }
        goto L_0x0025;
    L_0x0057:
        r2.close();	 Catch:{ IOException -> 0x005a }
    L_0x005a:
        if (r1 == 0) goto L_0x0082;
    L_0x005c:
        r1.destroy();
        return r3;
    L_0x0060:
        r7 = move-exception;
        goto L_0x006d;
    L_0x0062:
        r3 = r0;
    L_0x0063:
        r0 = r2;
        goto L_0x007a;
    L_0x0065:
        r7 = move-exception;
        r2 = r0;
        goto L_0x006d;
    L_0x0068:
        r3 = r0;
        goto L_0x007a;
    L_0x006a:
        r7 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x006d:
        if (r2 == 0) goto L_0x0072;
    L_0x006f:
        r2.close();	 Catch:{ IOException -> 0x0072 }
    L_0x0072:
        if (r1 == 0) goto L_0x0077;
    L_0x0074:
        r1.destroy();
    L_0x0077:
        throw r7;
    L_0x0078:
        r1 = r0;
        r3 = r1;
    L_0x007a:
        if (r0 == 0) goto L_0x007f;
    L_0x007c:
        r0.close();	 Catch:{ IOException -> 0x007f }
    L_0x007f:
        if (r1 == 0) goto L_0x0082;
    L_0x0081:
        goto L_0x005c;
    L_0x0082:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.a.h.a(java.lang.String):java.util.ArrayList");
    }

    private JSONObject a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, ArrayList<b> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            x.a(this.b, jSONObject, "mac_list");
            jSONObject.put("ssid", str);
            jSONObject.put("bssid", str2);
            jSONObject.put("local_ip", str3);
            jSONObject.put("local_mac", str4);
            jSONObject.put("netmask", str5);
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(str6)) {
                jSONArray.put(str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                jSONArray.put(str7);
            }
            jSONObject.put("dns", jSONArray);
            jSONObject.put("gateway", str8);
            jSONObject.put("dhcp", str9);
            jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ip", bVar.a());
                jSONObject2.put("mac", bVar.c());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static b b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        b bVar = new b();
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i < bytes.length - 1) {
            i++;
            if (bytes[i] == (byte) 32) {
                int i4 = i - i2;
                if (i4 > 1) {
                    String str2 = new String(bytes, i2, i4);
                    if (i3 == 0) {
                        bVar.a(str2);
                    } else if (i3 == 1) {
                        bVar.b(str2);
                    } else if (i3 == 2) {
                        bVar.c(str2);
                    } else if (i3 == 3) {
                        bVar.d(str2);
                        return bVar;
                    }
                    i3++;
                }
                i2 = i + 1;
            }
        }
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d6 A:{LOOP_START, SYNTHETIC, LOOP:1: B:34:0x00d6->B:71:0x00d6, Splitter:B:34:0x00d6} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00d6 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:34|35|(2:37|(2:75|39)(1:40))|74|41|(5:43|44|45|73|71)(1:46)) */
    public final void run() {
        /*
        r24 = this;
        r12 = r24;
        r1 = r12.c;
        r1 = r1.getDhcpInfo();
        if (r1 != 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r2 = r1.ipAddress;
        r2 = (long) r2;
        r2 = new byte[]{(byte) ((int) (255 & r2)), (byte) ((int) (255 & (r2 >> 8))), (byte) ((int) (255 & (r2 >> 16))), (byte) ((int) (255 & (r2 >> 24)))};
        r3 = r1.ipAddress;
        r3 = cn.jiguang.a.a.a.c.a(r3);
        r4 = "0.0.0.0";
        r4 = android.text.TextUtils.equals(r3, r4);
        if (r4 == 0) goto L_0x0022;
    L_0x0020:
        r3 = "";
    L_0x0022:
        r10 = r3;
        r3 = r12.b;
        r4 = "";
        r11 = cn.jiguang.g.a.b(r3, r4);
        r3 = r1.netmask;
        r3 = cn.jiguang.a.a.a.c.a(r3);
        r4 = "0.0.0.0";
        r4 = android.text.TextUtils.equals(r3, r4);
        if (r4 == 0) goto L_0x003b;
    L_0x0039:
        r3 = "";
    L_0x003b:
        r13 = r3;
        r3 = r1.dns1;
        r3 = cn.jiguang.a.a.a.c.a(r3);
        r4 = "0.0.0.0";
        r4 = android.text.TextUtils.equals(r3, r4);
        if (r4 == 0) goto L_0x004c;
    L_0x004a:
        r3 = "";
    L_0x004c:
        r14 = r3;
        r3 = r1.dns2;
        r3 = cn.jiguang.a.a.a.c.a(r3);
        r4 = "0.0.0.0";
        r4 = android.text.TextUtils.equals(r3, r4);
        if (r4 == 0) goto L_0x005d;
    L_0x005b:
        r3 = "";
    L_0x005d:
        r15 = r3;
        r3 = r1.gateway;
        r3 = cn.jiguang.a.a.a.c.a(r3);
        r4 = "0.0.0.0";
        r4 = android.text.TextUtils.equals(r3, r4);
        if (r4 == 0) goto L_0x006e;
    L_0x006c:
        r3 = "";
    L_0x006e:
        r16 = r3;
        r1 = r1.serverAddress;
        r1 = cn.jiguang.a.a.a.c.a(r1);
        r3 = "0.0.0.0";
        r3 = android.text.TextUtils.equals(r1, r3);
        if (r3 == 0) goto L_0x0080;
    L_0x007e:
        r1 = "";
    L_0x0080:
        r3 = r1;
        r1 = new cn.jiguang.g.l;
        r1.<init>();
        r9 = 2;
        r4 = r12.g;	 Catch:{ Exception -> 0x0104 }
        r8 = 0;
        if (r4 != r9) goto L_0x00f4;
    L_0x008c:
        r7 = r8;
    L_0x008d:
        r4 = 3;
        if (r7 >= r4) goto L_0x00d0;
    L_0x0090:
        r4 = r12.h;	 Catch:{ Exception -> 0x0104 }
        r4[r7] = r8;	 Catch:{ Exception -> 0x0104 }
        r4 = r7 * 85;
        r17 = r4 + 0;
        r18 = r17 + 85;
        r4 = new cn.jiguang.g.l;	 Catch:{ Exception -> 0x0104 }
        r4.<init>();	 Catch:{ Exception -> 0x0104 }
        r5 = new cn.jiguang.a.a.a.d;	 Catch:{ Exception -> 0x0104 }
        r6 = r12.a;	 Catch:{ Exception -> 0x0104 }
        r5.<init>(r3, r6);	 Catch:{ Exception -> 0x0104 }
        r6 = new cn.jiguang.a.a.a.j;	 Catch:{ Exception -> 0x0104 }
        r6.<init>(r12, r4, r7);	 Catch:{ Exception -> 0x0104 }
        r4 = new cn.jiguang.a.a.a.f;	 Catch:{ Exception -> 0x0104 }
        r19 = r4;
        r4 = r19;
        r20 = r6;
        r6 = r2;
        r21 = r7;
        r7 = r17;
        r22 = r15;
        r15 = r8;
        r8 = r18;
        r9 = r20;
        r4.<init>(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0106 }
        r4 = new int[r15];	 Catch:{ Exception -> 0x0106 }
        r5 = r19;
        cn.jiguang.api.JCoreInterface.asyncExecute(r5, r4);	 Catch:{ Exception -> 0x0106 }
        r7 = r21 + 1;
        r8 = r15;
        r15 = r22;
        r9 = 2;
        goto L_0x008d;
    L_0x00d0:
        r22 = r15;
        r15 = r8;
        r2 = i;	 Catch:{ Exception -> 0x0106 }
        monitor-enter(r2);	 Catch:{ Exception -> 0x0106 }
    L_0x00d6:
        r4 = r12.h;	 Catch:{ all -> 0x00f0 }
        r5 = r4.length;	 Catch:{ all -> 0x00f0 }
        r6 = r15;
    L_0x00da:
        if (r6 >= r5) goto L_0x00e5;
    L_0x00dc:
        r7 = r4[r6];	 Catch:{ all -> 0x00f0 }
        if (r7 != 0) goto L_0x00e2;
    L_0x00e0:
        r8 = 1;
        goto L_0x00e6;
    L_0x00e2:
        r6 = r6 + 1;
        goto L_0x00da;
    L_0x00e5:
        r8 = r15;
    L_0x00e6:
        if (r8 == 0) goto L_0x00ee;
    L_0x00e8:
        r4 = i;	 Catch:{ InterruptedException -> 0x00d6 }
        r4.wait();	 Catch:{ InterruptedException -> 0x00d6 }
        goto L_0x00d6;
    L_0x00ee:
        monitor-exit(r2);	 Catch:{ all -> 0x00f0 }
        goto L_0x0106;
    L_0x00f0:
        r0 = move-exception;
        r4 = r0;
        monitor-exit(r2);	 Catch:{ all -> 0x00f0 }
        throw r4;	 Catch:{ Exception -> 0x0106 }
    L_0x00f4:
        r22 = r15;
        r15 = r8;
        r4 = new cn.jiguang.a.a.a.d;	 Catch:{ Exception -> 0x0106 }
        r5 = r12.a;	 Catch:{ Exception -> 0x0106 }
        r4.<init>(r3, r5);	 Catch:{ Exception -> 0x0106 }
        r5 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r4.a(r2, r15, r5);	 Catch:{ Exception -> 0x0106 }
        goto L_0x0106;
    L_0x0104:
        r22 = r15;
    L_0x0106:
        r2 = "ping";
        r1.a(r2);
        r1 = 0;
        r2 = r12.a(r3);	 Catch:{ Exception -> 0x0112 }
        r15 = r2;
        goto L_0x0113;
    L_0x0112:
        r15 = r1;
    L_0x0113:
        if (r15 == 0) goto L_0x013c;
    L_0x0115:
        r1 = r15.isEmpty();
        if (r1 != 0) goto L_0x013c;
    L_0x011b:
        r2 = r12.e;
        r4 = r12.d;
        r1 = r12;
        r17 = r3;
        r3 = r4;
        r4 = r10;
        r5 = r11;
        r6 = r13;
        r7 = r14;
        r8 = r22;
        r9 = r16;
        r10 = r17;
        r11 = r15;
        r1 = r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        r2 = r12.b;
        r3 = new cn.jiguang.a.a.a.i;
        r3.<init>(r12);
        cn.jiguang.d.d.x.a(r2, r1, r3);
    L_0x013c:
        r1 = 2;
        cn.jiguang.a.a.a.c.c(2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.a.h.run():void");
    }
}
