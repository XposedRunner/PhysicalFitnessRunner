package org.xutils.http;

import android.os.Parcelable.Creator;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.util.LogUtil;

final class RequestParamsHelper {
    private static final ClassLoader BOOT_CL = String.class.getClassLoader();

    interface ParseKVListener {
        void onParseKV(String str, Object obj);
    }

    private RequestParamsHelper() {
    }

    static Object parseJSONObject(Object obj) throws JSONException {
        if (obj == null) {
            return null;
        }
        Object jSONArray;
        Class cls = obj.getClass();
        Object value;
        if (cls.isArray()) {
            jSONArray = new JSONArray();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                jSONArray.put(parseJSONObject(Array.get(obj, i)));
            }
        } else if (obj instanceof List) {
            jSONArray = new JSONArray();
            for (Object value2 : (List) obj) {
                jSONArray.put(parseJSONObject(value2));
            }
        } else if (obj instanceof Map) {
            jSONArray = new JSONObject();
            for (Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                value2 = entry.getValue();
                if (!(key == null || value2 == null)) {
                    jSONArray.put(String.valueOf(key), parseJSONObject(value2));
                }
            }
        } else {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null || classLoader == BOOT_CL) {
                jSONArray = obj;
            } else {
                final JSONObject jSONObject = new JSONObject();
                parseKV(obj, cls, new ParseKVListener() {
                    public void onParseKV(String str, Object obj) {
                        try {
                            jSONObject.put(str, RequestParamsHelper.parseJSONObject(obj));
                        } catch (JSONException e) {
                            throw new IllegalArgumentException("parse RequestParams to json failed", e);
                        }
                    }
                });
                jSONArray = jSONObject;
            }
        }
        return jSONArray;
    }

    static void parseKV(Object obj, Class<?> cls, ParseKVListener parseKVListener) {
        if (obj != null && cls != null && cls != RequestParams.class && cls != Object.class) {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null && classLoader != BOOT_CL) {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    for (Field field : declaredFields) {
                        if (!(Modifier.isTransient(field.getModifiers()) || field.getType() == Creator.class)) {
                            field.setAccessible(true);
                            try {
                                String name = field.getName();
                                Object obj2 = field.get(obj);
                                if (obj2 != null) {
                                    parseKVListener.onParseKV(name, obj2);
                                }
                            } catch (IllegalAccessException e) {
                                LogUtil.e(e.getMessage(), e);
                            }
                        }
                    }
                }
                parseKV(obj, cls.getSuperclass(), parseKVListener);
            }
        }
    }
}
