package cn.jiguang.d.i;

import android.content.Context;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.SdkType;
import cn.jiguang.d.a;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.b;
import cn.jpush.android.service.DownloadProvider;
import java.util.concurrent.atomic.AtomicBoolean;

public class f {
    private static f d;
    private e a;
    private h b;
    private AtomicBoolean c;

    private f() {
        this.a = null;
        this.b = null;
        this.c = new AtomicBoolean(false);
        this.a = new e();
        this.b = new h();
    }

    public static f a() {
        if (d == null) {
            synchronized (f.class) {
                if (d == null) {
                    d = new f();
                }
            }
        }
        return d;
    }

    public final void a(Context context) {
        if (!this.c.get()) {
            String b = a.b(context);
            if (b == null) {
                b = "";
            }
            this.a.c(JCoreInterface.getDaemonAction());
            this.a.d("cn.jpush.android.service.PushService");
            this.a.a(DownloadProvider.class);
            this.a.a(3600);
            this.a.b(d.c(context));
            this.a.a(b);
            this.b.a(3600);
            h hVar = this.b;
            b.a();
            hVar.b(b.d(SdkType.JPUSH.name(), ""));
            this.b.a(b);
            this.c.set(true);
        }
    }

    public final void a(Context context, boolean z) {
        try {
            JCoreInterface.asyncExecute(new g(this, context, z), new int[0]);
        } catch (Throwable unused) {
        }
    }

    public final e b() {
        return this.a;
    }

    public final h c() {
        return this.b;
    }
}
