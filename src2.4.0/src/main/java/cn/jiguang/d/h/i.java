package cn.jiguang.d.h;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

public final class i {
    private static HashMap<String, s> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("SDK_MAIN", new j());
        a.put("ACTION", new k());
        a.put("BUILD_REPORT", new l());
        a.put("UPLOAD_REPORT", new n());
        a.put("REPORT_HISTORY", new o());
        a.put("ASYNC", new q());
    }

    public static void a(String str, int i, int i2) {
        if (!a.containsKey(str)) {
            a.put(str, new r(str, 4, -1));
        }
    }

    public static void a(String str, Runnable runnable, int i) {
        s sVar = (s) a.get(str);
        if (sVar != null) {
            ExecutorService executorService = null;
            try {
                ExecutorService a = sVar.a(true);
                try {
                    t.a(a, new w(runnable, i));
                } catch (Throwable unused) {
                    executorService = a;
                    t.a(executorService);
                    try {
                        t.a(sVar.a(true), new w(runnable, i));
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable unused3) {
                t.a(executorService);
                t.a(sVar.a(true), new w(runnable, i));
            }
        }
    }
}
