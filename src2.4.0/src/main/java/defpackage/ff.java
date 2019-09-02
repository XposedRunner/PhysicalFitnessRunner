package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.entity.mine.ClassBean;
import java.util.List;

/* compiled from: ChangeMyClassAdapter */
/* renamed from: ff */
public class ff extends Adapter<O000000o> {
    private List<ClassBean> O000000o;
    private O00000Oo O00000Oo;

    /* compiled from: ChangeMyClassAdapter */
    /* renamed from: ff$O00000Oo */
    public interface O00000Oo {
        void O000000o(ClassBean classBean);
    }

    /* compiled from: ChangeMyClassAdapter */
    /* renamed from: ff$1 */
    class 1 implements OnClickListener {
        final /* synthetic */ ClassBean O000000o;
        final /* synthetic */ ff O00000Oo;

        1(ff ffVar, ClassBean classBean) {
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: ChangeMyClassAdapter */
    /* renamed from: ff$O000000o */
    class O000000o extends ViewHolder {
        final /* synthetic */ ff O000000o;
        private TextView O00000Oo;

        public O000000o(ff ffVar, View view) {
        }
    }

    public ff(O00000Oo o00000Oo) {
    }

    public O000000o O000000o(ViewGroup viewGroup, int i) {
        return null;
    }

    public void O000000o(O000000o o000000o, int i) {
    }

    public void O000000o(List<ClassBean> list) {
    }

    public int getItemCount() {
        return 0;
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }
}
