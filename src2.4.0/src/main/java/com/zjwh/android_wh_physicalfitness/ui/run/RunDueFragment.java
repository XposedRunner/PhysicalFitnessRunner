package com.zjwh.android_wh_physicalfitness.ui.run;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.AllRunListActivity;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfo;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.gf;
import defpackage.ig;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427518)
public class RunDueFragment extends BaseFragment {
    private int O000000o;

    static {
        C.i(16777363);
    }

    @Event({2131297275, 2131297276})
    private void clickEvent(View view) {
        if (!O00OOo0.O000000o()) {
            if (VERSION.SDK_INT < 22) {
                O00000Oo("版本过低", "您的手机Android版本低于5.1，无法开启跑步。");
            } else if (O00Oo0.O00000o(getActivity())) {
                O00Oo00.O00000Oo((int) R.string.is_enmulator);
            } else if (ig.O000000o(getActivity()) || ig.O00000o0(getActivity()) || ig.O00000Oo() || ig.O000000o() || ig.O00000Oo(getActivity())) {
                O00Oo00.O00000Oo(getString(R.string.cheat_xposed_check));
                O00OO0O.O000000o(new PvDataInfo(gf.O000OOOo, gf.O000OooO));
            } else {
                switch (view.getId()) {
                    case R.id.tvSportDueCreate /*2131297275*/:
                        this.O000000o = 1;
                        break;
                    case R.id.tvSportDueMore /*2131297276*/:
                        this.O000000o = 2;
                        break;
                }
                O00O00o.O000000o((Fragment) this);
            }
        }
    }

    @PermissionSuccess(requestCode = 101)
    public void O00000Oo() {
        if (this.O000000o == 1) {
            O00000o();
        } else if (this.O000000o == 2) {
            AllRunListActivity.O000000o(getActivity());
        }
    }

    public native void O00000o();

    @PermissionFail(requestCode = 101)
    public void O00000o0() {
        O00O00o.O000000o(getContext(), 101);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.O00000oO = false;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionGen.onRequestPermissionsResult((Fragment) this, i, strArr, iArr);
    }
}
