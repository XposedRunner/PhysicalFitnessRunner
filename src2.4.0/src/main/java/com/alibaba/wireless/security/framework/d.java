package com.alibaba.wireless.security.framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import com.alibaba.wireless.security.framework.utils.c;
import com.alibaba.wireless.security.framework.utils.f;
import com.alibaba.wireless.security.open.SecException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class d implements ISGPluginManager {
    private static String[] n = new String[]{"armeabi", "armeabi-v7a", "x86", "arm64-v8a", "x86_64"};
    private static String o = null;
    private static volatile boolean p = true;
    HashMap<Class, Object> a = new HashMap();
    c b = null;
    private Context c;
    private final HashMap<String, c> d = new HashMap();
    private IRouterComponent e = null;
    private boolean f = true;
    private String g = null;
    private String h = null;
    private b i = null;
    private boolean j = false;
    private File k = null;
    private File l = null;
    private File m = null;

    private static class a {
        File a;
        File b;
        File c;
        boolean d;

        public a(File file, File file2, File file3, boolean z) {
            this.a = file;
            this.b = file2;
            this.c = file3;
            this.d = z;
        }
    }

    private int a(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int length = split.length < split2.length ? split.length : split2.length;
        for (int i = 0; i < length; i++) {
            int parseInt = Integer.parseInt(split[i]);
            int parseInt2 = Integer.parseInt(split2[i]);
            if (parseInt > parseInt2) {
                return 1;
            }
            if (parseInt < parseInt2) {
                return -1;
            }
        }
        return 0;
    }

    private PackageInfo a(String str, a aVar, String str2) throws SecException {
        PackageInfo packageArchiveInfo;
        String str3;
        StringBuilder stringBuilder;
        try {
            packageArchiveInfo = this.c.getPackageManager().getPackageArchiveInfo(aVar.a.getAbsolutePath(), 133);
        } catch (Throwable th) {
            str3 = "getPackageArchiveInfo failed";
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(th);
            String stringBuilder3 = stringBuilder2.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(aVar.a.getAbsolutePath());
            stringBuilder.append("");
            a(100043, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, str3, stringBuilder3, c(stringBuilder.toString()), aVar.c != null ? c(aVar.c.getAbsolutePath()) : "", str2);
            if (aVar.a.exists() && !b(aVar.a)) {
                aVar.a.delete();
            }
            packageArchiveInfo = null;
        }
        if (packageArchiveInfo != null) {
            return packageArchiveInfo;
        }
        str3 = "packageInfo == null";
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("[");
        stringBuilder.append(str2);
        stringBuilder.append("]");
        a(100043, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, str3, stringBuilder.toString(), c(aVar.a.getAbsolutePath()), aVar.c != null ? c(aVar.c.getAbsolutePath()) : "", c());
        throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e8 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{SYNTHETIC, Splitter:B:31:0x00a7} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c5 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01c0 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x024e A:{SYNTHETIC, Splitter:B:62:0x024e} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e2 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{SYNTHETIC, Splitter:B:31:0x00a7} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e8 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fe A:{SKIP, Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01c0 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c5 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e2 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x024e A:{SYNTHETIC, Splitter:B:62:0x024e} */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x05cb A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0531 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:136:0x0498 */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e8 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{SYNTHETIC, Splitter:B:31:0x00a7} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fe A:{SKIP, Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c5 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01c0 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x024e A:{SYNTHETIC, Splitter:B:62:0x024e} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e2 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{SYNTHETIC, Splitter:B:31:0x00a7} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e8 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fe A:{SKIP, Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01c0 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c5 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e2 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x024e A:{SYNTHETIC, Splitter:B:62:0x024e} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e8 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{SYNTHETIC, Splitter:B:31:0x00a7} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fe A:{SKIP, Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c5 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01c0 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x024e A:{SYNTHETIC, Splitter:B:62:0x024e} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e2 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A:{SYNTHETIC, Splitter:B:31:0x00a7} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e8 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fe A:{SKIP, Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01c0 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01c5 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01e2 A:{Catch:{ SecException -> 0x062b, all -> 0x05bf, all -> 0x0693 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x024e A:{SYNTHETIC, Splitter:B:62:0x024e} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:136|137) */
    /* JADX WARNING: Missing block: B:137:?, code skipped:
            r4 = "";
     */
    /* JADX WARNING: Missing block: B:150:0x050b, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:151:0x050c, code skipped:
            r11 = r5;
            r39 = r7;
     */
    /* JADX WARNING: Missing block: B:156:0x0531, code skipped:
            r4 = "";
            r5 = r10.toString();
     */
    /* JADX WARNING: Missing block: B:157:0x0540, code skipped:
            if (r45.length() == 0) goto L_0x0542;
     */
    /* JADX WARNING: Missing block: B:158:0x0542, code skipped:
            r6 = r39;
     */
    /* JADX WARNING: Missing block: B:159:0x0544, code skipped:
            r11 = r43;
     */
    /* JADX WARNING: Missing block: B:160:0x0547, code skipped:
            r1 = new java.lang.StringBuilder();
            r1.append(r12);
            r1.append("->");
            r1.append(r39);
            r6 = r1.toString();
     */
    /* JADX WARNING: Missing block: B:162:0x0561, code skipped:
            if (r11.c != null) goto L_0x0563;
     */
    /* JADX WARNING: Missing block: B:163:0x0563, code skipped:
            r1 = new java.lang.StringBuilder();
            r1.append("src:");
            r1.append(c(r11.c.getAbsolutePath()));
     */
    /* JADX WARNING: Missing block: B:164:0x057b, code skipped:
            r1 = new java.lang.StringBuilder();
            r1.append("zipfile:");
            r1.append(c(r11.a.getAbsolutePath()));
     */
    /* JADX WARNING: Missing block: B:165:0x0592, code skipped:
            a(100043, 103, r4, r5, r6, r1.toString(), c(r13.getAbsolutePath()));
     */
    /* JADX WARNING: Missing block: B:168:0x05a5, code skipped:
            if (r11.d == false) goto L_0x05a7;
     */
    /* JADX WARNING: Missing block: B:169:0x05a7, code skipped:
            r9.b.a();
     */
    /* JADX WARNING: Missing block: B:171:0x05b0, code skipped:
            if (r13.exists() != false) goto L_0x05b2;
     */
    /* JADX WARNING: Missing block: B:172:0x05b2, code skipped:
            r13.delete();
     */
    /* JADX WARNING: Missing block: B:175:0x05b7, code skipped:
            if (r11.d == false) goto L_0x05b9;
     */
    /* JADX WARNING: Missing block: B:176:0x05b9, code skipped:
            r9.b.b();
     */
    /* JADX WARNING: Missing block: B:182:0x05cb, code skipped:
            r1 = r11;
            r11 = r43;
            r5 = r10.toString();
            r6 = new java.lang.StringBuilder();
            r6.append("soName=");
            r6.append(r1);
            r6.append(", authCode=");
            r6.append(r9.h);
            r6.append(", errorCode=");
            r6.append(r10.getErrorCode());
            a(100043, com.alibaba.wireless.security.SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "native exception occurred", r5, r6.toString(), c(r11.a.getAbsolutePath()), c(r13.getAbsolutePath()));
     */
    private com.alibaba.wireless.security.framework.c a(java.lang.String r42, com.alibaba.wireless.security.framework.d.a r43, android.content.Context r44, java.lang.String r45) throws com.alibaba.wireless.security.open.SecException {
        /*
        r41 = this;
        r9 = r41;
        r10 = r42;
        r11 = r43;
        r12 = r45;
        r1 = r11.a;
        r13 = r1.getAbsolutePath();
        r1 = r11.b;
        r14 = r1.getAbsolutePath();
        r15 = 0;
        r1 = java.lang.Boolean.valueOf(r15);
        r2 = java.lang.Boolean.valueOf(r15);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r14);
        r4 = java.io.File.separator;
        r3.append(r4);
        r3.append(r10);
        r4 = "_";
        r3.append(r4);
        r4 = r11.a;
        r4 = r4.lastModified();
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 / r6;
        r3.append(r4);
        r4 = ".pkgInfo";
        r3.append(r4);
        r3 = r3.toString();
        r8 = new com.alibaba.wireless.security.framework.a;
        r8.<init>(r3);
        r16 = 0;
        r3 = r8.a();	 Catch:{ all -> 0x0693 }
        r18 = 1;
        r19 = 0;
        if (r3 == 0) goto L_0x009f;
    L_0x0058:
        r3 = r8.b();	 Catch:{ Exception | JSONException -> 0x0098, Exception | JSONException -> 0x0098 }
        r4 = "version";
        r4 = r3.getString(r4);	 Catch:{ Exception | JSONException -> 0x0098, Exception | JSONException -> 0x0098 }
        r5 = "dependencies";
        r5 = r3.getString(r5);	 Catch:{ Exception | JSONException -> 0x0094, Exception | JSONException -> 0x0094 }
        r6 = "hasso";
        r6 = r3.getString(r6);	 Catch:{ Exception | JSONException -> 0x0091, Exception | JSONException -> 0x0091 }
        r6 = java.lang.Boolean.parseBoolean(r6);	 Catch:{ Exception | JSONException -> 0x0091, Exception | JSONException -> 0x0091 }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception | JSONException -> 0x0091, Exception | JSONException -> 0x0091 }
        r1 = "pluginclass";
        r1 = r3.getString(r1);	 Catch:{ JSONException -> 0x0090, Exception -> 0x008e }
        r7 = "thirdpartyso";
        r3 = r3.getBoolean(r7);	 Catch:{ Exception | JSONException -> 0x008b, Exception | JSONException -> 0x008b }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ Exception | JSONException -> 0x008b, Exception | JSONException -> 0x008b }
        r2 = r3;
        r3 = r1;
        r1 = r18;
        goto L_0x00a5;
    L_0x008b:
        r3 = r1;
        r1 = r6;
        goto L_0x009c;
    L_0x008e:
        r1 = r6;
        goto L_0x0091;
    L_0x0090:
        r1 = r6;
    L_0x0091:
        r3 = r19;
        goto L_0x009c;
    L_0x0094:
        r3 = r19;
        r5 = r3;
        goto L_0x009c;
    L_0x0098:
        r3 = r19;
        r4 = r3;
        r5 = r4;
    L_0x009c:
        r6 = r1;
        r1 = r15;
        goto L_0x00a5;
    L_0x009f:
        r6 = r1;
        r1 = r15;
        r3 = r19;
        r4 = r3;
        r5 = r4;
    L_0x00a5:
        if (r1 != 0) goto L_0x00e8;
    L_0x00a7:
        r1 = r9.a(r10, r11, r12);	 Catch:{ all -> 0x0693 }
        r4 = r1.versionName;	 Catch:{ all -> 0x0693 }
        r2 = r1.applicationInfo;	 Catch:{ all -> 0x0693 }
        r2 = r2.metaData;	 Catch:{ all -> 0x0693 }
        r3 = "dependencies";
        r2 = r2.getString(r3);	 Catch:{ all -> 0x0693 }
        r3 = r1.applicationInfo;	 Catch:{ all -> 0x0693 }
        r3 = r3.metaData;	 Catch:{ all -> 0x0693 }
        r5 = "hasso";
        r3 = r3.getBoolean(r5, r15);	 Catch:{ all -> 0x0693 }
        r6 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x0693 }
        r3 = r1.applicationInfo;	 Catch:{ all -> 0x0693 }
        r3 = r3.metaData;	 Catch:{ all -> 0x0693 }
        r5 = "pluginclass";
        r3 = r3.getString(r5);	 Catch:{ all -> 0x0693 }
        r5 = r1.applicationInfo;	 Catch:{ all -> 0x0693 }
        r5 = r5.metaData;	 Catch:{ all -> 0x0693 }
        r7 = "thirdpartyso";
        r5 = r5.getBoolean(r7, r15);	 Catch:{ all -> 0x0693 }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ all -> 0x0693 }
        r8.a = r1;	 Catch:{ all -> 0x0693 }
        r8.a(r1, r10);	 Catch:{ all -> 0x0693 }
        r7 = r4;
        r4 = r3;
        r3 = r5;
        r5 = r6;
        r6 = r2;
        goto L_0x00f0;
    L_0x00e8:
        r7 = r4;
        r4 = r3;
        r3 = r2;
        r40 = r6;
        r6 = r5;
        r5 = r40;
    L_0x00f0:
        r1 = r9.c;	 Catch:{ all -> 0x0693 }
        r1 = r1.getPackageName();	 Catch:{ all -> 0x0693 }
        r2 = "com.eg.android.AlipayGphone";
        r1 = r2.equals(r1);	 Catch:{ all -> 0x0693 }
        if (r1 == 0) goto L_0x0194;
    L_0x00fe:
        if (r7 == 0) goto L_0x0194;
    L_0x0100:
        r1 = "6.4.3448869";
        r1 = r7.contains(r1);	 Catch:{ all -> 0x0693 }
        if (r1 == 0) goto L_0x0194;
    L_0x0108:
        r20 = 2;
        r21 = android.os.Build.FINGERPRINT;	 Catch:{ all -> 0x0693 }
        r1 = r11.c;	 Catch:{ all -> 0x0693 }
        if (r1 == 0) goto L_0x0117;
    L_0x0110:
        r1 = r11.c;	 Catch:{ all -> 0x0693 }
        r1 = r1.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        goto L_0x0119;
    L_0x0117:
        r1 = "";
    L_0x0119:
        r22 = r1;
        r1 = com.alibaba.wireless.security.framework.d.class;
        r1 = r1.getClassLoader();	 Catch:{ all -> 0x0693 }
        r23 = r1.toString();	 Catch:{ all -> 0x0693 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r1.append(r13);	 Catch:{ all -> 0x0693 }
        r15 = "(";
        r1.append(r15);	 Catch:{ all -> 0x0693 }
        r15 = r11.a;	 Catch:{ all -> 0x0693 }
        r24 = r3;
        r2 = r15.getTotalSpace();	 Catch:{ all -> 0x0693 }
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r2 = "),";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r1.append(r14);	 Catch:{ all -> 0x0693 }
        r15 = r1.toString();	 Catch:{ all -> 0x0693 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r2 = r9.c;	 Catch:{ all -> 0x0693 }
        r2 = r2.getApplicationInfo();	 Catch:{ all -> 0x0693 }
        r2 = r2.sourceDir;	 Catch:{ all -> 0x0693 }
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r2 = ",";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r2 = new java.io.File;	 Catch:{ all -> 0x0693 }
        r3 = r9.c;	 Catch:{ all -> 0x0693 }
        r3 = r3.getApplicationInfo();	 Catch:{ all -> 0x0693 }
        r3 = r3.sourceDir;	 Catch:{ all -> 0x0693 }
        r2.<init>(r3);	 Catch:{ all -> 0x0693 }
        r2 = r2.lastModified();	 Catch:{ all -> 0x0693 }
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r25 = r1.toString();	 Catch:{ all -> 0x0693 }
        r1 = r9;
        r2 = 100088; // 0x186f8 float:1.40253E-40 double:4.945E-319;
        r26 = r24;
        r3 = r20;
        r27 = r4;
        r4 = r21;
        r28 = r5;
        r5 = r22;
        r29 = r6;
        r6 = r23;
        r30 = r7;
        r7 = r15;
        r15 = r8;
        r8 = r25;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0693 }
        goto L_0x019f;
    L_0x0194:
        r26 = r3;
        r27 = r4;
        r28 = r5;
        r29 = r6;
        r30 = r7;
        r15 = r8;
    L_0x019f:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r1.append(r10);	 Catch:{ all -> 0x0693 }
        r2 = "(";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r8 = r30;
        r1.append(r8);	 Catch:{ all -> 0x0693 }
        r2 = ")";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r7 = r1.toString();	 Catch:{ all -> 0x0693 }
        r1 = r45.length();	 Catch:{ all -> 0x0693 }
        if (r1 != 0) goto L_0x01c5;
    L_0x01c0:
        r1 = r7;
    L_0x01c1:
        r6 = r29;
        r2 = 0;
        goto L_0x01da;
    L_0x01c5:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r1.append(r12);	 Catch:{ all -> 0x0693 }
        r2 = "->";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        goto L_0x01c1;
    L_0x01da:
        r1 = r9.a(r6, r1, r2);	 Catch:{ all -> 0x0693 }
        r5 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        if (r1 != 0) goto L_0x024e;
    L_0x01e2:
        r2 = 100043; // 0x186cb float:1.4019E-40 double:4.9428E-319;
        r3 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r4 = "loadRequirements failed";
        r1 = r45.length();	 Catch:{ all -> 0x0693 }
        if (r1 != 0) goto L_0x01f0;
    L_0x01ef:
        goto L_0x0205;
    L_0x01f0:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r1.append(r12);	 Catch:{ all -> 0x0693 }
        r8 = "->";
        r1.append(r8);	 Catch:{ all -> 0x0693 }
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r7 = r1;
    L_0x0205:
        r1 = r11.c;	 Catch:{ all -> 0x0693 }
        if (r1 == 0) goto L_0x0221;
    L_0x0209:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r8 = "src:";
        r1.append(r8);	 Catch:{ all -> 0x0693 }
        r8 = r11.c;	 Catch:{ all -> 0x0693 }
        r8 = r8.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r8 = r9.c(r8);	 Catch:{ all -> 0x0693 }
        r1.append(r8);	 Catch:{ all -> 0x0693 }
        goto L_0x0238;
    L_0x0221:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r8 = "zipfile:";
        r1.append(r8);	 Catch:{ all -> 0x0693 }
        r8 = r11.a;	 Catch:{ all -> 0x0693 }
        r8 = r8.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r8 = r9.c(r8);	 Catch:{ all -> 0x0693 }
        r1.append(r8);	 Catch:{ all -> 0x0693 }
    L_0x0238:
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r8 = r1;
        r10 = "";
        r1 = r9;
        r11 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r10;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0693 }
        r1 = new com.alibaba.wireless.security.open.SecException;	 Catch:{ all -> 0x0693 }
        r1.<init>(r11);	 Catch:{ all -> 0x0693 }
        throw r1;	 Catch:{ all -> 0x0693 }
    L_0x024e:
        r9.b(r10, r8);	 Catch:{ SecException -> 0x062b }
        r1 = "";
        r2 = "";
        r4 = r28;
        r3 = r4.booleanValue();	 Catch:{ all -> 0x0693 }
        if (r3 == 0) goto L_0x0324;
    L_0x025d:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r2 = "libsg";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r1.append(r10);	 Catch:{ all -> 0x0693 }
        r2 = "so-";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r1.append(r8);	 Catch:{ all -> 0x0693 }
        r2 = ".so";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r20 = r1.toString();	 Catch:{ all -> 0x0693 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r2 = "sg";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r1.append(r10);	 Catch:{ all -> 0x0693 }
        r2 = "so-";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r1.append(r8);	 Catch:{ all -> 0x0693 }
        r21 = r1.toString();	 Catch:{ all -> 0x0693 }
        r3 = r11.c;	 Catch:{ all -> 0x0693 }
        r2 = r11.d;	 Catch:{ all -> 0x0693 }
        r1 = r9;
        r22 = r2;
        r2 = r13;
        r23 = r3;
        r3 = r14;
        r31 = r8;
        r8 = r4;
        r4 = r23;
        r32 = r15;
        r15 = r5;
        r5 = r20;
        r23 = r6;
        r6 = r22;
        r1 = r1.a(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x0693 }
        if (r1 != 0) goto L_0x031f;
    L_0x02b3:
        r2 = 100043; // 0x186cb float:1.4019E-40 double:4.9428E-319;
        r3 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r4 = "";
        r1 = r45.length();	 Catch:{ all -> 0x0693 }
        if (r1 != 0) goto L_0x02c2;
    L_0x02c0:
        r6 = r7;
        goto L_0x02d7;
    L_0x02c2:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r1.append(r12);	 Catch:{ all -> 0x0693 }
        r5 = "->";
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r6 = r1;
    L_0x02d7:
        r1 = r11.c;	 Catch:{ all -> 0x0693 }
        if (r1 == 0) goto L_0x02f3;
    L_0x02db:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r5 = "src:";
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        r5 = r11.c;	 Catch:{ all -> 0x0693 }
        r5 = r5.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r5 = r9.c(r5);	 Catch:{ all -> 0x0693 }
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        goto L_0x030a;
    L_0x02f3:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r5 = "zipfile:";
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        r5 = r11.a;	 Catch:{ all -> 0x0693 }
        r5 = r5.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r5 = r9.c(r5);	 Catch:{ all -> 0x0693 }
        r1.append(r5);	 Catch:{ all -> 0x0693 }
    L_0x030a:
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r7 = r1;
        r8 = "";
        r1 = r9;
        r5 = r23;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0693 }
        r1 = new com.alibaba.wireless.security.open.SecException;	 Catch:{ all -> 0x0693 }
        r2 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r1.<init>(r2);	 Catch:{ all -> 0x0693 }
        throw r1;	 Catch:{ all -> 0x0693 }
    L_0x031f:
        r5 = r20;
        r6 = r21;
        goto L_0x032e;
    L_0x0324:
        r23 = r6;
        r31 = r8;
        r32 = r15;
        r8 = r4;
        r15 = r5;
        r5 = r1;
        r6 = r2;
    L_0x032e:
        r3 = r27;
        if (r3 != 0) goto L_0x039c;
    L_0x0332:
        r2 = 100043; // 0x186cb float:1.4019E-40 double:4.9428E-319;
        r3 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r4 = "miss pluginclass";
        r1 = r45.length();	 Catch:{ all -> 0x0693 }
        if (r1 != 0) goto L_0x0341;
    L_0x033f:
        r6 = r7;
        goto L_0x0356;
    L_0x0341:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r1.append(r12);	 Catch:{ all -> 0x0693 }
        r5 = "->";
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r6 = r1;
    L_0x0356:
        r1 = r11.c;	 Catch:{ all -> 0x0693 }
        if (r1 == 0) goto L_0x0372;
    L_0x035a:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r5 = "src:";
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        r5 = r11.c;	 Catch:{ all -> 0x0693 }
        r5 = r5.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r5 = r9.c(r5);	 Catch:{ all -> 0x0693 }
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        goto L_0x0389;
    L_0x0372:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r5 = "zipfile:";
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        r5 = r11.a;	 Catch:{ all -> 0x0693 }
        r5 = r5.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r5 = r9.c(r5);	 Catch:{ all -> 0x0693 }
        r1.append(r5);	 Catch:{ all -> 0x0693 }
    L_0x0389:
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r7 = r1;
        r8 = "";
        r1 = r9;
        r5 = r23;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0693 }
        r1 = new com.alibaba.wireless.security.open.SecException;	 Catch:{ all -> 0x0693 }
        r1.<init>(r15);	 Catch:{ all -> 0x0693 }
        throw r1;	 Catch:{ all -> 0x0693 }
    L_0x039c:
        r4 = r3.trim();	 Catch:{ all -> 0x0693 }
        r1 = r11.d;	 Catch:{ all -> 0x0693 }
        r3 = r9.b(r13, r14, r1);	 Catch:{ all -> 0x0693 }
        r1 = r9.a(r3, r4);	 Catch:{ all -> 0x0693 }
        if (r1 != 0) goto L_0x042f;
    L_0x03ac:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r2 = "load ";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r1.append(r4);	 Catch:{ all -> 0x0693 }
        r2 = " failed from plugin ";
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        com.alibaba.wireless.security.framework.utils.a.b(r1);	 Catch:{ all -> 0x0693 }
        r2 = 100043; // 0x186cb float:1.4019E-40 double:4.9428E-319;
        r3 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r5 = "clazz == null";
        r1 = r45.length();	 Catch:{ all -> 0x0693 }
        if (r1 != 0) goto L_0x03d4;
    L_0x03d2:
        r6 = r7;
        goto L_0x03e9;
    L_0x03d4:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r1.append(r12);	 Catch:{ all -> 0x0693 }
        r6 = "->";
        r1.append(r6);	 Catch:{ all -> 0x0693 }
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r6 = r1;
    L_0x03e9:
        r1 = r11.c;	 Catch:{ all -> 0x0693 }
        if (r1 == 0) goto L_0x0405;
    L_0x03ed:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r7 = "src:";
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        r7 = r11.c;	 Catch:{ all -> 0x0693 }
        r7 = r7.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r7 = r9.c(r7);	 Catch:{ all -> 0x0693 }
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        goto L_0x041c;
    L_0x0405:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r7 = "zipfile:";
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        r7 = r11.a;	 Catch:{ all -> 0x0693 }
        r7 = r7.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r7 = r9.c(r7);	 Catch:{ all -> 0x0693 }
        r1.append(r7);	 Catch:{ all -> 0x0693 }
    L_0x041c:
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r7 = r1;
        r1 = r9;
        r8 = r4;
        r4 = r5;
        r5 = r23;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0693 }
        r1 = new com.alibaba.wireless.security.open.SecException;	 Catch:{ all -> 0x0693 }
        r1.<init>(r15);	 Catch:{ all -> 0x0693 }
        throw r1;	 Catch:{ all -> 0x0693 }
    L_0x042f:
        r1 = r1.newInstance();	 Catch:{ InstantiationException -> 0x0621, IllegalAccessException -> 0x0617, SecException -> 0x050b }
        r15 = r1;
        r15 = (com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin) r15;	 Catch:{ InstantiationException -> 0x0621, IllegalAccessException -> 0x0617, SecException -> 0x050b }
        r20 = new com.alibaba.wireless.security.framework.c;	 Catch:{ InstantiationException -> 0x0621, IllegalAccessException -> 0x0617, SecException -> 0x050b }
        r1 = r20;
        r2 = r13;
        r13 = r3;
        r3 = r9;
        r4 = r10;
        r11 = r5;
        r5 = r13;
        r38 = r6;
        r6 = r32;
        r39 = r7;
        r7 = r15;
        r1.<init>(r2, r3, r4, r5, r6, r7);	 Catch:{ InstantiationException -> 0x0621, IllegalAccessException -> 0x0617, SecException -> 0x0509 }
        r1 = r41.getMainPluginName();	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r1 = r10.equalsIgnoreCase(r1);	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r2 = 3;
        r3 = 2;
        if (r1 == 0) goto L_0x04c5;
    L_0x0456:
        r1 = r9.f;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        if (r1 == 0) goto L_0x045d;
    L_0x045a:
        r1 = r18;
        goto L_0x045e;
    L_0x045d:
        r1 = 0;
    L_0x045e:
        r4 = r9.j;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        if (r4 == 0) goto L_0x0464;
    L_0x0462:
        r1 = r1 | 2;
    L_0x0464:
        r4 = r9.g;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        if (r4 == 0) goto L_0x0472;
    L_0x0468:
        r4 = r9.g;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r4 = r4.length();	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        if (r4 <= 0) goto L_0x0472;
    L_0x0470:
        r1 = r1 | 4;
    L_0x0472:
        r4 = r9.c;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r4 = com.alibaba.wireless.security.framework.utils.f.a(r4);	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        if (r4 == 0) goto L_0x047c;
    L_0x047a:
        r1 = r1 | 8;
    L_0x047c:
        r4 = r9.c;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r4 = com.alibaba.wireless.security.framework.utils.f.b(r4);	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        if (r4 == 0) goto L_0x0486;
    L_0x0484:
        r1 = r1 | 16;
    L_0x0486:
        r4 = r9.i;	 Catch:{ Exception -> 0x0498 }
        if (r4 == 0) goto L_0x0495;
    L_0x048a:
        r4 = r9.i;	 Catch:{ Exception -> 0x0498 }
        r4 = r4.a();	 Catch:{ Exception -> 0x0498 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0498 }
        goto L_0x049a;
    L_0x0495:
        r4 = "";
        goto L_0x049a;
    L_0x0498:
        r4 = "";
    L_0x049a:
        r34 = 0;
        r5 = 4;
        r5 = new java.lang.Object[r5];	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r6 = 0;
        r5[r6] = r1;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r5[r18] = r4;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r1 = r9.l;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r1 = r1.getAbsolutePath();	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r5[r3] = r1;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r1 = r9.h;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r5[r2] = r1;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r32 = r15;
        r33 = r44;
        r35 = r20;
        r36 = r38;
        r37 = r5;
        r1 = r32.onPluginLoaded(r33, r34, r35, r36, r37);	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r9.e = r1;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        goto L_0x04db;
    L_0x04c5:
        com.alibaba.wireless.security.framework.SGPluginExtras.slot = r16;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r1 = r9.e;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r4 = 0;
        r5 = new java.lang.Object[r4];	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r32 = r15;
        r33 = r44;
        r34 = r1;
        r35 = r20;
        r36 = r38;
        r37 = r5;
        r32.onPluginLoaded(r33, r34, r35, r36, r37);	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
    L_0x04db:
        r1 = r8.booleanValue();	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        if (r1 == 0) goto L_0x0628;
    L_0x04e1:
        r5 = r26;
        r1 = r5.booleanValue();	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        if (r1 != 0) goto L_0x0628;
    L_0x04e9:
        r1 = r38;
        r1 = com.alibaba.wireless.security.framework.utils.f.a(r13, r1);	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r4 = r9.e;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r5 = 10102; // 0x2776 float:1.4156E-41 double:4.991E-320;
        r2 = new java.lang.Object[r2];	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r6 = 0;
        r2[r6] = r10;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r2[r18] = r31;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r2[r3] = r1;	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        r4.doCommand(r5, r2);	 Catch:{ InstantiationException -> 0x0505, IllegalAccessException -> 0x0501, SecException -> 0x0509 }
        goto L_0x0628;
    L_0x0501:
        r0 = move-exception;
        r1 = r0;
        goto L_0x061b;
    L_0x0505:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0625;
    L_0x0509:
        r0 = move-exception;
        goto L_0x050f;
    L_0x050b:
        r0 = move-exception;
        r11 = r5;
        r39 = r7;
    L_0x050f:
        r10 = r0;
        r13 = new java.io.File;	 Catch:{ all -> 0x0693 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r1.append(r14);	 Catch:{ all -> 0x0693 }
        r2 = java.io.File.separator;	 Catch:{ all -> 0x0693 }
        r1.append(r2);	 Catch:{ all -> 0x0693 }
        r1.append(r11);	 Catch:{ all -> 0x0693 }
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r13.<init>(r1);	 Catch:{ all -> 0x0693 }
        r1 = r10.getErrorCode();	 Catch:{ all -> 0x0693 }
        r2 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        if (r1 != r2) goto L_0x05cb;
    L_0x0531:
        r2 = 100043; // 0x186cb float:1.4019E-40 double:4.9428E-319;
        r3 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r4 = "";
        r5 = r10.toString();	 Catch:{ all -> 0x0693 }
        r1 = r45.length();	 Catch:{ all -> 0x0693 }
        if (r1 != 0) goto L_0x0547;
    L_0x0542:
        r6 = r39;
    L_0x0544:
        r11 = r43;
        goto L_0x055f;
    L_0x0547:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r1.append(r12);	 Catch:{ all -> 0x0693 }
        r6 = "->";
        r1.append(r6);	 Catch:{ all -> 0x0693 }
        r6 = r39;
        r1.append(r6);	 Catch:{ all -> 0x0693 }
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r6 = r1;
        goto L_0x0544;
    L_0x055f:
        r1 = r11.c;	 Catch:{ all -> 0x0693 }
        if (r1 == 0) goto L_0x057b;
    L_0x0563:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r7 = "src:";
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        r7 = r11.c;	 Catch:{ all -> 0x0693 }
        r7 = r7.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r7 = r9.c(r7);	 Catch:{ all -> 0x0693 }
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        goto L_0x0592;
    L_0x057b:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r7 = "zipfile:";
        r1.append(r7);	 Catch:{ all -> 0x0693 }
        r7 = r11.a;	 Catch:{ all -> 0x0693 }
        r7 = r7.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r7 = r9.c(r7);	 Catch:{ all -> 0x0693 }
        r1.append(r7);	 Catch:{ all -> 0x0693 }
    L_0x0592:
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r7 = r1;
        r1 = r13.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r8 = r9.c(r1);	 Catch:{ all -> 0x0693 }
        r1 = r9;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0693 }
        r1 = r11.d;	 Catch:{ all -> 0x05bf }
        if (r1 != 0) goto L_0x05ac;
    L_0x05a7:
        r1 = r9.b;	 Catch:{ all -> 0x05bf }
        r1.a();	 Catch:{ all -> 0x05bf }
    L_0x05ac:
        r1 = r13.exists();	 Catch:{ all -> 0x05bf }
        if (r1 == 0) goto L_0x05b5;
    L_0x05b2:
        r13.delete();	 Catch:{ all -> 0x05bf }
    L_0x05b5:
        r1 = r11.d;	 Catch:{ all -> 0x0693 }
        if (r1 != 0) goto L_0x0616;
    L_0x05b9:
        r1 = r9.b;	 Catch:{ all -> 0x0693 }
        r1.b();	 Catch:{ all -> 0x0693 }
        goto L_0x0616;
    L_0x05bf:
        r0 = move-exception;
        r1 = r0;
        r2 = r11.d;	 Catch:{ all -> 0x0693 }
        if (r2 != 0) goto L_0x05ca;
    L_0x05c5:
        r2 = r9.b;	 Catch:{ all -> 0x0693 }
        r2.b();	 Catch:{ all -> 0x0693 }
    L_0x05ca:
        throw r1;	 Catch:{ all -> 0x0693 }
    L_0x05cb:
        r1 = r11;
        r11 = r43;
        r2 = 100043; // 0x186cb float:1.4019E-40 double:4.9428E-319;
        r3 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r4 = "native exception occurred";
        r5 = r10.toString();	 Catch:{ all -> 0x0693 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r6.<init>();	 Catch:{ all -> 0x0693 }
        r7 = "soName=";
        r6.append(r7);	 Catch:{ all -> 0x0693 }
        r6.append(r1);	 Catch:{ all -> 0x0693 }
        r1 = ", authCode=";
        r6.append(r1);	 Catch:{ all -> 0x0693 }
        r1 = r9.h;	 Catch:{ all -> 0x0693 }
        r6.append(r1);	 Catch:{ all -> 0x0693 }
        r1 = ", errorCode=";
        r6.append(r1);	 Catch:{ all -> 0x0693 }
        r1 = r10.getErrorCode();	 Catch:{ all -> 0x0693 }
        r6.append(r1);	 Catch:{ all -> 0x0693 }
        r6 = r6.toString();	 Catch:{ all -> 0x0693 }
        r1 = r11.a;	 Catch:{ all -> 0x0693 }
        r1 = r1.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r7 = r9.c(r1);	 Catch:{ all -> 0x0693 }
        r1 = r13.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r8 = r9.c(r1);	 Catch:{ all -> 0x0693 }
        r1 = r9;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0693 }
    L_0x0616:
        throw r10;	 Catch:{ all -> 0x0693 }
    L_0x0617:
        r0 = move-exception;
        r1 = r0;
        r20 = r19;
    L_0x061b:
        r2 = "";
    L_0x061d:
        com.alibaba.wireless.security.framework.utils.a.a(r2, r1);	 Catch:{ all -> 0x0693 }
        goto L_0x0628;
    L_0x0621:
        r0 = move-exception;
        r1 = r0;
        r20 = r19;
    L_0x0625:
        r2 = "";
        goto L_0x061d;
    L_0x0628:
        com.alibaba.wireless.security.framework.SGPluginExtras.slot = r16;
        return r20;
    L_0x062b:
        r0 = move-exception;
        r23 = r6;
        r6 = r7;
        r2 = 100043; // 0x186cb float:1.4019E-40 double:4.9428E-319;
        r3 = 199; // 0xc7 float:2.79E-43 double:9.83E-322;
        r4 = "isMeetReverseDependencies failed";
        r1 = r45.length();	 Catch:{ all -> 0x0693 }
        if (r1 != 0) goto L_0x063d;
    L_0x063c:
        goto L_0x0652;
    L_0x063d:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r1.append(r12);	 Catch:{ all -> 0x0693 }
        r5 = "->";
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        r1.append(r6);	 Catch:{ all -> 0x0693 }
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r6 = r1;
    L_0x0652:
        r1 = r11.c;	 Catch:{ all -> 0x0693 }
        if (r1 == 0) goto L_0x066e;
    L_0x0656:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r5 = "src:";
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        r5 = r11.c;	 Catch:{ all -> 0x0693 }
        r5 = r5.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r5 = r9.c(r5);	 Catch:{ all -> 0x0693 }
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        goto L_0x0685;
    L_0x066e:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0693 }
        r1.<init>();	 Catch:{ all -> 0x0693 }
        r5 = "zipfile:";
        r1.append(r5);	 Catch:{ all -> 0x0693 }
        r5 = r11.a;	 Catch:{ all -> 0x0693 }
        r5 = r5.getAbsolutePath();	 Catch:{ all -> 0x0693 }
        r5 = r9.c(r5);	 Catch:{ all -> 0x0693 }
        r1.append(r5);	 Catch:{ all -> 0x0693 }
    L_0x0685:
        r1 = r1.toString();	 Catch:{ all -> 0x0693 }
        r7 = r1;
        r8 = "";
        r1 = r9;
        r5 = r23;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0693 }
        throw r0;	 Catch:{ all -> 0x0693 }
    L_0x0693:
        r0 = move-exception;
        r1 = r0;
        com.alibaba.wireless.security.framework.SGPluginExtras.slot = r16;
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.a(java.lang.String, com.alibaba.wireless.security.framework.d$a, android.content.Context, java.lang.String):com.alibaba.wireless.security.framework.c");
    }

    private File a(Context context) throws SecException {
        if (context == null) {
            a(100038, SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT, "", "", "", "", "");
            throw new SecException(SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT);
        }
        String str = null;
        if (context != null) {
            StringBuilder stringBuilder;
            try {
                String str2 = context.getApplicationInfo().sourceDir;
                if (str2 != null) {
                    File file = new File(str2);
                    if (file.exists()) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(file.lastModified() / 1000);
                        stringBuilder.append("");
                        str = stringBuilder.toString();
                    }
                }
            } catch (Exception e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(e);
                a(100038, SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED, "", stringBuilder.toString(), "", "", "");
                throw new SecException(e, (int) SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED);
            }
        }
        if (str == null) {
            throw new SecException(SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED);
        }
        this.l = context.getDir("SGLib", 0);
        if (this.l == null || !this.l.exists()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(this.l);
            a(100038, 109, "", stringBuilder2.toString(), "", "", "");
            throw new SecException(109);
        }
        String absolutePath = this.l.getAbsolutePath();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("app_");
        stringBuilder3.append(str);
        File file2 = new File(absolutePath, stringBuilder3.toString());
        if (!file2.exists()) {
            file2.mkdirs();
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        if (p && file2.exists()) {
            p = false;
            File file3 = this.l;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("app_");
            stringBuilder4.append(str);
            a(file3, stringBuilder4.toString());
        }
        if (file2.exists()) {
            return file2;
        }
        a(100038, 114, "", "", "", "", "");
        throw new SecException(114);
    }

    private File a(Context context, b bVar) {
        File file = null;
        if (!(f.a(context) || bVar == null || bVar.b() == 0 || bVar.c() == null || bVar.c().length() <= 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.k.getAbsolutePath());
            stringBuilder.append(File.separator);
            stringBuilder.append("libs");
            stringBuilder.append(File.separator);
            stringBuilder.append(bVar.b());
            stringBuilder.append(File.separator);
            stringBuilder.append(bVar.c());
            File file2 = new File(stringBuilder.toString());
            if (!file2.exists()) {
                return null;
            }
            file = file2;
        }
        return file;
    }

    private File a(String str) {
        File file = null;
        if (this.g != null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sg");
        stringBuilder.append(str);
        str = f.a(d.class.getClassLoader(), stringBuilder.toString());
        if (str != null && str.length() > 0) {
            file = new File(str);
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082 A:{Catch:{ all -> 0x0098 }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d A:{Catch:{ all -> 0x0098 }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0094 A:{SYNTHETIC, Splitter:B:35:0x0094} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009b A:{SYNTHETIC, Splitter:B:41:0x009b} */
    private java.io.File a(java.lang.String r13, java.io.File r14) {
        /*
        r12 = this;
        r0 = 0;
        r1 = r12.c;	 Catch:{ Exception -> 0x000a }
        r1 = r1.getApplicationInfo();	 Catch:{ Exception -> 0x000a }
        r1 = r1.sourceDir;	 Catch:{ Exception -> 0x000a }
        goto L_0x000b;
    L_0x000a:
        r1 = r0;
    L_0x000b:
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        return r0;
    L_0x000e:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "libsg";
        r2.append(r3);
        r2.append(r13);
        r3 = ".so";
        r2.append(r3);
        r2 = r2.toString();
        r3 = "Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed";
        com.alibaba.wireless.security.framework.utils.a.b(r3);	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r3 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r3.<init>(r1);	 Catch:{ IOException -> 0x0070, all -> 0x006d }
        r4 = n;	 Catch:{ IOException -> 0x006b }
        r5 = r4.length;	 Catch:{ IOException -> 0x006b }
        r6 = 0;
    L_0x0032:
        if (r6 >= r5) goto L_0x0064;
    L_0x0034:
        r7 = r4[r6];	 Catch:{ IOException -> 0x006b }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x006b }
        r8.<init>();	 Catch:{ IOException -> 0x006b }
        r9 = "lib";
        r8.append(r9);	 Catch:{ IOException -> 0x006b }
        r9 = java.io.File.separator;	 Catch:{ IOException -> 0x006b }
        r8.append(r9);	 Catch:{ IOException -> 0x006b }
        r8.append(r7);	 Catch:{ IOException -> 0x006b }
        r9 = java.io.File.separator;	 Catch:{ IOException -> 0x006b }
        r8.append(r9);	 Catch:{ IOException -> 0x006b }
        r8.append(r2);	 Catch:{ IOException -> 0x006b }
        r8 = r8.toString();	 Catch:{ IOException -> 0x006b }
        r9 = r3.getEntry(r8);	 Catch:{ IOException -> 0x006b }
        if (r9 == 0) goto L_0x0061;
    L_0x005a:
        o = r7;	 Catch:{ IOException -> 0x006b }
        r14 = r12.a(r13, r14, r3, r8);	 Catch:{ IOException -> 0x006b }
        goto L_0x0065;
    L_0x0061:
        r6 = r6 + 1;
        goto L_0x0032;
    L_0x0064:
        r14 = r0;
    L_0x0065:
        if (r3 == 0) goto L_0x006a;
    L_0x0067:
        r3.close();	 Catch:{ Exception -> 0x006a }
    L_0x006a:
        return r14;
    L_0x006b:
        r14 = move-exception;
        goto L_0x0072;
    L_0x006d:
        r13 = move-exception;
        r3 = r0;
        goto L_0x0099;
    L_0x0070:
        r14 = move-exception;
        r3 = r0;
    L_0x0072:
        r2 = "getPluginFile throws exception";
        com.alibaba.wireless.security.framework.utils.a.a(r2, r14);	 Catch:{ all -> 0x0098 }
        r5 = 100047; // 0x186cf float:1.40196E-40 double:4.943E-319;
        r6 = 3;
        if (r14 == 0) goto L_0x0082;
    L_0x007d:
        r14 = r14.toString();	 Catch:{ all -> 0x0098 }
        goto L_0x0084;
    L_0x0082:
        r14 = "";
    L_0x0084:
        r7 = r14;
        r9 = r12.c(r1);	 Catch:{ all -> 0x0098 }
        r10 = "";
        r11 = "";
        r4 = r12;
        r8 = r13;
        r4.a(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x0098 }
        if (r3 == 0) goto L_0x0097;
    L_0x0094:
        r3.close();	 Catch:{ Exception -> 0x0097 }
    L_0x0097:
        return r0;
    L_0x0098:
        r13 = move-exception;
    L_0x0099:
        if (r3 == 0) goto L_0x009e;
    L_0x009b:
        r3.close();	 Catch:{ Exception -> 0x009e }
    L_0x009e:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.a(java.lang.String, java.io.File):java.io.File");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0031 A:{Catch:{ all -> 0x0048 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c A:{Catch:{ all -> 0x0048 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043 A:{SYNTHETIC, Splitter:B:24:0x0043} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004b A:{SYNTHETIC, Splitter:B:32:0x004b} */
    private java.io.File a(java.lang.String r11, java.io.File r12, java.lang.String r13, java.lang.String r14) {
        /*
        r10 = this;
        r0 = 0;
        if (r13 == 0) goto L_0x004f;
    L_0x0003:
        if (r14 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r1 = "Plugin not existed in the application library path, maybe installed in x86 phone, or the armeabi-v7a existed";
        com.alibaba.wireless.security.framework.utils.a.b(r1);	 Catch:{ IOException -> 0x001f, all -> 0x001c }
        r1 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x001f, all -> 0x001c }
        r1.<init>(r13);	 Catch:{ IOException -> 0x001f, all -> 0x001c }
        r12 = r10.a(r11, r12, r1, r14);	 Catch:{ IOException -> 0x001a }
        if (r1 == 0) goto L_0x0047;
    L_0x0016:
        r1.close();	 Catch:{ Exception -> 0x0047 }
        return r12;
    L_0x001a:
        r12 = move-exception;
        goto L_0x0021;
    L_0x001c:
        r11 = move-exception;
        r1 = r0;
        goto L_0x0049;
    L_0x001f:
        r12 = move-exception;
        r1 = r0;
    L_0x0021:
        r14 = "getPluginFile throws exception";
        com.alibaba.wireless.security.framework.utils.a.a(r14, r12);	 Catch:{ all -> 0x0048 }
        r3 = 100047; // 0x186cf float:1.40196E-40 double:4.943E-319;
        r4 = 3;
        if (r12 == 0) goto L_0x0031;
    L_0x002c:
        r12 = r12.toString();	 Catch:{ all -> 0x0048 }
        goto L_0x0033;
    L_0x0031:
        r12 = "";
    L_0x0033:
        r5 = r12;
        r7 = r10.c(r13);	 Catch:{ all -> 0x0048 }
        r8 = "";
        r9 = "";
        r2 = r10;
        r6 = r11;
        r2.a(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x0048 }
        if (r1 == 0) goto L_0x0046;
    L_0x0043:
        r1.close();	 Catch:{ Exception -> 0x0046 }
    L_0x0046:
        r12 = r0;
    L_0x0047:
        return r12;
    L_0x0048:
        r11 = move-exception;
    L_0x0049:
        if (r1 == 0) goto L_0x004e;
    L_0x004b:
        r1.close();	 Catch:{ Exception -> 0x004e }
    L_0x004e:
        throw r11;
    L_0x004f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.a(java.lang.String, java.io.File, java.lang.String, java.lang.String):java.io.File");
    }

    private File a(String str, File file, ZipFile zipFile, String str2) throws IOException {
        if (!(zipFile == null || str2 == null)) {
            ZipEntry entry = zipFile.getEntry(str2);
            if (entry != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Plugin existed  in ");
                stringBuilder.append(entry.getName());
                com.alibaba.wireless.security.framework.utils.a.b(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("libsg");
                stringBuilder.append(str);
                stringBuilder.append("_inner");
                stringBuilder.append(entry.getTime());
                stringBuilder.append(".zip");
                File file2 = new File(file, stringBuilder.toString());
                if ((file2.exists() && file2.length() == entry.getSize()) || f.a(zipFile, entry, file2)) {
                    com.alibaba.wireless.security.framework.utils.a.b("Extract success");
                    return file2;
                }
                com.alibaba.wireless.security.framework.utils.a.b("Extract failed!!");
            }
        }
        return null;
    }

    private Class<?> a(ClassLoader classLoader, String str) {
        Class<?> cls;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            cls = Class.forName(str, true, classLoader);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(th);
            a(100042, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "Class.forName failed", stringBuilder.toString(), str, classLoader.toString(), "");
            cls = null;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("    loadClassFromClassLoader( ");
        stringBuilder2.append(str);
        stringBuilder2.append(" ) used time: ");
        stringBuilder2.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuilder2.append(" ms");
        com.alibaba.wireless.security.framework.utils.a.b(stringBuilder2.toString());
        return cls;
    }

    private String a(Class<?> cls) {
        InterfacePluginInfo interfacePluginInfo = (InterfacePluginInfo) cls.getAnnotation(InterfacePluginInfo.class);
        return interfacePluginInfo == null ? null : interfacePluginInfo.pluginName();
    }

    private void a() throws SecException {
        this.k = a(this.c);
        if (this.k != null) {
            Context context = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.k);
            stringBuilder.append(File.separator);
            stringBuilder.append("lock.lock");
            this.b = new c(context, stringBuilder.toString());
            this.i = b();
            this.m = a(this.c, this.i);
        }
    }

    private void a(int i, int i2, String str, String str2, String str3, String str4, String str5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(i);
        UserTrackMethodJniBridge.addUtRecord(stringBuilder.toString(), i2, 0, com.alibaba.wireless.security.open.initialize.c.a(), 0, str, str2, str3, str4, str5);
    }

    private void a(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String file2 : list) {
                    a(new File(file, file2));
                }
            }
        }
        file.delete();
    }

    private void a(final File file, final String str) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    File[] listFiles;
                    int length;
                    int i = 0;
                    if (file != null && file.isDirectory()) {
                        listFiles = file.listFiles();
                        if (listFiles != null && listFiles.length > 0) {
                            for (File file : listFiles) {
                                if (file.isDirectory() && file.getName().startsWith("app_") && !file.getName().equals(str)) {
                                    d.this.a(file);
                                } else if (file.getName().startsWith("libsg")) {
                                    file.delete();
                                }
                            }
                        }
                    }
                    if (d.this.c != null) {
                        File filesDir = d.this.c.getFilesDir();
                        if (filesDir != null && filesDir.isDirectory()) {
                            listFiles = filesDir.listFiles();
                            if (listFiles != null && listFiles.length > 0) {
                                length = listFiles.length;
                                while (i < length) {
                                    File file2 = listFiles[i];
                                    if (file2.getName().startsWith("libsecuritysdk")) {
                                        file2.delete();
                                    }
                                    i++;
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b9 A:{Catch:{ all -> 0x00fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b4 A:{Catch:{ all -> 0x00fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e3 A:{SYNTHETIC, Splitter:B:54:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ef A:{SYNTHETIC, Splitter:B:59:0x00ef} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0102 A:{SYNTHETIC, Splitter:B:68:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010e A:{SYNTHETIC, Splitter:B:73:0x010e} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b4 A:{Catch:{ all -> 0x00fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b9 A:{Catch:{ all -> 0x00fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e3 A:{SYNTHETIC, Splitter:B:54:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ef A:{SYNTHETIC, Splitter:B:59:0x00ef} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0102 A:{SYNTHETIC, Splitter:B:68:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010e A:{SYNTHETIC, Splitter:B:73:0x010e} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b9 A:{Catch:{ all -> 0x00fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b4 A:{Catch:{ all -> 0x00fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e3 A:{SYNTHETIC, Splitter:B:54:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ef A:{SYNTHETIC, Splitter:B:59:0x00ef} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0102 A:{SYNTHETIC, Splitter:B:68:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010e A:{SYNTHETIC, Splitter:B:73:0x010e} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0102 A:{SYNTHETIC, Splitter:B:68:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010e A:{SYNTHETIC, Splitter:B:73:0x010e} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b4 A:{Catch:{ all -> 0x00fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b9 A:{Catch:{ all -> 0x00fd }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e3 A:{SYNTHETIC, Splitter:B:54:0x00e3} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ef A:{SYNTHETIC, Splitter:B:59:0x00ef} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e A:{Splitter:B:1:0x0027, ExcHandler: all (r0_7 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:41:0x009e, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:42:0x009f, code skipped:
            r1 = r0;
            r13 = null;
     */
    /* JADX WARNING: Missing block: B:43:0x00a3, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:44:0x00a4, code skipped:
            r4 = r19;
     */
    /* JADX WARNING: Missing block: B:50:0x00b4, code skipped:
            r2 = r2.toString();
     */
    /* JADX WARNING: Missing block: B:51:0x00b9, code skipped:
            r2 = "";
     */
    /* JADX WARNING: Missing block: B:55:?, code skipped:
            r12.close();
     */
    /* JADX WARNING: Missing block: B:56:0x00e7, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:57:0x00e8, code skipped:
            com.alibaba.wireless.security.framework.utils.a.a("", r0);
     */
    /* JADX WARNING: Missing block: B:60:?, code skipped:
            r13.close();
     */
    /* JADX WARNING: Missing block: B:61:0x00f3, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:62:0x00f4, code skipped:
            com.alibaba.wireless.security.framework.utils.a.a("", r0);
     */
    /* JADX WARNING: Missing block: B:69:?, code skipped:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:70:0x0106, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:71:0x0107, code skipped:
            com.alibaba.wireless.security.framework.utils.a.a("", r0);
     */
    /* JADX WARNING: Missing block: B:74:?, code skipped:
            r13.close();
     */
    /* JADX WARNING: Missing block: B:75:0x0112, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:76:0x0113, code skipped:
            com.alibaba.wireless.security.framework.utils.a.a("", r0);
     */
    private boolean a(java.io.File r19, java.io.File r20) {
        /*
        r18 = this;
        r9 = r18;
        r1 = r20;
        r10 = new java.io.File;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r20.getAbsolutePath();
        r2.append(r3);
        r3 = ".tmp.";
        r2.append(r3);
        r3 = android.os.Process.myPid();
        r2.append(r3);
        r2 = r2.toString();
        r10.<init>(r2);
        r11 = 0;
        r2 = 0;
        r3 = r10.exists();	 Catch:{ Exception -> 0x00a3, all -> 0x009e }
        if (r3 == 0) goto L_0x0030;
    L_0x002d:
        r10.delete();	 Catch:{ Exception -> 0x00a3, all -> 0x009e }
    L_0x0030:
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00a3, all -> 0x009e }
        r4 = r19;
        r3.<init>(r4);	 Catch:{ Exception -> 0x009c, all -> 0x009e }
        r3 = r3.getChannel();	 Catch:{ Exception -> 0x009c, all -> 0x009e }
        r5 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        r5.<init>(r10);	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        r5 = r5.getChannel();	 Catch:{ Exception -> 0x0098, all -> 0x0092 }
        r14 = 0;
        r16 = r3.size();	 Catch:{ Exception -> 0x008d, all -> 0x0087 }
        r12 = r5;
        r13 = r3;
        r12.transferFrom(r13, r14, r16);	 Catch:{ Exception -> 0x008d, all -> 0x0087 }
        r3.close();	 Catch:{ Exception -> 0x008d, all -> 0x0087 }
        r5.close();	 Catch:{ Exception -> 0x0083, all -> 0x0080 }
        r5 = r10.length();	 Catch:{ Exception -> 0x009c, all -> 0x009e }
        r7 = r19.length();	 Catch:{ Exception -> 0x009c, all -> 0x009e }
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r3 != 0) goto L_0x00f9;
    L_0x0061:
        r3 = r20.exists();	 Catch:{ Exception -> 0x009c, all -> 0x009e }
        if (r3 == 0) goto L_0x0079;
    L_0x0067:
        r5 = r20.length();	 Catch:{ Exception -> 0x009c, all -> 0x009e }
        r7 = r19.length();	 Catch:{ Exception -> 0x009c, all -> 0x009e }
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r3 != 0) goto L_0x0076;
    L_0x0073:
        r11 = 1;
        goto L_0x00f9;
    L_0x0076:
        r20.delete();	 Catch:{ Exception -> 0x009c, all -> 0x009e }
    L_0x0079:
        r3 = r10.renameTo(r1);	 Catch:{ Exception -> 0x009c, all -> 0x009e }
        r11 = r3;
        goto L_0x00f9;
    L_0x0080:
        r0 = move-exception;
        r1 = r0;
        goto L_0x008a;
    L_0x0083:
        r0 = move-exception;
        r12 = r2;
        r13 = r5;
        goto L_0x00a8;
    L_0x0087:
        r0 = move-exception;
        r1 = r0;
        r2 = r3;
    L_0x008a:
        r13 = r5;
        goto L_0x0100;
    L_0x008d:
        r0 = move-exception;
        r2 = r0;
        r12 = r3;
        r13 = r5;
        goto L_0x00a9;
    L_0x0092:
        r0 = move-exception;
        r1 = r0;
        r13 = r2;
        r2 = r3;
        goto L_0x0100;
    L_0x0098:
        r0 = move-exception;
        r13 = r2;
        r12 = r3;
        goto L_0x00a8;
    L_0x009c:
        r0 = move-exception;
        goto L_0x00a6;
    L_0x009e:
        r0 = move-exception;
        r1 = r0;
        r13 = r2;
        goto L_0x0100;
    L_0x00a3:
        r0 = move-exception;
        r4 = r19;
    L_0x00a6:
        r12 = r2;
        r13 = r12;
    L_0x00a8:
        r2 = r0;
    L_0x00a9:
        r3 = "";
        com.alibaba.wireless.security.framework.utils.a.a(r3, r2);	 Catch:{ all -> 0x00fd }
        r3 = 100047; // 0x186cf float:1.40196E-40 double:4.943E-319;
        r5 = 2;
        if (r2 == 0) goto L_0x00b9;
    L_0x00b4:
        r2 = r2.toString();	 Catch:{ all -> 0x00fd }
        goto L_0x00bb;
    L_0x00b9:
        r2 = "";
    L_0x00bb:
        r6 = r2;
        r2 = r19.getAbsolutePath();	 Catch:{ all -> 0x00fd }
        r7 = r9.c(r2);	 Catch:{ all -> 0x00fd }
        r1 = r20.getAbsolutePath();	 Catch:{ all -> 0x00fd }
        r8 = r9.c(r1);	 Catch:{ all -> 0x00fd }
        r1 = r10.getAbsolutePath();	 Catch:{ all -> 0x00fd }
        r14 = r9.c(r1);	 Catch:{ all -> 0x00fd }
        r15 = "";
        r1 = r9;
        r2 = r3;
        r3 = r5;
        r4 = r6;
        r5 = r7;
        r6 = r8;
        r7 = r14;
        r8 = r15;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x00fd }
        if (r12 == 0) goto L_0x00ed;
    L_0x00e3:
        r12.close();	 Catch:{ Exception -> 0x00e7 }
        goto L_0x00ed;
    L_0x00e7:
        r0 = move-exception;
        r1 = "";
        com.alibaba.wireless.security.framework.utils.a.a(r1, r0);
    L_0x00ed:
        if (r13 == 0) goto L_0x00f9;
    L_0x00ef:
        r13.close();	 Catch:{ Exception -> 0x00f3 }
        goto L_0x00f9;
    L_0x00f3:
        r0 = move-exception;
        r1 = "";
        com.alibaba.wireless.security.framework.utils.a.a(r1, r0);
    L_0x00f9:
        r10.delete();
        return r11;
    L_0x00fd:
        r0 = move-exception;
        r1 = r0;
        r2 = r12;
    L_0x0100:
        if (r2 == 0) goto L_0x010c;
    L_0x0102:
        r2.close();	 Catch:{ Exception -> 0x0106 }
        goto L_0x010c;
    L_0x0106:
        r0 = move-exception;
        r2 = "";
        com.alibaba.wireless.security.framework.utils.a.a(r2, r0);
    L_0x010c:
        if (r13 == 0) goto L_0x0118;
    L_0x010e:
        r13.close();	 Catch:{ Exception -> 0x0112 }
        goto L_0x0118;
    L_0x0112:
        r0 = move-exception;
        r2 = "";
        com.alibaba.wireless.security.framework.utils.a.a(r2, r0);
    L_0x0118:
        r10.delete();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.a(java.io.File, java.io.File):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x00d3 A:{SYNTHETIC, Splitter:B:83:0x00d3} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0094 A:{Catch:{ all -> 0x0082, all -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x008f A:{SYNTHETIC, Splitter:B:64:0x008f} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00a9 A:{Catch:{ all -> 0x0082, all -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00a0 A:{Catch:{ all -> 0x0082, all -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00b7 A:{Catch:{ all -> 0x0082, all -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00ae A:{Catch:{ all -> 0x0082, all -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00cb A:{SYNTHETIC, Splitter:B:77:0x00cb} */
    /* JADX WARNING: Missing block: B:36:0x0050, code skipped:
            return r4;
     */
    /* JADX WARNING: Missing block: B:44:0x005f, code skipped:
            return r4;
     */
    /* JADX WARNING: Missing block: B:52:0x0076, code skipped:
            return r4;
     */
    private synchronized boolean a(java.lang.String r14, java.lang.String r15, java.io.File r16, java.lang.String r17, boolean r18) {
        /*
        r13 = this;
        r9 = r13;
        r2 = r17;
        monitor-enter(r13);
        r3 = r9.c;	 Catch:{ all -> 0x00d9 }
        r3 = com.alibaba.wireless.security.framework.utils.f.a(r3);	 Catch:{ all -> 0x00d9 }
        r4 = 1;
        if (r3 == 0) goto L_0x0015;
    L_0x000d:
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00d9 }
        r5 = 19;
        if (r3 <= r5) goto L_0x0015;
    L_0x0013:
        monitor-exit(r13);
        return r4;
    L_0x0015:
        r3 = r9.g;	 Catch:{ all -> 0x00d9 }
        if (r3 == 0) goto L_0x001b;
    L_0x0019:
        monitor-exit(r13);
        return r4;
    L_0x001b:
        if (r16 == 0) goto L_0x0033;
    L_0x001d:
        r3 = new java.io.File;	 Catch:{ all -> 0x00d9 }
        r5 = r16.getParent();	 Catch:{ all -> 0x00d9 }
        r3.<init>(r5, r2);	 Catch:{ all -> 0x00d9 }
        r3 = r3.exists();	 Catch:{ all -> 0x00d9 }
        if (r3 == 0) goto L_0x002e;
    L_0x002c:
        monitor-exit(r13);
        return r4;
    L_0x002e:
        r3 = r16.getAbsolutePath();	 Catch:{ all -> 0x00d9 }
        goto L_0x0034;
    L_0x0033:
        r3 = r14;
    L_0x0034:
        if (r18 != 0) goto L_0x003b;
    L_0x0036:
        r5 = r9.b;	 Catch:{ all -> 0x00d9 }
        r5.a();	 Catch:{ all -> 0x00d9 }
    L_0x003b:
        r5 = 0;
        r6 = new java.io.File;	 Catch:{ Exception -> 0x0085 }
        r7 = r15;
        r6.<init>(r7, r2);	 Catch:{ Exception -> 0x0085 }
        r5 = r6.exists();	 Catch:{ Exception -> 0x007f }
        if (r5 == 0) goto L_0x0051;
    L_0x0048:
        if (r18 != 0) goto L_0x004f;
    L_0x004a:
        r1 = r9.b;	 Catch:{ all -> 0x00d9 }
        r1.b();	 Catch:{ all -> 0x00d9 }
    L_0x004f:
        monitor-exit(r13);
        return r4;
    L_0x0051:
        r5 = com.alibaba.wireless.security.framework.utils.f.a(r3, r2, r6);	 Catch:{ Exception -> 0x007f }
        if (r5 == 0) goto L_0x0060;
    L_0x0057:
        if (r18 != 0) goto L_0x005e;
    L_0x0059:
        r1 = r9.b;	 Catch:{ all -> 0x00d9 }
        r1.b();	 Catch:{ all -> 0x00d9 }
    L_0x005e:
        monitor-exit(r13);
        return r4;
    L_0x0060:
        r5 = r9.c;	 Catch:{ Exception -> 0x007f }
        r5 = r5.getApplicationInfo();	 Catch:{ Exception -> 0x007f }
        r5 = r5.sourceDir;	 Catch:{ Exception -> 0x007f }
        r2 = com.alibaba.wireless.security.framework.utils.f.a(r5, r2, r6);	 Catch:{ Exception -> 0x007f }
        if (r2 == 0) goto L_0x0077;
    L_0x006e:
        if (r18 != 0) goto L_0x0075;
    L_0x0070:
        r1 = r9.b;	 Catch:{ all -> 0x00d9 }
        r1.b();	 Catch:{ all -> 0x00d9 }
    L_0x0075:
        monitor-exit(r13);
        return r4;
    L_0x0077:
        if (r18 != 0) goto L_0x00ce;
    L_0x0079:
        r1 = r9.b;	 Catch:{ all -> 0x00d9 }
    L_0x007b:
        r1.b();	 Catch:{ all -> 0x00d9 }
        goto L_0x00ce;
    L_0x007f:
        r0 = move-exception;
        r10 = r0;
        goto L_0x0088;
    L_0x0082:
        r0 = move-exception;
        r1 = r0;
        goto L_0x00d1;
    L_0x0085:
        r0 = move-exception;
        r10 = r0;
        r6 = r5;
    L_0x0088:
        r2 = 100039; // 0x186c7 float:1.40184E-40 double:4.9426E-319;
        r4 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        if (r10 == 0) goto L_0x0094;
    L_0x008f:
        r5 = r10.toString();	 Catch:{ all -> 0x0082 }
        goto L_0x0096;
    L_0x0094:
        r5 = "";
    L_0x0096:
        r7 = r9.c();	 Catch:{ all -> 0x0082 }
        r8 = r9.c(r3);	 Catch:{ all -> 0x0082 }
        if (r6 == 0) goto L_0x00a9;
    L_0x00a0:
        r3 = r6.getAbsolutePath();	 Catch:{ all -> 0x0082 }
        r3 = r9.c(r3);	 Catch:{ all -> 0x0082 }
        goto L_0x00ab;
    L_0x00a9:
        r3 = "";
    L_0x00ab:
        r11 = r3;
        if (r16 == 0) goto L_0x00b7;
    L_0x00ae:
        r1 = r16.getAbsolutePath();	 Catch:{ all -> 0x0082 }
        r1 = r9.c(r1);	 Catch:{ all -> 0x0082 }
        goto L_0x00b9;
    L_0x00b7:
        r1 = "";
    L_0x00b9:
        r12 = r1;
        r1 = r9;
        r3 = r4;
        r4 = r5;
        r5 = r7;
        r6 = r8;
        r7 = r11;
        r8 = r12;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0082 }
        r1 = "";
        com.alibaba.wireless.security.framework.utils.a.a(r1, r10);	 Catch:{ all -> 0x0082 }
        if (r18 != 0) goto L_0x00ce;
    L_0x00cb:
        r1 = r9.b;	 Catch:{ all -> 0x00d9 }
        goto L_0x007b;
    L_0x00ce:
        r1 = 0;
        monitor-exit(r13);
        return r1;
    L_0x00d1:
        if (r18 != 0) goto L_0x00d8;
    L_0x00d3:
        r2 = r9.b;	 Catch:{ all -> 0x00d9 }
        r2.b();	 Catch:{ all -> 0x00d9 }
    L_0x00d8:
        throw r1;	 Catch:{ all -> 0x00d9 }
    L_0x00d9:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r13);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.a(java.lang.String, java.lang.String, java.io.File, java.lang.String, boolean):boolean");
    }

    private boolean a(String str, String str2, boolean z) throws SecException {
        String str3 = str2;
        boolean z2 = z;
        if (str.trim().length() == 0) {
            return true;
        }
        String str4 = str;
        String[] split = str4.split(";");
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.length() != 0) {
                String[] split2 = trim.split(":");
                StringBuilder stringBuilder;
                String stringBuilder2;
                StringBuilder stringBuilder3;
                if (split2.length != 2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("");
                    stringBuilder.append(z2);
                    stringBuilder2 = stringBuilder.toString();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("");
                    stringBuilder3.append(i);
                    String stringBuilder4 = stringBuilder3.toString();
                    a(100040, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "nameVersionPair.length != 2", trim, str3, stringBuilder2, stringBuilder4);
                    throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                }
                int indexOf = str3.indexOf(split2[0]);
                StringBuilder stringBuilder5;
                String stringBuilder6;
                String str5;
                if (indexOf >= 0) {
                    int indexOf2 = str3.indexOf("(", indexOf);
                    indexOf = str3.indexOf(")", indexOf);
                    if (indexOf2 < 0 || indexOf < 0 || indexOf2 > indexOf) {
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("");
                        stringBuilder3.append(indexOf2);
                        str4 = stringBuilder3.toString();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("");
                        stringBuilder3.append(indexOf);
                        trim = stringBuilder3.toString();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("");
                        stringBuilder3.append(i);
                        str3 = stringBuilder3.toString();
                        a(100040, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "indexLeftP < 0 || indexRightP < 0 || indexLeftP > indexRightP", str4, trim, "", str3);
                        throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                    }
                    trim = str3.substring(indexOf2 + 1, indexOf);
                    if (a(trim, split2[1]) < 0) {
                        stringBuilder5 = new StringBuilder();
                        stringBuilder5.append("version ");
                        stringBuilder5.append(trim);
                        stringBuilder5.append(" of ");
                        stringBuilder5.append(split2[0]);
                        stringBuilder5.append(" is not meet the requirement: ");
                        stringBuilder5.append(split2[1]);
                        stringBuilder6 = stringBuilder5.toString();
                        if (str2.length() != 0) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(stringBuilder6);
                            stringBuilder.append(", depended by: ");
                            stringBuilder.append(str3);
                            stringBuilder6 = stringBuilder.toString();
                        }
                        str3 = stringBuilder6;
                        if (!z2) {
                            str5 = split2[0];
                            stringBuilder2 = split2[1];
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("");
                            stringBuilder3.append(i);
                            a(100040, 113, "versionCompare(parentPluginVersion, nameVersionPair[1]) < 0", trim, str5, stringBuilder2, stringBuilder3.toString());
                        }
                        throw new SecException(str3, 113);
                    }
                } else {
                    ISGPluginInfo iSGPluginInfo = (ISGPluginInfo) this.d.get(split2[0]);
                    if (iSGPluginInfo == null) {
                        Object obj = null;
                        try {
                            iSGPluginInfo = d(split2[0], str3, z2 ^ 1);
                        } catch (Throwable th) {
                            obj = th;
                        }
                        if (iSGPluginInfo == null) {
                            if (!z2) {
                                if (obj instanceof SecException) {
                                    throw ((SecException) obj);
                                }
                                stringBuilder3 = new StringBuilder();
                                stringBuilder3.append("");
                                stringBuilder3.append(obj);
                                trim = stringBuilder3.toString();
                                stringBuilder3 = new StringBuilder();
                                stringBuilder3.append("");
                                stringBuilder3.append(i);
                                stringBuilder2 = stringBuilder3.toString();
                                a(100040, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "throwable in loadPluginInner", trim, str4, str3, stringBuilder2);
                                throw new SecException(str3, (int) SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                            }
                        }
                    }
                    if (a(iSGPluginInfo.getVersion(), split2[1]) < 0) {
                        stringBuilder5 = new StringBuilder();
                        stringBuilder5.append("version ");
                        stringBuilder5.append(iSGPluginInfo.getVersion());
                        stringBuilder5.append(" of ");
                        stringBuilder5.append(split2[0]);
                        stringBuilder5.append(" is not meet the requirement: ");
                        stringBuilder5.append(split2[1]);
                        stringBuilder6 = stringBuilder5.toString();
                        if (str2.length() != 0) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(stringBuilder6);
                            stringBuilder.append(", depended by: ");
                            stringBuilder.append(str3);
                            stringBuilder6 = stringBuilder.toString();
                        }
                        str3 = stringBuilder6;
                        if (!z2) {
                            trim = iSGPluginInfo.getVersion();
                            str5 = split2[0];
                            stringBuilder2 = split2[1];
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("");
                            stringBuilder3.append(i);
                            a(100040, 113, "versionCompare(dependPlugin.getVersion(), nameVersionPair[1]) < 0", trim, str5, stringBuilder2, stringBuilder3.toString());
                        }
                        throw new SecException(str3, 113);
                    }
                }
            }
        }
        return true;
    }

    private b b() {
        b a;
        File file = new File(this.k, "update.config");
        File file2 = new File(this.k, "init.config");
        if (this.j) {
            a = b.a(file);
            if (a == null) {
                return b.a(file2);
            }
            try {
                this.b.a();
                file2.delete();
                file.renameTo(file2);
            } catch (Throwable th) {
                this.b.b();
            }
        } else {
            try {
                this.b.a();
                a = b.a(file2);
            } catch (Throwable th2) {
                this.b.b();
            }
        }
        this.b.b();
        return a;
    }

    private DexClassLoader b(String str, String str2, boolean z) {
        StringBuilder stringBuilder;
        if (!z) {
            try {
                this.b.a();
            } catch (Throwable th) {
                if (!z) {
                    this.b.b();
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.c.getApplicationInfo().nativeLibraryDir);
        stringBuilder2.append(File.pathSeparator);
        stringBuilder2.append(str2);
        String stringBuilder3 = stringBuilder2.toString();
        if (this.g != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder3);
            stringBuilder.append(File.pathSeparator);
            stringBuilder.append(this.g);
            stringBuilder3 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("add path to native classloader ");
            stringBuilder.append(stringBuilder3);
            com.alibaba.wireless.security.framework.utils.a.b(stringBuilder.toString());
        }
        if (o != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(stringBuilder3);
            stringBuilder.append(File.pathSeparator);
            stringBuilder.append(this.c.getApplicationInfo().sourceDir);
            stringBuilder.append("!/lib/");
            stringBuilder.append(o);
            stringBuilder3 = stringBuilder.toString();
        }
        DexClassLoader dexClassLoader = new DexClassLoader(str, str2, stringBuilder3, d.class.getClassLoader());
        if (!z) {
            this.b.b();
        }
        return dexClassLoader;
    }

    private File b(String str) {
        String str2 = this.g;
        if (str2 == null) {
            try {
                str2 = this.c.getApplicationInfo().nativeLibraryDir;
            } catch (Exception unused) {
            }
        }
        if (str2 != null && str2.length() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(File.separator);
            stringBuilder.append("libsg");
            stringBuilder.append(str);
            stringBuilder.append(".so");
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    private boolean b(File file) {
        try {
            if (!(file.getParentFile().getCanonicalPath().equals(file.getCanonicalFile().getParentFile().getCanonicalPath()) && file.getName().equals(file.getCanonicalFile().getName()))) {
                return true;
            }
        } catch (Exception e) {
            com.alibaba.wireless.security.framework.utils.a.a("", e);
            a(100047, 0, e != null ? e.toString() : "", file.getAbsolutePath(), "", "", "");
        }
        return false;
    }

    private boolean b(File file, File file2) {
        try {
            Method declaredMethod;
            Object obj = null;
            if (VERSION.SDK_INT >= 21) {
                declaredMethod = Class.forName("android.system.Os").getDeclaredMethod("symlink", new Class[]{String.class, String.class});
            } else {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                declaredField.setAccessible(true);
                obj = declaredField.get(null);
                declaredMethod = obj.getClass().getMethod("symlink", new Class[]{String.class, String.class});
            }
            declaredMethod.invoke(obj, new Object[]{file.getAbsolutePath(), file2.getAbsolutePath()});
            return true;
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("create symbolic link( ");
            stringBuilder.append(file2.getAbsolutePath());
            stringBuilder.append(" -> ");
            stringBuilder.append(file.getAbsolutePath());
            stringBuilder.append(" ) failed");
            com.alibaba.wireless.security.framework.utils.a.a(stringBuilder.toString(), e);
            String exception = e != null ? e.toString() : "";
            String absolutePath = file.getAbsolutePath();
            String absolutePath2 = file2.getAbsolutePath();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(VERSION.SDK_INT);
            a(100047, 1, exception, absolutePath, absolutePath2, stringBuilder2.toString(), "");
            return false;
        }
    }

    private boolean b(String str, String str2) throws SecException {
        for (Entry entry : this.d.entrySet()) {
            String str3 = (String) entry.getKey();
            c cVar = (c) entry.getValue();
            String a = cVar.a("reversedependencies");
            if (a != null) {
                String[] split = a.split(";");
                for (int i = 0; i < split.length; i++) {
                    String trim = split[i].trim();
                    if (trim.length() != 0) {
                        String[] split2 = trim.split(":");
                        StringBuilder stringBuilder;
                        String stringBuilder2;
                        if (split2.length != 2) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append("(");
                            stringBuilder.append(str2);
                            stringBuilder.append(")");
                            stringBuilder2 = stringBuilder.toString();
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(str3);
                            stringBuilder3.append("(");
                            stringBuilder3.append(cVar.getVersion());
                            stringBuilder3.append(")");
                            a(100041, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, "nameVersionPair.length != 2", stringBuilder2, stringBuilder3.toString(), c(cVar.getPluginPath()), a);
                            throw new SecException(SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
                        } else if (split2[0].equalsIgnoreCase(str) && a(str2, split2[1]) < 0) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("plugin ");
                            stringBuilder.append(str);
                            stringBuilder.append("(");
                            stringBuilder.append(str2);
                            stringBuilder.append(") is not meet the reverse dependency of ");
                            stringBuilder.append(str3);
                            stringBuilder.append("(");
                            stringBuilder.append(cVar.getVersion());
                            stringBuilder.append("): ");
                            stringBuilder.append(split2[0]);
                            stringBuilder.append("(");
                            stringBuilder.append(split2[1]);
                            stringBuilder.append(")");
                            str = stringBuilder.toString();
                            stringBuilder2 = d.class.getClassLoader().toString();
                            String c = c(cVar.getPluginPath());
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("");
                            stringBuilder.append(i);
                            a(100041, SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET, str, stringBuilder2, c, a, stringBuilder.toString());
                            throw new SecException(str, (int) SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET);
                        }
                    }
                }
                continue;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054 A:{SYNTHETIC, Splitter:B:18:0x0054} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A:{Catch:{ all -> 0x0060 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0143 A:{Catch:{ all -> 0x0060 }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054 A:{SYNTHETIC, Splitter:B:18:0x0054} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A:{Catch:{ all -> 0x0060 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0143 A:{Catch:{ all -> 0x0060 }} */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015a  */
    private com.alibaba.wireless.security.framework.d.a c(java.lang.String r18, java.lang.String r19, boolean r20) throws com.alibaba.wireless.security.open.SecException {
        /*
        r17 = this;
        r9 = r17;
        r10 = r18;
        r1 = r9.m;
        if (r1 == 0) goto L_0x0037;
    L_0x0008:
        r1 = new java.io.File;
        r2 = r9.m;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "libsg";
        r3.append(r4);
        r3.append(r10);
        r4 = ".so";
        r3.append(r4);
        r3 = r3.toString();
        r1.<init>(r2, r3);
        r2 = r1.exists();
        if (r2 == 0) goto L_0x0037;
    L_0x002b:
        r2 = r9.m;
        r2 = r9.d(r2);
        r3 = r9.m;
        if (r2 == r3) goto L_0x0039;
    L_0x0035:
        r3 = 1;
        goto L_0x003a;
    L_0x0037:
        r1 = 0;
        r2 = 0;
    L_0x0039:
        r3 = 0;
    L_0x003a:
        if (r2 != 0) goto L_0x0049;
    L_0x003c:
        r2 = r9.k;
        r2 = r9.d(r2);
        r3 = r9.k;
        if (r2 == r3) goto L_0x0048;
    L_0x0046:
        r3 = 1;
        goto L_0x0049;
    L_0x0048:
        r3 = 0;
    L_0x0049:
        r15 = r2;
        r14 = r3;
        if (r14 != 0) goto L_0x0052;
    L_0x004d:
        r2 = r9.b;
        r2.a();
    L_0x0052:
        if (r1 != 0) goto L_0x0064;
    L_0x0054:
        r1 = r17.a(r18);	 Catch:{ all -> 0x0060 }
        r2 = r9.c(r1);	 Catch:{ all -> 0x0060 }
        if (r2 != 0) goto L_0x0064;
    L_0x005e:
        r1 = 0;
        goto L_0x0064;
    L_0x0060:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0217;
    L_0x0064:
        if (r1 == 0) goto L_0x0141;
    L_0x0066:
        r8 = r1.getAbsolutePath();	 Catch:{ all -> 0x0060 }
        r2 = r9.c;	 Catch:{ all -> 0x0060 }
        r2 = r2.getPackageName();	 Catch:{ all -> 0x0060 }
        r3 = "com.eg.android.AlipayGphone";
        r2 = r3.equals(r2);	 Catch:{ all -> 0x0060 }
        if (r2 == 0) goto L_0x00e8;
    L_0x0078:
        if (r8 == 0) goto L_0x00e8;
    L_0x007a:
        r2 = "app_plugins_lib";
        r2 = r8.contains(r2);	 Catch:{ all -> 0x0060 }
        if (r2 == 0) goto L_0x00e8;
    L_0x0082:
        r2 = 100088; // 0x186f8 float:1.40253E-40 double:4.945E-319;
        r3 = 1;
        r4 = android.os.Build.FINGERPRINT;	 Catch:{ all -> 0x0060 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0060 }
        r5.<init>();	 Catch:{ all -> 0x0060 }
        r5.append(r8);	 Catch:{ all -> 0x0060 }
        r6 = "(";
        r5.append(r6);	 Catch:{ all -> 0x0060 }
        r6 = r1.getTotalSpace();	 Catch:{ all -> 0x0060 }
        r5.append(r6);	 Catch:{ all -> 0x0060 }
        r1 = ")";
        r5.append(r1);	 Catch:{ all -> 0x0060 }
        r5 = r5.toString();	 Catch:{ all -> 0x0060 }
        r1 = com.alibaba.wireless.security.framework.d.class;
        r1 = r1.getClassLoader();	 Catch:{ all -> 0x0060 }
        r6 = r1.toString();	 Catch:{ all -> 0x0060 }
        r7 = r15.getAbsolutePath();	 Catch:{ all -> 0x0060 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0060 }
        r1.<init>();	 Catch:{ all -> 0x0060 }
        r13 = r9.c;	 Catch:{ all -> 0x0060 }
        r13 = r13.getApplicationInfo();	 Catch:{ all -> 0x0060 }
        r13 = r13.sourceDir;	 Catch:{ all -> 0x0060 }
        r1.append(r13);	 Catch:{ all -> 0x0060 }
        r13 = ",";
        r1.append(r13);	 Catch:{ all -> 0x0060 }
        r13 = new java.io.File;	 Catch:{ all -> 0x0060 }
        r11 = r9.c;	 Catch:{ all -> 0x0060 }
        r11 = r11.getApplicationInfo();	 Catch:{ all -> 0x0060 }
        r11 = r11.sourceDir;	 Catch:{ all -> 0x0060 }
        r13.<init>(r11);	 Catch:{ all -> 0x0060 }
        r12 = r13.lastModified();	 Catch:{ all -> 0x0060 }
        r1.append(r12);	 Catch:{ all -> 0x0060 }
        r11 = r1.toString();	 Catch:{ all -> 0x0060 }
        r1 = r9;
        r12 = r8;
        r8 = r11;
        r1.a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0060 }
        r1 = 0;
        goto L_0x00e9;
    L_0x00e8:
        r12 = r8;
    L_0x00e9:
        if (r1 == 0) goto L_0x0141;
    L_0x00eb:
        if (r12 == 0) goto L_0x0141;
    L_0x00ed:
        r2 = "!/";
        r2 = r12.contains(r2);	 Catch:{ all -> 0x0060 }
        if (r2 == 0) goto L_0x0141;
    L_0x00f5:
        r2 = "!/";
        r3 = 2;
        r2 = r12.split(r2, r3);	 Catch:{ all -> 0x0060 }
        r3 = 0;
        r4 = r2[r3];	 Catch:{ all -> 0x0060 }
        r5 = 1;
        r2 = r2[r5];	 Catch:{ all -> 0x0060 }
        r5 = n;	 Catch:{ all -> 0x0060 }
        r6 = r5.length;	 Catch:{ all -> 0x0060 }
    L_0x0105:
        if (r3 >= r6) goto L_0x0141;
    L_0x0107:
        r7 = r5[r3];	 Catch:{ all -> 0x0060 }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0060 }
        r8.<init>();	 Catch:{ all -> 0x0060 }
        r11 = "lib";
        r8.append(r11);	 Catch:{ all -> 0x0060 }
        r11 = java.io.File.separator;	 Catch:{ all -> 0x0060 }
        r8.append(r11);	 Catch:{ all -> 0x0060 }
        r8.append(r7);	 Catch:{ all -> 0x0060 }
        r11 = java.io.File.separator;	 Catch:{ all -> 0x0060 }
        r8.append(r11);	 Catch:{ all -> 0x0060 }
        r11 = "libsg";
        r8.append(r11);	 Catch:{ all -> 0x0060 }
        r8.append(r10);	 Catch:{ all -> 0x0060 }
        r11 = ".so";
        r8.append(r11);	 Catch:{ all -> 0x0060 }
        r8 = r8.toString();	 Catch:{ all -> 0x0060 }
        r8 = r8.equals(r2);	 Catch:{ all -> 0x0060 }
        if (r8 == 0) goto L_0x013e;
    L_0x0137:
        o = r7;	 Catch:{ all -> 0x0060 }
        r1 = r9.a(r10, r15, r4, r2);	 Catch:{ all -> 0x0060 }
        goto L_0x0141;
    L_0x013e:
        r3 = r3 + 1;
        goto L_0x0105;
    L_0x0141:
        if (r1 != 0) goto L_0x0147;
    L_0x0143:
        r1 = r17.b(r18);	 Catch:{ all -> 0x0060 }
    L_0x0147:
        if (r1 != 0) goto L_0x014f;
    L_0x0149:
        if (r20 == 0) goto L_0x014f;
    L_0x014b:
        r1 = r9.a(r10, r15);	 Catch:{ all -> 0x0060 }
    L_0x014f:
        if (r1 != 0) goto L_0x015a;
    L_0x0151:
        if (r14 != 0) goto L_0x0158;
    L_0x0153:
        r1 = r9.b;
        r1.b();
    L_0x0158:
        r2 = 0;
        return r2;
    L_0x015a:
        r2 = 0;
        r3 = r1.getAbsolutePath();	 Catch:{ all -> 0x0060 }
        r4 = ".zip";
        r3 = r3.endsWith(r4);	 Catch:{ all -> 0x0060 }
        if (r3 == 0) goto L_0x016e;
    L_0x0167:
        r13 = new com.alibaba.wireless.security.framework.d$a;	 Catch:{ all -> 0x0060 }
        r13.<init>(r1, r15, r2, r14);	 Catch:{ all -> 0x0060 }
        goto L_0x020f;
    L_0x016e:
        r3 = com.alibaba.wireless.security.framework.utils.f.a();	 Catch:{ all -> 0x0060 }
        if (r3 == 0) goto L_0x017b;
    L_0x0174:
        r13 = new com.alibaba.wireless.security.framework.d$a;	 Catch:{ all -> 0x0060 }
        r13.<init>(r1, r15, r1, r14);	 Catch:{ all -> 0x0060 }
        goto L_0x020f;
    L_0x017b:
        r3 = new java.io.File;	 Catch:{ all -> 0x0060 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0060 }
        r4.<init>();	 Catch:{ all -> 0x0060 }
        r5 = "libsg";
        r4.append(r5);	 Catch:{ all -> 0x0060 }
        r4.append(r10);	 Catch:{ all -> 0x0060 }
        r5 = "_";
        r4.append(r5);	 Catch:{ all -> 0x0060 }
        r5 = r1.lastModified();	 Catch:{ all -> 0x0060 }
        r4.append(r5);	 Catch:{ all -> 0x0060 }
        r5 = ".zip";
        r4.append(r5);	 Catch:{ all -> 0x0060 }
        r4 = r4.toString();	 Catch:{ all -> 0x0060 }
        r3.<init>(r15, r4);	 Catch:{ all -> 0x0060 }
        r4 = r3.exists();	 Catch:{ all -> 0x0060 }
        if (r4 == 0) goto L_0x01ba;
    L_0x01a8:
        r4 = r9.b(r3);	 Catch:{ all -> 0x0060 }
        if (r4 == 0) goto L_0x01ba;
    L_0x01ae:
        r4 = r9.c(r3, r1);	 Catch:{ all -> 0x0060 }
        if (r4 != 0) goto L_0x01ba;
    L_0x01b4:
        r13 = new com.alibaba.wireless.security.framework.d$a;	 Catch:{ all -> 0x0060 }
        r13.<init>(r3, r15, r1, r14);	 Catch:{ all -> 0x0060 }
        goto L_0x020f;
    L_0x01ba:
        r3.delete();	 Catch:{ all -> 0x0060 }
        r4 = r9.b(r1, r3);	 Catch:{ all -> 0x0060 }
        if (r4 == 0) goto L_0x01c9;
    L_0x01c3:
        r13 = new com.alibaba.wireless.security.framework.d$a;	 Catch:{ all -> 0x0060 }
        r13.<init>(r3, r15, r1, r14);	 Catch:{ all -> 0x0060 }
        goto L_0x020f;
    L_0x01c9:
        r3 = new java.io.File;	 Catch:{ all -> 0x0060 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0060 }
        r4.<init>();	 Catch:{ all -> 0x0060 }
        r5 = "libsg";
        r4.append(r5);	 Catch:{ all -> 0x0060 }
        r4.append(r10);	 Catch:{ all -> 0x0060 }
        r5 = "_cp";
        r4.append(r5);	 Catch:{ all -> 0x0060 }
        r5 = r1.lastModified();	 Catch:{ all -> 0x0060 }
        r4.append(r5);	 Catch:{ all -> 0x0060 }
        r5 = ".zip";
        r4.append(r5);	 Catch:{ all -> 0x0060 }
        r4 = r4.toString();	 Catch:{ all -> 0x0060 }
        r3.<init>(r15, r4);	 Catch:{ all -> 0x0060 }
        r4 = r3.exists();	 Catch:{ all -> 0x0060 }
        if (r4 == 0) goto L_0x0202;
    L_0x01f6:
        r4 = r3.length();	 Catch:{ all -> 0x0060 }
        r6 = r1.length();	 Catch:{ all -> 0x0060 }
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x0208;
    L_0x0202:
        r4 = r9.a(r1, r3);	 Catch:{ all -> 0x0060 }
        if (r4 == 0) goto L_0x020e;
    L_0x0208:
        r13 = new com.alibaba.wireless.security.framework.d$a;	 Catch:{ all -> 0x0060 }
        r13.<init>(r3, r15, r1, r14);	 Catch:{ all -> 0x0060 }
        goto L_0x020f;
    L_0x020e:
        r13 = r2;
    L_0x020f:
        if (r14 != 0) goto L_0x0216;
    L_0x0211:
        r1 = r9.b;
        r1.b();
    L_0x0216:
        return r13;
    L_0x0217:
        if (r14 != 0) goto L_0x021e;
    L_0x0219:
        r2 = r9.b;
        r2.b();
    L_0x021e:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.d.c(java.lang.String, java.lang.String, boolean):com.alibaba.wireless.security.framework.d$a");
    }

    private String c() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = this.k;
        if (file != null && file.exists() && file.isDirectory()) {
            try {
                stringBuilder.append("[");
                File[] listFiles = file.listFiles();
                int i = 0;
                while (listFiles != null && i < listFiles.length) {
                    File file2 = listFiles[i];
                    if (file2.getName().startsWith("libsg") && (file2.getName().endsWith("zip") || file2.getName().endsWith(".so"))) {
                        stringBuilder.append(file2.getName());
                        stringBuilder.append("(");
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(b(file2));
                        stringBuilder2.append(" , ");
                        stringBuilder.append(stringBuilder2.toString());
                        stringBuilder.append(file2.length());
                        stringBuilder.append(") , ");
                    }
                    i++;
                }
                stringBuilder.append("]");
            } catch (Throwable unused) {
            }
        } else {
            stringBuilder.append("not exists!");
        }
        return stringBuilder.toString();
    }

    private String c(String str) {
        String str2 = "";
        if (str == null || str.length() <= 0) {
            return str2;
        }
        File file = new File(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (b(file)) {
            stringBuilder.append("->");
            try {
                stringBuilder.append(file.getCanonicalPath());
            } catch (Exception unused) {
            }
        }
        stringBuilder.append('[');
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("exists:");
        stringBuilder2.append(file.exists());
        stringBuilder2.append(",");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("size:");
        stringBuilder2.append(file.length());
        stringBuilder2.append(",");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("canRead:");
        stringBuilder2.append(file.canRead());
        stringBuilder2.append(",");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("canWrite:");
        stringBuilder2.append(file.canWrite());
        stringBuilder2.append(",");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("totalSpace:");
        stringBuilder2.append(file.getTotalSpace());
        stringBuilder2.append(",");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("freeSpace:");
        stringBuilder2.append(file.getFreeSpace());
        stringBuilder2.append(",");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private boolean c(File file) {
        if (file != null) {
            try {
                String absolutePath = file.getAbsolutePath();
                if (absolutePath != null) {
                    if (absolutePath.length() > 0) {
                        if (f.a(this.c) || !absolutePath.startsWith("/system/")) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean c(File file, File file2) {
        try {
            return file.getCanonicalPath().equals(file2.getCanonicalPath());
        } catch (Exception e) {
            com.alibaba.wireless.security.framework.utils.a.a("", e);
            a(100046, 0, e != null ? e.toString() : "", file.getAbsolutePath(), file2.getAbsolutePath(), "", "");
            return false;
        }
    }

    private synchronized ISGPluginInfo d(String str, String str2, boolean z) throws SecException {
        c cVar = (c) this.d.get(str);
        if (cVar != null) {
            return cVar;
        }
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        if (this.k == null || !this.k.exists()) {
            a();
        }
        a c = c(str, str2, z);
        if (!(c == null || c.a == null)) {
            if (c.a.exists()) {
                c a = a(str, c, this.c, str2);
                if (a == null) {
                    String str3 = "";
                    if (c.c != null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("src:");
                        stringBuilder.append(c(c.c.getAbsolutePath()));
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("zipfile:");
                        stringBuilder.append(c(c.a.getAbsolutePath()));
                    }
                    a(100044, 110, str3, str, str2, stringBuilder.toString(), "");
                    throw new SecException(str, 111);
                }
                this.d.put(str, a);
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append("(");
                stringBuilder2.append(a.getVersion());
                stringBuilder2.append(")");
                str = stringBuilder2.toString();
                final String a2 = a.a("weakdependencies");
                if (str2.length() != 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str2);
                    stringBuilder3.append("->");
                    stringBuilder3.append(str);
                    str = stringBuilder3.toString();
                }
                Looper myLooper = Looper.myLooper();
                if (myLooper == null || myLooper == Looper.getMainLooper()) {
                    com.alibaba.wireless.security.framework.utils.a.a("looper of current thread is null, try to create a new thread with a looper");
                    HandlerThread handlerThread = new HandlerThread("SGBackgroud");
                    handlerThread.start();
                    myLooper = handlerThread.getLooper();
                }
                new Handler(myLooper).postDelayed(new Runnable() {
                    public void run() {
                        try {
                            d.this.a(a2, str, true);
                        } catch (SecException e) {
                            com.alibaba.wireless.security.framework.utils.a.a("load weak dependency", e);
                        }
                    }
                }, 60000);
                return a;
            }
        }
        if (!z) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("plugin ");
        stringBuilder.append(str);
        stringBuilder.append(" not existed");
        String stringBuilder4 = stringBuilder.toString();
        if (str2.length() != 0) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(stringBuilder4);
            stringBuilder2.append(", depended by ");
            stringBuilder2.append(str2);
            stringBuilder4 = stringBuilder2.toString();
        }
        a(100044, 110, "", str, str2, "", "");
        throw new SecException(stringBuilder4, 110);
    }

    private File d(File file) {
        if (!file.exists() || !file.isDirectory() || !this.j) {
            return file;
        }
        File file2 = new File(file, "main");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.exists() ? file2 : file;
    }

    public void a(Context context, String str, String str2, boolean z, Object... objArr) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.c = context;
        this.h = str;
        this.j = f.c(this.c);
        this.f = z;
        UserTrackMethodJniBridge.init(this.c);
        if (!(str2 == null || str2.isEmpty())) {
            this.g = str2;
        }
        try {
            a();
        } catch (SecException unused) {
        }
    }

    public synchronized <T> T getInterface(Class<T> cls) throws SecException {
        Object obj = this.a.get(cls);
        if (obj != null) {
            return cls.cast(obj);
        }
        String str = null;
        if (this.i != null) {
            str = this.i.d();
            if (str == null || str.length() == 0) {
                str = this.i.a(cls.getName());
            }
        }
        if (str == null || str.length() == 0) {
            str = a((Class) cls);
        }
        if (str != null) {
            if (str.length() != 0) {
                ISGPluginInfo pluginInfo = getPluginInfo(str);
                if (pluginInfo == null) {
                    throw new SecException(110);
                }
                Object obj2 = pluginInfo.getSGPluginEntry().getInterface(cls);
                if (obj2 == null) {
                    String name = cls.getName();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("(");
                    stringBuilder.append(pluginInfo.getVersion());
                    stringBuilder.append(")");
                    a(100045, 112, "", name, stringBuilder.toString(), c(pluginInfo.getPluginPath()), "");
                    throw new SecException(112);
                }
                this.a.put(cls, obj2);
                return cls.cast(obj2);
            }
        }
        throw new SecException(SecExceptionCode.SEC_ERROR_INIT_NO_ANNOTATION);
    }

    public String getMainPluginName() {
        return "main";
    }

    public ISGPluginInfo getPluginInfo(String str) throws SecException {
        return d(str, "", true);
    }

    public IRouterComponent getRouter() {
        return this.e;
    }
}
