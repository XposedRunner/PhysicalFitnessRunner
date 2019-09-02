package com.qiyukf.nimlib.d.e.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class a {
    private Context a;
    private a b;
    private BroadcastReceiver c = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "android.net.wifi.SCAN_RESULTS".equals(intent.getAction()) && a.this.b != null) {
                a.this.b.a();
            }
        }
    };

    public interface a {
        void a();
    }

    public a(Context context, a aVar) {
        this.a = context;
        this.b = aVar;
    }

    public final void a() {
        if (this.a != null) {
            this.a.registerReceiver(this.c, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        }
    }

    public final void b() {
        if (this.a != null) {
            this.a.unregisterReceiver(this.c);
        }
    }
}
