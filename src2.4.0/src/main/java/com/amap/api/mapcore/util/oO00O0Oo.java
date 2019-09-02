package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import s.h.e.l.l.C;

/* compiled from: DB */
public class oO00O0Oo extends SQLiteOpenHelper {
    private static boolean O00000Oo = true;
    private static boolean O00000o0;
    private oO0Oo0O0 O000000o;

    static {
        C.i(5);
    }

    public oO00O0Oo(Context context, String str, CursorFactory cursorFactory, int i, oO0Oo0O0 oo0oo0o0) {
        super(context, str, cursorFactory, i);
        this.O000000o = oo0oo0o0;
    }

    public native void onCreate(SQLiteDatabase sQLiteDatabase);

    public native void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
}
