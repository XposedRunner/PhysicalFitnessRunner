package cn.jpush.android.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public final class d extends f {
    private static final String[] a = new String[]{"_id", "ln_id", "ln_count", "ln_remove", "ln_type", "ln_extra", "ln_trigger_time", "ln_add_time"};
    private static volatile d b;
    private static final Object c = new Object();

    private d(Context context) {
        super(context, "jpush_local_notification.db", null, 1);
    }

    public static d a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new d(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public static e a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return null;
        }
        try {
            e eVar = new e();
            eVar.a(cursor.getLong(1));
            eVar.a(cursor.getInt(2));
            eVar.b(cursor.getInt(3));
            eVar.c(cursor.getInt(4));
            eVar.a(cursor.getString(5));
            eVar.c(cursor.getLong(6));
            eVar.b(cursor.getLong(7));
            return eVar;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public final int a(long j) {
        if (a(true)) {
            int e;
            try {
                StringBuilder stringBuilder = new StringBuilder("ln_id=");
                stringBuilder.append(j);
                e = getWritableDatabase().delete("t_localnotification", stringBuilder.toString(), null);
                return e;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            } finally {
                b(true);
            }
        }
        return 0;
    }

    public final long a(long j, int i, int i2, int i3, String str, long j2, long j3) {
        if (a(true)) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j));
                contentValues.put("ln_count", Integer.valueOf(1));
                contentValues.put("ln_remove", Integer.valueOf(0));
                contentValues.put("ln_type", Integer.valueOf(0));
                contentValues.put("ln_extra", str);
                contentValues.put("ln_trigger_time", Long.valueOf(j2));
                contentValues.put("ln_add_time", Long.valueOf(j3));
                j = getWritableDatabase().insert("t_localnotification", null, contentValues);
                return j;
            } catch (Exception e) {
                j = e;
                j.printStackTrace();
            } finally {
                b(true);
            }
        }
        return 0;
    }

    public final Cursor a(int i, long j) {
        StringBuilder stringBuilder = new StringBuilder("ln_count=");
        stringBuilder.append(1);
        stringBuilder.append(" and ln_trigger_time");
        stringBuilder.append("<");
        stringBuilder.append(j);
        try {
            return getReadableDatabase().query(true, "t_localnotification", a, stringBuilder.toString(), null, null, null, null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public final Cursor a(long j, long j2) {
        long j3 = j + 300000;
        StringBuilder stringBuilder = new StringBuilder("ln_count>0 and ln_trigger_time<");
        stringBuilder.append(j3);
        stringBuilder.append(" and ln_trigger_time");
        stringBuilder.append(">");
        stringBuilder.append(j);
        try {
            return getReadableDatabase().query(true, "t_localnotification", a, stringBuilder.toString(), null, null, null, null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    public final cn.jpush.android.data.e a(long r13, int r15) {
        /*
        r12 = this;
        r15 = 0;
        r0 = r12.a(r15);
        if (r0 == 0) goto L_0x0052;
    L_0x0007:
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0048 }
        r2 = "ln_id=";
        r1.<init>(r2);	 Catch:{ all -> 0x0048 }
        r1.append(r13);	 Catch:{ all -> 0x0048 }
        r13 = " and ln_type";
        r1.append(r13);	 Catch:{ all -> 0x0048 }
        r13 = "=0";
        r1.append(r13);	 Catch:{ all -> 0x0048 }
        r6 = r1.toString();	 Catch:{ all -> 0x0048 }
        r2 = r12.getReadableDatabase();	 Catch:{ all -> 0x0048 }
        r3 = 1;
        r4 = "t_localnotification";
        r5 = a;	 Catch:{ all -> 0x0048 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ all -> 0x0048 }
        if (r13 == 0) goto L_0x003b;
    L_0x0034:
        r13.moveToFirst();	 Catch:{ all -> 0x0038 }
        goto L_0x003b;
    L_0x0038:
        r14 = move-exception;
        r0 = r13;
        goto L_0x0049;
    L_0x003b:
        r14 = a(r13);	 Catch:{ all -> 0x0038 }
        if (r13 == 0) goto L_0x0044;
    L_0x0041:
        r13.close();
    L_0x0044:
        r12.b(r15);
        return r14;
    L_0x0048:
        r14 = move-exception;
    L_0x0049:
        if (r0 == 0) goto L_0x004e;
    L_0x004b:
        r0.close();
    L_0x004e:
        r12.b(r15);
        throw r14;
    L_0x0052:
        r13 = new java.lang.Exception;
        r14 = "open database failed";
        r13.<init>(r14);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.d.a(long, int):cn.jpush.android.data.e");
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045 A:{Splitter:B:6:0x0023, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:16:0x0045, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:17:0x0046, code skipped:
            r2 = false;
     */
    /* JADX WARNING: Missing block: B:18:0x0048, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:19:0x0049, code skipped:
            r1 = r11;
     */
    /* JADX WARNING: Missing block: B:46:0x0081, code skipped:
            r11.close();
     */
    /* JADX WARNING: Missing block: B:49:0x0089, code skipped:
            b(true);
     */
    /* JADX WARNING: Missing block: B:55:0x0093, code skipped:
            r0.close();
     */
    /* JADX WARNING: Missing block: B:58:0x009b, code skipped:
            b(true);
     */
    public final int[] a() {
        /*
        r13 = this;
        r4 = "1";
        r10 = 0;
        r0 = r13.a(r10);
        r11 = 0;
        if (r0 == 0) goto L_0x009f;
    L_0x000a:
        r12 = 1;
        r3 = new java.lang.String[r12];	 Catch:{ Exception -> 0x0079, all -> 0x0075 }
        r0 = "ln_id";
        r3[r10] = r0;	 Catch:{ Exception -> 0x0079, all -> 0x0075 }
        r0 = r13.getReadableDatabase();	 Catch:{ Exception -> 0x0079, all -> 0x0075 }
        r1 = 1;
        r2 = "t_localnotification";
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0079, all -> 0x0075 }
        if (r0 == 0) goto L_0x004d;
    L_0x0023:
        r1 = r0.getCount();	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        if (r1 <= 0) goto L_0x004d;
    L_0x0029:
        r1 = r0.getCount();	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r1 = new int[r1];	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r0.moveToFirst();	 Catch:{ Exception -> 0x0043, all -> 0x0045 }
        r2 = r10;
    L_0x0033:
        r3 = r0.getInt(r10);	 Catch:{ Exception -> 0x0043, all -> 0x0045 }
        r1[r2] = r3;	 Catch:{ Exception -> 0x0043, all -> 0x0045 }
        r2 = r2 + 1;
        r3 = r0.moveToNext();	 Catch:{ Exception -> 0x0043, all -> 0x0045 }
        if (r3 != 0) goto L_0x0033;
    L_0x0041:
        r11 = r1;
        goto L_0x004d;
    L_0x0043:
        r2 = move-exception;
        goto L_0x004a;
    L_0x0045:
        r1 = move-exception;
        r2 = r10;
        goto L_0x0091;
    L_0x0048:
        r2 = move-exception;
        r1 = r11;
    L_0x004a:
        r11 = r0;
        r0 = r10;
        goto L_0x007c;
    L_0x004d:
        r1 = r13.a(r12);	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        if (r1 == 0) goto L_0x0066;
    L_0x0053:
        r1 = "delete from t_localnotification";
        r2 = r13.getWritableDatabase();	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r2.execSQL(r1);	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r1 = r12;
        goto L_0x0067;
    L_0x005e:
        r1 = move-exception;
        r2 = r12;
        goto L_0x0091;
    L_0x0061:
        r2 = move-exception;
        r1 = r11;
        r11 = r0;
        r0 = r12;
        goto L_0x007c;
    L_0x0066:
        r1 = r10;
    L_0x0067:
        if (r0 == 0) goto L_0x006c;
    L_0x0069:
        r0.close();
    L_0x006c:
        r13.b(r10);
        if (r1 == 0) goto L_0x009f;
    L_0x0071:
        r13.b(r12);
        return r11;
    L_0x0075:
        r1 = move-exception;
        r2 = r10;
    L_0x0077:
        r0 = r11;
        goto L_0x0091;
    L_0x0079:
        r2 = move-exception;
        r0 = r10;
        r1 = r11;
    L_0x007c:
        r2.printStackTrace();	 Catch:{ all -> 0x008e }
        if (r11 == 0) goto L_0x0084;
    L_0x0081:
        r11.close();
    L_0x0084:
        r13.b(r10);
        if (r0 == 0) goto L_0x008c;
    L_0x0089:
        r13.b(r12);
    L_0x008c:
        r11 = r1;
        return r11;
    L_0x008e:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0077;
    L_0x0091:
        if (r0 == 0) goto L_0x0096;
    L_0x0093:
        r0.close();
    L_0x0096:
        r13.b(r10);
        if (r2 == 0) goto L_0x009e;
    L_0x009b:
        r13.b(r12);
    L_0x009e:
        throw r1;
    L_0x009f:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.data.d.a():int[]");
    }

    public final long b(long j, int i, int i2, int i3, String str, long j2, long j3) {
        if (a(true)) {
            try {
                StringBuilder stringBuilder = new StringBuilder("ln_id=");
                stringBuilder.append(j);
                String stringBuilder2 = stringBuilder.toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j));
                contentValues.put("ln_count", Integer.valueOf(i));
                contentValues.put("ln_remove", Integer.valueOf(i2));
                contentValues.put("ln_type", Integer.valueOf(0));
                contentValues.put("ln_extra", str);
                contentValues.put("ln_trigger_time", Long.valueOf(j2));
                contentValues.put("ln_add_time", Long.valueOf(j3));
                j = (long) getWritableDatabase().update("t_localnotification", contentValues, stringBuilder2, null);
                return j;
            } catch (Exception e) {
                j = e;
                j.printStackTrace();
            } finally {
                b(true);
            }
        }
        return 0;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE t_localnotification (_id INTEGER PRIMARY KEY AUTOINCREMENT ,ln_id long not null,ln_count integer not null,ln_remove integer not null,ln_type integer not null,ln_extra text ,ln_trigger_time long ,ln_add_time long );");
        } catch (Exception unused) {
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_localnotification");
        onCreate(sQLiteDatabase);
    }
}
