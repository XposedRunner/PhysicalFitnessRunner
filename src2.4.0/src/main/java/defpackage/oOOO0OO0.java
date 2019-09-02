package defpackage;

/* compiled from: Effects */
/* renamed from: oOOO0OO0 */
public enum oOOO0OO0 {
    standard(e.class),
    slideOnTop(d.class),
    flip(oo000000.class),
    slideIn(c.class),
    jelly(a.class),
    thumbSlider(f.class),
    scale(b.class);
    
    private Class<? extends oOOo0000> O0000OOo;

    private oOOO0OO0(Class<? extends oOOo0000> cls) {
        this.O0000OOo = cls;
    }

    public oOOo0000 O000000o() {
        try {
            return (oOOo0000) this.O0000OOo.newInstance();
        } catch (ClassCastException unused) {
            throw new Error("Can not init animatorClazz instance");
        } catch (InstantiationException unused2) {
            throw new Error("Can not init animatorClazz instance");
        } catch (IllegalAccessException unused3) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
