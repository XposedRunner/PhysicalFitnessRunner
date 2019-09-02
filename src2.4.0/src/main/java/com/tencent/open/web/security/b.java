package com.tencent.open.web.security;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.jiguang.net.HttpUtils;
import com.tencent.open.a;
import com.tencent.open.a.f;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
public class b extends a {
    public void a(String str, String str2, List<String> list, a.a aVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->getResult, objectName: ");
        stringBuilder.append(str);
        stringBuilder.append(" | methodName: ");
        stringBuilder.append(str2);
        f.a("openSDK_LOG.SecureJsBridge", stringBuilder.toString());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                list.set(i, URLDecoder.decode((String) list.get(i), HttpUtils.ENCODING_UTF_8));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        com.tencent.open.a.b bVar = (com.tencent.open.a.b) this.a.get(str);
        if (bVar != null) {
            f.b("openSDK_LOG.SecureJsBridge", "-->handler != null");
            bVar.call(str2, list, aVar);
            return;
        }
        f.b("openSDK_LOG.SecureJsBridge", "-->handler == null");
        if (aVar != null) {
            aVar.a();
        }
    }

    public boolean a(WebView webView, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->canHandleUrl---url = ");
        stringBuilder.append(str);
        f.a("openSDK_LOG.SecureJsBridge", stringBuilder.toString());
        if (str == null || !Uri.parse(str).getScheme().equals("jsbridge")) {
            return false;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/#");
        ArrayList arrayList = new ArrayList(Arrays.asList(stringBuilder.toString().split(HttpUtils.PATHS_SEPARATOR)));
        if (arrayList.size() < 7) {
            return false;
        }
        String str2 = (String) arrayList.get(2);
        String str3 = (String) arrayList.get(3);
        String str4 = (String) arrayList.get(4);
        String str5 = (String) arrayList.get(5);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("-->canHandleUrl, objectName: ");
        stringBuilder2.append(str2);
        stringBuilder2.append(" | methodName: ");
        stringBuilder2.append(str3);
        stringBuilder2.append(" | snStr: ");
        stringBuilder2.append(str4);
        f.a("openSDK_LOG.SecureJsBridge", stringBuilder2.toString());
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return false;
        }
        try {
            a(str2, str3, arrayList.subList(6, arrayList.size() - 1), new c(webView, Long.parseLong(str4), str, str5));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
