package com.qiyukf.nimlib.f;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import com.qiyukf.nimlib.a.c;
import com.qiyukf.nimlib.d;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.nimlib.service.NimService;
import com.qiyukf.unicorn.api.SavePowerConfig;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private Messenger a;
    private IBinder b;
    private c c;
    private c d;
    private final List<Message> e = new ArrayList();
    private Messenger f;

    private class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i != 103) {
                    switch (i) {
                        case 14:
                            com.qiyukf.nimlib.f.a.a aVar = (com.qiyukf.nimlib.f.a.a) a.a(message);
                            if (aVar != null) {
                                c.a().a(aVar);
                            }
                            return;
                        case 15:
                            c.a().a((com.qiyukf.nimlib.f.a.b) a.b(message));
                            return;
                        case 16:
                            ArrayList arrayList = (ArrayList) a.b(message);
                            c.a();
                            c.a(arrayList);
                            return;
                        case 17:
                            com.qiyukf.nimlib.b.c.e().a((String) a.b(message));
                            return;
                        default:
                            super.handleMessage(message);
                            return;
                    }
                }
                com.qiyukf.unicorn.g.b.a(((Boolean) a.b(message)).booleanValue());
            } catch (Throwable th) {
                com.qiyukf.basesdk.a.a.b("LocalAgent", "handle push message error.", th);
            }
        }
    }

    public b(Context context) {
        if (d.f()) {
            HandlerThread handlerThread = new HandlerThread("LocalAgent");
            handlerThread.start();
            this.f = new Messenger(new a(handlerThread.getLooper()));
            a(context);
            return;
        }
        com.qiyukf.basesdk.a.a.a("LocalAgent", "LocalAgent only lives in main process");
    }

    private void a(int i, Parcelable parcelable) {
        a(a.a(i, parcelable));
    }

    private void a(Context context) {
        this.c = new c(context, NimService.b(context), "main_conn") {
            /* Access modifiers changed, original: protected|final */
            public final void a(IBinder iBinder) {
                b.a(b.this, iBinder);
                b.this.c.c();
            }
        };
        this.d = new c(context, NimService.c(context), "aux_conn") {
            /* Access modifiers changed, original: protected|final */
            public final void a() {
                com.qiyukf.basesdk.a.a.a("LocalAgent", "AuxService onServiceDisconnected");
                b.this.d.b();
            }

            /* Access modifiers changed, original: protected|final */
            public final void a(IBinder iBinder) {
                if (b.this.b == null || b.this.a == null) {
                    com.qiyukf.basesdk.a.a.a("LocalAgent", "AuxService onConnected, reconnect NimService...");
                    b.this.c.b();
                }
            }
        };
        this.c.b();
        this.d.b();
    }

    private void a(Message message) {
        boolean z = false;
        int i = 0;
        while (i < 3) {
            try {
                if (this.a != null) {
                    this.a.send(message);
                    z = true;
                }
            } catch (DeadObjectException unused) {
                c();
            } catch (Exception e) {
                if (!e.a(e)) {
                    a(false);
                    break;
                }
                i++;
            }
        }
        if (!z) {
            synchronized (this.e) {
                this.e.add(message);
            }
            this.c.b();
        }
    }

    private void a(boolean z) {
        if (!z || this.b == null) {
            this.a = null;
            return;
        }
        this.a = new Messenger(this.b);
        Message obtain = Message.obtain(null, 1);
        obtain.replyTo = this.f;
        try {
            this.a.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
            a(false);
        }
        d();
    }

    private void c() {
        com.qiyukf.basesdk.a.a.a("LocalAgent", "!!! Push binder dead !!!");
        this.b = null;
        a(false);
    }

    private void d() {
        synchronized (this.e) {
            List arrayList;
            if (this.e.size() > 0) {
                arrayList = new ArrayList(this.e);
                this.e.clear();
            } else {
                arrayList = null;
            }
        }
        if (arrayList != null) {
            for (Message a : arrayList) {
                a(a);
            }
        }
    }

    public final void a() {
        a(11, null);
    }

    public final void a(int i) {
        a(a.a(101, Integer.valueOf(i)));
    }

    public final void a(com.qiyukf.nimlib.f.a.a aVar) {
        for (Parcelable a : aVar.a()) {
            a(13, a);
        }
    }

    public final void a(LoginInfo loginInfo) {
        a(10, (Parcelable) loginInfo);
    }

    public final void a(SavePowerConfig savePowerConfig) {
        a(a.a(102, savePowerConfig));
    }

    public final void b() {
        if (com.qiyukf.nimlib.b.a() == null) {
            com.qiyukf.basesdk.a.a.a("SDKCache.getContext() is", "null");
        } else if (this.a != null && this.b != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.toString());
            stringBuilder.append(this.b.toString());
            com.qiyukf.basesdk.a.a.a("sender and binder:", stringBuilder.toString());
        } else if (this.c != null && this.c.d()) {
            com.qiyukf.basesdk.a.a.a("main:", this.c.toString());
        } else if (this.d == null || !this.d.d()) {
            com.qiyukf.basesdk.a.a.a("LocalAgent", "IPC has not established while awaking UI, start rebinding...");
            NimService.a(com.qiyukf.nimlib.b.a(), 1);
            a(com.qiyukf.nimlib.b.a());
        } else {
            com.qiyukf.basesdk.a.a.a("aux:", this.d.toString());
        }
    }
}
