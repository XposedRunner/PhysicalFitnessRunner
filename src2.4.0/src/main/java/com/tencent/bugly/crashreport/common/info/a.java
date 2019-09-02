package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.support.v4.os.EnvironmentCompat;
import com.tencent.bugly.b;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

/* compiled from: BUGLY */
public final class a {
    private static a ad;
    public HashMap<String, String> A = new HashMap();
    public boolean B = true;
    public List<String> C = new ArrayList();
    public com.tencent.bugly.crashreport.a D = null;
    public SharedPreferences E;
    private final Context F;
    private String G;
    private String H;
    private String I = EnvironmentCompat.MEDIA_UNKNOWN;
    private String J = EnvironmentCompat.MEDIA_UNKNOWN;
    private String K = "";
    private String L = null;
    private String M = null;
    private String N = null;
    private String O = null;
    private long P = -1;
    private long Q = -1;
    private long R = -1;
    private String S = null;
    private String T = null;
    private Map<String, PlugInBean> U = null;
    private boolean V = true;
    private String W = null;
    private String X = null;
    private Boolean Y = null;
    private String Z = null;
    public final long a = System.currentTimeMillis();
    private String aa = null;
    private String ab = null;
    private Map<String, PlugInBean> ac = null;
    private int ae = -1;
    private int af = -1;
    private Map<String, String> ag = new HashMap();
    private Map<String, String> ah = new HashMap();
    private Map<String, String> ai = new HashMap();
    private boolean aj;
    private String ak = null;
    private String al = null;
    private String am = null;
    private String an = null;
    private String ao = null;
    private final Object ap = new Object();
    private final Object aq = new Object();
    private final Object ar = new Object();
    private final Object as = new Object();
    private final Object at = new Object();
    private final Object au = new Object();
    private final Object av = new Object();
    public final byte b;
    public String c;
    public final String d;
    public boolean e = true;
    public final String f;
    public final String g;
    public final String h;
    public long i;
    public String j = null;
    public String k = null;
    public String l = null;
    public String m = null;
    public String n = null;
    public List<String> o = null;
    public String p = EnvironmentCompat.MEDIA_UNKNOWN;
    public long q = 0;
    public long r = 0;
    public long s = 0;
    public long t = 0;
    public boolean u = false;
    public String v = null;
    public String w = null;
    public String x = null;
    public boolean y = false;
    public boolean z = false;

    private a(Context context) {
        this.F = z.a(context);
        this.b = (byte) 1;
        PackageInfo b = AppInfo.b(context);
        if (b != null) {
            try {
                this.j = b.versionName;
                this.v = this.j;
                this.w = Integer.toString(b.versionCode);
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.c = AppInfo.a(context);
        this.d = AppInfo.a(Process.myPid());
        this.f = b.l();
        this.g = b.a();
        this.k = AppInfo.c(context);
        StringBuilder stringBuilder = new StringBuilder("Android ");
        stringBuilder.append(b.b());
        stringBuilder.append(",level ");
        stringBuilder.append(b.c());
        this.h = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.g);
        stringBuilder.append(";");
        stringBuilder.append(this.h);
        stringBuilder.toString();
        Map d = AppInfo.d(context);
        if (d != null) {
            try {
                this.o = AppInfo.a(d);
                String str = (String) d.get("BUGLY_APPID");
                if (str != null) {
                    this.X = str;
                }
                str = (String) d.get("BUGLY_APP_VERSION");
                if (str != null) {
                    this.j = str;
                }
                str = (String) d.get("BUGLY_APP_CHANNEL");
                if (str != null) {
                    this.l = str;
                }
                str = (String) d.get("BUGLY_ENABLE_DEBUG");
                if (str != null) {
                    this.u = str.equalsIgnoreCase("true");
                }
                String str2 = (String) d.get("com.tencent.rdm.uuid");
                if (str2 != null) {
                    this.x = str2;
                }
            } catch (Throwable th2) {
                if (!x.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.z = true;
                x.c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (b.c) {
                th3.printStackTrace();
            }
        }
        this.E = z.a("BUGLY_COMMON_VALUES", context);
        x.c("com info create end", new Object[0]);
    }

    public static int L() {
        return b.c();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (ad == null) {
                ad = new a(context);
            }
            aVar = ad;
        }
        return aVar;
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            aVar = ad;
        }
        return aVar;
    }

    public static String c() {
        return "2.6.6";
    }

    public final String A() {
        if (this.ab == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.d());
            this.ab = stringBuilder.toString();
            x.a("Hardware serial number: %s", this.ab);
        }
        return this.ab;
    }

    public final Map<String, String> B() {
        synchronized (this.ar) {
            if (this.ag.size() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(this.ag);
            return hashMap;
        }
    }

    public final void C() {
        synchronized (this.ar) {
            this.ag.clear();
        }
    }

    public final int D() {
        int size;
        synchronized (this.ar) {
            size = this.ag.size();
        }
        return size;
    }

    public final Set<String> E() {
        Set keySet;
        synchronized (this.ar) {
            keySet = this.ag.keySet();
        }
        return keySet;
    }

    public final Map<String, String> F() {
        synchronized (this.av) {
            if (this.ah.size() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(this.ah);
            return hashMap;
        }
    }

    public final Map<String, String> G() {
        synchronized (this.as) {
            if (this.ai.size() <= 0) {
                return null;
            }
            HashMap hashMap = new HashMap(this.ai);
            return hashMap;
        }
    }

    public final int H() {
        int i;
        synchronized (this.at) {
            i = this.ae;
        }
        return i;
    }

    public final int I() {
        return this.af;
    }

    public final boolean J() {
        return AppInfo.f(this.F);
    }

    public final synchronized Map<String, PlugInBean> K() {
        return null;
    }

    public final String M() {
        if (this.ak == null) {
            this.ak = b.m();
        }
        return this.ak;
    }

    public final String N() {
        if (this.al == null) {
            this.al = b.j(this.F);
        }
        return this.al;
    }

    public final String O() {
        if (this.am == null) {
            this.am = b.k(this.F);
        }
        return this.am;
    }

    public final String P() {
        Context context = this.F;
        return b.n();
    }

    public final String Q() {
        if (this.an == null) {
            this.an = b.l(this.F);
        }
        return this.an;
    }

    public final long R() {
        Context context = this.F;
        return b.o();
    }

    public final void a(int i) {
        synchronized (this.at) {
            if (this.ae != i) {
                this.ae = i;
                x.a("user scene tag %d changed to tag %d", Integer.valueOf(r1), Integer.valueOf(this.ae));
            }
        }
    }

    public final void a(String str) {
        this.X = str;
    }

    public final void a(String str, String str2) {
        if (str != null && str2 != null) {
            synchronized (this.aq) {
                this.A.put(str, str2);
            }
        }
    }

    public final void a(boolean z) {
        this.aj = z;
        if (this.D != null) {
            this.D.setNativeIsAppForeground(z);
        }
    }

    public final boolean a() {
        return this.aj;
    }

    public final void b(int i) {
        if (this.af != 24096) {
            this.af = 24096;
            x.a("server scene tag %d changed to tag %d", Integer.valueOf(i), Integer.valueOf(this.af));
        }
    }

    public final void b(String str) {
        synchronized (this.au) {
            if (str == null) {
                try {
                    str = "10000";
                } catch (Throwable th) {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            this.I = stringBuilder.toString();
        }
    }

    public final void b(String str, String str2) {
        if (z.a(str) || z.a(str2)) {
            Object[] objArr = new Object[2];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            objArr[0] = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            objArr[1] = stringBuilder2.toString();
            x.d("key&value should not be empty %s %s", objArr);
            return;
        }
        synchronized (this.ar) {
            this.ag.put(str, str2);
        }
    }

    public final void c(String str) {
        this.H = str;
        synchronized (this.av) {
            this.ah.put("E8", str);
        }
    }

    public final void c(String str, String str2) {
        if (z.a(str) || z.a(str2)) {
            Object[] objArr = new Object[2];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            objArr[0] = stringBuilder.toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            objArr[1] = stringBuilder2.toString();
            x.d("server key&value should not be empty %s %s", objArr);
            return;
        }
        synchronized (this.as) {
            this.ai.put(str, str2);
        }
    }

    public final void d() {
        synchronized (this.ap) {
            this.G = UUID.randomUUID().toString();
        }
    }

    public final synchronized void d(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        this.J = stringBuilder.toString();
    }

    public final String e() {
        if (this.G == null) {
            synchronized (this.ap) {
                if (this.G == null) {
                    this.G = UUID.randomUUID().toString();
                }
            }
        }
        return this.G;
    }

    public final synchronized void e(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        this.K = stringBuilder.toString();
    }

    public final String f() {
        return !z.a(null) ? null : this.X;
    }

    public final String f(String str) {
        if (z.a(str)) {
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            objArr[0] = stringBuilder.toString();
            x.d("key should not be empty %s", objArr);
            return null;
        }
        synchronized (this.ar) {
            str = (String) this.ag.remove(str);
        }
        return str;
    }

    public final String g() {
        String str;
        synchronized (this.au) {
            str = this.I;
        }
        return str;
    }

    public final String g(String str) {
        if (z.a(str)) {
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            objArr[0] = stringBuilder.toString();
            x.d("key should not be empty %s", objArr);
            return null;
        }
        synchronized (this.ar) {
            str = (String) this.ag.get(str);
        }
        return str;
    }

    public final String h() {
        if (this.H != null) {
            return this.H;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k());
        stringBuilder.append("|");
        stringBuilder.append(m());
        stringBuilder.append("|");
        stringBuilder.append(n());
        this.H = stringBuilder.toString();
        return this.H;
    }

    public final synchronized String i() {
        return this.J;
    }

    public final synchronized String j() {
        return this.K;
    }

    public final String k() {
        if (!this.V) {
            return "";
        }
        if (this.L == null) {
            this.L = b.a(this.F);
        }
        return this.L;
    }

    public final String l() {
        if (!this.V) {
            return "";
        }
        if (this.M == null || !this.M.contains(":")) {
            this.M = b.d(this.F);
        }
        return this.M;
    }

    public final String m() {
        if (!this.V) {
            return "";
        }
        if (this.N == null) {
            this.N = b.b(this.F);
        }
        return this.N;
    }

    public final String n() {
        if (!this.V) {
            return "";
        }
        if (this.O == null) {
            this.O = b.c(this.F);
        }
        return this.O;
    }

    public final long o() {
        if (this.P <= 0) {
            this.P = b.e();
        }
        return this.P;
    }

    public final long p() {
        if (this.Q <= 0) {
            this.Q = b.g();
        }
        return this.Q;
    }

    public final long q() {
        if (this.R <= 0) {
            this.R = b.i();
        }
        return this.R;
    }

    public final String r() {
        if (this.S == null) {
            this.S = b.a(true);
        }
        return this.S;
    }

    public final String s() {
        if (this.T == null) {
            this.T = b.h(this.F);
        }
        return this.T;
    }

    public final String t() {
        try {
            Map all = this.F.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.aq) {
                    for (Entry entry : all.entrySet()) {
                        try {
                            this.A.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            x.a(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            x.a(th2);
        }
        if (this.A.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry2 : this.A.entrySet()) {
            stringBuilder.append("[");
            stringBuilder.append((String) entry2.getKey());
            stringBuilder.append(",");
            stringBuilder.append((String) entry2.getValue());
            stringBuilder.append("] ");
        }
        c("SDK_INFO", stringBuilder.toString());
        return stringBuilder.toString();
    }

    public final String u() {
        if (this.ao == null) {
            this.ao = AppInfo.e(this.F);
        }
        return this.ao;
    }

    public final synchronized Map<String, PlugInBean> v() {
        return null;
    }

    public final String w() {
        if (this.W == null) {
            this.W = b.k();
        }
        return this.W;
    }

    public final Boolean x() {
        if (this.Y == null) {
            this.Y = Boolean.valueOf(b.i(this.F));
        }
        return this.Y;
    }

    public final String y() {
        if (this.Z == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.g(this.F));
            this.Z = stringBuilder.toString();
            x.a("ROM ID: %s", this.Z);
        }
        return this.Z;
    }

    public final String z() {
        if (this.aa == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b.e(this.F));
            this.aa = stringBuilder.toString();
            x.a("SIM serial number: %s", this.aa);
        }
        return this.aa;
    }
}
