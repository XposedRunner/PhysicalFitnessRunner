package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class k {
    private static long j = 12000;
    public e a;
    private Context b;
    private WebView c;
    private LocationClient d;
    private a e;
    private List<b> f;
    private boolean g;
    private long h;
    private BDLocation i;
    private f k;
    private boolean l;

    private class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        private String a(BDLocation bDLocation) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("latitude", bDLocation.getLatitude());
                jSONObject.put("longitude", bDLocation.getLongitude());
                jSONObject.put("radius", (double) bDLocation.getRadius());
                jSONObject.put("errorcode", 1);
                if (bDLocation.hasAltitude()) {
                    jSONObject.put("altitude", bDLocation.getAltitude());
                }
                if (bDLocation.hasSpeed()) {
                    jSONObject.put("speed", (double) (bDLocation.getSpeed() / 3.6f));
                }
                if (bDLocation.getLocType() == 61) {
                    jSONObject.put("direction", (double) bDLocation.getDirection());
                }
                if (bDLocation.getBuildingName() != null) {
                    jSONObject.put("buildingname", bDLocation.getBuildingName());
                }
                if (bDLocation.getBuildingID() != null) {
                    jSONObject.put("buildingid", bDLocation.getBuildingID());
                }
                if (bDLocation.getFloor() != null) {
                    jSONObject.put("floor", bDLocation.getFloor());
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }

        private void a(String str) {
            if (k.this.l) {
                k.this.e.removeCallbacks(k.this.k);
                k.this.l = false;
            }
            if (k.this.f != null && k.this.f.size() > 0) {
                Iterator it = k.this.f.iterator();
                while (it.hasNext()) {
                    try {
                        b bVar = (b) it.next();
                        if (bVar.b() != null) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("javascript:");
                            stringBuilder.append(bVar.b());
                            stringBuilder.append("('");
                            stringBuilder.append(str);
                            stringBuilder.append("')");
                            k.this.c.loadUrl(stringBuilder.toString());
                        }
                        it.remove();
                    } catch (Exception unused) {
                        return;
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:46:0x0118  */
        /* JADX WARNING: Missing block: B:7:0x0019, code skipped:
            if (r11 == null) goto L_0x0160;
     */
        /* JADX WARNING: Missing block: B:12:0x002c, code skipped:
            if (r11 == null) goto L_0x0160;
     */
        /* JADX WARNING: Missing block: B:30:0x00b6, code skipped:
            a(r11);
     */
        /* JADX WARNING: Missing block: B:31:0x00b9, code skipped:
            return;
     */
        /* JADX WARNING: Missing block: B:53:0x0160, code skipped:
            return;
     */
        public void handleMessage(android.os.Message r11) {
            /*
            r10 = this;
            r0 = r11.what;
            r1 = 2;
            r2 = 0;
            r3 = 0;
            switch(r0) {
                case 1: goto L_0x00ba;
                case 2: goto L_0x00ae;
                case 3: goto L_0x0084;
                case 4: goto L_0x0030;
                case 5: goto L_0x001c;
                case 6: goto L_0x0009;
                default: goto L_0x0008;
            };
        L_0x0008:
            return;
        L_0x0009:
            r11 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0018 }
            r11.<init>();	 Catch:{ Exception -> 0x0018 }
            r0 = "errorcode";
            r11.put(r0, r1);	 Catch:{ Exception -> 0x0018 }
            r11 = r11.toString();	 Catch:{ Exception -> 0x0018 }
            goto L_0x0019;
        L_0x0018:
            r11 = r3;
        L_0x0019:
            if (r11 == 0) goto L_0x0160;
        L_0x001b:
            goto L_0x002e;
        L_0x001c:
            r11 = new org.json.JSONObject;	 Catch:{ Exception -> 0x002b }
            r11.<init>();	 Catch:{ Exception -> 0x002b }
            r0 = "errorcode";
            r11.put(r0, r2);	 Catch:{ Exception -> 0x002b }
            r11 = r11.toString();	 Catch:{ Exception -> 0x002b }
            goto L_0x002c;
        L_0x002b:
            r11 = r3;
        L_0x002c:
            if (r11 == 0) goto L_0x0160;
        L_0x002e:
            goto L_0x00b6;
        L_0x0030:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.f;
            if (r11 == 0) goto L_0x0046;
        L_0x0038:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.f;
            r11.clear();
            r11 = com.baidu.location.a.k.this;
            r11.f = r3;
        L_0x0046:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.d;
            r0 = com.baidu.location.a.k.this;
            r0 = r0.a;
            r11.unRegisterLocationListener(r0);
            r11 = com.baidu.location.a.k.this;
            r0 = 0;
            r11.h = r0;
            r11 = com.baidu.location.a.k.this;
            r11.i = r3;
            r11 = com.baidu.location.a.k.this;
            r11 = r11.k;
            if (r11 == 0) goto L_0x007e;
        L_0x0067:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.l;
            if (r11 == 0) goto L_0x007e;
        L_0x006f:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.e;
            r0 = com.baidu.location.a.k.this;
            r0 = r0.k;
            r11.removeCallbacks(r0);
        L_0x007e:
            r11 = com.baidu.location.a.k.this;
            r11.l = r2;
            return;
        L_0x0084:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.f;
            if (r11 != 0) goto L_0x0097;
        L_0x008c:
            r11 = com.baidu.location.a.k.this;
            r0 = new java.util.ArrayList;
            r0.<init>();
            r11.f = r0;
            goto L_0x00a0;
        L_0x0097:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.f;
            r11.clear();
        L_0x00a0:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.d;
            r0 = com.baidu.location.a.k.this;
            r0 = r0.a;
            r11.registerLocationListener(r0);
            return;
        L_0x00ae:
            r11 = r11.obj;
            r11 = (com.baidu.location.BDLocation) r11;
            r11 = r10.a(r11);
        L_0x00b6:
            r10.a(r11);
            return;
        L_0x00ba:
            r11 = r11.obj;
            r11 = (com.baidu.location.a.k.b) r11;
            r0 = com.baidu.location.a.k.this;
            r0 = r0.f;
            if (r0 == 0) goto L_0x00cf;
        L_0x00c6:
            r0 = com.baidu.location.a.k.this;
            r0 = r0.f;
            r0.add(r11);
        L_0x00cf:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.d;
            if (r11 == 0) goto L_0x0160;
        L_0x00d7:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.d;
            r11 = r11.requestLocation();
            r0 = 1;
            if (r11 == 0) goto L_0x0115;
        L_0x00e4:
            r4 = java.lang.System.currentTimeMillis();
            r11 = com.baidu.location.a.k.this;
            r6 = r11.h;
            r8 = r4 - r6;
            r11 = com.baidu.location.a.k.this;
            r11 = r11.i;
            if (r11 == 0) goto L_0x0115;
        L_0x00f8:
            r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
            if (r11 > 0) goto L_0x0115;
        L_0x00fe:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.e;
            r11 = r11.obtainMessage(r1);
            r1 = com.baidu.location.a.k.this;
            r1 = r1.i;
            r11.obj = r1;
            r11.sendToTarget();
            r11 = r2;
            goto L_0x0116;
        L_0x0115:
            r11 = r0;
        L_0x0116:
            if (r11 == 0) goto L_0x0160;
        L_0x0118:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.l;
            if (r11 == 0) goto L_0x0134;
        L_0x0120:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.e;
            r1 = com.baidu.location.a.k.this;
            r1 = r1.k;
            r11.removeCallbacks(r1);
            r11 = com.baidu.location.a.k.this;
            r11.l = r2;
        L_0x0134:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.k;
            if (r11 != 0) goto L_0x0148;
        L_0x013c:
            r11 = com.baidu.location.a.k.this;
            r1 = new com.baidu.location.a.k$f;
            r2 = com.baidu.location.a.k.this;
            r1.<init>();
            r11.k = r1;
        L_0x0148:
            r11 = com.baidu.location.a.k.this;
            r11 = r11.e;
            r1 = com.baidu.location.a.k.this;
            r1 = r1.k;
            r2 = com.baidu.location.a.k.j;
            r11.postDelayed(r1, r2);
            r11 = com.baidu.location.a.k.this;
            r11.l = r0;
        L_0x0160:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.a.k$a.handleMessage(android.os.Message):void");
        }
    }

    private class b {
        private String b = null;
        private String c = null;
        private long d = 0;

        b(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && jSONObject.has("action")) {
                    this.b = jSONObject.getString("action");
                }
                if (jSONObject != null && jSONObject.has("callback")) {
                    this.c = jSONObject.getString("callback");
                }
                if (jSONObject != null && jSONObject.has("timeout")) {
                    long j = jSONObject.getLong("timeout");
                    if (j >= 1000) {
                        k.j = j;
                    }
                }
                this.d = System.currentTimeMillis();
            } catch (Exception unused) {
                this.b = null;
                this.c = null;
            }
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }

    private static final class c {
        private static final k a = new k();
    }

    private class d {
        private d() {
        }

        @JavascriptInterface
        public void sendMessage(String str) {
            if (str != null && k.this.g) {
                b bVar = new b(str);
                if (bVar.a() != null && bVar.a().equals("requestLoc") && k.this.e != null) {
                    Message obtainMessage = k.this.e.obtainMessage(1);
                    obtainMessage.obj = bVar;
                    obtainMessage.sendToTarget();
                }
            }
        }

        @JavascriptInterface
        public void showLog(String str) {
        }
    }

    public class e extends BDAbstractLocationListener {
        public void onReceiveLocation(BDLocation bDLocation) {
            if (k.this.g && bDLocation != null) {
                Message obtainMessage;
                BDLocation bDLocation2 = new BDLocation(bDLocation);
                int locType = bDLocation2.getLocType();
                String coorType = bDLocation2.getCoorType();
                if (locType == 61 || locType == BDLocation.TypeNetWorkLocation || locType == 66) {
                    if (coorType != null) {
                        if (coorType.equals(CoordinateType.GCJ02)) {
                            bDLocation2 = LocationClient.getBDLocationInCoorType(bDLocation2, "gcj2wgs");
                        } else {
                            String str;
                            if (coorType.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                                str = BDLocation.BDLOCATION_BD09_TO_GCJ02;
                            } else if (coorType.equals("bd09ll")) {
                                str = BDLocation.BDLOCATION_BD09LL_TO_GCJ02;
                            }
                            bDLocation2 = LocationClient.getBDLocationInCoorType(LocationClient.getBDLocationInCoorType(bDLocation2, str), "gcj2wgs");
                        }
                    }
                    k.this.h = System.currentTimeMillis();
                    k.this.i = new BDLocation(bDLocation2);
                    obtainMessage = k.this.e.obtainMessage(2);
                    obtainMessage.obj = bDLocation2;
                } else {
                    obtainMessage = k.this.e.obtainMessage(5);
                }
                obtainMessage.sendToTarget();
            }
        }
    }

    private class f implements Runnable {
        private f() {
        }

        public void run() {
            k.this.l = false;
            k.this.e.obtainMessage(6).sendToTarget();
        }
    }

    private k() {
        this.b = null;
        this.d = null;
        this.a = new e();
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = 0;
        this.i = null;
        this.k = null;
        this.l = false;
    }

    public static k a() {
        return c.a;
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    private void a(WebView webView) {
        webView.addJavascriptInterface(new d(), "BaiduLocAssistant");
    }

    public void a(Context context, WebView webView, LocationClient locationClient) {
        if (!this.g && Integer.valueOf(VERSION.SDK_INT).intValue() >= 17) {
            this.b = context;
            this.c = webView;
            this.d = locationClient;
            this.e = new a(Looper.getMainLooper());
            this.e.obtainMessage(3).sendToTarget();
            webView.getSettings().setJavaScriptEnabled(true);
            a(this.c);
            this.g = true;
        }
    }

    public void b() {
        if (this.g) {
            this.e.obtainMessage(4).sendToTarget();
            this.g = false;
        }
    }
}
