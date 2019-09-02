package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import java.util.List;

/* compiled from: CommonAdapter */
/* renamed from: fw */
public abstract class fw<T> extends fx<T> {
    protected int O00000o;
    protected Context O00000o0;
    protected List<T> O00000oO;
    protected LayoutInflater O00000oo;

    /* compiled from: CommonAdapter */
    /* renamed from: fw$1 */
    class 1 implements fy<T> {
        final /* synthetic */ int O000000o;
        final /* synthetic */ fw O00000Oo;

        1(fw fwVar, int i) {
        }

        public int O000000o() {
            return 0;
        }

        public void O000000o(ga gaVar, T t, int i) {
        }

        public boolean O000000o(T t, int i) {
            return true;
        }
    }

    public fw(Context context, int i, List<T> list) {
    }

    public abstract void O000000o(ga gaVar, T t, int i);
}
