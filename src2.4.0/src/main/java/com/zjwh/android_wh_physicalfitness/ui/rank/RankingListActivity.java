package com.zjwh.android_wh_physicalfitness.ui.rank;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import java.util.ArrayList;
import java.util.List;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class RankingListActivity extends BaseActivity implements OnPageChangeListener {
    public static final String O000000o = "extra_index";
    @ViewInject(2131297472)
    private ViewPager O00000Oo;
    private List<Fragment> O00000o = new ArrayList();
    @ViewInject(2131297127)
    private TabLayout O00000o0;
    private String O00000oO = "";
    private int O00000oo = 0;

    private class O000000o extends FragmentPagerAdapter {
        private List<Fragment> O00000Oo;

        O000000o(FragmentManager fragmentManager, List<Fragment> list) {
            super(fragmentManager);
            this.O00000Oo = list;
        }

        public int getCount() {
            return this.O00000Oo == null ? 0 : this.O00000Oo.size();
        }

        public Fragment getItem(int i) {
            return (Fragment) this.O00000Oo.get(i);
        }

        public CharSequence getPageTitle(int i) {
            return i == 1 ? "院系榜" : i == 2 ? "作弊黑榜" : "个人榜";
        }
    }

    static {
        C.i(16777356);
    }

    public static native void O000000o(Activity activity, String str);

    public static native void O000000o(Activity activity, String str, int i);

    private native void O000000o(Bundle bundle);

    private native void O00000oo();

    public native int O000000o();

    public native void O00000Oo();

    @PermissionSuccess(requestCode = 101)
    public void O00000o() {
        CheatReportActivity.O000000o((Activity) this);
    }

    @PermissionFail(requestCode = 101)
    public void O00000oO() {
        O00O00o.O000000o(this, 101);
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        if (!isFinishing()) {
            O00000oo();
        }
    }

    public native void onPageScrollStateChanged(int i);

    public native void onPageScrolled(int i, float f, int i2);

    public native void onPageSelected(int i);

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onSaveInstanceState(Bundle bundle);
}
