package cn.jiguang.g;

import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import cn.jiguang.d.d.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    private static final SparseArray<String> a;
    private static long b;

    static {
        SparseArray sparseArray = new SparseArray();
        a = sparseArray;
        sparseArray.put(0, "OK");
        a.put(-1001, "Exceed buffer size. Please contact support.");
        a.put(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED, "Connection failed. Please check your connection and retry later!");
        a.put(-998, "Sending failed or timeout. Please Retry later!");
        a.put(-997, "Receiving failed or timeout. Please Retry later!");
        a.put(-996, "Connection is closed. Please Retry later!");
        a.put(-994, "Response timeout. Please Retry later!");
        a.put(-993, "Invalid socket. Please Retry later!");
        a.put(11, "Failed to register!");
        a.put(1005, "Your appKey and android package name are not matched. Please double check them according to Application you created on Portal.");
        a.put(1006, "You android package name is not exist, Please register your pacakge name in Portal.");
        a.put(1007, "Invalid Imei, Register again.");
        a.put(1008, "Invalid appKey, Please get your Appkey from JIGUANG web console!");
        a.put(1009, "Your appKey is related to a non-Android App.Please use your Android App's appKey, or add an Android app for this appKey.");
        a.put(10000, "Receiver data parse error");
        a.put(102, "102 - Incorrect password");
        a.put(108, "108 - Incorrect uid");
        a.put(PointerIconCompat.TYPE_NO_DROP, "Server reject this connection, will clear cache and restart connect.");
    }

    public static String a(int i) {
        return a.get(i) == null ? null : (String) a.get(i);
    }

    public static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "rmv");
            jSONObject.put("appid", str);
            x.a(null, jSONObject, "app_add_rmv");
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static JSONObject a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "add");
            jSONObject.put("appid", str);
            x.a(null, jSONObject, "app_add_rmv");
            jSONObject.put("install_type", i);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
