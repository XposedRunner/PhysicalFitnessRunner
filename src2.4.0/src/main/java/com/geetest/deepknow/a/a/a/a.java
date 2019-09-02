package com.geetest.deepknow.a.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.a.b;

/* compiled from: DPPersonDAO */
public class a {
    private SQLiteDatabase a;
    private final com.geetest.deepknow.a.a b;

    public a(Context context) {
        this.b = new com.geetest.deepknow.a.a(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARNING: Missing block: B:8:0x003f, code skipped:
            if (r2 != null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:16:0x004e, code skipped:
            if (r2 != null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:17:0x0050, code skipped:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:18:0x0053, code skipped:
            return r0;
     */
    public java.util.List<com.geetest.deepknow.a.b> a() {
        /*
        r12 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = r12.b;	 Catch:{ Exception -> 0x0047, all -> 0x0044 }
        r2 = r2.getReadableDatabase();	 Catch:{ Exception -> 0x0047, all -> 0x0044 }
        r12.a = r2;	 Catch:{ Exception -> 0x0047, all -> 0x0044 }
        r3 = r12.a;	 Catch:{ Exception -> 0x0047, all -> 0x0044 }
        r4 = "GGDPERSON";
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r2 = r3.query(r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x0047, all -> 0x0044 }
    L_0x001c:
        r1 = r2.moveToNext();	 Catch:{ Exception -> 0x0042 }
        if (r1 == 0) goto L_0x003f;
    L_0x0022:
        r1 = "_ID";
        r1 = r2.getColumnIndex(r1);	 Catch:{ Exception -> 0x0042 }
        r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x0042 }
        r3 = "EVENTS";
        r3 = r2.getColumnIndex(r3);	 Catch:{ Exception -> 0x0042 }
        r3 = r2.getString(r3);	 Catch:{ Exception -> 0x0042 }
        r4 = new com.geetest.deepknow.a.b;	 Catch:{ Exception -> 0x0042 }
        r4.<init>(r3, r1);	 Catch:{ Exception -> 0x0042 }
        r0.add(r4);	 Catch:{ Exception -> 0x0042 }
        goto L_0x001c;
    L_0x003f:
        if (r2 == 0) goto L_0x0053;
    L_0x0041:
        goto L_0x0050;
    L_0x0042:
        r1 = move-exception;
        goto L_0x004b;
    L_0x0044:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0055;
    L_0x0047:
        r2 = move-exception;
        r11 = r2;
        r2 = r1;
        r1 = r11;
    L_0x004b:
        r1.printStackTrace();	 Catch:{ all -> 0x0054 }
        if (r2 == 0) goto L_0x0053;
    L_0x0050:
        r2.close();
    L_0x0053:
        return r0;
    L_0x0054:
        r0 = move-exception;
    L_0x0055:
        if (r2 == 0) goto L_0x005a;
    L_0x0057:
        r2.close();
    L_0x005a:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.deepknow.a.a.a.a.a():java.util.List");
    }

    public void a(b bVar) {
        JniLib1557756502.cV(this, bVar, Integer.valueOf(12));
    }

    public int b() {
        return JniLib1557756502.cI(this, Integer.valueOf(13));
    }

    public void c() {
        JniLib1557756502.cV(this, Integer.valueOf(14));
    }

    public void d() {
        JniLib1557756502.cV(this, Integer.valueOf(15));
    }
}
