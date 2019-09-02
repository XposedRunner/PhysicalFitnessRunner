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
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
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

/* compiled from: IdJournal */
public class a implements j<a, e>, Serializable, Cloneable {
    public static final Map<e, v> e;
    private static final long f = 9132678615281394583L;
    private static final an g = new an("IdJournal");
    private static final ad h = new ad(DTransferConstants.PAY_DOMAIN, (byte) 11, (short) 1);
    private static final ad i = new ad("old_id", (byte) 11, (short) 2);
    private static final ad j = new ad("new_id", (byte) 11, (short) 3);
    private static final ad k = new ad("ts", (byte) 10, (short) 4);
    private static final Map<Class<? extends aq>, ar> l = new HashMap();
    private static final int m = 0;
    public String a;
    public String b;
    public String c;
    public long d;
    private byte n;
    private e[] o;

    /* compiled from: IdJournal */
    private static class a extends as<a> {
        private a() {
        }

        /* renamed from: a */
        public void b(ai aiVar, a aVar) throws p {
            aiVar.j();
            while (true) {
                ad l = aiVar.l();
                if (l.b == (byte) 0) {
                    aiVar.k();
                    if (aVar.m()) {
                        aVar.n();
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
                        aVar.a = aiVar.z();
                        aVar.a(true);
                        break;
                    case (short) 2:
                        if (l.b != (byte) 11) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        aVar.b = aiVar.z();
                        aVar.b(true);
                        break;
                    case (short) 3:
                        if (l.b != (byte) 11) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        aVar.c = aiVar.z();
                        aVar.c(true);
                        break;
                    case (short) 4:
                        if (l.b != (byte) 10) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        aVar.d = aiVar.x();
                        aVar.d(true);
                        break;
                    default:
                        al.a(aiVar, l.b);
                        break;
                }
                aiVar.m();
            }
        }

        /* renamed from: b */
        public void a(ai aiVar, a aVar) throws p {
            aVar.n();
            aiVar.a(a.g);
            if (aVar.a != null) {
                aiVar.a(a.h);
                aiVar.a(aVar.a);
                aiVar.c();
            }
            if (aVar.b != null && aVar.g()) {
                aiVar.a(a.i);
                aiVar.a(aVar.b);
                aiVar.c();
            }
            if (aVar.c != null) {
                aiVar.a(a.j);
                aiVar.a(aVar.c);
                aiVar.c();
            }
            aiVar.a(a.k);
            aiVar.a(aVar.d);
            aiVar.c();
            aiVar.d();
            aiVar.b();
        }
    }

    /* compiled from: IdJournal */
    private static class b implements ar {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: IdJournal */
    private static class c extends at<a> {
        private c() {
        }

        public void a(ai aiVar, a aVar) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(aVar.a);
            aoVar.a(aVar.c);
            aoVar.a(aVar.d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            aoVar.a(bitSet, 1);
            if (aVar.g()) {
                aoVar.a(aVar.b);
            }
        }

        public void b(ai aiVar, a aVar) throws p {
            ao aoVar = (ao) aiVar;
            aVar.a = aoVar.z();
            aVar.a(true);
            aVar.c = aoVar.z();
            aVar.c(true);
            aVar.d = aoVar.x();
            aVar.d(true);
            if (aoVar.b(1).get(0)) {
                aVar.b = aoVar.z();
                aVar.b(true);
            }
        }
    }

    /* compiled from: IdJournal */
    private static class d implements ar {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: IdJournal */
    public enum e implements q {
        DOMAIN((short) 1, DTransferConstants.PAY_DOMAIN),
        OLD_ID((short) 2, "old_id"),
        NEW_ID((short) 3, "new_id"),
        TS((short) 4, "ts");
        
        private static final Map<String, e> e = null;
        private final short f;
        private final String g;

        static {
            e = new HashMap();
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                e.put(eVar.b(), eVar);
            }
        }

        private e(short s, String str) {
            this.f = s;
            this.g = str;
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return DOMAIN;
                case 2:
                    return OLD_ID;
                case 3:
                    return NEW_ID;
                case 4:
                    return TS;
                default:
                    return null;
            }
        }

        public static e a(String str) {
            return (e) e.get(str);
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
            return this.f;
        }

        public String b() {
            return this.g;
        }
    }

    static {
        l.put(as.class, new b());
        l.put(at.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new v(DTransferConstants.PAY_DOMAIN, (byte) 1, new w((byte) 11)));
        enumMap.put(e.OLD_ID, new v("old_id", (byte) 2, new w((byte) 11)));
        enumMap.put(e.NEW_ID, new v("new_id", (byte) 1, new w((byte) 11)));
        enumMap.put(e.TS, new v("ts", (byte) 1, new w((byte) 10)));
        e = Collections.unmodifiableMap(enumMap);
        v.a(a.class, e);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.a = aVar.a;
        }
        if (aVar.g()) {
            this.b = aVar.b;
        }
        if (aVar.j()) {
            this.c = aVar.c;
        }
        this.d = aVar.d;
    }

    public a(String str, String str2, long j) {
        this();
        this.a = str;
        this.c = str2;
        this.d = j;
        d(true);
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.n = (byte) 0;
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
    public a deepCopy() {
        return new a(this);
    }

    public a a(long j) {
        this.d = j;
        d(true);
        return this;
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public a b(String str) {
        this.b = str;
        return this;
    }

    public String b() {
        return this.a;
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public a c(String str) {
        this.c = str;
        return this;
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
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0;
    }

    public void d(boolean z) {
        this.n = g.a(this.n, 0, z);
    }

    public boolean d() {
        return this.a != null;
    }

    public String e() {
        return this.b;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
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

    public long k() {
        return this.d;
    }

    public void l() {
        this.n = g.b(this.n, 0);
    }

    public boolean m() {
        return g.a(this.n, 0);
    }

    public void n() throws p {
        StringBuilder stringBuilder;
        if (this.a == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Required field 'domain' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new aj(stringBuilder.toString());
        } else if (this.c == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Required field 'new_id' was not present! Struct: ");
            stringBuilder.append(toString());
            throw new aj(stringBuilder.toString());
        }
    }

    public void read(ai aiVar) throws p {
        ((ar) l.get(aiVar.D())).b().b(aiVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdJournal(");
        stringBuilder.append("domain:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (g()) {
            stringBuilder.append(", ");
            stringBuilder.append("old_id:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("new_id:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void write(ai aiVar) throws p {
        ((ar) l.get(aiVar.D())).b().a(aiVar, this);
    }
}
