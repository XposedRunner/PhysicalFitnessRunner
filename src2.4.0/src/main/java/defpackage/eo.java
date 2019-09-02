package defpackage;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.PrizeListBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O00000o0;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PrizeListAdapter */
/* renamed from: eo */
public class eo extends Adapter<O000000o> {
    private List<PrizeListBean> O000000o = new ArrayList();

    /* compiled from: PrizeListAdapter */
    /* renamed from: eo$O000000o */
    static class O000000o extends ViewHolder {
        LinearLayout O000000o;
        ImageView O00000Oo;
        TextView O00000o;
        TextView O00000o0;
        TextView O00000oO;
        TextView O00000oo;
        TextView O0000O0o;

        O000000o(View view) {
            super(view);
            this.O00000Oo = (ImageView) view.findViewById(R.id.iv_icon);
            this.O00000o0 = (TextView) view.findViewById(R.id.tv_name);
            this.O00000o = (TextView) view.findViewById(R.id.tv_date);
            this.O00000oO = (TextView) view.findViewById(R.id.tv_code);
            this.O00000oo = (TextView) view.findViewById(R.id.tv_copy);
            this.O000000o = (LinearLayout) view.findViewById(R.id.llExplain);
            this.O0000O0o = (TextView) view.findViewById(R.id.tvExplain);
        }

        private void O000000o(final PrizeListBean prizeListBean) {
            if (prizeListBean != null) {
                CharSequence redeemText;
                if (TextUtils.isEmpty(prizeListBean.getLogoUrl())) {
                    this.O00000Oo.setImageResource(R.color.window_background);
                } else {
                    O00Oo.O00000o0(this.itemView.getContext()).O000000o(prizeListBean.getLogoUrl()).O000000o(this.O00000Oo);
                }
                this.O00000o0.setText(prizeListBean.getPrizeName());
                TextView textView = this.O00000o;
                int i = 8;
                int i2 = (prizeListBean.getPrizeValidStartTime() <= 0 || prizeListBean.getPrizeValidEndTime() <= 0) ? 8 : 0;
                textView.setVisibility(i2);
                this.O00000o.setText(String.format("有效日期：%s ~ %s", new Object[]{O000O0o0.O000000o(O000O0o0.O0000OoO, prizeListBean.getPrizeValidStartTime()), O000O0o0.O000000o(O000O0o0.O0000OoO, prizeListBean.getPrizeValidEndTime())}));
                if (prizeListBean.isRedeem()) {
                    redeemText = prizeListBean.getRedeemText();
                    this.O00000oO.setVisibility(0);
                    this.O00000oO.setText(String.format("兑换码：%s", new Object[]{prizeListBean.getDefineText2()}));
                } else {
                    redeemText = prizeListBean.getDefineText2();
                    this.O00000oO.setVisibility(8);
                }
                this.O000000o.setVisibility(TextUtils.isEmpty(redeemText) ? 8 : 0);
                TextView textView2 = this.O0000O0o;
                if (TextUtils.isEmpty(redeemText)) {
                    redeemText = "";
                }
                textView2.setText(redeemText);
                textView = this.O00000oo;
                if (prizeListBean.isRedeem()) {
                    i = 0;
                }
                textView.setVisibility(i);
                this.O00000oo.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        O00Oo00.O000000o("复制成功");
                        O00Oo0.O000000o(O000000o.this.itemView.getContext(), null, prizeListBean.getDefineText2());
                    }
                });
            }
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_gift_list_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O000000o o000000o, int i) {
        final PrizeListBean prizeListBean = (PrizeListBean) this.O000000o.get(i);
        o000000o.O000000o(prizeListBean);
        o000000o.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(gf.O000o00O);
                stringBuilder.append(prizeListBean.getPrizeName());
                O00OO0O.O000000o(new PvDataInfoV29(gf.O000OOo, stringBuilder.toString()));
                Context context = view.getContext();
                String str = O000000o.O00000o;
                stringBuilder = new StringBuilder();
                stringBuilder.append(gf.O000o00O);
                stringBuilder.append(prizeListBean.getPrizeName());
                O00Oo00o.O000000o(context, str, stringBuilder.toString());
                if (!TextUtils.isEmpty(prizeListBean.getDefinedUrl())) {
                    String definedUrl = prizeListBean.getDefinedUrl();
                    try {
                        if (!TextUtils.isEmpty(definedUrl)) {
                            definedUrl = O00000o0.O000000o(prizeListBean.getDefinedUrl());
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    O000o0.O000000o((Activity) o000000o.itemView.getContext(), definedUrl);
                }
            }
        });
    }

    public void O000000o(List<PrizeListBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public void O00000Oo(List<PrizeListBean> list) {
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
