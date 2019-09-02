package cn.jiguang.d.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.SdkType;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.d.a.a;
import cn.jiguang.d.a.d;
import java.util.HashMap;
import java.util.Map;

public final class f {
    private static volatile f g;
    private static final Object h = new Object();
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private Map<Long, String> i;

    private f() {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.i = new HashMap();
        this.a = h();
        this.b = i();
        this.c = j();
        this.d = k();
        this.e = l();
        this.f = m();
    }

    public static f a() {
        if (g == null) {
            synchronized (h) {
                if (g == null) {
                    g = new f();
                }
            }
        }
        return g;
    }

    private static String a(Context context, String str) {
        b.a();
        String d = b.d(str, "");
        return (TextUtils.isEmpty(d) || d.equals(d.b(context, str))) ? "" : d;
    }

    private void a(short s, String str, String str2) {
        long c = d.c(null);
        int a = d.a();
        long f = a.f();
        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
        outputDataUtil.writeU16(0);
        outputDataUtil.writeU8(0);
        outputDataUtil.writeU8(26);
        outputDataUtil.writeU64(f);
        outputDataUtil.writeU32((long) a);
        outputDataUtil.writeU64(c);
        outputDataUtil.writeU8(s);
        outputDataUtil.writeU8(1);
        outputDataUtil.writeByteArrayincludeLength(str.getBytes());
        outputDataUtil.writeU16At(outputDataUtil.current(), 0);
        byte[] toByteArray = outputDataUtil.toByteArray();
        cn.jiguang.d.b.d.a();
        cn.jiguang.d.b.d.a(toByteArray, SdkType.JCORE.name(), 0);
        this.i.put(Long.valueOf(f), str2);
    }

    public static boolean e() {
        b.a();
        return b.a(0);
    }

    private static boolean h() {
        try {
            Class.forName("cn.jpush.android.api.JPushInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean i() {
        try {
            Class.forName("cn.jpush.im.android.api.JMessageClient");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean j() {
        try {
            Class.forName("cn.jiguang.analytics.android.api.JAnalyticsInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean k() {
        try {
            Class.forName("cn.jiguang.share.android.api.JShareInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean l() {
        try {
            Class.forName("cn.jiguang.adsdk.api.JSSPInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean m() {
        try {
            Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void a(Context context) {
        if (context != null) {
            String a = a(context, SdkType.JPUSH.name());
            String a2 = a(context, SdkType.JMESSAGE.name());
            String a3 = a(context, SdkType.JANALYTICS.name());
            String a4 = a(context, SdkType.JSHARE.name());
            String a5 = a(context, SdkType.JSSP.name());
            String a6 = a(context, SdkType.JVERIFICATION.name());
            if (!TextUtils.isEmpty(a)) {
                a((short) 1, a, SdkType.JPUSH.name());
            }
            if (!TextUtils.isEmpty(a2)) {
                a((short) 2, a2, SdkType.JMESSAGE.name());
            }
            if (!TextUtils.isEmpty(a3)) {
                a((short) 4, a3, SdkType.JANALYTICS.name());
            }
            if (!TextUtils.isEmpty(a4)) {
                a((short) 5, a4, SdkType.JSHARE.name());
            }
            if (!TextUtils.isEmpty(a5)) {
                a((short) 9, a5, SdkType.JSSP.name());
            }
            if (!TextUtils.isEmpty(a6)) {
                a((short) 10, a6, SdkType.JVERIFICATION.name());
            }
        }
    }

    public final void a(Context context, long j) {
        String str = (String) this.i.remove(Long.valueOf(j));
        if (!TextUtils.isEmpty(str)) {
            b.a();
            TextUtils.isEmpty(b.d(str, ""));
        }
        if ((this.i == null || this.i.isEmpty()) && !this.b && !this.a) {
            cn.jiguang.d.b.d.a().c();
        }
    }

    public final short b() {
        boolean z = this.a;
        if (!this.b) {
            return z;
        }
        int i = (a.u() >= 0 || a.t()) ? z | 32 : z | 64;
        return (short) i;
    }

    public final void b(Context context, long j) {
        String str = (String) this.i.remove(Long.valueOf(j));
        if (!TextUtils.isEmpty(str)) {
            b.a();
            String d = b.d(str, "");
            if (!TextUtils.isEmpty(d)) {
                d.a(context, str, d);
            }
        }
        if (!b(context)) {
            cn.jiguang.d.b.d.a().c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c A:{RETURN} */
    public final boolean b(android.content.Context r4) {
        /*
        r3 = this;
        r0 = r3.b;
        r1 = 1;
        if (r0 != 0) goto L_0x006e;
    L_0x0005:
        r0 = r3.a;
        if (r0 != 0) goto L_0x006e;
    L_0x0009:
        r0 = 0;
        if (r4 != 0) goto L_0x0014;
    L_0x000c:
        r4 = "JClientsHelper";
        r2 = "get isNeedUserCtrl failed,context is null";
        cn.jiguang.e.c.c(r4, r2);
        goto L_0x0069;
    L_0x0014:
        r2 = r3.c;
        if (r2 == 0) goto L_0x002a;
    L_0x0018:
        r2 = cn.jiguang.api.SdkType.JANALYTICS;
        r2 = r2.name();
        r2 = a(r4, r2);
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x002a;
    L_0x0028:
        r4 = r1;
        goto L_0x006a;
    L_0x002a:
        r2 = r3.d;
        if (r2 == 0) goto L_0x003f;
    L_0x002e:
        r2 = cn.jiguang.api.SdkType.JSHARE;
        r2 = r2.name();
        r2 = a(r4, r2);
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x003f;
    L_0x003e:
        goto L_0x0028;
    L_0x003f:
        r2 = r3.a;
        if (r2 == 0) goto L_0x0054;
    L_0x0043:
        r2 = cn.jiguang.api.SdkType.JPUSH;
        r2 = r2.name();
        r2 = a(r4, r2);
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x0054;
    L_0x0053:
        goto L_0x0028;
    L_0x0054:
        r2 = r3.b;
        if (r2 == 0) goto L_0x0069;
    L_0x0058:
        r2 = cn.jiguang.api.SdkType.JMESSAGE;
        r2 = r2.name();
        r4 = a(r4, r2);
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x0069;
    L_0x0068:
        goto L_0x0028;
    L_0x0069:
        r4 = r0;
    L_0x006a:
        if (r4 == 0) goto L_0x006d;
    L_0x006c:
        return r1;
    L_0x006d:
        return r0;
    L_0x006e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.d.f.b(android.content.Context):boolean");
    }

    public final long c() {
        long j = this.a ? 1 : 0;
        if (this.c) {
            j |= 4;
        }
        if (this.d) {
            j |= 8;
        }
        if (this.b) {
            j |= 32;
        }
        if (this.e) {
            j |= 128;
        }
        return this.f ? j | 256 : j;
    }

    public final void c(Context context, long j) {
        this.i.remove(Long.valueOf(j));
        if ((this.i == null || this.i.isEmpty()) && !this.b && !this.a) {
            cn.jiguang.d.b.d.a().c();
        }
    }

    public final long d() {
        long j;
        long j2;
        long j3 = this.a ? 1 : 0;
        if (this.b) {
            j = (a.u() >= 0 || a.t()) ? 32 : 64;
            j2 = j3 | j;
        } else {
            j2 = j3;
        }
        j = this.c ? j2 | 4 : j2;
        if (this.d) {
            j |= 8;
        }
        if (this.e) {
            j |= 128;
        }
        return this.f ? j | 256 : j;
    }

    public final boolean f() {
        return this.b || this.a;
    }

    public final boolean g() {
        return this.f;
    }
}
