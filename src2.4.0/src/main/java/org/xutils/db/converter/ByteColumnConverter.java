package org.xutils.db.converter;

import android.database.Cursor;
import org.xutils.db.sqlite.ColumnDbType;

public class ByteColumnConverter implements ColumnConverter<Byte> {
    public Object fieldValue2DbValue(Byte b) {
        return b;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Byte getFieldValue(Cursor cursor, int i) {
        return cursor.isNull(i) ? null : Byte.valueOf((byte) cursor.getInt(i));
    }
}
