package com.zjwh.android_wh_physicalfitness.ui.rank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.amap.api.maps.MapView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0O0o;
import com.zjwh.sw.map.entity.RunPeopleBean;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.dy;
import defpackage.dy.O00000o;
import defpackage.gp.O000000o;
import defpackage.gp.O00000Oo;
import defpackage.iw;
import defpackage.lj;
import java.util.List;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class CheatReportActivity extends BaseActivity implements O00000o, O00000Oo {
    @ViewInject(2131296805)
    private MapView O000000o;
    @ViewInject(2131296944)
    private RecyclerView O00000Oo;
    @ViewInject(2131296349)
    private Button O00000o;
    @ViewInject(2131297252)
    private TextView O00000o0;
    @ViewInject(2131296348)
    private Button O00000oO;
    @ViewInject(2131296491)
    private EditText O00000oo;
    @ViewInject(2131297251)
    private TextView O0000O0o;
    @ViewInject(2131296401)
    private RadioGroup O0000OOo;
    private dy O0000Oo;
    private O000000o O0000Oo0;
    private lj O0000o;

    static {
        C.i(16777352);
    }

    public static native void O000000o(Activity activity);

    private native void O000000o(Bundle bundle);

    private native void O000000o(boolean z);

    private native void O0000Oo0();

    @Event({2131296348, 2131296349, 2131296359})
    private void clickEvent(View view) {
        int id = view.getId();
        if (id != R.id.btnSubmit) {
            switch (id) {
                case R.id.btnChooseNear /*2131296348*/:
                    try {
                        this.O0000o.O000000o(O00000oo().O00000Oo(), O00000oo().O000000o(), O00000oo().O00000o0());
                        O00000o();
                        return;
                    } catch (com.zjwh.sw.map.O00000o e) {
                        e.printStackTrace();
                        return;
                    }
                case R.id.btnClean /*2131296349*/:
                    O00000oo().O00000o();
                    return;
                default:
                    return;
            }
        }
        O00000oo().O000000o(this, this.O00000oo.getText().toString().trim(), this.O0000OOo.getCheckedRadioButtonId(), this.O0000o.O00000o());
    }

    public native int O000000o();

    public native void O000000o(int i);

    public native void O000000o(int i, int i2);

    public native void O000000o(int i, boolean z);

    public native void O000000o(String str);

    public native void O000000o(String str, String str2);

    public void O000000o(List<RunPeopleBean> list) {
        if (!isFinishing()) {
            try {
                this.O0000o.O00000Oo((List) list);
                O00000o();
            } catch (com.zjwh.sw.map.O00000o e) {
                e.printStackTrace();
            }
        }
    }

    public native void O00000Oo();

    public native void O00000Oo(String str);

    public void O00000Oo(List<SWLatLng> list) {
        if (!isFinishing()) {
            try {
                this.O0000o.O000000o((List) list);
            } catch (com.zjwh.sw.map.O00000o e) {
                e.printStackTrace();
            }
        }
    }

    public native void O00000o();

    public native void O00000o0(String str);

    public native void O00000oO();

    public O000000o O00000oo() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new iw(this);
        }
        return this.O0000Oo0;
    }

    @PermissionSuccess(requestCode = 100)
    public void O0000O0o() {
        O00O0O0o.O00000Oo(this.O0000o0);
    }

    @PermissionFail(requestCode = 100)
    public void O0000OOo() {
        O00O00o.O000000o(this, 100);
    }

    public native boolean dispatchTouchEvent(MotionEvent motionEvent);

    public void n_() {
    }

    public native void onActivityResult(int i, int i2, Intent intent);

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        O0000Oo0();
    }

    public native void onDestroy();

    public native void onPause();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onResume();
}
