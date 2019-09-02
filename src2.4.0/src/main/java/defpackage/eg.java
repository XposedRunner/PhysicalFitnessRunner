package defpackage;

import android.content.Context;
import android.support.v4.content.ContextCompat;
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
import com.zjwh.android_wh_physicalfitness.entity.HistoryRank;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HistoryRankAdapter */
/* renamed from: eg */
public class eg extends Adapter<O000000o> {
    private Context O000000o;
    private List<HistoryRank> O00000Oo = new ArrayList();
    private O00000Oo O00000o0;

    /* compiled from: HistoryRankAdapter */
    /* renamed from: eg$O00000Oo */
    public interface O00000Oo {
        void O000000o(HistoryRank historyRank);
    }

    /* compiled from: HistoryRankAdapter */
    /* renamed from: eg$O000000o */
    public static class O000000o extends ViewHolder {
        TextView O000000o;
        TextView O00000Oo;
        ImageView O00000o;
        TextView O00000o0;

        public O000000o(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.tv_date);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv_order);
            this.O00000o0 = (TextView) view.findViewById(R.id.tv_tag);
            this.O00000o = (ImageView) view.findViewById(R.id.iv_icon);
        }
    }

    public eg(Context context) {
        this.O000000o = context;
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(this.O000000o).inflate(R.layout.layout_history_rank_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        final HistoryRank historyRank = (HistoryRank) this.O00000Oo.get(i);
        o000000o.O000000o.setText(O000O0o0.O000000o(O000O0o0.O0000Oo, O000O0o0.O000000o, historyRank.getHisRankId()));
        TextView textView = o000000o.O00000o0;
        String string = this.O000000o.getString(R.string.rank_first2);
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(historyRank.getChampName()) ? "" : historyRank.getChampName();
        textView.setText(String.format(string, objArr));
        o000000o.O00000Oo.setTextColor(ContextCompat.getColor(this.O000000o, R.color.sport_green));
        int curUserOrder = historyRank.getCurUserOrder();
        o000000o.O00000Oo.setText(String.format(this.O000000o.getString(R.string.rank), new Object[]{Integer.valueOf(curUserOrder)}));
        if (curUserOrder == 0) {
            o000000o.O00000Oo.setText(R.string.overstep_rank2);
        } else if (curUserOrder <= 3) {
            if (curUserOrder == 1) {
                o000000o.O00000o0.setText(String.format(this.O000000o.getString(R.string.rank_first2), new Object[]{this.O000000o.getString(R.string.me)}));
            }
            o000000o.O00000Oo.setTextColor(ContextCompat.getColor(this.O000000o, R.color.red));
        }
        O00Oo0.O000000o(o000000o.itemView.getContext(), historyRank.getChampIcon(), o000000o.O00000o, 1);
        o000000o.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (eg.this.O00000o0 != null) {
                    eg.this.O00000o0.O000000o(historyRank);
                }
            }
        });
    }

    public void O000000o(O00000Oo o00000Oo) {
        this.O00000o0 = o00000Oo;
    }

    public void O000000o(List<HistoryRank> list) {
        this.O00000Oo.clear();
        this.O00000Oo.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O00000Oo.size();
    }
}
