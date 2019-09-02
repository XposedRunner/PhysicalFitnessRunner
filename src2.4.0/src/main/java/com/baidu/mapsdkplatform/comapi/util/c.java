package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;

public class c {
    private ArrayList<Integer> a;
    private Context b;

    private static class a {
        private static final c a = new c();
    }

    private c() {
        this.a = new ArrayList();
    }

    /* synthetic */ c(d dVar) {
        this();
    }

    private int a(String str) {
        return this.b == null ? -101 : this.b.getSharedPreferences("ad_auth", 0).getInt(str, 0);
    }

    public static c a() {
        return a.a;
    }

    private void a(String str, int i) {
        if (this.b != null) {
            this.b.getSharedPreferences("ad_auth", 0).edit().putInt(str, i).apply();
        }
    }

    public void a(int i) {
        if (i == -1) {
            i = a("ad_key");
            if (i == -101) {
                return;
            }
        }
        for (int i2 = i; i2 != 0; i2 /= 2) {
            this.a.add(Integer.valueOf(i2 % 2));
        }
        a("ad_key", i);
    }

    public void a(Context context) {
        this.b = context;
    }

    public boolean b() {
        return this.a != null && this.a.size() > 0 && ((Integer) this.a.get(0)).intValue() == 1;
    }
}
