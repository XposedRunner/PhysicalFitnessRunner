package com.baidu.location.a;

import com.baidu.location.e.i;
import com.baidu.location.f;

class q implements Runnable {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public void run() {
        if (i.j() || this.a.a(f.getServiceContext())) {
            this.a.d();
        }
    }
}
