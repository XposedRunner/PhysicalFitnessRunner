package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* compiled from: UMTTFiveTracker */
public class k extends a {
    private static final String a = "umtt5";
    private Context b;

    public k(Context context) {
        super(a);
        this.b = context;
    }

    public String f() {
        try {
            Class cls = Class.forName("com.umeng.commonsdk.internal.utils.SDStorageAgent");
            if (cls == null) {
                return null;
            }
            return (String) cls.getMethod("getUmtt5", new Class[]{Context.class}).invoke(cls, new Object[]{this.b});
        } catch (Throwable unused) {
            return null;
        }
    }
}
