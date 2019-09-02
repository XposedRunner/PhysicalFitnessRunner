package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;

/* compiled from: UMTTThreeTracker */
public class n extends a {
    private static final String a = "umtt3";
    private Context b;

    public n(Context context) {
        super(a);
        this.b = context;
    }

    public String f() {
        try {
            Class cls = Class.forName("com.umeng.commonsdk.internal.utils.SDStorageAgent");
            if (cls == null) {
                return null;
            }
            return (String) cls.getMethod("getUmtt3", new Class[]{Context.class}).invoke(cls, new Object[]{this.b});
        } catch (Throwable unused) {
            return null;
        }
    }
}
