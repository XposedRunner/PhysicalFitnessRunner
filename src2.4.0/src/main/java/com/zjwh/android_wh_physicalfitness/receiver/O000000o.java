package com.zjwh.android_wh_physicalfitness.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: ScreenStatusController */
public class O000000o {
    private Context O000000o;
    private IntentFilter O00000Oo = null;
    private BroadcastReceiver O00000o = null;
    private O00000Oo O00000o0 = null;

    public O000000o(Context context) {
        this.O000000o = context;
        this.O00000Oo = new IntentFilter();
        this.O00000Oo.addAction("android.intent.action.SCREEN_ON");
        this.O00000Oo.addAction("android.intent.action.SCREEN_OFF");
        this.O00000Oo.addAction("android.intent.action.USER_PRESENT");
    }

    public void O000000o() {
        if (this.O000000o != null) {
            this.O00000o = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    if ("android.intent.action.SCREEN_ON".equals(action)) {
                        if (O000000o.this.O00000o0 != null) {
                            O000000o.this.O00000o0.O00000o0();
                        }
                    } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        if (O000000o.this.O00000o0 != null) {
                            O000000o.this.O00000o0.O00000o();
                        }
                    } else if ("android.intent.action.USER_PRESENT".equals(action) && O000000o.this.O00000o0 != null) {
                        O000000o.this.O00000o0.O00000oO();
                    }
                }
            };
            this.O000000o.registerReceiver(this.O00000o, this.O00000Oo);
        }
    }

    public void O000000o(O00000Oo o00000Oo) {
        this.O00000o0 = o00000Oo;
    }

    public void O00000Oo() {
        try {
            if (this.O000000o != null) {
                this.O000000o.unregisterReceiver(this.O00000o);
                this.O00000o = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
