package com.baidu.location.e;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.g.j;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@SuppressLint({"NewApi"})
public class b {
    public static int a;
    public static int b;
    private static b c;
    private static Class<?> k;
    private TelephonyManager d = null;
    private a e = new a();
    private a f = null;
    private List<a> g = null;
    private a h = null;
    private boolean i = false;
    private boolean j = false;
    private Handler l = new Handler();

    private class a extends PhoneStateListener {
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation != null) {
                b.this.l.post(new c(this));
            }
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (b.this.e != null) {
                a c;
                int gsmSignalStrength;
                if (b.this.e.i == 'g') {
                    c = b.this.e;
                    gsmSignalStrength = signalStrength.getGsmSignalStrength();
                } else if (b.this.e.i == 'c') {
                    c = b.this.e;
                    gsmSignalStrength = signalStrength.getCdmaDbm();
                }
                c.h = gsmSignalStrength;
            }
        }
    }

    private b() {
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
        r2 = r9.e;
        if (r2 == 0) goto L_0x00ae;
    L_0x00a1:
        r2 = r9.e;
        r2 = r2.c;
        if (r2 <= 0) goto L_0x00ae;
    L_0x00a7:
        r2 = r9.e;
        r2 = r2.c;
    L_0x00ab:
        r1.c = r2;
        goto L_0x0117;
    L_0x00ae:
        r2 = -1;
        r6 = r9.d;	 Catch:{ Exception -> 0x00d4 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.b.a(android.telephony.CellInfo):com.baidu.location.e.a");
    }

    private a a(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    private a a(CellLocation cellLocation, boolean z) {
        if (cellLocation == null || this.d == null) {
            return null;
        }
        a aVar = new a();
        if (z) {
            aVar.f();
        }
        aVar.g = System.currentTimeMillis();
        try {
            String networkOperator = this.d.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                int i = -1;
                if (networkOperator.length() >= 3) {
                    i = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.c = i < 0 ? this.e.c : i;
                }
                networkOperator = networkOperator.substring(3);
                if (networkOperator != null) {
                    char[] toCharArray = networkOperator.toCharArray();
                    int i2 = 0;
                    while (i2 < toCharArray.length) {
                        if (!Character.isDigit(toCharArray[i2])) {
                            break;
                        }
                        i2++;
                    }
                    i = Integer.valueOf(networkOperator.substring(0, i2)).intValue();
                }
                if (i < 0) {
                    i = this.e.d;
                }
                aVar.d = i;
            }
            a = this.d.getSimState();
        } catch (Exception unused) {
            b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            aVar.a = gsmCellLocation.getLac();
            aVar.b = gsmCellLocation.getCid();
            aVar.i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.i = 'c';
            if (k == null) {
                try {
                    k = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused2) {
                    k = null;
                    return aVar;
                }
            }
            if (k != null && k.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.e.d;
                    }
                    aVar.d = systemId;
                    aVar.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    systemId = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (systemId < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                        aVar.e = systemId;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                        aVar.f = baseStationLongitude;
                    }
                } catch (Exception unused3) {
                    b = 3;
                    return aVar;
                }
            }
        }
        c(aVar);
        return aVar;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (c == null) {
                c = new b();
            }
            bVar = c;
        }
        return bVar;
    }

    private void c(a aVar) {
        if (aVar.b() && (this.e == null || !this.e.a(aVar))) {
            this.e = aVar;
            if (aVar.b()) {
                int size = this.g.size();
                aVar = size == 0 ? null : (a) this.g.get(size - 1);
                if (!(aVar != null && aVar.b == this.e.b && aVar.a == this.e.a)) {
                    this.g.add(this.e);
                    if (this.g.size() > 3) {
                        this.g.remove(0);
                    }
                    j();
                    this.j = false;
                }
            } else if (this.g != null) {
                this.g.clear();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private String d(a aVar) {
        StringBuilder stringBuilder = new StringBuilder();
        if (Integer.valueOf(VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.d.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    stringBuilder.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered()) {
                            a a = a(cellInfo);
                            if (a != null) {
                                if (!(a.a == -1 || a.b == -1)) {
                                    StringBuilder stringBuilder2;
                                    if (aVar.a != a.a) {
                                        stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append(a.a);
                                        stringBuilder2.append("|");
                                        stringBuilder2.append(a.b);
                                        stringBuilder2.append("|");
                                        stringBuilder2.append(a.h);
                                        stringBuilder2.append(";");
                                    } else {
                                        stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append("|");
                                        stringBuilder2.append(a.b);
                                        stringBuilder2.append("|");
                                        stringBuilder2.append(a.h);
                                        stringBuilder2.append(";");
                                    }
                                    stringBuilder.append(stringBuilder2.toString());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return stringBuilder.toString();
    }

    private void i() {
        String h = j.h();
        if (h != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(h);
            stringBuilder.append(File.separator);
            stringBuilder.append("lcvif.dat");
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    long j = 0;
                    randomAccessFile.seek(0);
                    if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                        randomAccessFile.close();
                        file.delete();
                        return;
                    }
                    randomAccessFile.readInt();
                    int i = 0;
                    while (i < 3) {
                        long readLong = randomAccessFile.readLong();
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        int readInt5 = randomAccessFile.readInt();
                        char c = readInt5 == 2 ? 'c' : readInt5 == 1 ? 'g' : 0;
                        if (readLong != j) {
                            a aVar = r9;
                            boolean z = true;
                            a aVar2 = new a(readInt3, readInt4, readInt, readInt2, 0, c);
                            aVar.g = readLong;
                            if (aVar.b()) {
                                this.j = z;
                                this.g.add(aVar);
                            }
                        }
                        i++;
                        j = 0;
                    }
                    randomAccessFile.close();
                } catch (Exception unused) {
                    file.delete();
                }
            }
        }
    }

    private void j() {
        if (this.g != null || this.f != null) {
            if (this.g == null && this.f != null) {
                this.g = new LinkedList();
                this.g.add(this.f);
            }
            String h = j.h();
            if (!(h == null || this.g == null)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(h);
                stringBuilder.append(File.separator);
                stringBuilder.append("lcvif.dat");
                File file = new File(stringBuilder.toString());
                int size = this.g.size();
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    randomAccessFile.writeLong(((a) this.g.get(size - 1)).g);
                    randomAccessFile.writeInt(size);
                    int i = 0;
                    for (int i2 = 0; i2 < 3 - size; i2++) {
                        randomAccessFile.writeLong(0);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(2);
                    }
                    while (i < size) {
                        randomAccessFile.writeLong(((a) this.g.get(i)).g);
                        randomAccessFile.writeInt(((a) this.g.get(i)).c);
                        randomAccessFile.writeInt(((a) this.g.get(i)).d);
                        randomAccessFile.writeInt(((a) this.g.get(i)).a);
                        randomAccessFile.writeInt(((a) this.g.get(i)).b);
                        if (((a) this.g.get(i)).i == 'g') {
                            randomAccessFile.writeInt(1);
                        } else if (((a) this.g.get(i)).i == 'c') {
                            randomAccessFile.writeInt(2);
                        } else {
                            randomAccessFile.writeInt(3);
                        }
                        i++;
                    }
                    randomAccessFile.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    private void k() {
        a l = l();
        if (l != null) {
            c(l);
        }
        if (l == null || !l.b()) {
            CellLocation cellLocation;
            try {
                cellLocation = this.d.getCellLocation();
            } catch (Throwable unused) {
                cellLocation = null;
            }
            if (cellLocation != null) {
                a(cellLocation);
            }
        }
    }

    @SuppressLint({"NewApi"})
    private a l() {
        a aVar = null;
        if (Integer.valueOf(VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            a = this.d.getSimState();
            List<CellInfo> allCellInfo = this.d.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                a aVar2 = null;
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo.isRegistered()) {
                        Object obj = null;
                        if (aVar2 != null) {
                            obj = 1;
                        }
                        a a = a(cellInfo);
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

    public String a(a aVar) {
        String d;
        try {
            d = d(aVar);
            int intValue = Integer.valueOf(VERSION.SDK_INT).intValue();
            if ((d != null && !d.equals("") && !d.equals("&nc=")) || intValue >= 17) {
                return d;
            }
            List<NeighboringCellInfo> neighboringCellInfo = this.d.getNeighboringCellInfo();
            if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                d = "&nc=";
                int i = 0;
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    int lac = neighboringCellInfo2.getLac();
                    if (!(lac == -1 || neighboringCellInfo2.getCid() == -1)) {
                        if (aVar.a != lac) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(d);
                            stringBuilder.append(lac);
                            stringBuilder.append("|");
                            stringBuilder.append(neighboringCellInfo2.getCid());
                            stringBuilder.append("|");
                            stringBuilder.append(neighboringCellInfo2.getRssi());
                            stringBuilder.append(";");
                            d = stringBuilder.toString();
                        } else {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(d);
                            stringBuilder2.append("|");
                            stringBuilder2.append(neighboringCellInfo2.getCid());
                            stringBuilder2.append("|");
                            stringBuilder2.append(neighboringCellInfo2.getRssi());
                            stringBuilder2.append(";");
                            d = stringBuilder2.toString();
                        }
                    }
                    i++;
                    if (i >= 8) {
                        break;
                    }
                }
            }
            return (d == null || !d.equals("&nc=")) ? d : null;
        } catch (Throwable th) {
            th.printStackTrace();
            d = "";
        }
    }

    public String b(a aVar) {
        int i;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[]{Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.a), Integer.valueOf(aVar.b), Integer.valueOf(aVar.h)}));
        if (aVar.e < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED && aVar.f < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", new Object[]{Double.valueOf(((double) aVar.f) / 14400.0d), Double.valueOf(((double) aVar.e) / 14400.0d)}));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.g);
        try {
            if (this.g != null && this.g.size() > 0) {
                int size = this.g.size();
                stringBuffer.append("&clt=");
                for (i = 0; i < size; i++) {
                    a aVar2 = (a) this.g.get(i);
                    if (aVar2 != null) {
                        if (aVar2.c != aVar.c) {
                            stringBuffer.append(aVar2.c);
                        }
                        stringBuffer.append("|");
                        if (aVar2.d != aVar.d) {
                            stringBuffer.append(aVar2.d);
                        }
                        stringBuffer.append("|");
                        if (aVar2.a != aVar.a) {
                            stringBuffer.append(aVar2.a);
                        }
                        stringBuffer.append("|");
                        if (aVar2.b != aVar.b) {
                            stringBuffer.append(aVar2.b);
                        }
                        stringBuffer.append("|");
                        stringBuffer.append((System.currentTimeMillis() - aVar2.g) / 1000);
                        stringBuffer.append(";");
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (a > 100) {
            a = 0;
        }
        i = a + (b << 8);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&cs=");
        stringBuilder.append(i);
        stringBuffer.append(stringBuilder.toString());
        if (aVar.j != null) {
            stringBuffer.append(aVar.j);
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003f */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:17|18|19|20|21|22) */
    /* JADX WARNING: Missing block: B:24:0x0044, code skipped:
            return;
     */
    public synchronized void b() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.i;	 Catch:{ all -> 0x0045 }
        r1 = 1;
        if (r0 != r1) goto L_0x0008;
    L_0x0006:
        monitor-exit(r4);
        return;
    L_0x0008:
        r0 = com.baidu.location.f.isServing;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r4);
        return;
    L_0x000e:
        r0 = com.baidu.location.f.getServiceContext();	 Catch:{ all -> 0x0045 }
        r2 = "phone";
        r0 = r0.getSystemService(r2);	 Catch:{ all -> 0x0045 }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ all -> 0x0045 }
        r4.d = r0;	 Catch:{ all -> 0x0045 }
        r0 = new java.util.LinkedList;	 Catch:{ all -> 0x0045 }
        r0.<init>();	 Catch:{ all -> 0x0045 }
        r4.g = r0;	 Catch:{ all -> 0x0045 }
        r0 = new com.baidu.location.e.b$a;	 Catch:{ all -> 0x0045 }
        r0.<init>();	 Catch:{ all -> 0x0045 }
        r4.h = r0;	 Catch:{ all -> 0x0045 }
        r4.i();	 Catch:{ all -> 0x0045 }
        r0 = r4.d;	 Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x0043;
    L_0x0031:
        r0 = r4.h;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0036;
    L_0x0035:
        goto L_0x0043;
    L_0x0036:
        r0 = r4.d;	 Catch:{ Exception -> 0x003f }
        r2 = r4.h;	 Catch:{ Exception -> 0x003f }
        r3 = 272; // 0x110 float:3.81E-43 double:1.344E-321;
        r0.listen(r2, r3);	 Catch:{ Exception -> 0x003f }
    L_0x003f:
        r4.i = r1;	 Catch:{ all -> 0x0045 }
        monitor-exit(r4);
        return;
    L_0x0043:
        monitor-exit(r4);
        return;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.b.b():void");
    }

    public synchronized void c() {
        if (this.i) {
            if (!(this.h == null || this.d == null)) {
                this.d.listen(this.h, 0);
            }
            this.h = null;
            this.d = null;
            this.g.clear();
            this.g = null;
            j();
            this.i = false;
        }
    }

    public boolean d() {
        return this.j;
    }

    public int e() {
        if (this.d == null) {
            return 0;
        }
        try {
            return this.d.getNetworkType();
        } catch (Exception unused) {
            return 0;
        }
    }

    public a f() {
        if (!((this.e != null && this.e.a() && this.e.b()) || this.d == null)) {
            try {
                k();
            } catch (Exception unused) {
            }
        }
        if (this.e != null && this.e.e()) {
            this.f = null;
            this.f = new a(this.e.a, this.e.b, this.e.c, this.e.d, this.e.h, this.e.i);
        }
        if (this.e != null && this.e.d() && this.f != null && this.e.i == 'g') {
            this.e.d = this.f.d;
            this.e.c = this.f.c;
        }
        return this.e;
    }

    public String g() {
        int i = -1;
        try {
            if (this.d != null) {
                i = this.d.getSimState();
            }
        } catch (Exception unused) {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&sim=");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public int h() {
        String subscriberId;
        try {
            subscriberId = this.d.getSubscriberId();
        } catch (Exception unused) {
            subscriberId = null;
        }
        if (subscriberId != null) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002") || subscriberId.startsWith("46007")) {
                return 1;
            }
            if (subscriberId.startsWith("46001")) {
                return 2;
            }
            if (subscriberId.startsWith("46003")) {
                return 3;
            }
        }
        return 0;
    }
}
