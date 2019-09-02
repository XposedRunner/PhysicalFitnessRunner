package defpackage;

import android.content.Context;
import com.umeng.socialize.utils.O00000Oo;

/* compiled from: DBManager */
/* renamed from: cy */
public class cy {
    private static cy O000000o;
    private static cz O00000Oo;

    private cy() {
        O00000Oo = new cz(O00000Oo.O000000o());
    }

    public static synchronized cy O000000o(Context context) {
        cy cyVar;
        synchronized (cy.class) {
            if (O000000o == null) {
                O000000o = new cy();
            }
            cyVar = O000000o;
        }
        return cyVar;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x00a0 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0089 A:{Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074, Throwable -> 0x008f }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098 A:{SYNTHETIC, Splitter:B:54:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d A:{Catch:{ Throwable -> 0x00a0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0089 A:{Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074, Throwable -> 0x008f }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098 A:{SYNTHETIC, Splitter:B:54:0x0098} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009d A:{Catch:{ Throwable -> 0x00a0 }} */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:25|26|(2:54|55)|(1:57)|58|59) */
    /* JADX WARNING: Missing block: B:23:0x006e, code skipped:
            if (r2 != null) goto L_0x0070;
     */
    /* JADX WARNING: Missing block: B:24:0x0070, code skipped:
            r2.endTransaction();
     */
    /* JADX WARNING: Missing block: B:43:0x008c, code skipped:
            if (r2 != null) goto L_0x0070;
     */
    public synchronized org.json.JSONArray O000000o(java.lang.String r8, java.util.ArrayList<java.lang.Integer> r9, double r10, boolean r12) throws org.json.JSONException {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = new org.json.JSONArray;	 Catch:{ all -> 0x00a1 }
        r0.<init>();	 Catch:{ all -> 0x00a1 }
        r1 = 0;
        r2 = O00000Oo;	 Catch:{ JSONException -> 0x0091, Throwable -> 0x0085, all -> 0x0081 }
        r2 = r2.getWritableDatabase();	 Catch:{ JSONException -> 0x0091, Throwable -> 0x0085, all -> 0x0081 }
        r2.beginTransaction();	 Catch:{ JSONException -> 0x007d, Throwable -> 0x007b, all -> 0x0078 }
        r3 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x007d, Throwable -> 0x007b, all -> 0x0078 }
        r3.<init>();	 Catch:{ JSONException -> 0x007d, Throwable -> 0x007b, all -> 0x0078 }
        r4 = "select * from ";
        r3.append(r4);	 Catch:{ JSONException -> 0x007d, Throwable -> 0x007b, all -> 0x0078 }
        r3.append(r8);	 Catch:{ JSONException -> 0x007d, Throwable -> 0x007b, all -> 0x0078 }
        r8 = r3.toString();	 Catch:{ JSONException -> 0x007d, Throwable -> 0x007b, all -> 0x0078 }
        r8 = r2.rawQuery(r8, r1);	 Catch:{ JSONException -> 0x007d, Throwable -> 0x007b, all -> 0x0078 }
    L_0x0025:
        r1 = r8.moveToNext();	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        if (r1 == 0) goto L_0x0066;
    L_0x002b:
        r1 = 0;
        r1 = r8.getInt(r1);	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r3 = 1;
        r3 = r8.getString(r3);	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        if (r12 == 0) goto L_0x004c;
    L_0x0037:
        r4 = r0.toString();	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r4 = r4.getBytes();	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r4 = r4.length;	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r5 = r3.getBytes();	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r5 = r5.length;	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r4 = r4 + r5;
        r4 = (double) r4;	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r6 <= 0) goto L_0x004c;
    L_0x004b:
        goto L_0x0066;
    L_0x004c:
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r4.<init>(r3);	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r0.put(r4);	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r3 = java.lang.Integer.valueOf(r1);	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r3 = r9.contains(r3);	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        if (r3 != 0) goto L_0x0025;
    L_0x005e:
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        r9.add(r1);	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        goto L_0x0025;
    L_0x0066:
        r2.setTransactionSuccessful();	 Catch:{ JSONException -> 0x0076, Throwable -> 0x0087, all -> 0x0074 }
        if (r8 == 0) goto L_0x006e;
    L_0x006b:
        r8.close();	 Catch:{ Throwable -> 0x008f }
    L_0x006e:
        if (r2 == 0) goto L_0x008f;
    L_0x0070:
        r2.endTransaction();	 Catch:{ Throwable -> 0x008f }
        goto L_0x008f;
    L_0x0074:
        r9 = move-exception;
        goto L_0x0096;
    L_0x0076:
        r9 = move-exception;
        goto L_0x007f;
    L_0x0078:
        r9 = move-exception;
        r8 = r1;
        goto L_0x0096;
    L_0x007b:
        r8 = r1;
        goto L_0x0087;
    L_0x007d:
        r9 = move-exception;
        r8 = r1;
    L_0x007f:
        r1 = r2;
        goto L_0x0093;
    L_0x0081:
        r9 = move-exception;
        r8 = r1;
        r2 = r8;
        goto L_0x0096;
    L_0x0085:
        r8 = r1;
        r2 = r8;
    L_0x0087:
        if (r8 == 0) goto L_0x008c;
    L_0x0089:
        r8.close();	 Catch:{ Throwable -> 0x008f }
    L_0x008c:
        if (r2 == 0) goto L_0x008f;
    L_0x008e:
        goto L_0x0070;
    L_0x008f:
        monitor-exit(r7);
        return r0;
    L_0x0091:
        r9 = move-exception;
        r8 = r1;
    L_0x0093:
        throw r9;	 Catch:{ all -> 0x0094 }
    L_0x0094:
        r9 = move-exception;
        r2 = r1;
    L_0x0096:
        if (r8 == 0) goto L_0x009b;
    L_0x0098:
        r8.close();	 Catch:{ Throwable -> 0x00a0 }
    L_0x009b:
        if (r2 == 0) goto L_0x00a0;
    L_0x009d:
        r2.endTransaction();	 Catch:{ Throwable -> 0x00a0 }
    L_0x00a0:
        throw r9;	 Catch:{ all -> 0x00a1 }
    L_0x00a1:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cy.O000000o(java.lang.String, java.util.ArrayList, double, boolean):org.json.JSONArray");
    }

    public synchronized void O000000o() {
        O00000Oo.close();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030 A:{SYNTHETIC, Splitter:B:11:0x0030} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:6:0x0027, code skipped:
            if (r1 != null) goto L_0x0037;
     */
    /* JADX WARNING: Missing block: B:17:0x0035, code skipped:
            if (r1 != null) goto L_0x0037;
     */
    /* JADX WARNING: Missing block: B:20:?, code skipped:
            r1.endTransaction();
     */
    public synchronized void O000000o(java.lang.String r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = 0;
        r1 = O00000Oo;	 Catch:{ Throwable -> 0x0034, all -> 0x002c }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x0034, all -> 0x002c }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x0035, all -> 0x002a }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0035, all -> 0x002a }
        r0.<init>();	 Catch:{ Throwable -> 0x0035, all -> 0x002a }
        r2 = "DELETE FROM ";
        r0.append(r2);	 Catch:{ Throwable -> 0x0035, all -> 0x002a }
        r0.append(r4);	 Catch:{ Throwable -> 0x0035, all -> 0x002a }
        r4 = ";";
        r0.append(r4);	 Catch:{ Throwable -> 0x0035, all -> 0x002a }
        r4 = r0.toString();	 Catch:{ Throwable -> 0x0035, all -> 0x002a }
        r1.execSQL(r4);	 Catch:{ Throwable -> 0x0035, all -> 0x002a }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0035, all -> 0x002a }
        if (r1 == 0) goto L_0x003e;
    L_0x0029:
        goto L_0x0037;
    L_0x002a:
        r4 = move-exception;
        goto L_0x002e;
    L_0x002c:
        r4 = move-exception;
        r1 = r0;
    L_0x002e:
        if (r1 == 0) goto L_0x0033;
    L_0x0030:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0033 }
    L_0x0033:
        throw r4;	 Catch:{ all -> 0x003b }
    L_0x0034:
        r1 = r0;
    L_0x0035:
        if (r1 == 0) goto L_0x003e;
    L_0x0037:
        r1.endTransaction();	 Catch:{ Throwable -> 0x003e }
        goto L_0x003e;
    L_0x003b:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x003e:
        monitor-exit(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cy.O000000o(java.lang.String):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046 A:{SYNTHETIC, Splitter:B:15:0x0046} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:10:0x003d, code skipped:
            if (r1 != null) goto L_0x004d;
     */
    /* JADX WARNING: Missing block: B:21:0x004b, code skipped:
            if (r1 != null) goto L_0x004d;
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            r1.endTransaction();
     */
    public synchronized void O000000o(java.util.ArrayList<java.lang.Integer> r5, java.lang.String r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = 0;
        r1 = O00000Oo;	 Catch:{ Throwable -> 0x004a, all -> 0x0042 }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x004a, all -> 0x0042 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r0 = 0;
    L_0x000c:
        r2 = r5.size();	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        if (r0 >= r2) goto L_0x003a;
    L_0x0012:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r2.<init>();	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r3 = "delete from ";
        r2.append(r3);	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r2.append(r6);	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r3 = " where Id='";
        r2.append(r3);	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r3 = r5.get(r0);	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r2.append(r3);	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r3 = "' ";
        r2.append(r3);	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r1.execSQL(r2);	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        r0 = r0 + 1;
        goto L_0x000c;
    L_0x003a:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x004b, all -> 0x0040 }
        if (r1 == 0) goto L_0x0054;
    L_0x003f:
        goto L_0x004d;
    L_0x0040:
        r5 = move-exception;
        goto L_0x0044;
    L_0x0042:
        r5 = move-exception;
        r1 = r0;
    L_0x0044:
        if (r1 == 0) goto L_0x0049;
    L_0x0046:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0049 }
    L_0x0049:
        throw r5;	 Catch:{ all -> 0x0051 }
    L_0x004a:
        r1 = r0;
    L_0x004b:
        if (r1 == 0) goto L_0x0054;
    L_0x004d:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0054 }
        goto L_0x0054;
    L_0x0051:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
    L_0x0054:
        monitor-exit(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cy.O000000o(java.util.ArrayList, java.lang.String):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A:{SYNTHETIC, Splitter:B:14:0x002e} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:9:0x0025, code skipped:
            if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:20:0x0033, code skipped:
            if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r1.endTransaction();
     */
    public synchronized void O000000o(org.json.JSONObject r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        if (r5 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r4);
        return;
    L_0x0005:
        r0 = 0;
        r1 = O00000Oo;	 Catch:{ Throwable -> 0x0032, all -> 0x002a }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x0032, all -> 0x002a }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2.<init>();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r3 = "_json";
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r5 = "s_e";
        r1.insert(r5, r0, r2);	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        if (r1 == 0) goto L_0x003c;
    L_0x0027:
        goto L_0x0035;
    L_0x0028:
        r5 = move-exception;
        goto L_0x002c;
    L_0x002a:
        r5 = move-exception;
        r1 = r0;
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0031 }
    L_0x0031:
        throw r5;	 Catch:{ all -> 0x0039 }
    L_0x0032:
        r1 = r0;
    L_0x0033:
        if (r1 == 0) goto L_0x003c;
    L_0x0035:
        r1.endTransaction();	 Catch:{ Throwable -> 0x003c }
        goto L_0x003c;
    L_0x0039:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
    L_0x003c:
        monitor-exit(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cy.O000000o(org.json.JSONObject):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A:{SYNTHETIC, Splitter:B:14:0x002e} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:9:0x0025, code skipped:
            if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:20:0x0033, code skipped:
            if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r1.endTransaction();
     */
    public synchronized void O00000Oo(org.json.JSONObject r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        if (r5 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r4);
        return;
    L_0x0005:
        r0 = 0;
        r1 = O00000Oo;	 Catch:{ Throwable -> 0x0032, all -> 0x002a }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x0032, all -> 0x002a }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2.<init>();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r3 = "_json";
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r5 = "auth";
        r1.insert(r5, r0, r2);	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        if (r1 == 0) goto L_0x003c;
    L_0x0027:
        goto L_0x0035;
    L_0x0028:
        r5 = move-exception;
        goto L_0x002c;
    L_0x002a:
        r5 = move-exception;
        r1 = r0;
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0031 }
    L_0x0031:
        throw r5;	 Catch:{ all -> 0x0039 }
    L_0x0032:
        r1 = r0;
    L_0x0033:
        if (r1 == 0) goto L_0x003c;
    L_0x0035:
        r1.endTransaction();	 Catch:{ Throwable -> 0x003c }
        goto L_0x003c;
    L_0x0039:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
    L_0x003c:
        monitor-exit(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cy.O00000Oo(org.json.JSONObject):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A:{SYNTHETIC, Splitter:B:14:0x002e} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:9:0x0025, code skipped:
            if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:20:0x0033, code skipped:
            if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r1.endTransaction();
     */
    public synchronized void O00000o(org.json.JSONObject r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        if (r5 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r4);
        return;
    L_0x0005:
        r0 = 0;
        r1 = O00000Oo;	 Catch:{ Throwable -> 0x0032, all -> 0x002a }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x0032, all -> 0x002a }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2.<init>();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r3 = "_json";
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r5 = "dau";
        r1.insert(r5, r0, r2);	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        if (r1 == 0) goto L_0x003c;
    L_0x0027:
        goto L_0x0035;
    L_0x0028:
        r5 = move-exception;
        goto L_0x002c;
    L_0x002a:
        r5 = move-exception;
        r1 = r0;
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0031 }
    L_0x0031:
        throw r5;	 Catch:{ all -> 0x0039 }
    L_0x0032:
        r1 = r0;
    L_0x0033:
        if (r1 == 0) goto L_0x003c;
    L_0x0035:
        r1.endTransaction();	 Catch:{ Throwable -> 0x003c }
        goto L_0x003c;
    L_0x0039:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
    L_0x003c:
        monitor-exit(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cy.O00000o(org.json.JSONObject):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A:{SYNTHETIC, Splitter:B:14:0x002e} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:9:0x0025, code skipped:
            if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:20:0x0033, code skipped:
            if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r1.endTransaction();
     */
    public synchronized void O00000o0(org.json.JSONObject r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        if (r5 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r4);
        return;
    L_0x0005:
        r0 = 0;
        r1 = O00000Oo;	 Catch:{ Throwable -> 0x0032, all -> 0x002a }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x0032, all -> 0x002a }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2.<init>();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r3 = "_json";
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r5 = "userinfo";
        r1.insert(r5, r0, r2);	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        if (r1 == 0) goto L_0x003c;
    L_0x0027:
        goto L_0x0035;
    L_0x0028:
        r5 = move-exception;
        goto L_0x002c;
    L_0x002a:
        r5 = move-exception;
        r1 = r0;
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0031 }
    L_0x0031:
        throw r5;	 Catch:{ all -> 0x0039 }
    L_0x0032:
        r1 = r0;
    L_0x0033:
        if (r1 == 0) goto L_0x003c;
    L_0x0035:
        r1.endTransaction();	 Catch:{ Throwable -> 0x003c }
        goto L_0x003c;
    L_0x0039:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
    L_0x003c:
        monitor-exit(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cy.O00000o0(org.json.JSONObject):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A:{SYNTHETIC, Splitter:B:14:0x002e} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:9:0x0025, code skipped:
            if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:20:0x0033, code skipped:
            if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Missing block: B:23:?, code skipped:
            r1.endTransaction();
     */
    public synchronized void O00000oO(org.json.JSONObject r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        if (r5 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r4);
        return;
    L_0x0005:
        r0 = 0;
        r1 = O00000Oo;	 Catch:{ Throwable -> 0x0032, all -> 0x002a }
        r1 = r1.getWritableDatabase();	 Catch:{ Throwable -> 0x0032, all -> 0x002a }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2.<init>();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r3 = "_json";
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r2.put(r3, r5);	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r5 = "stats";
        r1.insert(r5, r0, r2);	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0033, all -> 0x0028 }
        if (r1 == 0) goto L_0x003c;
    L_0x0027:
        goto L_0x0035;
    L_0x0028:
        r5 = move-exception;
        goto L_0x002c;
    L_0x002a:
        r5 = move-exception;
        r1 = r0;
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0031 }
    L_0x0031:
        throw r5;	 Catch:{ all -> 0x0039 }
    L_0x0032:
        r1 = r0;
    L_0x0033:
        if (r1 == 0) goto L_0x003c;
    L_0x0035:
        r1.endTransaction();	 Catch:{ Throwable -> 0x003c }
        goto L_0x003c;
    L_0x0039:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
    L_0x003c:
        monitor-exit(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cy.O00000oO(org.json.JSONObject):void");
    }
}
