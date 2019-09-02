package com.zjwh.android_wh_physicalfitness.ui.run;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.due.DueRunCompleteActivity;
import com.zjwh.android_wh_physicalfitness.entity.DueRunningPerson;
import com.zjwh.android_wh_physicalfitness.entity.GetDrawChanceBean;
import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.blur.BlurDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.ib.O000000o;
import defpackage.ib.O00000Oo;
import defpackage.km;
import java.util.List;
import kr.co.namee.permissiongen.PermissionSuccess;
import s.h.e.l.l.C;

public class RunDueActivity extends BaseRunActivity<O000000o> implements BlurDialog.O000000o, O00000Oo {
    private O0000Oo O0000oo0 = null;

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.run.RunDueActivity$9 */
    class AnonymousClass9 implements OnClickListener {
        final /* synthetic */ int O000000o;
        final /* synthetic */ GetDrawChanceBean O00000Oo;

        AnonymousClass9(int i, GetDrawChanceBean getDrawChanceBean) {
            this.O000000o = i;
            this.O00000Oo = getDrawChanceBean;
        }

        public void onClick(View view) {
            DueRunCompleteActivity.O000000o(RunDueActivity.this, this.O000000o, this.O00000Oo);
            RunDueActivity.this.finish();
        }
    }

    static {
        C.i(16777362);
    }

    public static native void O000000o(Activity activity, int i);

    public static native void O000000o(Activity activity, int i, int i2);

    public native void O000000o(int i, int i2, String str, String str2);

    public native void O000000o(DueRunningPerson dueRunningPerson);

    public native void O000000o(String str, String str2, String str3, String str4);

    public void O000000o(List<FivePoint> list, SWLatLng sWLatLng) {
        O0000o();
        super.O000000o((List) list, sWLatLng);
        O0000o0().O0000ooO();
        if (this.O00000o0 != null && list != null && list.size() > 0) {
            this.O00000o0.O000000o((List) list, sWLatLng, 2);
        }
    }

    public native void O000000o(boolean z, int i);

    public native void O000000o(boolean z, int i, GetDrawChanceBean getDrawChanceBean);

    public native void O00000Oo(int i);

    public native void O00000o(int i);

    public native void O00000o0();

    public native void O00000o0(int i);

    public native void O0000o0O();

    /* Access modifiers changed, original: protected */
    /* renamed from: O0000oo */
    public O000000o O0000o0() {
        if (this.O00000oo == null) {
            this.O00000oo = new km(this, this.O0000o0);
        }
        return (O000000o) this.O00000oo;
    }

    @PermissionSuccess(requestCode = 101)
    public void O0000oo0() {
        O0000o0().O00000o();
        O0000o0().O00000oo();
        O00Oo0.O000000o(this);
    }

    public native void O0000ooO();

    public void k_() {
        O00Oo00.O00000Oo(getString(R.string.get_extra_fail));
        finish();
    }

    public void l_() {
        if (!isFinishing()) {
            new O0000Oo(this.O0000o0).O000000o().O000000o(false).O00000Oo(false).O000000o((int) R.string.title_due_run_failure).O00000Oo((int) R.string.msg_record_exception).O000000o((int) R.string.give_up, new OnClickListener() {
                public void onClick(View view) {
                    RunDueActivity.this.O0000o0().O000O00o();
                    RunDueActivity.this.O0000o0().O0000Oo0();
                }
            }).O00000Oo((int) R.string.reupload, new OnClickListener() {
                public void onClick(View view) {
                    RunDueActivity.this.O0000OOo();
                }
            }).O00000Oo();
        }
    }

    public void m_() {
        if (this.O00000o0 != null) {
            this.O00000o0.O00000o0();
        }
    }

    public native void onDestroy();

    public native void onDismiss(DialogInterface dialogInterface);

    public native void onPause();
}
