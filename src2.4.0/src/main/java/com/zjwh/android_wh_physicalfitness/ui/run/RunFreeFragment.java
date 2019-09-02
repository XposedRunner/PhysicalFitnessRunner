package com.zjwh.android_wh_physicalfitness.ui.run;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.HomePageInfo;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfo;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O0000o;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.gf;
import defpackage.gj;
import defpackage.gk;
import defpackage.ig;
import defpackage.lf;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427519)
public class RunFreeFragment extends BaseFragment {
    @ViewInject(2131297277)
    private TextView O000000o;
    @ViewInject(2131296672)
    private ImageView O00000oo;
    private lf O0000O0o;
    private O0000Oo O0000OOo;

    static {
        C.i(16777365);
    }

    private native void O00000o();

    private void O00000oO() {
        O000000o(getString(R.string.txt_loading), false);
        this.O00000oo.setEnabled(false);
        gj gjVar = new gj(gk.O000OOoo);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sportType", 4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        gjVar.setBodyContent(jSONObject.toString());
        O000000o(HttpUtil.postOp(getActivity(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
                if (RunFreeFragment.this.O0000Ooo()) {
                    RunFreeFragment.this.O00000oo.setEnabled(true);
                    RunFreeFragment.this.O0000o00();
                }
            }

            public void onError(ResponseError responseError) {
                if (RunFreeFragment.this.O0000Ooo()) {
                    new O0000Oo(RunFreeFragment.this.getContext()).O000000o().O000000o((int) R.string.tip).O00000Oo((int) R.string.msg_not_start_time).O000000o(false).O00000Oo(false).O000000o((int) R.string.give_up, null).O00000Oo((int) R.string.sure, new OnClickListener() {
                        public void onClick(View view) {
                            RunFreeFragment.this.O00000oO();
                        }
                    }).O00000Oo();
                }
            }

            public void onFinished() {
                if (RunFreeFragment.this.O0000Ooo()) {
                    RunFreeFragment.this.O00000oo.setEnabled(true);
                    RunFreeFragment.this.O0000o00();
                }
            }

            public void onSuccess(String str) {
                if (RunFreeFragment.this.O0000Ooo()) {
                    RunFreeFragment.this.O0000o00();
                    RunFreeActivity.O000000o(RunFreeFragment.this.getActivity(), ((Long) O000o000.O000000o().fromJson(str, Long.class)).longValue());
                }
            }
        }));
    }

    @Event({2131296672})
    private void clickEvent(View view) {
        if (!O00OOo0.O000000o()) {
            if (VERSION.SDK_INT < 22) {
                O00000Oo("版本过低", "您的手机Android版本低于5.1，无法开启跑步。");
                return;
            }
            if (view.getId() != R.id.ivSportStart || O000O0o.O000000o(O00Oo0.O00000oO()) != null) {
                return;
            }
            if (O00Oo0.O00000o(getActivity())) {
                O00Oo00.O00000Oo((int) R.string.is_enmulator);
            } else if (ig.O000000o(getActivity()) || ig.O00000o0(getActivity()) || ig.O00000Oo() || ig.O000000o() || ig.O00000Oo(getActivity())) {
                O00Oo00.O00000Oo(getString(R.string.cheat_xposed_check));
                O00OO0O.O000000o(new PvDataInfo(gf.O000OOOo, gf.O000OooO));
            } else {
                O00O00o.O000000o((Fragment) this);
            }
        }
    }

    public native void O000000o(boolean z);

    @PermissionSuccess(requestCode = 101)
    public void O00000Oo() {
        O00000o();
    }

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

    public native void onDestroy();

    public native void onPause();

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionGen.onRequestPermissionsResult((Fragment) this, i, strArr, iArr);
    }

    public native void onResume();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O000000o.setText("自由模式下的跑步成绩，不计入体育成绩");
        HomePageInfo O000000o = O0000o.O000000o();
        TextView textView = this.O000000o;
        int i = (O000000o == null || O000000o.getRunModeModel() == null || !O000000o.getRunModeModel().isFreedomRunCalculate()) ? 0 : 8;
        textView.setVisibility(i);
        this.O0000O0o = new lf(DensityUtil.dip2px(220.0f), DensityUtil.dip2px(110.0f));
        this.O00000oo.setImageDrawable(this.O0000O0o);
        this.O0000O0o.start();
    }
}
