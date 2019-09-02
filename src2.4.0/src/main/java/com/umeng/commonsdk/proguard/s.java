package com.umeng.commonsdk.proguard;

import com.umeng.commonsdk.proguard.ac.a;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: TSerializer */
public class s {
    private final ByteArrayOutputStream a;
    private final au b;
    private ai c;

    public s() {
        this(new a());
    }

    public s(ak akVar) {
        this.a = new ByteArrayOutputStream();
        this.b = new au(this.a);
        this.c = akVar.a(this.b);
    }

    public String a(j jVar, String str) throws p {
        try {
            return new String(a(jVar), str);
        } catch (UnsupportedEncodingException unused) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JVM DOES NOT SUPPORT ENCODING: ");
            stringBuilder.append(str);
            throw new p(stringBuilder.toString());
        }
    }

    public byte[] a(j jVar) throws p {
        this.a.reset();
        jVar.write(this.c);
        return this.a.toByteArray();
    }

    public String b(j jVar) throws p {
        return new String(a(jVar));
    }
}
