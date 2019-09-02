package cn.jpush.android.api;

import android.content.Context;
import cn.jpush.android.data.b;

final class d implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    d(Context context, b bVar) {
        this.a = context;
        this.b = bVar;
    }

    public final void run() {
        c.b(this.a, this.b);
    }
}
