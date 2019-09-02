package cn.jiguang.d.b;

import android.os.Handler;
import android.os.Looper;

final class f extends Handler {
    final /* synthetic */ d a;

    public f(d dVar, Looper looper) {
        this.a = dVar;
        super(looper);
    }

    /* JADX WARNING: Missing block: B:40:0x0083, code skipped:
            cn.jiguang.e.c.c(r5, r0);
     */
    /* JADX WARNING: Missing block: B:41:0x0086, code skipped:
            return;
     */
    public final void handleMessage(android.os.Message r5) {
        /*
        r4 = this;
        super.handleMessage(r5);
        r0 = "";
        r1 = r5.getData();	 Catch:{ Throwable -> 0x0174 }
        if (r1 == 0) goto L_0x0011;
    L_0x000b:
        r0 = "sdktype";
        r0 = r1.getString(r0);	 Catch:{ Throwable -> 0x0174 }
    L_0x0011:
        r2 = cn.jiguang.g.i.a(r0);	 Catch:{ Throwable -> 0x0174 }
        if (r2 != 0) goto L_0x002d;
    L_0x0017:
        r2 = cn.jiguang.d.a.a;	 Catch:{ Throwable -> 0x0174 }
        r2 = r0.equals(r2);	 Catch:{ Throwable -> 0x0174 }
        if (r2 == 0) goto L_0x0020;
    L_0x001f:
        goto L_0x002d;
    L_0x0020:
        cn.jiguang.d.d.b.a();	 Catch:{ Throwable -> 0x0174 }
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.h;	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.d.d.b.a(r5, r0, r1);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x002d:
        r0 = r5.what;	 Catch:{ Throwable -> 0x0174 }
        r1 = 1022; // 0x3fe float:1.432E-42 double:5.05E-321;
        if (r0 == r1) goto L_0x016f;
    L_0x0033:
        r1 = 1032; // 0x408 float:1.446E-42 double:5.1E-321;
        if (r0 == r1) goto L_0x0161;
    L_0x0037:
        r1 = 7301; // 0x1c85 float:1.0231E-41 double:3.607E-320;
        if (r0 == r1) goto L_0x0151;
    L_0x003b:
        r1 = 1;
        r2 = 0;
        switch(r0) {
            case 1001: goto L_0x013a;
            case 1002: goto L_0x0130;
            case 1003: goto L_0x012a;
            case 1004: goto L_0x0124;
            case 1005: goto L_0x011e;
            case 1006: goto L_0x0116;
            case 1007: goto L_0x0116;
            default: goto L_0x0040;
        };	 Catch:{ Throwable -> 0x0174 }
    L_0x0040:
        switch(r0) {
            case 1010: goto L_0x0104;
            case 1011: goto L_0x00fe;
            default: goto L_0x0043;
        };	 Catch:{ Throwable -> 0x0174 }
    L_0x0043:
        switch(r0) {
            case 7303: goto L_0x00ee;
            case 7304: goto L_0x00de;
            default: goto L_0x0046;
        };	 Catch:{ Throwable -> 0x0174 }
    L_0x0046:
        switch(r0) {
            case 7306: goto L_0x00cc;
            case 7307: goto L_0x00c6;
            default: goto L_0x0049;
        };	 Catch:{ Throwable -> 0x0174 }
    L_0x0049:
        switch(r0) {
            case 7401: goto L_0x00a1;
            case 7402: goto L_0x0079;
            case 7403: goto L_0x0063;
            case 7404: goto L_0x004d;
            default: goto L_0x004c;
        };	 Catch:{ Throwable -> 0x0174 }
    L_0x004c:
        return;
    L_0x004d:
        r0 = r5.obj;	 Catch:{ Throwable -> 0x0174 }
        if (r0 == 0) goto L_0x0174;
    L_0x0051:
        r0 = r5.obj;	 Catch:{ Throwable -> 0x0174 }
        r0 = r0 instanceof cn.jiguang.d.b.i;	 Catch:{ Throwable -> 0x0174 }
        if (r0 == 0) goto L_0x0174;
    L_0x0057:
        r0 = cn.jiguang.d.b.h.a();	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.obj;	 Catch:{ Throwable -> 0x0174 }
        r5 = (cn.jiguang.d.b.i) r5;	 Catch:{ Throwable -> 0x0174 }
        r0.a(r5);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x0063:
        r0 = r5.obj;	 Catch:{ Throwable -> 0x0174 }
        if (r0 == 0) goto L_0x0174;
    L_0x0067:
        r0 = r5.obj;	 Catch:{ Throwable -> 0x0174 }
        r0 = r0 instanceof cn.jiguang.d.b.i;	 Catch:{ Throwable -> 0x0174 }
        if (r0 == 0) goto L_0x0174;
    L_0x006d:
        r0 = cn.jiguang.d.b.h.a();	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.obj;	 Catch:{ Throwable -> 0x0174 }
        r5 = (cn.jiguang.d.b.i) r5;	 Catch:{ Throwable -> 0x0174 }
        r0.b(r5);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x0079:
        r0 = r5.getData();	 Catch:{ Throwable -> 0x0174 }
        if (r0 != 0) goto L_0x0087;
    L_0x007f:
        r5 = "JiguangTcpManager";
        r0 = "Unexpected - msg response bundle is null.";
    L_0x0083:
        cn.jiguang.e.c.c(r5, r0);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x0087:
        r1 = "request_sdktype";
        r0 = r0.getString(r1);	 Catch:{ Throwable -> 0x0174 }
        r1 = cn.jiguang.d.b.h.a();	 Catch:{ Throwable -> 0x0174 }
        r2 = r5.getData();	 Catch:{ Throwable -> 0x0174 }
        r3 = "connection";
        r2 = r2.getLong(r3);	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.obj;	 Catch:{ Throwable -> 0x0174 }
        r1.a(r2, r0, r5);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x00a1:
        r5 = r5.getData();	 Catch:{ Throwable -> 0x0174 }
        if (r5 != 0) goto L_0x00ac;
    L_0x00a7:
        r5 = "JiguangTcpManager";
        r0 = "Unexpected - want to send null request.";
        goto L_0x0083;
    L_0x00ac:
        r0 = "request_timeout";
        r0 = r5.getInt(r0);	 Catch:{ Throwable -> 0x0174 }
        r1 = "request_data";
        r1 = r5.getByteArray(r1);	 Catch:{ Throwable -> 0x0174 }
        r2 = "request_sdktype";
        r5 = r5.getString(r2);	 Catch:{ Throwable -> 0x0174 }
        r2 = cn.jiguang.d.b.h.a();	 Catch:{ Throwable -> 0x0174 }
        r2.b(r1, r5, r0);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x00c6:
        r5 = cn.jiguang.d.b.g.b;	 Catch:{ Throwable -> 0x0174 }
        r5.set(r2);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x00cc:
        r0 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r1 = r5.getData();	 Catch:{ Throwable -> 0x0174 }
        r2 = "connection";
        r1 = r1.getLong(r2);	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.arg2;	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.d.b.d.a(r0, r1, r5);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x00de:
        r0 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.getData();	 Catch:{ Throwable -> 0x0174 }
        r1 = "connection";
        r1 = r5.getLong(r1);	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.d.b.d.a(r0, r1);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x00ee:
        r0 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.getData();	 Catch:{ Throwable -> 0x0174 }
        r1 = "connection";
        r1 = r5.getLong(r1);	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.d.b.d.c(r0, r1);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x00fe:
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r5.e();	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x0104:
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.a;	 Catch:{ Throwable -> 0x0174 }
        if (r5 == 0) goto L_0x0174;
    L_0x010c:
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.a;	 Catch:{ Throwable -> 0x0174 }
        r5.c();	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x0116:
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r2 = 0;
        r5.a(r1, r2);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x011e:
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.d.b.d.a(r5, r2);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x0124:
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.d.b.d.a(r5, r1);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x012a:
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.d.b.d.b(r5);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x0130:
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.h;	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.a.c.c.a(r5, r2);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x013a:
        r5 = cn.jiguang.d.d.l.a();	 Catch:{ Throwable -> 0x0174 }
        r0 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r0 = r0.h;	 Catch:{ Throwable -> 0x0174 }
        r5.b(r0, r1);	 Catch:{ Throwable -> 0x0174 }
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.h;	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.d.d.d.a(r5, r2);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x0151:
        r0 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r5 = r5.getData();	 Catch:{ Throwable -> 0x0174 }
        r1 = "connection";
        r1 = r5.getLong(r1);	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.d.b.d.b(r0, r1);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x0161:
        r5 = cn.jiguang.d.d.f.a();	 Catch:{ Throwable -> 0x0174 }
        r0 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        r0 = r0.h;	 Catch:{ Throwable -> 0x0174 }
        r5.a(r0);	 Catch:{ Throwable -> 0x0174 }
        return;
    L_0x016f:
        r5 = r4.a;	 Catch:{ Throwable -> 0x0174 }
        cn.jiguang.d.b.d.d(r5);	 Catch:{ Throwable -> 0x0174 }
    L_0x0174:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.b.f.handleMessage(android.os.Message):void");
    }
}
