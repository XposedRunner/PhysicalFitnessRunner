package cn.jiguang.d.c;

public final class p extends m {
    private int e;
    private int f;
    private int g;
    private j h;

    p() {
    }

    /* Access modifiers changed, original: final */
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append(" ");
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.f);
        stringBuilder.append(" ");
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.g);
        stringBuilder.append(" ");
        stringBuffer.append(stringBuilder.toString());
        stringBuffer.append(this.h);
        return stringBuffer.toString();
    }

    /* Access modifiers changed, original: final */
    public final void a(d dVar) {
        this.e = dVar.g();
        this.f = dVar.g();
        this.g = dVar.g();
        this.h = new j(dVar);
    }

    /* Access modifiers changed, original: final */
    public final void a(e eVar, boolean z) {
        eVar.c(this.e);
        eVar.c(this.f);
        eVar.c(this.g);
        this.h.a(eVar, null, true);
    }

    public final int h() {
        return this.g;
    }

    public final j i() {
        return this.h;
    }
}
