package cn.jpush.android.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class e implements OnClickListener {
    final /* synthetic */ SslErrorHandler a;
    final /* synthetic */ c b;

    e(c cVar, SslErrorHandler sslErrorHandler) {
        this.b = cVar;
        this.a = sslErrorHandler;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.b.c = true;
        this.a.proceed();
    }
}
