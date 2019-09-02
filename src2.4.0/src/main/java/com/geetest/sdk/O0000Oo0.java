package com.geetest.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.geetest.sdk.dialog.views.FailedView;
import com.geetest.sdk.dialog.views.GT3GtWebView;
import com.geetest.sdk.dialog.views.LoadingView;
import com.geetest.sdk.dialog.views.SuccessView;

/* compiled from: DialogController */
public final class O0000Oo0 {
    private Context O000000o;
    private GT3ConfigBean O00000Oo;
    private LoadingView O00000o;
    private O0000OOo O00000o0;
    private GT3GtWebView O00000oO;
    private O000000o O00000oo = new O000000o();
    private O00000Oo O0000O0o;
    private O00000o0 O0000OOo;
    private com.geetest.sdk.dialog.views.O00000Oo O0000Oo;
    private GT3ErrorBean O0000Oo0;
    private com.geetest.sdk.O000000o.O000000o O0000OoO;
    private int O0000Ooo = 1;

    /* compiled from: DialogController */
    public class O000000o extends Handler {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            O0000Oo0.this.O00000o();
            switch (message.what) {
                case 1:
                    if (!(O0000Oo0.this.O00000Oo == null || O0000Oo0.this.O00000Oo.getListener() == null)) {
                        O0000Oo0.this.O00000Oo.getListener().onFailed(O0000Oo0.this.O0000Oo0);
                        return;
                    }
                case 2:
                    if (!(O0000Oo0.this.O00000Oo == null || O0000Oo0.this.O00000Oo.getListener() == null)) {
                        O0000Oo0.this.O00000Oo.getListener().onSuccess("");
                        break;
                    }
            }
        }
    }

    /* compiled from: DialogController */
    public class O00000Oo implements Runnable {
        public final void run() {
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (O0000Oo0.this.O00000oo != null) {
                O0000Oo0.this.O00000oo.sendMessage(obtain);
            }
        }
    }

    /* compiled from: DialogController */
    public class O00000o0 implements Runnable {
        public final void run() {
            Message obtain = Message.obtain();
            obtain.what = 2;
            if (O0000Oo0.this.O00000oo != null) {
                O0000Oo0.this.O00000oo.sendMessage(obtain);
            }
        }
    }

    public O0000Oo0(Context context, GT3ConfigBean gT3ConfigBean) {
        this.O000000o = context;
        this.O00000Oo = gT3ConfigBean;
        this.O00000o0 = new O0000OOo(context);
        this.O00000o0.setCanceledOnTouchOutside(gT3ConfigBean.isCanceledOnTouchOutside());
        this.O00000o0.setOnCancelListener(new O0000Oo(this, gT3ConfigBean));
        this.O00000o0.setOnKeyListener(new O0000o00(this, gT3ConfigBean));
    }

    private void O0000OOo() {
        if (this.O00000o0 != null && this.O00000o0.isShowing()) {
            this.O00000o0.setCanceledOnTouchOutside(false);
            this.O00000o0.setCancelable(false);
        }
    }

    public final void O000000o() {
        switch (this.O0000Ooo) {
            case 2:
            case 3:
                return;
            default:
                this.O00000o = new LoadingView(this.O000000o);
                this.O00000o0.O000000o(this.O00000o);
                if (!(this.O000000o == null || !(this.O000000o instanceof Activity) || ((Activity) this.O000000o).isFinishing())) {
                    this.O00000o0.show();
                }
                return;
        }
    }

    public final void O000000o(int i) {
        this.O0000Ooo = i;
    }

    public final void O000000o(GT3ErrorBean gT3ErrorBean) {
        switch (this.O0000Ooo) {
            case 2:
                O00000o();
                if (this.O0000OoO != null) {
                    this.O0000OoO.O000000o(gT3ErrorBean.errorDesc, gT3ErrorBean.errorCode);
                }
                if (!(this.O00000Oo == null || this.O00000Oo.getListener() == null)) {
                    this.O00000Oo.getListener().onFailed(gT3ErrorBean);
                    return;
                }
            case 3:
                O00000o();
                if (!(this.O00000Oo == null || this.O00000Oo.getListener() == null)) {
                    this.O00000Oo.getListener().onFailed(gT3ErrorBean);
                    return;
                }
            default:
                O0000OOo();
                this.O0000Oo0 = gT3ErrorBean;
                this.O0000O0o = new O00000Oo();
                this.O00000o0.O00000Oo(new FailedView(this.O000000o, gT3ErrorBean, this.O00000oo, this.O0000O0o));
                break;
        }
    }

    public final void O000000o(O00O00Oo o00O00Oo, O00OOOo o00OOOo) {
        this.O0000Oo = new com.geetest.sdk.dialog.views.O00000Oo(this.O000000o);
        this.O0000Oo.O000000o(o00O00Oo);
        this.O0000Oo.O000000o(o00OOOo);
        this.O00000oO = this.O0000Oo.O000000o();
    }

    public final void O00000Oo() {
        switch (this.O0000Ooo) {
            case 2:
            case 3:
                this.O00000o0.O000000o(this.O00000oO);
                if (!(this.O000000o == null || !(this.O000000o instanceof Activity) || ((Activity) this.O000000o).isFinishing())) {
                    if (this.O00000o0.isShowing()) {
                        this.O00000o0.O00000Oo(this.O00000oO);
                        return;
                    } else {
                        this.O00000o0.show();
                        return;
                    }
                }
            default:
                if (this.O00000o0 != null && this.O00000o0.isShowing()) {
                    this.O00000o0.O00000Oo(this.O00000oO);
                    break;
                }
        }
    }

    public final void O00000o() {
        if (this.O00000o0 != null && this.O00000o0.isShowing()) {
            this.O00000o0.dismiss();
        }
    }

    public final void O00000o0() {
        switch (this.O0000Ooo) {
            case 2:
                O00000o();
                if (this.O0000OoO != null) {
                    this.O0000OoO.O00000oO();
                }
                if (!(this.O00000Oo == null || this.O00000Oo.getListener() == null)) {
                    this.O00000Oo.getListener().onSuccess("");
                    return;
                }
            case 3:
                O00000o();
                if (!(this.O00000Oo == null || this.O00000Oo.getListener() == null)) {
                    this.O00000Oo.getListener().onSuccess("");
                    return;
                }
            default:
                O0000OOo();
                this.O0000OOo = new O00000o0();
                this.O00000o0.O00000Oo(new SuccessView(this.O000000o, this.O00000oo, this.O0000OOo));
                break;
        }
    }

    public final void O00000oO() {
        O00000o();
        if (this.O0000Ooo == 2 && this.O0000OoO != null) {
            this.O0000OoO.O0000O0o();
        }
    }

    public final void O00000oo() {
        if (this.O0000Oo != null) {
            this.O0000Oo.O00000Oo();
        }
    }

    public final void O0000O0o() {
        O00000o();
        if (this.O00000oo != null) {
            try {
                this.O00000oo.removeMessages(1);
                this.O00000oo.removeCallbacks(this.O0000O0o);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.O00000oo.removeMessages(2);
                this.O00000oo.removeCallbacks(this.O0000OOo);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.O00000oo = null;
        }
        if (this.O0000Oo != null) {
            this.O0000Oo.O00000o();
            this.O0000Oo = null;
        }
    }

    public final void setButtonListener(com.geetest.sdk.O000000o.O000000o o000000o) {
        this.O0000OoO = o000000o;
    }
}
