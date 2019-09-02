package com.geetest.sdk;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* compiled from: BaseScreenDialog */
public abstract class O0000O0o extends O00000o {
    public O0000O0o(@NonNull Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void O000000o() {
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }
}
