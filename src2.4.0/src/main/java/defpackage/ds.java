package defpackage;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.AttendanceListBean;
import com.zjwh.android_wh_physicalfitness.entity.AttendanceValidBean;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: AttendanceListAdapter */
/* renamed from: ds */
public class ds extends Adapter<O000000o> {
    private List<AttendanceListBean> O000000o = new ArrayList();

    /* compiled from: AttendanceListAdapter */
    /* renamed from: ds$O000000o */
    public static class O000000o extends ViewHolder {
        private TextView O000000o;
        private TextView O00000Oo;
        private LinearLayout O00000o;
        private TextView O00000o0;
        private View O00000oO;

        public O000000o(View view) {
            super(view);
            this.O000000o = (TextView) view.findViewById(R.id.attendance_time);
            this.O00000Oo = (TextView) view.findViewById(R.id.attendance_valid_time);
            this.O00000o0 = (TextView) view.findViewById(R.id.attendance_state);
            this.O00000o = (LinearLayout) view.findViewById(R.id.attendance_valid_layout);
            this.O00000oO = view.findViewById(R.id.line);
        }
    }

    private TextView O000000o(Context context, boolean z, String str) {
        TextView textView = new TextView(context);
        textView.setTextColor(ContextCompat.getColor(context, z ? R.color.text_color_major : R.color.red));
        textView.setTextSize(13.0f);
        textView.setText(str);
        return textView;
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.attendance_list_item, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(O000000o o000000o, int i) {
        AttendanceListBean attendanceListBean = (AttendanceListBean) this.O000000o.get(i);
        o000000o.O000000o.setText(O000O0o0.O000000o(O000O0o0.O0000Ooo, attendanceListBean.getSigninTime()));
        TextView O00000Oo = o000000o.O00000Oo;
        Object[] objArr = new Object[1];
        int i2 = 0;
        objArr[0] = Integer.valueOf(attendanceListBean.getValidTime());
        O00000Oo.setText(String.format(Locale.getDefault(), "%d分钟", objArr));
        o000000o.O00000o0.setText(attendanceListBean.getStatus() == 1 ? "出勤" : "无效");
        o000000o.O00000o.removeAllViews();
        if (attendanceListBean.getFragments() != null) {
            for (AttendanceValidBean attendanceValidBean : attendanceListBean.getFragments()) {
                LinearLayout O00000o = o000000o.O00000o;
                Context context = o000000o.itemView.getContext();
                boolean z = attendanceListBean.getStatus() == 1;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(O000O0o0.O000000o(O000O0o0.O0000OOo, attendanceValidBean.getStartTime()));
                stringBuilder.append("-");
                stringBuilder.append(O000O0o0.O000000o(O000O0o0.O0000OOo, attendanceValidBean.getEndTime()));
                O00000o.addView(O000000o(context, z, stringBuilder.toString()));
            }
        }
        O00000Oo = o000000o.O000000o;
        Context context2 = o000000o.itemView.getContext();
        int status = attendanceListBean.getStatus();
        int i3 = R.color.red;
        O00000Oo.setTextColor(ContextCompat.getColor(context2, status == 1 ? R.color.text_color_major : R.color.red));
        o000000o.O00000Oo.setTextColor(ContextCompat.getColor(o000000o.itemView.getContext(), attendanceListBean.getStatus() == 1 ? R.color.text_color_major : R.color.red));
        O00000Oo = o000000o.O00000o0;
        context2 = o000000o.itemView.getContext();
        if (attendanceListBean.getStatus() == 1) {
            i3 = R.color.text_color_major;
        }
        O00000Oo.setTextColor(ContextCompat.getColor(context2, i3));
        View O00000oO = o000000o.O00000oO;
        if (i == getItemCount() - 1) {
            i2 = 8;
        }
        O00000oO.setVisibility(i2);
    }

    public void O000000o(List<AttendanceListBean> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public void O00000Oo(List<AttendanceListBean> list) {
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
