package cn.jpush.android.a;

final class h {
    public int a;
    public String b;
    final /* synthetic */ g c;

    public h(g gVar, int i, String str) {
        this.c = gVar;
        this.a = i;
        this.b = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MobileBean{sequence=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mobileNumber='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
