package com.baidu.location.e;

import com.alibaba.wireless.security.SecExceptionCode;
import java.util.Locale;

public class a {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public char i;
    public String j;
    private boolean k;

    public a() {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.g = 0;
        this.h = -1;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.g = System.currentTimeMillis();
    }

    public a(int i, int i2, int i3, int i4, int i5, char c) {
        this.a = -1;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.e = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.g = 0;
        this.h = -1;
        this.i = '0';
        this.j = null;
        this.k = false;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.h = i5;
        this.i = c;
        this.g = System.currentTimeMillis();
    }

    public a(a aVar) {
        this(aVar.a, aVar.b, aVar.c, aVar.d, aVar.h, aVar.i);
        this.g = aVar.g;
    }

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.g > 0 && currentTimeMillis - this.g < 3000;
    }

    public boolean a(a aVar) {
        return this.a == aVar.a && this.b == aVar.b && this.d == aVar.d && this.c == aVar.c;
    }

    public boolean b() {
        return this.a > -1 && this.b > 0;
    }

    public boolean c() {
        return this.a == -1 && this.b == -1 && this.d == -1 && this.c == -1;
    }

    public boolean d() {
        return this.a > -1 && this.b > -1 && this.d == -1 && this.c == -1;
    }

    public boolean e() {
        return this.a > -1 && this.b > -1 && this.d > -1 && this.c > -1;
    }

    public void f() {
        this.k = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(this.b + 23);
        stringBuffer.append("H");
        stringBuffer.append(this.a + 45);
        stringBuffer.append("K");
        stringBuffer.append(this.d + 54);
        stringBuffer.append("Q");
        stringBuffer.append(this.c + SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE);
        return stringBuffer.toString();
    }

    public String h() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.h)}));
        if (this.k) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }

    public String i() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(this.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.h)}));
        return stringBuffer.toString();
    }
}
