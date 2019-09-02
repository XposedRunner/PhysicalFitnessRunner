package com.zjwh.android_wh_physicalfitness.activity.due;

import android.app.Activity;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.MapView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.DueRunCreateInfo;
import com.zjwh.android_wh_physicalfitness.entity.DueRunCreateResult;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.RunPoint;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.service.RunLocationService;
import com.zjwh.android_wh_physicalfitness.service.RunLocationService.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import com.zjwh.sw.map.O00000o;
import com.zjwh.sw.map.entity.SWFixedPoint;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.gj;
import defpackage.ll;
import java.util.ArrayList;
import java.util.List;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class DueRunCreateActivity extends BaseActivity {
    private static final int O000000o = 6;
    private static final int O00000Oo = 5;
    @ViewInject(2131296847)
    private MapView O00000o;
    @ViewInject(2131296734)
    private View O00000o0;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000oO;
    @ViewInject(2131297370)
    private TextView O00000oo;
    @ViewInject(2131296363)
    private TextView O0000O0o;
    @ViewInject(2131296516)
    private EditText O0000OOo;
    private RunLocationService O0000Oo;
    @ViewInject(2131296668)
    private ImageView O0000Oo0;
    private ServiceConnection O0000o;
    private List<RunPoint> O0000oO = new ArrayList();
    private ll O0000oO0;
    private SWLatLng O0000oOO;
    private UserInfo O0000oOo;
    private int O0000oo = -1;
    private String O0000oo0;
    private int O0000ooO = -1;
    private int O0000ooo = -1;
    private boolean O000O00o;
    private boolean O000O0OO = false;
    private boolean O000O0Oo = false;
    private O00000Oo O00oOoOo = new O00000Oo() {
        public void O000000o(double d, double d2, double d3, double d4, float f) {
            DueRunCreateActivity.this.O0000oOO = new SWLatLng(d, d2, d3, d4);
            if (d3 > 1.0d && d3 > 1.0d) {
                DueRunCreateActivity.this.O0000O0o();
            }
        }
    };
    private int O00oOooO;
    private String O00oOooo;

    static {
        C.i(16777298);
    }

    public static native void O000000o(Activity activity);

    private native void O0000OOo();

    private void O0000Oo0() {
        if (!isFinishing() && this.O0000oO != null && this.O0000oO.size() != 0) {
            try {
                List arrayList = new ArrayList();
                for (RunPoint runPoint : this.O0000oO) {
                    arrayList.add(new SWFixedPoint(runPoint.getLat(), runPoint.getLon(), -1.0d, -1.0d, runPoint.getPid(), runPoint.getDesc()));
                }
                this.O0000oO0.O000000o(arrayList);
            } catch (O00000o e) {
                e.printStackTrace();
            }
        }
    }

    private native void O0000o0();

    private native void O0000o0O();

    private void O0000o0o() {
        if (this.O0000oo < 0) {
            new O0000Oo(this).O000000o().O000000o("创建失败").O00000Oo("请选择终点点位").O000000o(false).O00000Oo(false).O000000o((int) R.string.sure, (int) R.color.green, null).O00000Oo();
        } else if (this.O0000oOO == null || this.O0000oOO.getBLat() < 1.0d || this.O0000oOO.getBLon() < 1.0d) {
            O00Oo0.O000000o(this, R.string.due_run_no_location);
        } else {
            O00000oO(getString(R.string.create_confirming));
            this.O0000O0o.setText(R.string.create_confirming);
            this.O0000O0o.setEnabled(false);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("/api/v8/");
            stringBuilder.append(this.O0000ooO);
            stringBuilder.append("/open/room");
            gj gjVar = new gj(stringBuilder.toString());
            DueRunCreateInfo dueRunCreateInfo = new DueRunCreateInfo();
            dueRunCreateInfo.setBeginInterval(5);
            dueRunCreateInfo.setPid(this.O0000oo);
            dueRunCreateInfo.setUnid(this.O0000ooo);
            dueRunCreateInfo.setNumLimit(6);
            dueRunCreateInfo.setLon(this.O0000oOO.getBLon());
            dueRunCreateInfo.setLat(this.O0000oOO.getBLat());
            dueRunCreateInfo.setRoomName(TextUtils.isEmpty(this.O0000OOo.getText().toString()) ? this.O0000oo0 : this.O0000OOo.getText().toString().trim());
            gjVar.setBodyContent(this.O0000OoO.toJson(dueRunCreateInfo));
            HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                    DueRunCreateActivity.this.O0000OoO();
                    if (responseError.getError() == 10930 || responseError.getError() == 10901) {
                        new O0000Oo(DueRunCreateActivity.this).O000000o().O000000o("创建失败").O00000Oo(responseError.getMessage()).O000000o(false).O00000Oo(false).O000000o((int) R.string.sure, (int) R.color.green, null).O00000Oo();
                    } else {
                        O00Oo00.O000000o(responseError.getMessage(), false);
                    }
                }

                public void onFinished() {
                    DueRunCreateActivity.this.O0000OoO();
                    DueRunCreateActivity.this.O0000O0o.setText("创建房间");
                    DueRunCreateActivity.this.O0000O0o.setEnabled(true);
                }

                public void onSuccess(String str) {
                    try {
                        DueRunCreateResult dueRunCreateResult = (DueRunCreateResult) DueRunCreateActivity.this.O0000OoO.fromJson(str, DueRunCreateResult.class);
                        if (dueRunCreateResult != null) {
                            DueRunWaitActivity.O000000o(DueRunCreateActivity.this, dueRunCreateResult.getRoomId());
                            DueRunCreateActivity.this.finish();
                            return;
                        }
                        O00Oo0.O000000o(DueRunCreateActivity.this, R.string.msg_due_run_create_failure);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Event({2131296740, 2131296363})
    private void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_create) {
            O0000o0o();
        } else if (id == R.id.left_image) {
            onBackPressed();
        }
    }

    public native int O000000o();

    public native void O000000o(Bundle bundle);

    public native void O00000Oo();

    @PermissionSuccess(requestCode = 101)
    public void O00000o() {
        this.O000O0Oo = true;
        O00000oo();
    }

    @PermissionFail(requestCode = 101)
    public void O00000oO() {
        O00O00o.O000000o(this, 101);
    }

    public native void O00000oo();

    public native void O0000O0o();

    public native boolean dispatchTouchEvent(MotionEvent motionEvent);

    public void n_() {
        this.O0000oOo = O00Oo0.O00000o0();
        this.O0000ooo = ((Integer) O00O0Oo0.O00000o0("sp_key_run_unid", Integer.valueOf(-1))).intValue();
        if (this.O0000oOo != null) {
            this.O0000ooO = this.O0000oOo.getUid();
            this.O0000ooo = this.O0000ooo == -1 ? this.O0000oOo.getUnid() : this.O0000ooo;
            if (TextUtils.isEmpty(this.O0000oOo.getName())) {
                this.O0000oo0 = "发起的约跑";
                return;
            }
            StringBuilder stringBuilder;
            String substring;
            if (this.O0000oOo.getName().length() > 7) {
                stringBuilder = new StringBuilder();
                substring = this.O0000oOo.getName().substring(0, 7);
            } else {
                stringBuilder = new StringBuilder();
                substring = this.O0000oOo.getName();
            }
            stringBuilder.append(substring);
            stringBuilder.append("发起的约跑");
            this.O0000oo0 = stringBuilder.toString();
        }
    }

    public native void onBackPressed();

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native void onPause();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onResume();
}
