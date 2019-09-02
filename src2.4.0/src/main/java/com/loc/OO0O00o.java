package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.tencent.open.SocialConstants;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthConfigManager */
public final class OO0O00o {
    public static int O000000o = -1;
    public static String O00000Oo = "";

    /* compiled from: AuthConfigManager */
    public static class O000000o {
        public String O000000o;
        public int O00000Oo = -1;
        @Deprecated
        public JSONObject O00000o;
        @Deprecated
        public JSONObject O00000o0;
        @Deprecated
        public JSONObject O00000oO;
        @Deprecated
        public JSONObject O00000oo;
        @Deprecated
        public JSONObject O0000O0o;
        @Deprecated
        public JSONObject O0000OOo;
        @Deprecated
        public JSONObject O0000Oo;
        @Deprecated
        public JSONObject O0000Oo0;
        @Deprecated
        public JSONObject O0000OoO;
        @Deprecated
        public JSONObject O0000Ooo;
        @Deprecated
        public JSONObject O0000o;
        @Deprecated
        public JSONObject O0000o0;
        @Deprecated
        public JSONObject O0000o00;
        @Deprecated
        public JSONObject O0000o0O;
        @Deprecated
        public JSONObject O0000o0o;
        @Deprecated
        public JSONObject O0000oO;
        @Deprecated
        public JSONObject O0000oO0;
        @Deprecated
        public JSONObject O0000oOO;
        @Deprecated
        public JSONObject O0000oOo;
        public JSONObject O0000oo;
        @Deprecated
        public JSONObject O0000oo0;
        public O000000o O0000ooO;
        public O00000o O0000ooo;
        public O00000o0 O000O00o;
        public O00000Oo O000O0OO;
        public O00000Oo O000O0Oo;
        public O0000O0o O000O0o;
        public O00000Oo O000O0o0;
        public O00000Oo O00oOoOo;
        public O0000OOo O00oOooO;
        @Deprecated
        public O00000o0 O00oOooo;

        /* compiled from: AuthConfigManager */
        public static class O000000o {
            public boolean O000000o;
            public boolean O00000Oo;
            public JSONObject O00000o0;
        }

        /* compiled from: AuthConfigManager */
        public static class O00000Oo {
            public boolean O000000o;
            public String O00000Oo;
            public String O00000o;
            public String O00000o0;
            public boolean O00000oO;
        }

        /* compiled from: AuthConfigManager */
        public static class O00000o0 {
            public String O000000o;
            public String O00000Oo;
        }

        /* compiled from: AuthConfigManager */
        public static class O00000o {
            public String O000000o;
            public String O00000Oo;
            public String O00000o0;
        }

        /* compiled from: AuthConfigManager */
        public static class O0000O0o {
            public boolean O000000o;
            public boolean O00000Oo;
            public String O00000o;
            public boolean O00000o0;
            public String O00000oO;
            public String O00000oo;
        }

        /* compiled from: AuthConfigManager */
        public static class O0000OOo {
            public boolean O000000o;
        }
    }

    /* compiled from: AuthConfigManager */
    static class O00000Oo extends O00OO0O {
        private String O00000oo;
        private Map<String, String> O0000O0o = null;
        private boolean O0000OOo;

        O00000Oo(Context context, OO0Oo0 oO0Oo0, String str) {
            super(context, oO0Oo0);
            this.O00000oo = str;
            this.O0000OOo = VERSION.SDK_INT != 19;
        }

        public final Map<String, String> O000000o() {
            return null;
        }

        public final String O00000o0() {
            return this.O0000OOo ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }

        /* Access modifiers changed, original: protected|final */
        public final String O0000O0o() {
            return "3.0";
        }

        public final byte[] O0000OOo() {
            return null;
        }

        public final byte[] O0000Oo0() {
            Object O0000oo0 = OO0O0o0.O0000oo0(this.O000000o);
            if (TextUtils.isEmpty(O0000oo0)) {
                O0000oo0 = OO0O0o0.O0000Oo0(this.O000000o);
            }
            if (!TextUtils.isEmpty(O0000oo0)) {
                O0000oo0 = OO0OOOO.O00000Oo(new StringBuilder(O0000oo0).reverse().toString());
            }
            Map hashMap = new HashMap();
            hashMap.put("authkey", this.O00000oo);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.O00000Oo.O000000o());
            hashMap.put("version", this.O00000Oo.O00000Oo());
            hashMap.put("output", "json");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(VERSION.SDK_INT);
            hashMap.put("androidversion", stringBuilder.toString());
            hashMap.put("deviceId", O0000oo0);
            hashMap.put("manufacture", Build.MANUFACTURER);
            if (!(this.O0000O0o == null || this.O0000O0o.isEmpty())) {
                hashMap.putAll(this.O0000O0o);
            }
            hashMap.put("abitype", OO0o000.O000000o(this.O000000o));
            hashMap.put("ext", this.O00000Oo.O00000o());
            return OO0o000.O000000o(OO0o000.O000000o(hashMap));
        }

        public final boolean O0000o00() {
            return this.O0000OOo;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5 A:{RETURN} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0088 */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A:{SYNTHETIC, PHI: r13 , Splitter:B:1:0x0013, ExcHandler: IllegalBlockSizeException (unused javax.crypto.IllegalBlockSizeException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:32:0x0092, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:33:0x0093, code skipped:
            r3 = r13;
            r13 = null;
            r5 = r4;
            r4 = r13;
     */
    /* JADX WARNING: Missing block: B:35:0x009f, code skipped:
            r3 = r13;
     */
    /* JADX WARNING: Missing block: B:39:0x00a3, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:40:0x00a4, code skipped:
            r3 = r13;
            r13 = null;
            r5 = r4;
            r4 = r13;
     */
    public static com.loc.OO0O00o.O000000o O000000o(android.content.Context r11, com.loc.OO0Oo0 r12, java.lang.String r13, boolean r14) {
        /*
        r0 = new com.loc.OO0O00o$O000000o;
        r0.<init>();
        r1 = new org.json.JSONObject;
        r1.<init>();
        r0.O0000oo = r1;
        r1 = com.loc.OO0OO0o.O000000o.O000000o;
        r1.O000000o(r11);
        r1 = 0;
        r2 = 0;
        r3 = new com.loc.O00O0o;	 Catch:{ OO00Oo0 -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
        r3.<init>();	 Catch:{ OO00Oo0 -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
        r3 = new java.lang.StringBuilder;	 Catch:{ OO00Oo0 -> 0x0090, Throwable -> 0x0088, IllegalBlockSizeException -> 0x009f }
        r3.<init>();	 Catch:{ OO00Oo0 -> 0x0090, Throwable -> 0x0088, IllegalBlockSizeException -> 0x009f }
        r3.append(r13);	 Catch:{ OO00Oo0 -> 0x0090, Throwable -> 0x0088, IllegalBlockSizeException -> 0x009f }
        r4 = ";14N;15K";
        r3.append(r4);	 Catch:{ OO00Oo0 -> 0x0090, Throwable -> 0x0088, IllegalBlockSizeException -> 0x009f }
        r3 = r3.toString();	 Catch:{ OO00Oo0 -> 0x0090, Throwable -> 0x0088, IllegalBlockSizeException -> 0x009f }
        r13 = new com.loc.OO0O00o$O00000Oo;	 Catch:{ OO00Oo0 -> 0x0083, Throwable -> 0x0081, IllegalBlockSizeException -> 0x00a0 }
        r13.<init>(r11, r12, r3);	 Catch:{ OO00Oo0 -> 0x0083, Throwable -> 0x0081, IllegalBlockSizeException -> 0x00a0 }
        r4 = r13.O0000o00();	 Catch:{ OO00Oo0 -> 0x0083, Throwable -> 0x0081, IllegalBlockSizeException -> 0x00a0 }
        r13 = com.loc.O00O0o.O000000o(r13, r4);	 Catch:{ OO00Oo0 -> 0x0083, Throwable -> 0x0081, IllegalBlockSizeException -> 0x00a0 }
        if (r13 == 0) goto L_0x0048;
    L_0x0038:
        r4 = r13.O000000o;	 Catch:{ OO00Oo0 -> 0x0043, IllegalBlockSizeException -> 0x0040, Throwable -> 0x003b }
        goto L_0x0049;
    L_0x003b:
        r4 = move-exception;
        r5 = r4;
        r4 = r1;
        goto L_0x0097;
    L_0x0040:
        r4 = r1;
        goto L_0x00b3;
    L_0x0043:
        r4 = move-exception;
        r5 = r4;
        r4 = r1;
        goto L_0x00a8;
    L_0x0048:
        r4 = r1;
    L_0x0049:
        r5 = 16;
        r6 = new byte[r5];	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r7 = r4.length;	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r7 = r7 - r5;
        r7 = new byte[r7];	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        java.lang.System.arraycopy(r4, r2, r6, r2, r5);	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r8 = r4.length;	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r8 = r8 - r5;
        java.lang.System.arraycopy(r4, r5, r7, r2, r8);	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r5 = new javax.crypto.spec.SecretKeySpec;	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r8 = "AES";
        r5.<init>(r6, r8);	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r6 = "AES/CBC/PKCS5Padding";
        r6 = javax.crypto.Cipher.getInstance(r6);	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r8 = new javax.crypto.spec.IvParameterSpec;	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r9 = com.loc.OO0o000.O00000o0();	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r8.<init>(r9);	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r9 = 2;
        r6.init(r9, r5, r8);	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r5 = r6.doFinal(r7);	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r5 = com.loc.OO0o000.O000000o(r5);	 Catch:{ OO00Oo0 -> 0x007f, IllegalBlockSizeException -> 0x00b3, Throwable -> 0x007d }
        r1 = r5;
        goto L_0x00b3;
    L_0x007d:
        r5 = move-exception;
        goto L_0x0097;
    L_0x007f:
        r5 = move-exception;
        goto L_0x00a8;
    L_0x0081:
        r13 = r3;
        goto L_0x0088;
    L_0x0083:
        r13 = move-exception;
        r10 = r3;
        r3 = r13;
        r13 = r10;
        goto L_0x0091;
    L_0x0088:
        r3 = new com.loc.OO00Oo0;	 Catch:{ OO00Oo0 -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
        r4 = "未知的错误";
        r3.<init>(r4);	 Catch:{ OO00Oo0 -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
        throw r3;	 Catch:{ OO00Oo0 -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
    L_0x0090:
        r3 = move-exception;
    L_0x0091:
        throw r3;	 Catch:{ OO00Oo0 -> 0x00a3, IllegalBlockSizeException -> 0x009f, Throwable -> 0x0092 }
    L_0x0092:
        r4 = move-exception;
        r3 = r13;
        r13 = r1;
        r5 = r4;
        r4 = r13;
    L_0x0097:
        r6 = "at";
        r7 = "lc";
        com.loc.O0000o.O00000Oo(r5, r6, r7);
        goto L_0x00b3;
    L_0x009f:
        r3 = r13;
    L_0x00a0:
        r13 = r1;
        r4 = r13;
        goto L_0x00b3;
    L_0x00a3:
        r4 = move-exception;
        r3 = r13;
        r13 = r1;
        r5 = r4;
        r4 = r13;
    L_0x00a8:
        r6 = r5.O000000o();
        r0.O000000o = r6;
        r6 = "/v3/iasdkauth";
        com.loc.O0000o.O000000o(r12, r6, r5);
    L_0x00b3:
        if (r4 != 0) goto L_0x00b6;
    L_0x00b5:
        return r0;
    L_0x00b6:
        r5 = android.text.TextUtils.isEmpty(r1);
        if (r5 == 0) goto L_0x00c0;
    L_0x00bc:
        r1 = com.loc.OO0o000.O000000o(r4);
    L_0x00c0:
        r4 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0328 }
        r4.<init>(r1);	 Catch:{ Throwable -> 0x0328 }
        r1 = "status";
        r1 = r4.has(r1);	 Catch:{ Throwable -> 0x0328 }
        if (r1 == 0) goto L_0x0330;
    L_0x00cd:
        r1 = "status";
        r1 = r4.getInt(r1);	 Catch:{ Throwable -> 0x0328 }
        r5 = 1;
        if (r1 != r5) goto L_0x00d9;
    L_0x00d6:
        O000000o = r5;	 Catch:{ Throwable -> 0x0328 }
        goto L_0x011a;
    L_0x00d9:
        if (r1 != 0) goto L_0x011a;
    L_0x00db:
        r1 = "authcsid";
        r5 = "authgsid";
        if (r13 == 0) goto L_0x00e5;
    L_0x00e1:
        r1 = r13.O00000o0;	 Catch:{ Throwable -> 0x0328 }
        r5 = r13.O00000o;	 Catch:{ Throwable -> 0x0328 }
    L_0x00e5:
        com.loc.OO0o000.O000000o(r11, r1, r5, r4);	 Catch:{ Throwable -> 0x0328 }
        O000000o = r2;	 Catch:{ Throwable -> 0x0328 }
        r13 = "info";
        r13 = r4.has(r13);	 Catch:{ Throwable -> 0x0328 }
        if (r13 == 0) goto L_0x00fa;
    L_0x00f2:
        r13 = "info";
        r13 = r4.getString(r13);	 Catch:{ Throwable -> 0x0328 }
        O00000Oo = r13;	 Catch:{ Throwable -> 0x0328 }
    L_0x00fa:
        r13 = "";
        r1 = "infocode";
        r1 = r4.has(r1);	 Catch:{ Throwable -> 0x0328 }
        if (r1 == 0) goto L_0x010a;
    L_0x0104:
        r13 = "infocode";
        r13 = r4.getString(r13);	 Catch:{ Throwable -> 0x0328 }
    L_0x010a:
        r1 = "/v3/iasdkauth";
        r6 = O00000Oo;	 Catch:{ Throwable -> 0x0328 }
        com.loc.O0000o.O000000o(r12, r1, r6, r5, r13);	 Catch:{ Throwable -> 0x0328 }
        r12 = O000000o;	 Catch:{ Throwable -> 0x0328 }
        if (r12 != 0) goto L_0x011a;
    L_0x0115:
        r11 = O00000Oo;	 Catch:{ Throwable -> 0x0328 }
        r0.O000000o = r11;	 Catch:{ Throwable -> 0x0328 }
        return r0;
    L_0x011a:
        r12 = "ver";
        r12 = r4.has(r12);	 Catch:{ Throwable -> 0x012b }
        if (r12 == 0) goto L_0x0133;
    L_0x0122:
        r12 = "ver";
        r12 = r4.getInt(r12);	 Catch:{ Throwable -> 0x012b }
        r0.O00000Oo = r12;	 Catch:{ Throwable -> 0x012b }
        goto L_0x0133;
    L_0x012b:
        r12 = move-exception;
        r13 = "at";
        r1 = "lc";
        com.loc.O0000Oo.O000000o(r12, r13, r1);	 Catch:{ Throwable -> 0x0328 }
    L_0x0133:
        r12 = "result";
        r12 = com.loc.OO0o000.O000000o(r4, r12);	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x0330;
    L_0x013b:
        r12 = new com.loc.OO0O00o$O000000o$O000000o;	 Catch:{ Throwable -> 0x0328 }
        r12.<init>();	 Catch:{ Throwable -> 0x0328 }
        r12.O000000o = r2;	 Catch:{ Throwable -> 0x0328 }
        r12.O00000Oo = r2;	 Catch:{ Throwable -> 0x0328 }
        r0.O0000ooO = r12;	 Catch:{ Throwable -> 0x0328 }
        r13 = "result";
        r13 = r4.getJSONObject(r13);	 Catch:{ Throwable -> 0x0328 }
        r1 = ";";
        r1 = r3.split(r1);	 Catch:{ Throwable -> 0x016f }
        if (r1 == 0) goto L_0x0177;
    L_0x0154:
        r3 = r1.length;	 Catch:{ Throwable -> 0x016f }
        if (r3 <= 0) goto L_0x0177;
    L_0x0157:
        r3 = r1.length;	 Catch:{ Throwable -> 0x016f }
        r4 = r2;
    L_0x0159:
        if (r4 >= r3) goto L_0x0177;
    L_0x015b:
        r5 = r1[r4];	 Catch:{ Throwable -> 0x016f }
        r6 = r13.has(r5);	 Catch:{ Throwable -> 0x016f }
        if (r6 == 0) goto L_0x016c;
    L_0x0163:
        r6 = r0.O0000oo;	 Catch:{ Throwable -> 0x016f }
        r7 = r13.get(r5);	 Catch:{ Throwable -> 0x016f }
        r6.putOpt(r5, r7);	 Catch:{ Throwable -> 0x016f }
    L_0x016c:
        r4 = r4 + 1;
        goto L_0x0159;
    L_0x016f:
        r1 = move-exception;
        r3 = "at";
        r4 = "co";
        com.loc.O0000Oo.O000000o(r1, r3, r4);	 Catch:{ Throwable -> 0x0328 }
    L_0x0177:
        r1 = "11K";
        r1 = com.loc.OO0o000.O000000o(r13, r1);	 Catch:{ Throwable -> 0x0328 }
        if (r1 == 0) goto L_0x01aa;
    L_0x017f:
        r1 = "11K";
        r1 = r13.getJSONObject(r1);	 Catch:{ Throwable -> 0x01a2 }
        r3 = "able";
        r3 = r1.getString(r3);	 Catch:{ Throwable -> 0x01a2 }
        r3 = O000000o(r3, r2);	 Catch:{ Throwable -> 0x01a2 }
        r12.O000000o = r3;	 Catch:{ Throwable -> 0x01a2 }
        r3 = "off";
        r3 = r1.has(r3);	 Catch:{ Throwable -> 0x01a2 }
        if (r3 == 0) goto L_0x01aa;
    L_0x0199:
        r3 = "off";
        r1 = r1.getJSONObject(r3);	 Catch:{ Throwable -> 0x01a2 }
        r12.O00000o0 = r1;	 Catch:{ Throwable -> 0x01a2 }
        goto L_0x01aa;
    L_0x01a2:
        r12 = move-exception;
        r1 = "AuthConfigManager";
        r3 = "loadException";
        com.loc.O0000Oo.O000000o(r12, r1, r3);	 Catch:{ Throwable -> 0x0328 }
    L_0x01aa:
        r12 = "001";
        r12 = com.loc.OO0o000.O000000o(r13, r12);	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x01f5;
    L_0x01b2:
        r12 = "001";
        r12 = r13.getJSONObject(r12);	 Catch:{ Throwable -> 0x0328 }
        r1 = new com.loc.OO0O00o$O000000o$O00000o;	 Catch:{ Throwable -> 0x0328 }
        r1.<init>();	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x01f3;
    L_0x01bf:
        r3 = "md5";
        r3 = O000000o(r12, r3);	 Catch:{ Throwable -> 0x01eb }
        r4 = "url";
        r4 = O000000o(r12, r4);	 Catch:{ Throwable -> 0x01eb }
        r5 = "sdkversion";
        r12 = O000000o(r12, r5);	 Catch:{ Throwable -> 0x01eb }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x01eb }
        if (r5 != 0) goto L_0x01f3;
    L_0x01d7:
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x01eb }
        if (r5 != 0) goto L_0x01f3;
    L_0x01dd:
        r5 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Throwable -> 0x01eb }
        if (r5 == 0) goto L_0x01e4;
    L_0x01e3:
        goto L_0x01f3;
    L_0x01e4:
        r1.O000000o = r4;	 Catch:{ Throwable -> 0x01eb }
        r1.O00000Oo = r3;	 Catch:{ Throwable -> 0x01eb }
        r1.O00000o0 = r12;	 Catch:{ Throwable -> 0x01eb }
        goto L_0x01f3;
    L_0x01eb:
        r12 = move-exception;
        r3 = "at";
        r4 = "psu";
        com.loc.O0000Oo.O000000o(r12, r3, r4);	 Catch:{ Throwable -> 0x0328 }
    L_0x01f3:
        r0.O0000ooo = r1;	 Catch:{ Throwable -> 0x0328 }
    L_0x01f5:
        r12 = "002";
        r12 = com.loc.OO0o000.O000000o(r13, r12);	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x020d;
    L_0x01fd:
        r12 = "002";
        r12 = r13.getJSONObject(r12);	 Catch:{ Throwable -> 0x0328 }
        r1 = new com.loc.OO0O00o$O000000o$O00000o0;	 Catch:{ Throwable -> 0x0328 }
        r1.<init>();	 Catch:{ Throwable -> 0x0328 }
        O000000o(r12, r1);	 Catch:{ Throwable -> 0x0328 }
        r0.O00oOooo = r1;	 Catch:{ Throwable -> 0x0328 }
    L_0x020d:
        r12 = "14S";
        r12 = com.loc.OO0o000.O000000o(r13, r12);	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x0225;
    L_0x0215:
        r12 = "14S";
        r12 = r13.getJSONObject(r12);	 Catch:{ Throwable -> 0x0328 }
        r1 = new com.loc.OO0O00o$O000000o$O00000o0;	 Catch:{ Throwable -> 0x0328 }
        r1.<init>();	 Catch:{ Throwable -> 0x0328 }
        O000000o(r12, r1);	 Catch:{ Throwable -> 0x0328 }
        r0.O000O00o = r1;	 Catch:{ Throwable -> 0x0328 }
    L_0x0225:
        O000000o(r0, r13);	 Catch:{ Throwable -> 0x0328 }
        r12 = "14Z";
        r12 = com.loc.OO0o000.O000000o(r13, r12);	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x0282;
    L_0x0230:
        r12 = "14Z";
        r12 = r13.getJSONObject(r12);	 Catch:{ Throwable -> 0x0328 }
        r1 = new com.loc.OO0O00o$O000000o$O0000O0o;	 Catch:{ Throwable -> 0x0328 }
        r1.<init>();	 Catch:{ Throwable -> 0x0328 }
        r3 = "md5";
        r3 = O000000o(r12, r3);	 Catch:{ Throwable -> 0x0278 }
        r4 = "md5info";
        r4 = O000000o(r12, r4);	 Catch:{ Throwable -> 0x0278 }
        r5 = "url";
        r5 = O000000o(r12, r5);	 Catch:{ Throwable -> 0x0278 }
        r6 = "able";
        r6 = O000000o(r12, r6);	 Catch:{ Throwable -> 0x0278 }
        r7 = "on";
        r7 = O000000o(r12, r7);	 Catch:{ Throwable -> 0x0278 }
        r8 = "mobileable";
        r12 = O000000o(r12, r8);	 Catch:{ Throwable -> 0x0278 }
        r1.O00000oO = r3;	 Catch:{ Throwable -> 0x0278 }
        r1.O00000oo = r4;	 Catch:{ Throwable -> 0x0278 }
        r1.O00000o = r5;	 Catch:{ Throwable -> 0x0278 }
        r3 = O000000o(r6, r2);	 Catch:{ Throwable -> 0x0278 }
        r1.O000000o = r3;	 Catch:{ Throwable -> 0x0278 }
        r3 = O000000o(r7, r2);	 Catch:{ Throwable -> 0x0278 }
        r1.O00000Oo = r3;	 Catch:{ Throwable -> 0x0278 }
        r12 = O000000o(r12, r2);	 Catch:{ Throwable -> 0x0278 }
        r1.O00000o0 = r12;	 Catch:{ Throwable -> 0x0278 }
        goto L_0x0280;
    L_0x0278:
        r12 = move-exception;
        r3 = "at";
        r4 = "pes";
        com.loc.O0000Oo.O000000o(r12, r3, r4);	 Catch:{ Throwable -> 0x0328 }
    L_0x0280:
        r0.O000O0o = r1;	 Catch:{ Throwable -> 0x0328 }
    L_0x0282:
        r12 = "151";
        r12 = com.loc.OO0o000.O000000o(r13, r12);	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x02a5;
    L_0x028a:
        r12 = "151";
        r12 = r13.getJSONObject(r12);	 Catch:{ Throwable -> 0x0328 }
        r1 = new com.loc.OO0O00o$O000000o$O0000OOo;	 Catch:{ Throwable -> 0x0328 }
        r1.<init>();	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x02a3;
    L_0x0297:
        r3 = "able";
        r12 = r12.optString(r3);	 Catch:{ Throwable -> 0x0328 }
        r12 = O000000o(r12, r2);	 Catch:{ Throwable -> 0x0328 }
        r1.O000000o = r12;	 Catch:{ Throwable -> 0x0328 }
    L_0x02a3:
        r0.O00oOooO = r1;	 Catch:{ Throwable -> 0x0328 }
    L_0x02a5:
        O000000o(r0, r13);	 Catch:{ Throwable -> 0x0328 }
        r12 = "14N";
        r12 = com.loc.OO0o000.O000000o(r13, r12);	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x02fb;
    L_0x02b0:
        r12 = "14N";
        r12 = r13.getJSONObject(r12);	 Catch:{ Throwable -> 0x0328 }
        r1 = new com.loc.OO0O00o$O000000o$O00000Oo;	 Catch:{ Throwable -> 0x0328 }
        r1.<init>();	 Catch:{ Throwable -> 0x0328 }
        r3 = "able";
        r3 = r12.optString(r3);	 Catch:{ Throwable -> 0x0328 }
        r3 = O000000o(r3, r2);	 Catch:{ Throwable -> 0x0328 }
        r1.O000000o = r3;	 Catch:{ Throwable -> 0x0328 }
        r3 = "url";
        r3 = r12.optString(r3);	 Catch:{ Throwable -> 0x0328 }
        r1.O00000Oo = r3;	 Catch:{ Throwable -> 0x0328 }
        r3 = "md5";
        r12 = r12.optString(r3);	 Catch:{ Throwable -> 0x0328 }
        r1.O00000o0 = r12;	 Catch:{ Throwable -> 0x0328 }
        r12 = r1.O000000o;	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x02f6;
    L_0x02db:
        r12 = com.loc.O0000OOo.O000000o();	 Catch:{ Throwable -> 0x0328 }
        if (r12 == 0) goto L_0x02fb;
    L_0x02e1:
        r3 = new com.loc.O000OOo0;	 Catch:{ Throwable -> 0x0328 }
        r4 = r1.O00000Oo;	 Catch:{ Throwable -> 0x0328 }
        r1 = r1.O00000o0;	 Catch:{ Throwable -> 0x0328 }
        r3.<init>(r4, r1);	 Catch:{ Throwable -> 0x0328 }
        r3.O000000o(r14);	 Catch:{ Throwable -> 0x0328 }
        r14 = new com.loc.O000OOOo;	 Catch:{ Throwable -> 0x0328 }
        r14.<init>(r11, r3, r12);	 Catch:{ Throwable -> 0x0328 }
        r14.O000000o();	 Catch:{ Throwable -> 0x0328 }
        goto L_0x02fb;
    L_0x02f6:
        r12 = "aiu";
        com.loc.O000OOo.O000000o(r11, r12);	 Catch:{ Throwable -> 0x0328 }
    L_0x02fb:
        r12 = "15K";
        r12 = r13.getJSONObject(r12);	 Catch:{ Throwable -> 0x0323 }
        r13 = "isTargetAble";
        r13 = r12.optString(r13);	 Catch:{ Throwable -> 0x0323 }
        r13 = O000000o(r13, r2);	 Catch:{ Throwable -> 0x0323 }
        r14 = "able";
        r12 = r12.optString(r14);	 Catch:{ Throwable -> 0x0323 }
        r12 = O000000o(r12, r2);	 Catch:{ Throwable -> 0x0323 }
        if (r12 != 0) goto L_0x031d;
    L_0x0317:
        r12 = com.loc.OO0OO0o.O000000o.O000000o;	 Catch:{ Throwable -> 0x0323 }
        r12.O00000Oo(r11);	 Catch:{ Throwable -> 0x0323 }
        return r0;
    L_0x031d:
        r12 = com.loc.OO0OO0o.O000000o.O000000o;	 Catch:{ Throwable -> 0x0323 }
        r12.O000000o(r11, r13);	 Catch:{ Throwable -> 0x0323 }
        return r0;
    L_0x0323:
        r11 = move-exception;
        r11.printStackTrace();	 Catch:{ Throwable -> 0x0328 }
        return r0;
    L_0x0328:
        r11 = move-exception;
        r12 = "at";
        r13 = "lc";
        com.loc.O0000Oo.O000000o(r11, r12, r13);
    L_0x0330:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.OO0O00o.O000000o(android.content.Context, com.loc.OO0Oo0, java.lang.String, boolean):com.loc.OO0O00o$O000000o");
    }

    private static String O000000o(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return "";
        }
        String str2 = "";
        if (jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) {
            str2 = jSONObject.optString(str);
        }
        return str2;
    }

    public static void O000000o(Context context, String str) {
        OO00o00.O000000o(context, str);
    }

    private static void O000000o(O000000o o000000o, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2;
            O00000Oo o00000Oo;
            if (OO0o000.O000000o(jSONObject, "11B")) {
                o000000o.O0000OOo = jSONObject.getJSONObject("11B");
            }
            if (OO0o000.O000000o(jSONObject, "11C")) {
                o000000o.O0000OoO = jSONObject.getJSONObject("11C");
            }
            if (OO0o000.O000000o(jSONObject, "11I")) {
                o000000o.O0000Ooo = jSONObject.getJSONObject("11I");
            }
            if (OO0o000.O000000o(jSONObject, "11H")) {
                o000000o.O0000o00 = jSONObject.getJSONObject("11H");
            }
            if (OO0o000.O000000o(jSONObject, "11E")) {
                o000000o.O0000o0 = jSONObject.getJSONObject("11E");
            }
            if (OO0o000.O000000o(jSONObject, "11F")) {
                o000000o.O0000o0O = jSONObject.getJSONObject("11F");
            }
            if (OO0o000.O000000o(jSONObject, "13A")) {
                o000000o.O0000o = jSONObject.getJSONObject("13A");
            }
            if (OO0o000.O000000o(jSONObject, "13J")) {
                o000000o.O0000Oo0 = jSONObject.getJSONObject("13J");
            }
            if (OO0o000.O000000o(jSONObject, "11G")) {
                o000000o.O0000o0o = jSONObject.getJSONObject("11G");
            }
            if (OO0o000.O000000o(jSONObject, "006")) {
                o000000o.O0000oO0 = jSONObject.getJSONObject("006");
            }
            if (OO0o000.O000000o(jSONObject, "010")) {
                o000000o.O0000oO = jSONObject.getJSONObject("010");
            }
            if (OO0o000.O000000o(jSONObject, "11Z")) {
                jSONObject2 = jSONObject.getJSONObject("11Z");
                o00000Oo = new O00000Oo();
                O000000o(jSONObject2, o00000Oo);
                o000000o.O000O0OO = o00000Oo;
            }
            if (OO0o000.O000000o(jSONObject, "135")) {
                o000000o.O0000Oo = jSONObject.getJSONObject("135");
            }
            if (OO0o000.O000000o(jSONObject, "13S")) {
                o000000o.O0000O0o = jSONObject.getJSONObject("13S");
            }
            if (OO0o000.O000000o(jSONObject, "121")) {
                jSONObject2 = jSONObject.getJSONObject("121");
                o00000Oo = new O00000Oo();
                O000000o(jSONObject2, o00000Oo);
                o000000o.O000O0Oo = o00000Oo;
            }
            if (OO0o000.O000000o(jSONObject, "122")) {
                jSONObject2 = jSONObject.getJSONObject("122");
                o00000Oo = new O00000Oo();
                O000000o(jSONObject2, o00000Oo);
                o000000o.O00oOoOo = o00000Oo;
            }
            if (OO0o000.O000000o(jSONObject, "123")) {
                jSONObject2 = jSONObject.getJSONObject("123");
                o00000Oo = new O00000Oo();
                O000000o(jSONObject2, o00000Oo);
                o000000o.O000O0o0 = o00000Oo;
            }
            if (OO0o000.O000000o(jSONObject, "011")) {
                o000000o.O00000o0 = jSONObject.getJSONObject("011");
            }
            if (OO0o000.O000000o(jSONObject, "012")) {
                o000000o.O00000o = jSONObject.getJSONObject("012");
            }
            if (OO0o000.O000000o(jSONObject, "013")) {
                o000000o.O00000oO = jSONObject.getJSONObject("013");
            }
            if (OO0o000.O000000o(jSONObject, "014")) {
                o000000o.O00000oo = jSONObject.getJSONObject("014");
            }
            if (OO0o000.O000000o(jSONObject, "145")) {
                o000000o.O0000oOO = jSONObject.getJSONObject("145");
            }
            if (OO0o000.O000000o(jSONObject, "14B")) {
                o000000o.O0000oOo = jSONObject.getJSONObject("14B");
            }
            if (OO0o000.O000000o(jSONObject, "14D")) {
                o000000o.O0000oo0 = jSONObject.getJSONObject("14D");
            }
        } catch (Throwable th) {
            O0000o.O00000Oo(th, "at", "pe");
        }
    }

    private static void O000000o(JSONObject jSONObject, O00000Oo o00000Oo) {
        if (o00000Oo != null) {
            try {
                String O000000o = O000000o(jSONObject, "m");
                String O000000o2 = O000000o(jSONObject, "u");
                String O000000o3 = O000000o(jSONObject, "v");
                String O000000o4 = O000000o(jSONObject, "able");
                String O000000o5 = O000000o(jSONObject, "on");
                o00000Oo.O00000o0 = O000000o;
                o00000Oo.O00000Oo = O000000o2;
                o00000Oo.O00000o = O000000o3;
                o00000Oo.O000000o = O000000o(O000000o4, false);
                o00000Oo.O00000oO = O000000o(O000000o5, true);
            } catch (Throwable th) {
                O0000Oo.O000000o(th, "at", "pe");
            }
        }
    }

    private static void O000000o(JSONObject jSONObject, O00000o0 o00000o0) {
        if (jSONObject != null) {
            try {
                String O000000o = O000000o(jSONObject, "md5");
                String O000000o2 = O000000o(jSONObject, SocialConstants.PARAM_URL);
                o00000o0.O00000Oo = O000000o;
                o00000o0.O000000o = O000000o2;
            } catch (Throwable th) {
                O0000Oo.O000000o(th, "at", "psc");
            }
        }
    }

    public static boolean O000000o(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split(HttpUtils.PATHS_SEPARATOR);
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z;
        }
    }
}
