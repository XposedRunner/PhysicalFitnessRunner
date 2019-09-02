package com.zjwh.android_wh_physicalfitness.ui.run;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.SemesterTipDialog;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.activity.BindAccountActivity;
import com.zjwh.android_wh_physicalfitness.activity.ChangeCampusActivity;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.GetCampusEvt;
import com.zjwh.android_wh_physicalfitness.entity.HomePageDialogBean;
import com.zjwh.android_wh_physicalfitness.entity.HomePageInfo;
import com.zjwh.android_wh_physicalfitness.entity.RunModeModel;
import com.zjwh.android_wh_physicalfitness.entity.RunModel;
import com.zjwh.android_wh_physicalfitness.entity.RunRuleModel;
import com.zjwh.android_wh_physicalfitness.entity.SchoolInfoModel;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfoModel;
import com.zjwh.android_wh_physicalfitness.entity.SemesterTipBean;
import com.zjwh.android_wh_physicalfitness.entity.ValidTime;
import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.entity.database.MyLocation;
import com.zjwh.android_wh_physicalfitness.entity.database.NearBySchoolBean;
import com.zjwh.android_wh_physicalfitness.entity.database.SportRecord;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.ui.music.MusicMainActivity;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.O00000o0;
import com.zjwh.android_wh_physicalfitness.utils.O0000o;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00OOOo;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000OOo;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.DbManager;
import org.xutils.common.util.DensityUtil;
import org.xutils.ex.DbException;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;
import zhy.com.highlight.O00000Oo;

@ContentView(2131427517)
public class SportFragment extends BaseFragment {
    public static final String O000000o = "action_update_user_info";
    public static final String O00000oo = "receiver_broadcast";
    public static final String O0000O0o = "sp_key_run_campus";
    public static final String O0000OOo = "sp_key_run_unid";
    @ViewInject(2131296341)
    private View O0000Oo;
    @ViewInject(2131296670)
    private ImageView O0000Oo0;
    @ViewInject(2131297257)
    private TextView O0000OoO;
    @ViewInject(2131297198)
    private TextView O0000Ooo;
    @ViewInject(2131297264)
    private TextView O0000o;
    @ViewInject(2131297255)
    private TextView O0000o0;
    @ViewInject(2131297274)
    private TextView O0000o00;
    @ViewInject(2131297127)
    private TabLayout O0000o0O;
    @ViewInject(2131297472)
    private ViewPager O0000o0o;
    private RunRandomFragment O0000oO;
    private RunFreeFragment O0000oO0;
    private RunDueFragment O0000oOO;
    private O00000Oo O0000oOo;
    private BroadcastReceiver O0000oo;
    private LocalBroadcastManager O0000oo0;
    private DbManager O0000ooO;
    private O0000Oo O0000ooo;
    private List<HomePageDialogBean> O000O00o = new ArrayList();
    private boolean O000O0OO;
    private boolean O000O0Oo = false;
    private boolean O000O0o;
    private boolean O000O0o0;
    private boolean O00oOoOo = true;
    private HomePageInfo O00oOooO;
    private int O00oOooo;

    static {
        C.i(51);
    }

    private native boolean O00000Oo();

    private void O00000o() {
        this.O0000oOo = new O00000Oo(getActivity()).O00000Oo(false).O000000o(true).O000000o(new 7(this)).O000000o(2131297079, LayoutInflater.from(getActivity()).inflate(2131427534, null, false), new kt((float) (-DensityUtil.dip2px(60.0f)), 0.0f, 0.0f, (float) (-(this.O0000o.getHeight() + DensityUtil.dip2px(40.0f)))), new ne(0.0f, 0.0f, 0.0f, (float) DensityUtil.dip2px(30.0f), (float) DensityUtil.dip2px(30.0f)));
        if (O0000Ooo()) {
            this.O0000oOo.O0000OOo();
        }
    }

    private void O00000o0() {
        if (this.O000O00o != null && this.O000O00o.size() > 0) {
            int size = this.O000O00o.size() - 1;
            while (size >= 0) {
                HomePageDialogBean homePageDialogBean = (HomePageDialogBean) this.O000O00o.get(size);
                try {
                    if (O0000Ooo()) {
                        new O0000OOo(getContext(), homePageDialogBean.getBounceType()).O000000o(homePageDialogBean.getMainTitle()).O00000Oo(homePageDialogBean.getSubTitle()).O00000o0(homePageDialogBean.getBtnText()).O00000o(homePageDialogBean.getBounceType() == 0 ? homePageDialogBean.getImgUrl() : homePageDialogBean.getIrregularImgUrl()).O00000Oo(new 6(this, homePageDialogBean)).O000000o(new 5(this, homePageDialogBean)).show();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("exposure_");
                        stringBuilder.append(homePageDialogBean.getBounceId());
                        O00OO0O.O000000o(new PvDataInfoV29(120000, stringBuilder.toString()));
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("exposure_");
                        stringBuilder.append(homePageDialogBean.getBounceId());
                        O00Oo00o.O000000o(getActivity(), "tank", stringBuilder.toString());
                        if (!TextUtils.isEmpty(homePageDialogBean.getAdExposingCodes())) {
                            O00000o0.O00000Oo(homePageDialogBean.getAdExposingCodes());
                        }
                        size--;
                    } else {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.O000O00o.clear();
        }
    }

    private void O00000oO() {
        SemesterTipBean semesterTipBean = new SemesterTipBean();
        SemesterInfoModel O00000o0 = O0000o.O00000o0();
        RunRuleModel O00000Oo = O0000o.O00000Oo();
        if (O00000o0 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O00Oo0.O00000Oo(O00000o0.getSemesterGoal()));
            stringBuilder.append("公里");
            semesterTipBean.setSemesterGoal(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(O000O0o0.O000000o("yyyy.MM.dd", O00000o0.getStartDate()));
            stringBuilder.append("-");
            stringBuilder.append(O000O0o0.O000000o("yyyy.MM.dd", O00000o0.getEndDate()));
            semesterTipBean.setTime(stringBuilder.toString());
            semesterTipBean.setShowMoreLimit(O00000Oo());
            if (O00000Oo != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(O00000Oo.getDayGoal());
                stringBuilder.append("公里");
                semesterTipBean.setGradeLimit(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(((float) O00000Oo.getMinDistance()) / 1000.0f);
                stringBuilder.append("公里");
                semesterTipBean.setDistanceLimit(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(O00Oo0.O0000O0o(O00000Oo.getSpeedTop()));
                stringBuilder.append("~");
                stringBuilder.append(O00Oo0.O0000O0o(O00000Oo.getSpeedBottom()));
                stringBuilder.append("分钟/公里");
                semesterTipBean.setSpeedLimit(stringBuilder.toString());
                ArrayList arrayList = new ArrayList();
                List validTime = O00000Oo.getValidTime();
                if (validTime != null && validTime.size() > 0) {
                    for (int i = 0; i < validTime.size(); i++) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(((ValidTime) validTime.get(i)).getStart());
                        stringBuilder2.append("-");
                        stringBuilder2.append(((ValidTime) validTime.get(i)).getEnd());
                        arrayList.add(stringBuilder2.toString());
                    }
                }
                semesterTipBean.setRunValidTime(arrayList);
            }
            SemesterTipDialog newInstance = SemesterTipDialog.newInstance(semesterTipBean);
            if (this.O000O0o0) {
                newInstance.setNeedCallBack(true);
                newInstance.setTargetFragment(this, SemesterTipDialog.REQUEST_CODE_SEMESTER_DIALOG);
                this.O000O0o0 = false;
            }
            if (O0000Ooo()) {
                newInstance.show(getFragmentManager(), SemesterTipDialog.TAG);
            } else {
                return;
            }
        }
        O000000o("提示", "学校未开设学期", (OnClickListener) new 8(this));
    }

    private void O00000oo() {
        this.O00oOoOo = true;
        SportRecord O000000o = O000O0o.O000000o(this.O00oOooo);
        if (O000000o != null) {
            try {
                boolean z;
                List locList = O000000o.getLocList(this.O0000ooO);
                List fivePoint = O000000o.getFivePoint(this.O0000ooO);
                boolean z2 = fivePoint != null && fivePoint.size() > 0;
                if (O000000o.getPolicy() == -1) {
                    z = z2 && ((FivePoint) fivePoint.get(0)).getPosition() < 5;
                    O000000o.setPolicy(z);
                } else {
                    z = O000000o.getPolicy() == 1 && O000000o.getSportType() == 1;
                }
                boolean z3 = O000000o.getSportType() == 4;
                if (locList == null || locList.size() <= 0 || !(z2 || z3)) {
                    O000O0o.O000000o(O000000o.getTimestamp());
                    O0000OOo();
                } else {
                    MyLocation myLocation = (MyLocation) locList.get(locList.size() - 1);
                    if (O000O0o0.O00000o0(myLocation.getGainTime()) > 1800) {
                        FragmentActivity activity = getActivity();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(this.O00oOooo);
                        stringBuilder.append("Due_Run_RoomId");
                        O00O0Oo0.O000000o(activity, stringBuilder.toString());
                        if (myLocation.getTotalTime() < 30) {
                            O000O0o.O000000o(O000000o.getTimestamp());
                            O0000O0o();
                        } else if (!z3 || myLocation.getTotalDis() >= 100.0d) {
                            O000000o.setStopTime(System.currentTimeMillis());
                            this.O0000ooO.saveOrUpdate(O000000o);
                            this.O0000ooo = O000000o(2131689877, 2131689672, (OnClickListener) new O000000o(this, null));
                        } else {
                            O000O0o.O000000o(O000000o.getTimestamp());
                            O0000O0o();
                        }
                    } else {
                        int intValue = ((Integer) O00O0Oo0.O00000o0("run_restart_count", Integer.valueOf(0))).intValue();
                        if (!z3) {
                            intValue++;
                            O00O0Oo0.O000000o("run_restart_count", Integer.valueOf(intValue));
                        }
                        if (intValue >= 5) {
                            O000000o.setStopTime(System.currentTimeMillis());
                            this.O0000ooO.saveOrUpdate(O000000o);
                            O00O0Oo0.O000000o("run_restart_count");
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(this.O00oOooo);
                            stringBuilder2.append("Due_Run_RoomId");
                            O00O0Oo0.O000000o(stringBuilder2.toString());
                            this.O0000ooo = O000000o(2131689877, 2131689670, (OnClickListener) new O000000o(this, null));
                        } else {
                            this.O0000ooo = new O0000Oo(getActivity()).O000000o().O000000o(false).O00000Oo(false).O000000o(2131689877).O00000Oo(2131689673).O00000Oo(2131689933, new 11(this, O000000o, z3, z)).O000000o(2131689637, new 10(this, O000000o));
                            if (O0000Ooo()) {
                                this.O0000ooo.O00000Oo();
                            }
                        }
                    }
                }
            } catch (DbException e) {
                e.printStackTrace();
            }
        } else {
            O0000OOo();
        }
    }

    private synchronized void O0000O0o() {
        this.O00oOoOo = false;
        if (!(this.O000O0Oo || isHidden() || ((this.O0000ooo != null && this.O0000ooo.O00000oO()) || ((Boolean) O00O0Oo0.O00000o0(O00000oo, Boolean.valueOf(false))).booleanValue()))) {
            UserInfo O00000o0 = O00Oo0.O00000o0();
            if (O00000o0 == null || O00000o0.isInfoComplete()) {
                O0000Oo0();
            } else {
                BindAccountActivity.O000000o(getActivity());
            }
        }
    }

    private void O0000OOo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O00oOooo);
        stringBuilder.append("Due_Run_RoomId");
        int intValue = ((Integer) O00O0Oo0.O00000o0(stringBuilder.toString(), Integer.valueOf(-1))).intValue();
        if (intValue == -1) {
            O0000O0o();
            return;
        }
        gj gjVar = new gj("/api/v8/homepage/aboutRunInfo");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("roomId", String.valueOf(intValue));
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(getActivity(), gjVar, new 2(this, intValue)));
    }

    private native void O0000Oo0();

    @Event({2131297274, 2131297255, 2131296353, 2131297264})
    private void clickEvent(View view) {
        if (!O00OOo0.O000000o()) {
            int id = view.getId();
            if (id == 2131296353) {
                O00OO0O.O000000o(new PvDataInfoV29(SemesterTipDialog.REQUEST_CODE_SEMESTER_DIALOG, "home_music"));
                MusicMainActivity.O000000o(getActivity());
            } else if (id == 2131297255) {
                ChangeCampusActivity.O000000o(getActivity());
            } else if (id == 2131297264) {
                O00000oO();
            } else if (id == 2131297274) {
                double d = 0.0d;
                if (this.O00oOooO != null) {
                    SemesterInfoModel semesterInfoModel = this.O00oOooO.getSemesterInfoModel();
                    if (semesterInfoModel != null) {
                        double semesterGoal = semesterInfoModel.getSemesterGoal();
                        if (this.O00oOooO.getRunModel() != null) {
                            d = this.O00oOooO.getRunModel().getValidTotalDis();
                        }
                        SportInfoActivity.O000000o(getActivity(), semesterGoal, d);
                    } else {
                        O00000Oo("提示", "学校未开设学期");
                    }
                } else {
                    O00000Oo("提示", "学校未开设学期");
                }
            }
        }
    }

    public void O000000o(HomePageInfo homePageInfo) {
        this.O00oOooO = homePageInfo;
        SchoolInfoModel schoolInfoModel = this.O00oOooO.getSchoolInfoModel();
        this.O00oOooO.getSemesterInfoModel();
        RunModel runModel = this.O00oOooO.getRunModel();
        String str = "";
        String str2 = "0";
        if (schoolInfoModel != null) {
            str = schoolInfoModel.getName();
            List schoolPicUrls = schoolInfoModel.getSchoolPicUrls();
            if (schoolPicUrls != null && schoolPicUrls.size() > 0) {
                O00Oo.O000000o(getActivity()).O000000o((String) schoolPicUrls.get(0)).O0000Oo(2131231263).O00000o(2131231263).O000000o(this.O0000Oo0);
            }
        }
        if (runModel != null) {
            str2 = O00Oo0.O00000o0(runModel.getValidTotalDis());
        }
        boolean z = true;
        if (!str.contains(" ") || str.length() <= 14) {
            this.O0000OoO.setText(str);
            this.O0000Ooo.setVisibility(8);
        } else {
            String[] split = str.split(" ");
            this.O0000Ooo.setVisibility(0);
            this.O0000OoO.setText(split[0]);
            this.O0000Ooo.setText(split[1]);
        }
        this.O0000o00.setText(getString(2131689674, str2));
        UserInfo O00000o0 = O00Oo0.O00000o0();
        CharSequence charSequence = (String) O00O0Oo0.O00000o0(O0000O0o, "");
        if (O00000o0 != null && TextUtils.isEmpty(charSequence)) {
            charSequence = O00000o0.getCampusName();
        }
        this.O0000o0.setText(charSequence);
        if (this.O0000oO0 != null) {
            RunModeModel runModeModel = this.O00oOooO.getRunModeModel();
            RunFreeFragment runFreeFragment = this.O0000oO0;
            if (runModeModel == null || !runModeModel.isFreedomRunCalculate()) {
                z = false;
            }
            runFreeFragment.O000000o(z);
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        O00OOOo.O00000o0(getActivity(), this.O0000Oo);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(O000000o);
        this.O0000oo = new 1(this);
        this.O0000oo0 = LocalBroadcastManager.getInstance(getActivity());
        this.O0000oo0.registerReceiver(this.O0000oo, intentFilter);
        this.O000O0o = ((Boolean) O00O0Oo0.O00000o0("high_tip_start", Boolean.valueOf(true))).booleanValue();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == SemesterTipDialog.REQUEST_CODE_SEMESTER_DIALOG && i2 == -1) {
            new Handler().postDelayed(new 9(this), 100);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.O0000ooO = O00Oo0.O0000O0o();
        this.O00oOooO = O0000o.O000000o();
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        org.greenrobot.eventbus.O00000o0.O000000o().O000000o(this);
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public native void onDestroy();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GetCampusEvt getCampusEvt) {
        if (getCampusEvt != null) {
            NearBySchoolBean nearBySchoolBean = getCampusEvt.getNearBySchoolBean();
            String campusName = nearBySchoolBean.getCampusName();
            O00O0Oo0.O000000o(O0000O0o, campusName);
            O00O0Oo0.O000000o(O0000OOo, Integer.valueOf(nearBySchoolBean.getUnid()));
            this.O0000o0.setText(campusName);
        }
    }

    public native void onHiddenChanged(boolean z);

    public native void onPause();

    public void onResume() {
        super.onResume();
        this.O000O0OO = false;
        O00000oo();
        if (this.O000O0o && !O00000Oo()) {
            this.O000O0o = false;
            new Handler().postDelayed(new 4(this), 150);
        }
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        UserInfo O00000o0 = O00Oo0.O00000o0();
        if (O00000o0 != null) {
            this.O00oOooo = O00000o0.getUid();
        }
        this.O0000o0O.setupWithViewPager(this.O0000o0o);
        this.O0000o0o.setOffscreenPageLimit(3);
        this.O0000o0o.setAdapter(new O00000Oo(this, getChildFragmentManager()));
        this.O0000o0o.setCurrentItem(1);
        this.O0000o0O.setVisibility(O00000Oo() ? 8 : 0);
        this.O0000oO0 = new RunFreeFragment();
        this.O0000oO = new RunRandomFragment();
        this.O0000oOO = new RunDueFragment();
    }
}
