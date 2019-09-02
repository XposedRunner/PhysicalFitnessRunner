package cn.jiguang.d.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.a.a.b.e;
import cn.jiguang.a.a.b.f;
import cn.jiguang.d.a;
import cn.jiguang.d.a.d;
import cn.jiguang.d.b.a.g;
import cn.jiguang.g.k;
import defpackage.O0000Oo0;
import java.util.LinkedHashSet;
import java.util.concurrent.FutureTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class v {
    private static w a;
    private static volatile FutureTask<?> b;
    private static final Object c = new Object();

    static /* synthetic */ g a(Context context) {
        String b = a.b(context);
        long c = d.c(context);
        int a = k.a(context);
        String b2 = k.b(context);
        e a2 = f.a(context);
        return new g(a, b, O0000Oo0.O00000oo, c, b2, a2.b(), a2.c(), a2.d());
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0046 */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:11|12|(2:18|19)|20|21) */
    public static void a(android.content.Context r4, boolean r5) {
        /*
        r0 = a;
        r1 = 0;
        if (r0 != 0) goto L_0x000c;
    L_0x0005:
        r0 = new cn.jiguang.d.d.w;
        r0.<init>(r4, r1);
        a = r0;
    L_0x000c:
        r4 = b;
        if (r4 == 0) goto L_0x0020;
    L_0x0010:
        r4 = b;
        r4 = r4.isCancelled();
        if (r4 != 0) goto L_0x0020;
    L_0x0018:
        r4 = b;
        r4 = r4.isDone();
        if (r4 == 0) goto L_0x0047;
    L_0x0020:
        r4 = c;
        monitor-enter(r4);
        r0 = b;	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0037;
    L_0x0027:
        r0 = b;	 Catch:{ all -> 0x0053 }
        r0 = r0.isCancelled();	 Catch:{ all -> 0x0053 }
        if (r0 != 0) goto L_0x0037;
    L_0x002f:
        r0 = b;	 Catch:{ all -> 0x0053 }
        r0 = r0.isDone();	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0046;
    L_0x0037:
        r0 = new java.util.concurrent.FutureTask;	 Catch:{ Throwable -> 0x0046 }
        r2 = a;	 Catch:{ Throwable -> 0x0046 }
        r3 = 0;
        r0.<init>(r2, r3);	 Catch:{ Throwable -> 0x0046 }
        b = r0;	 Catch:{ Throwable -> 0x0046 }
        r1 = new int[r1];	 Catch:{ Throwable -> 0x0046 }
        cn.jiguang.api.JCoreInterface.asyncExecute(r0, r1);	 Catch:{ Throwable -> 0x0046 }
    L_0x0046:
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
    L_0x0047:
        if (r5 == 0) goto L_0x0052;
    L_0x0049:
        r4 = b;	 Catch:{ InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052, InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052, InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052, InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052 }
        r0 = 10;
        r5 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052, InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052, InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052, InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052 }
        r4.get(r0, r5);	 Catch:{ InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052, InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052, InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052, InterruptedException | Throwable | ExecutionException | TimeoutException -> 0x0052 }
    L_0x0052:
        return;
    L_0x0053:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.d.v.a(android.content.Context, boolean):void");
    }

    private static boolean b(Context context, String str, String str2) {
        ab a = h.a(str, str2, context, true, 3, 2);
        if (a.a() == 0) {
            str = a.b();
            if (!TextUtils.isEmpty(str)) {
                try {
                    c.a().a(context, new JSONObject(str).getJSONObject("ret"));
                    return true;
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    private static LinkedHashSet<String> c(Context context) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String p = d.p(context);
        if (TextUtils.isEmpty(p)) {
            return linkedHashSet;
        }
        try {
            JSONArray jSONArray = new JSONArray(p);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedHashSet.add(jSONArray.optString(i));
            }
        } catch (JSONException unused) {
        }
        return linkedHashSet;
    }
}
