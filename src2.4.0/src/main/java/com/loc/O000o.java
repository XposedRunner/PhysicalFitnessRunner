package com.loc;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: DynamicFileDBCreator */
public final class O000o implements O000O0o0 {
    private static O000o O000000o;

    private O000o() {
    }

    public static synchronized O000o O00000Oo() {
        O000o o000o;
        synchronized (O000o.class) {
            if (O000000o == null) {
                O000000o = new O000o();
            }
            o000o = O000000o;
        }
        return o000o;
    }

    public final String O000000o() {
        return "dafile.db";
    }

    public final void O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "DynamicFileDBCreator", "onCreate");
        }
    }
}
