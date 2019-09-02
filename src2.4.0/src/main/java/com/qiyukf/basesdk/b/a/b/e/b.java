package com.qiyukf.basesdk.b.a.b.e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.qiyukf.basesdk.a.a;
import com.sina.weibo.sdk.statistic.LogBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static final String a = c.a(b.class);

    private static String a(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, null);
    }

    private static String a(JSONArray jSONArray) {
        Throwable e;
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        String str = "";
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(jSONArray.getString(i));
                String stringBuilder2 = stringBuilder.toString();
                try {
                    if (i != jSONArray.length() - 1) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(stringBuilder2);
                        stringBuilder3.append(";");
                        str = stringBuilder3.toString();
                    } else {
                        str = stringBuilder2;
                    }
                    i++;
                } catch (JSONException e2) {
                    e = e2;
                    str = stringBuilder2;
                    a.b(a, "get json string exception", e);
                    return str;
                }
            } catch (JSONException e3) {
                e = e3;
                a.b(a, "get json string exception", e);
                return str;
            }
        }
        return str;
    }

    private static void a(Context context, String str, String str2) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("lbs");
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("lbs ip: ");
            stringBuilder.append(string);
            a.d(str, stringBuilder.toString());
            String a = a(jSONObject.getJSONArray("upload"));
            str = a;
            stringBuilder = new StringBuilder("upload server ip string: ");
            stringBuilder.append(a);
            a.d(str, stringBuilder.toString());
            if (!TextUtils.isEmpty(string)) {
                a(context, "netease_pomelo_nos_lbs", string);
            }
            if (!TextUtils.isEmpty(a)) {
                a(context, "netease_pomelo_nos_server", a);
                string = a;
                StringBuilder stringBuilder2 = new StringBuilder("save http upload server ip: ");
                stringBuilder2.append(a);
                a.d(string, stringBuilder2.toString());
                a = a.replaceAll("http://", "https://");
                a(context, "netease_pomelo_nos_https_server", a);
                string = a;
                stringBuilder2 = new StringBuilder("save https upload server ip: ");
                stringBuilder2.append(a);
                a.d(string, stringBuilder2.toString());
            }
            long currentTimeMillis = System.currentTimeMillis();
            Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putLong("netease_pomelo_nos_last_save_time", currentTimeMillis);
            edit.commit();
            a.d(a, "save lbs response data");
        } catch (JSONException e) {
            a.b(a, "get json array exception", e);
        }
    }

    public static boolean a(Context context) {
        long j = PreferenceManager.getDefaultSharedPreferences(context).getLong("netease_pomelo_nos_last_save_time", 0);
        boolean z = false;
        if (j <= 0) {
            return false;
        }
        if (System.currentTimeMillis() - j <= LogBuilder.MAX_INTERVAL) {
            z = true;
        }
        if (!z) {
            a(context, "netease_pomelo_nos_lbs", null);
        }
        return z;
    }

    public static String[] a(Context context, boolean z) {
        String a = a(context, !z ? "netease_pomelo_nos_server" : "netease_pomelo_nos_https_server");
        return a == null ? null : a.split(";");
    }

    public static String b(Context context) {
        return a(context, "netease_pomelo_nos_lbs");
    }

    public static void c(Context context) {
        a(context, "netease_pomelo_nos_lbs", null);
    }
}
