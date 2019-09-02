package com.umeng.commonsdk.proguard;

import java.io.Serializable;

/* compiled from: FieldValueMetaData */
public class w implements Serializable {
    private final boolean a;
    public final byte b;
    private final String c;
    private final boolean d;

    public w(byte b) {
        this(b, false);
    }

    public w(byte b, String str) {
        this.b = b;
        this.a = true;
        this.c = str;
        this.d = false;
    }

    public w(byte b, boolean z) {
        this.b = b;
        this.a = false;
        this.c = null;
        this.d = z;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public boolean c() {
        return this.b == (byte) 12;
    }

    public boolean d() {
        return this.b == ap.m || this.b == ap.k || this.b == ap.l;
    }

    public boolean e() {
        return this.d;
    }
}
