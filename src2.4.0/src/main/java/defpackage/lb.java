package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: RoundedCornersTransformation */
/* renamed from: lb */
public class lb implements O0OoOo<Bitmap> {
    private OO000OO O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private O000000o O00000oO;

    /* compiled from: RoundedCornersTransformation */
    /* renamed from: lb$1 */
    static /* synthetic */ class 1 {
        static final /* synthetic */ int[] O000000o = new int[O000000o.values().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        static {
            /*
            r0 = defpackage.lb.O000000o.values();
            r0 = r0.length;
            r0 = new int[r0];
            O000000o = r0;
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = defpackage.lb.O000000o.ALL;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = defpackage.lb.O000000o.TOP_LEFT;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = defpackage.lb.O000000o.TOP_RIGHT;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = defpackage.lb.O000000o.BOTTOM_LEFT;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = defpackage.lb.O000000o.BOTTOM_RIGHT;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = defpackage.lb.O000000o.TOP;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = defpackage.lb.O000000o.BOTTOM;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 7;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r1 = defpackage.lb.O000000o.LEFT;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0062 }
            r2 = 8;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0062 }
        L_0x0062:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x006e }
            r1 = defpackage.lb.O000000o.RIGHT;	 Catch:{ NoSuchFieldError -> 0x006e }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x006e }
            r2 = 9;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x006e }
        L_0x006e:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x007a }
            r1 = defpackage.lb.O000000o.OTHER_TOP_LEFT;	 Catch:{ NoSuchFieldError -> 0x007a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x007a }
            r2 = 10;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x007a }
        L_0x007a:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0086 }
            r1 = defpackage.lb.O000000o.OTHER_TOP_RIGHT;	 Catch:{ NoSuchFieldError -> 0x0086 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0086 }
            r2 = 11;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0086 }
        L_0x0086:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0092 }
            r1 = defpackage.lb.O000000o.OTHER_BOTTOM_LEFT;	 Catch:{ NoSuchFieldError -> 0x0092 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0092 }
            r2 = 12;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0092 }
        L_0x0092:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x009e }
            r1 = defpackage.lb.O000000o.OTHER_BOTTOM_RIGHT;	 Catch:{ NoSuchFieldError -> 0x009e }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x009e }
            r2 = 13;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x009e }
        L_0x009e:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x00aa }
            r1 = defpackage.lb.O000000o.DIAGONAL_FROM_TOP_LEFT;	 Catch:{ NoSuchFieldError -> 0x00aa }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00aa }
            r2 = 14;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00aa }
        L_0x00aa:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x00b6 }
            r1 = defpackage.lb.O000000o.DIAGONAL_FROM_TOP_RIGHT;	 Catch:{ NoSuchFieldError -> 0x00b6 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00b6 }
            r2 = 15;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00b6 }
        L_0x00b6:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.lb$1.<clinit>():void");
        }
    }

    /* compiled from: RoundedCornersTransformation */
    /* renamed from: lb$O000000o */
    public enum O000000o {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public lb(OO000OO oo000oo, int i, int i2) {
    }

    public lb(OO000OO oo000oo, int i, int i2, O000000o o000000o) {
    }

    public lb(Context context, int i, int i2) {
    }

    public lb(Context context, int i, int i2, O000000o o000000o) {
    }

    private void O000000o(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O00000Oo(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O00000o(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O00000o0(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O00000oO(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O00000oo(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O0000O0o(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O0000OOo(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O0000Oo(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O0000Oo0(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O0000OoO(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O0000Ooo(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O0000o0(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O0000o00(Canvas canvas, Paint paint, float f, float f2) {
    }

    private void O0000o0O(Canvas canvas, Paint paint, float f, float f2) {
    }

    public Oo0OOo<Bitmap> O000000o(Oo0OOo<Bitmap> oo0OOo, int i, int i2) {
        return null;
    }

    public String O000000o() {
        return null;
    }
}
