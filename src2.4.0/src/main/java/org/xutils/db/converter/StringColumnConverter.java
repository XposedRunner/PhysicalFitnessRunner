package org.xutils.db.converter;

import android.database.Cursor;
import org.xutils.db.sqlite.ColumnDbType;

public class StringColumnConverter implements ColumnConverter<String> {
    public Object fieldValue2DbValue(String str) {
        return str;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.TEXT;
    }

    public String getFieldValue(Cursor cursor, int i) {
        return cursor.isNull(i) ? null : cursor.getString(i);
    }
}
