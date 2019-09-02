package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.autonavi.ae.gmap.style.StyleElement;
import com.autonavi.ae.gmap.style.StyleItem;
import com.autonavi.amap.mapcore.Convert;
import com.autonavi.amap.mapcore.FileUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StyleParser */
public class OO0OO0o {
    private static final int[] O00000o = new int[]{1};
    List<OO0O0O> O000000o = null;
    private int O00000Oo = 0;
    private int O00000o0 = -1;

    public OO0OO0o(Context context) {
    }

    public static int O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int parseColor;
        try {
            if (!str.startsWith("#")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("#");
                stringBuilder.append(str);
                str = stringBuilder.toString();
            }
            parseColor = Color.parseColor(str);
        } catch (Throwable th) {
            th.printStackTrace();
            parseColor = 0;
        }
        return parseColor;
    }

    public static OO0O0OO O000000o(byte[] bArr) {
        OO0O0OO oo0o0oo;
        Throwable th;
        try {
            oo0o0oo = new OO0O0OO();
            try {
                byte[] bytes = "l".getBytes("utf-8");
                int length = bArr.length;
                int length2 = bytes.length;
                for (int i = 0; i < length; i++) {
                    int i2 = i % length2;
                    bArr[i] = (byte) (bytes[i2] ^ bArr[i]);
                }
                oo0o0oo.O000000o(Convert.getString(bArr, 0, 4));
                oo0o0oo.O00000Oo(Convert.getString(bArr, 4, 32));
                oo0o0oo.O00000o0(Convert.getString(bArr, 36, 10));
                oo0o0oo.O00000o(O000000o(Convert.getSubBytes(bArr, 78, length - 78), Convert.getSubBytes(bArr, 46, 16), Convert.getSubBytes(bArr, 62, 16)));
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return oo0o0oo;
            }
        } catch (Throwable th3) {
            th = th3;
            oo0o0oo = null;
            th.printStackTrace();
            return oo0o0oo;
        }
        return oo0o0oo;
    }

    private StyleElement O000000o(Map<Integer, StyleItem> map, int i, int i2, OO0O0O oo0o0o) {
        StyleItem styleItem = (StyleItem) map.get(Integer.valueOf(i));
        if (styleItem == null) {
            styleItem = new StyleItem(oo0o0o.O00000o0);
            styleItem.mainKey = oo0o0o.O000000o;
            styleItem.subKey = oo0o0o.O00000Oo;
            map.put(Integer.valueOf(i), styleItem);
        }
        StyleElement styleElement = styleItem.get(i2);
        if (styleElement != null) {
            return styleElement;
        }
        styleElement = new StyleElement();
        styleElement.styleElementType = i2;
        styleItem.put(i2, styleElement);
        return styleElement;
    }

    public static String O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return new String(instance.doFinal(bArr), "utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private List<OO0O0O> O000000o(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (OO0O0O oo0o0o : this.O000000o) {
            if (oo0o0o != null) {
                if (oo0o0o.O00000oO != null && oo0o0o.O00000oO.equals(str2)) {
                    arrayList.add(oo0o0o);
                } else if (oo0o0o.O00000oO != null && oo0o0o.O00000oO.equals(str) && oo0o0o.O00000oo != null && oo0o0o.O00000oo.contains(str2)) {
                    arrayList.add(oo0o0o);
                }
            }
        }
        return arrayList;
    }

    private void O000000o(OO0OOOO oo0oooo, byte[] bArr, boolean z) {
        OO0O0OO O000000o = O000000o(bArr);
        if (O000000o != null && O000000o.O000000o() != null) {
            try {
                JSONObject jSONObject = new JSONObject(O000000o.O000000o());
                if (jSONObject != null) {
                    JSONArray names = jSONObject.names();
                    for (int i = 0; i < names.length(); i++) {
                        String string = names.getString(i);
                        if (string == null || !string.trim().equals("sdkTextures")) {
                            if (string == null || !string.trim().equals("background")) {
                                JSONObject optJSONObject = jSONObject.optJSONObject(string);
                                if (optJSONObject != null) {
                                    O000000o(string, oo0oooo.O000000o(), optJSONObject, z);
                                }
                            } else {
                                string = jSONObject.optString("background");
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("#");
                                stringBuilder.append(string);
                                this.O00000Oo = O000000o(stringBuilder.toString());
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void O000000o(String str, String str2, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z) throws JSONException {
        if (jSONObject != null) {
            if (this.O000000o == null) {
                this.O000000o = O00000Oo();
            }
            List<OO0O0O> O000000o = O000000o(str, str2);
            for (OO0O0O oo0o0o : O000000o) {
                if (oo0o0o != null && oo0o0o.O00000o0 != NotificationManagerCompat.IMPORTANCE_UNSPECIFIED) {
                    int i = oo0o0o.O00000o;
                    if (jSONObject.optBoolean("visible", true)) {
                        if (!jSONObject.optBoolean("showIcon", true)) {
                            O000000o((Map) map, i, OO0O0o0.O000000o("textFillColor"), oo0o0o).textureId = -1;
                        }
                        if (!jSONObject.optBoolean("showLabel", true)) {
                            O000000o((Map) map, i, OO0O0o0.O000000o("textFillColor"), oo0o0o).opacity = 0.0f;
                            StyleElement O000000o2 = O000000o((Map) map, i, OO0O0o0.O000000o("textStrokeColor"), oo0o0o);
                            O000000o2.opacity = 0.0f;
                            O000000o2.visible = 0;
                            O000000o2.textureId = -1;
                        }
                        Map<Integer, StyleItem> map2 = map;
                        JSONObject jSONObject2 = jSONObject;
                        int i2 = i;
                        OO0O0O oo0o0o2 = oo0o0o;
                        O000000o(map2, jSONObject2, "color", "opacity", i2, oo0o0o2);
                        O000000o(map2, jSONObject2, "fillColor", "fillOpacity", i2, oo0o0o2);
                        O000000o(map2, jSONObject2, "strokeColor", "strokeOpacity", i2, oo0o0o2);
                        O000000o(map2, jSONObject2, "textFillColor", "textFillOpacity", i2, oo0o0o2);
                        O000000o(map2, jSONObject2, "textStrokeColor", "textStrokeOpacity", i2, oo0o0o2);
                        O000000o(map2, jSONObject2, "backgroundColor", "backgroundOpacity", i2, oo0o0o2);
                        if (z) {
                            O000000o((Map) map, jSONObject, "textureName", i, oo0o0o);
                        }
                    } else {
                        StyleElement O000000o3 = O000000o((Map) map, i, OO0O0o0.O000000o("visible"), oo0o0o);
                        O000000o3.textureId = -1;
                        O000000o3.visible = 0;
                    }
                } else {
                    return;
                }
            }
            O000000o.clear();
        }
    }

    private void O000000o(String str, Map<Integer, StyleItem> map, JSONObject jSONObject, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            JSONObject optJSONObject = jSONObject2.optJSONObject("subType");
            if (optJSONObject == null) {
                O000000o(str, str, (Map) map, jSONObject2, z);
            } else {
                JSONArray names = optJSONObject.names();
                for (int i = 0; i < names.length(); i++) {
                    String optString = names.optString(i);
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(optString);
                    if (optJSONObject2.has("detailedType")) {
                        jSONObject2 = optJSONObject2.optJSONObject("detailedType");
                        if (jSONObject2 != null) {
                            JSONArray names2 = jSONObject2.names();
                            for (int i2 = 0; i2 < names2.length(); i2++) {
                                String optString2 = names2.optString(i2);
                                JSONObject optJSONObject3 = jSONObject2.optJSONObject(optString2);
                                if (optJSONObject3 != null) {
                                    O000000o(str, optString2, (Map) map, optJSONObject3, z);
                                }
                            }
                        }
                    } else {
                        O000000o(str, optString, (Map) map, optJSONObject2, z);
                    }
                }
            }
        }
    }

    private void O000000o(Map<Integer, StyleItem> map, JSONObject jSONObject, int i, int i2, OO0O0O oo0o0o) throws JSONException {
        StyleElement O000000o = O000000o((Map) map, i, i2, oo0o0o);
        jSONObject = jSONObject.optJSONObject("stylers");
        if (jSONObject != null) {
            int O000000o2 = O000000o(jSONObject.optString("color"));
            if (O000000o2 != 0) {
                O000000o.value = O000000o2;
                O000000o.textureId = jSONObject.optInt("textureName", 0);
                O000000o.lineWidth = jSONObject.optInt("lineWidth", 0);
                if (i >= 30 && i <= 38) {
                    O000000o((Map) map, i, 4, oo0o0o).opacity = 0.1f;
                } else if (oo0o0o.O00000oO != null && oo0o0o.O00000oO.equals("water") && i2 == 3) {
                    O000000o((Map) map, i, 2, oo0o0o).value = O000000o2;
                }
            }
        }
    }

    private void O000000o(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, int i, OO0O0O oo0o0o) {
        try {
            int optInt = jSONObject.optInt(str, 0);
            if (optInt != 0) {
                O000000o((Map) map, i, OO0O0o0.O000000o(str), oo0o0o).textureId = optInt;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void O000000o(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String str2, int i, OO0O0O oo0o0o) {
        try {
            String optString = jSONObject.optString(str, null);
            float f = 1.0f;
            int i2 = 0;
            if (TextUtils.isEmpty(optString)) {
                f = (float) jSONObject.optDouble(str2, 1.0d);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("#");
                stringBuilder.append(optString);
                i2 = O000000o(stringBuilder.toString());
            }
            if (i2 != 0 || ((double) f) != 1.0d) {
                int O000000o = OO0O0o0.O000000o(str);
                StyleElement O000000o2 = O000000o((Map) map, i, O000000o, oo0o0o);
                O000000o2.value = i2;
                O000000o2.opacity = f;
                if (oo0o0o.O00000oo == null || !oo0o0o.O00000oo.equals("China")) {
                    if (oo0o0o.O00000oO != null && oo0o0o.O00000oO.equals("water") && O000000o == 3) {
                        StyleElement O000000o3 = O000000o((Map) map, i, 2, oo0o0o);
                        O000000o3.value = i2;
                        O000000o3.opacity = f;
                    }
                }
                O000000o((Map) map, i, O000000o, oo0o0o).opacity = 0.0f;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void O000000o(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String[] strArr, int i) throws JSONException {
        for (String str2 : strArr) {
            if (this.O000000o == null) {
                this.O000000o = O00000Oo();
            }
            for (OO0O0O oo0o0o : O000000o(str, str2)) {
                O000000o((Map) map, jSONObject, oo0o0o.O00000o, i, oo0o0o);
            }
        }
    }

    private void O000000o(JSONArray jSONArray, String str, String str2, String str3, List<OO0O0O> list) {
        JSONArray jSONArray2 = jSONArray;
        if (jSONArray2 != null) {
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                if (optJSONObject == null) {
                    List<OO0O0O> list2 = list;
                } else {
                    int[] iArr;
                    int optInt = optJSONObject.optInt("mainkey");
                    int[] iArr2 = new int[0];
                    JSONArray optJSONArray = optJSONObject.optJSONArray("subkey");
                    if (optJSONArray != null) {
                        int length2 = optJSONArray.length();
                        int[] iArr3 = new int[length2];
                        for (int i2 = 0; i2 < length2; i2++) {
                            iArr3[i2] = optJSONArray.optInt(i2);
                        }
                        iArr = iArr3;
                    } else {
                        iArr = iArr2;
                    }
                    list.add(new OO0O0O(optInt, iArr, str, str2, str3));
                }
            }
        }
    }

    private boolean O000000o(Map<Integer, StyleItem> map, byte[] bArr) {
        try {
            JSONArray jSONArray = new JSONArray(new String(bArr, HttpUtils.ENCODING_UTF_8));
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("featureType");
                    if (!TextUtils.isEmpty(optString)) {
                        if ("background".equals(optString)) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("stylers");
                            if (optJSONObject2 != null) {
                                int O000000o = O000000o(optJSONObject2.optString("color"));
                                if (O000000o != 0) {
                                    this.O00000Oo = O000000o;
                                }
                            }
                        } else {
                            String O00000Oo = oOo00.O00000Oo(optString);
                            if (O00000Oo != null) {
                                String[] O000000o2 = oOo00.O000000o(optString);
                                if (O000000o2 != null) {
                                    if (O000000o2.length != 0) {
                                        optString = optJSONObject.optString("elementType");
                                        if (!TextUtils.isEmpty(optString)) {
                                            int O000000o3 = OO0O0o0.O000000o(optString);
                                            if (O000000o3 != -1) {
                                                O000000o((Map) map, optJSONObject, O00000Oo, O000000o2, O000000o3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return true;
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private List<OO0O0O> O00000Oo() {
        this.O000000o = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray("[{\n\t\"regions\": {\n\t\t\"name\": \"区域面\",\n\t\t\"subType\": {\n\t\t\t\"land\": {\n\t\t\t\t\"name\": \"陆地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [1, 4, 5]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"green\": {\n\t\t\t\t\"name\": \"绿地\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30001,\n\t\t\t\t\t\"subkey\": [3, 7, 8, 9, 10, 12]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"edu\": {\n\t\t\t\t\"name\": \"教育体育\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [3, 31]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"public\": {\n\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [4, 12, 22, 32]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"traffic\": {\n\t\t\t\t\"name\": \"交通枢纽\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [6, 14, 40]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 30004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"scenicSpot\": {\n\t\t\t\t\"name\": \"景区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [5, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"culture\": {\n\t\t\t\t\"name\": \"文化\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [7, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"health\": {\n\t\t\t\t\"name\": \"医疗卫生\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [8, 36]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"sports\": {\n\t\t\t\t\"name\": \"运动场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [9, 10, 13, 19, 20, 21, 34, 37, 39]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"business\": {\n\t\t\t\t\"name\": \"商业场所\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [11, 23, 24, 25, 26, 27, 28, 29, 30, 38]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"parkingLot\": {\n\t\t\t\t\"name\": \"停车场\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30002,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁设施\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 30003\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"water\": {\n\t\t\"name\": \"水系\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 30001,\n\t\t\t\"subkey\": [2, 6, 11, 13]\n\t\t}, {\n\t\t\t\"mainkey\": 20014\n\t\t}, {\n\t\t\t\"mainkey\": 10002,\n\t\t\t\"subkey\": [13]\n\t\t}]\n\t},\n\t\"buildings\": {\n\t\t\"name\": \"建筑物\",\n\t\t\"styleMap\": [{\n\t\t\t\"mainkey\": 50001\n\t\t}, {\n\t\t\t\"mainkey\": 50002\n\t\t}, {\n\t\t\t\"mainkey\": 50003\n\t\t}, {\n\t\t\t\"mainkey\": 50004\n\t\t}, {\n\t\t\t\"mainkey\": 30002,\n\t\t\t\"subkey\": [2, 15, 16, 17, 18]\n\t\t}]\n\t},\n\t\"roads\": {\n\t\t\"name\": \"道路\",\n\t\t\"subType\": {\n\t\t\t\"highWay\": {\n\t\t\t\t\"name\": \"高速公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20001\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"ringRoad\": {\n\t\t\t\t\"name\": \"城市环线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20002\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"nationalRoad\": {\n\t\t\t\t\"name\": \"国道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20003\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincialRoad\": {\n\t\t\t\t\"name\": \"省道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"secondaryRoad\": {\n\t\t\t\t\"name\": \"二级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20007\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelThreeRoad\": {\n\t\t\t\t\"name\": \"三级公路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20008\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"levelFourRoad\": {\n\t\t\t\t\"name\": \"四级道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20009\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"roadsBeingBuilt\": {\n\t\t\t\t\"name\": \"在建道路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20018\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"railway\": {\n\t\t\t\t\"name\": \"铁路\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [1]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"highSpeedRailway\": {\n\t\t\t\t\"name\": \"高铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20010,\n\t\t\t\t\t\"subkey\": [2]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subway\": {\n\t\t\t\t\"name\": \"地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"subwayBeingBuilt\": {\n\t\t\t\t\"name\": \"在建地铁\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20015,\n\t\t\t\t\t\"subkey\": [1, 2]\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20019\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"overPass\": {\n\t\t\t\t\"name\": \"天桥\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20012\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"underPass\": {\n\t\t\t\t\"name\": \"地道\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20013\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"other\": {\n\t\t\t\t\"name\": \"其他线条\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20011\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20017\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20020\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20024\n\t\t\t\t}, {\n\t\t\t\t\t\"mainkey\": 20028\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"guideBoards\": {\n\t\t\t\t\"name\": \"道路路牌\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 40001\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"labels\": {\n\t\t\"name\": \"标注\",\n\t\t\"subType\": {\n\t\t\t\"pois\": {\n\t\t\t\t\"name\": \"兴趣点\",\n\t\t\t\t\"subType\": {\n\t\t\t\t\t\"hotel\": {\n\t\t\t\t\t\t\"name\": \"住宿\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 0,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [9, 133, 134, 135, 136, 155, 156, 157, 158, 159, 160, 161, 162, 186]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [31, 32, 33, 34, 35, 36, 37, 38, 39, 164, 165]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"restaurant\": {\n\t\t\t\t\t\t\"name\": \"餐饮\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 1,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [19, 20, 21, 22, 114, 115, 116, 117, 118, 119, 183, 187]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 166, 167, 168, 179, 180, 181, 203, 205, 206, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"shop\": {\n\t\t\t\t\t\t\"name\": \"购物\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 2,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [7, 8, 68, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 7, 8, 9, 10, 11, 12, 13, 175, 200, 201, 202, 204]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"scenicSpot\": {\n\t\t\t\t\t\t\"name\": \"风景名胜\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 3,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [4, 12, 14, 38, 69, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 120, 167, 171, 188, 189, 190, 191, 192]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10008\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 187, 188, 190, 192, 193, 194, 195, 196, 198, 216, 217, 218, 219, 220, 221, 223, 224, 225]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"traffic\": {\n\t\t\t\t\t\t\"name\": \"交通设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 4,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [23, 24, 25, 26, 31, 36, 148, 154, 168, 172, 175, 176, 177, 178]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [11, 16]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10009\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"bank\": {\n\t\t\t\t\t\t\"name\": \"金融保险\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 5,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 144, 145, 146, 147]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"edu\": {\n\t\t\t\t\t\t\"name\": \"科教文化\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 6,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [10, 11, 13, 35, 138, 139, 140, 141, 142, 143, 163, 164, 165, 166, 170]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [43, 44, 45, 46, 47, 176, 177]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"live\": {\n\t\t\t\t\t\t\"name\": \"生活服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 7,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [58, 63, 64, 65, 66, 67, 121, 122, 123]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [28, 29, 30]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"hospital\": {\n\t\t\t\t\t\t\"name\": \"医疗保健\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 8,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [32, 33, 57, 70, 131, 132, 169, 193, 206, 207, 208, 209, 210]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [170, 209]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pe\": {\n\t\t\t\t\t\t\"name\": \"休闲体育\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 9,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [15, 16, 17, 37, 60, 61, 62, 73, 124, 125, 126, 127, 128, 129, 130, 180, 181, 182, 184, 185, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [169, 171, 172, 173, 174, 178, 197, 207]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"public\": {\n\t\t\t\t\t\t\"name\": \"公共设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 10,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [59, 173, 215]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"buidling\": {\n\t\t\t\t\t\t\"name\": \"商务住宅\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 11,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [5, 6, 74, 75, 76, 77, 78, 79, 80, 81, 179]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [189, 191]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"gov\": {\n\t\t\t\t\t\t\"name\": \"政府机构及社会团体\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 12,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [3, 34, 43, 137]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"moto\": {\n\t\t\t\t\t\t\"name\": \"摩托车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 13,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [113]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"vehicle\": {\n\t\t\t\t\t\t\"name\": \"汽车服务\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 14,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [39, 40, 41, 71, 72, 151, 152, 153]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [40, 41, 42, 182, 183, 184, 185, 186]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"pass\": {\n\t\t\t\t\t\t\"name\": \"通行设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 15,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [27, 28, 149, 150, 174]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [21]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"subway\": {\n\t\t\t\t\t\t\"name\": \"地铁站\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 16,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10005\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10006\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"roadFacilities\": {\n\t\t\t\t\t\t\"name\": \"道路附属设施\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 17,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [2, 29, 30]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10017\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"address\": {\n\t\t\t\t\t\t\"name\": \"地名\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 18,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [18]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [10, 12, 14, 15, 23, 36]\n\t\t\t\t\t\t}]\n\t\t\t\t\t},\n\t\t\t\t\t\"other\": {\n\t\t\t\t\t\t\"name\": \"其他\",\n\t\t\t\t\t\t\"isDetailedType\": true,\n\t\t\t\t\t\t\"detailedCode\": 19,\n\t\t\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\t\t\"mainkey\": 10001,\n\t\t\t\t\t\t\t\"subkey\": [1, 211, 212]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\t\t\"subkey\": [28]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10007,\n\t\t\t\t\t\t\t\"subkey\": [208, 210, 211, 212, 213, 214]\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10010\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10011\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10012\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10013\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10014\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10015\n\t\t\t\t\t\t}, {\n\t\t\t\t\t\t\t\"mainkey\": 10016\n\t\t\t\t\t\t}]\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t},\n\t\t\t\"aois\": {\n\t\t\t\t\"name\": \"区域标注\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10004\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"continent\": {\n\t\t\t\t\"name\": \"大洲\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [20]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"country\": {\n\t\t\t\t\"name\": \"国家\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [18, 19, 29]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"province\": {\n\t\t\t\t\"name\": \"省/直辖市/自治区/特别行政区\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [22, 26, 33]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"city\": {\n\t\t\t\t\"name\": \"城市\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [1, 2, 3, 4, 5, 7, 24, 25, 27, 30, 31, 32, 34, 35]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"district\": {\n\t\t\t\t\"name\": \"区县\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [6, 8, 37]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"town\": {\n\t\t\t\t\"name\": \"乡镇\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"village\": {\n\t\t\t\t\"name\": \"村庄\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 10002,\n\t\t\t\t\t\"subkey\": [17]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t},\n\t\"borders\": {\n\t\t\"name\": \"行政区边界\",\n\t\t\"subType\": {\n\t\t\t\"China\": {\n\t\t\t\t\"name\": \"中国国界\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [1, 2, 9]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"foreign\": {\n\t\t\t\t\"name\": \"外国国界/停火线/主张线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [3, 4, 8, 10, 11]\n\t\t\t\t}]\n\t\t\t},\n\t\t\t\"provincial\": {\n\t\t\t\t\"name\": \"省界线\",\n\t\t\t\t\"styleMap\": [{\n\t\t\t\t\t\"mainkey\": 20016,\n\t\t\t\t\t\"subkey\": [5, 6, 7, 12]\n\t\t\t\t}]\n\t\t\t}\n\t\t}\n\t}\n}]");
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    int i = 0;
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return this.O000000o;
                    }
                    JSONArray names = optJSONObject.names();
                    int length = names.length();
                    int i2 = 0;
                    while (i2 < length) {
                        String optString = names.optString(i2);
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(optString);
                        if (optJSONObject2 != null) {
                            String optString2 = optJSONObject2.optString("name");
                            if (optJSONObject2.has("styleMap")) {
                                O000000o(optJSONObject2.optJSONArray("styleMap"), optString, null, optString2, this.O000000o);
                            } else if (optJSONObject2.has("subType")) {
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("subType");
                                if (optJSONObject3 != null) {
                                    JSONArray names2 = optJSONObject3.names();
                                    int length2 = names2.length();
                                    int i3 = i;
                                    while (i3 < length2) {
                                        int i4;
                                        int i5;
                                        JSONArray jSONArray2;
                                        String optString3 = names2.optString(i3);
                                        optJSONObject2 = optJSONObject3.optJSONObject(optString3);
                                        if (optJSONObject2 == null) {
                                            i4 = i3;
                                            i5 = length2;
                                            jSONArray2 = names2;
                                        } else {
                                            String optString4 = optJSONObject2.optString("name");
                                            StringBuilder stringBuilder;
                                            String str;
                                            String str2;
                                            if (optJSONObject2.has("styleMap")) {
                                                JSONArray optJSONArray = optJSONObject2.optJSONArray("styleMap");
                                                stringBuilder = new StringBuilder();
                                                stringBuilder.append(optString2);
                                                str = optString3;
                                                stringBuilder.append("-");
                                                stringBuilder.append(optString4);
                                                String stringBuilder2 = stringBuilder.toString();
                                                i4 = i3;
                                                i5 = length2;
                                                str2 = stringBuilder2;
                                                jSONArray2 = names2;
                                                O000000o(optJSONArray, optString, str, str2, this.O000000o);
                                            } else {
                                                String str3 = optString3;
                                                i4 = i3;
                                                i5 = length2;
                                                jSONArray2 = names2;
                                                if (optJSONObject2.has("subType")) {
                                                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("subType");
                                                    if (optJSONObject4 != null) {
                                                        JSONArray names3 = optJSONObject4.names();
                                                        i3 = names3.length();
                                                        int i6 = 0;
                                                        while (i6 < i3) {
                                                            int i7;
                                                            JSONArray jSONArray3;
                                                            JSONObject jSONObject;
                                                            String optString5 = names3.optString(i6);
                                                            int i8 = i6;
                                                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject(optString5);
                                                            if (optJSONObject5 == null) {
                                                                str = optString4;
                                                                i7 = i3;
                                                                jSONArray3 = names3;
                                                            } else {
                                                                i7 = i3;
                                                                String optString6 = optJSONObject5.optString("name");
                                                                jSONArray3 = names3;
                                                                if (optJSONObject5.has("styleMap")) {
                                                                    JSONArray optJSONArray2 = optJSONObject5.optJSONArray("styleMap");
                                                                    StringBuilder stringBuilder3 = new StringBuilder();
                                                                    stringBuilder3.append(str3);
                                                                    jSONObject = optJSONObject4;
                                                                    stringBuilder3.append("-");
                                                                    stringBuilder3.append(optString5);
                                                                    str2 = stringBuilder3.toString();
                                                                    stringBuilder = new StringBuilder();
                                                                    stringBuilder.append(optString2);
                                                                    stringBuilder.append("-");
                                                                    stringBuilder.append(optString4);
                                                                    stringBuilder.append("-");
                                                                    stringBuilder.append(optString6);
                                                                    str = optString4;
                                                                    O000000o(optJSONArray2, optString, str2, stringBuilder.toString(), this.O000000o);
                                                                    i6 = i8 + 1;
                                                                    optString4 = str;
                                                                    i3 = i7;
                                                                    names3 = jSONArray3;
                                                                    optJSONObject4 = jSONObject;
                                                                } else {
                                                                    str = optString4;
                                                                }
                                                            }
                                                            jSONObject = optJSONObject4;
                                                            i6 = i8 + 1;
                                                            optString4 = str;
                                                            i3 = i7;
                                                            names3 = jSONArray3;
                                                            optJSONObject4 = jSONObject;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        i3 = i4 + 1;
                                        names2 = jSONArray2;
                                        length2 = i5;
                                    }
                                }
                            }
                            this.O000000o.add(new OO0O0O(20021, O00000o, "roads", "trafficRoadBackgroundColor", null));
                        }
                        i2++;
                        i = 0;
                    }
                    return this.O000000o;
                }
            }
            return this.O000000o;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int O000000o() {
        return this.O00000Oo;
    }

    public OO0OOOO O000000o(String str, boolean z) {
        return (str == null || "".equals(str)) ? null : O00000Oo(str, z);
    }

    public OO0OOOO O000000o(byte[] bArr, boolean z) {
        return (bArr == null || bArr.length == 0) ? null : O00000Oo(bArr, z);
    }

    public void O000000o(int i) {
        this.O00000o0 = i;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(OO0OOOO oo0oooo) {
        if (this.O00000o0 != -1) {
            Map O000000o = oo0oooo.O000000o();
            for (OO0O0O oo0o0o : O000000o("roads", "trafficRoadBackgroundColor")) {
                O000000o(O000000o, oo0o0o.O00000o, OO0O0o0.O000000o("fillColor"), oo0o0o).value = this.O00000o0;
                O000000o(O000000o, oo0o0o.O00000o, OO0O0o0.O000000o("strokeColor"), oo0o0o).value = this.O00000o0;
            }
        }
    }

    public OO0OOOO O00000Oo(String str, boolean z) {
        try {
            return O00000Oo(FileUtil.readFileContents(str), z);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public OO0OOOO O00000Oo(byte[] bArr, boolean z) {
        OO0OOOO oo0oooo = new OO0OOOO();
        try {
            if (!O000000o(oo0oooo.O000000o(), bArr)) {
                O000000o(oo0oooo, bArr, z);
            }
            O000000o(oo0oooo);
            oo0oooo.O00000Oo();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return oo0oooo;
    }
}
