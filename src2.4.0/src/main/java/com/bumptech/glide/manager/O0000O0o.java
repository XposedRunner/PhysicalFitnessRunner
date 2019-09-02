package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bumptech.glide.manager.O00000o0.O000000o;

/* compiled from: DefaultConnectivityMonitor */
class O0000O0o implements O00000o0 {
    private final Context O000000o;
    private final O000000o O00000Oo;
    private boolean O00000o;
    private boolean O00000o0;
    private final BroadcastReceiver O00000oO = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            boolean O000000o = O0000O0o.this.O00000o0;
            O0000O0o.this.O00000o0 = O0000O0o.this.O000000o(context);
            if (O000000o != O0000O0o.this.O00000o0) {
                O0000O0o.this.O00000Oo.O000000o(O0000O0o.this.O00000o0);
            }
        }
    };

    public O0000O0o(Context context, O000000o o000000o) {
        this.O000000o = context.getApplicationContext();
        this.O00000Oo = o000000o;
    }

    private void O000000o() {
        if (!this.O00000o) {
            this.O00000o0 = O000000o(this.O000000o);
            this.O000000o.registerReceiver(this.O00000oO, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.O00000o = true;
        }
    }

    private boolean O000000o(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void O00000Oo() {
        if (this.O00000o) {
            this.O000000o.unregisterReceiver(this.O00000oO);
            this.O00000o = false;
        }
    }

    public void O0000O0o() {
        O000000o();
    }

    public void O0000OOo() {
        O00000Oo();
    }

    public void O0000Oo0() {
    }
}
