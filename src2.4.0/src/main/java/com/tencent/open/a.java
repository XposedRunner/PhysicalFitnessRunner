package com.tencent.open;

import android.net.Uri;
import android.webkit.WebView;
import cn.jiguang.net.HttpUtils;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public class a {
    protected HashMap<String, b> a = new HashMap();

    /* compiled from: ProGuard */
    public static class b {
        public void call(String str, List<String> list, a aVar) {
            String str2;
            Method method;
            Method[] declaredMethods = getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                str2 = null;
                if (i >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i];
                if (method.getName().equals(str) && method.getParameterTypes().length == list.size()) {
                    break;
                }
                i++;
            }
            if (method != null) {
                try {
                    Object invoke;
                    switch (list.size()) {
                        case 0:
                            invoke = method.invoke(this, new Object[0]);
                            break;
                        case 1:
                            invoke = method.invoke(this, new Object[]{list.get(0)});
                            break;
                        case 2:
                            invoke = method.invoke(this, new Object[]{list.get(0), list.get(1)});
                            break;
                        case 3:
                            invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2)});
                            break;
                        case 4:
                            invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3)});
                            break;
                        case 5:
                            invoke = method.invoke(this, new Object[]{list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)});
                            break;
                        default:
                            Object[] objArr = new Object[6];
                            objArr[0] = list.get(0);
                            objArr[1] = list.get(1);
                            objArr[2] = list.get(2);
                            objArr[3] = list.get(3);
                            objArr[4] = list.get(4);
                            objArr[5] = list.get(5);
                            invoke = method.invoke(this, objArr);
                            break;
                    }
                    Class returnType = method.getReturnType();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("-->call, result: ");
                    stringBuilder.append(invoke);
                    stringBuilder.append(" | ReturnType: ");
                    stringBuilder.append(returnType.getName());
                    f.b("openSDK_LOG.JsBridge", stringBuilder.toString());
                    if (!"void".equals(returnType.getName())) {
                        if (returnType != Void.class) {
                            if (aVar != null && customCallback()) {
                                if (invoke != null) {
                                    str2 = invoke.toString();
                                }
                                aVar.a(str2);
                            }
                            return;
                        }
                    }
                    if (aVar != null) {
                        aVar.a(null);
                    }
                    return;
                } catch (Exception e) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("-->handler call mehtod ex. targetMethod: ");
                    stringBuilder2.append(method);
                    f.b("openSDK_LOG.JsBridge", stringBuilder2.toString(), e);
                    if (aVar != null) {
                        aVar.a();
                    }
                    return;
                }
            }
            if (aVar != null) {
                aVar.a();
            }
        }

        public boolean customCallback() {
            return false;
        }
    }

    /* compiled from: ProGuard */
    public static class a {
        protected WeakReference<WebView> a;
        protected long b;
        protected String c;

        public a(WebView webView, long j, String str) {
            this.a = new WeakReference(webView);
            this.b = j;
            this.c = str;
        }

        public void a() {
            WebView webView = (WebView) this.a.get();
            if (webView != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("javascript:window.JsBridge&&JsBridge.callback(");
                stringBuilder.append(this.b);
                stringBuilder.append(",{'r':1,'result':'no such method'})");
                webView.loadUrl(stringBuilder.toString());
            }
        }

        public void a(Object obj) {
            WebView webView = (WebView) this.a.get();
            if (webView != null) {
                String str = "'undefined'";
                if (obj instanceof String) {
                    String replace = ((String) obj).replace("\\", "\\\\").replace("'", "\\'");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("'");
                    stringBuilder.append(replace);
                    stringBuilder.append("'");
                    str = stringBuilder.toString();
                } else if ((obj instanceof Number) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Float)) {
                    str = obj.toString();
                } else if (obj instanceof Boolean) {
                    str = obj.toString();
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("javascript:window.JsBridge&&JsBridge.callback(");
                stringBuilder2.append(this.b);
                stringBuilder2.append(",{'r':0,'result':");
                stringBuilder2.append(str);
                stringBuilder2.append("});");
                webView.loadUrl(stringBuilder2.toString());
            }
        }

        public void a(String str) {
            WebView webView = (WebView) this.a.get();
            if (webView != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("javascript:");
                stringBuilder.append(str);
                webView.loadUrl(stringBuilder.toString());
            }
        }
    }

    public void a(b bVar, String str) {
        this.a.put(str, bVar);
    }

    public void a(String str, String str2, List<String> list, a aVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getResult---objName = ");
        stringBuilder.append(str);
        stringBuilder.append(" methodName = ");
        stringBuilder.append(str2);
        f.a("openSDK_LOG.JsBridge", stringBuilder.toString());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode((String) list.get(i), HttpUtils.ENCODING_UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        b bVar = (b) this.a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.JsBridge", "call----");
            bVar.call(str2, list, aVar);
            return;
        }
        f.b("openSDK_LOG.JsBridge", "not call----objName NOT FIND");
        if (aVar != null) {
            aVar.a();
        }
    }

    public boolean a(WebView webView, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->canHandleUrl---url = ");
        stringBuilder.append(str);
        f.a("openSDK_LOG.JsBridge", stringBuilder.toString());
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/#");
        ArrayList arrayList = new ArrayList(Arrays.asList(stringBuilder.toString().split(HttpUtils.PATHS_SEPARATOR)));
        if (arrayList.size() < 6) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        List subList = arrayList.subList(4, arrayList.size() - 1);
        a aVar = new a(webView, 4, str);
        webView.getUrl();
        a(str2, str3, subList, aVar);
        return true;
    }
}
