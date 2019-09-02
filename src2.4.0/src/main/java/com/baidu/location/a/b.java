package com.baidu.location.a;

import android.os.Bundle;
import com.alibaba.wireless.security.SecExceptionCode;

public class b {
    private static Object a = new Object();
    private static b b;
    private int c = -1;

    public static b a() {
        b bVar;
        synchronized (a) {
            if (b == null) {
                b = new b();
            }
            bVar = b;
        }
        return bVar;
    }

    public void a(int i, int i2, String str) {
        if (i2 != this.c) {
            this.c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            a.a().a(bundle, (int) SecExceptionCode.SEC_ERROR_STA_NO_DATA_FILE);
        }
    }

    public void b() {
        this.c = -1;
    }
}
