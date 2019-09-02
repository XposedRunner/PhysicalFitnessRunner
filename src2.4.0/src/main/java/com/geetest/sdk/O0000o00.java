package com.geetest.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

/* compiled from: DialogController */
final class O0000o00 implements OnKeyListener {
    final /* synthetic */ GT3ConfigBean O000000o;
    final /* synthetic */ O0000Oo0 O00000Oo;

    O0000o00(O0000Oo0 o0000Oo0, GT3ConfigBean gT3ConfigBean) {
        this.O00000Oo = o0000Oo0;
        this.O000000o = gT3ConfigBean;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        if (this.O00000Oo.O0000OoO != null) {
            this.O00000Oo.O0000OoO.O0000O0o();
        }
        if (this.O000000o.getListener() != null) {
            this.O000000o.getListener().onClosed(3);
        }
        this.O00000Oo.O00000o();
        return true;
    }
}
