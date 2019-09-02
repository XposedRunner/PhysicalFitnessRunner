package defpackage;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.DiscoverModuleBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o;
import java.util.ArrayList;
import java.util.List;
import org.xutils.common.util.DensityUtil;

/* compiled from: DiscoverModuleAdapter */
/* renamed from: ea */
public class ea extends Adapter<O000000o> {
    private static final int O000000o = 10004;
    private static final int O00000Oo = 10005;
    private static final int O00000o = 20002;
    private static final int O00000o0 = 20001;
    private List<DiscoverModuleBean> O00000oO = new ArrayList();

    /* compiled from: DiscoverModuleAdapter */
    /* renamed from: ea$O000000o */
    class O000000o extends ViewHolder {
        private TextView O00000Oo;
        private ImageView O00000o0;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv_name);
            this.O00000o0 = (ImageView) view.findViewById(R.id.iv_icon);
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discover_module_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O000000o o000000o, int i) {
        final DiscoverModuleBean discoverModuleBean = (DiscoverModuleBean) this.O00000oO.get(i);
        if (discoverModuleBean != null) {
            o000000o.itemView.setLayoutParams(new LayoutParams(DensityUtil.getScreenWidth() / this.O00000oO.size(), -1));
            o000000o.O00000Oo.setText(TextUtils.isEmpty(discoverModuleBean.getModuleName()) ? "" : discoverModuleBean.getModuleName());
            if (TextUtils.isEmpty(discoverModuleBean.getIconUrl())) {
                switch (discoverModuleBean.getModuleId()) {
                    case 10004:
                        o000000o.O00000o0.setImageResource(R.drawable.find_item_rank);
                        break;
                    case 10005:
                        o000000o.O00000o0.setImageResource(R.drawable.find_item_music);
                        break;
                    case 20001:
                        o000000o.O00000o0.setImageResource(R.drawable.find_item_order);
                        break;
                    case O00000o /*20002*/:
                        o000000o.O00000o0.setImageResource(R.drawable.find_item_integral);
                        break;
                    default:
                        o000000o.O00000o0.setImageResource(R.drawable.find_item_default);
                        break;
                }
            }
            O00Oo.O00000o0(o000000o.O00000o0.getContext()).O000000o(discoverModuleBean.getIconUrl()).O0000O0o((int) R.drawable.find_item_default).O00000oO(R.drawable.find_item_default).O000000o(o000000o.O00000o0);
            o000000o.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!(O00OOo0.O000000o() || TextUtils.isEmpty(discoverModuleBean.getJumpUrl()))) {
                        if (discoverModuleBean.getModuleId() == ea.O00000o) {
                            O00Oo00o.O000000o(view.getContext(), O000000o.O0000OoO, "click1");
                        }
                        if (discoverModuleBean.getModuleId() == 10005) {
                            O00OO0O.O000000o(new PvDataInfoV29(gf.O000O0oO, "discovery_music"));
                        }
                        O000o0.O000000o((Activity) o000000o.itemView.getContext(), discoverModuleBean.getJumpUrl());
                    }
                }
            });
        }
    }

    public void O000000o(List<DiscoverModuleBean> list) {
        this.O00000oO.clear();
        this.O00000oO.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O00000oO == null ? 0 : this.O00000oO.size();
    }
}
