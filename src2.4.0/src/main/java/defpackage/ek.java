package defpackage;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.WebViewActivity;
import com.zjwh.android_wh_physicalfitness.entity.MyOrderInfoBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MyOrderInfoAdapter */
/* renamed from: ek */
public class ek extends Adapter<O000000o> {
    private List<MyOrderInfoBean> O000000o = new ArrayList();

    /* compiled from: MyOrderInfoAdapter */
    /* renamed from: ek$O000000o */
    class O000000o extends ViewHolder {
        private TextView O00000Oo;
        private TextView O00000o;
        private TextView O00000o0;
        private TextView O00000oO;
        private TextView O00000oo;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv_order_number);
            this.O00000o0 = (TextView) view.findViewById(R.id.tv_order_status);
            this.O00000o = (TextView) view.findViewById(R.id.tv_club_name);
            this.O00000oO = (TextView) view.findViewById(R.id.tv_sport_address);
            this.O00000oo = (TextView) view.findViewById(R.id.tv_price);
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_order_list_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O000000o o000000o, int i) {
        MyOrderInfoBean myOrderInfoBean = (MyOrderInfoBean) this.O000000o.get(i);
        if (myOrderInfoBean != null) {
            o000000o.O00000Oo.setText(String.format("订单编号 %s", new Object[]{myOrderInfoBean.getOrderCode()}));
            TextView O00000Oo = o000000o.O00000o0;
            CharSequence charSequence = myOrderInfoBean.getOrderStatus() == 1 ? "未使用" : myOrderInfoBean.getOrderStatus() == 2 ? "待支付" : "已过期";
            O00000Oo.setText(charSequence);
            O00000Oo = o000000o.O00000o0;
            int color = myOrderInfoBean.getOrderStatus() == 1 ? ContextCompat.getColor(o000000o.itemView.getContext(), R.color.text_color_major) : myOrderInfoBean.getOrderStatus() == 2 ? ContextCompat.getColor(o000000o.itemView.getContext(), R.color.red) : ContextCompat.getColor(o000000o.itemView.getContext(), R.color.text_color_hint);
            O00000Oo.setTextColor(color);
            o000000o.O00000o.setText(myOrderInfoBean.getFieldName());
            o000000o.O00000oO.setText(myOrderInfoBean.getVenueName());
            o000000o.O00000oo.setText(myOrderInfoBean.getReceivableFee());
            o000000o.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    WebViewActivity.O000000o((Activity) o000000o.itemView.getContext(), "http://www.baidu.com");
                }
            });
        }
    }

    public void O000000o(List<MyOrderInfoBean> list) {
        if (list != null) {
            this.O000000o.clear();
            this.O000000o.addAll(list);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
