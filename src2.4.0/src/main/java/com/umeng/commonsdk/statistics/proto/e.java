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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ImprintValue */
public class e implements j<e, e>, Serializable, Cloneable {
    public static final Map<e, v> d;
    private static final long e = 7501688097813630241L;
    private static final an f = new an("ImprintValue");
    private static final ad g = new ad("value", (byte) 11, (short) 1);
    private static final ad h = new ad("ts", (byte) 10, (short) 2);
    private static final ad i = new ad("guid", (byte) 11, (short) 3);
    private static final Map<Class<? extends aq>, ar> j = new HashMap();
    private static final int k = 0;
    public String a;
    public long b;
    public String c;
    private byte l;
    private e[] m;

    /* compiled from: ImprintValue */
    private static class a extends as<e> {
        private a() {
        }

        /* renamed from: a */
        public void b(ai aiVar, e eVar) throws p {
            aiVar.j();
            while (true) {
                ad l = aiVar.l();
                if (l.b == (byte) 0) {
                    aiVar.k();
                    if (eVar.g()) {
                        eVar.k();
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Required field 'ts' was not found in serialized data! Struct: ");
                    stringBuilder.append(toString());
                    throw new aj(stringBuilder.toString());
                }
                switch (l.c) {
                    case (short) 1:
                        if (l.b != (byte) 11) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        eVar.a = aiVar.z();
                        eVar.a(true);
                        break;
                    case (short) 2:
                        if (l.b != (byte) 10) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        eVar.b = aiVar.x();
                        eVar.b(true);
                        break;
                    case (short) 3:
                        if (l.b != (byte) 11) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        eVar.c = aiVar.z();
                        eVar.c(true);
                        break;
                    default:
                        al.a(aiVar, l.b);
                        break;
                }
                aiVar.m();
            }
        }

        /* renamed from: b */
        public void a(ai aiVar, e eVar) throws p {
            eVar.k();
            aiVar.a(e.f);
            if (eVar.a != null && eVar.d()) {
                aiVar.a(e.g);
                aiVar.a(eVar.a);
                aiVar.c();
            }
            aiVar.a(e.h);
            aiVar.a(eVar.b);
            aiVar.c();
            if (eVar.c != null) {
                aiVar.a(e.i);
                aiVar.a(eVar.c);
                aiVar.c();
            }
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: ImprintValue */
    private static class b implements ar {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: ImprintValue */
    private static class c extends at<e> {
        private c() {
        }

        public void a(ai aiVar, e eVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(eVar.b);
            aoVar.a(eVar.c);
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            aoVar.a(bitSet, 1);
            if (eVar.d()) {
                aoVar.a(eVar.a);
            }
        }

        public void b(ai aiVar, e eVar) throws p {
            ao aoVar = (ao) aiVar;
            eVar.b = aoVar.x();
            eVar.b(true);
            eVar.c = aoVar.z();
            eVar.c(true);
            if (aoVar.b(1).get(0)) {
                eVar.a = aoVar.z();
                eVar.a(true);
            }
        }
    }

    /* compiled from: ImprintValue */
    private static class d implements ar {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: ImprintValue */
    public enum e implements q {
        VALUE((short) 1, "value"),
        TS((short) 2, "ts"),
        GUID((short) 3, "guid");
        
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
                    return VALUE;
                case 2:
                    return TS;
                case 3:
                    return GUID;
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
        enumMap.put(e.VALUE, new v("value", (byte) 2, new w((byte) 11)));
        enumMap.put(e.TS, new v("ts", (byte) 1, new w((byte) 10)));
        enumMap.put(e.GUID, new v("guid", (byte) 1, new w((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        v.a(e.class, d);
    }

    public e() {
        this.l = (byte) 0;
        this.m = new e[]{e.VALUE};
    }

    public e(long j, String str) {
        this();
        this.b = j;
        b(true);
        this.c = str;
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new e[]{e.VALUE};
        this.l = eVar.l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.c = eVar.c;
        }
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
    public e fieldForId(int i) {
        return e.a(i);
    }

    /* renamed from: a */
    public e deepCopy() {
        return new e(this);
    }

    public e a(long j) {
        this.b = j;
        b(true);
        return this;
    }

    public e a(String str) {
        this.a = str;
        return this;
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public e b(String str) {
        this.c = str;
        return this;
    }

    public String b() {
        return this.a;
    }

    public void b(boolean z) {
        this.l = g.a(this.l, 0, z);
    }

    public void c() {
        this.a = null;
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

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.l = g.b(this.l, 0);
    }

    public boolean g() {
        return g.a(this.l, 0);
    }

    public String h() {
        return this.c;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public void k() throws p {
        if (this.c == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Required field 'guid' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new aj(stringBuilder.toString());
        }
    }

    public void read(ai aiVar) throws p {
        ((ar) j.get(aiVar.D())).b().b(aiVar, this);
    }

    public String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("ImprintValue(");
        if (d()) {
            stringBuilder.append("value:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("ts:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
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
