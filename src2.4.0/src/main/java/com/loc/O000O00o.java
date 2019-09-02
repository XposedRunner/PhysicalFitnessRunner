package com.loc;

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
public final class O000O00o {
    public static byte[] O000000o = "FDF1F436161AEF5B".getBytes();
    public static byte[] O00000Oo = "0102030405060708".getBytes();
    private static HashSet<String> O00000o = new HashSet();
    public static String O00000o0 = "SOCRASH";
    private static final String O00000oo = "SOCRASH";
    private File[] O00000oO;

    /* compiled from: SoCrashLogProcessor */
    private static class O000000o {
        private String O000000o;
        private String O00000Oo;
        private String O00000o;
        private String O00000o0;
        private String O00000oO;

        private O000000o(String str, String str2, String str3, String str4, String str5) {
            this.O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
            this.O00000o = str4;
            this.O00000oO = str5;
        }

        public static List<O000000o> O000000o(String str) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(O00000Oo(jSONArray.getString(i)));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return arrayList;
        }

        private static O000000o O00000Oo(String str) {
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

        public final String O000000o() {
            return this.O000000o;
        }

        public final String O00000Oo() {
            return this.O00000Oo;
        }

        public final String O00000o() {
            return this.O00000o;
        }

        public final String O00000o0() {
            return this.O00000o0;
        }

        public final String O00000oO() {
            return this.O00000oO;
        }
    }

    /* compiled from: SoCrashLogProcessor */
    private static class O00000Oo {
        private int O000000o;
        private String O00000Oo;
    }

    private static void O000000o(Context context, O000000o o000000o) throws JSONException {
        if (!(TextUtils.isEmpty(o000000o.O00000Oo()) || TextUtils.isEmpty(o000000o.O00000o0()) || TextUtils.isEmpty(o000000o.O00000o()))) {
            JSONObject jSONObject;
            int i = 0;
            SharedPreferences sharedPreferences = context.getSharedPreferences(OO0OOOO.O00000Oo("SO_DYNAMIC_FILE_KEY"), 0);
            JSONArray jSONArray = new JSONArray(OO0o000.O000000o(OO0o00.O00000Oo(OO0o000.O00000o(sharedPreferences.getString("SO_ERROR_KEY", "")))));
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
            edit.putString("SO_ERROR_KEY", OO0o000.O0000O0o(OO0o00.O000000o(OO0o000.O000000o(jSONArray.toString()))));
            edit.commit();
        }
    }

    private static void O000000o(Context context, byte[] bArr) {
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
                        List O000000o = O000000o.O000000o(optString);
                        if (O000000o != null) {
                            while (i < O000000o.size()) {
                                O000000o o000000o = (O000000o) O000000o.get(i);
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

    private static boolean O000000o(List<O00000Oo> list, String str) {
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

    /* JADX WARNING: Missing block: B:21:0x0022, code skipped:
            return false;
     */
    private static boolean O000000o(byte[] r4, byte[] r5) {
        /*
        r0 = 0;
        if (r4 == 0) goto L_0x0022;
    L_0x0003:
        r1 = r4.length;
        if (r1 != 0) goto L_0x0007;
    L_0x0006:
        return r0;
    L_0x0007:
        if (r5 == 0) goto L_0x0022;
    L_0x0009:
        r1 = r5.length;
        if (r1 != 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r1 = r4.length;
        r2 = r5.length;
        if (r1 == r2) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = r0;
    L_0x0013:
        r2 = r4.length;
        if (r1 >= r2) goto L_0x0020;
    L_0x0016:
        r2 = r4[r1];
        r3 = r5[r1];
        if (r2 == r3) goto L_0x001d;
    L_0x001c:
        return r0;
    L_0x001d:
        r1 = r1 + 1;
        goto L_0x0013;
    L_0x0020:
        r4 = 1;
        return r4;
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O000O00o.O000000o(byte[], byte[]):boolean");
    }

    private static byte[] O000000o(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            bArr = oOo00.O000000o("a1f5886b7153004c5c99559f5261676f".getBytes(), bArr, "nFy1THrhajaZzz8U".getBytes());
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(bArr.length - 16)];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            return !O000000o(OO0OOOO.O000000o(bArr3, "MD5"), bArr2) ? new byte[0] : bArr3;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e A:{Catch:{ Throwable -> 0x008e }} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A:{Catch:{ Throwable -> 0x008e }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0032 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final void O000000o(android.content.Context r9) {
        /*
        r8 = this;
        r0 = com.loc.O0000o00.O000000o(r9);	 Catch:{ Throwable -> 0x008e }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x008e }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x008e }
        r0 = r1.isDirectory();	 Catch:{ Throwable -> 0x008e }
        r2 = 0;
        if (r0 != 0) goto L_0x0012;
    L_0x0010:
        r0 = r2;
        goto L_0x0016;
    L_0x0012:
        r0 = r1.listFiles();	 Catch:{ Throwable -> 0x008e }
    L_0x0016:
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        return;
    L_0x0019:
        r8.O00000oO = r0;	 Catch:{ Throwable -> 0x008e }
        r1 = 0;
        r3 = new com.loc.OO0Oo0$O000000o;	 Catch:{ Throwable -> 0x0032 }
        r4 = O00000oo;	 Catch:{ Throwable -> 0x0032 }
        r5 = "1.0";
        r6 = "";
        r3.<init>(r4, r5, r6);	 Catch:{ Throwable -> 0x0032 }
        r4 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x0032 }
        r3 = r3.O000000o(r4);	 Catch:{ Throwable -> 0x0032 }
        r3 = r3.O000000o();	 Catch:{ Throwable -> 0x0032 }
        r2 = r3;
    L_0x0032:
        r3 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x008e }
        r3.<init>();	 Catch:{ Throwable -> 0x008e }
    L_0x0037:
        r4 = r0.length;	 Catch:{ Throwable -> 0x008e }
        if (r1 >= r4) goto L_0x008e;
    L_0x003a:
        r4 = 10;
        if (r1 >= r4) goto L_0x008e;
    L_0x003e:
        r4 = r0[r1];	 Catch:{ Throwable -> 0x008e }
        if (r4 == 0) goto L_0x008b;
    L_0x0042:
        r5 = r4.exists();	 Catch:{ Throwable -> 0x008e }
        if (r5 == 0) goto L_0x008b;
    L_0x0048:
        r5 = r4.isFile();	 Catch:{ Throwable -> 0x008e }
        if (r5 == 0) goto L_0x008b;
    L_0x004e:
        r5 = O000000o(r4);	 Catch:{ Throwable -> 0x008e }
        if (r5 == 0) goto L_0x0088;
    L_0x0054:
        r6 = r5.length;	 Catch:{ Throwable -> 0x008e }
        if (r6 == 0) goto L_0x0088;
    L_0x0057:
        r6 = r5.length;	 Catch:{ Throwable -> 0x008e }
        r7 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        if (r6 <= r7) goto L_0x005e;
    L_0x005d:
        goto L_0x0088;
    L_0x005e:
        r6 = com.loc.OO0OOOO.O000000o(r5);	 Catch:{ Throwable -> 0x008e }
        r7 = O000000o(r3, r6);	 Catch:{ Throwable -> 0x008e }
        if (r7 != 0) goto L_0x0088;
    L_0x0068:
        r7 = O00000o;	 Catch:{ Throwable -> 0x008e }
        r7 = r7.contains(r6);	 Catch:{ Throwable -> 0x008e }
        if (r7 == 0) goto L_0x0071;
    L_0x0070:
        goto L_0x0088;
    L_0x0071:
        O000000o(r9, r5);	 Catch:{ Throwable -> 0x008e }
        r7 = O00000o;	 Catch:{ Throwable -> 0x008e }
        r7.add(r6);	 Catch:{ Throwable -> 0x008e }
        r5 = com.loc.oOo00.O00000Oo(r5);	 Catch:{ Throwable -> 0x008e }
        r6 = O00000oo;	 Catch:{ Throwable -> 0x008e }
        com.loc.O00oOooO.O000000o(r2, r9, r6, r5);	 Catch:{ Throwable -> 0x008e }
        if (r4 == 0) goto L_0x008b;
    L_0x0084:
        r4.delete();	 Catch:{ Exception -> 0x008b }
        goto L_0x008b;
    L_0x0088:
        r4.delete();	 Catch:{ Throwable -> 0x008e }
    L_0x008b:
        r1 = r1 + 1;
        goto L_0x0037;
    L_0x008e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O000O00o.O000000o(android.content.Context):void");
    }
}
