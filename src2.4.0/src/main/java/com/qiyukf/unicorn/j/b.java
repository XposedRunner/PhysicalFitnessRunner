package com.qiyukf.unicorn.j;

import android.content.Context;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.a.a;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class b {
    public static String a(Context context, byte[] bArr, String str) {
        byte[] b = b(context, bArr, str);
        if (b == null) {
            return null;
        }
        try {
            return new String(b, HttpUtils.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    private static byte[] a(Context context, String str) {
        String f = com.qiyukf.unicorn.b.b.f();
        String string = Secure.getString(context.getContentResolver(), "android_id");
        String substring = str.substring(0, Math.min(8, str.length() - 1));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(substring);
        stringBuilder.append(f.substring(0, Math.min(8, f.length() - 1)));
        f = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(f);
        stringBuilder2.append(string.substring(0, Math.min(8, string.length() - 1)));
        string = stringBuilder2.toString();
        if (string.length() != 24) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(string);
            stringBuilder3.append(str.substring(8, 24 - string.length()));
            string = stringBuilder3.toString();
        }
        return string.getBytes();
    }

    public static byte[] a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(context, str2), "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
            instance.init(1, secretKeySpec);
            return instance.doFinal(str.getBytes(HttpUtils.ENCODING_UTF_8));
        } catch (Exception e) {
            a.c("ENC", "AES cipher error, enc failed");
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] b(Context context, byte[] bArr, String str) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(a(context, str), "AES");
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/NoPadding");
            instance.init(2, secretKeySpec);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            a.c("ENC", "AES cipher error, dec failed");
            e.printStackTrace();
            return null;
        }
    }
}
