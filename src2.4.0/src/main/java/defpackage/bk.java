package defpackage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.io.File;

/* compiled from: UMProcessDBCreater */
/* renamed from: bk */
class bk extends SQLiteOpenHelper {
    bk(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    static bk O000000o(Context context, String str) {
        String O00000Oo = bk.O00000Oo(context, str);
        boolean equals = bj.O0000OOo.equals(str);
        return new bk(context, O00000Oo, null, 1);
    }

    public static String O000000o(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(al.O00000Oo(context));
        stringBuilder.append("subprocess/");
        return stringBuilder.toString();
    }

    private void O000000o(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table if not exists __et_p(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __pn TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    public static String O00000Oo(Context context, String str) {
        Object str2;
        if (TextUtils.isEmpty(str2)) {
            str2 = bj.O0000OOo;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(al.O00000Oo(context));
        stringBuilder.append("subprocess/");
        String stringBuilder2 = stringBuilder.toString();
        if (bj.O0000OOo.equals(str2)) {
            stringBuilder2 = al.O00000Oo(context);
        }
        File file = new File(stringBuilder2);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(bj.O00000oO);
        return String.format(stringBuilder3.toString(), new Object[]{str2});
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        O000000o(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
