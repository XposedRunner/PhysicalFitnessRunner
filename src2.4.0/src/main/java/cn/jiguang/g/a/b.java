package cn.jiguang.g.a;

import android.os.IBinder.DeathRecipient;
import cn.jiguang.d.a;
import cn.jiguang.d.a.d;

final class b implements DeathRecipient {
    b() {
    }

    public final void binderDied() {
        a.a(a.d, false);
        d.c(a.d, false);
    }
}
