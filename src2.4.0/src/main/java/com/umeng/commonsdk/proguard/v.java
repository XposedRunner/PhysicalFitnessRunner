package com.umeng.commonsdk.proguard;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldMetaData */
public class v implements Serializable {
    private static Map<Class<? extends j>, Map<? extends q, v>> d = new HashMap();
    public final String a;
    public final byte b;
    public final w c;

    public v(String str, byte b, w wVar) {
        this.a = str;
        this.b = b;
        this.c = wVar;
    }

    public static Map<? extends q, v> a(Class<? extends j> cls) {
        StringBuilder stringBuilder;
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (InstantiationException e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("InstantiationException for TBase class: ");
                stringBuilder.append(cls.getName());
                stringBuilder.append(", message: ");
                stringBuilder.append(e.getMessage());
                throw new RuntimeException(stringBuilder.toString());
            } catch (IllegalAccessException e2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("IllegalAccessException for TBase class: ");
                stringBuilder.append(cls.getName());
                stringBuilder.append(", message: ");
                stringBuilder.append(e2.getMessage());
                throw new RuntimeException(stringBuilder.toString());
            }
        }
        return (Map) d.get(cls);
    }

    public static void a(Class<? extends j> cls, Map<? extends q, v> map) {
        d.put(cls, map);
    }
}
