package cn.jpush.android.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JRequest;
import cn.jpush.a.c;
import cn.jpush.android.a;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.api.b;
import cn.jpush.android.d.f;
import cn.jpush.android.d.h;
import cn.jpush.android.service.ServiceInterface;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public final class n {
    private static ConcurrentLinkedQueue<Long> a = new ConcurrentLinkedQueue();

    protected static long a(Context context, String str, int i, long j) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE, b.j);
            if (i == 0) {
                j = jSONObject.optLong("sequence");
            }
            Intent intent = new Intent();
            intent.addCategory(a.c);
            intent.putExtra("proto_type", i);
            intent.setPackage(context.getPackageName());
            if (i == 0) {
                intent.setAction("cn.jpush.android.intent.TAG_ALIAS_CALLBACK");
            } else {
                intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
                if (i == 1) {
                    intent.putExtra("message_type", 1);
                } else {
                    intent.putExtra("message_type", 2);
                }
            }
            intent.putExtra("tagalias_errorcode", optInt);
            intent.putExtra("tagalias_seqid", j);
            Intent a = o.a().a(context, j, optInt, jSONObject, intent);
            if (a != null) {
                context.sendBroadcast(a);
            }
            return j;
        } catch (Throwable unused) {
            return -1;
        }
    }

    protected static c a(Context context, String str, long j, int i) {
        Context context2 = context;
        String str2 = str;
        long j2 = j;
        int i2 = i;
        Object obj = 1;
        Object obj2 = (i2 == 2 || i2 == 3 || i2 == 5) ? 1 : null;
        if (obj2 != null) {
            try {
                JSONObject a = a(i);
                if (i2 != 2) {
                    obj = null;
                }
                if (obj != null) {
                    if (TextUtils.isEmpty(str2)) {
                        f.d("TagAliasHelper", "alias was empty. Give up action.");
                        a(context2, 2, b.b, j2);
                        return null;
                    } else if (!a(context2, 2, str2, j2)) {
                        return null;
                    } else {
                        a.put("alias", str2);
                    }
                }
                String jSONObject = a.toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    return new c(1, 29, j2, JCoreInterface.getAppKey(), jSONObject);
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        a(context2, 2, b.j, j2);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0019 A:{Catch:{ Throwable -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0083 A:{Catch:{ Throwable -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0096 A:{Catch:{ Throwable -> 0x00a5 }} */
    protected static cn.jpush.a.c a(android.content.Context r10, java.util.List<java.lang.String> r11, long r12, int r14, int r15) {
        /*
        r0 = 0;
        r1 = 1;
        if (r14 == 0) goto L_0x00a5;
    L_0x0004:
        r2 = a(r14);	 Catch:{ Throwable -> 0x00a5 }
        r3 = 6;
        if (r14 == r1) goto L_0x0016;
    L_0x000b:
        r4 = 2;
        if (r14 == r4) goto L_0x0016;
    L_0x000e:
        r4 = 3;
        if (r14 == r4) goto L_0x0016;
    L_0x0011:
        if (r14 != r3) goto L_0x0014;
    L_0x0013:
        goto L_0x0016;
    L_0x0014:
        r4 = 0;
        goto L_0x0017;
    L_0x0016:
        r4 = r1;
    L_0x0017:
        if (r4 == 0) goto L_0x0080;
    L_0x0019:
        if (r11 == 0) goto L_0x0073;
    L_0x001b:
        r4 = r11.isEmpty();	 Catch:{ Throwable -> 0x00a5 }
        if (r4 == 0) goto L_0x0022;
    L_0x0021:
        goto L_0x0073;
    L_0x0022:
        r4 = new java.util.HashSet;	 Catch:{ Throwable -> 0x00a5 }
        r4.<init>(r11);	 Catch:{ Throwable -> 0x00a5 }
        r5 = a(r10, r1, r4, r12);	 Catch:{ Throwable -> 0x00a5 }
        if (r5 != 0) goto L_0x002e;
    L_0x002d:
        return r0;
    L_0x002e:
        r4 = b(r4);	 Catch:{ Throwable -> 0x00a5 }
        r5 = b(r10, r4, r12, r1);	 Catch:{ Throwable -> 0x00a5 }
        if (r5 != 0) goto L_0x0039;
    L_0x0038:
        return r0;
    L_0x0039:
        if (r14 != r3) goto L_0x0054;
    L_0x003b:
        r11 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x00a5 }
        if (r11 == 0) goto L_0x004e;
    L_0x0041:
        r11 = "TagAliasHelper";
        r14 = "stags was empty. Give up action.";
        cn.jpush.android.d.f.d(r11, r14);	 Catch:{ Throwable -> 0x00a5 }
        r11 = cn.jpush.android.api.b.b;	 Catch:{ Throwable -> 0x00a5 }
        a(r10, r1, r11, r12);	 Catch:{ Throwable -> 0x00a5 }
        return r0;
    L_0x004e:
        r11 = "tags";
        r2.put(r11, r4);	 Catch:{ Throwable -> 0x00a5 }
        goto L_0x0080;
    L_0x0054:
        r3 = new org.json.JSONArray;	 Catch:{ Throwable -> 0x00a5 }
        r3.<init>();	 Catch:{ Throwable -> 0x00a5 }
        r11 = r11.iterator();	 Catch:{ Throwable -> 0x00a5 }
    L_0x005d:
        r4 = r11.hasNext();	 Catch:{ Throwable -> 0x00a5 }
        if (r4 == 0) goto L_0x006d;
    L_0x0063:
        r4 = r11.next();	 Catch:{ Throwable -> 0x00a5 }
        r4 = (java.lang.String) r4;	 Catch:{ Throwable -> 0x00a5 }
        r3.put(r4);	 Catch:{ Throwable -> 0x00a5 }
        goto L_0x005d;
    L_0x006d:
        r11 = "tags";
        r2.put(r11, r3);	 Catch:{ Throwable -> 0x00a5 }
        goto L_0x0080;
    L_0x0073:
        r11 = "TagAliasHelper";
        r14 = "tags was empty. Give up action.";
        cn.jpush.android.d.f.d(r11, r14);	 Catch:{ Throwable -> 0x00a5 }
        r11 = cn.jpush.android.api.b.b;	 Catch:{ Throwable -> 0x00a5 }
        a(r10, r1, r11, r12);	 Catch:{ Throwable -> 0x00a5 }
        return r0;
    L_0x0080:
        r11 = 5;
        if (r14 != r11) goto L_0x008c;
    L_0x0083:
        r11 = "curr";
        r14 = -1;
        if (r15 != r14) goto L_0x0089;
    L_0x0088:
        r15 = r1;
    L_0x0089:
        r2.put(r11, r15);	 Catch:{ Throwable -> 0x00a5 }
    L_0x008c:
        r9 = r2.toString();	 Catch:{ Throwable -> 0x00a5 }
        r11 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x00a5 }
        if (r11 != 0) goto L_0x00aa;
    L_0x0096:
        r11 = new cn.jpush.a.c;	 Catch:{ Throwable -> 0x00a5 }
        r4 = 1;
        r5 = 28;
        r8 = cn.jiguang.api.JCoreInterface.getAppKey();	 Catch:{ Throwable -> 0x00a5 }
        r3 = r11;
        r6 = r12;
        r3.<init>(r4, r5, r6, r8, r9);	 Catch:{ Throwable -> 0x00a5 }
        return r11;
    L_0x00a5:
        r11 = cn.jpush.android.api.b.j;
        a(r10, r1, r11, r12);
    L_0x00aa:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.n.a(android.content.Context, java.util.List, long, int, int):cn.jpush.a.c");
    }

    private static c a(Context context, List<String> list, String str, long j) {
        Set hashSet = list != null ? new HashSet(list) : null;
        if (str != null && !a(context, 0, str, j)) {
            return null;
        }
        if (hashSet != null && !a(context, 0, hashSet, j)) {
            return null;
        }
        String b = b(hashSet);
        if (!b(context, b, j, 0)) {
            return null;
        }
        if (b == null && str == null) {
            f.d("TagAliasHelper", "NULL alias and tags. Give up action.");
            a(context, 0, b.b, j);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("action:setAliasAndTags - alias:");
        stringBuilder.append(str);
        stringBuilder.append(", tags:");
        stringBuilder.append(b);
        f.a("TagAliasHelper", stringBuilder.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "a");
            if (str != null) {
                jSONObject.put("alias", str);
            }
            if (hashSet != null) {
                jSONObject.put("tags", b);
            }
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return new c(4, 10, j, JCoreInterface.getAppKey(), jSONObject2);
            }
        } catch (Throwable unused) {
            a(context, 0, b.j, j);
        }
        return null;
    }

    public static Set<String> a(Set<String> set) {
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        for (String str : set) {
            if (TextUtils.isEmpty(str) || !h.a(str)) {
                StringBuilder stringBuilder = new StringBuilder("Invalid tag : ");
                stringBuilder.append(str);
                f.d("TagAliasHelper", stringBuilder.toString());
            } else {
                linkedHashSet.add(str);
                i++;
                if (i >= 1000) {
                    f.c("TagAliasHelper", "The lenght of tags maybe more than 1000.");
                    return linkedHashSet;
                }
            }
        }
        return linkedHashSet;
    }

    private static JSONObject a(int i) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "a");
        String str = "op";
        switch (i) {
            case 1:
                obj = "add";
                break;
            case 2:
                obj = "set";
                break;
            case 3:
                obj = "del";
                break;
            case 4:
                obj = "clean";
                break;
            case 5:
                obj = "get";
                break;
            case 6:
                obj = "valid";
                break;
            default:
                obj = null;
                break;
        }
        jSONObject.put(str, obj);
        return jSONObject;
    }

    protected static void a(Context context, int i, int i2, long j) {
        try {
            Intent intent = new Intent();
            intent.addCategory(context.getPackageName());
            intent.setPackage(context.getPackageName());
            if (i == 0) {
                intent.setAction("cn.jpush.android.intent.TAG_ALIAS_CALLBACK");
            } else {
                intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
                if (i == 1) {
                    intent.putExtra("message_type", 1);
                } else {
                    intent.putExtra("message_type", 2);
                }
            }
            intent.putExtra("tagalias_errorcode", i2);
            intent.putExtra("tagalias_seqid", j);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("NotifyTagAliasError:");
            stringBuilder.append(th.getMessage());
            f.c("TagAliasHelper", stringBuilder.toString());
        }
    }

    public static void a(Context context, int i, String str, int i2, int i3) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        a(context, str, null, new cn.jpush.android.api.a(i, str, System.currentTimeMillis(), 2, i3));
    }

    public static void a(Context context, int i, Set<String> set, int i2, int i3) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        a(context, null, (Set) set, new cn.jpush.android.api.a(i, (Set) set, System.currentTimeMillis(), 1, i3));
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    public static void a(android.content.Context r20, android.os.Bundle r21) {
        /*
        r6 = r20;
        r0 = r21;
        r1 = "alias";
        r13 = r0.getString(r1);
        r1 = "tags";
        r12 = r0.getStringArrayList(r1);
        r1 = "seq_id";
        r2 = 0;
        r10 = r0.getLong(r1, r2);
        r1 = 0;
        r4 = "proto_type";
        r4 = r0.getString(r4);	 Catch:{ Throwable -> 0x0025 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Throwable -> 0x0025 }
        r8 = r4;
        goto L_0x002b;
    L_0x0025:
        r4 = cn.jpush.android.api.b.j;
        a(r6, r1, r4, r10);
        r8 = r1;
    L_0x002b:
        r4 = "protoaction_type";
        r0 = r0.getString(r4);	 Catch:{ Throwable -> 0x0037 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Throwable -> 0x0037 }
        r9 = r0;
        goto L_0x003d;
    L_0x0037:
        r0 = cn.jpush.android.api.b.j;
        a(r6, r8, r0, r10);
        r9 = r1;
    L_0x003d:
        r4 = java.lang.System.currentTimeMillis();
        r0 = a;
        r0 = r0.size();
        r7 = 10;
        r14 = 2;
        r15 = 1;
        if (r0 >= r7) goto L_0x0057;
    L_0x004d:
        r0 = a;
        r2 = java.lang.Long.valueOf(r4);
        r0.offer(r2);
        goto L_0x0085;
    L_0x0057:
        r0 = a;
        r0 = r0.element();
        r0 = (java.lang.Long) r0;
        r16 = r0.longValue();
        r18 = r4 - r16;
        r0 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1));
        if (r0 >= 0) goto L_0x0070;
    L_0x0069:
        r0 = a;
        r0.clear();
        r1 = r14;
        goto L_0x0085;
    L_0x0070:
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0084;
    L_0x0076:
        r0 = a;
        r0 = r0.size();
        if (r0 < r7) goto L_0x004d;
    L_0x007e:
        r0 = a;
        r0.poll();
        goto L_0x0076;
    L_0x0084:
        r1 = r15;
    L_0x0085:
        if (r1 == 0) goto L_0x0092;
    L_0x0087:
        if (r1 != r15) goto L_0x008c;
    L_0x0089:
        r0 = cn.jpush.android.api.b.l;
        goto L_0x008e;
    L_0x008c:
        r0 = cn.jpush.android.api.b.n;
    L_0x008e:
        a(r6, r8, r0, r10);
        return;
    L_0x0092:
        cn.jpush.android.a.o.a();
        r0 = cn.jpush.android.a.o.a(r6, r8, r10);
        if (r0 == 0) goto L_0x00a1;
    L_0x009b:
        r0 = cn.jpush.android.api.b.u;
        a(r6, r8, r0, r10);
        return;
    L_0x00a1:
        r0 = 0;
        if (r8 != 0) goto L_0x00a9;
    L_0x00a4:
        r0 = a(r6, r12, r13, r10);
        goto L_0x00bb;
    L_0x00a9:
        if (r8 != r15) goto L_0x00b5;
    L_0x00ab:
        r5 = -1;
        r0 = r6;
        r1 = r12;
        r2 = r10;
        r4 = r9;
        r0 = a(r0, r1, r2, r4, r5);
        goto L_0x00bb;
    L_0x00b5:
        if (r8 != r14) goto L_0x00bb;
    L_0x00b7:
        r0 = a(r6, r13, r10, r9);
    L_0x00bb:
        if (r0 == 0) goto L_0x00de;
    L_0x00bd:
        if (r8 == r15) goto L_0x00c1;
    L_0x00bf:
        if (r8 != r14) goto L_0x00de;
    L_0x00c1:
        r1 = cn.jpush.android.a.o.a();
        r1 = r1.a(r8);
        if (r1 == 0) goto L_0x00d3;
    L_0x00cb:
        r7 = cn.jpush.android.a.o.a();
        r7.a(r8, r9, r10, r12, r13);
        goto L_0x00de;
    L_0x00d3:
        if (r8 != r15) goto L_0x00d8;
    L_0x00d5:
        r0 = cn.jpush.android.api.b.v;
        goto L_0x00da;
    L_0x00d8:
        r0 = cn.jpush.android.api.b.w;
    L_0x00da:
        a(r6, r8, r0, r10);
        return;
    L_0x00de:
        a(r6, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.n.a(android.content.Context, android.os.Bundle):void");
    }

    protected static void a(Context context, c cVar) {
        StringBuilder stringBuilder = new StringBuilder("tagalias:");
        stringBuilder.append(cVar);
        f.a("TagAliasHelper", stringBuilder.toString());
        if (cVar != null) {
            f.a(context).a((JRequest) cVar, 20000);
        }
    }

    public static void a(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback, int i, int i2) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
        a(context, str, (Set) set, new cn.jpush.android.api.a(str, set, tagAliasCallback, System.currentTimeMillis(), 0, 0));
    }

    private static void a(Context context, String str, Set<String> set, cn.jpush.android.api.a aVar) {
        long nextRid = JCoreInterface.getNextRid();
        if (aVar != null) {
            cn.jpush.android.service.f.a().a(context, Long.valueOf(nextRid), aVar);
        }
        if (ServiceInterface.d(context)) {
            cn.jpush.android.service.f.a().a(context, b.m, nextRid, aVar);
            return;
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (a.a(context)) {
            if (aVar.e == 0) {
                cn.jpush.android.service.f.a().a(context);
            }
            ServiceInterface.a(context, str, (Set) set, nextRid, aVar);
            return;
        }
        cn.jpush.android.service.f.a().a(context, b.j, nextRid, aVar);
    }

    private static boolean a(Context context, int i, String str, long j) {
        int b = h.b(str);
        if (b == 0) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid alias: ");
        stringBuilder.append(str);
        stringBuilder.append(", will not set alias this time.");
        f.a("TagAliasHelper", stringBuilder.toString());
        a(context, i, b, j);
        return false;
    }

    private static boolean a(Context context, int i, Set<String> set, long j) {
        int a = h.a((Set) set);
        if (a == 0) {
            return true;
        }
        f.a("TagAliasHelper", "Invalid tags, will not set tags this time.");
        a(context, i, a, j);
        return false;
    }

    public static String b(Set<String> set) {
        String str = null;
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return "";
        }
        int i = 0;
        for (String str2 : set) {
            String str22;
            if (TextUtils.isEmpty(str22) || !h.a(str22)) {
                StringBuilder stringBuilder = new StringBuilder("Invalid tag: ");
                stringBuilder.append(str22);
                f.d("TagAliasHelper", stringBuilder.toString());
            } else {
                if (str != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append(",");
                    stringBuilder2.append(str22);
                    str22 = stringBuilder2.toString();
                }
                i++;
                if (i >= 1000) {
                    return str22;
                }
                str = str22;
            }
        }
        return str;
    }

    private static boolean b(Context context, String str, long j, int i) {
        if (str != null) {
            str = str.replaceAll(",", "");
            boolean z = i != 0;
            int length = !TextUtils.isEmpty(str) ? str.getBytes().length + 0 : 0;
            int i2 = 7000;
            boolean z2 = z ? length > 5000 : length > 7000;
            if (!z2) {
                a(context, i, b.i, j);
                String str2 = "TagAliasHelper";
                StringBuilder stringBuilder = new StringBuilder("The length of tags should be less than ");
                if (i != 0) {
                    i2 = 5000;
                }
                stringBuilder.append(i2);
                stringBuilder.append(" bytes.");
                f.c(str2, stringBuilder.toString());
                return false;
            }
        }
        return true;
    }
}
