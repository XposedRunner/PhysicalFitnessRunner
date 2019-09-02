package com.baidu.lbsapi.auth;

class d implements Runnable {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public void run() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("postWithHttps start Thread id = ");
        stringBuilder.append(String.valueOf(Thread.currentThread().getId()));
        a.a(stringBuilder.toString());
        this.a.a(new g(this.a.a).a(this.a.b));
    }
}
