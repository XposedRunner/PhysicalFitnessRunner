package com.zjwh.android_wh_physicalfitness.ui.run;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.due.DueRunWaitActivity;
import com.zjwh.android_wh_physicalfitness.entity.AboutRunInfo;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import defpackage.gg;
import org.xutils.common.Callback.CancelledException;

class SportFragment$2 implements MyCallback<String> {
    final /* synthetic */ int O000000o;
    final /* synthetic */ SportFragment O00000Oo;

    SportFragment$2(SportFragment sportFragment, int i) {
        this.O00000Oo = sportFragment;
        this.O000000o = i;
    }

    public void onCancelled(CancelledException cancelledException) {
    }

    public void onError(ResponseError responseError) {
        SportFragment.O00000Oo(this.O00000Oo);
    }

    public void onFinished() {
    }

    public void onSuccess(String str) {
        if (this.O00000Oo.O0000Ooo() && !SportFragment.O0000Oo0(this.O00000Oo)) {
            AboutRunInfo aboutRunInfo = (AboutRunInfo) O000o000.O000000o().fromJson(str, AboutRunInfo.class);
            if (aboutRunInfo != null) {
                if (aboutRunInfo.getIsMissed() != 0) {
                    SportFragment.O000000o(this.O00000Oo, SportFragment.O000000o(this.O00000Oo, R.string.tip_run_due, R.string.home_dialog_run_missing, new SportFragment$O000000o(this.O00000Oo, null)));
                    Context activity = this.O00000Oo.getActivity();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(SportFragment.O0000OOo(this.O00000Oo));
                    stringBuilder.append(gg.O000OO00);
                    O00O0Oo0.O000000o(activity, stringBuilder.toString());
                } else if (aboutRunInfo.getIsStarted() == 0) {
                    DueRunWaitActivity.O000000o(this.O00000Oo.getActivity(), this.O000000o);
                } else {
                    SportFragment.O000000o(this.O00000Oo, new O0000Oo(this.O00000Oo.getActivity()).O000000o().O000000o(false).O00000Oo(false).O000000o("约跑提示").O00000Oo("您有一个约跑已经开始，点击开始约跑").O00000Oo((int) R.string.start, new OnClickListener() {
                        public void onClick(View view) {
                            RunDueActivity.O000000o(SportFragment$2.this.O00000Oo.getActivity(), SportFragment$2.this.O000000o);
                        }
                    }).O000000o((int) R.string.give_up, new SportFragment$O000000o() {
                        {
                            SportFragment sportFragment = SportFragment$2.this.O00000Oo;
                        }

                        public void onClick(View view) {
                            super.onClick(view);
                            Context activity = SportFragment$2.this.O00000Oo.getActivity();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(SportFragment.O0000OOo(SportFragment$2.this.O00000Oo));
                            stringBuilder.append(gg.O000OO00);
                            O00O0Oo0.O000000o(activity, stringBuilder.toString());
                        }
                    }));
                    if (this.O00000Oo.O0000Ooo()) {
                        SportFragment.O0000Oo(this.O00000Oo).O00000Oo();
                    }
                }
            }
        }
    }
}
