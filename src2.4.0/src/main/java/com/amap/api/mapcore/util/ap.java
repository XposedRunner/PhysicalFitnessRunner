package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.net.URLEncoder;

/* compiled from: PerminssionUtil */
public class ap {
    private String O000000o;

    public static boolean O000000o(Context context) {
        String str = "android.permission.WRITE_EXTERNAL_STORAGE";
        return (context == null || TextUtils.isEmpty(str)) ? false : o0OOOO00.O000000o(context, str);
    }

    public ap O000000o(File file) {
        if (file == null) {
            return this;
        }
        this.O000000o = file.getAbsolutePath();
        return this;
    }

    public ap O000000o(String str) {
        this.O000000o = str;
        return this;
    }

    public String O000000o() {
        return this.O000000o;
    }

    public ap O00000Oo(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O000000o);
        stringBuilder.append(File.separator);
        stringBuilder.append(URLEncoder.encode(str));
        this.O000000o = stringBuilder.toString();
        return this;
    }
}
