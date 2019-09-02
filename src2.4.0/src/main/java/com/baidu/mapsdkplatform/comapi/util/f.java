package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public final class f {
    private final boolean a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    f(Context context) {
        this.a = false;
        this.b = Environment.getExternalStorageDirectory().getAbsolutePath();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append(File.separator);
        stringBuilder.append("BaiduMapSDKNew");
        this.c = stringBuilder.toString();
        this.d = context.getCacheDir().getAbsolutePath();
        this.e = "";
        this.f = "";
    }

    f(String str, boolean z, String str2, Context context) {
        this.a = z;
        this.b = str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append(File.separator);
        stringBuilder.append("BaiduMapSDKNew");
        this.c = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(File.separator);
        stringBuilder.append("cache");
        this.d = stringBuilder.toString();
        this.e = context.getCacheDir().getAbsolutePath();
        this.f = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append(File.separator);
        stringBuilder.append("BaiduMapSDKNew");
        return stringBuilder.toString();
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == null || !f.class.isInstance(obj)) {
            return false;
        }
        return this.b.equals(((f) obj).b);
    }
}
