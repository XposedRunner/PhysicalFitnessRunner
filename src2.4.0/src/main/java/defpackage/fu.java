package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.entity.DueRun;
import java.util.List;

/* compiled from: WaitRunAdapter */
/* renamed from: fu */
public class fu extends Adapter<O000000o> {
    private List<DueRun> O000000o;
    private O00000Oo O00000Oo;
    private boolean O00000o0;

    /* compiled from: WaitRunAdapter */
    /* renamed from: fu$O00000Oo */
    public interface O00000Oo {
        void O000000o(DueRun dueRun);
    }

    /* compiled from: WaitRunAdapter */
    /* renamed from: fu$1 */
    class 1 implements OnClickListener {
        final /* synthetic */ DueRun O000000o;
        final /* synthetic */ fu O00000Oo;

        1(fu fuVar, DueRun dueRun) {
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: WaitRunAdapter */
    /* renamed from: fu$O000000o */
    class O000000o extends ViewHolder {
        TextView O000000o;
        TextView O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        ImageView O00000oO;
        LinearLayout O00000oo;
        LayoutParams O0000O0o;
        final /* synthetic */ fu O0000OOo;

        O000000o(fu fuVar, View view) {
        }

        private LayoutParams O000000o() {
            return null;
        }

        private void O000000o(DueRun dueRun, boolean z) {
        }

        static /* synthetic */ void O000000o(O000000o o000000o, DueRun dueRun, boolean z) {
        }
    }

    public fu(List<DueRun> list, O00000Oo o00000Oo, boolean z) {
    }

    public O000000o O000000o(ViewGroup viewGroup, int i) {
        return null;
    }

    public void O000000o(O000000o o000000o, int i) {
    }

    public void O000000o(O00000Oo o00000Oo) {
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
