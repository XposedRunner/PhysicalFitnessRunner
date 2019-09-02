package com.alibaba.wireless.security.framework.utils;

import android.content.Context;
import android.os.Process;
import cn.jiguang.net.HttpUtils;
import com.tencent.stat.DeviceInfo;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserTrackMethodJniBridge {
    private static Context a;
    private static String b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;
    private static Class g;
    private static Class h;
    private static Class i;
    private static Constructor j;
    private static Method k;
    private static Method l;
    private static Method m;
    private static Method n;
    private static final char[] o = "0123456789abcdef".toCharArray();

    private static synchronized String a() {
        String substring;
        synchronized (UserTrackMethodJniBridge.class) {
            if (b == null || b.length() == 0) {
                b = b();
            }
            substring = b.substring(0, b.length() / 8);
        }
        return substring;
    }

    private static String a(String str) {
        String str2 = "";
        if (!(str == null || str.length() == 0)) {
            try {
                return URLEncoder.encode(str, HttpUtils.ENCODING_UTF_8);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str2;
    }

    public static int addUtRecord(String str, int i, int i2, String str2, long j, String str3, String str4, String str5, String str6, String str7) {
        if (utAvaiable() == 0 || str == null || str.length() == 0) {
            return 0;
        }
        try {
            String str8 = "Page_SecurityGuardSDK";
            String str9 = str2 != null ? str2 : "";
            String valueOf = String.valueOf(i % 100);
            HashMap hashMap = new HashMap();
            hashMap.put("plugin", String.valueOf(i2));
            hashMap.put("pid", String.valueOf(Process.myPid()));
            hashMap.put("tid", String.valueOf(Thread.currentThread().getId()));
            hashMap.put("time", String.valueOf(j));
            if (d == 0) {
                c = f.c(a);
                d = 1;
            }
            hashMap.put(DeviceInfo.TAG_IMEI, String.valueOf(c));
            hashMap.put("sid", a());
            hashMap.put("uuid", b());
            hashMap.put("msg", a(str3));
            hashMap.put("rsv1", a(str4));
            hashMap.put("rsv2", a(str5));
            hashMap.put("rsv3", a(str6));
            hashMap.put("rsv4", a(str7));
            Object newInstance = j.newInstance(new Object[]{str8, Integer.valueOf(19999), str, str9, valueOf, hashMap});
            if (newInstance == null) {
                return 0;
            }
            Map map = (Map) k.invoke(newInstance, new Object[0]);
            if (map == null || map.size() == 0) {
                return 0;
            }
            Object invoke = l.invoke(h, new Object[0]);
            if (invoke == null) {
                return 0;
            }
            invoke = m.invoke(invoke, new Object[0]);
            if (invoke == null) {
                return 0;
            }
            n.invoke(invoke, new Object[]{map});
            return 0;
        } catch (Exception unused) {
        }
    }

    private static String b() {
        String str = "";
        try {
            String uuid = UUID.randomUUID().toString();
            String valueOf = String.valueOf(System.nanoTime());
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(uuid);
            stringBuilder.append(valueOf);
            return bytesToHex(instance.digest(stringBuilder.toString().getBytes(HttpUtils.ENCODING_UTF_8)));
        } catch (Exception unused) {
            return str;
        }
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr[i3] = o[i2 >>> 4];
            cArr[i3 + 1] = o[i2 & 15];
        }
        return new String(cArr);
    }

    public static String getStackTrace(int i, int i2) {
        String str = "";
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace != null) {
            if (stackTrace.length <= 0) {
                return str;
            }
            if (i > 0) {
                if (i2 <= 0) {
                    return str;
                }
                StringBuilder stringBuilder = new StringBuilder();
                int i3 = 0;
                int i4 = 0;
                while (i3 < stackTrace.length && i4 < i2 && stringBuilder.length() < i) {
                    if (i3 > 1) {
                        i4++;
                        StackTraceElement stackTraceElement = stackTrace[i3];
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(stackTraceElement.getClassName());
                        stringBuilder2.append(".");
                        stringBuilder2.append(stackTraceElement.getMethodName());
                        stringBuilder.append(stringBuilder2.toString());
                        if (i3 < stackTrace.length - 1) {
                            stringBuilder.append("#");
                        }
                    }
                    i3++;
                }
                str = stringBuilder.toString();
            }
        }
        return str;
    }

    public static void init(Context context) {
        if (context != null) {
            a = context;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public static int utAvaiable() {
        /*
        r0 = f;
        if (r0 != 0) goto L_0x0089;
    L_0x0004:
        r0 = com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.class;
        monitor-enter(r0);
        r1 = f;	 Catch:{ all -> 0x0086 }
        if (r1 != 0) goto L_0x0084;
    L_0x000b:
        r1 = 1;
        r2 = "com.ut.mini.internal.UTOriginalCustomHitBuilder";
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0082 }
        g = r2;	 Catch:{ ClassNotFoundException -> 0x0082 }
        r2 = "com.ut.mini.UTAnalytics";
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0082 }
        h = r2;	 Catch:{ ClassNotFoundException -> 0x0082 }
        r2 = "com.ut.mini.UTTracker";
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0082 }
        i = r2;	 Catch:{ ClassNotFoundException -> 0x0082 }
        r2 = g;	 Catch:{  }
        r3 = 6;
        r3 = new java.lang.Class[r3];	 Catch:{  }
        r4 = java.lang.String.class;
        r5 = 0;
        r3[r5] = r4;	 Catch:{  }
        r4 = java.lang.Integer.TYPE;	 Catch:{  }
        r3[r1] = r4;	 Catch:{  }
        r4 = 2;
        r6 = java.lang.String.class;
        r3[r4] = r6;	 Catch:{  }
        r4 = 3;
        r6 = java.lang.String.class;
        r3[r4] = r6;	 Catch:{  }
        r4 = 4;
        r6 = java.lang.String.class;
        r3[r4] = r6;	 Catch:{  }
        r4 = 5;
        r6 = java.util.Map.class;
        r3[r4] = r6;	 Catch:{  }
        r2 = r2.getConstructor(r3);	 Catch:{  }
        j = r2;	 Catch:{  }
        r2 = g;	 Catch:{  }
        r3 = "build";
        r4 = new java.lang.Class[r5];	 Catch:{  }
        r2 = r2.getMethod(r3, r4);	 Catch:{  }
        k = r2;	 Catch:{  }
        r2 = h;	 Catch:{  }
        r3 = "getInstance";
        r4 = new java.lang.Class[r5];	 Catch:{  }
        r2 = r2.getMethod(r3, r4);	 Catch:{  }
        l = r2;	 Catch:{  }
        r2 = h;	 Catch:{  }
        r3 = "getDefaultTracker";
        r4 = new java.lang.Class[r5];	 Catch:{  }
        r2 = r2.getMethod(r3, r4);	 Catch:{  }
        m = r2;	 Catch:{  }
        r2 = i;	 Catch:{  }
        r3 = "send";
        r4 = new java.lang.Class[r1];	 Catch:{  }
        r6 = java.util.Map.class;
        r4[r5] = r6;	 Catch:{  }
        r2 = r2.getMethod(r3, r4);	 Catch:{  }
        n = r2;	 Catch:{  }
        e = r1;	 Catch:{ all -> 0x0086 }
    L_0x0082:
        f = r1;	 Catch:{ all -> 0x0086 }
    L_0x0084:
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        goto L_0x0089;
    L_0x0086:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        throw r1;
    L_0x0089:
        r0 = e;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge.utAvaiable():int");
    }
}
