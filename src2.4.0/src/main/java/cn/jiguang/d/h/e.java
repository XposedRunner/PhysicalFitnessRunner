package cn.jiguang.d.h;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import cn.jiguang.d.d.ac;
import cn.jiguang.d.d.b;
import cn.jiguang.d.d.f;
import cn.jiguang.e.c;
import cn.jiguang.g.a;
import cn.jiguang.g.i;
import cn.jiguang.g.j;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e {
    private static volatile e x;
    private static final Object y = new Object();
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public String n;
    public long o;
    public int p;
    public String q;
    public String r;
    public String s;
    public String t;
    private transient AtomicBoolean u = new AtomicBoolean(false);
    private String v;
    private String w;

    private e() {
    }

    private static String a(String str, String str2) {
        return !i.a(str) ? str : str2;
    }

    public static byte c(Context context) {
        ArrayList a = b.a().a(context, SdkType.JPUSH.name(), 22, "platformtype", 1);
        Object obj = a.size() > 0 ? a.get(0) : null;
        return (obj == null || !(obj instanceof Byte)) ? (byte) 0 : ((Byte) obj).byteValue();
    }

    public static e d() {
        if (x == null) {
            synchronized (y) {
                if (x == null) {
                    x = new e();
                }
            }
        }
        return x;
    }

    public static String d(Context context) {
        String str = "";
        ArrayList a = b.a().a(context, SdkType.JPUSH.name(), 22, "platformregid", 1);
        Object obj = a.size() > 0 ? a.get(0) : null;
        return (obj == null || !(obj instanceof String)) ? str : (String) obj;
    }

    public final String a() {
        return this.v;
    }

    public final void a(Context context) {
        if (!this.u.get() && context != null) {
            b(context);
            this.u.set(true);
        }
    }

    public final String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f);
        stringBuilder.append("|");
        stringBuilder.append(this.g);
        stringBuilder.append("|");
        stringBuilder.append(this.h);
        stringBuilder.append("|");
        stringBuilder.append(this.i);
        stringBuilder.append("|");
        stringBuilder.append(this.j);
        stringBuilder.append("|");
        stringBuilder.append(this.k);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(a(this.b, " "));
        stringBuilder3.append("$$");
        stringBuilder3.append(a(this.c, " "));
        stringBuilder3.append("$$");
        stringBuilder3.append(a(this.d, " "));
        stringBuilder3.append("$$");
        stringBuilder3.append(a(this.e, " "));
        stringBuilder3.append("$$");
        stringBuilder3.append(a(this.l, " "));
        stringBuilder3.append("$$");
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("$$");
        stringBuilder3.append(this.m);
        stringBuilder3.append("$$");
        stringBuilder3.append(this.n);
        return stringBuilder3.toString();
    }

    public final void b(Context context) {
        if (context == null) {
            c.c("DeviceInfo", "context is null");
            return;
        }
        String g = a.g(context);
        String e = a.e(context, "");
        if (TextUtils.isEmpty(g)) {
            g = " ";
        }
        if (TextUtils.isEmpty(e)) {
            e = " ";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(g);
        stringBuilder.append("$$");
        stringBuilder.append(e);
        stringBuilder.append("$$");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("$$");
        stringBuilder.append(cn.jiguang.d.a.b(context));
        this.v = stringBuilder.toString();
        this.a = ac.a(context);
        this.o = f.a().c();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(VERSION.RELEASE);
        stringBuilder2.append(",");
        stringBuilder2.append(Integer.toString(VERSION.SDK_INT));
        this.b = stringBuilder2.toString();
        this.c = Build.MODEL;
        this.d = j.a(context, "gsm.version.baseband", "baseband");
        this.e = Build.DEVICE;
        this.l = cn.jiguang.d.a.a.g("");
        b.a();
        this.i = b.d(SdkType.JCORE.name(), "");
        b.a();
        this.g = b.d(SdkType.JANALYTICS.name(), "");
        b.a();
        this.h = b.d(SdkType.JSHARE.name(), "");
        b.a();
        this.f = b.d(SdkType.JPUSH.name(), "");
        b.a();
        this.j = b.d(SdkType.JSSP.name(), "");
        b.a();
        this.k = b.d(SdkType.JVERIFICATION.name(), "");
        this.m = a.j(context);
        this.n = a.a(context);
        this.w = a.d(context, this.w);
        this.q = a.i(context);
        this.p = a.a;
        this.r = a.h(context);
        this.s = a.b(context, " ");
        if (!i.e(this.s)) {
            this.s = " ";
        }
        this.w = a.d(context, " ");
        this.t = Build.SERIAL;
        cn.jiguang.d.a.a.a(this.w, this.r, this.s);
    }

    public final String c() {
        String str = EnvironmentCompat.MEDIA_UNKNOWN.equalsIgnoreCase(this.t) ? " " : this.t;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.p);
        stringBuilder.append("$$");
        stringBuilder.append(a(this.q, " "));
        stringBuilder.append("$$");
        stringBuilder.append(a(this.w, " "));
        stringBuilder.append("$$");
        stringBuilder.append(a(this.r, " "));
        stringBuilder.append("$$");
        stringBuilder.append(a(this.s, " "));
        stringBuilder.append("$$");
        stringBuilder.append(a(str, " "));
        return stringBuilder.toString();
    }
}
