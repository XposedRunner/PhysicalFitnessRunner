package com.amap.api.mapcore.util;

import java.util.ArrayList;

/* compiled from: MethodCallHelper */
public class Oo00 {
    ArrayList<O000000o> O000000o = new ArrayList();
    private boolean O00000Oo = false;

    /* compiled from: MethodCallHelper */
    public static class O000000o {
        private String O000000o;
        private Object O00000Oo;
        private Object[] O00000o;
        private Class<?>[] O00000o0;

        public O000000o(Object obj, String str, Object... objArr) {
            this.O00000Oo = obj;
            this.O000000o = str;
            if (objArr != null && objArr.length > 0) {
                int i = 0;
                this.O00000o0 = new Class[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    this.O00000o0[i2] = objArr[i2].getClass();
                }
                this.O00000o = new Object[objArr.length];
                while (i < objArr.length) {
                    this.O00000o[i] = objArr[i];
                    i++;
                }
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009b A:{Splitter:B:12:0x001c, ExcHandler: SecurityException (r3_9 'e' java.lang.SecurityException A:{Catch:{  }}), Catch:{ NoSuchMethodException -> 0x003f, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0096 A:{Splitter:B:12:0x001c, ExcHandler: IllegalAccessException (r3_8 'e' java.lang.IllegalAccessException A:{Catch:{  }}), Catch:{ NoSuchMethodException -> 0x003f, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0091 A:{Splitter:B:12:0x001c, ExcHandler: IllegalArgumentException (r3_7 'e' java.lang.IllegalArgumentException A:{Catch:{  }}), Catch:{ NoSuchMethodException -> 0x003f, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x008c A:{Splitter:B:12:0x001c, ExcHandler: InvocationTargetException (r3_6 'e' java.lang.reflect.InvocationTargetException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:24:0x0044, code skipped:
            if (com.amap.api.mapcore.util.Oo00.O000000o.O00000o0(r3).length > 0) goto L_0x0046;
     */
    /* JADX WARNING: Missing block: B:25:0x0046, code skipped:
            r5 = new java.lang.Class[com.amap.api.mapcore.util.Oo00.O000000o.O00000o0(r3).length];
            r6 = 0;
     */
    /* JADX WARNING: Missing block: B:27:0x0053, code skipped:
            if (r6 < com.amap.api.mapcore.util.Oo00.O000000o.O00000o0(r3).length) goto L_0x0055;
     */
    /* JADX WARNING: Missing block: B:29:0x0060, code skipped:
            if (com.amap.api.mapcore.util.Oo00.O000000o.O00000o0(r3)[r6].getInterfaces().length > 0) goto L_0x0062;
     */
    /* JADX WARNING: Missing block: B:30:0x0062, code skipped:
            r5[r6] = com.amap.api.mapcore.util.Oo00.O000000o.O00000o0(r3)[r6].getInterfaces()[0];
     */
    /* JADX WARNING: Missing block: B:31:0x0070, code skipped:
            r6 = r6 + 1;
     */
    /* JADX WARNING: Missing block: B:32:0x0073, code skipped:
            r5 = r4.getDeclaredMethod(com.amap.api.mapcore.util.Oo00.O000000o.O00000Oo(r3), r5);
     */
    /* JADX WARNING: Missing block: B:35:0x008c, code skipped:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            r3.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:38:0x0091, code skipped:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:39:0x0092, code skipped:
            r3.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:40:0x0096, code skipped:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:41:0x0097, code skipped:
            r3.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:42:0x009b, code skipped:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:43:0x009c, code skipped:
            r3.printStackTrace();
     */
    public synchronized void O000000o() {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.O00000Oo;	 Catch:{ all -> 0x00af }
        r1 = 1;
        if (r0 != r1) goto L_0x0008;
    L_0x0006:
        monitor-exit(r8);
        return;
    L_0x0008:
        r8.O00000Oo = r1;	 Catch:{ all -> 0x00af }
        r0 = 0;
        r2 = r0;
    L_0x000c:
        r3 = r8.O000000o;	 Catch:{ all -> 0x00af }
        r3 = r3.size();	 Catch:{ all -> 0x00af }
        if (r2 >= r3) goto L_0x00a8;
    L_0x0014:
        r3 = r8.O000000o;	 Catch:{ all -> 0x00af }
        r3 = r3.get(r2);	 Catch:{ all -> 0x00af }
        r3 = (com.amap.api.mapcore.util.Oo00.O000000o) r3;	 Catch:{ all -> 0x00af }
        r4 = r3.O00000Oo;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        if (r4 != 0) goto L_0x0024;
    L_0x0022:
        goto L_0x00a4;
    L_0x0024:
        r4 = r3.O00000Oo;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r4 = r4.getClass();	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        if (r4 != 0) goto L_0x0030;
    L_0x002e:
        goto L_0x00a4;
    L_0x0030:
        r5 = 0;
        r6 = r3.O000000o;	 Catch:{ NoSuchMethodException -> 0x003f, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r7 = r3.O00000o0;	 Catch:{ NoSuchMethodException -> 0x003f, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r6 = r4.getDeclaredMethod(r6, r7);	 Catch:{ NoSuchMethodException -> 0x003f, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r5 = r6;
        goto L_0x007b;
    L_0x003f:
        r6 = r3.O00000o0;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r6 = r6.length;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        if (r6 <= 0) goto L_0x007b;
    L_0x0046:
        r5 = r3.O00000o0;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r5 = r5.length;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r5 = new java.lang.Class[r5];	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r6 = r0;
    L_0x004e:
        r7 = r3.O00000o0;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r7 = r7.length;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        if (r6 >= r7) goto L_0x0073;
    L_0x0055:
        r7 = r3.O00000o0;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r7 = r7[r6];	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r7 = r7.getInterfaces();	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r7 = r7.length;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        if (r7 <= 0) goto L_0x0070;
    L_0x0062:
        r7 = r3.O00000o0;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r7 = r7[r6];	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r7 = r7.getInterfaces();	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r7 = r7[r0];	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r5[r6] = r7;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
    L_0x0070:
        r6 = r6 + 1;
        goto L_0x004e;
    L_0x0073:
        r6 = r3.O000000o;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r5 = r4.getDeclaredMethod(r6, r5);	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
    L_0x007b:
        if (r5 == 0) goto L_0x00a4;
    L_0x007d:
        r5.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r4 = r3.O00000Oo;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r3 = r3.O00000o;	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        r5.invoke(r4, r3);	 Catch:{ NoSuchMethodException -> 0x00a0, SecurityException -> 0x009b, IllegalAccessException -> 0x0096, IllegalArgumentException -> 0x0091, InvocationTargetException -> 0x008c }
        goto L_0x00a4;
    L_0x008c:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x00af }
        goto L_0x00a4;
    L_0x0091:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x00af }
        goto L_0x00a4;
    L_0x0096:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x00af }
        goto L_0x00a4;
    L_0x009b:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x00af }
        goto L_0x00a4;
    L_0x00a0:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x00af }
    L_0x00a4:
        r2 = r2 + 1;
        goto L_0x000c;
    L_0x00a8:
        r0 = r8.O000000o;	 Catch:{ all -> 0x00af }
        r0.clear();	 Catch:{ all -> 0x00af }
        monitor-exit(r8);
        return;
    L_0x00af:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.Oo00.O000000o():void");
    }

    public synchronized void O000000o(Object obj, Object... objArr) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length >= 3) {
                O000000o o000000o = new O000000o(obj, stackTrace[3].getMethodName(), objArr);
                if (o000000o != null) {
                    this.O000000o.add(o000000o);
                }
            }
        } catch (Throwable unused) {
        }
        this.O00000Oo = false;
    }
}
