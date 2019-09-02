package cn.jiguang.d.a;

import android.content.Context;
import cn.jiguang.api.MultiSpHelper;
import cn.jiguang.g.b.d;
import cn.jiguang.g.i;
import java.io.Serializable;

public final class a {
    public static String a = "";
    public static int b = -1;
    public static boolean c;
    private static d d;

    public static long a(long j) {
        return (j + r()) / 1000;
    }

    public static String a(Context context) {
        return (String) g(context).a("push_udid", (Serializable) "");
    }

    public static void a() {
        g(null).b(new cn.jiguang.g.b.a().a("last_good_sis", null).a("last_good_sis_address", null).a("default_sis", null).a("last_good_conn_ip", null).a("last_good_conn_port", null).a("last_sis_request_time", Long.valueOf(0)).a("device_registered_appkey", null));
        d.h(null);
    }

    public static void a(int i) {
        MultiSpHelper.commitInt(cn.jiguang.d.a.d, "idc", i);
    }

    public static void a(Context context, int i) {
        d.a(context, "jpush_register_code", Integer.valueOf(i));
    }

    public static void a(Context context, String str) {
        g(context).b("device_channel", str);
    }

    public static void a(Context context, String str, String str2) {
        d.a(context, str, cn.jiguang.d.h.a.a.a(str2));
    }

    public static void a(String str, int i) {
        g(null).b(new cn.jiguang.g.b.a().a("last_good_conn_ip", str).a("last_good_conn_port", i));
    }

    public static void a(String str, String str2, String str3) {
        g(null).b(new cn.jiguang.g.b.a().a("device_main_imei", (Serializable) str).a("device_main_android_id", (Serializable) str2).a("device_main_mac", (Serializable) str3));
    }

    public static void a(boolean z) {
        g(null).b("sis_report_switch", Boolean.valueOf(z));
    }

    public static boolean a(String str) {
        if (str == null) {
            return true;
        }
        if (str.equalsIgnoreCase((String) g(null).a("last_connection_type", null))) {
            return false;
        }
        g(null).b("last_connection_type", str);
        return true;
    }

    public static String b() {
        return (String) g(null).a("last_good_conn_ip", null);
    }

    public static String b(Context context) {
        return (String) g(context).a("imei", (Serializable) "");
    }

    public static String b(Context context, String str) {
        return (String) g(context).a("option_channel", null);
    }

    public static String b(Context context, String str, String str2) {
        String str3 = (String) d.b(context, str, "");
        return i.a(str3) ? str2 : cn.jiguang.d.h.a.a.b(str3, str2);
    }

    private static void b(int i) {
        g(null).b("heartbeat_interval", Integer.valueOf(i));
    }

    public static void b(long j) {
        if (j > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            b.a(j, currentTimeMillis);
            g(null).b(new cn.jiguang.g.b.a().a("login_server_time", j).a("login_local_time", currentTimeMillis));
        }
    }

    public static void b(String str) {
        g(null).b("backup_user_addr", str);
    }

    public static void b(String str, int i) {
        g(null).b(new cn.jiguang.g.b.a().a("default_conn_ip", str).a("default_conn_port", i));
    }

    public static int c() {
        return ((Integer) g(null).a("last_good_conn_port", Integer.valueOf(0))).intValue();
    }

    public static String c(Context context) {
        return (String) g(context).a("device_registered_appkey", null);
    }

    public static void c(Context context, String str) {
        g(context).b("option_channel", str);
    }

    public static void c(String str) {
        g(null).b("last_good_sis", str);
    }

    public static String d(Context context) {
        return (String) g(context).a("device_config_appkey", null);
    }

    public static void d(Context context, String str) {
        g(context).b("sdk_version", str);
    }

    public static void d(String str) {
        g(null).b("default_sis", str);
    }

    public static boolean d() {
        return System.currentTimeMillis() - ((Long) g(null).a("last_sis_request_time", Long.valueOf(0))).longValue() > 180000;
    }

    public static String e(Context context) {
        return (String) g(context).a("udp_report_device_info", (Serializable) "");
    }

    public static void e() {
        g(null).b("last_sis_request_time", Long.valueOf(System.currentTimeMillis()));
    }

    public static void e(Context context, String str) {
        g(context).b("push_udid", str);
    }

    public static void e(String str) {
        g(null).b("sis_report_history", str);
    }

    public static synchronized long f() {
        long a;
        synchronized (a.class) {
            a = e.a();
        }
        return a;
    }

    public static void f(Context context) {
        g(context).b(new cn.jiguang.g.b.a().a("last_report_index", Long.valueOf(0)).a("last_good_sis", null).a("last_good_sis_address", null).a("default_sis", null).a("last_good_conn_ip", null).a("last_good_conn_port", null).a("last_sis_request_time", null).a("device_registered_appkey", null).a("heartbeat_interval", null).a("default_conn_ip", null).a("default_conn_port", null).a("sis_report_switch", null).a("sis_report_history", null));
    }

    public static void f(Context context, String str) {
        g(context).b("imei", str);
    }

    public static void f(String str) {
        g(null).b("last_good_sis_address", str);
    }

    public static int g() {
        return ((Integer) g(null).a("heartbeat_interval", Integer.valueOf(290))).intValue();
    }

    private static d g(Context context) {
        if (d == null) {
            d = d.a(context, "cn.jpush.preferences.v2");
        }
        return d;
    }

    public static String g(String str) {
        return (String) g(null).a("device_channel", (Serializable) str);
    }

    public static void g(Context context, String str) {
        g(context).b("device_config_appkey", str);
    }

    public static void h() {
        b(290);
    }

    public static void h(Context context, String str) {
        g(context).b("udp_report_device_info", str);
    }

    public static void h(String str) {
        g(null).b("device_registered_appkey", str);
    }

    public static void i() {
        b(86400);
    }

    public static boolean j() {
        return g() == 86400;
    }

    public static String k() {
        return (String) g(null).a("last_good_sis", null);
    }

    public static String l() {
        return (String) g(null).a("default_sis", null);
    }

    public static String m() {
        return (String) g(null).a("sis_report_history", (Serializable) "");
    }

    public static String n() {
        return (String) g(null).a("last_good_sis_address", null);
    }

    public static boolean o() {
        return ((Boolean) g(null).a("sis_report_switch", Boolean.valueOf(false))).booleanValue();
    }

    public static String p() {
        return (String) g(null).a("foo001", null);
    }

    public static long q() {
        return a(System.currentTimeMillis());
    }

    public static long r() {
        if (b.a()) {
            return b.b();
        }
        long j = 0;
        long longValue = ((Long) g(null).a("login_local_time", Long.valueOf(0))).longValue();
        long longValue2 = ((Long) g(null).a("login_server_time", Long.valueOf(0))).longValue();
        if (longValue != 0) {
            if (longValue2 == 0) {
                return 0;
            }
            b.a(longValue2, longValue);
            j = longValue2 - longValue;
        }
        return j;
    }

    public static c s() {
        return new c((String) g(null).a("device_main_imei", (Serializable) ""), (String) g(null).a("device_main_android_id", (Serializable) ""), (String) g(null).a("device_main_mac", (Serializable) ""));
    }

    public static boolean t() {
        return ((Boolean) d.b(null, "is_im_logged_in", Boolean.valueOf(false))).booleanValue();
    }

    public static int u() {
        return ((Integer) d.b(null, "im_login_count", Integer.valueOf(-1))).intValue();
    }

    public static int v() {
        return MultiSpHelper.getInt(cn.jiguang.d.a.d, "idc", -1);
    }
}
