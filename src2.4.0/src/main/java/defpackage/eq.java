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
import com.zjwh.android_wh_physicalfitness.entity.DepartmentRank;
import com.zjwh.android_wh_physicalfitness.entity.PersonalRank;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: RankingListAdapter */
/* renamed from: eq */
public class eq extends Adapter<O000000o> {
    private List<PersonalRank> O000000o;
    private O00000Oo O00000Oo;
    private int O00000o;
    private List<DepartmentRank> O00000o0;

    /* compiled from: RankingListAdapter */
    /* renamed from: eq$O00000Oo */
    public interface O00000Oo {
        void O000000o(PersonalRank personalRank);
    }

    /* compiled from: RankingListAdapter */
    /* renamed from: eq$O000000o */
    class O000000o extends ViewHolder {
        private ImageView O00000Oo;
        private TextView O00000o;
        private TextView O00000o0;
        private TextView O00000oO;
        private TextView O00000oo;
        private TextView O0000O0o;
        private ImageView O0000OOo;

        public O000000o(View view) {
            super(view);
            this.O00000o0 = (TextView) view.findViewById(R.id.tvDepartmentIcon);
            this.O0000OOo = (ImageView) view.findViewById(R.id.ivNumber);
            this.O0000O0o = (TextView) view.findViewById(R.id.tvNumber);
            this.O00000Oo = (ImageView) view.findViewById(R.id.imageView);
            this.O00000o = (TextView) view.findViewById(R.id.tvTitle);
            this.O00000oO = (TextView) view.findViewById(R.id.tvSubTitle);
            this.O00000oo = (TextView) view.findViewById(R.id.tvTagView);
        }
    }

    public eq() {
        this.O00000o0 = new ArrayList();
        this.O00000o = 1;
    }

    public eq(O00000Oo o00000Oo) {
        this.O000000o = new ArrayList();
        this.O00000Oo = o00000Oo;
        this.O00000o = 0;
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rank_list_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        int order;
        CharSequence string;
        CharSequence name;
        CharSequence stringBuilder;
        if (this.O00000o == 0) {
            final PersonalRank personalRank = (PersonalRank) this.O000000o.get(i);
            if (personalRank.getUid() != -1) {
                order = personalRank.getOrder();
                string = TextUtils.isEmpty(personalRank.getPsign()) ? o000000o.itemView.getContext().getString(R.string.txt_default_signature) : personalRank.getPsign();
                name = TextUtils.isEmpty(personalRank.getName()) ? "" : personalRank.getName();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(String.valueOf(O00Oo0.O000000o(personalRank.getDis())));
                stringBuilder2.append("公里");
                stringBuilder = stringBuilder2.toString();
                o000000o.O00000o0.setVisibility(8);
                o000000o.O00000Oo.setVisibility(0);
                O00Oo0.O000000o(o000000o.itemView.getContext(), personalRank.getIcon(), o000000o.O00000Oo, personalRank.getGender());
                if (this.O00000Oo != null) {
                    o000000o.itemView.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            eq.this.O00000Oo.O000000o(personalRank);
                        }
                    });
                }
            } else {
                return;
            }
        }
        DepartmentRank departmentRank = (DepartmentRank) this.O00000o0.get(i);
        CharSequence substring = TextUtils.isEmpty(departmentRank.getDepartmentName()) ? "" : departmentRank.getDepartmentName().length() >= 2 ? departmentRank.getDepartmentName().substring(0, 2) : departmentRank.getDepartmentName();
        int order2 = departmentRank.getOrder();
        String format = String.format(o000000o.itemView.getContext().getString(R.string.depart_participate_num), new Object[]{Integer.valueOf(departmentRank.getParticipateCount())});
        String departmentName = TextUtils.isEmpty(departmentRank.getDepartmentName()) ? "" : departmentRank.getDepartmentName();
        stringBuilder = String.format(Locale.getDefault(), "%.2f 公里/人", new Object[]{Double.valueOf(departmentRank.getDis())});
        o000000o.O00000o0.setVisibility(0);
        o000000o.O00000Oo.setVisibility(8);
        o000000o.O00000o0.setText(substring);
        O00Oo0.O000000o(o000000o.O00000o0, substring);
        order = order2;
        string = format;
        name = departmentName;
        o000000o.O00000oO.setText(string);
        o000000o.O0000O0o.setText(String.valueOf(order));
        o000000o.O00000o.setText(name);
        o000000o.O00000oo.setText(stringBuilder);
        switch (order) {
            case 1:
                o000000o.O0000OOo.setImageResource(R.drawable.rank_first_icon);
                o000000o.O0000OOo.setVisibility(0);
                o000000o.O0000O0o.setVisibility(8);
                break;
            case 2:
                o000000o.O0000OOo.setImageResource(R.drawable.rank_second_icon);
                o000000o.O0000OOo.setVisibility(0);
                o000000o.O0000O0o.setVisibility(8);
                break;
            case 3:
                o000000o.O0000OOo.setImageResource(R.drawable.rank_third_icon);
                o000000o.O0000OOo.setVisibility(0);
                o000000o.O0000O0o.setVisibility(8);
                break;
            default:
                o000000o.O0000OOo.setVisibility(8);
                o000000o.O0000O0o.setVisibility(0);
                break;
        }
    }

    public void O000000o(List<PersonalRank> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public void O00000Oo(List<PersonalRank> list) {
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public void O00000o0(List<DepartmentRank> list) {
        this.O00000o0.clear();
        this.O00000o0.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        int i = 0;
        if (this.O00000o == 0) {
            if (this.O000000o != null) {
                i = this.O000000o.size();
            }
            return i;
        }
        if (this.O00000o0 != null) {
            i = this.O00000o0.size();
        }
        return i;
    }
}
