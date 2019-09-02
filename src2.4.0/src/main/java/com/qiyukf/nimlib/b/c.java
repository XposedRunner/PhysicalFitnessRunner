package com.qiyukf.nimlib.b;

import com.tencent.stat.DeviceInfo;
import com.umeng.commonsdk.framework.UMModuleRegister;

public final class c extends a {

    private static class a {
        private static final c a = new c();
    }

    public static c e() {
        return a.a;
    }

    public final void a(String str) {
        super.a(str, UMModuleRegister.PUSH);
    }

    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    /* Access modifiers changed, original: final */
    public final String b() {
        return DeviceInfo.TAG_IMEI;
    }

    public final /* bridge */ /* synthetic */ String c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
