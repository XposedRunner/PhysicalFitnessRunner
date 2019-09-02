package cn.jpush.android.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

final class d implements OnClickListener {
    final /* synthetic */ SslErrorHandler a;
    final /* synthetic */ c b;

    d(c cVar, SslErrorHandler sslErrorHandler) {
        this.b = cVar;
        this.a = sslErrorHandler;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.cancel();
    }
}
