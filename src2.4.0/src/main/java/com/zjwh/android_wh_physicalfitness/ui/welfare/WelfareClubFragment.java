package com.zjwh.android_wh_physicalfitness.ui.welfare;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.jsbridge.BridgeWebView;
import com.zjwh.android_wh_physicalfitness.view.jsbridge.O00000Oo;
import com.zjwh.android_wh_physicalfitness.view.jsbridge.O00000o0;
import defpackage.cu;
import defpackage.gg;
import java.util.HashMap;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427510)
public class WelfareClubFragment extends BaseFragment {
    @ViewInject(2131297158)
    public TextView O000000o;
    @ViewInject(2131296734)
    private View O00000oo;
    @ViewInject(2131297163)
    private Toolbar O0000O0o;
    @ViewInject(2131297490)
    private BridgeWebView O0000OOo;
    @ViewInject(2131297491)
    private ProgressBar O0000Oo0;

    static {
        C.i(16777371);
    }

    private native String O000000o(String[] strArr);

    private native void O000000o(boolean z);

    private native void O00000Oo();

    private HashMap<String, Comparable> O00000o0() {
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

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        O000000o(false);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public native void onDestroy();

    public native void onHiddenChanged(boolean z);

    public native void onPause();

    public native void onResume();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O000000o.setText("福利社");
        this.O0000O0o.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
        this.O0000O0o.setNavigationOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WelfareClubFragment.this.O0000OOo.goBack();
            }
        });
        O00Oo0.O000000o(this.O0000OOo);
        this.O0000OOo.setWebViewClient(new O00000o0(this.O0000OOo) {
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                super.shouldOverrideUrlLoading(webView, str);
                if (str.startsWith(O00000Oo.O000000o)) {
                    return true;
                }
                if (!str.contains(WelfareClubFragment.this.getString(R.string.commerce_url))) {
                    WelfareClubActivity.O000000o(WelfareClubFragment.this.getActivity(), str);
                    return true;
                } else if (!str.startsWith("tbopen://")) {
                    return false;
                } else {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    try {
                        if (WelfareClubFragment.this.getActivity().getPackageManager().resolveActivity(intent, 65536) != null) {
                            WelfareClubFragment.this.startActivity(intent);
                        } else {
                            O00Oo00.O000000o("未安装相应客户端");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        O00Oo00.O000000o("跳转被拒绝，无法正常跳转");
                    }
                    return true;
                }
            }
        });
        this.O0000OOo.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                if (i == 100) {
                    WelfareClubFragment.this.O0000Oo0.setVisibility(8);
                } else {
                    if (WelfareClubFragment.this.O0000Oo0.getVisibility() == 8) {
                        WelfareClubFragment.this.O0000Oo0.setVisibility(0);
                    }
                    WelfareClubFragment.this.O0000Oo0.setProgress(i);
                }
                super.onProgressChanged(webView, i);
            }
        });
        this.O0000OOo.loadUrl(getString(R.string.commerce_url));
        O00000Oo();
    }
}
