package cn.jiguang.d.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.d.d.b;
import cn.jiguang.d.e.a.a.c;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

public final class h {
    private static h f;
    private Map<String, i> a = new ConcurrentHashMap();
    private Deque<i> b = new LinkedBlockingDeque();
    private Deque<i> c = new LinkedBlockingDeque();
    private Handler d;
    private Context e;

    public static h a() {
        if (f == null) {
            f = new h();
        }
        return f;
    }

    private synchronized i a(String str) {
        i iVar;
        iVar = null;
        for (i iVar2 : this.c) {
            if (str.equals(iVar2.a())) {
                this.c.remove(iVar2);
                iVar = iVar2;
            }
        }
        return iVar;
    }

    private static String b(long j, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append("|");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private synchronized void c(i iVar) {
        if (iVar != null) {
            Object obj;
            for (i a : this.c) {
                if (a.a().equals(iVar.a())) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                this.c.offerLast(iVar);
            }
        }
    }

    private void d(i iVar) {
        if (iVar != null) {
            this.a.remove(iVar.a());
            this.b.remove(iVar);
            this.d.removeMessages(7403, iVar);
        }
    }

    private void e(i iVar) {
        if (iVar != null) {
            this.d.removeMessages(7404, iVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    private void f(cn.jiguang.d.b.i r10) {
        /*
        r9 = this;
        if (r10 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = cn.jiguang.d.a.d.a();	 Catch:{ Throwable -> 0x005a }
        r1 = 0;
        r1 = cn.jiguang.d.a.d.c(r1);	 Catch:{ Throwable -> 0x005a }
        r3 = r10.d;	 Catch:{ Throwable -> 0x005a }
        r0 = cn.jiguang.d.e.a.a.b.a(r0, r1, r3);	 Catch:{ Throwable -> 0x005a }
        r1 = 1;
        r0 = cn.jiguang.d.e.a.a.b.a(r0, r1);	 Catch:{ Throwable -> 0x005a }
        if (r0 == 0) goto L_0x0055;
    L_0x0019:
        r1 = cn.jiguang.d.b.g.a;	 Catch:{ Throwable -> 0x005a }
        r1 = r1.get();	 Catch:{ Throwable -> 0x005a }
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x004d;
    L_0x0025:
        r1 = cn.jiguang.d.g.c.a();	 Catch:{ Throwable -> 0x005a }
        r1 = r1.b();	 Catch:{ Throwable -> 0x005a }
        r0 = r1.a(r0);	 Catch:{ Throwable -> 0x005a }
        r1 = 6026; // 0x178a float:8.444E-42 double:2.977E-320;
        if (r0 != r1) goto L_0x005a;
    L_0x0035:
        r9.e(r10);	 Catch:{ Throwable -> 0x005a }
        r9.d(r10);	 Catch:{ Throwable -> 0x005a }
        r2 = cn.jiguang.d.d.b.a();	 Catch:{ Throwable -> 0x005a }
        r3 = r9.e;	 Catch:{ Throwable -> 0x005a }
        r4 = r10.f;	 Catch:{ Throwable -> 0x005a }
        r5 = r10.c;	 Catch:{ Throwable -> 0x005a }
        r7 = r10.e;	 Catch:{ Throwable -> 0x005a }
        r8 = 6026; // 0x178a float:8.444E-42 double:2.977E-320;
        r2.a(r3, r4, r5, r7, r8);	 Catch:{ Throwable -> 0x005a }
        return;
    L_0x004d:
        r0 = "RequestCacheManager";
        r1 = "sendCommandWithLoggedIn failed: tcp not connect";
    L_0x0051:
        cn.jiguang.e.c.c(r0, r1);	 Catch:{ Throwable -> 0x005a }
        goto L_0x005a;
    L_0x0055:
        r0 = "RequestCacheManager";
        r1 = "sendCommandWithLoggedIn failed:sendData is null";
        goto L_0x0051;
    L_0x005a:
        r9.c(r10);
        if (r10 == 0) goto L_0x006e;
    L_0x005f:
        r0 = r9.d;
        r1 = 7404; // 0x1cec float:1.0375E-41 double:3.658E-320;
        r10 = android.os.Message.obtain(r0, r1, r10);
        r0 = r9.d;
        r1 = 9800; // 0x2648 float:1.3733E-41 double:4.842E-320;
        r0.sendMessageDelayed(r10, r1);
    L_0x006e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.b.h.f(cn.jiguang.d.b.i):void");
    }

    public final void a(long j, String str, Object obj) {
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            g.a.get();
            i a = a(b(cVar.b().longValue(), str));
            if (a != null) {
                e(a);
                a = (i) this.a.get(a.a());
                if (a != null) {
                    d(a);
                }
            }
        }
    }

    public final void a(Context context, Handler handler) {
        this.e = context;
        this.d = handler;
    }

    public final void a(i iVar) {
        if (iVar != null && a(iVar.a()) != null) {
            if (iVar.a > 0) {
                d.a();
                if (d.d()) {
                    iVar.a -= 10000;
                    iVar.b++;
                    f(iVar);
                } else {
                    this.b.offerFirst(iVar);
                }
                if (iVar.b >= 2) {
                    this.d.sendEmptyMessageDelayed(1005, 2000);
                    return;
                }
            }
            b(iVar);
        }
    }

    public final void a(String str, Object obj) {
        Message obtain = Message.obtain(this.d, 7402, obj);
        Bundle bundle = new Bundle();
        bundle.putLong("connection", g.a.get());
        bundle.putString("request_sdktype", str);
        obtain.setData(bundle);
        obtain.sendToTarget();
    }

    public final void a(byte[] bArr, String str, int i) {
        if (bArr != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("request_timeout", i);
            bundle.putByteArray("request_data", bArr);
            bundle.putString("request_sdktype", str);
            Message obtain = Message.obtain(this.d, 7401);
            obtain.setData(bundle);
            obtain.sendToTarget();
        }
    }

    public final void b() {
        this.d.removeMessages(7404);
        while (true) {
            i iVar = (i) this.c.pollLast();
            if (iVar != null) {
                this.b.offerFirst(iVar);
            } else {
                return;
            }
        }
    }

    public final void b(i iVar) {
        if (iVar != null) {
            d(iVar);
            b.a();
            Context context = this.e;
            String str = iVar.f;
            long j = iVar.c;
            int i = iVar.e;
            if (TextUtils.isEmpty(str)) {
                b.b(context, j, i);
                return;
            }
            JAction jAction = (JAction) b.a.get(str);
            if (jAction == null) {
                b.b(context, j, i);
            } else {
                jAction.dispatchTimeOutMessage(context, g.a.get(), j, i);
            }
        }
    }

    public final void b(byte[] bArr, String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("Action - sendRequestInternal - connection:");
        stringBuilder.append(g.a.get());
        stringBuilder.append(", timeout:");
        stringBuilder.append(i);
        stringBuilder.append(",sdkType:");
        stringBuilder.append(str);
        stringBuilder.append(", threadId:");
        stringBuilder.append(Thread.currentThread().getId());
        cn.jiguang.e.c.a("RequestCacheManager", stringBuilder.toString());
        if (bArr != null) {
            if (this.a.size() > 200) {
                cn.jiguang.e.c.c("RequestCacheManager", "sendRequestInternal failed,cache is full");
                return;
            }
            i iVar = new i(bArr, str, i);
            this.a.put(iVar.a(), iVar);
            if (i > 10000) {
                this.d.sendMessageDelayed(Message.obtain(this.d, 7403, iVar), (long) iVar.a);
            }
            f(iVar);
        }
    }

    public final void c() {
        while (true) {
            i iVar = (i) this.b.pollFirst();
            if (iVar == null) {
                return;
            }
            if (iVar.e == 2) {
                this.b.remove(iVar);
                this.a.remove(iVar.a());
            } else {
                f(iVar);
            }
        }
    }
}
