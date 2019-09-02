package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LocalDexSoInfo */
public class oO0O00o0 {
    private static volatile String O0000Oo = null;
    private static String O0000Oo0 = "";
    private oO00OO0O O000000o;
    private kr O00000Oo;
    private boolean O00000o;
    private String O00000o0;
    private boolean O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;
    private boolean O0000OOo = false;

    public oO0O00o0(oO00OO0O oo00oo0o, kr krVar, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        this.O000000o = oo00oo0o;
        this.O00000Oo = krVar;
        this.O00000o0 = str;
        this.O0000O0o = z;
        this.O00000o = z2;
        this.O00000oO = z3;
        this.O00000oo = z4;
    }

    public static oO0O00o0 O000000o() {
        return new oO0O00o0(null, null, null, false, false, false, false);
    }

    public static oO0O00o0 O000000o(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(O0000Oo)) {
            return O000000o(O0000Oo);
        }
        String O000000o = t.O000000o(context, O0000Oo(), "INFO_KEY");
        O0000Oo = O000000o;
        return O000000o(O000000o);
    }

    public static oO0O00o0 O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return O000000o();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optString("fk", "");
            String optString = jSONObject.optString("fs", "");
            boolean optBoolean = jSONObject.optBoolean("fh", false);
            boolean optBoolean2 = jSONObject.optBoolean("fj", false);
            boolean optBoolean3 = jSONObject.optBoolean("fm", false);
            String optString2 = jSONObject.optString("fl", "");
            boolean optBoolean4 = jSONObject.optBoolean("cck", false);
            oO0O00o0 oo0o00o0 = new oO0O00o0(oO00OO0O.O000000o(str), kr.O00000Oo(optString), optString2, optBoolean3, optBoolean, optBoolean2, false);
            oo0o00o0.O000000o(optBoolean4);
            return oo0o00o0;
        } catch (Throwable unused) {
            return O000000o();
        }
    }

    public static boolean O000000o(Context context, oO0O00o0 oo0o00o0, o0OO0o00 o0oo0o00) {
        if (oo0o00o0 == null) {
            return true;
        }
        if (!oo0o00o0.O00000o(context)) {
            O00000o0(context);
        }
        if (!O000000o(oo0o00o0, o0oo0o00) || oo0o00o0.O00000Oo == null) {
            return true;
        }
        return oo0o00o0.O00000Oo.O00000Oo(x.O000000o(context, o0oo0o00));
    }

    /* JADX WARNING: Missing block: B:12:0x0039, code skipped:
            return false;
     */
    public static boolean O000000o(com.amap.api.mapcore.util.oO0O00o0 r3, com.amap.api.mapcore.util.o0OO0o00 r4) {
        /*
        r0 = 0;
        if (r4 == 0) goto L_0x0039;
    L_0x0003:
        if (r3 != 0) goto L_0x0006;
    L_0x0005:
        goto L_0x0039;
    L_0x0006:
        r1 = r4.O000000o();
        r2 = r3.O000000o;
        r2 = r2.O0000OOo();
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0038;
    L_0x0016:
        r1 = r4.O00000Oo();
        r2 = r3.O000000o;
        r2 = r2.O0000Oo0();
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0038;
    L_0x0026:
        r4 = r4.O00000o0();
        r3 = r3.O000000o;
        r3 = r3.O0000Oo();
        r3 = r4.equals(r3);
        if (r3 == 0) goto L_0x0038;
    L_0x0036:
        r3 = 1;
        return r3;
    L_0x0038:
        return r0;
    L_0x0039:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO0O00o0.O000000o(com.amap.api.mapcore.util.oO0O00o0, com.amap.api.mapcore.util.o0OO0o00):boolean");
    }

    public static void O00000o0(Context context) {
        if (context != null) {
            O0000Oo = null;
            String O0000Oo = O0000Oo();
            String str = "INFO_KEY";
            if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(O0000Oo)) {
                Editor edit = context.getSharedPreferences(O0000Oo, 0).edit();
                edit.putString(str, "");
                edit.commit();
            }
        }
    }

    private static String O0000Oo() {
        if (!TextUtils.isEmpty(O0000Oo0)) {
            return O0000Oo0;
        }
        String O00000Oo = o0OO00o0.O00000Oo("DEX_DOWNLOAD_SO_INFO_SP_KEY");
        O0000Oo0 = O00000Oo;
        return O00000Oo;
    }

    public void O000000o(boolean z) {
        this.O0000OOo = z;
    }

    public String O00000Oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.O000000o != null) {
                jSONObject.put("fk", this.O000000o.O00000oo());
            }
            if (this.O00000Oo != null) {
                jSONObject.put("fs", this.O00000Oo.O00000o0());
            }
            jSONObject.put("fm", this.O0000O0o);
            jSONObject.put("fh", this.O00000o);
            jSONObject.put("fj", this.O00000oO);
            jSONObject.put("fl", this.O00000o0);
            jSONObject.put("cck", this.O0000OOo);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public void O00000Oo(Context context) {
        if (context != null) {
            String O00000Oo = O00000Oo();
            O0000Oo = null;
            t.O000000o(context, O0000Oo(), "INFO_KEY", O00000Oo);
        }
    }

    public void O00000Oo(boolean z) {
        this.O00000o = z;
    }

    public kr O00000o() {
        return this.O00000Oo;
    }

    public void O00000o(boolean z) {
        this.O0000O0o = z;
    }

    /* JADX WARNING: Missing block: B:9:0x0019, code skipped:
            return false;
     */
    public boolean O00000o(android.content.Context r2) {
        /*
        r1 = this;
        r2 = r1.O000000o;
        r0 = 0;
        if (r2 == 0) goto L_0x0019;
    L_0x0005:
        r2 = r1.O000000o;
        r2 = r2.O0000O0o();
        if (r2 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0019;
    L_0x000e:
        r2 = r1.O00000Oo;
        r2 = com.amap.api.mapcore.util.kr.O000000o(r2);
        if (r2 != 0) goto L_0x0017;
    L_0x0016:
        return r0;
    L_0x0017:
        r2 = 1;
        return r2;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO0O00o0.O00000o(android.content.Context):boolean");
    }

    public oO00OO0O O00000o0() {
        return this.O000000o;
    }

    public void O00000o0(boolean z) {
        this.O00000oO = z;
    }

    public boolean O00000oO() {
        return this.O0000OOo;
    }

    public String O00000oo() {
        return this.O00000o0;
    }

    public boolean O0000O0o() {
        return this.O00000o;
    }

    public boolean O0000OOo() {
        return this.O00000oO;
    }

    public boolean O0000Oo0() {
        return this.O0000O0o;
    }
}
