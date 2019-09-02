package cn.jiguang.d.b;

import cn.jiguang.e.c;
import cn.jiguang.g.a;

public final class i {
    int a;
    int b = 0;
    long c;
    byte[] d;
    int e;
    String f;

    public i(byte[] bArr, String str, int i) {
        int i2 = 0;
        this.d = bArr;
        this.a = i;
        this.f = str;
        if (bArr == null || bArr.length < 24) {
            c.c("RequestCacheManager", "parse requesting failed");
            return;
        }
        this.e = a.a(bArr[3]);
        this.c = 0;
        while (i2 < 8) {
            this.c = (this.c << 8) + ((long) (bArr[4 + i2] & 255));
            i2++;
        }
    }

    public final String a() {
        return h.b(this.c, this.f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return (this.c == iVar.c && this.e == iVar.e) ? this.f != null ? this.f.equals(iVar.f) : iVar.f == null : false;
    }

    public final int hashCode() {
        return (31 * (((((int) (this.c ^ (this.c >>> 32))) + 31) * 31) + this.e)) + (this.f != null ? this.f.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Requesting{timeout=");
        stringBuilder.append(this.a);
        stringBuilder.append(", times=");
        stringBuilder.append(this.b);
        stringBuilder.append(", rid=");
        stringBuilder.append(this.c);
        stringBuilder.append(", command=");
        stringBuilder.append(this.e);
        stringBuilder.append(", sdkType='");
        stringBuilder.append(this.f);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
