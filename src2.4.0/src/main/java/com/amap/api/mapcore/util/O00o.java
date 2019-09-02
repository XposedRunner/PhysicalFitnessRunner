package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Utility */
public class O00o {
    public static long O000000o() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
    }

    public static long O000000o(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        long j = 0;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            j = file2.isDirectory() ? j + O000000o(file2) : j + file2.length();
        }
        return j;
    }

    public static OfflineMapProvince O000000o(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(O000000o(jSONObject, SocialConstants.PARAM_URL));
        offlineMapProvince.setProvinceName(O000000o(jSONObject, "name"));
        offlineMapProvince.setJianpin(O000000o(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(O000000o(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(O00000o(O000000o(jSONObject, "adcode")));
        offlineMapProvince.setVersion(O000000o(jSONObject, "version"));
        offlineMapProvince.setSize(Long.parseLong(O000000o(jSONObject, "size")));
        offlineMapProvince.setCityList(O00000Oo(jSONObject));
        return offlineMapProvince;
    }

    public static String O000000o(Context context, String str) {
        try {
            return OOo000.O000000o(OOOO0OO.O000000o(context).open(str));
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    public static String O000000o(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return "";
        }
        String str2 = "";
        if (jSONObject.has(str) && !"[]".equals(jSONObject.getString(str))) {
            str2 = jSONObject.optString(str).trim();
        }
        return str2;
    }

    public static List<OfflineMapProvince> O000000o(String str, Context context) throws JSONException {
        return (str == null || "".equals(str)) ? new ArrayList() : O000000o(new JSONObject(str), context);
    }

    public static List<OfflineMapProvince> O000000o(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject optJSONObject;
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("result")) {
            optJSONObject = jSONObject.optJSONObject("result");
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                O00000o0(jSONObject2.toString(), context);
                optJSONObject = jSONObject2.optJSONObject("result");
            } catch (JSONException e) {
                jSONObject2 = jSONObject.optJSONObject("result");
                ooOOOOoo.O00000o0(e, "Utility", "parseJson");
                e.printStackTrace();
                optJSONObject = jSONObject2;
            }
        }
        if (optJSONObject != null) {
            jSONObject = optJSONObject.optJSONObject("offlinemap_with_province_vfour");
            if (jSONObject == null) {
                return arrayList;
            }
            jSONObject = jSONObject.optJSONObject("offlinemapinfo_with_province");
        } else {
            jSONObject = jSONObject.optJSONObject("offlinemapinfo_with_province");
        }
        if (jSONObject == null) {
            return arrayList;
        }
        if (jSONObject.has("version")) {
            O00O0O0o.O00000o = O000000o(jSONObject, "version");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
            if (optJSONObject2 != null) {
                arrayList.add(O000000o(optJSONObject2));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("others");
        optJSONObject = null;
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            optJSONObject = optJSONArray2.getJSONObject(0);
        }
        if (optJSONObject == null) {
            return arrayList;
        }
        arrayList.add(O000000o(optJSONObject));
        return arrayList;
    }

    public static void O000000o(String str) {
    }

    public static ArrayList<OfflineMapCity> O00000Oo(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(O00000o0(jSONObject));
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(O00000o0(optJSONObject));
            }
        }
        return arrayList;
    }

    public static void O00000Oo(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.exists() && file2.isDirectory()) {
                        String[] list = file2.list();
                        if (list == null) {
                            file2.delete();
                        } else if (list.length == 0) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }

    public static void O00000Oo(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(OOo000.O00000o0(context)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.exists() && file.getName().contains(str)) {
                    O00000Oo(file);
                }
            }
            O00000Oo(OOo000.O00000o0(context));
        }
    }

    public static boolean O00000Oo(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!O00000Oo(listFiles[i])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static String O00000o(String str) {
        return "000001".equals(str) ? "100000" : str;
    }

    public static OfflineMapCity O00000o0(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(O00000o(O000000o(jSONObject, "adcode")));
        offlineMapCity.setUrl(O000000o(jSONObject, SocialConstants.PARAM_URL));
        offlineMapCity.setCity(O000000o(jSONObject, "name"));
        offlineMapCity.setCode(O000000o(jSONObject, "citycode"));
        offlineMapCity.setPinyin(O000000o(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(O000000o(jSONObject, "jianpin"));
        offlineMapCity.setVersion(O000000o(jSONObject, "version"));
        offlineMapCity.setSize(Long.parseLong(O000000o(jSONObject, "size")));
        return offlineMapCity;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:47:0x0070=Splitter:B:47:0x0070, B:33:0x004e=Splitter:B:33:0x004e} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x007c A:{SYNTHETIC, Splitter:B:50:0x007c} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0086 A:{SYNTHETIC, Splitter:B:55:0x0086} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a A:{SYNTHETIC, Splitter:B:36:0x005a} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0064 A:{SYNTHETIC, Splitter:B:41:0x0064} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x007c A:{SYNTHETIC, Splitter:B:50:0x007c} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0086 A:{SYNTHETIC, Splitter:B:55:0x0086} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005a A:{SYNTHETIC, Splitter:B:36:0x005a} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0064 A:{SYNTHETIC, Splitter:B:41:0x0064} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x008d A:{SYNTHETIC, Splitter:B:60:0x008d} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0097 A:{SYNTHETIC, Splitter:B:65:0x0097} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x008d A:{SYNTHETIC, Splitter:B:60:0x008d} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0097 A:{SYNTHETIC, Splitter:B:65:0x0097} */
    public static java.lang.String O00000o0(java.io.File r5) {
        /*
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x004b, all -> 0x0047 }
        r2.<init>(r5);	 Catch:{ FileNotFoundException -> 0x006d, IOException -> 0x004b, all -> 0x0047 }
        r5 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x0044, IOException -> 0x0041, all -> 0x003e }
        r3 = new java.io.InputStreamReader;	 Catch:{ FileNotFoundException -> 0x0044, IOException -> 0x0041, all -> 0x003e }
        r4 = "utf-8";
        r3.<init>(r2, r4);	 Catch:{ FileNotFoundException -> 0x0044, IOException -> 0x0041, all -> 0x003e }
        r5.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0044, IOException -> 0x0041, all -> 0x003e }
    L_0x0017:
        r3 = r5.readLine();	 Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
        if (r3 == 0) goto L_0x0021;
    L_0x001d:
        r0.append(r3);	 Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
        goto L_0x0017;
    L_0x0021:
        r0 = r0.toString();	 Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x003a }
        if (r5 == 0) goto L_0x002f;
    L_0x0027:
        r5.close();	 Catch:{ IOException -> 0x002b }
        goto L_0x002f;
    L_0x002b:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x002f:
        if (r2 == 0) goto L_0x0039;
    L_0x0031:
        r2.close();	 Catch:{ IOException -> 0x0035 }
        goto L_0x0039;
    L_0x0035:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0039:
        return r0;
    L_0x003a:
        r0 = move-exception;
        goto L_0x004e;
    L_0x003c:
        r0 = move-exception;
        goto L_0x0070;
    L_0x003e:
        r0 = move-exception;
        r5 = r1;
        goto L_0x008b;
    L_0x0041:
        r0 = move-exception;
        r5 = r1;
        goto L_0x004e;
    L_0x0044:
        r0 = move-exception;
        r5 = r1;
        goto L_0x0070;
    L_0x0047:
        r0 = move-exception;
        r5 = r1;
        r2 = r5;
        goto L_0x008b;
    L_0x004b:
        r0 = move-exception;
        r5 = r1;
        r2 = r5;
    L_0x004e:
        r3 = "MapDownloadManager";
        r4 = "readOfflineSD io";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r3, r4);	 Catch:{ all -> 0x008a }
        r0.printStackTrace();	 Catch:{ all -> 0x008a }
        if (r5 == 0) goto L_0x0062;
    L_0x005a:
        r5.close();	 Catch:{ IOException -> 0x005e }
        goto L_0x0062;
    L_0x005e:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0062:
        if (r2 == 0) goto L_0x0089;
    L_0x0064:
        r2.close();	 Catch:{ IOException -> 0x0068 }
        goto L_0x0089;
    L_0x0068:
        r5 = move-exception;
        r5.printStackTrace();
        goto L_0x0089;
    L_0x006d:
        r0 = move-exception;
        r5 = r1;
        r2 = r5;
    L_0x0070:
        r3 = "MapDownloadManager";
        r4 = "readOfflineSD filenotfound";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r3, r4);	 Catch:{ all -> 0x008a }
        r0.printStackTrace();	 Catch:{ all -> 0x008a }
        if (r5 == 0) goto L_0x0084;
    L_0x007c:
        r5.close();	 Catch:{ IOException -> 0x0080 }
        goto L_0x0084;
    L_0x0080:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0084:
        if (r2 == 0) goto L_0x0089;
    L_0x0086:
        r2.close();	 Catch:{ IOException -> 0x0068 }
    L_0x0089:
        return r1;
    L_0x008a:
        r0 = move-exception;
    L_0x008b:
        if (r5 == 0) goto L_0x0095;
    L_0x008d:
        r5.close();	 Catch:{ IOException -> 0x0091 }
        goto L_0x0095;
    L_0x0091:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x0095:
        if (r2 == 0) goto L_0x009f;
    L_0x0097:
        r2.close();	 Catch:{ IOException -> 0x009b }
        goto L_0x009f;
    L_0x009b:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x009f:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00o.O00000o0(java.io.File):java.lang.String");
    }

    public static String O00000o0(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return str.substring(str.lastIndexOf(HttpUtils.PATHS_SEPARATOR) + 1, str.indexOf(".zip"));
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "Utility", "getZipFileNameFromUrl");
        }
        return null;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x006d=Splitter:B:29:0x006d, B:35:0x007e=Splitter:B:35:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008a A:{SYNTHETIC, Splitter:B:38:0x008a} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0079 A:{SYNTHETIC, Splitter:B:32:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0090 A:{SYNTHETIC, Splitter:B:41:0x0090} */
    public static void O00000o0(java.lang.String r5, android.content.Context r6) {
        /*
        r0 = "";
        r1 = com.amap.api.mapcore.util.OOo000.O00000o0(r6);
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = new java.io.File;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r6 = com.amap.api.mapcore.util.OOo000.O00000o0(r6);
        r1.append(r6);
        r6 = "offlinemapv4.png";
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        r6 = r0.exists();
        if (r6 != 0) goto L_0x003c;
    L_0x002d:
        r0.createNewFile();	 Catch:{ IOException -> 0x0031 }
        goto L_0x003c;
    L_0x0031:
        r6 = move-exception;
        r1 = "OfflineUpdateCityHandlerAbstract";
        r2 = "writeSD dirCreate";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r6, r1, r2);
        r6.printStackTrace();
    L_0x003c:
        r1 = O000000o();
        r3 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r6 <= 0) goto L_0x0099;
    L_0x0047:
        r6 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x007d, IOException -> 0x006c }
        r6 = "utf-8";
        r5 = r5.getBytes(r6);	 Catch:{ FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
        r1.write(r5);	 Catch:{ FileNotFoundException -> 0x0067, IOException -> 0x0064, all -> 0x0061 }
        if (r1 == 0) goto L_0x0099;
    L_0x0058:
        r1.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x0099;
    L_0x005c:
        r5 = move-exception;
        r5.printStackTrace();
        goto L_0x0099;
    L_0x0061:
        r5 = move-exception;
        r6 = r1;
        goto L_0x008e;
    L_0x0064:
        r5 = move-exception;
        r6 = r1;
        goto L_0x006d;
    L_0x0067:
        r5 = move-exception;
        r6 = r1;
        goto L_0x007e;
    L_0x006a:
        r5 = move-exception;
        goto L_0x008e;
    L_0x006c:
        r5 = move-exception;
    L_0x006d:
        r0 = "OfflineUpdateCityHandlerAbstract";
        r1 = "writeSD io";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r5, r0, r1);	 Catch:{ all -> 0x006a }
        r5.printStackTrace();	 Catch:{ all -> 0x006a }
        if (r6 == 0) goto L_0x0099;
    L_0x0079:
        r6.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x0099;
    L_0x007d:
        r5 = move-exception;
    L_0x007e:
        r0 = "OfflineUpdateCityHandlerAbstract";
        r1 = "writeSD filenotfound";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r5, r0, r1);	 Catch:{ all -> 0x006a }
        r5.printStackTrace();	 Catch:{ all -> 0x006a }
        if (r6 == 0) goto L_0x0099;
    L_0x008a:
        r6.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x0099;
    L_0x008e:
        if (r6 == 0) goto L_0x0098;
    L_0x0090:
        r6.close();	 Catch:{ IOException -> 0x0094 }
        goto L_0x0098;
    L_0x0094:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0098:
        throw r5;
    L_0x0099:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00o.O00000o0(java.lang.String, android.content.Context):void");
    }
}
