package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.AllSemesterRunInfo;
import com.zjwh.android_wh_physicalfitness.entity.BannerBean;
import com.zjwh.android_wh_physicalfitness.entity.HistoryRefresh;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfo;
import com.zjwh.android_wh_physicalfitness.entity.SingleSemesterRunInfo;
import com.zjwh.android_wh_physicalfitness.entity.UploadEntity;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O0000OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.VpSwipeRefreshLayout;
import com.zjwh.android_wh_physicalfitness.view.banner.DecentBanner;
import com.zjwh.android_wh_physicalfitness.view.banner.O000000o;
import com.zjwh.android_wh_physicalfitness.view.banner.O000000o$O00000Oo;
import com.zjwh.android_wh_physicalfitness.view.banner.O00000o;
import defpackage.ew$O00000o0;
import defpackage.hj$O00000Oo;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class RunHistoryActivity extends BaseActivity implements O000000o$O00000Oo, ew$O00000o0, hj$O00000Oo {
    @ViewInject(2131296949)
    public VpSwipeRefreshLayout O000000o;
    @ViewInject(2131296942)
    public RecyclerView O00000Oo;
    @ViewInject(2131297043)
    private RecyclerView O00000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o0;
    @ViewInject(2131296467)
    private DrawerLayout O00000oO;
    @ViewInject(2131297339)
    private TextView O00000oo;
    @ViewInject(2131296679)
    private ImageView O0000O0o;
    @ViewInject(2131297464)
    private View O0000OOo;
    @ViewInject(2131296303)
    private AppBarLayout O0000Oo;
    @ViewInject(2131296788)
    private LinearLayout O0000Oo0;
    @ViewInject(2131296538)
    private DecentBanner O0000o;
    private es O0000oO;
    private ew O0000oO0;
    private O00000o0 O0000oOO;
    private O00000Oo O0000oOo;
    private O000000o O0000oo;
    private OnOffsetChangedListener O0000oo0;

    static {
        C.i(47);
    }

    public static native void O000000o(Activity activity);

    private native void O0000o();

    private void O0000o0O() {
        this.O0000oo0 = new 1(this);
        this.O0000Oo.addOnOffsetChangedListener(this.O0000oo0);
        this.O000000o.setColorSchemeResources(new int[]{2131099885, 2131099770, 2131099682, 2131099771});
        this.O000000o.setOnRefreshListener(new 2(this));
        this.O000000o.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.O0000O0o.setOnClickListener(new 3(this));
        this.O00000oO.setDrawerLockMode(1);
        int screenWidth = (DensityUtil.getScreenWidth() * 56) / 75;
        int dip2px = DensityUtil.dip2px(320.0f);
        if (screenWidth >= dip2px) {
            screenWidth = dip2px;
        }
        this.O0000Oo0.setLayoutParams(new LayoutParams(screenWidth, -1, GravityCompat.END));
    }

    private native void O0000o0o();

    private native void O0000oO0();

    @Event(type = OnMenuItemClickListener.class, value = {2131297163})
    private boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == 2131296281 && !this.O00000oO.isDrawerOpen((int) GravityCompat.END)) {
            this.O00000oO.openDrawer((int) GravityCompat.END);
        }
        return true;
    }

    public native int O000000o();

    public void O000000o(AllSemesterRunInfo allSemesterRunInfo) {
        this.O00000oo.setText(getString(2131689832, new Object[]{Integer.valueOf(allSemesterRunInfo.getTotalDays()), O00Oo0.O00000o0(((double) allSemesterRunInfo.getTotalDis()) / 1000.0d)}));
    }

    public void O000000o(ResponseError responseError) {
        this.O00000o0.O000000o(null, getString(2131689986), responseError.getMessage(), "", new 5(this));
    }

    public native void O000000o(SemesterInfo semesterInfo);

    public void O000000o(SingleSemesterRunInfo singleSemesterRunInfo) {
        this.O00000oo.setText(getString(2131689833, new Object[]{singleSemesterRunInfo.getSname(), O00Oo0.O00000o0(((double) singleSemesterRunInfo.getSemesterDis()) / 1000.0d), O00Oo0.O00000o0(((double) singleSemesterRunInfo.getSemesterValidDis()) / 1000.0d)}));
    }

    public native void O000000o(O000000o o000000o);

    public void O000000o(List<SemesterInfo> list) {
        if (list != null && list.size() > 0) {
            this.O0000oO0.O000000o(list);
        }
    }

    public void O000000o(List<UploadEntity> list, boolean z) {
        this.O00000o0.O000000o();
        if (this.O0000oO != null) {
            this.O0000oO.O000000o(list);
            if (z) {
                O0000O0o.O000000o(this.O00000Oo, LoadingFooter.O000000o.O000000o);
            } else {
                this.O0000oOO.O00000o(this.O0000oOO.O00000Oo());
            }
        }
    }

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public void O00000Oo(List<BannerBean> list) {
        if (list == null || list.size() <= 0) {
            this.O0000o.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            O00000o o00000o = new O00000o(this.O0000o0);
            BannerBean bannerBean = (BannerBean) list.get(i);
            if (bannerBean != null) {
                O0000OOo.O000000o(o00000o, bannerBean, i);
                o00000o.O000000o(this);
                arrayList.add(o00000o);
                if (i < 3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("exposure_");
                    stringBuilder.append(bannerBean.getId());
                    O00OO0O.O000000o(new PvDataInfoV29(110001, stringBuilder.toString()));
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("exposure");
                    stringBuilder2.append(i);
                    stringBuilder2.append("_");
                    stringBuilder2.append(bannerBean.getId());
                    O00Oo00o.O000000o(this, "run_record", stringBuilder2.toString());
                }
            }
        }
        this.O0000o.O000000o(arrayList);
        this.O0000o.setVisibility(0);
    }

    public native void O00000Oo(boolean z);

    public native void O00000o();

    public native void O00000o0(boolean z);

    public native void O00000oO();

    public native void O00000oo();

    public native void O0000O0o();

    public native void O0000OOo();

    public native void O0000Oo0();

    public O000000o O0000o0() {
        if (this.O0000oo == null) {
            this.O0000oo = new jt(this);
        }
        return this.O0000oo;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handlerRefresh(HistoryRefresh historyRefresh) {
        if (historyRefresh != null && historyRefresh.isDataChanged()) {
            O0000o0().O000000o(false);
            O0000o0().O000000o(1);
            O0000o0().O000000o(false, this.O0000o0);
        }
    }

    public void n_() {
        O0000o0().O000000o();
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O00Oo00o.O000000o(this.O0000o0, "run_record", "exposure");
        org.greenrobot.eventbus.O00000o0.O000000o().O000000o(this);
        O0000o0O();
        O0000o0o();
        O0000o0().O000000o(this.O0000o0);
        O0000o0().O000000o(true, this.O0000o0);
    }

    public native boolean onCreateOptionsMenu(Menu menu);

    public native void onDestroy();

    public native void onPause();

    public native void onResume();
}
