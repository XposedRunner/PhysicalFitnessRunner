package cn.jiguang.g;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import cn.jiguang.a.a.c.h;
import cn.jiguang.a.a.c.k;
import cn.jiguang.d.d.x;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    public static int a(ApplicationInfo applicationInfo) {
        if (applicationInfo == null) {
            return -1;
        }
        try {
            int i = 0;
            if (((applicationInfo.flags & 1) != 0 ? 1 : 0) != 0) {
                if ((applicationInfo.flags & 128) != 0) {
                    i = 1;
                }
                return i != 0 ? 2 : 1;
            } else {
                String str = applicationInfo.sourceDir;
                return TextUtils.isEmpty(str) ? -1 : (!str.startsWith("/system/") && applicationInfo.sourceDir.contains(applicationInfo.packageName)) ? 0 : 3;
            }
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static ApplicationInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static List<e> a(int i) {
        ArrayList<String> a = a.a(new String[]{"ps"});
        ArrayList arrayList = new ArrayList();
        if (a == null || a.isEmpty()) {
            return arrayList;
        }
        Iterator it;
        e a2;
        List<e> list;
        HashSet hashSet = new HashSet();
        Map a3 = e.a((String) a.remove(0));
        for (String a4 : a) {
            a2 = e.a(a4, a3);
            if (a2 != null) {
                if (i == 3 || !a2.a()) {
                    if (!"ps".equals(a2.a)) {
                        arrayList.add(a2);
                    }
                } else if (a2.b()) {
                    hashSet.add(a2.c);
                }
            }
        }
        if (i != 1 || hashSet.isEmpty()) {
            list = arrayList;
        } else {
            list = new ArrayList();
            int i2;
            for (int i3 = 0; i3 == 0; i3 = i2) {
                it = arrayList.iterator();
                i2 = 1;
                while (it.hasNext()) {
                    a2 = (e) it.next();
                    if (hashSet.contains(a2.d)) {
                        list.add(a2);
                        hashSet.add(a2.c);
                        it.remove();
                        i2 = 0;
                    }
                }
            }
        }
        return list;
    }

    private static List<h> a(Context context) {
        HashMap hashMap = new HashMap();
        for (e eVar : a(1)) {
            h b = b(context, eVar.a);
            if (b != null) {
                hashMap.put(b.b, b);
            }
        }
        return new ArrayList(hashMap.values());
    }

    private static JSONArray a(List<h> list) {
        JSONArray jSONArray = new JSONArray();
        for (h hVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", hVar.a);
                jSONObject.put("pkg", i.a(hVar.b, 128));
                jSONObject.put("ver_name", hVar.c);
                jSONObject.put("ver_code", hVar.d);
                jSONObject.put("install_type", hVar.e);
                jSONArray.put(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return jSONArray;
    }

    public static void a(Context context, int i, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = null;
        if (i2 > 0) {
            try {
                List<e> a = a(i2);
                jSONArray = new JSONArray();
                for (e a2 : a) {
                    JSONObject a3 = a2.a(128);
                    if (a3 != null) {
                        jSONArray.put(a3);
                    }
                }
            } catch (Throwable unused) {
                return;
            }
        }
        jSONArray = null;
        if (i > 0) {
            jSONArray2 = a(VERSION.SDK_INT < 21 ? b(context) : a(context));
        }
        JSONObject jSONObject = new JSONObject();
        if (jSONArray2 != null && jSONArray2.length() > 0) {
            jSONObject.put("app", jSONArray2);
        }
        if (jSONArray != null && jSONArray.length() > 0) {
            jSONObject.put(UMModuleRegister.PROCESS, jSONArray);
        }
        if (jSONObject.length() > 0) {
            x.a(context, jSONObject, "app_running");
            x.a(context, jSONObject);
        }
    }

    private static h b(Context context, String str) {
        try {
            PackageInfo c = c(context, str);
            if (c == null) {
                return null;
            }
            String charSequence = c.applicationInfo.loadLabel(context.getPackageManager()).toString();
            h hVar = new h();
            hVar.a = k.a(charSequence, 30);
            hVar.b = c.packageName;
            hVar.d = c.versionCode;
            hVar.c = c.versionName;
            hVar.e = a(c.applicationInfo);
            return hVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static List<h> b(Context context) {
        ArrayList arrayList = new ArrayList();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        HashSet hashSet = new HashSet();
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            String[] strArr = runningAppProcessInfo.pkgList;
            if (strArr != null && strArr.length > 0) {
                Collections.addAll(hashSet, strArr);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            h b = b(context, (String) it.next());
            if (b != null) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    private static PackageInfo c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
