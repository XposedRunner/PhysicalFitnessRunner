package cn.jpush.android.c;

final class e {
    String a;
    int b;
    String c;
    byte d;
    final /* synthetic */ d e;

    e(d dVar) {
        this.e = dVar;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ThirdMessage{msgid='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", notiId=");
        stringBuilder.append(this.b);
        stringBuilder.append(", content='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", platform=");
        stringBuilder.append(this.d);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
