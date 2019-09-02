package defpackage;

/* compiled from: SimpleTarget */
/* renamed from: oOo0oooO */
public abstract class oOo0oooO<Z> extends oO0OO00o<Z> {
    private final int O00000Oo;
    private final int O00000o0;

    public oOo0oooO() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public oOo0oooO(int i, int i2) {
        this.O00000Oo = i;
        this.O00000o0 = i2;
    }

    public final void O000000o(oO0O0Oo0 oo0o0oo0) {
        if (oOOO000o.O000000o(this.O00000Oo, this.O00000o0)) {
            oo0o0oo0.O000000o(this.O00000Oo, this.O00000o0);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append(" and height: ");
        stringBuilder.append(this.O00000o0);
        stringBuilder.append(", either provide dimensions in the constructor");
        stringBuilder.append(" or call override()");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
