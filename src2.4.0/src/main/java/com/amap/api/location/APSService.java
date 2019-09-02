package com.amap.api.location;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.loc.O0o;
import com.loc.O0o0000;
import com.loc.OO000OO;
import s.h.e.l.l.C;

public class APSService extends Service {
    APSServiceBase a;
    int b = 0;
    boolean c = false;

    static {
        C.i(2);
    }

    private boolean a() {
        if (OO000OO.O0000Oo(getApplicationContext())) {
            int i = -1;
            try {
                i = O0o.O00000Oo(getApplication().getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
            }
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public IBinder onBind(Intent intent) {
        try {
            return this.a.onBind(intent);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "APSService", "onBind");
            return null;
        }
    }

    public native void onCreate();

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037 A:{Catch:{ Throwable -> 0x0044 }} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037 A:{Catch:{ Throwable -> 0x0044 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0033 */
    /* JADX WARNING: Failed to process nested try/catch */
    public void onCreate(android.content.Context r8) {
        /*
        r7 = this;
        r0 = com.loc.OO0000.O00000o(r8);	 Catch:{ Throwable -> 0x0033 }
        if (r0 == 0) goto L_0x0029;
    L_0x0006:
        r2 = com.loc.O0o0000.O00000Oo();	 Catch:{ Throwable -> 0x0033 }
        r0 = "AY29tLmFtYXAuYXBpLmxvY2F0aW9uLkFQU1NlcnZpY2VXcmFwcGVy";
        r3 = com.loc.OO0o000.O00000o0(r0);	 Catch:{ Throwable -> 0x0033 }
        r4 = com.loc.OO00OO.class;
        r0 = 1;
        r5 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0033 }
        r1 = android.content.Context.class;
        r6 = 0;
        r5[r6] = r1;	 Catch:{ Throwable -> 0x0033 }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0033 }
        r0[r6] = r8;	 Catch:{ Throwable -> 0x0033 }
        r1 = r8;
        r6 = r0;
        r0 = com.loc.O000OOo.O000000o(r1, r2, r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0033 }
        r0 = (com.amap.api.location.APSServiceBase) r0;	 Catch:{ Throwable -> 0x0033 }
    L_0x0026:
        r7.a = r0;	 Catch:{ Throwable -> 0x0033 }
        goto L_0x0033;
    L_0x0029:
        r0 = r7.a;	 Catch:{ Throwable -> 0x0033 }
        if (r0 != 0) goto L_0x0033;
    L_0x002d:
        r0 = new com.loc.OO00OO;	 Catch:{ Throwable -> 0x0033 }
        r0.<init>(r8);	 Catch:{ Throwable -> 0x0033 }
        goto L_0x0026;
    L_0x0033:
        r0 = r7.a;	 Catch:{ Throwable -> 0x0044 }
        if (r0 != 0) goto L_0x003e;
    L_0x0037:
        r0 = new com.loc.OO00OO;	 Catch:{ Throwable -> 0x0044 }
        r0.<init>(r8);	 Catch:{ Throwable -> 0x0044 }
        r7.a = r0;	 Catch:{ Throwable -> 0x0044 }
    L_0x003e:
        r8 = r7.a;	 Catch:{ Throwable -> 0x0044 }
        r8.onCreate();	 Catch:{ Throwable -> 0x0044 }
        goto L_0x004c;
    L_0x0044:
        r8 = move-exception;
        r0 = "APSService";
        r1 = "onCreate";
        com.loc.O0o0000.O000000o(r8, r0, r1);
    L_0x004c:
        super.onCreate();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.APSService.onCreate(android.content.Context):void");
    }

    public void onDestroy() {
        try {
            this.a.onDestroy();
            if (this.c) {
                stopForeground(true);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0050 */
    /* JADX WARNING: Failed to process nested try/catch */
    public int onStartCommand(android.content.Intent r5, int r6, int r7) {
        /*
        r4 = this;
        if (r5 == 0) goto L_0x0050;
    L_0x0002:
        r0 = r4.a();	 Catch:{ Throwable -> 0x0050 }
        if (r0 == 0) goto L_0x0050;
    L_0x0008:
        r0 = "g";
        r1 = 0;
        r0 = r5.getIntExtra(r0, r1);	 Catch:{ Throwable -> 0x0050 }
        r2 = 1;
        if (r0 != r2) goto L_0x002f;
    L_0x0012:
        r0 = "i";
        r0 = r5.getIntExtra(r0, r1);	 Catch:{ Throwable -> 0x0050 }
        r1 = "h";
        r1 = r5.getParcelableExtra(r1);	 Catch:{ Throwable -> 0x0050 }
        r1 = (android.app.Notification) r1;	 Catch:{ Throwable -> 0x0050 }
        if (r0 == 0) goto L_0x0050;
    L_0x0022:
        if (r1 == 0) goto L_0x0050;
    L_0x0024:
        r4.startForeground(r0, r1);	 Catch:{ Throwable -> 0x0050 }
        r4.c = r2;	 Catch:{ Throwable -> 0x0050 }
        r0 = r4.b;	 Catch:{ Throwable -> 0x0050 }
        r0 = r0 + r2;
        r4.b = r0;	 Catch:{ Throwable -> 0x0050 }
        goto L_0x0050;
    L_0x002f:
        r3 = 2;
        if (r0 != r3) goto L_0x0050;
    L_0x0032:
        r0 = "j";
        r0 = r5.getBooleanExtra(r0, r2);	 Catch:{ Throwable -> 0x0050 }
        if (r0 == 0) goto L_0x0043;
    L_0x003a:
        r0 = r4.b;	 Catch:{ Throwable -> 0x0050 }
        if (r0 <= 0) goto L_0x0043;
    L_0x003e:
        r0 = r4.b;	 Catch:{ Throwable -> 0x0050 }
        r0 = r0 - r2;
        r4.b = r0;	 Catch:{ Throwable -> 0x0050 }
    L_0x0043:
        r0 = r4.b;	 Catch:{ Throwable -> 0x0050 }
        if (r0 > 0) goto L_0x004d;
    L_0x0047:
        r4.stopForeground(r2);	 Catch:{ Throwable -> 0x0050 }
        r4.c = r1;	 Catch:{ Throwable -> 0x0050 }
        goto L_0x0050;
    L_0x004d:
        r4.stopForeground(r1);	 Catch:{ Throwable -> 0x0050 }
    L_0x0050:
        r0 = r4.a;	 Catch:{ Throwable -> 0x0057 }
        r0 = r0.onStartCommand(r5, r6, r7);	 Catch:{ Throwable -> 0x0057 }
        return r0;
    L_0x0057:
        r0 = move-exception;
        r1 = "APSService";
        r2 = "onStartCommand";
        com.loc.O0o0000.O000000o(r0, r1, r2);
        r5 = super.onStartCommand(r5, r6, r7);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.APSService.onStartCommand(android.content.Intent, int, int):int");
    }
}
