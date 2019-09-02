package cn.jiguang.g.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.io.Serializable;
import java.util.Map.Entry;

public final class c {
    public static a a(ContentResolver contentResolver, String str, a aVar) {
        Throwable th;
        Cursor cursor = null;
        try {
            int b = aVar.b();
            if (b == 0) {
                return aVar;
            }
            String[] strArr = new String[b];
            String[] strArr2 = new String[b];
            int i = 0;
            int i2 = 0;
            for (Entry entry : aVar.a()) {
                strArr[i2] = (String) entry.getKey();
                strArr2[i2] = String.valueOf(a.a((Serializable) entry.getValue()));
                i2++;
            }
            Cursor query = contentResolver.query(Uri.parse(str), strArr, null, strArr2, null);
            try {
                a aVar2 = new a();
                if (!(query == null || aVar == null)) {
                    if (aVar.b() != 0) {
                        while (i < query.getColumnCount()) {
                            String columnName = query.getColumnName(i);
                            aVar2.a(columnName, a(query, i, aVar.b(columnName, null)));
                            i++;
                        }
                    }
                }
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                return aVar2;
            } catch (Throwable th2) {
                cursor = query;
                th = th2;
                cursor.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
            throw th;
        }
    }

    private static <T extends Serializable> T a(Cursor cursor, int i, T t) {
        T t2;
        T t3 = null;
        try {
            cursor.moveToFirst();
            T string = cursor.getString(i);
            if (string != null) {
                switch (a.a(t)) {
                    case 0:
                    case 1:
                        t2 = string;
                        break;
                    case 2:
                        t2 = Integer.valueOf(cursor.getInt(i));
                        break;
                    case 3:
                        t2 = Boolean.valueOf(cursor.getInt(i) > 0);
                        break;
                    case 4:
                        t2 = Long.valueOf(cursor.getLong(i));
                        break;
                    case 5:
                        t3 = Float.valueOf(cursor.getFloat(i));
                        break;
                    default:
                        break;
                }
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("convert ");
            stringBuilder.append(th.getMessage());
            Log.e("SpProviderHelper", stringBuilder.toString());
        }
        t2 = t3;
        return t2 == null ? t : t2;
    }

    public static <T extends Serializable> boolean a(ContentResolver contentResolver, String str, String str2, T t) {
        return b(contentResolver, str, new a().a(str2, (Serializable) t));
    }

    public static boolean b(ContentResolver contentResolver, String str, a aVar) {
        ContentValues contentValues = new ContentValues();
        for (Entry entry : aVar.a()) {
            switch (a.a((Serializable) entry.getValue())) {
                case 0:
                    contentValues.put((String) entry.getKey(), null);
                    break;
                case 1:
                    contentValues.put((String) entry.getKey(), (String) entry.getValue());
                    break;
                case 2:
                    contentValues.put((String) entry.getKey(), (Integer) entry.getValue());
                    break;
                case 3:
                    contentValues.put((String) entry.getKey(), (Boolean) entry.getValue());
                    break;
                case 4:
                    contentValues.put((String) entry.getKey(), (Long) entry.getValue());
                    break;
                case 5:
                    contentValues.put((String) entry.getKey(), (Float) entry.getValue());
                    break;
                default:
                    break;
            }
        }
        return contentResolver.update(Uri.parse(str), contentValues, null, null) > 0;
    }
}
