package com.qiyukf.basesdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.Calendar;

public final class c {
    private String a;
    private String b;
    private boolean c;
    private Handler d;
    private Calendar e;
    private MappedByteBuffer f;
    private long g;
    private long h;

    private static abstract class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public abstract void a();

        public final void run() {
            try {
                a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public c(String str, String str2, final boolean z) {
        a(str);
        this.b = str2;
        this.c = z;
        HandlerThread handlerThread = new HandlerThread("Log-Writer");
        handlerThread.start();
        this.d = new Handler(handlerThread.getLooper());
        this.d.post(new a() {
            public final void a() {
                if (z) {
                    b.a(c.this.c());
                    b.b(c.this.c());
                }
                c.this.e = b.a();
                File file = new File(c.this.a(c.this.e));
                if (file.exists()) {
                    c.this.g = b.a(file);
                    c.this.h = (long) ((int) file.length());
                    c.this.f = b.a(file, c.this.g, c.this.h - c.this.g);
                    return;
                }
                c.c(c.this);
            }
        });
    }

    private String a(Calendar calendar) {
        d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(a(false));
        stringBuilder.append(b.a.format(calendar.getTime()));
        return stringBuilder.toString();
    }

    private String a(boolean z) {
        return z ? this.b : this.c ? "tmp_c_" : "tmp_u_";
    }

    private String c() {
        d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(a(true));
        return stringBuilder.toString();
    }

    static /* synthetic */ void c(c cVar) {
        if (cVar.f != null) {
            cVar.f.force();
            cVar.f = null;
        }
        File file = new File(cVar.a(cVar.e));
        cVar.g = 0;
        cVar.h = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        cVar.f = b.a(file, 0, cVar.h);
    }

    private void d() {
        File file = new File(this.a);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    static /* synthetic */ boolean h(c cVar) {
        if (cVar.f != null) {
            cVar.f.force();
            cVar.f = null;
        }
        File file = new File(cVar.a(cVar.e));
        cVar.h += PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        cVar.f = b.a(file, cVar.g, cVar.h - cVar.g);
        return cVar.f != null;
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        if (!str.endsWith(HttpUtils.PATHS_SEPARATOR)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            str = stringBuilder.toString();
        }
        this.a = str;
    }

    public final void a(String str, long j, String str2, Throwable th) {
        final String str3 = str;
        final long j2 = j;
        final String str4 = str2;
        final Throwable th2 = th;
        this.d.post(new a() {
            public final void a() {
                if (c.this.f != null) {
                    String a = b.a(str3, j2, str4, th2);
                    if (!TextUtils.isEmpty(a)) {
                        if (System.currentTimeMillis() - c.this.e.getTimeInMillis() >= LogBuilder.MAX_INTERVAL) {
                            if (c.this.c) {
                                b.b(c.this.c());
                            }
                            c.this.e = b.a();
                            c.c(c.this);
                        }
                        if (!new File(c.this.a(c.this.e)).exists()) {
                            c.c(c.this);
                        }
                        byte[] bytes = a.getBytes();
                        if (c.this.g + ((long) bytes.length) <= c.this.h || c.h(c.this)) {
                            c.this.f.put(bytes);
                            c.this.g = c.this.g + ((long) bytes.length);
                        }
                    }
                }
            }
        });
    }

    public final String b() {
        try {
            b.c(c());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c();
    }
}
