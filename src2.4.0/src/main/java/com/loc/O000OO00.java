package com.loc;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import s.h.e.l.l.C;

/* compiled from: DB */
public final class O000OO00 extends SQLiteOpenHelper {
    private static boolean O00000Oo = true;
    private static boolean O00000o0;
    private O000O0o0 O000000o;

    /* compiled from: DB */
    public static class O000000o extends ContextWrapper {
        private String O000000o;
        private Context O00000Oo;

        public O000000o(Context context, String str) {
            super(context);
            this.O000000o = str;
            this.O00000Oo = context;
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0086 */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing block: B:22:?, code skipped:
            com.loc.O000OO00.O00000o();
     */
        public final java.io.File getDatabasePath(java.lang.String r5) {
            /*
            r4 = this;
            r0 = com.loc.O000OO00.O00000Oo;	 Catch:{ Throwable -> 0x00a0 }
            if (r0 == 0) goto L_0x009b;
        L_0x0006:
            r0 = r4.O00000Oo;	 Catch:{ Throwable -> 0x00a0 }
            r1 = "android.permission.WRITE_EXTERNAL_STORAGE";
            r0 = com.loc.OO0o000.O000000o(r0, r1);	 Catch:{ Throwable -> 0x00a0 }
            if (r0 != 0) goto L_0x0012;
        L_0x0010:
            goto L_0x009b;
        L_0x0012:
            r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a0 }
            r0.<init>();	 Catch:{ Throwable -> 0x00a0 }
            r1 = r4.O000000o;	 Catch:{ Throwable -> 0x00a0 }
            r0.append(r1);	 Catch:{ Throwable -> 0x00a0 }
            r1 = "/";
            r0.append(r1);	 Catch:{ Throwable -> 0x00a0 }
            r0.append(r5);	 Catch:{ Throwable -> 0x00a0 }
            r0 = r0.toString();	 Catch:{ Throwable -> 0x00a0 }
            r1 = new java.io.File;	 Catch:{ Throwable -> 0x00a0 }
            r2 = r4.O000000o;	 Catch:{ Throwable -> 0x00a0 }
            r1.<init>(r2);	 Catch:{ Throwable -> 0x00a0 }
            r2 = r1.exists();	 Catch:{ Throwable -> 0x00a0 }
            if (r2 != 0) goto L_0x0038;
        L_0x0035:
            r1.mkdirs();	 Catch:{ Throwable -> 0x00a0 }
        L_0x0038:
            r1 = com.loc.O000OO00.O00000o0;	 Catch:{ Throwable -> 0x00a0 }
            if (r1 == 0) goto L_0x0044;
        L_0x003e:
            r1 = com.loc.O000OO00.O00000Oo;	 Catch:{ Throwable -> 0x00a0 }
            if (r1 != 0) goto L_0x0074;
        L_0x0044:
            com.loc.O000OO00.O00000o0 = true;	 Catch:{ Throwable -> 0x00a0 }
            r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a0 }
            r1.<init>();	 Catch:{ Throwable -> 0x00a0 }
            r2 = r4.O000000o;	 Catch:{ Throwable -> 0x00a0 }
            r1.append(r2);	 Catch:{ Throwable -> 0x00a0 }
            r2 = java.io.File.separator;	 Catch:{ Throwable -> 0x00a0 }
            r1.append(r2);	 Catch:{ Throwable -> 0x00a0 }
            r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00a0 }
            r1.append(r2);	 Catch:{ Throwable -> 0x00a0 }
            r2 = ".db";
            r1.append(r2);	 Catch:{ Throwable -> 0x00a0 }
            r1 = r1.toString();	 Catch:{ Throwable -> 0x00a0 }
            r2 = new java.io.File;	 Catch:{ Throwable -> 0x00a0 }
            r2.<init>(r1);	 Catch:{ Throwable -> 0x00a0 }
            r1 = r2.createNewFile();	 Catch:{ Throwable -> 0x00a0 }
            if (r1 == 0) goto L_0x0093;
        L_0x0071:
            r2.delete();	 Catch:{ Throwable -> 0x00a0 }
        L_0x0074:
            r1 = 0;
            r2 = new java.io.File;	 Catch:{ Throwable -> 0x00a0 }
            r2.<init>(r0);	 Catch:{ Throwable -> 0x00a0 }
            r0 = r2.exists();	 Catch:{ Throwable -> 0x00a0 }
            if (r0 != 0) goto L_0x008a;
        L_0x0080:
            r0 = r2.createNewFile();	 Catch:{ IOException -> 0x0086 }
            r1 = r0;
            goto L_0x008b;
        L_0x0086:
            com.loc.O000OO00.O00000Oo = false;	 Catch:{ Throwable -> 0x00a0 }
            goto L_0x008b;
        L_0x008a:
            r1 = 1;
        L_0x008b:
            if (r1 == 0) goto L_0x008e;
        L_0x008d:
            return r2;
        L_0x008e:
            r0 = super.getDatabasePath(r5);	 Catch:{ Throwable -> 0x00a0 }
            return r0;
        L_0x0093:
            com.loc.O000OO00.O00000Oo = false;	 Catch:{ Throwable -> 0x00a0 }
            r0 = super.getDatabasePath(r5);	 Catch:{ Throwable -> 0x00a0 }
            return r0;
        L_0x009b:
            r0 = super.getDatabasePath(r5);	 Catch:{ Throwable -> 0x00a0 }
            return r0;
        L_0x00a0:
            com.loc.O000OO00.O00000Oo = false;
            r5 = super.getDatabasePath(r5);
            return r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.O000OO00$O000000o.getDatabasePath(java.lang.String):java.io.File");
        }

        public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
            if (getDatabasePath(str) != null) {
                SQLiteDatabase openOrCreateDatabase;
                try {
                    openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), null);
                } catch (Throwable unused) {
                    openOrCreateDatabase = null;
                }
                if (openOrCreateDatabase != null) {
                    return openOrCreateDatabase;
                }
            }
            return SQLiteDatabase.openOrCreateDatabase(this.O00000Oo.getApplicationContext().getDatabasePath(str), null);
        }

        public final SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
            if (getDatabasePath(str) != null) {
                SQLiteDatabase openOrCreateDatabase;
                try {
                    openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), null);
                } catch (Throwable unused) {
                    openOrCreateDatabase = null;
                }
                if (openOrCreateDatabase != null) {
                    return openOrCreateDatabase;
                }
            }
            return SQLiteDatabase.openOrCreateDatabase(this.O00000Oo.getApplicationContext().getDatabasePath(str), null);
        }
    }

    static {
        C.i(20);
    }

    public O000OO00(Context context, String str, O000O0o0 o000O0o0) {
        super(context, str, null, 1);
        this.O000000o = o000O0o0;
    }

    public final native void onCreate(SQLiteDatabase sQLiteDatabase);

    public final native void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
}
