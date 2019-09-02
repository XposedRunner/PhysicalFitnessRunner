package defpackage;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfo;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SemesterListAdapter */
/* renamed from: ew */
public class ew extends Adapter {
    private List<SemesterInfo> O000000o = new ArrayList();
    private O00000o0 O00000Oo;

    /* compiled from: SemesterListAdapter */
    /* renamed from: ew$O000000o */
    private static class O000000o extends ViewHolder {
        private TextView O000000o;

        O000000o(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    /* compiled from: SemesterListAdapter */
    /* renamed from: ew$O00000Oo */
    private static class O00000Oo extends ViewHolder {
        private TextView O000000o;
        private TextView O00000Oo;
        private View O00000o0;

        O00000Oo(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.tv_semester_name);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv_semester_time);
            this.O00000o0 = view.findViewById(R.id.current_line);
        }
    }

    public ew(O00000o0 o00000o0) {
        this.O00000Oo = o00000o0;
    }

    public void O000000o() {
        this.O00000Oo = null;
    }

    public void O000000o(List<SemesterInfo> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }

    public int getItemViewType(int i) {
        return ((SemesterInfo) this.O000000o.get(i)).getViewType();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final SemesterInfo semesterInfo = (SemesterInfo) this.O000000o.get(i);
        if (viewHolder instanceof O000000o) {
            ((O000000o) viewHolder).O000000o.setText(semesterInfo.getSname());
        } else if (viewHolder instanceof O00000Oo) {
            int i2 = 0;
            i = ((SemesterInfo) this.O000000o.get(i - 1)).getViewType() == 2 ? 1 : 0;
            O00000Oo o00000Oo = (O00000Oo) viewHolder;
            o00000Oo.O000000o.setText(semesterInfo.getSname());
            if (semesterInfo.getEndDate() > 0) {
                o00000Oo.O00000Oo.setText(String.format("%s-%s", new Object[]{O000O0o0.O000000o(O000O0o0.O0000OoO, semesterInfo.getStartDate()), O000O0o0.O000000o(O000O0o0.O0000OoO, semesterInfo.getEndDate())}));
            } else {
                o00000Oo.O00000Oo.setText("目前累计全部记录");
            }
            View O00000o0 = o00000Oo.O00000o0;
            if (i == 0) {
                i2 = 8;
            }
            O00000o0.setVisibility(i2);
            viewHolder.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (ew.this.O00000Oo != null) {
                        ew.this.O00000Oo.O000000o(semesterInfo);
                    }
                }
            });
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i != 2 ? new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.semester_title_layout, viewGroup, false)) : new O00000Oo(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.semester_list_item, viewGroup, false));
    }
}
