package cn.jiguang.d.c;

public final class n extends IllegalArgumentException {
    public n(j jVar) {
        StringBuilder stringBuilder = new StringBuilder("'");
        stringBuilder.append(jVar);
        stringBuilder.append("' is not an absolute name");
        super(stringBuilder.toString());
    }
}
