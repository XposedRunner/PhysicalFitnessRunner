package com.zjwh.android_wh_physicalfitness.ui.run;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.mine.RunHistoryDetailActivity;
import com.zjwh.android_wh_physicalfitness.entity.GetDrawChanceBean;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.blur.BlurDialog;
import com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O00000o0;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000O0o;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.gf;
import defpackage.gg;
import defpackage.id.O000000o;
import defpackage.id.O00000Oo;
import defpackage.ko;
import kr.co.namee.permissiongen.PermissionSuccess;

public class RunFreeActivity extends BaseRunActivity<O000000o> implements BlurDialog.O000000o, O00000Oo {
    public static void O000000o(Activity activity, long j) {
        Intent intent = new Intent(activity, RunFreeActivity.class);
        intent.putExtra("extra_start_time", j);
        activity.startActivity(intent);
    }

    public void O000000o(int i, int i2, int i3) {
        O000000o(i, i2, i3, getString(R.string.upload_later), getString(R.string.reupload));
    }

    public void O000000o(int i, int i2, final int i3, String str, String str2) {
        if (!isFinishing()) {
            new O0000Oo(this.O0000o0).O000000o().O000000o(false).O00000Oo(false).O000000o(i).O00000Oo(i2).O000000o((int) R.string.upload_later, new OnClickListener() {
                public void onClick(View view) {
                    RunHistoryDetailActivity.O000000o(RunFreeActivity.this, i3, true);
                    RunFreeActivity.this.finish();
                }
            }).O00000Oo((int) R.string.reupload, new OnClickListener() {
                public void onClick(View view) {
                    RunFreeActivity.this.O0000OOo();
                }
            }).O00000Oo();
        }
    }

    public void O000000o(int i, GetDrawChanceBean getDrawChanceBean, String str) {
        if (getDrawChanceBean == null) {
            RunHistoryDetailActivity.O000000o((Activity) this, 1, str, true);
        } else if (getDrawChanceBean.getRrid() <= 0) {
            RunHistoryDetailActivity.O000000o(this, i, getDrawChanceBean, true, -1);
        } else {
            RunHistoryDetailActivity.O000000o((Activity) this, -1, getDrawChanceBean, true, 4, "", getDrawChanceBean.getRrid());
        }
        finish();
    }

    public void O00000o() {
        O00Oo0.O000000o(this.O0000o0, gf.O00000oO);
        this.O0000oO = new O0000O0o(this);
        this.O0000oO.setCancelable(false);
        this.O0000oO.setCanceledOnTouchOutside(false);
        this.O0000oO.show();
        if (this.O0000oOO == null) {
            this.O0000oOO = new Handler();
        }
        if (this.O0000oOo == null) {
            this.O0000oOo = new Runnable() {
                public void run() {
                    if (!RunFreeActivity.this.isFinishing()) {
                        if (RunFreeActivity.this.O0000oO.isShowing()) {
                            RunFreeActivity.this.O0000oO.cancel();
                        }
                        if (((Boolean) O00O0Oo0.O00000o0(gg.O000000o, Boolean.valueOf(true))).booleanValue()) {
                            RunFreeActivity.this.O0000oO0();
                            O00O0Oo0.O000000o(gg.O000000o, Boolean.valueOf(false));
                        }
                        RunFreeActivity.this.O000000o(null, null);
                    }
                }
            };
        }
        this.O0000oOO.postDelayed(this.O0000oOo, 3000);
    }

    /* Access modifiers changed, original: protected */
    public void O0000o0O() {
        new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o(this).O000000o().O000000o(O0000o0().O0000oo()).O000000o(true).O00000Oo(true).O000000o(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (!RunFreeActivity.this.O0000o0().O0000o()) {
                    RunFreeActivity.this.O0000o0().O000000o((int) gg.O00O0Oo);
                }
            }
        }).O000000o(getString(R.string.txt_finish), O00000o0.Green, new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o() {
            public void O000000o(int i) {
                RunFreeActivity.this.O0000o0().O00000Oo(true);
            }
        }).O00000Oo();
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O0000oo */
    public O000000o O0000o0() {
        if (this.O00000oo == null) {
            this.O00000oo = new ko(this, this.O0000o0);
        }
        return (O000000o) this.O00000oo;
    }

    @PermissionSuccess(requestCode = 101)
    public void O0000oo0() {
        O0000o0().O00000o();
        O0000o0().O00000oo();
        O00Oo0.O000000o(this);
    }

    public void O0000ooO() {
    }

    public void k_() {
        O00Oo00.O00000Oo(getString(R.string.get_extra_fail));
        finish();
    }
}
