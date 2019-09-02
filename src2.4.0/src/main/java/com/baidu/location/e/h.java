package com.baidu.location.e;

import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.baidu.location.g.j;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class h {
    public List<ScanResult> a = null;
    private long b = 0;
    private long c = 0;
    private boolean d = false;
    private boolean e;

    public h(List<ScanResult> list, long j) {
        this.b = j;
        this.a = list;
        this.c = System.currentTimeMillis();
        n();
    }

    private boolean a(String str) {
        return TextUtils.isEmpty(str) ? false : Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    private String b(String str) {
        return str != null ? (str.contains(HttpUtils.PARAMETERS_SEPARATOR) || str.contains(";")) ? str.replace(HttpUtils.PARAMETERS_SEPARATOR, "_").replace(";", "_") : str : str;
    }

    private int m() {
        return this.a == null ? 0 : this.a.size();
    }

    private void n() {
        if (m() >= 1) {
            int size = this.a.size() - 1;
            int i = 1;
            while (size >= 1 && i != 0) {
                i = 0;
                int i2 = 0;
                while (i < size) {
                    int i3 = i + 1;
                    if (((ScanResult) this.a.get(i)).level < ((ScanResult) this.a.get(i3)).level) {
                        ScanResult scanResult = (ScanResult) this.a.get(i3);
                        this.a.set(i3, this.a.get(i));
                        this.a.set(i, scanResult);
                        i2 = 1;
                    }
                    i = i3;
                }
                size--;
                i = i2;
            }
        }
    }

    public int a() {
        return this.a == null ? 0 : this.a.size();
    }

    public String a(int i) {
        return a(i, false, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f3 A:{Catch:{ Error -> 0x0217, Exception -> 0x0215 }} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ca A:{Catch:{ Error -> 0x0217, Exception -> 0x0215 }} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0203 A:{Catch:{ Error -> 0x0217, Exception -> 0x0215 }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0122 A:{Catch:{ Error -> 0x0217, Exception -> 0x0215 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008b A:{SYNTHETIC, Splitter:B:37:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x021c A:{Catch:{ Error -> 0x0217, Exception -> 0x0215 }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A:{SYNTHETIC, Splitter:B:37:0x008b, ExcHandler: Error (unused java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A:{SYNTHETIC, Splitter:B:37:0x008b, ExcHandler: Error (unused java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A:{SYNTHETIC, Splitter:B:37:0x008b, ExcHandler: Error (unused java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A:{SYNTHETIC, Splitter:B:3:0x000b, ExcHandler: Exception (unused java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c3 A:{Catch:{ Error -> 0x0217, Exception -> 0x0215 }} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ca A:{Catch:{ Error -> 0x0217, Exception -> 0x0215 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f3 A:{Catch:{ Error -> 0x0217, Exception -> 0x0215 }} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0122 A:{Catch:{ Error -> 0x0217, Exception -> 0x0215 }} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0203 A:{Catch:{ Error -> 0x0217, Exception -> 0x0215 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:17:0x005c, code skipped:
            r11 = 0;
     */
    /* JADX WARNING: Missing block: B:47:0x00b4, code skipped:
            r22 = r5;
     */
    /* JADX WARNING: Missing block: B:108:0x0216, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:111:0x0218, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:149:0x0317, code skipped:
            return null;
     */
    @android.annotation.SuppressLint({"NewApi"})
    public java.lang.String a(int r32, boolean r33, boolean r34) {
        /*
        r31 = this;
        r0 = r31;
        r2 = r31.a();
        r3 = 0;
        r4 = 1;
        if (r2 >= r4) goto L_0x000b;
    L_0x000a:
        return r3;
    L_0x000b:
        r2 = new java.util.Random;	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r2.<init>();	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r5 = new java.lang.StringBuffer;	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r6 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        r5.<init>(r6);	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r6 = new java.util.ArrayList;	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r6.<init>();	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r7 = com.baidu.location.e.i.a();	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r7 = r7.l();	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        if (r7 == 0) goto L_0x0048;
    L_0x0026:
        r9 = r7.getBSSID();	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        if (r9 == 0) goto L_0x0048;
    L_0x002c:
        r9 = r7.getBSSID();	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r10 = ":";
        r11 = "";
        r9 = r9.replace(r10, r11);	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r7 = r7.getRssi();	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r10 = com.baidu.location.e.i.a();	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r10 = r10.n();	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        if (r7 >= 0) goto L_0x004b;
    L_0x0046:
        r7 = -r7;
        goto L_0x004b;
    L_0x0048:
        r9 = r3;
        r10 = r9;
        r7 = -1;
    L_0x004b:
        r11 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r12 = 17;
        r13 = 0;
        if (r11 < r12) goto L_0x0068;
    L_0x0053:
        r11 = android.os.SystemClock.elapsedRealtimeNanos();	 Catch:{ Error -> 0x005c, Exception -> 0x0316 }
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = r11 / r16;
        goto L_0x005d;
    L_0x005c:
        r11 = r13;
    L_0x005d:
        r16 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
        if (r16 <= 0) goto L_0x0065;
    L_0x0061:
        r16 = r11;
        r11 = r4;
        goto L_0x006b;
    L_0x0065:
        r16 = r11;
        goto L_0x006a;
    L_0x0068:
        r16 = r13;
    L_0x006a:
        r11 = 0;
    L_0x006b:
        if (r11 == 0) goto L_0x0074;
    L_0x006d:
        if (r11 == 0) goto L_0x0073;
    L_0x006f:
        if (r33 == 0) goto L_0x0073;
    L_0x0071:
        r11 = r4;
        goto L_0x0074;
    L_0x0073:
        r11 = 0;
    L_0x0074:
        r12 = r0.a;	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r12 = r12.size();	 Catch:{ Error -> 0x0318, Exception -> 0x0316 }
        r3 = r32;
        if (r12 <= r3) goto L_0x007f;
    L_0x007e:
        r12 = r3;
    L_0x007f:
        r18 = r4;
        r19 = r13;
        r3 = 0;
        r8 = 0;
        r13 = 0;
        r14 = 0;
        r21 = 0;
    L_0x0089:
        if (r3 >= r12) goto L_0x0219;
    L_0x008b:
        r15 = r0.a;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r15 = r15.get(r3);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r15 = (android.net.wifi.ScanResult) r15;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r15 = r15.level;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r15 != 0) goto L_0x009e;
    L_0x0097:
        r4 = r5;
        r27 = r11;
        r28 = r12;
        goto L_0x020b;
    L_0x009e:
        if (r11 == 0) goto L_0x00c4;
    L_0x00a0:
        r15 = r0.a;	 Catch:{ Exception -> 0x00b4, Error -> 0x0217 }
        r15 = r15.get(r3);	 Catch:{ Exception -> 0x00b4, Error -> 0x0217 }
        r15 = (android.net.wifi.ScanResult) r15;	 Catch:{ Exception -> 0x00b4, Error -> 0x0217 }
        r22 = r5;
        r4 = r15.timestamp;	 Catch:{ Exception -> 0x00b6, Error -> 0x0217 }
        r23 = r16 - r4;
        r4 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r4 = r23 / r4;
        goto L_0x00b8;
    L_0x00b4:
        r22 = r5;
    L_0x00b6:
        r4 = 0;
    L_0x00b8:
        r15 = java.lang.Long.valueOf(r4);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r6.add(r15);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r15 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1));
        if (r15 <= 0) goto L_0x00c6;
    L_0x00c3:
        goto L_0x00c8;
    L_0x00c4:
        r22 = r5;
    L_0x00c6:
        r4 = r19;
    L_0x00c8:
        if (r18 == 0) goto L_0x00f3;
    L_0x00ca:
        r15 = "&wf=";
        r25 = r4;
        r4 = r22;
        r4.append(r15);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r34 == 0) goto L_0x00f0;
    L_0x00d5:
        r14 = new java.lang.StringBuffer;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r14.<init>();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = "&wf_ch=";
        r14.append(r5);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r0.a;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r5.get(r3);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = (android.net.wifi.ScanResult) r5;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r5.frequency;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r0.b(r5);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r14.append(r5);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
    L_0x00f0:
        r18 = 0;
        goto L_0x0116;
    L_0x00f3:
        r25 = r4;
        r4 = r22;
        r5 = "|";
        r4.append(r5);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r34 == 0) goto L_0x0116;
    L_0x00fe:
        if (r14 == 0) goto L_0x0116;
    L_0x0100:
        r5 = "|";
        r14.append(r5);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r0.a;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r5.get(r3);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = (android.net.wifi.ScanResult) r5;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r5.frequency;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r0.b(r5);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r14.append(r5);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
    L_0x0116:
        r5 = r0.a;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r5.get(r3);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = (android.net.wifi.ScanResult) r5;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r5.BSSID;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r5 == 0) goto L_0x0203;
    L_0x0122:
        r15 = ":";
        r1 = "";
        r1 = r5.replace(r15, r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r0.a;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r5.get(r3);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = (android.net.wifi.ScanResult) r5;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r5.level;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r5 >= 0) goto L_0x013a;
    L_0x0139:
        r5 = -r5;
    L_0x013a:
        r15 = java.util.Locale.CHINA;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r27 = r11;
        r11 = ";%d;";
        r28 = r12;
        r29 = r14;
        r12 = 1;
        r14 = new java.lang.Object[r12];	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r12 = 0;
        r14[r12] = r5;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = java.lang.String.format(r15, r11, r14);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r5);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r21 + 1;
        if (r9 == 0) goto L_0x0172;
    L_0x0159:
        r1 = r9.equals(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r1 == 0) goto L_0x0172;
    L_0x015f:
        r1 = r0.a;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r1.get(r3);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = (android.net.wifi.ScanResult) r1;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r1.capabilities;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r0.a(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r0.e = r1;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r13 = r5;
        r1 = 1;
        goto L_0x0173;
    L_0x0172:
        r1 = 0;
    L_0x0173:
        if (r1 != 0) goto L_0x01f1;
    L_0x0175:
        r1 = 30;
        r11 = 2;
        if (r8 != 0) goto L_0x01b1;
    L_0x017a:
        r12 = 10;
        r12 = r2.nextInt(r12);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        if (r12 != r11) goto L_0x01ea;
    L_0x0182:
        r11 = r0.a;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r11 = r11.get(r3);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r11 = (android.net.wifi.ScanResult) r11;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r11 = r11.SSID;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        if (r11 == 0) goto L_0x01ea;
    L_0x018e:
        r11 = r0.a;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r11 = r11.get(r3);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r11 = (android.net.wifi.ScanResult) r11;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r11 = r11.SSID;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r11 = r11.length();	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        if (r11 >= r1) goto L_0x01ea;
    L_0x019e:
        r1 = r0.a;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r1 = r1.get(r3);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r1 = (android.net.wifi.ScanResult) r1;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r1 = r1.SSID;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r1 = r0.b(r1);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r4.append(r1);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r8 = 1;
        goto L_0x01ea;
    L_0x01b1:
        r12 = 1;
        if (r8 != r12) goto L_0x01ea;
    L_0x01b4:
        r14 = 20;
        r14 = r2.nextInt(r14);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        if (r14 != r12) goto L_0x01ea;
    L_0x01bc:
        r12 = r0.a;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r12 = r12.get(r3);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r12 = (android.net.wifi.ScanResult) r12;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r12 = r12.SSID;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        if (r12 == 0) goto L_0x01ea;
    L_0x01c8:
        r12 = r0.a;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r12 = r12.get(r3);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r12 = (android.net.wifi.ScanResult) r12;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r12 = r12.SSID;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r12 = r12.length();	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        if (r12 >= r1) goto L_0x01ea;
    L_0x01d8:
        r1 = r0.a;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r1 = r1.get(r3);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r1 = (android.net.wifi.ScanResult) r1;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r1 = r1.SSID;	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r1 = r0.b(r1);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r4.append(r1);	 Catch:{ Exception -> 0x01ea, Error -> 0x0217 }
        r8 = r11;
    L_0x01ea:
        r21 = r5;
        r19 = r25;
        r14 = r29;
        goto L_0x020b;
    L_0x01f1:
        r1 = r0.a;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r1.get(r3);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = (android.net.wifi.ScanResult) r1;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r1.SSID;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r0.b(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        goto L_0x01ea;
    L_0x0203:
        r27 = r11;
        r28 = r12;
        r29 = r14;
        r19 = r25;
    L_0x020b:
        r3 = r3 + 1;
        r5 = r4;
        r11 = r27;
        r12 = r28;
        r4 = 1;
        goto L_0x0089;
    L_0x0215:
        r1 = 0;
        return r1;
    L_0x0217:
        r1 = 0;
        return r1;
    L_0x0219:
        r4 = r5;
        if (r18 != 0) goto L_0x0314;
    L_0x021c:
        r1 = new java.lang.StringBuilder;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1.<init>();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r2 = "&wf_n=";
        r1.append(r2);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1.append(r13);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r1.toString();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r9 == 0) goto L_0x0249;
    L_0x0232:
        r1 = -1;
        if (r7 == r1) goto L_0x0249;
    L_0x0235:
        r1 = new java.lang.StringBuilder;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1.<init>();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r2 = "&wf_rs=";
        r1.append(r2);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1.append(r7);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r1.toString();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
    L_0x0249:
        r1 = 10;
        r3 = (r19 > r1 ? 1 : (r19 == r1 ? 0 : -1));
        if (r3 <= 0) goto L_0x02cf;
    L_0x024f:
        r1 = r6.size();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r1 <= 0) goto L_0x02cf;
    L_0x0255:
        r1 = 0;
        r2 = r6.get(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r2 = (java.lang.Long) r2;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r2.longValue();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r7 = 0;
        r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1));
        if (r3 <= 0) goto L_0x02cf;
    L_0x0266:
        r1 = new java.lang.StringBuffer;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r1.<init>(r2);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r2 = "&wf_ut=";
        r1.append(r2);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r2 = 0;
        r3 = r6.get(r2);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r3 = (java.lang.Long) r3;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r5 = r6.iterator();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r6 = 1;
    L_0x027e:
        r7 = r5.hasNext();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r7 == 0) goto L_0x02c8;
    L_0x0284:
        r7 = r5.next();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r7 = (java.lang.Long) r7;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r6 == 0) goto L_0x0299;
    L_0x028c:
        r6 = r7.longValue();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1.append(r6);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r6 = r2;
        r30 = r3;
        r7 = 0;
        goto L_0x02bf;
    L_0x0299:
        r7 = r7.longValue();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r11 = r3.longValue();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r30 = r3;
        r2 = r7 - r11;
        r7 = 0;
        r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r9 == 0) goto L_0x02bf;
    L_0x02ab:
        r9 = new java.lang.StringBuilder;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r9.<init>();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r11 = "";
        r9.append(r11);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r9.append(r2);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r2 = r9.toString();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1.append(r2);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
    L_0x02bf:
        r2 = "|";
        r1.append(r2);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r3 = r30;
        r2 = 0;
        goto L_0x027e;
    L_0x02c8:
        r1 = r1.toString();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
    L_0x02cf:
        r1 = "&wf_st=";
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r0.b;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = "&wf_et=";
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r0.c;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = "&wf_vt=";
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = com.baidu.location.e.i.a;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        if (r13 <= 0) goto L_0x02fc;
    L_0x02ef:
        r1 = 1;
        r0.d = r1;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = "&wf_en=";
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r1 = r0.e;	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
    L_0x02fc:
        if (r10 == 0) goto L_0x0306;
    L_0x02fe:
        r1 = "&wf_gw=";
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r10);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
    L_0x0306:
        if (r14 == 0) goto L_0x030f;
    L_0x0308:
        r1 = r14.toString();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        r4.append(r1);	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
    L_0x030f:
        r1 = r4.toString();	 Catch:{ Error -> 0x0217, Exception -> 0x0215 }
        return r1;
    L_0x0314:
        r1 = 0;
        return r1;
    L_0x0316:
        r1 = r3;
        return r1;
    L_0x0318:
        r1 = r3;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.h.a(int, boolean, boolean):java.lang.String");
    }

    public boolean a(long j) {
        long elapsedRealtimeNanos;
        boolean z;
        if (VERSION.SDK_INT >= 17) {
            try {
                elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error | Exception unused) {
                elapsedRealtimeNanos = 0;
            }
            z = elapsedRealtimeNanos > 0;
        } else {
            z = false;
            elapsedRealtimeNanos = 0;
        }
        if (!z || this.a == null || this.a.size() == 0) {
            return false;
        }
        int size = this.a.size();
        if (size > 16) {
            size = 16;
        }
        long j2 = 0;
        long j3 = j2;
        for (int i = 0; i < size; i++) {
            if (((ScanResult) this.a.get(i)).level != 0 && z) {
                long j4;
                try {
                    j4 = (elapsedRealtimeNanos - ((ScanResult) this.a.get(i)).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j4 = 0;
                }
                long j5 = j2 + j4;
                if (j4 > j3) {
                    j3 = j4;
                }
                j2 = j5;
            }
        }
        return j3 * 1000 > j || (j2 / ((long) size)) * 1000 > j;
    }

    public boolean a(h hVar) {
        if (this.a == null || hVar == null || hVar.a == null) {
            return false;
        }
        int size = (this.a.size() < hVar.a.size() ? this.a : hVar.a).size();
        for (int i = 0; i < size; i++) {
            if (!((ScanResult) this.a.get(i)).BSSID.equals(((ScanResult) hVar.a.get(i)).BSSID)) {
                return false;
            }
        }
        return true;
    }

    public int b(int i) {
        return (i <= 2400 || i >= 2500) ? (i <= 4900 || i >= 5900) ? 0 : 5 : 2;
    }

    public String b() {
        try {
            return a(j.O, true, true);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean b(h hVar) {
        if (this.a == null || hVar == null || hVar.a == null) {
            return false;
        }
        int size = (this.a.size() < hVar.a.size() ? this.a : hVar.a).size();
        for (int i = 0; i < size; i++) {
            String str = ((ScanResult) this.a.get(i)).BSSID;
            int i2 = ((ScanResult) this.a.get(i)).level;
            String str2 = ((ScanResult) hVar.a.get(i)).BSSID;
            int i3 = ((ScanResult) hVar.a.get(i)).level;
            if (!str.equals(str2) || i2 != i3) {
                return false;
            }
        }
        return true;
    }

    public String c() {
        try {
            return a(j.O, true, false);
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(int i) {
        if (a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = this.a.size();
        if (size <= i) {
            i = size;
        }
        int i2 = 1;
        int i3 = 0;
        while (i3 < i) {
            if (!(((ScanResult) this.a.get(i3)).level == 0 || ((ScanResult) this.a.get(i3)).BSSID == null)) {
                if (i2 != 0) {
                    i2 = 0;
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(((ScanResult) this.a.get(i3)).BSSID.replace(":", ""));
                int i4 = ((ScanResult) this.a.get(i3)).level;
                if (i4 < 0) {
                    i4 = -i4;
                }
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(i4)}));
            }
            i3++;
        }
        return i2 == 0 ? stringBuffer.toString() : null;
    }

    public boolean c(h hVar) {
        return i.a(hVar, this);
    }

    public String d() {
        try {
            return a(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public String d(int i) {
        if (i != 0) {
            int i2 = 1;
            if (a() >= 1) {
                StringBuffer stringBuffer = new StringBuffer(256);
                int size = this.a.size();
                if (size > j.O) {
                    size = j.O;
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < size) {
                    if (!((i2 & i) == 0 || ((ScanResult) this.a.get(i3)).BSSID == null)) {
                        stringBuffer.append(i4 == 0 ? "&ssid=" : "|");
                        stringBuffer.append(((ScanResult) this.a.get(i3)).BSSID.replace(":", ""));
                        stringBuffer.append(";");
                        stringBuffer.append(b(((ScanResult) this.a.get(i3)).SSID));
                        i4++;
                    }
                    i2 <<= 1;
                    i3++;
                }
                return stringBuffer.toString();
            }
        }
        return null;
    }

    public boolean e() {
        return a((long) j.af);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0035  */
    @android.annotation.SuppressLint({"NewApi"})
    public long f() {
        /*
        r13 = this;
        r0 = r13.a;
        r1 = 0;
        if (r0 == 0) goto L_0x0060;
    L_0x0006:
        r0 = r13.a;
        r0 = r0.size();
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return r1;
    L_0x000f:
        r0 = android.os.Build.VERSION.SDK_INT;
        r3 = 17;
        r4 = 0;
        if (r0 < r3) goto L_0x0025;
    L_0x0016:
        r5 = android.os.SystemClock.elapsedRealtimeNanos();	 Catch:{ Error | Exception -> 0x001e, Error | Exception -> 0x001e }
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = r5 / r7;
        goto L_0x001f;
    L_0x001e:
        r5 = r1;
    L_0x001f:
        r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0026;
    L_0x0023:
        r0 = 1;
        goto L_0x0027;
    L_0x0025:
        r5 = r1;
    L_0x0026:
        r0 = r4;
    L_0x0027:
        r3 = r13.a;
        r3 = r3.size();
        r7 = 16;
        if (r3 <= r7) goto L_0x0032;
    L_0x0031:
        r3 = r7;
    L_0x0032:
        r7 = r1;
    L_0x0033:
        if (r4 >= r3) goto L_0x005f;
    L_0x0035:
        r9 = r13.a;
        r9 = r9.get(r4);
        r9 = (android.net.wifi.ScanResult) r9;
        r9 = r9.level;
        if (r9 != 0) goto L_0x0042;
    L_0x0041:
        goto L_0x005c;
    L_0x0042:
        if (r0 == 0) goto L_0x005c;
    L_0x0044:
        r9 = r13.a;	 Catch:{ Error | Exception -> 0x0056, Error | Exception -> 0x0056 }
        r9 = r9.get(r4);	 Catch:{ Error | Exception -> 0x0056, Error | Exception -> 0x0056 }
        r9 = (android.net.wifi.ScanResult) r9;	 Catch:{ Error | Exception -> 0x0056, Error | Exception -> 0x0056 }
        r9 = r9.timestamp;	 Catch:{ Error | Exception -> 0x0056, Error | Exception -> 0x0056 }
        r11 = r5 - r9;
        r9 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r9 = r11 / r9;
        goto L_0x0057;
    L_0x0056:
        r9 = r1;
    L_0x0057:
        r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r11 <= 0) goto L_0x005c;
    L_0x005b:
        r7 = r9;
    L_0x005c:
        r4 = r4 + 1;
        goto L_0x0033;
    L_0x005f:
        return r7;
    L_0x0060:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.h.f():long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    @android.annotation.SuppressLint({"NewApi"})
    public long g() {
        /*
        r18 = this;
        r0 = r18;
        r1 = r0.a;
        r2 = 0;
        if (r1 == 0) goto L_0x007b;
    L_0x0008:
        r1 = r0.a;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0012;
    L_0x0010:
        goto L_0x007b;
    L_0x0012:
        r1 = android.os.Build.VERSION.SDK_INT;
        r4 = 17;
        r5 = 0;
        if (r1 < r4) goto L_0x0028;
    L_0x0019:
        r6 = android.os.SystemClock.elapsedRealtimeNanos();	 Catch:{ Error | Exception -> 0x0021, Error | Exception -> 0x0021 }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r8;
        goto L_0x0022;
    L_0x0021:
        r6 = r2;
    L_0x0022:
        r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r1 <= 0) goto L_0x0029;
    L_0x0026:
        r1 = 1;
        goto L_0x002a;
    L_0x0028:
        r6 = r2;
    L_0x0029:
        r1 = r5;
    L_0x002a:
        r4 = r0.a;
        r4 = r4.size();
        r8 = 16;
        if (r4 <= r8) goto L_0x0035;
    L_0x0034:
        r4 = r8;
    L_0x0035:
        r8 = r2;
        r10 = r8;
        r12 = r10;
    L_0x0038:
        r14 = 1;
        if (r5 >= r4) goto L_0x0070;
    L_0x003c:
        r2 = r0.a;
        r2 = r2.get(r5);
        r2 = (android.net.wifi.ScanResult) r2;
        r2 = r2.level;
        if (r2 != 0) goto L_0x0049;
    L_0x0048:
        goto L_0x006b;
    L_0x0049:
        if (r1 == 0) goto L_0x006b;
    L_0x004b:
        r2 = r0.a;	 Catch:{ Error | Exception -> 0x005d, Error | Exception -> 0x005d }
        r2 = r2.get(r5);	 Catch:{ Error | Exception -> 0x005d, Error | Exception -> 0x005d }
        r2 = (android.net.wifi.ScanResult) r2;	 Catch:{ Error | Exception -> 0x005d, Error | Exception -> 0x005d }
        r2 = r2.timestamp;	 Catch:{ Error | Exception -> 0x005d, Error | Exception -> 0x005d }
        r16 = r6 - r2;
        r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r2 = r16 / r2;
        goto L_0x005f;
    L_0x005d:
        r2 = 0;
    L_0x005f:
        r16 = r10 + r2;
        r10 = r8 + r14;
        r8 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r8 <= 0) goto L_0x0068;
    L_0x0067:
        r12 = r2;
    L_0x0068:
        r8 = r10;
        r10 = r16;
    L_0x006b:
        r5 = r5 + 1;
        r2 = 0;
        goto L_0x0038;
    L_0x0070:
        r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r1 <= 0) goto L_0x007a;
    L_0x0074:
        r1 = r10 - r12;
        r3 = r8 - r14;
        r12 = r1 / r3;
    L_0x007a:
        return r12;
    L_0x007b:
        r1 = r2;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.h.g():long");
    }

    public int h() {
        for (int i = 0; i < a(); i++) {
            int i2 = -((ScanResult) this.a.get(i)).level;
            if (i2 > 0) {
                return i2;
            }
        }
        return 0;
    }

    public boolean i() {
        return this.d;
    }

    public boolean j() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean k() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean l() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.b < 5000;
    }
}
