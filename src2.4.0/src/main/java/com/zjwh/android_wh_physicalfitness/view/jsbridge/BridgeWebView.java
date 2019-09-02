package com.zjwh.android_wh_physicalfitness.view.jsbridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.zjwh.android_wh_physicalfitness.view.WebView.VideoEnabledWebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class BridgeWebView extends VideoEnabledWebView implements O0000Oo0 {
    public static final String O000000o = "WebViewJavascriptBridge.js";
    Map<String, O00000o> O00000Oo = new HashMap();
    O000000o O00000o = new O0000O0o();
    Map<String, O000000o> O00000o0 = new HashMap();
    private final String O00000oO = "BridgeWebView";
    private List<O0000OOo> O00000oo = new ArrayList();
    private long O0000O0o = 0;

    public BridgeWebView(Context context) {
        super(context);
        O00000o();
    }

    public BridgeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o();
    }

    public BridgeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000o();
    }

    private void O00000Oo(O0000OOo o0000OOo) {
        if (this.O00000oo != null) {
            this.O00000oo.add(o0000OOo);
        } else {
            O000000o(o0000OOo);
        }
    }

    private void O00000Oo(String str, String str2, O00000o o00000o) {
        O0000OOo o0000OOo = new O0000OOo();
        if (!TextUtils.isEmpty(str2)) {
            o0000OOo.O00000o(str2);
        }
        if (o00000o != null) {
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder();
            long j = this.O0000O0o + 1;
            this.O0000O0o = j;
            stringBuilder.append(j);
            stringBuilder.append("_");
            stringBuilder.append(SystemClock.currentThreadTimeMillis());
            objArr[0] = stringBuilder.toString();
            str2 = String.format("JAVA_CB_%s", objArr);
            this.O00000Oo.put(str2, o00000o);
            o0000OOo.O00000o0(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            o0000OOo.O00000oO(str);
        }
        O00000Oo(o0000OOo);
    }

    private void O00000o() {
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        getSettings().setJavaScriptEnabled(true);
        setWebViewClient(O00000Oo());
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(O0000OOo o0000OOo) {
        String replaceAll = o0000OOo.O00000oo().replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2").replaceAll("(?<=[^\\\\])(\")", "\\\\\"");
        replaceAll = String.format("javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');", new Object[]{replaceAll});
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            loadUrl(replaceAll);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(String str) {
        String O00000o0 = O00000Oo.O00000o0(str);
        O00000o o00000o = (O00000o) this.O00000Oo.get(O00000o0);
        str = O00000Oo.O00000Oo(str);
        if (o00000o != null) {
            o00000o.O000000o(str);
            this.O00000Oo.remove(O00000o0);
        }
    }

    public void O000000o(String str, O000000o o000000o) {
        if (o000000o != null) {
            this.O00000o0.put(str, o000000o);
        }
    }

    public void O000000o(String str, O00000o o00000o) {
        O00000Oo(null, str, o00000o);
    }

    public void O000000o(String str, String str2, O00000o o00000o) {
        O00000Oo(str, str2, o00000o);
    }

    /* Access modifiers changed, original: protected */
    public O00000o0 O00000Oo() {
        return new O00000o0(this);
    }

    public void O00000Oo(String str) {
        O000000o(str, null);
    }

    public void O00000Oo(String str, O00000o o00000o) {
        loadUrl(str);
        this.O00000Oo.put(O00000Oo.O000000o(str), o00000o);
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o0() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            O00000Oo("javascript:WebViewJavascriptBridge._fetchQueue();", new O00000o() {
                public void O000000o(String str) {
                    try {
                        List O0000O0o = O0000OOo.O0000O0o(str);
                        if (O0000O0o != null && O0000O0o.size() != 0) {
                            for (int i = 0; i < O0000O0o.size(); i++) {
                                O0000OOo o0000OOo = (O0000OOo) O0000O0o.get(i);
                                String O000000o = o0000OOo.O000000o();
                                if (TextUtils.isEmpty(O000000o)) {
                                    O000000o = o0000OOo.O00000o0();
                                    O00000o anonymousClass1 = !TextUtils.isEmpty(O000000o) ? new O00000o() {
                                        public void O000000o(String str) {
                                            O0000OOo o0000OOo = new O0000OOo();
                                            o0000OOo.O000000o(O000000o);
                                            o0000OOo.O00000Oo(str);
                                            BridgeWebView.this.O00000Oo(o0000OOo);
                                        }
                                    } : new O00000o() {
                                        public void O000000o(String str) {
                                        }
                                    };
                                    O000000o o000000o = !TextUtils.isEmpty(o0000OOo.O00000oO()) ? (O000000o) BridgeWebView.this.O00000o0.get(o0000OOo.O00000oO()) : BridgeWebView.this.O00000o;
                                    if (o000000o != null) {
                                        o000000o.O000000o(o0000OOo.O00000o(), anonymousClass1);
                                    }
                                } else {
                                    ((O00000o) BridgeWebView.this.O00000Oo.get(O000000o)).O000000o(o0000OOo.O00000Oo());
                                    BridgeWebView.this.O00000Oo.remove(O000000o);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public List<O0000OOo> getStartupMessage() {
        return this.O00000oo;
    }

    public void setDefaultHandler(O000000o o000000o) {
        this.O00000o = o000000o;
    }

    public void setStartupMessage(List<O0000OOo> list) {
        this.O00000oo = list;
    }
}
