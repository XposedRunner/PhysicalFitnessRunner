package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.manager.O00000o0.O000000o;

/* compiled from: ConnectivityMonitorFactory */
public class O00000o {
    public O00000o0 O000000o(Context context, O000000o o000000o) {
        return (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : null) != null ? new O0000O0o(context, o000000o) : new O0000o00();
    }
}
