package com.baidu.mapapi.utils;

import android.content.Context;

final class f implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ int b;

    f(Context context, int i) {
        this.a = context;
        this.b = i;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                b.a(this.a);
                b.a(this.b, this.a);
            }
        } while (!b.v.isInterrupted());
    }
}
