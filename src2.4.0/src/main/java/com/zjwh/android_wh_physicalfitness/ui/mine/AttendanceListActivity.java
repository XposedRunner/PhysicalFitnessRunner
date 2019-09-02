package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.AttendanceListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfo;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.ds;
import defpackage.ew;
import defpackage.gn.O000000o;
import defpackage.gn.O00000Oo;
import defpackage.is;
import java.util.List;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class AttendanceListActivity extends BaseActivity implements O00000Oo {
    @ViewInject(2131297158)
    public TextView O000000o;
    @ViewInject(2131296942)
    public RecyclerView O00000Oo;
    @ViewInject(2131296974)
    private TextView O00000o;
    @ViewInject(2131296740)
    private ImageView O00000o0;
    @ViewInject(2131297132)
    private TextView O00000oO;
    @ViewInject(2131297135)
    private TextView O00000oo;
    @ViewInject(2131297138)
    private TextView O0000O0o;
    @ViewInject(2131297131)
    private View O0000OOo;
    @ViewInject(2131297137)
    private View O0000Oo;
    @ViewInject(2131297134)
    private View O0000Oo0;
    @ViewInject(2131296467)
    private DrawerLayout O0000o;
    @ViewInject(2131296788)
    private LinearLayout O0000oO;
    @ViewInject(2131297043)
    private RecyclerView O0000oO0;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000oOO;
    private ew O0000oOo;
    private O000000o O0000oo;
    private ds O0000oo0;
    private O00000o0 O0000ooO;
    private int O0000ooo;

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.mine.AttendanceListActivity$6 */
    class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;

        AnonymousClass6(int i, int i2) {
            this.O000000o = i;
            this.O00000Oo = i2;
        }

        public void onClick(View view) {
            O0000O0o.O000000o(AttendanceListActivity.this, AttendanceListActivity.this.O00000Oo, 20, LoadingFooter.O000000o.Loading, null);
            AttendanceListActivity.this.O0000O0o().O000000o(AttendanceListActivity.this.O0000o0, this.O000000o, this.O00000Oo);
        }
    }

    static {
        C.i(16777327);
    }

    private native int O000000o(int i);

    public static native void O000000o(Activity activity);

    private native void O0000OOo();

    @Event({2131297130, 2131297133, 2131297136})
    private void changeTab(View view) {
        if (this.O0000ooo != view.getId()) {
            O0000O0o().O000000o(this, O000000o(view.getId()), O0000O0o().O00000o0());
        }
    }

    @Event({2131296679})
    private void click(View view) {
        if (view.getId() == R.id.iv_cancel && this.O0000o.isDrawerOpen(8388613)) {
            this.O0000o.closeDrawer(8388613);
        }
    }

    public native int O000000o();

    public native void O000000o(int i, int i2, String str);

    public void O000000o(ResponseError responseError, final int i, final int i2) {
        if (!isFinishing()) {
            this.O0000oOO.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    AttendanceListActivity.this.O0000O0o().O000000o(AttendanceListActivity.this.O0000o0, i, i2);
                }
            });
        }
    }

    public void O000000o(List<SemesterInfo> list) {
        this.O0000oO0.setLayoutManager(new LinearLayoutManager(this));
        this.O0000oOo = new ew(new O00000o0() {
            public void O000000o(SemesterInfo semesterInfo) {
                if (AttendanceListActivity.this.O0000o.isDrawerOpen(8388613)) {
                    AttendanceListActivity.this.O0000o.closeDrawer(8388613);
                }
                if (semesterInfo.getSid() != AttendanceListActivity.this.O0000O0o().O00000o0()) {
                    AttendanceListActivity.this.O0000O0o().O000000o(semesterInfo);
                    AttendanceListActivity.this.O0000O0o().O000000o(AttendanceListActivity.this, semesterInfo.getSid());
                    AttendanceListActivity.this.O0000O0o().O000000o(AttendanceListActivity.this, AttendanceListActivity.this.O0000O0o().O00000Oo(), semesterInfo.getSid());
                }
            }
        });
        this.O0000oOo.O000000o((List) list);
        this.O0000oO0.setAdapter(this.O0000oOo);
    }

    public native void O000000o(boolean z);

    public void O000000o(boolean z, List<AttendanceListBean> list) {
        this.O0000oOO.O000000o();
        if (z) {
            this.O0000oo0.O000000o(list);
        } else {
            this.O0000oo0.O00000Oo(list);
        }
    }

    public native void O00000Oo();

    public native void O00000Oo(ResponseError responseError, int i, int i2);

    public void O00000Oo(List<SemesterInfo> list) {
        this.O0000oOo.O000000o((List) list);
    }

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public O000000o O0000O0o() {
        if (this.O0000oo == null) {
            this.O0000oo = new is(this);
        }
        return this.O0000oo;
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.id.tab_left);
        O0000OOo();
        O0000O0o().O000000o();
        O0000O0o().O000000o(this, O0000O0o().O00000o0());
        O0000O0o().O000000o(this, O0000O0o().O00000Oo(), O0000O0o().O00000o0());
    }

    public native void onDestroy();
}
