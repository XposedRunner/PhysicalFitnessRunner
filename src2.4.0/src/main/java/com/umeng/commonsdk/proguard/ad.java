package com.umeng.commonsdk.proguard;

/* compiled from: TField */
public class ad {
    public final String a;
    public final byte b;
    public final short c;

    public ad() {
        this("", (byte) 0, (short) 0);
    }

    public ad(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.c = s;
    }

    public boolean a(ad adVar) {
        return this.b == adVar.b && this.c == adVar.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<TField name:'");
        stringBuilder.append(this.a);
        stringBuilder.append("' type:");
        stringBuilder.append(this.b);
        stringBuilder.append(" field-id:");
        stringBuilder.append(this.c);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
