package defpackage;

/* compiled from: DiskCacheStrategy */
/* renamed from: O0Oo0 */
public enum O0Oo0 {
    ALL(true, true),
    NONE(false, false),
    SOURCE(true, false),
    RESULT(false, true);
    
    private final boolean O00000oO;
    private final boolean O00000oo;

    private O0Oo0(boolean z, boolean z2) {
        this.O00000oO = z;
        this.O00000oo = z2;
    }

    public boolean O000000o() {
        return this.O00000oO;
    }

    public boolean O00000Oo() {
        return this.O00000oo;
    }
}
