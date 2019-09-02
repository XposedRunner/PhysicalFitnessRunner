package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.a.a;
import com.tencent.open.a.f;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class c extends a {
    private String d;

    public c(WebView webView, long j, String str, String str2) {
        super(webView, j, str);
        this.d = str2;
    }

    private void b(String str) {
        WebView webView = (WebView) this.a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.d);
            stringBuffer.append("){");
            stringBuffer.append(this.d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            str = stringBuffer.toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-->callback, callback: ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.SecureJsListener", stringBuilder.toString());
            webView.loadUrl(str);
        }
    }

    public void a() {
        f.b("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    public void a(Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->onComplete, result: ");
        stringBuilder.append(obj);
        f.a("openSDK_LOG.SecureJsListener", stringBuilder.toString());
    }

    public void a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->onCustomCallback, js: ");
        stringBuilder.append(str);
        f.a("openSDK_LOG.SecureJsListener", stringBuilder.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", !com.tencent.open.c.c.a ? -4 : 0);
            jSONObject.put("sn", this.b);
            jSONObject.put("data", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
