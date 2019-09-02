package cn.jpush.android.c;

import android.content.Context;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.b;
import cn.jpush.android.d.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class a {
    private static volatile a b;
    private Map<Byte, b> a = new HashMap();

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private b a(long j) {
        for (Entry entry : this.a.entrySet()) {
            if (((b) entry.getValue()).c == j) {
                return (b) entry.getValue();
            }
        }
        return null;
    }

    private synchronized void a(Context context, b bVar) {
        JCoreInterface.sendRequestData(context, cn.jpush.android.a.a, 10000, bVar.d);
    }

    public final void a(Context context, long j) {
        b a = a(j);
        StringBuilder stringBuilder = new StringBuilder("onUpdateRidSuccess rid:");
        stringBuilder.append(j);
        stringBuilder.append(" ,pluginPlatformRegIDBean:");
        stringBuilder.append(String.valueOf(a));
        f.b("PluginPlatformRidUpdate", stringBuilder.toString());
        if (a != null) {
            b.a(context, a.a, a.b);
            b.b(context, a.a, true);
            this.a.remove(Byte.valueOf(a.a));
        }
    }

    public final void a(Context context, long j, int i) {
        b a = a(j);
        StringBuilder stringBuilder = new StringBuilder("onUpdateRidFailed rid:");
        stringBuilder.append(j);
        stringBuilder.append(",errorCode:");
        stringBuilder.append(i);
        stringBuilder.append(" ,pluginPlatformRegIDBean:");
        stringBuilder.append(String.valueOf(a));
        f.b("PluginPlatformRidUpdate", stringBuilder.toString());
        if (a != null) {
            if (a.e < 3) {
                a.e++;
                a(context, a);
                return;
            }
            this.a.remove(Byte.valueOf(a.a));
        }
    }

    /* JADX WARNING: Missing block: B:22:0x009a, code skipped:
            return;
     */
    public final synchronized void a(android.content.Context r11, android.os.Bundle r12) {
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = "plugin.platform.type";
        r1 = 0;
        r0 = r12.getByte(r0, r1);	 Catch:{ all -> 0x009b }
        r0 = r0.byteValue();	 Catch:{ all -> 0x009b }
        if (r0 == 0) goto L_0x0099;
    L_0x000e:
        r2 = cn.jiguang.api.JCoreInterface.isTcpConnected();	 Catch:{ all -> 0x009b }
        if (r2 != 0) goto L_0x0016;
    L_0x0014:
        monitor-exit(r10);
        return;
    L_0x0016:
        r2 = "plugin.platform.regid ";
        r5 = r12.getString(r2);	 Catch:{ all -> 0x009b }
        r12 = r10.a;	 Catch:{ all -> 0x009b }
        r2 = java.lang.Byte.valueOf(r0);	 Catch:{ all -> 0x009b }
        r12 = r12.containsKey(r2);	 Catch:{ all -> 0x009b }
        if (r12 == 0) goto L_0x003e;
    L_0x0028:
        r12 = r10.a;	 Catch:{ all -> 0x009b }
        r2 = java.lang.Byte.valueOf(r0);	 Catch:{ all -> 0x009b }
        r12 = r12.get(r2);	 Catch:{ all -> 0x009b }
        r12 = (cn.jpush.android.c.b) r12;	 Catch:{ all -> 0x009b }
        r12 = r12.b;	 Catch:{ all -> 0x009b }
        r12 = android.text.TextUtils.equals(r12, r5);	 Catch:{ all -> 0x009b }
        if (r12 == 0) goto L_0x003e;
    L_0x003c:
        monitor-exit(r10);
        return;
    L_0x003e:
        r6 = cn.jiguang.api.JCoreInterface.getNextRid();	 Catch:{ all -> 0x009b }
        r2 = cn.jiguang.api.JCoreInterface.getUid();	 Catch:{ all -> 0x009b }
        r12 = cn.jiguang.api.JCoreInterface.getSid();	 Catch:{ all -> 0x009b }
        r4 = new cn.jiguang.api.utils.OutputDataUtil;	 Catch:{ all -> 0x009b }
        r8 = 20480; // 0x5000 float:2.8699E-41 double:1.01185E-319;
        r4.<init>(r8);	 Catch:{ all -> 0x009b }
        r4.writeU16(r1);	 Catch:{ all -> 0x009b }
        r8 = 1;
        r4.writeU8(r8);	 Catch:{ all -> 0x009b }
        r8 = 27;
        r4.writeU8(r8);	 Catch:{ all -> 0x009b }
        r4.writeU64(r6);	 Catch:{ all -> 0x009b }
        r8 = (long) r12;	 Catch:{ all -> 0x009b }
        r4.writeU32(r8);	 Catch:{ all -> 0x009b }
        r4.writeU64(r2);	 Catch:{ all -> 0x009b }
        r12 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x009b }
        if (r12 == 0) goto L_0x0070;
    L_0x006d:
        r12 = new byte[r1];	 Catch:{ all -> 0x009b }
        goto L_0x0074;
    L_0x0070:
        r12 = r5.getBytes();	 Catch:{ all -> 0x009b }
    L_0x0074:
        r4.writeByteArrayincludeLength(r12);	 Catch:{ all -> 0x009b }
        r4.writeU8(r0);	 Catch:{ all -> 0x009b }
        r12 = r4.current();	 Catch:{ all -> 0x009b }
        r4.writeU16At(r12, r1);	 Catch:{ all -> 0x009b }
        r8 = r4.toByteArray();	 Catch:{ all -> 0x009b }
        r12 = new cn.jpush.android.c.b;	 Catch:{ all -> 0x009b }
        r2 = r12;
        r3 = r10;
        r4 = r0;
        r2.<init>(r3, r4, r5, r6, r8);	 Catch:{ all -> 0x009b }
        r1 = r10.a;	 Catch:{ all -> 0x009b }
        r0 = java.lang.Byte.valueOf(r0);	 Catch:{ all -> 0x009b }
        r1.put(r0, r12);	 Catch:{ all -> 0x009b }
        r10.a(r11, r12);	 Catch:{ all -> 0x009b }
    L_0x0099:
        monitor-exit(r10);
        return;
    L_0x009b:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.a.a(android.content.Context, android.os.Bundle):void");
    }

    public final void b(Context context, long j) {
        b a = a(j);
        StringBuilder stringBuilder = new StringBuilder("onUpdateRidTimeout rid:");
        stringBuilder.append(j);
        stringBuilder.append(" ,pluginPlatformRegIDBean:");
        stringBuilder.append(String.valueOf(a));
        f.b("PluginPlatformRidUpdate", stringBuilder.toString());
        if (a != null) {
            if (a.e < 3) {
                a.e++;
                a(context, a);
                return;
            }
            this.a.remove(Byte.valueOf(a.a));
        }
    }
}
