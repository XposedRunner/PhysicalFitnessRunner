package com.qiyukf.unicorn.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qiyukf.basesdk.c.c.a;
import com.qiyukf.basesdk.c.d;
import java.security.SecureRandom;
import java.util.UUID;
import org.json.JSONObject;

public final class b {
    private static Context a;
    private static String b;

    public static String a() {
        return p("YSF_ID_YX");
    }

    public static void a(int i) {
        d("YSF_KEYBOARD_HEIGHT", i);
    }

    public static void a(long j) {
        b("YSF_LAST_UPLOAD_USER", j);
    }

    public static void a(Context context, String str) {
        a = context.getApplicationContext();
        b = str;
    }

    public static void a(Boolean bool) {
        b("IS_UN_READ_CALLBACK", bool.booleanValue());
    }

    public static void a(String str) {
        d("YSF_ID_YX", str);
    }

    public static void a(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("YSF_SESSION_COUNT/");
        stringBuilder.append(str);
        d(stringBuilder.toString(), i);
    }

    public static void a(String str, long j) {
        StringBuilder stringBuilder = new StringBuilder("YSF_SESSION_ID/");
        stringBuilder.append(str);
        b(stringBuilder.toString(), j);
    }

    public static void a(String str, com.qiyukf.unicorn.f.a.c.b bVar) {
        String jSONObject = bVar == null ? null : bVar.b().toString();
        StringBuilder stringBuilder = new StringBuilder("YSF_EVALUATION_CONFIG/");
        stringBuilder.append(str);
        d(stringBuilder.toString(), jSONObject);
    }

    public static void a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("YSF_ID_MP/");
        stringBuilder.append(str);
        d(stringBuilder.toString(), str2);
    }

    public static void a(boolean z) {
        b("YSF_EAR_PHONE_MODE", z);
    }

    private static boolean a(String str, boolean z) {
        return t().getBoolean(str, z);
    }

    public static int b(int i) {
        return c("YSF_KEYBOARD_HEIGHT", i);
    }

    public static String b() {
        String p = p("YSF_ID_TK");
        if (TextUtils.isEmpty(p)) {
            return null;
        }
        String d = d();
        return com.qiyukf.unicorn.j.b.a(a, a.a(p), d);
    }

    public static void b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "YSF_ID_TK";
        } else {
            str2 = "YSF_ID_TK";
            byte[] a = com.qiyukf.unicorn.j.b.a(a, str, d());
            if (a != null) {
                str = a.a(a);
                d(str2, str);
            }
        }
        str = null;
        d(str2, str);
    }

    public static void b(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("YSF_SESSION_EVALUATE_STATE/");
        stringBuilder.append(str);
        d(stringBuilder.toString(), i);
    }

    private static void b(String str, long j) {
        d.a(t(), str, j);
    }

    public static void b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("YSF_DRAFT/");
        stringBuilder.append(str);
        d(stringBuilder.toString(), str2);
    }

    private static void b(String str, boolean z) {
        d.a(t(), str, z);
    }

    public static void b(boolean z) {
        b("YSF_SB_ON", z);
    }

    private static int c(String str, int i) {
        return t().getInt(str, i);
    }

    public static String c() {
        return t().getString("YSF_BID", "");
    }

    public static String c(String str) {
        StringBuilder stringBuilder = new StringBuilder("YSF_ID_MP/");
        stringBuilder.append(str);
        return p(stringBuilder.toString());
    }

    public static void c(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("YSF_EVALUATION_MESSAGE_ID/");
        stringBuilder.append(str);
        d(stringBuilder.toString(), str2);
    }

    public static void c(boolean z) {
        b("YSF_STATISTICS_ON", z);
    }

    public static String d() {
        String p = p("YSF_ID_DV");
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        p = UUID.randomUUID().toString().replace("-", "");
        d("YSF_ID_DV", p);
        return p;
    }

    public static void d(String str) {
        d("YSF_BID", str);
    }

    private static void d(String str, int i) {
        d.a(t(), str, i);
    }

    private static void d(String str, String str2) {
        d.a(t(), str, str2);
    }

    public static String e(String str) {
        StringBuilder stringBuilder = new StringBuilder("YSF_DRAFT/");
        stringBuilder.append(str);
        return p(stringBuilder.toString());
    }

    public static void e() {
        d("YSF_ID_DV", null);
    }

    public static String f() {
        String p = p("YSF_ID_SD");
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        p = a.a(new SecureRandom().generateSeed(32));
        d("YSF_ID_SD", p);
        return p;
    }

    public static void f(String str) {
        d("YSF_FOREIGN_NAME", str);
    }

    public static String g() {
        return p("YSF_FOREIGN_NAME");
    }

    public static void g(String str) {
        d("YSF_CRM_DATA", str);
    }

    public static long h(String str) {
        StringBuilder stringBuilder = new StringBuilder("YSF_SESSION_ID/");
        stringBuilder.append(str);
        return q(stringBuilder.toString());
    }

    public static String h() {
        return p("YSF_CRM_DATA");
    }

    public static int i(String str) {
        StringBuilder stringBuilder = new StringBuilder("YSF_SESSION_COUNT/");
        stringBuilder.append(str);
        return c(stringBuilder.toString(), 0);
    }

    public static boolean i() {
        return a("YSF_EAR_PHONE_MODE", false);
    }

    public static int j(String str) {
        StringBuilder stringBuilder = new StringBuilder("YSF_SESSION_EVALUATE_STATE/");
        stringBuilder.append(str);
        return c(stringBuilder.toString(), 0);
    }

    public static Boolean j() {
        return Boolean.valueOf(a("IS_UN_READ_CALLBACK", false));
    }

    public static com.qiyukf.unicorn.f.a.c.b k(String str) {
        StringBuilder stringBuilder = new StringBuilder("YSF_EVALUATION_CONFIG/");
        stringBuilder.append(str);
        JSONObject a = com.qiyukf.basesdk.c.b.a(p(stringBuilder.toString()));
        if (a == null) {
            return null;
        }
        com.qiyukf.unicorn.f.a.c.b bVar = new com.qiyukf.unicorn.f.a.c.b();
        bVar.a(a);
        return bVar;
    }

    public static boolean k() {
        return a("YSF_SB_ON", true);
    }

    public static String l() {
        return p("YSF_PUSH_TOKEN");
    }

    public static String l(String str) {
        StringBuilder stringBuilder = new StringBuilder("YSF_EVALUATION_MESSAGE_ID/");
        stringBuilder.append(str);
        return p(stringBuilder.toString());
    }

    public static void m() {
        b("YSF_TOKEN_REGISTERED", true);
    }

    public static void m(String str) {
        d("YSF_LAST_STAFF_ID", str);
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            d("YSF_MSG_SESSION_ID", null);
            return;
        }
        String p = p("YSF_MSG_SESSION_ID");
        if (TextUtils.isEmpty(p)) {
            d("YSF_MSG_SESSION_ID", str);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(p);
        stringBuilder.append(",");
        stringBuilder.append(str);
        d("YSF_MSG_SESSION_ID", stringBuilder.toString());
    }

    public static boolean n() {
        return a("YSF_TOKEN_REGISTERED", true);
    }

    public static String o() {
        return p("YSF_LAST_STAFF_ID");
    }

    public static void o(String str) {
        d("YSF_CRM_DATA_CACHE", str);
    }

    public static String p() {
        return p("YSF_MSG_SESSION_ID");
    }

    private static String p(String str) {
        return t().getString(str, null);
    }

    private static long q(String str) {
        try {
            return t().getLong(str, 0);
        } catch (ClassCastException unused) {
            return (long) t().getInt(str, 0);
        }
    }

    public static String q() {
        return p("YSF_CRM_DATA_CACHE");
    }

    public static long r() {
        return q("YSF_LAST_UPLOAD_USER");
    }

    public static boolean s() {
        return a("YSF_STATISTICS_ON", false);
    }

    private static SharedPreferences t() {
        Context context = a;
        StringBuilder stringBuilder = new StringBuilder("Unicorn.");
        stringBuilder.append(b);
        return context.getSharedPreferences(stringBuilder.toString(), 0);
    }
}
