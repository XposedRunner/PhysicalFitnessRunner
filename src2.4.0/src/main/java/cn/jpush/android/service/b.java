package cn.jpush.android.service;

import android.content.Context;

final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;

    b(a aVar, Context context) {
        this.b = aVar;
        this.a = context;
    }

    public final void run() {
        this.b.e(this.a);
        this.b.c(this.a);
    }
}
