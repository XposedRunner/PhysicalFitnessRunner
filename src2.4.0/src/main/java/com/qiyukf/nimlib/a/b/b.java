package com.qiyukf.nimlib.a.b;

import com.qiyukf.basesdk.c.e;
import com.qiyukf.nimlib.h.c.c.f;

public final class b {
    private e a;
    private f b;
    private boolean c;
    private c d;

    public static class a extends com.qiyukf.nimlib.a.d.a {
        public final f a(f fVar) {
            return null;
        }
    }

    public b(boolean z, e eVar, f fVar) {
        this.c = z;
        this.a = eVar;
        this.b = fVar;
        this.d = c.a(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0069  */
    private void a(com.qiyukf.nimlib.h.c.a r7, com.qiyukf.nimlib.h.c.c.f r8) {
        /*
        r6 = this;
        r0 = r6.d;
        r0 = r0.d(r7);
        r1 = r6.c;
        if (r1 == 0) goto L_0x0024;
    L_0x000a:
        r1 = com.qiyukf.nimlib.d.b();
        if (r1 != 0) goto L_0x0018;
    L_0x0010:
        r1 = r6.d;
        r1 = r1.a(r7);
        if (r1 == 0) goto L_0x0024;
    L_0x0018:
        r1 = new com.qiyukf.nimlib.a.d.a$a;
        r1.<init>();
        r1.a = r7;
        r1.b = r8;
        com.qiyukf.nimlib.f.d.a(r1);
    L_0x0024:
        if (r0 != 0) goto L_0x002f;
    L_0x0026:
        r1 = r6.c;
        if (r1 != 0) goto L_0x002f;
    L_0x002a:
        r0 = new com.qiyukf.nimlib.a.b.b$a;
        r0.<init>();
    L_0x002f:
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0.a(r7);
        r1 = r0.b();
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x0042;
    L_0x003d:
        if (r8 != 0) goto L_0x0040;
    L_0x003f:
        goto L_0x0042;
    L_0x0040:
        r1 = r3;
        goto L_0x0043;
    L_0x0042:
        r1 = r2;
    L_0x0043:
        r4 = 0;
        if (r1 != 0) goto L_0x0066;
    L_0x0046:
        r8 = r0.a(r8);	 Catch:{ Throwable -> 0x0060 }
        if (r8 == 0) goto L_0x004d;
    L_0x004c:
        r3 = r2;
    L_0x004d:
        if (r3 == 0) goto L_0x005e;
    L_0x004f:
        r5 = new com.qiyukf.nimlib.h.c.a;	 Catch:{ Throwable -> 0x005c }
        r5.<init>();	 Catch:{ Throwable -> 0x005c }
        r8.a(r5);	 Catch:{ Throwable -> 0x0059 }
        r4 = r5;
        goto L_0x005e;
    L_0x0059:
        r2 = move-exception;
        r4 = r5;
        goto L_0x0062;
    L_0x005c:
        r2 = move-exception;
        goto L_0x0062;
    L_0x005e:
        r1 = r2;
        goto L_0x0067;
    L_0x0060:
        r2 = move-exception;
        r8 = r4;
    L_0x0062:
        r2.printStackTrace();
        goto L_0x0067;
    L_0x0066:
        r8 = r4;
    L_0x0067:
        if (r1 == 0) goto L_0x00d3;
    L_0x0069:
        if (r3 == 0) goto L_0x007b;
    L_0x006b:
        r1 = r6.c;
        if (r1 == 0) goto L_0x0078;
    L_0x006f:
        r1 = r6.d;
        r1 = r1.c(r4);
        if (r1 != 0) goto L_0x0078;
    L_0x0077:
        return;
    L_0x0078:
        r6.a(r4, r8);
    L_0x007b:
        r8 = "core";
        r1 = new java.lang.StringBuilder;
        r2 = "handle packet: ";
        r1.<init>(r2);
        r1.append(r7);
        r7 = r1.toString();
        com.qiyukf.basesdk.a.a.b(r8, r7);
        r7 = r6.b;	 Catch:{ Throwable -> 0x00b0 }
        if (r7 == 0) goto L_0x0097;
    L_0x0092:
        r7 = r6.b;	 Catch:{ Throwable -> 0x00b0 }
        r7.a(r0);	 Catch:{ Throwable -> 0x00b0 }
    L_0x0097:
        r7 = r6.d;	 Catch:{ Throwable -> 0x00b0 }
        r8 = r0.a();	 Catch:{ Throwable -> 0x00b0 }
        r7 = r7.c(r8);	 Catch:{ Throwable -> 0x00b0 }
        if (r7 == 0) goto L_0x00a6;
    L_0x00a3:
        r7.a(r0);	 Catch:{ Throwable -> 0x00b0 }
    L_0x00a6:
        r7 = r6.b;	 Catch:{ Throwable -> 0x00b0 }
        if (r7 == 0) goto L_0x00af;
    L_0x00aa:
        r7 = r6.b;	 Catch:{ Throwable -> 0x00b0 }
        r7.b(r0);	 Catch:{ Throwable -> 0x00b0 }
    L_0x00af:
        return;
    L_0x00b0:
        r7 = move-exception;
        r7.printStackTrace();
        r8 = "core";
        r1 = new java.lang.StringBuilder;
        r2 = "process response exception: ";
        r1.<init>(r2);
        r1.append(r7);
        r7 = " on packet: ";
        r1.append(r7);
        r7 = r0.a();
        r1.append(r7);
        r7 = r1.toString();
        com.qiyukf.basesdk.a.a.a(r8, r7);
    L_0x00d3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nimlib.a.b.b.a(com.qiyukf.nimlib.h.c.a, com.qiyukf.nimlib.h.c.c.f):void");
    }

    public final void a(com.qiyukf.nimlib.a.d.a.a aVar) {
        final com.qiyukf.nimlib.h.c.a aVar2 = aVar.a;
        final f fVar = aVar.b;
        final Integer b = this.d.b(aVar2);
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                b.this.a(aVar2, fVar);
            }
        };
        if (b == null) {
            this.a.execute(anonymousClass1);
        } else {
            this.a.a(anonymousClass1, b.intValue());
        }
    }
}
