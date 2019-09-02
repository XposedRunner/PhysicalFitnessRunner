package com.loc;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.loc.OO0O00o.O000000o.O00000Oo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AuthUtil */
public final class OoO0o {
    public static boolean O000000o = true;
    static boolean O00000Oo = false;
    static int O00000o = 3600000;
    static boolean O00000o0 = false;
    static long O00000oO = 0;
    static long O00000oo = 0;
    static boolean O0000O0o = false;
    static boolean O0000OOo = true;
    private static boolean O0000Oo = false;
    static boolean O0000Oo0 = false;
    private static String O0000OoO = "提示信息";
    private static String O0000Ooo = "确认";
    private static boolean O0000o = false;
    private static String O0000o0 = "";
    private static String O0000o00 = "取消";
    private static String O0000o0O = "";
    private static String O0000o0o = "";
    private static long O0000oO = 0;
    private static long O0000oO0 = 0;
    private static long O0000oOO = 5000;
    private static boolean O0000oOo = false;
    private static boolean O0000oo = false;
    private static int O0000oo0 = 0;
    private static int O0000ooO = 0;
    private static boolean O0000ooo = false;
    private static int O000O00o = 0;
    private static boolean O000O0OO = true;
    private static int O000O0Oo = 1000;
    private static int O000O0o = 20;
    private static boolean O000O0o0 = false;
    private static boolean O000O0oO = true;
    private static boolean O000O0oo = true;
    private static ArrayList<String> O000OO = new ArrayList();
    private static int O000OO00 = -1;
    private static long O000OO0o = 0;
    private static boolean O000OOOo = false;
    private static long O000OOo = 0;
    private static int O000OOo0 = -1;
    private static ArrayList<String> O000OOoO = new ArrayList();
    private static String O000OOoo = null;
    private static boolean O000Oo0 = false;
    private static String O000Oo00 = null;
    private static boolean O000Oo0O = false;
    private static int O000Oo0o = 3000;
    private static long O000OoO = 300000;
    private static int O000OoO0 = 3000;
    private static boolean O000OoOO = false;
    private static List<O0o0> O000OoOo = new ArrayList();
    private static long O000Ooo = 0;
    private static boolean O000Ooo0 = false;
    private static int O000OooO = 0;
    private static int O000Oooo = 0;
    private static boolean O000o = true;
    private static boolean O000o0 = true;
    private static boolean O000o00 = true;
    private static List<String> O000o000 = new ArrayList();
    private static int O000o00O = 80;
    private static boolean O000o00o = false;
    private static boolean O000o0O = false;
    private static boolean O000o0O0 = false;
    private static boolean O000o0OO = true;
    private static boolean O000o0Oo = false;
    private static boolean O000o0o = true;
    private static int O000o0o0 = -1;
    private static long O000o0oo = -1;
    private static long O000oO0 = 0;
    private static int O000oO00 = 1;
    private static boolean O00O0Oo = true;
    private static int O00oOoOo = 200;
    private static int O00oOooO = 3600000;
    private static int O00oOooo;

    /* compiled from: AuthUtil */
    static class O000000o {
        boolean O000000o = false;
        String O00000Oo = "0";
        int O00000o = 5;
        boolean O00000o0 = false;

        O000000o() {
        }
    }

    private static O000000o O000000o(JSONObject jSONObject, String str) {
        Throwable th;
        if (jSONObject != null) {
            O000000o o000000o;
            try {
                jSONObject = jSONObject.getJSONObject(str);
                if (jSONObject != null) {
                    o000000o = new O000000o();
                    try {
                        o000000o.O000000o = OO0O00o.O000000o(jSONObject.optString("b"), false);
                        o000000o.O00000Oo = jSONObject.optString("t");
                        o000000o.O00000o0 = OO0O00o.O000000o(jSONObject.optString("st"), false);
                        o000000o.O00000o = jSONObject.optInt("i", 0);
                        return o000000o;
                    } catch (Throwable th2) {
                        th = th2;
                        O0o0000.O000000o(th, "AuthUtil", "getLocateObj");
                        return o000000o;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                o000000o = null;
                O0o0000.O000000o(th, "AuthUtil", "getLocateObj");
                return o000000o;
            }
        }
        return null;
    }

    public static boolean O000000o() {
        return O0000oOo;
    }

    public static boolean O000000o(long j) {
        long O00000o0 = OO000OO.O00000o0();
        return O0000o && O00000o0 - O0000oO <= O0000oO0 && O00000o0 - j >= O0000oOO;
    }

    public static boolean O000000o(Context context) {
        O000O0oO = true;
        boolean z = false;
        try {
            O0000Oo = OO0000o.O00000Oo(context, "pref", "oda", false);
            com.loc.OO0O00o.O000000o O000000o = OO0O00o.O000000o(context, O0o0000.O00000Oo(), O0o0000.O00000o0(), O0000Oo);
            if (O000000o != null) {
                z = O000000o(context, O000000o);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AuthUtil", "getConfig");
        }
        O00000oo = OO000OO.O00000o0();
        O00000oO = OO000OO.O00000o0();
        return z;
    }

    public static boolean O000000o(Context context, long j) {
        if (!O000Oo0O) {
            return false;
        }
        long O00000Oo = OO000OO.O00000Oo();
        if (O00000Oo - j < ((long) O000Oo0o)) {
            return false;
        }
        if (O000OoO0 == -1) {
            return true;
        }
        if (OO000OO.O00000o0(O00000Oo, OO0000o.O00000Oo(context, "pref", "ngpsTime", 0))) {
            int O00000Oo2 = OO0000o.O00000Oo(context, "pref", "ngpsCount", 0);
            if (O00000Oo2 >= O000OoO0) {
                return false;
            }
            OO0000o.O000000o(context, "pref", "ngpsCount", O00000Oo2 + 1);
            return true;
        }
        try {
            Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("ngpsTime", O00000Oo);
            edit.putInt("ngpsCount", 0);
            OO0000o.O000000o(edit);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AuthUtil", "resetPrefsNGPS");
        }
        OO0000o.O000000o(context, "pref", "ngpsCount", 1);
        return true;
    }

    private static boolean O000000o(Context context, O00000Oo o00000Oo, String str, String str2, boolean z) {
        if (o00000Oo != null) {
            try {
                boolean z2 = o00000Oo.O000000o;
                String str3 = o00000Oo.O00000Oo;
                String str4 = o00000Oo.O00000o0;
                String str5 = o00000Oo.O00000o;
                boolean z3 = o00000Oo.O00000oO;
                OO0Oo0 O000000o = O0o0000.O000000o(str, str2);
                if (z2) {
                    if (!(!z3 || !z || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str5))) {
                        O000OOo0 o000OOo0 = new O000OOo0(str3, str4);
                        o000OOo0.O000000o(O0000Oo);
                        O000OOo.O00000Oo(context, o000OOo0, O000000o);
                    }
                } else if (ooO0Ooo.O000000o(context, O000000o)) {
                    OO0000.O000000o(context, str, "config|get dex able is false");
                }
                return z2 && z3;
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AuthUtil", "downLoadPluginDex");
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x0283 A:{Catch:{ Throwable -> 0x028b }} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0281 A:{Catch:{ Throwable -> 0x028b }} */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0502 A:{SYNTHETIC, Splitter:B:273:0x0502} */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0597 A:{Catch:{ Throwable -> 0x05b6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02d3 A:{SYNTHETIC, Splitter:B:155:0x02d3} */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0312 A:{Catch:{ Throwable -> 0x0387 }} */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x03a9 A:{Catch:{ Throwable -> 0x03b6, Throwable -> 0x0418 }} */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x03c7 A:{Catch:{ Throwable -> 0x03b6, Throwable -> 0x0418 }} */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x03ef A:{Catch:{ Throwable -> 0x03b6, Throwable -> 0x0418 }} */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0425 A:{Catch:{ Throwable -> 0x0450 }} */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x045d A:{Catch:{ Throwable -> 0x048d }} */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x049a A:{Catch:{ Throwable -> 0x04aa }} */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x04b7 A:{Catch:{ Throwable -> 0x05b6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x05c3 A:{Catch:{ Throwable -> 0x05de }} */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x05eb A:{SYNTHETIC, Splitter:B:318:0x05eb} */
    /* JADX WARNING: Removed duplicated region for block: B:347:0x06d1 A:{Catch:{ Throwable -> 0x0712 }} */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x071f A:{Catch:{ Throwable -> 0x0754 }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf A:{Catch:{ Throwable -> 0x00e7 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00ba */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf A:{Catch:{ Throwable -> 0x00e7 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00a3 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf A:{Catch:{ Throwable -> 0x00e7 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x008c */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:4|5|10|11|16|17|(1:19)|(2:26|27)|32|33|34|35|36|37|38|39|(3:43|(3:46|(1:48)(1:370)|44)|371)(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:4|5|(2:10|11)|16|17|(1:19)|(2:26|27)|32|33|34|35|36|37|38|39|(3:43|(3:46|(1:48)(1:370)|44)|371)(0)) */
    private static boolean O000000o(android.content.Context r17, com.loc.OO0O00o.O000000o r18) {
        /*
        r1 = r17;
        r2 = r18;
        r3 = 0;
        r4 = r2.O0000O0o;	 Catch:{ Throwable -> 0x00de }
        if (r4 == 0) goto L_0x00e7;
    L_0x0009:
        r5 = "at";
        r6 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r5 = r4.optInt(r5, r6);	 Catch:{ Throwable -> 0x0018 }
        r5 = r5 * 60;
        r5 = r5 * 1000;
        O00000o = r5;	 Catch:{ Throwable -> 0x0018 }
        goto L_0x0021;
    L_0x0018:
        r0 = move-exception;
        r5 = r0;
        r6 = "AuthUtil";
        r7 = "requestSdkAuthInterval";
        com.loc.O0o0000.O000000o(r5, r6, r7);	 Catch:{ Throwable -> 0x00de }
    L_0x0021:
        r5 = "ila";
        r5 = r4.optString(r5);	 Catch:{ Throwable -> 0x0030 }
        r6 = O000o00o;	 Catch:{ Throwable -> 0x0030 }
        r5 = com.loc.OO0O00o.O000000o(r5, r6);	 Catch:{ Throwable -> 0x0030 }
        O000o00o = r5;	 Catch:{ Throwable -> 0x0030 }
        goto L_0x0039;
    L_0x0030:
        r0 = move-exception;
        r5 = r0;
        r6 = "AuthUtil";
        r7 = "loadConfigData_indoor";
        com.loc.O0o0000.O000000o(r5, r6, r7);	 Catch:{ Throwable -> 0x00de }
    L_0x0039:
        r5 = "icbd";
        r5 = r4.optString(r5);	 Catch:{ Throwable -> 0x004f }
        r6 = O00000o0;	 Catch:{ Throwable -> 0x004f }
        r5 = com.loc.OO0O00o.O000000o(r5, r6);	 Catch:{ Throwable -> 0x004f }
        O00000o0 = r5;	 Catch:{ Throwable -> 0x004f }
        if (r5 == 0) goto L_0x0058;
    L_0x0049:
        r5 = "loc";
        com.loc.O000OOo.O000000o(r1, r5);	 Catch:{ Throwable -> 0x004f }
        goto L_0x0058;
    L_0x004f:
        r0 = move-exception;
        r5 = r0;
        r6 = "AuthUtil";
        r7 = "loadConfigData_CallBackDex";
        com.loc.O0o0000.O000000o(r5, r6, r7);	 Catch:{ Throwable -> 0x00de }
    L_0x0058:
        if (r1 == 0) goto L_0x007e;
    L_0x005a:
        if (r4 != 0) goto L_0x005d;
    L_0x005c:
        goto L_0x007e;
    L_0x005d:
        r5 = "re";
        r5 = r4.optString(r5);	 Catch:{ Throwable -> 0x0075 }
        r6 = O0000OOo;	 Catch:{ Throwable -> 0x0075 }
        r5 = com.loc.OO0O00o.O000000o(r5, r6);	 Catch:{ Throwable -> 0x0075 }
        O0000OOo = r5;	 Catch:{ Throwable -> 0x0075 }
        r5 = "pref";
        r6 = "fr";
        r7 = O0000OOo;	 Catch:{ Throwable -> 0x0075 }
        com.loc.OO0000o.O000000o(r1, r5, r6, r7);	 Catch:{ Throwable -> 0x0075 }
        goto L_0x007e;
    L_0x0075:
        r0 = move-exception;
        r5 = r0;
        r6 = "AuthUtil";
        r7 = "checkReLocationAble";
        com.loc.O0o0000.O000000o(r5, r6, r7);	 Catch:{ Throwable -> 0x00de }
    L_0x007e:
        r5 = "nla";
        r5 = r4.optString(r5);	 Catch:{ Throwable -> 0x008c }
        r6 = O000o0;	 Catch:{ Throwable -> 0x008c }
        r5 = com.loc.OO0O00o.O000000o(r5, r6);	 Catch:{ Throwable -> 0x008c }
        O000o0 = r5;	 Catch:{ Throwable -> 0x008c }
    L_0x008c:
        r5 = "oda";
        r5 = r4.optString(r5);	 Catch:{ Throwable -> 0x00a3 }
        r6 = O0000Oo;	 Catch:{ Throwable -> 0x00a3 }
        r5 = com.loc.OO0O00o.O000000o(r5, r6);	 Catch:{ Throwable -> 0x00a3 }
        O0000Oo = r5;	 Catch:{ Throwable -> 0x00a3 }
        r5 = "pref";
        r6 = "oda";
        r7 = O0000Oo;	 Catch:{ Throwable -> 0x00a3 }
        com.loc.OO0000o.O000000o(r1, r5, r6, r7);	 Catch:{ Throwable -> 0x00a3 }
    L_0x00a3:
        r5 = "asw";
        r5 = r4.optString(r5);	 Catch:{ Throwable -> 0x00ba }
        r6 = O000o0o;	 Catch:{ Throwable -> 0x00ba }
        r5 = com.loc.OO0O00o.O000000o(r5, r6);	 Catch:{ Throwable -> 0x00ba }
        O000o0o = r5;	 Catch:{ Throwable -> 0x00ba }
        r5 = "pref";
        r6 = "asw";
        r7 = O000o0o;	 Catch:{ Throwable -> 0x00ba }
        com.loc.OO0000o.O000000o(r1, r5, r6, r7);	 Catch:{ Throwable -> 0x00ba }
    L_0x00ba:
        r5 = "mlpl";
        r4 = r4.optJSONArray(r5);	 Catch:{ Throwable -> 0x00e7 }
        if (r4 == 0) goto L_0x00e7;
    L_0x00c2:
        r5 = r4.length();	 Catch:{ Throwable -> 0x00e7 }
        if (r5 <= 0) goto L_0x00e7;
    L_0x00c8:
        r5 = r3;
    L_0x00c9:
        r6 = r4.length();	 Catch:{ Throwable -> 0x00e7 }
        if (r5 >= r6) goto L_0x00e7;
    L_0x00cf:
        r6 = r4.getString(r5);	 Catch:{ Throwable -> 0x00e7 }
        r6 = com.loc.OO000OO.O00000o0(r1, r6);	 Catch:{ Throwable -> 0x00e7 }
        O000o0O0 = r6;	 Catch:{ Throwable -> 0x00e7 }
        if (r6 != 0) goto L_0x00e7;
    L_0x00db:
        r5 = r5 + 1;
        goto L_0x00c9;
    L_0x00de:
        r0 = move-exception;
        r4 = r0;
        r5 = "AuthUtil";
        r6 = "loadConfigAbleStatus";
        com.loc.O0o0000.O000000o(r4, r5, r6);	 Catch:{ Throwable -> 0x0756 }
    L_0x00e7:
        r4 = 0;
        r6 = -1;
        r7 = 1;
        r8 = r2.O0000OOo;	 Catch:{ Throwable -> 0x0169 }
        if (r8 == 0) goto L_0x0172;
    L_0x00ef:
        r9 = "callamapflag";
        r9 = r8.optString(r9);	 Catch:{ Throwable -> 0x0169 }
        r10 = O000O0oo;	 Catch:{ Throwable -> 0x0169 }
        r9 = com.loc.OO0O00o.O000000o(r9, r10);	 Catch:{ Throwable -> 0x0169 }
        O000O0oo = r9;	 Catch:{ Throwable -> 0x0169 }
        r9 = "co";
        r9 = r8.optString(r9);	 Catch:{ Throwable -> 0x0169 }
        r9 = com.loc.OO0O00o.O000000o(r9, r3);	 Catch:{ Throwable -> 0x0169 }
        if (r9 == 0) goto L_0x010f;
    L_0x0109:
        r9 = O000O0oo;	 Catch:{ Throwable -> 0x0169 }
        if (r9 == 0) goto L_0x010f;
    L_0x010d:
        r9 = r7;
        goto L_0x0110;
    L_0x010f:
        r9 = r3;
    L_0x0110:
        O00000Oo = r9;	 Catch:{ Throwable -> 0x0169 }
        r9 = O000O0oo;	 Catch:{ Throwable -> 0x0169 }
        if (r9 == 0) goto L_0x0172;
    L_0x0116:
        r9 = "count";
        r10 = O000OO00;	 Catch:{ Throwable -> 0x0169 }
        r9 = r8.optInt(r9, r10);	 Catch:{ Throwable -> 0x0169 }
        O000OO00 = r9;	 Catch:{ Throwable -> 0x0169 }
        r9 = "sysTime";
        r10 = O000OO0o;	 Catch:{ Throwable -> 0x0169 }
        r9 = r8.optLong(r9, r10);	 Catch:{ Throwable -> 0x0169 }
        O000OO0o = r9;	 Catch:{ Throwable -> 0x0169 }
        r9 = "sn";
        r8 = r8.optJSONArray(r9);	 Catch:{ Throwable -> 0x0169 }
        if (r8 == 0) goto L_0x014b;
    L_0x0132:
        r9 = r8.length();	 Catch:{ Throwable -> 0x0169 }
        if (r9 <= 0) goto L_0x014b;
    L_0x0138:
        r9 = r3;
    L_0x0139:
        r10 = r8.length();	 Catch:{ Throwable -> 0x0169 }
        if (r9 >= r10) goto L_0x014b;
    L_0x013f:
        r10 = O000OO;	 Catch:{ Throwable -> 0x0169 }
        r11 = r8.getString(r9);	 Catch:{ Throwable -> 0x0169 }
        r10.add(r11);	 Catch:{ Throwable -> 0x0169 }
        r9 = r9 + 1;
        goto L_0x0139;
    L_0x014b:
        r8 = O000OO00;	 Catch:{ Throwable -> 0x0169 }
        if (r8 == r6) goto L_0x0172;
    L_0x014f:
        r8 = O000OO0o;	 Catch:{ Throwable -> 0x0169 }
        r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r10 == 0) goto L_0x0172;
    L_0x0155:
        r8 = "pref";
        r9 = "nowtime";
        r8 = com.loc.OO0000o.O00000Oo(r1, r8, r9, r4);	 Catch:{ Throwable -> 0x0169 }
        r10 = O000OO0o;	 Catch:{ Throwable -> 0x0169 }
        r8 = com.loc.OO000OO.O00000Oo(r10, r8);	 Catch:{ Throwable -> 0x0169 }
        if (r8 != 0) goto L_0x0172;
    L_0x0165:
        O0000Oo0(r17);	 Catch:{ Throwable -> 0x0169 }
        goto L_0x0172;
    L_0x0169:
        r0 = move-exception;
        r8 = r0;
        r9 = "AuthUtil";
        r10 = "loadConfigDataCallAMapSer";
        com.loc.O0o0000.O000000o(r8, r9, r10);	 Catch:{ Throwable -> 0x0756 }
    L_0x0172:
        r8 = r2.O0000OoO;	 Catch:{ Throwable -> 0x01d9 }
        if (r8 == 0) goto L_0x01e2;
    L_0x0176:
        r9 = "amappushflag";
        r9 = r8.optString(r9);	 Catch:{ Throwable -> 0x01d9 }
        r10 = O000OOOo;	 Catch:{ Throwable -> 0x01d9 }
        r9 = com.loc.OO0O00o.O000000o(r9, r10);	 Catch:{ Throwable -> 0x01d9 }
        O000OOOo = r9;	 Catch:{ Throwable -> 0x01d9 }
        if (r9 == 0) goto L_0x01e2;
    L_0x0186:
        r9 = "count";
        r10 = O000OOo0;	 Catch:{ Throwable -> 0x01d9 }
        r9 = r8.optInt(r9, r10);	 Catch:{ Throwable -> 0x01d9 }
        O000OOo0 = r9;	 Catch:{ Throwable -> 0x01d9 }
        r9 = "sysTime";
        r10 = O000OOo;	 Catch:{ Throwable -> 0x01d9 }
        r9 = r8.optLong(r9, r10);	 Catch:{ Throwable -> 0x01d9 }
        O000OOo = r9;	 Catch:{ Throwable -> 0x01d9 }
        r9 = "sn";
        r8 = r8.optJSONArray(r9);	 Catch:{ Throwable -> 0x01d9 }
        if (r8 == 0) goto L_0x01bb;
    L_0x01a2:
        r9 = r8.length();	 Catch:{ Throwable -> 0x01d9 }
        if (r9 <= 0) goto L_0x01bb;
    L_0x01a8:
        r9 = r3;
    L_0x01a9:
        r10 = r8.length();	 Catch:{ Throwable -> 0x01d9 }
        if (r9 >= r10) goto L_0x01bb;
    L_0x01af:
        r10 = O000OOoO;	 Catch:{ Throwable -> 0x01d9 }
        r11 = r8.getString(r9);	 Catch:{ Throwable -> 0x01d9 }
        r10.add(r11);	 Catch:{ Throwable -> 0x01d9 }
        r9 = r9 + 1;
        goto L_0x01a9;
    L_0x01bb:
        r8 = O000OOo0;	 Catch:{ Throwable -> 0x01d9 }
        if (r8 == r6) goto L_0x01e2;
    L_0x01bf:
        r8 = O000OOo;	 Catch:{ Throwable -> 0x01d9 }
        r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r10 == 0) goto L_0x01e2;
    L_0x01c5:
        r8 = "pref";
        r9 = "pushSerTime";
        r4 = com.loc.OO0000o.O00000Oo(r1, r8, r9, r4);	 Catch:{ Throwable -> 0x01d9 }
        r8 = O000OOo;	 Catch:{ Throwable -> 0x01d9 }
        r4 = com.loc.OO000OO.O00000Oo(r8, r4);	 Catch:{ Throwable -> 0x01d9 }
        if (r4 != 0) goto L_0x01e2;
    L_0x01d5:
        O0000Oo(r17);	 Catch:{ Throwable -> 0x01d9 }
        goto L_0x01e2;
    L_0x01d9:
        r0 = move-exception;
        r4 = r0;
        r5 = "AuthUtil";
        r8 = "loadConfigDataCallAMapPush";
        com.loc.O0o0000.O000000o(r4, r5, r8);	 Catch:{ Throwable -> 0x0756 }
    L_0x01e2:
        r4 = r2.O0000Ooo;	 Catch:{ Throwable -> 0x028b }
        if (r4 == 0) goto L_0x0294;
    L_0x01e6:
        r5 = "f";
        r5 = r4.optString(r5);	 Catch:{ Throwable -> 0x028b }
        r8 = O000Oo0;	 Catch:{ Throwable -> 0x028b }
        r5 = com.loc.OO0O00o.O000000o(r5, r8);	 Catch:{ Throwable -> 0x028b }
        O000Oo0 = r5;	 Catch:{ Throwable -> 0x028b }
        r5 = "mco";
        r5 = r4.optInt(r5, r3);	 Catch:{ Throwable -> 0x028b }
        O00oOooo = r5;	 Catch:{ Throwable -> 0x028b }
        r5 = "co";
        r5 = r4.optInt(r5, r3);	 Catch:{ Throwable -> 0x028b }
        O000O00o = r5;	 Catch:{ Throwable -> 0x028b }
        r5 = "it";
        r8 = 3600; // 0xe10 float:5.045E-42 double:1.7786E-320;
        r5 = r4.optInt(r5, r8);	 Catch:{ Throwable -> 0x028b }
        r5 = r5 * 1000;
        O00oOooO = r5;	 Catch:{ Throwable -> 0x028b }
        r8 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        if (r5 >= r8) goto L_0x0217;
    L_0x0215:
        O00oOooO = r8;	 Catch:{ Throwable -> 0x028b }
    L_0x0217:
        r5 = "a";
        r8 = "提示信息";
        r5 = r4.optString(r5, r8);	 Catch:{ Throwable -> 0x028b }
        O0000OoO = r5;	 Catch:{ Throwable -> 0x028b }
        r5 = "o";
        r8 = "确认";
        r5 = r4.optString(r5, r8);	 Catch:{ Throwable -> 0x028b }
        O0000Ooo = r5;	 Catch:{ Throwable -> 0x028b }
        r5 = "c";
        r8 = "取消";
        r5 = r4.optString(r5, r8);	 Catch:{ Throwable -> 0x028b }
        O0000o00 = r5;	 Catch:{ Throwable -> 0x028b }
        r5 = "i";
        r8 = "";
        r5 = r4.optString(r5, r8);	 Catch:{ Throwable -> 0x028b }
        O0000o0 = r5;	 Catch:{ Throwable -> 0x028b }
        r5 = "u";
        r8 = "";
        r5 = r4.optString(r5, r8);	 Catch:{ Throwable -> 0x028b }
        O0000o0O = r5;	 Catch:{ Throwable -> 0x028b }
        r5 = "t";
        r8 = "";
        r4 = r4.optString(r5, r8);	 Catch:{ Throwable -> 0x028b }
        O0000o0o = r4;	 Catch:{ Throwable -> 0x028b }
        r4 = O0000o0;	 Catch:{ Throwable -> 0x028b }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x028b }
        if (r4 != 0) goto L_0x0265;
    L_0x025b:
        r4 = "null";
        r5 = O0000o0;	 Catch:{ Throwable -> 0x028b }
        r4 = r4.equals(r5);	 Catch:{ Throwable -> 0x028b }
        if (r4 == 0) goto L_0x0278;
    L_0x0265:
        r4 = O0000o0O;	 Catch:{ Throwable -> 0x028b }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x028b }
        if (r4 != 0) goto L_0x027a;
    L_0x026d:
        r4 = "null";
        r5 = O0000o0O;	 Catch:{ Throwable -> 0x028b }
        r4 = r4.equals(r5);	 Catch:{ Throwable -> 0x028b }
        if (r4 == 0) goto L_0x0278;
    L_0x0277:
        goto L_0x027a;
    L_0x0278:
        r4 = r3;
        goto L_0x027b;
    L_0x027a:
        r4 = r7;
    L_0x027b:
        r5 = O000O00o;	 Catch:{ Throwable -> 0x028b }
        r8 = O00oOooo;	 Catch:{ Throwable -> 0x028b }
        if (r5 <= r8) goto L_0x0283;
    L_0x0281:
        r5 = r7;
        goto L_0x0284;
    L_0x0283:
        r5 = r3;
    L_0x0284:
        if (r4 != 0) goto L_0x0288;
    L_0x0286:
        if (r5 == 0) goto L_0x0294;
    L_0x0288:
        O000Oo0 = r3;	 Catch:{ Throwable -> 0x028b }
        goto L_0x0294;
    L_0x028b:
        r0 = move-exception;
        r4 = r0;
        r5 = "AuthUtil";
        r8 = "loadConfigDataOpenAMap";
        com.loc.O0o0000.O000000o(r4, r5, r8);	 Catch:{ Throwable -> 0x0756 }
    L_0x0294:
        r4 = com.loc.O0o0000.O00000Oo();	 Catch:{ Throwable -> 0x02c6 }
        r5 = r2.O0000ooo;	 Catch:{ Throwable -> 0x02c6 }
        r8 = 0;
        if (r5 == 0) goto L_0x02c2;
    L_0x029d:
        r9 = r5.O00000Oo;	 Catch:{ Throwable -> 0x02c6 }
        r10 = r5.O000000o;	 Catch:{ Throwable -> 0x02c6 }
        r5 = r5.O00000o0;	 Catch:{ Throwable -> 0x02c6 }
        r11 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x02c6 }
        if (r11 != 0) goto L_0x02c2;
    L_0x02a9:
        r11 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x02c6 }
        if (r11 != 0) goto L_0x02c2;
    L_0x02af:
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x02c6 }
        if (r5 == 0) goto L_0x02b6;
    L_0x02b5:
        goto L_0x02c2;
    L_0x02b6:
        r5 = new com.loc.O000OOo0;	 Catch:{ Throwable -> 0x02c6 }
        r5.<init>(r10, r9);	 Catch:{ Throwable -> 0x02c6 }
        r5.O000000o(r7);	 Catch:{ Throwable -> 0x02c6 }
        com.loc.O000OOo.O00000Oo(r1, r5, r4);	 Catch:{ Throwable -> 0x02c6 }
        goto L_0x02cf;
    L_0x02c2:
        com.loc.O000OOo.O00000Oo(r1, r8, r4);	 Catch:{ Throwable -> 0x02c6 }
        goto L_0x02cf;
    L_0x02c6:
        r0 = move-exception;
        r4 = r0;
        r5 = "AuthUtil";
        r8 = "loadConfigDataSdkUpdate";
        com.loc.O0o0000.O000000o(r4, r5, r8);	 Catch:{ Throwable -> 0x0756 }
    L_0x02cf:
        r4 = O000000o;	 Catch:{ Throwable -> 0x0756 }
        if (r4 == 0) goto L_0x030c;
    L_0x02d3:
        r4 = r2.O000O00o;	 Catch:{ Throwable -> 0x0303 }
        if (r4 == 0) goto L_0x030c;
    L_0x02d7:
        r5 = r4.O000000o;	 Catch:{ Throwable -> 0x0303 }
        O000OOoo = r5;	 Catch:{ Throwable -> 0x0303 }
        r4 = r4.O00000Oo;	 Catch:{ Throwable -> 0x0303 }
        O000Oo00 = r4;	 Catch:{ Throwable -> 0x0303 }
        r4 = O000OOoo;	 Catch:{ Throwable -> 0x0303 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0303 }
        if (r4 != 0) goto L_0x030c;
    L_0x02e7:
        r4 = O000Oo00;	 Catch:{ Throwable -> 0x0303 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0303 }
        if (r4 != 0) goto L_0x030c;
    L_0x02ef:
        r4 = new com.loc.OO0O0OO;	 Catch:{ Throwable -> 0x0303 }
        r5 = "loc";
        r8 = O000OOoo;	 Catch:{ Throwable -> 0x0303 }
        r9 = O000Oo00;	 Catch:{ Throwable -> 0x0303 }
        r4.<init>(r1, r5, r8, r9);	 Catch:{ Throwable -> 0x0303 }
        r5 = O0000Oo;	 Catch:{ Throwable -> 0x0303 }
        r4.O000000o(r5);	 Catch:{ Throwable -> 0x0303 }
        r4.O000000o();	 Catch:{ Throwable -> 0x0303 }
        goto L_0x030c;
    L_0x0303:
        r0 = move-exception;
        r4 = r0;
        r5 = "AuthUtil";
        r8 = "loadConfigDataGroupOffset";
        com.loc.O0o0000.O000000o(r4, r5, r8);	 Catch:{ Throwable -> 0x0756 }
    L_0x030c:
        r4 = 30;
        r5 = r2.O0000ooO;	 Catch:{ Throwable -> 0x0387 }
        if (r5 == 0) goto L_0x0390;
    L_0x0312:
        r8 = r5.O000000o;	 Catch:{ Throwable -> 0x0387 }
        O000O0OO = r8;	 Catch:{ Throwable -> 0x0387 }
        r8 = "pref";
        r9 = "exception";
        r10 = O000O0OO;	 Catch:{ Throwable -> 0x0387 }
        com.loc.OO0000o.O000000o(r1, r8, r9, r10);	 Catch:{ Throwable -> 0x0387 }
        r5 = r5.O00000o0;	 Catch:{ Throwable -> 0x0387 }
        r8 = "fn";
        r9 = O000O0Oo;	 Catch:{ Throwable -> 0x0387 }
        r8 = r5.optInt(r8, r9);	 Catch:{ Throwable -> 0x0387 }
        O000O0Oo = r8;	 Catch:{ Throwable -> 0x0387 }
        r8 = "mpn";
        r9 = O00oOoOo;	 Catch:{ Throwable -> 0x0387 }
        r8 = r5.optInt(r8, r9);	 Catch:{ Throwable -> 0x0387 }
        O00oOoOo = r8;	 Catch:{ Throwable -> 0x0387 }
        r9 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r8 <= r9) goto L_0x033b;
    L_0x0339:
        O00oOoOo = r9;	 Catch:{ Throwable -> 0x0387 }
    L_0x033b:
        r8 = O00oOoOo;	 Catch:{ Throwable -> 0x0387 }
        if (r8 >= r4) goto L_0x0341;
    L_0x033f:
        O00oOoOo = r4;	 Catch:{ Throwable -> 0x0387 }
    L_0x0341:
        r8 = "igu";
        r8 = r5.optString(r8);	 Catch:{ Throwable -> 0x0387 }
        r9 = O000O0o0;	 Catch:{ Throwable -> 0x0387 }
        r8 = com.loc.OO0O00o.O000000o(r8, r9);	 Catch:{ Throwable -> 0x0387 }
        O000O0o0 = r8;	 Catch:{ Throwable -> 0x0387 }
        r8 = "ms";
        r9 = O000O0o;	 Catch:{ Throwable -> 0x0387 }
        r5 = r5.optInt(r8, r9);	 Catch:{ Throwable -> 0x0387 }
        O000O0o = r5;	 Catch:{ Throwable -> 0x0387 }
        r5 = O000O0Oo;	 Catch:{ Throwable -> 0x0387 }
        r8 = O000O0o0;	 Catch:{ Throwable -> 0x0387 }
        r9 = O000O0o;	 Catch:{ Throwable -> 0x0387 }
        com.loc.O00Oo.O000000o(r5, r8, r9);	 Catch:{ Throwable -> 0x0387 }
        r5 = "pref";
        r8 = "fn";
        r9 = O000O0Oo;	 Catch:{ Throwable -> 0x0387 }
        com.loc.OO0000o.O000000o(r1, r5, r8, r9);	 Catch:{ Throwable -> 0x0387 }
        r5 = "pref";
        r8 = "mpn";
        r9 = O00oOoOo;	 Catch:{ Throwable -> 0x0387 }
        com.loc.OO0000o.O000000o(r1, r5, r8, r9);	 Catch:{ Throwable -> 0x0387 }
        r5 = "pref";
        r8 = "igu";
        r9 = O000O0o0;	 Catch:{ Throwable -> 0x0387 }
        com.loc.OO0000o.O000000o(r1, r5, r8, r9);	 Catch:{ Throwable -> 0x0387 }
        r5 = "pref";
        r8 = "ms";
        r9 = O000O0o;	 Catch:{ Throwable -> 0x0387 }
        com.loc.OO0000o.O000000o(r1, r5, r8, r9);	 Catch:{ Throwable -> 0x0387 }
        goto L_0x0390;
    L_0x0387:
        r0 = move-exception;
        r5 = r0;
        r8 = "AuthUtil";
        r9 = "loadConfigDataUploadException";
        com.loc.O0o0000.O000000o(r5, r8, r9);	 Catch:{ Throwable -> 0x0756 }
    L_0x0390:
        r5 = 2;
        r8 = r2.O0000o00;	 Catch:{ Throwable -> 0x0418 }
        if (r8 == 0) goto L_0x0421;
    L_0x0395:
        r9 = "able";
        r9 = r8.optString(r9);	 Catch:{ Throwable -> 0x0418 }
        r9 = com.loc.OO0O00o.O000000o(r9, r3);	 Catch:{ Throwable -> 0x0418 }
        if (r9 == 0) goto L_0x0421;
    L_0x03a1:
        r9 = "fs";
        r9 = O000000o(r8, r9);	 Catch:{ Throwable -> 0x0418 }
        if (r9 == 0) goto L_0x03bf;
    L_0x03a9:
        r10 = r9.O00000o0;	 Catch:{ Throwable -> 0x0418 }
        O0000oOo = r10;	 Catch:{ Throwable -> 0x0418 }
        r9 = r9.O00000Oo;	 Catch:{ Throwable -> 0x03b6 }
        r9 = java.lang.Integer.parseInt(r9);	 Catch:{ Throwable -> 0x03b6 }
        O0000oo0 = r9;	 Catch:{ Throwable -> 0x03b6 }
        goto L_0x03bf;
    L_0x03b6:
        r0 = move-exception;
        r9 = r0;
        r10 = "AuthUtil";
        r11 = "loadconfig part2";
        com.loc.O0o0000.O000000o(r9, r10, r11);	 Catch:{ Throwable -> 0x0418 }
    L_0x03bf:
        r9 = "us";
        r9 = O000000o(r8, r9);	 Catch:{ Throwable -> 0x0418 }
        if (r9 == 0) goto L_0x03e7;
    L_0x03c7:
        r10 = r9.O00000o0;	 Catch:{ Throwable -> 0x0418 }
        O0000oo = r10;	 Catch:{ Throwable -> 0x0418 }
        r10 = r9.O000000o;	 Catch:{ Throwable -> 0x0418 }
        O0000ooo = r10;	 Catch:{ Throwable -> 0x0418 }
        r9 = r9.O00000Oo;	 Catch:{ Throwable -> 0x03d8 }
        r9 = java.lang.Integer.parseInt(r9);	 Catch:{ Throwable -> 0x03d8 }
        O0000ooO = r9;	 Catch:{ Throwable -> 0x03d8 }
        goto L_0x03e1;
    L_0x03d8:
        r0 = move-exception;
        r9 = r0;
        r10 = "AuthUtil";
        r11 = "loadconfig part1";
        com.loc.O0o0000.O000000o(r9, r10, r11);	 Catch:{ Throwable -> 0x0418 }
    L_0x03e1:
        r9 = O0000ooO;	 Catch:{ Throwable -> 0x0418 }
        if (r9 >= r5) goto L_0x03e7;
    L_0x03e5:
        O0000oo = r3;	 Catch:{ Throwable -> 0x0418 }
    L_0x03e7:
        r9 = "rs";
        r8 = O000000o(r8, r9);	 Catch:{ Throwable -> 0x0418 }
        if (r8 == 0) goto L_0x0421;
    L_0x03ef:
        r9 = r8.O00000o0;	 Catch:{ Throwable -> 0x0418 }
        O0000o = r9;	 Catch:{ Throwable -> 0x0418 }
        if (r9 == 0) goto L_0x0402;
    L_0x03f5:
        r9 = com.loc.OO000OO.O00000o0();	 Catch:{ Throwable -> 0x0418 }
        O0000oO = r9;	 Catch:{ Throwable -> 0x0418 }
        r9 = r8.O00000o;	 Catch:{ Throwable -> 0x0418 }
        r9 = r9 * 1000;
        r9 = (long) r9;	 Catch:{ Throwable -> 0x0418 }
        O0000oOO = r9;	 Catch:{ Throwable -> 0x0418 }
    L_0x0402:
        r8 = r8.O00000Oo;	 Catch:{ Throwable -> 0x040e }
        r8 = java.lang.Integer.parseInt(r8);	 Catch:{ Throwable -> 0x040e }
        r8 = r8 * 1000;
        r8 = (long) r8;	 Catch:{ Throwable -> 0x040e }
        O0000oO0 = r8;	 Catch:{ Throwable -> 0x040e }
        goto L_0x0421;
    L_0x040e:
        r0 = move-exception;
        r8 = r0;
        r9 = "AuthUtil";
        r10 = "loadconfig part";
        com.loc.O0o0000.O000000o(r8, r9, r10);	 Catch:{ Throwable -> 0x0418 }
        goto L_0x0421;
    L_0x0418:
        r0 = move-exception;
        r8 = r0;
        r9 = "AuthUtil";
        r10 = "loadConfigDataLocate";
        com.loc.O0o0000.O000000o(r8, r9, r10);	 Catch:{ Throwable -> 0x0756 }
    L_0x0421:
        r8 = r2.O0000o0O;	 Catch:{ Throwable -> 0x0450 }
        if (r8 == 0) goto L_0x0459;
    L_0x0425:
        r9 = "able";
        r9 = r8.optString(r9);	 Catch:{ Throwable -> 0x0450 }
        r10 = O000Oo0O;	 Catch:{ Throwable -> 0x0450 }
        r9 = com.loc.OO0O00o.O000000o(r9, r10);	 Catch:{ Throwable -> 0x0450 }
        O000Oo0O = r9;	 Catch:{ Throwable -> 0x0450 }
        if (r9 == 0) goto L_0x0459;
    L_0x0435:
        r9 = "c";
        r9 = r8.optInt(r9, r3);	 Catch:{ Throwable -> 0x0450 }
        if (r9 != 0) goto L_0x0442;
    L_0x043d:
        r9 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        O000Oo0o = r9;	 Catch:{ Throwable -> 0x0450 }
        goto L_0x0446;
    L_0x0442:
        r9 = r9 * 1000;
        O000Oo0o = r9;	 Catch:{ Throwable -> 0x0450 }
    L_0x0446:
        r9 = "t";
        r8 = r8.getInt(r9);	 Catch:{ Throwable -> 0x0450 }
        r8 = r8 / r5;
        O000OoO0 = r8;	 Catch:{ Throwable -> 0x0450 }
        goto L_0x0459;
    L_0x0450:
        r0 = move-exception;
        r5 = r0;
        r8 = "AuthUtil";
        r9 = "loadConfigDataNgps";
        com.loc.O0o0000.O000000o(r5, r8, r9);	 Catch:{ Throwable -> 0x0756 }
    L_0x0459:
        r5 = r2.O0000o0o;	 Catch:{ Throwable -> 0x048d }
        if (r5 == 0) goto L_0x0496;
    L_0x045d:
        r8 = "able";
        r8 = r5.optString(r8);	 Catch:{ Throwable -> 0x048d }
        r9 = O00O0Oo;	 Catch:{ Throwable -> 0x048d }
        r8 = com.loc.OO0O00o.O000000o(r8, r9);	 Catch:{ Throwable -> 0x048d }
        O00O0Oo = r8;	 Catch:{ Throwable -> 0x048d }
        if (r8 == 0) goto L_0x047a;
    L_0x046d:
        r8 = "c";
        r9 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r5 = r5.optInt(r8, r9);	 Catch:{ Throwable -> 0x048d }
        r5 = r5 * 1000;
        r8 = (long) r5;	 Catch:{ Throwable -> 0x048d }
        O000OoO = r8;	 Catch:{ Throwable -> 0x048d }
    L_0x047a:
        r5 = "pref";
        r8 = "ca";
        r9 = O00O0Oo;	 Catch:{ Throwable -> 0x048d }
        com.loc.OO0000o.O000000o(r1, r5, r8, r9);	 Catch:{ Throwable -> 0x048d }
        r5 = "pref";
        r8 = "ct";
        r9 = O000OoO;	 Catch:{ Throwable -> 0x048d }
        com.loc.OO0000o.O000000o(r1, r5, r8, r9);	 Catch:{ Throwable -> 0x048d }
        goto L_0x0496;
    L_0x048d:
        r0 = move-exception;
        r5 = r0;
        r8 = "AuthUtil";
        r9 = "loadConfigDataCacheAble";
        com.loc.O0o0000.O000000o(r5, r8, r9);	 Catch:{ Throwable -> 0x0756 }
    L_0x0496:
        r5 = r2.O00oOoOo;	 Catch:{ Throwable -> 0x04aa }
        if (r5 == 0) goto L_0x04b3;
    L_0x049a:
        r8 = com.loc.O0OOo.O00000o0();	 Catch:{ Throwable -> 0x04aa }
        r8 = r8 ^ r7;
        r9 = "HttpDNS";
        r10 = "1.0.0";
        r5 = O000000o(r1, r5, r9, r10, r8);	 Catch:{ Throwable -> 0x04aa }
        O000OoOO = r5;	 Catch:{ Throwable -> 0x04aa }
        goto L_0x04b3;
    L_0x04aa:
        r0 = move-exception;
        r5 = r0;
        r8 = "AuthUtil";
        r9 = "loadConfigDataDnsDex";
        com.loc.O0o0000.O000000o(r5, r8, r9);	 Catch:{ Throwable -> 0x0756 }
    L_0x04b3:
        r5 = r2.O0000Oo;	 Catch:{ Throwable -> 0x05b6 }
        if (r5 == 0) goto L_0x05bf;
    L_0x04b7:
        r8 = "able";
        r8 = r5.optString(r8);	 Catch:{ Throwable -> 0x05b6 }
        r9 = O000Ooo0;	 Catch:{ Throwable -> 0x05b6 }
        r8 = com.loc.OO0O00o.O000000o(r8, r9);	 Catch:{ Throwable -> 0x05b6 }
        O000Ooo0 = r8;	 Catch:{ Throwable -> 0x05b6 }
        r8 = "sysTime";
        r9 = com.loc.OO000OO.O00000Oo();	 Catch:{ Throwable -> 0x05b6 }
        r8 = r5.optLong(r8, r9);	 Catch:{ Throwable -> 0x05b6 }
        O000Ooo = r8;	 Catch:{ Throwable -> 0x05b6 }
        r8 = "n";
        r8 = r5.optInt(r8, r7);	 Catch:{ Throwable -> 0x05b6 }
        O000OooO = r8;	 Catch:{ Throwable -> 0x05b6 }
        r8 = "nh";
        r8 = r5.optInt(r8, r7);	 Catch:{ Throwable -> 0x05b6 }
        O000Oooo = r8;	 Catch:{ Throwable -> 0x05b6 }
        r8 = O000OooO;	 Catch:{ Throwable -> 0x05b6 }
        if (r8 == r6) goto L_0x04ee;
    L_0x04e5:
        r8 = O000OooO;	 Catch:{ Throwable -> 0x05b6 }
        r9 = O000Oooo;	 Catch:{ Throwable -> 0x05b6 }
        if (r8 < r9) goto L_0x04ec;
    L_0x04eb:
        goto L_0x04ee;
    L_0x04ec:
        r8 = r3;
        goto L_0x04ef;
    L_0x04ee:
        r8 = r7;
    L_0x04ef:
        r9 = O000Ooo0;	 Catch:{ Throwable -> 0x05b6 }
        if (r9 == 0) goto L_0x05bf;
    L_0x04f3:
        if (r8 == 0) goto L_0x05bf;
    L_0x04f5:
        r8 = "l";
        r8 = r5.optJSONArray(r8);	 Catch:{ Throwable -> 0x05b6 }
        r9 = r3;
    L_0x04fc:
        r10 = r8.length();	 Catch:{ Throwable -> 0x05b6 }
        if (r9 >= r10) goto L_0x058f;
    L_0x0502:
        r10 = r8.optJSONObject(r9);	 Catch:{ Throwable -> 0x0587 }
        r11 = new com.loc.O0o0;	 Catch:{ Throwable -> 0x0587 }
        r11.<init>();	 Catch:{ Throwable -> 0x0587 }
        r12 = "able";
        r13 = "false";
        r12 = r10.optString(r12, r13);	 Catch:{ Throwable -> 0x0587 }
        r12 = com.loc.OO0O00o.O000000o(r12, r3);	 Catch:{ Throwable -> 0x0587 }
        r11.O000000o = r12;	 Catch:{ Throwable -> 0x0587 }
        if (r12 != 0) goto L_0x051c;
    L_0x051b:
        goto L_0x0587;
    L_0x051c:
        r12 = "pn";
        r13 = "";
        r12 = r10.optString(r12, r13);	 Catch:{ Throwable -> 0x0587 }
        r11.O00000Oo = r12;	 Catch:{ Throwable -> 0x0587 }
        r12 = "cn";
        r13 = "";
        r12 = r10.optString(r12, r13);	 Catch:{ Throwable -> 0x0587 }
        r11.O00000o0 = r12;	 Catch:{ Throwable -> 0x0587 }
        r12 = "a";
        r13 = "";
        r12 = r10.optString(r12, r13);	 Catch:{ Throwable -> 0x0587 }
        r11.O00000oO = r12;	 Catch:{ Throwable -> 0x0587 }
        r12 = "b";
        r12 = r10.optJSONArray(r12);	 Catch:{ Throwable -> 0x0587 }
        if (r12 == 0) goto L_0x0574;
    L_0x0542:
        r13 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0587 }
        r13.<init>();	 Catch:{ Throwable -> 0x0587 }
        r14 = r3;
    L_0x0548:
        r15 = r12.length();	 Catch:{ Throwable -> 0x0587 }
        if (r14 >= r15) goto L_0x0572;
    L_0x054e:
        r15 = r12.optJSONObject(r14);	 Catch:{ Throwable -> 0x0587 }
        r4 = new java.util.HashMap;	 Catch:{ Throwable -> 0x0587 }
        r7 = 16;
        r4.<init>(r7);	 Catch:{ Throwable -> 0x0587 }
        r7 = "k";
        r7 = r15.optString(r7);	 Catch:{ Throwable -> 0x056b }
        r6 = "v";
        r6 = r15.optString(r6);	 Catch:{ Throwable -> 0x056b }
        r4.put(r7, r6);	 Catch:{ Throwable -> 0x056b }
        r13.add(r4);	 Catch:{ Throwable -> 0x056b }
    L_0x056b:
        r14 = r14 + 1;
        r4 = 30;
        r6 = -1;
        r7 = 1;
        goto L_0x0548;
    L_0x0572:
        r11.O00000o = r13;	 Catch:{ Throwable -> 0x0587 }
    L_0x0574:
        r4 = "is";
        r6 = "false";
        r4 = r10.optString(r4, r6);	 Catch:{ Throwable -> 0x0587 }
        r4 = com.loc.OO0O00o.O000000o(r4, r3);	 Catch:{ Throwable -> 0x0587 }
        r11.O00000oo = r4;	 Catch:{ Throwable -> 0x0587 }
        r4 = O000OoOo;	 Catch:{ Throwable -> 0x0587 }
        r4.add(r11);	 Catch:{ Throwable -> 0x0587 }
    L_0x0587:
        r9 = r9 + 1;
        r4 = 30;
        r6 = -1;
        r7 = 1;
        goto L_0x04fc;
    L_0x058f:
        r4 = "sl";
        r4 = r5.optJSONArray(r4);	 Catch:{ Throwable -> 0x05b6 }
        if (r4 == 0) goto L_0x05bf;
    L_0x0597:
        r5 = r3;
    L_0x0598:
        r6 = r4.length();	 Catch:{ Throwable -> 0x05b6 }
        if (r5 >= r6) goto L_0x05bf;
    L_0x059e:
        r6 = r4.optJSONObject(r5);	 Catch:{ Throwable -> 0x05b6 }
        r7 = "pan";
        r6 = r6.optString(r7);	 Catch:{ Throwable -> 0x05b6 }
        r7 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x05b6 }
        if (r7 != 0) goto L_0x05b3;
    L_0x05ae:
        r7 = O000o000;	 Catch:{ Throwable -> 0x05b6 }
        r7.add(r6);	 Catch:{ Throwable -> 0x05b6 }
    L_0x05b3:
        r5 = r5 + 1;
        goto L_0x0598;
    L_0x05b6:
        r0 = move-exception;
        r4 = r0;
        r5 = "AuthUtil";
        r6 = "loadConfigData_otherServiceList";
        com.loc.O0o0000.O000000o(r4, r5, r6);	 Catch:{ Throwable -> 0x0756 }
    L_0x05bf:
        r4 = r2.O0000Oo0;	 Catch:{ Throwable -> 0x05de }
        if (r4 == 0) goto L_0x05e7;
    L_0x05c3:
        r5 = "able";
        r5 = r4.optString(r5);	 Catch:{ Throwable -> 0x05de }
        r6 = O000o00;	 Catch:{ Throwable -> 0x05de }
        r5 = com.loc.OO0O00o.O000000o(r5, r6);	 Catch:{ Throwable -> 0x05de }
        O000o00 = r5;	 Catch:{ Throwable -> 0x05de }
        if (r5 == 0) goto L_0x05e7;
    L_0x05d3:
        r5 = "c";
        r6 = O000o00O;	 Catch:{ Throwable -> 0x05de }
        r4 = r4.optInt(r5, r6);	 Catch:{ Throwable -> 0x05de }
        O000o00O = r4;	 Catch:{ Throwable -> 0x05de }
        goto L_0x05e7;
    L_0x05de:
        r0 = move-exception;
        r4 = r0;
        r5 = "AuthUtil";
        r6 = "loadConfigDataGpsGeoAble";
        com.loc.O0o0000.O000000o(r4, r5, r6);	 Catch:{ Throwable -> 0x0756 }
    L_0x05e7:
        r2 = r2.O0000oo;	 Catch:{ Throwable -> 0x0756 }
        if (r2 == 0) goto L_0x06c4;
    L_0x05eb:
        r4 = "157";
        r4 = r2.optJSONObject(r4);	 Catch:{ Throwable -> 0x06bb }
        if (r4 == 0) goto L_0x06c4;
    L_0x05f3:
        r5 = "able";
        r5 = r4.optString(r5);	 Catch:{ Throwable -> 0x06bb }
        r6 = O000o0O;	 Catch:{ Throwable -> 0x06bb }
        r5 = com.loc.OO0O00o.O000000o(r5, r6);	 Catch:{ Throwable -> 0x06bb }
        O000o0O = r5;	 Catch:{ Throwable -> 0x06bb }
        r5 = "co";
        r6 = "1.0.0";
        r5 = com.loc.O0o0000.O000000o(r5, r6);	 Catch:{ Throwable -> 0x06bb }
        r6 = O000o0O;	 Catch:{ Throwable -> 0x06bb }
        if (r6 == 0) goto L_0x0683;
    L_0x060d:
        r6 = "cv";
        r7 = -1;
        r6 = r4.optInt(r6, r7);	 Catch:{ Throwable -> 0x06bb }
        O000o0o0 = r6;	 Catch:{ Throwable -> 0x06bb }
        r6 = "co";
        r6 = r4.optString(r6);	 Catch:{ Throwable -> 0x06bb }
        r7 = O000o0OO;	 Catch:{ Throwable -> 0x06bb }
        r6 = com.loc.OO0O00o.O000000o(r6, r7);	 Catch:{ Throwable -> 0x06bb }
        O000o0OO = r6;	 Catch:{ Throwable -> 0x06bb }
        r6 = "oo";
        r6 = r4.optString(r6);	 Catch:{ Throwable -> 0x06bb }
        r7 = O000o0Oo;	 Catch:{ Throwable -> 0x06bb }
        r6 = com.loc.OO0O00o.O000000o(r6, r7);	 Catch:{ Throwable -> 0x06bb }
        O000o0Oo = r6;	 Catch:{ Throwable -> 0x06bb }
        r6 = "v";
        r6 = r4.optString(r6);	 Catch:{ Throwable -> 0x06bb }
        r7 = "u";
        r7 = r4.optString(r7);	 Catch:{ Throwable -> 0x06bb }
        r8 = "m";
        r4 = r4.optString(r8);	 Catch:{ Throwable -> 0x06bb }
        r8 = com.loc.O0OO0Oo.O000000o();	 Catch:{ Throwable -> 0x06bb }
        if (r8 != 0) goto L_0x0696;
    L_0x064a:
        r8 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x06bb }
        if (r8 != 0) goto L_0x0696;
    L_0x0650:
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Throwable -> 0x06bb }
        if (r8 != 0) goto L_0x0696;
    L_0x0656:
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x06bb }
        if (r6 != 0) goto L_0x0696;
    L_0x065c:
        r6 = new com.loc.O000OOo0;	 Catch:{ Throwable -> 0x06bb }
        r6.<init>(r7, r4);	 Catch:{ Throwable -> 0x06bb }
        r4 = O0000Oo;	 Catch:{ Throwable -> 0x06bb }
        r6.O000000o(r4);	 Catch:{ Throwable -> 0x06bb }
        r4 = com.loc.O000OOo.O000000o(r1, r6, r5);	 Catch:{ Throwable -> 0x06bb }
        r7 = r4 ^ 1;
        O0000Oo0 = r7;	 Catch:{ Throwable -> 0x06bb }
        if (r4 == 0) goto L_0x0696;
    L_0x0670:
        r4 = "pref";
        r7 = "ok4";
        r8 = 1;
        com.loc.OO0000o.O000000o(r1, r4, r7, r8);	 Catch:{ Throwable -> 0x06bb }
        r4 = "pref";
        r7 = "ok1";
        com.loc.OO0000o.O000000o(r1, r4, r7, r3);	 Catch:{ Throwable -> 0x06bb }
        com.loc.O000OOo.O00000Oo(r1, r6, r5);	 Catch:{ Throwable -> 0x06bb }
        goto L_0x0696;
    L_0x0683:
        O0000Oo0 = r3;	 Catch:{ Throwable -> 0x06bb }
        O000o0OO = r3;	 Catch:{ Throwable -> 0x06bb }
        O000o0Oo = r3;	 Catch:{ Throwable -> 0x06bb }
        r4 = com.loc.ooO0Ooo.O000000o(r1, r5);	 Catch:{ Throwable -> 0x06bb }
        if (r4 == 0) goto L_0x0696;
    L_0x068f:
        r4 = "co";
        r5 = "config|coDex able is false";
        com.loc.OO0000.O000000o(r1, r4, r5);	 Catch:{ Throwable -> 0x06bb }
    L_0x0696:
        r4 = "pref";
        r5 = "ok0";
        r6 = O000o0O;	 Catch:{ Throwable -> 0x06bb }
        com.loc.OO0000o.O000000o(r1, r4, r5, r6);	 Catch:{ Throwable -> 0x06bb }
        r4 = "pref";
        r5 = "ok1";
        r6 = O0000Oo0;	 Catch:{ Throwable -> 0x06bb }
        com.loc.OO0000o.O000000o(r1, r4, r5, r6);	 Catch:{ Throwable -> 0x06bb }
        r4 = "pref";
        r5 = "ok2";
        r6 = O000o0OO;	 Catch:{ Throwable -> 0x06bb }
        com.loc.OO0000o.O000000o(r1, r4, r5, r6);	 Catch:{ Throwable -> 0x06bb }
        r4 = "pref";
        r5 = "ok3";
        r6 = O000o0Oo;	 Catch:{ Throwable -> 0x06bb }
        com.loc.OO0000o.O000000o(r1, r4, r5, r6);	 Catch:{ Throwable -> 0x06bb }
        goto L_0x06c4;
    L_0x06bb:
        r0 = move-exception;
        r4 = r0;
        r5 = "AuthUtil";
        r6 = "loadConfigDataNewCollectionOffline";
        com.loc.O0o0000.O000000o(r4, r5, r6);	 Catch:{ Throwable -> 0x0756 }
    L_0x06c4:
        if (r1 == 0) goto L_0x0712;
    L_0x06c6:
        if (r2 != 0) goto L_0x06c9;
    L_0x06c8:
        goto L_0x0712;
    L_0x06c9:
        r4 = "15O";
        r4 = r2.optJSONObject(r4);	 Catch:{ Throwable -> 0x0712 }
        if (r4 == 0) goto L_0x0712;
    L_0x06d1:
        r5 = "able";
        r5 = r4.optString(r5);	 Catch:{ Throwable -> 0x0712 }
        r3 = com.loc.OO0O00o.O000000o(r5, r3);	 Catch:{ Throwable -> 0x0712 }
        if (r3 == 0) goto L_0x0705;
    L_0x06dd:
        r3 = "fl";
        r3 = r4.optJSONArray(r3);	 Catch:{ Throwable -> 0x0712 }
        if (r3 == 0) goto L_0x06f7;
    L_0x06e5:
        r5 = r3.length();	 Catch:{ Throwable -> 0x0712 }
        if (r5 <= 0) goto L_0x06f7;
    L_0x06eb:
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0712 }
        r5 = android.os.Build.MANUFACTURER;	 Catch:{ Throwable -> 0x0712 }
        r3 = r3.contains(r5);	 Catch:{ Throwable -> 0x0712 }
        if (r3 == 0) goto L_0x0705;
    L_0x06f7:
        r3 = "iv";
        r5 = 30;
        r3 = r4.optInt(r3, r5);	 Catch:{ Throwable -> 0x0712 }
        r3 = r3 * 1000;
        r3 = (long) r3;	 Catch:{ Throwable -> 0x0712 }
        O000o0oo = r3;	 Catch:{ Throwable -> 0x0712 }
        goto L_0x0709;
    L_0x0705:
        r3 = -1;
        O000o0oo = r3;	 Catch:{ Throwable -> 0x0712 }
    L_0x0709:
        r3 = "pref";
        r4 = "awsi";
        r5 = O000o0oo;	 Catch:{ Throwable -> 0x0712 }
        com.loc.OO0000o.O000000o(r1, r3, r4, r5);	 Catch:{ Throwable -> 0x0712 }
    L_0x0712:
        if (r1 == 0) goto L_0x0754;
    L_0x0714:
        if (r2 != 0) goto L_0x0717;
    L_0x0716:
        goto L_0x0754;
    L_0x0717:
        r3 = "15U";
        r2 = r2.optJSONObject(r3);	 Catch:{ Throwable -> 0x0754 }
        if (r2 == 0) goto L_0x0754;
    L_0x071f:
        r3 = "able";
        r3 = r2.optString(r3);	 Catch:{ Throwable -> 0x0754 }
        r4 = O000o;	 Catch:{ Throwable -> 0x0754 }
        r3 = com.loc.OO0O00o.O000000o(r3, r4);	 Catch:{ Throwable -> 0x0754 }
        r4 = "yn";
        r5 = O000oO00;	 Catch:{ Throwable -> 0x0754 }
        r4 = r2.optInt(r4, r5);	 Catch:{ Throwable -> 0x0754 }
        r5 = "sysTime";
        r6 = O000oO0;	 Catch:{ Throwable -> 0x0754 }
        r5 = r2.optLong(r5, r6);	 Catch:{ Throwable -> 0x0754 }
        O000oO0 = r5;	 Catch:{ Throwable -> 0x0754 }
        r2 = "pref";
        r5 = "15ua";
        com.loc.OO0000o.O000000o(r1, r2, r5, r3);	 Catch:{ Throwable -> 0x0754 }
        r2 = "pref";
        r3 = "15un";
        com.loc.OO0000o.O000000o(r1, r2, r3, r4);	 Catch:{ Throwable -> 0x0754 }
        r2 = "pref";
        r3 = "15ust";
        r4 = O000oO0;	 Catch:{ Throwable -> 0x0754 }
        com.loc.OO0000o.O000000o(r1, r2, r3, r4);	 Catch:{ Throwable -> 0x0754 }
    L_0x0754:
        r1 = 1;
        return r1;
    L_0x0756:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OoO0o.O000000o(android.content.Context, com.loc.OO0O00o$O000000o):boolean");
    }

    public static int O00000Oo() {
        return O0000oo0;
    }

    public static boolean O00000Oo(long j) {
        if (!O00O0Oo) {
            return false;
        }
        return O000OoO < 0 || OO000OO.O00000Oo() - j < O000OoO;
    }

    public static boolean O00000Oo(Context context) {
        if (!O000O0oo) {
            return false;
        }
        if (O000OO00 == -1 || O000OO0o == 0) {
            return true;
        }
        if (OO000OO.O00000Oo(O000OO0o, OO0000o.O00000Oo(context, "pref", "nowtime", 0))) {
            int O00000Oo = OO0000o.O00000Oo(context, "pref", "count", 0);
            if (O00000Oo >= O000OO00) {
                return false;
            }
            OO0000o.O000000o(context, "pref", "count", O00000Oo + 1);
            return true;
        }
        O0000Oo0(context);
        OO0000o.O000000o(context, "pref", "count", 1);
        return true;
    }

    public static int O00000o() {
        return O0000ooO;
    }

    /* JADX WARNING: Missing block: B:25:0x0076, code skipped:
            return false;
     */
    public static boolean O00000o(android.content.Context r11) {
        /*
        r0 = O000Oo0;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = O000O00o;
        if (r0 <= 0) goto L_0x0076;
    L_0x000a:
        r0 = O00oOooo;
        if (r0 <= 0) goto L_0x0076;
    L_0x000e:
        r0 = O000O00o;
        r2 = O00oOooo;
        if (r0 <= r2) goto L_0x0015;
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = "abcd";
        r2 = "lct";
        r3 = 0;
        r5 = com.loc.OO0000o.O00000Oo(r11, r0, r2, r3);
        r0 = "abcd";
        r2 = "lst";
        r2 = com.loc.OO0000o.O00000Oo(r11, r0, r2, r3);
        r7 = com.loc.OO000OO.O00000o0();
        r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x0037;
    L_0x002f:
        r0 = "abcd";
        r2 = "lct";
        com.loc.OO0000o.O000000o(r11, r0, r2, r7);
        return r1;
    L_0x0037:
        r9 = r7 - r5;
        r4 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x004e;
    L_0x0040:
        r0 = "abcd";
        r4 = "lct";
        com.loc.OO0000o.O000000o(r11, r0, r4, r7);
        r0 = "abcd";
        r4 = "t";
        com.loc.OO0000o.O000000o(r11, r0, r4, r1);
    L_0x004e:
        r4 = r7 - r2;
        r0 = O00oOooO;
        r2 = (long) r0;
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x0058;
    L_0x0057:
        return r1;
    L_0x0058:
        r0 = "abcd";
        r2 = "t";
        r0 = com.loc.OO0000o.O00000Oo(r11, r0, r2, r1);
        r2 = 1;
        r0 = r0 + r2;
        r3 = O00oOooo;
        if (r0 <= r3) goto L_0x0067;
    L_0x0066:
        return r1;
    L_0x0067:
        r1 = "abcd";
        r3 = "lst";
        com.loc.OO0000o.O000000o(r11, r1, r3, r7);
        r1 = "abcd";
        r3 = "t";
        com.loc.OO0000o.O000000o(r11, r1, r3, r0);
        return r2;
    L_0x0076:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OoO0o.O00000o(android.content.Context):boolean");
    }

    public static boolean O00000o0() {
        return O0000oo;
    }

    public static boolean O00000o0(Context context) {
        if (!O000OOOo) {
            return false;
        }
        if (O000OOo0 == -1 || O000OOo == 0) {
            return true;
        }
        if (OO000OO.O00000Oo(O000OOo, OO0000o.O00000Oo(context, "pref", "pushSerTime", 0))) {
            int O00000Oo = OO0000o.O00000Oo(context, "pref", "pushCount", 0);
            if (O00000Oo >= O000OOo0) {
                return false;
            }
            OO0000o.O000000o(context, "pref", "pushCount", O00000Oo + 1);
            return true;
        }
        O0000Oo(context);
        OO0000o.O000000o(context, "pref", "pushCount", 1);
        return true;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x00bd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0051 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x00b1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0075 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x00a5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0069 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:(2:0|1)|4|5|6|7|8|9|10|11|12|13|14|15|16|17|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:(2:0|1)|4|5|6|7|8|9|10|11|12|13|14|15|16|17|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:(2:0|1)|4|5|6|7|8|9|10|11|12|13|14|15|16|17|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:(2:0|1)|4|5|6|7|8|9|10|11|12|13|14|15|16|17|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:(2:0|1)|4|5|6|7|8|9|10|11|12|13|14|15|16|17|19) */
    public static void O00000oO(android.content.Context r4) {
        /*
        r0 = "pref";
        r1 = "exception";
        r2 = O000O0OO;	 Catch:{ Throwable -> 0x0010 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x0010 }
        O000O0OO = r0;	 Catch:{ Throwable -> 0x0010 }
        O00000oo(r4);	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0018;
    L_0x0010:
        r0 = move-exception;
        r1 = "AuthUtil";
        r2 = "loadLastAbleState p1";
        com.loc.O0o0000.O000000o(r0, r1, r2);
    L_0x0018:
        r0 = "pref";
        r1 = "fn";
        r2 = O000O0Oo;	 Catch:{ Throwable -> 0x0051 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x0051 }
        O000O0Oo = r0;	 Catch:{ Throwable -> 0x0051 }
        r0 = "pref";
        r1 = "mpn";
        r2 = O00oOoOo;	 Catch:{ Throwable -> 0x0051 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x0051 }
        O00oOoOo = r0;	 Catch:{ Throwable -> 0x0051 }
        r0 = "pref";
        r1 = "igu";
        r2 = O000O0o0;	 Catch:{ Throwable -> 0x0051 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x0051 }
        O000O0o0 = r0;	 Catch:{ Throwable -> 0x0051 }
        r0 = "pref";
        r1 = "ms";
        r2 = O000O0o;	 Catch:{ Throwable -> 0x0051 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x0051 }
        O000O0o = r0;	 Catch:{ Throwable -> 0x0051 }
        r0 = O000O0Oo;	 Catch:{ Throwable -> 0x0051 }
        r1 = O000O0o0;	 Catch:{ Throwable -> 0x0051 }
        r2 = O000O0o;	 Catch:{ Throwable -> 0x0051 }
        com.loc.O00Oo.O000000o(r0, r1, r2);	 Catch:{ Throwable -> 0x0051 }
    L_0x0051:
        r0 = "pref";
        r1 = "ca";
        r2 = O00O0Oo;	 Catch:{ Throwable -> 0x0069 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x0069 }
        O00O0Oo = r0;	 Catch:{ Throwable -> 0x0069 }
        r0 = "pref";
        r1 = "ct";
        r2 = O000OoO;	 Catch:{ Throwable -> 0x0069 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x0069 }
        O000OoO = r0;	 Catch:{ Throwable -> 0x0069 }
    L_0x0069:
        r0 = "pref";
        r1 = "fr";
        r2 = O0000OOo;	 Catch:{ Throwable -> 0x0075 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x0075 }
        O0000OOo = r0;	 Catch:{ Throwable -> 0x0075 }
    L_0x0075:
        r0 = "pref";
        r1 = "ok0";
        r2 = O000o0O;	 Catch:{ Throwable -> 0x00a5 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x00a5 }
        O000o0O = r0;	 Catch:{ Throwable -> 0x00a5 }
        r0 = "pref";
        r1 = "ok1";
        r2 = O0000Oo0;	 Catch:{ Throwable -> 0x00a5 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x00a5 }
        O0000Oo0 = r0;	 Catch:{ Throwable -> 0x00a5 }
        r0 = "pref";
        r1 = "ok2";
        r2 = O000o0OO;	 Catch:{ Throwable -> 0x00a5 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x00a5 }
        O000o0OO = r0;	 Catch:{ Throwable -> 0x00a5 }
        r0 = "pref";
        r1 = "ok3";
        r2 = O000o0Oo;	 Catch:{ Throwable -> 0x00a5 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x00a5 }
        O000o0Oo = r0;	 Catch:{ Throwable -> 0x00a5 }
    L_0x00a5:
        r0 = "pref";
        r1 = "asw";
        r2 = O000o0o;	 Catch:{ Throwable -> 0x00b1 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x00b1 }
        O000o0o = r0;	 Catch:{ Throwable -> 0x00b1 }
    L_0x00b1:
        r0 = "pref";
        r1 = "awsi";
        r2 = O000o0oo;	 Catch:{ Throwable -> 0x00bd }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x00bd }
        O000o0oo = r0;	 Catch:{ Throwable -> 0x00bd }
    L_0x00bd:
        r0 = "pref";
        r1 = "15ua";
        r2 = O000o;	 Catch:{ Throwable -> 0x00e1 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x00e1 }
        O000o = r0;	 Catch:{ Throwable -> 0x00e1 }
        r0 = "pref";
        r1 = "15un";
        r2 = O000oO00;	 Catch:{ Throwable -> 0x00e1 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x00e1 }
        O000oO00 = r0;	 Catch:{ Throwable -> 0x00e1 }
        r0 = "pref";
        r1 = "15ust";
        r2 = O000oO0;	 Catch:{ Throwable -> 0x00e1 }
        r0 = com.loc.OO0000o.O00000Oo(r4, r0, r1, r2);	 Catch:{ Throwable -> 0x00e1 }
        O000oO0 = r0;	 Catch:{ Throwable -> 0x00e1 }
    L_0x00e1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OoO0o.O00000oO(android.content.Context):void");
    }

    public static boolean O00000oO() {
        return O0000ooo;
    }

    public static String O00000oo() {
        return O0000OoO;
    }

    public static void O00000oo(Context context) {
        try {
            OO0Oo0 O00000Oo = O0o0000.O00000Oo();
            O00000Oo.O000000o(O000O0OO);
            O0000o.O000000o(context, O00000Oo);
        } catch (Throwable unused) {
        }
    }

    public static String O0000O0o() {
        return O0000Ooo;
    }

    public static boolean O0000O0o(Context context) {
        boolean z = O000OooO != -1 && O000OooO < O000Oooo;
        if (!O000Ooo0 || O000OooO == 0 || O000Oooo == 0 || O000Ooo == 0 || z) {
            return false;
        }
        if (O000o000 != null && O000o000.size() > 0) {
            for (String O00000Oo : O000o000) {
                if (OO000OO.O00000Oo(context, O00000Oo)) {
                    return false;
                }
            }
        }
        if (O000OooO == -1 && O000Oooo == -1) {
            return true;
        }
        long O00000Oo2 = OO0000o.O00000Oo(context, "pref", "ots", 0);
        long O00000Oo3 = OO0000o.O00000Oo(context, "pref", "otsh", 0);
        int O00000Oo4 = OO0000o.O00000Oo(context, "pref", "otn", 0);
        int O00000Oo5 = OO0000o.O00000Oo(context, "pref", "otnh", 0);
        if (O000OooO != -1) {
            if (!OO000OO.O00000Oo(O000Ooo, O00000Oo2)) {
                try {
                    Editor edit = context.getSharedPreferences("pref", 0).edit();
                    edit.putLong("ots", O000Ooo);
                    edit.putLong("otsh", O000Ooo);
                    edit.putInt("otn", 0);
                    edit.putInt("otnh", 0);
                    OO0000o.O000000o(edit);
                } catch (Throwable th) {
                    O0o0000.O000000o(th, "AuthUtil", "resetPrefsBind");
                }
                OO0000o.O000000o(context, "pref", "otn", 1);
                OO0000o.O000000o(context, "pref", "otnh", 1);
                return true;
            } else if (O00000Oo4 < O000OooO) {
                if (O000Oooo == -1) {
                    OO0000o.O000000o(context, "pref", "otn", O00000Oo4 + 1);
                    OO0000o.O000000o(context, "pref", "otnh", 0);
                    return true;
                } else if (!OO000OO.O000000o(O000Ooo, O00000Oo3)) {
                    OO0000o.O000000o(context, "pref", "otsh", O000Ooo);
                    OO0000o.O000000o(context, "pref", "otn", O00000Oo4 + 1);
                    OO0000o.O000000o(context, "pref", "otnh", 1);
                    return true;
                } else if (O00000Oo5 < O000Oooo) {
                    O00000Oo5++;
                    OO0000o.O000000o(context, "pref", "otn", O00000Oo4 + 1);
                    OO0000o.O000000o(context, "pref", "otnh", O00000Oo5);
                    return true;
                }
            }
        }
        if (O000OooO == -1) {
            OO0000o.O000000o(context, "pref", "otn", 0);
            if (O000Oooo == -1) {
                OO0000o.O000000o(context, "pref", "otnh", 0);
                return true;
            } else if (!OO000OO.O000000o(O000Ooo, O00000Oo3)) {
                OO0000o.O000000o(context, "pref", "otsh", O000Ooo);
                OO0000o.O000000o(context, "pref", "otnh", 1);
                return true;
            } else if (O00000Oo5 < O000Oooo) {
                OO0000o.O000000o(context, "pref", "otnh", O00000Oo5 + 1);
                return true;
            }
        }
        return false;
    }

    public static String O0000OOo() {
        return O0000o00;
    }

    public static boolean O0000OOo(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (OO000OO.O00000o0() - O00000oo >= ((long) O00000o)) {
                O0000O0o = true;
                return true;
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "Aps", "isConfigNeedUpdate");
        }
        return false;
    }

    public static String O0000Oo() {
        return O0000o0O;
    }

    private static void O0000Oo(Context context) {
        try {
            Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("pushSerTime", O000OOo);
            edit.putInt("pushCount", 0);
            OO0000o.O000000o(edit);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AuthUtil", "resetPrefsBind");
        }
    }

    public static String O0000Oo0() {
        return O0000o0;
    }

    private static void O0000Oo0(Context context) {
        try {
            Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("nowtime", O000OO0o);
            edit.putInt("count", 0);
            OO0000o.O000000o(edit);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AuthUtil", "resetPrefsBind");
        }
    }

    public static String O0000OoO() {
        return O0000o0o;
    }

    public static boolean O0000Ooo() {
        return O00000Oo;
    }

    public static boolean O0000o() {
        return O000O0oO;
    }

    public static ArrayList<String> O0000o0() {
        return O000OOoO;
    }

    public static ArrayList<String> O0000o00() {
        return O000OO;
    }

    public static boolean O0000o0O() {
        return O000O0OO;
    }

    public static int O0000o0o() {
        return O00oOoOo;
    }

    public static boolean O0000oO() {
        return O000Oo0O;
    }

    public static void O0000oO0() {
        O000O0oO = false;
    }

    public static long O0000oOO() {
        return O000OoO;
    }

    public static boolean O0000oOo() {
        return O00O0Oo;
    }

    public static List<O0o0> O0000oo() {
        return O000OoOo;
    }

    public static boolean O0000oo0() {
        return O000OoOO;
    }

    public static boolean O0000ooO() {
        return O000o00;
    }

    public static int O0000ooo() {
        return O000o00O;
    }

    public static boolean O000O00o() {
        if (!O0000O0o) {
            return O0000O0o;
        }
        O0000O0o = false;
        return true;
    }

    public static boolean O000O0OO() {
        return O0000OOo;
    }

    public static boolean O000O0Oo() {
        return O000o0O;
    }

    public static int O000O0o() {
        return O000o0o0;
    }

    public static boolean O000O0o0() {
        return O000o0OO;
    }

    public static boolean O000O0oO() {
        return O0000Oo0;
    }

    public static boolean O000O0oo() {
        return O000o0o;
    }

    public static int O000OO() {
        return O000oO00;
    }

    public static long O000OO00() {
        return O000o0oo;
    }

    public static boolean O000OO0o() {
        return O000o && O000oO00 > 0;
    }

    public static long O000OOOo() {
        return O000oO0;
    }

    public static boolean O00oOoOo() {
        return O000o0Oo;
    }

    public static boolean O00oOooO() {
        return O000o0;
    }

    public static boolean O00oOooo() {
        return O000o0O0;
    }
}
