package com.umeng.commonsdk.statistics.proto;

import com.umeng.commonsdk.proguard.ac;
import com.umeng.commonsdk.proguard.ad;
import com.umeng.commonsdk.proguard.ai;
import com.umeng.commonsdk.proguard.aj;
import com.umeng.commonsdk.proguard.al;
import com.umeng.commonsdk.proguard.an;
import com.umeng.commonsdk.proguard.ao;
import com.umeng.commonsdk.proguard.aq;
import com.umeng.commonsdk.proguard.ar;
import com.umeng.commonsdk.proguard.as;
import com.umeng.commonsdk.proguard.at;
import com.umeng.commonsdk.proguard.au;
import com.umeng.commonsdk.proguard.g;
import com.umeng.commonsdk.proguard.j;
import com.umeng.commonsdk.proguard.p;
import com.umeng.commonsdk.proguard.q;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.proguard.w;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IdSnapshot */
public class b implements j<b, e>, Serializable, Cloneable {
    public static final Map<e, v> d;
    private static final long e = -6496538196005191531L;
    private static final an f = new an("IdSnapshot");
    private static final ad g = new ad("identity", (byte) 11, (short) 1);
    private static final ad h = new ad("ts", (byte) 10, (short) 2);
    private static final ad i = new ad("version", (byte) 8, (short) 3);
    private static final Map<Class<? extends aq>, ar> j = new HashMap();
    private static final int k = 0;
    private static final int l = 1;
    public String a;
    public long b;
    public int c;
    private byte m;

    /* compiled from: IdSnapshot */
    private static class a extends as<b> {
        private a() {
        }

        /* renamed from: a */
        public void b(ai aiVar, b bVar) throws p {
            aiVar.j();
            while (true) {
                ad l = aiVar.l();
                if (l.b == (byte) 0) {
                    aiVar.k();
                    StringBuilder stringBuilder;
                    if (!bVar.g()) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Required field 'ts' was not found in serialized data! Struct: ");
                        stringBuilder.append(toString());
                        throw new aj(stringBuilder.toString());
                    } else if (bVar.j()) {
                        bVar.k();
                        return;
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Required field 'version' was not found in serialized data! Struct: ");
                        stringBuilder.append(toString());
                        throw new aj(stringBuilder.toString());
                    }
                }
                switch (l.c) {
                    case (short) 1:
                        if (l.b != (byte) 11) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        bVar.a = aiVar.z();
                        bVar.a(true);
                        break;
                    case (short) 2:
                        if (l.b != (byte) 10) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        bVar.b = aiVar.x();
                        bVar.b(true);
                        break;
                    case (short) 3:
                        if (l.b != (byte) 8) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        bVar.c = aiVar.w();
                        bVar.c(true);
                        break;
                    default:
                        al.a(aiVar, l.b);
                        break;
                }
                aiVar.m();
            }
        }

        /* renamed from: b */
        public void a(ai aiVar, b bVar) throws p {
            bVar.k();
            aiVar.a(b.f);
            if (bVar.a != null) {
                aiVar.a(b.g);
                aiVar.a(bVar.a);
                aiVar.c();
            }
            aiVar.a(b.h);
            aiVar.a(bVar.b);
            aiVar.c();
            aiVar.a(b.i);
            aiVar.a(bVar.c);
            aiVar.c();
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: IdSnapshot */
    private static class b implements ar {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: IdSnapshot */
    private static class c extends at<b> {
        private c() {
        }

        public void a(ai aiVar, b bVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(bVar.a);
            aoVar.a(bVar.b);
            aoVar.a(bVar.c);
        }

        public void b(ai aiVar, b bVar) throws p {
            ao aoVar = (ao) aiVar;
            bVar.a = aoVar.z();
            bVar.a(true);
            bVar.b = aoVar.x();
            bVar.b(true);
            bVar.c = aoVar.w();
            bVar.c(true);
        }
    }

    /* compiled from: IdSnapshot */
    private static class d implements ar {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: IdSnapshot */
    public enum e implements q {
        IDENTITY((short) 1, "identity"),
        TS((short) 2, "ts"),
        VERSION((short) 3, "version");
        
        private static final Map<String, e> d = null;
        private final short e;
        private final String f;

        static {
            d = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        private e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return IDENTITY;
                case 2:
                    return TS;
                case 3:
                    return VERSION;
                default:
                    return null;
            }
        }

        public static e a(String str) {
            return (e) d.get(str);
        }

        public static e b(int i) {
            e a = a(i);
            if (a != null) {
                return a;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field ");
            stringBuilder.append(i);
            stringBuilder.append(" doesn't exist!");
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public short a() {
            return this.e;
        }

        public String b() {
            return this.f;
        }
    }

    static {
        j.put(as.class, new b());
        j.put(at.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new v("identity", (byte) 1, new w((byte) 11)));
        enumMap.put(e.TS, new v("ts", (byte) 1, new w((byte) 10)));
        enumMap.put(e.VERSION, new v("version", (byte) 1, new w((byte) 8)));
        d = Collections.unmodifiableMap(enumMap);
        v.a(b.class, d);
    }

    public b() {
        this.m = (byte) 0;
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.a = bVar.a;
        }
        this.b = bVar.b;
        this.c = bVar.c;
    }

    public b(String str, long j, int i) {
        this();
        this.a = str;
        this.b = j;
        b(true);
        this.c = i;
        c(true);
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.m = (byte) 0;
            read(new ac(new au((InputStream) objectInputStream)));
        } catch (p e) {
            throw new IOException(e.getMessage());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ac(new au((OutputStream) objectOutputStream)));
        } catch (p e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    public b a(int i) {
        this.c = i;
        c(true);
        return this;
    }

    public b a(long j) {
        this.b = j;
        b(true);
        return this;
    }

    public b a(String str) {
        this.a = str;
        return this;
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    /* renamed from: b */
    public e fieldForId(int i) {
        return e.a(i);
    }

    public String b() {
        return this.a;
    }

    public void b(boolean z) {
        this.m = g.a(this.m, 0, z);
    }

    public void c() {
        this.a = null;
    }

    public void c(boolean z) {
        this.m = g.a(this.m, 1, z);
    }

    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        c(false);
        this.c = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.m = g.b(this.m, 0);
    }

    public boolean g() {
        return g.a(this.m, 0);
    }

    public int h() {
        return this.c;
    }

    public void i() {
        this.m = g.b(this.m, 1);
    }

    public boolean j() {
        return g.a(this.m, 1);
    }

    public void k() throws p {
        if (this.a == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Required field 'identity' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new aj(stringBuilder.toString());
        }
    }

    public void read(ai aiVar) throws p {
        ((ar) j.get(aiVar.D())).b().b(aiVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdSnapshot(");
        stringBuilder.append("identity:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void write(ai aiVar) throws p {
        ((ar) j.get(aiVar.D())).b().a(aiVar, this);
    }
}
