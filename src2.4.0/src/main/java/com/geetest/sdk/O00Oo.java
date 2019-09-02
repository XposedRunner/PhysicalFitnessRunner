package com.geetest.sdk;

/* compiled from: UICallback */
final class O00Oo implements Runnable {
    final /* synthetic */ int O000000o;
    final /* synthetic */ String O00000Oo;
    final /* synthetic */ O00Oo0OO O00000o;
    final /* synthetic */ Object O00000o0;

    O00Oo(O00Oo0OO o00Oo0OO, int i, String str, Object obj) {
        this.O00000o = o00Oo0OO;
        this.O000000o = i;
        this.O00000Oo = str;
        this.O00000o0 = obj;
    }

    public final void run() {
        try {
            this.O00000o.O00000Oo.O000000o(this.O000000o, this.O00000Oo, this.O00000o0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
