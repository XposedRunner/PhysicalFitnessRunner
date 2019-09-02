package com.qiyukf.nimlib.d.e;

import android.content.SharedPreferences;
import cn.jiguang.net.HttpUtils;
import com.qiyukf.basesdk.c.d;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class c {
    private Map<String, Long> a;

    private static class a {
        private static final c a = new c();
    }

    private c() {
        this.a = new HashMap(10);
        this.a.put("KEY_REFRESH_STRATEGY", Long.valueOf(0));
        SharedPreferences k = k();
        this.a.put("KEY_DEVICE", Long.valueOf(k.getLong("KEY_DEVICE", 0)));
        this.a.put("KEY_OPERATOR", Long.valueOf(k.getLong("KEY_OPERATOR", 0)));
        this.a.put("KEY_APP_LIST", Long.valueOf(k.getLong("KEY_APP_LIST", 0)));
        this.a.put("KEY_APP_INFO", Long.valueOf(k.getLong("KEY_APP_INFO", 0)));
        this.a.put("KEY_WIFI_INFO", Long.valueOf(k.getLong("KEY_WIFI_INFO", 0)));
        this.a.put("KEY_WIFI_LIST", Long.valueOf(k.getLong("KEY_WIFI_LIST", 0)));
        this.a.put("KEY_GPS", Long.valueOf(k.getLong("KEY_GPS", 0)));
        this.a.put("KEY_CELL", Long.valueOf(k.getLong("KEY_CELL", 0)));
        this.a.put("KEY_COLLECT_ALL", Long.valueOf(0));
        StringBuilder stringBuilder = new StringBuilder("WatcherPreferences=");
        for (Entry entry : this.a.entrySet()) {
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            stringBuilder.append(entry.getValue());
            stringBuilder.append("; ");
        }
        com.qiyukf.nimlib.d.a.b.a.f(stringBuilder.toString());
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private long a(String str) {
        Long l = (Long) this.a.get(str);
        return l != null ? l.longValue() : 0;
    }

    private void a(String str, long j) {
        this.a.put(str, Long.valueOf(j));
        d.a(k(), str, j);
    }

    private static SharedPreferences k() {
        return com.qiyukf.nimlib.d.a.d().a().getSharedPreferences("NIM_DC_WATCHER_SP", 0);
    }

    /* Access modifiers changed, original: final */
    public final long a() {
        return ((Long) this.a.get("KEY_REFRESH_STRATEGY")).longValue();
    }

    /* Access modifiers changed, original: final */
    public final void a(long j) {
        this.a.put("KEY_REFRESH_STRATEGY", Long.valueOf(j));
    }

    /* Access modifiers changed, original: final */
    public final long b() {
        return a("KEY_DEVICE");
    }

    /* Access modifiers changed, original: final */
    public final void b(long j) {
        if (j > a("KEY_DEVICE")) {
            a("KEY_DEVICE", j);
        }
    }

    /* Access modifiers changed, original: final */
    public final long c() {
        return a("KEY_OPERATOR");
    }

    /* Access modifiers changed, original: final */
    public final void c(long j) {
        if (j > a("KEY_OPERATOR")) {
            a("KEY_OPERATOR", j);
        }
    }

    /* Access modifiers changed, original: final */
    public final long d() {
        return a("KEY_APP_LIST");
    }

    /* Access modifiers changed, original: final */
    public final void d(long j) {
        if (j > a("KEY_APP_LIST")) {
            a("KEY_APP_LIST", j);
        }
    }

    /* Access modifiers changed, original: final */
    public final long e() {
        return a("KEY_APP_INFO");
    }

    /* Access modifiers changed, original: final */
    public final void e(long j) {
        if (j > a("KEY_APP_INFO")) {
            a("KEY_APP_INFO", j);
        }
    }

    /* Access modifiers changed, original: final */
    public final long f() {
        return a("KEY_WIFI_INFO");
    }

    /* Access modifiers changed, original: final */
    public final void f(long j) {
        if (j > a("KEY_WIFI_INFO")) {
            a("KEY_WIFI_INFO", j);
        }
    }

    /* Access modifiers changed, original: final */
    public final long g() {
        return a("KEY_WIFI_LIST");
    }

    /* Access modifiers changed, original: final */
    public final void g(long j) {
        if (j > a("KEY_WIFI_LIST")) {
            a("KEY_WIFI_LIST", j);
        }
    }

    /* Access modifiers changed, original: final */
    public final long h() {
        return a("KEY_GPS");
    }

    /* Access modifiers changed, original: final */
    public final void h(long j) {
        if (j > a("KEY_GPS")) {
            a("KEY_GPS", j);
        }
    }

    /* Access modifiers changed, original: final */
    public final long i() {
        return a("KEY_CELL");
    }

    /* Access modifiers changed, original: final */
    public final void i(long j) {
        if (j > a("KEY_CELL")) {
            a("KEY_CELL", j);
        }
    }

    /* Access modifiers changed, original: final */
    public final long j() {
        return a("KEY_COLLECT_ALL");
    }

    /* Access modifiers changed, original: final */
    public final void j(long j) {
        this.a.put("KEY_COLLECT_ALL", Long.valueOf(j));
    }
}
