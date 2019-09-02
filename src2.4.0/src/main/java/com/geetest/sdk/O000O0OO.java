package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: BaseHandler */
public abstract class O000O0OO implements O000O0o0 {
    private static final String O00000oO = "O000O0OO";
    protected O000O0OO O000000o;
    protected O0O0o00 O00000Oo;
    protected GT3ConfigBean O00000o;
    protected Context O00000o0;

    public static void O00000o0(O0O0o00 o0O0o00) {
        O0000Oo0 O00000oo = o0O0o00.O00000oo();
        O0OOO00.O000000o(o0O0o00.O00000o0().toString());
        O00000oo.O000000o(o0O0o00.O00000o0().clone());
        if (!TextUtils.isEmpty(O0OOOo0.O00000o0)) {
            O0O0OO.O000000o(O0OOOo0.O00000o0, o0O0o00.O0000O0o().O00000o0(), o0O0o00.O0000O0o().O00000o());
            O0OOOo0.O00000o0 = "";
        }
    }

    public final void O000000o(O000O0OO o000o0oo) {
        this.O000000o = o000o0oo;
    }

    public final void O00000Oo(O0O0o00 o0O0o00) {
        O000O0OO o000o0oo = this;
        while (true) {
            Object obj = null;
            if (o0O0o00 != null) {
                o000o0oo.O00000Oo = o0O0o00;
                o000o0oo.O00000o0 = o0O0o00.O00000o();
                if (o000o0oo.O00000o0 != null) {
                    o000o0oo.O00000o = o0O0o00.O00000oO();
                    if (o000o0oo.O00000o != null) {
                        obj = 1;
                    }
                }
            }
            if (obj == null) {
                O00000o0(o0O0o00);
            }
            if (o000o0oo.O000000o() >= o0O0o00.O000000o()) {
                o000o0oo.O000000o(o0O0o00);
                return;
            } else if (o000o0oo.O000000o != null) {
                o000o0oo = o000o0oo.O000000o;
            } else {
                O00000o0(o0O0o00);
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0132 A:{Catch:{ JSONException -> 0x019e }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012f A:{Catch:{ JSONException -> 0x019e }} */
    public final void O00000o(com.geetest.sdk.O0O0o00 r6) {
        /*
        r5 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "1";
        r2 = com.geetest.sdk.O00O00o0.O0000OOo();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 == 0) goto L_0x0033;
    L_0x0011:
        r1 = "0";
        r2 = com.geetest.sdk.O00O00o0.O00000oo();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 == 0) goto L_0x0033;
    L_0x001d:
        r1 = "0";
        r2 = com.geetest.sdk.O00O00o0.O0000O0o();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 == 0) goto L_0x0033;
    L_0x0029:
        r1 = "1";
        com.geetest.sdk.O00O00o0.O0000O0o(r1);	 Catch:{ JSONException -> 0x019e }
        r1 = "1";
        com.geetest.sdk.O00O00o0.O00000oo(r1);	 Catch:{ JSONException -> 0x019e }
    L_0x0033:
        r1 = "success";
        r2 = com.geetest.sdk.O00O00o0.O00000Oo();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 == 0) goto L_0x0044;
    L_0x003f:
        r1 = "1";
        com.geetest.sdk.O00O00o0.O0000Oo0(r1);	 Catch:{ JSONException -> 0x019e }
    L_0x0044:
        r1 = "0";
        r2 = com.geetest.sdk.O00O00o0.O00000oO();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 != 0) goto L_0x006b;
    L_0x0050:
        r1 = "gt";
        r2 = com.geetest.sdk.O00O00o0.O00000o0();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "challenge";
        r2 = com.geetest.sdk.O00O00o0.O00000o();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "success";
        r2 = com.geetest.sdk.O00O00o0.O000000o();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
    L_0x006b:
        r1 = "a1";
        r2 = com.geetest.sdk.O00O00o0.O00000oO();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "0";
        r2 = com.geetest.sdk.O00O00o0.O00000oO();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 != 0) goto L_0x00e9;
    L_0x0080:
        r1 = "false";
        r2 = com.geetest.sdk.O00O00o0.O000000o();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 != 0) goto L_0x00e9;
    L_0x008c:
        r1 = "t";
        r2 = com.geetest.sdk.O00O00o0.O00000oo();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "0";
        r2 = com.geetest.sdk.O00O00o0.O00000oo();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 != 0) goto L_0x00e9;
    L_0x00a1:
        r1 = "g";
        r2 = com.geetest.sdk.O00O00o0.O0000O0o();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "0";
        r2 = com.geetest.sdk.O00O00o0.O0000O0o();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 != 0) goto L_0x00e9;
    L_0x00b6:
        r1 = "a";
        r2 = com.geetest.sdk.O00O00o0.O0000OOo();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "0";
        r2 = com.geetest.sdk.O00O00o0.O0000OOo();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 != 0) goto L_0x00e9;
    L_0x00cb:
        r1 = "r";
        r2 = com.geetest.sdk.O00O00o0.O0000Oo0();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "0";
        r2 = com.geetest.sdk.O00O00o0.O0000Oo0();	 Catch:{ JSONException -> 0x019e }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x019e }
        if (r1 != 0) goto L_0x00e9;
    L_0x00e0:
        r1 = "re";
        r2 = com.geetest.sdk.O00O00o0.O00000Oo();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
    L_0x00e9:
        r1 = r6.O00000o0();	 Catch:{ JSONException -> 0x019e }
        if (r1 == 0) goto L_0x00fc;
    L_0x00ef:
        r1 = "error";
        r6 = r6.O00000o0();	 Catch:{ JSONException -> 0x019e }
        r6 = r6.O000000o();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r6);	 Catch:{ JSONException -> 0x019e }
    L_0x00fc:
        r6 = r5.O00000o0;	 Catch:{ JSONException -> 0x019e }
        r1 = "os";
        r2 = "android";
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "mo";
        r2 = android.os.Build.BRAND;	 Catch:{ JSONException -> 0x019e }
        if (r2 != 0) goto L_0x010e;
    L_0x010b:
        r2 = "null";
        goto L_0x0126;
    L_0x010e:
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x019e }
        r2.<init>();	 Catch:{ JSONException -> 0x019e }
        r3 = android.os.Build.BRAND;	 Catch:{ JSONException -> 0x019e }
        r2.append(r3);	 Catch:{ JSONException -> 0x019e }
        r3 = android.os.Build.MODEL;	 Catch:{ JSONException -> 0x019e }
        r2.append(r3);	 Catch:{ JSONException -> 0x019e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x019e }
        if (r2 != 0) goto L_0x0124;
    L_0x0123:
        goto L_0x010b;
    L_0x0124:
        r2 = android.os.Build.MODEL;	 Catch:{ JSONException -> 0x019e }
    L_0x0126:
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "ver";
        r2 = android.os.Build.VERSION.RELEASE;	 Catch:{ JSONException -> 0x019e }
        if (r2 != 0) goto L_0x0132;
    L_0x012f:
        r2 = "null";
        goto L_0x0134;
    L_0x0132:
        r2 = android.os.Build.VERSION.RELEASE;	 Catch:{ JSONException -> 0x019e }
    L_0x0134:
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "net";
        r2 = com.geetest.sdk.O0Oo00.O00000Oo(r6);	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "build";
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x019e }
        r2.<init>();	 Catch:{ JSONException -> 0x019e }
        r3 = com.geetest.sdk.O0OoOo.O00000Oo(r6);	 Catch:{ JSONException -> 0x019e }
        r2.append(r3);	 Catch:{ JSONException -> 0x019e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "release";
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x019e }
        r2.<init>();	 Catch:{ JSONException -> 0x019e }
        r3 = com.geetest.sdk.O0OoOo.O00000Oo(r6);	 Catch:{ JSONException -> 0x019e }
        r2.append(r3);	 Catch:{ JSONException -> 0x019e }
        r3 = ".0";
        r2.append(r3);	 Catch:{ JSONException -> 0x019e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "vendor";
        r2 = com.geetest.sdk.O0OoOo.O00000o0(r6);	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "time";
        r2 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x019e }
        r2.<init>();	 Catch:{ JSONException -> 0x019e }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x019e }
        r2.append(r3);	 Catch:{ JSONException -> 0x019e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x019e }
        r1 = "imei";
        r6 = com.geetest.sdk.O0OoOo.O000000o(r6);	 Catch:{ JSONException -> 0x019e }
        r0.put(r1, r6);	 Catch:{ JSONException -> 0x019e }
        r6 = "gt3";
        r1 = "4.0.7";
        r0.put(r6, r1);	 Catch:{ JSONException -> 0x019e }
        goto L_0x01a2;
    L_0x019e:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x01a2:
        r6 = r5.O00000o;
        if (r6 == 0) goto L_0x01bb;
    L_0x01a6:
        r6 = r5.O00000o;
        r6 = r6.getListener();
        if (r6 == 0) goto L_0x01bb;
    L_0x01ae:
        r6 = r5.O00000o;
        r6 = r6.getListener();
        r0 = r0.toString();
        r6.onStatistics(r0);
    L_0x01bb:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.O000O0OO.O00000o(com.geetest.sdk.O0O0o00):void");
    }
}
