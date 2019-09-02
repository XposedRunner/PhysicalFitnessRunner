package com.geetest.sdk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.geetest.sdk.dialog.views.GT3GtWebView;
import com.geetest.sdk.dialog.views.O00000Oo;

/* compiled from: BaseStatusDialog */
public final class O0000OOo extends O0000O0o {
    public O0000OOo(@NonNull Context context) {
        super(context);
    }

    public final void O00000Oo(View view) {
        setContentView(view);
        if ((view instanceof GT3GtWebView) && view != null && view.getLayoutParams() != null) {
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = O00000Oo.O000000o;
            layoutParams.height = O00000Oo.O00000Oo;
            view.setLayoutParams(layoutParams);
        }
    }
}
