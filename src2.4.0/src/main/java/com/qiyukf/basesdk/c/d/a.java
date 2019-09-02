package com.qiyukf.basesdk.c.d;

import android.content.Context;
import android.text.ClipboardManager;

public final class a {
    public static final void a(Context context, CharSequence charSequence) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setText(charSequence);
        }
    }
}
