package com.zjwh.android_wh_physicalfitness.view.jsbridge;

import android.webkit.WebView;

/* compiled from: BridgeUtil */
public class O00000Oo {
    public static final String O000000o = "zjwhjs://";
    public static final String O00000Oo = "zjwhjs://return/";
    static final String O00000o = "";
    static final String O00000o0 = "zjwhjs://return/_fetchQueue/";
    static final String O00000oO = "_";
    static final String O00000oo = "/";
    static final String O0000O0o = "JAVA_CB_%s";
    static final String O0000OOo = "javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');";
    public static final String O0000Oo = "javascript:";
    static final String O0000Oo0 = "javascript:WebViewJavascriptBridge._fetchQueue();";

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c A:{SYNTHETIC, Splitter:B:26:0x004c} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0058 A:{SYNTHETIC, Splitter:B:33:0x0058} */
    public static java.lang.String O000000o(android.content.Context r4, java.lang.String r5) {
        /*
        r0 = 0;
        r4 = r4.getAssets();	 Catch:{ Exception -> 0x0045, all -> 0x0042 }
        r4 = r4.open(r5);	 Catch:{ Exception -> 0x0045, all -> 0x0042 }
        r5 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0040 }
        r1 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0040 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x0040 }
        r5.<init>(r1);	 Catch:{ Exception -> 0x0040 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0040 }
        r1.<init>();	 Catch:{ Exception -> 0x0040 }
    L_0x0018:
        r2 = r5.readLine();	 Catch:{ Exception -> 0x0040 }
        if (r2 == 0) goto L_0x0029;
    L_0x001e:
        r3 = "^\\s*\\/\\/.*";
        r3 = r2.matches(r3);	 Catch:{ Exception -> 0x0040 }
        if (r3 != 0) goto L_0x0029;
    L_0x0026:
        r1.append(r2);	 Catch:{ Exception -> 0x0040 }
    L_0x0029:
        if (r2 != 0) goto L_0x0018;
    L_0x002b:
        r5.close();	 Catch:{ Exception -> 0x0040 }
        r4.close();	 Catch:{ Exception -> 0x0040 }
        r5 = r1.toString();	 Catch:{ Exception -> 0x0040 }
        if (r4 == 0) goto L_0x003f;
    L_0x0037:
        r4.close();	 Catch:{ IOException -> 0x003b }
        goto L_0x003f;
    L_0x003b:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x003f:
        return r5;
    L_0x0040:
        r5 = move-exception;
        goto L_0x0047;
    L_0x0042:
        r5 = move-exception;
        r4 = r0;
        goto L_0x0056;
    L_0x0045:
        r5 = move-exception;
        r4 = r0;
    L_0x0047:
        r5.printStackTrace();	 Catch:{ all -> 0x0055 }
        if (r4 == 0) goto L_0x0054;
    L_0x004c:
        r4.close();	 Catch:{ IOException -> 0x0050 }
        goto L_0x0054;
    L_0x0050:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0054:
        return r0;
    L_0x0055:
        r5 = move-exception;
    L_0x0056:
        if (r4 == 0) goto L_0x0060;
    L_0x0058:
        r4.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x0060;
    L_0x005c:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0060:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.view.jsbridge.O00000Oo.O000000o(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String O000000o(String str) {
        return str.replace("javascript:WebViewJavascriptBridge.", "").replaceAll("\\(.*\\);", "");
    }

    public static void O000000o(WebView webView, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("var newscript = document.createElement(\"script\");");
        stringBuilder.append("newscript.src=\"");
        stringBuilder.append(str);
        stringBuilder.append("\";");
        str = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);");
        str = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(O0000Oo);
        stringBuilder2.append(str);
        webView.loadUrl(stringBuilder2.toString());
    }

    public static String O00000Oo(String str) {
        if (str.startsWith(O00000o0)) {
            return str.replace(O00000o0, "");
        }
        String[] split = str.replace(O00000Oo, "").split(O00000oo);
        if (split.length < 2) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < split.length; i++) {
            stringBuilder.append(split[i]);
        }
        return stringBuilder.toString();
    }

    public static void O00000Oo(WebView webView, String str) {
        str = O000000o(webView.getContext(), str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O0000Oo);
        stringBuilder.append(str);
        webView.loadUrl(stringBuilder.toString());
    }

    public static String O00000o0(String str) {
        String[] split = str.replace(O00000Oo, "").split(O00000oo);
        return split.length >= 1 ? split[0] : null;
    }
}
