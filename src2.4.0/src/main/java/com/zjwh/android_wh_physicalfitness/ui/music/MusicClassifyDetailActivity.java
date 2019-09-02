package com.zjwh.android_wh_physicalfitness.ui.music;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fq;
import defpackage.fq.O00000Oo;
import defpackage.hr;
import defpackage.jz;
import java.util.ArrayList;
import java.util.List;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MusicClassifyDetailActivity extends BaseActivity implements O00000Oo, hr.O00000Oo {
    public static final String O000000o = "extra_classify_id";
    public static final String O00000Oo = "extra_classify_name";
    private static final int O00000o = 1;
    private static final int O00000oO = 2;
    private static final int O00000oo = 3;
    @ViewInject(2131297158)
    public TextView O00000o0;
    @ViewInject(2131296740)
    private ImageView O0000O0o;
    @ViewInject(2131296974)
    private TextView O0000OOo;
    @ViewInject(2131297472)
    private ViewPager O0000Oo;
    @ViewInject(2131297127)
    private TabLayout O0000Oo0;
    @ViewInject(2131297204)
    private TextView O0000o;
    @ViewInject(2131297299)
    private TextView O0000oO;
    @ViewInject(2131297240)
    private TextView O0000oO0;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000oOO;
    @ViewInject(2131296774)
    private LinearLayout O0000oOo;
    @ViewInject(2131296920)
    private View O0000oo;
    @ViewInject(2131296635)
    private ImageView O0000oo0;
    @ViewInject(2131297260)
    private TextView O0000ooO;
    private defpackage.hr.O000000o O0000ooo;
    private PopupWindow O000O00o;
    private boolean O000O0OO = false;
    private fq O000O0Oo;
    private List<String> O00oOooO = new ArrayList();
    private O000000o O00oOooo;

    class O000000o extends FragmentStatePagerAdapter {
        O000000o(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public int getCount() {
            return MusicClassifyDetailActivity.this.O00oOooO == null ? 0 : MusicClassifyDetailActivity.this.O00oOooO.size();
        }

        public Fragment getItem(int i) {
            return AlbumFragment.O000000o(MusicClassifyDetailActivity.this.O0000Oo0().O00000o0(), (String) MusicClassifyDetailActivity.this.O00oOooO.get(i), MusicClassifyDetailActivity.this.O0000Oo0().O00000Oo());
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public CharSequence getPageTitle(int i) {
            return (CharSequence) MusicClassifyDetailActivity.this.O00oOooO.get(i);
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, i);
        }
    }

    static {
        C.i(16777346);
    }

    public static native void O000000o(Activity activity, long j, String str);

    private native void O00000Oo(int i);

    private defpackage.hr.O000000o O0000Oo0() {
        if (this.O0000ooo == null) {
            this.O0000ooo = new jz(this, this.O0000o0);
        }
        return this.O0000ooo;
    }

    private native void O0000o0();

    private native void O0000o0O();

    public native int O000000o();

    public native void O000000o(int i);

    public void O000000o(List<String> list, long j) {
        if (!isFinishing()) {
            this.O0000oOO.O000000o();
            this.O00oOooO = list;
            if (j != -2) {
                this.O0000oOo.setVisibility(0);
                O00000Oo(1);
            } else {
                this.O0000oOo.setVisibility(8);
                this.O00oOooo.notifyDataSetChanged();
            }
            this.O0000Oo.setCurrentItem(0);
            this.O0000oo0.setEnabled(true);
            O0000Oo0().O000000o((String) this.O00oOooO.get(0));
            this.O000O0Oo.O000000o((List) list);
        }
    }

    public native void O00000Oo();

    public native void O00000o();

    public void O00000oO() {
        if (!isFinishing()) {
            getWindow().setBackgroundDrawableResource(R.color.window_background);
            this.O0000oOO.O000000o(null, getString(R.string.txt_music_error), getString(R.string.txt_music_reload), "", new OnClickListener() {
                public void onClick(View view) {
                    MusicClassifyDetailActivity.this.O0000Oo0().O00000o();
                }
            });
        }
    }

    public native void O00000oo();

    public native void O0000O0o();

    public native void O0000OOo();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        getWindow().setBackgroundDrawableResource(R.color.white);
        super.onCreate(bundle);
        defpackage.hr.O000000o O0000Oo0 = O0000Oo0();
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        O0000Oo0.O000000o(bundle);
        if (!isFinishing()) {
            O0000o0O();
            O0000Oo0().O00000o();
        }
    }

    public native void onDestroy();

    public native void onNewIntent(Intent intent);

    public native void onSaveInstanceState(Bundle bundle);
}
