package cn.jpush.android.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.SdkType;
import cn.jpush.android.a;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.c;
import cn.jpush.android.b;
import cn.jpush.android.d.f;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.service.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {
    private static Map<String, Byte> b = new HashMap();
    private static d d;
    private static final Object e = new Object();
    private List<JThirdPlatFormInterface> a = new ArrayList();
    private boolean c;

    static {
        b.put("cn.jpush.android.thirdpush.meizu.MeizuPushManager", Byte.valueOf((byte) 3));
        b.put("cn.jpush.android.thirdpush.xiaomi.XMPushManager", Byte.valueOf((byte) 1));
        b.put("cn.jpush.android.thirdpush.huawei.HWPushManager", Byte.valueOf((byte) 2));
        b.put("cn.jpush.android.thirdpush.fcm.FCMPushManager", Byte.valueOf((byte) 8));
        b.put("cn.jpush.android.thridpush.oppo.OPushManager", Byte.valueOf((byte) 4));
    }

    private d() {
    }

    public static d a() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    private e a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        e eVar = new e(this);
        eVar.c = bundle.getString("data");
        eVar.a = bundle.getString(JThirdPlatFormInterface.KEY_MSG_ID);
        eVar.b = bundle.getInt(JThirdPlatFormInterface.KEY_NOTI_ID, 0);
        eVar.d = bundle.getByte("platform", (byte) -1).byteValue();
        return eVar;
    }

    private void a(Context context, byte b, String str) {
        if (context == null) {
            context = a.e;
        }
        if (context != null) {
            g(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                if (jThirdPlatFormInterface.getRomType(context) == b) {
                    a(context, jThirdPlatFormInterface);
                    if (a(context, (int) b, str)) {
                        b(context, b, str);
                    }
                }
            }
        }
    }

    private static void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface) {
        if (jThirdPlatFormInterface != null && jThirdPlatFormInterface.isNeedClearToken(context)) {
            b.b(context, jThirdPlatFormInterface.getRomType(context), false);
            b.a(context, jThirdPlatFormInterface.getRomType(context), null);
        }
    }

    private static boolean a(Context context, int i, String str) {
        return (b.b(context, i) && TextUtils.equals(b.a(context, i), str)) ? false : true;
    }

    private static void b(Context context, byte b, String str) {
        b.b(context, (int) b, false);
        b.a(context, (int) b, str);
        Bundle bundle = new Bundle();
        e.a(context, bundle, JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REQUEST_REGID);
        bundle.putString("plugin.platform.regid ", str);
        bundle.putByte("plugin.platform.type", b);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    /* JADX WARNING: Missing block: B:50:0x0015, code skipped:
            continue;
     */
    private synchronized void g(android.content.Context r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.c;	 Catch:{ all -> 0x008a }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r5);
        return;
    L_0x0007:
        if (r6 != 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r5);
        return;
    L_0x000b:
        r0 = b;	 Catch:{ all -> 0x008a }
        r0 = r0.entrySet();	 Catch:{ all -> 0x008a }
        r0 = r0.iterator();	 Catch:{ all -> 0x008a }
    L_0x0015:
        r1 = r0.hasNext();	 Catch:{ all -> 0x008a }
        if (r1 == 0) goto L_0x0085;
    L_0x001b:
        r1 = r0.next();	 Catch:{ all -> 0x008a }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ all -> 0x008a }
        r2 = r6.getClassLoader();	 Catch:{ Throwable -> 0x0052 }
        r3 = r1.getKey();	 Catch:{ Throwable -> 0x0052 }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x0052 }
        r2 = r2.loadClass(r3);	 Catch:{ Throwable -> 0x0052 }
        if (r2 == 0) goto L_0x0015;
    L_0x0031:
        r2 = r2.newInstance();	 Catch:{ Throwable -> 0x0052 }
        if (r2 == 0) goto L_0x0015;
    L_0x0037:
        r3 = r2 instanceof cn.jpush.android.api.JThirdPlatFormInterface;	 Catch:{ Throwable -> 0x0052 }
        if (r3 == 0) goto L_0x0015;
    L_0x003b:
        r3 = r2;
        r3 = (cn.jpush.android.api.JThirdPlatFormInterface) r3;	 Catch:{ Throwable -> 0x0052 }
        r3.init(r6);	 Catch:{ Throwable -> 0x0052 }
        r3 = r2;
        r3 = (cn.jpush.android.api.JThirdPlatFormInterface) r3;	 Catch:{ Throwable -> 0x0052 }
        r3 = r3.isSupport(r6);	 Catch:{ Throwable -> 0x0052 }
        if (r3 == 0) goto L_0x0015;
    L_0x004a:
        r3 = r5.a;	 Catch:{ Throwable -> 0x0052 }
        r2 = (cn.jpush.android.api.JThirdPlatFormInterface) r2;	 Catch:{ Throwable -> 0x0052 }
        r3.add(r2);	 Catch:{ Throwable -> 0x0052 }
        goto L_0x0015;
    L_0x0052:
        r2 = move-exception;
        r1 = r1.getValue();	 Catch:{ all -> 0x008a }
        r1 = (java.lang.Byte) r1;	 Catch:{ all -> 0x008a }
        r3 = r1.byteValue();	 Catch:{ all -> 0x008a }
        r4 = 0;
        cn.jpush.android.b.b(r6, r3, r4);	 Catch:{ all -> 0x008a }
        r1 = r1.byteValue();	 Catch:{ all -> 0x008a }
        r3 = 0;
        cn.jpush.android.b.a(r6, r1, r3);	 Catch:{ all -> 0x008a }
        r1 = r2 instanceof java.lang.RuntimeException;	 Catch:{ all -> 0x008a }
        if (r1 == 0) goto L_0x0015;
    L_0x006d:
        r1 = r2.getMessage();	 Catch:{ all -> 0x008a }
        r3 = "Please check";
        r1 = r1.contains(r3);	 Catch:{ all -> 0x008a }
        if (r1 == 0) goto L_0x0015;
    L_0x0079:
        r1 = cn.jiguang.api.JCoreInterface.getDebugMode();	 Catch:{ all -> 0x008a }
        if (r1 == 0) goto L_0x0015;
    L_0x007f:
        r6 = new java.lang.RuntimeException;	 Catch:{ all -> 0x008a }
        r6.<init>(r2);	 Catch:{ all -> 0x008a }
        throw r6;	 Catch:{ all -> 0x008a }
    L_0x0085:
        r6 = 1;
        r5.c = r6;	 Catch:{ all -> 0x008a }
        monitor-exit(r5);
        return;
    L_0x008a:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.c.d.g(android.content.Context):void");
    }

    public final void a(Context context) {
        g(context);
        if (!JPushInterface.isPushStopped(context.getApplicationContext())) {
            for (JThirdPlatFormInterface register : this.a) {
                register.register(context);
            }
        }
    }

    public final void a(Context context, Bundle bundle) {
        if (bundle != null) {
            try {
                e a = a(bundle);
                cn.jpush.android.data.b a2 = c.a(context, a.c, a.a);
                a2.i = true;
                a2.f = true;
                a2.e = a.d;
                c.a(context, a2);
                a(context, JThirdPlatFormInterface.ACTION_NOTIFICATION_ARRIVED, bundle);
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(Context context, String str, Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder("doAction,action:");
        stringBuilder.append(str);
        stringBuilder.append(",bundle:");
        stringBuilder.append(bundle);
        f.a("ThirdPushManager", stringBuilder.toString());
        if (!TextUtils.isEmpty(str)) {
            e a;
            if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_ARRIVED)) {
                a = a(bundle);
                if (a != null) {
                    c.a(context, a.c, a.a, a.b, a.d, false);
                }
            } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED)) {
                a = a(bundle);
                if (a != null) {
                    c.a(context, a.c, a.a, a.b, a.d, true);
                }
            } else if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW)) {
                e.a(context, bundle, JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW);
                JCoreInterface.sendAction(context, a.a, bundle);
            } else if (str.equals(JThirdPlatFormInterface.ACTION_REGISTER_TOKEN) && bundle != null) {
                a(context, bundle.getByte("platform", (byte) -1).byteValue(), bundle.getString("token"));
            }
        }
    }

    public final void b(Context context) {
        g(context);
        for (JThirdPlatFormInterface resumePush : this.a) {
            resumePush.resumePush(context);
        }
    }

    public final void b(Context context, Bundle bundle) {
        g(context);
        byte byteValue = bundle.getByte("platform", (byte) -1).byteValue();
        if (byteValue > (byte) 0) {
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                if (jThirdPlatFormInterface.getRomType(context) == byteValue) {
                    a(context, byteValue, jThirdPlatFormInterface.getToken(context));
                }
            }
        }
    }

    public final void c(Context context) {
        g(context);
        for (JThirdPlatFormInterface stopPush : this.a) {
            stopPush.stopPush(context);
        }
    }

    public final byte d(Context context) {
        g(context);
        int i = 0;
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            byte romType = jThirdPlatFormInterface.getRomType(context);
            i = (byte) (i | romType);
            String a = b.a(context, romType);
            boolean b = b.b(context, romType);
            if (jThirdPlatFormInterface.getRomType(context) == (byte) 8) {
                i = (byte) (i | 8);
                if (b && !TextUtils.isEmpty(a)) {
                    i |= 32;
                }
            } else {
                if (jThirdPlatFormInterface.getRomType(context) == (byte) 2) {
                    i = (byte) (i | 64);
                }
                if (!b || TextUtils.isEmpty(a)) {
                    i |= 128;
                }
            }
            i = (byte) i;
        }
        return i;
    }

    public final String e(Context context) {
        for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
            if (jThirdPlatFormInterface.getRomType(context) != (byte) 8) {
                return b.a(context, jThirdPlatFormInterface.getRomType(context));
            }
        }
        return null;
    }

    public final void f(Context context) {
        if (context == null) {
            context = a.e;
        }
        if (context != null) {
            g(context);
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.a) {
                String token;
                if (jThirdPlatFormInterface.needSendToMainProcess()) {
                    token = jThirdPlatFormInterface.getToken(context);
                    if (TextUtils.isEmpty(token)) {
                        try {
                            Intent intent = new Intent(context, PushReceiver.class);
                            intent.setAction(JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
                            Bundle bundle = new Bundle();
                            bundle.putString("sdktype", SdkType.JPUSH.name());
                            bundle.putByte("platform", jThirdPlatFormInterface.getRomType(context));
                            intent.putExtras(bundle);
                            intent.setPackage(context.getPackageName());
                            context.sendBroadcast(intent);
                        } catch (Throwable th) {
                            StringBuilder stringBuilder = new StringBuilder("send ACTION_PLUGIN_PALTFORM_REFRESSH_REGID failed:");
                            stringBuilder.append(th);
                            f.c("ThirdPushManager", stringBuilder.toString());
                        }
                    } else {
                        a(context, jThirdPlatFormInterface.getRomType(context), token);
                    }
                } else {
                    a(context, jThirdPlatFormInterface);
                    if (jThirdPlatFormInterface.getRomType(context) == (byte) 2) {
                        jThirdPlatFormInterface.getToken(context);
                    } else {
                        token = jThirdPlatFormInterface.getToken(context);
                        if (a(context, jThirdPlatFormInterface.getRomType(context), token)) {
                            b(context, jThirdPlatFormInterface.getRomType(context), token);
                        }
                    }
                }
            }
        }
    }
}
