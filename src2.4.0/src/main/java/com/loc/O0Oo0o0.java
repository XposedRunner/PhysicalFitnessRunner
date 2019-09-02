package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
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
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
/* compiled from: CgiManager */
public final class O0Oo0o0 {
    int O000000o = 0;
    ArrayList<O0OO0O> O00000Oo = new ArrayList();
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
    private ArrayList<O0OO0O> O0000o0 = new ArrayList();
    private String O0000o00 = null;
    private int O0000o0O = -113;
    private O0OO00O O0000o0o = null;
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
        /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0044 */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:3|4|(6:6|(1:8)(2:11|12)|9|10|15|(2:17|18)(1:19))|20|21) */
        public final void onLooperPrepared() {
            /*
            r6 = this;
            super.onLooperPrepared();	 Catch:{ Throwable -> 0x0049 }
            r0 = com.loc.O0Oo0o0.this;	 Catch:{ Throwable -> 0x0049 }
            r0 = r0.O0000oOo;	 Catch:{ Throwable -> 0x0049 }
            monitor-enter(r0);	 Catch:{ Throwable -> 0x0049 }
            r1 = com.loc.O0Oo0o0.this;	 Catch:{ all -> 0x0046 }
            r1 = r1.O0000oOO;	 Catch:{ all -> 0x0046 }
            if (r1 != 0) goto L_0x0044;
        L_0x0012:
            r1 = com.loc.O0Oo0o0.this;	 Catch:{ all -> 0x0046 }
            r2 = new com.loc.O0Oo0o0$1;	 Catch:{ all -> 0x0046 }
            r2.<init>();	 Catch:{ all -> 0x0046 }
            r1.O0000O0o = r2;	 Catch:{ all -> 0x0046 }
            r2 = "android.telephony.PhoneStateListener";
            r3 = 0;
            r4 = com.loc.OO000OO.O00000o();	 Catch:{ all -> 0x0046 }
            r5 = 7;
            if (r4 >= r5) goto L_0x002c;
        L_0x0025:
            r4 = "LISTEN_SIGNAL_STRENGTH";
        L_0x0027:
            r2 = com.loc.O0o.O00000Oo(r2, r4);	 Catch:{ Throwable -> 0x002f }
            goto L_0x0030;
        L_0x002c:
            r4 = "LISTEN_SIGNAL_STRENGTHS";
            goto L_0x0027;
        L_0x002f:
            r2 = r3;
        L_0x0030:
            r3 = 16;
            if (r2 != 0) goto L_0x003c;
        L_0x0034:
            r2 = r1.O00000o0;	 Catch:{ Throwable -> 0x0044 }
            r1 = r1.O0000O0o;	 Catch:{ Throwable -> 0x0044 }
            r2.listen(r1, r3);	 Catch:{ Throwable -> 0x0044 }
            goto L_0x0044;
        L_0x003c:
            r4 = r1.O00000o0;	 Catch:{ Throwable -> 0x0044 }
            r1 = r1.O0000O0o;	 Catch:{ Throwable -> 0x0044 }
            r2 = r2 | r3;
            r4.listen(r1, r2);	 Catch:{ Throwable -> 0x0044 }
        L_0x0044:
            monitor-exit(r0);	 Catch:{ all -> 0x0046 }
            return;
        L_0x0046:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ Throwable -> 0x0049 }
            throw r1;	 Catch:{ Throwable -> 0x0049 }
        L_0x0049:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo0o0$O000000o.onLooperPrepared():void");
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
            r0 = com.loc.O0Oo0o0.this;	 Catch:{ Throwable -> 0x0018 }
            r0 = r0.O00000o0;	 Catch:{ Throwable -> 0x0018 }
            r1 = com.loc.O0Oo0o0.this;	 Catch:{ Throwable -> 0x0018 }
            r1 = r1.O0000O0o;	 Catch:{ Throwable -> 0x0018 }
            r2 = 0;
            r0.listen(r1, r2);	 Catch:{ Throwable -> 0x0018 }
            r0 = com.loc.O0Oo0o0.this;	 Catch:{ Throwable -> 0x0018 }
            r1 = 0;
            r0.O0000O0o = r1;	 Catch:{ Throwable -> 0x0018 }
            r3.quit();	 Catch:{ Throwable -> 0x0018 }
        L_0x0018:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo0o0$O000000o.run():void");
        }
    }

    public O0Oo0o0(Context context) {
        this.O0000Ooo = context;
        if (this.O00000o0 == null) {
            this.O00000o0 = (TelephonyManager) OO000OO.O000000o(this.O0000Ooo, "phone");
        }
        if (this.O00000o0 != null) {
            try {
                CellLocation cellLocation = this.O00000o0.getCellLocation();
                Context context2 = this.O0000Ooo;
                this.O000000o = O00000o0(cellLocation);
            } catch (SecurityException e) {
                this.O0000OOo = e.getMessage();
            } catch (Throwable th) {
                this.O0000OOo = null;
                O0o0000.O000000o(th, "CgiManager", "CgiManager");
                this.O000000o = 0;
            }
            try {
                String str;
                this.O0000oO0 = O0000oO0();
                switch (this.O0000oO0) {
                    case 1:
                        context = this.O0000Ooo;
                        str = "phone_msim";
                        break;
                    case 2:
                        context = this.O0000Ooo;
                        str = "phone2";
                        break;
                    default:
                        context = this.O0000Ooo;
                        str = "phone2";
                        break;
                }
                this.O0000o = OO000OO.O000000o(context, str);
            } catch (Throwable unused) {
            }
            if (this.O0000OoO == null) {
                this.O0000OoO = new O000000o("listenerPhoneStateThread");
                this.O0000OoO.start();
            }
        }
        this.O0000o0o = new O0OO00O();
    }

    private CellLocation O000000o(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        try {
            obj = O0o.O000000o(obj, str, objArr);
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
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo0o0.O000000o(java.util.List):android.telephony.CellLocation");
    }

    private static O0OO0O O000000o(int i, boolean z, int i2, int i3, int i4, int i5, int i6) {
        O0OO0O o0oo0o = new O0OO0O(i, z);
        o0oo0o.O000000o = i2;
        o0oo0o.O00000Oo = i3;
        o0oo0o.O00000o0 = i4;
        o0oo0o.O00000o = i5;
        o0oo0o.O0000Oo = i6;
        return o0oo0o;
    }

    @SuppressLint({"NewApi"})
    private O0OO0O O000000o(CellInfoCdma cellInfoCdma, boolean z) {
        int parseInt;
        int parseInt2;
        O0OO0O O000000o;
        CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
        String[] O000000o2 = OO000OO.O000000o(this.O00000o0);
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
    private static O0OO0O O000000o(CellInfoGsm cellInfoGsm, boolean z) {
        CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
        return O000000o(1, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoGsm.getCellSignalStrength().getDbm());
    }

    @SuppressLint({"NewApi"})
    private static O0OO0O O000000o(CellInfoLte cellInfoLte, boolean z) {
        CellIdentityLte cellIdentity = cellInfoLte.getCellIdentity();
        O0OO0O O000000o = O000000o(3, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getTac(), cellIdentity.getCi(), cellInfoLte.getCellSignalStrength().getDbm());
        O000000o.O0000o0O = cellIdentity.getPci();
        return O000000o;
    }

    @SuppressLint({"NewApi"})
    private static O0OO0O O000000o(CellInfoWcdma cellInfoWcdma, boolean z) {
        CellIdentityWcdma cellIdentity = cellInfoWcdma.getCellIdentity();
        O0OO0O O000000o = O000000o(4, z, cellIdentity.getMcc(), cellIdentity.getMnc(), cellIdentity.getLac(), cellIdentity.getCid(), cellInfoWcdma.getCellSignalStrength().getDbm());
        O000000o.O0000o0O = cellIdentity.getPsc();
        return O000000o;
    }

    private static O0OO0O O000000o(NeighboringCellInfo neighboringCellInfo, String[] strArr) {
        try {
            O0OO0O o0oo0o = new O0OO0O(1, false);
            o0oo0o.O000000o = Integer.parseInt(strArr[0]);
            o0oo0o.O00000Oo = Integer.parseInt(strArr[1]);
            o0oo0o.O00000o0 = O0o.O00000Oo(neighboringCellInfo, "getLac", new Object[0]);
            o0oo0o.O00000o = neighboringCellInfo.getCid();
            o0oo0o.O0000Oo = OO000OO.O000000o(neighboringCellInfo.getRssi());
            return o0oo0o;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "CgiManager", "getGsm");
            return null;
        }
    }

    private void O000000o(CellLocation cellLocation, String[] strArr, boolean z) {
        if (cellLocation != null && this.O00000o0 != null) {
            this.O00000Oo.clear();
            if (O00000Oo(cellLocation)) {
                this.O000000o = 1;
                List list = null;
                ArrayList arrayList = this.O00000Oo;
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                O0OO0O o0oo0o = new O0OO0O(1, true);
                o0oo0o.O000000o = OO000OO.O0000OOo(strArr[0]);
                o0oo0o.O00000Oo = OO000OO.O0000OOo(strArr[1]);
                o0oo0o.O00000o0 = gsmCellLocation.getLac();
                o0oo0o.O00000o = gsmCellLocation.getCid();
                o0oo0o.O0000Oo = this.O0000o0O;
                arrayList.add(o0oo0o);
                if (!z) {
                    if (VERSION.SDK_INT <= 28) {
                        list = (List) O0o.O000000o(this.O00000o0, "getNeighboringCellInfo", new Object[0]);
                    }
                    if (list != null && !list.isEmpty()) {
                        for (NeighboringCellInfo neighboringCellInfo : list) {
                            if (neighboringCellInfo != null && O000000o(neighboringCellInfo.getLac(), neighboringCellInfo.getCid())) {
                                O0OO0O O000000o = O000000o(neighboringCellInfo, strArr);
                                if (!(O000000o == null || this.O00000Oo.contains(O000000o))) {
                                    this.O00000Oo.add(O000000o);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean O000000o(int i) {
        return (i == -1 || i == 0 || i > SupportMenu.USER_MASK) ? false : true;
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
        return cellIdentityGsm != null && O000000o(cellIdentityGsm.getLac()) && O00000Oo(cellIdentityGsm.getCid());
    }

    @SuppressLint({"NewApi"})
    private static boolean O000000o(CellIdentityLte cellIdentityLte) {
        return cellIdentityLte != null && O000000o(cellIdentityLte.getTac()) && O00000Oo(cellIdentityLte.getCi());
    }

    @SuppressLint({"NewApi"})
    private static boolean O000000o(CellIdentityWcdma cellIdentityWcdma) {
        return cellIdentityWcdma != null && O000000o(cellIdentityWcdma.getLac()) && O00000Oo(cellIdentityWcdma.getCid());
    }

    private static boolean O00000Oo(int i) {
        return (i == -1 || i == 0 || i == SupportMenu.USER_MASK || i >= 268435455) ? false : true;
    }

    private boolean O00000Oo(CellLocation cellLocation) {
        boolean O000000o = O000000o(cellLocation);
        if (!O000000o) {
            this.O000000o = 0;
        }
        return O000000o;
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
            O0o0000.O000000o(th, "Utils", "getCellLocT");
            return 0;
        }
    }

    private Class<?> O0000o() {
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
            O0o0000.O000000o(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    private CellLocation O0000o0() {
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
                O0o0000.O000000o(th, "CgiManager", "getCellLocation");
                return null;
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private CellLocation O0000o0O() {
        Object obj = this.O00000o0;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        CellLocation O0000o0 = O0000o0();
        if (O00000Oo(O0000o0)) {
            return O0000o0;
        }
        if (OO000OO.O00000o() >= 18) {
            try {
                cellLocation = O000000o(obj.getAllCellInfo());
            } catch (SecurityException e) {
                this.O0000OOo = e.getMessage();
            }
        }
        if (cellLocation != null) {
            return cellLocation;
        }
        cellLocation = O000000o(obj, "getCellLocationExt", Integer.valueOf(1));
        if (cellLocation != null) {
            return cellLocation;
        }
        CellLocation O000000o = O000000o(obj, "getCellLocationGemini", Integer.valueOf(1));
        if (O000000o != null) {
        }
        return O000000o;
    }

    private CellLocation O0000o0o() {
        Throwable th;
        Object obj = this.O0000o;
        CellLocation cellLocation = null;
        if (obj == null) {
            return null;
        }
        try {
            Class O0000o = O0000o();
            if (O0000o.isInstance(obj)) {
                obj = O0000o.cast(obj);
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
                        O0o0000.O000000o(th, "CgiManager", "getSim2Cgi");
                        return cellLocation;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cellLocation = O000000o;
                    O0o0000.O000000o(th, "CgiManager", "getSim2Cgi");
                    return cellLocation;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            O0o0000.O000000o(th, "CgiManager", "getSim2Cgi");
            return cellLocation;
        }
        return cellLocation;
    }

    private int O0000oO0() {
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

    public final ArrayList<O0OO0O> O000000o() {
        return this.O00000Oo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0050 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0089 A:{SYNTHETIC, EDGE_INSN: B:178:0x0089->B:40:0x0089 ?: BREAK  , EDGE_INSN: B:178:0x0089->B:40:0x0089 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0093 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0263 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0287 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0283 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0263 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:150:0x025f */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x025f A:{SYNTHETIC} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:150:0x025f */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02ae A:{Splitter:B:0:0x0000, ExcHandler: SecurityException (r11_50 'e' java.lang.SecurityException)} */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x025f A:{SYNTHETIC} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:150:0x025f */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02ae A:{Splitter:B:0:0x0000, ExcHandler: SecurityException (r11_50 'e' java.lang.SecurityException)} */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02ae A:{Splitter:B:0:0x0000, ExcHandler: SecurityException (r11_50 'e' java.lang.SecurityException)} */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02ae A:{Splitter:B:0:0x0000, ExcHandler: SecurityException (r11_50 'e' java.lang.SecurityException)} */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0263 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0283 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0287 A:{Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:65:0x00e1, code skipped:
            if (r11 == 0) goto L_0x00e5;
     */
    /* JADX WARNING: Missing block: B:89:0x016e, code skipped:
            r11 = move-exception;
     */
    /* JADX WARNING: Missing block: B:91:?, code skipped:
            com.loc.O0o0000.O000000o(r11, "CgiManager", "hdlCdmaLocChange");
     */
    /* JADX WARNING: Missing block: B:175:0x02ae, code skipped:
            r11 = move-exception;
     */
    /* JADX WARNING: Missing block: B:176:0x02af, code skipped:
            r10.O0000OOo = r11.getMessage();
     */
    /* JADX WARNING: Missing block: B:177:0x02b5, code skipped:
            return;
     */
    public final void O000000o(boolean r11, boolean r12) {
        /*
        r10 = this;
        r0 = r10.O0000Ooo;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r0 = com.loc.OO000OO.O000000o(r0);	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r10.O0000Oo0 = r0;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r0 = r10.O0000Oo0;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r1 = 1;
        r2 = 0;
        if (r0 == 0) goto L_0x0010;
    L_0x000e:
        r0 = r2;
        goto L_0x0020;
    L_0x0010:
        r3 = com.loc.OO000OO.O00000o0();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r5 = r10.O00000o;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r7 = r3 - r5;
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r0 >= 0) goto L_0x001f;
    L_0x001e:
        goto L_0x000e;
    L_0x001f:
        r0 = r1;
    L_0x0020:
        if (r0 != 0) goto L_0x002a;
    L_0x0022:
        r0 = r10.O00000Oo;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r0 = r0.isEmpty();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r0 == 0) goto L_0x027f;
    L_0x002a:
        r0 = r10.O0000Oo0;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r3 = 0;
        if (r0 != 0) goto L_0x006b;
    L_0x002f:
        r0 = r10.O00000o0;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r0 == 0) goto L_0x006b;
    L_0x0033:
        r0 = r10.O0000o0O();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r4 = r10.O00000Oo(r0);	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r4 != 0) goto L_0x0041;
    L_0x003d:
        r0 = r10.O0000o0o();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
    L_0x0041:
        r4 = r10.O00000Oo(r0);	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r4 == 0) goto L_0x0050;
    L_0x0047:
        r10.O00000oO = r0;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r4 = com.loc.OO000OO.O00000o0();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r10.O0000oO = r4;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        goto L_0x006b;
    L_0x0050:
        r4 = com.loc.OO000OO.O00000o0();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r6 = r10.O0000oO;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r8 = r4 - r6;
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x006b;
    L_0x005f:
        r10.O00000oO = r3;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r0 = r10.O00000Oo;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r0.clear();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r0 = r10.O0000o0;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r0.clear();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
    L_0x006b:
        r0 = r10.O00000oo;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r0 != 0) goto L_0x0089;
    L_0x006f:
        r0 = r10.O00000oO;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r0 != 0) goto L_0x0089;
    L_0x0073:
        if (r12 == 0) goto L_0x0089;
    L_0x0075:
        r12 = r2;
    L_0x0076:
        r4 = 10;
        java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x007c }
        goto L_0x0080;
    L_0x007c:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
    L_0x0080:
        r12 = r12 + r1;
        r0 = r10.O00000oO;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r0 != 0) goto L_0x0089;
    L_0x0085:
        r0 = 50;
        if (r12 < r0) goto L_0x0076;
    L_0x0089:
        r10.O00000oo = r1;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r12 = r10.O00000oO;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r12 = r10.O00000Oo(r12);	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r12 == 0) goto L_0x017c;
    L_0x0093:
        r12 = r10.O00000o0;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r12 = com.loc.OO000OO.O000000o(r12);	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r0 = r10.O00000oO;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r4 = r10.O0000Ooo;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r0 = r10.O00000o0(r0);	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        switch(r0) {
            case 1: goto L_0x0177;
            case 2: goto L_0x00a6;
            default: goto L_0x00a4;
        };	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
    L_0x00a4:
        goto L_0x017c;
    L_0x00a6:
        r0 = r10.O00000oO;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r0 == 0) goto L_0x017c;
    L_0x00aa:
        r4 = r10.O00000Oo;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r4.clear();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r4 = com.loc.OO000OO.O00000o();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r5 = 5;
        if (r4 < r5) goto L_0x017c;
    L_0x00b6:
        r4 = r10.O0000o;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        if (r4 == 0) goto L_0x00e5;
    L_0x00ba:
        r4 = r0.getClass();	 Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
        r5 = "mGsmCellLoc";
        r4 = r4.getDeclaredField(r5);	 Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
        r5 = r4.isAccessible();	 Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
        if (r5 != 0) goto L_0x00cd;
    L_0x00ca:
        r4.setAccessible(r1);	 Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
    L_0x00cd:
        r4 = r4.get(r0);	 Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
        r4 = (android.telephony.gsm.GsmCellLocation) r4;	 Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
        if (r4 == 0) goto L_0x00e0;
    L_0x00d5:
        r5 = r10.O00000Oo(r4);	 Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
        if (r5 == 0) goto L_0x00e0;
    L_0x00db:
        r10.O000000o(r4, r12, r11);	 Catch:{ Throwable -> 0x00e0, SecurityException -> 0x02ae }
        r11 = r1;
        goto L_0x00e1;
    L_0x00e0:
        r11 = r2;
    L_0x00e1:
        if (r11 == 0) goto L_0x00e5;
    L_0x00e3:
        goto L_0x017c;
    L_0x00e5:
        r11 = r10.O00000Oo(r0);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        if (r11 != 0) goto L_0x00ed;
    L_0x00eb:
        goto L_0x017c;
    L_0x00ed:
        r11 = 2;
        r10.O000000o = r11;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4 = new com.loc.O0OO0O;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4.<init>(r11, r1);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = r12[r2];	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = java.lang.Integer.parseInt(r11);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4.O000000o = r11;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = r12[r1];	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = java.lang.Integer.parseInt(r11);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4.O00000Oo = r11;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = "getSystemId";
        r12 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = com.loc.O0o.O00000Oo(r0, r11, r12);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4.O0000O0o = r11;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = "getNetworkId";
        r12 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = com.loc.O0o.O00000Oo(r0, r11, r12);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4.O0000OOo = r11;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = "getBaseStationId";
        r12 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = com.loc.O0o.O00000Oo(r0, r11, r12);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4.O0000Oo0 = r11;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = r10.O0000o0O;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4.O0000Oo = r11;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = "getBaseStationLatitude";
        r12 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = com.loc.O0o.O00000Oo(r0, r11, r12);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4.O00000oO = r11;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = "getBaseStationLongitude";
        r12 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = com.loc.O0o.O00000Oo(r0, r11, r12);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4.O00000oo = r11;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = r4.O00000oO;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r12 = r4.O00000oo;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        if (r11 != r12) goto L_0x0146;
    L_0x0141:
        r11 = r4.O00000oO;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        if (r11 <= 0) goto L_0x0146;
    L_0x0145:
        goto L_0x0147;
    L_0x0146:
        r1 = r2;
    L_0x0147:
        r11 = r4.O00000oO;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        if (r11 < 0) goto L_0x015c;
    L_0x014b:
        r11 = r4.O00000oo;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        if (r11 < 0) goto L_0x015c;
    L_0x014f:
        r11 = r4.O00000oO;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r12 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r11 == r12) goto L_0x015c;
    L_0x0156:
        r11 = r4.O00000oo;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        if (r11 == r12) goto L_0x015c;
    L_0x015a:
        if (r1 == 0) goto L_0x0160;
    L_0x015c:
        r4.O00000oO = r2;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r4.O00000oo = r2;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
    L_0x0160:
        r11 = r10.O00000Oo;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11 = r11.contains(r4);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        if (r11 != 0) goto L_0x017c;
    L_0x0168:
        r11 = r10.O00000Oo;	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        r11.add(r4);	 Catch:{ Throwable -> 0x016e, SecurityException -> 0x02ae }
        goto L_0x017c;
    L_0x016e:
        r11 = move-exception;
        r12 = "CgiManager";
        r0 = "hdlCdmaLocChange";
        com.loc.O0o0000.O000000o(r11, r12, r0);	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        goto L_0x017c;
    L_0x0177:
        r0 = r10.O00000oO;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r10.O000000o(r0, r12, r11);	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
    L_0x017c:
        r11 = com.loc.OO000OO.O00000o();	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        r12 = 18;
        if (r11 < r12) goto L_0x025f;
    L_0x0184:
        r11 = r10.O00000o0;	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        if (r11 == 0) goto L_0x025f;
    L_0x0188:
        r11 = r10.O0000o0;	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        r12 = r10.O0000o0o;	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        r0 = r10.O00000o0;	 Catch:{ SecurityException -> 0x0197, Throwable -> 0x025f }
        r0 = r0.getAllCellInfo();	 Catch:{ SecurityException -> 0x0197, Throwable -> 0x025f }
        r10.O0000OOo = r3;	 Catch:{ SecurityException -> 0x0195, Throwable -> 0x025f }
        goto L_0x019f;
    L_0x0195:
        r1 = move-exception;
        goto L_0x0199;
    L_0x0197:
        r1 = move-exception;
        r0 = r3;
    L_0x0199:
        r1 = r1.getMessage();	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        r10.O0000OOo = r1;	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
    L_0x019f:
        if (r0 == 0) goto L_0x024e;
    L_0x01a1:
        r1 = r0.size();	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        if (r1 == 0) goto L_0x024e;
    L_0x01a7:
        if (r11 == 0) goto L_0x01ac;
    L_0x01a9:
        r11.clear();	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
    L_0x01ac:
        r3 = r2;
    L_0x01ad:
        if (r3 >= r1) goto L_0x024e;
    L_0x01af:
        r4 = r0.get(r3);	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        r4 = (android.telephony.CellInfo) r4;	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        if (r4 == 0) goto L_0x024a;
    L_0x01b7:
        r5 = r4.isRegistered();	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r6 = r4 instanceof android.telephony.CellInfoCdma;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r7 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r6 == 0) goto L_0x01e4;
    L_0x01c2:
        r4 = (android.telephony.CellInfoCdma) r4;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r6 = r4.getCellIdentity();	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r6 = O000000o(r6);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        if (r6 != 0) goto L_0x01d0;
    L_0x01ce:
        goto L_0x024a;
    L_0x01d0:
        r4 = r10.O000000o(r4, r5);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = r12.O000000o(r4);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = java.lang.Math.min(r7, r5);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = (int) r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = (short) r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r4.O0000Ooo = r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
    L_0x01e0:
        r11.add(r4);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        goto L_0x024a;
    L_0x01e4:
        r6 = r4 instanceof android.telephony.CellInfoGsm;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        if (r6 == 0) goto L_0x0206;
    L_0x01e8:
        r4 = (android.telephony.CellInfoGsm) r4;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r6 = r4.getCellIdentity();	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r6 = O000000o(r6);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        if (r6 != 0) goto L_0x01f5;
    L_0x01f4:
        goto L_0x024a;
    L_0x01f5:
        r4 = O000000o(r4, r5);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = r12.O000000o(r4);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = java.lang.Math.min(r7, r5);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = (int) r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = (short) r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r4.O0000Ooo = r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        goto L_0x01e0;
    L_0x0206:
        r6 = r4 instanceof android.telephony.CellInfoWcdma;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        if (r6 == 0) goto L_0x0228;
    L_0x020a:
        r4 = (android.telephony.CellInfoWcdma) r4;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r6 = r4.getCellIdentity();	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r6 = O000000o(r6);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        if (r6 != 0) goto L_0x0217;
    L_0x0216:
        goto L_0x024a;
    L_0x0217:
        r4 = O000000o(r4, r5);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = r12.O000000o(r4);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = java.lang.Math.min(r7, r5);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = (int) r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = (short) r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r4.O0000Ooo = r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        goto L_0x01e0;
    L_0x0228:
        r6 = r4 instanceof android.telephony.CellInfoLte;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        if (r6 == 0) goto L_0x024a;
    L_0x022c:
        r4 = (android.telephony.CellInfoLte) r4;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r6 = r4.getCellIdentity();	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r6 = O000000o(r6);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        if (r6 != 0) goto L_0x0239;
    L_0x0238:
        goto L_0x024a;
    L_0x0239:
        r4 = O000000o(r4, r5);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = r12.O000000o(r4);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = java.lang.Math.min(r7, r5);	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = (int) r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r5 = (short) r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        r4.O0000Ooo = r5;	 Catch:{ Throwable -> 0x024a, SecurityException -> 0x02ae }
        goto L_0x01e0;
    L_0x024a:
        r3 = r3 + 1;
        goto L_0x01ad;
    L_0x024e:
        if (r11 == 0) goto L_0x025f;
    L_0x0250:
        r0 = r11.size();	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        if (r0 <= 0) goto L_0x025f;
    L_0x0256:
        r0 = r10.O000000o;	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        r0 = r0 | 4;
        r10.O000000o = r0;	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
        r12.O000000o(r11);	 Catch:{ Throwable -> 0x025f, SecurityException -> 0x02ae }
    L_0x025f:
        r11 = r10.O00000o0;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r11 == 0) goto L_0x0279;
    L_0x0263:
        r11 = r10.O00000o0;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r11 = r11.getNetworkOperator();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r10.O0000o00 = r11;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r11 = r10.O0000o00;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r11 = android.text.TextUtils.isEmpty(r11);	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r11 != 0) goto L_0x0279;
    L_0x0273:
        r11 = r10.O000000o;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r11 = r11 | 8;
        r10.O000000o = r11;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
    L_0x0279:
        r11 = com.loc.OO000OO.O00000o0();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r10.O00000o = r11;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
    L_0x027f:
        r11 = r10.O0000Oo0;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r11 == 0) goto L_0x0287;
    L_0x0283:
        r10.O0000Oo0();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        return;
    L_0x0287:
        r11 = r10.O000000o;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r11 = r11 & 3;
        switch(r11) {
            case 1: goto L_0x029a;
            case 2: goto L_0x028f;
            default: goto L_0x028e;
        };	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
    L_0x028e:
        return;
    L_0x028f:
        r11 = r10.O00000Oo;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r11 = r11.isEmpty();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r11 == 0) goto L_0x02a4;
    L_0x0297:
        r10.O000000o = r2;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        return;
    L_0x029a:
        r11 = r10.O00000Oo;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        r11 = r11.isEmpty();	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
        if (r11 == 0) goto L_0x02a4;
    L_0x02a2:
        r10.O000000o = r2;	 Catch:{ SecurityException -> 0x02ae, Throwable -> 0x02a5 }
    L_0x02a4:
        return;
    L_0x02a5:
        r11 = move-exception;
        r12 = "CgiManager";
        r0 = "refresh";
        com.loc.O0o0000.O000000o(r11, r12, r0);
        return;
    L_0x02ae:
        r11 = move-exception;
        r11 = r11.getMessage();
        r10.O0000OOo = r11;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo0o0.O000000o(boolean, boolean):void");
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
        r2 = com.loc.O0o.O00000Oo(r5, r2, r3);	 Catch:{ Throwable -> 0x002f }
        if (r2 <= 0) goto L_0x002d;
    L_0x0019:
        r2 = "getNetworkId";
        r3 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x002f }
        r2 = com.loc.O0o.O00000Oo(r5, r2, r3);	 Catch:{ Throwable -> 0x002f }
        if (r2 < 0) goto L_0x002d;
    L_0x0023:
        r2 = "getBaseStationId";
        r3 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x002f }
        r5 = com.loc.O0o.O00000Oo(r5, r2, r3);	 Catch:{ Throwable -> 0x002f }
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
        com.loc.O0o0000.O000000o(r5, r0, r2);
    L_0x004d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo0o0.O000000o(android.telephony.CellLocation):boolean");
    }

    public final ArrayList<O0OO0O> O00000Oo() {
        return this.O0000o0;
    }

    public final O0OO0O O00000o() {
        if (this.O0000Oo0) {
            return null;
        }
        ArrayList arrayList = this.O0000o0;
        return arrayList.size() > 0 ? (O0OO0O) arrayList.get(0) : null;
    }

    public final O0OO0O O00000o0() {
        if (this.O0000Oo0) {
            return null;
        }
        ArrayList arrayList = this.O00000Oo;
        return arrayList.size() > 0 ? (O0OO0O) arrayList.get(0) : null;
    }

    public final int O00000oO() {
        return this.O000000o;
    }

    public final int O00000oo() {
        return this.O000000o & 3;
    }

    public final TelephonyManager O0000O0o() {
        return this.O00000o0;
    }

    public final void O0000OOo() {
        this.O0000o0o.O000000o();
        this.O0000oO = 0;
        synchronized (this.O0000oOo) {
            this.O0000oOO = true;
        }
        if (!(this.O00000o0 == null || this.O0000O0o == null)) {
            try {
                this.O00000o0.listen(this.O0000O0o, 0);
            } catch (Throwable th) {
                O0o0000.O000000o(th, "CgiManager", "destroy");
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

    public final String O0000Oo() {
        return this.O0000OOo;
    }

    /* Access modifiers changed, original: final */
    public final void O0000Oo0() {
        this.O0000OOo = null;
        this.O00000oO = null;
        this.O000000o = 0;
        this.O00000Oo.clear();
        this.O0000o0.clear();
    }

    public final String O0000OoO() {
        return this.O0000o00;
    }

    public final String O0000Ooo() {
        if (this.O0000Oo0) {
            O0000Oo0();
        }
        if (this.O0000Oo == null) {
            this.O0000Oo = new StringBuilder();
        } else {
            this.O0000Oo.delete(0, this.O0000Oo.length());
        }
        int i = 1;
        if ((this.O000000o & 3) == 1) {
            while (i < this.O00000Oo.size()) {
                StringBuilder stringBuilder = this.O0000Oo;
                stringBuilder.append("#");
                stringBuilder.append(((O0OO0O) this.O00000Oo.get(i)).O00000Oo);
                stringBuilder = this.O0000Oo;
                stringBuilder.append("|");
                stringBuilder.append(((O0OO0O) this.O00000Oo.get(i)).O00000o0);
                stringBuilder = this.O0000Oo;
                stringBuilder.append("|");
                stringBuilder.append(((O0OO0O) this.O00000Oo.get(i)).O00000o);
                i++;
            }
        }
        if (this.O0000Oo.length() > 0) {
            this.O0000Oo.deleteCharAt(0);
        }
        return this.O0000Oo.toString();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* JADX WARNING: Failed to process nested try/catch */
    public final boolean O0000o00() {
        /*
        r3 = this;
        r0 = 1;
        r1 = r3.O00000o0;	 Catch:{ Throwable -> 0x001f }
        if (r1 == 0) goto L_0x001f;
    L_0x0005:
        r1 = r3.O00000o0;	 Catch:{ Throwable -> 0x001f }
        r1 = r1.getSimOperator();	 Catch:{ Throwable -> 0x001f }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x001f }
        if (r1 != 0) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = r3.O00000o0;	 Catch:{ Throwable -> 0x001f }
        r1 = r1.getSimCountryIso();	 Catch:{ Throwable -> 0x001f }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x001f }
        if (r1 != 0) goto L_0x001f;
    L_0x001e:
        return r0;
    L_0x001f:
        r1 = r3.O0000Ooo;	 Catch:{ Throwable -> 0x0038 }
        r1 = com.loc.OO000OO.O00000o0(r1);	 Catch:{ Throwable -> 0x0038 }
        r1 = com.loc.OO000OO.O000000o(r1);	 Catch:{ Throwable -> 0x0038 }
        if (r1 == 0) goto L_0x0037;
    L_0x002b:
        r2 = 4;
        if (r1 == r2) goto L_0x0037;
    L_0x002e:
        r2 = 2;
        if (r1 == r2) goto L_0x0037;
    L_0x0031:
        r2 = 5;
        if (r1 == r2) goto L_0x0037;
    L_0x0034:
        r2 = 3;
        if (r1 != r2) goto L_0x0038;
    L_0x0037:
        return r0;
    L_0x0038:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0Oo0o0.O0000o00():boolean");
    }
}
