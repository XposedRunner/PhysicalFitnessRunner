package com.geetest.mobinfo;

import com.bangcle.andJni.JniLib1557756502;
import java.io.BufferedInputStream;

/* compiled from: CommandUtil */
public class m {

    /* compiled from: CommandUtil */
    private static class a {
        private static final m a = new m();
    }

    private m() {
    }

    public static m a() {
        return (m) JniLib1557756502.cL(Integer.valueOf(137));
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[512];
        StringBuilder stringBuilder = new StringBuilder();
        int read;
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    stringBuilder.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception unused) {
            }
        } while (read >= 512);
        return stringBuilder.toString();
    }

    public String a(String str) {
        return (String) JniLib1557756502.cL(this, str, Integer.valueOf(136));
    }
}
