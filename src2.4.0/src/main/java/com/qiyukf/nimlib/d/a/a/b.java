package com.qiyukf.nimlib.d.a.a;

import android.content.Context;
import android.os.Handler;
import java.util.Map;

public final class b {
    private static b a;
    private boolean b = false;
    private com.qiyukf.nimlib.d.a.c.b c;
    private Handler d;

    public interface a {
        void a(String str, int i, Throwable th);
    }

    public class b implements Runnable {
        private String b;
        private Map<String, String> c;
        private String d;
        private a e;
        private boolean f;

        public b(String str, Map<String, String> map, String str2, a aVar, boolean z) {
            this.b = str;
            this.c = map;
            this.d = str2;
            this.e = aVar;
            this.f = z;
        }

        public final void run() {
            final a a = this.f ? a.a(this.b, this.c, this.d) : a.a(this.b, this.c);
            b.this.d.post(new Runnable() {
                public final void run() {
                    if (b.this.e != null) {
                        b.this.e.a((String) a.c, a.a, a.b);
                    }
                }
            });
        }
    }

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    public final void a(Context context) {
        if (!this.b) {
            this.c = new com.qiyukf.nimlib.d.a.c.b("NIM_HTTP_TASK_EXECUTOR", new com.qiyukf.nimlib.d.a.c.b.a());
            this.d = new Handler(context.getMainLooper());
            this.b = true;
        }
    }

    public final void a(String str, Map<String, String> map, String str2, a aVar) {
        a(str, map, str2, true, aVar);
    }

    public final void a(String str, Map<String, String> map, String str2, boolean z, a aVar) {
        if (this.b) {
            this.c.execute(new b(str, map, str2, aVar, z));
        }
    }
}
