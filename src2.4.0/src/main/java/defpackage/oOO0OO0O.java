package defpackage;

import android.annotation.TargetApi;
import android.os.Build.VERSION;

/* compiled from: LogTime */
/* renamed from: oOO0OO0O */
public final class oOO0OO0O {
    private static final double O000000o;

    static {
        double d = 1.0d;
        if (17 <= VERSION.SDK_INT) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        O000000o = d;
    }

    private oOO0OO0O() {
    }

    public static double O000000o(long j) {
        return 0.0d;
    }

    @TargetApi(17)
    public static long O000000o() {
        return 0;
    }
}
