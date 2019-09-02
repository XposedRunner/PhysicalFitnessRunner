package cn.jiguang.d.c;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class l implements Serializable {
    private List a;
    private short b;
    private short c;

    public l() {
        this.a = new ArrayList(1);
        this.b = (short) 0;
        this.c = (short) 0;
    }

    public l(m mVar) {
        this();
        b(mVar);
    }

    private static String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            stringBuffer.append("[");
            stringBuffer.append(mVar.a());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    private synchronized Iterator a(boolean z, boolean z2) {
        int size = this.a.size();
        short s = z ? size - this.b : this.b;
        if (s == (short) 0) {
            return Collections.EMPTY_LIST.iterator();
        }
        int i;
        Collection subList;
        if (!z) {
            i = size - this.b;
        } else if (z2) {
            if (this.c >= s) {
                this.c = (short) 0;
            }
            i = this.c;
            this.c = (short) (i + 1);
        } else {
            i = 0;
        }
        ArrayList arrayList = new ArrayList(s);
        if (z) {
            arrayList.addAll(this.a.subList(i, s));
            if (i != 0) {
                subList = this.a.subList(0, i);
            }
            return arrayList.iterator();
        }
        subList = this.a.subList(i, size);
        arrayList.addAll(subList);
        return arrayList.iterator();
    }

    private void b(m mVar) {
        if (this.b == (short) 0) {
            this.a.add(mVar);
        } else {
            this.a.add(this.a.size() - this.b, mVar);
        }
    }

    private synchronized long c() {
        return b().f();
    }

    public final synchronized Iterator a() {
        return a(true, true);
    }

    /* JADX WARNING: Missing block: B:25:0x0074, code skipped:
            return;
     */
    public final synchronized void a(cn.jiguang.d.c.m r7) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.a;	 Catch:{ all -> 0x0075 }
        r0 = r0.size();	 Catch:{ all -> 0x0075 }
        if (r0 != 0) goto L_0x000e;
    L_0x0009:
        r6.b(r7);	 Catch:{ all -> 0x0075 }
        monitor-exit(r6);
        return;
    L_0x000e:
        r0 = r6.b();	 Catch:{ all -> 0x0075 }
        r1 = r7.a(r0);	 Catch:{ all -> 0x0075 }
        if (r1 != 0) goto L_0x0020;
    L_0x0018:
        r7 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x0075 }
        r0 = "record does not match rrset";
        r7.<init>(r0);	 Catch:{ all -> 0x0075 }
        throw r7;	 Catch:{ all -> 0x0075 }
    L_0x0020:
        r1 = r7.f();	 Catch:{ all -> 0x0075 }
        r3 = r0.f();	 Catch:{ all -> 0x0075 }
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x0068;
    L_0x002c:
        r1 = r7.f();	 Catch:{ all -> 0x0075 }
        r3 = r0.f();	 Catch:{ all -> 0x0075 }
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x0044;
    L_0x0038:
        r7 = r7.g();	 Catch:{ all -> 0x0075 }
        r0 = r0.f();	 Catch:{ all -> 0x0075 }
        r7.a(r0);	 Catch:{ all -> 0x0075 }
        goto L_0x0068;
    L_0x0044:
        r0 = 0;
    L_0x0045:
        r1 = r6.a;	 Catch:{ all -> 0x0075 }
        r1 = r1.size();	 Catch:{ all -> 0x0075 }
        if (r0 >= r1) goto L_0x0068;
    L_0x004d:
        r1 = r6.a;	 Catch:{ all -> 0x0075 }
        r1 = r1.get(r0);	 Catch:{ all -> 0x0075 }
        r1 = (cn.jiguang.d.c.m) r1;	 Catch:{ all -> 0x0075 }
        r1 = r1.g();	 Catch:{ all -> 0x0075 }
        r2 = r7.f();	 Catch:{ all -> 0x0075 }
        r1.a(r2);	 Catch:{ all -> 0x0075 }
        r2 = r6.a;	 Catch:{ all -> 0x0075 }
        r2.set(r0, r1);	 Catch:{ all -> 0x0075 }
        r0 = r0 + 1;
        goto L_0x0045;
    L_0x0068:
        r0 = r6.a;	 Catch:{ all -> 0x0075 }
        r0 = r0.contains(r7);	 Catch:{ all -> 0x0075 }
        if (r0 != 0) goto L_0x0073;
    L_0x0070:
        r6.b(r7);	 Catch:{ all -> 0x0075 }
    L_0x0073:
        monitor-exit(r6);
        return;
    L_0x0075:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.c.l.a(cn.jiguang.d.c.m):void");
    }

    public final synchronized m b() {
        if (this.a.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (m) this.a.get(0);
    }

    public final String toString() {
        if (this.a.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{ ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b().b());
        stringBuilder.append(" ");
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(c());
        stringBuilder.append(" ");
        stringBuffer.append(stringBuilder.toString());
        stringBuffer.append(a(a(true, false)));
        if (this.b > (short) 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(a(a(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }
}
