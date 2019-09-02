package cn.jiguang.g;

import cn.jiguang.d.h.c;
import java.util.Date;

public final class l {
    private long a = System.currentTimeMillis();

    public final void a(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" | cost time:");
        stringBuilder.append(c.a("mm:ss:SSS").format(new Date(currentTimeMillis)));
    }
}
