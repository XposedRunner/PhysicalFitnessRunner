package com.geetest.mobinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ApkUtils */
public class k {
    public static JSONArray a(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(0)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("n", packageInfo.packageName);
                jSONObject.put("v", packageInfo.versionName);
                if ((packageInfo.applicationInfo.flags & 1) == 0) {
                    jSONObject.put("s", "0");
                } else {
                    jSONObject.put("s", "1");
                }
                arrayList.add(jSONObject);
            }
        } catch (Exception unused) {
        }
        return new JSONArray(arrayList);
    }
}
