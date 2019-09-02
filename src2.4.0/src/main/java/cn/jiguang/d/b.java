package cn.jiguang.d;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import cn.jiguang.d.d.i;
import cn.jiguang.g.a.a;

final class b implements ServiceConnection {
    b() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a.a(cn.jiguang.b.b.a(iBinder));
        if (a.d != null) {
            i.a().b(a.d, "intent.INIT", new Bundle());
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
