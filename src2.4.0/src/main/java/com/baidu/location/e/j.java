package com.baidu.location.e;

import com.baidu.location.a.l;
import com.baidu.location.a.u;
import com.baidu.location.a.x;
import com.baidu.location.indoor.g;

class j implements Runnable {
    final /* synthetic */ a a;

    j(a aVar) {
        this.a = aVar;
    }

    public void run() {
        i.this.s();
        l.c().i();
        if (g.a().e()) {
            g.a().a.obtainMessage(41).sendToTarget();
        }
        if (System.currentTimeMillis() - u.b() <= 5000) {
            x.a().c();
        }
    }
}
