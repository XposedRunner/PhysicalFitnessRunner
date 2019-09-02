package defpackage;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.DailySignBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: SignDialogAdapter */
/* renamed from: ex */
public class ex extends Adapter<O000000o> {
    private List<DailySignBean> O000000o = new ArrayList();

    /* compiled from: SignDialogAdapter */
    /* renamed from: ex$O000000o */
    class O000000o extends ViewHolder {
        private TextView O00000Oo;
        private TextView O00000o0;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.tvDays);
            this.O00000o0 = (TextView) view.findViewById(R.id.tvScore);
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sign_dialog_list_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        DailySignBean dailySignBean = (DailySignBean) this.O000000o.get(i);
        if (dailySignBean != null) {
            Context context;
            o000000o.O00000Oo.setText(String.format(Locale.getDefault(), "第%d天", new Object[]{Integer.valueOf(dailySignBean.getDay())}));
            TextView O000000o = o000000o.O00000Oo;
            boolean isSelected = dailySignBean.isSelected();
            int i2 = R.color.white;
            O000000o.setTextColor(isSelected ? ContextCompat.getColor(o000000o.itemView.getContext(), R.color.white) : ContextCompat.getColor(o000000o.itemView.getContext(), R.color.text_color_label));
            o000000o.O00000o0.setText(String.format(Locale.getDefault(), "+%d", new Object[]{Integer.valueOf(dailySignBean.getScore())}));
            O000000o = o000000o.O00000o0;
            if (dailySignBean.isSelected()) {
                context = o000000o.itemView.getContext();
            } else {
                context = o000000o.itemView.getContext();
                i2 = R.color.sport_green;
            }
            O000000o.setTextColor(ContextCompat.getColor(context, i2));
            o000000o.itemView.setBackgroundResource(dailySignBean.isSelected() ? R.drawable.sign_dialog_list_select_bg : R.drawable.sign_dialog_list_unselect_bg);
        }
    }

    public void O000000o(List<DailySignBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
