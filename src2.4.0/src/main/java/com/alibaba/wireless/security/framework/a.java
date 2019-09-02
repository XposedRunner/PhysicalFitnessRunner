package com.alibaba.wireless.security.framework;

import android.content.pm.PackageInfo;
import com.alibaba.wireless.security.framework.utils.b;
import java.io.File;
import org.json.JSONObject;

public class a {
    public PackageInfo a = null;
    private JSONObject b = null;
    private String c;

    public a(String str) {
        this.c = str;
    }

    public String a(String str) {
        try {
            return b().getString(str);
        } catch (Exception unused) {
            return "";
        }
    }

    public boolean a() {
        try {
            return new File(this.c).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0094 A:{SYNTHETIC, Splitter:B:19:0x0094} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a1 A:{RETURN} */
    public boolean a(android.content.pm.PackageInfo r5, java.lang.String r6) {
        /*
        r4 = this;
        r0 = 0;
        if (r5 == 0) goto L_0x00a3;
    L_0x0003:
        if (r6 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r6 = new org.json.JSONObject;
        r6.<init>();
        r1 = "version";
        r2 = r5.versionName;	 Catch:{ Exception -> 0x00a2 }
        r6.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
        r1 = "hasso";
        r2 = r5.applicationInfo;	 Catch:{ Exception -> 0x00a2 }
        r2 = r2.metaData;	 Catch:{ Exception -> 0x00a2 }
        r3 = "hasso";
        r2 = r2.getBoolean(r3, r0);	 Catch:{ Exception -> 0x00a2 }
        r6.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
        r1 = "pluginname";
        r2 = r5.applicationInfo;	 Catch:{ Exception -> 0x00a2 }
        r2 = r2.metaData;	 Catch:{ Exception -> 0x00a2 }
        r3 = "pluginname";
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x00a2 }
        r6.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
        r1 = "pluginclass";
        r2 = r5.applicationInfo;	 Catch:{ Exception -> 0x00a2 }
        r2 = r2.metaData;	 Catch:{ Exception -> 0x00a2 }
        r3 = "pluginclass";
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x00a2 }
        r6.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
        r1 = "dependencies";
        r2 = r5.applicationInfo;	 Catch:{ Exception -> 0x00a2 }
        r2 = r2.metaData;	 Catch:{ Exception -> 0x00a2 }
        r3 = "dependencies";
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x00a2 }
        r6.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
        r1 = "weakdependencies";
        r2 = r5.applicationInfo;	 Catch:{ Exception -> 0x00a2 }
        r2 = r2.metaData;	 Catch:{ Exception -> 0x00a2 }
        r3 = "weakdependencies";
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x00a2 }
        r6.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
        r1 = "reversedependencies";
        r2 = r5.applicationInfo;	 Catch:{ Exception -> 0x00a2 }
        r2 = r2.metaData;	 Catch:{ Exception -> 0x00a2 }
        r3 = "reversedependencies";
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x00a2 }
        r6.put(r1, r2);	 Catch:{ Exception -> 0x00a2 }
        r1 = "thirdpartyso";
        r5 = r5.applicationInfo;	 Catch:{ Exception -> 0x00a2 }
        r5 = r5.metaData;	 Catch:{ Exception -> 0x00a2 }
        r2 = "thirdpartyso";
        r5 = r5.getBoolean(r2);	 Catch:{ Exception -> 0x00a2 }
        r6.put(r1, r5);	 Catch:{ Exception -> 0x00a2 }
        r5 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x008d }
        r2 = r4.c;	 Catch:{ Exception -> 0x008d }
        r1.<init>(r2);	 Catch:{ Exception -> 0x008d }
        r5 = r1.exists();	 Catch:{ Exception -> 0x008e }
        if (r5 != 0) goto L_0x0097;
    L_0x0089:
        r1.createNewFile();	 Catch:{ Exception -> 0x008e }
        goto L_0x0097;
    L_0x008d:
        r1 = r5;
    L_0x008e:
        r5 = r1.exists();
        if (r5 != 0) goto L_0x0097;
    L_0x0094:
        r1.createNewFile();	 Catch:{ Exception -> 0x0097 }
    L_0x0097:
        r5 = r6.toString();
        r5 = com.alibaba.wireless.security.framework.utils.b.a(r1, r5);
        if (r5 != 0) goto L_0x00a2;
    L_0x00a1:
        return r0;
    L_0x00a2:
        r0 = 1;
    L_0x00a3:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.a.a(android.content.pm.PackageInfo, java.lang.String):boolean");
    }

    public JSONObject b() {
        if (this.b != null) {
            return this.b;
        }
        JSONObject jSONObject = null;
        try {
            String a = b.a(new File(this.c));
            if (a != null && a.length() > 0) {
                jSONObject = new JSONObject(a);
            }
        } catch (Exception unused) {
        }
        this.b = jSONObject;
        return jSONObject;
    }
}
