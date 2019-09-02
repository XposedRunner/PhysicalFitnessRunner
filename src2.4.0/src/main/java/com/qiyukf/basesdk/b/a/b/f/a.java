package com.qiyukf.basesdk.b.a.b.f;

import android.content.Context;
import com.qiyukf.basesdk.b.a.b.c.b;
import com.qiyukf.basesdk.b.a.b.c.f;
import com.qiyukf.basesdk.b.a.b.e.c;
import com.qiyukf.basesdk.c.e;
import java.io.File;

public final class a {
    private static e a;

    public static b a(Context context, File file, Object obj, String str, f fVar, b bVar) {
        c.a(context, file, obj, fVar, bVar);
        b bVar2 = new b(new com.qiyukf.basesdk.b.a.b.a.a(context, fVar.d(), fVar.e(), fVar.f(), file, obj, str, fVar), bVar);
        if (a == null) {
            a = new e("NosUploadManager", e.b, true);
        }
        a.execute(bVar2);
        return bVar2;
    }

    public static void a() {
        if (a != null) {
            a.b();
            a = null;
        }
    }
}
