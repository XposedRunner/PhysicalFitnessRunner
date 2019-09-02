package com.amap.api.mapcore.util;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: DynamicFileDBCreator */
public class oO00Oo00 implements oO0Oo0O0 {
    private static oO00Oo00 O000000o;

    private oO00Oo00() {
    }

    public static synchronized oO00Oo00 O000000o() {
        oO00Oo00 oo00oo00;
        synchronized (oO00Oo00.class) {
            if (O000000o == null) {
                O000000o = new oO00Oo00();
            }
            oo00oo00 = O000000o;
        }
        return oo00oo00;
    }

    public void O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "DynamicFileDBCreator", "onCreate");
        }
    }

    public void O000000o(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public String O00000Oo() {
        return "dafile.db";
    }

    public int O00000o0() {
        return 1;
    }
}
