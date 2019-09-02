package com.qiyukf.nimlib.c.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import cn.jiguang.net.HttpUtils;
import java.io.File;

public abstract class a {
    protected final int a;
    protected SQLiteDatabase b;
    private boolean c;
    private Context d;
    private String e;

    public a(Context context, String str) {
        this(context, str, (byte) 0);
    }

    private a(Context context, String str, byte b) {
        StringBuilder stringBuilder;
        this.d = context;
        this.e = str;
        this.a = 4;
        this.c = true;
        StringBuilder stringBuilder2 = new StringBuilder("open database: ");
        stringBuilder2.append(this.e.substring(this.e.lastIndexOf(HttpUtils.PATHS_SEPARATOR) + 1));
        com.qiyukf.basesdk.a.a.a("db", stringBuilder2.toString());
        String str2;
        int i;
        StringBuilder stringBuilder3;
        if (this.c) {
            str2 = this.e;
            i = this.a;
            try {
                this.b = SQLiteDatabase.openOrCreateDatabase(c(str2), null);
            } catch (SQLiteException e) {
                stringBuilder = new StringBuilder("error=");
                stringBuilder.append(e.getLocalizedMessage());
                com.qiyukf.basesdk.a.a.a("db", stringBuilder.toString());
            }
            int version = this.b.getVersion();
            if (version != i) {
                this.b.beginTransaction();
                if (version == 0) {
                    try {
                        stringBuilder3 = new StringBuilder("create database ");
                        stringBuilder3.append(str2);
                        com.qiyukf.basesdk.a.a.a("db", stringBuilder3.toString());
                        a().a(this.b, this.a);
                    } catch (Exception e2) {
                        stringBuilder3 = new StringBuilder("create or upgrade database ");
                        stringBuilder3.append(str2);
                        stringBuilder3.append(" error: ");
                        stringBuilder3.append(e2);
                        com.qiyukf.basesdk.a.a.c("db", stringBuilder3.toString());
                        this.b.endTransaction();
                        return;
                    } catch (Throwable th) {
                        this.b.endTransaction();
                    }
                } else if (version < i) {
                    stringBuilder = new StringBuilder("upgrade database ");
                    stringBuilder.append(str2);
                    stringBuilder.append(" from ");
                    stringBuilder.append(version);
                    stringBuilder.append(" to ");
                    stringBuilder.append(i);
                    com.qiyukf.basesdk.a.a.a("db", stringBuilder.toString());
                    a().a(this.b, version, i);
                }
                this.b.setVersion(i);
                this.b.setTransactionSuccessful();
                this.b.endTransaction();
                return;
            }
            return;
        }
        str2 = this.e;
        i = this.a;
        try {
            this.b = SQLiteDatabase.openDatabase(c(str2), null, 0);
            if (this.b.getVersion() < i) {
                this.b.close();
                this.b = null;
            }
        } catch (SQLiteException e3) {
            stringBuilder3 = new StringBuilder("open database ");
            stringBuilder3.append(str2);
            stringBuilder3.append(" only failed: ");
            stringBuilder3.append(e3);
            com.qiyukf.basesdk.a.a.a("db", stringBuilder3.toString());
        }
    }

    private String c(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d.getApplicationInfo().dataDir);
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(str);
        str = stringBuilder.toString();
        File file = new File(str);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        StringBuilder stringBuilder2 = new StringBuilder("ready to open db, path=");
        stringBuilder2.append(str);
        Log.i("db", stringBuilder2.toString());
        return str;
    }

    public final int a(String str, ContentValues contentValues, String str2, String[] strArr) {
        return this.b != null ? b.a(this.b, str, contentValues, str2, strArr) : -1;
    }

    public final long a(String str, ContentValues contentValues) {
        return this.b != null ? b.a(this.b, str, contentValues) : -1;
    }

    public abstract c a();

    public final void a(String str) {
        boolean z;
        if (this.b != null) {
            SQLiteDatabase sQLiteDatabase = this.b;
            int i = 0;
            while (i < 3) {
                boolean z2;
                try {
                    sQLiteDatabase.execSQL(str);
                    z2 = true;
                    z = false;
                } catch (SQLiteException e) {
                    e.printStackTrace();
                    StringBuilder stringBuilder = new StringBuilder("exec sql exception: ");
                    stringBuilder.append(e);
                    com.qiyukf.basesdk.a.a.a("db", stringBuilder.toString());
                    z = b.a(e);
                    z2 = false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z = false;
                    z2 = z;
                }
                if (z) {
                    com.qiyukf.basesdk.a.a.e("db", "locked");
                }
                if (!z2 && z) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final long b(String str, ContentValues contentValues) {
        return this.b != null ? b.b(this.b, str, contentValues) : -1;
    }

    public final Cursor b(String str) {
        return this.b != null ? b.a(this.b, str) : null;
    }

    public final boolean b() {
        return this.b != null;
    }

    public final void c() {
        if (this.b != null) {
            this.b.close();
            this.b = null;
        }
    }

    public final SQLiteDatabase d() {
        return this.b;
    }
}
