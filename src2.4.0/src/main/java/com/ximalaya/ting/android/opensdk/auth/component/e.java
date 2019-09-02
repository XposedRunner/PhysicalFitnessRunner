package com.ximalaya.ting.android.opensdk.auth.component;

import android.content.Context;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.auth.call.IXmlyAuthListener;
import java.util.HashMap;
import java.util.Map;

/* compiled from: XmlyCallbackManager */
public final class e {
    private static e a;
    private Context b;
    private Map<String, IXmlyAuthListener> c = new HashMap();

    private e(Context context) {
        this.b = context;
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e(context);
            }
            eVar = a;
        }
        return eVar;
    }

    private static String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    public final synchronized IXmlyAuthListener a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (IXmlyAuthListener) this.c.get(str);
    }

    public final synchronized void a(String str, IXmlyAuthListener iXmlyAuthListener) {
        if (!(TextUtils.isEmpty(str) || iXmlyAuthListener == null)) {
            this.c.put(str, iXmlyAuthListener);
        }
    }

    public final synchronized void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c.remove(str);
        }
    }
}
