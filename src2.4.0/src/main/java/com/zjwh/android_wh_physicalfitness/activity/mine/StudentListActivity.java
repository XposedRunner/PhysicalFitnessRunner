package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.CheckAttendanceActivity;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.StudentResModel;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fw;
import defpackage.ga;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class StudentListActivity extends BaseActivity {
    @ViewInject(2131297033)
    RecyclerView O000000o;
    @ViewInject(2131297340)
    TextView O00000Oo;
    private fw<StudentResModel> O00000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o0;
    private List<StudentResModel> O00000oO;
    private int O00000oo;
    private OnMenuItemClickListener O0000O0o = new OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.check_attendance) {
                Intent intent = new Intent(StudentListActivity.this, CheckAttendanceActivity.class);
                intent.putExtra("cid", StudentListActivity.this.O00000oo);
                StudentListActivity.this.startActivity(intent);
            }
            return true;
        }
    };

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.mine.StudentListActivity$2 */
    class AnonymousClass2 extends fw<StudentResModel> {
        AnonymousClass2(Context context, int i, List list) {
            super(context, i, list);
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, StudentResModel studentResModel, int i) {
            CharSequence charSequence;
            int color;
            gaVar.O000000o((int) R.id.tv_studentname, studentResModel.name);
            gaVar.O000000o((int) R.id.tv_studentnumber, studentResModel.campusId);
            boolean z = false;
            if ((studentResModel.validTotalDis >= studentResModel.semesterGoal ? 1 : false) != 0) {
                charSequence = "完成";
                color = ContextCompat.getColor(gaVar.itemView.getContext(), R.color.sport_green);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(O00Oo0.O00000o0(studentResModel.validTotalDis));
                stringBuilder.append("/");
                stringBuilder.append(O00Oo0.O00000o0(studentResModel.semesterGoal));
                charSequence = stringBuilder.toString();
                color = ContextCompat.getColor(gaVar.itemView.getContext(), R.color.text_color_hint);
            }
            gaVar.O00000oO(R.id.tv_finish_state, color);
            gaVar.O000000o((int) R.id.tv_finish_state, charSequence);
            if (i != StudentListActivity.this.O00000oO.size() - 1) {
                z = true;
            }
            gaVar.O000000o((int) R.id.line, z);
        }
    }

    static {
        C.i(16777313);
    }

    private native void O000000o(int i);

    public static native void O000000o(Activity activity, int i);

    private native void O00000o();

    private native void O00000oO();

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
        this.O00000oo = getIntent().getIntExtra("cid", 0);
        O000000o(this.O00000oo);
    }

    public native void onCreate(Bundle bundle);

    public native boolean onCreateOptionsMenu(Menu menu);

    public native void onDestroy();
}
