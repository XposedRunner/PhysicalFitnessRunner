package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.rank.RankCheatBean;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: RankReportAdapter */
/* renamed from: ep */
public class ep extends Adapter<O000000o> {
    private List<RankCheatBean> O000000o = new ArrayList();
    private RankCheatBean O00000Oo;

    /* compiled from: RankReportAdapter */
    /* renamed from: ep$O000000o */
    class O000000o extends ViewHolder {
        private ImageView O00000Oo;
        private TextView O00000o;
        private TextView O00000o0;
        private TextView O00000oO;
        private TextView O00000oo;

        public O000000o(View view) {
            super(view);
            this.O00000oo = (TextView) view.findViewById(R.id.tvNumber);
            this.O00000Oo = (ImageView) view.findViewById(R.id.imageView);
            this.O00000o0 = (TextView) view.findViewById(R.id.tvTitle);
            this.O00000o = (TextView) view.findViewById(R.id.tvSubTitle);
            this.O00000oO = (TextView) view.findViewById(R.id.tvTagView);
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rank_list_item, viewGroup, false));
    }

    public void O000000o(RankCheatBean rankCheatBean) {
        this.O00000Oo = rankCheatBean;
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        RankCheatBean rankCheatBean = this.O00000Oo == null ? (RankCheatBean) this.O000000o.get(i) : i == 0 ? this.O00000Oo : (RankCheatBean) this.O000000o.get(i - 1);
        o000000o.O00000o0.setText(rankCheatBean.getName());
        o000000o.O00000oO.setText(String.format(Locale.getDefault(), "作弊%d次", new Object[]{Integer.valueOf(rankCheatBean.getCount())}));
        o000000o.O00000o.setText(rankCheatBean.getCampusId());
        o000000o.O00000oo.setText(String.valueOf(i + 1));
        o000000o.O00000oo.setVisibility(0);
        O00Oo0.O000000o(o000000o.itemView.getContext(), rankCheatBean.getIconUrl(), o000000o.O00000Oo, rankCheatBean.getSex());
    }

    public void O000000o(List<RankCheatBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public void O00000Oo(List<RankCheatBean> list) {
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        int i = 1;
        if (this.O000000o == null || this.O000000o.size() == 0) {
            if (this.O00000Oo == null) {
                i = 0;
            }
            return i;
        }
        return this.O00000Oo == null ? this.O000000o.size() : this.O000000o.size() + 1;
    }
}
