package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alibaba.wireless.security.jaq.JAQException;
import com.alibaba.wireless.security.jaq.SecuritySignature;
import com.umeng.socialize.UMShareAPI;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BasePayActivity;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.utils.O000OO;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00O0o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.jsbridge.BridgeWebView;
import com.zjwh.android_wh_physicalfitness.view.jsbridge.O00000Oo;
import com.zjwh.android_wh_physicalfitness.view.jsbridge.O00000o0;
import defpackage.by;
import defpackage.cu;
import defpackage.gg;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionSuccess;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class WebViewActivity extends BasePayActivity implements com.zjwh.android_wh_physicalfitness.activity.common.BasePayActivity.O000000o {
    public static final String O000000o = "contenturl";
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;
    public static final int O00000oO = 4;
    @ViewInject(2131297490)
    BridgeWebView O00000oo;
    @ViewInject(2131297491)
    ProgressBar O0000O0o;
    @ViewInject(2131296859)
    ViewGroup O0000OOo;
    @ViewInject(2131297469)
    ViewGroup O0000Oo0;
    @ViewInject(2131297158)
    private TextView O000O00o;
    @ViewInject(2131296972)
    private ImageButton O000O0OO;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O000O0Oo;
    private String O000O0o;
    private ValueCallback<Uri> O000O0o0;
    private String O000O0oO = "";
    private boolean O000O0oo = true;
    private int O000OO = -1;
    private boolean O000OO00 = true;
    private int O000OO0o = -1;
    private ValueCallback<Uri[]> O00oOoOo;
    @ViewInject(2131296741)
    private TextView O00oOooo;

    private class O000000o extends O00000o0 {
        O000000o(BridgeWebView bridgeWebView) {
            super(bridgeWebView);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebViewActivity.this.O000O00o.setText(webView.getTitle());
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewActivity.this.O000O0oo = true;
            WebViewActivity.this.O000O0OO.setVisibility(8);
            if (str.startsWith("mqqwpa")) {
                webView.stopLoading();
                if (UMShareAPI.get(WebViewActivity.this.getApplicationContext()).isInstall(WebViewActivity.this, by.QQ)) {
                    WebViewActivity.this.O0000o0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } else {
                    O00Oo00.O000000o(WebViewActivity.this.O0000o0, (int) R.string.umeng_socialize_text_qq_no_install);
                }
                webView.goBack();
                return;
            }
            super.onPageStarted(webView, str, bitmap);
            WebViewActivity.this.O000O00o.setText(R.string.p2refresh_doing_end_refresh);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            super.shouldOverrideUrlLoading(webView, str);
            if (!(O00Oo0.O00000Oo((Activity) webView.getContext(), str) || str.startsWith(O00000Oo.O000000o) || !str.startsWith("http"))) {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("Referer", WebViewActivity.this.getString(R.string.base_venue_url));
                webView.loadUrl(str, arrayMap);
            }
            return true;
        }
    }

    static {
        C.i(16777291);
    }

    private native String O000000o(String[] strArr);

    public static native void O000000o(Activity activity, String str);

    public static native void O000000o(Activity activity, String str, int i);

    private native void O000000o(Bundle bundle);

    private native void O000000o(File file);

    private native void O000000o(String str);

    private native void O000000o(boolean z);

    private native void O0000o();

    private void O0000o0() {
        O00Oo0.O000000o(this.O00000oo);
        this.O00000oo.setWebViewClient(new O000000o(this.O00000oo));
        this.O00000oo.setWebChromeClient(new com.zjwh.android_wh_physicalfitness.view.WebView.O000000o(this.O0000OOo, this.O0000Oo0, null, this.O00000oo) {
            public void O000000o(ValueCallback<Uri> valueCallback, String str, String str2) {
                WebViewActivity.this.O000OO0o = 4;
                WebViewActivity.this.O000O0o0 = valueCallback;
                O00O00o.O00000o(WebViewActivity.this);
            }

            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    WebViewActivity.this.O0000O0o.setVisibility(8);
                } else {
                    if (WebViewActivity.this.O0000O0o.getVisibility() == 8) {
                        WebViewActivity.this.O0000O0o.setVisibility(0);
                    }
                    WebViewActivity.this.O0000O0o.setProgress(i);
                }
                super.onProgressChanged(webView, i);
            }

            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
                WebViewActivity.this.O000OO0o = 4;
                WebViewActivity.this.O00oOoOo = valueCallback;
                O00O00o.O00000o(WebViewActivity.this);
                return true;
            }
        });
    }

    private native void O0000o0O();

    private void O0000o0o() {
        int i = this.O000OO0o;
        if (i != 4) {
            switch (i) {
                case 1:
                    Intent intent = new Intent(this.O0000o0, MultiImageSelectorActivity.class);
                    intent.putExtra("show_camera", false);
                    intent.putExtra("max_select_count", 1);
                    intent.putExtra("select_count_mode", 0);
                    startActivityForResult(intent, 0);
                    return;
                case 2:
                    O00O0O0o.O00000Oo(this.O0000o0);
                    return;
                default:
                    return;
            }
        }
        O00000o();
    }

    private ArrayMap<String, Comparable> O0000oO() {
        UserInfo O00000o0 = O00Oo0.O00000o0();
        Object obj = (String) O00O0Oo0.O00000o0(gg.O000o0O0, "");
        int intValue = ((Integer) O00O0Oo0.O00000o0(gg.O000o0O, Integer.valueOf(-1))).intValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("");
        String stringBuilder2 = stringBuilder.toString();
        Object obj2 = "";
        if (O00000o0 != null) {
            if (TextUtils.isEmpty(obj) || intValue == -1) {
                if (TextUtils.isEmpty(obj)) {
                    obj = O00000o0.getToken();
                }
                if (intValue == -1) {
                    intValue = O00000o0.getUid();
                }
                O00O0Oo0.O000000o(gg.O000o0O0, TextUtils.isEmpty(obj) ? "" : obj);
                O00O0Oo0.O000000o(gg.O000o0O, Integer.valueOf(intValue));
            }
            if (!TextUtils.isEmpty(obj) && intValue >= 0) {
                Map arrayMap = new ArrayMap();
                arrayMap.put("timeStamp", stringBuilder2);
                arrayMap.put("token", obj);
                arrayMap.put("uid", Integer.valueOf(intValue));
                try {
                    obj2 = new SecuritySignature(this.O0000o0).atlasSign(O00O0o.O000000o(arrayMap), this.O0000o0.getString(R.string.ali_app_key));
                } catch (JAQException e) {
                    e.printStackTrace();
                }
            }
        }
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("uid", Integer.valueOf(intValue));
        arrayMap2.put("token", obj);
        arrayMap2.put(cu.O000OO0o, O00000o0 == null ? "" : O00000o0.getName());
        arrayMap2.put(cu.O000O0oo, Integer.valueOf(O00000o0 == null ? 0 : O00000o0.getSex()));
        arrayMap2.put("enrollmentYear", Integer.valueOf(O00000o0 == null ? 0 : O00000o0.getEnrollmentYear()));
        arrayMap2.put("timeStamp", stringBuilder2);
        arrayMap2.put("tokenSign", obj2);
        arrayMap2.put("role", Integer.valueOf(O00000o0 == null ? 1 : O00000o0.getRole()));
        arrayMap2.put("appVersion", O00Oo0.O00000Oo());
        arrayMap2.put("DeviceId", O00Oo0.O000000o());
        arrayMap2.put("CustomDeviceId", (String) O00O0Oo0.O000000o(this.O0000o0, "CustomDeviceId", ""));
        arrayMap2.put("osType", Integer.valueOf(0));
        arrayMap2.put("osVersion", O000OO.O00000o0());
        arrayMap2.put("deviceName", O000OO.O0000OOo());
        arrayMap2.put("IMEI", O000OO.O0000Oo());
        arrayMap2.put("BaseHost", com.zjwh.android_wh_physicalfitness.O000000o.O0000O0o);
        return arrayMap2;
    }

    private void O0000oO0() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imgUrl", this.O000O0o);
            jSONObject.put("type", this.O000OO0o);
            this.O00000oo.O000000o("getOperationResult", jSONObject.toString(), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Event({2131296740, 2131296741, 2131296972})
    private void onClick(View view) {
        int id = view.getId();
        if (id != R.id.right_image) {
            switch (id) {
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
        O0000Oo0();
    }

    public native int O000000o();

    public void O000000o(int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("payChannel", i);
            jSONObject.put("payDoneStatus", i2);
            this.O00000oo.O000000o("payDoneStatusReturn", jSONObject.toString(), null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public native void O00000Oo();

    public void O00000o() {
        if (!isFinishing()) {
            new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o(this.O0000o0).O000000o().O000000o(true).O00000Oo(true).O000000o(this.O0000o0.getString(R.string.txt_take_pic), com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O00000o0.Black, new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o() {
                public void O000000o(int i) {
                    O00O0O0o.O00000Oo(WebViewActivity.this.O0000o0);
                }
            }).O000000o(this.O0000o0.getString(R.string.txt_choose_local_pic), com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O00000o0.Black, new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o() {
                public void O000000o(int i) {
                    Intent intent = new Intent(WebViewActivity.this.O0000o0, MultiImageSelectorActivity.class);
                    intent.putExtra("show_camera", false);
                    intent.putExtra("max_select_count", 1);
                    intent.putExtra("select_count_mode", 0);
                    WebViewActivity.this.startActivityForResult(intent, 0);
                }
            }).O000000o(new OnClickListener() {
                public void onClick(View view) {
                    if (WebViewActivity.this.O000O0o0 != null) {
                        WebViewActivity.this.O000O0o0.onReceiveValue(null);
                        WebViewActivity.this.O000O0o0 = null;
                    }
                    if (WebViewActivity.this.O00oOoOo != null) {
                        WebViewActivity.this.O00oOoOo.onReceiveValue(null);
                        WebViewActivity.this.O00oOoOo = null;
                    }
                }
            }).O00000Oo();
        }
    }

    @PermissionSuccess(requestCode = 100)
    public void O00000oO() {
        O0000o0o();
    }

    @PermissionFail(requestCode = 100)
    public void O00000oo() {
        O00O00o.O000000o(this, 100);
    }

    public void O0000O0o() {
        if (!isFinishing()) {
            this.O000O0Oo.O000000o();
            if (O00Oo0.O00000Oo(getApplicationContext())) {
                this.O00000oo.loadUrl(this.O000O0oO);
            } else {
                this.O000O0Oo.O000000o(null, getString(R.string.txt_request_failure), getString(R.string.txt_check_network), "", new OnClickListener() {
                    public void onClick(View view) {
                        WebViewActivity.this.O0000O0o();
                    }
                });
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (this.O000O0o0 != null) {
                this.O000O0o0.onReceiveValue(null);
                this.O000O0o0 = null;
            }
            if (this.O00oOoOo != null) {
                this.O00oOoOo.onReceiveValue(null);
                this.O00oOoOo = null;
            }
        } else if (i != 96) {
            Uri fromFile;
            switch (i) {
                case 0:
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra(MultiImageSelectorActivity.O00000o);
                    if (this.O00oOoOo == null && this.O000O0o0 == null) {
                        O000000o((String) stringArrayListExtra.get(0));
                        return;
                    }
                    fromFile = Uri.fromFile(new File((String) stringArrayListExtra.get(0)));
                    if (this.O00oOoOo != null) {
                        this.O00oOoOo.onReceiveValue(new Uri[]{fromFile});
                        return;
                    } else if (this.O000O0o0 != null) {
                        this.O000O0o0.onReceiveValue(fromFile);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    String string = PreferenceManager.getDefaultSharedPreferences(this.O0000o0).getString(O00O0O0o.O00000Oo, null);
                    if (this.O00oOoOo == null && this.O000O0o0 == null) {
                        O000000o(string);
                        return;
                    } else if (!TextUtils.isEmpty(string)) {
                        fromFile = Uri.fromFile(new File(string));
                        if (this.O00oOoOo != null) {
                            this.O00oOoOo.onReceiveValue(new Uri[]{fromFile});
                            return;
                        } else if (this.O000O0o0 != null) {
                            this.O000O0o0.onReceiveValue(fromFile);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        } else {
            O00Oo00.O000000o(this.O0000o0, (int) R.string.msg_set_pic_error);
        }
    }

    public native void onBackPressed();

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native void onPause();

    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public native void onResume();

    public native void onSaveInstanceState(Bundle bundle);
}
