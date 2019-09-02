package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.FileOutputStream;

/* compiled from: EventList */
/* renamed from: ab */
public class ab extends ae implements FileLockCallback {
    private static final int O00000oo = 0;
    private static final int O0000O0o = 1;
    private static final int O0000OOo = 2;
    protected String O000000o;
    protected String O00000Oo;
    protected String O00000o;
    protected String O00000o0;
    private Context O00000oO;
    private FileLockUtil O0000Oo0 = new FileLockUtil();

    public ab(String str, String str2) {
        this.O000000o = str;
        this.O00000Oo = str;
        this.O00000o = str2;
    }

    private void O000000o(File file) {
        if (this.O00000oO != null) {
            synchronized (this.O0000Oo0) {
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00be A:{SYNTHETIC, Splitter:B:60:0x00be} */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ca A:{SYNTHETIC, Splitter:B:66:0x00ca} */
    private boolean O000000o(android.content.Context r9, java.io.File r10) {
        /*
        r8 = this;
        r0 = r10.exists();
        r1 = 0;
        if (r0 == 0) goto L_0x00d3;
    L_0x0007:
        r0 = r8.O00000o0;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x00d3;
    L_0x000f:
        r0 = 0;
        r2 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00b5, all -> 0x00b0 }
        r2.<init>(r10);	 Catch:{ Throwable -> 0x00b5, all -> 0x00b0 }
        r10 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00b5, all -> 0x00b0 }
        r10.<init>(r2);	 Catch:{ Throwable -> 0x00b5, all -> 0x00b0 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ae }
        r0.<init>();	 Catch:{ Throwable -> 0x00ae }
    L_0x001f:
        r2 = r10.readLine();	 Catch:{ Throwable -> 0x00ae }
        if (r2 == 0) goto L_0x0029;
    L_0x0025:
        r0.append(r2);	 Catch:{ Throwable -> 0x00ae }
        goto L_0x001f;
    L_0x0029:
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00ae }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x00ae }
        if (r2 != 0) goto L_0x00a8;
    L_0x0033:
        r2 = com.umeng.commonsdk.statistics.common.HelperUtils.getMD5(r0);	 Catch:{ Throwable -> 0x00ae }
        r3 = r8.O00000o;	 Catch:{ Throwable -> 0x00ae }
        r4 = "";
        r3 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r9, r3, r4);	 Catch:{ Throwable -> 0x00ae }
        r8.O00000o0 = r0;	 Catch:{ Throwable -> 0x00ae }
        r8.O00000Oo();	 Catch:{ Throwable -> 0x00ae }
        r4 = "MobclickRT";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ae }
        r5.<init>();	 Catch:{ Throwable -> 0x00ae }
        r6 = "--->>> loadEventListFromFile: mEventList = ";
        r5.append(r6);	 Catch:{ Throwable -> 0x00ae }
        r6 = r8.O00000o0;	 Catch:{ Throwable -> 0x00ae }
        r5.append(r6);	 Catch:{ Throwable -> 0x00ae }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x00ae }
        com.umeng.commonsdk.debug.UMRTLog.i(r4, r5);	 Catch:{ Throwable -> 0x00ae }
        r4 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r9);	 Catch:{ Throwable -> 0x00ae }
        r5 = 1;
        if (r4 == 0) goto L_0x0087;
    L_0x0063:
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Throwable -> 0x00ae }
        if (r2 == 0) goto L_0x0079;
    L_0x0069:
        r8.O00000o0 = r0;	 Catch:{ Throwable -> 0x00ae }
        r8.O000000o(r1);	 Catch:{ Throwable -> 0x00ae }
        if (r10 == 0) goto L_0x0078;
    L_0x0070:
        r10.close();	 Catch:{ Throwable -> 0x0074 }
        goto L_0x0078;
    L_0x0074:
        r10 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10);
    L_0x0078:
        return r5;
    L_0x0079:
        r8.O000000o(r5);	 Catch:{ Throwable -> 0x00ae }
        if (r10 == 0) goto L_0x0086;
    L_0x007e:
        r10.close();	 Catch:{ Throwable -> 0x0082 }
        goto L_0x0086;
    L_0x0082:
        r10 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10);
    L_0x0086:
        return r1;
    L_0x0087:
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Throwable -> 0x00ae }
        if (r2 == 0) goto L_0x009d;
    L_0x008d:
        r8.O00000o0 = r0;	 Catch:{ Throwable -> 0x00ae }
        r8.O00000Oo();	 Catch:{ Throwable -> 0x00ae }
        if (r10 == 0) goto L_0x009c;
    L_0x0094:
        r10.close();	 Catch:{ Throwable -> 0x0098 }
        goto L_0x009c;
    L_0x0098:
        r10 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10);
    L_0x009c:
        return r5;
    L_0x009d:
        if (r10 == 0) goto L_0x00a7;
    L_0x009f:
        r10.close();	 Catch:{ Throwable -> 0x00a3 }
        goto L_0x00a7;
    L_0x00a3:
        r10 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10);
    L_0x00a7:
        return r1;
    L_0x00a8:
        if (r10 == 0) goto L_0x00d3;
    L_0x00aa:
        r10.close();	 Catch:{ Throwable -> 0x00c2 }
        goto L_0x00d3;
    L_0x00ae:
        r0 = move-exception;
        goto L_0x00b9;
    L_0x00b0:
        r10 = move-exception;
        r7 = r0;
        r0 = r10;
        r10 = r7;
        goto L_0x00c8;
    L_0x00b5:
        r10 = move-exception;
        r7 = r0;
        r0 = r10;
        r10 = r7;
    L_0x00b9:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r0);	 Catch:{ all -> 0x00c7 }
        if (r10 == 0) goto L_0x00d3;
    L_0x00be:
        r10.close();	 Catch:{ Throwable -> 0x00c2 }
        goto L_0x00d3;
    L_0x00c2:
        r10 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10);
        goto L_0x00d3;
    L_0x00c7:
        r0 = move-exception;
    L_0x00c8:
        if (r10 == 0) goto L_0x00d2;
    L_0x00ca:
        r10.close();	 Catch:{ Throwable -> 0x00ce }
        goto L_0x00d2;
    L_0x00ce:
        r10 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10);
    L_0x00d2:
        throw r0;
    L_0x00d3:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ab.O000000o(android.content.Context, java.io.File):boolean");
    }

    private void O00000Oo(Context context, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(this.O00000o0.getBytes());
            fileOutputStream.close();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public void O000000o(Context context) {
        if (this.O00000oO == null) {
            this.O00000oO = context.getApplicationContext();
        }
        File file = new File(this.O00000oO.getFilesDir(), this.O000000o);
        if (!TextUtils.isEmpty(UMEnvelopeBuild.imprintProperty(this.O00000oO, this.O00000o, ""))) {
            if (file.exists()) {
                this.O0000Oo0.doFileOperateion(file, (FileLockCallback) this, 1);
            } else {
                O000000o(true);
            }
        }
        if (UMUtils.isMainProgress(this.O00000oO)) {
            ImprintHandler.getImprintService(this.O00000oO).registPreProcessCallback(this.O00000Oo, this);
            ImprintHandler.getImprintService(this.O00000oO).registImprintCallback(this.O00000o, this);
        }
    }

    public void O000000o(boolean z) {
    }

    public boolean O000000o() {
        synchronized (this) {
            if (this.O00000o0 == null) {
                return false;
            }
            return true;
        }
    }

    public boolean O000000o(String str) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo() {
    }

    public boolean onFileLock(File file, int i) {
        if (i == 0) {
            synchronized (this) {
                O00000Oo(this.O00000oO, file);
            }
        } else if (i == 1) {
            synchronized (this) {
                if (O000000o(this.O00000oO, file)) {
                    UMRTLog.i("MobclickRT", "--->>> find event list data file, load it.");
                } else {
                    UMRTLog.i("MobclickRT", "--->>> can't find event list file.");
                }
            }
        } else if (i == 2) {
            synchronized (this) {
                this.O00000o0 = null;
                O000000o(file);
            }
        }
        return true;
    }

    public boolean onFileLock(String str) {
        return false;
    }

    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void onImprintValueChanged(String str, String str2) {
        if (ah.O000o0O.equals(str) && str2 == null) {
            UMRTLog.i("MobclickRT", "--->>> disable black list for ekv.");
            this.O0000Oo0.doFileOperateion(new File(this.O00000oO.getFilesDir(), this.O000000o), (FileLockCallback) this, 2);
        }
        if (ah.O000o0OO.equals(str) && str2 == null) {
            UMRTLog.i("MobclickRT", "--->>> disable white list for ekv.");
            this.O0000Oo0.doFileOperateion(new File(this.O00000oO.getFilesDir(), this.O000000o), (FileLockCallback) this, 2);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0060 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Missing block: B:10:0x0064, code skipped:
            r6 = move-exception;
     */
    /* JADX WARNING: Missing block: B:11:0x0065, code skipped:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r4.O00000oO, r6);
     */
    public boolean onPreProcessImprintKey(java.lang.String r5, java.lang.String r6) {
        /*
        r4 = this;
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 != 0) goto L_0x0073;
    L_0x0006:
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 != 0) goto L_0x0073;
    L_0x000c:
        r0 = r6.length();
        r1 = "MobclickRT";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "--->>> onPreProcessImprintKey: key = ";
        r2.append(r3);
        r2.append(r5);
        r5 = "; len of value=";
        r2.append(r5);
        r2.append(r0);
        r5 = r2.toString();
        com.umeng.commonsdk.debug.UMRTLog.i(r1, r5);
        r5 = "MobclickRT";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "--->>> onPreProcessImprintKey: value = ";
        r0.append(r1);
        r0.append(r6);
        r0 = r0.toString();
        com.umeng.commonsdk.debug.UMRTLog.i(r5, r0);
        r4.O00000o0 = r6;
        r4.O00000Oo();
        r5 = new java.io.File;
        r6 = r4.O00000oO;
        r6 = r6.getFilesDir();
        r0 = r4.O000000o;
        r5.<init>(r6, r0);
        r6 = r5.exists();
        if (r6 != 0) goto L_0x006a;
    L_0x005c:
        r5.createNewFile();	 Catch:{ IOException -> 0x0060 }
        goto L_0x006a;
    L_0x0060:
        r5.createNewFile();	 Catch:{ IOException -> 0x0064 }
        goto L_0x006a;
    L_0x0064:
        r6 = move-exception;
        r0 = r4.O00000oO;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r0, r6);
    L_0x006a:
        r6 = r4.O0000Oo0;
        r0 = 0;
        r6.doFileOperateion(r5, r4, r0);
        r4.O000000o(r0);
    L_0x0073:
        r5 = 1;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ab.onPreProcessImprintKey(java.lang.String, java.lang.String):boolean");
    }

    public String toString() {
        if (TextUtils.isEmpty(this.O000000o) || TextUtils.isEmpty(this.O00000Oo)) {
            return "Uninitialized EventList.";
        }
        StringBuilder stringBuilder = new StringBuilder("[");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("EventListName:");
        stringBuilder2.append(this.O000000o);
        stringBuilder2.append(",");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("listKey:");
        stringBuilder2.append(this.O00000Oo);
        stringBuilder2.append(",");
        stringBuilder.append(stringBuilder2.toString());
        if (TextUtils.isEmpty(this.O00000o0)) {
            stringBuilder.append("listKeyValue:empty,");
        } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("listKeyValue:");
            stringBuilder2.append(this.O00000o0);
            stringBuilder2.append("]");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (TextUtils.isEmpty(this.O00000o)) {
            stringBuilder.append("listKeyVer:empty]");
        } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("listKeyVer:");
            stringBuilder2.append(this.O00000o);
            stringBuilder2.append("]");
            stringBuilder.append(stringBuilder2.toString());
        }
        return stringBuilder.toString();
    }
}
