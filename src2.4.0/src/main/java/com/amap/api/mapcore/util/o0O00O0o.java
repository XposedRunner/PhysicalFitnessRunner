package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: AbstractBasicHandler */
public abstract class o0O00O0o<T, V> extends OO0OOo0 {
    protected T O000000o;
    protected int O00000Oo = 1;
    protected String O00000o;
    protected Context O00000o0;

    public o0O00O0o(Context context, T t) {
        O000000o(context, t);
    }

    private V O000000o(byte[] bArr) throws o0OoO00O {
        return O00000Oo(bArr);
    }

    private void O000000o(Context context, T t) {
        this.O00000o0 = context;
        this.O000000o = t;
        this.O00000Oo = 1;
        setSoTimeout(30000);
        setConnectionTimeout(30000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0083 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0002 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0035 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A:{SYNTHETIC, Splitter:B:3:0x0006, ExcHandler: Throwable (unused java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:12:0x0026, code skipped:
            r0 = new com.amap.api.mapcore.util.o0OoO00O("未知错误");
     */
    /* JADX WARNING: Missing block: B:15:0x002e, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:19:0x003e, code skipped:
            throw new com.amap.api.mapcore.util.o0OoO00O(r2.O000000o());
     */
    /* JADX WARNING: Missing block: B:20:0x003f, code skipped:
            r2 = e;
     */
    /* JADX WARNING: Missing block: B:25:?, code skipped:
            java.lang.Thread.sleep(1000);
     */
    /* JADX WARNING: Missing block: B:29:0x0056, code skipped:
            if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(r2.getMessage()) != false) goto L_0x007b;
     */
    /* JADX WARNING: Missing block: B:35:0x007a, code skipped:
            throw new com.amap.api.mapcore.util.o0OoO00O(r2.O000000o());
     */
    /* JADX WARNING: Missing block: B:37:0x0082, code skipped:
            throw new com.amap.api.mapcore.util.o0OoO00O("http或socket连接失败 - ConnectionException");
     */
    /* JADX WARNING: Missing block: B:38:0x0083, code skipped:
            O00000Oo();
     */
    /* JADX WARNING: Missing block: B:39:0x0090, code skipped:
            if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(r2.getMessage()) != false) goto L_0x00c1;
     */
    /* JADX WARNING: Missing block: B:47:0x00c0, code skipped:
            throw new com.amap.api.mapcore.util.o0OoO00O(r2.O000000o());
     */
    /* JADX WARNING: Missing block: B:49:0x00c8, code skipped:
            throw new com.amap.api.mapcore.util.o0OoO00O("http或socket连接失败 - ConnectionException");
     */
    private V O00000o0() throws com.amap.api.mapcore.util.o0OoO00O {
        /*
        r6 = this;
        r0 = 0;
        r1 = 0;
    L_0x0002:
        r2 = r6.O00000Oo;
        if (r1 >= r2) goto L_0x00c9;
    L_0x0006:
        r2 = r6.O00000o0;	 Catch:{ o0O0oo0o -> 0x003f, o0OoO00O -> 0x002e, Throwable -> 0x0026 }
        r2 = com.amap.api.mapcore.util.o0OO0OO0.O000000o(r2);	 Catch:{ o0O0oo0o -> 0x003f, o0OoO00O -> 0x002e, Throwable -> 0x0026 }
        r6.setProxy(r2);	 Catch:{ o0O0oo0o -> 0x003f, o0OoO00O -> 0x002e, Throwable -> 0x0026 }
        r2 = r6.makeHttpRequest();	 Catch:{ o0O0oo0o -> 0x003f, o0OoO00O -> 0x002e, Throwable -> 0x0026 }
        r2 = r6.O000000o(r2);	 Catch:{ o0O0oo0o -> 0x003f, o0OoO00O -> 0x002e, Throwable -> 0x0026 }
        r0 = r6.O00000Oo;	 Catch:{ o0O0oo0o -> 0x0021, o0OoO00O -> 0x001c, Throwable -> 0x0026 }
        r1 = r0;
        r0 = r2;
        goto L_0x0002;
    L_0x001c:
        r0 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x002f;
    L_0x0021:
        r0 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x0040;
    L_0x0026:
        r0 = new com.amap.api.mapcore.util.o0OoO00O;
        r1 = "未知错误";
        r0.<init>(r1);
        throw r0;
    L_0x002e:
        r2 = move-exception;
    L_0x002f:
        r1 = r1 + 1;
        r3 = r6.O00000Oo;
        if (r1 < r3) goto L_0x0002;
    L_0x0035:
        r0 = new com.amap.api.mapcore.util.o0OoO00O;
        r1 = r2.O000000o();
        r0.<init>(r1);
        throw r0;
    L_0x003f:
        r2 = move-exception;
    L_0x0040:
        r1 = r1 + 1;
        r3 = r6.O00000Oo;
        if (r1 >= r3) goto L_0x0083;
    L_0x0046:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        java.lang.Thread.sleep(r3);	 Catch:{ InterruptedException -> 0x004c }
        goto L_0x0002;
    L_0x004c:
        r0 = "http连接失败 - ConnectionException";
        r1 = r2.getMessage();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x007b;
    L_0x0058:
        r0 = "socket 连接异常 - SocketException";
        r1 = r2.getMessage();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x007b;
    L_0x0064:
        r0 = "服务器连接失败 - UnknownServiceException";
        r1 = r2.getMessage();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0071;
    L_0x0070:
        goto L_0x007b;
    L_0x0071:
        r0 = new com.amap.api.mapcore.util.o0OoO00O;
        r1 = r2.O000000o();
        r0.<init>(r1);
        throw r0;
    L_0x007b:
        r0 = new com.amap.api.mapcore.util.o0OoO00O;
        r1 = "http或socket连接失败 - ConnectionException";
        r0.<init>(r1);
        throw r0;
    L_0x0083:
        r6.O00000Oo();
        r0 = "http连接失败 - ConnectionException";
        r1 = r2.getMessage();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x00c1;
    L_0x0092:
        r0 = "socket 连接异常 - SocketException";
        r1 = r2.getMessage();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x00c1;
    L_0x009e:
        r0 = "未知的错误";
        r1 = r2.O000000o();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x00c1;
    L_0x00aa:
        r0 = "服务器连接失败 - UnknownServiceException";
        r1 = r2.getMessage();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b7;
    L_0x00b6:
        goto L_0x00c1;
    L_0x00b7:
        r0 = new com.amap.api.mapcore.util.o0OoO00O;
        r1 = r2.O000000o();
        r0.<init>(r1);
        throw r0;
    L_0x00c1:
        r0 = new com.amap.api.mapcore.util.o0OoO00O;
        r1 = "http或socket连接失败 - ConnectionException";
        r0.<init>(r1);
        throw r0;
    L_0x00c9:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0O00O0o.O00000o0():java.lang.Object");
    }

    public V O000000o() throws o0OoO00O {
        return this.O000000o != null ? O00000o0() : null;
    }

    /* Access modifiers changed, original: protected */
    public V O00000Oo() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public V O00000Oo(byte[] bArr) throws o0OoO00O {
        Object str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        o0O00Oo0.O000000o(str, this.O00000o);
        return O00000o0(str);
    }

    public abstract V O00000o0(String str) throws o0OoO00O;
}
