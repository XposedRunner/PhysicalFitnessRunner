package com.baidu.location.d;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.baidu.location.e.h;
import com.baidu.location.f;
import java.io.File;

public final class g {
    public static final String a = com.baidu.location.g.a.a;
    static final String b = "http://ofloc.map.baidu.com/offline_loc";
    private static Context c;
    private static volatile g d;
    private static Object e = new Object();
    private final File f;
    private final j g;
    private final c h;
    private final k i;
    private final f j;

    public enum a {
        NEED_TO_LOG,
        NO_NEED_TO_LOG
    }

    public enum b {
        IS_MIX_MODE,
        IS_NOT_MIX_MODE
    }

    private enum c {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G
    }

    private g() {
        File file;
        try {
            file = new File(c.getFilesDir(), "ofld");
            try {
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            file = null;
        }
        this.f = file;
        this.h = new c(this);
        this.g = new j(this.h.a());
        this.j = new f(this, this.h.a());
        this.i = new k(this, this.h.a(), this.j.n());
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0027 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|10|8) */
    /* JADX WARNING: Missing block: B:7:?, code skipped:
            r7.cancel(true);
     */
    /* JADX WARNING: Missing block: B:8:0x002d, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:9:0x002e, code skipped:
            r0.shutdown();
     */
    private com.baidu.location.BDLocation a(java.lang.String[] r7) {
        /*
        r6 = this;
        r0 = new com.baidu.location.BDLocation;
        r0.<init>();
        r0 = java.util.concurrent.Executors.newSingleThreadExecutor();
        r1 = new com.baidu.location.d.h;
        r1.<init>(r6, r7);
        r7 = r0.submit(r1);
        r7 = (java.util.concurrent.FutureTask) r7;
        r1 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r3 = 0;
        r4 = 1;
        r5 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0027, InterruptedException | ExecutionException | TimeoutException -> 0x0027, InterruptedException | ExecutionException | TimeoutException -> 0x0027 }
        r1 = r7.get(r1, r5);	 Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0027, InterruptedException | ExecutionException | TimeoutException -> 0x0027, InterruptedException | ExecutionException | TimeoutException -> 0x0027 }
        r1 = (com.baidu.location.BDLocation) r1;	 Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0027, InterruptedException | ExecutionException | TimeoutException -> 0x0027, InterruptedException | ExecutionException | TimeoutException -> 0x0027 }
        r0.shutdown();
        r3 = r1;
        return r3;
    L_0x0025:
        r7 = move-exception;
        goto L_0x002e;
    L_0x0027:
        r7.cancel(r4);	 Catch:{ all -> 0x0025 }
        r0.shutdown();
        return r3;
    L_0x002e:
        r0.shutdown();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.g.a(java.lang.String[]):com.baidu.location.BDLocation");
    }

    public static g a() {
        g gVar;
        synchronized (e) {
            if (d == null) {
                if (c == null) {
                    a(f.getServiceContext());
                }
                d = new g();
            }
            d.q();
            gVar = d;
        }
        return gVar;
    }

    public static void a(Context context) {
        if (c == null) {
            c = context;
            com.baidu.location.g.b.a().a(c);
        }
    }

    private static final Uri c(String str) {
        return Uri.parse(String.format("content://%s/", new Object[]{str}));
    }

    private void q() {
        this.j.g();
    }

    private boolean r() {
        String packageName = c.getPackageName();
        String[] o = this.j.o();
        ProviderInfo providerInfo = null;
        for (String resolveContentProvider : o) {
            try {
                providerInfo = c.getPackageManager().resolveContentProvider(resolveContentProvider, 0);
            } catch (Exception unused) {
                providerInfo = null;
            }
            if (providerInfo != null) {
                break;
            }
        }
        return providerInfo == null || packageName.equals(providerInfo.packageName);
    }

    public long a(String str) {
        return this.j.a(str);
    }

    public BDLocation a(com.baidu.location.e.a aVar, h hVar, BDLocation bDLocation, b bVar, a aVar2) {
        int i;
        String stringBuilder;
        if (bVar == b.IS_MIX_MODE) {
            int a = this.j.a();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(com.baidu.location.g.b.a().d());
            stringBuilder2.append("&mixMode=1");
            i = a;
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = com.baidu.location.g.b.a().d();
            i = 0;
        }
        String[] a2 = i.a(aVar, hVar, bDLocation, stringBuilder, (aVar2 == a.NEED_TO_LOG ? Boolean.valueOf(true) : Boolean.valueOf(false)).booleanValue(), i);
        BDLocation bDLocation2 = null;
        if (a2.length > 0) {
            bDLocation2 = a(a2);
            if (bDLocation2 != null) {
                bDLocation2.getLocType();
            }
        }
        return bDLocation2;
    }

    public Context b() {
        return c;
    }

    /* Access modifiers changed, original: 0000 */
    public File c() {
        return this.f;
    }

    public boolean d() {
        return this.j.h();
    }

    public boolean e() {
        return this.j.i();
    }

    public boolean f() {
        return this.j.j();
    }

    public boolean g() {
        return this.j.k();
    }

    public boolean h() {
        return this.j.m();
    }

    public void i() {
        this.g.a();
    }

    /* Access modifiers changed, original: 0000 */
    public j j() {
        return this.g;
    }

    /* Access modifiers changed, original: 0000 */
    public k k() {
        return this.i;
    }

    /* Access modifiers changed, original: 0000 */
    public f l() {
        return this.j;
    }

    public void m() {
        if (r()) {
            this.h.b();
        }
    }

    public void n() {
    }

    public double o() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) c.getSystemService("connectivity")).getActiveNetworkInfo();
        c cVar = c.NETWORK_UNKNOWN;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                cVar = c.NETWORK_WIFI;
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                    cVar = c.NETWORK_2G;
                } else if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) {
                    cVar = c.NETWORK_3G;
                } else if (subtype == 13) {
                    cVar = c.NETWORK_4G;
                }
            }
        }
        double d = 0.0d;
        if (cVar == c.NETWORK_UNKNOWN) {
            return this.j.b();
        }
        if (cVar == c.NETWORK_WIFI) {
            return this.j.c();
        }
        if (cVar == c.NETWORK_2G) {
            return this.j.d();
        }
        if (cVar == c.NETWORK_3G) {
            return this.j.e();
        }
        if (cVar == c.NETWORK_4G) {
            d = this.j.f();
        }
        return d;
    }
}
