package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.DynamicTabBean;
import com.zjwh.android_wh_physicalfitness.view.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class SportCampusActivity extends BaseActivity {
    @ViewInject(2131297139)
    private PagerSlidingTabStrip O000000o;
    @ViewInject(2131296876)
    private ViewPager O00000Oo;

    private class O000000o extends FragmentPagerAdapter {
        O000000o(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return 2;
        }

        public Fragment getItem(int i) {
            return SportConcernFansFragment.O00000Oo(i == 0 ? 2 : 1);
        }
    }

    static {
        C.i(16777341);
    }

    public static native void O000000o(Activity activity);

    private List<DynamicTabBean> O00000o() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DynamicTabBean("关注"));
        arrayList.add(new DynamicTabBean("粉丝"));
        return arrayList;
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.O00000Oo.setAdapter(new O000000o(getSupportFragmentManager()));
        this.O000000o.setItems(O00000o());
        this.O000000o.setViewPager(this.O00000Oo);
    }
}
