package cn.jiguang.d.a;

import android.content.Context;
import cn.jiguang.g.b.d;
import java.util.Random;

public final class e {
    private static d a;

    public static synchronized long a() {
        synchronized (e.class) {
            long longValue = ((Long) a(null).a("next_rid", Long.valueOf(-1))).longValue();
            if (longValue != -1) {
                longValue = a(longValue);
                a(null).b("next_rid", Long.valueOf(longValue));
            }
            if (longValue != -1) {
                return longValue;
            }
            longValue = a((long) Math.abs(new Random().nextInt(32767)));
            a(null).b("next_rid", Long.valueOf(longValue));
            return longValue;
        }
    }

    private static long a(long j) {
        long j2 = 2;
        if (j % 2 == 0) {
            j2 = 1;
        }
        return (j + j2) % 32767;
    }

    private static d a(Context context) {
        if (a == null) {
            a = d.a(null, "cn.jpush.preferences.v2.rid");
        }
        return a;
    }
}
