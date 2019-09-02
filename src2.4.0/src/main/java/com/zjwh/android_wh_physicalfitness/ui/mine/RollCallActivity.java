package com.zjwh.android_wh_physicalfitness.ui.mine;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.rollcall.RollCallClassInfoBean;
import com.zjwh.android_wh_physicalfitness.entity.rollcall.RollCallRankBean;
import com.zjwh.android_wh_physicalfitness.entity.rollcall.RollCallRankInfoBean;
import com.zjwh.android_wh_physicalfitness.utils.O0000o00;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.fh;
import defpackage.hh.O000000o;
import defpackage.hh.O00000Oo;
import defpackage.jq;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class RollCallActivity extends BaseActivity implements O00000Oo {
    public static final int O000000o = 10000;
    @ViewInject(2131297278)
    private TextView O00000Oo;
    @ViewInject(2131297286)
    private TextView O00000o;
    @ViewInject(2131297279)
    private TextView O00000o0;
    @ViewInject(2131297200)
    private TextView O00000oO;
    @ViewInject(2131297164)
    private CollapsingToolbarLayout O00000oo;
    @ViewInject(2131297078)
    private View O0000O0o;
    @ViewInject(2131297244)
    private TextView O0000OOo;
    @ViewInject(2131296648)
    private ImageView O0000Oo;
    @ViewInject(2131296665)
    private ImageView O0000Oo0;
    @ViewInject(2131297280)
    private TextView O0000o;
    @ViewInject(2131297246)
    private TextView O0000oO;
    @ViewInject(2131297197)
    private TextView O0000oO0;
    @ViewInject(2131297242)
    private TextView O0000oOO;
    @ViewInject(2131296945)
    private RecyclerView O0000oOo;
    @ViewInject(2131296358)
    private Button O0000oo;
    @ViewInject(2131296792)
    private LoadingEmptyLayout O0000oo0;
    private fh O0000ooO;
    private O000000o O0000ooo;
    private O0000Oo O00oOooO;

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.mine.RollCallActivity$1 */
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
                    if (!RollCallActivity.this.isFinishing()) {
                        if (AnonymousClass1.this.O000000o.isEnabled()) {
                            RollCallActivity.this.O00000oo().O00000Oo();
                        } else {
                            RollCallActivity.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 10000);
                        }
                    }
                }
            }, 3000);
        }
    }

    static {
        C.i(16777338);
    }

    public static native void O000000o(Activity activity);

    private void O000000o(RollCallRankBean rollCallRankBean) {
        if (rollCallRankBean != null) {
            this.O0000o.setText("我");
            this.O0000oO0.setText(rollCallRankBean.getCampusId());
            this.O0000oOO.setText(rollCallRankBean.getOrder() > 10 ? "未上榜" : "已上榜");
            this.O0000oO.setText(O000O0o0.O000000o(O000O0o0.O0000OOo, rollCallRankBean.getSignTime()));
            O00Oo0.O000000o(this, rollCallRankBean.getIcon(), this.O0000Oo, rollCallRankBean.getSex());
            switch (rollCallRankBean.getOrder()) {
                case 1:
                    this.O0000Oo0.setImageResource(R.drawable.roll_call_rank_first_icon);
                    this.O0000Oo0.setVisibility(0);
                    this.O0000OOo.setVisibility(4);
                    break;
                case 2:
                    this.O0000Oo0.setImageResource(R.drawable.roll_call_rank_second_icon);
                    this.O0000Oo0.setVisibility(0);
                    this.O0000OOo.setVisibility(4);
                    break;
                case 3:
                    this.O0000Oo0.setImageResource(R.drawable.roll_call_rank_third_icon);
                    this.O0000Oo0.setVisibility(0);
                    this.O0000OOo.setVisibility(4);
                    break;
                default:
                    this.O0000OOo.setText(String.valueOf(rollCallRankBean.getOrder()));
                    this.O0000Oo0.setVisibility(8);
                    this.O0000OOo.setVisibility(0);
                    break;
            }
            this.O0000O0o.setVisibility(0);
            this.O00000oo.setMinimumHeight(DensityUtil.dip2px(68.0f));
            return;
        }
        this.O0000O0o.setVisibility(8);
        this.O00000oo.setMinimumHeight(0);
    }

    private O000000o O00000oo() {
        if (this.O0000ooo == null) {
            this.O0000ooo = new jq(this, this.O0000o0);
        }
        return this.O0000ooo;
    }

    private native void O0000O0o();

    @Event(type = OnMenuItemClickListener.class, value = {2131297163})
    private boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_roll_call) {
            RollCallRecordActivity.O000000o((Activity) this);
        }
        return true;
    }

    public native int O000000o();

    public native void O000000o(BluetoothAdapter bluetoothAdapter);

    public void O000000o(ResponseError responseError) {
        if (!isFinishing()) {
            this.O0000oo0.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    RollCallActivity.this.O00000oo().O000000o(RollCallActivity.this.O0000o0);
                }
            });
        }
    }

    public native void O000000o(RollCallClassInfoBean rollCallClassInfoBean);

    public native void O000000o(RollCallRankInfoBean rollCallRankInfoBean);

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public void n_() {
    }

    public native void onActivityResult(int i, int i2, Intent intent);

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (O0000o00.O000000o((Context) this)) {
            O00O00o.O00000o0((Activity) this);
            O0000O0o();
            O00000oo().O000000o(this.O0000o0);
            return;
        }
        O00Oo00.O000000o("该设备不支持本功能！");
        finish();
    }

    public native boolean onCreateOptionsMenu(Menu menu);

    public native void onDestroy();

    public native void onResume();
}
