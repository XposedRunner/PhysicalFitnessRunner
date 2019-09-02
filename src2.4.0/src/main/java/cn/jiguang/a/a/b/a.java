package cn.jiguang.a.a.b;

import android.content.Context;
import android.support.v4.internal.view.SupportMenu;
import android.telephony.TelephonyManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private int a = -1;
    private int b = -1;
    private String c = "";
    private String d = "";
    private String e = "";
    private TelephonyManager f = null;
    private Context g = null;
    private int h = 0;
    private b i;
    private f j;
    private JSONArray k = null;

    public a(Context context, f fVar) {
        this.g = context;
        try {
            this.f = (TelephonyManager) context.getSystemService("phone");
            this.j = fVar;
        } catch (Exception unused) {
        }
    }

    private static int a(String str) {
        try {
            return str.length() <= 6 ? Integer.parseInt(str.substring(3, str.length())) : -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    private JSONObject a(int i, int i2, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mobile_network_code", this.b);
            jSONObject.put("cell_id", i2);
            jSONObject.put("radio_type", this.c);
            jSONObject.put("signal_strength", i);
            jSONObject.put("mobile_country_code", this.a);
            jSONObject.put("carrier", this.e);
            jSONObject.put("location_area_code", i3);
            jSONObject.put("generation", this.d);
            jSONObject.put("itime", cn.jiguang.d.a.a.q());
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    private JSONObject a(int i, int i2, int i3, int i4) {
        return (i2 >= 268435455 || !(i4 == 0 || i4 == 3)) ? (i2 >= SupportMenu.USER_MASK || !(i4 == 1 || i4 == 2)) ? null : a(i, i2, i3) : a(i, i2, i3);
    }

    private void a(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!jSONArray2.toString().contains(jSONObject.toString())) {
                    jSONArray2.put(jSONObject);
                }
                i++;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        this.k = jSONArray2;
    }

    private void e() {
        if (this.j != null) {
            this.j.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    private boolean f() {
        /*
        r6 = this;
        r0 = r6.f;	 Catch:{ Exception -> 0x0007 }
        r0 = r0.getCellLocation();	 Catch:{ Exception -> 0x0007 }
        goto L_0x000c;
    L_0x0007:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = 0;
    L_0x000c:
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        r0 = 0;
        return r0;
    L_0x0010:
        r1 = new org.json.JSONArray;
        r1.<init>();
        r2 = r0 instanceof android.telephony.gsm.GsmCellLocation;	 Catch:{ Exception -> 0x0042 }
        if (r2 == 0) goto L_0x002d;
    L_0x0019:
        r0 = (android.telephony.gsm.GsmCellLocation) r0;	 Catch:{ Exception -> 0x0042 }
        r2 = r0.getCid();	 Catch:{ Exception -> 0x0042 }
        r0 = r0.getLac();	 Catch:{ Exception -> 0x0042 }
        r3 = r6.h;	 Catch:{ Exception -> 0x0042 }
        r0 = r6.a(r3, r2, r0);	 Catch:{ Exception -> 0x0042 }
    L_0x0029:
        r1.put(r0);	 Catch:{ Exception -> 0x0042 }
        goto L_0x0046;
    L_0x002d:
        r2 = r0 instanceof android.telephony.cdma.CdmaCellLocation;	 Catch:{ Exception -> 0x0042 }
        if (r2 == 0) goto L_0x0046;
    L_0x0031:
        r0 = (android.telephony.cdma.CdmaCellLocation) r0;	 Catch:{ Exception -> 0x0042 }
        r2 = r0.getBaseStationId();	 Catch:{ Exception -> 0x0042 }
        r0 = r0.getNetworkId();	 Catch:{ Exception -> 0x0042 }
        r3 = r6.h;	 Catch:{ Exception -> 0x0042 }
        r0 = r6.a(r3, r2, r0);	 Catch:{ Exception -> 0x0042 }
        goto L_0x0029;
    L_0x0042:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0046:
        r0 = r6.f;
        r0 = r0.getNeighboringCellInfo();
        if (r0 == 0) goto L_0x007c;
    L_0x004e:
        r0 = r0.iterator();
    L_0x0052:
        r2 = r0.hasNext();
        if (r2 == 0) goto L_0x007c;
    L_0x0058:
        r2 = r0.next();
        r2 = (android.telephony.NeighboringCellInfo) r2;
        r3 = -113; // 0xffffffffffffff8f float:NaN double:NaN;
        r4 = 2;
        r5 = r2.getRssi();
        r4 = r4 * r5;
        r3 = r3 + r4;
        r4 = r2.getCid();
        r2 = r2.getLac();
        r5 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
        if (r4 >= r5) goto L_0x0052;
    L_0x0074:
        r2 = r6.a(r3, r4, r2);
        r1.put(r2);
        goto L_0x0052;
    L_0x007c:
        r6.a(r1);
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.a.f():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066 A:{Catch:{ Throwable -> 0x0076 }} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x014d A:{SYNTHETIC, Splitter:B:74:0x014d} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0149  */
    public final void a() {
        /*
        r9 = this;
        r0 = r9.j;
        if (r0 != 0) goto L_0x0008;
    L_0x0004:
        r9.e();
        return;
    L_0x0008:
        r0 = 0;
        r1 = -1;
        r2 = 3;
        r9.a = r1;	 Catch:{ Throwable -> 0x0076 }
        r9.b = r1;	 Catch:{ Throwable -> 0x0076 }
        r1 = "";
        r9.c = r1;	 Catch:{ Throwable -> 0x0076 }
        r1 = "";
        r9.d = r1;	 Catch:{ Throwable -> 0x0076 }
        r1 = "";
        r9.e = r1;	 Catch:{ Throwable -> 0x0076 }
        r1 = r9.f;	 Catch:{ Throwable -> 0x0076 }
        r1 = r1.getNetworkOperatorName();	 Catch:{ Throwable -> 0x0076 }
        r9.e = r1;	 Catch:{ Throwable -> 0x0076 }
        r1 = r9.f;	 Catch:{ Throwable -> 0x0076 }
        r1 = r1.getNetworkType();	 Catch:{ Throwable -> 0x0076 }
        r3 = 4;
        if (r1 == r3) goto L_0x0048;
    L_0x002c:
        r3 = 7;
        if (r1 == r3) goto L_0x0048;
    L_0x002f:
        r3 = 5;
        if (r1 == r3) goto L_0x0048;
    L_0x0032:
        r3 = 6;
        if (r1 == r3) goto L_0x0048;
    L_0x0035:
        r3 = 12;
        if (r1 == r3) goto L_0x0048;
    L_0x0039:
        r3 = 14;
        if (r1 != r3) goto L_0x003e;
    L_0x003d:
        goto L_0x0048;
    L_0x003e:
        r3 = 13;
        if (r1 != r3) goto L_0x0045;
    L_0x0042:
        r1 = "lte";
        goto L_0x004a;
    L_0x0045:
        r1 = "gsm";
        goto L_0x004a;
    L_0x0048:
        r1 = "cdma";
    L_0x004a:
        r9.c = r1;	 Catch:{ Throwable -> 0x0076 }
        r1 = r9.g;	 Catch:{ Throwable -> 0x0076 }
        r3 = r9.f;	 Catch:{ Throwable -> 0x0076 }
        r3 = r3.getNetworkType();	 Catch:{ Throwable -> 0x0076 }
        r1 = cn.jiguang.g.k.a(r1, r3);	 Catch:{ Throwable -> 0x0076 }
        r9.d = r1;	 Catch:{ Throwable -> 0x0076 }
        r1 = r9.f;	 Catch:{ Throwable -> 0x0076 }
        r1 = r1.getNetworkOperator();	 Catch:{ Throwable -> 0x0076 }
        r3 = r1.length();	 Catch:{ Throwable -> 0x0076 }
        if (r3 <= r2) goto L_0x0076;
    L_0x0066:
        r3 = r1.substring(r0, r2);	 Catch:{ Throwable -> 0x0076 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ Throwable -> 0x0076 }
        r9.a = r3;	 Catch:{ Throwable -> 0x0076 }
        r1 = a(r1);	 Catch:{ Throwable -> 0x0076 }
        r9.b = r1;	 Catch:{ Throwable -> 0x0076 }
    L_0x0076:
        r1 = new org.json.JSONArray;
        r1.<init>();
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 17;
        if (r3 <= r4) goto L_0x0143;
    L_0x0081:
        r3 = 0;
        r5 = r9.f;	 Catch:{ Throwable -> 0x0089 }
        r5 = r5.getAllCellInfo();	 Catch:{ Throwable -> 0x0089 }
        r3 = r5;
    L_0x0089:
        if (r3 == 0) goto L_0x0143;
    L_0x008b:
        r5 = r3.size();
        if (r5 <= 0) goto L_0x0143;
    L_0x0091:
        r3 = r3.iterator();
    L_0x0095:
        r5 = r3.hasNext();
        if (r5 == 0) goto L_0x013c;
    L_0x009b:
        r5 = r3.next();
        r5 = (android.telephony.CellInfo) r5;
        if (r5 == 0) goto L_0x0095;
    L_0x00a3:
        r6 = r5 instanceof android.telephony.CellInfoLte;
        if (r6 == 0) goto L_0x00cb;
    L_0x00a7:
        r5 = (android.telephony.CellInfoLte) r5;
        r6 = android.os.Build.VERSION.SDK_INT;
        if (r6 <= r4) goto L_0x0095;
    L_0x00ad:
        r6 = r5.getCellSignalStrength();
        r5 = r5.getCellIdentity();
        r6 = r6.getDbm();
        r7 = r5.getCi();
        r5 = r5.getTac();
        r5 = r9.a(r6, r7, r5, r0);
        if (r5 == 0) goto L_0x0095;
    L_0x00c7:
        r1.put(r5);
        goto L_0x0095;
    L_0x00cb:
        r6 = r5 instanceof android.telephony.CellInfoGsm;
        if (r6 == 0) goto L_0x00f1;
    L_0x00cf:
        r5 = (android.telephony.CellInfoGsm) r5;
        r6 = android.os.Build.VERSION.SDK_INT;
        if (r6 <= r4) goto L_0x0095;
    L_0x00d5:
        r6 = r5.getCellSignalStrength();
        r5 = r5.getCellIdentity();
        r6 = r6.getDbm();
        r7 = r5.getCid();
        r5 = r5.getLac();
        r8 = 1;
        r5 = r9.a(r6, r7, r5, r8);
        if (r5 == 0) goto L_0x0095;
    L_0x00f0:
        goto L_0x00c7;
    L_0x00f1:
        r6 = r5 instanceof android.telephony.CellInfoCdma;
        if (r6 == 0) goto L_0x0117;
    L_0x00f5:
        r5 = (android.telephony.CellInfoCdma) r5;
        r6 = android.os.Build.VERSION.SDK_INT;
        if (r6 <= r4) goto L_0x0095;
    L_0x00fb:
        r6 = r5.getCellSignalStrength();
        r5 = r5.getCellIdentity();
        r6 = r6.getDbm();
        r7 = r5.getBasestationId();
        r5 = r5.getNetworkId();
        r8 = 2;
        r5 = r9.a(r6, r7, r5, r8);
        if (r5 == 0) goto L_0x0095;
    L_0x0116:
        goto L_0x00c7;
    L_0x0117:
        r6 = r5 instanceof android.telephony.CellInfoWcdma;
        if (r6 == 0) goto L_0x0095;
    L_0x011b:
        r5 = (android.telephony.CellInfoWcdma) r5;
        r6 = android.os.Build.VERSION.SDK_INT;
        if (r6 <= r4) goto L_0x0095;
    L_0x0121:
        r6 = r5.getCellSignalStrength();
        r5 = r5.getCellIdentity();
        r6 = r6.getDbm();
        r7 = r5.getCid();
        r5 = r5.getLac();
        r5 = r9.a(r6, r7, r5, r2);
        if (r5 == 0) goto L_0x0095;
    L_0x013b:
        goto L_0x00c7;
    L_0x013c:
        r9.a(r1);
        r9.e();
        return;
    L_0x0143:
        r0 = r9.f();
        if (r0 == 0) goto L_0x014d;
    L_0x0149:
        r9.e();
        return;
    L_0x014d:
        r0 = new cn.jiguang.a.a.b.b;	 Catch:{ Exception -> 0x015e }
        r0.<init>(r9);	 Catch:{ Exception -> 0x015e }
        r9.i = r0;	 Catch:{ Exception -> 0x015e }
        r0 = r9.f;	 Catch:{ Exception -> 0x015e }
        r1 = r9.i;	 Catch:{ Exception -> 0x015e }
        r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r0.listen(r1, r2);	 Catch:{ Exception -> 0x015e }
        return;
    L_0x015e:
        r9.e();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.b.a.a():void");
    }

    public final JSONArray b() {
        return this.k;
    }

    public final void c() {
        this.k = null;
    }

    public final void d() {
        try {
            if (!(this.f == null || this.i == null)) {
                this.f.listen(this.i, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
