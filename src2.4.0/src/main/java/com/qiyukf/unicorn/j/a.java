package com.qiyukf.unicorn.j;

import android.os.Handler;

public abstract class a<Param, Result> {
    private Handler a = com.qiyukf.basesdk.c.a.b();
    private Handler b;

    public a(String str) {
        this.b = com.qiyukf.basesdk.c.a.a().a(str);
    }

    public abstract Result a();

    /* Access modifiers changed, original: protected */
    public void a(Result result) {
    }

    public final void a(final Param... paramArr) {
        this.b.post(new Runnable() {
            public final void run() {
                final Object a = a.this.a();
                a.this.a.post(new Runnable() {
                    public final void run() {
                        a.this.a(a);
                    }
                });
            }
        });
    }
}
