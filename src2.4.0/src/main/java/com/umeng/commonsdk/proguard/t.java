package com.umeng.commonsdk.proguard;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: TUnion */
public abstract class t<T extends t<?, ?>, F extends q> implements j<T, F> {
    private static final Map<Class<? extends aq>, ar> c = new HashMap();
    protected Object a;
    protected F b;

    /* compiled from: TUnion */
    private static class a extends as<t> {
        private a() {
        }

        /* renamed from: a */
        public void b(ai aiVar, t tVar) throws p {
            tVar.b = null;
            tVar.a = null;
            aiVar.j();
            ad l = aiVar.l();
            tVar.a = tVar.a(aiVar, l);
            if (tVar.a != null) {
                tVar.b = tVar.a(l.c);
            }
            aiVar.m();
            aiVar.l();
            aiVar.k();
        }

        /* renamed from: b */
        public void a(ai aiVar, t tVar) throws p {
            if (tVar.a() == null || tVar.b() == null) {
                throw new aj("Cannot write a TUnion with no set value!");
            }
            aiVar.a(tVar.d());
            aiVar.a(tVar.c(tVar.b));
            tVar.a(aiVar);
            aiVar.c();
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: TUnion */
    private static class b implements ar {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: TUnion */
    private static class c extends at<t> {
        private c() {
        }

        /* renamed from: a */
        public void b(ai aiVar, t tVar) throws p {
            tVar.b = null;
            tVar.a = null;
            short v = aiVar.v();
            tVar.a = tVar.a(aiVar, v);
            if (tVar.a != null) {
                tVar.b = tVar.a(v);
            }
        }

        /* renamed from: b */
        public void a(ai aiVar, t tVar) throws p {
            if (tVar.a() == null || tVar.b() == null) {
                throw new aj("Cannot write a TUnion with no set value!");
            }
            aiVar.a(tVar.b.a());
            tVar.b(aiVar);
        }
    }

    /* compiled from: TUnion */
    private static class d implements ar {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    static {
        c.put(as.class, new b());
        c.put(at.class, new d());
    }

    protected t() {
        this.b = null;
        this.a = null;
    }

    protected t(F f, Object obj) {
        a((q) f, obj);
    }

    protected t(t<T, F> tVar) {
        if (tVar.getClass().equals(getClass())) {
            this.b = tVar.b;
            this.a = a(tVar.a);
            return;
        }
        throw new ClassCastException();
    }

    private static Object a(Object obj) {
        return obj instanceof j ? ((j) obj).deepCopy() : obj instanceof ByteBuffer ? k.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map) obj) : obj;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object a : list) {
            arrayList.add(a(a));
        }
        return arrayList;
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object a : set) {
            hashSet.add(a(a));
        }
        return hashSet;
    }

    public F a() {
        return this.b;
    }

    public abstract F a(short s);

    public Object a(int i) {
        return a(a((short) i));
    }

    public abstract Object a(ai aiVar, ad adVar) throws p;

    public abstract Object a(ai aiVar, short s) throws p;

    public Object a(F f) {
        if (f == this.b) {
            return b();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot get the value of field ");
        stringBuilder.append(f);
        stringBuilder.append(" because union's set field is ");
        stringBuilder.append(this.b);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void a(int i, Object obj) {
        a(a((short) i), obj);
    }

    public abstract void a(ai aiVar) throws p;

    public void a(F f, Object obj) {
        b(f, obj);
        this.b = f;
        this.a = obj;
    }

    public Object b() {
        return this.a;
    }

    public abstract void b(ai aiVar) throws p;

    public abstract void b(F f, Object obj) throws ClassCastException;

    public boolean b(int i) {
        return b(a((short) i));
    }

    public boolean b(F f) {
        return this.b == f;
    }

    public abstract ad c(F f);

    public boolean c() {
        return this.b != null;
    }

    public final void clear() {
        this.b = null;
        this.a = null;
    }

    public abstract an d();

    public void read(ai aiVar) throws p {
        ((ar) c.get(aiVar.D())).b().b(aiVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" ");
        if (a() != null) {
            Object b = b();
            stringBuilder.append(c(a()).a);
            stringBuilder.append(":");
            if (b instanceof ByteBuffer) {
                k.a((ByteBuffer) b, stringBuilder);
            } else {
                stringBuilder.append(b.toString());
            }
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    public void write(ai aiVar) throws p {
        ((ar) c.get(aiVar.D())).b().a(aiVar, this);
    }
}
