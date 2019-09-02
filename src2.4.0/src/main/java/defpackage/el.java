package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfoBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MySemesterListAdapter */
/* renamed from: el */
public class el extends Adapter<O000000o> {
    private List<SemesterInfoBean> O000000o = new ArrayList();
    private int O00000Oo;
    private O00000Oo O00000o0;

    /* compiled from: MySemesterListAdapter */
    /* renamed from: el$O00000Oo */
    public interface O00000Oo {
        void O000000o(SemesterInfoBean semesterInfoBean);
    }

    /* compiled from: MySemesterListAdapter */
    /* renamed from: el$O000000o */
    class O000000o extends ViewHolder {
        private TextView O00000Oo;
        private ImageView O00000o0;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv);
            this.O00000o0 = (ImageView) view.findViewById(R.id.iv);
        }
    }

    public el(O00000Oo o00000Oo) {
        this.O00000o0 = o00000Oo;
    }

    private void O000000o(int i) {
        if (this.O000000o != null && this.O000000o.size() > this.O00000Oo && this.O000000o.size() > i) {
            ((SemesterInfoBean) this.O000000o.get(this.O00000Oo)).setSelected(false);
            notifyItemChanged(this.O00000Oo);
            ((SemesterInfoBean) this.O000000o.get(i)).setSelected(true);
            notifyItemChanged(i);
            this.O00000Oo = i;
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.school_list_item, viewGroup, false));
    }

    public void O000000o() {
        this.O000000o.clear();
        notifyDataSetChanged();
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O000000o o000000o, int i) {
        final SemesterInfoBean semesterInfoBean = (SemesterInfoBean) this.O000000o.get(i);
        if (semesterInfoBean != null) {
            o000000o.O00000Oo.setText(semesterInfoBean.getName());
            o000000o.O00000o0.setImageResource(semesterInfoBean.isSelected() ? R.drawable.schools_checked : R.drawable.schools_unchecked);
            o000000o.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    el.this.O000000o(o000000o.getAdapterPosition() - 1);
                    if (el.this.O00000o0 != null) {
                        el.this.O00000o0.O000000o(semesterInfoBean);
                    }
                }
            });
        }
    }

    public void O000000o(List<SemesterInfoBean> list) {
        this.O00000Oo = 0;
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
