package com.umeng.commonsdk.proguard;

/* compiled from: TApplicationException */
public class i extends p {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final an j = new an("TApplicationException");
    private static final ad k = new ad("message", (byte) 11, (short) 1);
    private static final ad l = new ad("type", (byte) 8, (short) 2);
    private static final long m = 1;
    protected int i = 0;

    public i(int i) {
        this.i = i;
    }

    public i(int i, String str) {
        super(str);
        this.i = i;
    }

    public i(String str) {
        super(str);
    }

    public static i a(ai aiVar) throws p {
        aiVar.j();
        String str = null;
        int i = 0;
        while (true) {
            ad l = aiVar.l();
            if (l.b == (byte) 0) {
                aiVar.k();
                return new i(i, str);
            }
            switch (l.c) {
                case (short) 1:
                    if (l.b != (byte) 11) {
                        al.a(aiVar, l.b);
                        break;
                    }
                    str = aiVar.z();
                    break;
                case (short) 2:
                    if (l.b != (byte) 8) {
                        al.a(aiVar, l.b);
                        break;
                    }
                    i = aiVar.w();
                    break;
                default:
                    al.a(aiVar, l.b);
                    break;
            }
            aiVar.m();
        }
    }

    public int a() {
        return this.i;
    }

    public void b(ai aiVar) throws p {
        aiVar.a(j);
        if (getMessage() != null) {
            aiVar.a(k);
            aiVar.a(getMessage());
            aiVar.c();
        }
        aiVar.a(l);
        aiVar.a(this.i);
        aiVar.c();
        aiVar.d();
        aiVar.b();
    }
}
