package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.utils.O0000o00;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.gm.O000000o;
import defpackage.gm.O00000Oo;
import defpackage.it;
import java.util.Locale;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class AttendanceActivity extends BaseActivity implements O00000Oo {
    public static final int O000000o = 10000;
    public static final String O00000Oo = "bluetooth_sign_tip";
    @ViewInject(2131296590)
    private View O00000o;
    @ViewInject(2131296798)
    private LoadingEmptyLayout O00000o0;
    @ViewInject(2131297460)
    private ImageView O00000oO;
    @ViewInject(2131297461)
    private TextView O00000oo;
    @ViewInject(2131296323)
    private TextView O0000O0o;
    @ViewInject(2131296321)
    private TextView O0000OOo;
    @ViewInject(2131296309)
    private TextView O0000Oo;
    @ViewInject(2131296347)
    private TextView O0000Oo0;
    @ViewInject(2131296849)
    private View O0000o;
    @ViewInject(2131296315)
    private ViewStub O0000oO;
    @ViewInject(2131296320)
    private ViewStub O0000oO0;
    @ViewInject(2131296316)
    private ViewStub O0000oOO;
    private View O0000oOo;
    private View O0000oo;
    private View O0000oo0;
    private O0000Oo O0000ooO;
    private O000000o O0000ooo;

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.mine.AttendanceActivity$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ BluetoothAdapter O000000o;

        AnonymousClass1(BluetoothAdapter bluetoothAdapter) {
            this.O000000o = bluetoothAdapter;
        }

        public void onClick(View view) {
            try {
                this.O000000o.enable();
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    if (!AttendanceActivity.this.isFinishing()) {
                        if (AnonymousClass1.this.O000000o.isEnabled()) {
                            AttendanceActivity.this.O0000OOo().O00000Oo();
                        } else {
                            AttendanceActivity.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 10000);
                        }
                    }
                }
            }, 3000);
        }
    }

    static {
        C.i(16777326);
    }

    public static native void O000000o(Activity activity);

    @Event(type = OnMenuItemClickListener.class, value = {2131297163})
    private boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_attendance) {
            AttendanceListActivity.O000000o((Activity) this);
        }
        return true;
    }

    public native int O000000o();

    public native void O000000o(int i);

    public native void O000000o(long j);

    public void O000000o(long j, long j2, long j3, long j4, long j5, boolean z) {
        long j6 = j4;
        if (this.O0000oo == null) {
            this.O0000oo = this.O0000oOO.inflate();
        }
        TextView textView = (TextView) this.O0000oo.findViewById(R.id.start_valid_label);
        TextView textView2 = (TextView) this.O0000oo.findViewById(R.id.attendance_end_time);
        TextView textView3 = (TextView) this.O0000oo.findViewById(R.id.end_valid_label);
        ((TextView) this.O0000oo.findViewById(R.id.attendance_start_time)).setText(getString(R.string.attendance_sign_checked, new Object[]{O000O0o0.O000000o(O000O0o0.O0000OOo, j)}));
        textView.setText(getString(R.string.attendance_sign_in_time, new Object[]{O000O0o0.O000000o(O000O0o0.O0000OOo, j3)}));
        textView2.setText(getString(R.string.attendance_sign_out_checked, new Object[]{O000O0o0.O000000o(O000O0o0.O0000OOo, j2)}));
        if (j6 > 0) {
            textView3.setText(getString(R.string.attendance_sign_out_time, new Object[]{O000O0o0.O000000o(O000O0o0.O0000OOo, j6)}));
            this.O0000O0o.setText(getString(R.string.attendance_valid_time, new Object[]{Long.valueOf(j5)}));
        } else {
            textView3.setText("");
            this.O0000O0o.setText("未在考勤时间内签退");
        }
        this.O0000OOo.setBackgroundResource(z ? R.drawable.attendance_valid_bg : R.drawable.attendance_unvalid_bg);
        this.O0000OOo.setText(z ? "达标" : "无效");
        this.O0000O0o.setVisibility(0);
        this.O0000OOo.setVisibility(0);
        if (this.O0000oOo != null) {
            this.O0000oOo.setVisibility(8);
        }
        if (this.O0000oo0 != null) {
            this.O0000oo0.setVisibility(8);
        }
    }

    public void O000000o(long j, long j2, long j3, boolean z, boolean z2) {
        if (this.O0000oOo == null) {
            this.O0000oOo = this.O0000oO0.inflate();
        }
        TextView textView = (TextView) this.O0000oOo.findViewById(R.id.attendance_start_time);
        TextView textView2 = (TextView) this.O0000oOo.findViewById(R.id.attendance_end_time);
        TextView textView3 = (TextView) this.O0000oOo.findViewById(R.id.attendance_check_label);
        TextView textView4 = (TextView) this.O0000oOo.findViewById(R.id.attendance_check_time);
        TextView textView5 = (TextView) this.O0000oOo.findViewById(R.id.attendance_range);
        View findViewById = this.O0000oOo.findViewById(R.id.check_layout);
        Object[] objArr = new Object[1];
        int i = 0;
        objArr[0] = O000O0o0.O000000o(O000O0o0.O0000OOo, j);
        textView.setText(getString(R.string.attendance_sign_checking, objArr));
        textView2.setText(getString(R.string.attendance_sign_out_checking, new Object[]{O000O0o0.O000000o(O000O0o0.O0000OOo, j2)}));
        textView4.setText(O000O0o0.O000000o(O000O0o0.O0000O0o, j3));
        findViewById.setTag(Boolean.valueOf(false));
        findViewById.setBackgroundResource(R.drawable.attendance_btn_gray);
        textView3.setText("无法签到");
        int i2 = z2 ? z ? R.string.attendance_time_out : R.string.attendance_range_out : R.string.attendance_not_over_time;
        textView5.setText(getString(i2));
        textView5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.attendance_range_out, 0, 0, 0);
        findViewById.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag == null) {
                    tag = Boolean.valueOf(false);
                }
                if (((Boolean) tag).booleanValue()) {
                    if (((Boolean) O00O0Oo0.O00000o0(AttendanceActivity.O00000Oo, Boolean.valueOf(true))).booleanValue()) {
                        new O0000Oo(AttendanceActivity.this).O000000o().O000000o(false).O00000Oo(false).O000000o(AttendanceActivity.this.getString(R.string.tip)).O00000Oo(AttendanceActivity.this.getString(R.string.attendance_not_close_tip)).O000000o((int) R.string.sure, null).O00000Oo("不再提示", new OnClickListener() {
                            public void onClick(View view) {
                                O00O0Oo0.O000000o(AttendanceActivity.O00000Oo, Boolean.valueOf(false));
                            }
                        }).O00000Oo();
                    }
                    AttendanceActivity.this.O0000OOo().O00000Oo(AttendanceActivity.this);
                }
            }
        });
        if (z) {
            i = 8;
        }
        textView4.setVisibility(i);
    }

    public native void O000000o(long j, boolean z);

    public native void O000000o(BluetoothAdapter bluetoothAdapter);

    public native void O000000o(ServiceConnection serviceConnection);

    public native void O000000o(String str, String str2, int i, String str3);

    public void O000000o(boolean z, long j, long j2, long j3, long j4) {
        if (this.O0000oo0 == null) {
            this.O0000oo0 = this.O0000oO.inflate();
        }
        TextView textView = (TextView) this.O0000oo0.findViewById(R.id.attendance_start_time);
        TextView textView2 = (TextView) this.O0000oo0.findViewById(R.id.valid_label);
        TextView textView3 = (TextView) this.O0000oo0.findViewById(R.id.check_btn_label);
        TextView textView4 = (TextView) this.O0000oo0.findViewById(R.id.attendance_end_time);
        TextView textView5 = (TextView) this.O0000oo0.findViewById(R.id.attendance_check_time);
        TextView textView6 = (TextView) this.O0000oo0.findViewById(R.id.attendance_range);
        View findViewById = this.O0000oo0.findViewById(R.id.check_layout);
        textView.setText(getString(R.string.attendance_sign_checked, new Object[]{O000O0o0.O000000o(O000O0o0.O0000OOo, j)}));
        textView2.setText(getString(R.string.attendance_sign_in_time, new Object[]{O000O0o0.O000000o(O000O0o0.O0000OOo, j3)}));
        textView4.setText(getString(R.string.attendance_sign_out_checking, new Object[]{O000O0o0.O000000o(O000O0o0.O0000OOo, j2)}));
        textView5.setText(String.format(Locale.getDefault(), "%d分钟", new Object[]{Long.valueOf(j4)}));
        textView3.setText(z ? "签退" : "无法签退");
        findViewById.setTag(Boolean.valueOf(z));
        findViewById.setBackgroundResource(z ? R.drawable.attendance_btn_green : R.drawable.attendance_btn_gray);
        textView6.setText(getString(z ? R.string.attendance_range_in : R.string.attendance_range_out));
        textView6.setCompoundDrawablesWithIntrinsicBounds(z ? R.drawable.attendance_range_in : R.drawable.attendance_range_out, 0, 0, 0);
        findViewById.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag == null) {
                    tag = Boolean.valueOf(false);
                }
                if (((Boolean) tag).booleanValue()) {
                    AttendanceActivity.this.O0000OOo().O00000o(AttendanceActivity.this);
                }
            }
        });
        if (this.O0000oOo != null) {
            this.O0000oOo.setVisibility(8);
        }
    }

    public void O000000o(boolean z, boolean z2) {
        View view = this.O0000oOo;
        int i = R.drawable.attendance_range_in;
        int i2 = R.string.attendance_range_out;
        int i3 = R.drawable.attendance_btn_gray;
        int i4 = 0;
        if (view != null && this.O0000oOo.getVisibility() == 0) {
            view = this.O0000oOo.findViewById(R.id.check_layout);
            TextView textView = (TextView) this.O0000oOo.findViewById(R.id.attendance_check_label);
            TextView textView2 = (TextView) this.O0000oOo.findViewById(R.id.attendance_range);
            TextView textView3 = (TextView) this.O0000oOo.findViewById(R.id.attendance_check_time);
            CharSequence charSequence = "无法签到";
            boolean O00000o0 = O0000OOo().O00000o0();
            int i5 = (O00000o0 && z && !z2) ? 1 : 0;
            boolean z3 = z && i5 != 0;
            view.setTag(Boolean.valueOf(z3));
            if (i5 != 0) {
                i3 = R.drawable.attendance_btn_green;
            }
            view.setBackgroundResource(i3);
            if (!O00000o0) {
                i2 = R.string.attendance_not_over_time;
            } else if (z2) {
                i2 = R.string.attendance_time_out;
            } else if (z) {
                charSequence = "签到";
                i2 = R.string.attendance_range_in;
            }
            textView2.setText(i2);
            textView.setText(charSequence);
            if (i5 == 0) {
                i = R.drawable.attendance_range_out;
            }
            textView2.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            if (z2) {
                i4 = 8;
            }
            textView3.setVisibility(i4);
        } else if (this.O0000oo0 != null && this.O0000oo0.getVisibility() == 0) {
            View findViewById = this.O0000oo0.findViewById(R.id.check_layout);
            TextView textView4 = (TextView) this.O0000oo0.findViewById(R.id.attendance_range);
            TextView textView5 = (TextView) this.O0000oo0.findViewById(R.id.check_btn_label);
            findViewById.setTag(Boolean.valueOf(z));
            if (z) {
                i3 = R.drawable.attendance_btn_green;
            }
            findViewById.setBackgroundResource(i3);
            textView5.setText(z ? "签退" : "无法签退");
            if (z) {
                i2 = R.string.attendance_range_in;
            }
            textView4.setText(getString(i2));
            if (!z) {
                i = R.drawable.attendance_range_out;
            }
            textView4.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        }
    }

    public native void O00000Oo();

    public native void O00000Oo(long j);

    public native void O00000Oo(ServiceConnection serviceConnection);

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public native void O0000O0o();

    public O000000o O0000OOo() {
        if (this.O0000ooo == null) {
            this.O0000ooo = new it(this, this.O0000o0);
        }
        return this.O0000ooo;
    }

    @PermissionSuccess(requestCode = 101)
    public void O0000Oo0() {
        O0000OOo().O000000o(this);
    }

    @PermissionFail(requestCode = 101)
    public void O0000o0() {
        O00O00o.O000000o(this, 101);
    }

    public void n_() {
    }

    public native void onActivityResult(int i, int i2, Intent intent);

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (O0000o00.O000000o((Context) this)) {
            O00O00o.O00000o0((Activity) this);
            return;
        }
        O00Oo00.O000000o("该设备不支持本功能！");
        finish();
    }

    public native boolean onCreateOptionsMenu(Menu menu);

    public native void onDestroy();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onResume();
}
