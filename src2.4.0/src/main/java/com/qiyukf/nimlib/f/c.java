package com.qiyukf.nimlib.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.qiyukf.basesdk.a.a;
import java.util.concurrent.atomic.AtomicBoolean;

public class c extends Handler implements ServiceConnection {
    private final Context a;
    private final Intent b;
    private final AtomicBoolean c = new AtomicBoolean();
    private final String d;

    public c(Context context, Intent intent, String str) {
        super(context.getMainLooper());
        this.a = context.getApplicationContext();
        this.b = intent;
        this.d = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0074 A:{Catch:{ Throwable -> 0x0098 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0040 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    private void a(int r5) {
        /*
        r4 = this;
        r0 = r4.d;	 Catch:{ Throwable -> 0x0098 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0098 }
        r2 = "doConnect: tag#";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0098 }
        r2 = r4.d;	 Catch:{ Throwable -> 0x0098 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0098 }
        r2 = " count#";
        r1.append(r2);	 Catch:{ Throwable -> 0x0098 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0098 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0098 }
        com.qiyukf.basesdk.a.a.d(r0, r1);	 Catch:{ Throwable -> 0x0098 }
        if (r5 <= 0) goto L_0x0040;
    L_0x001f:
        r0 = r4.d;	 Catch:{ Throwable -> 0x0098 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0098 }
        r2 = "doConnect: unbind & stop service#";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0098 }
        r2 = r4.b;	 Catch:{ Throwable -> 0x0098 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0098 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0098 }
        com.qiyukf.basesdk.a.a.e(r0, r1);	 Catch:{ Throwable -> 0x0098 }
        r0 = r4.a;	 Catch:{ Throwable -> 0x0040 }
        r0.unbindService(r4);	 Catch:{ Throwable -> 0x0040 }
        r0 = r4.a;	 Catch:{ Throwable -> 0x0040 }
        r1 = r4.b;	 Catch:{ Throwable -> 0x0040 }
        r0.stopService(r1);	 Catch:{ Throwable -> 0x0040 }
    L_0x0040:
        r0 = android.os.Message.obtain();	 Catch:{ Throwable -> 0x0098 }
        r1 = 1;
        r0.what = r1;	 Catch:{ Throwable -> 0x0098 }
        r0.arg1 = r5;	 Catch:{ Throwable -> 0x0098 }
        r5 = r4.d;	 Catch:{ Throwable -> 0x0098 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0098 }
        r3 = "doConnect: start & bind service#";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x0098 }
        r3 = r4.b;	 Catch:{ Throwable -> 0x0098 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0098 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0098 }
        com.qiyukf.basesdk.a.a.a(r5, r2);	 Catch:{ Throwable -> 0x0098 }
        r2 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r4.sendMessageDelayed(r0, r2);	 Catch:{ Throwable -> 0x0098 }
        r5 = r4.a;	 Catch:{ Throwable -> 0x0098 }
        r0 = r4.b;	 Catch:{ Throwable -> 0x0098 }
        r5.startService(r0);	 Catch:{ Throwable -> 0x0098 }
        r5 = r4.a;	 Catch:{ Throwable -> 0x0098 }
        r0 = r4.b;	 Catch:{ Throwable -> 0x0098 }
        r5 = r5.bindService(r0, r4, r1);	 Catch:{ Throwable -> 0x0098 }
        if (r5 != 0) goto L_0x0097;
    L_0x0074:
        r5 = r4.d;	 Catch:{ Throwable -> 0x0098 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0098 }
        r2 = "doConnect: stop & bind service#";
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0098 }
        r2 = r4.b;	 Catch:{ Throwable -> 0x0098 }
        r0.append(r2);	 Catch:{ Throwable -> 0x0098 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0098 }
        com.qiyukf.basesdk.a.a.e(r5, r0);	 Catch:{ Throwable -> 0x0098 }
        r5 = r4.a;	 Catch:{ Throwable -> 0x0098 }
        r0 = r4.b;	 Catch:{ Throwable -> 0x0098 }
        r5.stopService(r0);	 Catch:{ Throwable -> 0x0098 }
        r5 = r4.a;	 Catch:{ Throwable -> 0x0098 }
        r0 = r4.b;	 Catch:{ Throwable -> 0x0098 }
        r5.bindService(r0, r4, r1);	 Catch:{ Throwable -> 0x0098 }
    L_0x0097:
        return;
    L_0x0098:
        r5 = move-exception;
        r5.printStackTrace();
        r0 = r4.d;
        r1 = new java.lang.StringBuilder;
        r2 = "connect core error: ";
        r1.<init>(r2);
        r1.append(r5);
        r5 = r1.toString();
        com.qiyukf.basesdk.a.a.a(r0, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.f.c.a(int):void");
    }

    /* Access modifiers changed, original: protected */
    public void a() {
    }

    /* Access modifiers changed, original: protected */
    public void a(IBinder iBinder) {
    }

    public final void b() {
        if (this.c.compareAndSet(false, true)) {
            a(0);
        } else {
            a.d(this.d, "connect: connecting...");
        }
    }

    public final void c() {
        try {
            this.a.unbindService(this);
        } catch (Exception e) {
            String str = this.d;
            StringBuilder stringBuilder = new StringBuilder("unbind service error: ");
            stringBuilder.append(e);
            a.c(str, stringBuilder.toString());
        }
    }

    public final boolean d() {
        return this.c.get();
    }

    public void handleMessage(Message message) {
        if (message.what == 1) {
            int i = message.arg1;
            String str = this.d;
            StringBuilder stringBuilder = new StringBuilder("doTimeout: count#");
            stringBuilder.append(i);
            a.d(str, stringBuilder.toString());
            if (i > 0) {
                this.c.set(false);
                return;
            }
            a(i + 1);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = this.d;
        StringBuilder stringBuilder = new StringBuilder("onServiceConnected: binder#");
        stringBuilder.append(iBinder);
        a.a(str, stringBuilder.toString());
        if (iBinder != null) {
            removeMessages(1);
            this.c.set(false);
            a(iBinder);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        String str = this.d;
        StringBuilder stringBuilder = new StringBuilder("onServiceDisconnected#");
        stringBuilder.append(componentName.getClassName());
        a.a(str, stringBuilder.toString());
        a();
    }
}
