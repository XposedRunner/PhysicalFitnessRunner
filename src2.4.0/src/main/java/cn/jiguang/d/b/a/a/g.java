package cn.jiguang.d.b.a.a;

import android.text.TextUtils;
import cn.jiguang.d.a.a;
import cn.jiguang.d.b.a.d;

public final class g extends i {
    public g(d dVar) {
        super(dVar);
    }

    /* Access modifiers changed, original: final */
    public final int a() {
        String str = "LastGoodConnPolicy";
        String b = a.b();
        if (TextUtils.isEmpty(b)) {
            return -1;
        }
        cn.jiguang.d.b.a.a aVar = new cn.jiguang.d.b.a.a();
        aVar.a(b, a.c(), str);
        return b(aVar);
    }
}
