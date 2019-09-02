package org.xutils.db.converter;

import android.database.Cursor;
import org.xutils.db.sqlite.ColumnDbType;

public class ShortColumnConverter implements ColumnConverter<Short> {
    public Object fieldValue2DbValue(Short sh) {
        return sh;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Short getFieldValue(Cursor cursor, int i) {
        return cursor.isNull(i) ? null : Short.valueOf(cursor.getShort(i));
    }
}
