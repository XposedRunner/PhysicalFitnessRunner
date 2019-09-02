package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.a.d;
import com.tencent.stat.common.StatLogger;
import java.io.File;
import java.util.Iterator;

class i implements Runnable {
    private Context a = null;

    public i(Context context) {
        this.a = context;
    }

    public void run() {
        Iterator it = StatNativeCrashReport.a(this.a).iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            d dVar = new d(this.a, StatService.a(this.a, false), StatNativeCrashReport.a(file), 3, 10240);
            dVar.a(StatNativeCrashReport.b(file));
            if (StatService.c(this.a) != null) {
                StatService.c(this.a).post(new k(dVar));
            }
            file.delete();
            StatLogger b = StatService.i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete tombstone file:");
            stringBuilder.append(file.getAbsolutePath().toString());
            b.d(stringBuilder.toString());
        }
    }
}
