package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

/* compiled from: UMDBCreater */
/* renamed from: ag */
class ag extends ContextWrapper {
    private String O000000o;

    public ag(Context context, String str) {
        super(context);
        this.O000000o = str;
    }

    public File getDatabasePath(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O000000o);
        stringBuilder.append(str);
        File file = new File(stringBuilder.toString());
        if (!(file.getParentFile().exists() || file.getParentFile().isDirectory())) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
        return SQLiteDatabase.openDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, 268435472);
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return SQLiteDatabase.openDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, 268435472);
    }
}
