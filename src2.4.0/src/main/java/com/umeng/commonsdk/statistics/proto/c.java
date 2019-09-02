package com.umeng.commonsdk.statistics.proto;

import com.umeng.commonsdk.proguard.aa;
import com.umeng.commonsdk.proguard.ac;
import com.umeng.commonsdk.proguard.ad;
import com.umeng.commonsdk.proguard.ae;
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
import com.umeng.commonsdk.proguard.j;
import com.umeng.commonsdk.proguard.p;
import com.umeng.commonsdk.proguard.q;
import com.umeng.commonsdk.proguard.v;
import com.umeng.commonsdk.proguard.w;
import com.umeng.commonsdk.proguard.x;
import com.umeng.commonsdk.proguard.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: IdTracking */
public class c implements j<c, e>, Serializable, Cloneable {
    public static final Map<e, v> d;
    private static final long e = -5764118265293965743L;
    private static final an f = new an("IdTracking");
    private static final ad g = new ad("snapshots", ap.k, (short) 1);
    private static final ad h = new ad("journals", ap.m, (short) 2);
    private static final ad i = new ad("checksum", (byte) 11, (short) 3);
    private static final Map<Class<? extends aq>, ar> j = new HashMap();
    public Map<String, b> a;
    public List<a> b;
    public String c;
    private e[] k;

    /* compiled from: IdTracking */
    private static class a extends as<c> {
        private a() {
        }

        /* renamed from: a */
        public void b(ai aiVar, c cVar) throws p {
            aiVar.j();
            while (true) {
                ad l = aiVar.l();
                if (l.b == (byte) 0) {
                    aiVar.k();
                    cVar.n();
                    return;
                }
                int i = 0;
                switch (l.c) {
                    case (short) 1:
                        if (l.b != ap.k) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        af n = aiVar.n();
                        cVar.a = new HashMap(2 * n.c);
                        while (i < n.c) {
                            String z = aiVar.z();
                            b bVar = new b();
                            bVar.read(aiVar);
                            cVar.a.put(z, bVar);
                            i++;
                        }
                        aiVar.o();
                        cVar.a(true);
                        break;
                    case (short) 2:
                        if (l.b != ap.m) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        ae p = aiVar.p();
                        cVar.b = new ArrayList(p.b);
                        while (i < p.b) {
                            a aVar = new a();
                            aVar.read(aiVar);
                            cVar.b.add(aVar);
                            i++;
                        }
                        aiVar.q();
                        cVar.b(true);
                        break;
                    case (short) 3:
                        if (l.b != (byte) 11) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        cVar.c = aiVar.z();
                        cVar.c(true);
                        break;
                    default:
                        al.a(aiVar, l.b);
                        break;
                }
                aiVar.m();
            }
        }

        /* renamed from: b */
        public void a(ai aiVar, c cVar) throws p {
            cVar.n();
            aiVar.a(c.f);
            if (cVar.a != null) {
                aiVar.a(c.g);
                aiVar.a(new af((byte) 11, (byte) 12, cVar.a.size()));
                for (Entry entry : cVar.a.entrySet()) {
                    aiVar.a((String) entry.getKey());
                    ((b) entry.getValue()).write(aiVar);
                }
                aiVar.e();
                aiVar.c();
            }
            if (cVar.b != null && cVar.j()) {
                aiVar.a(c.h);
                aiVar.a(new ae((byte) 12, cVar.b.size()));
                for (a write : cVar.b) {
                    write.write(aiVar);
                }
                aiVar.f();
                aiVar.c();
            }
            if (cVar.c != null && cVar.m()) {
                aiVar.a(c.i);
                aiVar.a(cVar.c);
                aiVar.c();
            }
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: IdTracking */
    private static class b implements ar {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: IdTracking */
    private static class c extends at<c> {
        private c() {
        }

        public void a(ai aiVar, c cVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(cVar.a.size());
            for (Entry entry : cVar.a.entrySet()) {
                aoVar.a((String) entry.getKey());
                ((b) entry.getValue()).write(aoVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            aoVar.a(bitSet, 2);
            if (cVar.j()) {
                aoVar.a(cVar.b.size());
                for (a write : cVar.b) {
                    write.write(aoVar);
                }
            }
            if (cVar.m()) {
                aoVar.a(cVar.c);
            }
        }

        public void b(ai aiVar, c cVar) throws p {
            ao aoVar = (ao) aiVar;
            af afVar = new af((byte) 11, (byte) 12, aoVar.w());
            cVar.a = new HashMap(afVar.c * 2);
            int i = 0;
            for (int i2 = 0; i2 < afVar.c; i2++) {
                String z = aoVar.z();
                b bVar = new b();
                bVar.read(aoVar);
                cVar.a.put(z, bVar);
            }
            cVar.a(true);
            BitSet b = aoVar.b(2);
            if (b.get(0)) {
                ae aeVar = new ae((byte) 12, aoVar.w());
                cVar.b = new ArrayList(aeVar.b);
                while (i < aeVar.b) {
                    a aVar = new a();
                    aVar.read(aoVar);
                    cVar.b.add(aVar);
                    i++;
                }
                cVar.b(true);
            }
            if (b.get(1)) {
                cVar.c = aoVar.z();
                cVar.c(true);
            }
        }
    }

    /* compiled from: IdTracking */
    private static class d implements ar {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: IdTracking */
    public enum e implements q {
        SNAPSHOTS((short) 1, "snapshots"),
        JOURNALS((short) 2, "journals"),
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
                    return SNAPSHOTS;
                case 2:
                    return JOURNALS;
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
        enumMap.put(e.SNAPSHOTS, new v("snapshots", (byte) 1, new y(ap.k, new w((byte) 11), new aa((byte) 12, b.class))));
        enumMap.put(e.JOURNALS, new v("journals", (byte) 2, new x(ap.m, new aa((byte) 12, a.class))));
        enumMap.put(e.CHECKSUM, new v("checksum", (byte) 2, new w((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        v.a(c.class, d);
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Entry entry : cVar.a.entrySet()) {
                hashMap.put((String) entry.getKey(), new b((b) entry.getValue()));
            }
            this.a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            for (a aVar : cVar.b) {
                arrayList.add(new a(aVar));
            }
            this.b = arrayList;
        }
        if (cVar.m()) {
            this.c = cVar.c;
        }
    }

    public c(Map<String, b> map) {
        this();
        this.a = map;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
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
    public e fieldForId(int i) {
        return e.a(i);
    }

    /* renamed from: a */
    public c deepCopy() {
        return new c(this);
    }

    public c a(String str) {
        this.c = str;
        return this;
    }

    public c a(List<a> list) {
        this.b = list;
        return this;
    }

    public c a(Map<String, b> map) {
        this.a = map;
        return this;
    }

    public void a(a aVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(aVar);
    }

    public void a(String str, b bVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, bVar);
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public int b() {
        return this.a == null ? 0 : this.a.size();
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public Map<String, b> c() {
        return this.a;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    public void clear() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b == null ? 0 : this.b.size();
    }

    public Iterator<a> g() {
        return this.b == null ? null : this.b.iterator();
    }

    public List<a> h() {
        return this.b;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public String k() {
        return this.c;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public void n() throws p {
        if (this.a == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Required field 'snapshots' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new aj(stringBuilder.toString());
        }
    }

    public void read(ai aiVar) throws p {
        ((ar) j.get(aiVar.D())).b().b(aiVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdTracking(");
        stringBuilder.append("snapshots:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (j()) {
            stringBuilder.append(", ");
            stringBuilder.append("journals:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (m()) {
            stringBuilder.append(", ");
            stringBuilder.append("checksum:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void write(ai aiVar) throws p {
        ((ar) j.get(aiVar.D())).b().a(aiVar, this);
    }
}
