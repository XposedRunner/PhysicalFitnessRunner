package cn.jiguang.a.a.a;

import cn.jiguang.g.l;

final class j implements g {
    final /* synthetic */ l a;
    final /* synthetic */ int b;
    final /* synthetic */ h c;

    j(h hVar, l lVar, int i) {
        this.c = hVar;
        this.a = lVar;
        this.b = i;
    }

    public final void a() {
        synchronized (h.i) {
            l lVar = this.a;
            StringBuilder stringBuilder = new StringBuilder("thread");
            stringBuilder.append(this.b);
            lVar.a(stringBuilder.toString());
            this.c.h[this.b] = true;
            h.i.notifyAll();
        }
    }
}
