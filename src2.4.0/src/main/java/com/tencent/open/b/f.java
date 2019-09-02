package com.tencent.open.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.utils.e;

/* compiled from: ProGuard */
public class f extends SQLiteOpenHelper {
    protected static final String[] a = new String[]{"key"};
    protected static f b;

    public f(Context context) {
        super(context, "sdk_report.db", null, 2);
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f(e.a());
            }
            fVar = b;
        }
        return fVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0075 A:{SYNTHETIC, Splitter:B:51:0x0075} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0086 A:{SYNTHETIC, Splitter:B:59:0x0086} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0058 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0065 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x006f */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00a6 A:{SYNTHETIC, Splitter:B:75:0x00a6} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006c A:{SYNTHETIC, Splitter:B:43:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0075 A:{SYNTHETIC, Splitter:B:51:0x0075} */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0084 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0062 A:{SYNTHETIC, Splitter:B:33:0x0062} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:42|(0)|45|46|47|(0)|53|(0)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:29|(0)|35|36|37|38) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:29|(0)|35|36|37|38) */
    /* JADX WARNING: Missing block: B:61:0x0089, code skipped:
            if (r1 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Missing block: B:62:0x008b, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:71:0x009f, code skipped:
            if (r1 != null) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:73:0x00a3, code skipped:
            return r0;
     */
    public synchronized java.util.List<java.io.Serializable> a(java.lang.String r12) {
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x00af }
        r0.<init>();	 Catch:{ all -> 0x00af }
        r0 = java.util.Collections.synchronizedList(r0);	 Catch:{ all -> 0x00af }
        r1 = android.text.TextUtils.isEmpty(r12);	 Catch:{ all -> 0x00af }
        if (r1 == 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r11);
        return r0;
    L_0x0012:
        r1 = r11.getReadableDatabase();	 Catch:{ all -> 0x00af }
        if (r1 != 0) goto L_0x001a;
    L_0x0018:
        monitor-exit(r11);
        return r0;
    L_0x001a:
        r10 = 0;
        r3 = "via_cgi_report";
        r4 = 0;
        r5 = "type = ?";
        r2 = 1;
        r6 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0092 }
        r2 = 0;
        r6[r2] = r12;	 Catch:{ Exception -> 0x0092 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r2 = r1;
        r12 = r2.query(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0092 }
        if (r12 == 0) goto L_0x0084;
    L_0x0030:
        r2 = r12.getCount();	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        if (r2 <= 0) goto L_0x0084;
    L_0x0036:
        r12.moveToFirst();	 Catch:{ Exception -> 0x0081, all -> 0x007f }
    L_0x0039:
        r2 = "blob";
        r2 = r12.getColumnIndex(r2);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r2 = r12.getBlob(r2);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        r2 = new java.io.ObjectInputStream;	 Catch:{ Exception -> 0x0069, all -> 0x005e }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0069, all -> 0x005e }
        r4 = r2.readObject();	 Catch:{ Exception -> 0x006a, all -> 0x005c }
        r4 = (java.io.Serializable) r4;	 Catch:{ Exception -> 0x006a, all -> 0x005c }
        if (r2 == 0) goto L_0x0058;
    L_0x0055:
        r2.close();	 Catch:{ IOException -> 0x0058 }
    L_0x0058:
        r3.close();	 Catch:{ IOException -> 0x0073 }
        goto L_0x0073;
    L_0x005c:
        r4 = move-exception;
        goto L_0x0060;
    L_0x005e:
        r4 = move-exception;
        r2 = r10;
    L_0x0060:
        if (r2 == 0) goto L_0x0065;
    L_0x0062:
        r2.close();	 Catch:{ IOException -> 0x0065 }
    L_0x0065:
        r3.close();	 Catch:{ IOException -> 0x0068 }
    L_0x0068:
        throw r4;	 Catch:{ Exception -> 0x0081, all -> 0x007f }
    L_0x0069:
        r2 = r10;
    L_0x006a:
        if (r2 == 0) goto L_0x006f;
    L_0x006c:
        r2.close();	 Catch:{ IOException -> 0x006f }
    L_0x006f:
        r3.close();	 Catch:{ IOException -> 0x0072 }
    L_0x0072:
        r4 = r10;
    L_0x0073:
        if (r4 == 0) goto L_0x0078;
    L_0x0075:
        r0.add(r4);	 Catch:{ Exception -> 0x0081, all -> 0x007f }
    L_0x0078:
        r2 = r12.moveToNext();	 Catch:{ Exception -> 0x0081, all -> 0x007f }
        if (r2 != 0) goto L_0x0039;
    L_0x007e:
        goto L_0x0084;
    L_0x007f:
        r0 = move-exception;
        goto L_0x00a4;
    L_0x0081:
        r2 = move-exception;
        r10 = r12;
        goto L_0x0093;
    L_0x0084:
        if (r12 == 0) goto L_0x0089;
    L_0x0086:
        r12.close();	 Catch:{ all -> 0x00af }
    L_0x0089:
        if (r1 == 0) goto L_0x00a2;
    L_0x008b:
        r1.close();	 Catch:{ all -> 0x00af }
        goto L_0x00a2;
    L_0x008f:
        r0 = move-exception;
        r12 = r10;
        goto L_0x00a4;
    L_0x0092:
        r2 = move-exception;
    L_0x0093:
        r12 = "openSDK_LOG.ReportDatabaseHelper";
        r3 = "getReportItemFromDB has exception.";
        com.tencent.open.a.f.b(r12, r3, r2);	 Catch:{ all -> 0x008f }
        if (r10 == 0) goto L_0x009f;
    L_0x009c:
        r10.close();	 Catch:{ all -> 0x00af }
    L_0x009f:
        if (r1 == 0) goto L_0x00a2;
    L_0x00a1:
        goto L_0x008b;
    L_0x00a2:
        monitor-exit(r11);
        return r0;
    L_0x00a4:
        if (r12 == 0) goto L_0x00a9;
    L_0x00a6:
        r12.close();	 Catch:{ all -> 0x00af }
    L_0x00a9:
        if (r1 == 0) goto L_0x00ae;
    L_0x00ab:
        r1.close();	 Catch:{ all -> 0x00af }
    L_0x00ae:
        throw r0;	 Catch:{ all -> 0x00af }
    L_0x00af:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.f.a(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x005c */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0063 A:{SYNTHETIC, Splitter:B:51:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0059 A:{SYNTHETIC, Splitter:B:41:0x0059} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0067 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0089 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x004f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x005f */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:26|27|(5:28|29|30|31|(2:33|34))|35|36|53|54|78) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:26|27|(5:28|29|30|31|(2:33|34))|35|36|53|54|78) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:37|38|(0)|43|44|45|46|62|63|64|65) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:37|38|(0)|43|44|45|46|62|63|64|65) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:37|38|(0)|43|44|45|46|62|63|64|65) */
    /* JADX WARNING: Missing block: B:59:0x0081, code skipped:
            if (r1 != null) goto L_0x0083;
     */
    /* JADX WARNING: Missing block: B:60:0x0083, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:66:0x0093, code skipped:
            if (r1 == null) goto L_0x0096;
     */
    /* JADX WARNING: Missing block: B:68:0x0097, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:70:?, code skipped:
            r1.endTransaction();
     */
    /* JADX WARNING: Missing block: B:71:0x009b, code skipped:
            if (r1 != null) goto L_0x009d;
     */
    /* JADX WARNING: Missing block: B:72:0x009d, code skipped:
            r1.close();
     */
    public synchronized void a(java.lang.String r9, java.util.List<java.io.Serializable> r10) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r10.size();	 Catch:{ all -> 0x00a1 }
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r8);
        return;
    L_0x0009:
        r1 = 20;
        if (r0 > r1) goto L_0x000e;
    L_0x000d:
        goto L_0x000f;
    L_0x000e:
        r0 = r1;
    L_0x000f:
        r1 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r8);
        return;
    L_0x0017:
        r8.b(r9);	 Catch:{ all -> 0x00a1 }
        r1 = r8.getWritableDatabase();	 Catch:{ all -> 0x00a1 }
        if (r1 != 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r8);
        return;
    L_0x0022:
        r1.beginTransaction();	 Catch:{ all -> 0x00a1 }
        r2 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0089 }
        r2.<init>();	 Catch:{ Exception -> 0x0089 }
        r3 = 0;
    L_0x002b:
        if (r3 >= r0) goto L_0x007b;
    L_0x002d:
        r4 = r10.get(r3);	 Catch:{ Exception -> 0x0089 }
        r4 = (java.io.Serializable) r4;	 Catch:{ Exception -> 0x0089 }
        if (r4 == 0) goto L_0x0075;
    L_0x0035:
        r5 = "type";
        r2.put(r5, r9);	 Catch:{ Exception -> 0x0089 }
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0089 }
        r6 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        r5.<init>(r6);	 Catch:{ Exception -> 0x0089 }
        r6 = 0;
        r7 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x0060, all -> 0x0056 }
        r7.<init>(r5);	 Catch:{ IOException -> 0x0060, all -> 0x0056 }
        r7.writeObject(r4);	 Catch:{ IOException -> 0x0061, all -> 0x0053 }
        if (r7 == 0) goto L_0x004f;
    L_0x004c:
        r7.close();	 Catch:{ IOException -> 0x004f }
    L_0x004f:
        r5.close();	 Catch:{ IOException -> 0x0067 }
        goto L_0x0067;
    L_0x0053:
        r9 = move-exception;
        r6 = r7;
        goto L_0x0057;
    L_0x0056:
        r9 = move-exception;
    L_0x0057:
        if (r6 == 0) goto L_0x005c;
    L_0x0059:
        r6.close();	 Catch:{ IOException -> 0x005c }
    L_0x005c:
        r5.close();	 Catch:{ IOException -> 0x005f }
    L_0x005f:
        throw r9;	 Catch:{ Exception -> 0x0089 }
    L_0x0060:
        r7 = r6;
    L_0x0061:
        if (r7 == 0) goto L_0x004f;
    L_0x0063:
        r7.close();	 Catch:{ IOException -> 0x004f }
        goto L_0x004f;
    L_0x0067:
        r4 = "blob";
        r5 = r5.toByteArray();	 Catch:{ Exception -> 0x0089 }
        r2.put(r4, r5);	 Catch:{ Exception -> 0x0089 }
        r4 = "via_cgi_report";
        r1.insert(r4, r6, r2);	 Catch:{ Exception -> 0x0089 }
    L_0x0075:
        r2.clear();	 Catch:{ Exception -> 0x0089 }
        r3 = r3 + 1;
        goto L_0x002b;
    L_0x007b:
        r1.setTransactionSuccessful();	 Catch:{ Exception -> 0x0089 }
        r1.endTransaction();	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x0096;
    L_0x0083:
        r1.close();	 Catch:{ all -> 0x00a1 }
        goto L_0x0096;
    L_0x0087:
        r9 = move-exception;
        goto L_0x0098;
    L_0x0089:
        r9 = "openSDK_LOG.ReportDatabaseHelper";
        r10 = "saveReportItemToDB has exception.";
        com.tencent.open.a.f.e(r9, r10);	 Catch:{ all -> 0x0087 }
        r1.endTransaction();	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x0096;
    L_0x0095:
        goto L_0x0083;
    L_0x0096:
        monitor-exit(r8);
        return;
    L_0x0098:
        r1.endTransaction();	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x00a0;
    L_0x009d:
        r1.close();	 Catch:{ all -> 0x00a1 }
    L_0x00a0:
        throw r9;	 Catch:{ all -> 0x00a1 }
    L_0x00a1:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.f.a(java.lang.String, java.util.List):void");
    }

    /* JADX WARNING: Missing block: B:13:0x001e, code skipped:
            if (r0 != null) goto L_0x0020;
     */
    /* JADX WARNING: Missing block: B:15:?, code skipped:
            r0.close();
     */
    /* JADX WARNING: Missing block: B:20:0x002e, code skipped:
            if (r0 == null) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:22:0x0032, code skipped:
            return;
     */
    public synchronized void b(java.lang.String r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0039 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r5);
        return;
    L_0x0009:
        r0 = r5.getWritableDatabase();	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r5);
        return;
    L_0x0011:
        r1 = "via_cgi_report";
        r2 = "type = ?";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x0026 }
        r4 = 0;
        r3[r4] = r6;	 Catch:{ Exception -> 0x0026 }
        r0.delete(r1, r2, r3);	 Catch:{ Exception -> 0x0026 }
        if (r0 == 0) goto L_0x0031;
    L_0x0020:
        r0.close();	 Catch:{ all -> 0x0039 }
        goto L_0x0031;
    L_0x0024:
        r6 = move-exception;
        goto L_0x0033;
    L_0x0026:
        r6 = move-exception;
        r1 = "openSDK_LOG.ReportDatabaseHelper";
        r2 = "clearReportItem has exception.";
        com.tencent.open.a.f.b(r1, r2, r6);	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0031;
    L_0x0030:
        goto L_0x0020;
    L_0x0031:
        monitor-exit(r5);
        return;
    L_0x0033:
        if (r0 == 0) goto L_0x0038;
    L_0x0035:
        r0.close();	 Catch:{ all -> 0x0039 }
    L_0x0038:
        throw r6;	 Catch:{ all -> 0x0039 }
    L_0x0039:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.f.b(java.lang.String):void");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }
}
