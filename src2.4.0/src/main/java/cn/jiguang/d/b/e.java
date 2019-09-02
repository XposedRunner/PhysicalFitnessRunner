package cn.jiguang.d.b;

import android.os.HandlerThread;

final class e extends HandlerThread {
    final /* synthetic */ d a;

    e(d dVar, String str) {
        this.a = dVar;
        super(str);
    }

    public final void run() {
        try {
            super.run();
        } catch (RuntimeException unused) {
        }
    }
}
