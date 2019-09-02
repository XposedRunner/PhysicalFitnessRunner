package com.zjwh.android_wh_physicalfitness.ui.welfare;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.jsbridge.BridgeWebView;
import com.zjwh.android_wh_physicalfitness.view.jsbridge.O00000Oo;
import com.zjwh.android_wh_physicalfitness.view.jsbridge.O00000o0;
import defpackage.cu;
import defpackage.gg;
import java.util.HashMap;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class WelfareClubActivity extends BaseActivity {
    public static final String O000000o = "contenturl";
    @ViewInject(2131297490)
    BridgeWebView O00000Oo;
    @ViewInject(2131296859)
    ViewGroup O00000o;
    @ViewInject(2131297491)
    ProgressBar O00000o0;
    @ViewInject(2131297469)
    ViewGroup O00000oO;
    @ViewInject(2131296741)
    private TextView O00000oo;
    @ViewInject(2131297158)
    private TextView O0000O0o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000OOo;
    private String O0000Oo0 = "";

    private class O000000o extends O00000o0 {
        O000000o(BridgeWebView bridgeWebView) {
            super(bridgeWebView);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            super.shouldOverrideUrlLoading(webView, str);
            if (str.startsWith(O00000Oo.O000000o)) {
                return true;
            }
            if (str.startsWith("taobao://")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            if (str.startsWith("tbopen://")) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                try {
                    if (WelfareClubActivity.this.getPackageManager().resolveActivity(intent, 65536) != null) {
                        WelfareClubActivity.this.startActivity(intent);
                    } else {
                        O00Oo00.O000000o("未安装相应客户端");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    O00Oo00.O000000o("跳转被拒绝，无法正常跳转");
                }
            } else if (!(O00Oo0.O00000Oo((Activity) webView.getContext(), str) || str.startsWith(O00000Oo.O000000o) || !str.startsWith("http"))) {
                HashMap hashMap = new HashMap();
                hashMap.put("Referer", WelfareClubActivity.this.getString(R.string.base_venue_url));
                webView.loadUrl(str, hashMap);
            }
            return true;
        }
    }

    static {
        C.i(16777370);
    }

    private native String O000000o(String[] strArr);

    public static native void O000000o(Activity activity, String str);

    private native void O000000o(Bundle bundle);

    private native void O000000o(boolean z);

    private void O00000oO() {
        this.O0000O0o.setText("福利社");
        O00Oo0.O000000o(this.O00000Oo);
        this.O00000Oo.setWebViewClient(new O000000o(this.O00000Oo));
        this.O00000Oo.setWebChromeClient(new com.zjwh.android_wh_physicalfitness.view.WebView.O000000o(this.O00000o, this.O00000oO, null, this.O00000Oo) {
            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    WelfareClubActivity.this.O00000o0.setVisibility(8);
                } else {
                    if (WelfareClubActivity.this.O00000o0.getVisibility() == 8) {
                        WelfareClubActivity.this.O00000o0.setVisibility(0);
                    }
                    WelfareClubActivity.this.O00000o0.setProgress(i);
                }
                super.onProgressChanged(webView, i);
            }
        });
    }

    private native void O00000oo();

    private HashMap<String, Comparable> O0000O0o() {
        UserInfo O00000o0 = O00Oo0.O00000o0();
        int intValue = ((Integer) O00O0Oo0.O00000o0(gg.O000o0O, Integer.valueOf(-1))).intValue();
        if (O00000o0 != null) {
            if (intValue == -1) {
                intValue = O00000o0.getUid();
            }
            O00O0Oo0.O000000o(gg.O000o0O, Integer.valueOf(intValue));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uid", Integer.valueOf(intValue));
        hashMap.put(cu.O000OO0o, O00000o0 == null ? "" : O00000o0.getName());
        int i = 0;
        hashMap.put(cu.O000O0oo, Integer.valueOf(O00000o0 == null ? 0 : O00000o0.getSex()));
        String str = "enrollmentYear";
        if (O00000o0 != null) {
            i = O00000o0.getEnrollmentYear();
        }
        hashMap.put(str, Integer.valueOf(i));
        hashMap.put("depart", O00000o0 == null ? "" : O00000o0.getDepart());
        hashMap.put("campusName", O00000o0 == null ? "" : O00000o0.getCampusName());
        return hashMap;
    }

    @Event({2131296740, 2131296741})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.left_image /*2131296740*/:
                onBackPressed();
                return;
            case R.id.left_text /*2131296741*/:
                finish();
                return;
            default:
                return;
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void O00000o() {
        if (!isFinishing()) {
            this.O0000OOo.O000000o();
            if (O00Oo0.O00000Oo(getApplicationContext())) {
                this.O00000Oo.loadUrl(this.O0000Oo0);
            } else {
                this.O0000OOo.O000000o(null, getString(R.string.txt_request_failure), getString(R.string.txt_check_network), "", new OnClickListener() {
                    public void onClick(View view) {
                        WelfareClubActivity.this.O00000o();
                    }
                });
            }
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
