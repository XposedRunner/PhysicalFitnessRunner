package com.zjwh.android_wh_physicalfitness.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: GsonUtil */
public class O000o000 {
    private static Gson O000000o = new Gson();

    static {
        if (O000000o == null) {
        }
    }

    private O000o000() {
    }

    public static Gson O000000o() {
        if (O000000o == null) {
            O000000o = new Gson();
        }
        return O000000o;
    }

    public static <T> T O000000o(String str, Class<T> cls) {
        return O000000o != null ? O000000o.fromJson(str, cls) : null;
    }

    public static String O000000o(Object obj) {
        return O000000o != null ? O000000o.toJson(obj) : "";
    }

    public static <T> List<Map<String, T>> O000000o(String str) {
        return O000000o != null ? (List) O000000o.fromJson(str, new TypeToken<List<Map<String, T>>>() {
        }.getType()) : null;
    }

    public static <T> List<T> O00000Oo(String str, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = new JsonParser().parse(str).getAsJsonArray().iterator();
            while (it.hasNext()) {
                JsonElement jsonElement = (JsonElement) it.next();
                if (O000000o != null) {
                    arrayList.add(O000000o.fromJson(jsonElement, cls));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static Map<String, Object> O00000Oo(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            hashMap.put(field.getName(), field.get(obj));
        }
        return hashMap;
    }
}
