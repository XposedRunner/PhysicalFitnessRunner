package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.a;

/* compiled from: IDFATracker */
public class c extends a {
    private static final String a = "idfa";
    private Context b;

    public c(Context context) {
        super(a);
        this.b = context;
    }

    public String f() {
        String a = a.a(this.b);
        return a == null ? "" : a;
    }
}
