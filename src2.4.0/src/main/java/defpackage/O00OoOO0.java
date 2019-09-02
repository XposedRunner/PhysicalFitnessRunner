package defpackage;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import java.util.List;
import java.util.Queue;

/* compiled from: ListPreloader */
/* renamed from: O00OoOO0 */
public class O00OoOO0<T> implements OnScrollListener {
    private final int O000000o;
    private final O00000o O00000Oo;
    private final O00000Oo<T> O00000o;
    private final O000000o<T> O00000o0;
    private int O00000oO;
    private int O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private boolean O0000Oo0;

    /* compiled from: ListPreloader */
    /* renamed from: O00OoOO0$O000000o */
    public interface O000000o<U> {
        O00Oo00o O000000o(U u);

        List<U> O000000o(int i);
    }

    /* compiled from: ListPreloader */
    /* renamed from: O00OoOO0$1 */
    class 1 implements O000000o<T> {
        final /* synthetic */ O00OoOO0 O000000o;

        1(O00OoOO0 o00OoOO0) {
        }

        public O00Oo00o O000000o(T t) {
            return null;
        }

        public List<T> O000000o(int i) {
            return null;
        }
    }

    /* compiled from: ListPreloader */
    /* renamed from: O00OoOO0$O00000Oo */
    public interface O00000Oo<T> {
        int[] O000000o(T t, int i, int i2);
    }

    /* compiled from: ListPreloader */
    /* renamed from: O00OoOO0$2 */
    class 2 implements O00000Oo<T> {
        final /* synthetic */ O00OoOO0 O000000o;

        2(O00OoOO0 o00OoOO0) {
        }

        public int[] O000000o(T t, int i, int i2) {
            return null;
        }
    }

    /* compiled from: ListPreloader */
    /* renamed from: O00OoOO0$O00000o0 */
    private static class O00000o0 extends oO0OO00o<Object> {
        private int O00000Oo;
        private int O00000o0;

        private O00000o0() {
        }

        /* synthetic */ O00000o0(1 1) {
        }

        public void O000000o(Object obj, oO00OOOo<? super Object> oo00oooo) {
        }

        public void O000000o(oO0O0Oo0 oo0o0oo0) {
        }
    }

    /* compiled from: ListPreloader */
    /* renamed from: O00OoOO0$O00000o */
    private static final class O00000o {
        private final Queue<O00000o0> O000000o;

        public O00000o(int i) {
        }

        public O00000o0 O000000o(int i, int i2) {
            return null;
        }
    }

    @Deprecated
    public O00OoOO0(int i) {
    }

    public O00OoOO0(O000000o<T> o000000o, O00000Oo<T> o00000Oo, int i) {
    }

    private void O000000o() {
    }

    private void O000000o(int i, boolean z) {
    }

    private void O000000o(T t, int i, int i2) {
    }

    private void O000000o(List<T> list, int i, boolean z) {
    }

    private void O00000Oo(int i, int i2) {
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    public List<T> O000000o(int i, int i2) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    public int[] O000000o(T t) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    @Deprecated
    public O00Oo00o O00000Oo(T t) {
        return null;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
