package com.qiyukf.unicorn.f.a;

import com.qiyukf.unicorn.f.a.b.a;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    private static Object a(JSONArray jSONArray, int i, Class<?> cls) {
        if (a.class.isAssignableFrom(cls)) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                try {
                    Object obj = (a) cls.newInstance();
                    a(obj, optJSONObject);
                    return obj;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (cls == String.class) {
            return jSONArray.optString(i);
        } else {
            if (cls == Integer.class) {
                return Integer.valueOf(jSONArray.optInt(i));
            }
            if (cls == Long.class) {
                return Long.valueOf(jSONArray.optLong(i));
            }
            if (cls == Float.class) {
                return Float.valueOf((float) jSONArray.optDouble(i));
            }
            if (cls == Double.class) {
                return Double.valueOf(jSONArray.optDouble(i));
            }
            if (cls == Boolean.class) {
                return Boolean.valueOf(jSONArray.optBoolean(i));
            }
            if (cls == JSONObject.class) {
                return jSONArray.optJSONObject(i);
            }
            if (cls == JSONArray.class) {
                return jSONArray.optJSONArray(i);
            }
            if (cls == Object.class) {
                return jSONArray.opt(i);
            }
        }
        return null;
    }

    private static Type a(Type type) {
        if (type instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                return actualTypeArguments[0];
            }
        }
        return null;
    }

    private static List<Object> a(JSONArray jSONArray, Type type) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            return arrayList;
        }
        int i = 0;
        if (type instanceof Class) {
            while (i < jSONArray.length()) {
                arrayList.add(a(jSONArray, i, (Class) type));
                i++;
            }
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if ((parameterizedType.getRawType() instanceof Class) && List.class.isAssignableFrom((Class) parameterizedType.getRawType())) {
                while (i < jSONArray.length()) {
                    arrayList.add(a(jSONArray == null ? null : jSONArray.optJSONArray(i), a(parameterizedType)));
                    i++;
                }
            }
        }
        return arrayList;
    }

    public static void a(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                a aVar = (a) field.getAnnotation(a.class);
                if (aVar != null) {
                    try {
                        Object e;
                        Class type = field.getType();
                        String a = aVar.a();
                        field.setAccessible(true);
                        if (type == String.class) {
                            e = com.qiyukf.basesdk.c.b.e(jSONObject, a);
                        } else {
                            if (type != Integer.TYPE) {
                                if (type != Integer.class) {
                                    if (type != Long.TYPE) {
                                        if (type != Long.class) {
                                            if (type != Float.TYPE) {
                                                if (type != Float.class) {
                                                    if (type != Double.TYPE) {
                                                        if (type != Double.class) {
                                                            if (type != Boolean.TYPE) {
                                                                if (type != Boolean.class) {
                                                                    if (type == JSONObject.class) {
                                                                        e = com.qiyukf.basesdk.c.b.f(jSONObject, a);
                                                                    } else if (type == JSONArray.class) {
                                                                        e = com.qiyukf.basesdk.c.b.g(jSONObject, a);
                                                                    } else if (type == Object.class) {
                                                                        e = jSONObject == null ? null : jSONObject.opt(a);
                                                                    } else if (a.class.isAssignableFrom(type)) {
                                                                        JSONObject f = com.qiyukf.basesdk.c.b.f(jSONObject, a);
                                                                        if (f != null) {
                                                                            Object obj2 = (a) type.newInstance();
                                                                            a(obj2, f);
                                                                            field.set(obj, obj2);
                                                                        }
                                                                    } else if (List.class.isAssignableFrom(type)) {
                                                                        e = a(com.qiyukf.basesdk.c.b.g(jSONObject, a), a(field.getGenericType()));
                                                                    }
                                                                }
                                                            }
                                                            field.setBoolean(obj, Boolean.valueOf(com.qiyukf.basesdk.c.b.e(jSONObject, a)).booleanValue());
                                                        }
                                                    }
                                                    field.setDouble(obj, com.qiyukf.basesdk.c.b.d(jSONObject, a));
                                                }
                                            }
                                            field.setFloat(obj, (float) com.qiyukf.basesdk.c.b.d(jSONObject, a));
                                        }
                                    }
                                    field.setLong(obj, com.qiyukf.basesdk.c.b.c(jSONObject, a));
                                }
                            }
                            field.setInt(obj, com.qiyukf.basesdk.c.b.b(jSONObject, a));
                        }
                        field.set(obj, e);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}
