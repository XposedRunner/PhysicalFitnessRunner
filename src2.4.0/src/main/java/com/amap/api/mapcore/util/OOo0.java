package com.amap.api.mapcore.util;

/* compiled from: RectPacker */
public class OOo0 {
    O00000Oo O000000o;

    /* compiled from: RectPacker */
    enum O000000o {
        FAIL,
        PERFECT,
        FIT
    }

    /* compiled from: RectPacker */
    class O00000Oo {
        static final /* synthetic */ boolean O00000oO = true;
        String O000000o;
        O00000o0 O00000Oo;
        O00000Oo O00000o = null;
        O00000Oo O00000o0 = null;

        static {
            Class cls = OOo0.class;
        }

        O00000Oo(O00000o0 o00000o0) {
            this.O00000Oo = o00000o0;
        }

        /* Access modifiers changed, original: 0000 */
        public O00000Oo O000000o(int i, int i2, String str) {
            if (!O000000o()) {
                O00000Oo O000000o = this.O00000o0.O000000o(i, i2, str);
                if (O000000o == null) {
                    O000000o = this.O00000o.O000000o(i, i2, str);
                }
                return O000000o;
            } else if (this.O000000o != null) {
                return null;
            } else {
                switch (O00000Oo(i, i2)) {
                    case FAIL:
                        return null;
                    case PERFECT:
                        this.O000000o = str;
                        return this;
                    case FIT:
                        O000000o(i, i2);
                        break;
                }
                return this.O00000o0.O000000o(i, i2, str);
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(int i, int i2) {
            int i3 = this.O00000Oo.O00000o0 - i;
            int i4 = this.O00000Oo.O00000o - i2;
            if (!O00000oO && i3 < 0) {
                throw new AssertionError();
            } else if (O00000oO || i4 >= 0) {
                O00000o0 o00000o0;
                O00000o0 o00000o02;
                if (i3 > i4) {
                    O00000o0 o00000o03 = new O00000o0(this.O00000Oo.O000000o, this.O00000Oo.O00000Oo, i, this.O00000Oo.O00000o);
                    o00000o0 = new O00000o0(o00000o03.O000000o + i, this.O00000Oo.O00000Oo, this.O00000Oo.O00000o0 - i, this.O00000Oo.O00000o);
                    o00000o02 = o00000o03;
                } else {
                    o00000o02 = new O00000o0(this.O00000Oo.O000000o, this.O00000Oo.O00000Oo, this.O00000Oo.O00000o0, i2);
                    o00000o0 = new O00000o0(this.O00000Oo.O000000o, o00000o02.O00000Oo + i2, this.O00000Oo.O00000o0, this.O00000Oo.O00000o - i2);
                }
                this.O00000o0 = new O00000Oo(o00000o02);
                this.O00000o = new O00000Oo(o00000o0);
            } else {
                throw new AssertionError();
            }
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o() {
            return this.O00000o0 == null;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(String str) {
            if (!O000000o()) {
                boolean O000000o = this.O00000o0.O000000o(str);
                if (!O000000o) {
                    O000000o = this.O00000o.O000000o(str);
                }
                if (!(!O000000o || this.O00000o0.O00000Oo() || this.O00000o.O00000Oo())) {
                    this.O00000o0 = null;
                    this.O00000o = null;
                }
                return O000000o;
            } else if (!str.equals(this.O000000o)) {
                return false;
            } else {
                this.O000000o = null;
                return true;
            }
        }

        /* Access modifiers changed, original: 0000 */
        public O000000o O00000Oo(int i, int i2) {
            return (i > this.O00000Oo.O00000o0 || i2 > this.O00000Oo.O00000o) ? O000000o.FAIL : (i == this.O00000Oo.O00000o0 && i2 == this.O00000Oo.O00000o) ? O000000o.PERFECT : O000000o.FIT;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O00000Oo() {
            return (this.O000000o == null && O000000o()) ? false : true;
        }
    }

    /* compiled from: RectPacker */
    public static class O00000o0 {
        public int O000000o;
        public int O00000Oo;
        public int O00000o;
        public int O00000o0;

        O00000o0(int i, int i2, int i3, int i4) {
            this.O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
            this.O00000o = i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[ x: ");
            stringBuilder.append(this.O000000o);
            stringBuilder.append(", y: ");
            stringBuilder.append(this.O00000Oo);
            stringBuilder.append(", w: ");
            stringBuilder.append(this.O00000o0);
            stringBuilder.append(", h: ");
            stringBuilder.append(this.O00000o);
            stringBuilder.append(" ]");
            return stringBuilder.toString();
        }
    }

    public OOo0(int i, int i2) {
        this.O000000o = new O00000Oo(new O00000o0(0, 0, i, i2));
    }

    public int O000000o() {
        return this.O000000o.O00000Oo.O00000o0;
    }

    public O00000o0 O000000o(int i, int i2, String str) {
        O00000Oo O000000o = this.O000000o.O000000o(i, i2, str);
        return O000000o != null ? new O00000o0(O000000o.O00000Oo.O000000o, O000000o.O00000Oo.O00000Oo, O000000o.O00000Oo.O00000o0, O000000o.O00000Oo.O00000o) : null;
    }

    public boolean O000000o(String str) {
        return this.O000000o.O000000o(str);
    }

    public int O00000Oo() {
        return this.O000000o.O00000Oo.O00000o;
    }
}
