package com.qiyukf.nimlib.d.e;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import com.qiyukf.nimlib.d.d.a.a;
import com.qiyukf.nimlib.d.e.b.c;

abstract class b {
    private static final SparseArray<String> d;
    Context a;
    com.qiyukf.nimlib.d.c.b b;
    a c;
    private Handler e;
    private boolean f = false;
    private com.qiyukf.nimlib.d.e.b.a g;
    private com.qiyukf.nimlib.d.e.c.a h;
    private com.qiyukf.nimlib.d.e.b.a.a i = new com.qiyukf.nimlib.d.e.b.a.a() {
        public final void a(int i) {
            if (b.this.d()) {
                if ((i == com.qiyukf.nimlib.d.e.b.b.a.e || i == com.qiyukf.nimlib.d.e.b.b.a.f) && c.a(b.this.a)) {
                    b.this.b(3);
                }
            }
        }
    };
    private com.qiyukf.nimlib.d.e.c.a.a j = new com.qiyukf.nimlib.d.e.c.a.a() {
        public final void a() {
            b.this.b(4);
        }
    };
    private com.qiyukf.nimlib.d.e.a.b.a k = new com.qiyukf.nimlib.d.e.a.b.a() {
        public final void a() {
            if (!b.d(b.this)) {
                b.this.b(2);
            }
        }

        public final void b() {
            if (!b.d(b.this)) {
                b.this.b(2);
            }
        }
    };

    static {
        SparseArray sparseArray = new SparseArray(10);
        d = sparseArray;
        sparseArray.put(0, "SDK_START");
        d.put(1, "APP_LOGIN");
        d.put(2, "APP_FOREGROUND_BACKGROUND");
        d.put(3, "WIFI_CONNECTED");
        d.put(4, "WIFI_LIST_SCAN_RESULT");
        d.put(5, "GPS_COLLECTED");
        d.put(11, "TIMER_WIFI");
        d.put(12, "TIMER_GPS");
        d.put(13, "TIMER_CELL");
    }

    b() {
    }

    private synchronized boolean a() {
        if (!(this.b == null || this.e == null)) {
            if (this.a != null) {
                if (this.f) {
                    com.qiyukf.nimlib.d.a.b.a.f("watcher has already started!");
                    return false;
                }
                this.g = new com.qiyukf.nimlib.d.e.b.a(this.a.getApplicationContext(), this.i);
                this.g.a();
                this.h = new com.qiyukf.nimlib.d.e.c.a(this.a.getApplicationContext(), this.j);
                this.h.a();
                if (com.qiyukf.nimlib.d.a.d().c().b) {
                    com.qiyukf.nimlib.d.e.a.b.a(this.a);
                    com.qiyukf.nimlib.d.e.a.b.a(this.k);
                } else {
                    com.qiyukf.nimlib.d.a.b.a.f("SDKOptions watchAppForegroundBackgroundStatus=false");
                }
                this.f = true;
                com.qiyukf.nimlib.d.a.b.a.f("watcher started!");
                return true;
            }
        }
        com.qiyukf.nimlib.d.a.b.a.f("unable to start watcher, as context was not prepared");
        return false;
    }

    private void b(final int i) {
        if (d()) {
            this.e.post(new Runnable() {
                public final void run() {
                    StringBuilder stringBuilder = new StringBuilder("onEvent ");
                    stringBuilder.append((String) b.d.get(i));
                    com.qiyukf.nimlib.d.a.b.a.f(stringBuilder.toString());
                    b.this.a(i);
                }
            });
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("reject event as watcher is not running, event=");
        stringBuilder.append(i);
        com.qiyukf.nimlib.d.a.b.a.f(stringBuilder.toString());
    }

    private boolean d() {
        return this.f && this.b != null && this.b.i() && this.e != null;
    }

    static /* synthetic */ boolean d(b bVar) {
        if (System.currentTimeMillis() < a.a.a() + 21600000) {
            return false;
        }
        bVar.e();
        return true;
    }

    private synchronized void e() {
        com.qiyukf.nimlib.d.a.b.a.f("on strategy timeout, refreshing strategy...");
        b();
        a(this.a);
    }

    private synchronized void f() {
        b(0);
    }

    public abstract void a(int i);

    public void a(Context context) {
        if (context != null) {
            this.a = context;
            com.qiyukf.nimlib.d.c.a.a().a(new com.qiyukf.nimlib.d.c.a.a<com.qiyukf.nimlib.d.c.b>() {
                public final void a(int i, String str) {
                    com.qiyukf.nimlib.d.a.b.a.f("unable to start watcher, as fetch strategy from DCServer failed!");
                }

                public final /* synthetic */ void a(Object obj) {
                    com.qiyukf.nimlib.d.c.b bVar = (com.qiyukf.nimlib.d.c.b) obj;
                    StringBuilder stringBuilder = new StringBuilder("fetch dc strategy=");
                    stringBuilder.append(bVar);
                    com.qiyukf.nimlib.d.a.b.a.f(stringBuilder.toString());
                    a.a.a(System.currentTimeMillis());
                    if (bVar.i()) {
                        b.this.b = bVar;
                        b.this.e = com.qiyukf.nimlib.d.a.c.a.a().a("DC_EVENT");
                        com.qiyukf.nimlib.d.a.b.a.f("watcher inited!");
                        if (b.this.a()) {
                            b.this.f();
                            return;
                        }
                    }
                    com.qiyukf.nimlib.d.a.b.a.f("DCServer disable client dc!");
                }
            });
        }
    }

    public synchronized void b() {
        if (!(this.b == null || this.e == null)) {
            if (this.a != null) {
                if (this.f) {
                    if (this.g != null) {
                        this.g.b();
                        this.g = null;
                    }
                    if (this.h != null) {
                        this.h.b();
                        this.h = null;
                    }
                    if (com.qiyukf.nimlib.d.a.d().c().b) {
                        com.qiyukf.nimlib.d.e.a.b.b(this.k);
                        com.qiyukf.nimlib.d.e.a.b.b(this.a);
                    }
                    this.e.removeCallbacksAndMessages(null);
                    this.f = false;
                    this.b = null;
                    com.qiyukf.nimlib.d.a.b.a.f("watcher stopped!");
                    return;
                }
                com.qiyukf.nimlib.d.a.b.a.f("watcher has already stopped!");
                return;
            }
        }
        com.qiyukf.nimlib.d.a.b.a.f("unable to stop watcher, as context was not prepared");
    }
}
