package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.SdkType;
import cn.jiguang.d.a;
import cn.jiguang.d.b.d;
import cn.jiguang.d.b.g;
import cn.jiguang.e.c;
import cn.jiguang.g.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static HashMap<String, JAction> a = new HashMap();
    public static HashMap<String, JActionExtra> b = new HashMap();
    private static volatile b c;
    private static final Object d = new Object();

    static {
        a(a.a, g.class.getName());
    }

    private b() {
    }

    public static b a() {
        if (c == null) {
            synchronized (d) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    private static Object a(JActionExtra jActionExtra, Context context, int i, String str, int i2) {
        if (jActionExtra == null) {
            return null;
        }
        if (i2 == 0) {
            try {
                return jActionExtra.beforRegister(context, i, str);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("#unexcepted- invoke method error:");
                stringBuilder.append(th);
                c.c("ActionManager", stringBuilder.toString());
            }
        } else {
            if (i2 == 1) {
                return jActionExtra.beforLogin(context, i, str);
            }
            return null;
        }
    }

    public static void a(Context context, long j, int i) {
        for (Entry value : a.entrySet()) {
            JAction jAction = (JAction) value.getValue();
            if (jAction != null) {
                jAction.onEvent(context, j, i);
            }
        }
    }

    private static void a(Context context, long j, int i, int i2) {
        for (Entry value : b.entrySet()) {
            JActionExtra jActionExtra = (JActionExtra) value.getValue();
            if (jActionExtra != null) {
                jActionExtra.onSendData(context, g.a.get(), j, i, i2);
            }
        }
    }

    public static void a(Context context, cn.jiguang.d.e.a.a.c cVar, ByteBuffer byteBuffer) {
        if (cVar != null) {
            for (Entry entry : a.entrySet()) {
                JAction jAction = (JAction) entry.getValue();
                if (jAction != null && jAction.isSupportedCMD(cVar.a())) {
                    cVar.a(Long.valueOf(jAction.dispatchMessage(context, g.a.get(), cVar.a(), cVar, byteBuffer)));
                    d.a().a((String) entry.getKey(), (Object) cVar);
                    byteBuffer.clear();
                }
            }
        }
    }

    public static void a(Context context, String str, long j, Bundle bundle, Handler handler) {
        JAction jAction = (JAction) a.get(str);
        if (jAction != null) {
            jAction.onActionRun(context, j, bundle, handler);
        }
    }

    public static void a(Context context, String str, Object obj) {
        if (i.a(str)) {
            for (Entry value : a.entrySet()) {
                JAction jAction = (JAction) value.getValue();
                d.a();
                jAction.handleMessage(context, d.g(), obj);
            }
            return;
        }
        JAction jAction2 = (JAction) a.get(str);
        if (jAction2 != null) {
            d.a();
            jAction2.handleMessage(context, d.g(), obj);
        }
    }

    public static void a(String str, String str2) {
        if (!(TextUtils.isEmpty(str2) || a.containsKey(str))) {
            try {
                Object newInstance = Class.forName(str2).newInstance();
                if (newInstance instanceof JAction) {
                    a.put(str, (JAction) newInstance);
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("#unexcepted - instance ");
                stringBuilder.append(str2);
                stringBuilder.append(" class failed:");
                stringBuilder.append(th);
                c.c("ActionManager", stringBuilder.toString());
            }
        }
    }

    public static boolean a(int i) {
        for (Entry entry : b.entrySet()) {
            JActionExtra jActionExtra = (JActionExtra) entry.getValue();
            if (jActionExtra != null) {
                try {
                    StringBuilder stringBuilder = new StringBuilder("isAllowAction actionType:");
                    stringBuilder.append(0);
                    stringBuilder.append(",sdktype:");
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append(",action:");
                    stringBuilder.append(jActionExtra.checkAction(0));
                    c.a("ActionManager", stringBuilder.toString());
                    if (!jActionExtra.checkAction(0)) {
                        return false;
                    }
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
        return true;
    }

    public static void b(Context context, long j, int i) {
        for (Entry value : a.entrySet()) {
            JAction jAction = (JAction) value.getValue();
            if (jAction != null) {
                jAction.dispatchTimeOutMessage(context, g.a.get(), j, i);
            }
        }
    }

    public static void b(String str, String str2) {
        if (!b.containsKey(str)) {
            try {
                Object newInstance = Class.forName(str2).newInstance();
                if (newInstance instanceof JActionExtra) {
                    b.put(str, (JActionExtra) newInstance);
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("#unexcepted - instance ");
                stringBuilder.append(str2);
                stringBuilder.append(" class failed:");
                stringBuilder.append(th);
                c.c("ActionManager", stringBuilder.toString());
            }
        }
    }

    public static IBinder c(String str, String str2) {
        JAction jAction = (JAction) a.get(str);
        return jAction != null ? jAction.getBinderByType(str2) : null;
    }

    public static String d(String str, String str2) {
        if (a.containsKey(str)) {
            JAction jAction = (JAction) a.get(str);
            if (!(jAction == null || TextUtils.isEmpty(jAction.getSdkVersion()))) {
                return jAction.getSdkVersion();
            }
        }
        return str2;
    }

    public final ArrayList<Object> a(Context context, String str, int i, String str2, int i2) {
        ArrayList arrayList = new ArrayList();
        if (i.a(str)) {
            for (Entry value : b.entrySet()) {
                Object a = a((JActionExtra) value.getValue(), context, 22, str2, 1);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        } else {
            Object a2 = a((JActionExtra) b.get(str), context, 22, str2, 1);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public final void a(Context context, String str, long j, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            a(context, j, i, 6026);
            return;
        }
        JActionExtra jActionExtra = (JActionExtra) b.get(str);
        if (jActionExtra == null) {
            a(context, j, i, 6026);
            return;
        }
        jActionExtra.onSendData(context, g.a.get(), j, i, 6026);
    }

    public final boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            jSONObject.put("sdk_ver", d(SdkType.JPUSH.name(), ""));
            jSONObject.put("core_sdk_ver", d(SdkType.JCORE.name(), ""));
            jSONObject.put("share_sdk_ver", d(SdkType.JSHARE.name(), ""));
            jSONObject.put("ssp_sdk_ver", d(SdkType.JSSP.name(), ""));
            jSONObject.put("statistics_sdk_ver", d(SdkType.JANALYTICS.name(), ""));
            jSONObject.put("verification_sdk_ver", d(SdkType.JVERIFICATION.name(), ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return true;
    }
}
