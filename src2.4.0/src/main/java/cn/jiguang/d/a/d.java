package cn.jiguang.d.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.g.b.a;
import cn.jiguang.g.i;
import java.io.Serializable;

public final class d {
    private static volatile cn.jiguang.g.b.d a;

    public static int a() {
        return ((Integer) u(null).a("session_id", Integer.valueOf(0))).intValue();
    }

    public static String a(Context context) {
        return (String) u(context).a("device_registration_id", (Serializable) "");
    }

    public static void a(Context context, int i) {
        u(context).b("session_id", Integer.valueOf(i));
    }

    public static void a(Context context, long j) {
        u(context).b("services_launched_time", Long.valueOf(j));
    }

    public static void a(Context context, long j, String str, String str2, String str3) {
        a a = new a().a("device_uid", Long.valueOf(j)).a("device_password", str).a("device_registration_id", str2);
        if (!i.a(str3)) {
            a.a("devcie_id_generated", str3);
        }
        u(context).b(a);
        a.h(cn.jiguang.d.a.b(context));
    }

    public static void a(Context context, a aVar) {
        u(context).b(aVar);
    }

    public static <T extends Serializable> void a(Context context, String str, T t) {
        u(context).b(str, t);
    }

    public static void a(Context context, String str, String str2) {
        cn.jiguang.g.b.d u = u(context);
        StringBuilder stringBuilder = new StringBuilder("sdk_version_");
        stringBuilder.append(str);
        u.b(stringBuilder.toString(), str2);
    }

    public static void a(Context context, boolean z) {
        u(context).b("upload_crash", Boolean.valueOf(z));
    }

    public static void a(String str) {
        u(null).b("brd", str);
    }

    public static boolean a(Context context, String str) {
        return u(context).b("devcie_id_generated", str);
    }

    public static a b(Context context, a aVar) {
        return u(context).a(aVar);
    }

    public static <T extends Serializable> T b(Context context, String str, T t) {
        return u(context).a(str, (Serializable) t);
    }

    public static String b(Context context) {
        return (String) u(context).a("devcie_id_generated", (Serializable) "");
    }

    public static String b(Context context, String str) {
        cn.jiguang.g.b.d u = u(context);
        StringBuilder stringBuilder = new StringBuilder("sdk_version_");
        stringBuilder.append(str);
        return (String) u.a(stringBuilder.toString(), (Serializable) "");
    }

    public static void b(Context context, int i) {
        u(context).b("sp_state", Integer.valueOf(i));
    }

    public static void b(Context context, long j) {
        u(context).b("whitelist_wakeup_time", Long.valueOf(j));
    }

    public static void b(Context context, boolean z) {
        u(context).b("is_tcp_close", Boolean.valueOf(z));
    }

    public static void b(String str) {
        u(null).b("last_location", str);
    }

    public static boolean b() {
        return ((Boolean) u(null).a("upload_crash", Boolean.valueOf(true))).booleanValue();
    }

    public static long c(Context context) {
        return ((Long) u(context).a("device_uid", Long.valueOf(0))).longValue();
    }

    public static String c() {
        return (String) u(null).a("brd", (Serializable) "");
    }

    public static void c(Context context, long j) {
        u(context).b("last_update_report_urls", Long.valueOf(j));
    }

    public static void c(Context context, String str) {
        u(context).b("analytics_account_id", str);
    }

    public static void c(Context context, boolean z) {
        u(context).b("tcp_loggedin", Boolean.valueOf(z));
    }

    public static long d(Context context, long j) {
        return ((Long) u(context).a("report_urls_ttl_millis", Long.valueOf(3600000))).longValue();
    }

    public static void d(Context context, String str) {
        u(context).b("report_urls", str);
    }

    public static void d(Context context, boolean z) {
        u(context).b("power_save_is_enbale", Boolean.valueOf(z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a A:{Catch:{ Throwable -> 0x0086 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0010 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|(3:4|5|6)|7|8|(2:16|(4:22|(4:24|(1:26)|27|(1:29))|30|31)(2:20|21))(2:14|15)) */
    public static boolean d() {
        /*
        r0 = 0;
        r1 = cn.jiguang.g.a.a.c();	 Catch:{ Throwable -> 0x0086 }
        if (r1 == 0) goto L_0x0010;
    L_0x0007:
        r1 = cn.jiguang.g.a.a.b();	 Catch:{ Throwable -> 0x0010 }
        r1 = r1.a();	 Catch:{ Throwable -> 0x0010 }
        return r1;
    L_0x0010:
        r1 = cn.jiguang.d.a.d;	 Catch:{ Throwable -> 0x0086 }
        r2 = cn.jpush.android.service.PushService.class;
        r2 = r2.getCanonicalName();	 Catch:{ Throwable -> 0x0086 }
        r1 = cn.jiguang.g.a.h(r1, r2);	 Catch:{ Throwable -> 0x0086 }
        r2 = cn.jiguang.d.a.d;	 Catch:{ Throwable -> 0x0086 }
        r2 = cn.jiguang.d.b.a.c(r2);	 Catch:{ Throwable -> 0x0086 }
        r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0086 }
        if (r3 != 0) goto L_0x003c;
    L_0x0028:
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0086 }
        if (r3 != 0) goto L_0x003c;
    L_0x002e:
        r1 = r2.equals(r1);	 Catch:{ Throwable -> 0x0086 }
        if (r1 == 0) goto L_0x003c;
    L_0x0034:
        cn.jiguang.d.b.d.a();	 Catch:{ Throwable -> 0x0086 }
        r1 = cn.jiguang.d.b.d.d();	 Catch:{ Throwable -> 0x0086 }
        return r1;
    L_0x003c:
        r1 = cn.jiguang.d.b.a.c();	 Catch:{ Throwable -> 0x0086 }
        if (r1 != 0) goto L_0x0052;
    L_0x0042:
        r1 = cn.jiguang.d.a.d;	 Catch:{ Throwable -> 0x0086 }
        r1 = cn.jiguang.d.b.a.b(r1);	 Catch:{ Throwable -> 0x0086 }
        if (r1 == 0) goto L_0x0052;
    L_0x004a:
        cn.jiguang.d.b.d.a();	 Catch:{ Throwable -> 0x0086 }
        r1 = cn.jiguang.d.b.d.d();	 Catch:{ Throwable -> 0x0086 }
        return r1;
    L_0x0052:
        r1 = cn.jiguang.d.a.d;	 Catch:{ Throwable -> 0x0086 }
        r1 = cn.jiguang.g.a.b(r1);	 Catch:{ Throwable -> 0x0086 }
        if (r1 != 0) goto L_0x006f;
    L_0x005a:
        r1 = cn.jiguang.d.a.d;	 Catch:{ Throwable -> 0x0086 }
        if (r1 == 0) goto L_0x0068;
    L_0x005e:
        r1 = cn.jiguang.d.d.i.a();	 Catch:{ Throwable -> 0x0086 }
        r2 = cn.jiguang.d.a.d;	 Catch:{ Throwable -> 0x0086 }
        r3 = 0;
        r1.c(r2, r3, r3);	 Catch:{ Throwable -> 0x0086 }
    L_0x0068:
        r1 = cn.jiguang.d.b.a.c();	 Catch:{ Throwable -> 0x0086 }
        if (r1 == 0) goto L_0x006f;
    L_0x006e:
        return r0;
    L_0x006f:
        r1 = cn.jiguang.d.a.d;	 Catch:{ Throwable -> 0x0086 }
        r1 = u(r1);	 Catch:{ Throwable -> 0x0086 }
        r2 = "tcp_loggedin";
        r3 = java.lang.Boolean.valueOf(r0);	 Catch:{ Throwable -> 0x0086 }
        r1 = r1.a(r2, r3);	 Catch:{ Throwable -> 0x0086 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ Throwable -> 0x0086 }
        r1 = r1.booleanValue();	 Catch:{ Throwable -> 0x0086 }
        return r1;
    L_0x0086:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.a.d.d():boolean");
    }

    public static boolean d(Context context) {
        if (c(context) <= 0 || TextUtils.isEmpty(a(context))) {
            return false;
        }
        String b = cn.jiguang.d.a.b(context);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        String c = a.c(context);
        return !TextUtils.isEmpty(c) && TextUtils.equals(b, c);
    }

    public static String e(Context context) {
        return (String) u(context).a("device_password", (Serializable) "");
    }

    public static void e(Context context, long j) {
        u(context).b("report_urls_ttl_millis", Long.valueOf(j));
    }

    public static void e(Context context, String str) {
        u(context).b("report_sis_urls", str);
    }

    public static void f(Context context) {
        u(context).b(new a().a("device_uid", Long.valueOf(0)).a("device_password", "").a("device_registration_id", "").a("devcie_id_generated", "").a("device_appkey", "").a("session_id", 0).a("brd", ""));
    }

    public static void f(Context context, long j) {
        u(context).b("key_share_process_uuid_creattime", Long.valueOf(j));
    }

    public static void f(Context context, String str) {
        u(context).b("key_share_process_uuid", str);
    }

    public static void g(Context context) {
        u(context).b(new a().a("device_uid", Long.valueOf(0)).a("device_password", "").a("device_registration_id", "").a("devcie_id_generated", ""));
        a.h(null);
    }

    public static void h(Context context) {
        u(null).b(new a().a("device_uid", Long.valueOf(0)).a("device_password", "").a("device_registration_id", ""));
    }

    public static boolean i(Context context) {
        return ((Boolean) u(context).a("is_tcp_close", Boolean.valueOf(false))).booleanValue();
    }

    public static long j(Context context) {
        return ((Long) u(context).a("services_launched_time", Long.valueOf(-1))).longValue();
    }

    public static long k(Context context) {
        return ((Long) u(context).a("whitelist_wakeup_time", Long.valueOf(-1))).longValue();
    }

    public static String l(Context context) {
        return (String) u(context).a("last_location", (Serializable) "");
    }

    public static String m(Context context) {
        return (String) u(context).a("analytics_account_id", (Serializable) "");
    }

    public static long n(Context context) {
        return ((Long) u(context).a("last_update_report_urls", Long.valueOf(0))).longValue();
    }

    public static String o(Context context) {
        return (String) u(context).a("report_urls", (Serializable) "");
    }

    public static String p(Context context) {
        return (String) u(context).a("report_sis_urls", (Serializable) "");
    }

    public static boolean q(Context context) {
        return ((Boolean) u(context).a("power_save_is_enbale", Boolean.valueOf(false))).booleanValue();
    }

    public static String r(Context context) {
        return (String) u(context).a("key_share_process_uuid", (Serializable) "");
    }

    public static int s(Context context) {
        int intValue = ((Integer) u(context).a("sp_state", Integer.valueOf(0))).intValue();
        return (intValue == 0 || intValue == 1) ? intValue : 0;
    }

    public static long t(Context context) {
        return ((Long) u(context).a("key_share_process_uuid_creattime", Long.valueOf(-1))).longValue();
    }

    private static cn.jiguang.g.b.d u(Context context) {
        if (a == null) {
            a = cn.jiguang.g.b.d.a(context, "cn.jpush.android.user.profile");
        }
        return a;
    }
}
