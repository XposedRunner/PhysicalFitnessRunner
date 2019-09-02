package com.geetest.sdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import s.h.e.l.l.C;

/* compiled from: BaseDialog */
public abstract class O00000o extends Dialog {
    private View O000000o;

    static {
        C.i(18);
    }

    public O00000o(@NonNull Context context) {
        super(context, R.style.gt3_dialog_style);
    }

    public abstract void O000000o();

    public final native void O000000o(View view);

    public native void onCreate(Bundle bundle);

    public native void show();
}
