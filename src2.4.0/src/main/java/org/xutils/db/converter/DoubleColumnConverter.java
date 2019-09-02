package org.xutils.db.converter;

import android.database.Cursor;
import org.xutils.db.sqlite.ColumnDbType;

public class DoubleColumnConverter implements ColumnConverter<Double> {
    public Object fieldValue2DbValue(Double d) {
        return d;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.REAL;
    }

    public Double getFieldValue(Cursor cursor, int i) {
        return cursor.isNull(i) ? null : Double.valueOf(cursor.getDouble(i));
    }
}
