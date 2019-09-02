package com.zjwh.android_wh_physicalfitness.ui.run;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.mine.RunHistoryDetailActivity;
import com.zjwh.android_wh_physicalfitness.entity.GetDrawChanceBean;
import com.zjwh.android_wh_physicalfitness.entity.RunRuleModel;
import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.utils.O0000o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.blur.BlurDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O00000o0;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import com.zjwh.sw.map.entity.SWLatLng;
import defpackage.gf;
import defpackage.gg;
import defpackage.ie.O000000o;
import defpackage.ie.O00000Oo;
import defpackage.kp;
import java.util.List;
import kr.co.namee.permissiongen.PermissionSuccess;

public class RunRandomActivity extends BaseRunActivity<O000000o> implements BlurDialog.O000000o, O00000Oo {
    private void O000000o(double d, double d2, String str, String str2, String str3, String str4) {
        if (!isFinishing()) {
            O0000o0().O0000oo();
            try {
                final double d3 = d;
                final double d4 = d2;
                new O0000Oo(this.O0000o0).O000000o().O000000o(str).O00000Oo(str2).O000000o(false).O00000Oo(false).O000000o(str3, new OnClickListener() {
                    public void onClick(View view) {
                        RunRandomActivity.this.O0000o0().O0000Oo0();
                    }
                }).O00000Oo(str4, new OnClickListener() {
                    public void onClick(View view) {
                        RunRandomActivity.this.O0000o0().O000000o(d3, d4);
                    }
                }).O00000Oo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void O000000o(Activity activity, int i) {
        Intent intent = new Intent(activity, RunRandomActivity.class);
        intent.putExtra(gg.O0000o0, i);
        activity.startActivity(intent);
    }

    public static void O000000o(Activity activity, String str) {
        RunRuleModel O00000Oo = O0000o.O00000Oo();
        int i = 1000;
        if (O00000Oo != null && O00000Oo.getMinDistance() > 0) {
            i = O00000Oo.getMinDistance();
        }
        Intent intent = new Intent(activity, RunRandomActivity.class);
        intent.putExtra(gg.O0000o0, i);
        intent.putExtra("extra_start_flag", str);
        activity.startActivity(intent);
    }

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

    public void O000000o(int i, boolean z) {
        if (this.O00000o0 != null) {
            this.O00000o0.O000000o(i, z);
        }
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
                            RunHistoryDetailActivity.O000000o(RunRandomActivity.this, i, true);
                            O00O0Oo0.O000000o(gg.O000OO0o);
                            RunRandomActivity.this.finish();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                O000000o.O00000Oo(str4, new OnClickListener() {
                    public void onClick(View view) {
                        RunRandomActivity.this.O0000OOo();
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
        super.O000000o((List) list, sWLatLng);
        if (this.O00000o0 != null && list != null && list.size() > 0) {
            this.O00000o0.O000000o((List) list, sWLatLng, 1);
        }
    }

    public void O000000o(boolean z, int i) {
        if (z) {
            O00Oo0.O000000o(this.O0000o0, gf.O00000o0);
        } else {
            O00Oo0.O000000o(this.O0000o0, i);
        }
        O000000o(2);
    }

    /* Access modifiers changed, original: protected */
    public void O0000o0O() {
        if (!isFinishing()) {
            new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o(this).O000000o().O000000o(O0000o0().O0000ooO()).O000000o(true).O00000Oo(true).O000000o(new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!RunRandomActivity.this.O0000o0().O0000o()) {
                        RunRandomActivity.this.O0000o0().O000000o((int) gg.O00O0Oo);
                    }
                }
            }).O000000o(getString(R.string.txt_finish), O00000o0.Green, new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o() {
                public void O000000o(int i) {
                    RunRandomActivity.this.O0000o0().O00000Oo(true);
                }
            }).O00000Oo();
        }
    }

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
            this.O00000oo = new kp(this, this.O0000o0);
        }
        return (O000000o) this.O00000oo;
    }

    public void O0000ooO() {
        if (O0000o0().O0000o0()) {
            O0000o0o();
        }
    }

    public void k_() {
        O00Oo00.O00000Oo(getString(R.string.get_extra_fail));
        finish();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (O0000o0().O0000o0O()) {
            O0000o0().O0000Oo0();
        }
    }
}
