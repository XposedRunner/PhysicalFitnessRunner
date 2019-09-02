package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.qiyukf.unicorn.api.UnreadCountChangeListener;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.MainDataEvt;
import com.zjwh.android_wh_physicalfitness.entity.HomePageInfo;
import com.zjwh.android_wh_physicalfitness.entity.MainBottomItemBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfo;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.fragment.FindFragment;
import com.zjwh.android_wh_physicalfitness.ui.dynamic.DynamicMainFragment;
import com.zjwh.android_wh_physicalfitness.ui.mine.MineFragment;
import com.zjwh.android_wh_physicalfitness.ui.run.SportFragment;
import com.zjwh.android_wh_physicalfitness.ui.welfare.WelfareClubFragment;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O0000o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import defpackage.hb$O00000Oo;
import java.util.Collections;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MainActivity extends BaseActivity implements hb$O00000Oo {
    public static final String O000000o = "action_new_message";
    public static final String O00000Oo = "extra_new_message";
    public static final String O00000o = "extra_module_id";
    public static final String O00000o0 = "extra_new_discover";
    private static final String O0000OOo = "fragment_tag_sport";
    private static final String O0000Oo = "fragment_tag_dynamic";
    private static final String O0000Oo0 = "fragment_tag_discover";
    private static final String O0000o = "fragment_tag_mine";
    private static final String O0000oO0 = "fragment_tag_commerce";
    protected Handler O00000oO = new Handler();
    protected Vibrator O00000oo = null;
    protected long[] O0000O0o = new long[]{100, 400, 100, 400};
    @ViewInject(2131297127)
    private TabLayout O0000oO;
    @ViewInject(2131296638)
    private ImageView O0000oOO;
    private LocalBroadcastManager O0000oOo;
    private O000000o O0000oo;
    private BroadcastReceiver O0000oo0;
    private Boolean O0000ooO = Boolean.valueOf(false);
    private int O0000ooo = 10001;
    private UnreadCountChangeListener O000O00o = new 1(this);
    private int O00oOooO;
    private long O00oOooo;

    static {
        C.i(33);
    }

    private native ColorStateList O000000o(int i, int i2);

    private native StateListDrawable O000000o(Drawable[] drawableArr);

    private synchronized Tab O000000o(MainBottomItemBean mainBottomItemBean, Tab tab) throws NumberFormatException, NullPointerException {
        if (tab == null) {
            try {
                tab = this.O0000oO.newTab();
                tab.setCustomView(2131427588);
            } catch (Throwable th) {
            }
        }
        View customView = tab.getCustomView();
        if (customView != null) {
            TextView textView = (TextView) customView.findViewById(2131297143);
            ImageView imageView = (ImageView) customView.findViewById(2131296599);
            textView.setText(mainBottomItemBean.getText());
            if (!(TextUtils.isEmpty(mainBottomItemBean.getColorNormal()) || TextUtils.isEmpty(mainBottomItemBean.getColorSelected()))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("#");
                stringBuilder.append(mainBottomItemBean.getColorNormal());
                int parseColor = Color.parseColor(stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("#");
                stringBuilder2.append(mainBottomItemBean.getColorSelected());
                textView.setTextColor(O000000o(parseColor, Color.parseColor(stringBuilder2.toString())));
            }
            Drawable[] drawableArr = new Drawable[2];
            int[] iArr = new int[2];
            boolean[] zArr = new boolean[]{false, false};
            switch (mainBottomItemBean.getModuleId()) {
                case 10001:
                    iArr[0] = 2131231026;
                    iArr[1] = 2131231025;
                    break;
                case 10002:
                    iArr[0] = 2131231022;
                    iArr[1] = 2131231021;
                    break;
                case 10003:
                    iArr[0] = 2131231020;
                    iArr[1] = 2131231019;
                    break;
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_USER_ID_NULL /*10005*/:
                    iArr[0] = 2131231018;
                    iArr[1] = 2131231017;
                    customView.setVisibility(4);
                    break;
                default:
                    iArr[0] = 2131231024;
                    iArr[1] = 2131231023;
                    break;
            }
            drawableArr[0] = getResources().getDrawable(iArr[0]);
            drawableArr[1] = getResources().getDrawable(iArr[1]);
            O00Oo.O000000o(this).O000000o(mainBottomItemBean.getIconSelected()).O0000Oo().O00000o(iArr[0]).O00000Oo(iArr[0]).O00000Oo(new 6(this, drawableArr, zArr, imageView, mainBottomItemBean));
            O00Oo.O000000o(this).O000000o(mainBottomItemBean.getIconNormal()).O0000Oo().O00000o(iArr[1]).O00000Oo(iArr[1]).O00000Oo(new 7(this, drawableArr, zArr, imageView, mainBottomItemBean));
            tab.setTag(Integer.valueOf(mainBottomItemBean.getModuleId()));
        }
        return tab;
    }

    private synchronized void O000000o(int i) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Fragment fragment = (SportFragment) supportFragmentManager.findFragmentByTag(O0000OOo);
        Fragment fragment2 = (FindFragment) supportFragmentManager.findFragmentByTag(O0000Oo0);
        Fragment fragment3 = (DynamicMainFragment) supportFragmentManager.findFragmentByTag(O0000Oo);
        Fragment fragment4 = (MineFragment) supportFragmentManager.findFragmentByTag(O0000o);
        Fragment fragment5 = (WelfareClubFragment) supportFragmentManager.findFragmentByTag(O0000oO0);
        switch (i) {
            case 10001:
                O000000o(beginTransaction, fragment2);
                O000000o(beginTransaction, fragment3);
                O000000o(beginTransaction, fragment4);
                O000000o(beginTransaction, fragment5);
                if (fragment == null) {
                    beginTransaction.add(2131296804, new SportFragment(), O0000OOo);
                } else {
                    beginTransaction.show(fragment);
                }
                this.O0000oOO.setSelected(false);
                break;
            case 10002:
                O00OO0O.O000000o(new PvDataInfo(10000, "find_module_index"));
                O000000o(beginTransaction, fragment);
                O000000o(beginTransaction, fragment3);
                O000000o(beginTransaction, fragment4);
                O000000o(beginTransaction, fragment5);
                if (fragment2 == null) {
                    beginTransaction.add(2131296804, new FindFragment(), O0000Oo0);
                } else {
                    beginTransaction.show(fragment2);
                }
                this.O0000oOO.setSelected(false);
                break;
            case 10003:
                O00OO0O.O000000o(new PvDataInfo(20000, "dynamic_module_index"));
                O000000o(beginTransaction, fragment);
                O000000o(beginTransaction, fragment2);
                O000000o(beginTransaction, fragment4);
                O000000o(beginTransaction, fragment5);
                if (fragment3 == null) {
                    beginTransaction.add(2131296804, new DynamicMainFragment(), O0000Oo);
                } else {
                    beginTransaction.show(fragment3);
                }
                this.O0000oOO.setSelected(false);
                break;
            case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_ROLE_TYPE_ERROR /*10004*/:
                O000000o(beginTransaction, fragment);
                O000000o(beginTransaction, fragment2);
                O000000o(beginTransaction, fragment3);
                O000000o(beginTransaction, fragment5);
                if (fragment4 == null) {
                    beginTransaction.add(2131296804, new MineFragment(), O0000o);
                } else {
                    beginTransaction.show(fragment4);
                }
                this.O0000oOO.setSelected(false);
                break;
            case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_USER_ID_NULL /*10005*/:
                O00OO0O.O000000o(new PvDataInfoV29(70000, "commerce_module_index"));
                O000000o(beginTransaction, fragment);
                O000000o(beginTransaction, fragment2);
                O000000o(beginTransaction, fragment3);
                O000000o(beginTransaction, fragment4);
                if (fragment5 == null) {
                    beginTransaction.add(2131296804, new WelfareClubFragment(), O0000oO0);
                } else {
                    beginTransaction.show(fragment5);
                }
                this.O0000oOO.setSelected(true);
                break;
            default:
                break;
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public static native void O000000o(Activity activity);

    private native void O000000o(FragmentTransaction fragmentTransaction, Fragment fragment);

    private native void O000000o(ImageView imageView, Drawable[] drawableArr, int i, boolean z);

    private void O000000o(boolean z) {
        int i = 0;
        while (i < this.O0000oO.getTabCount()) {
            try {
                Tab tabAt = this.O0000oO.getTabAt(i);
                if (!(tabAt == null || ((Integer) tabAt.getTag()).intValue() != 10002 || tabAt.getCustomView() == null)) {
                    tabAt.getCustomView().findViewById(2131296644).setVisibility(z ? 0 : 8);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void O00000Oo(boolean z) {
        int i = 0;
        while (i < this.O0000oO.getTabCount()) {
            try {
                Tab tabAt = this.O0000oO.getTabAt(i);
                if (!(tabAt == null || ((Integer) tabAt.getTag()).intValue() != HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_ROLE_TYPE_ERROR || tabAt.getCustomView() == null)) {
                    tabAt.getCustomView().findViewById(2131296657).setVisibility(z ? 0 : 8);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private native void O00000oo();

    private void O0000O0o() {
        int screenWidth = DensityUtil.getScreenWidth() / 5;
        LayoutParams layoutParams = new LayoutParams(screenWidth, screenWidth);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = DensityUtil.dip2px(5.0f);
        this.O0000oOO.setLayoutParams(layoutParams);
        this.O0000oOO.setOnClickListener(new 3(this));
        List<MainBottomItemBean> O000000o = O0000o.O000000o(O0000o.O00000o, "newMainBottomModules", new 4(this).getType());
        if (!O000000o.isEmpty()) {
            Collections.sort(O000000o);
            for (MainBottomItemBean O000000o2 : O000000o) {
                try {
                    this.O0000oO.addTab(O000000o(O000000o2, null));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.O0000oO.addOnTabSelectedListener(new 5(this));
            O000000o(this.O0000ooo);
        }
    }

    private void O0000OOo() {
        int i = 0;
        while (i < this.O0000oO.getTabCount()) {
            try {
                Tab tabAt = this.O0000oO.getTabAt(i);
                if (tabAt == null || ((Integer) tabAt.getTag()).intValue() != HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_USER_ID_NULL) {
                    i++;
                } else {
                    Tab tabAt2 = this.O0000oO.getTabAt(i);
                    if (tabAt2 != null) {
                        tabAt2.select();
                        return;
                    }
                    return;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void O0000Oo0() {
        if (this.O00000oo == null) {
            this.O00000oo = (Vibrator) getApplicationContext().getSystemService("vibrator");
        }
        if (this.O00000oo != null) {
            this.O00000oo.vibrate(this.O0000O0o, 1);
        }
        this.O00000oO.postDelayed(new 8(this), 500);
    }

    public native int O000000o();

    public native void O000000o(HomePageInfo homePageInfo);

    public void O000000o(List<MainBottomItemBean> list) {
        for (int i = 0; i < list.size(); i++) {
            O000000o((MainBottomItemBean) list.get(i), null);
        }
    }

    public native void O00000Oo();

    public O000000o O00000o() {
        if (this.O0000oo == null) {
            this.O0000oo = new je(this, this.O0000o0);
        }
        return this.O0000oo;
    }

    public void O00000oO() {
        this.O0000ooo = ((Integer) O00O0Oo0.O00000o0(O00000o, Integer.valueOf(-1))).intValue();
        if (this.O0000ooo != -1) {
            int i = 0;
            while (i < this.O0000oO.getTabCount()) {
                try {
                    Tab tabAt = this.O0000oO.getTabAt(i);
                    if (tabAt == null || ((Integer) tabAt.getTag()).intValue() != this.O0000ooo) {
                        i++;
                    } else {
                        Tab tabAt2 = this.O0000oO.getTabAt(i);
                        if (tabAt2 != null) {
                            tabAt2.select();
                        }
                        O00O0Oo0.O000000o(O00000o);
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
            O00O0Oo0.O000000o(O00000o);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleRunDataChanged(MainDataEvt mainDataEvt) {
        if (mainDataEvt != null) {
            this.O0000ooO = Boolean.valueOf(mainDataEvt.isDataChange());
            if (mainDataEvt.getSelectedModuleId() > 0) {
                O00O0Oo0.O000000o(O00000o, Integer.valueOf(mainDataEvt.getSelectedModuleId()));
                O00000oO();
            }
        }
    }

    public void n_() {
        O00000o().O000000o();
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.O00oOooo > 2000) {
                O00Oo00.O000000o(this.O0000o0, 2131689742);
                this.O00oOooo = currentTimeMillis;
                return true;
            }
            O00000Oo.O00000Oo((Context) this);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public native void onResume();

    public native void onStop();
}
