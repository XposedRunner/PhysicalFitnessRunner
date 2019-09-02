package org.xutils.db;

import android.database.Cursor;
import java.util.LinkedHashMap;
import org.xutils.db.table.ColumnEntity;
import org.xutils.db.table.DbModel;
import org.xutils.db.table.TableEntity;

final class CursorUtils {
    CursorUtils() {
    }

    public static DbModel getDbModel(Cursor cursor) {
        DbModel dbModel = new DbModel();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            dbModel.add(cursor.getColumnName(i), cursor.getString(i));
        }
        return dbModel;
    }

    public static <T> T getEntity(TableEntity<T> tableEntity, Cursor cursor) throws Throwable {
        Object createEntity = tableEntity.createEntity();
        LinkedHashMap columnMap = tableEntity.getColumnMap();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            ColumnEntity columnEntity = (ColumnEntity) columnMap.get(cursor.getColumnName(i));
            if (columnEntity != null) {
                columnEntity.setValueFromCursor(createEntity, cursor, i);
            }
        }
        return createEntity;
    }
}
