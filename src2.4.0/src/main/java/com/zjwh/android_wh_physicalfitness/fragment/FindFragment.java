package com.zjwh.android_wh_physicalfitness.fragment;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.zjwh.android_wh_physicalfitness.activity.find.ActivitiesActivity;
import com.zjwh.android_wh_physicalfitness.activity.find.ArticleActivity;
import com.zjwh.android_wh_physicalfitness.activity.find.TopicActivity;
import com.zjwh.android_wh_physicalfitness.entity.BannerBean;
import com.zjwh.android_wh_physicalfitness.entity.DiscoverModuleBean;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.ArticleRefreshEvt;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.NoticeHasNewEvt;
import com.zjwh.android_wh_physicalfitness.entity.NoticeListBean;
import com.zjwh.android_wh_physicalfitness.entity.TopicBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfo;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.ui.notice.NoticeListActivity;
import com.zjwh.android_wh_physicalfitness.utils.O0000OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00OOOo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.UpDownTextSwitcher;
import com.zjwh.android_wh_physicalfitness.view.banner.DecentBanner;
import com.zjwh.android_wh_physicalfitness.view.banner.O000000o;
import com.zjwh.android_wh_physicalfitness.view.banner.O000000o$O00000Oo;
import com.zjwh.android_wh_physicalfitness.view.banner.O00000o0;
import defpackage.gu$O00000Oo;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

@ContentView(2131427512)
public class FindFragment extends BaseFragment implements O000000o$O00000Oo, gu$O00000Oo {
    @ViewInject(2131297108)
    private SwipeRefreshLayout O000000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000oo;
    @ViewInject(2131297060)
    private NestedScrollView O0000O0o;
    @ViewInject(2131297037)
    private RecyclerView O0000OOo;
    @ViewInject(2131296551)
    private RecyclerView O0000Oo;
    @ViewInject(2131296541)
    private DecentBanner O0000Oo0;
    @ViewInject(2131297034)
    private RecyclerView O0000OoO;
    @ViewInject(2131297093)
    private UpDownTextSwitcher O0000Ooo;
    private fa O0000o;
    @ViewInject(2131296659)
    private ImageView O0000o0;
    @ViewInject(2131296784)
    private LinearLayout O0000o00;
    @ViewInject(2131296843)
    private RecyclerView O0000o0O;
    private O000000o O0000o0o;
    private fb O0000oO;
    private ez O0000oO0;
    private ea O0000oOO;
    private long O0000oOo;
    private long O0000oo0;

    static {
        C.i(44);
    }

    private void O00000o(List<BannerBean> list) {
        if (list == null || list.size() <= 0) {
            this.O0000Oo0.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            O00000o0 o00000o0 = new O00000o0(getActivity());
            BannerBean bannerBean = (BannerBean) list.get(i);
            if (bannerBean != null) {
                O0000OOo.O000000o(o00000o0, bannerBean, i);
                o00000o0.O000000o(this);
                arrayList.add(o00000o0);
                if (!TextUtils.isEmpty(bannerBean.getAdExposingCodes())) {
                    com.zjwh.android_wh_physicalfitness.utils.O00000o0.O00000Oo(bannerBean.getAdExposingCodes());
                }
                if (i < 3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("exposure_");
                    stringBuilder.append(bannerBean.getId());
                    O00OO0O.O000000o(new PvDataInfoV29(110000, stringBuilder.toString()));
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("exposure");
                    stringBuilder.append(i);
                    stringBuilder.append("_");
                    stringBuilder.append(bannerBean.getId());
                    O00Oo00o.O000000o(getActivity(), "topbanner", stringBuilder.toString());
                }
            }
        }
        this.O0000Oo0.O000000o(arrayList);
        this.O0000Oo0.setVisibility(0);
    }

    private O000000o O0000OOo() {
        if (this.O0000o0o == null) {
            this.O0000o0o = new ja(this);
        }
        return this.O0000o0o;
    }

    private void O0000Oo0() {
        this.O0000oo0 = SystemClock.elapsedRealtime();
        int i = ((int) (this.O0000oo0 - this.O0000oOo)) / 1000;
        if (i > 0) {
            O00OO0O.O00000Oo(new PvDataInfo(10000, "find_module_index", i));
        }
    }

    @Event({2131296549, 2131296540, 2131296539, 2131297378})
    private void onClick(View view) {
        switch (view.getId()) {
            case 2131296539:
                if (this.O0000oO0 != null) {
                    this.O0000oO0.O000000o();
                }
                O00OO0O.O000000o(new PvDataInfo(40003, "more"));
                ActivitiesActivity.O000000o(getActivity());
                return;
            case 2131296540:
                if (this.O0000o != null) {
                    this.O0000o.O000000o();
                }
                O00OO0O.O000000o(new PvDataInfo(40002, "more"));
                ArticleActivity.O000000o(getActivity());
                return;
            case 2131296549:
                if (this.O0000oO != null) {
                    this.O0000oO.O000000o();
                }
                O00OO0O.O000000o(new PvDataInfo(40001, "more"));
                TopicActivity.O000000o(getActivity());
                return;
            case 2131297378:
                NoticeListActivity.O000000o(getActivity());
                return;
            default:
                return;
        }
    }

    public native void O000000o();

    public void O000000o(O000000o o000000o) {
        O000000o(O0000OOo.O000000o(getActivity(), o000000o.O0000Oo()));
        if (o000000o.O0000Ooo() < 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("click_");
            stringBuilder.append(o000000o.O0000Oo());
            O00OO0O.O000000o(new PvDataInfoV29(110000, stringBuilder.toString()));
            stringBuilder = new StringBuilder();
            stringBuilder.append("click");
            stringBuilder.append(o000000o.O0000Ooo());
            stringBuilder.append("_");
            stringBuilder.append(o000000o.O0000Oo());
            O00Oo00o.O000000o(getActivity(), "topbanner", stringBuilder.toString());
        }
        O0000OOo.O000000o(getActivity(), o000000o.O0000OoO(), o000000o.O00000oo(), o000000o.O000000o());
        switch (o000000o.O000000o()) {
            case 1:
                if (this.O0000o != null) {
                    this.O0000o.O000000o();
                    return;
                }
                return;
            case 2:
                if (this.O0000oO != null) {
                    this.O0000oO.O000000o();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void O000000o(List<BannerBean> list) {
        if (O0000Ooo()) {
            O00000o(list);
        }
    }

    public void O000000o(List<BannerBean> list, List<TopicBean> list2, List<DiscoverModuleBean> list3) {
        O00000o(list);
        O00000Oo((List) list2);
        O00000o();
        O0000O0o();
        O00000o0((List) list3);
    }

    public void O000000o(List<NoticeListBean> list, boolean z) {
        if (list == null || list.size() <= 0) {
            O00000Oo();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (NoticeListBean title : list) {
            arrayList.add(title.getTitle());
        }
        this.O0000Ooo.setMessage(arrayList);
        this.O0000Ooo.setText((CharSequence) arrayList.get(0));
        this.O0000Ooo.setTag(Integer.valueOf(0));
        if (list.size() > 1) {
            this.O0000Ooo.setCurPosition(1);
            this.O0000Ooo.O000000o();
        } else {
            this.O0000Ooo.O00000Oo();
        }
        this.O0000Ooo.setOnClickListener(new 5(this, list));
        notifyNoticeIcon(new NoticeHasNewEvt(z));
        this.O0000o00.setVisibility(0);
    }

    public native void O00000Oo();

    public void O00000Oo(List<TopicBean> list) {
        if (O0000Ooo() && list != null && !list.isEmpty()) {
            if (this.O0000oO == null) {
                this.O0000oO = new fb();
                this.O0000oO.O000000o(new 3(this));
                this.O0000Oo.setAdapter(this.O0000oO);
            }
            int i = 0;
            this.O0000oO.O000000o(list.size() > 2 ? list.subList(0, 2) : list);
            while (i < list.size()) {
                if (i < 2) {
                    TopicBean topicBean = (TopicBean) list.get(i);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("exposure_");
                    stringBuilder.append(topicBean.getId());
                    O00OO0O.O000000o(new PvDataInfoV29(10002, stringBuilder.toString()));
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("exposure");
                    stringBuilder.append(i);
                    stringBuilder.append("_");
                    stringBuilder.append(topicBean.getId());
                    O00Oo00o.O000000o(getActivity(), "ex_topic", stringBuilder.toString());
                }
                i++;
            }
        }
    }

    public native void O00000o();

    public native void O00000o0();

    public void O00000o0(List<DiscoverModuleBean> list) {
        if (O0000Ooo()) {
            this.O0000oOO.O000000o(list);
        }
    }

    public void O00000oO() {
        if (O0000Ooo()) {
            this.O00000oo.O000000o(null, getString(2131689986), getString(2131689761), "", new 4(this));
        }
    }

    public native void O00000oo();

    public native void O0000O0o();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handlerRefresh(ArticleRefreshEvt articleRefreshEvt) {
        if (articleRefreshEvt != null && articleRefreshEvt.isDataChanged()) {
            O0000OOo().O00000Oo();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void notifyNoticeIcon(NoticeHasNewEvt noticeHasNewEvt) {
        ImageView imageView = this.O0000o0;
        int i = (noticeHasNewEvt == null || !noticeHasNewEvt.isHasNew()) ? 2131230936 : 2131231079;
        imageView.setImageResource(i);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        O00OOOo.O00000o0(getActivity(), null);
        O0000OOo().O000000o();
        O0000OOo().O00000o0(getActivity());
    }

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDestroy();

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            O0000Oo0();
            return;
        }
        O00OOOo.O00000o0(getActivity(), null);
        this.O0000oOo = SystemClock.elapsedRealtime();
    }

    public native void onPause();

    public void onResume() {
        super.onResume();
        this.O0000oOo = SystemClock.elapsedRealtime();
        this.O0000Oo0.O000000o();
        this.O0000Ooo.O000000o();
    }

    public native void onStop();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O000000o.setColorSchemeResources(2131099885, 2131099770, 2131099682, 2131099771);
        this.O000000o.setOnRefreshListener(new 1(this));
        this.O000000o.setProgressViewOffset(false, 0, DensityUtil.dip2px(24.0f));
        this.O0000OOo.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.O0000OOo.addItemDecoration(new O00O0Oo(2, DensityUtil.dip2px(8.0f), false));
        this.O0000OOo.setNestedScrollingEnabled(false);
        this.O0000Oo.setLayoutManager(new LinearLayoutManager(getContext()));
        this.O0000Oo.addItemDecoration(new com.zjwh.android_wh_physicalfitness.view.O000000o(DensityUtil.dip2px(8.0f)));
        this.O0000Oo.setNestedScrollingEnabled(false);
        this.O0000OoO.setLayoutManager(new LinearLayoutManager(getContext()));
        this.O0000OoO.addItemDecoration(new com.zjwh.android_wh_physicalfitness.view.O000000o(DensityUtil.dip2px(8.0f)));
        this.O0000OoO.setNestedScrollingEnabled(false);
        this.O0000oOO = new ea();
        this.O0000o0O.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.O0000o0O.setNestedScrollingEnabled(false);
        this.O0000o0O.setAdapter(this.O0000oOO);
        this.O0000O0o.setOnScrollChangeListener(new 2(this));
    }
}
