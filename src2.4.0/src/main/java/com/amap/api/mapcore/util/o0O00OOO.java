package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: AbstractBasicLbsRestHandler */
public abstract class o0O00OOO<T, V> extends o0O00O0o<T, V> {
    public o0O00OOO(Context context, T t) {
        super(context, t);
    }

    /* Access modifiers changed, original: protected */
    public V O00000Oo() {
        return null;
    }

    public abstract String O00000o0();

    public byte[] getEntityBytes() {
        try {
            return O00000o0().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Map<String, String> getParams() {
        return null;
    }

    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap(16);
        hashMap.put("Content-Type", " application/json");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("User-Agent", "AMAP SDK Android Trace 6.8.0");
        hashMap.put("x-INFO", o0O0OOOo.O00000Oo(this.O00000o0));
        hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{"6.8.0", "trace"}));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }
}
