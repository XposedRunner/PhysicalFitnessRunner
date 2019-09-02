package com.baidu.mapsdkplatform.comapi.synchronization.d;

import cn.jiguang.net.HttpUtils;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.LinkedHashMap;
import java.util.Map;

public final class d {
    private Map<String, String> a;

    public d a(String str, String str2) {
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
        this.a.put(str, str2);
        return this;
    }

    public String a() {
        if (this.a == null || this.a.isEmpty()) {
            return null;
        }
        String str = new String();
        int i = 0;
        for (String str2 : this.a.keySet()) {
            StringBuilder stringBuilder;
            String encodeUrlParamsValue = AppMD5.encodeUrlParamsValue((String) this.a.get(str2));
            if (i == 0) {
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                str = HttpUtils.PARAMETERS_SEPARATOR;
            }
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            stringBuilder.append(encodeUrlParamsValue);
            str = stringBuilder.toString();
            i++;
        }
        return str;
    }
}
