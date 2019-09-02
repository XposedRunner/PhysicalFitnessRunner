package cn.jiguang.d.b;

final class k {
    String a;
    int b;

    public k(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            throw new Exception("Port is needed for a valid address, split by :");
        }
        this.a = str.substring(0, indexOf);
        if (j.c(this.a)) {
            str = str.substring(indexOf + 1);
            try {
                this.b = Integer.parseInt(str);
                if (this.b == 0) {
                    throw new Exception("Invalid port - 0");
                }
                return;
            } catch (Exception unused) {
                StringBuilder stringBuilder = new StringBuilder("Invalid port - ");
                stringBuilder.append(str);
                throw new Exception(stringBuilder.toString());
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("Invalid ip - ");
        stringBuilder2.append(this.a);
        throw new Exception(stringBuilder2.toString());
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(":");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
