package cn.jiguang.a.a.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfo.DisplayNameComparator;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import cn.jiguang.d.d.x;
import cn.jiguang.e.c;
import cn.jiguang.net.HttpUtils;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
    private static final String a = "k";

    public static String a(String str, int i) {
        if (str == null) {
            return str;
        }
        str = Pattern.compile("\n|\r|\r\n|\n\r|\t").matcher(str).replaceAll("");
        try {
            byte[] bytes = str.getBytes();
            return bytes.length > 30 ? str.substring(0, new String(bytes, 0, 30, HttpUtils.ENCODING_UTF_8).length()) : str;
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private static Set<String> a(ActivityManager activityManager) {
        HashSet hashSet = new HashSet();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            Collections.addAll(hashSet, runningAppProcessInfo.pkgList);
        }
        return hashSet;
    }

    private static JSONArray a(ActivityManager activityManager, PackageManager packageManager) {
        PackageManager packageManager2 = packageManager;
        JSONArray jSONArray = new JSONArray();
        try {
            Set a = a(activityManager);
            List installedApplications = packageManager2.getInstalledApplications(8192);
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(200);
            Collections.sort(installedApplications, new DisplayNameComparator(packageManager2));
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = installedApplications.iterator();
            while (it.hasNext()) {
                Set set;
                Iterator it2;
                ApplicationInfo applicationInfo = (ApplicationInfo) it.next();
                String a2 = a(applicationInfo.loadLabel(packageManager2).toString(), 30);
                if (a.contains(applicationInfo.packageName)) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray2 = new JSONArray();
                    for (RunningServiceInfo runningServiceInfo : runningServices) {
                        if (runningServiceInfo.service.getPackageName().equals(applicationInfo.packageName)) {
                            JSONObject jSONObject2 = new JSONObject();
                            set = a;
                            it2 = it;
                            long round = (long) Math.round((float) ((elapsedRealtime - runningServiceInfo.activeSince) / 1000));
                            jSONObject2.put("class_name", runningServiceInfo.service.getShortClassName());
                            jSONObject2.put("live_seconds", round);
                            jSONArray2.put(jSONObject2);
                        } else {
                            set = a;
                            it2 = it;
                        }
                        a = set;
                        it = it2;
                    }
                    set = a;
                    it2 = it;
                    try {
                        jSONObject.put("app_name", a2);
                        jSONObject.put("pkg_name", applicationInfo.packageName);
                        jSONObject.put("service_list", jSONArray2);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    set = a;
                    it2 = it;
                }
                a = set;
                it = it2;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            Throwable th2 = th;
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("getRunningApps error:");
            stringBuilder.append(th2.getMessage());
            c.a(str, stringBuilder.toString());
        }
        return jSONArray;
    }

    public static void a(Context context) {
        JSONArray a = a((ActivityManager) context.getSystemService("activity"), context.getPackageManager());
        if (a != null && a.length() != 0) {
            x.a(context, a);
        }
    }
}
