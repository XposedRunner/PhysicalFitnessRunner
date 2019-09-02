package org.xutils.db.converter;

import android.database.Cursor;
import org.xutils.db.sqlite.ColumnDbType;

public class ByteArrayColumnConverter implements ColumnConverter<byte[]> {
    public Object fieldValue2DbValue(byte[] bArr) {
        return bArr;
    }

    public ColumnDbType getColumnDbType() {
        return ColumnDbType.BLOB;
    }

    public byte[] getFieldValue(Cursor cursor, int i) {
        return cursor.isNull(i) ? null : cursor.getBlob(i);
    }
}
