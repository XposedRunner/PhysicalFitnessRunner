package com.qiyukf.unicorn.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qiyukf.nimlib.b;
import com.qiyukf.unicorn.api.SavePowerConfig;

public final class d {
    private SharedPreferences a;

    private d(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder("qiyu_save_");
        stringBuilder.append(str);
        this.a = context.getSharedPreferences(stringBuilder.toString(), 0);
    }

    public static d a() {
        return new d(b.a(), b.g());
    }

    public final void a(long j) {
        com.qiyukf.basesdk.c.d.a(this.a, "last_check_time", j);
    }

    public final void a(SavePowerConfig savePowerConfig) {
        String str;
        Editor putLong;
        int i;
        if (savePowerConfig == null) {
            str = "smp_cp";
            putLong = this.a.edit().putLong("saver_delay", -1).putLong("check_interval", -1);
        } else {
            putLong = this.a.edit().putLong("saver_delay", savePowerConfig.activeDelay).putLong("check_interval", savePowerConfig.checkInterval);
            str = "smp_cp";
            if (savePowerConfig.customPush) {
                i = 1;
                com.qiyukf.basesdk.c.d.a(putLong.putInt(str, i));
            }
        }
        i = 0;
        com.qiyukf.basesdk.c.d.a(putLong.putInt(str, i));
    }

    public final void a(boolean z) {
        com.qiyukf.basesdk.c.d.a(this.a, "YSF_PUSH_TOGGLE", z);
    }

    public final void b() {
        com.qiyukf.basesdk.c.d.a(this.a.edit().clear());
    }

    public final void b(long j) {
        com.qiyukf.basesdk.c.d.a(this.a, "k_latest_msg", j);
    }

    public final long c() {
        return this.a.getLong("last_check_time", System.currentTimeMillis());
    }

    public final void c(long j) {
        com.qiyukf.basesdk.c.d.a(this.a, "ysf_visitor", j);
    }

    public final int d() {
        return this.a.getInt("saver_mode", 0);
    }

    public final void d(long j) {
        com.qiyukf.basesdk.c.d.a(this.a, "ysf_pkg", j);
    }

    public final void e() {
        com.qiyukf.basesdk.c.d.a(this.a, "saver_mode", 1);
    }

    public final SavePowerConfig f() {
        long j = this.a.getLong("saver_delay", -1);
        long j2 = this.a.getLong("check_interval", -1);
        int i = this.a.getInt("smp_cp", 0);
        if (j < 0 || j2 < 0) {
            return null;
        }
        return new SavePowerConfig(i == 1, j, j2);
    }

    public final long g() {
        return this.a.getLong("k_latest_msg", 0);
    }

    public final boolean h() {
        return this.a.getBoolean("YSF_PUSH_TOGGLE", false);
    }

    public final long i() {
        return this.a.getLong("ysf_visitor", 0);
    }

    public final long j() {
        return this.a.getLong("ysf_pkg", 0);
    }
}
