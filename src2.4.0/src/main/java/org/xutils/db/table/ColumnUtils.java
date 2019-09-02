package org.xutils.db.table;

import com.umeng.commonsdk.proguard.e;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import org.xutils.common.util.LogUtil;
import org.xutils.db.converter.ColumnConverterFactory;

public final class ColumnUtils {
    private static final HashSet<Class<?>> AUTO_INCREMENT_TYPES = new HashSet(4);
    private static final HashSet<Class<?>> BOOLEAN_TYPES = new HashSet(2);
    private static final HashSet<Class<?>> INTEGER_TYPES = new HashSet(2);

    static {
        BOOLEAN_TYPES.add(Boolean.TYPE);
        BOOLEAN_TYPES.add(Boolean.class);
        INTEGER_TYPES.add(Integer.TYPE);
        INTEGER_TYPES.add(Integer.class);
        AUTO_INCREMENT_TYPES.addAll(INTEGER_TYPES);
        AUTO_INCREMENT_TYPES.add(Long.TYPE);
        AUTO_INCREMENT_TYPES.add(Long.class);
    }

    private ColumnUtils() {
    }

    public static Object convert2DbValueIfNeeded(Object obj) {
        return obj != null ? ColumnConverterFactory.getColumnConverter(obj.getClass()).fieldValue2DbValue(obj) : obj;
    }

    private static Method findBooleanGetMethod(Class<?> cls, String str) {
        StringBuilder stringBuilder;
        if (!str.startsWith(e.ac)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(e.ac);
            stringBuilder.append(str.substring(0, 1).toUpperCase());
            stringBuilder.append(str.substring(1));
            str = stringBuilder.toString();
        }
        try {
            return cls.getDeclaredMethod(str, new Class[0]);
        } catch (NoSuchMethodException unused) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(cls.getName());
            stringBuilder.append("#");
            stringBuilder.append(str);
            stringBuilder.append(" not exist");
            LogUtil.d(stringBuilder.toString());
            return null;
        }
    }

    private static Method findBooleanSetMethod(Class<?> cls, String str, Class<?> cls2) {
        StringBuilder stringBuilder;
        if (str.startsWith(e.ac)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("set");
            stringBuilder.append(str.substring(2, 3).toUpperCase());
            stringBuilder.append(str.substring(3));
            str = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("set");
            stringBuilder.append(str.substring(0, 1).toUpperCase());
            stringBuilder.append(str.substring(1));
            str = stringBuilder.toString();
        }
        try {
            return cls.getDeclaredMethod(str, new Class[]{cls2});
        } catch (NoSuchMethodException unused) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(cls.getName());
            stringBuilder2.append("#");
            stringBuilder2.append(str);
            stringBuilder2.append(" not exist");
            LogUtil.d(stringBuilder2.toString());
            return null;
        }
    }

    static Method findGetMethod(Class<?> cls, Field field) {
        Method method = null;
        if (Object.class.equals(cls)) {
            return null;
        }
        String name = field.getName();
        if (isBoolean(field.getType())) {
            method = findBooleanGetMethod(cls, name);
        }
        if (method == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get");
            stringBuilder.append(name.substring(0, 1).toUpperCase());
            stringBuilder.append(name.substring(1));
            name = stringBuilder.toString();
            try {
                method = cls.getDeclaredMethod(name, new Class[0]);
            } catch (NoSuchMethodException unused) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(cls.getName());
                stringBuilder.append("#");
                stringBuilder.append(name);
                stringBuilder.append(" not exist");
                LogUtil.d(stringBuilder.toString());
            }
        }
        return method == null ? findGetMethod(cls.getSuperclass(), field) : method;
    }

    static Method findSetMethod(Class<?> cls, Field field) {
        Method method = null;
        if (Object.class.equals(cls)) {
            return null;
        }
        String name = field.getName();
        Class type = field.getType();
        if (isBoolean(type)) {
            method = findBooleanSetMethod(cls, name, type);
        }
        if (method == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("set");
            stringBuilder.append(name.substring(0, 1).toUpperCase());
            stringBuilder.append(name.substring(1));
            name = stringBuilder.toString();
            try {
                method = cls.getDeclaredMethod(name, new Class[]{type});
            } catch (NoSuchMethodException unused) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(cls.getName());
                stringBuilder2.append("#");
                stringBuilder2.append(name);
                stringBuilder2.append(" not exist");
                LogUtil.d(stringBuilder2.toString());
            }
        }
        return method == null ? findSetMethod(cls.getSuperclass(), field) : method;
    }

    public static boolean isAutoIdType(Class<?> cls) {
        return AUTO_INCREMENT_TYPES.contains(cls);
    }

    public static boolean isBoolean(Class<?> cls) {
        return BOOLEAN_TYPES.contains(cls);
    }

    public static boolean isInteger(Class<?> cls) {
        return INTEGER_TYPES.contains(cls);
    }
}
