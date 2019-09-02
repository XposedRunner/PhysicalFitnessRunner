package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.location.Address.Builder;
import com.baidu.location.g.j;
import java.util.ArrayList;
import java.util.List;

public final class BDLocation implements Parcelable {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
    public static final Creator<BDLocation> CREATOR = new a();
    public static final int GPS_ACCURACY_BAD = 3;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_MID = 2;
    public static final int GPS_ACCURACY_UNKNOWN = 0;
    public static final int GPS_RECTIFY_INDOOR = 1;
    public static final int GPS_RECTIFY_NONE = 0;
    public static final int GPS_RECTIFY_OUTDOOR = 2;
    public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
    public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
    public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
    public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
    public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
    public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
    public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
    public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
    public static final int INDOOR_NETWORK_STATE_HIGH = 2;
    public static final int INDOOR_NETWORK_STATE_LOW = 0;
    public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerCheckKeyError = 505;
    public static final int TypeServerDecryptError = 162;
    public static final int TypeServerError = 167;
    public static final int USER_INDDOR_TRUE = 1;
    public static final int USER_INDOOR_FALSE = 0;
    public static final int USER_INDOOR_UNKNOW = -1;
    private int A;
    private String B;
    private int C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private String I;
    private String J;
    private String K;
    private List<Poi> L;
    private String M;
    private String N;
    private Bundle O;
    private int P;
    private int Q;
    private int a;
    private String b;
    private double c;
    private double d;
    private boolean e;
    private double f;
    private boolean g;
    private float h;
    private boolean i;
    private float j;
    private boolean k;
    private int l;
    private float m;
    private String n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private Address u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private int z;

    public BDLocation() {
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = new Bundle();
        this.P = 0;
        this.Q = 0;
    }

    private BDLocation(Parcel parcel) {
        this.a = 0;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = new Bundle();
        this.P = 0;
        this.Q = 0;
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.f = parcel.readDouble();
        this.h = parcel.readFloat();
        this.j = parcel.readFloat();
        this.l = parcel.readInt();
        this.m = parcel.readFloat();
        this.v = parcel.readString();
        this.z = parcel.readInt();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.B = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        String readString8 = parcel.readString();
        this.u = new Builder().country(readString7).countryCode(readString8).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).adcode(parcel.readString()).build();
        boolean[] zArr = new boolean[7];
        this.C = parcel.readInt();
        this.D = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.A = parcel.readInt();
        this.M = parcel.readString();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.P = parcel.readInt();
        this.N = parcel.readString();
        this.Q = parcel.readInt();
        try {
            parcel.readBooleanArray(zArr);
            this.e = zArr[0];
            this.g = zArr[1];
            this.i = zArr[2];
            this.k = zArr[3];
            this.o = zArr[4];
            this.t = zArr[5];
            this.y = zArr[6];
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, Poi.class.getClassLoader());
        if (arrayList.size() == 0) {
            this.L = null;
        } else {
            this.L = arrayList;
        }
        this.O = parcel.readBundle();
    }

    /* synthetic */ BDLocation(Parcel parcel, a aVar) {
        this(parcel);
    }

    public BDLocation(BDLocation bDLocation) {
        int i = 0;
        this.a = 0;
        List list = null;
        this.b = null;
        this.c = Double.MIN_VALUE;
        this.d = Double.MIN_VALUE;
        this.e = false;
        this.f = Double.MIN_VALUE;
        this.g = false;
        this.h = 0.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = false;
        this.l = -1;
        this.m = -1.0f;
        this.n = null;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = new Builder().build();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 0;
        this.A = 1;
        this.B = null;
        this.D = "";
        this.E = -1;
        this.F = 0;
        this.G = 2;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = new Bundle();
        this.P = 0;
        this.Q = 0;
        this.a = bDLocation.a;
        this.b = bDLocation.b;
        this.c = bDLocation.c;
        this.d = bDLocation.d;
        this.e = bDLocation.e;
        this.f = bDLocation.f;
        this.g = bDLocation.g;
        this.h = bDLocation.h;
        this.i = bDLocation.i;
        this.j = bDLocation.j;
        this.k = bDLocation.k;
        this.l = bDLocation.l;
        this.m = bDLocation.m;
        this.n = bDLocation.n;
        this.o = bDLocation.o;
        this.p = bDLocation.p;
        this.t = bDLocation.t;
        this.u = new Builder().country(bDLocation.u.country).countryCode(bDLocation.u.countryCode).province(bDLocation.u.province).city(bDLocation.u.city).cityCode(bDLocation.u.cityCode).district(bDLocation.u.district).street(bDLocation.u.street).streetNumber(bDLocation.u.streetNumber).adcode(bDLocation.u.adcode).build();
        this.v = bDLocation.v;
        this.w = bDLocation.w;
        this.x = bDLocation.x;
        this.A = bDLocation.A;
        this.z = bDLocation.z;
        this.y = bDLocation.y;
        this.B = bDLocation.B;
        this.C = bDLocation.C;
        this.D = bDLocation.D;
        this.q = bDLocation.q;
        this.r = bDLocation.r;
        this.s = bDLocation.s;
        this.E = bDLocation.E;
        this.F = bDLocation.F;
        this.G = bDLocation.F;
        this.H = bDLocation.H;
        this.I = bDLocation.I;
        this.J = bDLocation.J;
        this.K = bDLocation.K;
        this.P = bDLocation.P;
        this.N = bDLocation.N;
        if (bDLocation.L != null) {
            list = new ArrayList();
            while (i < bDLocation.L.size()) {
                Poi poi = (Poi) bDLocation.L.get(i);
                list.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
                i++;
            }
        }
        this.L = list;
        this.M = bDLocation.M;
        this.O = bDLocation.O;
        this.Q = bDLocation.Q;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:12:0x0110=Splitter:B:12:0x0110, B:156:0x0362=Splitter:B:156:0x0362, B:241:0x0537=Splitter:B:241:0x0537, B:17:0x0129=Splitter:B:17:0x0129, B:236:0x051e=Splitter:B:236:0x051e} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:156:0x0362=Splitter:B:156:0x0362, B:241:0x0537=Splitter:B:241:0x0537, B:17:0x0129=Splitter:B:17:0x0129} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0133 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x012d A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0129 */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0126 A:{Catch:{ Exception -> 0x0129, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0118 A:{Catch:{ Exception -> 0x0129, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x012d A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0133 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0110 */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x053f A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x053b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:241:0x0537 */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x036b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03ab A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03c6 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03e5 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0400 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x041b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0436 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0460 A:{SYNTHETIC, Splitter:B:197:0x0460} */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x051b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0511 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0534 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0526 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x053b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x053f A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x036b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03ab A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03c6 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03e5 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0400 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x041b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0436 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0460 A:{SYNTHETIC, Splitter:B:197:0x0460} */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0511 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x051b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0526 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0534 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x053f A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x053b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x036b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03ab A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03c6 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03e5 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0400 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x041b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0436 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0460 A:{SYNTHETIC, Splitter:B:197:0x0460} */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x051b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0511 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0534 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0526 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x053b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x053f A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x036b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03ab A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03c6 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03e5 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0400 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x041b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0436 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0460 A:{SYNTHETIC, Splitter:B:197:0x0460} */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0511 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x051b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0526 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0534 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x053f A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x053b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x059d A:{Splitter:B:5:0x0080, ExcHandler: Error (r0_11 'e' java.lang.Error)} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x036b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03ab A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03c6 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03e5 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0400 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x041b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0436 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0460 A:{SYNTHETIC, Splitter:B:197:0x0460} */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x051b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0511 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0534 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0526 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x053b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x053f A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x036b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x03ab A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03c6 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03e5 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0400 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x041b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0436 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0460 A:{SYNTHETIC, Splitter:B:197:0x0460} */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0511 A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x051b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0526 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0534 A:{Catch:{ Exception -> 0x0537, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x053f A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x053b A:{Catch:{ Exception -> 0x05a3, Error -> 0x059d }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:56:0x0214, code skipped:
            r8 = 0;
            r7 = null;
     */
    /* JADX WARNING: Missing block: B:97:0x02cb, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:98:0x02cc, code skipped:
            r4 = r0;
            r11 = r8;
            r9 = null;
            r10 = null;
     */
    /* JADX WARNING: Missing block: B:103:0x02d8, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:104:0x02d9, code skipped:
            r4 = r0;
            r11 = r8;
            r12 = r9;
            r9 = null;
            r10 = null;
     */
    /* JADX WARNING: Missing block: B:117:0x02f8, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:118:0x02f9, code skipped:
            r4 = r0;
            r12 = r9;
            r14 = r10;
            r15 = r11;
            r9 = null;
            r10 = null;
            r13 = null;
            r16 = null;
     */
    /* JADX WARNING: Missing block: B:125:0x030c, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:126:0x030d, code skipped:
            r4 = r0;
            r14 = r10;
            r15 = r11;
            r16 = r12;
            r10 = null;
            r13 = null;
     */
    /* JADX WARNING: Missing block: B:133:0x0320, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:134:0x0321, code skipped:
            r4 = r0;
            r14 = r10;
            r15 = r11;
            r16 = r12;
            r10 = null;
     */
    /* JADX WARNING: Missing block: B:140:0x032f, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:141:0x0330, code skipped:
            r4 = r0;
            r15 = r11;
            r16 = r12;
            r11 = r8;
            r12 = r9;
            r9 = r14;
            r14 = r10;
            r10 = null;
     */
    /* JADX WARNING: Missing block: B:147:0x0342, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:148:0x0343, code skipped:
            r4 = r0;
            r16 = r12;
            r12 = r9;
            r9 = r14;
            r14 = r10;
            r10 = r15;
            r15 = r11;
     */
    /* JADX WARNING: Missing block: B:151:0x0357, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:152:0x0358, code skipped:
            r4 = r0;
            r9 = null;
            r10 = null;
            r11 = null;
     */
    /* JADX WARNING: Missing block: B:224:0x04fe, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:227:?, code skipped:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:228:0x0504, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:231:?, code skipped:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:256:0x059d, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:257:0x059e, code skipped:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:258:0x05a3, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:259:0x05a4, code skipped:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:260:0x05a8, code skipped:
            r1.a = 0;
            r1.o = false;
     */
    public BDLocation(java.lang.String r20) {
        /*
        r19 = this;
        r1 = r19;
        r2 = r20;
        r19.<init>();
        r3 = 0;
        r1.a = r3;
        r4 = 0;
        r1.b = r4;
        r5 = 1;
        r1.c = r5;
        r1.d = r5;
        r1.e = r3;
        r1.f = r5;
        r1.g = r3;
        r5 = 0;
        r1.h = r5;
        r1.i = r3;
        r1.j = r5;
        r1.k = r3;
        r5 = -1;
        r1.l = r5;
        r6 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r1.m = r6;
        r1.n = r4;
        r1.o = r3;
        r1.p = r4;
        r1.q = r4;
        r1.r = r4;
        r1.s = r4;
        r1.t = r3;
        r6 = new com.baidu.location.Address$Builder;
        r6.<init>();
        r6 = r6.build();
        r1.u = r6;
        r1.v = r4;
        r1.w = r4;
        r1.x = r4;
        r1.y = r3;
        r1.z = r3;
        r6 = 1;
        r1.A = r6;
        r1.B = r4;
        r7 = "";
        r1.D = r7;
        r1.E = r5;
        r1.F = r3;
        r5 = 2;
        r1.G = r5;
        r1.H = r3;
        r1.I = r4;
        r1.J = r4;
        r1.K = r4;
        r1.L = r4;
        r1.M = r4;
        r1.N = r4;
        r7 = new android.os.Bundle;
        r7.<init>();
        r1.O = r7;
        r1.P = r3;
        r1.Q = r3;
        if (r2 == 0) goto L_0x05ac;
    L_0x0077:
        r7 = "";
        r7 = r2.equals(r7);
        if (r7 == 0) goto L_0x0080;
    L_0x007f:
        return;
    L_0x0080:
        r7 = new org.json.JSONObject;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7.<init>(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r2 = "result";
        r2 = r7.getJSONObject(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r8 = "error";
        r8 = r2.getString(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r8 = java.lang.Integer.parseInt(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setLocType(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r9 = "time";
        r2 = r2.getString(r9);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setTime(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r2 = 61;
        if (r8 != r2) goto L_0x0136;
    L_0x00a5:
        r2 = "content";
        r2 = r7.getJSONObject(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = "point";
        r4 = r2.getJSONObject(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r5 = "y";
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = java.lang.Double.parseDouble(r5);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setLatitude(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r5 = "x";
        r4 = r4.getString(r5);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = java.lang.Double.parseDouble(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setLongitude(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = "radius";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = java.lang.Float.parseFloat(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setRadius(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = "s";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = java.lang.Float.parseFloat(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setSpeed(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = "d";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = java.lang.Float.parseFloat(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setDirection(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = "n";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setSatelliteNumber(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = "h";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x0110;
    L_0x0107:
        r4 = "h";
        r4 = r2.getDouble(r4);	 Catch:{ Exception -> 0x0110, Error -> 0x059d }
        r1.setAltitude(r4);	 Catch:{ Exception -> 0x0110, Error -> 0x059d }
    L_0x0110:
        r4 = "in_cn";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x0129, Error -> 0x059d }
        if (r4 == 0) goto L_0x0126;
    L_0x0118:
        r4 = "in_cn";
        r2 = r2.getString(r4);	 Catch:{ Exception -> 0x0129, Error -> 0x059d }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ Exception -> 0x0129, Error -> 0x059d }
        r1.setLocationWhere(r2);	 Catch:{ Exception -> 0x0129, Error -> 0x059d }
        goto L_0x0129;
    L_0x0126:
        r1.setLocationWhere(r6);	 Catch:{ Exception -> 0x0129, Error -> 0x059d }
    L_0x0129:
        r2 = r1.A;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r2 != 0) goto L_0x0133;
    L_0x012d:
        r2 = "wgs84";
    L_0x012f:
        r1.setCoorType(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        return;
    L_0x0133:
        r2 = "gcj02";
        goto L_0x012f;
    L_0x0136:
        r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
        if (r8 != r2) goto L_0x0543;
    L_0x013a:
        r2 = "content";
        r2 = r7.getJSONObject(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = "point";
        r7 = r2.getJSONObject(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r8 = "y";
        r8 = r7.getString(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r8 = java.lang.Double.parseDouble(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setLatitude(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r8 = "x";
        r7 = r7.getString(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = java.lang.Double.parseDouble(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setLongitude(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = "radius";
        r7 = r2.getString(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = java.lang.Float.parseFloat(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setRadius(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = "sema";
        r7 = r2.has(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r7 == 0) goto L_0x0204;
    L_0x0175:
        r7 = "sema";
        r7 = r2.getJSONObject(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r8 = "aptag";
        r8 = r7.has(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r8 == 0) goto L_0x0195;
    L_0x0183:
        r8 = "aptag";
        r8 = r7.getString(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r9 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r9 != 0) goto L_0x0192;
    L_0x018f:
        r1.q = r8;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        goto L_0x0195;
    L_0x0192:
        r8 = "";
        goto L_0x018f;
    L_0x0195:
        r8 = "aptagd";
        r8 = r7.has(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r8 == 0) goto L_0x01d8;
    L_0x019d:
        r8 = "aptagd";
        r8 = r7.getJSONObject(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r9 = "pois";
        r8 = r8.getJSONArray(r9);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r9 = new java.util.ArrayList;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r9.<init>();	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r10 = r3;
    L_0x01af:
        r11 = r8.length();	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r10 >= r11) goto L_0x01d6;
    L_0x01b5:
        r11 = r8.getJSONObject(r10);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r12 = "pname";
        r12 = r11.getString(r12);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r13 = "pid";
        r13 = r11.getString(r13);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r14 = "pr";
        r14 = r11.getDouble(r14);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r11 = new com.baidu.location.Poi;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r11.<init>(r13, r12, r14);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r9.add(r11);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r10 = r10 + 1;
        goto L_0x01af;
    L_0x01d6:
        r1.L = r9;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x01d8:
        r8 = "poiregion";
        r8 = r7.has(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r8 == 0) goto L_0x01ee;
    L_0x01e0:
        r8 = "poiregion";
        r8 = r7.getString(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r9 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r9 != 0) goto L_0x01ee;
    L_0x01ec:
        r1.r = r8;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x01ee:
        r8 = "regular";
        r8 = r7.has(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r8 == 0) goto L_0x0204;
    L_0x01f6:
        r8 = "regular";
        r7 = r7.getString(r8);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r8 != 0) goto L_0x0204;
    L_0x0202:
        r1.s = r7;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x0204:
        r7 = "addr";
        r7 = r2.has(r7);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r7 == 0) goto L_0x039d;
    L_0x020c:
        r7 = "addr";
        r7 = r2.getJSONObject(r7);	 Catch:{ Exception -> 0x0214, Error -> 0x059d }
        r8 = r6;
        goto L_0x0216;
    L_0x0214:
        r8 = r3;
        r7 = r4;
    L_0x0216:
        if (r7 == 0) goto L_0x02b3;
    L_0x0218:
        r9 = "";
        r10 = "";
        r11 = "";
        r12 = "";
        r13 = "";
        r14 = "";
        r15 = "";
        r16 = "";
        r17 = "";
        r4 = "city";
        r4 = r7.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x0238;
    L_0x0232:
        r4 = "city";
        r12 = r7.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x0238:
        r4 = "city_code";
        r4 = r7.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x0246;
    L_0x0240:
        r4 = "city_code";
        r13 = r7.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x0246:
        r4 = "country";
        r4 = r7.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x0254;
    L_0x024e:
        r4 = "country";
        r9 = r7.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x0254:
        r4 = "country_code";
        r4 = r7.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x0262;
    L_0x025c:
        r4 = "country_code";
        r10 = r7.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x0262:
        r4 = "province";
        r4 = r7.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x0270;
    L_0x026a:
        r4 = "province";
        r11 = r7.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x0270:
        r4 = "district";
        r4 = r7.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x027e;
    L_0x0278:
        r4 = "district";
        r14 = r7.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x027e:
        r4 = "street";
        r4 = r7.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x028c;
    L_0x0286:
        r4 = "street";
        r15 = r7.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x028c:
        r4 = "street_number";
        r4 = r7.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x029a;
    L_0x0294:
        r4 = "street_number";
        r16 = r7.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x029a:
        r4 = "adcode";
        r4 = r7.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x02ad;
    L_0x02a2:
        r4 = "adcode";
        r4 = r7.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r5 = r4;
        r4 = r16;
        goto L_0x0369;
    L_0x02ad:
        r4 = r16;
        r5 = r17;
        goto L_0x0369;
    L_0x02b3:
        r4 = "addr";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x0357, Error -> 0x059d }
        r7 = ",";
        r4 = r4.split(r7);	 Catch:{ Exception -> 0x0357, Error -> 0x059d }
        r7 = r4.length;	 Catch:{ Exception -> 0x0357, Error -> 0x059d }
        if (r7 <= 0) goto L_0x02c5;
    L_0x02c2:
        r8 = r4[r3];	 Catch:{ Exception -> 0x0357, Error -> 0x059d }
        goto L_0x02c6;
    L_0x02c5:
        r8 = 0;
    L_0x02c6:
        if (r7 <= r6) goto L_0x02d2;
    L_0x02c8:
        r9 = r4[r6];	 Catch:{ Exception -> 0x02cb, Error -> 0x059d }
        goto L_0x02d3;
    L_0x02cb:
        r0 = move-exception;
        r4 = r0;
        r11 = r8;
        r9 = 0;
        r10 = 0;
        goto L_0x035c;
    L_0x02d2:
        r9 = 0;
    L_0x02d3:
        if (r7 <= r5) goto L_0x02e0;
    L_0x02d5:
        r10 = r4[r5];	 Catch:{ Exception -> 0x02d8, Error -> 0x059d }
        goto L_0x02e1;
    L_0x02d8:
        r0 = move-exception;
        r4 = r0;
        r11 = r8;
        r12 = r9;
        r9 = 0;
        r10 = 0;
        goto L_0x035d;
    L_0x02e0:
        r10 = 0;
    L_0x02e1:
        r11 = 3;
        if (r7 <= r11) goto L_0x02f1;
    L_0x02e4:
        r11 = r4[r11];	 Catch:{ Exception -> 0x02e7, Error -> 0x059d }
        goto L_0x02f2;
    L_0x02e7:
        r0 = move-exception;
        r4 = r0;
        r11 = r8;
        r12 = r9;
        r14 = r10;
        r9 = 0;
        r10 = 0;
        r13 = 0;
        goto L_0x035f;
    L_0x02f1:
        r11 = 0;
    L_0x02f2:
        r12 = 4;
        if (r7 <= r12) goto L_0x0305;
    L_0x02f5:
        r12 = r4[r12];	 Catch:{ Exception -> 0x02f8, Error -> 0x059d }
        goto L_0x0306;
    L_0x02f8:
        r0 = move-exception;
        r4 = r0;
        r12 = r9;
        r14 = r10;
        r15 = r11;
        r9 = 0;
        r10 = 0;
        r13 = 0;
        r16 = 0;
    L_0x0302:
        r11 = r8;
        goto L_0x0362;
    L_0x0305:
        r12 = 0;
    L_0x0306:
        r13 = 5;
        if (r7 <= r13) goto L_0x0319;
    L_0x0309:
        r13 = r4[r13];	 Catch:{ Exception -> 0x030c, Error -> 0x059d }
        goto L_0x031a;
    L_0x030c:
        r0 = move-exception;
        r4 = r0;
        r14 = r10;
        r15 = r11;
        r16 = r12;
        r10 = 0;
        r13 = 0;
    L_0x0314:
        r11 = r8;
        r12 = r9;
        r9 = 0;
        goto L_0x0362;
    L_0x0319:
        r13 = 0;
    L_0x031a:
        r14 = 6;
        if (r7 <= r14) goto L_0x0328;
    L_0x031d:
        r14 = r4[r14];	 Catch:{ Exception -> 0x0320, Error -> 0x059d }
        goto L_0x0329;
    L_0x0320:
        r0 = move-exception;
        r4 = r0;
        r14 = r10;
        r15 = r11;
        r16 = r12;
        r10 = 0;
        goto L_0x0314;
    L_0x0328:
        r14 = 0;
    L_0x0329:
        r15 = 7;
        if (r7 <= r15) goto L_0x033a;
    L_0x032c:
        r15 = r4[r15];	 Catch:{ Exception -> 0x032f, Error -> 0x059d }
        goto L_0x033b;
    L_0x032f:
        r0 = move-exception;
        r4 = r0;
        r15 = r11;
        r16 = r12;
        r11 = r8;
        r12 = r9;
        r9 = r14;
        r14 = r10;
        r10 = 0;
        goto L_0x0362;
    L_0x033a:
        r15 = 0;
    L_0x033b:
        r5 = 8;
        if (r7 <= r5) goto L_0x034c;
    L_0x033f:
        r4 = r4[r5];	 Catch:{ Exception -> 0x0342, Error -> 0x059d }
        goto L_0x034d;
    L_0x0342:
        r0 = move-exception;
        r4 = r0;
        r16 = r12;
        r12 = r9;
        r9 = r14;
        r14 = r10;
        r10 = r15;
        r15 = r11;
        goto L_0x0302;
    L_0x034c:
        r4 = 0;
    L_0x034d:
        r5 = r4;
        r4 = r12;
        r12 = r9;
        r9 = r14;
        r14 = r10;
        r10 = r15;
        r15 = r11;
        r11 = r8;
        r8 = r6;
        goto L_0x0369;
    L_0x0357:
        r0 = move-exception;
        r4 = r0;
        r9 = 0;
        r10 = 0;
        r11 = 0;
    L_0x035c:
        r12 = 0;
    L_0x035d:
        r13 = 0;
        r14 = 0;
    L_0x035f:
        r15 = 0;
        r16 = 0;
    L_0x0362:
        r4.printStackTrace();	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r8 = r3;
        r4 = r16;
        r5 = 0;
    L_0x0369:
        if (r8 == 0) goto L_0x03a3;
    L_0x036b:
        r7 = new com.baidu.location.Address$Builder;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7.<init>();	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = r7.country(r9);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = r7.countryCode(r10);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = r7.province(r11);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = r7.city(r12);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = r7.cityCode(r13);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = r7.district(r14);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r7 = r7.street(r15);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = r7.streetNumber(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = r4.adcode(r5);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = r4.build();	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.u = r4;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.o = r6;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        goto L_0x03a3;
    L_0x039d:
        r1.o = r3;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = 0;
        r1.setAddrStr(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x03a3:
        r4 = "floor";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x03be;
    L_0x03ab:
        r4 = "floor";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.v = r4;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = r1.v;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x03be;
    L_0x03bb:
        r4 = 0;
        r1.v = r4;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x03be:
        r4 = "indoor";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x03dd;
    L_0x03c6:
        r4 = "indoor";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r5 != 0) goto L_0x03dd;
    L_0x03d2:
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = r4.intValue();	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setUserIndoorState(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x03dd:
        r4 = "loctp";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x03f8;
    L_0x03e5:
        r4 = "loctp";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.B = r4;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = r1.B;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x03f8;
    L_0x03f5:
        r4 = 0;
        r1.B = r4;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x03f8:
        r4 = "bldgid";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x0413;
    L_0x0400:
        r4 = "bldgid";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.w = r4;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = r1.w;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x0413;
    L_0x0410:
        r4 = 0;
        r1.w = r4;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x0413:
        r4 = "bldg";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x042e;
    L_0x041b:
        r4 = "bldg";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.x = r4;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = r1.x;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x042e;
    L_0x042b:
        r4 = 0;
        r1.x = r4;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x042e:
        r4 = "ibav";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x0458;
    L_0x0436:
        r4 = "ibav";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r5 == 0) goto L_0x0445;
    L_0x0442:
        r1.z = r3;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        goto L_0x0458;
    L_0x0445:
        r5 = "0";
        r5 = r4.equals(r5);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r5 == 0) goto L_0x044e;
    L_0x044d:
        goto L_0x0442;
    L_0x044e:
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = r4.intValue();	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.z = r4;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x0458:
        r4 = "indoorflags";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x0509;
    L_0x0460:
        r4 = "indoorflags";
        r4 = r2.getJSONObject(r4);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        r5 = "area";
        r5 = r4.has(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        if (r5 == 0) goto L_0x0488;
    L_0x046e:
        r5 = "area";
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        r5 = r5.intValue();	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        if (r5 != 0) goto L_0x0483;
    L_0x047e:
        r7 = 2;
        r1.setIndoorLocationSurpport(r7);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        goto L_0x0488;
    L_0x0483:
        if (r5 != r6) goto L_0x0488;
    L_0x0485:
        r1.setIndoorLocationSurpport(r6);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
    L_0x0488:
        r5 = "support";
        r5 = r4.has(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        if (r5 == 0) goto L_0x04a1;
    L_0x0490:
        r5 = "support";
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        r5 = r5.intValue();	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        r1.setIndoorLocationSource(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
    L_0x04a1:
        r5 = "inbldg";
        r5 = r4.has(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        if (r5 == 0) goto L_0x04b1;
    L_0x04a9:
        r5 = "inbldg";
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        r1.I = r5;	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
    L_0x04b1:
        r5 = "inbldgid";
        r5 = r4.has(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        if (r5 == 0) goto L_0x04c1;
    L_0x04b9:
        r5 = "inbldgid";
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        r1.J = r5;	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
    L_0x04c1:
        r5 = "polygon";
        r5 = r4.has(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        if (r5 == 0) goto L_0x04d2;
    L_0x04c9:
        r5 = "polygon";
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        r1.setIndoorSurpportPolygon(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
    L_0x04d2:
        r5 = "ret_fields";
        r5 = r4.has(r5);	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        if (r5 == 0) goto L_0x0509;
    L_0x04da:
        r5 = "ret_fields";
        r4 = r4.getString(r5);	 Catch:{ Exception -> 0x04fe, Error -> 0x059d }
        r5 = "\\|";
        r4 = r4.split(r5);	 Catch:{ Exception -> 0x04fe, Error -> 0x059d }
        r5 = r4.length;	 Catch:{ Exception -> 0x04fe, Error -> 0x059d }
        r7 = r3;
    L_0x04e8:
        if (r7 >= r5) goto L_0x0509;
    L_0x04ea:
        r8 = r4[r7];	 Catch:{ Exception -> 0x04fe, Error -> 0x059d }
        r9 = "=";
        r8 = r8.split(r9);	 Catch:{ Exception -> 0x04fe, Error -> 0x059d }
        r9 = r8[r3];	 Catch:{ Exception -> 0x04fe, Error -> 0x059d }
        r8 = r8[r6];	 Catch:{ Exception -> 0x04fe, Error -> 0x059d }
        r10 = r1.O;	 Catch:{ Exception -> 0x04fe, Error -> 0x059d }
        r10.putString(r9, r8);	 Catch:{ Exception -> 0x04fe, Error -> 0x059d }
        r7 = r7 + 1;
        goto L_0x04e8;
    L_0x04fe:
        r0 = move-exception;
        r4 = r0;
        r4.printStackTrace();	 Catch:{ Exception -> 0x0504, Error -> 0x059d }
        goto L_0x0509;
    L_0x0504:
        r0 = move-exception;
        r4 = r0;
        r4.printStackTrace();	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x0509:
        r4 = "gpscs";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r4 == 0) goto L_0x051b;
    L_0x0511:
        r4 = "gpscs";
        r4 = r2.getInt(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setGpsCheckStatus(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        goto L_0x051e;
    L_0x051b:
        r1.setGpsCheckStatus(r3);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
    L_0x051e:
        r4 = "in_cn";
        r4 = r2.has(r4);	 Catch:{ Exception -> 0x0537, Error -> 0x059d }
        if (r4 == 0) goto L_0x0534;
    L_0x0526:
        r4 = "in_cn";
        r2 = r2.getString(r4);	 Catch:{ Exception -> 0x0537, Error -> 0x059d }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ Exception -> 0x0537, Error -> 0x059d }
        r1.setLocationWhere(r2);	 Catch:{ Exception -> 0x0537, Error -> 0x059d }
        goto L_0x0537;
    L_0x0534:
        r1.setLocationWhere(r6);	 Catch:{ Exception -> 0x0537, Error -> 0x059d }
    L_0x0537:
        r2 = r1.A;	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        if (r2 != 0) goto L_0x053f;
    L_0x053b:
        r2 = "wgs84";
        goto L_0x012f;
    L_0x053f:
        r2 = "gcj02";
        goto L_0x012f;
    L_0x0543:
        r2 = 66;
        if (r8 == r2) goto L_0x0555;
    L_0x0547:
        r2 = 68;
        if (r8 != r2) goto L_0x054c;
    L_0x054b:
        goto L_0x0555;
    L_0x054c:
        r2 = 167; // 0xa7 float:2.34E-43 double:8.25E-322;
        if (r8 != r2) goto L_0x05ac;
    L_0x0550:
        r2 = 2;
        r1.setLocationWhere(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        return;
    L_0x0555:
        r2 = "content";
        r2 = r7.getJSONObject(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = "point";
        r4 = r2.getJSONObject(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r5 = "y";
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r5 = java.lang.Double.parseDouble(r5);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setLatitude(r5);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r5 = "x";
        r4 = r4.getString(r5);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = java.lang.Double.parseDouble(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setLongitude(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = "radius";
        r4 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = java.lang.Float.parseFloat(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.setRadius(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r4 = "isCellChanged";
        r2 = r2.getString(r4);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r2 = java.lang.Boolean.parseBoolean(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r1.a(r2);	 Catch:{ Exception -> 0x05a3, Error -> 0x059d }
        r2 = "gcj02";
        goto L_0x012f;
    L_0x059d:
        r0 = move-exception;
        r2 = r0;
        r2.printStackTrace();
        goto L_0x05a8;
    L_0x05a3:
        r0 = move-exception;
        r2 = r0;
        r2.printStackTrace();
    L_0x05a8:
        r1.a = r3;
        r1.o = r3;
    L_0x05ac:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.BDLocation.<init>(java.lang.String):void");
    }

    private void a(Boolean bool) {
        this.t = bool.booleanValue();
    }

    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.u.adcode;
    }

    public String getAddrStr() {
        return this.u.address;
    }

    public Address getAddress() {
        return this.u;
    }

    public double getAltitude() {
        return this.f;
    }

    public String getBuildingID() {
        return this.w;
    }

    public String getBuildingName() {
        return this.x;
    }

    public String getCity() {
        return this.u.city;
    }

    public String getCityCode() {
        return this.u.cityCode;
    }

    public String getCoorType() {
        return this.n;
    }

    public String getCountry() {
        return this.u.country;
    }

    public String getCountryCode() {
        return this.u.countryCode;
    }

    @Deprecated
    public float getDerect() {
        return this.m;
    }

    public float getDirection() {
        return this.m;
    }

    public String getDistrict() {
        return this.u.district;
    }

    public Location getExtraLocation(String str) {
        if (this.O != null) {
            Parcelable parcelable = this.O.getParcelable(str);
            if (parcelable instanceof Location) {
                return (Location) parcelable;
            }
        }
        return null;
    }

    public String getFloor() {
        return this.v;
    }

    public double[] getFusionLocInfo(String str) {
        return this.O.getDoubleArray(str);
    }

    public int getGpsAccuracyStatus() {
        return this.P;
    }

    public int getGpsCheckStatus() {
        return this.Q;
    }

    public int getIndoorLocationSource() {
        return this.H;
    }

    public int getIndoorLocationSurpport() {
        return this.F;
    }

    public String getIndoorLocationSurpportBuidlingID() {
        return this.J;
    }

    public String getIndoorLocationSurpportBuidlingName() {
        return this.I;
    }

    public int getIndoorNetworkState() {
        return this.G;
    }

    public String getIndoorSurpportPolygon() {
        return this.K;
    }

    public double getLatitude() {
        return this.c;
    }

    public int getLocType() {
        return this.a;
    }

    public String getLocTypeDescription() {
        return this.M;
    }

    public String getLocationDescribe() {
        return this.q;
    }

    public String getLocationID() {
        return this.N;
    }

    public int getLocationWhere() {
        return this.A;
    }

    public double getLongitude() {
        return this.d;
    }

    public String getNetworkLocationType() {
        return this.B;
    }

    public int getOperators() {
        return this.C;
    }

    public List<Poi> getPoiList() {
        return this.L;
    }

    public String getProvince() {
        return this.u.province;
    }

    public float getRadius() {
        return this.j;
    }

    public String getRetFields(String str) {
        return this.O.getString(str);
    }

    public int getSatelliteNumber() {
        this.k = true;
        return this.l;
    }

    @Deprecated
    public String getSemaAptag() {
        return this.q;
    }

    public float getSpeed() {
        return this.h;
    }

    public String getStreet() {
        return this.u.street;
    }

    public String getStreetNumber() {
        return this.u.streetNumber;
    }

    public String getTime() {
        return this.b;
    }

    public int getUserIndoorState() {
        return this.E;
    }

    public boolean hasAddr() {
        return this.o;
    }

    public boolean hasAltitude() {
        return this.e;
    }

    public boolean hasRadius() {
        return this.i;
    }

    public boolean hasSateNumber() {
        return this.k;
    }

    public boolean hasSpeed() {
        return this.g;
    }

    public boolean isCellChangeFlag() {
        return this.t;
    }

    public boolean isIndoorLocMode() {
        return this.y;
    }

    public int isParkAvailable() {
        return this.z;
    }

    public void setAddr(Address address) {
        if (address != null) {
            this.u = address;
            this.o = true;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x000a in {2, 4, 5} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public void setAddrStr(java.lang.String r1) {
        /*
        r0 = this;
        r0.p = r1;
        if (r1 != 0) goto L_0x0008;
        r1 = 0;
        r0.o = r1;
        return;
        r1 = 1;
        goto L_0x0005;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.BDLocation.setAddrStr(java.lang.String):void");
    }

    public void setAltitude(double d) {
        if (d < 9999.0d) {
            this.f = d;
            this.e = true;
        }
    }

    public void setBuildingID(String str) {
        this.w = str;
    }

    public void setBuildingName(String str) {
        this.x = str;
    }

    public void setCoorType(String str) {
        this.n = str;
    }

    public void setDirection(float f) {
        this.m = f;
    }

    public void setExtraLocation(String str, Location location) {
        if (this.O == null) {
            this.O = new Bundle();
        }
        this.O.putParcelable(str, location);
    }

    public void setFloor(String str) {
        this.v = str;
    }

    public void setFusionLocInfo(String str, double[] dArr) {
        if (this.O == null) {
            this.O = new Bundle();
        }
        this.O.putDoubleArray(str, dArr);
    }

    public void setGpsAccuracyStatus(int i) {
        this.P = i;
    }

    public void setGpsCheckStatus(int i) {
        this.Q = i;
    }

    public void setIndoorLocMode(boolean z) {
        this.y = z;
    }

    public void setIndoorLocationSource(int i) {
        this.H = i;
    }

    public void setIndoorLocationSurpport(int i) {
        this.F = i;
    }

    public void setIndoorNetworkState(int i) {
        this.G = i;
    }

    public void setIndoorSurpportPolygon(String str) {
        this.K = str;
    }

    public void setLatitude(double d) {
        this.c = d;
    }

    public void setLocType(int i) {
        String str;
        this.a = i;
        switch (i) {
            case 61:
                setLocTypeDescription("GPS location successful!");
                setUserIndoorState(0);
                return;
            case 62:
                str = "Location failed beacuse we can not get any loc information!";
                break;
            case 63:
            case 67:
                str = "Offline location failed, please check the net (wifi/cell)!";
                break;
            case 66:
                str = "Offline location successful!";
                break;
            case TypeNetWorkLocation /*161*/:
                str = "NetWork location successful!";
                break;
            case TypeServerDecryptError /*162*/:
                str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
                break;
            case TypeServerError /*167*/:
                str = "NetWork location failed because baidu location service can not caculate the location!";
                break;
            case 505:
                str = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
                break;
            default:
                str = "UnKnown!";
                break;
        }
        setLocTypeDescription(str);
    }

    public void setLocTypeDescription(String str) {
        this.M = str;
    }

    public void setLocationDescribe(String str) {
        this.q = str;
    }

    public void setLocationID(String str) {
        this.N = str;
    }

    public void setLocationWhere(int i) {
        this.A = i;
    }

    public void setLongitude(double d) {
        this.d = d;
    }

    public void setNetworkLocationType(String str) {
        this.B = str;
    }

    public void setOperators(int i) {
        this.C = i;
    }

    public void setParkAvailable(int i) {
        this.z = i;
    }

    public void setPoiList(List<Poi> list) {
        this.L = list;
    }

    public void setRadius(float f) {
        this.j = f;
        this.i = true;
    }

    public void setRetFields(String str, String str2) {
        if (this.O == null) {
            this.O = new Bundle();
        }
        this.O.putString(str, str2);
    }

    public void setSatelliteNumber(int i) {
        this.l = i;
    }

    public void setSpeed(float f) {
        this.h = f;
        this.g = true;
    }

    public void setTime(String str) {
        this.b = str;
        setLocationID(j.a(str));
    }

    public void setUserIndoorState(int i) {
        this.E = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeDouble(this.f);
        parcel.writeFloat(this.h);
        parcel.writeFloat(this.j);
        parcel.writeInt(this.l);
        parcel.writeFloat(this.m);
        parcel.writeString(this.v);
        parcel.writeInt(this.z);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.B);
        parcel.writeString(this.u.province);
        parcel.writeString(this.u.city);
        parcel.writeString(this.u.district);
        parcel.writeString(this.u.street);
        parcel.writeString(this.u.streetNumber);
        parcel.writeString(this.u.cityCode);
        parcel.writeString(this.u.address);
        parcel.writeString(this.u.country);
        parcel.writeString(this.u.countryCode);
        parcel.writeString(this.u.adcode);
        parcel.writeInt(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.A);
        parcel.writeString(this.M);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeInt(this.P);
        parcel.writeString(this.N);
        parcel.writeInt(this.Q);
        parcel.writeBooleanArray(new boolean[]{this.e, this.g, this.i, this.k, this.o, this.t, this.y});
        parcel.writeList(this.L);
        parcel.writeBundle(this.O);
    }
}
