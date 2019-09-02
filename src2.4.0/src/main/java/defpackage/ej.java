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
import com.zjwh.android_wh_physicalfitness.entity.MineFragmentListBean;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MineFragmentAdapter */
/* renamed from: ej */
public class ej extends Adapter<O000000o> {
    private List<MineFragmentListBean> O000000o = new ArrayList();
    private boolean O00000Oo = false;

    /* compiled from: MineFragmentAdapter */
    /* renamed from: ej$O000000o */
    class O000000o extends ViewHolder {
        private ImageView O00000Oo;
        private ImageView O00000o;
        private ImageView O00000o0;
        private TextView O00000oO;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (ImageView) view.findViewById(R.id.ivIcon);
            this.O00000oO = (TextView) view.findViewById(R.id.tvName);
            this.O00000o0 = (ImageView) view.findViewById(R.id.ivDot);
            this.O00000o = (ImageView) view.findViewById(R.id.ivCourseNew);
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mine_fragment_list_item, viewGroup, false));
    }

    public void O000000o() {
        for (int i = 0; i < this.O000000o.size(); i++) {
            MineFragmentListBean mineFragmentListBean = (MineFragmentListBean) this.O000000o.get(i);
            if (mineFragmentListBean.getModuleId() == 30006) {
                mineFragmentListBean.setNewMessage(true);
                notifyItemChanged(i);
                return;
            }
        }
    }

    public void O000000o(MineFragmentListBean mineFragmentListBean) {
        this.O000000o.add(mineFragmentListBean);
        notifyItemInserted(this.O000000o.size() - 1);
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        final MineFragmentListBean mineFragmentListBean = (MineFragmentListBean) this.O000000o.get(i);
        if (mineFragmentListBean != null) {
            ImageView O000000o = o000000o.O00000o0;
            int i2 = 8;
            int i3 = (mineFragmentListBean.getModuleId() == MineFragmentListBean.MINE_RUN_PRIZE && this.O00000Oo) ? 0 : 8;
            O000000o.setVisibility(i3);
            o000000o.O00000oO.setText(mineFragmentListBean.getModuleName());
            O000000o = o000000o.O00000o;
            if (mineFragmentListBean.getModuleId() == 30006 && !mineFragmentListBean.isNewMessage()) {
                i2 = 0;
            }
            O000000o.setVisibility(i2);
            if (TextUtils.isEmpty(mineFragmentListBean.getIconUrl())) {
                switch (mineFragmentListBean.getModuleId()) {
                    case MineFragmentListBean.MINE_RUN_PRIZE /*30001*/:
                        o000000o.O00000Oo.setImageResource(R.drawable.run_reward_icon);
                        break;
                    case 30002:
                        o000000o.O00000Oo.setImageResource(R.drawable.run_history_icon);
                        break;
                    case MineFragmentListBean.MINE_RANK_HISTORY /*30003*/:
                        o000000o.O00000Oo.setImageResource(R.drawable.history_rank_icon);
                        break;
                    case 30004:
                        o000000o.O00000Oo.setImageResource(R.drawable.attendance_icon);
                        break;
                    case 30005:
                        o000000o.O00000Oo.setImageResource(R.drawable.my_grade_icon);
                        break;
                    case 30006:
                        o000000o.O00000Oo.setImageResource(R.drawable.my_course_icon);
                        break;
                    case 30007:
                        o000000o.O00000Oo.setImageResource(R.drawable.my_student_icon);
                        break;
                    case MineFragmentListBean.MINE_NOTICE /*30008*/:
                        o000000o.O00000Oo.setImageResource(R.drawable.mine_module_notice);
                        break;
                    case MineFragmentListBean.MINE_ROLL_CALL /*30009*/:
                        o000000o.O00000Oo.setImageResource(R.drawable.mine_module_roll_call);
                        break;
                    case 30010:
                        o000000o.O00000Oo.setImageResource(R.drawable.mine_module_sport_campus);
                        break;
                    default:
                        o000000o.O00000Oo.setImageResource(R.color.window_background);
                        break;
                }
            }
            O00Oo.O00000o0(o000000o.itemView.getContext()).O000000o(mineFragmentListBean.getIconUrl()).O00000oO(R.color.window_background).O0000O0o((int) R.color.window_background).O000000o(o000000o.O00000Oo);
            o000000o.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!O00OOo0.O000000o()) {
                        O000o0.O000000o(O00Oo0.O00000oo(view.getContext()), mineFragmentListBean.getJumpUrl());
                        if (mineFragmentListBean.getModuleId() == 30002) {
                            O00Oo00o.O000000o(view.getContext(), O000000o.O0000Oo, "click2");
                        } else if (mineFragmentListBean.getModuleId() == MineFragmentListBean.MINE_RUN_PRIZE) {
                            O00Oo00o.O000000o(view.getContext(), O000000o.O00000o, "clickenter");
                        }
                    }
                }
            });
        }
    }

    public void O000000o(List<MineFragmentListBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public void O000000o(boolean z) {
        this.O00000Oo = z;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
