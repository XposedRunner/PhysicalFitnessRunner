package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.loc.O0o0000;

public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Creator<AMapLocationClientOption> CREATOR = new Creator<AMapLocationClientOption>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AMapLocationClientOption[i];
        }
    };
    public static boolean OPEN_ALWAYS_SCAN_WIFI = true;
    public static long SCAN_WIFI_INTERVAL = 30000;
    static String a = "";
    private static AMapLocationProtocol j = AMapLocationProtocol.HTTP;
    private static boolean u = true;
    private long b;
    private long c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private AMapLocationMode i;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private long r;
    private long s;
    private GeoLanguage t;
    private float v;
    private AMapLocationPurpose w;

    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);
        
        private int a;

        private AMapLocationProtocol(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public enum AMapLocationPurpose {
        SignIn,
        Transport,
        Sport
    }

    public enum GeoLanguage {
        DEFAULT,
        ZH,
        EN
    }

    public AMapLocationClientOption() {
        this.b = 2000;
        this.c = (long) O0o0000.O00000oo;
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = AMapLocationMode.Hight_Accuracy;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = StatisticConfig.MIN_UPLOAD_INTERVAL;
        this.s = StatisticConfig.MIN_UPLOAD_INTERVAL;
        this.t = GeoLanguage.DEFAULT;
        this.v = 0.0f;
        this.w = null;
    }

    protected AMapLocationClientOption(Parcel parcel) {
        this.b = 2000;
        this.c = (long) O0o0000.O00000oo;
        boolean z = false;
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = AMapLocationMode.Hight_Accuracy;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = StatisticConfig.MIN_UPLOAD_INTERVAL;
        this.s = StatisticConfig.MIN_UPLOAD_INTERVAL;
        this.t = GeoLanguage.DEFAULT;
        this.v = 0.0f;
        AMapLocationPurpose aMapLocationPurpose = null;
        this.w = null;
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readByte() != (byte) 0;
        this.e = parcel.readByte() != (byte) 0;
        this.f = parcel.readByte() != (byte) 0;
        this.g = parcel.readByte() != (byte) 0;
        this.h = parcel.readByte() != (byte) 0;
        int readInt = parcel.readInt();
        this.i = readInt == -1 ? AMapLocationMode.Hight_Accuracy : AMapLocationMode.values()[readInt];
        this.k = parcel.readByte() != (byte) 0;
        this.l = parcel.readByte() != (byte) 0;
        this.m = parcel.readByte() != (byte) 0;
        this.n = parcel.readByte() != (byte) 0;
        this.o = parcel.readByte() != (byte) 0;
        this.p = parcel.readByte() != (byte) 0;
        this.q = parcel.readByte() != (byte) 0;
        this.r = parcel.readLong();
        readInt = parcel.readInt();
        j = readInt == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt];
        readInt = parcel.readInt();
        this.t = readInt == -1 ? GeoLanguage.DEFAULT : GeoLanguage.values()[readInt];
        u = parcel.readByte() != (byte) 0;
        this.v = parcel.readFloat();
        readInt = parcel.readInt();
        if (readInt != -1) {
            aMapLocationPurpose = AMapLocationPurpose.values()[readInt];
        }
        this.w = aMapLocationPurpose;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        OPEN_ALWAYS_SCAN_WIFI = z;
        this.s = parcel.readLong();
    }

    public static String getAPIKEY() {
        return a;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return u;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z) {
        u = z;
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        j = aMapLocationProtocol;
    }

    public static void setOpenAlwaysScanWifi(boolean z) {
        OPEN_ALWAYS_SCAN_WIFI = z;
    }

    public static void setScanWifiInterval(long j) {
        SCAN_WIFI_INTERVAL = j;
    }

    public AMapLocationClientOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.b = this.b;
        aMapLocationClientOption.d = this.d;
        aMapLocationClientOption.i = this.i;
        aMapLocationClientOption.e = this.e;
        aMapLocationClientOption.k = this.k;
        aMapLocationClientOption.l = this.l;
        aMapLocationClientOption.f = this.f;
        aMapLocationClientOption.g = this.g;
        aMapLocationClientOption.c = this.c;
        aMapLocationClientOption.m = this.m;
        aMapLocationClientOption.n = this.n;
        aMapLocationClientOption.o = this.o;
        aMapLocationClientOption.p = isSensorEnable();
        aMapLocationClientOption.q = isWifiScan();
        aMapLocationClientOption.r = this.r;
        setLocationProtocol(getLocationProtocol());
        aMapLocationClientOption.t = this.t;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        aMapLocationClientOption.v = this.v;
        aMapLocationClientOption.w = this.w;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(getScanWifiInterval());
        aMapLocationClientOption.s = this.s;
        return aMapLocationClientOption;
    }

    public int describeContents() {
        return 0;
    }

    public float getDeviceModeDistanceFilter() {
        return this.v;
    }

    public GeoLanguage getGeoLanguage() {
        return this.t;
    }

    public long getGpsFirstTimeout() {
        return this.s;
    }

    public long getHttpTimeOut() {
        return this.c;
    }

    public long getInterval() {
        return this.b;
    }

    public long getLastLocationLifeCycle() {
        return this.r;
    }

    public AMapLocationMode getLocationMode() {
        return this.i;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return j;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.w;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isGpsFirst() {
        return this.l;
    }

    public boolean isKillProcess() {
        return this.k;
    }

    public boolean isLocationCacheEnable() {
        return this.n;
    }

    public boolean isMockEnable() {
        return this.e;
    }

    public boolean isNeedAddress() {
        return this.f;
    }

    public boolean isOffset() {
        return this.m;
    }

    public boolean isOnceLocation() {
        return this.d;
    }

    public boolean isOnceLocationLatest() {
        return this.o;
    }

    public boolean isSensorEnable() {
        return this.p;
    }

    public boolean isWifiActiveScan() {
        return this.g;
    }

    public boolean isWifiScan() {
        return this.q;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float f) {
        this.v = f;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage geoLanguage) {
        this.t = geoLanguage;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean z) {
        this.l = z;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long j) {
        if (j < 5000) {
            j = 5000;
        }
        if (j > StatisticConfig.MIN_UPLOAD_INTERVAL) {
            j = StatisticConfig.MIN_UPLOAD_INTERVAL;
        }
        this.s = j;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j) {
        this.c = j;
        return this;
    }

    public AMapLocationClientOption setInterval(long j) {
        if (j <= 800) {
            j = 800;
        }
        this.b = j;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z) {
        this.k = z;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j) {
        this.r = j;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z) {
        this.n = z;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.i = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose aMapLocationPurpose) {
        this.w = aMapLocationPurpose;
        if (aMapLocationPurpose != null) {
            switch (aMapLocationPurpose) {
                case SignIn:
                    this.i = AMapLocationMode.Hight_Accuracy;
                    this.d = true;
                    this.o = true;
                    this.l = false;
                    break;
                case Transport:
                case Sport:
                    this.i = AMapLocationMode.Hight_Accuracy;
                    this.d = false;
                    this.o = false;
                    this.l = true;
                    break;
                default:
                    return this;
            }
            this.e = false;
            this.q = true;
        }
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z) {
        this.e = z;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z) {
        this.f = z;
        return this;
    }

    public AMapLocationClientOption setOffset(boolean z) {
        this.m = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z) {
        this.d = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z) {
        this.o = z;
        return this;
    }

    public AMapLocationClientOption setSensorEnable(boolean z) {
        this.p = z;
        return this;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean z) {
        this.g = z;
        this.h = z;
        return this;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x000d in {2, 4, 5} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public com.amap.api.location.AMapLocationClientOption setWifiScan(boolean r1) {
        /*
        r0 = this;
        r0.q = r1;
        r1 = r0.q;
        if (r1 == 0) goto L_0x000b;
        r1 = r0.h;
        r0.g = r1;
        return r0;
        r1 = 0;
        goto L_0x0008;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.AMapLocationClientOption.setWifiScan(boolean):com.amap.api.location.AMapLocationClientOption");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("interval:");
        stringBuilder.append(String.valueOf(this.b));
        stringBuilder.append("#");
        stringBuilder.append("isOnceLocation:");
        stringBuilder.append(String.valueOf(this.d));
        stringBuilder.append("#");
        stringBuilder.append("locationMode:");
        stringBuilder.append(String.valueOf(this.i));
        stringBuilder.append("#");
        stringBuilder.append("locationProtocol:");
        stringBuilder.append(String.valueOf(j));
        stringBuilder.append("#");
        stringBuilder.append("isMockEnable:");
        stringBuilder.append(String.valueOf(this.e));
        stringBuilder.append("#");
        stringBuilder.append("isKillProcess:");
        stringBuilder.append(String.valueOf(this.k));
        stringBuilder.append("#");
        stringBuilder.append("isGpsFirst:");
        stringBuilder.append(String.valueOf(this.l));
        stringBuilder.append("#");
        stringBuilder.append("isNeedAddress:");
        stringBuilder.append(String.valueOf(this.f));
        stringBuilder.append("#");
        stringBuilder.append("isWifiActiveScan:");
        stringBuilder.append(String.valueOf(this.g));
        stringBuilder.append("#");
        stringBuilder.append("wifiScan:");
        stringBuilder.append(String.valueOf(this.q));
        stringBuilder.append("#");
        stringBuilder.append("httpTimeOut:");
        stringBuilder.append(String.valueOf(this.c));
        stringBuilder.append("#");
        stringBuilder.append("isLocationCacheEnable:");
        stringBuilder.append(String.valueOf(this.n));
        stringBuilder.append("#");
        stringBuilder.append("isOnceLocationLatest:");
        stringBuilder.append(String.valueOf(this.o));
        stringBuilder.append("#");
        stringBuilder.append("sensorEnable:");
        stringBuilder.append(String.valueOf(this.p));
        stringBuilder.append("#");
        stringBuilder.append("geoLanguage:");
        stringBuilder.append(String.valueOf(this.t));
        stringBuilder.append("#");
        stringBuilder.append("locationPurpose:");
        stringBuilder.append(String.valueOf(this.w));
        stringBuilder.append("#");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeByte(this.d);
        parcel.writeByte(this.e);
        parcel.writeByte(this.f);
        parcel.writeByte(this.g);
        parcel.writeByte(this.h);
        int i2 = -1;
        parcel.writeInt(this.i == null ? -1 : this.i.ordinal());
        parcel.writeByte(this.k);
        parcel.writeByte(this.l);
        parcel.writeByte(this.m);
        parcel.writeByte(this.n);
        parcel.writeByte(this.o);
        parcel.writeByte(this.p);
        parcel.writeByte(this.q);
        parcel.writeLong(this.r);
        parcel.writeInt(j == null ? -1 : getLocationProtocol().ordinal());
        parcel.writeInt(this.t == null ? -1 : this.t.ordinal());
        parcel.writeByte(u);
        parcel.writeFloat(this.v);
        if (this.w != null) {
            i2 = this.w.ordinal();
        }
        parcel.writeInt(i2);
        parcel.writeInt(OPEN_ALWAYS_SCAN_WIFI);
        parcel.writeLong(this.s);
    }
}
