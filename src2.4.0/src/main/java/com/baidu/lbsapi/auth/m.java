package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

class m extends Thread {
    Handler a = null;
    private Object b = new Object();
    private boolean c = false;

    m() {
    }

    m(String str) {
        super(str);
    }

    public void a() {
        if (a.a) {
            a.a("Looper thread quit()");
        }
        this.a.getLooper().quit();
    }

    public void b() {
        synchronized (this.b) {
            try {
                if (!this.c) {
                    this.b.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void c() {
        synchronized (this.b) {
            this.c = true;
            this.b.notifyAll();
        }
    }

    public void run() {
        Looper.prepare();
        this.a = new Handler();
        if (a.a) {
            a.a("new Handler() finish!!");
        }
        Looper.loop();
        if (a.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LooperThread run() thread id:");
            stringBuilder.append(String.valueOf(Thread.currentThread().getId()));
            a.a(stringBuilder.toString());
        }
    }
}
