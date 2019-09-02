package com.baidu.mapapi.map;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class n<T extends a> {
    private final g a;
    private final int b;
    private List<T> c;
    private List<n<T>> d;

    static abstract class a {
        a() {
        }

        public abstract Point a();
    }

    private n(double d, double d2, double d3, double d4, int i) {
        g gVar = new g(d, d2, d3, d4);
        this(gVar, i);
    }

    public n(g gVar) {
        this(gVar, 0);
    }

    private n(g gVar, int i) {
        this.d = null;
        this.a = gVar;
        this.b = i;
    }

    private void a() {
        this.d = new ArrayList(4);
        this.d.add(new n(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1));
        this.d.add(new n(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1));
        this.d.add(new n(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1));
        this.d.add(new n(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1));
        List<a> list = this.c;
        this.c = null;
        for (a aVar : list) {
            a((double) aVar.a().x, (double) aVar.a().y, aVar);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:14:0x0039 in {6, 8, 9, 12, 13, 17, 22, 23} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private void a(double r8, double r10, T r12) {
        /*
        r7 = this;
        r0 = r7.d;
        if (r0 == 0) goto L_0x003a;
        r0 = r7.a;
        r0 = r0.f;
        r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x0029;
        r0 = r7.a;
        r0 = r0.e;
        r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x0025;
        r0 = r7.d;
        r1 = 0;
        r0 = r0.get(r1);
        r1 = r0;
        r1 = (com.baidu.mapapi.map.n) r1;
        r2 = r8;
        r4 = r10;
        r6 = r12;
        r1.a(r2, r4, r6);
        return;
        r0 = r7.d;
        r1 = 1;
        goto L_0x0017;
        r0 = r7.a;
        r0 = r0.e;
        r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x0035;
        r0 = r7.d;
        r1 = 2;
        goto L_0x0017;
        r0 = r7.d;
        r1 = 3;
        goto L_0x0017;
        return;
        r8 = r7.c;
        if (r8 != 0) goto L_0x0045;
        r8 = new java.util.ArrayList;
        r8.<init>();
        r7.c = r8;
        r8 = r7.c;
        r8.add(r12);
        r8 = r7.c;
        r8 = r8.size();
        r9 = 40;
        if (r8 <= r9) goto L_0x005b;
        r8 = r7.b;
        if (r8 >= r9) goto L_0x005b;
        r7.a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.n.a(double, double, com.baidu.mapapi.map.n$a):void");
    }

    private void a(g gVar, Collection<T> collection) {
        if (this.a.a(gVar)) {
            if (this.d != null) {
                for (n a : this.d) {
                    a.a(gVar, collection);
                }
            } else if (this.c != null) {
                if (gVar.b(this.a)) {
                    collection.addAll(this.c);
                    return;
                }
                for (a aVar : this.c) {
                    if (gVar.a(aVar.a())) {
                        collection.add(aVar);
                    }
                }
            }
        }
    }

    public Collection<T> a(g gVar) {
        ArrayList arrayList = new ArrayList();
        a(gVar, arrayList);
        return arrayList;
    }

    public void a(T t) {
        Point a = t.a();
        if (this.a.a((double) a.x, (double) a.y)) {
            a((double) a.x, (double) a.y, t);
        }
    }
}
