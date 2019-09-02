package com.qiyukf.nimlib.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class c {
    a a;
    Context b;
    private boolean c;
    private String d;
    private BroadcastReceiver e = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
                String typeName = z ? activeNetworkInfo.getTypeName() : null;
                if (c.this.c != z) {
                    c.this.c = z;
                    c.this.d = typeName;
                    c.b(c.this, z);
                } else if (c.this.c && !typeName.equals(c.this.d)) {
                    c.this.d = typeName;
                    c.this.a(com.qiyukf.nimlib.h.b.c.a.f);
                }
            }
        }
    };

    public interface a {
        void a(int i);
    }

    c(Context context, a aVar) {
        this.b = context.getApplicationContext();
        this.a = aVar;
    }

    private void a(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
        if (this.c) {
            StringBuilder stringBuilder = new StringBuilder("network type changed to: ");
            stringBuilder.append(this.d);
            com.qiyukf.basesdk.a.a.a("core", stringBuilder.toString());
        }
    }

    static /* synthetic */ void b(c cVar, boolean z) {
        cVar.a(z ? com.qiyukf.nimlib.h.b.c.a.e : com.qiyukf.nimlib.h.b.c.a.d);
    }

    public final boolean a() {
        return this.c || com.qiyukf.basesdk.c.d.c.c(this.b);
    }

    public final void b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        this.c = z;
        this.d = this.c ? activeNetworkInfo.getTypeName() : null;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.b.registerReceiver(this.e, intentFilter);
    }

    public final void c() {
        try {
            this.b.unregisterReceiver(this.e);
        } catch (IllegalArgumentException e) {
            StringBuilder stringBuilder = new StringBuilder("unregisterReceiver error: ");
            stringBuilder.append(e.toString());
            com.qiyukf.basesdk.a.a.c("ConnectivityWatcher", stringBuilder.toString());
        }
    }
}
