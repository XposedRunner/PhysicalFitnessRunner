package com.geetest.deepknow.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bangcle.andJni.JniLib1557756502;

/* compiled from: DPDBOpenHelper */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "db.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE GGDPERSON(_ID INTEGER PRIMARY KEY AUTOINCREMENT,EVENTS TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        JniLib1557756502.cV(this, sQLiteDatabase, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(16));
    }
}
