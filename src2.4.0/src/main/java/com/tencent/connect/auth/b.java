package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* compiled from: ProGuard */
public class b {
    public static b a = null;
    static final /* synthetic */ boolean d = true;
    private static int e;
    public HashMap<String, a> b = new HashMap();
    public final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* compiled from: ProGuard */
    public static class a {
        public IUiListener a;
        public a b;
        public String c;
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public static int b() {
        int i = e + 1;
        e = i;
        return i;
    }

    public String a(a aVar) {
        int b = b();
        try {
            HashMap hashMap = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(b);
            hashMap.put(stringBuilder.toString(), aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("");
        stringBuilder2.append(b);
        return stringBuilder2.toString();
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] toCharArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = toCharArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            stringBuffer.append(toCharArray[(int) (Math.random() * ((double) length))]);
        }
        return stringBuffer.toString();
    }
}
