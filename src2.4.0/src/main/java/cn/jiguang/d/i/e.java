package cn.jiguang.d.i;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.SdkType;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.a;
import cn.jiguang.d.d.x;
import cn.jiguang.g.i;
import com.umeng.commonsdk.framework.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends a {
    private boolean e = false;
    private String f = null;
    private Class<?> g = null;
    private String h = null;

    private a a(Context context, PackageManager packageManager, String str, String str2) {
        if (packageManager == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".permission.JPUSH_MESSAGE");
            int checkPermission = packageManager.checkPermission(stringBuilder.toString(), str);
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                String string = applicationInfo.metaData.getString("JPUSH_APPKEY");
                Intent intent = new Intent();
                intent.setClassName(str, this.h);
                int i = 0;
                List queryIntentServices = packageManager.queryIntentServices(intent, 0);
                if (!(queryIntentServices == null || queryIntentServices.size() == 0)) {
                    i = 1;
                }
                if (checkPermission == 0 && i != 0 && !TextUtils.isEmpty(string) && string.length() == 24) {
                    a aVar = new a(str, str2, applicationInfo.targetSdkVersion);
                    ComponentInfo a = cn.jiguang.g.a.a(context, str, this.g);
                    if (a != null && (a instanceof ProviderInfo)) {
                        ProviderInfo providerInfo = (ProviderInfo) a;
                        if (providerInfo.exported && providerInfo.enabled && providerInfo.authority != null) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(str);
                            stringBuilder2.append(".DownloadProvider");
                            if (TextUtils.equals(stringBuilder2.toString(), providerInfo.authority)) {
                                aVar.d = providerInfo.authority;
                            }
                        }
                    }
                    return aVar;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return i.b(stringBuilder.toString());
    }

    private static JSONObject a(int i, String str, String str2, String str3, boolean z) {
        Object str4;
        Object str22;
        Object str32;
        if (str4 == null) {
            try {
                str4 = "";
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        if (str22 == null) {
            str22 = "";
        }
        if (str32 == null) {
            str32 = "";
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("awake_type", i);
        jSONObject.put("from_package", str4);
        jSONObject.put("from_uid", str22);
        jSONObject.put("awake_sequence", str32);
        jSONObject.put("app_alive", z);
        return jSONObject;
    }

    public static void b(Context context, String str, JSONObject jSONObject) {
        JSONObject a;
        JSONObject a2 = x.a(context, jSONObject, str);
        synchronized ("wakeup_cache.json") {
            a = x.a(context, "wakeup_cache.json");
        }
        if (a == null) {
            a = new JSONObject();
        }
        JSONArray optJSONArray = a.optJSONArray(c.a);
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        try {
            optJSONArray.put(a2);
            a.put(c.a, optJSONArray);
            synchronized ("wakeup_cache.json") {
                x.a(context, "wakeup_cache.json", a);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final JSONObject a(String str, ArrayList<d> arrayList) {
        if (arrayList.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            try {
                JSONObject jSONObject = new JSONObject();
                String packageName = dVar.a().getPackageName();
                String a = a(this.b, packageName);
                jSONObject.put("target_package", packageName);
                jSONObject.put("awake_sequence", a);
                JSONArray jSONArray2 = new JSONArray();
                HashMap b = dVar.b();
                for (Integer intValue : b.keySet()) {
                    int intValue2 = intValue.intValue();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("awake_type", intValue2);
                    jSONObject2.put("success", b.get(Integer.valueOf(intValue2)));
                    jSONArray2.put(jSONObject2);
                }
                jSONObject.put("awake", jSONArray2);
                jSONArray.put(jSONObject);
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("package", str);
            jSONObject3.put("target", jSONArray);
            jSONObject3.put("device", Build.MODEL);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(VERSION.RELEASE);
            jSONObject3.put("os", stringBuilder.toString());
            return jSONObject3;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject3;
        }
    }

    public final void a(Context context, int i, boolean z, String str, String str2, String str3) {
        try {
            b(context, "android_awake_target", a(i, str, str2, str3, z));
        } catch (Throwable unused) {
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Context context, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject a;
            JSONObject a2 = x.a(context, jSONObject, str);
            synchronized ("wakeup_cache.json") {
                a = x.a(context, "wakeup_cache.json");
            }
            if (a == null) {
                a = new JSONObject();
            }
            JSONArray optJSONArray = a.optJSONArray(c.a);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            optJSONArray.put(a2);
            JCoreInterface.reportHttpData(context, optJSONArray, SdkType.JCORE.name());
            synchronized ("wakeup_cache.json") {
                x.a(context, "wakeup_cache.json", null);
            }
        }
    }

    public final void a(Class<?> cls) {
        this.g = cls;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a() {
        return (TextUtils.isEmpty(this.h) && this.g == null) ? false : this.e;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(Context context) {
        if (context == null) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = d.j(context);
        return -1 == j || Math.abs(currentTimeMillis - j) > this.a;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(Context context) {
        d.a(context, System.currentTimeMillis() / 1000);
    }

    /* Access modifiers changed, original: protected|final */
    public final ArrayList<a> c(Context context) {
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent();
            intent.setAction(this.f);
            int i = 0;
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() == 0) {
                return null;
            }
            while (i < queryIntentServices.size()) {
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(i)).serviceInfo;
                String str = serviceInfo.name;
                String str2 = serviceInfo.packageName;
                if (!(str == null || str2 == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !serviceInfo.exported || !serviceInfo.enabled || context.getPackageName().equals(str2))) {
                    a a = a(context, packageManager, str2, str);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                i++;
            }
            return arrayList;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("filterAllDaemonService error:");
            stringBuilder.append(th.getMessage());
            cn.jiguang.e.c.a("WakeUpJiGuangSdkManager", stringBuilder.toString());
        }
    }

    public final void c(String str) {
        this.f = str;
    }

    public final void d(Context context) {
        HashMap hashMap = new HashMap();
        String packageName = context.getPackageName();
        long j = this.c;
        hashMap.put("from_package", packageName);
        hashMap.put("from_uid", String.valueOf(j));
        hashMap.put("need_report", "true");
        ArrayList c = c(context);
        if (c != null && !c.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) c.get(i);
                hashMap.put("awake_sequence", a(this.b, aVar.a));
                int i2 = 2;
                if (VERSION.SDK_INT < 26 || aVar.c < 26) {
                    i2 = 3;
                }
                if (!TextUtils.isEmpty(aVar.d)) {
                    i2 |= 4;
                }
                d a = c.a(context, 1, i2, aVar, hashMap);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            if (c.a(context)) {
                JSONObject a2 = a(packageName, arrayList);
                if (a2 != null) {
                    a(context, "android_awake", a2);
                }
            }
        }
    }

    public final void d(String str) {
        this.h = str;
    }
}
