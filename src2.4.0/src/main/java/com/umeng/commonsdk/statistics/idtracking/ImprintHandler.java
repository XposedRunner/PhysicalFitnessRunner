package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.proto.e;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ImprintHandler implements FileLockCallback {
    private static final String a = "ImprintHandler";
    private static Object b = new Object();
    private static final String c = ".imprint";
    private static final byte[] d = "pbl0".getBytes();
    private static Map<String, ArrayList<UMImprintChangeCallback>> f = new HashMap();
    private static Object g = new Object();
    private static ImprintHandler j = null;
    private static Context k = null;
    private static FileLockUtil l = null;
    private static final int m = 0;
    private static final int n = 1;
    private static Map<String, UMImprintPreProcessCallback> o = new HashMap();
    private static Object p = new Object();
    private d e;
    private a h = new a();
    private com.umeng.commonsdk.statistics.proto.d i = null;

    public static class a {
        private Map<String, String> a = new HashMap();

        a() {
        }

        a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        /* JADX WARNING: Missing block: B:26:0x0068, code skipped:
            return;
     */
        private synchronized void b(com.umeng.commonsdk.statistics.proto.d r7) {
            /*
            r6 = this;
            monitor-enter(r6);
            if (r7 == 0) goto L_0x0067;
        L_0x0003:
            r0 = r7.e();	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            if (r0 != 0) goto L_0x000a;
        L_0x0009:
            goto L_0x0067;
        L_0x000a:
            r7 = r7.c();	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r0 = r7.keySet();	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r0 = r0.iterator();	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
        L_0x0016:
            r1 = r0.hasNext();	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            if (r1 == 0) goto L_0x0065;
        L_0x001c:
            r1 = r0.next();	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            if (r2 != 0) goto L_0x0016;
        L_0x0028:
            r2 = r7.get(r1);	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r2 = (com.umeng.commonsdk.statistics.proto.e) r2;	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            if (r2 == 0) goto L_0x0016;
        L_0x0030:
            r2 = r2.b();	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            if (r3 != 0) goto L_0x0016;
        L_0x003a:
            r3 = r6.a;	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r3.put(r1, r2);	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r3 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            if (r3 == 0) goto L_0x0016;
        L_0x0043:
            r3 = "ImprintHandler";
            r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r4.<init>();	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r5 = "imKey is ";
            r4.append(r5);	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r4.append(r1);	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r1 = ", imValue is ";
            r4.append(r1);	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r4.append(r2);	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            r1 = r4.toString();	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            android.util.Log.i(r3, r1);	 Catch:{ Throwable -> 0x0065, all -> 0x0062 }
            goto L_0x0016;
        L_0x0062:
            r7 = move-exception;
            monitor-exit(r6);
            throw r7;
        L_0x0065:
            monitor-exit(r6);
            return;
        L_0x0067:
            monitor-exit(r6);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a.b(com.umeng.commonsdk.statistics.proto.d):void");
        }

        /* JADX WARNING: Missing block: B:14:0x0023, code skipped:
            return r3;
     */
        public synchronized java.lang.String a(java.lang.String r2, java.lang.String r3) {
            /*
            r1 = this;
            monitor-enter(r1);
            r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0022;
        L_0x0007:
            r0 = r1.a;	 Catch:{ all -> 0x0024 }
            r0 = r0.size();	 Catch:{ all -> 0x0024 }
            if (r0 > 0) goto L_0x0010;
        L_0x000f:
            goto L_0x0022;
        L_0x0010:
            r0 = r1.a;	 Catch:{ all -> 0x0024 }
            r2 = r0.get(r2);	 Catch:{ all -> 0x0024 }
            r2 = (java.lang.String) r2;	 Catch:{ all -> 0x0024 }
            r0 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0020;
        L_0x001e:
            monitor-exit(r1);
            return r2;
        L_0x0020:
            monitor-exit(r1);
            return r3;
        L_0x0022:
            monitor-exit(r1);
            return r3;
        L_0x0024:
            r2 = move-exception;
            monitor-exit(r1);
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a.a(java.lang.String, java.lang.String):java.lang.String");
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar != null) {
                b(dVar);
            }
        }

        public synchronized void a(String str) {
            if (this.a != null && this.a.size() > 0 && !TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                this.a.remove(str);
            }
        }
    }

    private ImprintHandler(Context context) {
        k = context.getApplicationContext();
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        if (dVar2 == null) {
            return dVar;
        }
        Map c = dVar.c();
        for (Entry entry : dVar2.c().entrySet()) {
            int i = 0;
            if (((e) entry.getValue()).d()) {
                String str = (String) entry.getKey();
                String str2 = ((e) entry.getValue()).a;
                synchronized (p) {
                    if (!TextUtils.isEmpty(str) && o.containsKey(str)) {
                        UMImprintPreProcessCallback uMImprintPreProcessCallback = (UMImprintPreProcessCallback) o.get(str);
                        if (uMImprintPreProcessCallback != null && uMImprintPreProcessCallback.onPreProcessImprintKey(str, str2)) {
                            i = 1;
                        }
                    }
                }
                if (i == 0) {
                    c.put(entry.getKey(), entry.getValue());
                    synchronized (g) {
                        if (!(TextUtils.isEmpty(str) || !f.containsKey(str) || ((ArrayList) f.get(str)) == null)) {
                            map.put(str, str2);
                        }
                    }
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("--->>> merge: [");
                    stringBuilder.append(str);
                    stringBuilder.append("] should be ignored.");
                    UMRTLog.i("MobclickRT", stringBuilder.toString());
                }
            } else {
                String str3 = (String) entry.getKey();
                synchronized (g) {
                    if (!TextUtils.isEmpty(str3) && f.containsKey(str3)) {
                        ArrayList arrayList = (ArrayList) f.get(str3);
                        if (arrayList != null) {
                            while (i < arrayList.size()) {
                                ((UMImprintChangeCallback) arrayList.get(i)).onImprintValueChanged(str3, null);
                                i++;
                            }
                        }
                    }
                }
                c.remove(str3);
                this.h.a(str3);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.i != null) {
            try {
                synchronized (b) {
                    byte[] a = new s().a(this.i);
                    OutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(a);
                        fileOutputStream.flush();
                    } finally {
                        HelperUtils.safeClose(fileOutputStream);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (g) {
            try {
                int i = 0;
                StringBuilder stringBuilder;
                if (f.containsKey(str)) {
                    ArrayList arrayList = (ArrayList) f.get(str);
                    int size = arrayList.size();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("--->>> addCallback: before add: callbacks size is: ");
                    stringBuilder2.append(size);
                    ULog.i(stringBuilder2.toString());
                    while (i < size) {
                        if (uMImprintChangeCallback == arrayList.get(i)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("--->>> addCallback: after add: callbacks size is: ");
                    stringBuilder.append(arrayList.size());
                    ULog.i(stringBuilder.toString());
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    int size2 = arrayList2.size();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("--->>> addCallback: before add: callbacks size is: ");
                    stringBuilder3.append(size2);
                    ULog.i(stringBuilder3.toString());
                    while (i < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("--->>> addCallback: after add: callbacks size is: ");
                    stringBuilder.append(arrayList2.size());
                    ULog.i(stringBuilder.toString());
                    f.put(str, arrayList2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(k, th);
            }
        }
    }

    private boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private static void b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            synchronized (g) {
                try {
                    if (f.containsKey(str)) {
                        ArrayList arrayList = (ArrayList) f.get(str);
                        if (uMImprintChangeCallback != null && arrayList.size() > 0) {
                            StringBuilder stringBuilder;
                            int size = arrayList.size();
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("--->>> removeCallback: before remove: callbacks size is: ");
                            stringBuilder2.append(size);
                            ULog.i(stringBuilder2.toString());
                            for (int i = 0; i < size; i++) {
                                if (uMImprintChangeCallback == arrayList.get(i)) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("--->>> removeCallback: remove index ");
                                    stringBuilder.append(i);
                                    ULog.i(stringBuilder.toString());
                                    arrayList.remove(i);
                                    break;
                                }
                            }
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("--->>> removeCallback: after remove: callbacks size is: ");
                            stringBuilder.append(arrayList.size());
                            ULog.i(stringBuilder.toString());
                            if (arrayList.size() == 0) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("--->>> removeCallback: remove key from map: key = ");
                                stringBuilder.append(str);
                                ULog.i(stringBuilder.toString());
                                f.remove(str);
                            }
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(k, th);
                }
            }
        }
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (e eVar : dVar.c().values()) {
            byte[] reverseHexString = DataHelper.reverseHexString(eVar.h());
            byte[] a = a(eVar);
            for (int i = 0; i < 4; i++) {
                if (reverseHexString[i] != a[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map c = dVar.c();
        ArrayList<String> arrayList = new ArrayList(c.size() / 2);
        Iterator it = c.entrySet().iterator();
        while (true) {
            int i = 0;
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (((e) entry.getValue()).d()) {
                    int i2;
                    String str = (String) entry.getKey();
                    String str2 = ((e) entry.getValue()).a;
                    synchronized (p) {
                        if (!TextUtils.isEmpty(str) && o.containsKey(str)) {
                            UMImprintPreProcessCallback uMImprintPreProcessCallback = (UMImprintPreProcessCallback) o.get(str);
                            if (uMImprintPreProcessCallback != null && uMImprintPreProcessCallback.onPreProcessImprintKey(str, str2)) {
                                i2 = 1;
                            }
                        }
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        arrayList.add(str);
                    }
                    synchronized (g) {
                        if (!TextUtils.isEmpty(str) && f.containsKey(str)) {
                            ArrayList arrayList2 = (ArrayList) f.get(str);
                            if (arrayList2 != null) {
                                while (i < arrayList2.size()) {
                                    ((UMImprintChangeCallback) arrayList2.get(i)).onImprintValueChanged(str, str2);
                                    i++;
                                }
                            }
                        }
                    }
                } else {
                    arrayList.add(entry.getKey());
                }
            } else {
                for (String str3 : arrayList) {
                    synchronized (g) {
                        if (!TextUtils.isEmpty(str3) && f.containsKey(str3)) {
                            ArrayList arrayList3 = (ArrayList) f.get(str3);
                            if (arrayList3 != null) {
                                for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                                    ((UMImprintChangeCallback) arrayList3.get(i3)).onImprintValueChanged(str3, null);
                                }
                            }
                        }
                    }
                    c.remove(str3);
                }
                return dVar;
            }
        }
        while (true) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038 A:{SYNTHETIC, Splitter:B:24:0x0038} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0038 A:{SYNTHETIC, Splitter:B:24:0x0038} */
    private void e() {
        /*
        r5 = this;
        r0 = new java.io.File;
        r1 = k;
        r1 = r1.getFilesDir();
        r2 = ".imprint";
        r0.<init>(r1, r2);
        r1 = b;
        monitor-enter(r1);
        r0 = r0.exists();	 Catch:{ all -> 0x005b }
        if (r0 != 0) goto L_0x0018;
    L_0x0016:
        monitor-exit(r1);	 Catch:{ all -> 0x005b }
        return;
    L_0x0018:
        r0 = 0;
        r2 = k;	 Catch:{ Exception -> 0x002e, all -> 0x002c }
        r3 = ".imprint";
        r2 = r2.openFileInput(r3);	 Catch:{ Exception -> 0x002e, all -> 0x002c }
        r3 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r2);	 Catch:{ Exception -> 0x002a }
        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2);	 Catch:{ all -> 0x005b }
        r0 = r3;
        goto L_0x0036;
    L_0x002a:
        r3 = move-exception;
        goto L_0x0030;
    L_0x002c:
        r2 = move-exception;
        goto L_0x0057;
    L_0x002e:
        r3 = move-exception;
        r2 = r0;
    L_0x0030:
        r3.printStackTrace();	 Catch:{ all -> 0x0053 }
        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2);	 Catch:{ all -> 0x005b }
    L_0x0036:
        if (r0 == 0) goto L_0x0051;
    L_0x0038:
        r2 = new com.umeng.commonsdk.statistics.proto.d;	 Catch:{ Exception -> 0x004d }
        r2.<init>();	 Catch:{ Exception -> 0x004d }
        r3 = new com.umeng.commonsdk.proguard.m;	 Catch:{ Exception -> 0x004d }
        r3.<init>();	 Catch:{ Exception -> 0x004d }
        r3.a(r2, r0);	 Catch:{ Exception -> 0x004d }
        r5.i = r2;	 Catch:{ Exception -> 0x004d }
        r0 = r5.h;	 Catch:{ Exception -> 0x004d }
        r0.a(r2);	 Catch:{ Exception -> 0x004d }
        goto L_0x0051;
    L_0x004d:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x005b }
    L_0x0051:
        monitor-exit(r1);	 Catch:{ all -> 0x005b }
        return;
    L_0x0053:
        r0 = move-exception;
        r4 = r2;
        r2 = r0;
        r0 = r4;
    L_0x0057:
        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r0);	 Catch:{ all -> 0x005b }
        throw r2;	 Catch:{ all -> 0x005b }
    L_0x005b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.e():void");
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            if (j == null) {
                j = new ImprintHandler(context);
                l = new FileLockUtil();
                if (l != null) {
                    l.doFileOperateion(new File(k.getFilesDir(), c), j, 0);
                }
            }
            imprintHandler = j;
        }
        return imprintHandler;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : new TreeMap(dVar.c()).entrySet()) {
            stringBuilder.append((String) entry.getKey());
            if (((e) entry.getValue()).d()) {
                stringBuilder.append(((e) entry.getValue()).b());
            }
            stringBuilder.append(((e) entry.getValue()).e());
            stringBuilder.append(((e) entry.getValue()).h());
        }
        stringBuilder.append(dVar.b);
        return HelperUtils.MD5(stringBuilder.toString()).toLowerCase(Locale.US);
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (p) {
                try {
                    StringBuilder stringBuilder;
                    if (o.containsKey(str)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("--->>> unregistPreProcessCallback: unregist [");
                        stringBuilder.append(str);
                        stringBuilder.append("] success.");
                        UMRTLog.i("MobclickRT", stringBuilder.toString());
                        f.remove(str);
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("--->>> unregistPreProcessCallback: can't find [");
                        stringBuilder.append(str);
                        stringBuilder.append("], pls regist first.");
                        UMRTLog.i("MobclickRT", stringBuilder.toString());
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(k, th);
                }
            }
        }
    }

    public byte[] a() {
        try {
            synchronized (this) {
                if (this.i == null) {
                    return null;
                }
                byte[] a = new s().a(this.i);
                return a;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(k, th);
            return null;
        }
    }

    public byte[] a(e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = d;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.i;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.d("Imprint is null");
            }
        } else if (c(dVar)) {
            String str;
            int a;
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.d("Imprint is ok");
            }
            HashMap hashMap = new HashMap();
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar2 = this.i;
                str = null;
                String i = dVar2 == null ? null : dVar2.i();
                dVar = dVar2 == null ? d(dVar) : a(dVar2, dVar, hashMap);
                this.i = dVar;
                if (dVar != null) {
                    str = dVar.i();
                }
                a = a(i, str) ^ 1;
            }
            if (this.i != null) {
                boolean z = AnalyticsConstants.UM_DEBUG;
                if (a != 0) {
                    this.h.a(this.i);
                    if (this.e != null) {
                        this.e.onImprintChanged(this.h);
                    }
                }
            }
            if (hashMap.size() > 0) {
                synchronized (g) {
                    for (Entry entry : hashMap.entrySet()) {
                        str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        if (!TextUtils.isEmpty(str) && f.containsKey(str)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("--->>> target imprint key is: ");
                            stringBuilder.append(str);
                            stringBuilder.append("; value is: ");
                            stringBuilder.append(str2);
                            ULog.i(stringBuilder.toString());
                            ArrayList arrayList = (ArrayList) f.get(str);
                            if (arrayList != null) {
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    ((UMImprintChangeCallback) arrayList.get(i2)).onImprintValueChanged(str, str2);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e("Imprint is not valid");
            }
        }
    }

    public a c() {
        return this.h;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0020 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
    /* JADX WARNING: Missing block: B:11:0x0024, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:12:0x0025, code skipped:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(k, r1);
     */
    public void d() {
        /*
        r4 = this;
        r0 = r4.i;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = l;
        if (r0 == 0) goto L_0x0032;
    L_0x0009:
        r0 = new java.io.File;
        r1 = k;
        r1 = r1.getFilesDir();
        r2 = ".imprint";
        r0.<init>(r1, r2);
        r1 = r0.exists();
        if (r1 != 0) goto L_0x002a;
    L_0x001c:
        r0.createNewFile();	 Catch:{ IOException -> 0x0020 }
        goto L_0x002a;
    L_0x0020:
        r0.createNewFile();	 Catch:{ IOException -> 0x0024 }
        goto L_0x002a;
    L_0x0024:
        r1 = move-exception;
        r2 = k;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r2, r1);
    L_0x002a:
        r1 = l;
        r2 = j;
        r3 = 1;
        r1.doFileOperateion(r0, r2, r3);
    L_0x0032:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.d():void");
    }

    public boolean onFileLock(File file, int i) {
        if (i == 0) {
            j.e();
        } else if (i == 1) {
            j.a(file);
        }
        return true;
    }

    public boolean onFileLock(String str) {
        return false;
    }

    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            a(str, uMImprintChangeCallback);
        }
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintPreProcessCallback != null) {
            synchronized (p) {
                try {
                    StringBuilder stringBuilder;
                    if (o.containsKey(str)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("--->>> key : ");
                        stringBuilder.append(str);
                        stringBuilder.append(" PreProcesser has registed!");
                        UMRTLog.i("MobclickRT", stringBuilder.toString());
                    } else {
                        o.put(str, uMImprintPreProcessCallback);
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("--->>> registPreProcessCallback: key : ");
                        stringBuilder.append(str);
                        stringBuilder.append(" regist success.");
                        UMRTLog.i("MobclickRT", stringBuilder.toString());
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(k, th);
                }
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (!TextUtils.isEmpty(str) && uMImprintChangeCallback != null) {
            b(str, uMImprintChangeCallback);
        }
    }
}
