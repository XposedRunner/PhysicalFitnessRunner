package defpackage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O00000Oo;

/* compiled from: StandardDBHelper */
/* renamed from: cz */
public class cz extends SQLiteOpenHelper {
    private static Context O000000o;
    private String O00000Oo = null;

    public cz(Context context) {
        super(context, cx.O00000o, null, 1);
    }

    private void O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            this.O00000Oo = "create table if not exists stats (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL(this.O00000Oo);
        } catch (SQLException e) {
            O0000O0o.O000000o(O00000Oo.O000000o, e);
        }
    }

    private void O00000Oo(SQLiteDatabase sQLiteDatabase) {
        try {
            this.O00000Oo = "create table if not exists s_e (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL(this.O00000Oo);
        } catch (SQLException e) {
            O0000O0o.O000000o(O00000Oo.O000000o, e);
        }
    }

    private void O00000o(SQLiteDatabase sQLiteDatabase) {
        try {
            this.O00000Oo = "create table if not exists userinfo (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL(this.O00000Oo);
        } catch (SQLException e) {
            O0000O0o.O000000o(O00000Oo.O000000o, e);
        }
    }

    private void O00000o0(SQLiteDatabase sQLiteDatabase) {
        try {
            this.O00000Oo = "create table if not exists auth (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL(this.O00000Oo);
        } catch (SQLException e) {
            O0000O0o.O000000o(O00000Oo.O000000o, e);
        }
    }

    private void O00000oO(SQLiteDatabase sQLiteDatabase) {
        try {
            this.O00000Oo = "create table if not exists dau (Id integer primary key,_json TEXT)";
            sQLiteDatabase.execSQL(this.O00000Oo);
        } catch (SQLException e) {
            O0000O0o.O000000o(O00000Oo.O000000o, e);
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        O000000o(sQLiteDatabase);
        O00000Oo(sQLiteDatabase);
        O00000o0(sQLiteDatabase);
        O00000o(sQLiteDatabase);
        O00000oO(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
