package com.umeng.commonsdk.framework;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UMEnvelopeBuildImpl */
public class a {
    public static long a(Context context) {
        return context == null ? 0 : UMFrUtils.getLastSuccessfulBuildTime(context.getApplicationContext());
    }

    public static String a(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(context.getApplicationContext()).c().a(str, str2);
    }

    public static JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONException e;
        ULog.d("--->>> buildEnvelopeFile Enter.");
        if (UMGlobalContext.getInstance().isMainProcess(context)) {
            return new b().a(context.getApplicationContext(), jSONObject, jSONObject2);
        }
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(c.c, 101);
            } catch (JSONException e2) {
                e = e2;
            }
        } catch (JSONException e3) {
            JSONException jSONException = e3;
            jSONObject = null;
            e = jSONException;
            e.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    /* JADX WARNING: Missing block: B:7:0x001a, code skipped:
            if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r5, r6) != false) goto L_0x0034;
     */
    /* JADX WARNING: Missing block: B:13:0x0032, code skipped:
            if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r5, r6) != false) goto L_0x0034;
     */
    public static boolean a(android.content.Context r5, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType r6) {
        /*
        r0 = 0;
        if (r5 == 0) goto L_0x003b;
    L_0x0003:
        r5 = r5.getApplicationContext();
        r1 = com.umeng.commonsdk.framework.UMFrUtils.isOnline(r5);
        r2 = com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(r5);
        r3 = 1;
        if (r1 == 0) goto L_0x0034;
    L_0x0012:
        r4 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL;
        if (r6 != r4) goto L_0x001f;
    L_0x0016:
        r5 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r5, r6);
        if (r5 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0034;
    L_0x001d:
        r0 = r3;
        goto L_0x0034;
    L_0x001f:
        r4 = com.umeng.commonsdk.framework.b.a();
        if (r4 == 0) goto L_0x002e;
    L_0x0025:
        r5 = com.umeng.commonsdk.framework.b.b();
        r5 = (long) r5;
        com.umeng.commonsdk.framework.c.a(r5);
        goto L_0x0034;
    L_0x002e:
        r5 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r5, r6);
        if (r5 == 0) goto L_0x001d;
    L_0x0034:
        if (r1 == 0) goto L_0x003b;
    L_0x0036:
        if (r2 <= 0) goto L_0x003b;
    L_0x0038:
        com.umeng.commonsdk.framework.b.d();
    L_0x003b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.a.a(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType):boolean");
    }

    public static long b(Context context) {
        return context == null ? 0 : UMFrUtils.getLastInstantBuildTime(context.getApplicationContext());
    }

    public static long c(Context context) {
        return context == null ? 0 : b.a(context.getApplicationContext());
    }
}
