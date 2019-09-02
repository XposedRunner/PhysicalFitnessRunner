package com.zjwh.android_wh_physicalfitness.ui.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.MultiImageSelectorActivity;
import com.zjwh.android_wh_physicalfitness.activity.find.DynamicPublishActivity;
import com.zjwh.android_wh_physicalfitness.activity.find.TopicActivity;
import com.zjwh.android_wh_physicalfitness.entity.DynamicMainHeadBean;
import com.zjwh.android_wh_physicalfitness.entity.DynamicTabBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.view.PagerSlidingTabStrip;
import defpackage.fd;
import defpackage.gr.O00000Oo;
import defpackage.jm;
import java.util.ArrayList;
import java.util.List;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

@ContentView(2131427511)
public class DynamicMainFragment extends BaseFragment implements O00000Oo {
    public static final String O000000o = "extra_hot_dynamic_v2";
    public static final int O00000oo = 0;
    public static final int O0000O0o = 1;
    public static final int O0000OOo = 2;
    public static final int O0000Oo0 = 3;
    @ViewInject(2131297158)
    public TextView O0000Oo;
    @ViewInject(2131296734)
    private View O0000OoO;
    @ViewInject(2131297139)
    private PagerSlidingTabStrip O0000Ooo;
    @ViewInject(2131296945)
    private RecyclerView O0000o;
    @ViewInject(2131296740)
    private ImageView O0000o0;
    @ViewInject(2131296876)
    private ViewPager O0000o00;
    @ViewInject(2131296974)
    private TextView O0000o0O;
    @ViewInject(2131296982)
    private RelativeLayout O0000o0o;
    private fd O0000oO;
    private defpackage.gr.O000000o O0000oO0;

    private class O000000o extends FragmentPagerAdapter {
        O000000o(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return 4;
        }

        public Fragment getItem(int i) {
            switch (i) {
                case 1:
                    i = 3;
                    break;
                case 2:
                    i = 7;
                    break;
                case 3:
                    i = 6;
                    break;
                default:
                    i = 5;
                    break;
            }
            return DynamicFragment.O000000o(i, -1, 0);
        }

        public long getItemId(int i) {
            return (long) i;
        }
    }

    static {
        C.i(16777319);
    }

    private native void O000000o(boolean z);

    private defpackage.gr.O000000o O00000o() {
        if (this.O0000oO0 == null) {
            this.O0000oO0 = new jm(this);
        }
        return this.O0000oO0;
    }

    private List<DynamicTabBean> O00000oO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DynamicTabBean(getString(R.string.dynamic_top_hot)));
        arrayList.add(new DynamicTabBean(getString(R.string.dynamic_top_school)));
        arrayList.add(new DynamicTabBean(R.drawable.dynamic_tab_sport, R.drawable.dynamic_tab_sport));
        arrayList.add(new DynamicTabBean(getString(R.string.dynamic_top_attention)));
        return arrayList;
    }

    @Event({2131296974, 2131297234})
    private void onClick(View view) {
        int id = view.getId();
        if (id == R.id.right_text) {
            O00O00o.O00000Oo((Fragment) this);
        } else if (id == R.id.tvMore) {
            TopicActivity.O000000o(getActivity());
        }
    }

    @Event(type = OnLongClickListener.class, value = {2131296974})
    private boolean onTopLongClick(View view) {
        DynamicPublishActivity.O000000o(this);
        return false;
    }

    public native void O000000o();

    public void O000000o(List<DynamicMainHeadBean> list) {
        this.O0000o0o.setVisibility(0);
        this.O0000oO.O000000o(list);
    }

    @PermissionSuccess(requestCode = 100)
    public void O00000Oo() {
        O00O0o0.O000000o((Fragment) this, 9, 1);
    }

    @PermissionFail(requestCode = 100)
    public void O00000o0() {
        O00O00o.O000000o(getContext(), 100);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        O000000o(false);
        O00000o().O000000o(getContext());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i != 1000) {
            switch (i) {
                case 0:
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra(MultiImageSelectorActivity.O00000o);
                    DynamicPublishActivity.O000000o(this, stringArrayListExtra, O00O0O0o.O000000o((String) stringArrayListExtra.get(0)));
                    return;
                case 1:
                    String string = PreferenceManager.getDefaultSharedPreferences(getContext()).getString(O00O0O0o.O00000Oo, null);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(string);
                    DynamicPublishActivity.O000000o(this, arrayList, O00O0O0o.O000000o(string));
                    return;
                default:
                    return;
            }
        }
        this.O0000o00.setCurrentItem(1);
    }

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDestroy();

    public native void onHiddenChanged(boolean z);

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onResume();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000Oo.setText("动态");
        this.O0000o0.setVisibility(8);
        this.O0000o0O.setVisibility(0);
        this.O0000o0O.setText("发布");
        this.O0000o0O.setTextSize(13.0f);
        this.O0000o00.setAdapter(new O000000o(getChildFragmentManager()));
        this.O0000o00.setOffscreenPageLimit(4);
        this.O0000Ooo.setItems(O00000oO());
        this.O0000Ooo.setViewPager(this.O0000o00);
        this.O0000o0o.setVisibility(8);
        this.O0000o.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.O0000o.setNestedScrollingEnabled(false);
        this.O0000o.setHasFixedSize(true);
        this.O0000oO = new fd();
        this.O0000o.setAdapter(this.O0000oO);
        this.O0000o00.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                String str = "dynamic_";
                StringBuilder stringBuilder;
                switch (i) {
                    case 0:
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("hot");
                        str = stringBuilder.toString();
                        break;
                    case 1:
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("same_school");
                        str = stringBuilder.toString();
                        break;
                    case 2:
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("sports_mood");
                        str = stringBuilder.toString();
                        break;
                    case 3:
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("follow");
                        str = stringBuilder.toString();
                        break;
                }
                O00OO0O.O000000o(new PvDataInfoV29(40000, str));
            }
        });
    }
}
