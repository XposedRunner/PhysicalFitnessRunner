package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* compiled from: UMTTTwoTracker */
public class o extends a {
    private static final String a = "umtt2";
    private Context b;

    public o(Context context) {
        super(a);
        this.b = context;
    }

    public String f() {
        try {
            Class cls = Class.forName("com.umeng.commonsdk.internal.utils.SDStorageAgent");
            if (cls == null) {
                return null;
            }
            return (String) cls.getMethod("getUmtt2", new Class[]{Context.class}).invoke(cls, new Object[]{this.b});
        } catch (Throwable unused) {
            return null;
        }
    }
}
