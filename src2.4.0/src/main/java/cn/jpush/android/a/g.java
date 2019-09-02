package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.MultiSpHelper;
import cn.jpush.android.a;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.b;
import cn.jpush.android.d.f;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g {
    private static ConcurrentLinkedQueue<Long> a = new ConcurrentLinkedQueue();
    private static final Object c = new Object();
    private static g d;
    private ConcurrentHashMap<Long, h> b = new ConcurrentHashMap();

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (d == null) {
                synchronized (c) {
                    if (d == null) {
                        d = new g();
                    }
                }
            }
            gVar = d;
        }
        return gVar;
    }

    public static JPushMessage a(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            int intExtra = intent.getIntExtra("sequence", -1);
            int intExtra2 = intent.getIntExtra(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE, -1);
            String stringExtra = intent.getStringExtra("mobile_number");
            JPushMessage jPushMessage = new JPushMessage();
            try {
                jPushMessage.setSequence(intExtra);
                jPushMessage.setErrorCode(intExtra2);
                jPushMessage.setMobileNumber(stringExtra);
            } catch (Throwable unused) {
            }
            return jPushMessage;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void a(Context context, int i, int i2, String str) {
        try {
            Intent intent = new Intent();
            intent.addCategory(a.c);
            intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
            intent.setPackage(context.getPackageName());
            intent.putExtra("message_type", 3);
            intent.putExtra("sequence", i);
            intent.putExtra(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE, i2);
            intent.putExtra("mobile_number", str);
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("onResult error:");
            stringBuilder.append(th);
            f.c("MobileNumberHelper", stringBuilder.toString());
        }
    }

    public final void a(Context context, long j, int i) {
        if (this.b.size() != 0) {
            h hVar = (h) this.b.remove(Long.valueOf(j));
            if (hVar != null) {
                if (i == 0) {
                    MultiSpHelper.commitString(context, "mobile_number", hVar.b);
                } else if (i == 11) {
                    i = b.y;
                } else if (i == 10) {
                    i = b.x;
                }
                a(context, hVar.a, i, hVar.b);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    public final void a(android.content.Context r12, android.os.Bundle r13) {
        /*
        r11 = this;
        r0 = "sequence";
        r1 = 0;
        r0 = r13.getInt(r0, r1);
        r2 = "mobile_number";
        r13 = r13.getString(r2);
        r2 = "mobile_number";
        r3 = 0;
        r2 = cn.jiguang.api.MultiSpHelper.getString(r12, r2, r3);
        if (r2 == 0) goto L_0x0029;
    L_0x0016:
        r4 = android.text.TextUtils.equals(r13, r2);
        if (r4 == 0) goto L_0x0029;
    L_0x001c:
        r1 = "MobileNumberHelper";
        r2 = "already set this mobile number";
        cn.jpush.android.d.f.a(r1, r2);
        r1 = cn.jpush.android.api.b.a;
        a(r12, r0, r1, r13);
        return;
    L_0x0029:
        if (r2 == 0) goto L_0x0030;
    L_0x002b:
        r2 = "mobile_number";
        cn.jiguang.api.MultiSpHelper.commitString(r12, r2, r3);
    L_0x0030:
        r2 = java.lang.System.currentTimeMillis();
        r4 = a;
        r4 = r4.size();
        r5 = 3;
        r6 = 1;
        if (r4 >= r5) goto L_0x0049;
    L_0x003e:
        r4 = a;
        r2 = java.lang.Long.valueOf(r2);
        r4.offer(r2);
        r2 = r1;
        goto L_0x0079;
    L_0x0049:
        r4 = a;
        r4 = r4.element();
        r4 = (java.lang.Long) r4;
        r7 = r4.longValue();
        r9 = r2 - r7;
        r7 = 0;
        r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r4 >= 0) goto L_0x0064;
    L_0x005d:
        r2 = a;
        r2.clear();
        r2 = 2;
        goto L_0x0079;
    L_0x0064:
        r7 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));
        if (r4 <= 0) goto L_0x0078;
    L_0x006a:
        r4 = a;
        r4 = r4.size();
        if (r4 < r5) goto L_0x003e;
    L_0x0072:
        r4 = a;
        r4.poll();
        goto L_0x006a;
    L_0x0078:
        r2 = r6;
    L_0x0079:
        if (r2 == 0) goto L_0x0086;
    L_0x007b:
        if (r2 != r6) goto L_0x0080;
    L_0x007d:
        r1 = cn.jpush.android.api.b.l;
        goto L_0x0082;
    L_0x0080:
        r1 = cn.jpush.android.api.b.n;
    L_0x0082:
        a(r12, r0, r1, r13);
        return;
    L_0x0086:
        r2 = cn.jpush.android.d.h.c(r13);
        if (r2 == 0) goto L_0x00a8;
    L_0x008c:
        r1 = "MobileNumberHelper";
        r3 = new java.lang.StringBuilder;
        r4 = "Invalid mobile number: ";
        r3.<init>(r4);
        r3.append(r13);
        r4 = ", will not set mobile number this time.";
        r3.append(r4);
        r3 = r3.toString();
        cn.jpush.android.d.f.a(r1, r3);
        a(r12, r0, r2, r13);
        return;
    L_0x00a8:
        r2 = cn.jiguang.api.JCoreInterface.getNextRid();
        r4 = cn.jiguang.api.JCoreInterface.getUid();
        r7 = cn.jiguang.api.JCoreInterface.getSid();
        r8 = new cn.jiguang.api.utils.OutputDataUtil;
        r9 = 20480; // 0x5000 float:2.8699E-41 double:1.01185E-319;
        r8.<init>(r9);
        r8.writeU16(r1);
        r8.writeU8(r6);
        r9 = 26;
        r8.writeU8(r9);
        r8.writeU64(r2);
        r9 = (long) r7;
        r8.writeU32(r9);
        r8.writeU64(r4);
        r4 = 7;
        r8.writeU8(r4);
        r8.writeU8(r6);
        if (r13 == 0) goto L_0x00de;
    L_0x00d9:
        r4 = r13.getBytes();
        goto L_0x00e0;
    L_0x00de:
        r4 = new byte[r1];
    L_0x00e0:
        r8.writeByteArrayincludeLength(r4);
        r4 = r8.current();
        r8.writeU16At(r4, r1);
        r1 = r8.toByteArray();
        r4 = r11.b;
        r2 = java.lang.Long.valueOf(r2);
        r3 = new cn.jpush.android.a.h;
        r3.<init>(r11, r0, r13);
        r4.put(r2, r3);
        r13 = cn.jpush.android.a.a;
        r0 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        cn.jiguang.api.JCoreInterface.sendRequestData(r12, r13, r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.a.g.a(android.content.Context, android.os.Bundle):void");
    }
}
