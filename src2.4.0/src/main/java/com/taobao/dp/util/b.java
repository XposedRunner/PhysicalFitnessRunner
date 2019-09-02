package com.taobao.dp.util;

import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;

public class b implements IUMIDInitListenerEx {
    private int a;
    private String b;
    private int c = 908;
    private volatile boolean d = false;

    public b(int i) {
        this.a = i;
    }

    public int a() {
        return this.c;
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.d;
        }
        return z;
    }

    public void onUMIDInitFinishedEx(String str, int i) {
        this.b = str;
        this.c = i;
        synchronized (this) {
            this.d = true;
            notify();
        }
    }
}
