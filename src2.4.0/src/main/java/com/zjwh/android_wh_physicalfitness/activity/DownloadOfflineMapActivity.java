package com.zjwh.android_wh_physicalfitness.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o;
import com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O00000o0;
import defpackage.lk;
import java.util.Locale;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class DownloadOfflineMapActivity extends BaseActivity {
    private static final int O0000o = 1;
    private static final int O0000oO = 3;
    private static final int O0000oO0 = 2;
    @ViewInject(2131297326)
    TextView O000000o;
    @ViewInject(2131297358)
    TextView O00000Oo;
    @ViewInject(2131297353)
    TextView O00000o;
    @ViewInject(2131297359)
    TextView O00000o0;
    @ViewInject(2131296684)
    ImageView O00000oO;
    @ViewInject(2131296882)
    ProgressBar O00000oo;
    @ViewInject(2131296785)
    LinearLayout O0000O0o;
    private lk O0000OOo;
    private int O0000Oo;
    private String O0000Oo0 = "";
    private int O0000oOO;
    private int O0000oOo = -1;
    private O000000o O0000oo0 = new O000000o() {
        public void O000000o(int i) {
            DownloadOfflineMapActivity.this.O000000o(DownloadOfflineMapActivity.this.O0000Oo0);
        }
    };

    static {
        C.i(16777279);
    }

    private void O000000o(int i) {
        switch (i) {
            case 1:
                new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o(this).O000000o().O000000o(getString(R.string.pauseload), O00000o0.Black, new O000000o() {
                    public void O000000o(int i) {
                        DownloadOfflineMapActivity.this.O00000oo();
                    }
                }).O000000o(getString(R.string.delete), O00000o0.Green, this.O0000oo0).O00000Oo();
                return;
            case 2:
                new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o(this).O000000o().O000000o(getString(R.string.restartload), O00000o0.Black, new O000000o() {
                    public void O000000o(int i) {
                        DownloadOfflineMapActivity.this.O0000O0o();
                    }
                }).O000000o(getString(R.string.delete), O00000o0.Green, this.O0000oo0).O00000Oo();
                return;
            case 3:
                new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o(this).O000000o().O000000o((int) R.string.offlinemaptitle).O000000o(getString(R.string.delete), O00000o0.Green, this.O0000oo0).O00000Oo();
                return;
            default:
                return;
        }
    }

    private native void O0000o0();

    @Event({2131296684, 2131296993, 2131296740})
    private void onClick(View view) {
        int id = view.getId();
        if (id != R.id.iv_download) {
            if (id == R.id.left_image) {
                finish();
            } else if (id == R.id.rl_offline_map && this.O00000oO.getVisibility() != 0) {
                O000000o(this.O0000Oo);
            }
        } else if (O00Oo0.O00000Oo(getApplicationContext())) {
            O00000oO();
        } else {
            O00Oo00.O000000o(getString(R.string.network_connected_error), false);
        }
    }

    public native int O000000o();

    public String O000000o(long j) {
        if (j < 1048576) {
            return String.format(Locale.getDefault(), "%dK", new Object[]{Long.valueOf(j / 1024)});
        }
        return String.format(Locale.getDefault(), "%.1fM", new Object[]{Double.valueOf(((double) j) / 1048576.0d)});
    }

    public native void O000000o(String str);

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public native void O0000O0o();

    @PermissionSuccess(requestCode = 101)
    public void O0000OOo() {
        if (this.O0000OOo != null) {
            this.O0000OOo.O000000o(getApplicationContext());
        }
    }

    @PermissionFail(requestCode = 101)
    public void O0000Oo0() {
        O00O00o.O000000o(this, 101);
    }

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
}
