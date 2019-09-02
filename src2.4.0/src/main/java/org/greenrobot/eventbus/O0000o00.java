package org.greenrobot.eventbus;

/* compiled from: PendingPostQueue */
final class O0000o00 {
    private O0000Oo O000000o;
    private O0000Oo O00000Oo;

    O0000o00() {
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized O0000Oo O000000o() {
        O0000Oo o0000Oo;
        o0000Oo = this.O000000o;
        if (this.O000000o != null) {
            this.O000000o = this.O000000o.O00000o0;
            if (this.O000000o == null) {
                this.O00000Oo = null;
            }
        }
        return o0000Oo;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized O0000Oo O000000o(int i) throws InterruptedException {
        if (this.O000000o == null) {
            wait((long) i);
        }
        return O000000o();
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void O000000o(O0000Oo o0000Oo) {
        if (o0000Oo == null) {
            try {
                throw new NullPointerException("null cannot be enqueued");
            } catch (Throwable th) {
            }
        } else {
            if (this.O00000Oo != null) {
                this.O00000Oo.O00000o0 = o0000Oo;
                this.O00000Oo = o0000Oo;
            } else if (this.O000000o == null) {
                this.O00000Oo = o0000Oo;
                this.O000000o = o0000Oo;
            } else {
                throw new IllegalStateException("Head present, but no tail");
            }
            notifyAll();
        }
    }
}
