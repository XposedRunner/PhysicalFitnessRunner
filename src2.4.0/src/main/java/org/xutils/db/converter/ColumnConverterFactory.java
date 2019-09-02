package org.xutils.db.converter;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import org.xutils.common.util.LogUtil;
import org.xutils.db.sqlite.ColumnDbType;

public final class ColumnConverterFactory {
    private static final ConcurrentHashMap<String, ColumnConverter> columnType_columnConverter_map = new ConcurrentHashMap();

    static {
        BooleanColumnConverter booleanColumnConverter = new BooleanColumnConverter();
        columnType_columnConverter_map.put(Boolean.TYPE.getName(), booleanColumnConverter);
        columnType_columnConverter_map.put(Boolean.class.getName(), booleanColumnConverter);
        columnType_columnConverter_map.put(byte[].class.getName(), new ByteArrayColumnConverter());
        ByteColumnConverter byteColumnConverter = new ByteColumnConverter();
        columnType_columnConverter_map.put(Byte.TYPE.getName(), byteColumnConverter);
        columnType_columnConverter_map.put(Byte.class.getName(), byteColumnConverter);
        CharColumnConverter charColumnConverter = new CharColumnConverter();
        columnType_columnConverter_map.put(Character.TYPE.getName(), charColumnConverter);
        columnType_columnConverter_map.put(Character.class.getName(), charColumnConverter);
        columnType_columnConverter_map.put(Date.class.getName(), new DateColumnConverter());
        DoubleColumnConverter doubleColumnConverter = new DoubleColumnConverter();
        columnType_columnConverter_map.put(Double.TYPE.getName(), doubleColumnConverter);
        columnType_columnConverter_map.put(Double.class.getName(), doubleColumnConverter);
        FloatColumnConverter floatColumnConverter = new FloatColumnConverter();
        columnType_columnConverter_map.put(Float.TYPE.getName(), floatColumnConverter);
        columnType_columnConverter_map.put(Float.class.getName(), floatColumnConverter);
        IntegerColumnConverter integerColumnConverter = new IntegerColumnConverter();
        columnType_columnConverter_map.put(Integer.TYPE.getName(), integerColumnConverter);
        columnType_columnConverter_map.put(Integer.class.getName(), integerColumnConverter);
        LongColumnConverter longColumnConverter = new LongColumnConverter();
        columnType_columnConverter_map.put(Long.TYPE.getName(), longColumnConverter);
        columnType_columnConverter_map.put(Long.class.getName(), longColumnConverter);
        ShortColumnConverter shortColumnConverter = new ShortColumnConverter();
        columnType_columnConverter_map.put(Short.TYPE.getName(), shortColumnConverter);
        columnType_columnConverter_map.put(Short.class.getName(), shortColumnConverter);
        columnType_columnConverter_map.put(java.sql.Date.class.getName(), new SqlDateColumnConverter());
        columnType_columnConverter_map.put(String.class.getName(), new StringColumnConverter());
    }

    private ColumnConverterFactory() {
    }

    public static ColumnConverter getColumnConverter(Class cls) {
        ColumnConverter columnConverter;
        if (columnType_columnConverter_map.containsKey(cls.getName())) {
            columnConverter = (ColumnConverter) columnType_columnConverter_map.get(cls.getName());
        } else {
            if (ColumnConverter.class.isAssignableFrom(cls)) {
                try {
                    columnConverter = (ColumnConverter) cls.newInstance();
                    if (columnConverter != null) {
                        columnType_columnConverter_map.put(cls.getName(), columnConverter);
                    }
                } catch (Throwable th) {
                    LogUtil.e(th.getMessage(), th);
                }
            }
            columnConverter = null;
        }
        if (columnConverter != null) {
            return columnConverter;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Database Column Not Support: ");
        stringBuilder.append(cls.getName());
        stringBuilder.append(", please impl ColumnConverter or use ColumnConverterFactory#registerColumnConverter(...)");
        throw new RuntimeException(stringBuilder.toString());
    }

    public static ColumnDbType getDbColumnType(Class cls) {
        return getColumnConverter(cls).getColumnDbType();
    }

    public static boolean isSupportColumnConverter(Class cls) {
        boolean z = true;
        if (columnType_columnConverter_map.containsKey(cls.getName())) {
            return true;
        }
        if (ColumnConverter.class.isAssignableFrom(cls)) {
            try {
                ColumnConverter columnConverter = (ColumnConverter) cls.newInstance();
                if (columnConverter != null) {
                    columnType_columnConverter_map.put(cls.getName(), columnConverter);
                }
                if (columnConverter != null) {
                    z = false;
                }
                return z;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static void registerColumnConverter(Class cls, ColumnConverter columnConverter) {
        columnType_columnConverter_map.put(cls.getName(), columnConverter);
    }
}
