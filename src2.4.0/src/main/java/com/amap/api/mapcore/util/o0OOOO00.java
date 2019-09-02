package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import com.amap.api.mapcore.util.o0OO0o00.O000000o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: Utils */
public class o0OOOO00 {
    static String O000000o;
    private static final String[] O00000Oo;
    private static final String[] O00000o0 = new String[]{"arm", "x86"};

    static {
        r1 = new String[2];
        int i = 0;
        r1[0] = "arm64-v8a";
        r1[1] = "x86_64";
        O00000Oo = r1;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < 80) {
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            i++;
        }
        O000000o = stringBuilder.toString();
    }

    public static o0OO0o00 O000000o() throws o0O0oo0o {
        return new O000000o("collection", "1.0", "AMap_collection_1.0").O000000o(new String[]{"com.amap.api.collection"}).O000000o();
    }

    public static String O000000o(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String O000000o(long j, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String O000000o(Context context) {
        CharSequence charSequence = "";
        if (VERSION.SDK_INT >= 21 && VERSION.SDK_INT < 28) {
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                Field declaredField = Class.forName(ApplicationInfo.class.getName()).getDeclaredField("primaryCpuAbi");
                declaredField.setAccessible(true);
                charSequence = (String) declaredField.get(applicationInfo);
            } catch (Throwable th) {
                oO0OoOO0.O000000o(th, "ut", "gct");
            }
        }
        if (VERSION.SDK_INT >= 28) {
            try {
                String[] strArr = (String[]) Build.class.getDeclaredField("SUPPORTED_ABIS").get(null);
                if (strArr != null && strArr.length >= 1) {
                    charSequence = strArr[0];
                }
                if (!TextUtils.isEmpty(charSequence) && Arrays.asList(O00000Oo).contains(charSequence)) {
                    String str = context.getApplicationInfo().nativeLibraryDir;
                    if (!TextUtils.isEmpty(str)) {
                        if (Arrays.asList(O00000o0).contains(str.substring(str.lastIndexOf(File.separator) + 1))) {
                            String[] strArr2 = (String[]) Build.class.getDeclaredField("SUPPORTED_32_BIT_ABIS").get(null);
                            if (strArr2 != null && strArr2.length >= 1) {
                                charSequence = strArr2[0];
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                oO0OoOO0.O000000o(th2, "ut", "gct_p");
            }
        }
        return TextUtils.isEmpty(charSequence) ? Build.CPU_ABI : charSequence;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0049 A:{SYNTHETIC, Splitter:B:33:0x0049} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0053 A:{SYNTHETIC, Splitter:B:38:0x0053} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x005f A:{SYNTHETIC, Splitter:B:45:0x005f} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0069 A:{SYNTHETIC, Splitter:B:50:0x0069} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0049 A:{SYNTHETIC, Splitter:B:33:0x0049} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0053 A:{SYNTHETIC, Splitter:B:38:0x0053} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x005f A:{SYNTHETIC, Splitter:B:45:0x005f} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0069 A:{SYNTHETIC, Splitter:B:50:0x0069} */
    public static java.lang.String O000000o(java.lang.Throwable r3) {
        /*
        r0 = 0;
        r1 = new java.io.StringWriter;	 Catch:{ Throwable -> 0x0041, all -> 0x003d }
        r1.<init>();	 Catch:{ Throwable -> 0x0041, all -> 0x003d }
        r2 = new java.io.PrintWriter;	 Catch:{ Throwable -> 0x003a, all -> 0x0037 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x003a, all -> 0x0037 }
        r3.printStackTrace(r2);	 Catch:{ Throwable -> 0x0035 }
        r3 = r3.getCause();	 Catch:{ Throwable -> 0x0035 }
    L_0x0012:
        if (r3 == 0) goto L_0x001c;
    L_0x0014:
        r3.printStackTrace(r2);	 Catch:{ Throwable -> 0x0035 }
        r3 = r3.getCause();	 Catch:{ Throwable -> 0x0035 }
        goto L_0x0012;
    L_0x001c:
        r3 = r1.toString();	 Catch:{ Throwable -> 0x0035 }
        if (r1 == 0) goto L_0x002a;
    L_0x0022:
        r1.close();	 Catch:{ Throwable -> 0x0026 }
        goto L_0x002a;
    L_0x0026:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x002a:
        if (r2 == 0) goto L_0x0034;
    L_0x002c:
        r2.close();	 Catch:{ Throwable -> 0x0030 }
        goto L_0x0034;
    L_0x0030:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0034:
        return r3;
    L_0x0035:
        r3 = move-exception;
        goto L_0x0044;
    L_0x0037:
        r3 = move-exception;
        r2 = r0;
        goto L_0x005d;
    L_0x003a:
        r3 = move-exception;
        r2 = r0;
        goto L_0x0044;
    L_0x003d:
        r3 = move-exception;
        r1 = r0;
        r2 = r1;
        goto L_0x005d;
    L_0x0041:
        r3 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x0044:
        r3.printStackTrace();	 Catch:{ all -> 0x005c }
        if (r1 == 0) goto L_0x0051;
    L_0x0049:
        r1.close();	 Catch:{ Throwable -> 0x004d }
        goto L_0x0051;
    L_0x004d:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x0051:
        if (r2 == 0) goto L_0x005b;
    L_0x0053:
        r2.close();	 Catch:{ Throwable -> 0x0057 }
        goto L_0x005b;
    L_0x0057:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x005b:
        return r0;
    L_0x005c:
        r3 = move-exception;
    L_0x005d:
        if (r1 == 0) goto L_0x0067;
    L_0x005f:
        r1.close();	 Catch:{ Throwable -> 0x0063 }
        goto L_0x0067;
    L_0x0063:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0067:
        if (r2 == 0) goto L_0x0071;
    L_0x0069:
        r2.close();	 Catch:{ Throwable -> 0x006d }
        goto L_0x0071;
    L_0x006d:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0071:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OOOO00.O000000o(java.lang.Throwable):java.lang.String");
    }

    static String O000000o(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(HttpUtils.PARAMETERS_SEPARATOR);
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            stringBuilder.append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }

    public static String O000000o(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, HttpUtils.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static Method O000000o(Class cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(O00000o0(str), clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void O000000o(Context context, String str, String str2, JSONObject jSONObject) {
        Object obj = "";
        String O00000oO = o0O0O0Oo.O00000oO(context);
        String O00000Oo = o0OO00o0.O00000Oo(O00000oO);
        Object obj2 = "";
        Object obj3 = "";
        String str3 = "";
        String O000000o = o0O0O0Oo.O000000o(context);
        String str4 = "";
        try {
            if (jSONObject.has("info")) {
                obj = jSONObject.getString("info");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("请在高德开放平台官网中搜索\"");
                stringBuilder.append(obj);
                stringBuilder.append("\"相关内容进行解决");
                str3 = stringBuilder.toString();
            }
            String str5;
            StringBuilder stringBuilder2;
            StringBuilder stringBuilder3;
            StringBuilder stringBuilder4;
            if ("INVALID_USER_SCODE".equals(obj)) {
                if (jSONObject.has("sec_code")) {
                    obj2 = jSONObject.getString("sec_code");
                }
                if (jSONObject.has("sec_code_debug")) {
                    obj3 = jSONObject.getString("sec_code_debug");
                }
                if (O00000Oo.equals(obj2) || O00000Oo.equals(obj3)) {
                    str5 = "请在高德开放平台官网中搜索\"请求内容过长导致业务调用失败\"相关内容进行解决";
                    O0000OOo(O000000o);
                    O0000OOo("                                   鉴权错误信息                                  ");
                    O0000OOo(O000000o);
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("SHA1Package:");
                    stringBuilder2.append(O00000oO);
                    O0000O0o(stringBuilder2.toString());
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("key:");
                    stringBuilder3.append(O000000o);
                    O0000O0o(stringBuilder3.toString());
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("csid:");
                    stringBuilder4.append(str);
                    O0000O0o(stringBuilder4.toString());
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("gsid:");
                    stringBuilder4.append(str2);
                    O0000O0o(stringBuilder4.toString());
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("json:");
                    stringBuilder4.append(jSONObject.toString());
                    O0000O0o(stringBuilder4.toString());
                    O0000OOo("                                                                               ");
                    O0000OOo(str5);
                    O0000OOo(O000000o);
                }
                str5 = str3;
                O0000OOo(O000000o);
                O0000OOo("                                   鉴权错误信息                                  ");
                O0000OOo(O000000o);
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("SHA1Package:");
                stringBuilder2.append(O00000oO);
                O0000O0o(stringBuilder2.toString());
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("key:");
                stringBuilder3.append(O000000o);
                O0000O0o(stringBuilder3.toString());
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append("csid:");
                stringBuilder4.append(str);
                O0000O0o(stringBuilder4.toString());
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append("gsid:");
                stringBuilder4.append(str2);
                O0000O0o(stringBuilder4.toString());
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append("json:");
                stringBuilder4.append(jSONObject.toString());
                O0000O0o(stringBuilder4.toString());
                O0000OOo("                                                                               ");
                O0000OOo(str5);
                O0000OOo(O000000o);
            }
            if ("INVALID_USER_KEY".equals(obj)) {
                if (jSONObject.has("key")) {
                    str4 = jSONObject.getString("key");
                }
                if (str4.length() > 0 && !O000000o.equals(str4)) {
                    str5 = "请在高德开放平台官网上发起技术咨询工单—>账号与Key问题，咨询INVALID_USER_KEY如何解决";
                    O0000OOo(O000000o);
                    O0000OOo("                                   鉴权错误信息                                  ");
                    O0000OOo(O000000o);
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("SHA1Package:");
                    stringBuilder2.append(O00000oO);
                    O0000O0o(stringBuilder2.toString());
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("key:");
                    stringBuilder3.append(O000000o);
                    O0000O0o(stringBuilder3.toString());
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("csid:");
                    stringBuilder4.append(str);
                    O0000O0o(stringBuilder4.toString());
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("gsid:");
                    stringBuilder4.append(str2);
                    O0000O0o(stringBuilder4.toString());
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("json:");
                    stringBuilder4.append(jSONObject.toString());
                    O0000O0o(stringBuilder4.toString());
                    O0000OOo("                                                                               ");
                    O0000OOo(str5);
                    O0000OOo(O000000o);
                }
            }
            str5 = str3;
            O0000OOo(O000000o);
            O0000OOo("                                   鉴权错误信息                                  ");
            O0000OOo(O000000o);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("SHA1Package:");
            stringBuilder2.append(O00000oO);
            O0000O0o(stringBuilder2.toString());
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append("key:");
            stringBuilder3.append(O000000o);
            O0000O0o(stringBuilder3.toString());
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append("csid:");
            stringBuilder4.append(str);
            O0000O0o(stringBuilder4.toString());
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append("gsid:");
            stringBuilder4.append(str2);
            O0000O0o(stringBuilder4.toString());
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append("json:");
            stringBuilder4.append(jSONObject.toString());
            O0000O0o(stringBuilder4.toString());
            O0000OOo("                                                                               ");
            O0000OOo(str5);
            O0000OOo(O000000o);
        } catch (Throwable unused) {
        }
    }

    public static void O000000o(ByteArrayOutputStream byteArrayOutputStream, byte b, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b});
            int i = b & 255;
            if (i < 255 && i > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            oO0OoOO0.O000000o(e, "ut", "wFie");
        }
    }

    public static void O000000o(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{(byte) 0});
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        int length = str.length();
        if (length > 255) {
            length = 255;
        }
        O000000o(byteArrayOutputStream, (byte) length, O000000o(str));
    }

    public static boolean O000000o(Context context, String str) {
        if (context == null || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        if (VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                if (((Integer) context.getClass().getMethod("checkSelfPermission", new Class[]{String.class}).invoke(context, new Object[]{str})).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static boolean O000000o(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static byte[] O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes(HttpUtils.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static o0OO0o00 O00000Oo() throws o0O0oo0o {
        return new O000000o("co", com.ecloud.pulltozoomview.O000000o.O00000oo, "AMap_co_1.0.0").O000000o(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).O000000o();
    }

    public static String O00000Oo(String str) {
        if (str == null) {
            return null;
        }
        str = o0OO000o.O00000o0(O000000o(str));
        String str2 = "";
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((char) ((str.length() % 26) + 65));
            stringBuilder.append(str);
            str = stringBuilder.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            str = str2;
        }
        return str;
    }

    public static String O00000Oo(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Object obj = 1;
        try {
            for (Entry entry : map.entrySet()) {
                if (obj != null) {
                    obj = null;
                    stringBuffer.append((String) entry.getKey());
                    stringBuffer.append(HttpUtils.EQUAL_SIGN);
                    stringBuffer.append((String) entry.getValue());
                } else {
                    stringBuffer.append(HttpUtils.PARAMETERS_SEPARATOR);
                    stringBuffer.append((String) entry.getKey());
                    stringBuffer.append(HttpUtils.EQUAL_SIGN);
                    stringBuffer.append((String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    public static boolean O00000Oo(Context context) {
        return oO000o00.O000000o(context);
    }

    public static byte[] O00000Oo(byte[] bArr) {
        try {
            return O0000OOo(bArr);
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "ut", "gZp");
            return new byte[0];
        }
    }

    public static String O00000o(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split(HttpUtils.PARAMETERS_SEPARATOR);
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : split) {
                stringBuffer.append(append);
                stringBuffer.append(HttpUtils.PARAMETERS_SEPARATOR);
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
            return str;
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "ut", "sPa");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0054 A:{SYNTHETIC, Splitter:B:29:0x0054} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0060 A:{SYNTHETIC, Splitter:B:36:0x0060} */
    static java.security.PublicKey O00000o() throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException {
        /*
        r0 = "MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk=";
        r1 = 0;
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ Throwable -> 0x004d, all -> 0x004a }
        r0 = com.amap.api.mapcore.util.o0OO000o.O00000Oo(r0);	 Catch:{ Throwable -> 0x004d, all -> 0x004a }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x004d, all -> 0x004a }
        r0 = "X.509";
        r0 = java.security.cert.CertificateFactory.getInstance(r0);	 Catch:{ Throwable -> 0x0048 }
        r3 = "RSA";
        r3 = java.security.KeyFactory.getInstance(r3);	 Catch:{ Throwable -> 0x0048 }
        r0 = r0.generateCertificate(r2);	 Catch:{ Throwable -> 0x0048 }
        if (r0 == 0) goto L_0x003d;
    L_0x001e:
        if (r3 != 0) goto L_0x0021;
    L_0x0020:
        goto L_0x003d;
    L_0x0021:
        r4 = new java.security.spec.X509EncodedKeySpec;	 Catch:{ Throwable -> 0x0048 }
        r0 = r0.getPublicKey();	 Catch:{ Throwable -> 0x0048 }
        r0 = r0.getEncoded();	 Catch:{ Throwable -> 0x0048 }
        r4.<init>(r0);	 Catch:{ Throwable -> 0x0048 }
        r0 = r3.generatePublic(r4);	 Catch:{ Throwable -> 0x0048 }
        if (r2 == 0) goto L_0x003c;
    L_0x0034:
        r2.close();	 Catch:{ Throwable -> 0x0038 }
        goto L_0x003c;
    L_0x0038:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x003c:
        return r0;
    L_0x003d:
        if (r2 == 0) goto L_0x0047;
    L_0x003f:
        r2.close();	 Catch:{ Throwable -> 0x0043 }
        goto L_0x0047;
    L_0x0043:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0047:
        return r1;
    L_0x0048:
        r0 = move-exception;
        goto L_0x004f;
    L_0x004a:
        r0 = move-exception;
        r2 = r1;
        goto L_0x005e;
    L_0x004d:
        r0 = move-exception;
        r2 = r1;
    L_0x004f:
        r0.printStackTrace();	 Catch:{ all -> 0x005d }
        if (r2 == 0) goto L_0x005c;
    L_0x0054:
        r2.close();	 Catch:{ Throwable -> 0x0058 }
        goto L_0x005c;
    L_0x0058:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x005c:
        return r1;
    L_0x005d:
        r0 = move-exception;
    L_0x005e:
        if (r2 == 0) goto L_0x0068;
    L_0x0060:
        r2.close();	 Catch:{ Throwable -> 0x0064 }
        goto L_0x0068;
    L_0x0064:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0068:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OOOO00.O00000o():java.security.PublicKey");
    }

    public static byte[] O00000o(byte[] bArr) {
        try {
            return O0000OOo(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    public static String O00000o0(String str) {
        return str.length() < 2 ? "" : o0OO000o.O000000o(str.substring(1));
    }

    public static String O00000o0(Map<String, String> map) {
        return O00000o(O000000o((Map) map));
    }

    public static byte[] O00000o0() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            int i = 0;
            for (int i2 = 0; i2 < split.length; i2++) {
                bArr[i2] = Byte.parseByte(split[i2]);
            }
            split = new StringBuffer(new String(o0OO000o.O00000Oo(new String(bArr)))).reverse().toString().split(",");
            bArr = new byte[split.length];
            while (i < split.length) {
                bArr[i] = Byte.parseByte(split[i]);
                i++;
            }
            return bArr;
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "ut", "gIV");
            return new byte[16];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e A:{SYNTHETIC, Splitter:B:32:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006c A:{SYNTHETIC, Splitter:B:37:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007d A:{SYNTHETIC, Splitter:B:45:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008b A:{SYNTHETIC, Splitter:B:50:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007d A:{SYNTHETIC, Splitter:B:45:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008b A:{SYNTHETIC, Splitter:B:50:0x008b} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e A:{SYNTHETIC, Splitter:B:32:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006c A:{SYNTHETIC, Splitter:B:37:0x006c} */
    public static byte[] O00000o0(byte[] r5) {
        /*
        r0 = 0;
        if (r5 == 0) goto L_0x0098;
    L_0x0003:
        r1 = r5.length;
        if (r1 != 0) goto L_0x0008;
    L_0x0006:
        goto L_0x0098;
    L_0x0008:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x0052, all -> 0x004e }
        r1.<init>();	 Catch:{ Throwable -> 0x0052, all -> 0x004e }
        r2 = new java.util.zip.ZipOutputStream;	 Catch:{ Throwable -> 0x004b, all -> 0x0048 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x004b, all -> 0x0048 }
        r3 = new java.util.zip.ZipEntry;	 Catch:{ Throwable -> 0x0046 }
        r4 = "log";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0046 }
        r2.putNextEntry(r3);	 Catch:{ Throwable -> 0x0046 }
        r2.write(r5);	 Catch:{ Throwable -> 0x0046 }
        r2.closeEntry();	 Catch:{ Throwable -> 0x0046 }
        r2.finish();	 Catch:{ Throwable -> 0x0046 }
        r5 = r1.toByteArray();	 Catch:{ Throwable -> 0x0046 }
        if (r2 == 0) goto L_0x0037;
    L_0x002b:
        r2.close();	 Catch:{ Throwable -> 0x002f }
        goto L_0x0037;
    L_0x002f:
        r0 = move-exception;
        r2 = "ut";
        r3 = "zp1";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r0, r2, r3);
    L_0x0037:
        if (r1 == 0) goto L_0x0079;
    L_0x0039:
        r1.close();	 Catch:{ Throwable -> 0x003d }
        goto L_0x0079;
    L_0x003d:
        r0 = move-exception;
        r1 = "ut";
        r2 = "zp2";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r0, r1, r2);
        goto L_0x0079;
    L_0x0046:
        r5 = move-exception;
        goto L_0x0055;
    L_0x0048:
        r5 = move-exception;
        r2 = r0;
        goto L_0x007b;
    L_0x004b:
        r5 = move-exception;
        r2 = r0;
        goto L_0x0055;
    L_0x004e:
        r5 = move-exception;
        r1 = r0;
        r2 = r1;
        goto L_0x007b;
    L_0x0052:
        r5 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x0055:
        r3 = "ut";
        r4 = "zp";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r5, r3, r4);	 Catch:{ all -> 0x007a }
        if (r2 == 0) goto L_0x006a;
    L_0x005e:
        r2.close();	 Catch:{ Throwable -> 0x0062 }
        goto L_0x006a;
    L_0x0062:
        r5 = move-exception;
        r2 = "ut";
        r3 = "zp1";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r5, r2, r3);
    L_0x006a:
        if (r1 == 0) goto L_0x0078;
    L_0x006c:
        r1.close();	 Catch:{ Throwable -> 0x0070 }
        goto L_0x0078;
    L_0x0070:
        r5 = move-exception;
        r1 = "ut";
        r2 = "zp2";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r5, r1, r2);
    L_0x0078:
        r5 = r0;
    L_0x0079:
        return r5;
    L_0x007a:
        r5 = move-exception;
    L_0x007b:
        if (r2 == 0) goto L_0x0089;
    L_0x007d:
        r2.close();	 Catch:{ Throwable -> 0x0081 }
        goto L_0x0089;
    L_0x0081:
        r0 = move-exception;
        r2 = "ut";
        r3 = "zp1";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r0, r2, r3);
    L_0x0089:
        if (r1 == 0) goto L_0x0097;
    L_0x008b:
        r1.close();	 Catch:{ Throwable -> 0x008f }
        goto L_0x0097;
    L_0x008f:
        r0 = move-exception;
        r1 = "ut";
        r2 = "zp2";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r0, r1, r2);
    L_0x0097:
        throw r5;
    L_0x0098:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OOOO00.O00000o0(byte[]):byte[]");
    }

    static String O00000oO(byte[] bArr) {
        try {
            return O0000O0o(bArr);
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "ut", "h2s");
            return null;
        }
    }

    public static byte[] O00000oO(String str) {
        if (str.length() % 2 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    static String O00000oo(byte[] bArr) {
        try {
            return O0000O0o(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean O00000oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            str = o0OO000o.O000000o(str);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Build.MODEL);
            stringBuilder.append(VERSION.SDK_INT);
            return str.contains(stringBuilder.toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String O0000O0o(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append('0');
                stringBuilder2.append(toHexString);
                toHexString = stringBuilder2.toString();
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    static void O0000O0o(String str) {
        int i = 0;
        if (str.length() < 78) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("|");
            stringBuilder.append(str);
            while (i < 78 - str.length()) {
                stringBuilder.append(" ");
                i++;
            }
            stringBuilder.append("|");
            O0000OOo(stringBuilder.toString());
            return;
        }
        String substring = str.substring(0, 78);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("|");
        stringBuilder2.append(substring);
        stringBuilder2.append("|");
        O0000OOo(stringBuilder2.toString());
        O0000O0o(str.substring(78));
    }

    private static void O0000OOo(String str) {
        Log.i("authErrLog", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x003e A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0046 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x003e A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0046 A:{SYNTHETIC} */
    private static byte[] O0000OOo(byte[] r3) throws java.io.IOException, java.lang.Throwable {
        /*
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x0036, all -> 0x0033 }
        r1.<init>();	 Catch:{ Throwable -> 0x0036, all -> 0x0033 }
        r2 = new java.util.zip.GZIPOutputStream;	 Catch:{ Throwable -> 0x002f, all -> 0x002d }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x002f, all -> 0x002d }
        r2.write(r3);	 Catch:{ Throwable -> 0x002b, all -> 0x0029 }
        r2.finish();	 Catch:{ Throwable -> 0x002b, all -> 0x0029 }
        r3 = r1.toByteArray();	 Catch:{ Throwable -> 0x002b, all -> 0x0029 }
        if (r2 == 0) goto L_0x0020;
    L_0x001a:
        r2.close();	 Catch:{ Throwable -> 0x001e }
        goto L_0x0020;
    L_0x001e:
        r3 = move-exception;
        throw r3;
    L_0x0020:
        if (r1 == 0) goto L_0x0028;
    L_0x0022:
        r1.close();	 Catch:{ Throwable -> 0x0026 }
        goto L_0x0028;
    L_0x0026:
        r3 = move-exception;
        throw r3;
    L_0x0028:
        return r3;
    L_0x0029:
        r3 = move-exception;
        goto L_0x003b;
    L_0x002b:
        r3 = move-exception;
        goto L_0x0031;
    L_0x002d:
        r3 = move-exception;
        goto L_0x003c;
    L_0x002f:
        r3 = move-exception;
        r2 = r0;
    L_0x0031:
        r0 = r1;
        goto L_0x0038;
    L_0x0033:
        r3 = move-exception;
        r1 = r0;
        goto L_0x003c;
    L_0x0036:
        r3 = move-exception;
        r2 = r0;
    L_0x0038:
        throw r3;	 Catch:{ all -> 0x0039 }
    L_0x0039:
        r3 = move-exception;
        r1 = r0;
    L_0x003b:
        r0 = r2;
    L_0x003c:
        if (r0 == 0) goto L_0x0044;
    L_0x003e:
        r0.close();	 Catch:{ Throwable -> 0x0042 }
        goto L_0x0044;
    L_0x0042:
        r3 = move-exception;
        throw r3;
    L_0x0044:
        if (r1 == 0) goto L_0x004c;
    L_0x0046:
        r1.close();	 Catch:{ Throwable -> 0x004a }
        goto L_0x004c;
    L_0x004a:
        r3 = move-exception;
        throw r3;
    L_0x004c:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OOOO00.O0000OOo(byte[]):byte[]");
    }
}
