package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.content.BroadcastReceiver;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.load.resource.bitmap.O0000O0o;
import com.qf.qrcode.R;
import com.qiyukf.unicorn.api.ConsultSource;
import com.qiyukf.unicorn.api.Unicorn;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.zjwh.android_wh_physicalfitness.activity.HomePageActivity;
import com.zjwh.android_wh_physicalfitness.activity.WebViewActivity;
import com.zjwh.android_wh_physicalfitness.activity.mine.SettingActivity;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.ChooseCourseEvt;
import com.zjwh.android_wh_physicalfitness.entity.HomePageInfo;
import com.zjwh.android_wh_physicalfitness.entity.RunModel;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfoModel;
import com.zjwh.android_wh_physicalfitness.entity.SignIntegralBean;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.ui.message.MessageActivity;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.O0000o;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00OOOo;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.greenrobot.eventbus.O00000o0;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427513)
public class MineFragment extends BaseFragment {
    @ViewInject(2131296691)
    public ImageView O000000o;
    @ViewInject(2131297371)
    public TextView O00000oo;
    @ViewInject(2131297382)
    public TextView O0000O0o;
    @ViewInject(2131297418)
    public TextView O0000OOo;
    @ViewInject(2131297331)
    public TextView O0000Oo;
    @ViewInject(2131297303)
    public TextView O0000Oo0;
    @ViewInject(2131297060)
    private NestedScrollView O0000OoO;
    @ViewInject(2131296992)
    private View O0000Ooo;
    @ViewInject(2131296947)
    private View O0000o;
    @ViewInject(2131296669)
    private ImageView O0000o0;
    @ViewInject(2131297160)
    private View O0000o00;
    @ViewInject(2131296664)
    private ImageView O0000o0O;
    @ViewInject(2131296658)
    private ImageView O0000o0o;
    @ViewInject(2131297233)
    private TextView O0000oO;
    @ViewInject(2131297231)
    private TextView O0000oO0;
    @ViewInject(2131297269)
    private TextView O0000oOO;
    @ViewInject(2131297268)
    private TextView O0000oOo;
    @ViewInject(2131296767)
    private LinearLayout O0000oo;
    @ViewInject(2131296945)
    private RecyclerView O0000oo0;
    @ViewInject(2131296441)
    private TextView O0000ooO;
    private LocalBroadcastManager O0000ooo;
    private SignIntegralBean O000O00o;
    private UserInfo O000O0OO;
    private BroadcastReceiver O00oOooO;
    private ej O00oOooo;

    static {
        C.i(46);
    }

    private native void O00000o();

    private native void O00000oO();

    private native void O00000oo();

    private void O0000O0o() {
        try {
            this.O000O0OO = O00Oo0.O00000o0();
            this.O00000oo.setText(this.O000O0OO.getName());
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(this.O000O0OO.getCampusName())) {
                stringBuilder.append(this.O000O0OO.getCampusName().split(" ")[0]);
                stringBuilder.append(" ");
            }
            if (!TextUtils.isEmpty(this.O000O0OO.getDepart())) {
                stringBuilder.append(this.O000O0OO.getDepart());
            }
            this.O0000O0o.setText(stringBuilder.toString());
            int i = this.O000O0OO.getSex() == 0 ? 2131230877 : 2131230878;
            if (TextUtils.isEmpty(this.O000O0OO.getIcon())) {
                O00Oo.O000000o(getActivity()).O000000o(Integer.valueOf(i)).O000000o(new O0000O0o[]{new la(getContext())}).O000000o(this.O000000o);
            } else {
                O00Oo0.O000000o(getActivity(), this.O000O0OO.getIcon(), this.O000000o, this.O000O0OO.getSex());
            }
            HomePageInfo O000000o = O0000o.O000000o();
            if (O000000o != null) {
                SemesterInfoModel semesterInfoModel = O000000o.getSemesterInfoModel();
                RunModel runModel = O000000o.getRunModel();
                this.O0000OOo.setText(semesterInfoModel == null ? "0.00" : O00Oo0.O00000o0(semesterInfoModel.getSemesterGoal()));
                this.O0000Oo0.setText(runModel == null ? "0.00" : O00Oo0.O00000o0(runModel.getTotalDis()));
                this.O0000Oo.setText(runModel == null ? "0.00" : O00Oo0.O00000o0(runModel.getValidTotalDis()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private native void O0000OOo();

    private native void O0000Oo0();

    private void O0000o0() {
        gj gjVar = new gj("/api/v24/app/userinfo/point/info");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Oauth2AccessToken.KEY_UID, this.O000O0OO.getUid());
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(getContext(), gjVar, new 5(this)));
    }

    private native void O0000o0O();

    @Event(type = OnClickListener.class, value = {2131296992, 2131297003, 2131296669, 2131296664, 2131296813, 2131296773, 2131297268, 2131297231, 2131296441, 2131296786})
    private void clickEvent(View view) {
        if (!O00OOo0.O000000o()) {
            switch (view.getId()) {
                case 2131296441:
                    ConsultSource consultSource = new ConsultSource("Android_Mine", "Android_Mine", "");
                    Unicorn.openServiceActivity(getActivity(), "客服", consultSource);
                    break;
                case 2131296664:
                    QrCodeActivity.O000000o(getActivity());
                    break;
                case 2131296669:
                    O00O00o.O00000Oo(this);
                    break;
                case 2131296773:
                    O00Oo00o.O000000o(getActivity(), "integral_record", "click2");
                    WebViewActivity.O000000o(getActivity(), "https://gxapp-h5.oss-cn-shanghai.aliyuncs.com/gxapp/point/prod/integral.html");
                    break;
                case 2131296786:
                    O00Oo00o.O000000o(getActivity(), "run_record", "click1");
                    RunHistoryActivity.O000000o(getActivity());
                    break;
                case 2131296813:
                    MessageActivity.O000000o(getActivity());
                    break;
                case 2131296992:
                    if (this.O000O0OO != null) {
                        HomePageActivity.O000000o(getActivity(), this.O000O0OO.getUid());
                        break;
                    }
                    return;
                case 2131297003:
                    SettingActivity.O000000o(getActivity());
                    break;
                case 2131297231:
                    WebViewActivity.O000000o(getActivity(), "https://gxapp-h5.oss-cn-shanghai.aliyuncs.com/gxapp/point/prod/rank.html");
                    break;
                case 2131297268:
                    O00Oo00o.O000000o(getActivity(), "integral_record", "click3");
                    O0000o0O();
                    break;
            }
        }
    }

    public native void O000000o(boolean z);

    @PermissionSuccess(requestCode = 100)
    public void O00000Oo() {
        ScanActivity.O000000o(getActivity());
    }

    @PermissionFail(requestCode = 100)
    public void O00000o0() {
        O00O00o.O000000o(getActivity(), 100);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        O00OOOo.O00000o0(getActivity(), this.O0000oo);
        O00000oO();
        O00000o();
        O0000Oo0();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        O00000o0.O000000o().O000000o(this);
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public native void onDestroy();

    public native void onHiddenChanged(boolean z);

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        PermissionGen.onRequestPermissionsResult(this, i, strArr, iArr);
    }

    public native void onResume();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (VERSION.SDK_INT >= 19) {
            this.O0000Ooo.setPadding(this.O0000Ooo.getPaddingLeft(), this.O0000Ooo.getPaddingTop() + O00OOOo.O000000o(getContext()), this.O0000Ooo.getPaddingRight(), this.O0000Ooo.getPaddingBottom());
        }
        this.O0000oo.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.transparent));
        this.O0000o00.setVisibility(8);
        this.O0000oo0.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.O0000oo0.setNestedScrollingEnabled(false);
        this.O00oOooo = new ej();
        this.O0000oo0.setAdapter(this.O00oOooo);
        this.O0000OoO.setOnScrollChangeListener(new 1(this));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateCourse(ChooseCourseEvt chooseCourseEvt) {
        if (this.O00oOooo != null) {
            this.O00oOooo.O000000o();
        }
    }
}
