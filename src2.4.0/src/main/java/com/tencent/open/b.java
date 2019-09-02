package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.tencent.open.a.f;

/* compiled from: ProGuard */
public abstract class b extends Dialog {
    protected a a;
    @SuppressLint({"NewApi"})
    protected final WebChromeClient b = new WebChromeClient() {
        public void onConsoleMessage(String str, int i, String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WebChromeClient onConsoleMessage");
            stringBuilder.append(str);
            stringBuilder.append(" -- From 222 line ");
            stringBuilder.append(i);
            stringBuilder.append(" of ");
            stringBuilder.append(str2);
            f.c("openSDK_LOG.JsDialog", stringBuilder.toString());
            if (VERSION.SDK_INT == 7) {
                b.this.a(str);
            }
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null) {
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WebChromeClient onConsoleMessage");
            stringBuilder.append(consoleMessage.message());
            stringBuilder.append(" -- From  111 line ");
            stringBuilder.append(consoleMessage.lineNumber());
            stringBuilder.append(" of ");
            stringBuilder.append(consoleMessage.sourceId());
            f.c("openSDK_LOG.JsDialog", stringBuilder.toString());
            if (VERSION.SDK_INT > 7) {
                b.this.a(consoleMessage == null ? "" : consoleMessage.message());
            }
            return true;
        }
    };

    public b(Context context, int i) {
        super(context, i);
    }

    public abstract void a(String str);

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new a();
    }
}
