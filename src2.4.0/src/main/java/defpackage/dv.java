package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.MyCampusBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChangeMyCampusAdapter */
/* renamed from: dv */
public class dv extends Adapter<O000000o> {
    private List<MyCampusBean> O000000o = new ArrayList();
    private O00000Oo O00000Oo;

    /* compiled from: ChangeMyCampusAdapter */
    /* renamed from: dv$O00000Oo */
    public interface O00000Oo {
        void O000000o(MyCampusBean myCampusBean);
    }

    /* compiled from: ChangeMyCampusAdapter */
    /* renamed from: dv$O000000o */
    class O000000o extends ViewHolder {
        private TextView O00000Oo;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.tvCampus);
        }
    }

    public dv(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.change_my_campus_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        final MyCampusBean myCampusBean = (MyCampusBean) this.O000000o.get(i);
        if (myCampusBean != null) {
            o000000o.O00000Oo.setText(myCampusBean.getName());
            o000000o.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (dv.this.O00000Oo != null) {
                        dv.this.O00000Oo.O000000o(myCampusBean);
                    }
                }
            });
        }
    }

    public void O000000o(List<MyCampusBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
