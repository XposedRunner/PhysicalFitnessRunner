package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.a.c;
import cn.jpush.android.api.b;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o {
    private static volatile o a;
    private static final Object b = new Object();
    private ConcurrentHashMap<Long, p> c = new ConcurrentHashMap();

    public static o a() {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new o();
                }
            }
        }
        return a;
    }

    private static p a(JSONObject jSONObject, p pVar) {
        if (pVar == null) {
            return null;
        }
        if (TextUtils.equals(jSONObject.optString("op"), "get")) {
            if (pVar.a == 1) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("tags");
                    if (!(optJSONArray == null || optJSONArray.length() == 0)) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.getString(i));
                        }
                        if (arrayList.size() > 0) {
                            pVar.d.addAll(arrayList);
                            return pVar;
                        }
                    }
                } catch (Throwable unused) {
                }
            } else {
                String optString = jSONObject.optString("alias");
                if (optString != null) {
                    pVar.e = optString;
                }
            }
        }
        return pVar;
    }

    protected static boolean a(Context context, int i, long j) {
        Context context2 = context;
        int i2 = i;
        if (i2 == 1 || i2 == 2) {
            boolean z;
            long j2 = MultiSpHelper.getLong(context2, "TAFreezeEndTime", -1);
            if (j2 > 1800) {
                j2 = 0;
            }
            long j3 = MultiSpHelper.getLong(context2, "TAFreezeSetTime", -1);
            if (j2 == -1 || j3 == -1 || (System.currentTimeMillis() - j3 >= 0 && System.currentTimeMillis() - j3 <= j2)) {
                z = false;
            } else {
                MultiSpHelper.commitLong(context2, "TAFreezeSetTime", -1);
                MultiSpHelper.commitLong(context2, "TAFreezeEndTime", -1);
                z = true;
            }
            if (z) {
                n.a(context2, i2, b.u, j);
                return true;
            }
        }
        return false;
    }

    private boolean a(Context context, p pVar) {
        if (pVar == null) {
            return false;
        }
        c a;
        if (pVar.a == 1) {
            a = n.a(context, pVar.d, pVar.c, pVar.b, pVar.g);
        } else {
            if (pVar.a == 2) {
                a = n.a(context, pVar.e, pVar.c, pVar.a);
            }
            return false;
        }
        if (a != null) {
            if (pVar.h > 200) {
                this.c.remove(Long.valueOf(pVar.c));
                n.a(context, pVar.a, b.o, pVar.c);
                return true;
            }
            n.a(context, a);
            pVar.h++;
            this.c.put(Long.valueOf(pVar.c), pVar);
            return true;
        }
        return false;
    }

    public final int a(long j) {
        p pVar = (p) this.c.remove(Long.valueOf(j));
        return pVar != null ? pVar.a : 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c A:{RETURN} */
    public final android.content.Intent a(android.content.Context r6, long r7, int r9, org.json.JSONObject r10, android.content.Intent r11) {
        /*
        r5 = this;
        r0 = r5.c;
        r1 = java.lang.Long.valueOf(r7);
        r0 = r0.get(r1);
        r0 = (cn.jpush.android.a.p) r0;
        r1 = r5.c;
        r7 = java.lang.Long.valueOf(r7);
        r1.remove(r7);
        if (r0 != 0) goto L_0x0018;
    L_0x0017:
        return r11;
    L_0x0018:
        r7 = 0;
        r8 = 1;
        if (r9 != r8) goto L_0x0038;
    L_0x001c:
        r1 = r0.h;
        if (r1 != 0) goto L_0x0038;
    L_0x0020:
        r1 = r0.h;
        r1 = r1 + r8;
        r0.h = r1;
        r1 = r0.a;
        r2 = r0.c;
        r1 = a(r6, r1, r2);
        if (r1 == 0) goto L_0x0031;
    L_0x002f:
        r1 = r8;
        goto L_0x0039;
    L_0x0031:
        r1 = r5.a(r6, r0);
        if (r1 == 0) goto L_0x0038;
    L_0x0037:
        goto L_0x002f;
    L_0x0038:
        r1 = r7;
    L_0x0039:
        r2 = 0;
        if (r1 == 0) goto L_0x003d;
    L_0x003c:
        return r2;
    L_0x003d:
        if (r9 == 0) goto L_0x00a9;
    L_0x003f:
        r7 = 100;
        if (r9 != r7) goto L_0x0085;
    L_0x0043:
        r8 = "wait";
        r1 = -1;
        r1 = r10.optLong(r8, r1);
        r8 = "TagAliasNewProtoRetryHelper";
        r10 = new java.lang.StringBuilder;
        r3 = "set tag/alias action will freeze ";
        r10.<init>(r3);
        r10.append(r1);
        r3 = " seconds";
        r10.append(r3);
        r10 = r10.toString();
        cn.jpush.android.d.f.c(r8, r10);
        r3 = 0;
        r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r8 <= 0) goto L_0x0085;
    L_0x0069:
        r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r8 < 0) goto L_0x0085;
    L_0x006d:
        r3 = 1800; // 0x708 float:2.522E-42 double:8.893E-321;
        r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r8 <= 0) goto L_0x0074;
    L_0x0073:
        r1 = r3;
    L_0x0074:
        r8 = "TAFreezeSetTime";
        r3 = java.lang.System.currentTimeMillis();
        cn.jiguang.api.MultiSpHelper.commitLong(r6, r8, r3);
        r8 = "TAFreezeEndTime";
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = r1 * r3;
        cn.jiguang.api.MultiSpHelper.commitLong(r6, r8, r1);
    L_0x0085:
        r6 = r0.a;
        if (r6 == 0) goto L_0x00a3;
    L_0x0089:
        if (r9 == r7) goto L_0x00a1;
    L_0x008b:
        switch(r9) {
            case 0: goto L_0x00a3;
            case 1: goto L_0x009e;
            case 2: goto L_0x009e;
            case 3: goto L_0x009b;
            case 4: goto L_0x0098;
            case 5: goto L_0x0095;
            case 6: goto L_0x0092;
            case 7: goto L_0x008f;
            case 8: goto L_0x008f;
            default: goto L_0x008e;
        };
    L_0x008e:
        goto L_0x00a3;
    L_0x008f:
        r9 = cn.jpush.android.api.b.t;
        goto L_0x00a3;
    L_0x0092:
        r9 = cn.jpush.android.api.b.s;
        goto L_0x00a3;
    L_0x0095:
        r9 = cn.jpush.android.api.b.r;
        goto L_0x00a3;
    L_0x0098:
        r9 = cn.jpush.android.api.b.q;
        goto L_0x00a3;
    L_0x009b:
        r9 = cn.jpush.android.api.b.p;
        goto L_0x00a3;
    L_0x009e:
        r9 = cn.jpush.android.api.b.o;
        goto L_0x00a3;
    L_0x00a1:
        r9 = cn.jpush.android.api.b.u;
    L_0x00a3:
        r6 = "tagalias_errorcode";
        r11.putExtra(r6, r9);
        return r11;
    L_0x00a9:
        r0.h = r7;
        r9 = r0.b;
        r1 = 5;
        if (r9 != r1) goto L_0x00c4;
    L_0x00b0:
        r9 = "total";
        r3 = -1;
        r9 = r10.optInt(r9, r3);
        r0.f = r9;
        r9 = "curr";
        r9 = r10.optInt(r9, r3);
        r0.g = r9;
        a(r10, r0);
    L_0x00c4:
        if (r0 != 0) goto L_0x00c8;
    L_0x00c6:
        r9 = r7;
        goto L_0x00d0;
    L_0x00c8:
        r9 = r0.g;
        r3 = r0.f;
        if (r9 < r3) goto L_0x00cf;
    L_0x00ce:
        goto L_0x00c6;
    L_0x00cf:
        r9 = r8;
    L_0x00d0:
        if (r9 == 0) goto L_0x00e9;
    L_0x00d2:
        r9 = r0.g;
        r9 = r9 + r8;
        r0.g = r9;
        r9 = r0.a;
        r3 = r0.c;
        r9 = a(r6, r9, r3);
        if (r9 == 0) goto L_0x00e2;
    L_0x00e1:
        return r2;
    L_0x00e2:
        r6 = r5.a(r6, r0);
        if (r6 == 0) goto L_0x00e9;
    L_0x00e8:
        return r2;
    L_0x00e9:
        r6 = r0.b;
        if (r6 != r1) goto L_0x0112;
    L_0x00ed:
        r6 = r0.a;
        if (r6 != r8) goto L_0x0101;
    L_0x00f1:
        r6 = r0.d;
        r6 = r6.size();
        if (r6 <= 0) goto L_0x0126;
    L_0x00f9:
        r6 = "tags";
        r7 = r0.d;
        r11.putStringArrayListExtra(r6, r7);
        return r11;
    L_0x0101:
        r6 = r0.a;
        r7 = 2;
        if (r6 != r7) goto L_0x0126;
    L_0x0106:
        r6 = r0.e;
        if (r6 == 0) goto L_0x0126;
    L_0x010a:
        r6 = "alias";
        r7 = r0.e;
        r11.putExtra(r6, r7);
        return r11;
    L_0x0112:
        r6 = r0.b;
        r9 = 6;
        if (r6 != r9) goto L_0x0126;
    L_0x0117:
        r6 = r0.a;
        if (r6 != r8) goto L_0x0126;
    L_0x011b:
        r6 = "validated";
        r8 = "validated";
        r7 = r10.optBoolean(r8, r7);
        r11.putExtra(r6, r7);
    L_0x0126:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.o.a(android.content.Context, long, int, org.json.JSONObject, android.content.Intent):android.content.Intent");
    }

    public final void a(int i, int i2, long j, ArrayList<String> arrayList, String str) {
        this.c.put(Long.valueOf(j), new p(this, i, i2, j, arrayList, str));
    }

    public final boolean a(int i) {
        if (!(this.c == null || this.c.isEmpty())) {
            for (Entry value : this.c.entrySet()) {
                p pVar = (p) value.getValue();
                if (pVar != null && pVar.a == i) {
                    return false;
                }
            }
        }
        return true;
    }
}
