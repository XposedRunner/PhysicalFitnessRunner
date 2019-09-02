package org.xutils.db.table;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.xutils.common.util.LogUtil;
import org.xutils.db.annotation.Column;
import org.xutils.db.converter.ColumnConverterFactory;

final class TableUtils {
    private TableUtils() {
    }

    private static void addColumns2Map(Class<?> cls, HashMap<String, ColumnEntity> hashMap) {
        if (!Object.class.equals(cls)) {
            try {
                for (Field field : cls.getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    if (!Modifier.isStatic(modifiers)) {
                        if (!Modifier.isTransient(modifiers)) {
                            Column column = (Column) field.getAnnotation(Column.class);
                            if (column != null && ColumnConverterFactory.isSupportColumnConverter(field.getType())) {
                                ColumnEntity columnEntity = new ColumnEntity(cls, field, column);
                                if (!hashMap.containsKey(columnEntity.getName())) {
                                    hashMap.put(columnEntity.getName(), columnEntity);
                                }
                            }
                        }
                    }
                }
                addColumns2Map(cls.getSuperclass(), hashMap);
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
    }

    static synchronized LinkedHashMap<String, ColumnEntity> findColumnMap(Class<?> cls) {
        LinkedHashMap linkedHashMap;
        synchronized (TableUtils.class) {
            linkedHashMap = new LinkedHashMap();
            addColumns2Map(cls, linkedHashMap);
        }
        return linkedHashMap;
    }
}
