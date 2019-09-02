package com.loc;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: SdCardDbCreator */
public class O0OOOo0 implements O000O0o0 {
    public final String O000000o() {
        return "alsn20170807.db";
    }

    public final void O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (Throwable th) {
            O0o0000.O000000o(th, "SdCardDbCreator", "onCreate");
        }
    }
}
