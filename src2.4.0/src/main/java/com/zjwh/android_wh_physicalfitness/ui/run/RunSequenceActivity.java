package com.zjwh.android_wh_physicalfitness.ui.run;

import android.app.Activity;
import android.content.Intent;
import com.zjwh.android_wh_physicalfitness.entity.RunRuleModel;
import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.utils.O0000o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.gg;
import defpackage.ie.O000000o;
import defpackage.kq;
import java.util.List;
import kr.co.namee.permissiongen.PermissionSuccess;

public class RunSequenceActivity extends RunRandomActivity {
    public static void O00000Oo(Activity activity, int i) {
        Intent intent = new Intent(activity, RunSequenceActivity.class);
        intent.putExtra(gg.O0000o0, i);
        activity.startActivity(intent);
    }

    public static void O00000Oo(Activity activity, String str) {
        RunRuleModel O00000Oo = O0000o.O00000Oo();
        int i = 1000;
        if (O00000Oo != null && O00000Oo.getMinDistance() > 0) {
            i = O00000Oo.getMinDistance();
        }
        Intent intent = new Intent(activity, RunSequenceActivity.class);
        intent.putExtra(gg.O0000o0, i);
        intent.putExtra("extra_start_flag", str);
        activity.startActivity(intent);
    }

    public void O000000o(int i, boolean z) {
        if (this.O00000o0 != null) {
            this.O00000o0.O00000Oo(i, z);
        }
    }

    public void O000000o(List<FivePoint> list, SWLatLng sWLatLng) {
        O0000o();
        if (!O0000o0().O000000o(30005)) {
            O0000o0().O00000oO();
        }
        if (this.O00000o0 != null && list != null && list.size() > 0) {
            this.O00000o0.O000000o((List) list, sWLatLng, 3);
        }
    }

    @PermissionSuccess(requestCode = 101)
    public void O0000oo() {
        O0000o0().O00000o();
        O0000o0().O00000oo();
        O00Oo0.O000000o(this);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O0000oo0 */
    public O000000o O0000o0() {
        if (this.O00000oo == null) {
            this.O00000oo = new kq(this, this.O0000o0);
        }
        return (O000000o) this.O00000oo;
    }
}
