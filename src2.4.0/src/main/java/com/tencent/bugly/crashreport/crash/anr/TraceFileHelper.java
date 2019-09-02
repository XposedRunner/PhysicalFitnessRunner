package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    public interface b {
        boolean a(long j);

        boolean a(long j, long j2, String str);

        boolean a(String str, int i, String str2, String str3);
    }

    /* compiled from: BUGLY */
    public static class a {
        public long a;
        public String b;
        public long c;
        public Map<String, String[]> d;
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(readLine);
            stringBuilder.append("\n");
            stringBuffer.append(stringBuilder.toString());
        }
        return stringBuffer.toString();
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader == null || patternArr == null) {
            return null;
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            for (Pattern matcher : patternArr) {
                if (matcher.matcher(readLine).matches()) {
                    return new Object[]{patternArr[r4], readLine};
                }
            }
        }
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.trim().length() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(readLine);
                stringBuilder.append("\n");
                stringBuffer.append(stringBuilder.toString());
            }
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            x.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() {
            public final boolean a(long j) {
                x.c("process end %d", Long.valueOf(j));
                return false;
            }

            public final boolean a(long j, long j2, String str) {
                x.c("new process %s", str);
                aVar.a = j;
                aVar.b = str;
                aVar.c = j2;
                return z;
            }

            public final boolean a(String str, int i, String str2, String str3) {
                x.c("new thread %s", str);
                if (aVar.d == null) {
                    aVar.d = new HashMap();
                }
                Map map = aVar.d;
                String[] strArr = new String[3];
                strArr[0] = str2;
                strArr[1] = str3;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                strArr[2] = stringBuilder.toString();
                map.put(str, strArr);
                return true;
            }
        });
        if (aVar.a > 0 && aVar.c > 0 && aVar.b != null) {
            return aVar;
        }
        Object[] objArr = new Object[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aVar.a);
        stringBuilder.append(" ");
        stringBuilder.append(aVar.c);
        stringBuilder.append(" ");
        stringBuilder.append(aVar.b);
        objArr[0] = stringBuilder.toString();
        x.e("first dump error %s", objArr);
        return null;
    }

    public static a readTargetDumpInfo(String str, String str2, final boolean z) {
        if (str == null || str2 == null) {
            return null;
        }
        final a aVar = new a();
        readTraceFile(str2, new b() {
            public final boolean a(long j) {
                x.c("process end %d", Long.valueOf(j));
                return aVar.a <= 0 || aVar.c <= 0 || aVar.b == null;
            }

            public final boolean a(long j, long j2, String str) {
                x.c("new process %s", str);
                if (!str.equals(str)) {
                    return true;
                }
                aVar.a = j;
                aVar.b = str;
                aVar.c = j2;
                return z;
            }

            public final boolean a(String str, int i, String str2, String str3) {
                x.c("new thread %s", str);
                if (aVar.a <= 0 || aVar.c <= 0 || aVar.b == null) {
                    return true;
                }
                if (aVar.d == null) {
                    aVar.d = new HashMap();
                }
                Map map = aVar.d;
                String[] strArr = new String[3];
                strArr[0] = str2;
                strArr[1] = str3;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                strArr[2] = stringBuilder.toString();
                map.put(str, strArr);
                return true;
            }
        });
        return (aVar.a <= 0 || aVar.c <= 0 || aVar.b == null) ? null : aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x017a A:{Catch:{ all -> 0x01b2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b1 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01a2 A:{SYNTHETIC, Splitter:B:72:0x01a2} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01b6 A:{SYNTHETIC, Splitter:B:83:0x01b6} */
    public static void readTraceFile(java.lang.String r18, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b r19) {
        /*
        r1 = r18;
        r7 = r19;
        if (r1 == 0) goto L_0x01c5;
    L_0x0006:
        if (r7 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x01c5;
    L_0x000a:
        r2 = new java.io.File;
        r2.<init>(r1);
        r1 = r2.exists();
        if (r1 != 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r2.lastModified();
        r2.length();
        r1 = 0;
        r8 = 2;
        r9 = 0;
        r10 = 1;
        r11 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0171, all -> 0x016d }
        r3 = new java.io.FileReader;	 Catch:{ Exception -> 0x0171, all -> 0x016d }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0171, all -> 0x016d }
        r11.<init>(r3);	 Catch:{ Exception -> 0x0171, all -> 0x016d }
        r1 = "-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}";
        r12 = java.util.regex.Pattern.compile(r1);	 Catch:{ Exception -> 0x016b }
        r1 = "-{5}\\send\\s\\d+\\s-{5}";
        r13 = java.util.regex.Pattern.compile(r1);	 Catch:{ Exception -> 0x016b }
        r1 = "Cmd\\sline:\\s(\\S+)";
        r14 = java.util.regex.Pattern.compile(r1);	 Catch:{ Exception -> 0x016b }
        r1 = "\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*";
        r15 = java.util.regex.Pattern.compile(r1);	 Catch:{ Exception -> 0x016b }
        r6 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x016b }
        r1 = "yyyy-MM-dd HH:mm:ss";
        r2 = java.util.Locale.US;	 Catch:{ Exception -> 0x016b }
        r6.<init>(r1, r2);	 Catch:{ Exception -> 0x016b }
    L_0x004b:
        r1 = new java.util.regex.Pattern[r10];	 Catch:{ Exception -> 0x016b }
        r1[r9] = r12;	 Catch:{ Exception -> 0x016b }
        r1 = a(r11, r1);	 Catch:{ Exception -> 0x016b }
        if (r1 == 0) goto L_0x015c;
    L_0x0055:
        r1 = r1[r10];	 Catch:{ Exception -> 0x016b }
        r1 = r1.toString();	 Catch:{ Exception -> 0x016b }
        r2 = "\\s";
        r1 = r1.split(r2);	 Catch:{ Exception -> 0x016b }
        r2 = r1[r8];	 Catch:{ Exception -> 0x016b }
        r2 = java.lang.Long.parseLong(r2);	 Catch:{ Exception -> 0x016b }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x016b }
        r4.<init>();	 Catch:{ Exception -> 0x016b }
        r5 = 4;
        r5 = r1[r5];	 Catch:{ Exception -> 0x016b }
        r4.append(r5);	 Catch:{ Exception -> 0x016b }
        r5 = " ";
        r4.append(r5);	 Catch:{ Exception -> 0x016b }
        r5 = 5;
        r1 = r1[r5];	 Catch:{ Exception -> 0x016b }
        r4.append(r1);	 Catch:{ Exception -> 0x016b }
        r1 = r4.toString();	 Catch:{ Exception -> 0x016b }
        r1 = r6.parse(r1);	 Catch:{ Exception -> 0x016b }
        r4 = r1.getTime();	 Catch:{ Exception -> 0x016b }
        r1 = new java.util.regex.Pattern[r10];	 Catch:{ Exception -> 0x016b }
        r1[r9] = r14;	 Catch:{ Exception -> 0x016b }
        r1 = a(r11, r1);	 Catch:{ Exception -> 0x016b }
        if (r1 != 0) goto L_0x00a2;
    L_0x0093:
        r11.close();	 Catch:{ IOException -> 0x0097 }
        return;
    L_0x0097:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x00a1;
    L_0x009e:
        r0.printStackTrace();
    L_0x00a1:
        return;
    L_0x00a2:
        r1 = r1[r10];	 Catch:{ Exception -> 0x016b }
        r1 = r1.toString();	 Catch:{ Exception -> 0x016b }
        r1 = r14.matcher(r1);	 Catch:{ Exception -> 0x016b }
        r1.find();	 Catch:{ Exception -> 0x016b }
        r1.group(r10);	 Catch:{ Exception -> 0x016b }
        r16 = r1.group(r10);	 Catch:{ Exception -> 0x016b }
        r1 = r7;
        r17 = r6;
        r6 = r16;
        r1 = r1.a(r2, r4, r6);	 Catch:{ Exception -> 0x016b }
        if (r1 != 0) goto L_0x00d0;
    L_0x00c1:
        r11.close();	 Catch:{ IOException -> 0x00c5 }
        return;
    L_0x00c5:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x00cf;
    L_0x00cc:
        r0.printStackTrace();
    L_0x00cf:
        return;
    L_0x00d0:
        r1 = new java.util.regex.Pattern[r8];	 Catch:{ Exception -> 0x016b }
        r1[r9] = r15;	 Catch:{ Exception -> 0x016b }
        r1[r10] = r13;	 Catch:{ Exception -> 0x016b }
        r1 = a(r11, r1);	 Catch:{ Exception -> 0x016b }
        if (r1 == 0) goto L_0x0158;
    L_0x00dc:
        r2 = r1[r9];	 Catch:{ Exception -> 0x016b }
        if (r2 != r15) goto L_0x0131;
    L_0x00e0:
        r1 = r1[r10];	 Catch:{ Exception -> 0x016b }
        r1 = r1.toString();	 Catch:{ Exception -> 0x016b }
        r2 = "\".+\"";
        r2 = java.util.regex.Pattern.compile(r2);	 Catch:{ Exception -> 0x016b }
        r2 = r2.matcher(r1);	 Catch:{ Exception -> 0x016b }
        r2.find();	 Catch:{ Exception -> 0x016b }
        r2 = r2.group();	 Catch:{ Exception -> 0x016b }
        r3 = r2.length();	 Catch:{ Exception -> 0x016b }
        r3 = r3 - r10;
        r2 = r2.substring(r10, r3);	 Catch:{ Exception -> 0x016b }
        r3 = "NATIVE";
        r1.contains(r3);	 Catch:{ Exception -> 0x016b }
        r3 = "tid=\\d+";
        r3 = java.util.regex.Pattern.compile(r3);	 Catch:{ Exception -> 0x016b }
        r1 = r3.matcher(r1);	 Catch:{ Exception -> 0x016b }
        r1.find();	 Catch:{ Exception -> 0x016b }
        r1 = r1.group();	 Catch:{ Exception -> 0x016b }
        r3 = "=";
        r3 = r1.indexOf(r3);	 Catch:{ Exception -> 0x016b }
        r3 = r3 + r10;
        r1 = r1.substring(r3);	 Catch:{ Exception -> 0x016b }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x016b }
        r3 = a(r11);	 Catch:{ Exception -> 0x016b }
        r4 = b(r11);	 Catch:{ Exception -> 0x016b }
        r7.a(r2, r1, r3, r4);	 Catch:{ Exception -> 0x016b }
        goto L_0x00d0;
    L_0x0131:
        r1 = r1[r10];	 Catch:{ Exception -> 0x016b }
        r1 = r1.toString();	 Catch:{ Exception -> 0x016b }
        r2 = "\\s";
        r1 = r1.split(r2);	 Catch:{ Exception -> 0x016b }
        r1 = r1[r8];	 Catch:{ Exception -> 0x016b }
        r1 = java.lang.Long.parseLong(r1);	 Catch:{ Exception -> 0x016b }
        r1 = r7.a(r1);	 Catch:{ Exception -> 0x016b }
        if (r1 != 0) goto L_0x0158;
    L_0x0149:
        r11.close();	 Catch:{ IOException -> 0x014d }
        return;
    L_0x014d:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x0157;
    L_0x0154:
        r0.printStackTrace();
    L_0x0157:
        return;
    L_0x0158:
        r6 = r17;
        goto L_0x004b;
    L_0x015c:
        r11.close();	 Catch:{ IOException -> 0x0160 }
        return;
    L_0x0160:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x016a;
    L_0x0167:
        r0.printStackTrace();
    L_0x016a:
        return;
    L_0x016b:
        r0 = move-exception;
        goto L_0x0173;
    L_0x016d:
        r0 = move-exception;
        r11 = r1;
    L_0x016f:
        r1 = r0;
        goto L_0x01b4;
    L_0x0171:
        r0 = move-exception;
        r11 = r1;
    L_0x0173:
        r1 = r0;
        r2 = com.tencent.bugly.proguard.x.a(r1);	 Catch:{ all -> 0x01b2 }
        if (r2 != 0) goto L_0x017d;
    L_0x017a:
        r1.printStackTrace();	 Catch:{ all -> 0x01b2 }
    L_0x017d:
        r2 = "trace open fail:%s : %s";
        r3 = new java.lang.Object[r8];	 Catch:{ all -> 0x01b2 }
        r4 = r1.getClass();	 Catch:{ all -> 0x01b2 }
        r4 = r4.getName();	 Catch:{ all -> 0x01b2 }
        r3[r9] = r4;	 Catch:{ all -> 0x01b2 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b2 }
        r4.<init>();	 Catch:{ all -> 0x01b2 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x01b2 }
        r4.append(r1);	 Catch:{ all -> 0x01b2 }
        r1 = r4.toString();	 Catch:{ all -> 0x01b2 }
        r3[r10] = r1;	 Catch:{ all -> 0x01b2 }
        com.tencent.bugly.proguard.x.d(r2, r3);	 Catch:{ all -> 0x01b2 }
        if (r11 == 0) goto L_0x01b1;
    L_0x01a2:
        r11.close();	 Catch:{ IOException -> 0x01a6 }
        return;
    L_0x01a6:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.x.a(r0);
        if (r1 != 0) goto L_0x01b0;
    L_0x01ad:
        r0.printStackTrace();
    L_0x01b0:
        return;
    L_0x01b1:
        return;
    L_0x01b2:
        r0 = move-exception;
        goto L_0x016f;
    L_0x01b4:
        if (r11 == 0) goto L_0x01c4;
    L_0x01b6:
        r11.close();	 Catch:{ IOException -> 0x01ba }
        goto L_0x01c4;
    L_0x01ba:
        r0 = move-exception;
        r2 = com.tencent.bugly.proguard.x.a(r0);
        if (r2 != 0) goto L_0x01c4;
    L_0x01c1:
        r0.printStackTrace();
    L_0x01c4:
        throw r1;
    L_0x01c5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTraceFile(java.lang.String, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b):void");
    }
}
