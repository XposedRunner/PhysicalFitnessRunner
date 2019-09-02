package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.HandlerThread;
import android.support.v4.internal.view.SupportMenu;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: CgiManager */
public final class bh {
    int O000000o = 0;
    ArrayList<bg> O00000Oo = new ArrayList();
    long O00000o = 0;
    TelephonyManager O00000o0 = null;
    CellLocation O00000oO;
    boolean O00000oo = false;
    PhoneStateListener O0000O0o = null;
    String O0000OOo = null;
    StringBuilder O0000Oo = null;
    boolean O0000Oo0 = false;
    HandlerThread O0000OoO = null;
    private Context O0000Ooo;
    private Object O0000o;
    private ArrayList<bg> O0000o0 = new ArrayList();
    private String O0000o00 = null;
    private int O0000o0O = -113;
    private be O0000o0o = null;
    private long O0000oO = 0;
    private int O0000oO0 = 0;
    private boolean O0000oOO = false;
    private Object O0000oOo = new Object();

    /* compiled from: CgiManager */
    class O000000o extends HandlerThread {
        public O000000o(String str) {
            super(str);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onLooperPrepared() {
            try {
                super.onLooperPrepared();
                synchronized (bh.this.O0000oOo) {
                    if (!bh.this.O0000oOO) {
                        bh.this.O0000OoO();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0004 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:4:?, code skipped:
            r3.O000000o.O00000o0.listen(r3.O000000o.O0000O0o, 0);
            r3.O000000o.O0000O0o = null;
            quit();
     */
        /* JADX WARNING: Missing block: B:5:0x0018, code skipped:
            return;
     */
        public final void run() {
            /*
            r3 = this;
            super.run();	 Catch:{ Throwable -> 0x0004 }
            return;
        L_0x0004:
            r0 = com.amap.api.mapcore.util.bh.this;	 Catch:{ Throwable -> 0x0018 }
            r0 = r0.O00000o0;	 Catch:{ Throwable -> 0x0018 }
            r1 = com.amap.api.mapcore.util.bh.this;	 Catch:{ Throwable -> 0x0018 }
            r1 = r1.O0000O0o;	 Catch:{ Throwable -> 0x0018 }
            r2 = 0;
            r0.listen(r1, r2);	 Catch:{ Throwable -> 0x0018 }
            r0 = com.amap.api.mapcore.util.bh.this;	 Catch:{ Throwable -> 0x0018 }
            r1 = 0;
            r0.O0000O0o = r1;	 Catch:{ Throwable -> 0x0018 }
            r3.quit();	 Catch:{ Throwable -> 0x0018 }
        L_0x0018:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bh$O000000o.run():void");
        }
    }

    public bh(Context context) {
        this.O0000Ooo = context;
        if (this.O00000o0 == null) {
            this.O00000o0 = (TelephonyManager) bt.O000000o(this.O0000Ooo, "phone");
        }
        O0000Oo();
        this.O0000o0o = new be();
    }

    private CellLocation O000000o(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            obj = br.O000000o(obj, str, objArr);
            CellLocation cellLocation = obj != null ? (CellLocation) obj : null;
            return O00000Oo(cellLocation) ? cellLocation : null;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00aa A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a9 A:{RETURN} */
    @android.annotation.SuppressLint({"NewApi"})
    private android.telephony.CellLocation O000000o(java.util.List<android.telephony.CellInfo> r11) {
        /*
        r10 = this;
        r0 = 0;
        if (r11 == 0) goto L_0x00ab;
    L_0x0003:
        r1 = r11.isEmpty();
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = 0;
    L_0x000b:
        r2 = r11.size();
        if (r1 >= r2) goto L_0x0078;
    L_0x0011:
        r2 = r11.get(r1);
        r2 = (android.telephony.CellInfo) r2;
        if (r2 == 0) goto L_0x0075;
    L_0x0019:
        r3 = r2.isRegistered();	 Catch:{ Throwable -> 0x0075 }
        r4 = r2 instanceof android.telephony.CellInfoCdma;	 Catch:{ Throwable -> 0x0075 }
        if (r4 == 0) goto L_0x0033;
    L_0x0021:
        r2 = (android.telephony.CellInfoCdma) r2;	 Catch:{ Throwable -> 0x0075 }
        r4 = r2.getCellIdentity();	 Catch:{ Throwable -> 0x0075 }
        r4 = O000000o(r4);	 Catch:{ Throwable -> 0x0075 }
        if (r4 != 0) goto L_0x002e;
    L_0x002d:
        goto L_0x0075;
    L_0x002e:
        r2 = r10.O000000o(r2, r3);	 Catch:{ Throwable -> 0x0075 }
        goto L_0x0079;
    L_0x0033:
        r4 = r2 instanceof android.telephony.CellInfoGsm;	 Catch:{ Throwable -> 0x0075 }
        if (r4 == 0) goto L_0x0049;
    L_0x0037:
        r2 = (android.telephony.CellInfoGsm) r2;	 Catch:{ Throwable -> 0x0075 }
        r4 = r2.getCellIdentity();	 Catch:{ Throwable -> 0x0075 }
        r4 = O000000o(r4);	 Catch:{ Throwable -> 0x0075 }
        if (r4 != 0) goto L_0x0044;
    L_0x0043:
        goto L_0x0075;
    L_0x0044:
        r2 = O000000o(r2, r3);	 Catch:{ Throwable -> 0x0075 }
        goto L_0x0079;
    L_0x0049:
        r4 = r2 instanceof android.telephony.CellInfoWcdma;	 Catch:{ Throwable -> 0x0075 }
        if (r4 == 0) goto L_0x005f;
    L_0x004d:
        r2 = (android.telephony.CellInfoWcdma) r2;	 Catch:{ Throwable -> 0x0075 }
        r4 = r2.getCellIdentity();	 Catch:{ Throwable -> 0x0075 }
        r4 = O000000o(r4);	 Catch:{ Throwable -> 0x0075 }
        if (r4 != 0) goto L_0x005a;
    L_0x0059:
        goto L_0x0075;
    L_0x005a:
        r2 = O000000o(r2, r3);	 Catch:{ Throwable -> 0x0075 }
        goto L_0x0079;
    L_0x005f:
        r4 = r2 instanceof android.telephony.CellInfoLte;	 Catch:{ Throwable -> 0x0075 }
        if (r4 == 0) goto L_0x0078;
    L_0x0063:
        r2 = (android.telephony.CellInfoLte) r2;	 Catch:{ Throwable -> 0x0075 }
        r4 = r2.getCellIdentity();	 Catch:{ Throwable -> 0x0075 }
        r4 = O000000o(r4);	 Catch:{ Throwable -> 0x0075 }
        if (r4 != 0) goto L_0x0070;
    L_0x006f:
        goto L_0x0075;
    L_0x0070:
        r2 = O000000o(r2, r3);	 Catch:{ Throwable -> 0x0075 }
        goto L_0x0079;
    L_0x0075:
        r1 = r1 + 1;
        goto L_0x000b;
    L_0x0078:
        r2 = r0;
    L_0x0079:
        if (r2 == 0) goto L_0x00a3;
    L_0x007b:
        r11 = r2.O0000OoO;	 Catch:{ Throwable -> 0x00a1 }
        r1 = 2;
        if (r11 != r1) goto L_0x0094;
    L_0x0080:
        r11 = new android.telephony.cdma.CdmaCellLocation;	 Catch:{ Throwable -> 0x00a1 }
        r11.<init>();	 Catch:{ Throwable -> 0x00a1 }
        r4 = r2.O0000Oo0;	 Catch:{ Throwable -> 0x00a7 }
        r5 = r2.O00000oO;	 Catch:{ Throwable -> 0x00a7 }
        r6 = r2.O00000oo;	 Catch:{ Throwable -> 0x00a7 }
        r7 = r2.O0000O0o;	 Catch:{ Throwable -> 0x00a7 }
        r8 = r2.O0000OOo;	 Catch:{ Throwable -> 0x00a7 }
        r3 = r11;
        r3.setCellLocationData(r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x00a7 }
        goto L_0x00a7;
    L_0x0094:
        r11 = new android.telephony.gsm.GsmCellLocation;	 Catch:{ Throwable -> 0x00a1 }
        r11.<init>();	 Catch:{ Throwable -> 0x00a1 }
        r1 = r2.O00000o0;	 Catch:{ Throwable -> 0x00a4 }
        r2 = r2.O00000o;	 Catch:{ Throwable -> 0x00a4 }
        r11.setLacAndCid(r1, r2);	 Catch:{ Throwable -> 0x00a4 }
        goto L_0x00a4;
    L_0x00a1:
        r11 = r0;
        goto L_0x00a7;
    L_0x00a3:
        r11 = r0;
    L_0x00a4:
        r9 = r0;
        r0 = r11;
        r11 = r9;
    L_0x00a7:
        if (r11 != 0) goto L_0x00aa;
    L_0x00a9:
        return r0;
    L_0x00aa:
        return r11;
    L_0x00ab:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bh.O000000o(java.util.List):android.telephony.CellLocation");
    }

    private static bg O000000o(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        bg bgVar = new bg(i, z);
        bgVar.O000000o = i2;
        bgVar.O00000Oo = i3;
        bgVar.O00000o0 = i4;
        bgVar.O00000o = i5;
        bgVar.O0000Oo = i6;
        return bgVar;
    }

    @SuppressLint({"NewApi"})
    private bg O000000o(CellInfoCdma cellInfoCdma, boolean z) {
        int parseInt;
        int parseInt2;
        bg O000000o;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        String[] O000000o2 = bt.O000000o(this.O00000o0);
        try {
            parseInt = Integer.parseInt(O000000o2[0]);
            try {
                parseInt2 = Integer.parseInt(O000000o2[1]);
            } catch (Throwable unused) {
                parseInt2 = 0;
                O000000o = O000000o(2, z, parseInt, parseInt2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
                O000000o.O0000O0o = cellIdentity.getSystemId();
                O000000o.O0000OOo = cellIdentity.getNetworkId();
                O000000o.O0000Oo0 = cellIdentity.getBasestationId();
                O000000o.O00000oO = cellIdentity.getLatitude();
                O000000o.O00000oo = cellIdentity.getLongitude();
                return O000000o;
            }
        } catch (Throwable unused2) {
            parseInt = 0;
            parseInt2 = 0;
            O000000o = O000000o(2, z, parseInt, parseInt2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
            O000000o.O0000O0o = cellIdentity.getSystemId();
            O000000o.O0000OOo = cellIdentity.getNetworkId();
            O000000o.O0000Oo0 = cellIdentity.getBasestationId();
            O000000o.O00000oO = cellIdentity.getLatitude();
            O000000o.O00000oo = cellIdentity.getLongitude();
            return O000000o;
        }
        O000000o = O000000o(2, z, parseInt, parseInt2, 0, 0, cellInfoCdma.getCellSignalStrength().getCdmaDbm());
        O000000o.O0000O0o = cellIdentity.getSystemId();
        O000000o.O0000OOo = cellIdentity.getNetworkId();
        O000000o.O0000Oo0 = cellIdentity.getBasestationId();
        O000000o.O00000oO = cellIdentity.getLatitude();
        O000000o.O00000oo = cellIdentity.getLongitude();
        return O000000o;
    }

    @SuppressLint({"NewApi"})
    private static bg O000000o(CellInfoGsm cellInfoGsm, boolean z) {
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        return O000000o(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static bg O000000o(CellInfoLte cellInfoLte, boolean z) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        return O000000o(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static bg O000000o(CellInfoWcdma cellInfoWcdma, boolean z) {
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        return O000000o(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
    }

    private static bg O000000o(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            bg bgVar = new bg(1, false);
            bgVar.O000000o = Integer.parseInt(strArr[0]);
            bgVar.O00000Oo = Integer.parseInt(strArr[1]);
            bgVar.O00000o0 = br.O00000Oo(neighboringCellInfo, "getLac", new Object[0]);
            bgVar.O00000o = neighboringCellInfo.getCid();
            bgVar.O0000Oo = bt.O000000o(neighboringCellInfo.getRssi());
            return bgVar;
        } catch (Throwable th) {
            bp.O000000o(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private void O000000o(CellLocation cellLocation, String[] strArr) {
        if (cellLocation != null && this.O00000o0 != null) {
            this.O00000Oo.clear();
            if (O00000Oo(cellLocation)) {
                this.O000000o = 1;
                this.O00000Oo.add(O00000o0(cellLocation, strArr));
                List<NeighboringCellInfo> neighboringCellInfo = this.O00000o0.getNeighboringCellInfo();
                if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                    for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                        if (neighboringCellInfo2 != null && O000000o(neighboringCellInfo2.getLac(), neighboringCellInfo2.getCid())) {
                            bg O000000o = O000000o(neighboringCellInfo2, strArr);
                            if (!(O000000o == null || this.O00000Oo.contains(O000000o))) {
                                this.O00000Oo.add(O000000o);
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean O000000o(int i) {
        return i > 0 && i <= 15;
    }

    private static boolean O000000o(int i, int i2) {
        return (i == -1 || i == 0 || i > SupportMenu.USER_MASK || i2 == -1 || i2 == 0 || i2 == SupportMenu.USER_MASK || i2 >= 268435455) ? false : true;
    }

    @SuppressLint({"NewApi"})
    private static boolean O000000o(CellIdentityCdma cellIdentityCdma) {
        return cellIdentityCdma != null && cellIdentityCdma.getSystemId() > 0 && cellIdentityCdma.getNetworkId() >= 0 && cellIdentityCdma.getBasestationId() >= 0;
    }

    @SuppressLint({"NewApi"})
    private static boolean O000000o(CellIdentityGsm cellIdentityGsm) {
        return cellIdentityGsm != null && O00000o0(cellIdentityGsm.getLac()) && O00000o(cellIdentityGsm.getCid());
    }

    @SuppressLint({"NewApi"})
    private static boolean O000000o(CellIdentityLte cellIdentityLte) {
        return cellIdentityLte != null && O00000o0(cellIdentityLte.getTac()) && O00000o(cellIdentityLte.getCi());
    }

    @SuppressLint({"NewApi"})
    private static boolean O000000o(CellIdentityWcdma cellIdentityWcdma) {
        return cellIdentityWcdma != null && O00000o0(cellIdentityWcdma.getLac()) && O00000o(cellIdentityWcdma.getCid());
    }

    private void O00000Oo(int i) {
        if (i == -113) {
            this.O0000o0O = -113;
            return;
        }
        this.O0000o0O = i;
        switch (this.O000000o) {
            case 1:
            case 2:
                if (!(this.O00000Oo == null || this.O00000Oo.isEmpty())) {
                    try {
                        ((bg) this.O00000Oo.get(0)).O0000Oo = this.O0000o0O;
                    } catch (Throwable unused) {
                    }
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A:{RETURN} */
    private void O00000Oo(android.telephony.CellLocation r5, java.lang.String[] r6) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r4.O00000Oo;
        r0.clear();
        r0 = com.amap.api.mapcore.util.bt.O00000o0();
        r1 = 5;
        if (r0 >= r1) goto L_0x0010;
    L_0x000f:
        return;
    L_0x0010:
        r0 = r4.O0000o;	 Catch:{ Throwable -> 0x00c8 }
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0040;
    L_0x0016:
        r0 = r5.getClass();	 Catch:{ Throwable -> 0x003c }
        r3 = "mGsmCellLoc";
        r0 = r0.getDeclaredField(r3);	 Catch:{ Throwable -> 0x003c }
        r3 = r0.isAccessible();	 Catch:{ Throwable -> 0x003c }
        if (r3 != 0) goto L_0x0029;
    L_0x0026:
        r0.setAccessible(r1);	 Catch:{ Throwable -> 0x003c }
    L_0x0029:
        r0 = r0.get(r5);	 Catch:{ Throwable -> 0x003c }
        r0 = (android.telephony.gsm.GsmCellLocation) r0;	 Catch:{ Throwable -> 0x003c }
        if (r0 == 0) goto L_0x003c;
    L_0x0031:
        r3 = r4.O00000Oo(r0);	 Catch:{ Throwable -> 0x003c }
        if (r3 == 0) goto L_0x003c;
    L_0x0037:
        r4.O000000o(r0, r6);	 Catch:{ Throwable -> 0x003c }
        r0 = r1;
        goto L_0x003d;
    L_0x003c:
        r0 = r2;
    L_0x003d:
        if (r0 == 0) goto L_0x0040;
    L_0x003f:
        return;
    L_0x0040:
        r0 = r4.O00000Oo(r5);	 Catch:{ Throwable -> 0x00c8 }
        if (r0 != 0) goto L_0x0047;
    L_0x0046:
        return;
    L_0x0047:
        r0 = 2;
        r4.O000000o = r0;	 Catch:{ Throwable -> 0x00c8 }
        r3 = new com.amap.api.mapcore.util.bg;	 Catch:{ Throwable -> 0x00c8 }
        r3.<init>(r0, r1);	 Catch:{ Throwable -> 0x00c8 }
        r0 = r6[r2];	 Catch:{ Throwable -> 0x00c8 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Throwable -> 0x00c8 }
        r3.O000000o = r0;	 Catch:{ Throwable -> 0x00c8 }
        r6 = r6[r1];	 Catch:{ Throwable -> 0x00c8 }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ Throwable -> 0x00c8 }
        r3.O00000Oo = r6;	 Catch:{ Throwable -> 0x00c8 }
        r6 = "getSystemId";
        r0 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00c8 }
        r6 = com.amap.api.mapcore.util.br.O00000Oo(r5, r6, r0);	 Catch:{ Throwable -> 0x00c8 }
        r3.O0000O0o = r6;	 Catch:{ Throwable -> 0x00c8 }
        r6 = "getNetworkId";
        r0 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00c8 }
        r6 = com.amap.api.mapcore.util.br.O00000Oo(r5, r6, r0);	 Catch:{ Throwable -> 0x00c8 }
        r3.O0000OOo = r6;	 Catch:{ Throwable -> 0x00c8 }
        r6 = "getBaseStationId";
        r0 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00c8 }
        r6 = com.amap.api.mapcore.util.br.O00000Oo(r5, r6, r0);	 Catch:{ Throwable -> 0x00c8 }
        r3.O0000Oo0 = r6;	 Catch:{ Throwable -> 0x00c8 }
        r6 = r4.O0000o0O;	 Catch:{ Throwable -> 0x00c8 }
        r3.O0000Oo = r6;	 Catch:{ Throwable -> 0x00c8 }
        r6 = "getBaseStationLatitude";
        r0 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00c8 }
        r6 = com.amap.api.mapcore.util.br.O00000Oo(r5, r6, r0);	 Catch:{ Throwable -> 0x00c8 }
        r3.O00000oO = r6;	 Catch:{ Throwable -> 0x00c8 }
        r6 = "getBaseStationLongitude";
        r0 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00c8 }
        r5 = com.amap.api.mapcore.util.br.O00000Oo(r5, r6, r0);	 Catch:{ Throwable -> 0x00c8 }
        r3.O00000oo = r5;	 Catch:{ Throwable -> 0x00c8 }
        r5 = r3.O00000oO;	 Catch:{ Throwable -> 0x00c8 }
        r6 = r3.O00000oo;	 Catch:{ Throwable -> 0x00c8 }
        if (r5 != r6) goto L_0x00a0;
    L_0x009b:
        r5 = r3.O00000oO;	 Catch:{ Throwable -> 0x00c8 }
        if (r5 <= 0) goto L_0x00a0;
    L_0x009f:
        goto L_0x00a1;
    L_0x00a0:
        r1 = r2;
    L_0x00a1:
        r5 = r3.O00000oO;	 Catch:{ Throwable -> 0x00c8 }
        if (r5 < 0) goto L_0x00b6;
    L_0x00a5:
        r5 = r3.O00000oo;	 Catch:{ Throwable -> 0x00c8 }
        if (r5 < 0) goto L_0x00b6;
    L_0x00a9:
        r5 = r3.O00000oO;	 Catch:{ Throwable -> 0x00c8 }
        r6 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r5 == r6) goto L_0x00b6;
    L_0x00b0:
        r5 = r3.O00000oo;	 Catch:{ Throwable -> 0x00c8 }
        if (r5 == r6) goto L_0x00b6;
    L_0x00b4:
        if (r1 == 0) goto L_0x00ba;
    L_0x00b6:
        r3.O00000oO = r2;	 Catch:{ Throwable -> 0x00c8 }
        r3.O00000oo = r2;	 Catch:{ Throwable -> 0x00c8 }
    L_0x00ba:
        r5 = r4.O00000Oo;	 Catch:{ Throwable -> 0x00c8 }
        r5 = r5.contains(r3);	 Catch:{ Throwable -> 0x00c8 }
        if (r5 != 0) goto L_0x00c7;
    L_0x00c2:
        r5 = r4.O00000Oo;	 Catch:{ Throwable -> 0x00c8 }
        r5.add(r3);	 Catch:{ Throwable -> 0x00c8 }
    L_0x00c7:
        return;
    L_0x00c8:
        r5 = move-exception;
        r6 = "CgiManager";
        r0 = "hdlCdmaLocChange";
        com.amap.api.mapcore.util.bp.O000000o(r5, r6, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bh.O00000Oo(android.telephony.CellLocation, java.lang.String[]):void");
    }

    private boolean O00000Oo(CellLocation cellLocation) {
        boolean O000000o = O000000o(cellLocation);
        if (!O000000o) {
            this.O000000o = 0;
        }
        return O000000o;
    }

    private static boolean O00000o(int i) {
        return (i == -1 || i == 0 || i == SupportMenu.USER_MASK || i >= 268435455) ? false : true;
    }

    private int O00000o0(CellLocation cellLocation) {
        if (this.O0000Oo0 || cellLocation == null) {
            return 0;
        }
        if (cellLocation instanceof GsmCellLocation) {
            return 1;
        }
        try {
            Class.forName("android.telephony.cdma.CdmaCellLocation");
            return 2;
        } catch (Throwable th) {
            bp.O000000o(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    private bg O00000o0(CellLocation cellLocation, String[] strArr) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        bg bgVar = new bg(1, true);
        bgVar.O000000o = bt.O00000o(strArr[0]);
        bgVar.O00000Oo = bt.O00000o(strArr[1]);
        bgVar.O00000o0 = gsmCellLocation.getLac();
        bgVar.O00000o = gsmCellLocation.getCid();
        bgVar.O0000Oo = this.O0000o0O;
        return bgVar;
    }

    private static boolean O00000o0(int i) {
        return (i == -1 || i == 0 || i > SupportMenu.USER_MASK) ? false : true;
    }

    private void O0000Oo() {
        if (this.O00000o0 != null) {
            try {
                CellLocation cellLocation = this.O00000o0.getCellLocation();
                Context context = this.O0000Ooo;
                this.O000000o = O00000o0(cellLocation);
            } catch (SecurityException e) {
                this.O0000OOo = e.getMessage();
            } catch (Throwable th) {
                this.O0000OOo = null;
                bp.O000000o(th, "CgiManager", "CgiManager");
                this.O000000o = 0;
            }
            try {
                Context context2;
                String str;
                this.O0000oO0 = O0000oOo();
                switch (this.O0000oO0) {
                    case 1:
                        context2 = this.O0000Ooo;
                        str = "phone_msim";
                        break;
                    case 2:
                        context2 = this.O0000Ooo;
                        str = "phone2";
                        break;
                    default:
                        context2 = this.O0000Ooo;
                        str = "phone2";
                        break;
                }
                this.O0000o = bt.O000000o(context2, str);
            } catch (Throwable unused) {
            }
            if (this.O0000OoO == null) {
                this.O0000OoO = new O000000o("listenerPhoneStateThread");
                this.O0000OoO.start();
            }
        }
    }

    private void O0000OoO() {
        int O00000Oo;
        this.O0000O0o = new PhoneStateListener() {
            public final void onCellLocationChanged(CellLocation cellLocation) {
                try {
                    if (bh.this.O000000o(cellLocation)) {
                        bh.this.O00000oO = cellLocation;
                        bh.this.O00000oo = true;
                        bh.this.O0000oO = bt.O00000Oo();
                    }
                } catch (Throwable unused) {
                }
            }

            public final void onServiceStateChanged(ServiceState serviceState) {
                try {
                    switch (serviceState.getState()) {
                        case 0:
                            bh.this.O00000oo();
                            break;
                        case 1:
                            bh.this.O0000OOo();
                            return;
                        default:
                            return;
                    }
                } catch (Throwable unused) {
                }
            }

            public final void onSignalStrengthChanged(int i) {
                int i2 = -113;
                try {
                    switch (bh.this.O000000o) {
                        case 1:
                        case 2:
                            i2 = bt.O000000o(i);
                            break;
                        default:
                            break;
                    }
                    bh.this.O00000Oo(i2);
                } catch (Throwable unused) {
                }
            }

            public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                if (signalStrength != null) {
                    int i = -113;
                    try {
                        switch (bh.this.O000000o) {
                            case 1:
                                i = bt.O000000o(signalStrength.getGsmSignalStrength());
                                break;
                            case 2:
                                i = signalStrength.getCdmaDbm();
                                break;
                            default:
                                break;
                        }
                        bh.this.O00000Oo(i);
                    } catch (Throwable unused) {
                    }
                }
            }
        };
        try {
            O00000Oo = br.O00000Oo("android.telephony.PhoneStateListener", bt.O00000o0() < 7 ? "LISTEN_SIGNAL_STRENGTH" : "LISTEN_SIGNAL_STRENGTHS");
        } catch (Throwable unused) {
            O00000Oo = 0;
        }
        if (O00000Oo == 0) {
            try {
                this.O00000o0.listen(this.O0000O0o, 16);
            } catch (Throwable unused2) {
            }
        } else {
            try {
                this.O00000o0.listen(this.O0000O0o, O00000Oo | 16);
            } catch (Throwable unused3) {
            }
        }
    }

    private CellLocation O0000Ooo() {
        if (this.O00000o0 != null) {
            try {
                CellLocation cellLocation = this.O00000o0.getCellLocation();
                this.O0000OOo = null;
                if (O00000Oo(cellLocation)) {
                    this.O00000oO = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e) {
                this.O0000OOo = e.getMessage();
            } catch (Throwable th) {
                this.O0000OOo = null;
                bp.O000000o(th, "CgiManager", "getCellLocation");
                return null;
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private CellLocation O0000o() {
        TelephonyManager telephonyManager = this.O00000o0;
        CellLocation cellLocation = null;
        if (telephonyManager == null) {
            return null;
        }
        CellLocation O0000Ooo = O0000Ooo();
        if (O00000Oo(O0000Ooo)) {
            return O0000Ooo;
        }
        if (bt.O00000o0() >= 18) {
            try {
                cellLocation = O000000o(telephonyManager.getAllCellInfo());
            } catch (SecurityException e) {
                this.O0000OOo = e.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        cellLocation = O000000o(telephonyManager, "getCellLocationExt", Integer.valueOf(1));
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation O000000o = O000000o(telephonyManager, "getCellLocationGemini", Integer.valueOf(1));
        if (O000000o != null) {
        }
        return O000000o;
    }

    private void O0000o0() {
        O0000OOo();
    }

    private boolean O0000o00() {
        return !this.O0000Oo0 && bt.O00000Oo() - this.O00000o >= 10000;
    }

    private void O0000o0O() {
        switch (O00000o()) {
            case 1:
                if (this.O00000Oo.isEmpty()) {
                    this.O000000o = 0;
                    break;
                }
                break;
            case 2:
                if (this.O00000Oo.isEmpty()) {
                    this.O000000o = 0;
                    return;
                }
                break;
            default:
                return;
        }
    }

    private void O0000o0o() {
        CellLocation O0000o;
        if (!(this.O0000Oo0 || this.O00000o0 == null)) {
            O0000o = O0000o();
            if (!O00000Oo(O0000o)) {
                O0000o = O0000oO0();
            }
            if (O00000Oo(O0000o)) {
                this.O00000oO = O0000o;
                this.O0000oO = bt.O00000Oo();
            } else if (bt.O00000Oo() - this.O0000oO > 60000) {
                this.O00000oO = null;
                this.O00000Oo.clear();
                this.O0000o0.clear();
            }
        }
        if (!this.O00000oo) {
            O0000o = this.O00000oO;
        }
        this.O00000oo = true;
        if (O00000Oo(this.O00000oO)) {
            String[] O000000o = bt.O000000o(this.O00000o0);
            CellLocation cellLocation = this.O00000oO;
            Context context = this.O0000Ooo;
            switch (O00000o0(cellLocation)) {
                case 1:
                    O000000o(this.O00000oO, O000000o);
                    break;
                case 2:
                    O00000Oo(this.O00000oO, O000000o);
                    break;
            }
        }
        try {
            if (bt.O00000o0() >= 18) {
                O0000oOO();
            }
        } catch (Throwable unused) {
        }
        if (this.O00000o0 != null) {
            this.O0000o00 = this.O00000o0.getNetworkOperator();
            if (!TextUtils.isEmpty(this.O0000o00)) {
                this.O000000o |= 8;
            }
        }
    }

    private Class<?> O0000oO() {
        String str;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (this.O0000oO0) {
            case 0:
                str = "android.telephony.TelephonyManager";
                break;
            case 1:
                str = "android.telephony.MSimTelephonyManager";
                break;
            case 2:
                str = "android.telephony.TelephonyManager2";
                break;
            default:
                str = null;
                break;
        }
        try {
            return systemClassLoader.loadClass(str);
        } catch (Throwable th) {
            bp.O000000o(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    private CellLocation O0000oO0() {
        Throwable th;
        Object obj = this.O0000o;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class O0000oO = O0000oO();
            if (O0000oO.isInstance(obj)) {
                obj = O0000oO.cast(obj);
                String str = "getCellLocation";
                CellLocation O000000o = O000000o(obj, str, new Object[0]);
                if (O000000o != null) {
                    return O000000o;
                }
                try {
                    CellLocation O000000o2 = O000000o(obj, str, Integer.valueOf(1));
                    if (O000000o2 != null) {
                        return O000000o2;
                    }
                    try {
                        O000000o = O000000o(obj, "getCellLocationGemini", Integer.valueOf(1));
                        if (O000000o != null) {
                            return O000000o;
                        }
                        cellLocation = O000000o(obj, "getAllCellInfo", Integer.valueOf(1));
                        if (cellLocation != null) {
                            return cellLocation;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cellLocation = O000000o2;
                        bp.O000000o(th, "CgiManager", "getSim2Cgi");
                        return cellLocation;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cellLocation = O000000o;
                    bp.O000000o(th, "CgiManager", "getSim2Cgi");
                    return cellLocation;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bp.O000000o(th, "CgiManager", "getSim2Cgi");
            return cellLocation;
        }
        return cellLocation;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0022  */
    @android.annotation.SuppressLint({"NewApi"})
    private void O0000oOO() {
        /*
        r11 = this;
        r0 = r11.O00000o0;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r11.O0000o0;
        r1 = r11.O0000o0o;
        r2 = 0;
        r3 = r11.O00000o0;	 Catch:{ SecurityException -> 0x0019 }
        r3 = r3.getAllCellInfo();	 Catch:{ SecurityException -> 0x0019 }
        r11.O0000OOo = r2;	 Catch:{ SecurityException -> 0x0014 }
        r2 = r3;
        goto L_0x0020;
    L_0x0014:
        r2 = move-exception;
        r10 = r3;
        r3 = r2;
        r2 = r10;
        goto L_0x001a;
    L_0x0019:
        r3 = move-exception;
    L_0x001a:
        r3 = r3.getMessage();
        r11.O0000OOo = r3;
    L_0x0020:
        if (r2 == 0) goto L_0x00c3;
    L_0x0022:
        r3 = r2.size();
        if (r3 == 0) goto L_0x00c3;
    L_0x0028:
        if (r0 == 0) goto L_0x002d;
    L_0x002a:
        r0.clear();
    L_0x002d:
        r4 = 0;
    L_0x002e:
        if (r4 >= r3) goto L_0x00c3;
    L_0x0030:
        r5 = r2.get(r4);
        r5 = (android.telephony.CellInfo) r5;
        if (r5 == 0) goto L_0x00bf;
    L_0x0038:
        r6 = r5.isRegistered();	 Catch:{ Throwable -> 0x00bf }
        r7 = r5 instanceof android.telephony.CellInfoCdma;	 Catch:{ Throwable -> 0x00bf }
        r8 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r7 == 0) goto L_0x0065;
    L_0x0043:
        r5 = (android.telephony.CellInfoCdma) r5;	 Catch:{ Throwable -> 0x00bf }
        r7 = r5.getCellIdentity();	 Catch:{ Throwable -> 0x00bf }
        r7 = O000000o(r7);	 Catch:{ Throwable -> 0x00bf }
        if (r7 != 0) goto L_0x0051;
    L_0x004f:
        goto L_0x00bf;
    L_0x0051:
        r5 = r11.O000000o(r5, r6);	 Catch:{ Throwable -> 0x00bf }
        r6 = r1.O000000o(r5);	 Catch:{ Throwable -> 0x00bf }
        r6 = java.lang.Math.min(r8, r6);	 Catch:{ Throwable -> 0x00bf }
    L_0x005d:
        r6 = (int) r6;	 Catch:{ Throwable -> 0x00bf }
        r6 = (short) r6;	 Catch:{ Throwable -> 0x00bf }
        r5.O0000Ooo = r6;	 Catch:{ Throwable -> 0x00bf }
        r0.add(r5);	 Catch:{ Throwable -> 0x00bf }
        goto L_0x00bf;
    L_0x0065:
        r7 = r5 instanceof android.telephony.CellInfoGsm;	 Catch:{ Throwable -> 0x00bf }
        if (r7 == 0) goto L_0x0083;
    L_0x0069:
        r5 = (android.telephony.CellInfoGsm) r5;	 Catch:{ Throwable -> 0x00bf }
        r7 = r5.getCellIdentity();	 Catch:{ Throwable -> 0x00bf }
        r7 = O000000o(r7);	 Catch:{ Throwable -> 0x00bf }
        if (r7 != 0) goto L_0x0076;
    L_0x0075:
        goto L_0x00bf;
    L_0x0076:
        r5 = O000000o(r5, r6);	 Catch:{ Throwable -> 0x00bf }
        r6 = r1.O000000o(r5);	 Catch:{ Throwable -> 0x00bf }
        r6 = java.lang.Math.min(r8, r6);	 Catch:{ Throwable -> 0x00bf }
        goto L_0x005d;
    L_0x0083:
        r7 = r5 instanceof android.telephony.CellInfoWcdma;	 Catch:{ Throwable -> 0x00bf }
        if (r7 == 0) goto L_0x00a1;
    L_0x0087:
        r5 = (android.telephony.CellInfoWcdma) r5;	 Catch:{ Throwable -> 0x00bf }
        r7 = r5.getCellIdentity();	 Catch:{ Throwable -> 0x00bf }
        r7 = O000000o(r7);	 Catch:{ Throwable -> 0x00bf }
        if (r7 != 0) goto L_0x0094;
    L_0x0093:
        goto L_0x00bf;
    L_0x0094:
        r5 = O000000o(r5, r6);	 Catch:{ Throwable -> 0x00bf }
        r6 = r1.O000000o(r5);	 Catch:{ Throwable -> 0x00bf }
        r6 = java.lang.Math.min(r8, r6);	 Catch:{ Throwable -> 0x00bf }
        goto L_0x005d;
    L_0x00a1:
        r7 = r5 instanceof android.telephony.CellInfoLte;	 Catch:{ Throwable -> 0x00bf }
        if (r7 == 0) goto L_0x00bf;
    L_0x00a5:
        r5 = (android.telephony.CellInfoLte) r5;	 Catch:{ Throwable -> 0x00bf }
        r7 = r5.getCellIdentity();	 Catch:{ Throwable -> 0x00bf }
        r7 = O000000o(r7);	 Catch:{ Throwable -> 0x00bf }
        if (r7 != 0) goto L_0x00b2;
    L_0x00b1:
        goto L_0x00bf;
    L_0x00b2:
        r5 = O000000o(r5, r6);	 Catch:{ Throwable -> 0x00bf }
        r6 = r1.O000000o(r5);	 Catch:{ Throwable -> 0x00bf }
        r6 = java.lang.Math.min(r8, r6);	 Catch:{ Throwable -> 0x00bf }
        goto L_0x005d;
    L_0x00bf:
        r4 = r4 + 1;
        goto L_0x002e;
    L_0x00c3:
        if (r0 == 0) goto L_0x00d4;
    L_0x00c5:
        r2 = r0.size();
        if (r2 <= 0) goto L_0x00d4;
    L_0x00cb:
        r2 = r11.O000000o;
        r2 = r2 | 4;
        r11.O000000o = r2;
        r1.O000000o(r0);
    L_0x00d4:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bh.O0000oOO():void");
    }

    private int O0000oOo() {
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            this.O0000oO0 = 1;
        } catch (Throwable unused) {
        }
        if (this.O0000oO0 == 0) {
            try {
                Class.forName("android.telephony.TelephonyManager2");
                this.O0000oO0 = 2;
            } catch (Throwable unused2) {
            }
        }
        return this.O0000oO0;
    }

    public final ArrayList<bg> O000000o() {
        return this.O00000Oo;
    }

    /* Access modifiers changed, original: final */
    public final boolean O000000o(android.telephony.CellLocation r5) {
        /*
        r4 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 1;
        r2 = r4.O0000Ooo;
        r2 = r4.O00000o0(r5);
        switch(r2) {
            case 1: goto L_0x0035;
            case 2: goto L_0x000f;
            default: goto L_0x000e;
        };
    L_0x000e:
        return r1;
    L_0x000f:
        r2 = "getSystemId";
        r3 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x002f }
        r2 = com.amap.api.mapcore.util.br.O00000Oo(r5, r2, r3);	 Catch:{ Throwable -> 0x002f }
        if (r2 <= 0) goto L_0x002d;
    L_0x0019:
        r2 = "getNetworkId";
        r3 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x002f }
        r2 = com.amap.api.mapcore.util.br.O00000Oo(r5, r2, r3);	 Catch:{ Throwable -> 0x002f }
        if (r2 < 0) goto L_0x002d;
    L_0x0023:
        r2 = "getBaseStationId";
        r3 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x002f }
        r5 = com.amap.api.mapcore.util.br.O00000Oo(r5, r2, r3);	 Catch:{ Throwable -> 0x002f }
        if (r5 >= 0) goto L_0x004d;
    L_0x002d:
        r1 = r0;
        return r1;
    L_0x002f:
        r5 = move-exception;
        r0 = "CgiManager";
        r2 = "cgiUseful Cgi.I_CDMA_T";
        goto L_0x004a;
    L_0x0035:
        r5 = (android.telephony.gsm.GsmCellLocation) r5;	 Catch:{ Throwable -> 0x0045 }
        r0 = r5.getLac();	 Catch:{ Throwable -> 0x0045 }
        r5 = r5.getCid();	 Catch:{ Throwable -> 0x0045 }
        r5 = O000000o(r0, r5);	 Catch:{ Throwable -> 0x0045 }
        r1 = r5;
        return r1;
    L_0x0045:
        r5 = move-exception;
        r0 = "CgiManager";
        r2 = "cgiUseful Cgi.I_GSM_T";
    L_0x004a:
        com.amap.api.mapcore.util.bp.O000000o(r5, r0, r2);
    L_0x004d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bh.O000000o(android.telephony.CellLocation):boolean");
    }

    public final ArrayList<bg> O00000Oo() {
        return this.O0000o0;
    }

    public final int O00000o() {
        return this.O000000o & 3;
    }

    public final int O00000o0() {
        return this.O000000o;
    }

    public final TelephonyManager O00000oO() {
        return this.O00000o0;
    }

    public final void O00000oo() {
        try {
            this.O0000Oo0 = bt.O000000o(this.O0000Ooo);
            if (O0000o00() || this.O00000Oo.isEmpty()) {
                O0000o0o();
                this.O00000o = bt.O00000Oo();
            }
            if (this.O0000Oo0) {
                O0000o0();
            } else {
                O0000o0O();
            }
        } catch (SecurityException e) {
            this.O0000OOo = e.getMessage();
        } catch (Throwable th) {
            bp.O000000o(th, "CgiManager", "refresh");
        }
    }

    public final void O0000O0o() {
        this.O0000o0o.O000000o();
        this.O0000oO = 0;
        synchronized (this.O0000oOo) {
            this.O0000oOO = true;
        }
        if (!(this.O00000o0 == null || this.O0000O0o == null)) {
            try {
                this.O00000o0.listen(this.O0000O0o, 0);
            } catch (Throwable th) {
                bp.O000000o(th, "CgiManager", "destroy");
            }
        }
        this.O0000O0o = null;
        if (this.O0000OoO != null) {
            this.O0000OoO.quit();
            this.O0000OoO = null;
        }
        this.O0000o0O = -113;
        this.O00000o0 = null;
        this.O0000o = null;
    }

    /* Access modifiers changed, original: final */
    public final void O0000OOo() {
        this.O0000OOo = null;
        this.O00000oO = null;
        this.O000000o = 0;
        this.O00000Oo.clear();
        this.O0000o0.clear();
    }

    public final String O0000Oo0() {
        return this.O0000o00;
    }
}
