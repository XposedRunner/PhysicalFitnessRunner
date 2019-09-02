package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.ActivityTipBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ActivityTipAdapter */
/* renamed from: dn */
public class dn extends Adapter<O000000o> {
    private List<ActivityTipBean> O000000o = new ArrayList();
    private O00000Oo O00000Oo;

    /* compiled from: ActivityTipAdapter */
    /* renamed from: dn$O00000Oo */
    public interface O00000Oo {
        void O000000o(ActivityTipBean activityTipBean);
    }

    /* compiled from: ActivityTipAdapter */
    /* renamed from: dn$O000000o */
    class O000000o extends ViewHolder {
        ImageView O000000o;

        O000000o(View view) {
            super(view);
            this.O000000o = (ImageView) view.findViewById(R.id.iv);
        }
    }

    public dn(O00000Oo o00000Oo) {
        this.O00000Oo = o00000Oo;
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_tip_item, viewGroup, false));
    }

    public void O000000o() {
        if (this.O00000Oo != null) {
            this.O00000Oo = null;
        }
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        final ActivityTipBean activityTipBean = (ActivityTipBean) this.O000000o.get(i);
        O00Oo.O00000o0(o000000o.itemView.getContext()).O000000o(activityTipBean.getActivityImgUrl()).O00000oO(R.color.window_background).O0000O0o((int) R.color.window_background).O000000o(new la(o000000o.itemView.getContext())).O000000o(o000000o.O000000o);
        o000000o.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (dn.this.O00000Oo != null) {
                    dn.this.O00000Oo.O000000o(activityTipBean);
                }
            }
        });
    }

    public void O000000o(List<ActivityTipBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
