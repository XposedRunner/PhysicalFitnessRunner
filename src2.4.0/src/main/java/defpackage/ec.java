package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.PrizeListBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DrawWinListAdapter */
/* renamed from: ec */
public class ec extends Adapter<O000000o> {
    private O00000Oo O000000o;
    private List<PrizeListBean> O00000Oo = new ArrayList();

    /* compiled from: DrawWinListAdapter */
    /* renamed from: ec$O00000Oo */
    public interface O00000Oo {
        void O000000o(PrizeListBean prizeListBean);
    }

    /* compiled from: DrawWinListAdapter */
    /* renamed from: ec$O000000o */
    class O000000o extends ViewHolder {
        private TextView O00000Oo;
        private TextView O00000o;
        private TextView O00000o0;
        private ImageView O00000oO;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv_prize_name);
            this.O00000o0 = (TextView) view.findViewById(R.id.tv_prize_valid_time);
            this.O00000o = (TextView) view.findViewById(R.id.tv_prize_detail);
            this.O00000oO = (ImageView) view.findViewById(R.id.iv_prize);
        }
    }

    public ec(O00000Oo o00000Oo) {
        this.O000000o = o00000Oo;
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.draw_win_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        final PrizeListBean prizeListBean = (PrizeListBean) this.O00000Oo.get(i);
        if (prizeListBean != null) {
            o000000o.O00000Oo.setText(TextUtils.isEmpty(prizeListBean.getPrizeName()) ? "" : prizeListBean.getPrizeName());
            TextView O00000Oo = o000000o.O00000o0;
            int i2 = (prizeListBean.getPrizeValidStartTime() <= 0 || prizeListBean.getPrizeValidEndTime() <= 0) ? 8 : 0;
            O00000Oo.setVisibility(i2);
            o000000o.O00000o0.setText(String.format("有效日期：%s ~ %s", new Object[]{O000O0o0.O000000o(O000O0o0.O0000OoO, prizeListBean.getPrizeValidStartTime()), O000O0o0.O000000o(O000O0o0.O0000OoO, prizeListBean.getPrizeValidEndTime())}));
            if (TextUtils.isEmpty(prizeListBean.getLogoUrl())) {
                o000000o.O00000oO.setImageResource(0);
            } else {
                O00Oo.O00000o0(o000000o.itemView.getContext()).O000000o(prizeListBean.getLogoUrl()).O000000o(o000000o.O00000oO);
            }
            o000000o.O00000o.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ec.this.O000000o.O000000o(prizeListBean);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(gf.O000o00O);
                    stringBuilder.append(prizeListBean.getPrizeName());
                    O00OO0O.O000000o(new PvDataInfoV29(gf.O000OOo0, stringBuilder.toString()));
                }
            });
        }
    }

    public void O000000o(List<PrizeListBean> list) {
        this.O00000Oo.clear();
        this.O00000Oo.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O00000Oo == null ? 0 : this.O00000Oo.size();
    }
}
