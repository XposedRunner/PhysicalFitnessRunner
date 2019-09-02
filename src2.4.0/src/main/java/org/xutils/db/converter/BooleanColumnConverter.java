package org.xutils.db.converter;

import android.database.Cursor;
import org.xutils.db.sqlite.ColumnDbType;

public class BooleanColumnConverter implements ColumnConverter<Boolean> {
    public Object fieldValue2DbValue(Boolean bool) {
        return bool == null ? null : Integer.valueOf(bool.booleanValue());
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Boolean getFieldValue(Cursor cursor, int i) {
        if (cursor.isNull(i)) {
            return null;
        }
        int i2 = cursor.getInt(i);
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
