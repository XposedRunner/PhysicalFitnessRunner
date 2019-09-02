package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.tencent.stat.DeviceInfo;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

public class PermissionCheck {
    public static int a = 200;
    public static int b = 202;
    public static int c = 252;
    private static final String d = "PermissionCheck";
    private static Context e = null;
    private static String f = null;
    private static Hashtable<String, String> g = null;
    private static LBSAuthManager h = null;
    private static LBSAuthManagerListener i = null;
    private static c j = null;
    private static int k = 601;

    public interface c {
        void a(b bVar);
    }

    private static class a implements LBSAuthManagerListener {
        private a() {
        }

        /* synthetic */ a(e eVar) {
            this();
        }

        public void onAuthResult(int i, String str) {
            if (str == null) {
                Log.e(PermissionCheck.d, "The result is null");
                i = PermissionCheck.permissionCheck();
                str = PermissionCheck.d;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onAuthResult try permissionCheck result is: ");
                stringBuilder.append(i);
                Log.d(str, stringBuilder.toString());
                return;
            }
            b bVar = new b();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    bVar.a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    bVar.c = jSONObject.optString("appid");
                }
                if (jSONObject.has(Oauth2AccessToken.KEY_UID)) {
                    bVar.b = jSONObject.optString(Oauth2AccessToken.KEY_UID);
                }
                if (jSONObject.has("message")) {
                    bVar.d = jSONObject.optString("message");
                }
                if (jSONObject.has("token")) {
                    bVar.e = jSONObject.optString("token");
                }
                if (jSONObject.has("ak_permission")) {
                    bVar.f = jSONObject.optInt("ak_permission");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            PermissionCheck.k = bVar.a;
            if (PermissionCheck.j != null) {
                PermissionCheck.j.a(bVar);
            }
        }
    }

    public static class b {
        public int a = 0;
        public String b = "-1";
        public String c = "-1";
        public String d = "";
        public String e;
        public int f;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\nerrorcode为230时，请参考论坛链接：\nhttp://bbs.lbsyun.baidu.com/forum.php?mod=viewthread&tid=106461\n=============================================\n", new Object[]{a.a(PermissionCheck.e), PermissionCheck.f, Integer.valueOf(this.a), this.b, this.c, this.d});
        }
    }

    public static void destory() {
        j = null;
        e = null;
        i = null;
    }

    public static int getPermissionResult() {
        return k;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        Object charSequence;
        e = context;
        try {
            applicationInfo = e.getPackageManager().getApplicationInfo(e.getPackageName(), 128);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            f = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (g == null) {
            g = new Hashtable();
        }
        if (h == null) {
            h = LBSAuthManager.getInstance(e);
        }
        if (i == null) {
            i = new a();
        }
        String str = "";
        try {
            charSequence = context.getPackageManager().getPackageInfo(e.getPackageName(), 0).applicationInfo.loadLabel(e.getPackageManager()).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            charSequence = str;
        }
        Bundle b = h.b();
        if (b != null) {
            g.put("mb", b.getString("mb"));
            g.put("os", b.getString("os"));
            g.put("sv", b.getString("sv"));
            g.put("imt", "1");
            g.put("net", b.getString("net"));
            g.put("cpu", b.getString("cpu"));
            g.put("glr", b.getString("glr"));
            g.put("glv", b.getString("glv"));
            g.put("resid", b.getString("resid"));
            g.put("appid", "-1");
            g.put(DeviceInfo.TAG_VERSION, "1");
            g.put("screen", String.format("(%d,%d)", new Object[]{Integer.valueOf(b.getInt("screen_x")), Integer.valueOf(b.getInt("screen_y"))}));
            g.put("dpi", String.format("(%d,%d)", new Object[]{Integer.valueOf(b.getInt("dpi_x")), Integer.valueOf(b.getInt("dpi_y"))}));
            g.put("pcn", b.getString("pcn"));
            g.put("cuid", b.getString("cuid"));
            g.put("name", charSequence);
        }
    }

    /* JADX WARNING: Missing block: B:14:0x0036, code skipped:
            return r1;
     */
    public static synchronized int permissionCheck() {
        /*
        r0 = com.baidu.mapsdkplatform.comapi.util.PermissionCheck.class;
        monitor-enter(r0);
        r1 = h;	 Catch:{ all -> 0x0065 }
        r2 = 0;
        if (r1 == 0) goto L_0x0037;
    L_0x0008:
        r1 = i;	 Catch:{ all -> 0x0065 }
        if (r1 == 0) goto L_0x0037;
    L_0x000c:
        r1 = e;	 Catch:{ all -> 0x0065 }
        if (r1 != 0) goto L_0x0011;
    L_0x0010:
        goto L_0x0037;
    L_0x0011:
        r1 = h;	 Catch:{ all -> 0x0065 }
        r3 = "lbs_androidmapsdk";
        r4 = g;	 Catch:{ all -> 0x0065 }
        r5 = i;	 Catch:{ all -> 0x0065 }
        r1 = r1.authenticate(r2, r3, r4, r5);	 Catch:{ all -> 0x0065 }
        if (r1 == 0) goto L_0x0035;
    L_0x001f:
        r2 = d;	 Catch:{ all -> 0x0065 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
        r3.<init>();	 Catch:{ all -> 0x0065 }
        r4 = "permission check result is: ";
        r3.append(r4);	 Catch:{ all -> 0x0065 }
        r3.append(r1);	 Catch:{ all -> 0x0065 }
        r3 = r3.toString();	 Catch:{ all -> 0x0065 }
        android.util.Log.e(r2, r3);	 Catch:{ all -> 0x0065 }
    L_0x0035:
        monitor-exit(r0);
        return r1;
    L_0x0037:
        r1 = d;	 Catch:{ all -> 0x0065 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
        r3.<init>();	 Catch:{ all -> 0x0065 }
        r4 = "The authManager is: ";
        r3.append(r4);	 Catch:{ all -> 0x0065 }
        r4 = h;	 Catch:{ all -> 0x0065 }
        r3.append(r4);	 Catch:{ all -> 0x0065 }
        r4 = "; the authCallback is: ";
        r3.append(r4);	 Catch:{ all -> 0x0065 }
        r4 = i;	 Catch:{ all -> 0x0065 }
        r3.append(r4);	 Catch:{ all -> 0x0065 }
        r4 = "; the mContext is: ";
        r3.append(r4);	 Catch:{ all -> 0x0065 }
        r4 = e;	 Catch:{ all -> 0x0065 }
        r3.append(r4);	 Catch:{ all -> 0x0065 }
        r3 = r3.toString();	 Catch:{ all -> 0x0065 }
        android.util.Log.e(r1, r3);	 Catch:{ all -> 0x0065 }
        monitor-exit(r0);
        return r2;
    L_0x0065:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.util.PermissionCheck.permissionCheck():int");
    }

    public static void setPermissionCheckResultListener(c cVar) {
        j = cVar;
    }
}
