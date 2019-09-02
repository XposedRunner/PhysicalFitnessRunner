package com.geetest.sdk.dialog.views;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import cn.jiguang.net.HttpUtils;
import com.geetest.sdk.O00O00Oo;
import com.geetest.sdk.O00OO0O;
import com.geetest.sdk.O00OOOo;
import com.geetest.sdk.O0OOO00;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: WebviewBuilder */
public class O00000Oo {
    public static int O000000o = 0;
    public static int O00000Oo = 0;
    private static final String O00000o0 = "O00000Oo";
    private Context O00000o;
    private O00OO0O O00000oO;
    private O00O00Oo O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private GT3GtWebView O0000Oo = null;
    private int O0000Oo0;
    private String O0000OoO;
    private Runnable O0000Ooo;
    private Map<String, String> O0000o0;
    private Handler O0000o00 = new O00000Oo();

    /* compiled from: WebviewBuilder */
    private class O000000o {
        private O000000o() {
        }

        /* synthetic */ O000000o(O00000Oo o00000Oo, byte b) {
            this();
        }

        @JavascriptInterface
        public final void gt3Error(String str) {
            O0OOO00.O000000o(str);
            if (O00000Oo.this.O0000o00 != null) {
                try {
                    O00000Oo.this.O0000o00.removeCallbacks(O00000Oo.this.O0000Ooo);
                    O00000Oo.this.O0000o00.removeMessages(1);
                } catch (Exception unused) {
                }
            }
            if (O00000Oo.this.O00000oO != null && O00000Oo.this.O00000o != null && (O00000Oo.this.O00000o instanceof Activity)) {
                ((Activity) O00000Oo.this.O00000o).runOnUiThread(new O0000O0o(this, str));
            }
        }

        @JavascriptInterface
        public final void gtCallBack(String str, String str2, String str3) {
            O00000Oo.O00000o0;
            StringBuilder stringBuilder = new StringBuilder("JSInterface-->gtCallBack-->code: ");
            stringBuilder.append(str);
            stringBuilder.append(", message: ");
            stringBuilder.append(str3);
            O0OOO00.O000000o(stringBuilder.toString());
            O00000Oo.O00000o0;
            stringBuilder = new StringBuilder("JSInterface-->gtCallBack-->code: ");
            stringBuilder.append(str);
            stringBuilder.append(", result: ");
            stringBuilder.append(str2);
            stringBuilder.append(", message: ");
            stringBuilder.append(str3);
            O0OOO00.O000000o();
            try {
                int parseInt = Integer.parseInt(str);
                if (!(O00000Oo.this.O00000o == null || ((Activity) O00000Oo.this.O00000o).isFinishing())) {
                    ((Activity) O00000Oo.this.O00000o).runOnUiThread(new O00000o0(this, parseInt, str2));
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public final void gtClose() {
            O00000Oo.O00000o0;
            O0OOO00.O000000o("JSInterface-->gtClose");
            if (O00000Oo.this.O00000oO != null) {
                O00000Oo.this.O00000oO.O00000Oo();
            }
        }

        @JavascriptInterface
        public final void gtNotify(String str) {
            O00000Oo.O00000o0;
            O0OOO00.O000000o("JSInterface-->gtNotify-->".concat(String.valueOf(str)));
            try {
                O00000Oo.this.O0000Oo0 = Integer.parseInt(new JSONObject(str).getString("aspect_radio"));
                if (!(O00000Oo.this.O00000o == null || ((Activity) O00000Oo.this.O00000o).isFinishing())) {
                    ((Activity) O00000Oo.this.O00000o).runOnUiThread(new O0000OOo(this));
                }
            } catch (Exception e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("parse aspect_radio failed-->");
                stringBuilder.append(e.toString());
                O00000Oo.this.O00000oO.O000000o("202", stringBuilder.toString());
            }
        }

        @JavascriptInterface
        public final void gtReady() {
            O00000Oo.O00000o0;
            O0OOO00.O000000o("JSInterface-->gtReady");
            if (O00000Oo.this.O00000o != null && (O00000Oo.this.O00000o instanceof Activity)) {
                ((Activity) O00000Oo.this.O00000o).runOnUiThread(new O00000o(this));
            }
        }
    }

    /* compiled from: WebviewBuilder */
    public class O00000Oo extends Handler {
        public final void handleMessage(Message message) {
            if (message.what == 1 && O00000Oo.this.O00000oO != null) {
                O00000Oo.O00000o0;
                O0OOO00.O000000o(String.format("handleMessage-->timeout %s !", new Object[]{Integer.valueOf(O00000Oo.this.O00000oo.O00000oo())}));
                O00000Oo.this.O00000oO.O000000o("204", "load static resource timeout !");
            }
        }
    }

    /* compiled from: WebviewBuilder */
    public class O00000o0 implements Runnable {
        public final void run() {
            Message message = new Message();
            message.what = 1;
            O00000Oo.this.O0000o00.sendMessage(message);
        }
    }

    public O00000Oo(Context context) {
        this.O00000o = context;
        this.O00000oO = new O00OO0O();
    }

    private float O00000oo() {
        return this.O00000o.getResources().getDisplayMetrics().density;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARNING: Missing block: B:43:0x00ff, code skipped:
            if (r3 > r5) goto L_0x00e5;
     */
    private int O0000O0o() {
        /*
        r18 = this;
        r0 = r18;
        r1 = r0.O00000o;
        r1 = com.geetest.sdk.O0OO0O.O00000Oo(r1);
        r2 = r0.O00000o;
        r2 = com.geetest.sdk.O0OO0O.O000000o(r2);
        r3 = r0.O00000o;
        r4 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r3 = com.geetest.sdk.O0OO00O.O000000o(r3, r4);
        r4 = r0.O00000o;
        r5 = 1133084672; // 0x43898000 float:275.0 double:5.598182103E-315;
        r4 = com.geetest.sdk.O0OO00O.O000000o(r4, r5);
        r5 = r0.O00000o;
        r6 = 1135476736; // 0x43ae0000 float:348.0 double:5.61000047E-315;
        r5 = com.geetest.sdk.O0OO00O.O000000o(r5, r6);
        r6 = new java.lang.StringBuilder;
        r7 = "widthScreen: ";
        r6.<init>(r7);
        r7 = r0.O00000o;
        r8 = (float) r2;
        r7 = com.geetest.sdk.O0OO00O.O00000Oo(r7, r8);
        r6.append(r7);
        com.geetest.sdk.O0OOO00.O000000o();
        if (r1 >= r2) goto L_0x0042;
    L_0x003d:
        r6 = r1 << 2;
        r6 = r6 / 5;
        goto L_0x0046;
    L_0x0042:
        r6 = r2 << 2;
        r6 = r6 / 5;
    L_0x0046:
        r7 = "beeline";
        r8 = r0.O00000oo;
        r8 = r8.O0000Oo0();
        r7 = r7.equals(r8);
        r8 = 100;
        if (r7 != 0) goto L_0x0152;
    L_0x0056:
        r7 = r0.O0000Oo0;
        r9 = 60;
        if (r7 > r9) goto L_0x005e;
    L_0x005c:
        goto L_0x0152;
    L_0x005e:
        r7 = r0.O0000Oo0;
        if (r7 < r8) goto L_0x0123;
    L_0x0062:
        r7 = "slide";
        r9 = r0.O00000oo;
        r9 = r9.O0000Oo0();
        r7 = r7.equals(r9);
        if (r7 == 0) goto L_0x00e9;
    L_0x0070:
        r7 = android.os.Build.VERSION.SDK_INT;
        r9 = 19;
        if (r7 >= r9) goto L_0x00e9;
    L_0x0076:
        r3 = r18.O00000oo();
        com.geetest.sdk.O0OOO00.O000000o();
        r7 = r0.O00000o;
        r9 = 1129447424; // 0x43520000 float:210.0 double:5.58021171E-315;
        r7 = com.geetest.sdk.O0OO00O.O000000o(r7, r9);
        r9 = r0.O00000o;
        r10 = 1130758144; // 0x43660000 float:230.0 double:5.586687527E-315;
        r9 = com.geetest.sdk.O0OO00O.O000000o(r9, r10);
        r10 = r0.O00000o;
        r11 = 1132068864; // 0x437a0000 float:250.0 double:5.593163344E-315;
        r10 = com.geetest.sdk.O0OO00O.O000000o(r10, r11);
        r11 = r0.O00000o;
        r12 = 1132920832; // 0x43870000 float:270.0 double:5.597372625E-315;
        r11 = com.geetest.sdk.O0OO00O.O000000o(r11, r12);
        r12 = r0.O00000o;
        r13 = 1133248512; // 0x438c0000 float:280.0 double:5.59899158E-315;
        r12 = com.geetest.sdk.O0OO00O.O000000o(r12, r13);
        r13 = r0.O00000o;
        r14 = 1135214592; // 0x43aa0000 float:340.0 double:5.608705306E-315;
        r13 = com.geetest.sdk.O0OO00O.O000000o(r13, r14);
        r14 = (double) r3;
        r16 = 4609434218613702656; // 0x3ff8000000000000 float:0.0 double:1.5;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 > 0) goto L_0x00bf;
    L_0x00b4:
        if (r6 >= r7) goto L_0x00b7;
    L_0x00b6:
        goto L_0x00b8;
    L_0x00b7:
        r7 = r6;
    L_0x00b8:
        if (r6 <= r4) goto L_0x00bc;
    L_0x00ba:
        goto L_0x010b;
    L_0x00bc:
        r4 = r7;
        goto L_0x010b;
    L_0x00bf:
        r3 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r7 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1));
        if (r7 > 0) goto L_0x00cf;
    L_0x00c5:
        if (r6 >= r9) goto L_0x00c8;
    L_0x00c7:
        goto L_0x00c9;
    L_0x00c8:
        r9 = r6;
    L_0x00c9:
        if (r6 <= r12) goto L_0x00cd;
    L_0x00cb:
        r6 = r12;
        goto L_0x010c;
    L_0x00cd:
        r4 = r9;
        goto L_0x010b;
    L_0x00cf:
        r3 = 4613937818241073152; // 0x4008000000000000 float:0.0 double:3.0;
        r7 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1));
        if (r7 > 0) goto L_0x00df;
    L_0x00d5:
        if (r6 >= r10) goto L_0x00d8;
    L_0x00d7:
        goto L_0x00d9;
    L_0x00d8:
        r10 = r6;
    L_0x00d9:
        if (r6 <= r13) goto L_0x00dd;
    L_0x00db:
        r6 = r13;
        goto L_0x010c;
    L_0x00dd:
        r4 = r10;
        goto L_0x010b;
    L_0x00df:
        if (r6 >= r11) goto L_0x00e2;
    L_0x00e1:
        goto L_0x00e3;
    L_0x00e2:
        r11 = r6;
    L_0x00e3:
        if (r6 <= r5) goto L_0x00e7;
    L_0x00e5:
        r4 = r5;
        goto L_0x010b;
    L_0x00e7:
        r4 = r11;
        goto L_0x010b;
    L_0x00e9:
        if (r1 >= r2) goto L_0x0102;
    L_0x00eb:
        r3 = r0.O00000o;
        r6 = r0.O00000o;
        r7 = (float) r1;
        r6 = com.geetest.sdk.O0OO00O.O00000Oo(r6, r7);
        r6 = r6 + -44;
        r6 = (float) r6;
        r3 = com.geetest.sdk.O0OO00O.O000000o(r3, r6);
        if (r3 >= r4) goto L_0x00fe;
    L_0x00fd:
        goto L_0x00ff;
    L_0x00fe:
        r4 = r3;
    L_0x00ff:
        if (r3 <= r5) goto L_0x010b;
    L_0x0101:
        goto L_0x00e5;
    L_0x0102:
        if (r6 >= r3) goto L_0x0106;
    L_0x0104:
        r4 = r3;
        goto L_0x0107;
    L_0x0106:
        r4 = r6;
    L_0x0107:
        if (r6 <= r5) goto L_0x010b;
    L_0x0109:
        r6 = r5;
        goto L_0x010c;
    L_0x010b:
        r6 = r4;
    L_0x010c:
        if (r1 >= r2) goto L_0x0118;
    L_0x010e:
        r1 = r6 * 100;
        r2 = r0.O0000Oo0;
        r1 = r1 / r2;
        r0.O0000O0o = r1;
        r0.O0000OOo = r6;
        goto L_0x015c;
    L_0x0118:
        r0.O0000O0o = r6;
        r1 = r0.O0000O0o;
        r2 = r0.O0000Oo0;
        r1 = r1 * r2;
        r1 = r1 / r8;
        r0.O0000OOo = r1;
        goto L_0x015c;
    L_0x0123:
        if (r1 >= r2) goto L_0x013f;
    L_0x0125:
        r2 = r0.O00000o;
        r3 = r0.O00000o;
        r1 = (float) r1;
        r1 = com.geetest.sdk.O0OO00O.O00000Oo(r3, r1);
        r1 = r1 + -44;
        r1 = (float) r1;
        r1 = com.geetest.sdk.O0OO00O.O000000o(r2, r1);
        if (r1 >= r4) goto L_0x0138;
    L_0x0137:
        goto L_0x0139;
    L_0x0138:
        r4 = r1;
    L_0x0139:
        if (r1 <= r5) goto L_0x013c;
    L_0x013b:
        goto L_0x013d;
    L_0x013c:
        r5 = r4;
    L_0x013d:
        r6 = r5;
        goto L_0x0147;
    L_0x013f:
        if (r6 >= r3) goto L_0x0142;
    L_0x0141:
        goto L_0x0143;
    L_0x0142:
        r3 = r6;
    L_0x0143:
        if (r6 <= r5) goto L_0x0146;
    L_0x0145:
        goto L_0x013d;
    L_0x0146:
        r6 = r3;
    L_0x0147:
        r0.O0000O0o = r6;
        r1 = r0.O0000O0o;
        r2 = r0.O0000Oo0;
        r1 = r1 * r2;
        r1 = r1 / r8;
        r0.O0000OOo = r1;
        goto L_0x015c;
    L_0x0152:
        r0.O0000O0o = r3;
        r1 = r0.O0000O0o;
        r2 = r0.O0000Oo0;
        r1 = r1 * r2;
        r1 = r1 / r8;
        r0.O0000OOo = r1;
    L_0x015c:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.dialog.views.O00000Oo.O0000O0o():int");
    }

    public final GT3GtWebView O000000o() {
        StringBuilder stringBuilder;
        this.O0000o0 = new HashMap();
        this.O0000Oo0 = this.O00000oo.O0000OOo();
        HashMap hashMap = new HashMap();
        String str = "";
        String str2 = "";
        Map O000000o = this.O00000oo.O0000o0().O000000o();
        if (O000000o != null && O000000o.size() > 0) {
            for (Entry entry : O000000o.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str2);
                    stringBuilder2.append("&aspect_radio_");
                    stringBuilder2.append((String) entry.getKey());
                    stringBuilder2.append(HttpUtils.EQUAL_SIGN);
                    stringBuilder2.append(entry.getValue());
                    str2 = stringBuilder2.toString();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append(HttpUtils.PARAMETERS_SEPARATOR);
                    stringBuilder2.append((String) entry.getKey());
                    stringBuilder2.append(HttpUtils.EQUAL_SIGN);
                    stringBuilder2.append(this.O00000oo.O0000o0().O00000Oo().optString((String) entry.getKey()));
                    str = stringBuilder2.toString();
                }
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder("?gt=");
        stringBuilder3.append(this.O00000oo.O00000o0());
        stringBuilder3.append("&challenge=");
        stringBuilder3.append(this.O00000oo.O00000o());
        stringBuilder3.append("&lang=");
        stringBuilder3.append(this.O00000oo.O00000Oo());
        stringBuilder3.append("&title=&type=");
        stringBuilder3.append(this.O00000oo.O0000Oo0());
        stringBuilder3.append("&api_server=");
        stringBuilder3.append(this.O00000oo.O0000o0O().O00000Oo());
        stringBuilder3.append("&static_servers=");
        stringBuilder3.append(this.O00000oo.O0000o0O().O000000o().toString().replace("[", "").replace("]", ""));
        stringBuilder3.append("&width=100%&timeout=");
        stringBuilder3.append(this.O00000oo.O0000O0o());
        stringBuilder3.append("&debug=");
        stringBuilder3.append(this.O00000oo.O00000oO());
        stringBuilder3.append(str2);
        stringBuilder3.append(str);
        this.O0000OoO = stringBuilder3.toString();
        List O000000o2 = this.O00000oo.O0000o0O().O000000o();
        int i = 0;
        if (O000000o2 == null || O000000o2.size() <= 0) {
            StringBuilder stringBuilder4 = new StringBuilder("https://static.geetest.com/static/appweb/app3-index.html");
            stringBuilder4.append(this.O0000OoO);
            str = stringBuilder4.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("https://%s/static/appweb/app3-index.html", new Object[]{O000000o2.get(0)}));
            stringBuilder.append(this.O0000OoO);
            str = stringBuilder.toString();
        }
        try {
            this.O0000Oo = new GT3GtWebView(this.O00000o);
            this.O0000Oo.O00000Oo();
            if (this.O0000o00 != null) {
                this.O0000Ooo = new O00000o0();
                this.O0000o00.postDelayed(this.O0000Ooo, (long) this.O00000oo.O00000oo());
            }
            this.O0000Oo.setObservable(this.O00000oO);
            this.O0000Oo.setLayoutParams(new LayoutParams(-2, -2));
            this.O0000Oo.setStaticUrl(str);
            this.O0000Oo.setDataBean(this.O00000oo);
            this.O0000Oo.setMyHandler(this.O0000o00);
            this.O0000Oo.setRunnable(this.O0000Ooo);
            this.O0000Oo.loadUrl(str);
            this.O0000Oo.buildLayer();
            this.O0000Oo.addJavascriptInterface(new O000000o(this, (byte) 0), "JSInterface");
            this.O0000Oo.setTimeout(this.O00000oo.O00000oo());
            O00000Oo();
        } catch (Exception e) {
            e.printStackTrace();
            stringBuilder = new StringBuilder("默认webview内核丢失，错误码：204_3-->");
            stringBuilder.append(e.toString());
            O0OOO00.O000000o(stringBuilder.toString());
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            while (i < length) {
                O0OOO00.O000000o(stackTrace[i].toString());
                i++;
            }
            if (this.O0000o00 != null) {
                try {
                    this.O0000o00.removeCallbacks(this.O0000Ooo);
                    this.O0000o00.removeMessages(1);
                } catch (Exception unused) {
                }
            }
            if (this.O00000oO != null) {
                stringBuilder = new StringBuilder("webview crate error -->");
                stringBuilder.append(e.toString());
                this.O00000oO.O000000o("204_3", stringBuilder.toString());
            }
        }
        return this.O0000Oo;
    }

    public final void O000000o(O00O00Oo o00O00Oo) {
        this.O00000oo = o00O00Oo;
    }

    public final void O000000o(O00OOOo o00OOOo) {
        this.O00000oO.O000000o(o00OOOo);
    }

    public final void O00000Oo() {
        O0000O0o();
        if (this.O0000Oo != null && this.O0000Oo.getLayoutParams() != null) {
            O000000o = this.O0000O0o;
            O00000Oo = this.O0000OOo;
            LayoutParams layoutParams = this.O0000Oo.getLayoutParams();
            layoutParams.width = O000000o;
            layoutParams.height = O00000Oo;
            this.O0000Oo.setLayoutParams(layoutParams);
        }
    }

    public final void O00000o() {
        if (this.O0000Oo != null) {
            this.O0000Oo.removeJavascriptInterface("JSInterface");
            ViewGroup viewGroup = (ViewGroup) this.O0000Oo.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.O0000Oo);
            }
            this.O0000Oo.removeAllViews();
            this.O0000Oo.destroy();
            this.O0000Oo = null;
        }
        try {
            if (this.O0000o00 != null) {
                this.O0000o00.removeCallbacks(this.O0000Ooo);
                this.O0000o00.removeMessages(1);
                this.O0000o00 = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void O00000o0() {
        if (this.O0000Oo != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.O0000Oo, "translationX", new float[]{0.0f, 2.0f, 4.0f, 2.0f, 0.0f, -2.0f, -4.0f, -2.0f, 0.0f, 2.0f, 4.0f, 2.0f, 0.0f, -2.0f, -4.0f, -2.0f, 0.0f});
            ofFloat.setDuration(500);
            ofFloat.start();
        }
    }
}
