package org.greenrobot.eventbus.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.greenrobot.eventbus.O00000o0;

/* compiled from: ExceptionToResourceMapping */
public class O00000o {
    public final Map<Class<? extends Throwable>, Integer> O000000o = new HashMap();

    public Integer O000000o(Throwable th) {
        String str;
        StringBuilder stringBuilder;
        int i = 20;
        Throwable th2 = th;
        do {
            Integer O00000Oo = O00000Oo(th2);
            if (O00000Oo != null) {
                return O00000Oo;
            }
            th2 = th2.getCause();
            i--;
            if (i <= 0 || th2 == th) {
                str = O00000o0.O000000o;
                stringBuilder = new StringBuilder();
                stringBuilder.append("No specific message ressource ID found for ");
                stringBuilder.append(th);
                Log.d(str, stringBuilder.toString());
            }
        } while (th2 != null);
        str = O00000o0.O000000o;
        stringBuilder = new StringBuilder();
        stringBuilder.append("No specific message ressource ID found for ");
        stringBuilder.append(th);
        Log.d(str, stringBuilder.toString());
        return null;
    }

    public O00000o O000000o(Class<? extends Throwable> cls, int i) {
        this.O000000o.put(cls, Integer.valueOf(i));
        return this;
    }

    /* Access modifiers changed, original: protected */
    public Integer O00000Oo(Throwable th) {
        Class cls = th.getClass();
        Integer num = (Integer) this.O000000o.get(cls);
        if (num == null) {
            Class cls2 = null;
            for (Entry entry : this.O000000o.entrySet()) {
                Class cls3 = (Class) entry.getKey();
                if (cls3.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(cls3))) {
                    num = (Integer) entry.getValue();
                    cls2 = cls3;
                }
            }
        }
        return num;
    }
}
