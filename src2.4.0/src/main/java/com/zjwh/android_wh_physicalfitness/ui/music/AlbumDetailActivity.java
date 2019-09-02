package com.zjwh.android_wh_physicalfitness.ui.music;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ximalaya.ting.android.opensdk.model.track.TrackList;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.utils.O00OOOo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0o0;
import defpackage.hn.O00000Oo;
import defpackage.jv;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class AlbumDetailActivity extends BaseActivity implements O00000Oo {
    public static final String O000000o = "extra_album_id";
    public static final String O00000Oo = "extra_album_name";
    public static final String O00000o = "extra_album_count";
    public static final String O00000o0 = "extra_album_paid";
    @ViewInject(2131297158)
    public TextView O00000oO;
    @ViewInject(2131296740)
    private ImageView O00000oo;
    @ViewInject(2131297127)
    private TabLayout O0000O0o;
    @ViewInject(2131297472)
    private ViewPager O0000OOo;
    @ViewInject(2131296628)
    private ImageView O0000Oo;
    @ViewInject(2131296629)
    private ImageView O0000Oo0;
    @ViewInject(2131297190)
    private TextView O0000o;
    @ViewInject(2131296734)
    private View O0000oO;
    @ViewInject(2131297188)
    private TextView O0000oO0;
    @ViewInject(2131296305)
    private AppBarLayout O0000oOO;
    @ViewInject(2131297165)
    private CollapsingToolbarLayout O0000oOo;
    @ViewInject(2131296976)
    private RelativeLayout O0000oo;
    @ViewInject(2131297160)
    private View O0000oo0;
    @ViewInject(2131297193)
    private TextView O0000ooO;
    private defpackage.hn.O000000o O0000ooo;
    private O00Oo0o0 O00oOooO;

    class O000000o extends FragmentPagerAdapter {
        O000000o(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return 2;
        }

        public Fragment getItem(int i) {
            return i == 0 ? AlbumIntroFragment.O000000o(AlbumDetailActivity.this.O00000oo().O00000o()) : AlbumListFragment.O000000o(AlbumDetailActivity.this.O00000oo().O00000o0(), AlbumDetailActivity.this.O00000oo().O00000o(), AlbumDetailActivity.this.O00000oo().O000000o(), AlbumDetailActivity.this.O00000oo().O00000Oo());
        }

        public CharSequence getPageTitle(int i) {
            return i == 0 ? "简介" : "音乐列表";
        }
    }

    static {
        C.i(16777343);
    }

    public static native void O000000o(Activity activity, long j, String str, boolean z, long j2);

    private defpackage.hn.O000000o O00000oo() {
        if (this.O0000ooo == null) {
            this.O0000ooo = new jv(this);
        }
        return this.O0000ooo;
    }

    private native void O0000O0o();

    private native void O0000OOo();

    public native int O000000o();

    public native void O000000o(TrackList trackList);

    public native void O000000o(boolean z, double d);

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public void n_() {
        if (VERSION.SDK_INT < 19) {
            this.O0000oOo.setMinimumHeight(DensityUtil.dip2px(45.0f));
        } else {
            this.O0000oOo.setMinimumHeight(DensityUtil.dip2px(45.0f) + O00OOOo.O000000o((Context) this));
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O00OOOo.O000000o((Activity) this, 0, this.O0000oO);
        defpackage.hn.O000000o O00000oo = O00000oo();
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        O00000oo.O000000o(bundle);
        if (!isFinishing()) {
            O0000O0o();
            O0000OOo();
        }
    }

    public native void onSaveInstanceState(Bundle bundle);
}
