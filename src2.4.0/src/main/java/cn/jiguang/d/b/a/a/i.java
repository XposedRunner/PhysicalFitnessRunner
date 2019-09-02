package cn.jiguang.d.b.a.a;

import android.text.TextUtils;
import cn.jiguang.d.b.a.a;
import cn.jiguang.d.b.a.c;
import cn.jiguang.d.b.a.d;
import cn.jiguang.d.b.g;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class i {
    final d a;

    public i(d dVar) {
        this.a = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0168  */
    private cn.jiguang.d.b.a.a a(java.net.InetAddress r21, int r22, java.lang.String r23, java.net.DatagramSocket r24) {
        /*
        r20 = this;
        r1 = r20;
        r10 = r22;
        r11 = r21.getHostAddress();
        r2 = java.lang.System.currentTimeMillis();
        r4 = cn.jiguang.d.a.a.r();
        r6 = r2 + r4;
        r2 = 0;
        r4 = 0;
        r5 = r1.a;	 Catch:{ Exception -> 0x012f }
        r5 = r5.c();	 Catch:{ Exception -> 0x012f }
        r8 = new java.net.DatagramPacket;	 Catch:{ e -> 0x012b, all -> 0x0125 }
        r9 = r5.length;	 Catch:{ e -> 0x012b, all -> 0x0125 }
        r12 = r21;
        r8.<init>(r5, r9, r12, r10);	 Catch:{ e -> 0x012b, all -> 0x0125 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ e -> 0x012b, all -> 0x0125 }
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r7 = r24;
        r7 = cn.jiguang.d.d.d.a(r7, r8);	 Catch:{ Exception -> 0x00d5, e -> 0x00d0, all -> 0x00c9 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00d5, e -> 0x00d0, all -> 0x00c9 }
        r14 = r8 - r12;
        r8 = r14 / r5;
        r2 = cn.jiguang.d.a.a.a(r12);	 Catch:{ Exception -> 0x00c7 }
        r5 = cn.jiguang.d.b.a.d.a(r7);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r6 = new java.lang.String;	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r5 = r5.b;	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r6.<init>(r5);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r5 = cn.jiguang.d.d.d.a(r6);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r6 = 5;
        if (r5 != 0) goto L_0x0061;
    L_0x004d:
        r5 = new cn.jiguang.d.b.a.e;	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7 = new java.lang.StringBuilder;	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r12 = "Can not parse sis info from host: ";
        r7.<init>(r12);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7.append(r11);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7 = r7.toString();	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r5.<init>(r6, r7);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        throw r5;	 Catch:{ e -> 0x00c3, all -> 0x00bd }
    L_0x0061:
        r5.h();	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7 = "SisPolicy";
        r12 = new java.lang.StringBuilder;	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r13 = "Get sis info succeed with host: ";
        r12.<init>(r13);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r12.append(r11);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r13 = " type:";
        r12.append(r13);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r13 = r23;
        r12.append(r13);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r12 = r12.toString();	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        cn.jiguang.e.c.b(r7, r12);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        cn.jiguang.d.a.a.e();	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7 = r5.g();	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        cn.jiguang.d.a.a.a(r7);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7 = r1.a;	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r12 = cn.jiguang.d.b.a.a.a(r5);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7.a(r12);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r5 = cn.jiguang.d.b.a.a.b(r5);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7 = r5.a();	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        if (r7 == 0) goto L_0x00b2;
    L_0x009e:
        r5 = new cn.jiguang.d.b.a.e;	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7 = new java.lang.StringBuilder;	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r12 = "sis address is Empty from host:";
        r7.<init>(r12);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7.append(r11);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r7 = r7.toString();	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        r5.<init>(r6, r7);	 Catch:{ e -> 0x00c3, all -> 0x00bd }
        throw r5;	 Catch:{ e -> 0x00c3, all -> 0x00bd }
    L_0x00b2:
        r2 = r1.a;
        r3 = new cn.jiguang.d.b.a.c;
        r3.<init>(r11, r10);
        r2.c(r3);
        return r5;
    L_0x00bd:
        r0 = move-exception;
        r12 = r0;
        r5 = r2;
        r13 = r4;
        goto L_0x0157;
    L_0x00c3:
        r0 = move-exception;
        r6 = r2;
        goto L_0x012d;
    L_0x00c7:
        r0 = move-exception;
        goto L_0x00d7;
    L_0x00c9:
        r0 = move-exception;
        r7 = r2;
    L_0x00cb:
        r5 = r12;
        r12 = r0;
        r13 = r4;
        goto L_0x0158;
    L_0x00d0:
        r0 = move-exception;
        r8 = r2;
        r6 = r12;
        goto L_0x012d;
    L_0x00d5:
        r0 = move-exception;
        r8 = r2;
    L_0x00d7:
        r2 = r0;
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ e -> 0x0121, all -> 0x011e }
        r16 = r14 - r12;
        r5 = r16 / r5;
        r7 = cn.jiguang.d.a.a.a(r12);	 Catch:{ e -> 0x011a, all -> 0x0117 }
        r3 = new cn.jiguang.d.b.a.e;	 Catch:{ e -> 0x010f, all -> 0x0105 }
        r9 = 2;
        r12 = new java.lang.StringBuilder;	 Catch:{ e -> 0x010f, all -> 0x0105 }
        r13 = "Can not get sis response from host: - ";
        r12.<init>(r13);	 Catch:{ e -> 0x010f, all -> 0x0105 }
        r12.append(r11);	 Catch:{ e -> 0x010f, all -> 0x0105 }
        r13 = " - ";
        r12.append(r13);	 Catch:{ e -> 0x010f, all -> 0x0105 }
        r2 = r2.getMessage();	 Catch:{ e -> 0x010f, all -> 0x0105 }
        r12.append(r2);	 Catch:{ e -> 0x010f, all -> 0x0105 }
        r2 = r12.toString();	 Catch:{ e -> 0x010f, all -> 0x0105 }
        r3.<init>(r9, r2);	 Catch:{ e -> 0x010f, all -> 0x0105 }
        throw r3;	 Catch:{ e -> 0x010f, all -> 0x0105 }
    L_0x0105:
        r0 = move-exception;
        r12 = r0;
        r13 = r4;
        r18 = r5;
        r5 = r7;
        r7 = r18;
        goto L_0x0158;
    L_0x010f:
        r0 = move-exception;
        r2 = r0;
        r18 = r5;
        r6 = r7;
        r8 = r18;
        goto L_0x014a;
    L_0x0117:
        r0 = move-exception;
        r7 = r5;
        goto L_0x00cb;
    L_0x011a:
        r0 = move-exception;
        r2 = r0;
        r8 = r5;
        goto L_0x0123;
    L_0x011e:
        r0 = move-exception;
        r7 = r8;
        goto L_0x00cb;
    L_0x0121:
        r0 = move-exception;
        r2 = r0;
    L_0x0123:
        r6 = r12;
        goto L_0x014a;
    L_0x0125:
        r0 = move-exception;
        r12 = r0;
        r13 = r4;
        r5 = r6;
        r7 = r2;
        goto L_0x0158;
    L_0x012b:
        r0 = move-exception;
        r8 = r2;
    L_0x012d:
        r2 = r0;
        goto L_0x014a;
    L_0x012f:
        r0 = move-exception;
        r5 = r0;
        r8 = new cn.jiguang.d.b.a.e;	 Catch:{ e -> 0x012b, all -> 0x0125 }
        r9 = 1;
        r12 = new java.lang.StringBuilder;	 Catch:{ e -> 0x012b, all -> 0x0125 }
        r13 = "Failed to package data - ";
        r12.<init>(r13);	 Catch:{ e -> 0x012b, all -> 0x0125 }
        r5 = r5.getMessage();	 Catch:{ e -> 0x012b, all -> 0x0125 }
        r12.append(r5);	 Catch:{ e -> 0x012b, all -> 0x0125 }
        r5 = r12.toString();	 Catch:{ e -> 0x012b, all -> 0x0125 }
        r8.<init>(r9, r5);	 Catch:{ e -> 0x012b, all -> 0x0125 }
        throw r8;	 Catch:{ e -> 0x012b, all -> 0x0125 }
    L_0x014a:
        r3 = r2.a();	 Catch:{ all -> 0x0153 }
        throw r2;	 Catch:{ all -> 0x014f }
    L_0x014f:
        r0 = move-exception;
        r12 = r0;
        r13 = r3;
        goto L_0x0156;
    L_0x0153:
        r0 = move-exception;
        r12 = r0;
        r13 = r4;
    L_0x0156:
        r5 = r6;
    L_0x0157:
        r7 = r8;
    L_0x0158:
        if (r13 == 0) goto L_0x0168;
    L_0x015a:
        r2 = r1.a;
        r3 = r11;
        r4 = r10;
        r9 = r13;
        r2.a(r3, r4, r5, r7, r9);
        r2 = r1.a;
        r2.a(r11, r10, r13);
        goto L_0x0172;
    L_0x0168:
        r2 = r1.a;
        r3 = new cn.jiguang.d.b.a.c;
        r3.<init>(r11, r10);
        r2.c(r3);
    L_0x0172:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.b.a.a.i.a(java.net.InetAddress, int, java.lang.String, java.net.DatagramSocket):cn.jiguang.d.b.a.a");
    }

    public abstract int a();

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a4 A:{SYNTHETIC, Splitter:B:42:0x00a4} */
    /* JADX WARNING: Missing block: B:26:0x0089, code skipped:
            if (r1 != null) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:28:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:29:0x008e, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:37:0x009d, code skipped:
            if (r1 != null) goto L_0x008b;
     */
    /* JADX WARNING: Missing block: B:38:0x00a0, code skipped:
            return null;
     */
    public final cn.jiguang.d.b.a.a a(cn.jiguang.d.b.a.a r9) {
        /*
        r8 = this;
        r0 = 0;
        if (r9 == 0) goto L_0x00a8;
    L_0x0003:
        r1 = r9.a();
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = new java.net.DatagramSocket;	 Catch:{ Throwable -> 0x0094, all -> 0x0091 }
        r1.<init>();	 Catch:{ Throwable -> 0x0094, all -> 0x0091 }
        r9 = r9.b();	 Catch:{ Throwable -> 0x008f }
    L_0x0013:
        r2 = r9.hasNext();	 Catch:{ Throwable -> 0x008f }
        if (r2 == 0) goto L_0x0089;
    L_0x0019:
        r2 = r9.next();	 Catch:{ Throwable -> 0x008f }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ Throwable -> 0x008f }
        r3 = r2.getKey();	 Catch:{ Throwable -> 0x008f }
        r3 = (cn.jiguang.d.b.a.c) r3;	 Catch:{ Throwable -> 0x008f }
        r2 = r2.getValue();	 Catch:{ Throwable -> 0x008f }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x008f }
        r4 = r3.a;	 Catch:{ Throwable -> 0x008f }
        r4 = cn.jiguang.d.d.d.b(r4);	 Catch:{ Throwable -> 0x008f }
        if (r4 == 0) goto L_0x0013;
    L_0x0033:
        r5 = r4.getHostAddress();	 Catch:{ Throwable -> 0x008f }
        r3.a = r5;	 Catch:{ Throwable -> 0x008f }
        r5 = "SisPolicy";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x008f }
        r7 = "To get sis - host:";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x008f }
        r7 = r3.a;	 Catch:{ Throwable -> 0x008f }
        r6.append(r7);	 Catch:{ Throwable -> 0x008f }
        r7 = ", port:";
        r6.append(r7);	 Catch:{ Throwable -> 0x008f }
        r7 = r3.b;	 Catch:{ Throwable -> 0x008f }
        r6.append(r7);	 Catch:{ Throwable -> 0x008f }
        r7 = " ,type:";
        r6.append(r7);	 Catch:{ Throwable -> 0x008f }
        r6.append(r2);	 Catch:{ Throwable -> 0x008f }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x008f }
        cn.jiguang.e.c.a(r5, r6);	 Catch:{ Throwable -> 0x008f }
        r5 = r8.a;	 Catch:{ Throwable -> 0x008f }
        r5 = r5.a(r3);	 Catch:{ Throwable -> 0x008f }
        if (r5 != 0) goto L_0x0013;
    L_0x0068:
        r3 = r3.b;	 Catch:{ Throwable -> 0x0074 }
        r2 = r8.a(r4, r3, r2, r1);	 Catch:{ Throwable -> 0x0074 }
        if (r1 == 0) goto L_0x0073;
    L_0x0070:
        r1.close();	 Catch:{ Throwable -> 0x0073 }
    L_0x0073:
        return r2;
    L_0x0074:
        r2 = move-exception;
        r3 = "SisPolicy";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x008f }
        r5 = "singleSendSis failed, error:";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x008f }
        r4.append(r2);	 Catch:{ Throwable -> 0x008f }
        r2 = r4.toString();	 Catch:{ Throwable -> 0x008f }
        cn.jiguang.e.c.c(r3, r2);	 Catch:{ Throwable -> 0x008f }
        goto L_0x0013;
    L_0x0089:
        if (r1 == 0) goto L_0x00a0;
    L_0x008b:
        r1.close();	 Catch:{ Throwable -> 0x00a0 }
        return r0;
    L_0x008f:
        r9 = move-exception;
        goto L_0x0096;
    L_0x0091:
        r9 = move-exception;
        r1 = r0;
        goto L_0x00a2;
    L_0x0094:
        r9 = move-exception;
        r1 = r0;
    L_0x0096:
        r2 = "SisPolicy";
        r3 = "Get sis info error :";
        cn.jiguang.e.c.a(r2, r3, r9);	 Catch:{ all -> 0x00a1 }
        if (r1 == 0) goto L_0x00a0;
    L_0x009f:
        goto L_0x008b;
    L_0x00a0:
        return r0;
    L_0x00a1:
        r9 = move-exception;
    L_0x00a2:
        if (r1 == 0) goto L_0x00a7;
    L_0x00a4:
        r1.close();	 Catch:{ Throwable -> 0x00a7 }
    L_0x00a7:
        throw r9;
    L_0x00a8:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.b.a.a.i.a(cn.jiguang.d.b.a.a):cn.jiguang.d.b.a.a");
    }

    public final int b(a aVar) {
        if (aVar == null || aVar.a()) {
            return -1;
        }
        Iterator b = aVar.b();
        while (b.hasNext()) {
            if (this.a.e().d()) {
                return 2;
            }
            Entry entry = (Entry) b.next();
            c cVar = (c) entry.getKey();
            String str = (String) entry.getValue();
            int i = 1;
            int i2 = (TextUtils.isEmpty(cVar.a) || cVar.b <= 0) ? 0 : 1;
            if (i2 != 0) {
                String str2 = cVar.a;
                int i3 = cVar.b;
                if (this.a.b(cVar)) {
                    continue;
                } else {
                    int i4;
                    StringBuilder stringBuilder = new StringBuilder("Open connection with ");
                    stringBuilder.append(str);
                    stringBuilder.append(" - ip:");
                    stringBuilder.append(str2);
                    stringBuilder.append(", port:");
                    stringBuilder.append(i3);
                    cn.jiguang.e.c.a("SisPolicy", stringBuilder.toString());
                    long currentTimeMillis = System.currentTimeMillis();
                    g e = this.a.e();
                    if (e.d()) {
                        i4 = -991;
                    } else {
                        int a = cn.jiguang.d.g.c.a().b().a(str2, i3);
                        if (!(a == 0 || e.d())) {
                            StringBuilder stringBuilder2 = new StringBuilder("Open connection failed - ret:");
                            stringBuilder2.append(a);
                            cn.jiguang.e.c.a("ConnectingHelper", stringBuilder2.toString());
                        }
                        i4 = a;
                    }
                    if (i4 != 0) {
                        long currentTimeMillis2 = (System.currentTimeMillis() - currentTimeMillis) / 1000;
                        long a2 = cn.jiguang.d.a.a.a(currentTimeMillis);
                        i = i3;
                        this.a.b(str2, i3, a2, currentTimeMillis2, i4);
                        this.a.b(str2, i, i4);
                    }
                    i = i4;
                    continue;
                }
            }
            if (i == 0) {
                cn.jiguang.d.a.a.a(cVar.a, cVar.b);
                StringBuilder stringBuilder3 = new StringBuilder("Succeed to open connection - ip:");
                stringBuilder3.append(cVar.a);
                stringBuilder3.append(", port:");
                stringBuilder3.append(cVar.b);
                cn.jiguang.e.c.b("SisPolicy", stringBuilder3.toString());
                return 0;
            }
        }
        return -1;
    }
}
