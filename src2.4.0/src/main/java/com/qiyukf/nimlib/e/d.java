package com.qiyukf.nimlib.e;

import android.os.Handler;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.auth.AuthServiceObserver;
import java.util.ArrayList;

final class d {
    private Handler a;

    d(Handler handler) {
        this.a = handler;
    }

    public final void a(String str, final Observer observer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AuthServiceObserver.class.getSimpleName());
        stringBuilder.append("/observeOtherClients");
        if (str.equals(stringBuilder.toString())) {
            final ArrayList i = com.qiyukf.nimlib.d.i();
            this.a.post(new Runnable() {
                public final void run() {
                    observer.onEvent(i);
                }
            });
        }
    }
}
