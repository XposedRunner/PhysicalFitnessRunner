package com.umeng.commonsdk.statistics.proto;

import com.umeng.commonsdk.proguard.aa;
import com.umeng.commonsdk.proguard.ac;
import com.umeng.commonsdk.proguard.ad;
import com.umeng.commonsdk.proguard.af;
import com.umeng.commonsdk.proguard.ai;
import com.umeng.commonsdk.proguard.aj;
import com.umeng.commonsdk.proguard.al;
import com.umeng.commonsdk.proguard.an;
import com.umeng.commonsdk.proguard.ao;
import com.umeng.commonsdk.proguard.ap;
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
import com.umeng.commonsdk.proguard.y;
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
import java.util.Map.Entry;

/* compiled from: Imprint */
public class d implements j<d, e>, Serializable, Cloneable {
    public static final Map<e, v> d;
    private static final long e = 2846460275012375038L;
    private static final an f = new an("Imprint");
    private static final ad g = new ad("property", ap.k, (short) 1);
    private static final ad h = new ad("version", (byte) 8, (short) 2);
    private static final ad i = new ad("checksum", (byte) 11, (short) 3);
    private static final Map<Class<? extends aq>, ar> j = new HashMap();
    private static final int k = 0;
    public Map<String, e> a;
    public int b;
    public String c;
    private byte l;

    /* compiled from: Imprint */
    private static class a extends as<d> {
        private a() {
        }

        /* renamed from: a */
        public void b(ai aiVar, d dVar) throws p {
            aiVar.j();
            while (true) {
                ad l = aiVar.l();
                if (l.b == (byte) 0) {
                    aiVar.k();
                    if (dVar.h()) {
                        dVar.l();
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Required field 'version' was not found in serialized data! Struct: ");
                    stringBuilder.append(toString());
                    throw new aj(stringBuilder.toString());
                }
                switch (l.c) {
                    case (short) 1:
                        if (l.b != ap.k) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        af n = aiVar.n();
                        dVar.a = new HashMap(2 * n.c);
                        for (int i = 0; i < n.c; i++) {
                            String z = aiVar.z();
                            e eVar = new e();
                            eVar.read(aiVar);
                            dVar.a.put(z, eVar);
                        }
                        aiVar.o();
                        dVar.a(true);
                        break;
                    case (short) 2:
                        if (l.b != (byte) 8) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        dVar.b = aiVar.w();
                        dVar.b(true);
                        break;
                    case (short) 3:
                        if (l.b != (byte) 11) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        dVar.c = aiVar.z();
                        dVar.c(true);
                        break;
                    default:
                        al.a(aiVar, l.b);
                        break;
                }
                aiVar.m();
            }
        }

        /* renamed from: b */
        public void a(ai aiVar, d dVar) throws p {
            dVar.l();
            aiVar.a(d.f);
            if (dVar.a != null) {
                aiVar.a(d.g);
                aiVar.a(new af((byte) 11, (byte) 12, dVar.a.size()));
                for (Entry entry : dVar.a.entrySet()) {
                    aiVar.a((String) entry.getKey());
                    ((e) entry.getValue()).write(aiVar);
                }
                aiVar.e();
                aiVar.c();
            }
            aiVar.a(d.h);
            aiVar.a(dVar.b);
            aiVar.c();
            if (dVar.c != null) {
                aiVar.a(d.i);
                aiVar.a(dVar.c);
                aiVar.c();
            }
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: Imprint */
    private static class b implements ar {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: Imprint */
    private static class c extends at<d> {
        private c() {
        }

        public void a(ai aiVar, d dVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(dVar.a.size());
            for (Entry entry : dVar.a.entrySet()) {
                aoVar.a((String) entry.getKey());
                ((e) entry.getValue()).write(aoVar);
            }
            aoVar.a(dVar.b);
            aoVar.a(dVar.c);
        }

        public void b(ai aiVar, d dVar) throws p {
            ao aoVar = (ao) aiVar;
            af afVar = new af((byte) 11, (byte) 12, aoVar.w());
            dVar.a = new HashMap(2 * afVar.c);
            for (int i = 0; i < afVar.c; i++) {
                String z = aoVar.z();
                e eVar = new e();
                eVar.read(aoVar);
                dVar.a.put(z, eVar);
            }
            dVar.a(true);
            dVar.b = aoVar.w();
            dVar.b(true);
            dVar.c = aoVar.z();
            dVar.c(true);
        }
    }

    /* compiled from: Imprint */
    private static class d implements ar {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: Imprint */
    public enum e implements q {
        PROPERTY((short) 1, "property"),
        VERSION((short) 2, "version"),
        CHECKSUM((short) 3, "checksum");
        
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
                    return PROPERTY;
                case 2:
                    return VERSION;
                case 3:
                    return CHECKSUM;
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
        enumMap.put(e.PROPERTY, new v("property", (byte) 1, new y(ap.k, new w((byte) 11), new aa((byte) 12, e.class))));
        enumMap.put(e.VERSION, new v("version", (byte) 1, new w((byte) 8)));
        enumMap.put(e.CHECKSUM, new v("checksum", (byte) 1, new w((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        v.a(d.class, d);
    }

    public d() {
        this.l = (byte) 0;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Entry entry : dVar.a.entrySet()) {
                hashMap.put((String) entry.getKey(), new e((e) entry.getValue()));
            }
            this.a = hashMap;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.c = dVar.c;
        }
    }

    public d(Map<String, e> map, int i, String str) {
        this();
        this.a = map;
        this.b = i;
        b(true);
        this.c = str;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.l = (byte) 0;
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
    public d deepCopy() {
        return new d(this);
    }

    public d a(int i) {
        this.b = i;
        b(true);
        return this;
    }

    public d a(String str) {
        this.c = str;
        return this;
    }

    public d a(Map<String, e> map) {
        this.a = map;
        return this;
    }

    public void a(String str, e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, eVar);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public int b() {
        return this.a == null ? 0 : this.a.size();
    }

    /* renamed from: b */
    public e fieldForId(int i) {
        return e.a(i);
    }

    public void b(boolean z) {
        this.l = g.a(this.l, 0, z);
    }

    public Map<String, e> c() {
        return this.a;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b;
    }

    public void g() {
        this.l = g.b(this.l, 0);
    }

    public boolean h() {
        return g.a(this.l, 0);
    }

    public String i() {
        return this.c;
    }

    public void j() {
        this.c = null;
    }

    public boolean k() {
        return this.c != null;
    }

    public void l() throws p {
        StringBuilder stringBuilder;
        if (this.a == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Required field 'property' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new aj(stringBuilder.toString());
        } else if (this.c == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Required field 'checksum' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new aj(stringBuilder.toString());
        }
    }

    public void read(ai aiVar) throws p {
        ((ar) j.get(aiVar.D())).b().b(aiVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Imprint(");
        stringBuilder.append("property:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void write(ai aiVar) throws p {
        ((ar) j.get(aiVar.D())).b().a(aiVar, this);
    }
}
