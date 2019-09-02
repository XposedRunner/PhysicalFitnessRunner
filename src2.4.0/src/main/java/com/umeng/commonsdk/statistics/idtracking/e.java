package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.proguard.j;
import com.umeng.commonsdk.proguard.m;
import com.umeng.commonsdk.proguard.s;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.proto.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: IdTracker */
public class e {
    public static final long a = 86400000;
    public static e b;
    private static Object j = new Object();
    private final String c = "umeng_it.cache";
    private File d;
    private c e = null;
    private long f;
    private long g;
    private Set<a> h = new HashSet();
    private a i = null;

    /* compiled from: IdTracker */
    public static class a {
        private Context a;
        private Set<String> b = new HashSet();

        public a(Context context) {
            this.a = context;
        }

        public synchronized void a() {
            if (!this.b.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String append : this.b) {
                    stringBuilder.append(append);
                    stringBuilder.append(',');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                PreferenceWrapper.getDefault(this.a).edit().putString("invld_id", stringBuilder.toString()).commit();
            }
        }

        public synchronized boolean a(String str) {
            return this.b.contains(str) ^ 1;
        }

        public synchronized void b() {
            String string = PreferenceWrapper.getDefault(this.a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(",");
                if (split != null) {
                    for (CharSequence charSequence : split) {
                        if (!TextUtils.isEmpty(charSequence)) {
                            this.b.add(charSequence);
                        }
                    }
                }
            }
        }

        public synchronized void b(String str) {
            this.b.add(str);
        }

        public void c(String str) {
            this.b.remove(str);
        }
    }

    e(Context context) {
        this.d = new File(context.getFilesDir(), "umeng_it.cache");
        this.g = 86400000;
        this.i = new a(context);
        this.i.b();
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (b == null) {
                b = new e(context);
                b.a(new f(context));
                b.a(new b(context));
                b.a(new r(context));
                b.a(new d(context));
                b.a(new c(context));
                b.a(new g(context));
                b.a(new j());
                b.a(new s(context));
                a qVar = new q(context);
                if (!TextUtils.isEmpty(qVar.f())) {
                    b.a(qVar);
                }
                qVar = new i(context);
                if (qVar.g()) {
                    b.a(qVar);
                    b.a(new h(context));
                    qVar.i();
                }
                if (SdkVersion.SDK_TYPE != 1) {
                    b.a(new p(context));
                    b.a(new m(context));
                    b.a(new o(context));
                    b.a(new n(context));
                    b.a(new l(context));
                    b.a(new k(context));
                }
                b.e();
            }
            eVar = b;
        }
        return eVar;
    }

    private void a(c cVar) {
        synchronized (j) {
            if (cVar != null) {
                try {
                    byte[] a;
                    synchronized (this) {
                        a = new s().a(cVar);
                    }
                    if (a != null) {
                        HelperUtils.writeFile(this.d, a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean a(a aVar) {
        if (this.i.a(aVar.b())) {
            return this.h.add(aVar);
        }
        if (AnalyticsConstants.UM_DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid domain: ");
            stringBuilder.append(aVar.b());
            MLog.w(stringBuilder.toString());
        }
        return false;
    }

    private synchronized void g() {
        c cVar = new c();
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (a aVar : this.h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    hashMap.put(aVar.b(), aVar.d());
                }
                if (!(aVar.e() == null || aVar.e().isEmpty())) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(hashMap);
        synchronized (this) {
            this.e = cVar;
        }
    }

    private c h() {
        Exception e;
        Throwable th;
        synchronized (j) {
            if (this.d.exists()) {
                InputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream(this.d);
                    try {
                        byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        j cVar = new c();
                        new m().a(cVar, readStreamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            HelperUtils.safeClose(fileInputStream);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            HelperUtils.safeClose(fileInputStream);
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = null;
                    e.printStackTrace();
                    HelperUtils.safeClose(fileInputStream);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            }
            return null;
        }
    }

    public synchronized void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f >= this.g) {
            Object obj = null;
            for (a aVar : this.h) {
                if (aVar.c()) {
                    if (aVar.a()) {
                        obj = 1;
                        if (!aVar.c()) {
                            this.i.b(aVar.b());
                        }
                    }
                }
            }
            if (obj != null) {
                g();
                this.i.a();
                f();
            }
            this.f = currentTimeMillis;
        }
    }

    public void a(long j) {
        this.g = j;
    }

    public synchronized c b() {
        return this.e;
    }

    public String c() {
        return null;
    }

    public synchronized void d() {
        boolean z = false;
        for (a aVar : this.h) {
            if (aVar.c()) {
                if (!(aVar.e() == null || aVar.e().isEmpty())) {
                    aVar.a(null);
                    z = true;
                }
            }
        }
        if (z) {
            this.e.b(false);
            f();
        }
    }

    public synchronized void e() {
        c h = h();
        if (h != null) {
            ArrayList<a> arrayList = new ArrayList(this.h.size());
            synchronized (this) {
                this.e = h;
                for (a aVar : this.h) {
                    aVar.a(this.e);
                    if (!aVar.c()) {
                        arrayList.add(aVar);
                    }
                }
                for (a remove : arrayList) {
                    this.h.remove(remove);
                }
            }
            g();
        }
    }

    public synchronized void f() {
        if (this.e != null) {
            a(this.e);
        }
    }
}
