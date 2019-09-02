package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.support.v4.os.EnvironmentCompat;
import cn.jiguang.net.HttpUtils;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class b {
    private static String a;

    /* JADX WARNING: Removed duplicated region for block: B:52:0x008c A:{SYNTHETIC, Splitter:B:52:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0098 A:{SYNTHETIC, Splitter:B:59:0x0098} */
    public static com.tencent.bugly.crashreport.crash.CrashDetailBean a(android.content.Context r6, java.lang.String r7, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler r8) {
        /*
        r0 = 0;
        r1 = 0;
        if (r6 == 0) goto L_0x00a2;
    L_0x0004:
        if (r7 == 0) goto L_0x00a2;
    L_0x0006:
        if (r8 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x00a2;
    L_0x000a:
        r2 = new java.io.File;
        r3 = "rqd_record.eup";
        r2.<init>(r7, r3);
        r7 = r2.exists();
        if (r7 == 0) goto L_0x00a1;
    L_0x0017:
        r7 = r2.canRead();
        if (r7 != 0) goto L_0x001f;
    L_0x001d:
        goto L_0x00a1;
    L_0x001f:
        r7 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0085, all -> 0x0082 }
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0085, all -> 0x0082 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x0085, all -> 0x0082 }
        r7.<init>(r3);	 Catch:{ IOException -> 0x0085, all -> 0x0082 }
        r2 = a(r7);	 Catch:{ IOException -> 0x0080 }
        r3 = 1;
        if (r2 == 0) goto L_0x006e;
    L_0x0030:
        r4 = "NATIVE_RQD_REPORT";
        r4 = r2.equals(r4);	 Catch:{ IOException -> 0x0080 }
        if (r4 != 0) goto L_0x0039;
    L_0x0038:
        goto L_0x006e;
    L_0x0039:
        r2 = new java.util.HashMap;	 Catch:{ IOException -> 0x0080 }
        r2.<init>();	 Catch:{ IOException -> 0x0080 }
    L_0x003e:
        r4 = r1;
    L_0x003f:
        r5 = a(r7);	 Catch:{ IOException -> 0x0080 }
        if (r5 == 0) goto L_0x004d;
    L_0x0045:
        if (r4 != 0) goto L_0x0049;
    L_0x0047:
        r4 = r5;
        goto L_0x003f;
    L_0x0049:
        r2.put(r4, r5);	 Catch:{ IOException -> 0x0080 }
        goto L_0x003e;
    L_0x004d:
        if (r4 == 0) goto L_0x0061;
    L_0x004f:
        r6 = "record not pair! drop! %s";
        r8 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x0080 }
        r8[r0] = r4;	 Catch:{ IOException -> 0x0080 }
        com.tencent.bugly.proguard.x.e(r6, r8);	 Catch:{ IOException -> 0x0080 }
        r7.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x0060;
    L_0x005c:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0060:
        return r1;
    L_0x0061:
        r6 = a(r6, r2, r8);	 Catch:{ IOException -> 0x0080 }
        r7.close();	 Catch:{ IOException -> 0x0069 }
        goto L_0x006d;
    L_0x0069:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x006d:
        return r6;
    L_0x006e:
        r6 = "record read fail! %s";
        r8 = new java.lang.Object[r3];	 Catch:{ IOException -> 0x0080 }
        r8[r0] = r2;	 Catch:{ IOException -> 0x0080 }
        com.tencent.bugly.proguard.x.e(r6, r8);	 Catch:{ IOException -> 0x0080 }
        r7.close();	 Catch:{ IOException -> 0x007b }
        goto L_0x007f;
    L_0x007b:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x007f:
        return r1;
    L_0x0080:
        r6 = move-exception;
        goto L_0x0087;
    L_0x0082:
        r6 = move-exception;
        r7 = r1;
        goto L_0x0096;
    L_0x0085:
        r6 = move-exception;
        r7 = r1;
    L_0x0087:
        r6.printStackTrace();	 Catch:{ all -> 0x0095 }
        if (r7 == 0) goto L_0x0094;
    L_0x008c:
        r7.close();	 Catch:{ IOException -> 0x0090 }
        goto L_0x0094;
    L_0x0090:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0094:
        return r1;
    L_0x0095:
        r6 = move-exception;
    L_0x0096:
        if (r7 == 0) goto L_0x00a0;
    L_0x0098:
        r7.close();	 Catch:{ IOException -> 0x009c }
        goto L_0x00a0;
    L_0x009c:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x00a0:
        throw r6;
    L_0x00a1:
        return r1;
    L_0x00a2:
        r6 = "get eup record file args error";
        r7 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.x.e(r6, r7);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.b.a(android.content.Context, java.lang.String, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    private static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        Throwable th;
        Map<String, String> map2 = map;
        if (map2 == null) {
            return null;
        }
        if (a.a(context) == null) {
            x.e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str = (String) map2.get("intStateStr");
        if (str == null || str.trim().length() <= 0) {
            CrashDetailBean crashDetailBean = null;
            x.e("no intStateStr", new Object[0]);
            return crashDetailBean;
        }
        Map c = c(str);
        if (c == null) {
            x.e("parse intSateMap fail", Integer.valueOf(map.size()));
            return null;
        }
        try {
            ((Integer) c.get("sino")).intValue();
            ((Integer) c.get("sud")).intValue();
            String str2 = (String) map2.get("soVersion");
            if (str2 == null) {
                x.e("error format at version", new Object[0]);
                return null;
            }
            StringBuilder stringBuilder;
            String str3;
            String str4;
            StringBuilder stringBuilder2;
            Map map3;
            String str5 = (String) map2.get("errorAddr");
            if (str5 == null) {
                str5 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            String str6 = str5;
            str5 = (String) map2.get("codeMsg");
            if (str5 == null) {
                str5 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            String str7 = (String) map2.get("tombPath");
            if (str7 == null) {
                str7 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            String str8 = str7;
            str7 = (String) map2.get("signalName");
            if (str7 == null) {
                str7 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            map2.get("errnoMsg");
            String str9 = (String) map2.get("stack");
            if (str9 == null) {
                str9 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            String str10 = (String) map2.get("jstack");
            if (str10 != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str9);
                stringBuilder.append("java:\n");
                stringBuilder.append(str10);
                str9 = stringBuilder.toString();
            }
            Integer num = (Integer) c.get("sico");
            if (num == null || num.intValue() <= 0) {
                str3 = str5;
                str4 = str7;
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str7);
                stringBuilder2.append("(");
                stringBuilder2.append(str5);
                stringBuilder2.append(")");
                str4 = stringBuilder2.toString();
                str3 = "KERNEL";
            }
            str5 = (String) map2.get("nativeLog");
            byte[] a = (str5 == null || str5.isEmpty()) ? null : z.a(null, str5, "BuglyNativeLog.txt");
            str5 = (String) map2.get("sendingProcess");
            if (str5 == null) {
                str5 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            Integer num2 = (Integer) c.get("spd");
            if (num2 != null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str5);
                stringBuilder2.append("(");
                stringBuilder2.append(num2);
                stringBuilder2.append(")");
                str5 = stringBuilder2.toString();
            }
            String str11 = str5;
            str5 = (String) map2.get("threadName");
            if (str5 == null) {
                str5 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            num2 = (Integer) c.get("et");
            if (num2 != null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str5);
                stringBuilder2.append("(");
                stringBuilder2.append(num2);
                stringBuilder2.append(")");
                str5 = stringBuilder2.toString();
            }
            str10 = str5;
            str5 = (String) map2.get("processName");
            if (str5 == null) {
                str5 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            num2 = (Integer) c.get("ep");
            if (num2 != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str5);
                stringBuilder.append("(");
                stringBuilder.append(num2);
                stringBuilder.append(")");
                str5 = stringBuilder.toString();
            }
            str7 = (String) map2.get("key-value");
            if (str7 != null) {
                HashMap hashMap = new HashMap();
                String[] split = str7.split("\n");
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String[] split2 = split[i].split(HttpUtils.EQUAL_SIGN);
                    String[] strArr = split;
                    if (split2.length == 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                    i++;
                    split = strArr;
                }
                map3 = hashMap;
            } else {
                map3 = null;
            }
            CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str5, str10, (((long) ((Integer) c.get("ets")).intValue()) * 1000) + (((long) ((Integer) c.get("etms")).intValue()) / 1000), str4, str6, a(str9), str3, str11, str8, (String) map2.get("sysLogPath"), str2, a, map3, false);
            if (packageCrashDatas != null) {
                str = (String) map2.get("userId");
                if (str != null) {
                    x.c("[Native record info] userId: %s", str);
                    packageCrashDatas.m = str;
                }
                str = (String) map2.get("sysLog");
                if (str != null) {
                    packageCrashDatas.w = str;
                }
                str = (String) map2.get("appVersion");
                if (str != null) {
                    x.c("[Native record info] appVersion: %s", str);
                    packageCrashDatas.f = str;
                }
                str = (String) map2.get("isAppForeground");
                if (str != null) {
                    x.c("[Native record info] isAppForeground: %s", str);
                    packageCrashDatas.M = str.equalsIgnoreCase("true");
                }
                String str12 = (String) map2.get("launchTime");
                if (str12 != null) {
                    x.c("[Native record info] launchTime: %s", str12);
                    packageCrashDatas.L = Long.parseLong(str12);
                }
                packageCrashDatas.y = null;
                packageCrashDatas.k = true;
            }
            return packageCrashDatas;
        } catch (NumberFormatException e) {
            th = e;
            if (!x.a(th)) {
                th.printStackTrace();
            }
        } catch (Throwable e2) {
            th = e2;
            x.e("error format", new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    private static String a(BufferedInputStream bufferedInputStream) throws IOException {
        if (bufferedInputStream == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int read = bufferedInputStream.read();
            if (read == -1) {
                return null;
            }
            if (read == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append((char) read);
        }
    }

    protected static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                stringBuilder.append(str2);
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b0 A:{SYNTHETIC, Splitter:B:36:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bc A:{SYNTHETIC, Splitter:B:43:0x00bc} */
    public static java.lang.String a(java.lang.String r7, int r8, java.lang.String r9) {
        /*
        r0 = 0;
        if (r7 == 0) goto L_0x00c6;
    L_0x0003:
        if (r8 > 0) goto L_0x0007;
    L_0x0005:
        goto L_0x00c6;
    L_0x0007:
        r1 = new java.io.File;
        r1.<init>(r7);
        r2 = r1.exists();
        if (r2 == 0) goto L_0x00c5;
    L_0x0012:
        r2 = r1.canRead();
        if (r2 != 0) goto L_0x001a;
    L_0x0018:
        goto L_0x00c5;
    L_0x001a:
        a = r7;
        r2 = "Read system log from native record file(length: %s bytes): %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r1.length();
        r5 = java.lang.Long.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r5 = r1.getAbsolutePath();
        r3[r4] = r5;
        com.tencent.bugly.proguard.x.a(r2, r3);
        if (r9 != 0) goto L_0x0042;
    L_0x0038:
        r9 = new java.io.File;
        r9.<init>(r7);
        r7 = com.tencent.bugly.proguard.z.a(r9);
        goto L_0x0092;
    L_0x0042:
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r7.<init>();	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r3 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r4 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r4.<init>(r1);	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r1 = "utf-8";
        r3.<init>(r4, r1);	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00a9, all -> 0x00a6 }
    L_0x0058:
        r1 = r2.readLine();	 Catch:{ Throwable -> 0x00a4 }
        if (r1 == 0) goto L_0x0086;
    L_0x005e:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a4 }
        r3.<init>();	 Catch:{ Throwable -> 0x00a4 }
        r3.append(r9);	 Catch:{ Throwable -> 0x00a4 }
        r4 = "[ ]*:";
        r3.append(r4);	 Catch:{ Throwable -> 0x00a4 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00a4 }
        r3 = java.util.regex.Pattern.compile(r3);	 Catch:{ Throwable -> 0x00a4 }
        r3 = r3.matcher(r1);	 Catch:{ Throwable -> 0x00a4 }
        r3 = r3.find();	 Catch:{ Throwable -> 0x00a4 }
        if (r3 == 0) goto L_0x0058;
    L_0x007d:
        r7.append(r1);	 Catch:{ Throwable -> 0x00a4 }
        r1 = "\n";
        r7.append(r1);	 Catch:{ Throwable -> 0x00a4 }
        goto L_0x0058;
    L_0x0086:
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00a4 }
        r2.close();	 Catch:{ Exception -> 0x008e }
        goto L_0x0092;
    L_0x008e:
        r9 = move-exception;
        com.tencent.bugly.proguard.x.a(r9);
    L_0x0092:
        if (r7 == 0) goto L_0x00a3;
    L_0x0094:
        r9 = r7.length();
        if (r9 <= r8) goto L_0x00a3;
    L_0x009a:
        r9 = r7.length();
        r9 = r9 - r8;
        r7 = r7.substring(r9);
    L_0x00a3:
        return r7;
    L_0x00a4:
        r7 = move-exception;
        goto L_0x00ab;
    L_0x00a6:
        r7 = move-exception;
        r2 = r0;
        goto L_0x00ba;
    L_0x00a9:
        r7 = move-exception;
        r2 = r0;
    L_0x00ab:
        com.tencent.bugly.proguard.x.a(r7);	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x00b8;
    L_0x00b0:
        r2.close();	 Catch:{ Exception -> 0x00b4 }
        goto L_0x00b8;
    L_0x00b4:
        r7 = move-exception;
        com.tencent.bugly.proguard.x.a(r7);
    L_0x00b8:
        return r0;
    L_0x00b9:
        r7 = move-exception;
    L_0x00ba:
        if (r2 == 0) goto L_0x00c4;
    L_0x00bc:
        r2.close();	 Catch:{ Exception -> 0x00c0 }
        goto L_0x00c4;
    L_0x00c0:
        r8 = move-exception;
        com.tencent.bugly.proguard.x.a(r8);
    L_0x00c4:
        throw r7;
    L_0x00c5:
        return r0;
    L_0x00c6:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.b.a(java.lang.String, int, java.lang.String):java.lang.String");
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String b = b(str, str2);
        if (!(b == null || b.isEmpty())) {
            stringBuilder.append("Register infos:\n");
            stringBuilder.append(b);
        }
        str = c(str, str2);
        if (!(str == null || str.isEmpty())) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append("System SO infos:\n");
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static void a(boolean z, String str) {
        if (str != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists() && file.canWrite()) {
                file.delete();
                x.c("delete record file %s", file.getAbsoluteFile());
            }
            file = new File(str, "reg_record.txt");
            if (file.exists() && file.canWrite()) {
                file.delete();
                x.c("delete record file %s", file.getAbsoluteFile());
            }
            file = new File(str, "map_record.txt");
            if (file.exists() && file.canWrite()) {
                file.delete();
                x.c("delete record file %s", file.getAbsoluteFile());
            }
            file = new File(str, "backup_record.txt");
            if (file.exists() && file.canWrite()) {
                file.delete();
                x.c("delete record file %s", file.getAbsoluteFile());
            }
            if (a != null) {
                file = new File(a);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                    x.c("delete record file %s", file.getAbsoluteFile());
                }
            }
            if (z) {
                File file2 = new File(str);
                if (file2.canRead() && file2.isDirectory()) {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null) {
                        for (File file3 : listFiles) {
                            if (file3.canRead() && file3.canWrite() && file3.length() == 0) {
                                file3.delete();
                                x.c("delete invalid record file %s", file3.getAbsoluteFile());
                            }
                        }
                    }
                }
            }
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        return file.exists() ? file.getAbsolutePath() : null;
    }

    private static String b(String str, String str2) {
        BufferedReader a = z.a(str, "reg_record.txt");
        if (a == null) {
            return null;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String readLine = a.readLine();
            if (readLine != null) {
                if (readLine.startsWith(str2)) {
                    str2 = "                ";
                    int i = 18;
                    int i2 = 0;
                    int i3 = i2;
                    while (true) {
                        String readLine2 = a.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        if (i2 % 4 == 0) {
                            if (i2 > 0) {
                                stringBuilder.append("\n");
                            }
                            stringBuilder.append("  ");
                        } else {
                            if (readLine2.length() > 16) {
                                i = 28;
                            }
                            stringBuilder.append(str2.substring(0, i - i3));
                        }
                        i3 = readLine2.length();
                        stringBuilder.append(readLine2);
                        i2++;
                    }
                    stringBuilder.append("\n");
                    str2 = stringBuilder.toString();
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Exception e) {
                            x.a(e);
                        }
                    }
                    return str2;
                }
            }
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e2) {
                    x.a(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e22) {
                    x.a(e22);
                }
            }
        }
    }

    private static String c(String str, String str2) {
        BufferedReader a = z.a(str, "map_record.txt");
        if (a == null) {
            return null;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String readLine = a.readLine();
            if (readLine != null) {
                if (readLine.startsWith(str2)) {
                    while (true) {
                        str2 = a.readLine();
                        if (str2 == null) {
                            break;
                        }
                        stringBuilder.append("  ");
                        stringBuilder.append(str2);
                        stringBuilder.append("\n");
                    }
                    str2 = stringBuilder.toString();
                    if (a != null) {
                        try {
                            a.close();
                        } catch (Exception e) {
                            x.a(e);
                        }
                    }
                    return str2;
                }
            }
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e2) {
                    x.a(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            if (a != null) {
                try {
                    a.close();
                } catch (Exception e22) {
                    x.a(e22);
                }
            }
        }
    }

    private static Map<String, Integer> c(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String split : str.split(",")) {
                String[] split2 = split.split(":");
                if (split2.length != 2) {
                    x.e("error format at %s", split);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e) {
            x.e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }
}
