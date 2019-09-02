package com.taobao.wireless.security.adapter.common;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/*  JADX ERROR: NullPointerException in pass: ReSugarCode
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
    	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ExtractFieldInit.checkStaticFieldsInit(ExtractFieldInit.java:58)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
public class c {
    private static Context a;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.common.c.<clinit>():void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 9 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: com.taobao.wireless.security.adapter.common.c.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.c.<clinit>():void");
    }

    private static int a(URLConnection uRLConnection) throws IOException {
        return uRLConnection instanceof HttpsURLConnection ? ((HttpsURLConnection) uRLConnection).getResponseCode() : ((HttpURLConnection) uRLConnection).getResponseCode();
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:78:0x0110=Splitter:B:78:0x0110, B:90:0x0130=Splitter:B:90:0x0130, B:102:0x0152=Splitter:B:102:0x0152} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x015b A:{SYNTHETIC, Splitter:B:105:0x015b} */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0165 A:{Catch:{ Throwable -> 0x0174 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0139 A:{SYNTHETIC, Splitter:B:93:0x0139} */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0143 A:{Catch:{ Throwable -> 0x0174 }} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0117 A:{SYNTHETIC, Splitter:B:81:0x0117} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0121 A:{Catch:{ Throwable -> 0x0174 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0179 A:{SYNTHETIC, Splitter:B:119:0x0179} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a2 A:{SYNTHETIC, Splitter:B:42:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084 A:{Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0076 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A:{Splitter:B:10:0x0031, ExcHandler: UnknownHostException (e java.net.UnknownHostException)} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A:{Splitter:B:10:0x0031, ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f A:{Splitter:B:23:0x005e, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:16:0x004f, code skipped:
            r8 = th;
     */
    /* JADX WARNING: Missing block: B:17:0x0052, code skipped:
            r8 = th;
     */
    /* JADX WARNING: Missing block: B:18:0x0053, code skipped:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:19:0x0056, code skipped:
            r8 = e;
     */
    /* JADX WARNING: Missing block: B:20:0x0057, code skipped:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:21:0x005a, code skipped:
            r8 = e;
     */
    /* JADX WARNING: Missing block: B:22:0x005b, code skipped:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:72:0x0104, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x0106;
     */
    /* JADX WARNING: Missing block: B:73:0x0106, code skipped:
            android.net.TrafficStats.clearThreadStatsTag();
     */
    /* JADX WARNING: Missing block: B:74:0x0109, code skipped:
            return r5;
     */
    /* JADX WARNING: Missing block: B:89:0x012d, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x0106;
     */
    /* JADX WARNING: Missing block: B:101:0x014f, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x0106;
     */
    /* JADX WARNING: Missing block: B:113:0x0171, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x0106;
     */
    public static com.taobao.wireless.security.adapter.common.b a(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
        r0 = 1;
        r1 = new java.lang.String[r0];
        r2 = 0;
        r1[r2] = r7;
        r1 = com.taobao.wireless.security.adapter.common.a.a(r1);
        r2 = 0;
        if (r1 == 0) goto L_0x0015;
    L_0x000d:
        r7 = new com.taobao.wireless.security.adapter.common.b;
        r8 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r7.<init>(r2, r8);
        return r7;
    L_0x0015:
        r1 = "GET";
        r3 = 22000; // 0x55f0 float:3.0829E-41 double:1.08694E-319;
        r7 = a(r7, r3, r3, r1);
        r1 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        if (r7 != 0) goto L_0x0027;
    L_0x0021:
        r7 = new com.taobao.wireless.security.adapter.common.b;
        r7.<init>(r2, r1);
        return r7;
    L_0x0027:
        r3 = new com.taobao.wireless.security.adapter.common.b;
        r4 = -1;
        r3.<init>(r2, r4);
        r3 = 14;
        if (r8 == 0) goto L_0x005e;
    L_0x0031:
        r4 = r8.keySet();	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r4 = r4.iterator();	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
    L_0x0039:
        r5 = r4.hasNext();	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        if (r5 == 0) goto L_0x005e;
    L_0x003f:
        r5 = r4.next();	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r5 = (java.lang.String) r5;	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r6 = r8.get(r5);	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r6 = (java.lang.String) r6;	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r7.setRequestProperty(r5, r6);	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        goto L_0x0039;
    L_0x004f:
        r8 = move-exception;
        goto L_0x0177;
    L_0x0052:
        r8 = move-exception;
        r4 = r2;
        goto L_0x0110;
    L_0x0056:
        r8 = move-exception;
        r4 = r2;
        goto L_0x0130;
    L_0x005a:
        r8 = move-exception;
        r4 = r2;
        goto L_0x0152;
    L_0x005e:
        r8 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0076, UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, all -> 0x004f }
        if (r8 < r3) goto L_0x0076;
    L_0x0062:
        r8 = a;	 Catch:{ Throwable -> 0x0076, UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, all -> 0x004f }
        r8 = r8.getPackageName();	 Catch:{ Throwable -> 0x0076, UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, all -> 0x004f }
        r4 = "com.alibaba.android.rimet";
        r8 = r8.equalsIgnoreCase(r4);	 Catch:{ Throwable -> 0x0076, UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, all -> 0x004f }
        if (r8 == 0) goto L_0x0076;
    L_0x0070:
        r8 = 61453; // 0xf00d float:8.6114E-41 double:3.0362E-319;
        android.net.TrafficStats.setThreadStatsTag(r8);	 Catch:{ Throwable -> 0x0076, UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, all -> 0x004f }
    L_0x0076:
        r7.setDoInput(r0);	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r7.connect();	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r8 = a(r7);	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r8 == r0) goto L_0x00a2;
    L_0x0084:
        r0 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r0.<init>(r2, r8);	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        b(r7);
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x00a1 }
        if (r7 < r3) goto L_0x00a1;
    L_0x0090:
        r7 = a;	 Catch:{ Throwable -> 0x00a1 }
        r7 = r7.getPackageName();	 Catch:{ Throwable -> 0x00a1 }
        r8 = "com.alibaba.android.rimet";
        r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x00a1 }
        if (r7 == 0) goto L_0x00a1;
    L_0x009e:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x00a1 }
    L_0x00a1:
        return r0;
    L_0x00a2:
        r8 = r7.getInputStream();	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        if (r8 != 0) goto L_0x00c8;
    L_0x00a8:
        r8 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8.<init>(r2, r0);	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        b(r7);
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x00c7 }
        if (r7 < r3) goto L_0x00c7;
    L_0x00b6:
        r7 = a;	 Catch:{ Throwable -> 0x00c7 }
        r7 = r7.getPackageName();	 Catch:{ Throwable -> 0x00c7 }
        r0 = "com.alibaba.android.rimet";
        r7 = r7.equalsIgnoreCase(r0);	 Catch:{ Throwable -> 0x00c7 }
        if (r7 == 0) goto L_0x00c7;
    L_0x00c4:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x00c7 }
    L_0x00c7:
        return r8;
    L_0x00c8:
        r4 = new java.io.BufferedReader;	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r5 = new java.io.InputStreamReader;	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r6 = "UTF-8";
        r5.<init>(r8, r6);	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r4.<init>(r5);	 Catch:{ UnknownHostException -> 0x005a, SSLHandshakeException -> 0x0056, Throwable -> 0x0052, all -> 0x004f }
        r8 = new java.lang.StringBuilder;	 Catch:{ UnknownHostException -> 0x010e, SSLHandshakeException -> 0x010c, Throwable -> 0x010a }
        r8.<init>();	 Catch:{ UnknownHostException -> 0x010e, SSLHandshakeException -> 0x010c, Throwable -> 0x010a }
    L_0x00d9:
        r5 = r4.readLine();	 Catch:{ UnknownHostException -> 0x010e, SSLHandshakeException -> 0x010c, Throwable -> 0x010a }
        if (r5 == 0) goto L_0x00e3;
    L_0x00df:
        r8.append(r5);	 Catch:{ UnknownHostException -> 0x010e, SSLHandshakeException -> 0x010c, Throwable -> 0x010a }
        goto L_0x00d9;
    L_0x00e3:
        r5 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ UnknownHostException -> 0x010e, SSLHandshakeException -> 0x010c, Throwable -> 0x010a }
        r8 = r8.toString();	 Catch:{ UnknownHostException -> 0x010e, SSLHandshakeException -> 0x010c, Throwable -> 0x010a }
        r5.<init>(r8, r0);	 Catch:{ UnknownHostException -> 0x010e, SSLHandshakeException -> 0x010c, Throwable -> 0x010a }
        if (r4 == 0) goto L_0x00f1;
    L_0x00ee:
        r4.close();	 Catch:{ Throwable -> 0x00f1 }
    L_0x00f1:
        b(r7);
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0174 }
        if (r7 < r3) goto L_0x0174;
    L_0x00f8:
        r7 = a;	 Catch:{ Throwable -> 0x0174 }
        r7 = r7.getPackageName();	 Catch:{ Throwable -> 0x0174 }
        r8 = "com.alibaba.android.rimet";
        r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x0174 }
        if (r7 == 0) goto L_0x0174;
    L_0x0106:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x0174 }
        return r5;
    L_0x010a:
        r8 = move-exception;
        goto L_0x0110;
    L_0x010c:
        r8 = move-exception;
        goto L_0x0130;
    L_0x010e:
        r8 = move-exception;
        goto L_0x0152;
    L_0x0110:
        r5 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ all -> 0x0175 }
        r5.<init>(r2, r1, r8);	 Catch:{ all -> 0x0175 }
        if (r4 == 0) goto L_0x011a;
    L_0x0117:
        r4.close();	 Catch:{ Throwable -> 0x011a }
    L_0x011a:
        b(r7);
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0174 }
        if (r7 < r3) goto L_0x0174;
    L_0x0121:
        r7 = a;	 Catch:{ Throwable -> 0x0174 }
        r7 = r7.getPackageName();	 Catch:{ Throwable -> 0x0174 }
        r8 = "com.alibaba.android.rimet";
        r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x0174 }
        if (r7 == 0) goto L_0x0174;
    L_0x012f:
        goto L_0x0106;
    L_0x0130:
        r5 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ all -> 0x0175 }
        r0 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        r5.<init>(r2, r0, r8);	 Catch:{ all -> 0x0175 }
        if (r4 == 0) goto L_0x013c;
    L_0x0139:
        r4.close();	 Catch:{ Throwable -> 0x013c }
    L_0x013c:
        b(r7);
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0174 }
        if (r7 < r3) goto L_0x0174;
    L_0x0143:
        r7 = a;	 Catch:{ Throwable -> 0x0174 }
        r7 = r7.getPackageName();	 Catch:{ Throwable -> 0x0174 }
        r8 = "com.alibaba.android.rimet";
        r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x0174 }
        if (r7 == 0) goto L_0x0174;
    L_0x0151:
        goto L_0x0106;
    L_0x0152:
        r5 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ all -> 0x0175 }
        r0 = 1003; // 0x3eb float:1.406E-42 double:4.955E-321;
        r5.<init>(r2, r0, r8);	 Catch:{ all -> 0x0175 }
        if (r4 == 0) goto L_0x015e;
    L_0x015b:
        r4.close();	 Catch:{ Throwable -> 0x015e }
    L_0x015e:
        b(r7);
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0174 }
        if (r7 < r3) goto L_0x0174;
    L_0x0165:
        r7 = a;	 Catch:{ Throwable -> 0x0174 }
        r7 = r7.getPackageName();	 Catch:{ Throwable -> 0x0174 }
        r8 = "com.alibaba.android.rimet";
        r7 = r7.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x0174 }
        if (r7 == 0) goto L_0x0174;
    L_0x0173:
        goto L_0x0106;
    L_0x0174:
        return r5;
    L_0x0175:
        r8 = move-exception;
        r2 = r4;
    L_0x0177:
        if (r2 == 0) goto L_0x017c;
    L_0x0179:
        r2.close();	 Catch:{ Throwable -> 0x017c }
    L_0x017c:
        b(r7);
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0194 }
        if (r7 < r3) goto L_0x0194;
    L_0x0183:
        r7 = a;	 Catch:{ Throwable -> 0x0194 }
        r7 = r7.getPackageName();	 Catch:{ Throwable -> 0x0194 }
        r0 = "com.alibaba.android.rimet";
        r7 = r7.equalsIgnoreCase(r0);	 Catch:{ Throwable -> 0x0194 }
        if (r7 == 0) goto L_0x0194;
    L_0x0191:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x0194 }
    L_0x0194:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.c.a(java.lang.String, java.util.Map):com.taobao.wireless.security.adapter.common.b");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:125:0x0170=Splitter:B:125:0x0170, B:141:0x0197=Splitter:B:141:0x0197} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01c4 A:{SYNTHETIC, Splitter:B:162:0x01c4} */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01c9 A:{SYNTHETIC, Splitter:B:166:0x01c9} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01c4 A:{SYNTHETIC, Splitter:B:162:0x01c4} */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01c9 A:{SYNTHETIC, Splitter:B:166:0x01c9} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bd A:{SYNTHETIC, Splitter:B:53:0x00bd} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a A:{Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0075 */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01a0 A:{SYNTHETIC, Splitter:B:144:0x01a0} */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01a5 A:{SYNTHETIC, Splitter:B:148:0x01a5} */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01af A:{Catch:{ Throwable -> 0x01bf }} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0179 A:{SYNTHETIC, Splitter:B:128:0x0179} */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x017e A:{SYNTHETIC, Splitter:B:132:0x017e} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0188 A:{Catch:{ Throwable -> 0x01bf }} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01c4 A:{SYNTHETIC, Splitter:B:162:0x01c4} */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x01c9 A:{SYNTHETIC, Splitter:B:166:0x01c9} */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01a0 A:{SYNTHETIC, Splitter:B:144:0x01a0} */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01a5 A:{SYNTHETIC, Splitter:B:148:0x01a5} */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01af A:{Catch:{ Throwable -> 0x01bf }} */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0179 A:{SYNTHETIC, Splitter:B:128:0x0179} */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x017e A:{SYNTHETIC, Splitter:B:132:0x017e} */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0188 A:{Catch:{ Throwable -> 0x01bf }} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x014e A:{SYNTHETIC, Splitter:B:110:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0153 A:{SYNTHETIC, Splitter:B:114:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x015d A:{Catch:{ Throwable -> 0x01bf }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058 A:{Splitter:B:9:0x002b, ExcHandler: UnknownHostException (e java.net.UnknownHostException)} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053 A:{Splitter:B:9:0x002b, ExcHandler: SSLHandshakeException (e javax.net.ssl.SSLHandshakeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x014e A:{SYNTHETIC, Splitter:B:110:0x014e} */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0153 A:{SYNTHETIC, Splitter:B:114:0x0153} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x015d A:{Catch:{ Throwable -> 0x01bf }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049 A:{Splitter:B:23:0x005d, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x0049, code skipped:
            r7 = th;
     */
    /* JADX WARNING: Missing block: B:16:0x004a, code skipped:
            r0 = null;
     */
    /* JADX WARNING: Missing block: B:19:0x0053, code skipped:
            r7 = e;
     */
    /* JADX WARNING: Missing block: B:20:0x0054, code skipped:
            r8 = null;
            r0 = r8;
     */
    /* JADX WARNING: Missing block: B:21:0x0058, code skipped:
            r7 = e;
     */
    /* JADX WARNING: Missing block: B:22:0x0059, code skipped:
            r8 = null;
            r0 = r8;
     */
    /* JADX WARNING: Missing block: B:91:0x0129, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x012b;
     */
    /* JADX WARNING: Missing block: B:92:0x012b, code skipped:
            android.net.TrafficStats.clearThreadStatsTag();
     */
    /* JADX WARNING: Missing block: B:93:0x012e, code skipped:
            return r1;
     */
    /* JADX WARNING: Missing block: B:122:0x0169, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x012b;
     */
    /* JADX WARNING: Missing block: B:140:0x0194, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x012b;
     */
    /* JADX WARNING: Missing block: B:156:0x01bb, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x012b;
     */
    public static com.taobao.wireless.security.adapter.common.b a(java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, byte[] r8, java.lang.String r9, int r10, int r11) {
        /*
        r0 = 1;
        r1 = new java.lang.String[r0];
        r2 = 0;
        r1[r2] = r6;
        r1 = com.taobao.wireless.security.adapter.common.a.a(r1);
        r2 = 0;
        if (r1 != 0) goto L_0x01e5;
    L_0x000d:
        if (r8 != 0) goto L_0x0011;
    L_0x000f:
        goto L_0x01e5;
    L_0x0011:
        r1 = "POST";
        r6 = a(r6, r10, r11, r1);
        r10 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        if (r6 != 0) goto L_0x0021;
    L_0x001b:
        r6 = new com.taobao.wireless.security.adapter.common.b;
        r6.<init>(r2, r10);
        return r6;
    L_0x0021:
        r11 = new com.taobao.wireless.security.adapter.common.b;
        r1 = -1;
        r11.<init>(r2, r1);
        r11 = 14;
        if (r7 == 0) goto L_0x005d;
    L_0x002b:
        r1 = r7.keySet();	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        r1 = r1.iterator();	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
    L_0x0033:
        r3 = r1.hasNext();	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        if (r3 == 0) goto L_0x005d;
    L_0x0039:
        r3 = r1.next();	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        r3 = (java.lang.String) r3;	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        r4 = r7.get(r3);	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        r4 = (java.lang.String) r4;	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        r6.setRequestProperty(r3, r4);	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        goto L_0x0033;
    L_0x0049:
        r7 = move-exception;
        r0 = r2;
        goto L_0x01c2;
    L_0x004d:
        r7 = move-exception;
        r8 = r7;
        r7 = r2;
        r0 = r7;
        goto L_0x0147;
    L_0x0053:
        r7 = move-exception;
        r8 = r2;
        r0 = r8;
        goto L_0x0170;
    L_0x0058:
        r7 = move-exception;
        r8 = r2;
        r0 = r8;
        goto L_0x0197;
    L_0x005d:
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0075, UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, all -> 0x0049 }
        if (r7 < r11) goto L_0x0075;
    L_0x0061:
        r7 = a;	 Catch:{ Throwable -> 0x0075, UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, all -> 0x0049 }
        r7 = r7.getPackageName();	 Catch:{ Throwable -> 0x0075, UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, all -> 0x0049 }
        r1 = "com.alibaba.android.rimet";
        r7 = r7.equalsIgnoreCase(r1);	 Catch:{ Throwable -> 0x0075, UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, all -> 0x0049 }
        if (r7 == 0) goto L_0x0075;
    L_0x006f:
        r7 = 61453; // 0xf00d float:8.6114E-41 double:3.0362E-319;
        android.net.TrafficStats.setThreadStatsTag(r7);	 Catch:{ Throwable -> 0x0075, UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, all -> 0x0049 }
    L_0x0075:
        r6.setDoInput(r0);	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        if (r9 == 0) goto L_0x0085;
    L_0x007a:
        r7 = r9.length();	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        if (r7 <= 0) goto L_0x0085;
    L_0x0080:
        r7 = "Content-Type";
        r6.setRequestProperty(r7, r9);	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
    L_0x0085:
        r6.connect();	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        r7 = r6.getOutputStream();	 Catch:{ UnknownHostException -> 0x0058, SSLHandshakeException -> 0x0053, Throwable -> 0x004d, all -> 0x0049 }
        r7.write(r8);	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        r7.flush();	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        r8 = a(r6);	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r8 == r9) goto L_0x00bd;
    L_0x009a:
        r9 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        r9.<init>(r2, r8);	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        if (r7 == 0) goto L_0x00a4;
    L_0x00a1:
        r7.close();	 Catch:{ Throwable -> 0x00a4 }
    L_0x00a4:
        b(r6);
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x00bc }
        if (r6 < r11) goto L_0x00bc;
    L_0x00ab:
        r6 = a;	 Catch:{ Throwable -> 0x00bc }
        r6 = r6.getPackageName();	 Catch:{ Throwable -> 0x00bc }
        r7 = "com.alibaba.android.rimet";
        r6 = r6.equalsIgnoreCase(r7);	 Catch:{ Throwable -> 0x00bc }
        if (r6 == 0) goto L_0x00bc;
    L_0x00b9:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x00bc }
    L_0x00bc:
        return r9;
    L_0x00bd:
        r8 = r6.getInputStream();	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        if (r8 != 0) goto L_0x00e8;
    L_0x00c3:
        r8 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        r9 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r8.<init>(r2, r9);	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        if (r7 == 0) goto L_0x00cf;
    L_0x00cc:
        r7.close();	 Catch:{ Throwable -> 0x00cf }
    L_0x00cf:
        b(r6);
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x00e7 }
        if (r6 < r11) goto L_0x00e7;
    L_0x00d6:
        r6 = a;	 Catch:{ Throwable -> 0x00e7 }
        r6 = r6.getPackageName();	 Catch:{ Throwable -> 0x00e7 }
        r7 = "com.alibaba.android.rimet";
        r6 = r6.equalsIgnoreCase(r7);	 Catch:{ Throwable -> 0x00e7 }
        if (r6 == 0) goto L_0x00e7;
    L_0x00e4:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x00e7 }
    L_0x00e7:
        return r8;
    L_0x00e8:
        r0 = new java.io.BufferedReader;	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        r1 = new java.io.InputStreamReader;	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        r3 = "UTF-8";
        r1.<init>(r8, r3);	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        r0.<init>(r1);	 Catch:{ UnknownHostException -> 0x0141, SSLHandshakeException -> 0x013b, Throwable -> 0x0138, all -> 0x0135 }
        r8 = new java.lang.StringBuilder;	 Catch:{ UnknownHostException -> 0x0133, SSLHandshakeException -> 0x0131, Throwable -> 0x012f }
        r8.<init>();	 Catch:{ UnknownHostException -> 0x0133, SSLHandshakeException -> 0x0131, Throwable -> 0x012f }
    L_0x00f9:
        r1 = r0.readLine();	 Catch:{ UnknownHostException -> 0x0133, SSLHandshakeException -> 0x0131, Throwable -> 0x012f }
        if (r1 == 0) goto L_0x0103;
    L_0x00ff:
        r8.append(r1);	 Catch:{ UnknownHostException -> 0x0133, SSLHandshakeException -> 0x0131, Throwable -> 0x012f }
        goto L_0x00f9;
    L_0x0103:
        r1 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ UnknownHostException -> 0x0133, SSLHandshakeException -> 0x0131, Throwable -> 0x012f }
        r8 = r8.toString();	 Catch:{ UnknownHostException -> 0x0133, SSLHandshakeException -> 0x0131, Throwable -> 0x012f }
        r1.<init>(r8, r9);	 Catch:{ UnknownHostException -> 0x0133, SSLHandshakeException -> 0x0131, Throwable -> 0x012f }
        if (r7 == 0) goto L_0x0111;
    L_0x010e:
        r7.close();	 Catch:{ Throwable -> 0x0111 }
    L_0x0111:
        if (r0 == 0) goto L_0x0116;
    L_0x0113:
        r0.close();	 Catch:{ Throwable -> 0x0116 }
    L_0x0116:
        b(r6);
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x01bf }
        if (r6 < r11) goto L_0x01bf;
    L_0x011d:
        r6 = a;	 Catch:{ Throwable -> 0x01bf }
        r6 = r6.getPackageName();	 Catch:{ Throwable -> 0x01bf }
        r7 = "com.alibaba.android.rimet";
        r6 = r6.equalsIgnoreCase(r7);	 Catch:{ Throwable -> 0x01bf }
        if (r6 == 0) goto L_0x01bf;
    L_0x012b:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x01bf }
        return r1;
    L_0x012f:
        r8 = move-exception;
        goto L_0x0147;
    L_0x0131:
        r8 = move-exception;
        goto L_0x013d;
    L_0x0133:
        r8 = move-exception;
        goto L_0x0143;
    L_0x0135:
        r8 = move-exception;
        r0 = r2;
        goto L_0x016d;
    L_0x0138:
        r8 = move-exception;
        r0 = r2;
        goto L_0x0147;
    L_0x013b:
        r8 = move-exception;
        r0 = r2;
    L_0x013d:
        r5 = r8;
        r8 = r7;
        r7 = r5;
        goto L_0x0170;
    L_0x0141:
        r8 = move-exception;
        r0 = r2;
    L_0x0143:
        r5 = r8;
        r8 = r7;
        r7 = r5;
        goto L_0x0197;
    L_0x0147:
        r1 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ all -> 0x016c }
        r1.<init>(r2, r10, r8);	 Catch:{ all -> 0x016c }
        if (r7 == 0) goto L_0x0151;
    L_0x014e:
        r7.close();	 Catch:{ Throwable -> 0x0151 }
    L_0x0151:
        if (r0 == 0) goto L_0x0156;
    L_0x0153:
        r0.close();	 Catch:{ Throwable -> 0x0156 }
    L_0x0156:
        b(r6);
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x01bf }
        if (r6 < r11) goto L_0x01bf;
    L_0x015d:
        r6 = a;	 Catch:{ Throwable -> 0x01bf }
        r6 = r6.getPackageName();	 Catch:{ Throwable -> 0x01bf }
        r7 = "com.alibaba.android.rimet";
        r6 = r6.equalsIgnoreCase(r7);	 Catch:{ Throwable -> 0x01bf }
        if (r6 == 0) goto L_0x01bf;
    L_0x016b:
        goto L_0x012b;
    L_0x016c:
        r8 = move-exception;
    L_0x016d:
        r2 = r7;
        r7 = r8;
        goto L_0x01c2;
    L_0x0170:
        r1 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ all -> 0x01c0 }
        r9 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        r1.<init>(r2, r9, r7);	 Catch:{ all -> 0x01c0 }
        if (r8 == 0) goto L_0x017c;
    L_0x0179:
        r8.close();	 Catch:{ Throwable -> 0x017c }
    L_0x017c:
        if (r0 == 0) goto L_0x0181;
    L_0x017e:
        r0.close();	 Catch:{ Throwable -> 0x0181 }
    L_0x0181:
        b(r6);
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x01bf }
        if (r6 < r11) goto L_0x01bf;
    L_0x0188:
        r6 = a;	 Catch:{ Throwable -> 0x01bf }
        r6 = r6.getPackageName();	 Catch:{ Throwable -> 0x01bf }
        r7 = "com.alibaba.android.rimet";
        r6 = r6.equalsIgnoreCase(r7);	 Catch:{ Throwable -> 0x01bf }
        if (r6 == 0) goto L_0x01bf;
    L_0x0196:
        goto L_0x012b;
    L_0x0197:
        r1 = new com.taobao.wireless.security.adapter.common.b;	 Catch:{ all -> 0x01c0 }
        r9 = 1003; // 0x3eb float:1.406E-42 double:4.955E-321;
        r1.<init>(r2, r9, r7);	 Catch:{ all -> 0x01c0 }
        if (r8 == 0) goto L_0x01a3;
    L_0x01a0:
        r8.close();	 Catch:{ Throwable -> 0x01a3 }
    L_0x01a3:
        if (r0 == 0) goto L_0x01a8;
    L_0x01a5:
        r0.close();	 Catch:{ Throwable -> 0x01a8 }
    L_0x01a8:
        b(r6);
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x01bf }
        if (r6 < r11) goto L_0x01bf;
    L_0x01af:
        r6 = a;	 Catch:{ Throwable -> 0x01bf }
        r6 = r6.getPackageName();	 Catch:{ Throwable -> 0x01bf }
        r7 = "com.alibaba.android.rimet";
        r6 = r6.equalsIgnoreCase(r7);	 Catch:{ Throwable -> 0x01bf }
        if (r6 == 0) goto L_0x01bf;
    L_0x01bd:
        goto L_0x012b;
    L_0x01bf:
        return r1;
    L_0x01c0:
        r7 = move-exception;
        r2 = r8;
    L_0x01c2:
        if (r2 == 0) goto L_0x01c7;
    L_0x01c4:
        r2.close();	 Catch:{ Throwable -> 0x01c7 }
    L_0x01c7:
        if (r0 == 0) goto L_0x01cc;
    L_0x01c9:
        r0.close();	 Catch:{ Throwable -> 0x01cc }
    L_0x01cc:
        b(r6);
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x01e4 }
        if (r6 < r11) goto L_0x01e4;
    L_0x01d3:
        r6 = a;	 Catch:{ Throwable -> 0x01e4 }
        r6 = r6.getPackageName();	 Catch:{ Throwable -> 0x01e4 }
        r8 = "com.alibaba.android.rimet";
        r6 = r6.equalsIgnoreCase(r8);	 Catch:{ Throwable -> 0x01e4 }
        if (r6 == 0) goto L_0x01e4;
    L_0x01e1:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x01e4 }
    L_0x01e4:
        throw r7;
    L_0x01e5:
        r6 = new com.taobao.wireless.security.adapter.common.b;
        r7 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r6.<init>(r2, r7);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.c.a(java.lang.String, java.util.Map, byte[], java.lang.String, int, int):com.taobao.wireless.security.adapter.common.b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:148:0x015b A:{SYNTHETIC, Splitter:B:148:0x015b} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0160 A:{SYNTHETIC, Splitter:B:152:0x0160} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x016a A:{Catch:{ Throwable -> 0x0179 }} */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0139 A:{SYNTHETIC, Splitter:B:131:0x0139} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x013e A:{SYNTHETIC, Splitter:B:135:0x013e} */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0148 A:{Catch:{ Throwable -> 0x0179 }} */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0114 A:{SYNTHETIC, Splitter:B:112:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0119 A:{SYNTHETIC, Splitter:B:116:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0123 A:{Catch:{ Throwable -> 0x0179 }} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00ef A:{SYNTHETIC, Splitter:B:92:0x00ef} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00f4 A:{SYNTHETIC, Splitter:B:96:0x00f4} */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x015b A:{SYNTHETIC, Splitter:B:148:0x015b} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0160 A:{SYNTHETIC, Splitter:B:152:0x0160} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x016a A:{Catch:{ Throwable -> 0x0179 }} */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0139 A:{SYNTHETIC, Splitter:B:131:0x0139} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x013e A:{SYNTHETIC, Splitter:B:135:0x013e} */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0148 A:{Catch:{ Throwable -> 0x0179 }} */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0114 A:{SYNTHETIC, Splitter:B:112:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0119 A:{SYNTHETIC, Splitter:B:116:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0123 A:{Catch:{ Throwable -> 0x0179 }} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00ef A:{SYNTHETIC, Splitter:B:92:0x00ef} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00f4 A:{SYNTHETIC, Splitter:B:96:0x00f4} */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x015b A:{SYNTHETIC, Splitter:B:148:0x015b} */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0160 A:{SYNTHETIC, Splitter:B:152:0x0160} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x016a A:{Catch:{ Throwable -> 0x0179 }} */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0139 A:{SYNTHETIC, Splitter:B:131:0x0139} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x013e A:{SYNTHETIC, Splitter:B:135:0x013e} */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0148 A:{Catch:{ Throwable -> 0x0179 }} */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0114 A:{SYNTHETIC, Splitter:B:112:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0119 A:{SYNTHETIC, Splitter:B:116:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0123 A:{Catch:{ Throwable -> 0x0179 }} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00ef A:{SYNTHETIC, Splitter:B:92:0x00ef} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00f4 A:{SYNTHETIC, Splitter:B:96:0x00f4} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009c A:{SYNTHETIC, Splitter:B:50:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0078 */
    /* JADX WARNING: Removed duplicated region for block: B:145:? A:{SYNTHETIC, Splitter:B:10:0x0028, ExcHandler: UnknownHostException (unused java.net.UnknownHostException)} */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A:{SYNTHETIC, Splitter:B:10:0x0028, ExcHandler: SSLHandshakeException (unused javax.net.ssl.SSLHandshakeException)} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00eb A:{Splitter:B:10:0x0028, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:89:0x00eb, code skipped:
            r9 = th;
     */
    /* JADX WARNING: Missing block: B:90:0x00ec, code skipped:
            r4 = null;
     */
    /* JADX WARNING: Missing block: B:108:0x0110, code skipped:
            r9 = null;
            r4 = r9;
     */
    /* JADX WARNING: Missing block: B:124:0x012f, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x0131;
     */
    /* JADX WARNING: Missing block: B:125:0x0131, code skipped:
            android.net.TrafficStats.clearThreadStatsTag();
     */
    /* JADX WARNING: Missing block: B:126:0x0134, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:127:0x0135, code skipped:
            r9 = null;
            r4 = r9;
     */
    /* JADX WARNING: Missing block: B:143:0x0154, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x0131;
     */
    /* JADX WARNING: Missing block: B:144:0x0157, code skipped:
            r9 = null;
            r4 = r9;
     */
    /* JADX WARNING: Missing block: B:160:0x0176, code skipped:
            if (a.getPackageName().equalsIgnoreCase("com.alibaba.android.rimet") != false) goto L_0x0131;
     */
    public static java.lang.String a(java.lang.String r8, java.lang.String r9) {
        /*
        r0 = a;
        r1 = 0;
        if (r0 == 0) goto L_0x0179;
    L_0x0005:
        r0 = 1;
        r2 = new java.lang.String[r0];
        r3 = 0;
        r2[r3] = r9;
        r2 = com.taobao.wireless.security.adapter.common.a.b(r2);
        if (r2 == 0) goto L_0x0179;
    L_0x0011:
        r2 = new java.lang.String[r0];
        r2[r3] = r8;
        r2 = com.taobao.wireless.security.adapter.common.a.b(r2);
        if (r2 == 0) goto L_0x0179;
    L_0x001b:
        r2 = "GET";
        r4 = 22000; // 0x55f0 float:3.0829E-41 double:1.08694E-319;
        r8 = a(r8, r4, r4, r2);
        if (r8 != 0) goto L_0x0026;
    L_0x0025:
        return r1;
    L_0x0026:
        r2 = 14;
        r8.setDoInput(r0);	 Catch:{ UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, Throwable -> 0x0110, all -> 0x00eb }
        r8.connect();	 Catch:{ UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, Throwable -> 0x0110, all -> 0x00eb }
        r0 = a(r8);	 Catch:{ UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, Throwable -> 0x0110, all -> 0x00eb }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 == r4) goto L_0x004f;
    L_0x0036:
        b(r8);
        r8 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x004e }
        if (r8 < r2) goto L_0x004e;
    L_0x003d:
        r8 = a;	 Catch:{ Throwable -> 0x004e }
        r8 = r8.getPackageName();	 Catch:{ Throwable -> 0x004e }
        r9 = "com.alibaba.android.rimet";
        r8 = r8.equalsIgnoreCase(r9);	 Catch:{ Throwable -> 0x004e }
        if (r8 == 0) goto L_0x004e;
    L_0x004b:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x004e }
    L_0x004e:
        return r1;
    L_0x004f:
        r0 = new java.io.File;	 Catch:{ UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, Throwable -> 0x0110, all -> 0x00eb }
        r0.<init>(r9);	 Catch:{ UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, Throwable -> 0x0110, all -> 0x00eb }
        r9 = r0.exists();	 Catch:{ UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, Throwable -> 0x0110, all -> 0x00eb }
        if (r9 == 0) goto L_0x005d;
    L_0x005a:
        r0.delete();	 Catch:{ UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, Throwable -> 0x0110, all -> 0x00eb }
    L_0x005d:
        r0.createNewFile();	 Catch:{ UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, Throwable -> 0x0110, all -> 0x00eb }
        r9 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0078, UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, all -> 0x00eb }
        if (r9 < r2) goto L_0x0078;
    L_0x0064:
        r9 = a;	 Catch:{ Throwable -> 0x0078, UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, all -> 0x00eb }
        r9 = r9.getPackageName();	 Catch:{ Throwable -> 0x0078, UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, all -> 0x00eb }
        r4 = "com.alibaba.android.rimet";
        r9 = r9.equalsIgnoreCase(r4);	 Catch:{ Throwable -> 0x0078, UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, all -> 0x00eb }
        if (r9 == 0) goto L_0x0078;
    L_0x0072:
        r9 = 61453; // 0xf00d float:8.6114E-41 double:3.0362E-319;
        android.net.TrafficStats.setThreadStatsTag(r9);	 Catch:{ Throwable -> 0x0078, UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, all -> 0x00eb }
    L_0x0078:
        r9 = r8.getInputStream();	 Catch:{ UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, Throwable -> 0x0110, all -> 0x00eb }
        if (r9 != 0) goto L_0x009c;
    L_0x007e:
        if (r9 == 0) goto L_0x0083;
    L_0x0080:
        r9.close();	 Catch:{ Exception -> 0x0083 }
    L_0x0083:
        b(r8);
        r8 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x009b }
        if (r8 < r2) goto L_0x009b;
    L_0x008a:
        r8 = a;	 Catch:{ Throwable -> 0x009b }
        r8 = r8.getPackageName();	 Catch:{ Throwable -> 0x009b }
        r9 = "com.alibaba.android.rimet";
        r8 = r8.equalsIgnoreCase(r9);	 Catch:{ Throwable -> 0x009b }
        if (r8 == 0) goto L_0x009b;
    L_0x0098:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x009b }
    L_0x009b:
        return r1;
    L_0x009c:
        r4 = new java.io.FileOutputStream;	 Catch:{ UnknownHostException -> 0x00e8, SSLHandshakeException -> 0x00e6, Throwable -> 0x00e4, all -> 0x00df }
        r4.<init>(r0);	 Catch:{ UnknownHostException -> 0x00e8, SSLHandshakeException -> 0x00e6, Throwable -> 0x00e4, all -> 0x00df }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r5];	 Catch:{ UnknownHostException -> 0x0159, SSLHandshakeException -> 0x0137, Throwable -> 0x0112, all -> 0x00dd }
    L_0x00a5:
        r6 = r9.read(r5);	 Catch:{ UnknownHostException -> 0x0159, SSLHandshakeException -> 0x0137, Throwable -> 0x0112, all -> 0x00dd }
        r7 = -1;
        if (r6 == r7) goto L_0x00b0;
    L_0x00ac:
        r4.write(r5, r3, r6);	 Catch:{ UnknownHostException -> 0x0159, SSLHandshakeException -> 0x0137, Throwable -> 0x0112, all -> 0x00dd }
        goto L_0x00a5;
    L_0x00b0:
        r9.close();	 Catch:{ UnknownHostException -> 0x0159, SSLHandshakeException -> 0x0137, Throwable -> 0x0112, all -> 0x00dd }
        r4.close();	 Catch:{ UnknownHostException -> 0x00da, SSLHandshakeException -> 0x00d7, Throwable -> 0x00d5, all -> 0x00d3 }
        r9 = r0.getAbsolutePath();	 Catch:{ UnknownHostException -> 0x0157, SSLHandshakeException -> 0x0135, Throwable -> 0x0110, all -> 0x00eb }
        b(r8);
        r8 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x00d2 }
        if (r8 < r2) goto L_0x00d2;
    L_0x00c1:
        r8 = a;	 Catch:{ Throwable -> 0x00d2 }
        r8 = r8.getPackageName();	 Catch:{ Throwable -> 0x00d2 }
        r0 = "com.alibaba.android.rimet";
        r8 = r8.equalsIgnoreCase(r0);	 Catch:{ Throwable -> 0x00d2 }
        if (r8 == 0) goto L_0x00d2;
    L_0x00cf:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x00d2 }
    L_0x00d2:
        return r9;
    L_0x00d3:
        r9 = move-exception;
        goto L_0x00ed;
    L_0x00d5:
        r9 = r1;
        goto L_0x0112;
    L_0x00d7:
        r9 = r1;
        goto L_0x0137;
    L_0x00da:
        r9 = r1;
        goto L_0x0159;
    L_0x00dd:
        r0 = move-exception;
        goto L_0x00e1;
    L_0x00df:
        r0 = move-exception;
        r4 = r1;
    L_0x00e1:
        r1 = r9;
        r9 = r0;
        goto L_0x00ed;
    L_0x00e4:
        r4 = r1;
        goto L_0x0112;
    L_0x00e6:
        r4 = r1;
        goto L_0x0137;
    L_0x00e8:
        r4 = r1;
        goto L_0x0159;
    L_0x00eb:
        r9 = move-exception;
        r4 = r1;
    L_0x00ed:
        if (r1 == 0) goto L_0x00f2;
    L_0x00ef:
        r1.close();	 Catch:{ Exception -> 0x00f2 }
    L_0x00f2:
        if (r4 == 0) goto L_0x00f7;
    L_0x00f4:
        r4.close();	 Catch:{ Exception -> 0x00f7 }
    L_0x00f7:
        b(r8);
        r8 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x010f }
        if (r8 < r2) goto L_0x010f;
    L_0x00fe:
        r8 = a;	 Catch:{ Throwable -> 0x010f }
        r8 = r8.getPackageName();	 Catch:{ Throwable -> 0x010f }
        r0 = "com.alibaba.android.rimet";
        r8 = r8.equalsIgnoreCase(r0);	 Catch:{ Throwable -> 0x010f }
        if (r8 == 0) goto L_0x010f;
    L_0x010c:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x010f }
    L_0x010f:
        throw r9;
    L_0x0110:
        r9 = r1;
        r4 = r9;
    L_0x0112:
        if (r9 == 0) goto L_0x0117;
    L_0x0114:
        r9.close();	 Catch:{ Exception -> 0x0117 }
    L_0x0117:
        if (r4 == 0) goto L_0x011c;
    L_0x0119:
        r4.close();	 Catch:{ Exception -> 0x011c }
    L_0x011c:
        b(r8);
        r8 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0179 }
        if (r8 < r2) goto L_0x0179;
    L_0x0123:
        r8 = a;	 Catch:{ Throwable -> 0x0179 }
        r8 = r8.getPackageName();	 Catch:{ Throwable -> 0x0179 }
        r9 = "com.alibaba.android.rimet";
        r8 = r8.equalsIgnoreCase(r9);	 Catch:{ Throwable -> 0x0179 }
        if (r8 == 0) goto L_0x0179;
    L_0x0131:
        android.net.TrafficStats.clearThreadStatsTag();	 Catch:{ Throwable -> 0x0179 }
        return r1;
    L_0x0135:
        r9 = r1;
        r4 = r9;
    L_0x0137:
        if (r9 == 0) goto L_0x013c;
    L_0x0139:
        r9.close();	 Catch:{ Exception -> 0x013c }
    L_0x013c:
        if (r4 == 0) goto L_0x0141;
    L_0x013e:
        r4.close();	 Catch:{ Exception -> 0x0141 }
    L_0x0141:
        b(r8);
        r8 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0179 }
        if (r8 < r2) goto L_0x0179;
    L_0x0148:
        r8 = a;	 Catch:{ Throwable -> 0x0179 }
        r8 = r8.getPackageName();	 Catch:{ Throwable -> 0x0179 }
        r9 = "com.alibaba.android.rimet";
        r8 = r8.equalsIgnoreCase(r9);	 Catch:{ Throwable -> 0x0179 }
        if (r8 == 0) goto L_0x0179;
    L_0x0156:
        goto L_0x0131;
    L_0x0157:
        r9 = r1;
        r4 = r9;
    L_0x0159:
        if (r9 == 0) goto L_0x015e;
    L_0x015b:
        r9.close();	 Catch:{ Exception -> 0x015e }
    L_0x015e:
        if (r4 == 0) goto L_0x0163;
    L_0x0160:
        r4.close();	 Catch:{ Exception -> 0x0163 }
    L_0x0163:
        b(r8);
        r8 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0179 }
        if (r8 < r2) goto L_0x0179;
    L_0x016a:
        r8 = a;	 Catch:{ Throwable -> 0x0179 }
        r8 = r8.getPackageName();	 Catch:{ Throwable -> 0x0179 }
        r9 = "com.alibaba.android.rimet";
        r8 = r8.equalsIgnoreCase(r9);	 Catch:{ Throwable -> 0x0179 }
        if (r8 == 0) goto L_0x0179;
    L_0x0178:
        goto L_0x0131;
    L_0x0179:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.wireless.security.adapter.common.c.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static URLConnection a(String str, int i, int i2, String str2) {
        URLConnection openConnection;
        try {
            if (!str.startsWith("http")) {
                return null;
            }
            if (VERSION.SDK_INT < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            openConnection = new URL(str).openConnection();
            if (i <= 0) {
                i = 22000;
            }
            if (i2 <= 0) {
                i2 = 22000;
            }
            try {
                if (str.startsWith("https")) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                    httpsURLConnection.setConnectTimeout(i);
                    httpsURLConnection.setReadTimeout(i2);
                    httpsURLConnection.setRequestMethod(str2);
                } else {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    httpURLConnection.setConnectTimeout(i);
                    httpURLConnection.setReadTimeout(i2);
                    httpURLConnection.setRequestMethod(str2);
                }
                openConnection.setUseCaches(false);
                if ("POST".equals(str2)) {
                    openConnection.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
                    openConnection.setDoOutput(true);
                }
                openConnection.setRequestProperty("Accept-Charset", "UTF-8");
                return openConnection;
            } catch (Throwable unused) {
                return openConnection;
            }
        } catch (Throwable unused2) {
            openConnection = null;
            return openConnection;
        }
    }

    public static void a(Context context) {
        if (context != null) {
            a = context;
        }
    }

    private static void b(URLConnection uRLConnection) {
        if (uRLConnection != null) {
            try {
                if (uRLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) uRLConnection).disconnect();
                } else if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).disconnect();
                }
            } catch (Throwable unused) {
            }
        }
    }
}
