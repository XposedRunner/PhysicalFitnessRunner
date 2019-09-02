package org.greenrobot.eventbus;

import android.util.Log;

/* compiled from: BackgroundPoster */
final class O00000Oo implements Runnable {
    private final O0000o00 O000000o = new O0000o00();
    private final O00000o0 O00000Oo;
    private volatile boolean O00000o0;

    O00000Oo(O00000o0 o00000o0) {
        this.O00000Oo = o00000o0;
    }

    public void O000000o(O000O00o o000O00o, Object obj) {
        O0000Oo O000000o = O0000Oo.O000000o(o000O00o, obj);
        synchronized (this) {
            this.O000000o.O000000o(O000000o);
            if (!this.O00000o0) {
                this.O00000o0 = true;
                this.O00000Oo.O00000oO().execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                O0000Oo O000000o = this.O000000o.O000000o(1000);
                if (O000000o == null) {
                    synchronized (this) {
                        O000000o = this.O000000o.O000000o();
                        if (O000000o == null) {
                            this.O00000o0 = false;
                            this.O00000o0 = false;
                            return;
                        }
                    }
                }
                this.O00000Oo.O000000o(O000000o);
            } catch (InterruptedException e) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(Thread.currentThread().getName());
                    stringBuilder.append(" was interruppted");
                    Log.w("Event", stringBuilder.toString(), e);
                    return;
                } finally {
                    this.O00000o0 = false;
                }
            }
        }
    }
}
