package com.geetest.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: DialogController */
final class O0000Oo implements OnCancelListener {
    final /* synthetic */ GT3ConfigBean O000000o;
    final /* synthetic */ O0000Oo0 O00000Oo;

    O0000Oo(O0000Oo0 o0000Oo0, GT3ConfigBean gT3ConfigBean) {
        this.O00000Oo = o0000Oo0;
        this.O000000o = gT3ConfigBean;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.O00000Oo.O0000OoO != null) {
            this.O00000Oo.O0000OoO.O0000O0o();
        }
        if (this.O000000o.getListener() != null) {
            this.O000000o.getListener().onClosed(2);
        }
    }
}
