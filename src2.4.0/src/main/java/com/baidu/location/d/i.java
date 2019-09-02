package com.baidu.location.d;

import android.database.Cursor;
import android.database.MatrixCursor;
import cn.jiguang.net.HttpUtils;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.e.h;
import com.baidu.location.g.b;
import com.baidu.location.g.j;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

final class i {
    private static final String[] a = new String[]{"CoorType", "Time", "LocType", "Longitude", "Latitude", "Radius", "NetworkLocationType", "Country", "CountryCode", "Province", "City", "CityCode", "District", "Street", "StreetNumber", "PoiList", "LocationDescription"};

    static final class a {
        final String a;
        final String b;
        final boolean c;
        final boolean d;
        final boolean e;
        final int f;
        final BDLocation g;
        final boolean h;
        final LinkedHashMap<String, Integer> i;

        public a(String[] strArr) {
            String str;
            String str2;
            boolean z;
            String[] strArr2 = strArr;
            boolean z2 = false;
            if (strArr2 == null) {
                this.a = null;
                this.b = null;
                this.i = null;
                this.c = false;
                this.d = false;
                this.e = false;
                this.g = null;
                this.h = false;
                this.f = 8;
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 8;
            String str3 = null;
            String str4 = str3;
            BDLocation bDLocation = str4;
            int i2 = 0;
            boolean z3 = i2;
            boolean z4 = z3;
            boolean z5 = z4;
            boolean z6 = z5;
            while (i2 < strArr2.length) {
                try {
                    int i3 = 3;
                    String[] split;
                    if (strArr2[i2].equals("-loc")) {
                        String str5 = strArr2[i2 + 1];
                        String str6;
                        try {
                            String[] split2 = str5.split(HttpUtils.PARAMETERS_SEPARATOR);
                            String str7 = str4;
                            int i4 = z2;
                            while (i4 < split2.length) {
                                try {
                                    if (split2[i4].startsWith("cl=")) {
                                        try {
                                            str6 = str5;
                                            str7 = split2[i4].substring(i3);
                                        } catch (Exception unused) {
                                            str = str5;
                                            str4 = str7;
                                            str2 = str;
                                            z = false;
                                            this.a = str2;
                                            this.b = str4;
                                            this.i = linkedHashMap;
                                            this.c = z;
                                            this.d = z4;
                                            this.e = z5;
                                            this.f = i;
                                            this.g = bDLocation;
                                            this.h = z6;
                                        }
                                    }
                                    if (split2[i4].startsWith("wf=")) {
                                        String[] split3 = split2[i4].substring(i3).split("\\|");
                                        int i5 = 0;
                                        while (i5 < split3.length) {
                                            str6 = str5;
                                            try {
                                                split = split3[i5].split(";");
                                                String[] strArr3 = split3;
                                                if (split.length >= 2) {
                                                    linkedHashMap.put(split[0], Integer.valueOf(split[1]));
                                                }
                                                i5++;
                                                str5 = str6;
                                                split3 = strArr3;
                                            } catch (Exception unused2) {
                                                str4 = str7;
                                                str = str6;
                                                str2 = str;
                                                z = false;
                                                this.a = str2;
                                                this.b = str4;
                                                this.i = linkedHashMap;
                                                this.c = z;
                                                this.d = z4;
                                                this.e = z5;
                                                this.f = i;
                                                this.g = bDLocation;
                                                this.h = z6;
                                            }
                                        }
                                    }
                                    str6 = str5;
                                    i4++;
                                    str5 = str6;
                                    i3 = 3;
                                } catch (Exception unused3) {
                                    str6 = str5;
                                    str4 = str7;
                                    str = str6;
                                    str2 = str;
                                    z = false;
                                    this.a = str2;
                                    this.b = str4;
                                    this.i = linkedHashMap;
                                    this.c = z;
                                    this.d = z4;
                                    this.e = z5;
                                    this.f = i;
                                    this.g = bDLocation;
                                    this.h = z6;
                                }
                            }
                            str4 = str7;
                            str3 = str5;
                        } catch (Exception unused4) {
                            str6 = str5;
                            str = str6;
                            str2 = str;
                            z = false;
                            this.a = str2;
                            this.b = str4;
                            this.i = linkedHashMap;
                            this.c = z;
                            this.d = z4;
                            this.e = z5;
                            this.f = i;
                            this.g = bDLocation;
                            this.h = z6;
                        }
                    } else if (strArr2[i2].equals("-com")) {
                        BDLocation bDLocation2;
                        split = strArr2[i2 + 1].split(";");
                        if (split.length > 0) {
                            bDLocation2 = new BDLocation();
                            try {
                                bDLocation2.setLatitude(Double.valueOf(split[0]).doubleValue());
                                bDLocation2.setLongitude(Double.valueOf(split[1]).doubleValue());
                                bDLocation2.setLocType(Integer.valueOf(split[2]).intValue());
                                bDLocation2.setNetworkLocationType(split[3]);
                            } catch (Exception unused5) {
                                bDLocation = bDLocation2;
                            }
                        } else {
                            bDLocation2 = bDLocation;
                        }
                        bDLocation = bDLocation2;
                    } else if (strArr2[i2].equals("-log")) {
                        if (strArr2[i2 + 1].equals("true")) {
                            z3 = true;
                        }
                    } else if (strArr2[i2].equals("-rgc")) {
                        if (strArr2[i2 + 1].equals("true")) {
                            z5 = true;
                        }
                    } else if (strArr2[i2].equals("-poi")) {
                        if (strArr2[i2 + 1].equals("true")) {
                            z4 = true;
                        }
                    } else if (strArr2[i2].equals("-minap")) {
                        try {
                            i = Integer.valueOf(strArr2[i2 + 1]).intValue();
                        } catch (Exception unused6) {
                        }
                    } else if (strArr2[i2].equals("-des") && strArr2[i2 + 1].equals("true")) {
                        z6 = true;
                    }
                    i2 += 2;
                    z2 = false;
                } catch (Exception unused7) {
                    str = str3;
                    str2 = str;
                    z = false;
                    this.a = str2;
                    this.b = str4;
                    this.i = linkedHashMap;
                    this.c = z;
                    this.d = z4;
                    this.e = z5;
                    this.f = i;
                    this.g = bDLocation;
                    this.h = z6;
                }
            }
            str2 = !z3 ? null : str3;
            z = true;
            this.a = str2;
            this.b = str4;
            this.i = linkedHashMap;
            this.c = z;
            this.d = z4;
            this.e = z5;
            this.f = i;
            this.g = bDLocation;
            this.h = z6;
        }
    }

    static Cursor a(BDLocation bDLocation) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()));
        MatrixCursor matrixCursor = new MatrixCursor(a);
        Object[] objArr = new Object[a.length];
        objArr[matrixCursor.getColumnIndex("CoorType")] = CoordinateType.GCJ02;
        objArr[matrixCursor.getColumnIndex("Time")] = format;
        objArr[matrixCursor.getColumnIndex("LocType")] = Integer.valueOf(bDLocation.getLocType());
        objArr[matrixCursor.getColumnIndex("Longitude")] = Double.valueOf(bDLocation.getLongitude());
        objArr[matrixCursor.getColumnIndex("Latitude")] = Double.valueOf(bDLocation.getLatitude());
        objArr[matrixCursor.getColumnIndex("Radius")] = Float.valueOf(bDLocation.getRadius());
        objArr[matrixCursor.getColumnIndex("NetworkLocationType")] = bDLocation.getNetworkLocationType();
        Address address = bDLocation.getAddress();
        if (address != null) {
            str = address.country;
            str2 = address.countryCode;
            str3 = address.province;
            str4 = address.city;
            str5 = address.cityCode;
            str6 = address.district;
            str7 = address.street;
            format = address.streetNumber;
        } else {
            format = null;
            str = format;
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
        }
        objArr[matrixCursor.getColumnIndex("Country")] = str;
        objArr[matrixCursor.getColumnIndex("CountryCode")] = str2;
        objArr[matrixCursor.getColumnIndex("Province")] = str3;
        objArr[matrixCursor.getColumnIndex("City")] = str4;
        objArr[matrixCursor.getColumnIndex("CityCode")] = str5;
        objArr[matrixCursor.getColumnIndex("District")] = str6;
        objArr[matrixCursor.getColumnIndex("Street")] = str7;
        objArr[matrixCursor.getColumnIndex("StreetNumber")] = format;
        List poiList = bDLocation.getPoiList();
        if (poiList == null) {
            objArr[matrixCursor.getColumnIndex("PoiList")] = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < poiList.size(); i++) {
                Poi poi = (Poi) poiList.get(i);
                stringBuffer.append(poi.getId());
                stringBuffer.append(";");
                stringBuffer.append(poi.getName());
                stringBuffer.append(";");
                stringBuffer.append(poi.getRank());
                stringBuffer.append(";|");
            }
            objArr[matrixCursor.getColumnIndex("PoiList")] = stringBuffer.toString();
        }
        objArr[matrixCursor.getColumnIndex("LocationDescription")] = bDLocation.getLocationDescribe();
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }

    /* JADX WARNING: Missing block: B:96:0x01e0, code skipped:
            if (r9.size() == 0) goto L_0x01ea;
     */
    /* JADX WARNING: Missing block: B:98:0x01e8, code skipped:
            if (r9.size() == 0) goto L_0x01ea;
     */
    static com.baidu.location.BDLocation a(android.database.Cursor r24) {
        /*
        r1 = r24;
        r2 = new com.baidu.location.BDLocation;
        r2.<init>();
        if (r1 == 0) goto L_0x0225;
    L_0x0009:
        r3 = r24.getCount();
        if (r3 <= 0) goto L_0x0225;
    L_0x000f:
        r3 = r24.moveToFirst();
        if (r3 == 0) goto L_0x0225;
    L_0x0015:
        r3 = 0;
        r4 = "LocType";
        r4 = r1.getColumnIndex(r4);
        r6 = -1;
        if (r4 == r6) goto L_0x002a;
    L_0x001f:
        r4 = "LocType";
        r4 = r1.getColumnIndex(r4);
        r4 = r1.getInt(r4);
        goto L_0x002b;
    L_0x002a:
        r4 = 0;
    L_0x002b:
        r7 = "Latitude";
        r7 = r1.getColumnIndex(r7);
        r8 = 0;
        if (r7 == r6) goto L_0x0040;
    L_0x0035:
        r7 = "Latitude";
        r7 = r1.getColumnIndex(r7);
        r10 = r1.getDouble(r7);
        goto L_0x0041;
    L_0x0040:
        r10 = r8;
    L_0x0041:
        r7 = "Longitude";
        r7 = r1.getColumnIndex(r7);
        if (r7 == r6) goto L_0x0053;
    L_0x0049:
        r7 = "Longitude";
        r7 = r1.getColumnIndex(r7);
        r8 = r1.getDouble(r7);
    L_0x0053:
        r7 = "CoorType";
        r7 = r1.getColumnIndex(r7);
        if (r7 == r6) goto L_0x0066;
    L_0x005b:
        r7 = "CoorType";
        r7 = r1.getColumnIndex(r7);
        r7 = r1.getString(r7);
        goto L_0x0067;
    L_0x0066:
        r7 = 0;
    L_0x0067:
        r13 = "NetworkLocationType";
        r13 = r1.getColumnIndex(r13);
        if (r13 == r6) goto L_0x007a;
    L_0x006f:
        r13 = "NetworkLocationType";
        r13 = r1.getColumnIndex(r13);
        r13 = r1.getString(r13);
        goto L_0x007b;
    L_0x007a:
        r13 = 0;
    L_0x007b:
        r14 = "Radius";
        r14 = r1.getColumnIndex(r14);
        if (r14 == r6) goto L_0x008d;
    L_0x0083:
        r3 = "Radius";
        r3 = r1.getColumnIndex(r3);
        r3 = r1.getFloat(r3);
    L_0x008d:
        r14 = "Time";
        r14 = r1.getColumnIndex(r14);
        if (r14 == r6) goto L_0x00a0;
    L_0x0095:
        r14 = "Time";
        r14 = r1.getColumnIndex(r14);
        r14 = r1.getString(r14);
        goto L_0x00a1;
    L_0x00a0:
        r14 = 0;
    L_0x00a1:
        r15 = "Country";
        r15 = r1.getColumnIndex(r15);
        if (r15 == r6) goto L_0x00b4;
    L_0x00a9:
        r15 = "Country";
        r15 = r1.getColumnIndex(r15);
        r15 = r1.getString(r15);
        goto L_0x00b5;
    L_0x00b4:
        r15 = 0;
    L_0x00b5:
        r12 = "CountryCode";
        r12 = r1.getColumnIndex(r12);
        if (r12 == r6) goto L_0x00c8;
    L_0x00bd:
        r12 = "CountryCode";
        r12 = r1.getColumnIndex(r12);
        r12 = r1.getString(r12);
        goto L_0x00c9;
    L_0x00c8:
        r12 = 0;
    L_0x00c9:
        r5 = "Province";
        r5 = r1.getColumnIndex(r5);
        if (r5 == r6) goto L_0x00de;
    L_0x00d1:
        r5 = "Province";
        r5 = r1.getColumnIndex(r5);
        r5 = r1.getString(r5);
        r17 = r13;
        goto L_0x00e1;
    L_0x00de:
        r17 = r13;
        r5 = 0;
    L_0x00e1:
        r13 = "City";
        r13 = r1.getColumnIndex(r13);
        if (r13 == r6) goto L_0x00f6;
    L_0x00e9:
        r13 = "City";
        r13 = r1.getColumnIndex(r13);
        r13 = r1.getString(r13);
        r18 = r8;
        goto L_0x00f9;
    L_0x00f6:
        r18 = r8;
        r13 = 0;
    L_0x00f9:
        r8 = "CityCode";
        r8 = r1.getColumnIndex(r8);
        if (r8 == r6) goto L_0x010c;
    L_0x0101:
        r8 = "CityCode";
        r8 = r1.getColumnIndex(r8);
        r8 = r1.getString(r8);
        goto L_0x010d;
    L_0x010c:
        r8 = 0;
    L_0x010d:
        r9 = "District";
        r9 = r1.getColumnIndex(r9);
        if (r9 == r6) goto L_0x0122;
    L_0x0115:
        r9 = "District";
        r9 = r1.getColumnIndex(r9);
        r9 = r1.getString(r9);
        r20 = r10;
        goto L_0x0125;
    L_0x0122:
        r20 = r10;
        r9 = 0;
    L_0x0125:
        r10 = "Street";
        r10 = r1.getColumnIndex(r10);
        if (r10 == r6) goto L_0x0138;
    L_0x012d:
        r10 = "Street";
        r10 = r1.getColumnIndex(r10);
        r10 = r1.getString(r10);
        goto L_0x0139;
    L_0x0138:
        r10 = 0;
    L_0x0139:
        r11 = "StreetNumber";
        r11 = r1.getColumnIndex(r11);
        if (r11 == r6) goto L_0x014c;
    L_0x0141:
        r11 = "StreetNumber";
        r11 = r1.getColumnIndex(r11);
        r11 = r1.getString(r11);
        goto L_0x014d;
    L_0x014c:
        r11 = 0;
    L_0x014d:
        r6 = new com.baidu.location.Address$Builder;
        r6.<init>();
        r6 = r6.country(r15);
        r6 = r6.countryCode(r12);
        r5 = r6.province(r5);
        r5 = r5.city(r13);
        r5 = r5.cityCode(r8);
        r5 = r5.district(r9);
        r5 = r5.street(r10);
        r5 = r5.streetNumber(r11);
        r5 = r5.build();
        r6 = "PoiList";
        r6 = r1.getColumnIndex(r6);
        r8 = -1;
        if (r6 == r8) goto L_0x01ea;
    L_0x017f:
        r12 = new java.util.ArrayList;
        r12.<init>();
        r6 = "PoiList";
        r6 = r1.getColumnIndex(r6);
        r6 = r1.getString(r6);
        if (r6 == 0) goto L_0x01e3;
    L_0x0190:
        r8 = "\\|";
        r6 = r6.split(r8);	 Catch:{ Exception -> 0x01db, all -> 0x01d3 }
        r8 = 0;
    L_0x0197:
        r9 = r6.length;	 Catch:{ Exception -> 0x01db, all -> 0x01d3 }
        if (r8 >= r9) goto L_0x01e3;
    L_0x019a:
        r9 = r6[r8];	 Catch:{ Exception -> 0x01db, all -> 0x01d3 }
        r10 = ";";
        r9 = r9.split(r10);	 Catch:{ Exception -> 0x01db, all -> 0x01d3 }
        r10 = r9.length;	 Catch:{ Exception -> 0x01db, all -> 0x01d3 }
        r11 = 3;
        if (r10 < r11) goto L_0x01ce;
    L_0x01a6:
        r10 = new com.baidu.location.Poi;	 Catch:{ Exception -> 0x01db, all -> 0x01d3 }
        r11 = 0;
        r13 = r9[r11];	 Catch:{ Exception -> 0x01db, all -> 0x01d3 }
        r15 = 1;
        r15 = r9[r15];	 Catch:{ Exception -> 0x01db, all -> 0x01d3 }
        r16 = 2;
        r9 = r9[r16];	 Catch:{ Exception -> 0x01db, all -> 0x01d3 }
        r9 = java.lang.Double.valueOf(r9);	 Catch:{ Exception -> 0x01db, all -> 0x01d3 }
        r22 = r12;
        r11 = r9.doubleValue();	 Catch:{ Exception -> 0x01cb, all -> 0x01c7 }
        r10.<init>(r13, r15, r11);	 Catch:{ Exception -> 0x01cb, all -> 0x01c7 }
        r9 = r22;
        r9.add(r10);	 Catch:{ Exception -> 0x01dc, all -> 0x01c5 }
        goto L_0x01cf;
    L_0x01c5:
        r0 = move-exception;
        goto L_0x01d5;
    L_0x01c7:
        r0 = move-exception;
        r9 = r22;
        goto L_0x01d5;
    L_0x01cb:
        r9 = r22;
        goto L_0x01dc;
    L_0x01ce:
        r9 = r12;
    L_0x01cf:
        r8 = r8 + 1;
        r12 = r9;
        goto L_0x0197;
    L_0x01d3:
        r0 = move-exception;
        r9 = r12;
    L_0x01d5:
        r1 = r0;
        r2 = r9.size();
        throw r1;
    L_0x01db:
        r9 = r12;
    L_0x01dc:
        r6 = r9.size();
        if (r6 != 0) goto L_0x01eb;
    L_0x01e2:
        goto L_0x01ea;
    L_0x01e3:
        r9 = r12;
        r6 = r9.size();
        if (r6 != 0) goto L_0x01eb;
    L_0x01ea:
        r9 = 0;
    L_0x01eb:
        r6 = "LocationDescription";
        r6 = r1.getColumnIndex(r6);
        r8 = -1;
        if (r6 == r8) goto L_0x01ff;
    L_0x01f4:
        r6 = "LocationDescription";
        r6 = r1.getColumnIndex(r6);
        r12 = r1.getString(r6);
        goto L_0x0200;
    L_0x01ff:
        r12 = 0;
    L_0x0200:
        r2.setTime(r14);
        r2.setRadius(r3);
        r2.setLocType(r4);
        r2.setCoorType(r7);
        r10 = r20;
        r2.setLatitude(r10);
        r3 = r18;
        r2.setLongitude(r3);
        r13 = r17;
        r2.setNetworkLocationType(r13);
        r2.setAddr(r5);
        r2.setPoiList(r9);
        r2.setLocationDescribe(r12);
        return r2;
    L_0x0225:
        r1 = 67;
        r2.setLocType(r1);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.d.i.a(android.database.Cursor):com.baidu.location.BDLocation");
    }

    static String a(BDLocation bDLocation, int i) {
        String format;
        if (bDLocation == null || bDLocation.getLocType() == 67) {
            format = String.format(Locale.CHINA, "&ofl=%s|%d", new Object[]{"1", Integer.valueOf(i)});
        } else {
            StringBuilder stringBuilder;
            format = String.format(Locale.CHINA, "&ofl=%s|%d|%f|%f|%d", new Object[]{"1", Integer.valueOf(i), Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius())});
            if (bDLocation.getAddress() != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(format);
                stringBuilder.append("&ofaddr=");
                stringBuilder.append(bDLocation.getAddress().address);
                format = stringBuilder.toString();
            }
            if (bDLocation.getPoiList() != null && bDLocation.getPoiList().size() > 0) {
                Poi poi = (Poi) bDLocation.getPoiList().get(0);
                stringBuilder = new StringBuilder();
                stringBuilder.append(format);
                stringBuilder.append(String.format(Locale.US, "&ofpoi=%s|%s", new Object[]{poi.getId(), poi.getName()}));
                format = stringBuilder.toString();
            }
            if (b.d != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(format);
                stringBuilder2.append(String.format(Locale.US, "&pack=%s&sdk=%.3f", new Object[]{b.d, Float.valueOf(7.62f)}));
                return stringBuilder2.toString();
            }
        }
        return format;
    }

    static String a(BDLocation bDLocation, BDLocation bDLocation2, a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bDLocation2 == null ? "&ofcl=0" : String.format(Locale.US, "&ofcl=1|%f|%f|%d", new Object[]{Double.valueOf(bDLocation2.getLongitude()), Double.valueOf(bDLocation2.getLatitude()), Integer.valueOf((int) bDLocation2.getRadius())}));
        stringBuffer.append(bDLocation == null ? "&ofwf=0" : String.format(Locale.US, "&ofwf=1|%f|%f|%d", new Object[]{Double.valueOf(bDLocation.getLongitude()), Double.valueOf(bDLocation.getLatitude()), Integer.valueOf((int) bDLocation.getRadius())}));
        String str = (aVar == null || !aVar.e) ? "&rgcn=0" : "&rgcn=1";
        stringBuffer.append(str);
        str = (aVar == null || !aVar.d) ? "&poin=0" : "&poin=1";
        stringBuffer.append(str);
        str = (aVar == null || !aVar.h) ? "&desc=0" : "&desc=1";
        stringBuffer.append(str);
        if (aVar != null) {
            stringBuffer.append(String.format(Locale.US, "&aps=%d", new Object[]{Integer.valueOf(aVar.f)}));
        }
        return stringBuffer.toString();
    }

    static String[] a(com.baidu.location.e.a aVar, h hVar, BDLocation bDLocation, String str, boolean z, int i) {
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            stringBuffer.append(com.baidu.location.e.b.a().b(aVar));
        }
        if (hVar != null) {
            stringBuffer.append(hVar.a(30));
        }
        if (stringBuffer.length() > 0) {
            if (str != null) {
                stringBuffer.append(str);
            }
            arrayList.add("-loc");
            arrayList.add(stringBuffer.toString());
        }
        if (bDLocation != null) {
            String format = String.format(Locale.US, "%f;%f;%d;%s", new Object[]{Double.valueOf(bDLocation.getLatitude()), Double.valueOf(bDLocation.getLongitude()), Integer.valueOf(bDLocation.getLocType()), bDLocation.getNetworkLocationType()});
            arrayList.add("-com");
            arrayList.add(format);
        }
        if (z) {
            arrayList.add("-log");
            arrayList.add("true");
        }
        if (j.g.equals(MsgService.MSG_CHATTING_ACCOUNT_ALL)) {
            arrayList.add("-rgc");
            arrayList.add("true");
        }
        if (j.j) {
            arrayList.add("-poi");
            arrayList.add("true");
        }
        if (j.h) {
            arrayList.add("-des");
            arrayList.add("true");
        }
        arrayList.add("-minap");
        arrayList.add(Integer.toString(i));
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }
}
