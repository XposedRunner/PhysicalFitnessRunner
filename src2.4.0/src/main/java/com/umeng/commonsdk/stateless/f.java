package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.ap;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: UMSLUtils */
public class f {
    public static int a;
    private static final byte[] b = new byte[]{(byte) 10, (byte) 1, (byte) 11, (byte) 5, (byte) 4, ap.m, (byte) 7, (byte) 9, (byte) 23, (byte) 3, (byte) 1, (byte) 6, (byte) 8, (byte) 12, ap.k, (byte) 91};
    private static Object c = new Object();

    public static File a(Context context) {
        Throwable th;
        File file = null;
        try {
            synchronized (c) {
                try {
                    Object[] objArr = new Object[1];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("get last envelope begin, thread is ");
                    stringBuilder.append(Thread.currentThread());
                    objArr[0] = stringBuilder.toString();
                    ULog.i("walle", objArr);
                    if (!(context == null || context.getApplicationContext() == null)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(context.getApplicationContext().getFilesDir());
                        stringBuilder2.append("/");
                        stringBuilder2.append(a.e);
                        String stringBuilder3 = stringBuilder2.toString();
                        if (!TextUtils.isEmpty(stringBuilder3)) {
                            File file2 = new File(stringBuilder3);
                            if (file2 != null && file2.isDirectory()) {
                                File[] listFiles = file2.listFiles();
                                if (listFiles != null && listFiles.length > 0) {
                                    file2 = null;
                                    int i = 0;
                                    while (i < listFiles.length) {
                                        try {
                                            File file3 = listFiles[i];
                                            if (file3 != null && file3.isDirectory()) {
                                                File[] listFiles2 = file3.listFiles();
                                                if (listFiles2 != null && listFiles2.length > 0) {
                                                    Arrays.sort(listFiles2, new Comparator<File>() {
                                                        /* renamed from: a */
                                                        public int compare(File file, File file2) {
                                                            long lastModified = file.lastModified() - file2.lastModified();
                                                            return lastModified > 0 ? 1 : lastModified == 0 ? 0 : -1;
                                                        }
                                                    });
                                                    file3 = listFiles2[0];
                                                    if (file3 != null && (file2 == null || file2.lastModified() > file3.lastModified())) {
                                                        file2 = file3;
                                                    }
                                                }
                                            }
                                            i++;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            file = file2;
                                            throw th;
                                        }
                                    }
                                    file = file2;
                                }
                            }
                        }
                    }
                    Object[] objArr2 = new Object[1];
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("get last envelope end, thread is ");
                    stringBuilder4.append(Thread.currentThread());
                    objArr2[0] = stringBuilder4.toString();
                    ULog.i("walle", objArr2);
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        } catch (Throwable th4) {
            UMCrashManager.reportCrash(context, th4);
        }
        return file;
    }

    public static void a(Context context, String str, int i) {
        Object[] objArr;
        StringBuilder stringBuilder;
        if (str == null) {
            try {
                objArr = new Object[1];
                stringBuilder = new StringBuilder();
                stringBuilder.append("[lbs-build] fileDir not exist, thread is ");
                stringBuilder.append(Thread.currentThread());
                objArr[0] = stringBuilder.toString();
                ULog.i("AmapLBS", objArr);
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        } else {
            File file = new File(str);
            if (file.isDirectory()) {
                synchronized (c) {
                    File[] listFiles = file.listFiles();
                    Object[] objArr2 = new Object[1];
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("[lbs-build] delete file begin ");
                    stringBuilder2.append(listFiles.length);
                    stringBuilder2.append(", thread is ");
                    stringBuilder2.append(Thread.currentThread());
                    objArr2[0] = stringBuilder2.toString();
                    ULog.i("AmapLBS", objArr2);
                    if (listFiles == null || listFiles.length < i) {
                        ULog.i("AmapLBS", "[lbs-build] file size < max");
                    } else {
                        int i2;
                        ULog.i("AmapLBS", "[lbs-build] file size >= max");
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : listFiles) {
                            if (obj != null) {
                                arrayList.add(obj);
                            }
                        }
                        if (arrayList != null && arrayList.size() >= i) {
                            Object[] objArr3;
                            StringBuilder stringBuilder3;
                            Collections.sort(arrayList, new Comparator<File>() {
                                /* renamed from: a */
                                public int compare(File file, File file2) {
                                    return (file == null || file2 == null || file.lastModified() >= file2.lastModified()) ? (file == null || file2 == null || file.lastModified() != file2.lastModified()) ? 1 : 0 : -1;
                                }
                            });
                            if (ULog.DEBUG) {
                                for (i2 = 0; i2 < arrayList.size(); i2++) {
                                    objArr3 = new Object[1];
                                    stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append("[lbs-build] overrun native file is ");
                                    stringBuilder3.append(((File) arrayList.get(i2)).getPath());
                                    objArr3[0] = stringBuilder3.toString();
                                    ULog.i("AmapLBS", objArr3);
                                }
                            }
                            i2 = 0;
                            while (i2 <= arrayList.size() - i) {
                                if (!(arrayList == null || arrayList.get(i2) == null)) {
                                    objArr3 = new Object[1];
                                    stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append("[lbs-build] overrun remove file is ");
                                    stringBuilder3.append(((File) arrayList.get(i2)).getPath());
                                    objArr3[0] = stringBuilder3.toString();
                                    ULog.i("AmapLBS", objArr3);
                                    try {
                                        ((File) arrayList.get(i2)).delete();
                                        arrayList.remove(i2);
                                    } catch (Exception unused) {
                                    }
                                }
                                i2++;
                            }
                        }
                    }
                    Object[] objArr4 = new Object[1];
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("[lbs-build] delete file end ");
                    stringBuilder4.append(listFiles.length);
                    stringBuilder4.append(", thread is ");
                    stringBuilder4.append(Thread.currentThread());
                    objArr4[0] = stringBuilder4.toString();
                    ULog.i("AmapLBS", objArr4);
                }
                return;
            }
            objArr = new Object[1];
            stringBuilder = new StringBuilder();
            stringBuilder.append("[lbs-build] fileDir not exist, thread is ");
            stringBuilder.append(Thread.currentThread());
            objArr[0] = stringBuilder.toString();
            ULog.i("AmapLBS", objArr);
        }
    }

    public static boolean a(long j, long j2) {
        return j > j2;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:48:0x0120=Splitter:B:48:0x0120, B:39:0x00dc=Splitter:B:39:0x00dc} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ff A:{SYNTHETIC, Splitter:B:42:0x00ff} */
    /* JADX WARNING: Missing block: B:32:0x00d1, code skipped:
            r9 = th;
     */
    /* JADX WARNING: Missing block: B:33:0x00d3, code skipped:
            r9 = e;
     */
    /* JADX WARNING: Missing block: B:43:?, code skipped:
            r2.close();
     */
    public static boolean a(android.content.Context r8, java.lang.String r9, java.lang.String r10, byte[] r11) {
        /*
        r0 = 1;
        r1 = 0;
        if (r8 == 0) goto L_0x0189;
    L_0x0004:
        r2 = 0;
        r3 = c;	 Catch:{ IOException -> 0x011e, Throwable -> 0x00da }
        monitor-enter(r3);	 Catch:{ IOException -> 0x011e, Throwable -> 0x00da }
        r4 = "walle";
        r5 = new java.lang.Object[r0];	 Catch:{ all -> 0x00cd }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00cd }
        r6.<init>();	 Catch:{ all -> 0x00cd }
        r7 = "[stateless] begin write envelope, thread is ";
        r6.append(r7);	 Catch:{ all -> 0x00cd }
        r7 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x00cd }
        r6.append(r7);	 Catch:{ all -> 0x00cd }
        r6 = r6.toString();	 Catch:{ all -> 0x00cd }
        r5[r1] = r6;	 Catch:{ all -> 0x00cd }
        com.umeng.commonsdk.statistics.common.ULog.i(r4, r5);	 Catch:{ all -> 0x00cd }
        r4 = new java.io.File;	 Catch:{ all -> 0x00cd }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00cd }
        r5.<init>();	 Catch:{ all -> 0x00cd }
        r6 = r8.getFilesDir();	 Catch:{ all -> 0x00cd }
        r5.append(r6);	 Catch:{ all -> 0x00cd }
        r6 = "/";
        r5.append(r6);	 Catch:{ all -> 0x00cd }
        r6 = "stateless";
        r5.append(r6);	 Catch:{ all -> 0x00cd }
        r5 = r5.toString();	 Catch:{ all -> 0x00cd }
        r4.<init>(r5);	 Catch:{ all -> 0x00cd }
        r5 = r4.isDirectory();	 Catch:{ all -> 0x00cd }
        if (r5 != 0) goto L_0x004e;
    L_0x004b:
        r4.mkdir();	 Catch:{ all -> 0x00cd }
    L_0x004e:
        r5 = new java.io.File;	 Catch:{ all -> 0x00cd }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00cd }
        r6.<init>();	 Catch:{ all -> 0x00cd }
        r4 = r4.getPath();	 Catch:{ all -> 0x00cd }
        r6.append(r4);	 Catch:{ all -> 0x00cd }
        r4 = "/";
        r6.append(r4);	 Catch:{ all -> 0x00cd }
        r6.append(r9);	 Catch:{ all -> 0x00cd }
        r9 = r6.toString();	 Catch:{ all -> 0x00cd }
        r5.<init>(r9);	 Catch:{ all -> 0x00cd }
        r9 = r5.isDirectory();	 Catch:{ all -> 0x00cd }
        if (r9 != 0) goto L_0x0074;
    L_0x0071:
        r5.mkdir();	 Catch:{ all -> 0x00cd }
    L_0x0074:
        r9 = new java.io.File;	 Catch:{ all -> 0x00cd }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00cd }
        r4.<init>();	 Catch:{ all -> 0x00cd }
        r5 = r5.getPath();	 Catch:{ all -> 0x00cd }
        r4.append(r5);	 Catch:{ all -> 0x00cd }
        r5 = "/";
        r4.append(r5);	 Catch:{ all -> 0x00cd }
        r4.append(r10);	 Catch:{ all -> 0x00cd }
        r10 = r4.toString();	 Catch:{ all -> 0x00cd }
        r9.<init>(r10);	 Catch:{ all -> 0x00cd }
        r10 = r9.exists();	 Catch:{ all -> 0x00cd }
        if (r10 != 0) goto L_0x009a;
    L_0x0097:
        r9.createNewFile();	 Catch:{ all -> 0x00cd }
    L_0x009a:
        r10 = new java.io.FileOutputStream;	 Catch:{ all -> 0x00cd }
        r10.<init>(r9);	 Catch:{ all -> 0x00cd }
        r10.write(r11);	 Catch:{ all -> 0x00ca }
        r10.close();	 Catch:{ all -> 0x00ca }
        monitor-exit(r3);	 Catch:{ all -> 0x00c7 }
        r8 = "walle";
        r9 = new java.lang.Object[r0];
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "[stateless] end write envelope, thread id ";
        r10.append(r11);
        r11 = java.lang.Thread.currentThread();
        r10.append(r11);
        r10 = r10.toString();
        r9[r1] = r10;
        com.umeng.commonsdk.statistics.common.ULog.i(r8, r9);
        r10 = r0;
        goto L_0x018a;
    L_0x00c7:
        r9 = move-exception;
        r10 = r0;
        goto L_0x00cf;
    L_0x00ca:
        r9 = move-exception;
        r2 = r10;
        goto L_0x00ce;
    L_0x00cd:
        r9 = move-exception;
    L_0x00ce:
        r10 = r1;
    L_0x00cf:
        monitor-exit(r3);	 Catch:{ all -> 0x00d5 }
        throw r9;	 Catch:{ IOException -> 0x00d3, Throwable -> 0x00d1 }
    L_0x00d1:
        r9 = move-exception;
        goto L_0x00dc;
    L_0x00d3:
        r9 = move-exception;
        goto L_0x0120;
    L_0x00d5:
        r9 = move-exception;
        goto L_0x00cf;
    L_0x00d7:
        r8 = move-exception;
        goto L_0x0165;
    L_0x00da:
        r9 = move-exception;
        r10 = r1;
    L_0x00dc:
        r11 = "walle";
        r3 = new java.lang.Object[r0];	 Catch:{ all -> 0x00d7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d7 }
        r4.<init>();	 Catch:{ all -> 0x00d7 }
        r5 = "[stateless] write envelope, e is ";
        r4.append(r5);	 Catch:{ all -> 0x00d7 }
        r5 = r9.getMessage();	 Catch:{ all -> 0x00d7 }
        r4.append(r5);	 Catch:{ all -> 0x00d7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00d7 }
        r3[r1] = r4;	 Catch:{ all -> 0x00d7 }
        com.umeng.commonsdk.statistics.common.ULog.i(r11, r3);	 Catch:{ all -> 0x00d7 }
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r8, r9);	 Catch:{ all -> 0x00d7 }
        if (r2 == 0) goto L_0x0102;
    L_0x00ff:
        r2.close();	 Catch:{ IOException -> 0x0102 }
    L_0x0102:
        r8 = "walle";
        r9 = new java.lang.Object[r0];
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r0 = "[stateless] end write envelope, thread id ";
        r11.append(r0);
        r0 = java.lang.Thread.currentThread();
        r11.append(r0);
        r11 = r11.toString();
        r9[r1] = r11;
        goto L_0x0161;
    L_0x011e:
        r9 = move-exception;
        r10 = r1;
    L_0x0120:
        r11 = "walle";
        r3 = new java.lang.Object[r0];	 Catch:{ all -> 0x00d7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d7 }
        r4.<init>();	 Catch:{ all -> 0x00d7 }
        r5 = "[stateless] write envelope, e is ";
        r4.append(r5);	 Catch:{ all -> 0x00d7 }
        r5 = r9.getMessage();	 Catch:{ all -> 0x00d7 }
        r4.append(r5);	 Catch:{ all -> 0x00d7 }
        r4 = r4.toString();	 Catch:{ all -> 0x00d7 }
        r3[r1] = r4;	 Catch:{ all -> 0x00d7 }
        com.umeng.commonsdk.statistics.common.ULog.i(r11, r3);	 Catch:{ all -> 0x00d7 }
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r8, r9);	 Catch:{ all -> 0x00d7 }
        if (r2 == 0) goto L_0x0146;
    L_0x0143:
        r2.close();	 Catch:{ IOException -> 0x0146 }
    L_0x0146:
        r8 = "walle";
        r9 = new java.lang.Object[r0];
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r0 = "[stateless] end write envelope, thread id ";
        r11.append(r0);
        r0 = java.lang.Thread.currentThread();
        r11.append(r0);
        r11 = r11.toString();
        r9[r1] = r11;
    L_0x0161:
        com.umeng.commonsdk.statistics.common.ULog.i(r8, r9);
        goto L_0x018a;
    L_0x0165:
        if (r2 == 0) goto L_0x016a;
    L_0x0167:
        r2.close();	 Catch:{ IOException -> 0x016a }
    L_0x016a:
        r9 = "walle";
        r10 = new java.lang.Object[r0];
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r0 = "[stateless] end write envelope, thread id ";
        r11.append(r0);
        r0 = java.lang.Thread.currentThread();
        r11.append(r0);
        r11 = r11.toString();
        r10[r1] = r11;
        com.umeng.commonsdk.statistics.common.ULog.i(r9, r10);
        throw r8;
    L_0x0189:
        r10 = r1;
    L_0x018a:
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.f.a(android.content.Context, java.lang.String, java.lang.String, byte[]):boolean");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00b2 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00af A:{SYNTHETIC, Splitter:B:28:0x00af} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0080 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:2|3|4|5|6|7|8|(1:10)|11|(2:13|14)|15|16) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:26|(2:28|29)|30|31) */
    public static byte[] a(java.lang.String r13) throws java.io.IOException {
        /*
        r0 = c;
        monitor-enter(r0);
        r1 = "walle";
        r2 = 1;
        r3 = new java.lang.Object[r2];	 Catch:{ all -> 0x00b3 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b3 }
        r4.<init>();	 Catch:{ all -> 0x00b3 }
        r5 = "[stateless] begin read envelope, thread is ";
        r4.append(r5);	 Catch:{ all -> 0x00b3 }
        r5 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x00b3 }
        r4.append(r5);	 Catch:{ all -> 0x00b3 }
        r4 = r4.toString();	 Catch:{ all -> 0x00b3 }
        r5 = 0;
        r3[r5] = r4;	 Catch:{ all -> 0x00b3 }
        com.umeng.commonsdk.statistics.common.ULog.i(r1, r3);	 Catch:{ all -> 0x00b3 }
        r1 = 0;
        r3 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x0089, all -> 0x0084 }
        r4 = "r";
        r3.<init>(r13, r4);	 Catch:{ IOException -> 0x0089, all -> 0x0084 }
        r13 = r3.getChannel();	 Catch:{ IOException -> 0x0089, all -> 0x0084 }
        r7 = java.nio.channels.FileChannel.MapMode.READ_ONLY;	 Catch:{ IOException -> 0x0082 }
        r8 = 0;
        r10 = r13.size();	 Catch:{ IOException -> 0x0082 }
        r6 = r13;
        r1 = r6.map(r7, r8, r10);	 Catch:{ IOException -> 0x0082 }
        r1 = r1.load();	 Catch:{ IOException -> 0x0082 }
        r3 = java.lang.System.out;	 Catch:{ IOException -> 0x0082 }
        r4 = r1.isLoaded();	 Catch:{ IOException -> 0x0082 }
        r3.println(r4);	 Catch:{ IOException -> 0x0082 }
        r3 = r13.size();	 Catch:{ IOException -> 0x0082 }
        r3 = (int) r3;	 Catch:{ IOException -> 0x0082 }
        r3 = new byte[r3];	 Catch:{ IOException -> 0x0082 }
        r4 = r1.remaining();	 Catch:{ IOException -> 0x0082 }
        if (r4 <= 0) goto L_0x005d;
    L_0x0056:
        r4 = r1.remaining();	 Catch:{ IOException -> 0x0082 }
        r1.get(r3, r5, r4);	 Catch:{ IOException -> 0x0082 }
    L_0x005d:
        r1 = "walle";
        r4 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x0082 }
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0082 }
        r6.<init>();	 Catch:{ IOException -> 0x0082 }
        r7 = "[stateless] end read envelope, thread id ";
        r6.append(r7);	 Catch:{ IOException -> 0x0082 }
        r7 = java.lang.Thread.currentThread();	 Catch:{ IOException -> 0x0082 }
        r6.append(r7);	 Catch:{ IOException -> 0x0082 }
        r6 = r6.toString();	 Catch:{ IOException -> 0x0082 }
        r4[r5] = r6;	 Catch:{ IOException -> 0x0082 }
        com.umeng.commonsdk.statistics.common.ULog.i(r1, r4);	 Catch:{ IOException -> 0x0082 }
        if (r13 == 0) goto L_0x0080;
    L_0x007d:
        r13.close();	 Catch:{ IOException -> 0x0080 }
    L_0x0080:
        monitor-exit(r0);	 Catch:{ all -> 0x00b3 }
        return r3;
    L_0x0082:
        r1 = move-exception;
        goto L_0x008d;
    L_0x0084:
        r13 = move-exception;
        r12 = r1;
        r1 = r13;
        r13 = r12;
        goto L_0x00ad;
    L_0x0089:
        r13 = move-exception;
        r12 = r1;
        r1 = r13;
        r13 = r12;
    L_0x008d:
        r3 = "walle";
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00ac }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ac }
        r4.<init>();	 Catch:{ all -> 0x00ac }
        r6 = "[stateless] write envelope, e is ";
        r4.append(r6);	 Catch:{ all -> 0x00ac }
        r6 = r1.getMessage();	 Catch:{ all -> 0x00ac }
        r4.append(r6);	 Catch:{ all -> 0x00ac }
        r4 = r4.toString();	 Catch:{ all -> 0x00ac }
        r2[r5] = r4;	 Catch:{ all -> 0x00ac }
        com.umeng.commonsdk.statistics.common.ULog.i(r3, r2);	 Catch:{ all -> 0x00ac }
        throw r1;	 Catch:{ all -> 0x00ac }
    L_0x00ac:
        r1 = move-exception;
    L_0x00ad:
        if (r13 == 0) goto L_0x00b2;
    L_0x00af:
        r13.close();	 Catch:{ IOException -> 0x00b2 }
    L_0x00b2:
        throw r1;	 Catch:{ all -> 0x00b3 }
    L_0x00b3:
        r13 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00b3 }
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.f.a(java.lang.String):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    public static byte[] a(byte[] r5) throws java.io.IOException {
        /*
        r0 = 0;
        if (r5 == 0) goto L_0x0048;
    L_0x0003:
        r1 = r5.length;
        if (r1 > 0) goto L_0x0007;
    L_0x0006:
        goto L_0x0048;
    L_0x0007:
        r1 = new java.util.zip.Deflater;
        r1.<init>();
        r1.setInput(r5);
        r1.finish();
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r5 = new byte[r5];
        r2 = 0;
        a = r2;
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0040 }
        r3.<init>();	 Catch:{ all -> 0x0040 }
    L_0x001e:
        r0 = r1.finished();	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x0031;
    L_0x0024:
        r0 = r1.deflate(r5);	 Catch:{ all -> 0x003e }
        r4 = a;	 Catch:{ all -> 0x003e }
        r4 = r4 + r0;
        a = r4;	 Catch:{ all -> 0x003e }
        r3.write(r5, r2, r0);	 Catch:{ all -> 0x003e }
        goto L_0x001e;
    L_0x0031:
        r1.end();	 Catch:{ all -> 0x003e }
        if (r3 == 0) goto L_0x0039;
    L_0x0036:
        r3.close();
    L_0x0039:
        r5 = r3.toByteArray();
        return r5;
    L_0x003e:
        r5 = move-exception;
        goto L_0x0042;
    L_0x0040:
        r5 = move-exception;
        r3 = r0;
    L_0x0042:
        if (r3 == 0) goto L_0x0047;
    L_0x0044:
        r3.close();
    L_0x0047:
        throw r5;
    L_0x0048:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.f.a(byte[]):byte[]");
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(b));
        return instance.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.reset();
            instance.update(bArr);
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }
}
