package com.amap.api.mapcore.util;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: LogDBCreator */
public class oO0O0OoO implements oO0Oo0O0 {
    public void O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS a (_id integer primary key autoincrement, a1  varchar(20), a2 varchar(10),a3 varchar(50),a4 varchar(100),a5 varchar(20),a6 integer);");
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", new Object[]{"b"}));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", new Object[]{"c"}));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", new Object[]{"d"}));
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS e (_id integer primary key autoincrement,c1 integer,c2 integer,c3 integer);");
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "DB", "onCreate");
        }
    }

    public void O000000o(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public String O00000Oo() {
        return "logdb.db";
    }

    public int O00000o0() {
        return 1;
    }
}
