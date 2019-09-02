package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.activity.DownloadOfflineMapActivity;
import com.zjwh.android_wh_physicalfitness.activity.RunRuleActivity;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.EBOfflineMap;
import com.zjwh.android_wh_physicalfitness.entity.HomePageInfo;
import com.zjwh.android_wh_physicalfitness.entity.RunRulesInfo;
import com.zjwh.android_wh_physicalfitness.utils.O0000o;
import com.zjwh.android_wh_physicalfitness.utils.O000OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.view.dialog.O000000o;
import com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O00000o0;
import com.zjwh.map.gaode.O000O0OO;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class SettingActivity extends BaseActivity {
    @ViewInject(2131296684)
    public ImageView O000000o;
    @ViewInject(2131297316)
    public TextView O00000Oo;
    private HomePageInfo O00000o0 = new HomePageInfo();

    static {
        C.i(41);
    }

    public static native void O000000o(Activity activity);

    private native void O00000o();

    private native void O00000oO();

    @Event({2131297261, 2131296993, 2131296987, 2131297254, 2131297185, 2131297368})
    private void clickEvent(View view) {
        if (!O00OOo0.O000000o()) {
            Intent intent;
            switch (view.getId()) {
                case 2131296987:
                    new O000000o(this).execute(new Void[0]);
                    break;
                case 2131296993:
                    intent = new Intent(this.O0000o0, DownloadOfflineMapActivity.class);
                    break;
                case 2131297185:
                    intent = new Intent(this.O0000o0, AboutUsActivity.class);
                    break;
                case 2131297254:
                    double d = 0.0d;
                    if (this.O00000o0 != null) {
                        if (this.O00000o0.getSemesterInfoModel() != null) {
                            d = this.O00000o0.getSemesterInfoModel().getSemesterGoal();
                        }
                        if (this.O00000o0.getRunRuleModel() != null) {
                            RunRuleActivity.O000000o(this, new RunRulesInfo(this.O00000o0.getRunRuleModel().getRunRulesUrl(), String.valueOf(d), String.valueOf(this.O00000o0.getRunRuleModel().getDayGoal())));
                            break;
                        }
                    }
                    break;
                case 2131297261:
                    intent = new Intent(this.O0000o0, SecretActivity.class);
                    break;
                case 2131297368:
                    new O000000o(this).O000000o().O000000o(2131689741).O000000o(true).O00000Oo(true).O000000o(getString(2131689686), O00000o0.O00000Oo, new 1(this)).O00000Oo();
                    break;
            }
            intent = null;
            if (intent != null) {
                startActivity(intent);
            }
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleOfflinMapDown(EBOfflineMap eBOfflineMap) {
        if (eBOfflineMap != null) {
            int downloadStatus = eBOfflineMap.getDownloadStatus();
            if (downloadStatus == 1) {
                this.O000000o.setVisibility(0);
            } else if (downloadStatus == 2) {
                this.O000000o.setVisibility(8);
            }
        }
    }

    public void n_() {
        org.greenrobot.eventbus.O00000o0.O000000o().O000000o(this);
        this.O000000o.setVisibility(O000O0OO.O000000o() ? 0 : 8);
        this.O00000Oo.setText(O000OOo0.O000000o().O00000o(this.O0000o0));
        this.O00000o0 = O0000o.O000000o();
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
