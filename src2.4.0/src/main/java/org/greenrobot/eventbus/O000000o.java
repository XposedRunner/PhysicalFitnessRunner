package org.greenrobot.eventbus;

/* compiled from: AsyncPoster */
class O000000o implements Runnable {
    private final O0000o00 O000000o = new O0000o00();
    private final O00000o0 O00000Oo;

    O000000o(O00000o0 o00000o0) {
        this.O00000Oo = o00000o0;
    }

    public void O000000o(O000O00o o000O00o, Object obj) {
        this.O000000o.O000000o(O0000Oo.O000000o(o000O00o, obj));
        this.O00000Oo.O00000oO().execute(this);
    }

    public void run() {
        O0000Oo O000000o = this.O000000o.O000000o();
        if (O000000o == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.O00000Oo.O000000o(O000000o);
    }
}
