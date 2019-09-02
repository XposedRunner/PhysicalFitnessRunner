package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import java.lang.reflect.Method;

/* compiled from: BaseDialog */
/* renamed from: di */
public abstract class di extends Dialog {
    public final cd O000000o;
    public WebView O00000Oo;
    public View O00000o;
    public View O00000o0;
    public int O00000oO = 0;
    public Bundle O00000oo;
    public String O0000O0o = "error";
    public TextView O0000OOo;
    public Activity O0000Oo;
    public Context O0000Oo0;
    public by O0000OoO;
    public Handler O0000Ooo = new 1();

    /* compiled from: BaseDialog */
    /* renamed from: di$1 */
    class 1 extends Handler {
        1() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1 && di.this.O00000o != null) {
                di.this.O00000o.setVisibility(8);
            }
            int i = message.what;
        }
    }

    /* compiled from: BaseDialog */
    /* renamed from: di$2 */
    class 2 implements OnClickListener {
        2() {
        }

        public void onClick(View view) {
            di.this.dismiss();
        }
    }

    public di(Activity activity, by byVar) {
        super(activity, cd.O000000o((Context) activity).O00000o("umeng_socialize_popup_dialog"));
        this.O0000Oo0 = activity.getApplicationContext();
        this.O000000o = cd.O000000o(this.O0000Oo0);
        this.O0000Oo = activity;
        this.O0000OoO = byVar;
    }

    public void O000000o() {
        setOwnerActivity(this.O0000Oo);
        LayoutInflater layoutInflater = (LayoutInflater) this.O0000Oo.getSystemService("layout_inflater");
        int O000000o = this.O000000o.O000000o("umeng_socialize_oauth_dialog");
        int O00000Oo = this.O000000o.O00000Oo("umeng_socialize_follow");
        String str = null;
        this.O00000o0 = layoutInflater.inflate(O000000o, null);
        final View findViewById = this.O00000o0.findViewById(O00000Oo);
        findViewById.setVisibility(8);
        O000000o = this.O000000o.O00000Oo("progress_bar_parent");
        O00000Oo = this.O000000o.O00000Oo("umeng_back");
        int O00000Oo2 = this.O000000o.O00000Oo("umeng_share_btn");
        int O00000Oo3 = this.O000000o.O00000Oo("umeng_title");
        int O00000Oo4 = this.O000000o.O00000Oo("umeng_socialize_titlebar");
        this.O00000o = this.O00000o0.findViewById(O000000o);
        this.O00000o.setVisibility(0);
        ((RelativeLayout) this.O00000o0.findViewById(O00000Oo)).setOnClickListener(new 2());
        this.O00000o0.findViewById(O00000Oo2).setVisibility(8);
        this.O0000OOo = (TextView) this.O00000o0.findViewById(O00000Oo3);
        if (this.O0000OoO.toString().equals("SINA")) {
            str = bw.O00000o;
        } else if (this.O0000OoO.toString().equals("RENREN")) {
            str = bw.O0000O0o;
        } else if (this.O0000OoO.toString().equals("DOUBAN")) {
            str = bw.O0000Ooo;
        } else if (this.O0000OoO.toString().equals("TENCENT")) {
            str = bw.O0000OoO;
        }
        TextView textView = this.O0000OOo;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("授权");
        stringBuilder.append(str);
        textView.setText(stringBuilder.toString());
        O00000Oo();
        final View findViewById2 = this.O00000o0.findViewById(O00000Oo4);
        final int O000000o2 = O0000Oo0.O000000o(this.O0000Oo0, 200.0f);
        3 3 = new FrameLayout(this.O0000Oo0) {
            private void O000000o(final View view, final View view2, int i, int i2) {
                if (view2.getVisibility() == 0 && i2 < i) {
                    di.this.O0000Ooo.post(new Runnable() {
                        public void run() {
                            view2.setVisibility(8);
                            if (view.getVisibility() == 0) {
                                view.setVisibility(8);
                            }
                            3.this.requestLayout();
                        }
                    });
                } else if (view2.getVisibility() != 0 && i2 >= i) {
                    di.this.O0000Ooo.post(new Runnable() {
                        public void run() {
                            view2.setVisibility(0);
                            3.this.requestLayout();
                        }
                    });
                }
            }

            /* Access modifiers changed, original: protected */
            public void onSizeChanged(int i, int i2, int i3, int i4) {
                super.onSizeChanged(i, i2, i3, i4);
                if (!O0000Oo0.O00000o0(di.this.O0000Oo0)) {
                    O000000o(findViewById, findViewById2, O000000o2, i2);
                }
            }
        };
        3.addView(this.O00000o0, -1, -1);
        setContentView(3);
        LayoutParams attributes = getWindow().getAttributes();
        if (O0000Oo0.O00000o0(this.O0000Oo0)) {
            int[] O00000Oo5 = O0000Oo0.O00000Oo(this.O0000Oo0);
            attributes.width = O00000Oo5[0];
            attributes.height = O00000Oo5[1];
        } else {
            attributes.height = -1;
            attributes.width = -1;
        }
        attributes.gravity = 17;
    }

    public void O000000o(WebView webView) {
        if (VERSION.SDK_INT < 11) {
            try {
                webView.getClass().getDeclaredMethod("removeJavascriptInterface", new Class[0]).invoke("searchBoxJavaBridge_", new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public void O000000o(String str) {
        this.O0000O0o = str;
    }

    public abstract void O00000Oo(WebView webView);

    public boolean O00000Oo() {
        this.O00000Oo = (WebView) this.O00000o0.findViewById(this.O000000o.O00000Oo("webView"));
        O00000Oo(this.O00000Oo);
        this.O00000Oo.requestFocusFromTouch();
        this.O00000Oo.setVerticalScrollBarEnabled(false);
        this.O00000Oo.setHorizontalScrollBarEnabled(false);
        this.O00000Oo.setScrollBarStyle(0);
        this.O00000Oo.getSettings().setCacheMode(2);
        this.O00000Oo.setBackgroundColor(-1);
        WebSettings settings = this.O00000Oo.getSettings();
        settings.setJavaScriptEnabled(true);
        if (VERSION.SDK_INT >= 8) {
            settings.setPluginState(PluginState.ON);
        }
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setAllowFileAccess(true);
        settings.setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
        settings.setUseWideViewPort(true);
        if (VERSION.SDK_INT >= 8) {
            settings.setLoadWithOverviewMode(true);
            settings.setDatabaseEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setGeolocationEnabled(true);
            settings.setAppCacheEnabled(true);
        }
        if (VERSION.SDK_INT >= 11) {
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", new Class[]{Boolean.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, new Object[]{Boolean.valueOf(false)});
            } catch (Exception e) {
                O0000O0o.O000000o(e);
            }
        }
        try {
            if (this.O0000OoO == by.RENREN) {
                CookieSyncManager.createInstance(this.O0000Oo0);
                CookieManager.getInstance().removeAllCookie();
            }
        } catch (Exception unused) {
        }
        if (VERSION.SDK_INT >= 11) {
            this.O00000Oo.removeJavascriptInterface("searchBoxJavaBridge_");
        } else {
            O000000o(this.O00000Oo);
        }
        return true;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x000d */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
    public void O00000o0() {
        /*
        r2 = this;
        r0 = r2.O00000Oo;	 Catch:{ Exception -> 0x000d }
        r0 = r0.getParent();	 Catch:{ Exception -> 0x000d }
        r0 = (android.view.ViewGroup) r0;	 Catch:{ Exception -> 0x000d }
        r1 = r2.O00000Oo;	 Catch:{ Exception -> 0x000d }
        r0.removeView(r1);	 Catch:{ Exception -> 0x000d }
    L_0x000d:
        r0 = r2.O00000Oo;	 Catch:{ Exception -> 0x0012 }
        r0.removeAllViews();	 Catch:{ Exception -> 0x0012 }
    L_0x0012:
        r0 = 0;
        r2.O00000Oo = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.di.O00000o0():void");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
