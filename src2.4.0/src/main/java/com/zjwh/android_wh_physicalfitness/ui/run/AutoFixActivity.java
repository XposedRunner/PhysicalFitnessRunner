package com.zjwh.android_wh_physicalfitness.ui.run;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.AutoFixBean;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00OOOo;
import defpackage.fw;
import defpackage.hy.O000000o;
import defpackage.hy.O00000Oo;
import defpackage.kj;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class AutoFixActivity extends BaseActivity implements O00000Oo {
    public static final String O000000o = "action_fix_service";
    public static final String O00000Oo = "action_fixed";
    public static final String O00000o = "action_location_send";
    public static final String O00000o0 = "action_location";
    @ViewInject(2131296333)
    private TextView O00000oO;
    @ViewInject(2131296327)
    private TextView O00000oo;
    @ViewInject(2131296942)
    private RecyclerView O0000O0o;
    private fw<AutoFixBean> O0000OOo;
    private int O0000Oo;
    private O000000o O0000Oo0;
    private LocalBroadcastManager O0000o;
    private BroadcastReceiver O0000oO0;

    static {
        C.i(16777357);
    }

    public static native void O000000o(Activity activity);

    private native void O0000o();

    private native void O0000o0o();

    private synchronized O000000o O0000oO0() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new kj(this);
        }
        return this.O0000Oo0;
    }

    @Event(type = OnClickListener.class, value = {2131296327, 2131296326})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.auto_close /*2131296326*/:
                finish();
                return;
            case R.id.auto_fix /*2131296327*/:
                this.O00000oo.setEnabled(false);
                O0000oO0().O00000Oo(this);
                this.O0000OOo.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }

    public native int O000000o();

    public native void O000000o(String str);

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public native void O0000O0o();

    public native void O0000OOo();

    public native void O0000Oo0();

    @PermissionSuccess(requestCode = 101)
    public void O0000o0() {
        O0000oO0().O00000Oo();
        Intent intent = new Intent(O00000o);
        intent.putExtra(kj.O00000Oo, true);
        LocalBroadcastManager.getInstance(MyApplication.O000000o()).sendBroadcast(intent);
    }

    @PermissionFail(requestCode = 101)
    public void O0000o0O() {
        O00O00o.O000000o(this, 101);
    }

    public void h_() {
        O00O00o.O00000o0((Activity) this);
    }

    public void i_() {
        startActivity(new Intent("android.settings.SETTINGS"));
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O00OOOo.O000000o((Activity) this, 0, null);
        setResult(-1);
        this.O0000Oo = O0000oO0().O000000o();
        O0000o0o();
        O0000oO0().O00000Oo(this);
        O0000o();
    }

    public native void onDestroy();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onResume();
}
