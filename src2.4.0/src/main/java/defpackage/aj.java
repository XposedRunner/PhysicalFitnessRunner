package defpackage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import defpackage.ai.O000000o;
import defpackage.ai.O00000Oo;
import defpackage.ai.O00000o;
import defpackage.ai.O00000o0;

/* compiled from: UMDBCreater */
/* renamed from: aj */
class aj extends SQLiteOpenHelper {
    private static Context O00000Oo;
    private String O000000o;

    /* compiled from: UMDBCreater */
    /* renamed from: aj$O000000o */
    private static class O000000o {
        private static final aj O000000o = new aj(aj.O00000Oo, al.O00000Oo(aj.O00000Oo), ai.O00000Oo, null, 2);

        private O000000o() {
        }
    }

    private aj(Context context, String str, CursorFactory cursorFactory, int i) {
        if (TextUtils.isEmpty(str)) {
            str = ai.O00000Oo;
        }
        super(context, str, cursorFactory, i);
        this.O000000o = null;
        O000000o();
    }

    private aj(Context context, String str, String str2, CursorFactory cursorFactory, int i) {
        this(new ag(context, str), str2, cursorFactory, i);
    }

    public static aj O000000o(Context context) {
        if (O00000Oo == null) {
            O00000Oo = context.getApplicationContext();
        }
        return O000000o.O000000o;
    }

    private void O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            this.O000000o = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.O000000o);
        } catch (SQLException unused) {
        }
    }

    private void O000000o(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DROP TABLE IF EXISTS ");
            stringBuilder.append(str);
            sQLiteDatabase.execSQL(stringBuilder.toString());
        } catch (SQLException unused) {
        }
    }

    private void O00000Oo(SQLiteDatabase sQLiteDatabase) {
        try {
            this.O000000o = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.O000000o);
        } catch (SQLException unused) {
        }
    }

    private void O00000o(SQLiteDatabase sQLiteDatabase) {
        try {
            this.O000000o = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.O000000o);
        } catch (SQLException unused) {
        }
    }

    private void O00000o0(SQLiteDatabase sQLiteDatabase) {
        try {
            this.O000000o = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL(this.O000000o);
        } catch (SQLException unused) {
        }
    }

    private void O00000oO(SQLiteDatabase sQLiteDatabase) {
        if (!al.O000000o(sQLiteDatabase, O00000o.O000000o, "__av")) {
            al.O000000o(sQLiteDatabase, O00000o.O000000o, "__sp", "TEXT");
            al.O000000o(sQLiteDatabase, O00000o.O000000o, "__pp", "TEXT");
            al.O000000o(sQLiteDatabase, O00000o.O000000o, "__av", "TEXT");
            al.O000000o(sQLiteDatabase, O00000o.O000000o, "__vc", "TEXT");
        }
        if (!al.O000000o(sQLiteDatabase, O00000Oo.O000000o, "__av")) {
            al.O000000o(sQLiteDatabase, O00000Oo.O000000o, "__av", "TEXT");
            al.O000000o(sQLiteDatabase, O00000Oo.O000000o, "__vc", "TEXT");
        }
        if (!al.O000000o(sQLiteDatabase, O000000o.O000000o, "__av")) {
            al.O000000o(sQLiteDatabase, O000000o.O000000o, "__av", "TEXT");
            al.O000000o(sQLiteDatabase, O000000o.O000000o, "__vc", "TEXT");
        }
    }

    private void O00000oo(SQLiteDatabase sQLiteDatabase) {
        O000000o(sQLiteDatabase, O00000o.O000000o);
        O000000o(sQLiteDatabase, O00000Oo.O000000o);
        O000000o(sQLiteDatabase, O000000o.O000000o);
        O000000o();
    }

    public void O000000o() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!al.O000000o(O00000o.O000000o, writableDatabase)) {
                O00000o0(writableDatabase);
            }
            if (!al.O000000o(O00000o0.O000000o, writableDatabase)) {
                O00000o(writableDatabase);
            }
            if (!al.O000000o(O00000Oo.O000000o, writableDatabase)) {
                O00000Oo(writableDatabase);
            }
            if (!al.O000000o(O000000o.O000000o, writableDatabase)) {
                O000000o(writableDatabase);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001d */
    public void onCreate(android.database.sqlite.SQLiteDatabase r2) {
        /*
        r1 = this;
        r2.beginTransaction();	 Catch:{ SQLiteDatabaseCorruptException -> 0x001d, Throwable -> 0x001a }
        r1.O00000o0(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x001d, Throwable -> 0x001a }
        r1.O00000o(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x001d, Throwable -> 0x001a }
        r1.O00000Oo(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x001d, Throwable -> 0x001a }
        r1.O000000o(r2);	 Catch:{ SQLiteDatabaseCorruptException -> 0x001d, Throwable -> 0x001a }
        r2.setTransactionSuccessful();	 Catch:{ SQLiteDatabaseCorruptException -> 0x001d, Throwable -> 0x001a }
        if (r2 == 0) goto L_0x0025;
    L_0x0014:
        r2.endTransaction();	 Catch:{ Throwable -> 0x0025 }
        goto L_0x0025;
    L_0x0018:
        r0 = move-exception;
        goto L_0x0026;
    L_0x001a:
        if (r2 == 0) goto L_0x0025;
    L_0x001c:
        goto L_0x0014;
    L_0x001d:
        r0 = O00000Oo;	 Catch:{ all -> 0x0018 }
        defpackage.al.O000000o(r0);	 Catch:{ all -> 0x0018 }
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        goto L_0x0014;
    L_0x0025:
        return;
    L_0x0026:
        if (r2 == 0) goto L_0x002b;
    L_0x0028:
        r2.endTransaction();	 Catch:{ Throwable -> 0x002b }
    L_0x002b:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aj.onCreate(android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0009 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:3|4|5|6|13) */
    /* JADX WARNING: Missing block: B:7:0x000d, code skipped:
            O00000oo(r1);
     */
    /* JADX WARNING: Missing block: B:9:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:12:?, code skipped:
            return;
     */
    public void onUpgrade(android.database.sqlite.SQLiteDatabase r1, int r2, int r3) {
        /*
        r0 = this;
        if (r3 <= r2) goto L_0x0010;
    L_0x0002:
        r3 = 1;
        if (r2 != r3) goto L_0x0010;
    L_0x0005:
        r0.O00000oO(r1);	 Catch:{ Exception -> 0x0009 }
        goto L_0x0010;
    L_0x0009:
        r0.O00000oO(r1);	 Catch:{ Exception -> 0x000d }
        goto L_0x0010;
    L_0x000d:
        r0.O00000oo(r1);
    L_0x0010:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aj.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }
}
