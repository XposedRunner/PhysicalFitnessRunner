package org.xutils.db.converter;

import android.database.Cursor;
import org.xutils.db.sqlite.ColumnDbType;

public class LongColumnConverter implements ColumnConverter<Long> {
    public Object fieldValue2DbValue(Long l) {
        return l;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Long getFieldValue(Cursor cursor, int i) {
        return cursor.isNull(i) ? null : Long.valueOf(cursor.getLong(i));
    }
}
