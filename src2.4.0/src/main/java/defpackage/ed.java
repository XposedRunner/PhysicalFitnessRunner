package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.DueRun;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.List;

/* compiled from: DueRunCompleteAdapter */
/* renamed from: ed */
public class ed extends Adapter<O000000o> {
    List<DueRun> O000000o;

    /* compiled from: DueRunCompleteAdapter */
    /* renamed from: ed$O000000o */
    class O000000o extends ViewHolder {
        ImageView O000000o;

        public O000000o(View view) {
            super(view);
            this.O000000o = (ImageView) view.findViewById(R.id.iv_icon);
        }

        private void O000000o(DueRun dueRun) {
            if (dueRun != null) {
                O00Oo0.O000000o(this.itemView.getContext(), dueRun.getIcon(), this.O000000o, dueRun.getSex());
                this.O000000o.setBackgroundResource(dueRun.getTotalNum() == 0 ? R.drawable.shape_due_run_complete_red : R.drawable.shape_due_run_complete_green);
            }
        }
    }

    public ed(List<DueRun> list) {
        this.O000000o = list;
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_due_run_complete_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        o000000o.O000000o((DueRun) this.O000000o.get(i));
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
