package com.qiyukf.unicorn.f.a;

import com.qiyukf.unicorn.f.a.b.a;
import com.qiyukf.unicorn.f.a.b.b;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONObject;

public abstract class e extends d {
    private void fromObject(JSONObject jSONObject, Object obj) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            a aVar = (a) field.getAnnotation(a.class);
            if (aVar != null) {
                try {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    if (obj2 != null) {
                        jSONObject.put(aVar.a(), toJSONable(obj2));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object toJSONable(Object obj) {
        if (obj instanceof a) {
            return fromAttachObject((a) obj);
        }
        if (obj instanceof List) {
            obj = (List) obj;
            for (int i = 0; i < obj.size(); i++) {
                Object obj2 = obj.get(i);
                if (obj2 instanceof a) {
                    obj.set(i, fromAttachObject((a) obj2));
                }
            }
        }
        return obj;
    }

    /* Access modifiers changed, original: protected */
    public JSONObject fromAttachObject(a aVar) {
        JSONObject jSONObject = new JSONObject();
        fromObject(jSONObject, aVar);
        return jSONObject;
    }

    public final int getCmdId() {
        b bVar = (b) getClass().getAnnotation(b.class);
        return bVar != null ? bVar.a() : 0;
    }

    public final boolean supportOffline() {
        b bVar = (b) getClass().getAnnotation(b.class);
        return bVar != null && bVar.b();
    }

    public String toJson(boolean z) {
        return toJsonObject(z).toString();
    }

    /* Access modifiers changed, original: protected */
    public JSONObject toJsonObject(boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.qiyukf.basesdk.c.b.a(jSONObject, "cmd", getCmdId());
        fromObject(jSONObject, this);
        return jSONObject;
    }
}
