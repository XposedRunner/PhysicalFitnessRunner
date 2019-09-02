package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ClassResModel;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.ChooseCourseEvt;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.TeacherResModel;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fw;
import defpackage.ga;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.O00000o0;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChooseCourseActivity extends BaseActivity {
    @ViewInject(2131297033)
    RecyclerView O000000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000Oo;
    private List<ClassResModel> O00000o = new ArrayList();
    private fw<ClassResModel> O00000o0;
    private TeacherResModel O00000oO;
    private Dialog O00000oo;

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.mine.ChooseCourseActivity$1 */
    class AnonymousClass1 extends fw<ClassResModel> {
        AnonymousClass1(Context context, int i, List list) {
            super(context, i, list);
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, ClassResModel classResModel, int i) {
            gaVar.O000000o((int) R.id.tv_course, classResModel.className);
            gaVar.O000000o((int) R.id.iv_choose, classResModel.myClass);
            boolean z = true;
            if (i == ChooseCourseActivity.this.O00000o.size() - 1) {
                z = false;
            }
            gaVar.O000000o((int) R.id.line, z);
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.mine.ChooseCourseActivity$3 */
    class AnonymousClass3 implements MyCallback<String> {
        final /* synthetic */ ClassResModel O000000o;

        AnonymousClass3(ClassResModel classResModel) {
            this.O000000o = classResModel;
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
            if (!ChooseCourseActivity.this.isFinishing()) {
                O00Oo00.O000000o(ChooseCourseActivity.this, responseError.getMessage());
            }
        }

        public void onFinished() {
            if (ChooseCourseActivity.this.O00000oo != null && ChooseCourseActivity.this.O00000oo.isShowing()) {
                ChooseCourseActivity.this.O00000oo.cancel();
            }
        }

        public void onSuccess(String str) {
            if (!ChooseCourseActivity.this.isFinishing()) {
                O00000o0.O000000o().O00000o(new ChooseCourseEvt(this.O000000o.cid, this.O000000o.className, ChooseCourseActivity.this.O00000oO.mid, ChooseCourseActivity.this.O00000oO.teacherName));
                O00000Oo.O00000o0(ChooseTeacherActivity.class);
                O00000Oo.O00000o0(ChooseCourseActivity.class);
            }
        }
    }

    static {
        C.i(16777306);
    }

    private native void O000000o(ClassResModel classResModel);

    private native void O00000o();

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.O00000oO = (TeacherResModel) extras.getSerializable("teacherResModel");
            if (this.O00000oO != null) {
                this.O00000o = this.O00000oO.classResModels;
            }
        }
        O00000o();
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
