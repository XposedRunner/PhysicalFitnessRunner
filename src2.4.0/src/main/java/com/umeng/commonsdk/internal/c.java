package com.umeng.commonsdk.internal;

import android.content.Context;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import org.json.JSONObject;

/* compiled from: UMInternalDataProtocol */
public class c implements UMLogDataProtocol {
    private static final String b = "info";
    private static final String c = "stat";
    private Context a;

    public c(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
    }

    public void removeCacheData(Object obj) {
    }

    public JSONObject setupReportData(long j) {
        return null;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public void workEvent(java.lang.Object r7, int r8) {
        /*
        r6 = this;
        r0 = "walle";
        r1 = 1;
        r2 = new java.lang.Object[r1];
        r3 = "[internal] workEvent";
        r4 = 0;
        r2[r4] = r3;
        com.umeng.commonsdk.statistics.common.ULog.i(r0, r2);
        r0 = 2;
        switch(r8) {
            case 32769: goto L_0x0168;
            case 32770: goto L_0x0190;
            case 32771: goto L_0x0124;
            case 32772: goto L_0x00e0;
            case 32773: goto L_0x00bb;
            case 32774: goto L_0x009c;
            case 32775: goto L_0x0075;
            case 32776: goto L_0x0056;
            case 32777: goto L_0x0013;
            default: goto L_0x0011;
        };
    L_0x0011:
        goto L_0x0190;
    L_0x0013:
        r7 = "walle";
        r8 = new java.lang.Object[r1];	 Catch:{  }
        r0 = "[internal] workEvent send envelope";
        r8[r4] = r0;	 Catch:{  }
        com.umeng.commonsdk.statistics.common.ULog.i(r7, r8);	 Catch:{  }
        r7 = new org.json.JSONObject;	 Catch:{  }
        r7.<init>();	 Catch:{  }
        r8 = "i_sdk_v";
        r0 = "1.2.0";
        r7.put(r8, r0);	 Catch:{  }
        r8 = new org.json.JSONObject;	 Catch:{  }
        r8.<init>();	 Catch:{  }
        r0 = new org.json.JSONObject;	 Catch:{  }
        r0.<init>();	 Catch:{  }
        r2 = "inner";
        r8.put(r2, r0);	 Catch:{  }
        r0 = r6.a;	 Catch:{  }
        r7 = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r0, r7, r8);	 Catch:{  }
        if (r7 == 0) goto L_0x0190;
    L_0x0041:
        r8 = "exception";
        r7 = r7.has(r8);	 Catch:{  }
        if (r7 != 0) goto L_0x0190;
    L_0x0049:
        r7 = "walle";
        r8 = new java.lang.Object[r1];	 Catch:{  }
        r0 = "[internal] workEvent send envelope back, result is ok";
        r8[r4] = r0;	 Catch:{  }
        com.umeng.commonsdk.statistics.common.ULog.i(r7, r8);	 Catch:{  }
        goto L_0x0190;
    L_0x0056:
        r8 = r6.a;
        r8 = r8.getApplicationContext();
        r0 = "info";
        r8 = r8.getSharedPreferences(r0, r4);
        if (r8 == 0) goto L_0x0190;
    L_0x0064:
        r8 = r8.edit();
        r0 = "stat";
        r7 = (java.lang.String) r7;
        r7 = r8.putString(r0, r7);
        r7.commit();
        goto L_0x0190;
    L_0x0075:
        r8 = "com.umeng.commonsdk.internal.utils.InfoPreferenceAgent";
        r8 = java.lang.Class.forName(r8);	 Catch:{  }
        if (r8 == 0) goto L_0x0190;
    L_0x007d:
        r2 = "saveUA";
        r3 = new java.lang.Class[r0];	 Catch:{  }
        r5 = android.content.Context.class;
        r3[r4] = r5;	 Catch:{  }
        r5 = java.lang.String.class;
        r3[r1] = r5;	 Catch:{  }
        r2 = r8.getMethod(r2, r3);	 Catch:{  }
        r7 = (java.lang.String) r7;	 Catch:{  }
        r0 = new java.lang.Object[r0];	 Catch:{  }
        r3 = r6.a;	 Catch:{  }
        r0[r4] = r3;	 Catch:{  }
        r0[r1] = r7;	 Catch:{  }
        r2.invoke(r8, r0);	 Catch:{  }
        goto L_0x0190;
    L_0x009c:
        r7 = "com.umeng.commonsdk.internal.utils.ApplicationLayerUtilAgent";
        r7 = java.lang.Class.forName(r7);	 Catch:{  }
        if (r7 == 0) goto L_0x0190;
    L_0x00a4:
        r8 = "wifiChange";
        r0 = new java.lang.Class[r1];	 Catch:{  }
        r2 = android.content.Context.class;
        r0[r4] = r2;	 Catch:{  }
        r8 = r7.getMethod(r8, r0);	 Catch:{  }
        r0 = new java.lang.Object[r1];	 Catch:{  }
        r1 = r6.a;	 Catch:{  }
        r0[r4] = r1;	 Catch:{  }
        r8.invoke(r7, r0);	 Catch:{  }
        goto L_0x0190;
    L_0x00bb:
        r8 = "com.umeng.commonsdk.internal.utils.InfoPreferenceAgent";
        r8 = java.lang.Class.forName(r8);	 Catch:{  }
        if (r8 == 0) goto L_0x0190;
    L_0x00c3:
        r2 = "saveBluetoothInfo";
        r3 = new java.lang.Class[r0];	 Catch:{  }
        r5 = android.content.Context.class;
        r3[r4] = r5;	 Catch:{  }
        r5 = java.lang.Object.class;
        r3[r1] = r5;	 Catch:{  }
        r2 = r8.getMethod(r2, r3);	 Catch:{  }
        r0 = new java.lang.Object[r0];	 Catch:{  }
        r3 = r6.a;	 Catch:{  }
        r0[r4] = r3;	 Catch:{  }
        r0[r1] = r7;	 Catch:{  }
        r2.invoke(r8, r0);	 Catch:{  }
        goto L_0x0190;
    L_0x00e0:
        r8 = "walle";
        r2 = new java.lang.Object[r1];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "[internal] workEvent cache station, event is ";
        r3.append(r5);
        r5 = r7.toString();
        r3.append(r5);
        r3 = r3.toString();
        r2[r4] = r3;
        com.umeng.commonsdk.statistics.common.ULog.i(r8, r2);
        r8 = "com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent";
        r8 = java.lang.Class.forName(r8);	 Catch:{  }
        if (r8 == 0) goto L_0x0190;
    L_0x0106:
        r2 = "saveBaseStationStrength";
        r3 = new java.lang.Class[r0];	 Catch:{  }
        r5 = android.content.Context.class;
        r3[r4] = r5;	 Catch:{  }
        r5 = java.lang.String.class;
        r3[r1] = r5;	 Catch:{  }
        r2 = r8.getMethod(r2, r3);	 Catch:{  }
        r7 = (java.lang.String) r7;	 Catch:{  }
        r0 = new java.lang.Object[r0];	 Catch:{  }
        r3 = r6.a;	 Catch:{  }
        r0[r4] = r3;	 Catch:{  }
        r0[r1] = r7;	 Catch:{  }
        r2.invoke(r8, r0);	 Catch:{  }
        goto L_0x0190;
    L_0x0124:
        r8 = "walle";
        r2 = new java.lang.Object[r1];
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "[internal] workEvent cache battery, event is ";
        r3.append(r5);
        r5 = r7.toString();
        r3.append(r5);
        r3 = r3.toString();
        r2[r4] = r3;
        com.umeng.commonsdk.statistics.common.ULog.i(r8, r2);
        r8 = "com.umeng.commonsdk.internal.utils.UMInternalUtilsAgent";
        r8 = java.lang.Class.forName(r8);	 Catch:{  }
        if (r8 == 0) goto L_0x0190;
    L_0x014a:
        r2 = "saveBattery";
        r3 = new java.lang.Class[r0];	 Catch:{  }
        r5 = android.content.Context.class;
        r3[r4] = r5;	 Catch:{  }
        r5 = java.lang.String.class;
        r3[r1] = r5;	 Catch:{  }
        r2 = r8.getMethod(r2, r3);	 Catch:{  }
        r7 = (java.lang.String) r7;	 Catch:{  }
        r0 = new java.lang.Object[r0];	 Catch:{  }
        r3 = r6.a;	 Catch:{  }
        r0[r4] = r3;	 Catch:{  }
        r0[r1] = r7;	 Catch:{  }
        r2.invoke(r8, r0);	 Catch:{  }
        goto L_0x0190;
    L_0x0168:
        r7 = "walle";
        r8 = new java.lang.Object[r1];	 Catch:{  }
        r0 = "[internal] workEvent send envelope";
        r8[r4] = r0;	 Catch:{  }
        com.umeng.commonsdk.statistics.common.ULog.i(r7, r8);	 Catch:{  }
        r7 = "com.umeng.commonsdk.internal.UMInternalManagerAgent";
        r7 = java.lang.Class.forName(r7);	 Catch:{ Exception -> 0x0190 }
        if (r7 == 0) goto L_0x0190;
    L_0x017b:
        r8 = "sendInternalEnvelopeByStateful2";
        r0 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0190 }
        r2 = android.content.Context.class;
        r0[r4] = r2;	 Catch:{ Exception -> 0x0190 }
        r8 = r7.getMethod(r8, r0);	 Catch:{ Exception -> 0x0190 }
        r0 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0190 }
        r1 = r6.a;	 Catch:{ Exception -> 0x0190 }
        r0[r4] = r1;	 Catch:{ Exception -> 0x0190 }
        r8.invoke(r7, r0);	 Catch:{ Exception -> 0x0190 }
    L_0x0190:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }
}
