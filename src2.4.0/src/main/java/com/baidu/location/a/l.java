package com.baidu.location.a;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.e.d;
import com.baidu.location.e.e;
import com.baidu.location.e.h;
import com.baidu.location.e.i;
import com.baidu.location.f;
import com.baidu.location.g.j;
import com.baidu.location.indoor.g;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import java.util.List;

public class l extends i {
    public static boolean g;
    private static l h;
    private boolean A;
    private long B;
    private long C;
    private a D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private b J;
    private boolean K;
    private int L;
    private long M;
    private boolean N;
    private boolean O;
    public b e;
    public final Handler f;
    private boolean i;
    private String j;
    private BDLocation k;
    private BDLocation l;
    private h m;
    private com.baidu.location.e.a n;
    private h o;
    private com.baidu.location.e.a p;
    private boolean q;
    private volatile boolean r;
    private boolean s;
    private long t;
    private long u;
    private Address v;
    private String w;
    private List<Poi> x;
    private double y;
    private double z;

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(l lVar, m mVar) {
            this();
        }

        public void run() {
            if (l.this.E) {
                l.this.E = false;
                if (!l.this.F && !e.a().j()) {
                    l.this.a(false, false);
                }
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(l lVar, m mVar) {
            this();
        }

        public void run() {
            if (l.this.K) {
                l.this.K = false;
            }
            if (l.this.s) {
                l.this.s = false;
                l.this.h(null);
            }
        }
    }

    private l() {
        this.i = true;
        this.e = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = true;
        this.r = false;
        this.s = false;
        this.t = 0;
        this.u = 0;
        this.v = null;
        this.w = null;
        this.x = null;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = null;
        this.E = false;
        this.F = false;
        this.G = true;
        this.f = new com.baidu.location.a.i.a();
        this.H = false;
        this.I = false;
        this.J = null;
        this.K = false;
        this.L = 0;
        this.M = 0;
        this.N = false;
        this.O = true;
        this.e = new b();
    }

    private boolean a(com.baidu.location.e.a aVar) {
        this.b = com.baidu.location.e.b.a().f();
        return this.b == aVar ? false : (this.b == null || aVar == null) ? true : aVar.a(this.b) ^ 1;
    }

    private boolean a(h hVar) {
        this.a = i.a().p();
        return hVar == this.a ? false : (this.a == null || hVar == null) ? true : hVar.c(this.a) ^ 1;
    }

    private boolean b(com.baidu.location.e.a aVar) {
        return aVar == null ? false : this.p == null ? true : aVar.a(this.p) ^ 1;
    }

    public static synchronized l c() {
        l lVar;
        synchronized (l.class) {
            if (h == null) {
                h = new l();
            }
            lVar = h;
        }
        return lVar;
    }

    private void c(Message message) {
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            g = true;
        }
        if (!g.a().f()) {
            switch (a.a().d(message)) {
                case 1:
                    d(message);
                    break;
                case 2:
                    g(message);
                    return;
                case 3:
                    if (e.a().j()) {
                        e(message);
                        return;
                    }
                    break;
                default:
                    throw new IllegalArgumentException(String.format("this type %d is illegal", new Object[]{Integer.valueOf(a.a().d(message))}));
            }
        }
    }

    private void d(Message message) {
        if (e.a().j()) {
            e(message);
            o.a().c();
            return;
        }
        g(message);
        o.a().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(e.a().g());
        if (j.g.equals(MsgService.MSG_CHATTING_ACCOUNT_ALL) || j.h || j.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.v != null) {
                    bDLocation.setAddr(this.v);
                }
                if (this.w != null) {
                    bDLocation.setLocationDescribe(this.w);
                }
                if (this.x != null) {
                    bDLocation.setPoiList(this.x);
                }
            } else {
                this.A = true;
                g(null);
            }
        }
        this.k = bDLocation;
        this.l = null;
        a.a().a(bDLocation);
    }

    private void f(Message message) {
        if (i.a().g()) {
            this.s = true;
            if (this.J == null) {
                this.J = new b(this, null);
            }
            if (this.K && this.J != null) {
                this.f.removeCallbacks(this.J);
            }
            this.f.postDelayed(this.J, 3500);
            this.K = true;
            return;
        }
        h(message);
    }

    private void g(Message message) {
        this.L = 0;
        if (this.q) {
            this.L = 1;
            this.C = SystemClock.uptimeMillis();
            if (i.a().k()) {
                f(message);
                return;
            } else {
                h(message);
                return;
            }
        }
        f(message);
        this.C = SystemClock.uptimeMillis();
    }

    private void h(Message message) {
        long currentTimeMillis = System.currentTimeMillis() - this.t;
        if (!this.r || currentTimeMillis > 12000) {
            long j = 0;
            if (System.currentTimeMillis() - this.t <= 0 || System.currentTimeMillis() - this.t >= 1000) {
                StringBuilder stringBuilder;
                this.r = true;
                this.i = a(this.n);
                if (!(a(this.m) || this.i || this.k == null || this.A)) {
                    if (this.l != null && System.currentTimeMillis() - this.u > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                        this.k = this.l;
                        this.l = null;
                    }
                    if (o.a().d()) {
                        this.k.setDirection(o.a().e());
                    }
                    if (this.k.getLocType() == 62) {
                        long currentTimeMillis2 = System.currentTimeMillis() - this.M;
                        if (currentTimeMillis2 > 0) {
                            j = currentTimeMillis2;
                        }
                    }
                    if (this.k.getLocType() == 61 || this.k.getLocType() == BDLocation.TypeNetWorkLocation || (this.k.getLocType() == 62 && j < 15000)) {
                        a.a().a(this.k);
                        m();
                        return;
                    }
                }
                this.t = System.currentTimeMillis();
                String a = a(null);
                this.I = false;
                if (a == null) {
                    StringBuilder stringBuilder2;
                    this.I = true;
                    this.M = System.currentTimeMillis();
                    String[] l = l();
                    long currentTimeMillis3 = System.currentTimeMillis();
                    if (currentTimeMillis3 - this.B > 60000) {
                        this.B = currentTimeMillis3;
                    }
                    String m = i.a().m();
                    if (m != null) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(m);
                        stringBuilder2.append(b());
                        stringBuilder2.append(l[0]);
                        a = stringBuilder2.toString();
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("");
                        stringBuilder.append(b());
                        stringBuilder.append(l[0]);
                        a = stringBuilder.toString();
                    }
                    if (!(this.b == null || this.b.h() == null)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(this.b.h());
                        stringBuilder.append(a);
                        a = stringBuilder.toString();
                    }
                    m = com.baidu.location.g.b.a().a(true);
                    if (m != null) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(a);
                        stringBuilder2.append(m);
                        a = stringBuilder2.toString();
                    }
                }
                if (this.j != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(a);
                    stringBuilder.append(this.j);
                    a = stringBuilder.toString();
                    this.j = null;
                }
                this.e.a(a);
                this.n = this.b;
                this.m = this.a;
                if (!e.a().j()) {
                    k();
                }
                if (com.baidu.location.d.g.a().h()) {
                    if (this.D == null) {
                        this.D = new a(this, null);
                    }
                    this.f.postDelayed(this.D, com.baidu.location.d.g.a().a(d.a(com.baidu.location.e.b.a().e())));
                    this.E = true;
                }
                if (this.q) {
                    this.q = false;
                    if (i.j() && message != null && a.a().e(message) < 1000 && com.baidu.location.d.g.a().d()) {
                        com.baidu.location.d.g.a().i();
                    }
                    com.baidu.location.b.b.a().b();
                }
                if (this.L > 0) {
                    if (this.L == 2) {
                        i.a().g();
                    }
                    this.L = 0;
                }
                return;
            }
            if (this.k != null) {
                a.a().a(this.k);
            }
            m();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b7  */
    /* JADX WARNING: Missing block: B:43:0x00b1, code skipped:
            if (r0.getPoiList() == null) goto L_0x0089;
     */
    private boolean k() {
        /*
        r15 = this;
        r0 = java.lang.Math.random();
        android.os.SystemClock.uptimeMillis();
        r2 = com.baidu.location.e.b.a();
        r2 = r2.f();
        r3 = com.baidu.location.e.i.a();
        r3 = r3.o();
        if (r3 == 0) goto L_0x0024;
    L_0x0019:
        r4 = r3.a();
        if (r4 <= 0) goto L_0x0024;
    L_0x001f:
        r4 = r3.f();
        goto L_0x0026;
    L_0x0024:
        r4 = 0;
    L_0x0026:
        r6 = 1;
        r7 = 0;
        if (r2 == 0) goto L_0x003a;
    L_0x002a:
        r2 = r2.e();
        if (r2 == 0) goto L_0x003a;
    L_0x0030:
        if (r3 == 0) goto L_0x0038;
    L_0x0032:
        r2 = r3.a();
        if (r2 != 0) goto L_0x003a;
    L_0x0038:
        r2 = r6;
        goto L_0x003b;
    L_0x003a:
        r2 = r7;
    L_0x003b:
        r3 = com.baidu.location.d.g.a();
        r3 = r3.d();
        r8 = 0;
        if (r3 == 0) goto L_0x00b8;
    L_0x0046:
        r3 = com.baidu.location.d.g.a();
        r3 = r3.f();
        if (r3 == 0) goto L_0x00b8;
    L_0x0050:
        r9 = 60;
        r3 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));
        if (r3 >= 0) goto L_0x00b8;
    L_0x0056:
        if (r2 != 0) goto L_0x006a;
    L_0x0058:
        r2 = 0;
        r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r4 >= 0) goto L_0x00b8;
    L_0x005e:
        r2 = com.baidu.location.d.g.a();
        r2 = r2.o();
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 >= 0) goto L_0x00b8;
    L_0x006a:
        r9 = com.baidu.location.d.g.a();
        r0 = com.baidu.location.e.b.a();
        r10 = r0.f();
        r0 = com.baidu.location.e.i.a();
        r11 = r0.o();
        r12 = 0;
        r13 = com.baidu.location.d.g.b.IS_MIX_MODE;
        r14 = com.baidu.location.d.g.a.NEED_TO_LOG;
        r0 = r9.a(r10, r11, r12, r13, r14);
        if (r0 != 0) goto L_0x008b;
    L_0x0089:
        r1 = r7;
        goto L_0x00b4;
    L_0x008b:
        r1 = com.baidu.location.g.j.g;
        r2 = "all";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x009d;
    L_0x0095:
        r1 = r0.getAddrStr();
        if (r1 != 0) goto L_0x009d;
    L_0x009b:
        r1 = r7;
        goto L_0x009e;
    L_0x009d:
        r1 = r6;
    L_0x009e:
        r2 = com.baidu.location.g.j.h;
        if (r2 == 0) goto L_0x00a9;
    L_0x00a2:
        r2 = r0.getLocationDescribe();
        if (r2 != 0) goto L_0x00a9;
    L_0x00a8:
        r1 = r7;
    L_0x00a9:
        r2 = com.baidu.location.g.j.j;
        if (r2 == 0) goto L_0x00b4;
    L_0x00ad:
        r2 = r0.getPoiList();
        if (r2 != 0) goto L_0x00b4;
    L_0x00b3:
        goto L_0x0089;
    L_0x00b4:
        if (r1 != 0) goto L_0x00b7;
    L_0x00b6:
        goto L_0x00b8;
    L_0x00b7:
        r8 = r0;
    L_0x00b8:
        if (r8 == 0) goto L_0x00e0;
    L_0x00ba:
        r0 = r8.getLocType();
        r1 = 66;
        if (r0 != r1) goto L_0x00e0;
    L_0x00c2:
        r0 = r15.r;
        if (r0 == 0) goto L_0x00e0;
    L_0x00c6:
        r0 = new com.baidu.location.BDLocation;
        r0.<init>(r8);
        r1 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        r0.setLocType(r1);
        r1 = r15.r;
        if (r1 == 0) goto L_0x00e0;
    L_0x00d4:
        r15.F = r6;
        r1 = com.baidu.location.a.a.a();
        r1.a(r0);
        r15.k = r0;
        return r6;
    L_0x00e0:
        r6 = r7;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.l.k():boolean");
    }

    private String[] l() {
        int c;
        int i;
        b a;
        String[] strArr = new String[]{"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int b = j.b(f.getServiceContext());
        if (b == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(b);
        String d = j.d(f.getServiceContext());
        if (d.contains("0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(d);
        if (VERSION.SDK_INT >= 23) {
            stringBuffer.append("&loc=");
            c = j.c(f.getServiceContext());
            if (c == 0) {
                strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
                i = 1;
            } else {
                i = 0;
            }
            stringBuffer.append(c);
        } else {
            i = 0;
        }
        if (VERSION.SDK_INT >= 19) {
            stringBuffer.append("&lmd=");
            c = j.c(f.getServiceContext());
            if (c >= 0) {
                stringBuffer.append(c);
            }
        }
        String g = com.baidu.location.e.b.a().g();
        String h = i.a().h();
        stringBuffer.append(h);
        stringBuffer.append(g);
        stringBuffer.append(j.e(f.getServiceContext()));
        if (b == 1) {
            a = b.a();
            b = 7;
            d = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        } else if (d.contains("0|0|")) {
            a = b.a();
            b = 4;
            d = "Location failed beacuse we can not get any loc information without any location permission!";
        } else if (i != 0) {
            a = b.a();
            b = 5;
            d = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
        } else if (g == null || h == null || !g.equals("&sim=1") || h.equals("&wifio=1")) {
            a = b.a();
            b = 9;
            d = "Location failed beacuse we can not get any loc information!";
        } else {
            a = b.a();
            b = 6;
            d = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
        }
        a.a(62, b, d);
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    private void m() {
        this.r = false;
        this.F = false;
        this.G = false;
        this.A = false;
        n();
        if (this.O) {
            this.O = false;
        }
    }

    private void n() {
        if (this.k != null && i.j()) {
            x.a().d();
        }
    }

    public Address a(BDLocation bDLocation) {
        if (j.g.equals(MsgService.MSG_CHATTING_ACCOUNT_ALL) || j.h || j.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.w = null;
                this.x = null;
                this.A = true;
                this.f.post(new m(this));
            } else if (this.v != null) {
                return this.v;
            }
        }
        return null;
    }

    public void a() {
        boolean z = false;
        if (this.D != null && this.E) {
            this.E = false;
            this.f.removeCallbacks(this.D);
        }
        if (e.a().j()) {
            BDLocation bDLocation = new BDLocation(e.a().g());
            if (j.g.equals(MsgService.MSG_CHATTING_ACCOUNT_ALL) || j.h || j.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.v != null) {
                        bDLocation.setAddr(this.v);
                    }
                    if (this.w != null) {
                        bDLocation.setLocationDescribe(this.w);
                    }
                    if (this.x != null) {
                        bDLocation.setPoiList(this.x);
                    }
                }
            }
            a.a().a(bDLocation);
        } else if (this.F) {
            m();
            return;
        } else {
            BDLocation a;
            if (com.baidu.location.d.g.a().d() && com.baidu.location.d.g.a().e()) {
                a = com.baidu.location.d.g.a().a(com.baidu.location.e.b.a().f(), i.a().o(), null, com.baidu.location.d.g.b.IS_NOT_MIX_MODE, com.baidu.location.d.g.a.NEED_TO_LOG);
                if (a != null && a.getLocType() == 66) {
                    a.a().a(a);
                }
            } else {
                a = null;
            }
            if (a == null || a.getLocType() == 67) {
                if (this.i || this.k == null) {
                    if (com.baidu.location.d.a.a().a) {
                        a = com.baidu.location.d.a.a().a(false);
                    } else if (a == null) {
                        a = new BDLocation();
                        a.setLocType(67);
                    }
                    if (a != null) {
                        a.a().a(a);
                        if (a.getLocType() == 67 && !this.I) {
                            b.a().a(67, 3, "Offline location failed, please check the net (wifi/cell)!");
                        }
                        boolean z2 = true;
                        if (j.g.equals(MsgService.MSG_CHATTING_ACCOUNT_ALL) && a.getAddrStr() == null) {
                            z2 = false;
                        }
                        if (j.h && a.getLocationDescribe() == null) {
                            z2 = false;
                        }
                        if (!(j.j && a.getPoiList() == null)) {
                            z = z2;
                        }
                        if (!z) {
                            a.setLocType(67);
                        }
                    }
                } else {
                    a.a().a(this.k);
                }
            }
            this.l = null;
        }
        m();
    }

    public void a(Message message) {
        if (this.D != null && this.E) {
            this.E = false;
            this.f.removeCallbacks(this.D);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        if (bDLocation != null && bDLocation.getLocType() == BDLocation.TypeServerError && this.I) {
            bDLocation.setLocType(62);
        }
        b(bDLocation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARNING: Missing block: B:7:0x003a, code skipped:
            if (r0.getLocType() != 67) goto L_0x005b;
     */
    /* JADX WARNING: Missing block: B:10:0x0044, code skipped:
            if (com.baidu.location.d.a.a().a == false) goto L_0x005b;
     */
    public void a(boolean r9, boolean r10) {
        /*
        r8 = this;
        r0 = com.baidu.location.d.g.a();
        r0 = r0.d();
        r1 = 0;
        if (r0 == 0) goto L_0x0047;
    L_0x000b:
        r0 = com.baidu.location.d.g.a();
        r0 = r0.g();
        if (r0 == 0) goto L_0x0047;
    L_0x0015:
        r2 = com.baidu.location.d.g.a();
        r0 = com.baidu.location.e.b.a();
        r3 = r0.f();
        r0 = com.baidu.location.e.i.a();
        r4 = r0.o();
        r5 = 0;
        r6 = com.baidu.location.d.g.b.IS_NOT_MIX_MODE;
        r7 = com.baidu.location.d.g.a.NEED_TO_LOG;
        r0 = r2.a(r3, r4, r5, r6, r7);
        if (r0 == 0) goto L_0x003c;
    L_0x0034:
        r2 = r0.getLocType();
        r3 = 67;
        if (r2 != r3) goto L_0x005b;
    L_0x003c:
        if (r9 == 0) goto L_0x005b;
    L_0x003e:
        r9 = com.baidu.location.d.a.a();
        r9 = r9.a;
        if (r9 == 0) goto L_0x005b;
    L_0x0046:
        goto L_0x0051;
    L_0x0047:
        if (r9 == 0) goto L_0x005a;
    L_0x0049:
        r9 = com.baidu.location.d.a.a();
        r9 = r9.a;
        if (r9 == 0) goto L_0x005a;
    L_0x0051:
        r9 = com.baidu.location.d.a.a();
        r0 = r9.a(r1);
        goto L_0x005b;
    L_0x005a:
        r0 = 0;
    L_0x005b:
        if (r0 == 0) goto L_0x0098;
    L_0x005d:
        r9 = r0.getLocType();
        r2 = 66;
        if (r9 != r2) goto L_0x0098;
    L_0x0065:
        r9 = 1;
        r2 = com.baidu.location.g.j.g;
        r3 = "all";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0077;
    L_0x0070:
        r2 = r0.getAddrStr();
        if (r2 != 0) goto L_0x0077;
    L_0x0076:
        r9 = r1;
    L_0x0077:
        r2 = com.baidu.location.g.j.h;
        if (r2 == 0) goto L_0x0082;
    L_0x007b:
        r2 = r0.getLocationDescribe();
        if (r2 != 0) goto L_0x0082;
    L_0x0081:
        r9 = r1;
    L_0x0082:
        r2 = com.baidu.location.g.j.j;
        if (r2 == 0) goto L_0x008d;
    L_0x0086:
        r2 = r0.getPoiList();
        if (r2 != 0) goto L_0x008d;
    L_0x008c:
        r9 = r1;
    L_0x008d:
        if (r9 != 0) goto L_0x0091;
    L_0x008f:
        if (r10 == 0) goto L_0x0098;
    L_0x0091:
        r9 = com.baidu.location.a.a.a();
        r9.a(r0);
    L_0x0098:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.l.a(boolean, boolean):void");
    }

    public void b(Message message) {
        if (this.H) {
            c(message);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0139  */
    public void b(com.baidu.location.BDLocation r19) {
        /*
        r18 = this;
        r0 = r18;
        r1 = r19;
        r8 = new com.baidu.location.BDLocation;
        r8.<init>(r1);
        r2 = r19.hasAddr();
        if (r2 == 0) goto L_0x0021;
    L_0x000f:
        r2 = r19.getAddress();
        r0.v = r2;
        r2 = r19.getLongitude();
        r0.y = r2;
        r2 = r19.getLatitude();
        r0.z = r2;
    L_0x0021:
        r2 = r19.getLocationDescribe();
        if (r2 == 0) goto L_0x0039;
    L_0x0027:
        r2 = r19.getLocationDescribe();
        r0.w = r2;
        r2 = r19.getLongitude();
        r0.y = r2;
        r2 = r19.getLatitude();
        r0.z = r2;
    L_0x0039:
        r2 = r19.getPoiList();
        if (r2 == 0) goto L_0x0051;
    L_0x003f:
        r2 = r19.getPoiList();
        r0.x = r2;
        r2 = r19.getLongitude();
        r0.y = r2;
        r2 = r19.getLatitude();
        r0.z = r2;
    L_0x0051:
        r2 = com.baidu.location.e.e.a();
        r2 = r2.j();
        r3 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r4 = 2;
        r5 = 0;
        if (r2 == 0) goto L_0x00bc;
    L_0x005f:
        r1 = com.baidu.location.e.e.a();
        r1 = r1.g();
        r2 = new com.baidu.location.BDLocation;
        r2.<init>(r1);
        r1 = com.baidu.location.g.j.g;
        r6 = "all";
        r1 = r1.equals(r6);
        if (r1 != 0) goto L_0x007e;
    L_0x0076:
        r1 = com.baidu.location.g.j.h;
        if (r1 != 0) goto L_0x007e;
    L_0x007a:
        r1 = com.baidu.location.g.j.j;
        if (r1 == 0) goto L_0x00b1;
    L_0x007e:
        r1 = new float[r4];
        r6 = r0.z;
        r8 = r0.y;
        r10 = r2.getLatitude();
        r12 = r2.getLongitude();
        r14 = r1;
        android.location.Location.distanceBetween(r6, r8, r10, r12, r14);
        r1 = r1[r5];
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 >= 0) goto L_0x00b1;
    L_0x0096:
        r1 = r0.v;
        if (r1 == 0) goto L_0x009f;
    L_0x009a:
        r1 = r0.v;
        r2.setAddr(r1);
    L_0x009f:
        r1 = r0.w;
        if (r1 == 0) goto L_0x00a8;
    L_0x00a3:
        r1 = r0.w;
        r2.setLocationDescribe(r1);
    L_0x00a8:
        r1 = r0.x;
        if (r1 == 0) goto L_0x00b1;
    L_0x00ac:
        r1 = r0.x;
        r2.setPoiList(r1);
    L_0x00b1:
        r1 = com.baidu.location.a.a.a();
        r1.a(r2);
        r18.m();
        return;
    L_0x00bc:
        r2 = r0.F;
        if (r2 == 0) goto L_0x0105;
    L_0x00c0:
        r2 = new float[r4];
        r3 = r0.k;
        if (r3 == 0) goto L_0x00df;
    L_0x00c6:
        r3 = r0.k;
        r9 = r3.getLatitude();
        r3 = r0.k;
        r11 = r3.getLongitude();
        r13 = r19.getLatitude();
        r15 = r19.getLongitude();
        r17 = r2;
        android.location.Location.distanceBetween(r9, r11, r13, r15, r17);
    L_0x00df:
        r2 = r2[r5];
        r3 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 <= 0) goto L_0x00f7;
    L_0x00e7:
        r0.k = r1;
        r2 = r0.G;
        if (r2 != 0) goto L_0x0101;
    L_0x00ed:
        r0.G = r5;
    L_0x00ef:
        r2 = com.baidu.location.a.a.a();
        r2.a(r1);
        goto L_0x0101;
    L_0x00f7:
        r2 = r19.getUserIndoorState();
        r3 = -1;
        if (r2 <= r3) goto L_0x0101;
    L_0x00fe:
        r0.k = r1;
        goto L_0x00ef;
    L_0x0101:
        r18.m();
        return;
    L_0x0105:
        r2 = r19.getLocType();
        r6 = 167; // 0xa7 float:2.34E-43 double:8.25E-322;
        r7 = 1;
        r9 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        if (r2 != r6) goto L_0x011c;
    L_0x0110:
        r2 = com.baidu.location.a.b.a();
        r3 = 8;
        r4 = "NetWork location failed because baidu location service can not caculate the location!";
        r2.a(r6, r3, r4);
        goto L_0x0178;
    L_0x011c:
        r2 = r19.getLocType();
        if (r2 != r9) goto L_0x0178;
    L_0x0122:
        r2 = android.os.Build.VERSION.SDK_INT;
        r6 = 19;
        if (r2 < r6) goto L_0x0136;
    L_0x0128:
        r2 = com.baidu.location.f.getServiceContext();
        r2 = com.baidu.location.g.j.c(r2);
        if (r2 == 0) goto L_0x0134;
    L_0x0132:
        if (r2 != r4) goto L_0x0136;
    L_0x0134:
        r2 = r7;
        goto L_0x0137;
    L_0x0136:
        r2 = r5;
    L_0x0137:
        if (r2 == 0) goto L_0x0143;
    L_0x0139:
        r2 = com.baidu.location.a.b.a();
        r3 = "NetWork location successful, open gps will be better!";
        r2.a(r9, r7, r3);
        goto L_0x0178;
    L_0x0143:
        r2 = r19.getRadius();
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 < 0) goto L_0x0178;
    L_0x014b:
        r2 = r19.getNetworkLocationType();
        if (r2 == 0) goto L_0x0178;
    L_0x0151:
        r2 = r19.getNetworkLocationType();
        r3 = "cl";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0178;
    L_0x015d:
        r2 = com.baidu.location.e.i.a();
        r2 = r2.h();
        if (r2 == 0) goto L_0x0178;
    L_0x0167:
        r3 = "&wifio=1";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0178;
    L_0x016f:
        r2 = com.baidu.location.a.b.a();
        r3 = "NetWork location successful, open wifi will be better!";
        r2.a(r9, r4, r3);
    L_0x0178:
        r2 = 0;
        r0.l = r2;
        r3 = r19.getLocType();
        if (r3 != r9) goto L_0x01b8;
    L_0x0181:
        r3 = "cl";
        r4 = r19.getNetworkLocationType();
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x01b8;
    L_0x018d:
        r3 = r0.k;
        if (r3 == 0) goto L_0x01b8;
    L_0x0191:
        r3 = r0.k;
        r3 = r3.getLocType();
        if (r3 != r9) goto L_0x01b8;
    L_0x0199:
        r3 = "wf";
        r4 = r0.k;
        r4 = r4.getNetworkLocationType();
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x01b8;
    L_0x01a7:
        r3 = java.lang.System.currentTimeMillis();
        r10 = r0.u;
        r12 = r3 - r10;
        r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r6 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1));
        if (r6 >= 0) goto L_0x01b8;
    L_0x01b5:
        r0.l = r1;
        r5 = r7;
    L_0x01b8:
        if (r5 == 0) goto L_0x01c4;
    L_0x01ba:
        r3 = com.baidu.location.a.a.a();
        r4 = r0.k;
        r3.a(r4);
        goto L_0x01d1;
    L_0x01c4:
        r3 = com.baidu.location.a.a.a();
        r3.a(r1);
        r3 = java.lang.System.currentTimeMillis();
        r0.u = r3;
    L_0x01d1:
        r3 = com.baidu.location.g.j.a(r19);
        if (r3 == 0) goto L_0x01dc;
    L_0x01d7:
        if (r5 != 0) goto L_0x01de;
    L_0x01d9:
        r0.k = r1;
        goto L_0x01de;
    L_0x01dc:
        r0.k = r2;
    L_0x01de:
        r3 = c;
        r4 = "ssid\":\"";
        r5 = "\"";
        r3 = com.baidu.location.g.j.a(r3, r4, r5);
        r4 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r3 == r4) goto L_0x01f6;
    L_0x01ec:
        r4 = r0.m;
        if (r4 == 0) goto L_0x01f6;
    L_0x01f0:
        r2 = r0.m;
        r2 = r2.d(r3);
    L_0x01f6:
        r0.j = r2;
        r2 = com.baidu.location.d.g.a();
        r2 = r2.d();
        if (r2 == 0) goto L_0x022f;
    L_0x0202:
        r2 = r19.getLocType();
        if (r2 != r9) goto L_0x022f;
    L_0x0208:
        r2 = "cl";
        r3 = r19.getNetworkLocationType();
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x022f;
    L_0x0214:
        r2 = r0.n;
        r2 = r0.b(r2);
        if (r2 == 0) goto L_0x022f;
    L_0x021c:
        r2 = com.baidu.location.d.g.a();
        r3 = r0.n;
        r4 = 0;
        r6 = com.baidu.location.d.g.b.IS_NOT_MIX_MODE;
        r7 = com.baidu.location.d.g.a.NO_NEED_TO_LOG;
        r5 = r8;
        r2.a(r3, r4, r5, r6, r7);
        r2 = r0.n;
        r0.p = r2;
    L_0x022f:
        r2 = com.baidu.location.d.g.a();
        r2 = r2.d();
        if (r2 == 0) goto L_0x025e;
    L_0x0239:
        r2 = r19.getLocType();
        if (r2 != r9) goto L_0x025e;
    L_0x023f:
        r2 = "wf";
        r1 = r19.getNetworkLocationType();
        r1 = r2.equals(r1);
        if (r1 == 0) goto L_0x025e;
    L_0x024b:
        r1 = com.baidu.location.d.g.a();
        r2 = 0;
        r3 = r0.m;
        r5 = com.baidu.location.d.g.b.IS_NOT_MIX_MODE;
        r6 = com.baidu.location.d.g.a.NO_NEED_TO_LOG;
        r4 = r8;
        r1.a(r2, r3, r4, r5, r6);
        r1 = r0.m;
        r0.o = r1;
    L_0x025e:
        r1 = r0.n;
        if (r1 == 0) goto L_0x026f;
    L_0x0262:
        r1 = com.baidu.location.d.a.a();
        r2 = c;
        r3 = r0.n;
        r4 = r0.m;
        r1.a(r2, r3, r4, r8);
    L_0x026f:
        r1 = com.baidu.location.e.i.j();
        if (r1 == 0) goto L_0x0283;
    L_0x0275:
        r1 = com.baidu.location.d.g.a();
        r1.i();
        r1 = com.baidu.location.d.g.a();
        r1.m();
    L_0x0283:
        r18.m();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.l.b(com.baidu.location.BDLocation):void");
    }

    public void c(BDLocation bDLocation) {
        this.k = new BDLocation(bDLocation);
    }

    public void d() {
        this.q = true;
        this.r = false;
        this.H = true;
    }

    public void e() {
        this.r = false;
        this.s = false;
        this.F = false;
        this.G = true;
        j();
        this.H = false;
    }

    public String f() {
        return this.w;
    }

    public List<Poi> g() {
        return this.x;
    }

    public boolean h() {
        return this.i;
    }

    public void i() {
        if (this.s) {
            h(null);
            this.s = false;
            return;
        }
        com.baidu.location.b.b.a().d();
    }

    public void j() {
        this.k = null;
    }
}
