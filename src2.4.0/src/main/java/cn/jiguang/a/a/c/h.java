package cn.jiguang.a.a.c;

public final class h {
    public String a = "";
    public String b = "";
    public String c = "";
    public int d = 0;
    public int e = 0;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(",");
        stringBuilder.append(this.b);
        stringBuilder.append(",");
        stringBuilder.append(this.c);
        stringBuilder.append(",");
        stringBuilder.append(this.d);
        stringBuilder.append(",");
        stringBuilder.append(this.e);
        return stringBuilder.toString();
    }
}
