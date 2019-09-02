package cn.jiguang.d.h;

import java.text.SimpleDateFormat;
import java.util.Locale;

final class d extends ThreadLocal<SimpleDateFormat> {
    private String a;

    d(String str) {
        this.a = str;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object initialValue() {
        return new SimpleDateFormat(this.a, Locale.ENGLISH);
    }
}
