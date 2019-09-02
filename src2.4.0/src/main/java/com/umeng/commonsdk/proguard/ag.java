package com.umeng.commonsdk.proguard;

/* compiled from: TMessage */
public final class ag {
    public final String a;
    public final byte b;
    public final int c;

    public ag() {
        this("", (byte) 0, 0);
    }

    public ag(String str, byte b, int i) {
        this.a = str;
        this.b = b;
        this.c = i;
    }

    public boolean a(ag agVar) {
        return this.a.equals(agVar.a) && this.b == agVar.b && this.c == agVar.c;
    }

    public boolean equals(Object obj) {
        return obj instanceof ag ? a((ag) obj) : false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<TMessage name:'");
        stringBuilder.append(this.a);
        stringBuilder.append("' type: ");
        stringBuilder.append(this.b);
        stringBuilder.append(" seqid:");
        stringBuilder.append(this.c);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
