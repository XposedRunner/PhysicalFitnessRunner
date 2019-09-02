package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import jp.co.cyberagent.android.gpuimage.O000000o;

/* compiled from: BaseStationUtils */
public class b {
    private static final String b = "BaseStationUtils";
    private static boolean c;
    private static Context d;
    PhoneStateListener a;
    private TelephonyManager e;

    /* compiled from: BaseStationUtils */
    private static class a {
        private static final b a = new b(b.d, null);

        private a() {
        }
    }

    private b(Context context) {
        this.a = new PhoneStateListener() {
            /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x014a */
            /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|(2:7|(1:33)(3:17|(2:22|(2:27|(1:31))(1:26))(1:21)|32))(1:6)|34|(2:36|37)|38|39|41) */
            public void onSignalStrengthsChanged(android.telephony.SignalStrength r8) {
                /*
                r7 = this;
                super.onSignalStrengthsChanged(r8);
                r0 = "BaseStationUtils";
                r1 = 1;
                r2 = new java.lang.Object[r1];
                r3 = "base station onSignalStrengthsChanged";
                r4 = 0;
                r2[r4] = r3;
                com.umeng.commonsdk.statistics.common.ULog.e(r0, r2);
                r0 = com.umeng.commonsdk.internal.utils.b.this;	 Catch:{ Exception -> 0x014f }
                r2 = com.umeng.commonsdk.internal.utils.b.d;	 Catch:{ Exception -> 0x014f }
                r3 = "phone";
                r2 = r2.getSystemService(r3);	 Catch:{ Exception -> 0x014f }
                r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x014f }
                r0.e = r2;	 Catch:{ Exception -> 0x014f }
                r0 = r8.toString();	 Catch:{ Exception -> 0x014f }
                r2 = " ";
                r0 = r0.split(r2);	 Catch:{ Exception -> 0x014f }
                r2 = 0;
                r3 = com.umeng.commonsdk.internal.utils.b.this;	 Catch:{ Exception -> 0x014f }
                r3 = r3.e;	 Catch:{ Exception -> 0x014f }
                r5 = 9;
                if (r3 == 0) goto L_0x005d;
            L_0x0036:
                r3 = com.umeng.commonsdk.internal.utils.b.this;	 Catch:{ Exception -> 0x014f }
                r3 = r3.e;	 Catch:{ Exception -> 0x014f }
                r3 = r3.getNetworkType();	 Catch:{ Exception -> 0x014f }
                r6 = 13;
                if (r3 != r6) goto L_0x005d;
            L_0x0044:
                r8 = r0[r5];	 Catch:{ Exception -> 0x014f }
                r8 = java.lang.Integer.parseInt(r8);	 Catch:{ Exception -> 0x014f }
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014f }
                r0.<init>();	 Catch:{ Exception -> 0x014f }
                r2 = "";
                r0.append(r2);	 Catch:{ Exception -> 0x014f }
                r0.append(r8);	 Catch:{ Exception -> 0x014f }
                r8 = r0.toString();	 Catch:{ Exception -> 0x014f }
                goto L_0x0114;
            L_0x005d:
                r0 = com.umeng.commonsdk.internal.utils.b.this;	 Catch:{ Exception -> 0x014f }
                r0 = r0.e;	 Catch:{ Exception -> 0x014f }
                if (r0 == 0) goto L_0x00fa;
            L_0x0065:
                r0 = com.umeng.commonsdk.internal.utils.b.this;	 Catch:{ Exception -> 0x014f }
                r0 = r0.e;	 Catch:{ Exception -> 0x014f }
                r0 = r0.getNetworkType();	 Catch:{ Exception -> 0x014f }
                r3 = 8;
                if (r0 == r3) goto L_0x009a;
            L_0x0073:
                r0 = com.umeng.commonsdk.internal.utils.b.this;	 Catch:{ Exception -> 0x014f }
                r0 = r0.e;	 Catch:{ Exception -> 0x014f }
                r0 = r0.getNetworkType();	 Catch:{ Exception -> 0x014f }
                r3 = 10;
                if (r0 == r3) goto L_0x009a;
            L_0x0081:
                r0 = com.umeng.commonsdk.internal.utils.b.this;	 Catch:{ Exception -> 0x014f }
                r0 = r0.e;	 Catch:{ Exception -> 0x014f }
                r0 = r0.getNetworkType();	 Catch:{ Exception -> 0x014f }
                if (r0 == r5) goto L_0x009a;
            L_0x008d:
                r0 = com.umeng.commonsdk.internal.utils.b.this;	 Catch:{ Exception -> 0x014f }
                r0 = r0.e;	 Catch:{ Exception -> 0x014f }
                r0 = r0.getNetworkType();	 Catch:{ Exception -> 0x014f }
                r3 = 3;
                if (r0 != r3) goto L_0x00fa;
            L_0x009a:
                r0 = com.umeng.commonsdk.internal.utils.b.this;	 Catch:{ Exception -> 0x014f }
                r0 = r0.e();	 Catch:{ Exception -> 0x014f }
                r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x014f }
                if (r3 != 0) goto L_0x00b1;
            L_0x00a6:
                r3 = "中国移动";
                r3 = r0.equals(r3);	 Catch:{ Exception -> 0x014f }
                if (r3 == 0) goto L_0x00b1;
            L_0x00ae:
                r2 = "0";
                goto L_0x00f8;
            L_0x00b1:
                r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x014f }
                if (r3 != 0) goto L_0x00d5;
            L_0x00b7:
                r3 = "中国联通";
                r3 = r0.equals(r3);	 Catch:{ Exception -> 0x014f }
                if (r3 == 0) goto L_0x00d5;
            L_0x00bf:
                r8 = r8.getCdmaDbm();	 Catch:{ Exception -> 0x014f }
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014f }
                r0.<init>();	 Catch:{ Exception -> 0x014f }
                r0.append(r8);	 Catch:{ Exception -> 0x014f }
                r8 = "";
                r0.append(r8);	 Catch:{ Exception -> 0x014f }
                r2 = r0.toString();	 Catch:{ Exception -> 0x014f }
                goto L_0x00f8;
            L_0x00d5:
                r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x014f }
                if (r3 != 0) goto L_0x00f8;
            L_0x00db:
                r3 = "中国电信";
                r0 = r0.equals(r3);	 Catch:{ Exception -> 0x014f }
                if (r0 == 0) goto L_0x00f8;
            L_0x00e3:
                r8 = r8.getEvdoDbm();	 Catch:{ Exception -> 0x014f }
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014f }
                r0.<init>();	 Catch:{ Exception -> 0x014f }
                r0.append(r8);	 Catch:{ Exception -> 0x014f }
                r8 = "";
                r0.append(r8);	 Catch:{ Exception -> 0x014f }
                r2 = r0.toString();	 Catch:{ Exception -> 0x014f }
            L_0x00f8:
                r8 = r2;
                goto L_0x0114;
            L_0x00fa:
                r8 = r8.getGsmSignalStrength();	 Catch:{ Exception -> 0x014f }
                r0 = -113; // 0xffffffffffffff8f float:NaN double:NaN;
                r2 = 2;
                r2 = r2 * r8;
                r0 = r0 + r2;
                r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014f }
                r8.<init>();	 Catch:{ Exception -> 0x014f }
                r8.append(r0);	 Catch:{ Exception -> 0x014f }
                r0 = "";
                r8.append(r0);	 Catch:{ Exception -> 0x014f }
                r8 = r8.toString();	 Catch:{ Exception -> 0x014f }
            L_0x0114:
                r0 = "BaseStationUtils";
                r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x014f }
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014f }
                r2.<init>();	 Catch:{ Exception -> 0x014f }
                r3 = "stationStrength is ";
                r2.append(r3);	 Catch:{ Exception -> 0x014f }
                r2.append(r8);	 Catch:{ Exception -> 0x014f }
                r2 = r2.toString();	 Catch:{ Exception -> 0x014f }
                r1[r4] = r2;	 Catch:{ Exception -> 0x014f }
                com.umeng.commonsdk.statistics.common.ULog.e(r0, r1);	 Catch:{ Exception -> 0x014f }
                r0 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Exception -> 0x014f }
                if (r0 != 0) goto L_0x014a;
            L_0x0134:
                r0 = com.umeng.commonsdk.internal.utils.b.d;	 Catch:{ Throwable -> 0x014a }
                r1 = 32772; // 0x8004 float:4.5923E-41 double:1.61915E-319;
                r2 = com.umeng.commonsdk.internal.utils.b.d;	 Catch:{ Throwable -> 0x014a }
                r2 = com.umeng.commonsdk.internal.b.a(r2);	 Catch:{ Throwable -> 0x014a }
                r2 = r2.a();	 Catch:{ Throwable -> 0x014a }
                com.umeng.commonsdk.framework.UMWorkDispatch.sendEvent(r0, r1, r2, r8);	 Catch:{ Throwable -> 0x014a }
            L_0x014a:
                r8 = com.umeng.commonsdk.internal.utils.b.this;	 Catch:{ Exception -> 0x014f }
                r8.c();	 Catch:{ Exception -> 0x014f }
            L_0x014f:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.b$AnonymousClass1.onSignalStrengthsChanged(android.telephony.SignalStrength):void");
            }
        };
        if (context != null) {
            try {
                this.e = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
        }
    }

    /* synthetic */ b(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    public static b a(Context context) {
        if (d == null && context != null) {
            d = context.getApplicationContext();
        }
        return a.a;
    }

    private String e() {
        String str = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) d.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                if (!simOperator.equals("46000")) {
                    if (!simOperator.equals("46002")) {
                        if (simOperator.equals("46001")) {
                            simOperator = "中国联通";
                        } else if (simOperator.equals("46003")) {
                            simOperator = "中国电信";
                        }
                        str = simOperator;
                    }
                }
                simOperator = "中国移动";
                str = simOperator;
            }
            return str;
        } catch (Throwable unused) {
        }
    }

    public synchronized boolean a() {
        return c;
    }

    public synchronized void b() {
        ULog.e(b, "base station registerListener");
        try {
            if (this.e != null) {
                this.e.listen(this.a, O000000o.O00000oO);
            }
            c = true;
        } catch (Throwable unused) {
        }
    }

    public synchronized void c() {
        ULog.e(b, "base station unRegisterListener");
        try {
            if (this.e != null) {
                this.e.listen(this.a, 0);
            }
            c = false;
        } catch (Throwable unused) {
        }
    }
}
