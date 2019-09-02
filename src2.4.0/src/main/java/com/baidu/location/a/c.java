package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.CommonParam;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.g.e;
import com.baidu.location.g.j;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class c {
    private static Class<?> i;
    String a = null;
    String b = null;
    b c = new b();
    private Context d = null;
    private TelephonyManager e = null;
    private com.baidu.location.e.a f = new com.baidu.location.e.a();
    private WifiManager g = null;
    private c h = null;
    private String j = null;
    private LocationClientOption k;
    private a l;
    private String m = null;
    private String n = null;
    private String o = null;
    private boolean p = false;
    private long q = 0;
    private boolean r = false;

    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    class b extends e {
        String a;

        b() {
            this.a = null;
            this.k = new HashMap();
        }

        public void a() {
            this.h = j.d();
            if (!(c.this.n == null || c.this.o == null)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                stringBuilder.append(String.format(Locale.CHINA, "&ki=%s&sn=%s", new Object[]{c.this.n, c.this.o}));
                this.a = stringBuilder.toString();
            }
            String encodeTp4 = Jni.encodeTp4(this.a);
            this.a = null;
            this.k.put("bloc", encodeTp4);
            this.k.put("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
        }

        public void a(String str) {
            this.a = str;
            c(j.f);
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000e */
        /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|(1:12)) */
        public void a(boolean r3) {
            /*
            r2 = this;
            if (r3 == 0) goto L_0x006b;
        L_0x0002:
            r3 = r2.j;
            if (r3 == 0) goto L_0x006b;
        L_0x0006:
            r3 = r2.j;	 Catch:{ Exception -> 0x006b }
            r0 = new com.baidu.location.BDLocation;	 Catch:{ Exception -> 0x000e }
            r0.<init>(r3);	 Catch:{ Exception -> 0x000e }
            goto L_0x0018;
        L_0x000e:
            r0 = new com.baidu.location.BDLocation;	 Catch:{ Exception -> 0x006b }
            r0.<init>();	 Catch:{ Exception -> 0x006b }
            r3 = 63;
            r0.setLocType(r3);	 Catch:{ Exception -> 0x006b }
        L_0x0018:
            if (r0 == 0) goto L_0x006b;
        L_0x001a:
            r3 = r0.getLocType();	 Catch:{ Exception -> 0x006b }
            r1 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
            if (r3 != r1) goto L_0x006b;
        L_0x0022:
            r3 = com.baidu.location.a.c.this;	 Catch:{ Exception -> 0x006b }
            r3 = r3.k;	 Catch:{ Exception -> 0x006b }
            r3 = r3.coorType;	 Catch:{ Exception -> 0x006b }
            r0.setCoorType(r3);	 Catch:{ Exception -> 0x006b }
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006b }
            r3.<init>();	 Catch:{ Exception -> 0x006b }
            r1 = com.baidu.location.a.c.this;	 Catch:{ Exception -> 0x006b }
            r1 = r1.a;	 Catch:{ Exception -> 0x006b }
            r3.append(r1);	 Catch:{ Exception -> 0x006b }
            r1 = ";";
            r3.append(r1);	 Catch:{ Exception -> 0x006b }
            r1 = com.baidu.location.a.c.this;	 Catch:{ Exception -> 0x006b }
            r1 = r1.b;	 Catch:{ Exception -> 0x006b }
            r3.append(r1);	 Catch:{ Exception -> 0x006b }
            r1 = ";";
            r3.append(r1);	 Catch:{ Exception -> 0x006b }
            r1 = r0.getTime();	 Catch:{ Exception -> 0x006b }
            r3.append(r1);	 Catch:{ Exception -> 0x006b }
            r3 = r3.toString();	 Catch:{ Exception -> 0x006b }
            r3 = com.baidu.location.Jni.en1(r3);	 Catch:{ Exception -> 0x006b }
            r0.setLocationID(r3);	 Catch:{ Exception -> 0x006b }
            r3 = com.baidu.location.a.c.this;	 Catch:{ Exception -> 0x006b }
            r1 = 1;
            r3.r = r1;	 Catch:{ Exception -> 0x006b }
            r3 = com.baidu.location.a.c.this;	 Catch:{ Exception -> 0x006b }
            r3 = r3.l;	 Catch:{ Exception -> 0x006b }
            r3.onReceiveLocation(r0);	 Catch:{ Exception -> 0x006b }
        L_0x006b:
            r3 = r2.k;
            if (r3 == 0) goto L_0x0074;
        L_0x006f:
            r3 = r2.k;
            r3.clear();
        L_0x0074:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.c$b.a(boolean):void");
        }
    }

    protected class c {
        public List<ScanResult> a = null;
        private long c = 0;

        public c(List<ScanResult> list) {
            this.a = list;
            this.c = System.currentTimeMillis();
            c();
        }

        private String b() {
            if (c.this.g == null) {
                return null;
            }
            WifiInfo connectionInfo = c.this.g.getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            try {
                String bssid = connectionInfo.getBSSID();
                bssid = bssid != null ? bssid.replace(":", "") : null;
                return (bssid == null || bssid.length() == 12) ? new String(bssid) : null;
            } catch (Exception unused) {
                return null;
            }
        }

        private void c() {
            if (a() >= 1) {
                int size = this.a.size() - 1;
                int i = 1;
                while (size >= 1 && i != 0) {
                    i = 0;
                    int i2 = 0;
                    while (i < size) {
                        int i3 = i + 1;
                        if (((ScanResult) this.a.get(i)).level < ((ScanResult) this.a.get(i3)).level) {
                            ScanResult scanResult = (ScanResult) this.a.get(i3);
                            this.a.set(i3, this.a.get(i));
                            this.a.set(i, scanResult);
                            i2 = 1;
                        }
                        i = i3;
                    }
                    size--;
                    i = i2;
                }
            }
        }

        public int a() {
            return this.a == null ? 0 : this.a.size();
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00e6  */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00f2  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00f0  */
        public java.lang.String a(int r24) {
            /*
            r23 = this;
            r0 = r23;
            r1 = r23.a();
            r2 = 0;
            r3 = 2;
            if (r1 >= r3) goto L_0x000b;
        L_0x000a:
            return r2;
        L_0x000b:
            r1 = new java.util.ArrayList;
            r1.<init>();
            r3 = android.os.Build.VERSION.SDK_INT;
            r4 = 19;
            r5 = 1;
            r6 = 0;
            r8 = 0;
            if (r3 < r4) goto L_0x002c;
        L_0x001a:
            r3 = android.os.SystemClock.elapsedRealtimeNanos();	 Catch:{ Error -> 0x0022 }
            r9 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r3 = r3 / r9;
            goto L_0x0023;
        L_0x0022:
            r3 = r6;
        L_0x0023:
            r9 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
            if (r9 <= 0) goto L_0x002a;
        L_0x0027:
            r9 = r3;
            r3 = r5;
            goto L_0x002e;
        L_0x002a:
            r9 = r3;
            goto L_0x002d;
        L_0x002c:
            r9 = r6;
        L_0x002d:
            r3 = r8;
        L_0x002e:
            r4 = new java.lang.StringBuffer;
            r11 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
            r4.<init>(r11);
            r11 = r0.a;
            r11 = r11.size();
            r12 = r23.b();
            r15 = r5;
            r17 = r6;
            r13 = r8;
            r14 = r13;
            r16 = r14;
            r19 = r16;
        L_0x0048:
            if (r13 >= r11) goto L_0x00e2;
        L_0x004a:
            r6 = r0.a;
            r6 = r6.get(r13);
            r6 = (android.net.wifi.ScanResult) r6;
            r6 = r6.level;
            if (r6 != 0) goto L_0x005c;
        L_0x0056:
            r6 = r24;
            r20 = r11;
            goto L_0x00d9;
        L_0x005c:
            r14 = r14 + 1;
            if (r15 == 0) goto L_0x0067;
        L_0x0060:
            r6 = "&wf=";
            r4.append(r6);
            r15 = r8;
            goto L_0x006c;
        L_0x0067:
            r6 = "|";
            r4.append(r6);
        L_0x006c:
            r6 = r0.a;
            r6 = r6.get(r13);
            r6 = (android.net.wifi.ScanResult) r6;
            r6 = r6.BSSID;
            r7 = ":";
            r2 = "";
            r2 = r6.replace(r7, r2);
            r4.append(r2);
            if (r12 == 0) goto L_0x008b;
        L_0x0083:
            r2 = r2.equals(r12);
            if (r2 == 0) goto L_0x008b;
        L_0x0089:
            r19 = r14;
        L_0x008b:
            r2 = r0.a;
            r2 = r2.get(r13);
            r2 = (android.net.wifi.ScanResult) r2;
            r2 = r2.level;
            if (r2 >= 0) goto L_0x0098;
        L_0x0097:
            r2 = -r2;
        L_0x0098:
            r6 = java.util.Locale.CHINA;
            r7 = ";%d;";
            r20 = r11;
            r11 = new java.lang.Object[r5];
            r2 = java.lang.Integer.valueOf(r2);
            r11[r8] = r2;
            r2 = java.lang.String.format(r6, r7, r11);
            r4.append(r2);
            r2 = r16 + 1;
            if (r3 == 0) goto L_0x00d2;
        L_0x00b1:
            r6 = r0.a;	 Catch:{ Throwable -> 0x00c3 }
            r6 = r6.get(r13);	 Catch:{ Throwable -> 0x00c3 }
            r6 = (android.net.wifi.ScanResult) r6;	 Catch:{ Throwable -> 0x00c3 }
            r6 = r6.timestamp;	 Catch:{ Throwable -> 0x00c3 }
            r21 = r9 - r6;
            r6 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
            r6 = r21 / r6;
            goto L_0x00c5;
        L_0x00c3:
            r6 = 0;
        L_0x00c5:
            r11 = java.lang.Long.valueOf(r6);
            r1.add(r11);
            r11 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1));
            if (r11 <= 0) goto L_0x00d2;
        L_0x00d0:
            r17 = r6;
        L_0x00d2:
            r6 = r24;
            if (r2 <= r6) goto L_0x00d7;
        L_0x00d6:
            goto L_0x00e2;
        L_0x00d7:
            r16 = r2;
        L_0x00d9:
            r13 = r13 + 1;
            r11 = r20;
            r2 = 0;
            r6 = 0;
            goto L_0x0048;
        L_0x00e2:
            r2 = r19;
            if (r2 <= 0) goto L_0x00ee;
        L_0x00e6:
            r3 = "&wf_n=";
            r4.append(r3);
            r4.append(r2);
        L_0x00ee:
            if (r15 == 0) goto L_0x00f2;
        L_0x00f0:
            r2 = 0;
            return r2;
        L_0x00f2:
            r2 = 10;
            r6 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1));
            if (r6 <= 0) goto L_0x016e;
        L_0x00f8:
            r2 = r1.size();
            if (r2 <= 0) goto L_0x016e;
        L_0x00fe:
            r2 = r1.get(r8);
            r2 = (java.lang.Long) r2;
            r2 = r2.longValue();
            r6 = 0;
            r9 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
            if (r9 <= 0) goto L_0x016e;
        L_0x010e:
            r2 = new java.lang.StringBuffer;
            r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
            r2.<init>(r3);
            r3 = "&wf_ut=";
            r2.append(r3);
            r3 = r1.get(r8);
            r3 = (java.lang.Long) r3;
            r1 = r1.iterator();
        L_0x0124:
            r6 = r1.hasNext();
            if (r6 == 0) goto L_0x0167;
        L_0x012a:
            r6 = r1.next();
            r6 = (java.lang.Long) r6;
            if (r5 == 0) goto L_0x013d;
        L_0x0132:
            r5 = r6.longValue();
            r2.append(r5);
            r5 = r8;
            r6 = 0;
            goto L_0x0161;
        L_0x013d:
            r6 = r6.longValue();
            r9 = r3.longValue();
            r11 = r6 - r9;
            r6 = 0;
            r9 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
            if (r9 == 0) goto L_0x0161;
        L_0x014d:
            r9 = new java.lang.StringBuilder;
            r9.<init>();
            r10 = "";
            r9.append(r10);
            r9.append(r11);
            r9 = r9.toString();
            r2.append(r9);
        L_0x0161:
            r9 = "|";
            r2.append(r9);
            goto L_0x0124;
        L_0x0167:
            r1 = r2.toString();
            r4.append(r1);
        L_0x016e:
            r1 = r4.toString();
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.c$c.a(int):java.lang.String");
        }
    }

    public c(Context context, LocationClientOption locationClientOption, a aVar) {
        this.d = context.getApplicationContext();
        this.p = true;
        if (this.p) {
            String deviceId;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            this.k = new LocationClientOption(locationClientOption);
            this.l = aVar;
            this.a = this.d.getPackageName();
            this.b = null;
            try {
                this.e = (TelephonyManager) this.d.getSystemService("phone");
                this.g = (WifiManager) this.d.getApplicationContext().getSystemService("wifi");
                deviceId = this.e.getDeviceId();
            } catch (Exception unused) {
                deviceId = null;
            }
            try {
                this.b = CommonParam.a(this.d);
            } catch (Throwable unused2) {
                this.b = null;
                this.e = null;
                this.g = null;
            }
            if (this.b != null) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("");
                stringBuilder3.append(this.b);
                j.o = stringBuilder3.toString();
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("&prod=");
                stringBuilder3.append(this.k.prodName);
                stringBuilder3.append(":");
                stringBuilder3.append(this.a);
                stringBuilder3.append("|&cu=");
                stringBuilder3.append(this.b);
                stringBuilder3.append("&coor=");
                stringBuilder3.append(locationClientOption.getCoorType());
                deviceId = stringBuilder3.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("&prod=");
                stringBuilder.append(this.k.prodName);
                stringBuilder.append(":");
                stringBuilder.append(this.a);
                stringBuilder.append("|&im=");
                stringBuilder.append(deviceId);
                stringBuilder.append("&coor=");
                stringBuilder.append(locationClientOption.getCoorType());
                deviceId = stringBuilder.toString();
            }
            this.j = deviceId;
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append("&fw=");
            stringBuffer.append("7.62");
            stringBuffer.append("&sdk=");
            stringBuffer.append("7.62");
            stringBuffer.append("&lt=1");
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
            stringBuffer.append("&resid=");
            stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
            locationClientOption.getAddrType();
            if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals(MsgService.MSG_CHATTING_ACCOUNT_ALL)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.j);
                stringBuilder.append("&addr=allj");
                this.j = stringBuilder.toString();
            }
            if (locationClientOption.isNeedNewVersionRgc) {
                stringBuffer.append("&adtp=n2");
            }
            if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.j);
                stringBuilder.append("&sema=");
                this.j = stringBuilder.toString();
                if (locationClientOption.isNeedAptag) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(this.j);
                    stringBuilder.append("aptag|");
                    this.j = stringBuilder.toString();
                }
                if (locationClientOption.isNeedAptagd) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(this.j);
                    stringBuilder2.append("aptagd|");
                    this.j = stringBuilder2.toString();
                }
                this.n = j.b(this.d);
                this.o = j.c(this.d);
            }
            stringBuffer.append("&first=1");
            stringBuffer.append("&os=A");
            stringBuffer.append(VERSION.SDK);
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.j);
            stringBuilder2.append(stringBuffer.toString());
            this.j = stringBuilder2.toString();
            CharSequence a = a();
            if (!TextUtils.isEmpty(a)) {
                a = a.replace(":", "");
            }
            if (!(TextUtils.isEmpty(a) || a.equals("020000000000"))) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(this.j);
                stringBuilder4.append("&mac=");
                stringBuilder4.append(a);
                this.j = stringBuilder4.toString();
            }
            b();
        }
    }

    private int a(int i) {
        return i == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED ? -1 : i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0121 A:{Catch:{ Exception -> 0x015f }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x015f */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:27:0x00d4, code skipped:
            if (r2 <= 0) goto L_0x0117;
     */
    @android.annotation.SuppressLint({"NewApi"})
    private com.baidu.location.e.a a(android.telephony.CellInfo r10) {
        /*
        r9 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r0.intValue();
        r1 = 17;
        if (r0 >= r1) goto L_0x0010;
    L_0x000e:
        r10 = 0;
        return r10;
    L_0x0010:
        r1 = new com.baidu.location.e.a;
        r1.<init>();
        r2 = r10 instanceof android.telephony.CellInfoGsm;
        r3 = 0;
        r4 = 1;
        r5 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        if (r2 == 0) goto L_0x005a;
    L_0x001d:
        r2 = r10;
        r2 = (android.telephony.CellInfoGsm) r2;
        r3 = r2.getCellIdentity();
        r6 = r3.getMcc();
        r6 = r9.a(r6);
        r1.c = r6;
        r6 = r3.getMnc();
        r6 = r9.a(r6);
        r1.d = r6;
        r6 = r3.getLac();
        r6 = r9.a(r6);
        r1.a = r6;
        r3 = r3.getCid();
        r3 = r9.a(r3);
        r1.b = r3;
        r1.i = r5;
        r2 = r2.getCellSignalStrength();
        r2 = r2.getAsuLevel();
    L_0x0056:
        r1.h = r2;
        goto L_0x0117;
    L_0x005a:
        r2 = r10 instanceof android.telephony.CellInfoCdma;
        if (r2 == 0) goto L_0x00d7;
    L_0x005e:
        r2 = r10;
        r2 = (android.telephony.CellInfoCdma) r2;
        r6 = r2.getCellIdentity();
        r7 = r6.getLatitude();
        r1.e = r7;
        r7 = r6.getLongitude();
        r1.f = r7;
        r7 = r6.getSystemId();
        r7 = r9.a(r7);
        r1.d = r7;
        r7 = r6.getNetworkId();
        r7 = r9.a(r7);
        r1.a = r7;
        r6 = r6.getBasestationId();
        r6 = r9.a(r6);
        r1.b = r6;
        r6 = 99;
        r1.i = r6;
        r2 = r2.getCellSignalStrength();
        r2 = r2.getCdmaDbm();
        r1.h = r2;
        r2 = r9.f;
        if (r2 == 0) goto L_0x00ae;
    L_0x00a1:
        r2 = r9.f;
        r2 = r2.c;
        if (r2 <= 0) goto L_0x00ae;
    L_0x00a7:
        r2 = r9.f;
        r2 = r2.c;
    L_0x00ab:
        r1.c = r2;
        goto L_0x0117;
    L_0x00ae:
        r2 = -1;
        r6 = r9.e;	 Catch:{ Exception -> 0x00d4 }
        r6 = r6.getNetworkOperator();	 Catch:{ Exception -> 0x00d4 }
        if (r6 == 0) goto L_0x00d4;
    L_0x00b7:
        r7 = r6.length();	 Catch:{ Exception -> 0x00d4 }
        if (r7 <= 0) goto L_0x00d4;
    L_0x00bd:
        r7 = r6.length();	 Catch:{ Exception -> 0x00d4 }
        r8 = 3;
        if (r7 < r8) goto L_0x00d4;
    L_0x00c4:
        r3 = r6.substring(r3, r8);	 Catch:{ Exception -> 0x00d4 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x00d4 }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x00d4 }
        if (r3 >= 0) goto L_0x00d3;
    L_0x00d2:
        goto L_0x00d4;
    L_0x00d3:
        r2 = r3;
    L_0x00d4:
        if (r2 <= 0) goto L_0x0117;
    L_0x00d6:
        goto L_0x00ab;
    L_0x00d7:
        r2 = r10 instanceof android.telephony.CellInfoLte;
        if (r2 == 0) goto L_0x0116;
    L_0x00db:
        r2 = r10;
        r2 = (android.telephony.CellInfoLte) r2;
        r3 = r2.getCellIdentity();
        r6 = r3.getMcc();
        r6 = r9.a(r6);
        r1.c = r6;
        r6 = r3.getMnc();
        r6 = r9.a(r6);
        r1.d = r6;
        r6 = r3.getTac();
        r6 = r9.a(r6);
        r1.a = r6;
        r3 = r3.getCi();
        r3 = r9.a(r3);
        r1.b = r3;
        r1.i = r5;
        r2 = r2.getCellSignalStrength();
        r2 = r2.getAsuLevel();
        goto L_0x0056;
    L_0x0116:
        r4 = r3;
    L_0x0117:
        r2 = 18;
        if (r0 < r2) goto L_0x015f;
    L_0x011b:
        if (r4 != 0) goto L_0x015f;
    L_0x011d:
        r0 = r10 instanceof android.telephony.CellInfoWcdma;	 Catch:{ Exception -> 0x015f }
        if (r0 == 0) goto L_0x015f;
    L_0x0121:
        r0 = r10;
        r0 = (android.telephony.CellInfoWcdma) r0;	 Catch:{ Exception -> 0x015f }
        r0 = r0.getCellIdentity();	 Catch:{ Exception -> 0x015f }
        r2 = r0.getMcc();	 Catch:{ Exception -> 0x015f }
        r2 = r9.a(r2);	 Catch:{ Exception -> 0x015f }
        r1.c = r2;	 Catch:{ Exception -> 0x015f }
        r2 = r0.getMnc();	 Catch:{ Exception -> 0x015f }
        r2 = r9.a(r2);	 Catch:{ Exception -> 0x015f }
        r1.d = r2;	 Catch:{ Exception -> 0x015f }
        r2 = r0.getLac();	 Catch:{ Exception -> 0x015f }
        r2 = r9.a(r2);	 Catch:{ Exception -> 0x015f }
        r1.a = r2;	 Catch:{ Exception -> 0x015f }
        r0 = r0.getCid();	 Catch:{ Exception -> 0x015f }
        r0 = r9.a(r0);	 Catch:{ Exception -> 0x015f }
        r1.b = r0;	 Catch:{ Exception -> 0x015f }
        r1.i = r5;	 Catch:{ Exception -> 0x015f }
        r0 = r10;
        r0 = (android.telephony.CellInfoWcdma) r0;	 Catch:{ Exception -> 0x015f }
        r0 = r0.getCellSignalStrength();	 Catch:{ Exception -> 0x015f }
        r0 = r0.getAsuLevel();	 Catch:{ Exception -> 0x015f }
        r1.h = r0;	 Catch:{ Exception -> 0x015f }
    L_0x015f:
        r2 = android.os.SystemClock.elapsedRealtimeNanos();	 Catch:{ Error -> 0x0176 }
        r4 = r10.getTimeStamp();	 Catch:{ Error -> 0x0176 }
        r6 = r2 - r4;
        r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r6 = r6 / r2;
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Error -> 0x0176 }
        r4 = r2 - r6;
        r1.g = r4;	 Catch:{ Error -> 0x0176 }
        return r1;
    L_0x0176:
        r2 = java.lang.System.currentTimeMillis();
        r1.g = r2;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.c.a(android.telephony.CellInfo):com.baidu.location.e.a");
    }

    private void a(CellLocation cellLocation) {
        if (cellLocation != null && this.e != null) {
            int intValue;
            com.baidu.location.e.a aVar = new com.baidu.location.e.a();
            String networkOperator = this.e.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue2 = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue2 < 0) {
                            intValue2 = this.f.c;
                        }
                        aVar.c = intValue2;
                    }
                    networkOperator = networkOperator.substring(3);
                    if (networkOperator != null) {
                        char[] toCharArray = networkOperator.toCharArray();
                        int i = 0;
                        while (i < toCharArray.length) {
                            if (!Character.isDigit(toCharArray[i])) {
                                break;
                            }
                            i++;
                        }
                        intValue = Integer.valueOf(networkOperator.substring(0, i)).intValue();
                        if (intValue < 0) {
                            intValue = this.f.d;
                        }
                        aVar.d = intValue;
                    }
                } catch (Exception unused) {
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                aVar.a = gsmCellLocation.getLac();
                aVar.b = gsmCellLocation.getCid();
                aVar.i = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                aVar.i = 'c';
                if (i == null) {
                    try {
                        i = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    } catch (Exception unused2) {
                        i = null;
                        return;
                    }
                }
                if (i != null && i.isInstance(cellLocation)) {
                    try {
                        intValue = ((CdmaCellLocation) cellLocation).getSystemId();
                        if (intValue < 0) {
                            intValue = -1;
                        }
                        aVar.d = intValue;
                        aVar.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                        aVar.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                        intValue = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                        if (intValue < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                            aVar.e = intValue;
                        }
                        int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                        if (baseStationLongitude < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                            aVar.f = baseStationLongitude;
                        }
                    } catch (Exception unused3) {
                    }
                }
            }
            if (aVar.b()) {
                this.f = aVar;
            } else {
                this.f = null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008a  */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0054 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|(2:4|(1:6)(9:7|9|(1:14)(1:13)|15|16|(2:22|23)|26|27|(2:(1:(1:36)(1:37))|(1:39)(4:40|(1:42)|43|44))(2:32|33)))|8|9|(1:11)|14|15|16|18|20|22|23|26|27|(0)|(0)|(0)(0)) */
    /* JADX WARNING: Missing block: B:28:0x006a, code skipped:
            r5 = null;
     */
    private java.lang.String b(int r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.d();	 Catch:{ Throwable -> 0x0053 }
        if (r1 == 0) goto L_0x0011;
    L_0x0007:
        r2 = r1.b();	 Catch:{ Throwable -> 0x0053 }
        if (r2 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0011;
    L_0x000e:
        r4.f = r1;	 Catch:{ Throwable -> 0x0053 }
        goto L_0x001a;
    L_0x0011:
        r1 = r4.e;	 Catch:{ Throwable -> 0x0053 }
        r1 = r1.getCellLocation();	 Catch:{ Throwable -> 0x0053 }
        r4.a(r1);	 Catch:{ Throwable -> 0x0053 }
    L_0x001a:
        r1 = r4.f;	 Catch:{ Throwable -> 0x0053 }
        if (r1 == 0) goto L_0x002d;
    L_0x001e:
        r1 = r4.f;	 Catch:{ Throwable -> 0x0053 }
        r1 = r1.b();	 Catch:{ Throwable -> 0x0053 }
        if (r1 == 0) goto L_0x002d;
    L_0x0026:
        r1 = r4.f;	 Catch:{ Throwable -> 0x0053 }
        r1 = r1.h();	 Catch:{ Throwable -> 0x0053 }
        goto L_0x002e;
    L_0x002d:
        r1 = r0;
    L_0x002e:
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0054 }
        if (r2 != 0) goto L_0x0054;
    L_0x0034:
        r2 = r4.f;	 Catch:{ Throwable -> 0x0054 }
        if (r2 == 0) goto L_0x0054;
    L_0x0038:
        r2 = r4.f;	 Catch:{ Throwable -> 0x0054 }
        r2 = r2.j;	 Catch:{ Throwable -> 0x0054 }
        if (r2 == 0) goto L_0x0054;
    L_0x003e:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0054 }
        r2.<init>();	 Catch:{ Throwable -> 0x0054 }
        r2.append(r1);	 Catch:{ Throwable -> 0x0054 }
        r3 = r4.f;	 Catch:{ Throwable -> 0x0054 }
        r3 = r3.j;	 Catch:{ Throwable -> 0x0054 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0054 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0054 }
        r1 = r2;
        goto L_0x0054;
    L_0x0053:
        r1 = r0;
    L_0x0054:
        r4.h = r0;	 Catch:{ Exception -> 0x006a }
        r2 = new com.baidu.location.a.c$c;	 Catch:{ Exception -> 0x006a }
        r3 = r4.g;	 Catch:{ Exception -> 0x006a }
        r3 = r3.getScanResults();	 Catch:{ Exception -> 0x006a }
        r2.<init>(r3);	 Catch:{ Exception -> 0x006a }
        r4.h = r2;	 Catch:{ Exception -> 0x006a }
        r2 = r4.h;	 Catch:{ Exception -> 0x006a }
        r5 = r2.a(r5);	 Catch:{ Exception -> 0x006a }
        goto L_0x006b;
    L_0x006a:
        r5 = r0;
    L_0x006b:
        if (r1 != 0) goto L_0x0072;
    L_0x006d:
        if (r5 != 0) goto L_0x0072;
    L_0x006f:
        r4.m = r0;
        return r0;
    L_0x0072:
        if (r5 == 0) goto L_0x0087;
    L_0x0074:
        if (r1 != 0) goto L_0x0078;
    L_0x0076:
        r1 = r5;
        goto L_0x0087;
    L_0x0078:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r2.append(r5);
        r1 = r2.toString();
    L_0x0087:
        if (r1 != 0) goto L_0x008a;
    L_0x0089:
        return r0;
    L_0x008a:
        r4.m = r1;
        r5 = r4.j;
        if (r5 == 0) goto L_0x00a5;
    L_0x0090:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r4.m;
        r5.append(r0);
        r0 = r4.j;
        r5.append(r0);
        r5 = r5.toString();
        r4.m = r5;
    L_0x00a5:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5.append(r1);
        r0 = r4.j;
        r5.append(r0);
        r5 = r5.toString();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.c.b(int):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    private com.baidu.location.e.a d() {
        com.baidu.location.e.a aVar = null;
        if (Integer.valueOf(VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            List<CellInfo> allCellInfo = this.e.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                com.baidu.location.e.a aVar2 = null;
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo.isRegistered()) {
                        Object obj = null;
                        if (aVar2 != null) {
                            obj = 1;
                        }
                        com.baidu.location.e.a a = a(cellInfo);
                        if (a != null) {
                            if (!a.b()) {
                                a = null;
                            } else if (!(obj == null || aVar2 == null)) {
                                aVar2.j = a.i();
                                return aVar2;
                            }
                            if (aVar2 == null) {
                                aVar2 = a;
                            }
                        }
                    }
                }
                aVar = aVar2;
            }
        } catch (Throwable unused) {
        }
        return aVar;
    }

    public String a() {
        try {
            WifiInfo connectionInfo = this.g.getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getMacAddress();
            }
        } catch (Error | Exception unused) {
        }
        return null;
    }

    public String b() {
        try {
            return b(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public void c() {
        if (this.m != null && this.p) {
            BDLocation bDLocation = null;
            if (!(this.g == null || this.k.scanSpan < 1000 || this.k.getAddrType().equals(MsgService.MSG_CHATTING_ACCOUNT_ALL) || this.k.isNeedAptag || this.k.isNeedAptagd)) {
                try {
                    BDLocation a;
                    String g = this.f != null ? this.f.g() : null;
                    if (this.g != null) {
                        a = com.baidu.location.d.a.a().a(g, this.g.getScanResults(), false);
                        if (a != null && a.getLocType() == 66 && Math.abs(a.getLatitude()) < 0.10000000149011612d && Math.abs(a.getLongitude()) < 0.10000000149011612d) {
                            a.setLocType(67);
                        }
                    } else {
                        a = null;
                    }
                    if (a != null) {
                        a.getLocType();
                    }
                    if (a != null) {
                        a.getLocType();
                    }
                    if (!(this.k.coorType.equals(CoordinateType.GCJ02) || a == null || a.getLocType() != 66)) {
                        double longitude = a.getLongitude();
                        double latitude = a.getLatitude();
                        if (Math.abs(longitude) > 0.10000000149011612d && Math.abs(latitude) > 0.10000000149011612d) {
                            double[] coorEncrypt = Jni.coorEncrypt(longitude, latitude, this.k.coorType);
                            a.setLongitude(coorEncrypt[0]);
                            a.setLatitude(coorEncrypt[1]);
                            a.setCoorType(this.k.coorType);
                        }
                    }
                    if (a != null && a.getLocType() == 66 && Math.abs(a.getLatitude()) > 0.10000000149011612d && Math.abs(a.getLongitude()) > 0.10000000149011612d) {
                        if (!this.r) {
                            this.l.onReceiveLocation(a);
                        }
                        bDLocation = a;
                    }
                } catch (Exception unused) {
                }
            }
            if (bDLocation == null) {
                this.c.a(this.m);
            }
        }
    }
}
