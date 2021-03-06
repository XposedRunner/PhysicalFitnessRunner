package com.baidu.location.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.location.f;
import com.tencent.connect.common.Constants;

public class d {
    private static d d;
    private boolean a = false;
    private String b = null;
    private a c = null;
    private int e = -1;

    public class a extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    d dVar;
                    String str;
                    d.this.a = false;
                    int intExtra = intent.getIntExtra("status", 0);
                    int intExtra2 = intent.getIntExtra("plugged", 0);
                    int intExtra3 = intent.getIntExtra("level", -1);
                    int intExtra4 = intent.getIntExtra("scale", -1);
                    if (intExtra3 <= 0 || intExtra4 <= 0) {
                        d.this.e = -1;
                    } else {
                        d.this.e = (intExtra3 * 100) / intExtra4;
                    }
                    switch (intExtra) {
                        case 2:
                            dVar = d.this;
                            str = "4";
                            break;
                        case 3:
                        case 4:
                            dVar = d.this;
                            str = "3";
                            break;
                        default:
                            d.this.b = null;
                            break;
                    }
                    dVar.b = str;
                    switch (intExtra2) {
                        case 1:
                            d.this.b = Constants.VIA_SHARE_TYPE_INFO;
                            break;
                        case 2:
                            d.this.b = "5";
                            break;
                        default:
                            return;
                    }
                    d.this.a = true;
                }
            } catch (Exception unused) {
                d.this.b = null;
            }
        }
    }

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (d == null) {
                d = new d();
            }
            dVar = d;
        }
        return dVar;
    }

    public void b() {
        this.c = new a();
        try {
            f.getServiceContext().registerReceiver(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception unused) {
        }
    }

    public void c() {
        if (this.c != null) {
            try {
                f.getServiceContext().unregisterReceiver(this.c);
            } catch (Exception unused) {
            }
        }
        this.c = null;
    }

    public String d() {
        return this.b;
    }

    public boolean e() {
        return this.a;
    }

    public int f() {
        return this.e;
    }
}
