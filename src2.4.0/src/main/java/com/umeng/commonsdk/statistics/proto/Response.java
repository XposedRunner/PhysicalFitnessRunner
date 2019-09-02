package com.umeng.commonsdk.statistics.proto;

import com.umeng.commonsdk.proguard.aa;
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
import defpackage.db;
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

public class Response implements j<Response, e>, Serializable, Cloneable {
    private static final ad IMPRINT_FIELD_DESC = new ad(com.umeng.commonsdk.proguard.e.U, (byte) 12, (short) 3);
    private static final ad MSG_FIELD_DESC = new ad(db.O000OO00, (byte) 11, (short) 2);
    private static final ad RESP_CODE_FIELD_DESC = new ad("resp_code", (byte) 8, (short) 1);
    private static final an STRUCT_DESC = new an("Response");
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, v> metaDataMap;
    private static final Map<Class<? extends aq>, ar> schemes = new HashMap();
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;

    private static class a extends as<Response> {
        private a() {
        }

        /* renamed from: a */
        public void b(ai aiVar, Response response) throws p {
            aiVar.j();
            while (true) {
                ad l = aiVar.l();
                if (l.b == (byte) 0) {
                    aiVar.k();
                    if (response.isSetResp_code()) {
                        response.validate();
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Required field 'resp_code' was not found in serialized data! Struct: ");
                    stringBuilder.append(toString());
                    throw new aj(stringBuilder.toString());
                }
                switch (l.c) {
                    case (short) 1:
                        if (l.b != (byte) 8) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        response.resp_code = aiVar.w();
                        response.setResp_codeIsSet(true);
                        break;
                    case (short) 2:
                        if (l.b != (byte) 11) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        response.msg = aiVar.z();
                        response.setMsgIsSet(true);
                        break;
                    case (short) 3:
                        if (l.b != (byte) 12) {
                            al.a(aiVar, l.b);
                            break;
                        }
                        response.imprint = new d();
                        response.imprint.read(aiVar);
                        response.setImprintIsSet(true);
                        break;
                    default:
                        al.a(aiVar, l.b);
                        break;
                }
                aiVar.m();
            }
        }

        /* renamed from: b */
        public void a(ai aiVar, Response response) throws p {
            response.validate();
            aiVar.a(Response.STRUCT_DESC);
            aiVar.a(Response.RESP_CODE_FIELD_DESC);
            aiVar.a(response.resp_code);
            aiVar.c();
            if (response.msg != null && response.isSetMsg()) {
                aiVar.a(Response.MSG_FIELD_DESC);
                aiVar.a(response.msg);
                aiVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                aiVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(aiVar);
                aiVar.c();
            }
            aiVar.d();
            aiVar.b();
        }
    }

    private static class b implements ar {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    private static class c extends at<Response> {
        private c() {
        }

        public void a(ai aiVar, Response response) throws p {
            ao aoVar = (ao) aiVar;
            aoVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            aoVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                aoVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(aoVar);
            }
        }

        public void b(ai aiVar, Response response) throws p {
            ao aoVar = (ao) aiVar;
            response.resp_code = aoVar.w();
            response.setResp_codeIsSet(true);
            BitSet b = aoVar.b(2);
            if (b.get(0)) {
                response.msg = aoVar.z();
                response.setMsgIsSet(true);
            }
            if (b.get(1)) {
                response.imprint = new d();
                response.imprint.read(aoVar);
                response.setImprintIsSet(true);
            }
        }
    }

    private static class d implements ar {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    public enum e implements q {
        RESP_CODE((short) 1, "resp_code"),
        MSG((short) 2, db.O000OO00),
        IMPRINT((short) 3, com.umeng.commonsdk.proguard.e.U);
        
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
                    return RESP_CODE;
                case 2:
                    return MSG;
                case 3:
                    return IMPRINT;
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
        schemes.put(as.class, new b());
        schemes.put(at.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.RESP_CODE, new v("resp_code", (byte) 1, new w((byte) 8)));
        enumMap.put(e.MSG, new v(db.O000OO00, (byte) 2, new w((byte) 11)));
        enumMap.put(e.IMPRINT, new v(com.umeng.commonsdk.proguard.e.U, (byte) 2, new aa((byte) 12, d.class)));
        metaDataMap = Collections.unmodifiableMap(enumMap);
        v.a(Response.class, metaDataMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new d(response.imprint);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new ac(new au((InputStream) objectInputStream)));
        } catch (p e) {
            throw new IOException(e.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ac(new au((OutputStream) objectOutputStream)));
        } catch (p e) {
            throw new IOException(e.getMessage());
        }
    }

    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public Response deepCopy() {
        return new Response(this);
    }

    public e fieldForId(int i) {
        return e.a(i);
    }

    public d getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return g.a(this.__isset_bitfield, 0);
    }

    public void read(ai aiVar) throws p {
        ((ar) schemes.get(aiVar.D())).b().b(aiVar, this);
    }

    public Response setImprint(d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (!z) {
            this.imprint = null;
        }
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (!z) {
            this.msg = null;
        }
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = g.a(this.__isset_bitfield, 0, z);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Response(");
        stringBuilder.append("resp_code:");
        stringBuilder.append(this.resp_code);
        if (isSetMsg()) {
            stringBuilder.append(", ");
            stringBuilder.append("msg:");
            if (this.msg == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.msg);
            }
        }
        if (isSetImprint()) {
            stringBuilder.append(", ");
            stringBuilder.append("imprint:");
            if (this.imprint == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.imprint);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = g.b(this.__isset_bitfield, 0);
    }

    public void validate() throws p {
        if (this.imprint != null) {
            this.imprint.l();
        }
    }

    public void write(ai aiVar) throws p {
        ((ar) schemes.get(aiVar.D())).b().a(aiVar, this);
    }
}
