package cn.jiguang.d.b.a.a;

import android.content.Context;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.b.a.d;
import cn.jiguang.d.b.g;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements Runnable {
    private final LinkedList<i> a = new LinkedList();
    private final d b;

    public f(Context context, g gVar, long j) {
        this.b = new d(context, gVar, j);
        this.a.add(new h(this.b, true));
        this.a.add(new a(this.b));
        this.a.add(new k(this.b));
        this.a.add(new d(this.b));
        this.a.add(new e(this.b));
        this.a.add(new g(this.b));
        this.a.add(new j(this.b));
        this.a.add(new b(this.b));
        this.a.add(new h(this.b, false));
    }

    public final void a() {
        try {
            JCoreInterface.asyncExecute(this, new int[0]);
        } catch (Throwable unused) {
        }
    }

    public final int b() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            try {
                int a = ((i) it.next()).a();
                if (a == 0) {
                    return 0;
                }
                if (a == 2) {
                    return 2;
                }
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public final void run() {
        this.b.f();
    }
}
