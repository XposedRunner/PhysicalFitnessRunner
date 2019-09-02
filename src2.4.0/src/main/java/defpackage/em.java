package defpackage;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.mine.StudentListActivity;
import com.zjwh.android_wh_physicalfitness.entity.StuClassResModel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MyStudentAdapter */
/* renamed from: em */
public class em extends Adapter<O000000o> {
    private List<StuClassResModel> O000000o = new ArrayList();

    /* compiled from: MyStudentAdapter */
    /* renamed from: em$O000000o */
    class O000000o extends ViewHolder {
        private TextView O00000Oo;
        private RelativeLayout O00000o;
        private TextView O00000o0;
        private View O00000oO;

        public O000000o(View view) {
            super(view);
            this.O00000Oo = (TextView) view.findViewById(R.id.tv1_1);
            this.O00000o0 = (TextView) view.findViewById(R.id.tv1_2);
            this.O00000o = (RelativeLayout) view.findViewById(R.id.rl_course_stu);
            this.O00000oO = view.findViewById(R.id.line);
        }

        private void O000000o(StuClassResModel stuClassResModel) {
            this.O00000Oo.setText(stuClassResModel.getClassName());
            this.O00000o0.setText(this.itemView.getContext().getString(R.string.student_class_counts, new Object[]{Integer.valueOf(stuClassResModel.getStudentNum())}));
        }
    }

    /* renamed from: O000000o */
    public O000000o onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new O000000o(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_course_or_student, viewGroup, false));
    }

    /* renamed from: O000000o */
    public void onBindViewHolder(final O000000o o000000o, int i) {
        final StuClassResModel stuClassResModel = (StuClassResModel) this.O000000o.get(i);
        if (stuClassResModel != null) {
            o000000o.O000000o(stuClassResModel);
            o000000o.O00000o.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    StudentListActivity.O000000o((Activity) o000000o.itemView.getContext(), stuClassResModel.getCid());
                }
            });
            o000000o.O00000oO.setVisibility(i == this.O000000o.size() + -1 ? 8 : 0);
        }
    }

    public void O000000o(List<StuClassResModel> list) {
        this.O000000o.clear();
        this.O000000o.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.O000000o == null ? 0 : this.O000000o.size();
    }
}
