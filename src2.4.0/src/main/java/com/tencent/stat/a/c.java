package com.tencent.stat.a;

import java.util.Arrays;
import java.util.Properties;

public class c {
    String a;
    String[] b;
    Properties c = null;

    public c(String str, String[] strArr, Properties properties) {
        this.a = str;
        this.b = strArr;
        this.c = properties;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        boolean z = this.a.equals(cVar.a) && Arrays.equals(this.b, cVar.b);
        return this.c != null ? z && this.c.equals(cVar.c) : z && cVar.c == null;
    }

    public int hashCode() {
        int hashCode = this.a != null ? this.a.hashCode() : 0;
        if (this.b != null) {
            hashCode ^= Arrays.hashCode(this.b);
        }
        return this.c != null ? hashCode ^ this.c.hashCode() : hashCode;
    }

    public String toString() {
        StringBuilder stringBuilder;
        String str = this.a;
        String str2 = "";
        if (this.b != null) {
            str2 = this.b[0];
            for (int i = 1; i < this.b.length; i++) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(",");
                stringBuilder2.append(this.b[i]);
                str2 = stringBuilder2.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(str2);
            stringBuilder.append("]");
            str2 = stringBuilder.toString();
        }
        if (this.c != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(this.c.toString());
            str2 = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
