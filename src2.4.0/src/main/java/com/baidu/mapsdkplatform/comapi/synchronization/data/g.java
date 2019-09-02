package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.baidu.mapsdkplatform.comapi.synchronization.data.RouteLineInfo.RouteSectionInfo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {
    private static final String a = "g";
    private RoleOptions b;
    private DisplayOptions c;
    private BlockingQueue<SyncResponseResult> d;
    private i e;
    private String f;
    private String g;
    private com.baidu.mapsdkplatform.comapi.synchronization.c.a h;
    private HandlerThread i;
    private b j;
    private volatile int k;
    private k l;
    private boolean m;
    private float n;
    private long o;
    private int p;

    private static class a {
        private static final g a = new g();
    }

    private class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 100000:
                    SyncResponseResult a = g.this.b((String) message.obj);
                    if (a == null) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(g.a, "parser response data is null");
                        return;
                    }
                    g.this.a(a);
                    g.this.j();
                    g.this.b(a);
                    return;
                case 100001:
                    g.this.k();
                    return;
                default:
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(g.a, "Undefined message type");
                    return;
            }
        }
    }

    private g() {
        this.d = new LinkedBlockingQueue();
        this.f = String.valueOf(0);
        this.g = String.valueOf(0);
        this.h = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
        this.k = 0;
        this.m = false;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
    }

    /* synthetic */ g(h hVar) {
        this();
    }

    private f a(int i) {
        if (this.b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "RoleOptions is null");
            return null;
        }
        f fVar = new f();
        fVar.a(this.b.getOrderId());
        fVar.b(this.b.getDriverId());
        fVar.c(this.b.getUserId());
        fVar.a(i);
        if (this.m) {
            this.f = String.valueOf(0);
            this.g = String.valueOf(0);
        }
        fVar.d(this.f);
        fVar.e(this.g);
        return fVar;
    }

    public static g a() {
        return a.a;
    }

    private void a(SyncResponseResult syncResponseResult) {
        if (this.d == null) {
            this.d = new LinkedBlockingQueue();
        }
        if (this.m) {
            this.m = false;
            this.d.clear();
        }
        try {
            this.d.put(syncResponseResult);
        } catch (InterruptedException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "InterruptedException happened when put item into queue", e);
            Thread.currentThread().interrupt();
        }
    }

    private void a(String str) {
        if (this.h == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "HttpClient cannot be null");
        } else {
            this.h.a(str, new h(this));
        }
    }

    private void a(String str, SyncResponseResult syncResponseResult) {
        String[] split = str.split(";");
        if (split.length == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "There's no section route data");
            return;
        }
        String[] split2 = split[0].split(",");
        if (2 != split2.length) {
            String str2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Section start position latlng invalid: ");
            stringBuilder.append(split[0]);
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str2, stringBuilder.toString());
            return;
        }
        LatLng latLng;
        LatLng latLng2 = null;
        try {
            latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
        } catch (NumberFormatException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get startPosition failed", e);
            latLng = null;
        }
        for (int i = 1; i < split.length; i++) {
            RouteSectionInfo routeSectionInfo = new RouteSectionInfo();
            routeSectionInfo.a(latLng);
            String[] split3 = split[i].split(",");
            if (2 != split3.length) {
                String str3 = a;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Section position latlng invalid: ");
                stringBuilder2.append(split[i]);
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str3, stringBuilder2.toString());
            } else {
                try {
                    latLng2 = new LatLng(Double.valueOf(split3[1]).doubleValue(), Double.valueOf(split3[0]).doubleValue());
                } catch (NumberFormatException e2) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get endPosition failed", e2);
                }
                routeSectionInfo.b(latLng2);
                syncResponseResult.a().a(routeSectionInfo);
                latLng = latLng2;
            }
        }
    }

    private void a(JSONArray jSONArray, SyncResponseResult syncResponseResult) {
        JSONObject optJSONObject = jSONArray.optJSONObject(jSONArray.length() - 1);
        if (optJSONObject == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Invalid driver position data");
            return;
        }
        syncResponseResult.c().setTimeStamp(optJSONObject.optString("t"));
        String optString = optJSONObject.optString("p");
        if (optString == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No position info data");
            return;
        }
        String[] split = optString.split(";");
        if (split.length == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Position info array is empty");
            return;
        }
        String[] split2 = split[0].split(",");
        if (2 != split2.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Position latlng invalid");
            return;
        }
        double doubleValue;
        int intValue;
        LatLng latLng = null;
        try {
            latLng = new LatLng(Double.valueOf(split2[1]).doubleValue(), Double.valueOf(split2[0]).doubleValue());
        } catch (NumberFormatException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get driver position failed", e);
        }
        syncResponseResult.c().setPoint(latLng);
        try {
            doubleValue = Double.valueOf(split[1]).doubleValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get angle failed", e2);
            doubleValue = 0.0d;
        }
        syncResponseResult.c().setAngle(doubleValue);
        try {
            doubleValue = Double.valueOf(split[2]).doubleValue();
        } catch (NumberFormatException e22) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get speed failed", e22);
            doubleValue = 0.0d;
        }
        syncResponseResult.c().setSpeed(doubleValue);
        try {
            intValue = Integer.valueOf(split[3]).intValue();
        } catch (NumberFormatException e3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get orderStateInPosition failed", e3);
            intValue = 0;
        }
        syncResponseResult.c().setOrderStateInPosition(intValue);
    }

    private void a(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        JSONObject optJSONObject = jSONObject.optJSONObject("route");
        if (optJSONObject != null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "parser route data");
            b(optJSONObject, syncResponseResult);
        }
        optJSONObject = jSONObject.optJSONObject("traffic");
        if (optJSONObject != null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "parser traffic data");
            c(optJSONObject, syncResponseResult);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("positions");
        if (!(optJSONArray == null || optJSONArray.length() == 0)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "parser driver position data");
            a(optJSONArray, syncResponseResult);
        }
        String optString = jSONObject.optString("run");
        if (!TextUtils.isEmpty(optString)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "parser travelled distance and elapsed time data");
            c(optString, syncResponseResult);
        }
        optString = jSONObject.optString("remain");
        if (!TextUtils.isEmpty(optString)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "parser remain distance and estimated time data");
            d(optString, syncResponseResult);
        }
        syncResponseResult.a(jSONObject.optInt("s"));
        syncResponseResult.a(jSONObject.optString("mtime"));
        syncResponseResult.b(jSONObject.optString("ext"));
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("status")) {
            if (this.l != null) {
                this.l.c(2003, SynchronizationConstants.LBS_STATUS_MESSAGE_QUERY_TRACK_ROUTE_FAILED);
            }
            return false;
        }
        int optInt = jSONObject.optInt("status");
        String optString = jSONObject.optString("message");
        if (optInt == 0) {
            if (this.l != null) {
                this.l.b(optInt, optString);
            }
            return true;
        }
        if (this.l != null) {
            this.l.c(optInt, optString);
        }
        return false;
    }

    private SyncResponseResult b(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Response result is null");
            return null;
        }
        SyncResponseResult syncResponseResult = new SyncResponseResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (a(jSONObject)) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    if (optJSONObject.length() > 0) {
                        a(optJSONObject, syncResponseResult);
                        return syncResponseResult;
                    }
                }
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "No route and traffic and driver data");
                return null;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Response result is invalid");
            return null;
        } catch (JSONException unused) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "JSONException happened when parser");
            return null;
        }
    }

    private void b(SyncResponseResult syncResponseResult) {
        float d = syncResponseResult.d();
        long e = syncResponseResult.e();
        if (1 == this.p || 2 == this.p || 4 == this.p) {
            if (this.p != 1 && this.m) {
                this.n = 0.0f;
                this.o = 0;
                e = 0;
                d = 0.0f;
            }
            if (0.0f != d) {
                this.n = d;
            }
            if (0 != e) {
                this.o = e;
            }
        } else {
            this.n = 0.0f;
            this.o = 0;
        }
        if (this.l != null) {
            this.l.a(this.n, this.o);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074 A:{LOOP_END, LOOP:1: B:24:0x0070->B:26:0x0074} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074 A:{LOOP_END, LOOP:1: B:24:0x0070->B:26:0x0074} */
    private void b(java.lang.String r10, com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult r11) {
        /*
        r9 = this;
        r0 = ";";
        r10 = r10.split(r0);
        r0 = r10.length;
        if (r0 != 0) goto L_0x0011;
    L_0x0009:
        r10 = a;
        r11 = "There's no section traffic data";
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(r10, r11);
        return;
    L_0x0011:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = r10.length;
        r3 = r1;
    L_0x0019:
        if (r3 >= r2) goto L_0x0088;
    L_0x001b:
        r4 = r10[r3];
        r5 = ",";
        r5 = r4.split(r5);
        r6 = 3;
        r7 = r5.length;
        if (r6 == r7) goto L_0x003e;
    L_0x0027:
        r5 = a;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "section traffic data is invalid: ";
        r6.append(r7);
        r6.append(r4);
        r4 = r6.toString();
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(r5, r4);
        goto L_0x0085;
    L_0x003e:
        r4 = r5[r1];	 Catch:{ NumberFormatException -> 0x0064 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ NumberFormatException -> 0x0064 }
        r4 = r4.intValue();	 Catch:{ NumberFormatException -> 0x0064 }
        r6 = 1;
        r6 = r5[r6];	 Catch:{ NumberFormatException -> 0x0061 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ NumberFormatException -> 0x0061 }
        r6 = r6.intValue();	 Catch:{ NumberFormatException -> 0x0061 }
        r7 = 2;
        r5 = r5[r7];	 Catch:{ NumberFormatException -> 0x005f }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ NumberFormatException -> 0x005f }
        r5 = r5.intValue();	 Catch:{ NumberFormatException -> 0x005f }
        goto L_0x006f;
    L_0x005f:
        r5 = move-exception;
        goto L_0x0067;
    L_0x0061:
        r5 = move-exception;
        r6 = r1;
        goto L_0x0067;
    L_0x0064:
        r5 = move-exception;
        r4 = r1;
        r6 = r4;
    L_0x0067:
        r7 = a;
        r8 = "Get traffic status info failed";
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(r7, r8, r5);
        r5 = r1;
    L_0x006f:
        r7 = r4;
    L_0x0070:
        r8 = r4 + r6;
        if (r7 >= r8) goto L_0x007e;
    L_0x0074:
        r8 = java.lang.Integer.valueOf(r5);
        r0.add(r8);
        r7 = r7 + 1;
        goto L_0x0070;
    L_0x007e:
        r4 = r11.b();
        r4.a(r0);
    L_0x0085:
        r3 = r3 + 1;
        goto L_0x0019;
    L_0x0088:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.data.g.b(java.lang.String, com.baidu.mapsdkplatform.comapi.synchronization.data.SyncResponseResult):void");
    }

    private void b(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        syncResponseResult.a().a(jSONObject.optInt("c") != 0);
        this.f = jSONObject.optString("f");
        syncResponseResult.a().a(this.f);
        String optString = jSONObject.optString("d");
        if (!TextUtils.isEmpty(optString)) {
            a(optString, syncResponseResult);
        }
    }

    private void c(String str, SyncResponseResult syncResponseResult) {
        String[] split = str.split(";");
        if (2 != split.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The travelled data is null or invalid");
            return;
        }
        float f = 0.0f;
        try {
            f = Float.valueOf(split[0]).floatValue();
        } catch (NumberFormatException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get travelledDistance failed", e);
        }
        syncResponseResult.a(f);
        long j = 0;
        try {
            j = Long.valueOf(split[1]).longValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get elapsedTime failed", e2);
        }
        syncResponseResult.a(j);
    }

    private void c(JSONObject jSONObject, SyncResponseResult syncResponseResult) {
        syncResponseResult.b().a(jSONObject.optInt("c") != 0);
        this.g = jSONObject.optString("f");
        syncResponseResult.b().a(this.g);
        String optString = jSONObject.optString("d");
        if (!TextUtils.isEmpty(optString)) {
            b(optString, syncResponseResult);
        }
    }

    private void d(String str, SyncResponseResult syncResponseResult) {
        String[] split = str.split(";");
        if (2 != split.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "The remain data is null or invalid: ");
            return;
        }
        float f = 0.0f;
        try {
            f = Float.valueOf(split[0]).floatValue();
        } catch (NumberFormatException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get remainDistance failed", e);
        }
        syncResponseResult.b(f);
        long j = 0;
        try {
            j = Long.valueOf(split[1]).longValue();
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Get estimatedTime failed", e2);
        }
        syncResponseResult.b(j);
    }

    private void j() {
        if (this.e != null) {
            this.e.a();
        }
    }

    private void k() {
        if (this.e != null) {
            this.e.b();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i, boolean z) {
        String str;
        String str2;
        this.m = z;
        this.p = i;
        f a = a(i);
        if (a == null) {
            str = a;
            str2 = "Data request option is null";
        } else {
            str = new m(a).a();
            if (str == null) {
                str = a;
                str2 = "send url string is null";
            } else {
                a(str);
                return;
            }
        }
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(str, str2);
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* JADX WARNING: Missing block: B:12:0x001a, code skipped:
            return;
     */
    public synchronized void a(android.view.View r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.c;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x000c;
    L_0x0005:
        r0 = r2.c;	 Catch:{ all -> 0x001b }
        r0.setStartPositionInfoWindowView(r3);	 Catch:{ all -> 0x001b }
        monitor-exit(r2);
        return;
    L_0x000c:
        r3 = r2.l;	 Catch:{ all -> 0x001b }
        if (r3 == 0) goto L_0x0019;
    L_0x0010:
        r3 = r2.l;	 Catch:{ all -> 0x001b }
        r0 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        r1 = "DisplayOptions instance init null.";
        r3.c(r0, r1);	 Catch:{ all -> 0x001b }
    L_0x0019:
        monitor-exit(r2);
        return;
    L_0x001b:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.data.g.a(android.view.View):void");
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a(DisplayOptions displayOptions) {
        this.c = displayOptions;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a(RoleOptions roleOptions) {
        this.b = roleOptions;
    }

    public void a(i iVar) {
        this.e = iVar;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(k kVar) {
        this.l = kVar;
    }

    public void b() {
        this.i = new HandlerThread("SyncDataStorage");
        this.i.start();
        this.j = new b(this.i.getLooper());
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* JADX WARNING: Missing block: B:12:0x001a, code skipped:
            return;
     */
    public synchronized void b(android.view.View r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.c;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x000c;
    L_0x0005:
        r0 = r2.c;	 Catch:{ all -> 0x001b }
        r0.setEndPositionInfoWindowView(r3);	 Catch:{ all -> 0x001b }
        monitor-exit(r2);
        return;
    L_0x000c:
        r3 = r2.l;	 Catch:{ all -> 0x001b }
        if (r3 == 0) goto L_0x0019;
    L_0x0010:
        r3 = r2.l;	 Catch:{ all -> 0x001b }
        r0 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        r1 = "DisplayOptions instance init null.";
        r3.c(r0, r1);	 Catch:{ all -> 0x001b }
    L_0x0019:
        monitor-exit(r2);
        return;
    L_0x001b:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.data.g.b(android.view.View):void");
    }

    public void c() {
        if (this.e != null) {
            this.e = null;
        }
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* JADX WARNING: Missing block: B:12:0x001a, code skipped:
            return;
     */
    public synchronized void c(android.view.View r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.c;	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x000c;
    L_0x0005:
        r0 = r2.c;	 Catch:{ all -> 0x001b }
        r0.setCarInfoWindowView(r3);	 Catch:{ all -> 0x001b }
        monitor-exit(r2);
        return;
    L_0x000c:
        r3 = r2.l;	 Catch:{ all -> 0x001b }
        if (r3 == 0) goto L_0x0019;
    L_0x0010:
        r3 = r2.l;	 Catch:{ all -> 0x001b }
        r0 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;
        r1 = "DisplayOptions instance init null.";
        r3.c(r0, r1);	 Catch:{ all -> 0x001b }
    L_0x0019:
        monitor-exit(r2);
        return;
    L_0x001b:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.synchronization.data.g.c(android.view.View):void");
    }

    /* Access modifiers changed, original: 0000 */
    public int d() {
        return this.k;
    }

    public RoleOptions e() {
        return this.b;
    }

    public DisplayOptions f() {
        return this.c;
    }

    public BlockingQueue<SyncResponseResult> g() {
        return this.d;
    }

    public void h() {
        this.m = false;
        this.n = 0.0f;
        this.o = 0;
        this.j.removeCallbacksAndMessages(null);
        this.i.quit();
    }
}
