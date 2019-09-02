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
import com.zjwh.android_wh_physicalfitness.entity.SchoolsAndSemeBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SchoolListAdapter */
/* renamed from: et */
public class et extends Adapter<O000000o> {
    private List<SchoolsAndSemeBean> O000000o = new ArrayList();
    private O00000Oo O00000Oo;
    private int O00000o0;

    /* compiled from: SchoolListAdapter */
    /* renamed from: et$O00000Oo */
    public interface O00000Oo {
        void O000000o(SchoolsAndSemeBean schoolsAndSemeBean, int i);
    }

    /* compiled from: SchoolListAdapter */
    /* renamed from: et$O000000o */
    class O000000o extends ViewHolder {
        private TextView O00000Oo;
        private ImageView O00000o0;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv);
            this.O00000o0 = (ImageView) view.findViewById(R.id.iv);
        }
    }

    public et(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    private void O000000o(int i) {
        if (this.O000000o != null && this.O000000o.size() > this.O00000o0 && this.O000000o.size() > i) {
            ((SchoolsAndSemeBean) this.O000000o.get(this.O00000o0)).setSelected(false);
            notifyItemChanged(this.O00000o0);
            ((SchoolsAndSemeBean) this.O000000o.get(i)).setSelected(true);
            notifyItemChanged(i);
            this.O00000o0 = i;
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.school_list_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O000000o o000000o, int i) {
        final SchoolsAndSemeBean schoolsAndSemeBean = (SchoolsAndSemeBean) this.O000000o.get(i);
        if (schoolsAndSemeBean != null) {
            o000000o.O00000Oo.setText(schoolsAndSemeBean.getName());
            o000000o.O00000o0.setImageResource(schoolsAndSemeBean.isSelected() ? R.drawable.schools_checked : R.drawable.schools_unchecked);
            o000000o.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (et.this.O00000o0 != o000000o.getAdapterPosition() - 1) {
                        et.this.O000000o(o000000o.getAdapterPosition() - 1);
                        if (et.this.O00000Oo != null) {
                            et.this.O00000Oo.O000000o(schoolsAndSemeBean, o000000o.getAdapterPosition() - 1);
                        }
                    }
                }
            });
        }
    }

    public void O000000o(List<SchoolsAndSemeBean> list) {
        this.O00000o0 = 0;
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
