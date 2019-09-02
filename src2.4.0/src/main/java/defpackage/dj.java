package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.Config;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.utils.O00000o;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o00.O0000Oo;
import java.lang.ref.WeakReference;

/* compiled from: OauthDialog */
/* renamed from: dj */
public class dj extends di {
    private static final String O0000o0 = "https://log.umsns.com/";
    private static final String O0000o00 = "OauthDialog";
    private static String O0000o0o = "error";
    private O000000o O0000o0O;

    /* compiled from: OauthDialog */
    /* renamed from: dj$O000000o */
    static class O000000o {
        private UMAuthListener O000000o = null;
        private by O00000Oo;
        private int O00000o0;

        public O000000o(UMAuthListener uMAuthListener, by byVar) {
            this.O000000o = uMAuthListener;
            this.O00000Oo = byVar;
        }

        public void O000000o(Bundle bundle) {
            if (this.O000000o != null) {
                this.O000000o.onComplete(this.O00000Oo, this.O00000o0, O0000Oo0.O000000o(bundle));
            }
        }

        public void O000000o(Exception exception) {
            if (this.O000000o != null) {
                this.O000000o.onError(this.O00000Oo, this.O00000o0, exception);
            }
        }

        public void onCancel() {
            if (this.O000000o != null) {
                this.O000000o.onCancel(this.O00000Oo, this.O00000o0);
            }
        }
    }

    /* compiled from: OauthDialog */
    /* renamed from: dj$O00000Oo */
    private static class O00000Oo extends WebChromeClient {
        private WeakReference<dj> O000000o;

        private O00000Oo(dj djVar) {
            this.O000000o = new WeakReference(djVar);
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            dj djVar = this.O000000o == null ? null : (dj) this.O000000o.get();
            if (djVar == null) {
                return;
            }
            if (i < 90) {
                djVar.O00000o.setVisibility(0);
            } else {
                djVar.O0000Ooo.sendEmptyMessage(1);
            }
        }
    }

    /* compiled from: OauthDialog */
    /* renamed from: dj$O00000o0 */
    private static class O00000o0 extends WebViewClient {
        private WeakReference<dj> O000000o;

        private O00000o0(dj djVar) {
            this.O000000o = new WeakReference(djVar);
        }

        private void O000000o(String str) {
            Dialog dialog = this.O000000o == null ? null : (dj) this.O000000o.get();
            if (dialog != null) {
                dialog.O00000oO = 1;
                dialog.O00000oo = O0000Oo0.O000000o(str);
                if (dialog.isShowing()) {
                    O0000Oo0.O000000o(dialog);
                }
            }
        }

        private void O00000Oo(String str) {
            Dialog dialog = this.O000000o == null ? null : (dj) this.O000000o.get();
            if (dialog != null) {
                dialog.O00000oO = 1;
                dialog.O00000oo = da.O00000oO(str);
                if (dialog.isShowing()) {
                    O0000Oo0.O000000o(dialog);
                }
            }
        }

        public void onPageFinished(WebView webView, String str) {
            dj djVar = this.O000000o == null ? null : (dj) this.O000000o.get();
            if (djVar != null) {
                djVar.O0000Ooo.sendEmptyMessage(1);
                super.onPageFinished(webView, str);
                if (djVar.O00000oO == 0 && str.contains(djVar.O0000O0o)) {
                    O000000o(str);
                }
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            dj djVar = this.O000000o == null ? null : (dj) this.O000000o.get();
            if (djVar != null) {
                String str2 = "";
                if (str.contains("?ud_get=")) {
                    str2 = djVar.O00000o0(str);
                }
                if (str2.contains("access_key") && str2.contains("access_secret")) {
                    if (str.contains(djVar.O0000O0o)) {
                        O000000o(str);
                    }
                    return;
                } else if (str.startsWith(dj.O0000o0o)) {
                    O00000Oo(str);
                }
            }
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Dialog dialog = this.O000000o == null ? null : (dj) this.O000000o.get();
            if (dialog != null) {
                View view = dialog.O00000o;
                if (view.getVisibility() == 0) {
                    view.setVisibility(8);
                }
            }
            super.onReceivedError(webView, i, str, str2);
            if (dialog != null) {
                O0000Oo0.O000000o(dialog);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            dj djVar = this.O000000o == null ? null : (dj) this.O000000o.get();
            if (djVar != null) {
                Context applicationContext = djVar.O0000Oo0.getApplicationContext();
                if (O00000o.O00000o(applicationContext)) {
                    if (str.contains("?ud_get=")) {
                        str = djVar.O00000o0(str);
                    }
                    if (str.contains(djVar.O0000O0o)) {
                        O000000o(str);
                    }
                } else {
                    Toast.makeText(applicationContext, O0000Oo.O0000o00, 0).show();
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public dj(Activity activity, by byVar, UMAuthListener uMAuthListener) {
        super(activity, byVar);
        this.O0000o0O = new O000000o(uMAuthListener, byVar);
        O000000o();
    }

    private String O000000o(by byVar) {
        com.umeng.socialize.utils.O0000Oo o0000Oo = new com.umeng.socialize.utils.O0000Oo(this.O0000Oo0);
        o0000Oo.O000000o("https://log.umsns.com/").O00000Oo("share/auth/").O00000o0(O0000Oo0.O000000o(this.O0000Oo0)).O00000o(Config.EntityKey).O000000o(byVar).O00000oO("10").O00000oo(Config.SessionId).O0000O0o(UMUtils.getUMId(this.O0000Oo0));
        return o0000Oo.O00000Oo();
    }

    private String O00000o0(String str) {
        try {
            String[] split = str.split("ud_get=");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(split[0]);
            stringBuilder.append(split[1]);
            return stringBuilder.toString();
        } catch (Exception e) {
            O0000O0o.O000000o(e);
            return str;
        }
    }

    private WebViewClient O00000oO() {
        return new O00000o0();
    }

    public void O00000Oo(WebView webView) {
        webView.setWebViewClient(O00000oO());
        this.O00000Oo.setWebChromeClient(new O00000Oo());
    }

    public void O00000Oo(String str) {
        O0000o0o = str;
    }

    public void dismiss() {
        if (this.O00000oo != null) {
            String string = this.O00000oo.getString("uid");
            String string2 = this.O00000oo.getString("error_code");
            String string3 = this.O00000oo.getString("error_description");
            O000000o o000000o;
            if (this.O0000OoO == by.SINA && !TextUtils.isEmpty(string3)) {
                o000000o = this.O0000o0O;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cb.AuthorizeFailed.O000000o());
                stringBuilder.append("errorcode:");
                stringBuilder.append(string2);
                stringBuilder.append(" message:");
                stringBuilder.append(string3);
                o000000o.O000000o(new SocializeException(stringBuilder.toString()));
            } else if (TextUtils.isEmpty(string)) {
                o000000o = this.O0000o0O;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(cb.AuthorizeFailed.O000000o());
                stringBuilder2.append("unfetch usid...");
                o000000o.O000000o(new SocializeException(stringBuilder2.toString()));
            } else {
                this.O00000oo.putString("accessToken", this.O00000oo.getString("access_key"));
                this.O00000oo.putString("expiration", this.O00000oo.getString("expires_in"));
                this.O0000o0O.O000000o(this.O00000oo);
            }
        } else {
            this.O0000o0O.onCancel();
        }
        super.dismiss();
        O00000o0();
    }

    public void show() {
        super.show();
        this.O00000oo = null;
        if (this.O0000OoO == by.SINA) {
            this.O00000Oo.loadUrl(this.O0000O0o);
            return;
        }
        this.O00000Oo.loadUrl(O000000o(this.O0000OoO));
    }
}
