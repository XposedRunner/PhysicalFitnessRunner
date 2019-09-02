package com.qiyukf.nim.uikit.common.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.qiyukf.basesdk.a.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d<T> extends BaseAdapter implements b {
    protected final Context a;
    private final List<T> b;
    private final e c;
    private final LayoutInflater d;
    private final Map<Class<?>, Integer> e = new HashMap(getViewTypeCount());
    private Object f;
    private boolean g;
    private Set<a> h = new HashSet();

    public d(Context context, List<T> list, e eVar) {
        this.a = context;
        this.b = list;
        this.c = eVar;
        this.d = LayoutInflater.from(context);
    }

    private View a(int i, View view) {
        if (view == null) {
            view = b(i);
        }
        f fVar = (f) view.getTag();
        fVar.setPosition(i);
        try {
            fVar.refresh(getItem(i));
            a(i);
        } catch (RuntimeException e) {
            StringBuilder stringBuilder = new StringBuilder("refresh viewholder error. ");
            stringBuilder.append(e);
            a.c("TAdapter", stringBuilder.toString());
        }
        if (fVar instanceof a) {
            this.h.add(fVar);
        }
        return view;
    }

    private View b(int i) {
        Exception e;
        View view;
        try {
            f fVar = (f) this.c.a(i).newInstance();
            fVar.setAdapter(this);
            fVar.setContext(this.a);
            view = fVar.getView(this.d);
            try {
                view.setTag(fVar);
                return view;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return view;
            }
        } catch (Exception e3) {
            e = e3;
            view = null;
            e.printStackTrace();
            return view;
        }
    }

    public final List<T> a() {
        return this.b;
    }

    /* Access modifiers changed, original: protected */
    public void a(int i) {
    }

    public final void a(View view) {
        if (view != null) {
            f fVar = (f) view.getTag();
            if (fVar != null) {
                fVar.reclaim();
                this.h.remove(fVar);
            }
        }
    }

    public final void a(Object obj) {
        this.f = obj;
    }

    public final boolean b() {
        return this.g;
    }

    public final Object c() {
        return this.f;
    }

    public int getCount() {
        return this.b == null ? 0 : this.b.size();
    }

    public T getItem(int i) {
        return i < getCount() ? this.b.get(i) : null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (getViewTypeCount() == 1) {
            return 0;
        }
        Class a = this.c.a(i);
        if (this.e.containsKey(a)) {
            return ((Integer) this.e.get(a)).intValue();
        }
        int size = this.e.size();
        if (size >= getViewTypeCount()) {
            return 0;
        }
        this.e.put(a, Integer.valueOf(size));
        return size;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view);
    }

    public int getViewTypeCount() {
        return this.c.a();
    }

    public boolean isEnabled(int i) {
        return this.c.b();
    }
}
