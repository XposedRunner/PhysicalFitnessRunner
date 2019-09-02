package com.qiyukf.unicorn.widget.flowlayout;

import android.view.View;
import java.util.HashSet;
import java.util.List;

public abstract class a<T> {
    private List<T> a;
    private a b;
    @Deprecated
    private HashSet<Integer> c = new HashSet();

    interface a {
        void a();
    }

    public a(List<T> list) {
        this.a = list;
    }

    public abstract View a(FlowLayout flowLayout, int i, T t);

    public final T a(int i) {
        return this.a.get(i);
    }

    /* Access modifiers changed, original: final */
    @Deprecated
    public final HashSet<Integer> a() {
        return this.c;
    }

    /* Access modifiers changed, original: final */
    public final void a(a aVar) {
        this.b = aVar;
    }

    public final int b() {
        return this.a == null ? 0 : this.a.size();
    }

    public final void c() {
        if (this.b != null) {
            this.b.a();
        }
    }
}
