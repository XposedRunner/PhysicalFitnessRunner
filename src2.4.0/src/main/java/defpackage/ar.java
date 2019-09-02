package defpackage;

import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: CrashHandler */
/* renamed from: ar */
public class ar implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler O000000o;
    private av O00000Oo;

    public ar() {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.O000000o = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    private void O000000o(Throwable th) {
        if (u.O0000O0o) {
            this.O00000Oo.O000000o(th);
        } else {
            this.O00000Oo.O000000o(null);
        }
    }

    public void O000000o(av avVar) {
        this.O00000Oo = avVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        O000000o(th);
        if (this.O000000o != null && this.O000000o != Thread.getDefaultUncaughtExceptionHandler()) {
            this.O000000o.uncaughtException(thread, th);
        }
    }
}
