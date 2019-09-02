package cn.jiguang.d.d;

import cn.jiguang.g.i;
import java.io.Serializable;

public final class a implements Serializable {
    public String a = "";
    public String b = "";
    public int c = 0;
    public String d;

    public a(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return (i.a(this.a) || i.a(this.b) || i.a(aVar.a) || i.a(aVar.b) || !i.a(this.a, aVar.a) || !i.a(this.b, aVar.b)) ? false : true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AWakeInfo{pk_name='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", sv_name='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", target_version=");
        stringBuilder.append(this.c);
        stringBuilder.append(", providerAuthority='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
