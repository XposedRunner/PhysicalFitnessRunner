package org.xutils.db.converter;

import android.database.Cursor;
import org.xutils.db.sqlite.ColumnDbType;

public interface ColumnConverter<T> {
    Object fieldValue2DbValue(T t);

    ColumnDbType getColumnDbType();

    T getFieldValue(Cursor cursor, int i);
}
