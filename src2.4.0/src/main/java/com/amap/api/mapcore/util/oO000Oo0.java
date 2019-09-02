package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SoCrashLogProcessor */
public class oO000Oo0 {
    public static byte[] O000000o = "FDF1F436161AEF5B".getBytes();
    public static byte[] O00000Oo = "0102030405060708".getBytes();
    private static HashSet<String> O00000o = new HashSet();
    public static String O00000o0 = "SOCRASH";
    private static final String O00000oo = O00000o0;
    private File[] O00000oO;

    /* compiled from: SoCrashLogProcessor */
    private static class O000000o {
        private String O000000o;
        private String O00000Oo;
        private String O00000o;
        private String O00000o0;
        private String O00000oO;

        public O000000o(String str, String str2, String str3, String str4, String str5) {
            this.O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
            this.O00000o = str4;
            this.O00000oO = str5;
        }

        public static O000000o O000000o(String str) {
            if (TextUtils.isEmpty(str)) {
                return new O000000o();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new O000000o(jSONObject.optString("mk", ""), jSONObject.optString("ak", ""), jSONObject.optString("bk", ""), jSONObject.optString("ik", ""), jSONObject.optString("nk", ""));
            } catch (Throwable unused) {
                return new O000000o();
            }
        }

        public static List<O000000o> O00000Oo(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(O000000o(jSONArray.getString(i)));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return arrayList;
        }

        public String O000000o() {
            return this.O000000o;
        }

        public String O00000Oo() {
            return this.O00000Oo;
        }

        public String O00000o() {
            return this.O00000o;
        }

        public String O00000o0() {
            return this.O00000o0;
        }

        public String O00000oO() {
            return this.O00000oO;
        }
    }

    /* compiled from: SoCrashLogProcessor */
    private static class O00000Oo {
        private int O000000o;
        private String O00000Oo;
    }

    private static String O000000o() {
        return o0OO00o0.O00000Oo("SO_DYNAMIC_FILE_KEY");
    }

    private static void O000000o(Context context, O000000o o000000o) throws JSONException {
        if (!(TextUtils.isEmpty(o000000o.O00000Oo()) || TextUtils.isEmpty(o000000o.O00000o0()) || TextUtils.isEmpty(o000000o.O00000o()))) {
            JSONObject jSONObject;
            int i = 0;
            SharedPreferences sharedPreferences = context.getSharedPreferences(O000000o(), 0);
            JSONArray jSONArray = new JSONArray(o0OOOO00.O000000o(o0oO0O0o.O00000Oo(o0OOOO00.O00000oO(sharedPreferences.getString("SO_ERROR_KEY", "")))));
            while (i < jSONArray.length()) {
                jSONObject = jSONArray.getJSONObject(i);
                if (!jSONObject.opt("mk").equals(o000000o.O000000o()) || !jSONObject.opt("ak").equals(o000000o.O00000Oo()) || !jSONObject.opt("bk").equals(o000000o.O00000o0()) || !jSONObject.opt("ik").equals(o000000o.O00000o()) || !jSONObject.opt("nk").equals(o000000o.O00000oO())) {
                    i++;
                } else {
                    return;
                }
            }
            jSONObject = new JSONObject();
            jSONObject.putOpt("mk", o000000o.O000000o());
            jSONObject.putOpt("ak", o000000o.O00000Oo());
            jSONObject.putOpt("bk", o000000o.O00000o0());
            jSONObject.putOpt("ik", o000000o.O00000o());
            jSONObject.putOpt("nk", o000000o.O00000oO());
            jSONArray.put(jSONObject);
            Editor edit = sharedPreferences.edit();
            edit.putString("SO_ERROR_KEY", o0OOOO00.O0000O0o(o0oO0O0o.O000000o(o0OOOO00.O000000o(jSONArray.toString()))));
            edit.commit();
        }
    }

    private void O000000o(Context context, byte[] bArr) {
        if (context != null) {
            try {
                String str = new String(bArr, "ISO-8859-1");
                int i = 0;
                int i2 = (str.indexOf("{\"") <= 0 || str.indexOf("\"}") <= 0) ? 0 : 1;
                if (i2 != 0) {
                    JSONObject jSONObject = new JSONObject(str.substring(str.indexOf("{\""), str.lastIndexOf("\"}") + 2));
                    String optString = jSONObject.optString("ik");
                    str = jSONObject.optString("jk");
                    if (!TextUtils.isEmpty(str)) {
                        List O00000Oo = O000000o.O00000Oo(optString);
                        if (O00000Oo != null) {
                            while (i < O00000Oo.size()) {
                                O000000o o000000o = (O000000o) O00000Oo.get(i);
                                if (str.contains(o000000o.O00000oO())) {
                                    O000000o(context, o000000o);
                                }
                                i++;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void O000000o(File file) {
        if (file != null) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
    }

    private boolean O000000o(List<O00000Oo> list, String str) {
        if (list == null) {
            return false;
        }
        for (O00000Oo o00000Oo : list) {
            if (o00000Oo.O00000Oo.equals(str)) {
                o00000Oo.O000000o = o00000Oo.O000000o + 1;
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Missing block: B:19:0x0022, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:20:0x0023, code skipped:
            return false;
     */
    private boolean O000000o(byte[] r5, byte[] r6) {
        /*
        r4 = this;
        r0 = 0;
        if (r5 == 0) goto L_0x0023;
    L_0x0003:
        r1 = r5.length;
        if (r1 != 0) goto L_0x0007;
    L_0x0006:
        goto L_0x0023;
    L_0x0007:
        if (r6 == 0) goto L_0x0022;
    L_0x0009:
        r1 = r6.length;
        if (r1 != 0) goto L_0x000d;
    L_0x000c:
        goto L_0x0022;
    L_0x000d:
        r1 = r5.length;
        r2 = r6.length;
        if (r1 == r2) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = r0;
    L_0x0013:
        r2 = r5.length;
        if (r1 >= r2) goto L_0x0020;
    L_0x0016:
        r2 = r5[r1];
        r3 = r6[r1];
        if (r2 == r3) goto L_0x001d;
    L_0x001c:
        return r0;
    L_0x001d:
        r1 = r1 + 1;
        goto L_0x0013;
    L_0x0020:
        r5 = 1;
        return r5;
    L_0x0022:
        return r0;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO000Oo0.O000000o(byte[], byte[]):boolean");
    }

    private byte[] O00000Oo(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            bArr = o0OO000o.O000000o("a1f5886b7153004c5c99559f5261676f".getBytes(), bArr, "nFy1THrhajaZzz8U".getBytes());
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(bArr.length - 16)];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            return !O000000o(o0OO00o0.O000000o(bArr3, "MD5"), bArr2) ? new byte[0] : bArr3;
        } catch (Throwable unused) {
            return null;
        }
    }

    private File[] O00000Oo(Context context) {
        File file = new File(oO0Oo0oo.O000000o(context));
        return (file == null || !file.isDirectory()) ? null : file.listFiles();
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003e A:{Catch:{ Throwable -> 0x0080 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d A:{Catch:{ Throwable -> 0x0080 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0021 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public void O000000o(android.content.Context r9) {
        /*
        r8 = this;
        r0 = r8.O00000Oo(r9);	 Catch:{ Throwable -> 0x0080 }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r8.O00000oO = r0;	 Catch:{ Throwable -> 0x0080 }
        r1 = 0;
        r2 = 0;
        r3 = new com.amap.api.mapcore.util.o0OO0o00$O000000o;	 Catch:{ Throwable -> 0x0021 }
        r4 = O00000oo;	 Catch:{ Throwable -> 0x0021 }
        r5 = "1.0";
        r6 = "";
        r3.<init>(r4, r5, r6);	 Catch:{ Throwable -> 0x0021 }
        r4 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x0021 }
        r3 = r3.O000000o(r4);	 Catch:{ Throwable -> 0x0021 }
        r3 = r3.O000000o();	 Catch:{ Throwable -> 0x0021 }
        r1 = r3;
    L_0x0021:
        r3 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0080 }
        r3.<init>();	 Catch:{ Throwable -> 0x0080 }
    L_0x0026:
        r4 = r0.length;	 Catch:{ Throwable -> 0x0080 }
        if (r2 >= r4) goto L_0x0080;
    L_0x0029:
        r4 = 10;
        if (r2 >= r4) goto L_0x0080;
    L_0x002d:
        r4 = r0[r2];	 Catch:{ Throwable -> 0x0080 }
        if (r4 == 0) goto L_0x007d;
    L_0x0031:
        r5 = r4.exists();	 Catch:{ Throwable -> 0x0080 }
        if (r5 == 0) goto L_0x007d;
    L_0x0037:
        r5 = r4.isFile();	 Catch:{ Throwable -> 0x0080 }
        if (r5 != 0) goto L_0x003e;
    L_0x003d:
        goto L_0x007d;
    L_0x003e:
        r5 = r8.O00000Oo(r4);	 Catch:{ Throwable -> 0x0080 }
        if (r5 == 0) goto L_0x007a;
    L_0x0044:
        r6 = r5.length;	 Catch:{ Throwable -> 0x0080 }
        if (r6 == 0) goto L_0x007a;
    L_0x0047:
        r6 = r5.length;	 Catch:{ Throwable -> 0x0080 }
        r7 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        if (r6 <= r7) goto L_0x004e;
    L_0x004d:
        goto L_0x007a;
    L_0x004e:
        r6 = com.amap.api.mapcore.util.o0OO00o0.O000000o(r5);	 Catch:{ Throwable -> 0x0080 }
        r7 = r8.O000000o(r3, r6);	 Catch:{ Throwable -> 0x0080 }
        if (r7 != 0) goto L_0x0076;
    L_0x0058:
        r7 = O00000o;	 Catch:{ Throwable -> 0x0080 }
        r7 = r7.contains(r6);	 Catch:{ Throwable -> 0x0080 }
        if (r7 == 0) goto L_0x0061;
    L_0x0060:
        goto L_0x0076;
    L_0x0061:
        r8.O000000o(r9, r5);	 Catch:{ Throwable -> 0x0080 }
        r7 = O00000o;	 Catch:{ Throwable -> 0x0080 }
        r7.add(r6);	 Catch:{ Throwable -> 0x0080 }
        r5 = com.amap.api.mapcore.util.o0OO000o.O00000Oo(r5);	 Catch:{ Throwable -> 0x0080 }
        r6 = O00000oo;	 Catch:{ Throwable -> 0x0080 }
        com.amap.api.mapcore.util.oO0OOo0o.O000000o(r1, r9, r6, r5);	 Catch:{ Throwable -> 0x0080 }
        r8.O000000o(r4);	 Catch:{ Throwable -> 0x0080 }
        goto L_0x007d;
    L_0x0076:
        r4.delete();	 Catch:{ Throwable -> 0x0080 }
        goto L_0x007d;
    L_0x007a:
        r4.delete();	 Catch:{ Throwable -> 0x0080 }
    L_0x007d:
        r2 = r2 + 1;
        goto L_0x0026;
    L_0x0080:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO000Oo0.O000000o(android.content.Context):void");
    }
}
