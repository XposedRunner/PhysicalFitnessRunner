package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport.WebViewInterface;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BUGLY */
public class H5JavaScriptInterface {
    private static HashSet<Integer> a = new HashSet();
    private String b = null;
    private Thread c = null;
    private String d = null;
    private Map<String, String> e = null;

    private H5JavaScriptInterface() {
    }

    private static a a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.a = jSONObject.getString("projectRoot");
            if (aVar.a == null) {
                return null;
            }
            aVar.b = jSONObject.getString("context");
            if (aVar.b == null) {
                return null;
            }
            aVar.c = jSONObject.getString(SocialConstants.PARAM_URL);
            if (aVar.c == null) {
                return null;
            }
            aVar.d = jSONObject.getString("userAgent");
            if (aVar.d == null) {
                return null;
            }
            aVar.e = jSONObject.getString("language");
            if (aVar.e == null) {
                return null;
            }
            aVar.f = jSONObject.getString("name");
            if (aVar.f != null) {
                if (!aVar.f.equals("null")) {
                    String string = jSONObject.getString("stacktrace");
                    if (string == null) {
                        return null;
                    }
                    int indexOf = string.indexOf("\n");
                    if (indexOf < 0) {
                        x.d("H5 crash stack's format is wrong!", new Object[0]);
                        return null;
                    }
                    aVar.h = string.substring(indexOf + 1);
                    aVar.g = string.substring(0, indexOf);
                    int indexOf2 = aVar.g.indexOf(":");
                    if (indexOf2 > 0) {
                        aVar.g = aVar.g.substring(indexOf2 + 1);
                    }
                    aVar.i = jSONObject.getString("file");
                    if (aVar.f == null) {
                        return null;
                    }
                    aVar.j = jSONObject.getLong("lineNumber");
                    if (aVar.j < 0) {
                        return null;
                    }
                    aVar.k = jSONObject.getLong("columnNumber");
                    if (aVar.k < 0) {
                        return null;
                    }
                    x.a("H5 crash information is following: ", new Object[0]);
                    StringBuilder stringBuilder = new StringBuilder("[projectRoot]: ");
                    stringBuilder.append(aVar.a);
                    x.a(stringBuilder.toString(), new Object[0]);
                    stringBuilder = new StringBuilder("[context]: ");
                    stringBuilder.append(aVar.b);
                    x.a(stringBuilder.toString(), new Object[0]);
                    stringBuilder = new StringBuilder("[url]: ");
                    stringBuilder.append(aVar.c);
                    x.a(stringBuilder.toString(), new Object[0]);
                    stringBuilder = new StringBuilder("[userAgent]: ");
                    stringBuilder.append(aVar.d);
                    x.a(stringBuilder.toString(), new Object[0]);
                    stringBuilder = new StringBuilder("[language]: ");
                    stringBuilder.append(aVar.e);
                    x.a(stringBuilder.toString(), new Object[0]);
                    stringBuilder = new StringBuilder("[name]: ");
                    stringBuilder.append(aVar.f);
                    x.a(stringBuilder.toString(), new Object[0]);
                    stringBuilder = new StringBuilder("[message]: ");
                    stringBuilder.append(aVar.g);
                    x.a(stringBuilder.toString(), new Object[0]);
                    stringBuilder = new StringBuilder("[stacktrace]: \n");
                    stringBuilder.append(aVar.h);
                    x.a(stringBuilder.toString(), new Object[0]);
                    stringBuilder = new StringBuilder("[file]: ");
                    stringBuilder.append(aVar.i);
                    x.a(stringBuilder.toString(), new Object[0]);
                    stringBuilder = new StringBuilder("[lineNumber]: ");
                    stringBuilder.append(aVar.j);
                    x.a(stringBuilder.toString(), new Object[0]);
                    stringBuilder = new StringBuilder("[columnNumber]: ");
                    stringBuilder.append(aVar.k);
                    x.a(stringBuilder.toString(), new Object[0]);
                    return aVar;
                }
            }
            return null;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static H5JavaScriptInterface getInstance(WebViewInterface webViewInterface) {
        String str = null;
        if (webViewInterface == null || a.contains(Integer.valueOf(webViewInterface.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        a.add(Integer.valueOf(webViewInterface.hashCode()));
        h5JavaScriptInterface.c = Thread.currentThread();
        Thread thread = h5JavaScriptInterface.c;
        if (thread != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\n");
            for (int i = 2; i < thread.getStackTrace().length; i++) {
                StackTraceElement stackTraceElement = thread.getStackTrace()[i];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    stringBuilder.append(stackTraceElement.toString());
                    stringBuilder.append("\n");
                }
            }
            str = stringBuilder.toString();
        }
        h5JavaScriptInterface.d = str;
        HashMap hashMap = new HashMap();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(webViewInterface.getContentDescription());
        hashMap.put("[WebView] ContentDescription", stringBuilder2.toString());
        h5JavaScriptInterface.e = hashMap;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        x.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            x.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String b = z.b(str.getBytes());
        if (this.b == null || !this.b.equals(b)) {
            this.b = b;
            x.d("Handling JS exception ...", new Object[0]);
            a a = a(str);
            if (a == null) {
                x.d("Failed to parse payload.", new Object[0]);
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (a.a != null) {
                linkedHashMap2.put("[JS] projectRoot", a.a);
            }
            if (a.b != null) {
                linkedHashMap2.put("[JS] context", a.b);
            }
            if (a.c != null) {
                linkedHashMap2.put("[JS] url", a.c);
            }
            if (a.d != null) {
                linkedHashMap2.put("[JS] userAgent", a.d);
            }
            if (a.i != null) {
                linkedHashMap2.put("[JS] file", a.i);
            }
            if (a.j != 0) {
                linkedHashMap2.put("[JS] lineNumber", Long.toString(a.j));
            }
            linkedHashMap.putAll(linkedHashMap2);
            linkedHashMap.putAll(this.e);
            linkedHashMap.put("Java Stack", this.d);
            Thread thread = this.c;
            if (a != null) {
                InnerApi.postH5CrashAsync(thread, a.f, a.g, a.h, linkedHashMap);
            }
            return;
        }
        x.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
    }
}
