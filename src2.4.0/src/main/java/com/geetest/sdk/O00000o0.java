package com.geetest.sdk;

import android.app.Application;
import android.content.Context;
import com.geetest.sdk.O000000o.O000000o;

/* compiled from: GT3Controller */
public class O00000o0 {
    private static final String O000000o = "O00000o0";
    private Context O00000Oo;
    private O0O0o0 O00000o;
    private GT3ConfigBean O00000o0;
    private O0000Oo0 O00000oO;
    private O000o O00000oo;
    private String O0000O0o;
    private oooOoO O0000OOo;
    private O000000o O0000Oo;
    private String O0000Oo0;
    private int O0000OoO = 1;

    public O00000o0(Context context) {
        this.O00000Oo = context;
        this.O00000oo = new O000o();
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.O00000oo);
        this.O0000OOo = new oooOoO(context);
        this.O0000OOo.O000000o();
    }

    public final void O000000o() {
        if (this.O00000oo != null) {
            ((Application) this.O00000Oo.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.O00000oo);
            this.O0000O0o = this.O00000oo.O000000o();
            this.O00000oo.O00000Oo();
            this.O00000oo = null;
        }
        if (this.O0000OOo != null) {
            this.O0000Oo0 = this.O0000OOo.O00000o0();
            this.O0000OOo.O00000Oo();
            this.O0000OOo = null;
        }
        new StringBuilder("sensorData-->").append(this.O0000Oo0);
        O0OOO00.O000000o();
        new StringBuilder("motionString-->").append(this.O0000O0o);
        O0OOO00.O000000o();
        this.O00000o = new O0O0o0();
        this.O00000o.setButtonListener(this.O0000Oo);
        this.O00000o.O000000o(this.O00000Oo);
        this.O00000o.O000000o(this.O00000o0);
        this.O00000o.O000000o(this.O0000OoO);
        this.O00000o.O000000o(new O00O00o0());
        O00O00Oo o00O00Oo = new O00O00Oo();
        o00O00Oo.O0000OoO(this.O0000O0o);
        o00O00Oo.O0000Ooo(this.O0000Oo0);
        o00O00Oo.O000000o(this.O00000o0.getUserInfo());
        o00O00Oo.O000000o(this.O00000o0.isDebug());
        o00O00Oo.O00000Oo(this.O00000o0.getLang());
        o00O00Oo.O000000o(this.O00000o0.getTimeout());
        o00O00Oo.O00000Oo(this.O00000o0.getWebviewTimeout());
        o00O00Oo.O000000o(this.O00000o0.getApiServerHost());
        this.O00000o.O000000o(o00O00Oo);
        O0000o0 o0000o0 = new O0000o0();
        O000OO0o o000OO0o = new O000OO0o();
        O000O0o o000O0o = new O000O0o();
        O0000o o0000o = new O0000o();
        O000OOOo o000OOOo = new O000OOOo();
        O000O00o o000O00o = new O000O00o();
        o0000o0.O000000o(o000OO0o);
        o000OO0o.O000000o(o000O0o);
        o000O0o.O000000o(o0000o);
        o0000o.O000000o(o000OOOo);
        o000OOOo.O000000o(o000O00o);
        if (this.O0000OoO != 1) {
            this.O00000oO = new O0000Oo0(this.O00000Oo, this.O00000o0);
        } else if (this.O00000oO == null) {
            this.O00000oO = new O0000Oo0(this.O00000Oo, this.O00000o0);
        }
        this.O00000oO.O000000o(this.O0000OoO);
        this.O00000oO.setButtonListener(this.O0000Oo);
        this.O00000o.O000000o(this.O00000oO);
        o0000o0.O00000Oo(this.O00000o);
    }

    public final void O000000o(int i) {
        this.O0000OoO = i;
    }

    public final void O000000o(GT3ConfigBean gT3ConfigBean) {
        this.O00000o0 = gT3ConfigBean;
    }

    public final void O00000Oo() {
        if (this.O00000oo != null) {
            ((Application) this.O00000Oo.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.O00000oo);
            this.O0000O0o = this.O00000oo.O000000o();
            this.O00000oo.O00000Oo();
            this.O00000oo = null;
        }
        if (this.O0000OOo != null) {
            this.O0000Oo0 = this.O0000OOo.O00000o0();
            this.O0000OOo.O00000Oo();
            this.O0000OOo = null;
        }
        if (this.O0000OoO == 2) {
            if (this.O0000Oo != null) {
                this.O0000Oo.O00000o0();
                this.O0000Oo.O000000o();
            }
            this.O00000o0.getListener().onButtonClick();
            return;
        }
        this.O00000oO = new O0000Oo0(this.O00000Oo, this.O00000o0);
        this.O00000oO.O000000o(this.O0000OoO);
        this.O00000oO.O000000o();
        this.O00000o0.getListener().onButtonClick();
    }

    public final void O00000o() {
        if (this.O00000o != null && this.O00000o.O00000oo() != null) {
            this.O00000o.O00000oo().O00000oo();
        }
    }

    public final void O00000o0() {
        if (!(this.O00000oo == null || this.O00000Oo == null)) {
            ((Application) this.O00000Oo.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.O00000oo);
            this.O00000oo.O00000Oo();
            this.O00000oo = null;
        }
        if (this.O0000OOo != null) {
            this.O0000OOo.O00000Oo();
            this.O0000OOo = null;
        }
        O00OOo.O00000Oo();
        if (this.O00000o != null && this.O00000o.O00000oo() != null) {
            this.O00000o.O00000oo().O0000O0o();
        }
    }

    public final void O00000oO() {
        if (this.O00000o != null && this.O00000o.O00000oo() != null) {
            this.O00000o.O00000oo().O00000o0();
        }
    }

    public final void O00000oo() {
        if (this.O00000o != null && this.O00000o.O00000oo() != null) {
            O0OOO00.O000000o("api2接口错误，错误码为：209-->API2 Result Null !");
            O00O000o o00O000o = new O00O000o();
            o00O000o.O00000Oo("API2 Result Null !");
            o00O000o.O000000o("209");
            o00O000o.O000000o(System.currentTimeMillis() - this.O00000o.O0000OOo());
            o00O000o.O00000o0(this.O00000o.O0000O0o().O00000o());
            this.O00000o.O00000oo().O000000o(o00O000o.clone());
        }
    }

    public final void O0000O0o() {
        if (this.O00000o != null && this.O00000o.O00000oo() != null) {
            this.O00000o.O00000oo().O00000oO();
        }
    }

    public void setButtonListener(O000000o o000000o) {
        this.O0000Oo = o000000o;
    }
}
