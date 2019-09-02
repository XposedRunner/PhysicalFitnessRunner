package cn.jiguang.a.a.a;

import android.os.Handler;
import android.os.HandlerThread;

final class d {
    HandlerThread a = null;
    Handler b = null;
    private int c;
    private String d;

    public d(String str, int i) {
        this.c = i;
        this.d = str;
        this.a = new HandlerThread("ping timer");
        this.a.start();
        this.b = new Handler(this.a.getLooper(), new e(this));
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0082 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0076 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|16|17|18) */
    private void b(byte[] r12, int r13, int r14) {
        /*
        r11 = this;
        r0 = 4;
        r0 = new byte[r0];
        r1 = 0;
        r2 = r12[r1];
        r0[r1] = r2;
        r2 = 1;
        r3 = r12[r2];
        r0[r2] = r3;
        r3 = 2;
        r4 = r12[r3];
        r0[r3] = r4;
        r3 = 3;
        r0[r3] = r1;
        r1 = java.lang.Thread.currentThread();
        r4 = 0;
        r5 = r4;
    L_0x001b:
        if (r13 >= r14) goto L_0x0089;
    L_0x001d:
        r6 = (byte) r13;
        r0[r3] = r6;
        r6 = r0[r3];
        r7 = r12[r3];
        if (r6 == r7) goto L_0x0086;
    L_0x0026:
        r6 = cn.jiguang.a.a.a.c.a(r0);	 Catch:{ all -> 0x007b }
        r7 = r11.d;	 Catch:{ all -> 0x007b }
        r7 = r6.equalsIgnoreCase(r7);	 Catch:{ all -> 0x007b }
        if (r7 == 0) goto L_0x003c;
    L_0x0032:
        if (r5 == 0) goto L_0x0086;
    L_0x0034:
        r5.exitValue();	 Catch:{ Exception -> 0x0038 }
        goto L_0x0086;
    L_0x0038:
        r5.destroy();	 Catch:{ Exception -> 0x0086 }
        goto L_0x0086;
    L_0x003c:
        r7 = r11.b;	 Catch:{ all -> 0x007b }
        r7.removeCallbacksAndMessages(r4);	 Catch:{ all -> 0x007b }
        r7 = r11.b;	 Catch:{ all -> 0x007b }
        r7 = r7.obtainMessage(r2);	 Catch:{ all -> 0x007b }
        r7.obj = r1;	 Catch:{ all -> 0x007b }
        r8 = new android.os.Bundle;	 Catch:{ all -> 0x007b }
        r8.<init>();	 Catch:{ all -> 0x007b }
        r9 = "ip";
        r8.putString(r9, r6);	 Catch:{ all -> 0x007b }
        r7.setData(r8);	 Catch:{ all -> 0x007b }
        r8 = r11.b;	 Catch:{ all -> 0x007b }
        r9 = r11.c;	 Catch:{ all -> 0x007b }
        r9 = (long) r9;	 Catch:{ all -> 0x007b }
        r8.sendMessageDelayed(r7, r9);	 Catch:{ all -> 0x007b }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007b }
        r8 = "ping -c 1 -w 1 ";
        r7.<init>(r8);	 Catch:{ all -> 0x007b }
        r7.append(r6);	 Catch:{ all -> 0x007b }
        r6 = r7.toString();	 Catch:{ all -> 0x007b }
        r6 = cn.jiguang.a.a.a.c.b(r6);	 Catch:{ all -> 0x007b }
        if (r6 == 0) goto L_0x0079;
    L_0x0072:
        r6.exitValue();	 Catch:{ Exception -> 0x0076 }
        goto L_0x0079;
    L_0x0076:
        r6.destroy();	 Catch:{ Exception -> 0x0079 }
    L_0x0079:
        r5 = r6;
        goto L_0x0086;
    L_0x007b:
        r12 = move-exception;
        if (r5 == 0) goto L_0x0085;
    L_0x007e:
        r5.exitValue();	 Catch:{ Exception -> 0x0082 }
        goto L_0x0085;
    L_0x0082:
        r5.destroy();	 Catch:{ Exception -> 0x0085 }
    L_0x0085:
        throw r12;
    L_0x0086:
        r13 = r13 + 1;
        goto L_0x001b;
    L_0x0089:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.a.d.b(byte[], int, int):void");
    }

    public final void a(byte[] bArr, int i, int i2) {
        b(bArr, 0, 255);
        this.a.quit();
    }
}
