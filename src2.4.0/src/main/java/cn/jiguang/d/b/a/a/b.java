package cn.jiguang.d.b.a.a;

import android.text.TextUtils;
import cn.jiguang.d.a;
import cn.jiguang.d.b.a.d;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Iterator;

public final class b extends i {
    public b(d dVar) {
        super(dVar);
    }

    /* Access modifiers changed, original: final */
    public final int a() {
        String str = "DefaultConnPolicy";
        InetAddress b = cn.jiguang.d.d.d.b(a.f.d());
        if (b == null) {
            return -1;
        }
        String hostAddress = b.getHostAddress();
        if (TextUtils.isEmpty(hostAddress)) {
            return -1;
        }
        c cVar = new c(this);
        cVar.add(Integer.valueOf(7000));
        cVar.add(Integer.valueOf(7002));
        cVar.add(Integer.valueOf(7003));
        cVar.add(Integer.valueOf(7004));
        cVar.add(Integer.valueOf(7005));
        cVar.add(Integer.valueOf(7006));
        cVar.add(Integer.valueOf(7007));
        cVar.add(Integer.valueOf(7008));
        cVar.add(Integer.valueOf(7009));
        try {
            Collections.shuffle(cVar);
        } catch (Throwable unused) {
        }
        cn.jiguang.d.b.a.a aVar = new cn.jiguang.d.b.a.a();
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            aVar.a(hostAddress, ((Integer) it.next()).intValue(), str);
        }
        return b(aVar);
    }
}
