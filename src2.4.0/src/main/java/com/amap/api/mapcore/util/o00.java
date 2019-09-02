package com.amap.api.mapcore.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* compiled from: BottomDialogBase */
abstract class o00 extends Dialog {
    public o00(Context context) {
        super(context);
        O00000Oo();
    }

    public abstract void O000000o();

    /* Access modifiers changed, original: protected */
    public void O00000Oo() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            O000000o();
            window.getDecorView().setPadding(0, 0, 0, 0);
            LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.width = -1;
                attributes.height = -2;
                attributes.gravity = 80;
            }
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(17170445);
        }
    }
}
