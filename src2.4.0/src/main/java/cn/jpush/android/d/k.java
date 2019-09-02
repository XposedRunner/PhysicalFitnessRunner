package cn.jpush.android.d;

import cn.jiguang.api.JCoreInterface;

public final class k {
    private String a;
    private String b;
    private boolean c = false;
    private long d;

    public k(String str, String str2) {
        if (JCoreInterface.getDebugMode()) {
            this.a = str;
            this.b = str2;
            this.d = System.currentTimeMillis();
        }
    }

    public final void a() {
        if (JCoreInterface.getDebugMode() && !this.c) {
            this.d = System.currentTimeMillis();
        }
    }
}
