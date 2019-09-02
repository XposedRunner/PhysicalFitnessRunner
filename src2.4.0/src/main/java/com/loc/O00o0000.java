package com.loc;

import android.os.Bundle;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GeoFenceSearchResultParser */
public final class O00o0000 {
    private static long O000000o;

    public static int O000000o(String str, List<GeoFence> list, Bundle bundle) {
        int optInt;
        List<GeoFence> list2 = list;
        Bundle bundle2 = bundle;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 0;
            int optInt2 = jSONObject.optInt("status", 0);
            optInt = jSONObject.optInt("infocode", 0);
            if (optInt2 == 1) {
                JSONArray optJSONArray = jSONObject.optJSONArray("pois");
                if (optJSONArray != null) {
                    optInt2 = 0;
                    while (optInt2 < optJSONArray.length()) {
                        int i2;
                        GeoFence geoFence = new GeoFence();
                        PoiItem poiItem = new PoiItem();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(optInt2);
                        poiItem.setPoiId(jSONObject2.optString("id"));
                        poiItem.setPoiName(jSONObject2.optString("name"));
                        poiItem.setPoiType(jSONObject2.optString("type"));
                        poiItem.setTypeCode(jSONObject2.optString("typecode"));
                        poiItem.setAddress(jSONObject2.optString("address"));
                        String optString = jSONObject2.optString("location");
                        if (optString != null) {
                            String[] split = optString.split(",");
                            poiItem.setLongitude(Double.parseDouble(split[i]));
                            poiItem.setLatitude(Double.parseDouble(split[1]));
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            i2 = optInt;
                            DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                            arrayList2.add(dPoint);
                            arrayList.add(arrayList2);
                            geoFence.setPointList(arrayList);
                            geoFence.setCenter(dPoint);
                        } else {
                            i2 = optInt;
                        }
                        poiItem.setTel(jSONObject2.optString("tel"));
                        poiItem.setProvince(jSONObject2.optString("pname"));
                        poiItem.setCity(jSONObject2.optString("cityname"));
                        poiItem.setAdname(jSONObject2.optString("adname"));
                        geoFence.setPoiItem(poiItem);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(O000000o());
                        geoFence.setFenceId(stringBuilder.toString());
                        if (bundle2 != null) {
                            geoFence.setCustomId(bundle2.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
                            geoFence.setPendingIntentAction(bundle2.getString("pendingIntentAction"));
                            geoFence.setType(2);
                            geoFence.setRadius(bundle2.getFloat("fenceRadius"));
                            geoFence.setExpiration(bundle2.getLong("expiration"));
                            geoFence.setActivatesAction(bundle2.getInt("activatesAction", 1));
                        }
                        if (list2 != null) {
                            list2.add(geoFence);
                        }
                        optInt2++;
                        optInt = i2;
                        i = 0;
                    }
                }
            }
        } catch (Throwable unused) {
            optInt = 5;
        }
        return optInt;
    }

    public static synchronized long O000000o() {
        long O00000o0;
        synchronized (O00o0000.class) {
            O00000o0 = OO000OO.O00000o0();
            if (O00000o0 > O000000o) {
                O000000o = O00000o0;
            } else {
                O000000o++;
            }
            O00000o0 = O000000o;
        }
        return O00000o0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e9 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e7  */
    private java.util.List<com.amap.api.location.DPoint> O000000o(java.util.List<com.amap.api.location.DPoint> r31, float r32) {
        /*
        r30 = this;
        r0 = r30;
        r1 = r31;
        r2 = r32;
        if (r1 != 0) goto L_0x000a;
    L_0x0008:
        r1 = 0;
        return r1;
    L_0x000a:
        r3 = r31.size();
        r4 = 2;
        if (r3 > r4) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = 0;
        r5 = r1.get(r4);
        r5 = (com.amap.api.location.DPoint) r5;
        r6 = r31.size();
        r7 = 1;
        r6 = r6 - r7;
        r6 = r1.get(r6);
        r6 = (com.amap.api.location.DPoint) r6;
        r8 = 0;
        r13 = r4;
        r10 = r7;
        r11 = r8;
    L_0x002f:
        r14 = r31.size();
        r14 = r14 - r7;
        if (r10 >= r14) goto L_0x00f7;
    L_0x0036:
        r14 = r1.get(r10);
        r14 = (com.amap.api.location.DPoint) r14;
        r15 = r14.getLongitude();
        r17 = r5.getLongitude();
        r15 = r15 - r17;
        r17 = r14.getLatitude();
        r19 = r5.getLatitude();
        r17 = r17 - r19;
        r19 = r6.getLongitude();
        r21 = r5.getLongitude();
        r19 = r19 - r21;
        r21 = r6.getLatitude();
        r23 = r5.getLatitude();
        r21 = r21 - r23;
        r15 = r15 * r19;
        r17 = r17 * r21;
        r15 = r15 + r17;
        r17 = r19 * r19;
        r23 = r21 * r21;
        r17 = r17 + r23;
        r15 = r15 / r17;
        r17 = r5.getLongitude();
        r23 = r6.getLongitude();
        r25 = (r17 > r23 ? 1 : (r17 == r23 ? 0 : -1));
        if (r25 != 0) goto L_0x008d;
    L_0x007e:
        r17 = r5.getLatitude();
        r23 = r6.getLatitude();
        r25 = (r17 > r23 ? 1 : (r17 == r23 ? 0 : -1));
        if (r25 != 0) goto L_0x008d;
    L_0x008a:
        r17 = r7;
        goto L_0x008f;
    L_0x008d:
        r17 = r4;
    L_0x008f:
        r18 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1));
        if (r18 < 0) goto L_0x00bb;
    L_0x0093:
        if (r17 == 0) goto L_0x0096;
    L_0x0095:
        goto L_0x00bb;
    L_0x0096:
        r17 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r23 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1));
        if (r23 <= 0) goto L_0x00a5;
    L_0x009c:
        r15 = r6.getLongitude();
        r17 = r6.getLatitude();
        goto L_0x00c3;
    L_0x00a5:
        r17 = r5.getLongitude();
        r19 = r19 * r15;
        r17 = r17 + r19;
        r19 = r5.getLatitude();
        r15 = r15 * r21;
        r15 = r19 + r15;
        r26 = r5;
        r8 = r15;
        r4 = r17;
        goto L_0x00c8;
    L_0x00bb:
        r15 = r5.getLongitude();
        r17 = r5.getLatitude();
    L_0x00c3:
        r26 = r5;
        r4 = r15;
        r8 = r17;
    L_0x00c8:
        r15 = new com.amap.api.location.DPoint;
        r27 = r8;
        r7 = r14.getLatitude();
        r0 = r14.getLongitude();
        r15.<init>(r7, r0);
        r0 = new com.amap.api.location.DPoint;
        r7 = r27;
        r0.<init>(r7, r4);
        r0 = com.loc.OO000OO.O000000o(r15, r0);
        r0 = (double) r0;
        r4 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1));
        if (r4 <= 0) goto L_0x00e9;
    L_0x00e7:
        r11 = r0;
        r13 = r10;
    L_0x00e9:
        r10 = r10 + 1;
        r5 = r26;
        r0 = r30;
        r1 = r31;
        r4 = 0;
        r7 = 1;
        r8 = 0;
        goto L_0x002f;
    L_0x00f7:
        r26 = r5;
        r0 = (double) r2;
        r4 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r4 >= 0) goto L_0x0107;
    L_0x00fe:
        r5 = r26;
        r3.add(r5);
        r3.add(r6);
        return r3;
    L_0x0107:
        r0 = r13 + 1;
        r1 = r31;
        r4 = 0;
        r0 = r1.subList(r4, r0);
        r4 = r30;
        r0 = r4.O000000o(r0, r2);
        r5 = r31.size();
        r1 = r1.subList(r13, r5);
        r1 = r4.O000000o(r1, r2);
        r3.addAll(r0);
        r0 = r3.size();
        r2 = 1;
        r0 = r0 - r2;
        r3.remove(r0);
        r3.addAll(r1);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O00o0000.O000000o(java.util.List, float):java.util.List");
    }

    public static int O00000Oo(String str, List<GeoFence> list, Bundle bundle) {
        return O000000o(str, list, bundle);
    }

    public final int O00000o0(String str, List<GeoFence> list, Bundle bundle) {
        int optInt;
        List<GeoFence> list2 = list;
        Bundle bundle2 = bundle;
        try {
            long j;
            int i;
            String str2;
            JSONObject jSONObject = new JSONObject(str);
            int optInt2 = jSONObject.optInt("status", 0);
            optInt = jSONObject.optInt("infocode", 0);
            float f = 0.0f;
            String str3 = null;
            if (bundle2 != null) {
                str3 = bundle2.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string = bundle2.getString("pendingIntentAction");
                float f2 = bundle2.getFloat("fenceRadius");
                j = bundle2.getLong("expiration");
                i = bundle2.getInt("activatesAction", 1);
                float f3 = f2;
                str2 = string;
                f = f3;
            } else {
                i = 0;
                j = 0;
                str2 = null;
            }
            if (optInt2 == 1) {
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray != null) {
                    optInt2 = 0;
                    while (optInt2 < optJSONArray.length()) {
                        String[] split;
                        ArrayList arrayList;
                        String str4;
                        int i2;
                        float f4;
                        String str5;
                        String str6;
                        long j2;
                        Object obj;
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        GeoFence geoFence = new GeoFence();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(optInt2);
                        String optString = jSONObject2.optString("citycode");
                        String optString2 = jSONObject2.optString("adcode");
                        JSONArray jSONArray = optJSONArray;
                        String optString3 = jSONObject2.optString("name");
                        int i3 = optInt;
                        String string2 = jSONObject2.getString("center");
                        int i4 = optInt2;
                        DPoint dPoint = new DPoint();
                        if (string2 != null) {
                            split = string2.split(",");
                            arrayList = arrayList2;
                            str4 = optString;
                            dPoint.setLatitude(Double.parseDouble(split[1]));
                            dPoint.setLongitude(Double.parseDouble(split[0]));
                            geoFence.setCenter(dPoint);
                        } else {
                            str4 = optString;
                            arrayList = arrayList2;
                        }
                        geoFence.setCustomId(str3);
                        geoFence.setPendingIntentAction(str2);
                        geoFence.setType(3);
                        geoFence.setRadius(f);
                        geoFence.setExpiration(j);
                        geoFence.setActivatesAction(i);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(O000000o());
                        geoFence.setFenceId(stringBuilder.toString());
                        String optString4 = jSONObject2.optString("polyline");
                        if (optString4 != null) {
                            ArrayList arrayList4;
                            split = optString4.split("\\|");
                            int length = split.length;
                            float f5 = Float.MAX_VALUE;
                            float f6 = Float.MIN_VALUE;
                            int i5 = 0;
                            while (i5 < length) {
                                int i6;
                                String str7;
                                i2 = i;
                                String str8 = split[i5];
                                String[] strArr = split;
                                DistrictItem districtItem = new DistrictItem();
                                f4 = f;
                                List arrayList5 = new ArrayList();
                                str5 = str2;
                                str2 = str4;
                                districtItem.setCitycode(str2);
                                districtItem.setAdcode(optString2);
                                districtItem.setDistrictName(optString3);
                                String str9 = optString3;
                                String[] split2 = str8.split(";");
                                String str10 = str2;
                                int i7 = 0;
                                while (i7 < split2.length) {
                                    String[] strArr2 = split2;
                                    split2 = split2[i7].split(",");
                                    i6 = length;
                                    if (split2.length > 1) {
                                        str6 = str3;
                                        str7 = optString2;
                                        j2 = j;
                                        arrayList5.add(new DPoint(Double.parseDouble(split2[1]), Double.parseDouble(split2[0])));
                                    } else {
                                        str6 = str3;
                                        str7 = optString2;
                                        j2 = j;
                                    }
                                    i7++;
                                    split2 = strArr2;
                                    length = i6;
                                    str3 = str6;
                                    optString2 = str7;
                                    j = j2;
                                }
                                i6 = length;
                                str6 = str3;
                                str7 = optString2;
                                j2 = j;
                                if (((float) arrayList5.size()) > 100.0f) {
                                    try {
                                        arrayList5 = O000000o(arrayList5, 100.0f);
                                    } catch (Throwable unused) {
                                        optInt = 5;
                                        return optInt;
                                    }
                                }
                                arrayList3.add(arrayList5);
                                districtItem.setPolyline(arrayList5);
                                arrayList4 = arrayList;
                                arrayList4.add(districtItem);
                                f6 = Math.max(f6, O000000o.O00000Oo(dPoint, arrayList5));
                                f5 = Math.min(f5, O000000o.O000000o(dPoint, arrayList5));
                                i5++;
                                arrayList = arrayList4;
                                i = i2;
                                split = strArr;
                                f = f4;
                                str2 = str5;
                                optString3 = str9;
                                str4 = str10;
                                length = i6;
                                str3 = str6;
                                optString2 = str7;
                                j = j2;
                            }
                            i2 = i;
                            f4 = f;
                            str5 = str2;
                            str6 = str3;
                            j2 = j;
                            arrayList4 = arrayList;
                            obj = null;
                            geoFence.setMaxDis2Center(f6);
                            geoFence.setMinDis2Center(f5);
                            geoFence.setDistrictItemList(arrayList4);
                            geoFence.setPointList(arrayList3);
                            list2 = list;
                            if (list2 != null) {
                                list2.add(geoFence);
                            }
                        } else {
                            i2 = i;
                            f4 = f;
                            str5 = str2;
                            str6 = str3;
                            j2 = j;
                            list2 = list;
                            obj = null;
                        }
                        optInt2 = i4 + 1;
                        Object obj2 = obj;
                        optJSONArray = jSONArray;
                        optInt = i3;
                        i = i2;
                        f = f4;
                        str2 = str5;
                        str3 = str6;
                        j = j2;
                    }
                }
            }
        } catch (Throwable unused2) {
            optInt = 5;
            return optInt;
        }
        return optInt;
    }
}
