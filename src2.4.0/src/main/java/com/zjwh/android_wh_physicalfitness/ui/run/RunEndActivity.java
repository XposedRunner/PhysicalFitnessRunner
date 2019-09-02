package com.zjwh.android_wh_physicalfitness.ui.run;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.mine.RunHistoryDetailActivity;
import com.zjwh.android_wh_physicalfitness.entity.GetDrawChanceBean;
import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.blur.BlurDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.gg;
import defpackage.ic.O000000o;
import defpackage.ic.O00000Oo;
import defpackage.kn;
import java.util.List;
import kr.co.namee.permissiongen.PermissionSuccess;
import s.h.e.l.l.C;

public class RunEndActivity extends BaseRunActivity<O000000o> implements BlurDialog.O000000o, O00000Oo {

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.run.RunEndActivity$1 */
    class AnonymousClass1 implements com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o {
        final /* synthetic */ boolean O000000o;
        final /* synthetic */ boolean O00000Oo;
        final /* synthetic */ boolean O00000o0;

        AnonymousClass1(boolean z, boolean z2, boolean z3) {
            this.O000000o = z;
            this.O00000Oo = z2;
            this.O00000o0 = z3;
        }

        public void O000000o(int i) {
            if ((this.O000000o && this.O00000Oo) || this.O00000o0) {
                RunEndActivity.this.O0000o0().O00000Oo(true);
            } else if (!RunEndActivity.this.isFinishing()) {
                new O0000Oo(RunEndActivity.this.O0000o0).O000000o().O000000o("未完成提醒").O00000Oo("本次跑步还未完成，是否确定提交？").O000000o(false).O00000Oo(false).O00000Oo("再跑跑", null).O000000o("不跑了", new OnClickListener() {
                    public void onClick(View view) {
                        RunEndActivity.this.O0000o0().O00000Oo(true);
                    }
                }).O00000Oo();
            }
        }
    }

    static {
        C.i(16777364);
    }

    private void O000000o(double d, double d2, String str, String str2, String str3, String str4) {
        if (!isFinishing()) {
            O0000o0().O0000oo();
            try {
                final double d3 = d;
                final double d4 = d2;
                new O0000Oo(this.O0000o0).O000000o().O000000o(str).O00000Oo(str2).O000000o(false).O00000Oo(false).O000000o(str3, new OnClickListener() {
                    public void onClick(View view) {
                        RunEndActivity.this.O0000o0().O0000Oo0();
                    }
                }).O00000Oo(str4, new OnClickListener() {
                    public void onClick(View view) {
                        RunEndActivity.this.O0000o0().O000000o(d3, d4);
                    }
                }).O00000Oo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static native void O000000o(Activity activity, int i);

    public static native void O000000o(Activity activity, String str);

    public void O000000o(double d, double d2) {
        O000000o(d, d2, getString(R.string.tip), getString(R.string.msg_not_five_point), getString(R.string.give_up), getString(R.string.sure));
    }

    public void O000000o(int i, GetDrawChanceBean getDrawChanceBean, String str) {
        if (getDrawChanceBean == null) {
            RunHistoryDetailActivity.O000000o((Activity) this, 1, str, true);
        } else if (getDrawChanceBean.getRrid() <= 0) {
            RunHistoryDetailActivity.O000000o(this, i, getDrawChanceBean, true, -1);
        } else {
            RunHistoryDetailActivity.O000000o((Activity) this, -1, getDrawChanceBean, true, 1, "", getDrawChanceBean.getRrid());
        }
        finish();
    }

    public void O000000o(String str, String str2, int i) {
        O000000o(str, str2, i, getString(R.string.upload_later), getString(R.string.upload_again));
    }

    public void O000000o(String str, String str2, final int i, String str3, String str4) {
        if (!isFinishing()) {
            try {
                O0000Oo O000000o = new O0000Oo(this.O0000o0).O000000o();
                O000000o.O000000o(false);
                O000000o.O00000Oo(false);
                if (!TextUtils.isEmpty(str)) {
                    O000000o.O000000o(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    O000000o.O00000Oo(str2);
                }
                O000000o.O000000o(str3, new OnClickListener() {
                    public void onClick(View view) {
                        try {
                            RunHistoryDetailActivity.O000000o(RunEndActivity.this, i, true);
                            O00O0Oo0.O000000o(gg.O000OO0o);
                            RunEndActivity.this.finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                O000000o.O00000Oo(str4, new OnClickListener() {
                    public void onClick(View view) {
                        RunEndActivity.this.O0000OOo();
                    }
                });
                O000000o.O00000Oo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void O000000o(List<FivePoint> list, SWLatLng sWLatLng) {
        O0000o();
        O0000o0().O0000ooO();
        super.O000000o((List) list, sWLatLng);
        if (this.O00000o0 != null && list != null && list.size() > 0) {
            this.O00000o0.O000000o(list.subList(0, 1), sWLatLng, 4);
        }
    }

    public native void O0000o0O();

    @PermissionSuccess(requestCode = 101)
    public void O0000oo() {
        O0000o0().O00000o();
        O0000o0().O00000oo();
        O00Oo0.O000000o(this);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O0000oo0 */
    public O000000o O0000o0() {
        if (this.O00000oo == null) {
            this.O00000oo = new kn(this, this.O0000o0);
        }
        return (O000000o) this.O00000oo;
    }

    public native void O0000ooO();

    public void k_() {
        O00Oo00.O00000Oo(getString(R.string.get_extra_fail));
        finish();
    }

    public native void onDestroy();

    public native void onDismiss(DialogInterface dialogInterface);
}
