package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.database.NearBySchoolBean;
import java.util.List;

/* compiled from: ChangeCampusAdapter */
/* renamed from: du */
public class du extends Adapter {
    private List<NearBySchoolBean> O000000o;
    private O00000o0 O00000Oo;

    /* compiled from: ChangeCampusAdapter */
    /* renamed from: du$O00000o0 */
    public interface O00000o0 {
        void O000000o(NearBySchoolBean nearBySchoolBean);
    }

    /* compiled from: ChangeCampusAdapter */
    /* renamed from: du$O000000o */
    private static class O000000o extends ViewHolder {
        private TextView O000000o;

        O000000o(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    /* compiled from: ChangeCampusAdapter */
    /* renamed from: du$O00000Oo */
    private static class O00000Oo extends ViewHolder {
        private TextView O000000o;
        private View O00000Oo;

        O00000Oo(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.tv_current_school);
            this.O00000Oo = view.findViewById(R.id.current_line);
        }
    }

    public du(List<NearBySchoolBean> list, O00000o0 o00000o0) {
        this.O00000Oo = o00000o0;
        this.O000000o = list;
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }

    public int getItemViewType(int i) {
        return ((NearBySchoolBean) this.O000000o.get(i)).getViewType();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final NearBySchoolBean nearBySchoolBean = (NearBySchoolBean) this.O000000o.get(i);
        if (viewHolder instanceof O000000o) {
            ((O000000o) viewHolder).O000000o.setText(nearBySchoolBean.getCampusName());
        } else if (viewHolder instanceof O00000Oo) {
            int i2 = 1;
            int i3 = 0;
            if (((NearBySchoolBean) this.O000000o.get(i - 1)).getViewType() != 2) {
                i2 = 0;
            }
            O00000Oo o00000Oo = (O00000Oo) viewHolder;
            o00000Oo.O000000o.setText(nearBySchoolBean.getCampusName());
            View O00000Oo = o00000Oo.O00000Oo;
            if (i2 == 0) {
                i3 = 8;
            }
            O00000Oo.setVisibility(i3);
            viewHolder.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (du.this.O00000Oo != null) {
                        du.this.O00000Oo.O000000o(nearBySchoolBean);
                    }
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i != 2 ? new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.change_school_title_layout, viewGroup, false)) : new O00000Oo(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_campus_item, viewGroup, false));
    }
}
