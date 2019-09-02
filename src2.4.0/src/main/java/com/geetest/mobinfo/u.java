package com.geetest.mobinfo;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.bangcle.andJni.JniLib1557756502;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: MoreOpen */
public class u {
    private static String[] a = new String[]{"com.bly.dkplat", "com.lbe.parallel", "com.excelliance.dualaid", "com.lody.virtual", "com.qihoo.magic"};

    public static JSONObject a(Context context, String str, String str2, String str3) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, Integer.valueOf(BDLocation.TypeServerDecryptError));
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0040 A:{SYNTHETIC, Splitter:B:32:0x0040} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003a A:{SYNTHETIC, Splitter:B:26:0x003a} */
    /* JADX WARNING: Missing block: B:17:0x002c, code skipped:
            if (r2 == null) goto L_0x0043;
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            r2.close();
     */
    private static boolean a() {
        /*
        r0 = 0;
        r1 = 0;
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x003e, all -> 0x0037 }
        r3 = new java.io.FileReader;	 Catch:{ Exception -> 0x003e, all -> 0x0037 }
        r4 = "/proc/self/maps";
        r3.<init>(r4);	 Catch:{ Exception -> 0x003e, all -> 0x0037 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x003e, all -> 0x0037 }
    L_0x000e:
        r1 = r2.readLine();	 Catch:{ Exception -> 0x0035, all -> 0x0032 }
        if (r1 == 0) goto L_0x002c;
    L_0x0014:
        r3 = a;	 Catch:{ Exception -> 0x0035, all -> 0x0032 }
        r4 = r3.length;	 Catch:{ Exception -> 0x0035, all -> 0x0032 }
        r5 = r0;
    L_0x0018:
        if (r5 >= r4) goto L_0x000e;
    L_0x001a:
        r6 = r3[r5];	 Catch:{ Exception -> 0x0035, all -> 0x0032 }
        r6 = r1.contains(r6);	 Catch:{ Exception -> 0x0035, all -> 0x0032 }
        if (r6 == 0) goto L_0x0029;
    L_0x0022:
        if (r2 == 0) goto L_0x0027;
    L_0x0024:
        r2.close();	 Catch:{ IOException -> 0x0027 }
    L_0x0027:
        r0 = 1;
        return r0;
    L_0x0029:
        r5 = r5 + 1;
        goto L_0x0018;
    L_0x002c:
        if (r2 == 0) goto L_0x0043;
    L_0x002e:
        r2.close();	 Catch:{ IOException -> 0x0043 }
        goto L_0x0043;
    L_0x0032:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0038;
    L_0x0035:
        r1 = r2;
        goto L_0x003e;
    L_0x0037:
        r0 = move-exception;
    L_0x0038:
        if (r1 == 0) goto L_0x003d;
    L_0x003a:
        r1.close();	 Catch:{ IOException -> 0x003d }
    L_0x003d:
        throw r0;
    L_0x003e:
        if (r1 == 0) goto L_0x0043;
    L_0x0040:
        r1.close();	 Catch:{ IOException -> 0x0043 }
    L_0x0043:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.mobinfo.u.a():boolean");
    }

    private static boolean a(Context context) {
        try {
            String path = context.getFilesDir().getPath();
            for (CharSequence contains : a) {
                if (path.contains(contains)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean b() {
        boolean z = false;
        try {
            String c = c();
            if (TextUtils.isEmpty(c)) {
                return false;
            }
            String a = m.a().a("ps");
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            String[] split = a.split("\n");
            if (split != null) {
                if (split.length > 0) {
                    int i = 0;
                    int i2 = i;
                    while (i < split.length) {
                        if (split[i].contains(c)) {
                            int lastIndexOf = split[i].lastIndexOf(" ");
                            String substring = split[i].substring(lastIndexOf <= 0 ? 0 : lastIndexOf + 1, split[i].length());
                            if (new File(String.format("/data/data/%s", new Object[]{substring, Locale.CHINA})).exists()) {
                                i2++;
                            }
                        }
                        i++;
                    }
                    if (i2 > 1) {
                        z = true;
                    }
                    return z;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static String c() {
        return (String) JniLib1557756502.cL(Integer.valueOf(163));
    }
}
