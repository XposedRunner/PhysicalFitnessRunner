package com.loc;

import android.content.Context;
import android.net.wifi.ScanResult;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* compiled from: CoManager */
public final class O0OO0Oo {
    boolean O000000o = false;
    boolean O00000Oo = false;
    private Object O00000o = null;
    private Context O00000o0;
    private int O00000oO = -1;
    private boolean O00000oo = false;

    public O0OO0Oo(Context context) {
        this.O00000o0 = context;
    }

    private static String O000000o(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sv", "4.6.0");
            jSONObject.put("als", "S128DF1572465B890OE3F7A13167KLEI");
            jSONObject.put("pn", OO00o00.O00000o0(context));
            jSONObject.put("ak", OO00o00.O00000oo(context));
            jSONObject.put("ud", OO0O0o0.O0000OOo(context));
            jSONObject.put("au", OO0O0o0.O00000Oo(context));
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String O000000o(O0Oo0o0 o0Oo0o0) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (o0Oo0o0 != null) {
                O0OO0O O00000o0 = o0Oo0o0.O00000o0();
                O0OO0O O00000o = o0Oo0o0.O00000o();
                if (O00000o0 != null) {
                    jSONObject.put("mainCgi", O00000o0.O000000o());
                }
                if (O00000o != null) {
                    jSONObject.put("mainCgi2", O00000o.O000000o());
                }
                return jSONObject.toString();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "APSCoManager", "buildCgiJsonStr");
        }
        return null;
    }

    private void O000000o(O0Oo0o0 o0Oo0o0, List<ScanResult> list, AMapLocationServer aMapLocationServer, int i) {
        try {
            if (O00000oO() && OO000OO.O000000o(aMapLocationServer)) {
                O00000oo();
                if (this.O00000o != null) {
                    String O000000o = O000000o(o0Oo0o0);
                    ScanResult[] O000000o2 = O000000o((List) list);
                    if (i == 1) {
                        O0o.O000000o(this.O00000o, "trainingFps", new Class[]{String.class, ScanResult[].class}, new Object[]{O000000o, O000000o2});
                    } else if (i == 2) {
                        O0o.O000000o(this.O00000o, "correctOfflineLocation", new Class[]{String.class, ScanResult[].class, Double.TYPE, Double.TYPE}, new Object[]{O000000o, O000000o2, Double.valueOf(aMapLocationServer.getLatitude()), Double.valueOf(aMapLocationServer.getLongitude())});
                    }
                    this.O00000Oo = true;
                }
            }
        } catch (Throwable th) {
            String str = "APSCoManager";
            StringBuilder stringBuilder = new StringBuilder("action-");
            stringBuilder.append(1 == i ? "training" : "correct");
            O0o0000.O000000o(th, str, stringBuilder.toString());
        }
    }

    private static void O000000o(String str, String str2, String str3) {
        StringBuilder stringBuilder;
        if (!str2.endsWith(File.separator)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(File.separator);
            str2 = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        str3 = stringBuilder.toString();
        OO000OO.O00000oO(str2);
        OO000OO.O00000Oo(str, str3);
    }

    public static boolean O000000o() {
        try {
            Class.forName("com.amap.opensdk.co.CoManager");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static ScanResult[] O000000o(List<ScanResult> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    ScanResult[] scanResultArr = new ScanResult[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        scanResultArr[i] = (ScanResult) list.get(i);
                    }
                    return scanResultArr;
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "APSCoManager", "buildScanResults");
            }
        }
        return null;
    }

    private boolean O00000oO() {
        if (!OoO0o.O000O0Oo()) {
            O00000o();
            return false;
        } else if (OoO0o.O00oOoOo()) {
            return true;
        } else {
            if (this.O00000Oo) {
                try {
                    if (this.O00000o != null) {
                        O0o.O000000o(this.O00000o, "destroyOfflineLoc", new Object[0]);
                    }
                } catch (Throwable th) {
                    O0o0000.O000000o(th, "APSCoManager", "destroyOffline");
                }
                this.O00000Oo = false;
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc A:{Catch:{ Throwable -> 0x00e2, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cb A:{Catch:{ Throwable -> 0x00e2, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f6 A:{Catch:{ Throwable -> 0x00e2, Throwable -> 0x01a8 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00c7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x01a8 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:14:0x005f, B:55:0x01a8, B:59:0x01ae] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:16:0x007e, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:18:?, code skipped:
            com.loc.O0o0000.O000000o(r1, "APSCoManager", "initForJar");
     */
    /* JADX WARNING: Missing block: B:63:0x01c9, code skipped:
            r14.O00000oo = true;
     */
    /* JADX WARNING: Missing block: B:77:0x01f4, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:78:0x01f5, code skipped:
            com.loc.O0o0000.O000000o(r0, "APSCoManager", "init");
     */
    /* JADX WARNING: Missing block: B:79:0x01fc, code skipped:
            return;
     */
    private void O00000oo() {
        /*
        r14 = this;
        r0 = 1;
        r1 = new java.lang.Object[r0];
        r2 = "CoManager ==> init ";
        r3 = 0;
        r1[r3] = r2;
        com.loc.OO000OO.O000000o();
        r1 = r14.O00000o;	 Catch:{ Throwable -> 0x01f4 }
        if (r1 != 0) goto L_0x01cc;
    L_0x000f:
        r1 = r14.O00000o0;	 Catch:{ Throwable -> 0x01f4 }
        r2 = "pref";
        r4 = "ok5";
        r1 = com.loc.OO0000o.O00000Oo(r1, r2, r4, r3);	 Catch:{ Throwable -> 0x01f4 }
        r2 = r14.O00000o0;	 Catch:{ Throwable -> 0x01f4 }
        r4 = "pref";
        r5 = "ok7";
        r6 = 0;
        r4 = com.loc.OO0000o.O00000Oo(r2, r4, r5, r6);	 Catch:{ Throwable -> 0x01f4 }
        if (r1 == 0) goto L_0x0039;
    L_0x0027:
        r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r2 == 0) goto L_0x0039;
    L_0x002b:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x01f4 }
        r10 = r8 - r4;
        r4 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0039;
    L_0x0038:
        return;
    L_0x0039:
        r2 = r14.O00000o0;	 Catch:{ Throwable -> 0x01f4 }
        r4 = "pref";
        r5 = "ok5";
        r1 = r1 + r0;
        com.loc.OO0000o.O000000o(r2, r4, r5, r1);	 Catch:{ Throwable -> 0x01f4 }
        r1 = r14.O00000o0;	 Catch:{ Throwable -> 0x01f4 }
        r2 = "pref";
        r4 = "ok7";
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x01f4 }
        com.loc.OO0000o.O000000o(r1, r2, r4, r8);	 Catch:{ Throwable -> 0x01f4 }
        r1 = O000000o();	 Catch:{ Throwable -> 0x01f4 }
        if (r1 == 0) goto L_0x0088;
    L_0x0056:
        r1 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x01f4 }
        r2 = "CoManager ==> initForJar ";
        r1[r3] = r2;	 Catch:{ Throwable -> 0x01f4 }
        com.loc.OO000OO.O000000o();	 Catch:{ Throwable -> 0x01f4 }
        r1 = "com.amap.opensdk.co.CoManager";
        r2 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x007e }
        r4 = android.content.Context.class;
        r2[r3] = r4;	 Catch:{ Throwable -> 0x007e }
        r4 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x007e }
        r5 = r14.O00000o0;	 Catch:{ Throwable -> 0x007e }
        r4[r3] = r5;	 Catch:{ Throwable -> 0x007e }
        r1 = com.loc.O0o.O000000o(r1, r2, r4);	 Catch:{ Throwable -> 0x007e }
        r14.O00000o = r1;	 Catch:{ Throwable -> 0x007e }
        r1 = r14.O00000o;	 Catch:{ Throwable -> 0x007e }
        r2 = "loadLocalSo";
        r4 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x007e }
        com.loc.O0o.O000000o(r1, r2, r4);	 Catch:{ Throwable -> 0x007e }
        goto L_0x01b6;
    L_0x007e:
        r1 = move-exception;
        r2 = "APSCoManager";
        r4 = "initForJar";
        com.loc.O0o0000.O000000o(r1, r2, r4);	 Catch:{ Throwable -> 0x01f4 }
        goto L_0x01b6;
    L_0x0088:
        r1 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x01f4 }
        r2 = "CoManager ==> initForDex ";
        r1[r3] = r2;	 Catch:{ Throwable -> 0x01f4 }
        com.loc.OO000OO.O000000o();	 Catch:{ Throwable -> 0x01f4 }
        r1 = r14.O00000oo;	 Catch:{ Throwable -> 0x01ad }
        if (r1 != 0) goto L_0x01a8;
    L_0x0095:
        r1 = com.loc.OoO0o.O000O0oO();	 Catch:{ Throwable -> 0x01ad }
        if (r1 == 0) goto L_0x01a8;
    L_0x009b:
        r1 = "co";
        r2 = "1.0.0";
        r1 = com.loc.O0o0000.O000000o(r1, r2);	 Catch:{ Throwable -> 0x01ad }
        r2 = r14.O00000o0;	 Catch:{ Throwable -> 0x01ad }
        r2 = com.loc.ooO0Ooo.O000000o(r2, r1);	 Catch:{ Throwable -> 0x01ad }
        r14.O00000oo = r2;	 Catch:{ Throwable -> 0x01ad }
        r2 = r14.O00000oo;	 Catch:{ Throwable -> 0x01ad }
        if (r2 == 0) goto L_0x01a8;
    L_0x00af:
        r8 = r14.O00000o0;	 Catch:{ Throwable -> 0x00c7 }
        r10 = "com.amap.opensdk.co.CoManager";
        r11 = 0;
        r12 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x00c7 }
        r2 = android.content.Context.class;
        r12[r3] = r2;	 Catch:{ Throwable -> 0x00c7 }
        r13 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00c7 }
        r2 = r14.O00000o0;	 Catch:{ Throwable -> 0x00c7 }
        r13[r3] = r2;	 Catch:{ Throwable -> 0x00c7 }
        r9 = r1;
        r2 = com.loc.O000OOo.O000000o(r8, r9, r10, r11, r12, r13);	 Catch:{ Throwable -> 0x00c7 }
        r14.O00000o = r2;	 Catch:{ Throwable -> 0x00c7 }
    L_0x00c7:
        r2 = r14.O00000o0;	 Catch:{ Throwable -> 0x00e2 }
        if (r2 != 0) goto L_0x00cc;
    L_0x00cb:
        goto L_0x00ea;
    L_0x00cc:
        r2 = r14.O00000o0;	 Catch:{ Throwable -> 0x00e2 }
        r2 = O000000o(r2);	 Catch:{ Throwable -> 0x00e2 }
        r4 = r14.O00000o;	 Catch:{ Throwable -> 0x00e2 }
        if (r4 == 0) goto L_0x00ea;
    L_0x00d6:
        r4 = r14.O00000o;	 Catch:{ Throwable -> 0x00e2 }
        r5 = "init";
        r8 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00e2 }
        r8[r3] = r2;	 Catch:{ Throwable -> 0x00e2 }
        com.loc.O0o.O000000o(r4, r5, r8);	 Catch:{ Throwable -> 0x00e2 }
        goto L_0x00ea;
    L_0x00e2:
        r2 = move-exception;
        r4 = "APSCoManager";
        r5 = "setConfig";
        com.loc.O0o0000.O000000o(r2, r4, r5);	 Catch:{ Throwable -> 0x01a8 }
    L_0x00ea:
        r2 = r14.O00000o0;	 Catch:{ Throwable -> 0x01a8 }
        r1 = com.loc.O000OOo.O000000o(r2, r1);	 Catch:{ Throwable -> 0x01a8 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x01a8 }
        if (r2 != 0) goto L_0x01a8;
    L_0x00f6:
        r2 = new java.lang.StringBuffer;	 Catch:{ Throwable -> 0x01a8 }
        r2.<init>();	 Catch:{ Throwable -> 0x01a8 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01a8 }
        r4.<init>();	 Catch:{ Throwable -> 0x01a8 }
        r5 = r14.O00000o0;	 Catch:{ Throwable -> 0x01a8 }
        r5 = r5.getApplicationContext();	 Catch:{ Throwable -> 0x01a8 }
        r5 = r5.getFilesDir();	 Catch:{ Throwable -> 0x01a8 }
        r5 = r5.getAbsolutePath();	 Catch:{ Throwable -> 0x01a8 }
        r4.append(r5);	 Catch:{ Throwable -> 0x01a8 }
        r5 = java.io.File.separator;	 Catch:{ Throwable -> 0x01a8 }
        r4.append(r5);	 Catch:{ Throwable -> 0x01a8 }
        r5 = "loc_cozip";
        r4.append(r5);	 Catch:{ Throwable -> 0x01a8 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x01a8 }
        r5 = java.io.File.separator;	 Catch:{ Throwable -> 0x01a8 }
        r5 = r1.lastIndexOf(r5);	 Catch:{ Throwable -> 0x01a8 }
        r5 = r5 + r0;
        r8 = ".";
        r8 = r1.lastIndexOf(r8);	 Catch:{ Throwable -> 0x01a8 }
        r5 = r1.substring(r5, r8);	 Catch:{ Throwable -> 0x01a8 }
        r8 = com.loc.OO000OO.O00000o0(r4, r5);	 Catch:{ Throwable -> 0x01a8 }
        r9 = r14.O00000o0;	 Catch:{ Throwable -> 0x01a8 }
        r10 = "pref";
        r11 = "ok4";
        r9 = com.loc.OO0000o.O00000Oo(r9, r10, r11, r3);	 Catch:{ Throwable -> 0x01a8 }
        if (r8 == 0) goto L_0x0142;
    L_0x0140:
        if (r9 == 0) goto L_0x014e;
    L_0x0142:
        r8 = r14.O00000o0;	 Catch:{ Throwable -> 0x01a8 }
        r9 = "pref";
        r10 = "ok4";
        com.loc.OO0000o.O000000o(r8, r9, r10, r3);	 Catch:{ Throwable -> 0x01a8 }
        O000000o(r1, r4, r5);	 Catch:{ Throwable -> 0x01a8 }
    L_0x014e:
        r8 = r14.O00000o0;	 Catch:{ Throwable -> 0x01a8 }
        r8 = com.loc.OO0o000.O000000o(r8);	 Catch:{ Throwable -> 0x01a8 }
        r9 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x01a8 }
        if (r9 != 0) goto L_0x01a8;
    L_0x015a:
        r2.append(r4);	 Catch:{ Throwable -> 0x01a8 }
        r9 = java.io.File.separator;	 Catch:{ Throwable -> 0x01a8 }
        r2.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r2.append(r5);	 Catch:{ Throwable -> 0x01a8 }
        r9 = java.io.File.separator;	 Catch:{ Throwable -> 0x01a8 }
        r2.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r9 = "libs";
        r2.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r9 = java.io.File.separator;	 Catch:{ Throwable -> 0x01a8 }
        r2.append(r9);	 Catch:{ Throwable -> 0x01a8 }
        r2.append(r8);	 Catch:{ Throwable -> 0x01a8 }
        r8 = java.io.File.separator;	 Catch:{ Throwable -> 0x01a8 }
        r2.append(r8);	 Catch:{ Throwable -> 0x01a8 }
        r8 = "libapssdk.so";
        r2.append(r8);	 Catch:{ Throwable -> 0x01a8 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x01a8 }
        r8 = new java.io.File;	 Catch:{ Throwable -> 0x01a8 }
        r8.<init>(r2);	 Catch:{ Throwable -> 0x01a8 }
        r9 = r8.exists();	 Catch:{ Throwable -> 0x01a8 }
        if (r9 != 0) goto L_0x0193;
    L_0x0190:
        O000000o(r1, r4, r5);	 Catch:{ Throwable -> 0x01a8 }
    L_0x0193:
        r1 = r8.exists();	 Catch:{ Throwable -> 0x01a8 }
        if (r1 == 0) goto L_0x01a8;
    L_0x0199:
        r1 = r14.O00000o;	 Catch:{ Throwable -> 0x01a8 }
        if (r1 == 0) goto L_0x01a8;
    L_0x019d:
        r1 = r14.O00000o;	 Catch:{ Throwable -> 0x01a8 }
        r4 = "loadSo";
        r5 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x01a8 }
        r5[r3] = r2;	 Catch:{ Throwable -> 0x01a8 }
        com.loc.O0o.O000000o(r1, r4, r5);	 Catch:{ Throwable -> 0x01a8 }
    L_0x01a8:
        r14.O00000oo = r0;	 Catch:{ Throwable -> 0x01f4 }
        goto L_0x01b6;
    L_0x01ab:
        r1 = move-exception;
        goto L_0x01c9;
    L_0x01ad:
        r1 = move-exception;
        r2 = "APSCoManager";
        r4 = "initForDex";
        com.loc.O0o0000.O000000o(r1, r2, r4);	 Catch:{ all -> 0x01ab }
        goto L_0x01a8;
    L_0x01b6:
        r1 = r14.O00000o0;	 Catch:{ Throwable -> 0x01f4 }
        r2 = "pref";
        r4 = "ok5";
        com.loc.OO0000o.O000000o(r1, r2, r4, r3);	 Catch:{ Throwable -> 0x01f4 }
        r1 = r14.O00000o0;	 Catch:{ Throwable -> 0x01f4 }
        r2 = "pref";
        r4 = "ok7";
        com.loc.OO0000o.O000000o(r1, r2, r4, r6);	 Catch:{ Throwable -> 0x01f4 }
        goto L_0x01cc;
    L_0x01c9:
        r14.O00000oo = r0;	 Catch:{ Throwable -> 0x01f4 }
        throw r1;	 Catch:{ Throwable -> 0x01f4 }
    L_0x01cc:
        r1 = com.loc.OoO0o.O000O0o();	 Catch:{ Throwable -> 0x01eb }
        r2 = r14.O00000oO;	 Catch:{ Throwable -> 0x01eb }
        if (r2 != r1) goto L_0x01d5;
    L_0x01d4:
        return;
    L_0x01d5:
        r14.O00000oO = r1;	 Catch:{ Throwable -> 0x01eb }
        r2 = r14.O00000o;	 Catch:{ Throwable -> 0x01eb }
        if (r2 == 0) goto L_0x01ea;
    L_0x01db:
        r2 = r14.O00000o;	 Catch:{ Throwable -> 0x01eb }
        r4 = "setCloudConfigVersion";
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x01eb }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x01eb }
        r0[r3] = r1;	 Catch:{ Throwable -> 0x01eb }
        com.loc.O0o.O000000o(r2, r4, r0);	 Catch:{ Throwable -> 0x01eb }
    L_0x01ea:
        return;
    L_0x01eb:
        r0 = move-exception;
        r1 = "APSCoManager";
        r2 = "setCloudVersion";
        com.loc.O0o0000.O000000o(r0, r1, r2);	 Catch:{ Throwable -> 0x01f4 }
        return;
    L_0x01f4:
        r0 = move-exception;
        r1 = "APSCoManager";
        r2 = "init";
        com.loc.O0o0000.O000000o(r0, r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0OO0Oo.O00000oo():void");
    }

    public final AMapLocationServer O000000o(O0Oo0o0 o0Oo0o0, List<ScanResult> list, AMapLocationServer aMapLocationServer) {
        try {
            if (!O00000oO()) {
                return aMapLocationServer;
            }
            if (aMapLocationServer != null && aMapLocationServer.getErrorCode() == 7) {
                return aMapLocationServer;
            }
            O00000oo();
            if (this.O00000o != null) {
                this.O00000Oo = true;
                String O000000o = O000000o(o0Oo0o0);
                ScanResult[] O000000o2 = O000000o((List) list);
                Object O000000o3 = O0o.O000000o(this.O00000o, "getOfflineLoc", new Class[]{String.class, ScanResult[].class, Boolean.TYPE}, new Object[]{O000000o, O000000o2, Boolean.valueOf(false)});
                if (O000000o3 != null) {
                    JSONObject jSONObject = new JSONObject((String) O000000o3);
                    AMapLocationServer aMapLocationServer2 = new AMapLocationServer("lbs");
                    aMapLocationServer2.b(jSONObject);
                    if (OO000OO.O000000o(aMapLocationServer2)) {
                        String str;
                        StringBuffer stringBuffer = new StringBuffer();
                        if (aMapLocationServer2.e().equals("file")) {
                            str = "基站离线定位";
                        } else if (aMapLocationServer2.e().equals("wifioff")) {
                            str = "WIFI离线定位";
                        } else {
                            stringBuffer.append("离线定位，");
                            str = aMapLocationServer2.e();
                        }
                        stringBuffer.append(str);
                        if (aMapLocationServer != null) {
                            StringBuilder stringBuilder = new StringBuilder("，在线定位失败原因:");
                            stringBuilder.append(aMapLocationServer.getErrorInfo());
                            stringBuffer.append(stringBuilder.toString());
                        }
                        aMapLocationServer2.setTrustedLevel(2);
                        aMapLocationServer2.setLocationDetail(stringBuffer.toString());
                        aMapLocationServer2.setLocationType(8);
                    }
                    return aMapLocationServer2;
                }
            }
            return aMapLocationServer;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "APSCoManager", "getOffLoc");
        }
    }

    public final void O00000Oo() {
        try {
            if (!OoO0o.O000O0Oo()) {
                O00000o();
            } else if (!OoO0o.O000O0o0()) {
                if (this.O000000o) {
                    if (this.O00000o != null) {
                        O0o.O000000o(this.O00000o, "destroyCollect", new Object[0]);
                    }
                    this.O000000o = false;
                }
            } else if (!this.O000000o) {
                O00000oo();
                if (this.O00000o != null) {
                    O0o.O000000o(this.O00000o, "startCollect", new Object[0]);
                    this.O000000o = true;
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "APSCoManager", "startCollection");
        }
    }

    public final void O00000Oo(O0Oo0o0 o0Oo0o0, List<ScanResult> list, AMapLocationServer aMapLocationServer) {
        try {
            O000000o(o0Oo0o0, list, aMapLocationServer, 1);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "APSCoManager", "trainingFps");
        }
    }

    public final void O00000o() {
        try {
            if (this.O00000o != null) {
                O0o.O000000o(this.O00000o, "destroy", new Object[0]);
            }
            this.O000000o = false;
            this.O00000Oo = false;
            this.O00000o = null;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "APSCoManager", "destroy");
        }
    }

    public final String O00000o0() {
        try {
            if (OoO0o.O000O0Oo()) {
                if (this.O00000o != null) {
                    return (String) O0o.O000000o(this.O00000o, "getCollectVersion", new Object[0]);
                }
                return null;
            }
            O00000o();
            return null;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "APSCoManager", "getCollectionVersion");
        }
    }

    public final void O00000o0(O0Oo0o0 o0Oo0o0, List<ScanResult> list, AMapLocationServer aMapLocationServer) {
        try {
            O000000o(o0Oo0o0, list, aMapLocationServer, 2);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "APSCoManager", "correctOffLoc");
        }
    }
}
