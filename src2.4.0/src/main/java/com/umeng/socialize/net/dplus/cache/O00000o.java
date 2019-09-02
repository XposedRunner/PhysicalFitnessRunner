package com.umeng.socialize.net.dplus.cache;

import android.text.TextUtils;
import com.umeng.socialize.utils.O00000Oo;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DplueCache */
public class O00000o {
    public static File O000000o(String str) {
        if (O00000Oo.O000000o() == null) {
            return null;
        }
        String packageName = O00000Oo.O000000o().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(File.separator);
        stringBuilder.append("data");
        stringBuilder.append(File.separator);
        stringBuilder.append("data");
        stringBuilder.append(File.separator);
        stringBuilder.append(packageName);
        stringBuilder.append(File.separator);
        stringBuilder.append("files");
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        str = stringBuilder.toString();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        return (file.exists() || file.mkdirs()) ? file : null;
    }

    public static String O000000o() {
        return "dpluscache";
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054 A:{SYNTHETIC, Splitter:B:27:0x0054} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0063 A:{SYNTHETIC, Splitter:B:34:0x0063} */
    public static java.lang.String O000000o(java.io.File r4) {
        /*
        r0 = r4.exists();
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r4 = "";
        return r4;
    L_0x0009:
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004c }
        r1.<init>();	 Catch:{ Exception -> 0x004c }
        r2 = com.umeng.socialize.utils.O00000Oo.O000000o();	 Catch:{ Exception -> 0x004c }
        r4 = r4.getName();	 Catch:{ Exception -> 0x004c }
        r4 = r2.openFileInput(r4);	 Catch:{ Exception -> 0x004c }
        r2 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x004c }
        r2.<init>(r4);	 Catch:{ Exception -> 0x004c }
        r4 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x004c }
        r4.<init>(r2);	 Catch:{ Exception -> 0x004c }
    L_0x0025:
        r0 = r4.readLine();	 Catch:{ Exception -> 0x0045, all -> 0x0040 }
        if (r0 == 0) goto L_0x002f;
    L_0x002b:
        r1.append(r0);	 Catch:{ Exception -> 0x0045, all -> 0x0040 }
        goto L_0x0025;
    L_0x002f:
        r0 = r1.toString();	 Catch:{ Exception -> 0x0045, all -> 0x0040 }
        if (r4 == 0) goto L_0x003f;
    L_0x0035:
        r4.close();	 Catch:{ Exception -> 0x0039 }
        goto L_0x003f;
    L_0x0039:
        r4 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O00000Oo.O000000o;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r4);
    L_0x003f:
        return r0;
    L_0x0040:
        r0 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x0061;
    L_0x0045:
        r0 = move-exception;
        r3 = r0;
        r0 = r4;
        r4 = r3;
        goto L_0x004d;
    L_0x004a:
        r4 = move-exception;
        goto L_0x0061;
    L_0x004c:
        r4 = move-exception;
    L_0x004d:
        r1 = com.umeng.socialize.utils.O0000o00.O00000Oo.O000000o;	 Catch:{ all -> 0x004a }
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r4);	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x005e;
    L_0x0054:
        r0.close();	 Catch:{ Exception -> 0x0058 }
        goto L_0x005e;
    L_0x0058:
        r4 = move-exception;
        r0 = com.umeng.socialize.utils.O0000o00.O00000Oo.O000000o;
        com.umeng.socialize.utils.O0000O0o.O000000o(r0, r4);
    L_0x005e:
        r4 = "";
        return r4;
    L_0x0061:
        if (r0 == 0) goto L_0x006d;
    L_0x0063:
        r0.close();	 Catch:{ Exception -> 0x0067 }
        goto L_0x006d;
    L_0x0067:
        r0 = move-exception;
        r1 = com.umeng.socialize.utils.O0000o00.O00000Oo.O000000o;
        com.umeng.socialize.utils.O0000O0o.O000000o(r1, r0);
    L_0x006d:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache.O00000o.O000000o(java.io.File):java.lang.String");
    }

    private static JSONObject O000000o(JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject = jSONObject.optJSONObject("content");
            if (jSONObject != null) {
                return jSONObject.optJSONObject("share");
            }
        }
        return new JSONObject();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039 A:{SYNTHETIC, Splitter:B:21:0x0039} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A:{SYNTHETIC, Splitter:B:27:0x0046} */
    private static boolean O000000o(java.lang.String r3, java.io.File r4) {
        /*
        r0 = 0;
        r1 = 0;
        r2 = com.umeng.socialize.utils.O00000Oo.O000000o();	 Catch:{ Exception -> 0x0031 }
        r4 = r4.getName();	 Catch:{ Exception -> 0x0031 }
        r4 = r2.openFileOutput(r4, r0);	 Catch:{ Exception -> 0x0031 }
        r2 = new java.io.OutputStreamWriter;	 Catch:{ Exception -> 0x0031 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0031 }
        r4 = new java.io.BufferedWriter;	 Catch:{ Exception -> 0x0031 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0031 }
        r4.write(r3);	 Catch:{ Exception -> 0x002c, all -> 0x0029 }
        r3 = 1;
        if (r4 == 0) goto L_0x0028;
    L_0x001e:
        r4.close();	 Catch:{ Exception -> 0x0022 }
        goto L_0x0028;
    L_0x0022:
        r4 = move-exception;
        r0 = com.umeng.socialize.utils.O0000o00.O00000Oo.O00000Oo;
        com.umeng.socialize.utils.O0000O0o.O000000o(r0, r4);
    L_0x0028:
        return r3;
    L_0x0029:
        r3 = move-exception;
        r1 = r4;
        goto L_0x0044;
    L_0x002c:
        r3 = move-exception;
        r1 = r4;
        goto L_0x0032;
    L_0x002f:
        r3 = move-exception;
        goto L_0x0044;
    L_0x0031:
        r3 = move-exception;
    L_0x0032:
        r4 = com.umeng.socialize.utils.O0000o00.O00000Oo.O000000o;	 Catch:{ all -> 0x002f }
        com.umeng.socialize.utils.O0000O0o.O000000o(r4, r3);	 Catch:{ all -> 0x002f }
        if (r1 == 0) goto L_0x0043;
    L_0x0039:
        r1.close();	 Catch:{ Exception -> 0x003d }
        goto L_0x0043;
    L_0x003d:
        r3 = move-exception;
        r4 = com.umeng.socialize.utils.O0000o00.O00000Oo.O00000Oo;
        com.umeng.socialize.utils.O0000O0o.O000000o(r4, r3);
    L_0x0043:
        return r0;
    L_0x0044:
        if (r1 == 0) goto L_0x0050;
    L_0x0046:
        r1.close();	 Catch:{ Exception -> 0x004a }
        goto L_0x0050;
    L_0x004a:
        r4 = move-exception;
        r0 = com.umeng.socialize.utils.O0000o00.O00000Oo.O00000Oo;
        com.umeng.socialize.utils.O0000O0o.O000000o(r0, r4);
    L_0x0050:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache.O00000o.O000000o(java.lang.String, java.io.File):boolean");
    }

    public static boolean O000000o(JSONObject jSONObject, File file) throws JSONException, IOException {
        if (file.exists()) {
            String O000000o = O000000o(file);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o);
            stringBuilder.append(",");
            stringBuilder.append(jSONObject);
            return O000000o(stringBuilder.toString(), file);
        }
        file.createNewFile();
        return O000000o(jSONObject.toString(), file);
    }

    public static boolean O00000Oo(File file) {
        return file.delete();
    }
}
