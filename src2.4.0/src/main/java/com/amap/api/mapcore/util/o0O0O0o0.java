package com.amap.api.mapcore.util;

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
public class o0O0O0o0 {
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
        public O0000OOo O000O0o;
        public O00000Oo O000O0o0;
        public O00000Oo O00oOoOo;
        public O0000O0o O00oOooO;
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
        }

        /* compiled from: AuthConfigManager */
        public static class O0000OOo {
            public boolean O000000o;
            public boolean O00000Oo;
            public String O00000o;
            public boolean O00000o0;
            public String O00000oO;
            public String O00000oo;
        }
    }

    /* compiled from: AuthConfigManager */
    static class O00000Oo extends ooooO000 {
        private Map<String, String> O00000o;
        private String O00000o0;
        private boolean O00000oO;

        O00000Oo(Context context, o0OO0o00 o0oo0o00, String str, Map<String, String> map) {
            super(context, o0oo0o00);
            this.O00000o0 = str;
            this.O00000o = map;
            this.O00000oO = VERSION.SDK_INT != 19;
        }

        private Map<String, String> O0000Oo0() {
            Object O0000oo0 = o0O0o000.O0000oo0(this.O000000o);
            if (TextUtils.isEmpty(O0000oo0)) {
                O0000oo0 = o0O0o000.O0000Oo0(this.O000000o);
            }
            if (!TextUtils.isEmpty(O0000oo0)) {
                O0000oo0 = o0OO00o0.O00000Oo(new StringBuilder(O0000oo0).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.O00000o0);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.O00000Oo.O000000o());
            hashMap.put("version", this.O00000Oo.O00000Oo());
            hashMap.put("output", "json");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(VERSION.SDK_INT);
            stringBuilder.append("");
            hashMap.put("androidversion", stringBuilder.toString());
            hashMap.put("deviceId", O0000oo0);
            hashMap.put("manufacture", Build.MANUFACTURER);
            if (!(this.O00000o == null || this.O00000o.isEmpty())) {
                hashMap.putAll(this.O00000o);
            }
            hashMap.put("abitype", o0OOOO00.O000000o(this.O000000o));
            hashMap.put("ext", this.O00000Oo.O00000oO());
            return hashMap;
        }

        public boolean O000000o() {
            return this.O00000oO;
        }

        public byte[] O00000Oo() {
            return null;
        }

        /* Access modifiers changed, original: protected */
        public String O00000o() {
            return "3.0";
        }

        public byte[] O00000o0() {
            return o0OOOO00.O000000o(o0OOOO00.O00000Oo(O0000Oo0()));
        }

        public Map<String, String> getRequestHead() {
            return null;
        }

        public String getURL() {
            return this.O00000oO ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }
    }

    public static O000000o O000000o(Context context, o0OO0o00 o0oo0o00, String str, Map<String, String> map) {
        return O000000o(context, o0oo0o00, str, map, false);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x008d */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A:{SYNTHETIC, PHI: r11 , Splitter:B:1:0x0015, ExcHandler: IllegalBlockSizeException (unused javax.crypto.IllegalBlockSizeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba A:{RETURN} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:30:0x0095, code skipped:
            r12 = e;
     */
    /* JADX WARNING: Missing block: B:35:0x00a4, code skipped:
            r4 = r11;
     */
    public static com.amap.api.mapcore.util.o0O0O0o0.O000000o O000000o(android.content.Context r9, com.amap.api.mapcore.util.o0OO0o00 r10, java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, boolean r13) {
        /*
        r0 = new com.amap.api.mapcore.util.o0O0O0o0$O000000o;
        r0.<init>();
        r1 = new org.json.JSONObject;
        r1.<init>();
        r0.O0000oo = r1;
        r1 = com.amap.api.mapcore.util.o0OO00OO.O000000o();
        r1.O000000o(r9);
        r1 = 0;
        r2 = 0;
        r3 = new com.amap.api.mapcore.util.ooooOO00;	 Catch:{ o0O0oo0o -> 0x00a8, IllegalBlockSizeException -> 0x00a4, Throwable -> 0x0097 }
        r3.<init>();	 Catch:{ o0O0oo0o -> 0x00a8, IllegalBlockSizeException -> 0x00a4, Throwable -> 0x0097 }
        r4 = new java.lang.StringBuilder;	 Catch:{ o0O0oo0o -> 0x0095, Throwable -> 0x008d, IllegalBlockSizeException -> 0x00a4 }
        r4.<init>();	 Catch:{ o0O0oo0o -> 0x0095, Throwable -> 0x008d, IllegalBlockSizeException -> 0x00a4 }
        r4.append(r11);	 Catch:{ o0O0oo0o -> 0x0095, Throwable -> 0x008d, IllegalBlockSizeException -> 0x00a4 }
        r5 = ";14N;";
        r4.append(r5);	 Catch:{ o0O0oo0o -> 0x0095, Throwable -> 0x008d, IllegalBlockSizeException -> 0x00a4 }
        r5 = "15K";
        r4.append(r5);	 Catch:{ o0O0oo0o -> 0x0095, Throwable -> 0x008d, IllegalBlockSizeException -> 0x00a4 }
        r4 = r4.toString();	 Catch:{ o0O0oo0o -> 0x0095, Throwable -> 0x008d, IllegalBlockSizeException -> 0x00a4 }
        r11 = new com.amap.api.mapcore.util.o0O0O0o0$O00000Oo;	 Catch:{ o0O0oo0o -> 0x0089, Throwable -> 0x0087, IllegalBlockSizeException -> 0x00a5 }
        r11.<init>(r9, r10, r4, r12);	 Catch:{ o0O0oo0o -> 0x0089, Throwable -> 0x0087, IllegalBlockSizeException -> 0x00a5 }
        r12 = r11.O000000o();	 Catch:{ o0O0oo0o -> 0x0089, Throwable -> 0x0087, IllegalBlockSizeException -> 0x00a5 }
        r11 = r3.O000000o(r11, r12);	 Catch:{ o0O0oo0o -> 0x0089, Throwable -> 0x0087, IllegalBlockSizeException -> 0x00a5 }
        if (r11 == 0) goto L_0x004e;
    L_0x003f:
        r12 = r11.O000000o;	 Catch:{ o0O0oo0o -> 0x0049, IllegalBlockSizeException -> 0x0046, Throwable -> 0x0042 }
        goto L_0x004f;
    L_0x0042:
        r12 = move-exception;
        r3 = r12;
        r12 = r1;
        goto L_0x009c;
    L_0x0046:
        r12 = r1;
        goto L_0x00b8;
    L_0x0049:
        r12 = move-exception;
        r3 = r12;
        r12 = r1;
        goto L_0x00ad;
    L_0x004e:
        r12 = r1;
    L_0x004f:
        r3 = 16;
        r5 = new byte[r3];	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r6 = r12.length;	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r6 = r6 - r3;
        r6 = new byte[r6];	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        java.lang.System.arraycopy(r12, r2, r5, r2, r3);	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r7 = r12.length;	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r7 = r7 - r3;
        java.lang.System.arraycopy(r12, r3, r6, r2, r7);	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r3 = new javax.crypto.spec.SecretKeySpec;	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r7 = "AES";
        r3.<init>(r5, r7);	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r5 = "AES/CBC/PKCS5Padding";
        r5 = javax.crypto.Cipher.getInstance(r5);	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r7 = new javax.crypto.spec.IvParameterSpec;	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r8 = com.amap.api.mapcore.util.o0OOOO00.O00000o0();	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r7.<init>(r8);	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r8 = 2;
        r5.init(r8, r3, r7);	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r3 = r5.doFinal(r6);	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r3 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r3);	 Catch:{ o0O0oo0o -> 0x0085, IllegalBlockSizeException -> 0x00b8, Throwable -> 0x0083 }
        r1 = r3;
        goto L_0x00b8;
    L_0x0083:
        r3 = move-exception;
        goto L_0x009c;
    L_0x0085:
        r3 = move-exception;
        goto L_0x00ad;
    L_0x0087:
        r11 = r4;
        goto L_0x008d;
    L_0x0089:
        r11 = move-exception;
        r12 = r11;
        r11 = r4;
        goto L_0x0096;
    L_0x008d:
        r12 = new com.amap.api.mapcore.util.o0O0oo0o;	 Catch:{ o0O0oo0o -> 0x00a8, IllegalBlockSizeException -> 0x00a4, Throwable -> 0x0097 }
        r3 = "未知的错误";
        r12.<init>(r3);	 Catch:{ o0O0oo0o -> 0x00a8, IllegalBlockSizeException -> 0x00a4, Throwable -> 0x0097 }
        throw r12;	 Catch:{ o0O0oo0o -> 0x00a8, IllegalBlockSizeException -> 0x00a4, Throwable -> 0x0097 }
    L_0x0095:
        r12 = move-exception;
    L_0x0096:
        throw r12;	 Catch:{ o0O0oo0o -> 0x00a8, IllegalBlockSizeException -> 0x00a4, Throwable -> 0x0097 }
    L_0x0097:
        r12 = move-exception;
        r4 = r11;
        r3 = r12;
        r11 = r1;
        r12 = r11;
    L_0x009c:
        r5 = "at";
        r6 = "lc";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r3, r5, r6);
        goto L_0x00b8;
    L_0x00a4:
        r4 = r11;
    L_0x00a5:
        r11 = r1;
        r12 = r11;
        goto L_0x00b8;
    L_0x00a8:
        r12 = move-exception;
        r4 = r11;
        r3 = r12;
        r11 = r1;
        r12 = r11;
    L_0x00ad:
        r5 = r3.O000000o();
        r0.O000000o = r5;
        r5 = "/v3/iasdkauth";
        com.amap.api.mapcore.util.ooOOOOoo.O000000o(r10, r5, r3);
    L_0x00b8:
        if (r12 != 0) goto L_0x00bb;
    L_0x00ba:
        return r0;
    L_0x00bb:
        r3 = android.text.TextUtils.isEmpty(r1);
        if (r3 == 0) goto L_0x00c5;
    L_0x00c1:
        r1 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r12);
    L_0x00c5:
        r12 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0286 }
        r12.<init>(r1);	 Catch:{ Throwable -> 0x0286 }
        r1 = "status";
        r1 = r12.has(r1);	 Catch:{ Throwable -> 0x0286 }
        if (r1 == 0) goto L_0x028e;
    L_0x00d2:
        r1 = "status";
        r1 = r12.getInt(r1);	 Catch:{ Throwable -> 0x0286 }
        r3 = 1;
        if (r1 != r3) goto L_0x00de;
    L_0x00db:
        O000000o = r3;	 Catch:{ Throwable -> 0x0286 }
        goto L_0x011f;
    L_0x00de:
        if (r1 != 0) goto L_0x011f;
    L_0x00e0:
        r1 = "authcsid";
        r3 = "authgsid";
        if (r11 == 0) goto L_0x00ea;
    L_0x00e6:
        r1 = r11.O00000o0;	 Catch:{ Throwable -> 0x0286 }
        r3 = r11.O00000o;	 Catch:{ Throwable -> 0x0286 }
    L_0x00ea:
        com.amap.api.mapcore.util.o0OOOO00.O000000o(r9, r1, r3, r12);	 Catch:{ Throwable -> 0x0286 }
        O000000o = r2;	 Catch:{ Throwable -> 0x0286 }
        r11 = "info";
        r11 = r12.has(r11);	 Catch:{ Throwable -> 0x0286 }
        if (r11 == 0) goto L_0x00ff;
    L_0x00f7:
        r11 = "info";
        r11 = r12.getString(r11);	 Catch:{ Throwable -> 0x0286 }
        O00000Oo = r11;	 Catch:{ Throwable -> 0x0286 }
    L_0x00ff:
        r11 = "";
        r1 = "infocode";
        r1 = r12.has(r1);	 Catch:{ Throwable -> 0x0286 }
        if (r1 == 0) goto L_0x010f;
    L_0x0109:
        r11 = "infocode";
        r11 = r12.getString(r11);	 Catch:{ Throwable -> 0x0286 }
    L_0x010f:
        r1 = "/v3/iasdkauth";
        r5 = O00000Oo;	 Catch:{ Throwable -> 0x0286 }
        com.amap.api.mapcore.util.ooOOOOoo.O000000o(r10, r1, r5, r3, r11);	 Catch:{ Throwable -> 0x0286 }
        r10 = O000000o;	 Catch:{ Throwable -> 0x0286 }
        if (r10 != 0) goto L_0x011f;
    L_0x011a:
        r9 = O00000Oo;	 Catch:{ Throwable -> 0x0286 }
        r0.O000000o = r9;	 Catch:{ Throwable -> 0x0286 }
        return r0;
    L_0x011f:
        r10 = "ver";
        r10 = r12.has(r10);	 Catch:{ Throwable -> 0x0130 }
        if (r10 == 0) goto L_0x0138;
    L_0x0127:
        r10 = "ver";
        r10 = r12.getInt(r10);	 Catch:{ Throwable -> 0x0130 }
        r0.O00000Oo = r10;	 Catch:{ Throwable -> 0x0130 }
        goto L_0x0138;
    L_0x0130:
        r10 = move-exception;
        r11 = "at";
        r1 = "lc";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r10, r11, r1);	 Catch:{ Throwable -> 0x0286 }
    L_0x0138:
        r10 = "result";
        r10 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r12, r10);	 Catch:{ Throwable -> 0x0286 }
        if (r10 == 0) goto L_0x028e;
    L_0x0140:
        r10 = new com.amap.api.mapcore.util.o0O0O0o0$O000000o$O000000o;	 Catch:{ Throwable -> 0x0286 }
        r10.<init>();	 Catch:{ Throwable -> 0x0286 }
        r10.O000000o = r2;	 Catch:{ Throwable -> 0x0286 }
        r10.O00000Oo = r2;	 Catch:{ Throwable -> 0x0286 }
        r0.O0000ooO = r10;	 Catch:{ Throwable -> 0x0286 }
        r11 = "result";
        r11 = r12.getJSONObject(r11);	 Catch:{ Throwable -> 0x0286 }
        r12 = ";";
        r12 = r4.split(r12);	 Catch:{ Throwable -> 0x0174 }
        if (r12 == 0) goto L_0x017c;
    L_0x0159:
        r1 = r12.length;	 Catch:{ Throwable -> 0x0174 }
        if (r1 <= 0) goto L_0x017c;
    L_0x015c:
        r1 = r12.length;	 Catch:{ Throwable -> 0x0174 }
        r3 = r2;
    L_0x015e:
        if (r3 >= r1) goto L_0x017c;
    L_0x0160:
        r4 = r12[r3];	 Catch:{ Throwable -> 0x0174 }
        r5 = r11.has(r4);	 Catch:{ Throwable -> 0x0174 }
        if (r5 == 0) goto L_0x0171;
    L_0x0168:
        r5 = r0.O0000oo;	 Catch:{ Throwable -> 0x0174 }
        r6 = r11.get(r4);	 Catch:{ Throwable -> 0x0174 }
        r5.putOpt(r4, r6);	 Catch:{ Throwable -> 0x0174 }
    L_0x0171:
        r3 = r3 + 1;
        goto L_0x015e;
    L_0x0174:
        r12 = move-exception;
        r1 = "at";
        r3 = "co";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r12, r1, r3);	 Catch:{ Throwable -> 0x0286 }
    L_0x017c:
        r12 = "11K";
        r12 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r11, r12);	 Catch:{ Throwable -> 0x0286 }
        if (r12 == 0) goto L_0x01af;
    L_0x0184:
        r12 = "11K";
        r12 = r11.getJSONObject(r12);	 Catch:{ Throwable -> 0x01a7 }
        r1 = "able";
        r1 = r12.getString(r1);	 Catch:{ Throwable -> 0x01a7 }
        r1 = O000000o(r1, r2);	 Catch:{ Throwable -> 0x01a7 }
        r10.O000000o = r1;	 Catch:{ Throwable -> 0x01a7 }
        r1 = "off";
        r1 = r12.has(r1);	 Catch:{ Throwable -> 0x01a7 }
        if (r1 == 0) goto L_0x01af;
    L_0x019e:
        r1 = "off";
        r12 = r12.getJSONObject(r1);	 Catch:{ Throwable -> 0x01a7 }
        r10.O00000o0 = r12;	 Catch:{ Throwable -> 0x01a7 }
        goto L_0x01af;
    L_0x01a7:
        r10 = move-exception;
        r12 = "AuthConfigManager";
        r1 = "loadException";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r10, r12, r1);	 Catch:{ Throwable -> 0x0286 }
    L_0x01af:
        r10 = "001";
        r10 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r11, r10);	 Catch:{ Throwable -> 0x0286 }
        if (r10 == 0) goto L_0x01c7;
    L_0x01b7:
        r10 = "001";
        r10 = r11.getJSONObject(r10);	 Catch:{ Throwable -> 0x0286 }
        r12 = new com.amap.api.mapcore.util.o0O0O0o0$O000000o$O00000o;	 Catch:{ Throwable -> 0x0286 }
        r12.<init>();	 Catch:{ Throwable -> 0x0286 }
        O000000o(r10, r12);	 Catch:{ Throwable -> 0x0286 }
        r0.O0000ooo = r12;	 Catch:{ Throwable -> 0x0286 }
    L_0x01c7:
        r10 = "002";
        r10 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r11, r10);	 Catch:{ Throwable -> 0x0286 }
        if (r10 == 0) goto L_0x01df;
    L_0x01cf:
        r10 = "002";
        r10 = r11.getJSONObject(r10);	 Catch:{ Throwable -> 0x0286 }
        r12 = new com.amap.api.mapcore.util.o0O0O0o0$O000000o$O00000o0;	 Catch:{ Throwable -> 0x0286 }
        r12.<init>();	 Catch:{ Throwable -> 0x0286 }
        O000000o(r10, r12);	 Catch:{ Throwable -> 0x0286 }
        r0.O00oOooo = r12;	 Catch:{ Throwable -> 0x0286 }
    L_0x01df:
        r10 = "14S";
        r10 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r11, r10);	 Catch:{ Throwable -> 0x0286 }
        if (r10 == 0) goto L_0x01f7;
    L_0x01e7:
        r10 = "14S";
        r10 = r11.getJSONObject(r10);	 Catch:{ Throwable -> 0x0286 }
        r12 = new com.amap.api.mapcore.util.o0O0O0o0$O000000o$O00000o0;	 Catch:{ Throwable -> 0x0286 }
        r12.<init>();	 Catch:{ Throwable -> 0x0286 }
        O000000o(r10, r12);	 Catch:{ Throwable -> 0x0286 }
        r0.O000O00o = r12;	 Catch:{ Throwable -> 0x0286 }
    L_0x01f7:
        O000000o(r0, r11);	 Catch:{ Throwable -> 0x0286 }
        r10 = "14Z";
        r10 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r11, r10);	 Catch:{ Throwable -> 0x0286 }
        if (r10 == 0) goto L_0x0212;
    L_0x0202:
        r10 = "14Z";
        r10 = r11.getJSONObject(r10);	 Catch:{ Throwable -> 0x0286 }
        r12 = new com.amap.api.mapcore.util.o0O0O0o0$O000000o$O0000OOo;	 Catch:{ Throwable -> 0x0286 }
        r12.<init>();	 Catch:{ Throwable -> 0x0286 }
        O000000o(r10, r12);	 Catch:{ Throwable -> 0x0286 }
        r0.O000O0o = r12;	 Catch:{ Throwable -> 0x0286 }
    L_0x0212:
        r10 = "151";
        r10 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r11, r10);	 Catch:{ Throwable -> 0x0286 }
        if (r10 == 0) goto L_0x022a;
    L_0x021a:
        r10 = "151";
        r10 = r11.getJSONObject(r10);	 Catch:{ Throwable -> 0x0286 }
        r12 = new com.amap.api.mapcore.util.o0O0O0o0$O000000o$O0000O0o;	 Catch:{ Throwable -> 0x0286 }
        r12.<init>();	 Catch:{ Throwable -> 0x0286 }
        O000000o(r10, r12);	 Catch:{ Throwable -> 0x0286 }
        r0.O00oOooO = r12;	 Catch:{ Throwable -> 0x0286 }
    L_0x022a:
        O000000o(r0, r11);	 Catch:{ Throwable -> 0x0286 }
        r10 = "14N";
        r10 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r11, r10);	 Catch:{ Throwable -> 0x0286 }
        if (r10 == 0) goto L_0x0282;
    L_0x0235:
        r10 = "14N";
        r10 = r11.getJSONObject(r10);	 Catch:{ Throwable -> 0x0286 }
        r12 = new com.amap.api.mapcore.util.o0O0O0o0$O000000o$O00000Oo;	 Catch:{ Throwable -> 0x0286 }
        r12.<init>();	 Catch:{ Throwable -> 0x0286 }
        r1 = "able";
        r1 = r10.optString(r1);	 Catch:{ Throwable -> 0x0286 }
        r1 = O000000o(r1, r2);	 Catch:{ Throwable -> 0x0286 }
        r12.O000000o = r1;	 Catch:{ Throwable -> 0x0286 }
        r1 = "url";
        r1 = r10.optString(r1);	 Catch:{ Throwable -> 0x0286 }
        r12.O00000Oo = r1;	 Catch:{ Throwable -> 0x0286 }
        r1 = "md5";
        r10 = r10.optString(r1);	 Catch:{ Throwable -> 0x0286 }
        r12.O00000o0 = r10;	 Catch:{ Throwable -> 0x0286 }
        r10 = r12.O000000o;	 Catch:{ Throwable -> 0x0286 }
        if (r10 == 0) goto L_0x027d;
    L_0x0260:
        r10 = com.amap.api.mapcore.util.oO0Ooo00.O000000o();	 Catch:{ Throwable -> 0x0286 }
        if (r10 == 0) goto L_0x0282;
    L_0x0266:
        r1 = new com.amap.api.mapcore.util.oO00OO0O;	 Catch:{ Throwable -> 0x0286 }
        r2 = r12.O00000Oo;	 Catch:{ Throwable -> 0x0286 }
        r12 = r12.O00000o0;	 Catch:{ Throwable -> 0x0286 }
        r3 = "";
        r1.<init>(r2, r12, r3);	 Catch:{ Throwable -> 0x0286 }
        r1.O000000o(r13);	 Catch:{ Throwable -> 0x0286 }
        r12 = new com.amap.api.mapcore.util.oOo00OO0;	 Catch:{ Throwable -> 0x0286 }
        r12.<init>(r9, r1, r10);	 Catch:{ Throwable -> 0x0286 }
        r12.O000000o();	 Catch:{ Throwable -> 0x0286 }
        goto L_0x0282;
    L_0x027d:
        r10 = "aiu";
        com.amap.api.mapcore.util.oO00o000.O000000o(r9, r10);	 Catch:{ Throwable -> 0x0286 }
    L_0x0282:
        O000000o(r9, r11);	 Catch:{ Throwable -> 0x0286 }
        goto L_0x028e;
    L_0x0286:
        r9 = move-exception;
        r10 = "at";
        r11 = "lc";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r9, r10, r11);
    L_0x028e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0O0O0o0.O000000o(android.content.Context, com.amap.api.mapcore.util.o0OO0o00, java.lang.String, java.util.Map, boolean):com.amap.api.mapcore.util.o0O0O0o0$O000000o");
    }

    public static String O000000o(JSONObject jSONObject, String str) throws JSONException {
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
        o0O0O0Oo.O000000o(context, str);
    }

    private static void O000000o(Context context, JSONObject jSONObject) {
        try {
            jSONObject = jSONObject.getJSONObject("15K");
            boolean O000000o = O000000o(jSONObject.optString("isTargetAble"), false);
            if (O000000o(jSONObject.optString("able"), false)) {
                o0OO00OO.O000000o().O000000o(context, O000000o);
            } else {
                o0OO00OO.O000000o().O00000Oo(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void O000000o(O000000o o000000o, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2;
            O00000Oo o00000Oo;
            if (o0OOOO00.O000000o(jSONObject, "11B")) {
                o000000o.O0000OOo = jSONObject.getJSONObject("11B");
            }
            if (o0OOOO00.O000000o(jSONObject, "11C")) {
                o000000o.O0000OoO = jSONObject.getJSONObject("11C");
            }
            if (o0OOOO00.O000000o(jSONObject, "11I")) {
                o000000o.O0000Ooo = jSONObject.getJSONObject("11I");
            }
            if (o0OOOO00.O000000o(jSONObject, "11H")) {
                o000000o.O0000o00 = jSONObject.getJSONObject("11H");
            }
            if (o0OOOO00.O000000o(jSONObject, "11E")) {
                o000000o.O0000o0 = jSONObject.getJSONObject("11E");
            }
            if (o0OOOO00.O000000o(jSONObject, "11F")) {
                o000000o.O0000o0O = jSONObject.getJSONObject("11F");
            }
            if (o0OOOO00.O000000o(jSONObject, "13A")) {
                o000000o.O0000o = jSONObject.getJSONObject("13A");
            }
            if (o0OOOO00.O000000o(jSONObject, "13J")) {
                o000000o.O0000Oo0 = jSONObject.getJSONObject("13J");
            }
            if (o0OOOO00.O000000o(jSONObject, "11G")) {
                o000000o.O0000o0o = jSONObject.getJSONObject("11G");
            }
            if (o0OOOO00.O000000o(jSONObject, "006")) {
                o000000o.O0000oO0 = jSONObject.getJSONObject("006");
            }
            if (o0OOOO00.O000000o(jSONObject, "010")) {
                o000000o.O0000oO = jSONObject.getJSONObject("010");
            }
            if (o0OOOO00.O000000o(jSONObject, "11Z")) {
                jSONObject2 = jSONObject.getJSONObject("11Z");
                o00000Oo = new O00000Oo();
                O000000o(jSONObject2, o00000Oo);
                o000000o.O000O0OO = o00000Oo;
            }
            if (o0OOOO00.O000000o(jSONObject, "135")) {
                o000000o.O0000Oo = jSONObject.getJSONObject("135");
            }
            if (o0OOOO00.O000000o(jSONObject, "13S")) {
                o000000o.O0000O0o = jSONObject.getJSONObject("13S");
            }
            if (o0OOOO00.O000000o(jSONObject, "121")) {
                jSONObject2 = jSONObject.getJSONObject("121");
                o00000Oo = new O00000Oo();
                O000000o(jSONObject2, o00000Oo);
                o000000o.O000O0Oo = o00000Oo;
            }
            if (o0OOOO00.O000000o(jSONObject, "122")) {
                jSONObject2 = jSONObject.getJSONObject("122");
                o00000Oo = new O00000Oo();
                O000000o(jSONObject2, o00000Oo);
                o000000o.O00oOoOo = o00000Oo;
            }
            if (o0OOOO00.O000000o(jSONObject, "123")) {
                jSONObject2 = jSONObject.getJSONObject("123");
                o00000Oo = new O00000Oo();
                O000000o(jSONObject2, o00000Oo);
                o000000o.O000O0o0 = o00000Oo;
            }
            if (o0OOOO00.O000000o(jSONObject, "011")) {
                o000000o.O00000o0 = jSONObject.getJSONObject("011");
            }
            if (o0OOOO00.O000000o(jSONObject, "012")) {
                o000000o.O00000o = jSONObject.getJSONObject("012");
            }
            if (o0OOOO00.O000000o(jSONObject, "013")) {
                o000000o.O00000oO = jSONObject.getJSONObject("013");
            }
            if (o0OOOO00.O000000o(jSONObject, "014")) {
                o000000o.O00000oo = jSONObject.getJSONObject("014");
            }
            if (o0OOOO00.O000000o(jSONObject, "145")) {
                o000000o.O0000oOO = jSONObject.getJSONObject("145");
            }
            if (o0OOOO00.O000000o(jSONObject, "14B")) {
                o000000o.O0000oOo = jSONObject.getJSONObject("14B");
            }
            if (o0OOOO00.O000000o(jSONObject, "14D")) {
                o000000o.O0000oo0 = jSONObject.getJSONObject("14D");
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "at", "pe");
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
                oO0OoOO0.O000000o(th, "at", "pe");
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
                oO0OoOO0.O000000o(th, "at", "psc");
            }
        }
    }

    private static void O000000o(JSONObject jSONObject, O00000o o00000o) {
        if (jSONObject != null) {
            try {
                String O000000o = O000000o(jSONObject, "md5");
                String O000000o2 = O000000o(jSONObject, SocialConstants.PARAM_URL);
                String O000000o3 = O000000o(jSONObject, "sdkversion");
                if (!TextUtils.isEmpty(O000000o) && !TextUtils.isEmpty(O000000o2)) {
                    if (!TextUtils.isEmpty(O000000o3)) {
                        o00000o.O000000o = O000000o2;
                        o00000o.O00000Oo = O000000o;
                        o00000o.O00000o0 = O000000o3;
                    }
                }
            } catch (Throwable th) {
                oO0OoOO0.O000000o(th, "at", "psu");
            }
        }
    }

    private static void O000000o(JSONObject jSONObject, O0000O0o o0000O0o) {
        if (o0000O0o != null && jSONObject != null) {
            o0000O0o.O000000o = O000000o(jSONObject.optString("able"), false);
        }
    }

    private static void O000000o(JSONObject jSONObject, O0000OOo o0000OOo) {
        if (o0000OOo != null) {
            try {
                String O000000o = O000000o(jSONObject, "md5");
                String O000000o2 = O000000o(jSONObject, "md5info");
                String O000000o3 = O000000o(jSONObject, SocialConstants.PARAM_URL);
                String O000000o4 = O000000o(jSONObject, "able");
                String O000000o5 = O000000o(jSONObject, "on");
                String O000000o6 = O000000o(jSONObject, "mobileable");
                o0000OOo.O00000oO = O000000o;
                o0000OOo.O00000oo = O000000o2;
                o0000OOo.O00000o = O000000o3;
                o0000OOo.O000000o = O000000o(O000000o4, false);
                o0000OOo.O00000Oo = O000000o(O000000o5, false);
                o0000OOo.O00000o0 = O000000o(O000000o6, false);
            } catch (Throwable th) {
                oO0OoOO0.O000000o(th, "at", "pes");
            }
        }
    }

    public static boolean O000000o(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split(HttpUtils.PATHS_SEPARATOR);
            boolean z2 = true;
            if (split[split.length - 1].charAt(4) % 2 != 1) {
                z2 = false;
            }
            return z2;
        } catch (Throwable unused) {
            return z;
        }
    }
}
