package com.ximalaya.ting.android.xmpayordersdk;

import android.text.TextUtils;

/* compiled from: PayFinishModel */
public class O00000Oo {
    private int O000000o;
    private String O00000Oo;

    public O00000Oo(int i, String str) {
        this.O000000o = i;
        this.O00000Oo = str;
    }

    public static O00000Oo O000000o(int i, String str) {
        String str2 = (String) O000000o.O000O0OO.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            str = TextUtils.isEmpty(str2) ? "网络错误" : str2;
        }
        return new O00000Oo(i, str);
    }

    public static O00000Oo O00000Oo(int i) {
        String str = (String) O000000o.O000O0OO.get(Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            str = "网络错误";
        }
        return new O00000Oo(i, str);
    }

    public int O000000o() {
        return this.O000000o;
    }

    public void O000000o(int i) {
        this.O000000o = i;
    }

    public void O000000o(String str) {
        this.O00000Oo = str;
    }

    public String O00000Oo() {
        return this.O00000Oo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PayFinishModel{code=");
        stringBuilder.append(this.O000000o);
        stringBuilder.append(", des='");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
