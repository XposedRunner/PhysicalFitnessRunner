package com.qiyukf.nimlib.d.e.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.qiyukf.nimlib.d.a.d.b;

public final class a {
    private a a;
    private Context b;
    private boolean c;
    private String d;
    private BroadcastReceiver e = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && b.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
                    String typeName = z ? activeNetworkInfo.getTypeName() : null;
                    if (a.this.c != z) {
                        a.this.c = z;
                        a.this.d = typeName;
                        a.b(a.this, z);
                    } else if (a.this.c && !typeName.equals(a.this.d)) {
                        a.this.d = typeName;
                        a.this.a(com.qiyukf.nimlib.d.e.b.b.a.f);
                    }
                }
            }
        }
    };

    public interface a {
        void a(int i);
    }

    public a(Context context, a aVar) {
        this.b = context;
        this.a = aVar;
    }

    private void a(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
        if (this.c) {
            StringBuilder stringBuilder = new StringBuilder("network type changed to: ");
            stringBuilder.append(this.d);
            com.qiyukf.nimlib.d.a.b.a.a(stringBuilder.toString());
        }
    }

    static /* synthetic */ void b(a aVar, boolean z) {
        aVar.a(z ? com.qiyukf.nimlib.d.e.b.b.a.e : com.qiyukf.nimlib.d.e.b.b.a.d);
    }

    public final void a() {
        if (b.a(this.b, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                boolean z = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
                this.c = z;
                this.d = this.c ? activeNetworkInfo.getTypeName() : null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.b.registerReceiver(this.e, intentFilter);
            return;
        }
        com.qiyukf.nimlib.d.a.b.a.a("unable to startup ConnectivityWatcher, as without permission");
    }

    public final void b() {
        this.b.unregisterReceiver(this.e);
    }
}
