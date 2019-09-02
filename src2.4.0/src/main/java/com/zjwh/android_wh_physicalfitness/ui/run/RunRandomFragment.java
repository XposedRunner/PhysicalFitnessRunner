package com.zjwh.android_wh_physicalfitness.ui.run;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.RandomConfigBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.RunRuleModel;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfo;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o;
import com.zjwh.android_wh_physicalfitness.utils.O000OO0o;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.gf;
import defpackage.gg;
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
import zhy.com.highlight.O00000Oo;

@ContentView(2131427519)
public class RunRandomFragment extends BaseFragment {
    @ViewInject(2131297277)
    private TextView O000000o;
    @ViewInject(2131296672)
    private ImageView O00000oo;
    private O00000Oo O0000O0o;
    private O0000Oo O0000OOo;
    private lf O0000Oo0;

    static {
        C.i(16777367);
    }

    private native void O00000oO();

    private void O00000oo() {
        O000000o(getString(R.string.txt_loading), false);
        this.O00000oo.setEnabled(false);
        O000OO0o.O000000o(4, O00Oo0.O00000oO());
        gj gjVar = new gj(gk.O00Oo0OO);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("runMode", 1);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(getActivity(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
                if (RunRandomFragment.this.O0000Ooo()) {
                    RunRandomFragment.this.O00000oo.setEnabled(true);
                    RunRandomFragment.this.O0000o00();
                }
            }

            public void onError(ResponseError responseError) {
                if (RunRandomFragment.this.O0000Ooo()) {
                    int error = responseError.getError();
                    String message = error != 400 ? error != 11016 ? "服务器开小差，暂时无法开启随机跑！" : responseError.getMessage() : "网络异常，无法获取跑步有效时间，请检查网络连接";
                    RunRandomFragment.this.O00000Oo("无法开启随机跑", message);
                }
            }

            public void onFinished() {
                if (RunRandomFragment.this.O0000Ooo()) {
                    RunRandomFragment.this.O00000oo.setEnabled(true);
                    RunRandomFragment.this.O0000o00();
                }
            }

            public void onSuccess(String str) {
                if (RunRandomFragment.this.O0000Ooo()) {
                    RunRandomFragment.this.O0000o00();
                    RandomConfigBean randomConfigBean = (RandomConfigBean) O000o000.O000000o().fromJson(str, RandomConfigBean.class);
                    if (randomConfigBean != null) {
                        O00O0Oo0.O000000o(RunRuleModel.SP_KEY_MIN_DISTANCE, Integer.valueOf(randomConfigBean.getSelDistance()));
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(O00Oo0.O00000oO());
                        stringBuilder.append(randomConfigBean.getTimestamp());
                        int policy = randomConfigBean.getPolicy();
                        O00Oo0.O000000o(gg.O000Ooo0, O00Oo0.O0000oO());
                        if (policy == 0) {
                            RunRandomActivity.O000000o(RunRandomFragment.this.getActivity(), stringBuilder.toString());
                        } else if (policy == 1) {
                            RunSequenceActivity.O00000Oo(RunRandomFragment.this.getActivity(), stringBuilder.toString());
                        } else if (policy == 2) {
                            RunEndActivity.O000000o(RunRandomFragment.this.getActivity(), stringBuilder.toString());
                        }
                    }
                }
            }
        }));
    }

    @Event({2131296672})
    private void clickEvent(View view) {
        if (view.getId() != R.id.ivSportStart || O000O0o.O000000o(O00Oo0.O00000oO()) != null) {
            return;
        }
        if (VERSION.SDK_INT < 22) {
            O00000Oo("版本过低", "您的手机Android版本低于5.1，无法开启跑步。");
        } else if (O00Oo0.O00000o(getActivity())) {
            O00Oo00.O00000Oo((int) R.string.is_enmulator);
        } else if (ig.O000000o(getActivity()) || ig.O00000o0(getActivity()) || ig.O00000Oo() || ig.O000000o() || ig.O00000Oo(getActivity())) {
            O00Oo00.O00000Oo(getString(R.string.cheat_xposed_check));
            O00OO0O.O000000o(new PvDataInfo(gf.O000OOOo, gf.O000OooO));
        } else {
            O00O00o.O000000o((Fragment) this);
        }
    }

    public native void O00000Oo();

    @PermissionFail(requestCode = 101)
    public void O00000o() {
        O00O00o.O000000o(getContext(), 101);
    }

    @PermissionSuccess(requestCode = 101)
    public void O00000o0() {
        O00000oO();
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
        this.O000000o.setText("随机跑步进行成绩记录");
        this.O0000Oo0 = new lf(DensityUtil.dip2px(220.0f), DensityUtil.dip2px(110.0f));
        this.O00000oo.setImageDrawable(this.O0000Oo0);
        this.O0000Oo0.start();
    }
}
