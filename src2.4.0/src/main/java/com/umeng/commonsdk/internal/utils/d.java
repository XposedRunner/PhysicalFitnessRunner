package com.umeng.commonsdk.internal.utils;

import java.io.InputStream;

/* compiled from: CpuUtil */
public class d {

    /* compiled from: CpuUtil */
    public static class a {
        public String a;
        public String b;
        public int c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:139:0x014e A:{SYNTHETIC, Splitter:B:139:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0130 A:{Splitter:B:23:0x0028, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x014e A:{SYNTHETIC, Splitter:B:139:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x013f A:{SYNTHETIC, Splitter:B:124:0x013f} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0144 A:{SYNTHETIC, Splitter:B:128:0x0144} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x014e A:{SYNTHETIC, Splitter:B:139:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x013f A:{SYNTHETIC, Splitter:B:124:0x013f} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0144 A:{SYNTHETIC, Splitter:B:128:0x0144} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x014e A:{SYNTHETIC, Splitter:B:139:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0139 A:{Splitter:B:1:0x0002, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:109:0x012a, code skipped:
            if (r4 == null) goto L_0x0154;
     */
    /* JADX WARNING: Missing block: B:112:?, code skipped:
            r4.close();
     */
    /* JADX WARNING: Missing block: B:113:0x0130, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:120:0x0139, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:121:0x013a, code skipped:
            r3 = null;
            r4 = r3;
     */
    /* JADX WARNING: Missing block: B:125:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:129:?, code skipped:
            r4.close();
     */
    /* JADX WARNING: Missing block: B:132:0x0148, code skipped:
            r2 = null;
            r3 = r2;
     */
    /* JADX WARNING: Missing block: B:140:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:141:0x0151, code skipped:
            if (r4 == null) goto L_0x0154;
     */
    public static com.umeng.commonsdk.internal.utils.d.a a() {
        /*
        r0 = 0;
        r1 = 0;
        r2 = new com.umeng.commonsdk.internal.utils.d$a;	 Catch:{ Exception -> 0x0148, all -> 0x0139 }
        r2.<init>();	 Catch:{ Exception -> 0x0148, all -> 0x0139 }
        r3 = new java.io.FileReader;	 Catch:{ Exception -> 0x0137, all -> 0x0139 }
        r4 = "/proc/cpuinfo";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0137, all -> 0x0139 }
        if (r3 != 0) goto L_0x0016;
    L_0x0010:
        if (r3 == 0) goto L_0x0015;
    L_0x0012:
        r3.close();	 Catch:{ IOException -> 0x0015 }
    L_0x0015:
        return r0;
    L_0x0016:
        r4 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
        r4.<init>(r3);	 Catch:{ Exception -> 0x0135, all -> 0x0132 }
        if (r4 != 0) goto L_0x0028;
    L_0x001d:
        if (r3 == 0) goto L_0x0022;
    L_0x001f:
        r3.close();	 Catch:{ IOException -> 0x0022 }
    L_0x0022:
        if (r4 == 0) goto L_0x0027;
    L_0x0024:
        r4.close();	 Catch:{ IOException -> 0x0027 }
    L_0x0027:
        return r0;
    L_0x0028:
        r0 = r4.readLine();	 Catch:{ Exception -> 0x014b, all -> 0x0130 }
        r5 = 1;
        r6 = r1;
        r8 = r6;
        r7 = r5;
    L_0x0030:
        r9 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 != 0) goto L_0x0125;
    L_0x0036:
        r6 = r6 + r5;
        r9 = 30;
        if (r6 < r9) goto L_0x003d;
    L_0x003b:
        goto L_0x0125;
    L_0x003d:
        r9 = ":\\s+";
        r10 = 2;
        r0 = r0.split(r9, r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r7 == 0) goto L_0x0050;
    L_0x0046:
        if (r0 == 0) goto L_0x0050;
    L_0x0048:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x0050;
    L_0x004b:
        r7 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.a = r7;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r7 = r1;
    L_0x0050:
        if (r0 == 0) goto L_0x0061;
    L_0x0052:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x0061;
    L_0x0055:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "processor";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x0061;
    L_0x005f:
        r8 = r8 + 1;
    L_0x0061:
        if (r0 == 0) goto L_0x0074;
    L_0x0063:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x0074;
    L_0x0066:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "Features";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x0074;
    L_0x0070:
        r9 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.d = r9;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
    L_0x0074:
        if (r0 == 0) goto L_0x0087;
    L_0x0076:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x0087;
    L_0x0079:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "implementer";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x0087;
    L_0x0083:
        r9 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.e = r9;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
    L_0x0087:
        if (r0 == 0) goto L_0x009a;
    L_0x0089:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x009a;
    L_0x008c:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "architecture";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x009a;
    L_0x0096:
        r9 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.f = r9;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
    L_0x009a:
        if (r0 == 0) goto L_0x00ad;
    L_0x009c:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x00ad;
    L_0x009f:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "variant";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x00ad;
    L_0x00a9:
        r9 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.g = r9;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
    L_0x00ad:
        if (r0 == 0) goto L_0x00c0;
    L_0x00af:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x00c0;
    L_0x00b2:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "part";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x00c0;
    L_0x00bc:
        r9 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.h = r9;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
    L_0x00c0:
        if (r0 == 0) goto L_0x00d3;
    L_0x00c2:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x00d3;
    L_0x00c5:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "revision";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x00d3;
    L_0x00cf:
        r9 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.i = r9;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
    L_0x00d3:
        if (r0 == 0) goto L_0x00e6;
    L_0x00d5:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x00e6;
    L_0x00d8:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "Hardware";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x00e6;
    L_0x00e2:
        r9 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.j = r9;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
    L_0x00e6:
        if (r0 == 0) goto L_0x00f9;
    L_0x00e8:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x00f9;
    L_0x00eb:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "Revision";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x00f9;
    L_0x00f5:
        r9 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.k = r9;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
    L_0x00f9:
        if (r0 == 0) goto L_0x010c;
    L_0x00fb:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x010c;
    L_0x00fe:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "Serial";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x010c;
    L_0x0108:
        r9 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.l = r9;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
    L_0x010c:
        if (r0 == 0) goto L_0x011f;
    L_0x010e:
        r9 = r0.length;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 <= r5) goto L_0x011f;
    L_0x0111:
        r9 = r0[r1];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r10 = "implementer";
        r9 = r9.contains(r10);	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        if (r9 == 0) goto L_0x011f;
    L_0x011b:
        r0 = r0[r5];	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        r2.e = r0;	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
    L_0x011f:
        r0 = r4.readLine();	 Catch:{ Exception -> 0x014c, all -> 0x0130 }
        goto L_0x0030;
    L_0x0125:
        if (r3 == 0) goto L_0x012a;
    L_0x0127:
        r3.close();	 Catch:{ IOException -> 0x012a }
    L_0x012a:
        if (r4 == 0) goto L_0x0154;
    L_0x012c:
        r4.close();	 Catch:{ IOException -> 0x0154 }
        goto L_0x0154;
    L_0x0130:
        r0 = move-exception;
        goto L_0x013d;
    L_0x0132:
        r1 = move-exception;
        r4 = r0;
        goto L_0x013c;
    L_0x0135:
        r4 = r0;
        goto L_0x014b;
    L_0x0137:
        r3 = r0;
        goto L_0x014a;
    L_0x0139:
        r1 = move-exception;
        r3 = r0;
        r4 = r3;
    L_0x013c:
        r0 = r1;
    L_0x013d:
        if (r3 == 0) goto L_0x0142;
    L_0x013f:
        r3.close();	 Catch:{ IOException -> 0x0142 }
    L_0x0142:
        if (r4 == 0) goto L_0x0147;
    L_0x0144:
        r4.close();	 Catch:{ IOException -> 0x0147 }
    L_0x0147:
        throw r0;
    L_0x0148:
        r2 = r0;
        r3 = r2;
    L_0x014a:
        r4 = r3;
    L_0x014b:
        r8 = r1;
    L_0x014c:
        if (r3 == 0) goto L_0x0151;
    L_0x014e:
        r3.close();	 Catch:{ IOException -> 0x0151 }
    L_0x0151:
        if (r4 == 0) goto L_0x0154;
    L_0x0153:
        goto L_0x012c;
    L_0x0154:
        r2.c = r8;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.d.a():com.umeng.commonsdk.internal.utils.d$a");
    }

    public static String b() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(new String(bArr));
                str = stringBuilder.toString();
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String c() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(new String(bArr));
                str = stringBuilder.toString();
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002c A:{SYNTHETIC, Splitter:B:22:0x002c} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0026 A:{SYNTHETIC, Splitter:B:16:0x0026} */
    public static java.lang.String d() {
        /*
        r0 = "";
        r1 = 0;
        r2 = new java.io.FileReader;	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
        r3 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
        r2.<init>(r3);	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
        r3 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
        r1 = r3.readLine();	 Catch:{ Exception -> 0x0021, all -> 0x001e }
        r1 = r1.trim();	 Catch:{ Exception -> 0x0021, all -> 0x001e }
        if (r3 == 0) goto L_0x001c;
    L_0x0019:
        r3.close();	 Catch:{ Throwable -> 0x001c }
    L_0x001c:
        r0 = r1;
        goto L_0x002f;
    L_0x001e:
        r0 = move-exception;
        r1 = r3;
        goto L_0x0024;
    L_0x0021:
        r1 = r3;
        goto L_0x002a;
    L_0x0023:
        r0 = move-exception;
    L_0x0024:
        if (r1 == 0) goto L_0x0029;
    L_0x0026:
        r1.close();	 Catch:{ Throwable -> 0x0029 }
    L_0x0029:
        throw r0;
    L_0x002a:
        if (r1 == 0) goto L_0x002f;
    L_0x002c:
        r1.close();	 Catch:{ Throwable -> 0x002f }
    L_0x002f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.d.d():java.lang.String");
    }
}
