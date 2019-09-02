package com.baidu.location.d;

import com.baidu.location.BDLocation;
import java.util.concurrent.Callable;

class h implements Callable<BDLocation> {
    final /* synthetic */ String[] a;
    final /* synthetic */ g b;

    h(g gVar, String[] strArr) {
        this.b = gVar;
        this.a = strArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061 A:{SYNTHETIC, Splitter:B:31:0x0061} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a A:{SYNTHETIC, Splitter:B:23:0x005a} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x008c A:{SYNTHETIC, Splitter:B:55:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0085 A:{SYNTHETIC, Splitter:B:47:0x0085} */
    /* JADX WARNING: Missing block: B:16:0x004e, code skipped:
            if (r0 != null) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:42:0x007c, code skipped:
            if (r0 != null) goto L_0x0050;
     */
    /* renamed from: a */
    public com.baidu.location.BDLocation call() {
        /*
        r11 = this;
        r0 = new com.baidu.location.BDLocation;
        r0.<init>();
        r1 = r11.a;
        r1 = r1.length;
        if (r1 <= 0) goto L_0x009f;
    L_0x000a:
        r0 = r11.b;
        r0 = r0.j;
        r0 = r0.o();
        r1 = 0;
        r2 = 0;
        r3 = r1;
        r4 = r2;
    L_0x0018:
        r5 = r0.length;
        if (r3 >= r5) goto L_0x0031;
    L_0x001b:
        r4 = com.baidu.location.d.g.c;	 Catch:{ Exception -> 0x002a }
        r4 = r4.getPackageManager();	 Catch:{ Exception -> 0x002a }
        r5 = r0[r3];	 Catch:{ Exception -> 0x002a }
        r4 = r4.resolveContentProvider(r5, r1);	 Catch:{ Exception -> 0x002a }
        goto L_0x002b;
    L_0x002a:
        r4 = r2;
    L_0x002b:
        if (r4 == 0) goto L_0x002e;
    L_0x002d:
        goto L_0x0031;
    L_0x002e:
        r3 = r3 + 1;
        goto L_0x0018;
    L_0x0031:
        if (r4 == 0) goto L_0x0067;
    L_0x0033:
        r0 = com.baidu.location.d.g.c;	 Catch:{ Exception -> 0x005e, all -> 0x0057 }
        r5 = r0.getContentResolver();	 Catch:{ Exception -> 0x005e, all -> 0x0057 }
        r0 = r4.authority;	 Catch:{ Exception -> 0x005e, all -> 0x0057 }
        r6 = com.baidu.location.d.g.c(r0);	 Catch:{ Exception -> 0x005e, all -> 0x0057 }
        r7 = r11.a;	 Catch:{ Exception -> 0x005e, all -> 0x0057 }
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r0 = r5.query(r6, r7, r8, r9, r10);	 Catch:{ Exception -> 0x005e, all -> 0x0057 }
        r1 = com.baidu.location.d.i.a(r0);	 Catch:{ Exception -> 0x005f, all -> 0x0054 }
        if (r0 == 0) goto L_0x0065;
    L_0x0050:
        r0.close();	 Catch:{ Exception -> 0x0065 }
        goto L_0x0065;
    L_0x0054:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0058;
    L_0x0057:
        r1 = move-exception;
    L_0x0058:
        if (r2 == 0) goto L_0x005d;
    L_0x005a:
        r2.close();	 Catch:{ Exception -> 0x005d }
    L_0x005d:
        throw r1;
    L_0x005e:
        r0 = r2;
    L_0x005f:
        if (r0 == 0) goto L_0x0064;
    L_0x0061:
        r0.close();	 Catch:{ Exception -> 0x0064 }
    L_0x0064:
        r1 = r2;
    L_0x0065:
        r0 = r1;
        goto L_0x0090;
    L_0x0067:
        r0 = new com.baidu.location.d.i$a;
        r1 = r11.a;
        r0.<init>(r1);
        r1 = r11.b;	 Catch:{ Exception -> 0x0089, all -> 0x0082 }
        r1 = r1.h;	 Catch:{ Exception -> 0x0089, all -> 0x0082 }
        r0 = r1.a(r0);	 Catch:{ Exception -> 0x0089, all -> 0x0082 }
        r1 = com.baidu.location.d.i.a(r0);	 Catch:{ Exception -> 0x008a, all -> 0x007f }
        if (r0 == 0) goto L_0x0065;
    L_0x007e:
        goto L_0x0050;
    L_0x007f:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0083;
    L_0x0082:
        r1 = move-exception;
    L_0x0083:
        if (r2 == 0) goto L_0x0088;
    L_0x0085:
        r2.close();	 Catch:{ Exception -> 0x0088 }
    L_0x0088:
        throw r1;
    L_0x0089:
        r0 = r2;
    L_0x008a:
        if (r0 == 0) goto L_0x008f;
    L_0x008c:
        r0.close();	 Catch:{ Exception -> 0x008f }
    L_0x008f:
        r0 = r2;
    L_0x0090:
        if (r0 == 0) goto L_0x009f;
    L_0x0092:
        r1 = r0.getLocType();
        r2 = 67;
        if (r1 == r2) goto L_0x009f;
    L_0x009a:
        r1 = 66;
        r0.setLocType(r1);
    L_0x009f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.h.call():com.baidu.location.BDLocation");
    }
}
