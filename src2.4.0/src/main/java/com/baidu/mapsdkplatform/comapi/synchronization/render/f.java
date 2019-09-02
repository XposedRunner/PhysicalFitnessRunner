package com.baidu.mapsdkplatform.comapi.synchronization.render;

import android.os.HandlerThread;
import android.os.Message;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult;
import com.baidu.mapsdkplatform.comapi.synchronization.data.g;
import com.baidu.mapsdkplatform.comapi.synchronization.data.i;

public class f {
    private static final String a = "f";
    private static HandlerThread d;
    private int b;
    private int c;
    private b e;
    private g f;
    private i g;

    private class a implements i {
        private a() {
        }

        /* synthetic */ a(f fVar, g gVar) {
            this();
        }

        public void a() {
            f.this.j();
            f.this.e(f.this.b);
        }

        public void b() {
            f.this.i();
        }
    }

    private static class b {
        private static final f a = new f();
    }

    private f() {
        this.b = 0;
        this.c = 5;
    }

    /* synthetic */ f(g gVar) {
        this();
    }

    static f a() {
        return b.a;
    }

    private void e(int i) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The order state is: ");
        stringBuilder.append(i);
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, stringBuilder.toString());
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                f(i);
                return;
            default:
                str = a;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Undefined order state: ");
                stringBuilder.append(i);
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, stringBuilder.toString());
                return;
        }
    }

    private void f(int i) {
        if (this.e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler is null");
            return;
        }
        Message obtainMessage = this.e.obtainMessage();
        obtainMessage.what = i;
        this.e.sendMessage(obtainMessage);
    }

    private void i() {
        RoleOptions e = this.f.e();
        DisplayOptions f = this.f.f();
        if (this.e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler is null");
        } else {
            this.e.a(e, f, null, this.c);
        }
    }

    private void j() {
        SyncResponseResult syncResponseResult;
        RoleOptions e = this.f.e();
        DisplayOptions f = this.f.f();
        try {
            syncResponseResult = (SyncResponseResult) this.f.g().take();
        } catch (InterruptedException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get result when InterruptedException happened.", e2);
            syncResponseResult = null;
        }
        if (this.e == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler is null");
        } else {
            this.e.a(e, f, syncResponseResult, this.c);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i) {
        this.b = i;
        e(this.b);
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.e != null) {
            this.e.a(i, i2, i3, i4);
        }
    }

    public void a(BaiduMap baiduMap) {
        this.f = g.a();
        this.g = new a(this, null);
        this.f.a(this.g);
        d = new HandlerThread("SynchronizationRenderStrategy");
        d.start();
        this.e = new b(d.getLooper());
        this.e.a(baiduMap, this.f.e(), this.f.f());
    }

    /* Access modifiers changed, original: 0000 */
    public void a(d dVar) {
        if (this.e != null) {
            this.e.a(dVar);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Marker b() {
        if (this.e != null) {
            return this.e.a();
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler created failed");
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public void b(int i) {
        if (this.e != null) {
            this.e.a(i);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Marker c() {
        if (this.e != null) {
            return this.e.b();
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler created failed");
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public void c(int i) {
        if (this.e != null) {
            this.e.b(i);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Marker d() {
        if (this.e != null) {
            return this.e.c();
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncRenderHandler created failed");
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public void d(int i) {
        this.c = i;
    }

    public void e() {
        if (this.e != null) {
            this.e.d();
        }
    }

    public void f() {
        if (this.e != null) {
            this.e.e();
        }
    }

    public void g() {
        if (this.f != null) {
            this.f.c();
        }
        if (this.g != null) {
            this.g = null;
        }
        if (this.f != null) {
            this.f.h();
            this.f = null;
        }
        if (this.e != null) {
            this.e.f();
            this.e.removeCallbacksAndMessages(null);
            this.e = null;
        }
        if (d != null) {
            d.quit();
            d = null;
        }
    }

    public void h() {
        if (this.e != null) {
            this.e.g();
        }
    }
}
