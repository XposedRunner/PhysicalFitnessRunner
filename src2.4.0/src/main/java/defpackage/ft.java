package defpackage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* compiled from: RecyclerListAdapter */
/* renamed from: ft */
public abstract class ft<T, VH extends O000000o<T>> extends fr<T, VH> {
    public static final int O00000Oo = Integer.MIN_VALUE;
    private final HashMap<Integer, O00000Oo> O00000o;
    private final HashMap<Class<?>, Integer> O00000o0;

    /* compiled from: RecyclerListAdapter */
    /* renamed from: ft$O000000o */
    public static abstract class O000000o<T> extends ViewHolder {
        public O000000o(@NonNull View view) {
        }

        public abstract void O000000o(T t, int i);
    }

    /* compiled from: RecyclerListAdapter */
    /* renamed from: ft$O00000Oo */
    public interface O00000Oo<VH extends O000000o> {
        VH O000000o(ViewGroup viewGroup);
    }

    public int O000000o(Class<?> cls) {
        return 0;
    }

    public VH O000000o(ViewGroup viewGroup) {
        return null;
    }

    public VH O000000o(ViewGroup viewGroup, int i) {
        return null;
    }

    public <F> void O000000o(int i, O00000Oo<? extends O000000o<? extends F>> o00000Oo) {
    }

    public void O000000o(VH vh, int i) {
    }

    public <F> void O000000o(Class<? extends F> cls, O00000Oo<? extends O000000o<? extends F>> o00000Oo) {
    }

    public int O00000o0(T t) {
        return 0;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }
}
