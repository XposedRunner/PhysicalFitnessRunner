package cn.jiguang.d.c;

import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import cn.jiguang.e.c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f {
    public static List<p> a(String str) {
        String str2;
        StringBuilder stringBuilder;
        String str3;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            String[] a = o.b().a();
            byte[] b = h.a(m.a(j.a(j.a(str), j.a), 33, 1)).b(SupportMenu.USER_MASK);
            int length = a.length;
            int i = 0;
            while (i < length) {
                String str4 = a[i];
                try {
                    h hVar = new h(r.a(null, new InetSocketAddress(InetAddress.getByName(str4), 53), b, System.currentTimeMillis() + 1000));
                    m a2 = hVar.a();
                    if (a2 == null) {
                        return arrayList;
                    }
                    for (l lVar : hVar.a(1)) {
                        if (lVar.b().e() == a2.e()) {
                            int d = lVar.b().d();
                            j b2 = lVar.b().b();
                            if (d == a2.c() && b2.equals(a2.b())) {
                                Iterator a3 = lVar.a();
                                while (a3.hasNext()) {
                                    p pVar = (p) a3.next();
                                    if (pVar.h() > 0) {
                                        arrayList.add(pVar);
                                    }
                                }
                            }
                        }
                    }
                    i++;
                } catch (UnknownHostException e) {
                    str2 = "DNSSrvUtils";
                    stringBuilder = new StringBuilder("Get default ports error at ");
                    stringBuilder.append(str4);
                    stringBuilder.append(", with UnknownHostException:");
                    stringBuilder.append(e.getMessage());
                    str4 = stringBuilder.toString();
                    c.c(str2, str4);
                    i++;
                } catch (IOException e2) {
                    str2 = "DNSSrvUtils";
                    stringBuilder = new StringBuilder("Get default ports error at ");
                    stringBuilder.append(str4);
                    stringBuilder.append(", with IOException:");
                    stringBuilder.append(e2.getMessage());
                    str4 = stringBuilder.toString();
                    c.c(str2, str4);
                    i++;
                }
            }
        } catch (s unused) {
            str = "DNSSrvUtils";
            str3 = "Get default ports error with TextParseException";
            c.c(str, str3);
            return arrayList;
        } catch (k unused2) {
            str = "DNSSrvUtils";
            str3 = "Get default ports error with NameTooLongException";
            c.c(str, str3);
            return arrayList;
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("Get default ports error with Exception:");
            stringBuilder2.append(th);
            c.c("DNSSrvUtils", stringBuilder2.toString());
            return arrayList;
        }
        return arrayList;
    }
}
