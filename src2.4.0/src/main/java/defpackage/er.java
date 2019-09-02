package defpackage;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import com.zjwh.android_wh_physicalfitness.entity.Rank;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RecyclerViewHeaderAdapter */
/* renamed from: er */
public abstract class er<V extends ViewHolder> extends Adapter<V> {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    private final Context O00000o;
    private View O00000o0;
    private final List<O000000o> O00000oO = new ArrayList();
    private final List<O000000o> O00000oo = new ArrayList();

    /* compiled from: RecyclerViewHeaderAdapter */
    /* renamed from: er$O000000o */
    public static class O000000o<V extends ViewHolder> {
        public final int O000000o;
        public final V O00000Oo;

        public O000000o(int i, V v) {
            this.O000000o = i;
            this.O00000Oo = v;
        }
    }

    /* compiled from: RecyclerViewHeaderAdapter */
    /* renamed from: er$O00000Oo */
    public interface O00000Oo {
        void O000000o(View view, int i);

        void O00000Oo(View view, int i);
    }

    public er(Context context) {
        this.O00000o = context;
    }

    public Context O000000o() {
        return this.O00000o;
    }

    public abstract V O000000o(ViewGroup viewGroup, int i);

    public O000000o O000000o(int i, V v) {
        O000000o o000000o = new O000000o(i, v);
        O000000o(o000000o);
        return o000000o;
    }

    public void O000000o(int i) {
        int i2;
        ArrayList<O000000o> arrayList = new ArrayList();
        for (i2 = 0; i2 < this.O00000oO.size(); i2++) {
            O000000o o000000o = (O000000o) this.O00000oO.get(i2);
            if (o000000o.O000000o == i) {
                arrayList.add(o000000o);
            }
        }
        for (O000000o o000000o2 : arrayList) {
            i2 = this.O00000oO.indexOf(o000000o2);
            this.O00000oO.remove(o000000o2);
            notifyItemRemoved(i2);
        }
    }

    public abstract void O000000o(V v, int i);

    public void O000000o(View view) {
        this.O00000o0 = view;
        view.setVisibility(O00000Oo() == 0 ? 0 : 8);
    }

    public void O000000o(O000000o o000000o) {
        this.O00000oO.add(o000000o);
        notifyItemInserted(this.O00000oO.size());
    }

    public abstract void O000000o(O00000Oo o00000Oo);

    public abstract void O000000o(List<Rank> list);

    public abstract int O00000Oo();

    public O000000o O00000Oo(int i, V v) {
        O000000o o000000o = new O000000o(i, v);
        O00000o0(o000000o);
        return o000000o;
    }

    public void O00000Oo(int i) {
        int i2;
        ArrayList<O000000o> arrayList = new ArrayList();
        for (i2 = 0; i2 < this.O00000oo.size(); i2++) {
            O000000o o000000o = (O000000o) this.O00000oo.get(i2);
            if (o000000o.O000000o == i) {
                arrayList.add(o000000o);
            }
        }
        for (O000000o o000000o2 : arrayList) {
            i2 = this.O00000oo.indexOf(o000000o2);
            this.O00000oo.remove(o000000o2);
            notifyItemRemoved((this.O00000oO.size() + O00000Oo()) + i2);
        }
    }

    public void O00000Oo(O000000o o000000o) {
        int indexOf = this.O00000oO.indexOf(o000000o);
        if (indexOf >= 0) {
            this.O00000oO.remove(indexOf);
            notifyItemRemoved(indexOf);
        }
    }

    public O000000o O00000o(int i) {
        return (this.O00000oO == null || this.O00000oO.size() <= i) ? null : (O000000o) this.O00000oO.get(i);
    }

    public void O00000o(O000000o o000000o) {
        int indexOf = this.O00000oo.indexOf(o000000o);
        if (indexOf >= 0) {
            this.O00000oo.remove(indexOf);
            notifyItemRemoved((this.O00000oO.size() + O00000Oo()) + indexOf);
        }
    }

    public int O00000o0(int i) {
        return super.getItemViewType(i);
    }

    public void O00000o0(O000000o o000000o) {
        this.O00000oo.add(o000000o);
        notifyItemInserted(getItemCount());
    }

    public final int getItemCount() {
        int size = (this.O00000oO.size() + O00000Oo()) + this.O00000oo.size();
        if (this.O00000o0 != null) {
            this.O00000o0.setVisibility(O00000Oo() == 0 ? 0 : 8);
        }
        return size;
    }

    public final int getItemViewType(int i) {
        return i < this.O00000oO.size() ? 0 : 1;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (i < this.O00000oO.size() || i - this.O00000oO.size() >= O00000Oo()) {
            try {
                LayoutParams layoutParams = (LayoutParams) viewHolder.itemView.getLayoutParams();
                layoutParams.setFullSpan(true);
                viewHolder.itemView.setLayoutParams(layoutParams);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        O000000o(viewHolder, i - this.O00000oO.size());
    }

    public final V onCreateViewHolder(ViewGroup viewGroup, int i) {
        for (O000000o o000000o : this.O00000oO) {
            if (i == o000000o.O000000o) {
                return o000000o.O00000Oo;
            }
        }
        for (O000000o o000000o2 : this.O00000oo) {
            if (i == o000000o2.O000000o) {
                return o000000o2.O00000Oo;
            }
        }
        return O000000o(viewGroup, i);
    }
}
