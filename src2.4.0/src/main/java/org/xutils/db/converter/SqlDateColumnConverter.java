package org.xutils.db.converter;

import android.database.Cursor;
import java.sql.Date;
import org.xutils.db.sqlite.ColumnDbType;

public class SqlDateColumnConverter implements ColumnConverter<Date> {
    public Object fieldValue2DbValue(Date date) {
        return date == null ? null : Long.valueOf(date.getTime());
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.INTEGER;
    }

    public Date getFieldValue(Cursor cursor, int i) {
        return cursor.isNull(i) ? null : new Date(cursor.getLong(i));
    }
}
