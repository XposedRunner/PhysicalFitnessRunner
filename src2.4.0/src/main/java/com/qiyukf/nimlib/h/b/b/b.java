package com.qiyukf.nimlib.h.b.b;

import android.text.TextUtils;

public final class b {
    public String a;
    public int b;

    b(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(58);
            if (indexOf != -1) {
                this.a = str.substring(0, indexOf);
                try {
                    this.b = Integer.parseInt(str.substring(indexOf + 1));
                } catch (Exception unused) {
                }
                return;
            }
            this.a = str;
        }
    }

    public final String toString() {
        if ((TextUtils.isEmpty(this.a) ^ 1) == 0) {
            return "INVALID";
        }
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.a);
        if (this.b > 0) {
            StringBuilder stringBuilder3 = new StringBuilder(":");
            stringBuilder3.append(this.b);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        return stringBuilder2.toString();
    }
}
