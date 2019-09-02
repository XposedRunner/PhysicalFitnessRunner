package org.greenrobot.eventbus.util;

/* compiled from: ThrowableFailureEvent */
public class O0000OOo implements O0000O0o {
    protected final Throwable O000000o;
    protected final boolean O00000Oo;
    private Object O00000o0;

    public O0000OOo(Throwable th) {
        this.O000000o = th;
        this.O00000Oo = false;
    }

    public O0000OOo(Throwable th, boolean z) {
        this.O000000o = th;
        this.O00000Oo = z;
    }

    public Object O000000o() {
        return this.O00000o0;
    }

    public void O000000o(Object obj) {
        this.O00000o0 = obj;
    }

    public Throwable O00000Oo() {
        return this.O000000o;
    }

    public boolean O00000o0() {
        return this.O00000Oo;
    }
}
