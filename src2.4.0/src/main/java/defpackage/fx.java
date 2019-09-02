package defpackage;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: MultiItemTypeAdapter */
/* renamed from: fx */
public class fx<T> extends Adapter<ga> {
    protected Context O0000O0o;
    protected List<T> O0000OOo;
    protected O000000o O0000Oo;
    protected fz O0000Oo0;

    /* compiled from: MultiItemTypeAdapter */
    /* renamed from: fx$O000000o */
    public interface O000000o {
        void O000000o(View view, ViewHolder viewHolder, int i);

        boolean O00000Oo(View view, ViewHolder viewHolder, int i);
    }

    /* compiled from: MultiItemTypeAdapter */
    /* renamed from: fx$1 */
    class 1 implements OnClickListener {
        final /* synthetic */ ga O000000o;
        final /* synthetic */ fx O00000Oo;

        1(fx fxVar, ga gaVar) {
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: MultiItemTypeAdapter */
    /* renamed from: fx$2 */
    class 2 implements OnLongClickListener {
        final /* synthetic */ ga O000000o;
        final /* synthetic */ fx O00000Oo;

        2(fx fxVar, ga gaVar) {
        }

        public boolean onLongClick(View view) {
            return false;
        }
    }

    public fx(Context context, List<T> list) {
    }

    public fx O000000o(int i, fy<T> fyVar) {
        return null;
    }

    public fx O000000o(fy<T> fyVar) {
        return null;
    }

    public ga O000000o(ViewGroup viewGroup, int i) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(ViewGroup viewGroup, ga gaVar, int i) {
    }

    public void O000000o(O000000o o000000o) {
    }

    public void O000000o(ga gaVar, int i) {
    }

    public void O000000o(ga gaVar, View view) {
    }

    public void O000000o(ga gaVar, T t) {
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(int i) {
        return true;
    }

    public List<T> O00000Oo() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000o0() {
        return false;
    }

    public int getItemCount() {
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
