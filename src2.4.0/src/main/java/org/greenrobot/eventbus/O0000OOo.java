package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: HandlerPoster */
final class O0000OOo extends Handler {
    private final O0000o00 O000000o = new O0000o00();
    private final int O00000Oo;
    private boolean O00000o;
    private final O00000o0 O00000o0;

    O0000OOo(O00000o0 o00000o0, Looper looper, int i) {
        super(looper);
        this.O00000o0 = o00000o0;
        this.O00000Oo = i;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(O000O00o o000O00o, Object obj) {
        O0000Oo O000000o = O0000Oo.O000000o(o000O00o, obj);
        synchronized (this) {
            this.O000000o.O000000o(O000000o);
            if (!this.O00000o) {
                this.O00000o = true;
                if (!sendMessage(obtainMessage())) {
                    throw new O0000O0o("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                O0000Oo O000000o = this.O000000o.O000000o();
                if (O000000o == null) {
                    synchronized (this) {
                        O000000o = this.O000000o.O000000o();
                        if (O000000o == null) {
                            this.O00000o = false;
                            this.O00000o = false;
                            return;
                        }
                    }
                }
                this.O00000o0.O000000o(O000000o);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.O00000Oo));
            if (sendMessage(obtainMessage())) {
                this.O00000o = true;
                return;
            }
            throw new O0000O0o("Could not send handler message");
        } catch (Throwable th) {
            this.O00000o = false;
        }
    }
}
