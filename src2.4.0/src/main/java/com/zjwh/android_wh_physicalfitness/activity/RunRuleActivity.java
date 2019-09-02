package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.qiyukf.unicorn.api.ConsultSource;
import com.qiyukf.unicorn.api.Unicorn;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.RunRulesInfo;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class RunRuleActivity extends BaseActivity {
    private static final String O000000o = "extra_info";
    @ViewInject(2131297491)
    private ProgressBar O00000Oo;
    @ViewInject(2131296779)
    private RelativeLayout O00000o;
    @ViewInject(2131297492)
    private WebView O00000o0;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000oO;
    private String O00000oo = "";
    private String O0000O0o = "";
    private RunRulesInfo O0000OOo;

    public class O000000o {
        @JavascriptInterface
        public void setGoal() {
            RunRuleActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("javascript:setGoal('");
                    stringBuilder.append(RunRuleActivity.this.O0000O0o);
                    stringBuilder.append("')");
                    RunRuleActivity.this.O00000o0.loadUrl(stringBuilder.toString());
                }
            });
        }
    }

    static {
        C.i(16777288);
    }

    public static native void O000000o(Activity activity, RunRulesInfo runRulesInfo);

    private native void O000000o(Bundle bundle);

    private native boolean O000000o(Context context, String str);

    private native void O00000oO();

    private native void O00000oo();

    @Event({2131296362})
    private void onclickView(View view) {
        if (view.getId() == R.id.btn_contract_us) {
            Unicorn.openServiceActivity(this, "客服", new ConsultSource("Android_Rule", "Android_Rule", ""));
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void O00000o() {
        if (O00Oo0.O00000Oo(getApplicationContext())) {
            O00000oO();
        } else {
            this.O00000oO.O000000o(null, getString(R.string.txt_request_failure), getString(R.string.txt_check_network), "", new OnClickListener() {
                public void onClick(View view) {
                    RunRuleActivity.this.O00000o();
                }
            });
        }
    }

    public void n_() {
    }

    public native void onBackPressed();

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native void onPause();

    public native void onResume();

    public native void onSaveInstanceState(Bundle bundle);
}
