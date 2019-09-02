package com.amap.api.mapcore.util;

import android.content.Context;
import cn.jiguang.net.HttpUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;

@hz(a = "update_item", b = true)
/* compiled from: UpdateItem */
public class O00Oo00 extends O00Oo0OO {
    private String O0000o0 = "";
    private Context O0000o0O;

    public O00Oo00(OfflineMapCity offlineMapCity, Context context) {
        this.O0000o0O = context;
        this.O000000o = offlineMapCity.getCity();
        this.O00000o0 = offlineMapCity.getAdcode();
        this.O00000Oo = offlineMapCity.getUrl();
        this.O0000O0o = offlineMapCity.getSize();
        this.O00000oO = offlineMapCity.getVersion();
        this.O0000OoO = offlineMapCity.getCode();
        this.O0000Oo0 = 0;
        this.O0000Ooo = offlineMapCity.getState();
        this.O0000Oo = offlineMapCity.getcompleteCode();
        this.O0000o00 = offlineMapCity.getPinyin();
        O000000o();
    }

    public O00Oo00(OfflineMapProvince offlineMapProvince, Context context) {
        this.O0000o0O = context;
        this.O000000o = offlineMapProvince.getProvinceName();
        this.O00000o0 = offlineMapProvince.getProvinceCode();
        this.O00000Oo = offlineMapProvince.getUrl();
        this.O0000O0o = offlineMapProvince.getSize();
        this.O00000oO = offlineMapProvince.getVersion();
        this.O0000Oo0 = 1;
        this.O0000Ooo = offlineMapProvince.getState();
        this.O0000Oo = offlineMapProvince.getcompleteCode();
        this.O0000o00 = offlineMapProvince.getPinyin();
        O000000o();
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

    /* Access modifiers changed, original: protected */
    public void O000000o() {
        String O00000o0 = OOo000.O00000o0(this.O0000o0O);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O00000o0);
        stringBuilder.append(this.O0000o00);
        stringBuilder.append(".zip");
        stringBuilder.append(".tmp");
        this.O00000o = stringBuilder.toString();
    }

    public void O000000o(String str) {
        this.O0000o0 = str;
    }

    public String O00000Oo() {
        return this.O0000o0;
    }

    public void O00000Oo(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("file");
                    if (jSONObject != null) {
                        this.O000000o = jSONObject.optString("title");
                        this.O00000o0 = jSONObject.optString(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE);
                        this.O00000Oo = jSONObject.optString(SocialConstants.PARAM_URL);
                        this.O00000o = jSONObject.optString("fileName");
                        this.O00000oo = jSONObject.optLong("lLocalLength");
                        this.O0000O0o = jSONObject.optLong("lRemoteLength");
                        this.O0000Ooo = jSONObject.optInt("mState");
                        this.O00000oO = jSONObject.optString("version");
                        this.O0000OOo = jSONObject.optString("localPath");
                        this.O0000o0 = jSONObject.optString("vMapFileNames");
                        this.O0000Oo0 = jSONObject.optInt("isSheng");
                        this.O0000Oo = jSONObject.optInt("mCompleteCode");
                        this.O0000OoO = jSONObject.optString("mCityCode");
                        this.O0000o00 = O000000o(jSONObject, "pinyin");
                        if ("".equals(this.O0000o00)) {
                            str = this.O00000Oo.substring(this.O00000Oo.lastIndexOf(HttpUtils.PATHS_SEPARATOR) + 1);
                            this.O0000o00 = str.substring(0, str.lastIndexOf("."));
                        }
                    }
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "UpdateItem", "readFileToJSONObject");
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c5 A:{SYNTHETIC, Splitter:B:26:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cd A:{SYNTHETIC, Splitter:B:30:0x00cd} */
    public void O00000o0() {
        /*
        r6 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00d6 }
        r1.<init>();	 Catch:{ Throwable -> 0x00d6 }
        r2 = "title";
        r3 = r6.O000000o;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "code";
        r3 = r6.O00000o0;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "url";
        r3 = r6.O00000Oo;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "fileName";
        r3 = r6.O00000o;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "lLocalLength";
        r3 = r6.O00000oo;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "lRemoteLength";
        r3 = r6.O0000O0o;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "mState";
        r3 = r6.O0000Ooo;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "version";
        r3 = r6.O00000oO;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "localPath";
        r3 = r6.O0000OOo;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = r6.O0000o0;	 Catch:{ Throwable -> 0x00d6 }
        if (r2 == 0) goto L_0x0054;
    L_0x004d:
        r2 = "vMapFileNames";
        r3 = r6.O0000o0;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
    L_0x0054:
        r2 = "isSheng";
        r3 = r6.O0000Oo0;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "mCompleteCode";
        r3 = r6.O0000Oo;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "mCityCode";
        r3 = r6.O0000OoO;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "pinyin";
        r3 = r6.O0000o00;	 Catch:{ Throwable -> 0x00d6 }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = "file";
        r0.put(r2, r1);	 Catch:{ Throwable -> 0x00d6 }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x00d6 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d6 }
        r2.<init>();	 Catch:{ Throwable -> 0x00d6 }
        r3 = r6.O00000o;	 Catch:{ Throwable -> 0x00d6 }
        r2.append(r3);	 Catch:{ Throwable -> 0x00d6 }
        r3 = ".dt";
        r2.append(r3);	 Catch:{ Throwable -> 0x00d6 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00d6 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00d6 }
        r1.delete();	 Catch:{ Throwable -> 0x00d6 }
        r2 = 0;
        r3 = new java.io.OutputStreamWriter;	 Catch:{ IOException -> 0x00b8 }
        r4 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00b8 }
        r5 = 1;
        r4.<init>(r1, r5);	 Catch:{ IOException -> 0x00b8 }
        r1 = "utf-8";
        r3.<init>(r4, r1);	 Catch:{ IOException -> 0x00b8 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
        r3.write(r0);	 Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
        if (r3 == 0) goto L_0x00e1;
    L_0x00a7:
        r3.close();	 Catch:{ IOException -> 0x00ab }
        goto L_0x00e1;
    L_0x00ab:
        r0 = move-exception;
    L_0x00ac:
        r0.printStackTrace();	 Catch:{ Throwable -> 0x00d6 }
        goto L_0x00e1;
    L_0x00b0:
        r0 = move-exception;
        r2 = r3;
        goto L_0x00cb;
    L_0x00b3:
        r0 = move-exception;
        r2 = r3;
        goto L_0x00b9;
    L_0x00b6:
        r0 = move-exception;
        goto L_0x00cb;
    L_0x00b8:
        r0 = move-exception;
    L_0x00b9:
        r1 = "UpdateItem";
        r3 = "saveJSONObjectToFile";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r1, r3);	 Catch:{ all -> 0x00b6 }
        r0.printStackTrace();	 Catch:{ all -> 0x00b6 }
        if (r2 == 0) goto L_0x00e1;
    L_0x00c5:
        r2.close();	 Catch:{ IOException -> 0x00c9 }
        goto L_0x00e1;
    L_0x00c9:
        r0 = move-exception;
        goto L_0x00ac;
    L_0x00cb:
        if (r2 == 0) goto L_0x00d5;
    L_0x00cd:
        r2.close();	 Catch:{ IOException -> 0x00d1 }
        goto L_0x00d5;
    L_0x00d1:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Throwable -> 0x00d6 }
    L_0x00d5:
        throw r0;	 Catch:{ Throwable -> 0x00d6 }
    L_0x00d6:
        r0 = move-exception;
        r1 = "UpdateItem";
        r2 = "saveJSONObjectToFile parseJson";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r0, r1, r2);
        r0.printStackTrace();
    L_0x00e1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00Oo00.O00000o0():void");
    }
}
