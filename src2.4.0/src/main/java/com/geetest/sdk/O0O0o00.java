package com.geetest.sdk;

import android.content.Context;

/* compiled from: GTUserRequest */
public abstract class O0O0o00 {
    public int O000000o;
    private int O00000Oo;
    private O00O000o O00000o;
    private int O00000o0;
    private Context O00000oO;
    private GT3ConfigBean O00000oo;
    private O0000Oo0 O0000O0o;
    private O00O00Oo O0000OOo;
    private com.geetest.sdk.O000000o.O000000o O0000Oo;
    private long O0000Oo0;
    private int O0000OoO;
    private O00O00o0 O0000Ooo;

    /* compiled from: GTUserRequest */
    public enum O000000o {
        ;
        
        public static final int NORMAL$5c47eb37 = 3;
        public static final int ONEPASS$5c47eb37 = 2;
        public static final int REQUESTING$5c47eb37 = 4;
        public static final int SHUTDOWN$5c47eb37 = 1;

        static {
            O000000o = new int[]{SHUTDOWN$5c47eb37, ONEPASS$5c47eb37, NORMAL$5c47eb37, REQUESTING$5c47eb37};
        }

        public static int[] values$6970d78f() {
            return (int[]) O000000o.clone();
        }
    }

    public O0O0o00() {
        this.O00000Oo = 3;
        this.O00000o0 = 1;
        this.O0000OoO = 1;
        this.O000000o = O000000o.NORMAL$5c47eb37;
        this.O00000o0 = 0;
        this.O0000Oo0 = System.currentTimeMillis();
    }

    public final int O000000o() {
        return this.O00000o0;
    }

    public final void O000000o(int i) {
        this.O0000OoO = i;
    }

    public final void O000000o(Context context) {
        this.O00000oO = context;
    }

    public final void O000000o(GT3ConfigBean gT3ConfigBean) {
        this.O00000oo = gT3ConfigBean;
    }

    public final void O000000o(O0000Oo0 o0000Oo0) {
        this.O0000O0o = o0000Oo0;
    }

    public final void O000000o(O00O000o o00O000o) {
        this.O00000o = o00O000o;
    }

    public final void O000000o(O00O00Oo o00O00Oo) {
        this.O0000OOo = o00O00Oo;
    }

    public final void O000000o(O00O00o0 o00O00o0) {
        this.O0000Ooo = o00O00o0;
    }

    public final void O00000Oo() {
        this.O00000o0 = 22;
    }

    public final Context O00000o() {
        return this.O00000oO;
    }

    public final O00O000o O00000o0() {
        return this.O00000o;
    }

    public final GT3ConfigBean O00000oO() {
        return this.O00000oo;
    }

    public final O0000Oo0 O00000oo() {
        return this.O0000O0o;
    }

    public final O00O00Oo O0000O0o() {
        return this.O0000OOo;
    }

    public final long O0000OOo() {
        return this.O0000Oo0;
    }

    public final int O0000Oo() {
        return this.O0000OoO;
    }

    public final com.geetest.sdk.O000000o.O000000o O0000Oo0() {
        return this.O0000Oo;
    }

    public void setButtonListener(com.geetest.sdk.O000000o.O000000o o000000o) {
        this.O0000Oo = o000000o;
    }
}
