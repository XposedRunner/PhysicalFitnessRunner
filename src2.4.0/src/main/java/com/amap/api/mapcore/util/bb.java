package com.amap.api.mapcore.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* compiled from: MapNetLocation */
public final class bb {
    Context O000000o = null;
    boolean O00000Oo = false;
    long O00000o = 0;
    String O00000o0 = null;
    private bj O00000oO = null;
    private bh O00000oo = null;
    private O000000o O0000O0o = null;
    private bl O0000OOo = null;
    private bn O0000Oo = null;
    private ConnectivityManager O0000Oo0 = null;
    private StringBuilder O0000OoO = new StringBuilder();
    private Inner_3dMap_locationOption O0000Ooo = null;
    private final String O0000o0 = "\"status\":\"0\"";
    private ls O0000o00 = null;
    private final String O0000o0O = "</body></html>";

    /* compiled from: MapNetLocation */
    private class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(bb bbVar, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (bb.this.O00000oO != null) {
                                bb.this.O00000oO.O00000o0();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED") && bb.this.O00000oO != null) {
                            bb.this.O00000oO.O00000o();
                        }
                    }
                } catch (Throwable th) {
                    bp.O000000o(th, "MapNetLocation", "onReceive");
                }
            }
        }
    }

    public bb(Context context) {
        try {
            this.O000000o = context.getApplicationContext();
            bt.O00000Oo(this.O000000o);
            O000000o(this.O000000o);
            this.O0000Ooo = new Inner_3dMap_locationOption();
            if (this.O00000oO == null) {
                this.O00000oO = new bj(this.O000000o, (WifiManager) bt.O000000o(this.O000000o, "wifi"));
                this.O00000oO.O000000o(this.O00000Oo);
            }
            if (this.O00000oo == null) {
                this.O00000oo = new bh(this.O000000o);
            }
            if (this.O0000OOo == null) {
                this.O0000OOo = bl.O000000o(this.O000000o);
            }
            if (this.O0000Oo0 == null) {
                this.O0000Oo0 = (ConnectivityManager) bt.O000000o(this.O000000o, "connectivity");
            }
            this.O0000Oo = new bn();
            O00000o0();
        } catch (Throwable th) {
            bp.O000000o(th, "MapNetLocation", "<init>");
        }
    }

    private static ls O000000o(ls lsVar, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return aw.O000000o().O000000o(lsVar);
        }
        if (strArr[0].equals("shake")) {
            return aw.O000000o().O000000o(lsVar);
        }
        if (strArr[0].equals("fusion")) {
            aw.O000000o();
            lsVar = aw.O00000Oo(lsVar);
        }
        return lsVar;
    }

    private void O000000o(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(o0OOOO00.O00000o0("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.O00000Oo = true;
            }
        } catch (Throwable unused) {
        }
    }

    private boolean O000000o(long j) {
        if (bt.O00000Oo() - j < 800) {
            j = 0;
            if (bd.O000000o(this.O0000o00)) {
                j = bt.O000000o() - this.O0000o00.getTime();
            }
            if (j <= 10000) {
                return true;
            }
        }
        return false;
    }

    private ls O00000o() throws Exception {
        ls lsVar = new ls("");
        if (this.O00000oO == null || !this.O00000oO.O0000O0o()) {
            StringBuilder stringBuilder;
            try {
                if (this.O0000Oo == null) {
                    this.O0000Oo = new bn();
                }
                this.O0000Oo.O000000o(this.O000000o, this.O0000Ooo.isNeedAddress(), this.O0000Ooo.isOffset(), this.O00000oo, this.O00000oO, this.O0000Oo0, this.O00000o0);
                bc bcVar = new bc();
                byte[] bArr = null;
                CharSequence charSequence = "";
                StringBuilder stringBuilder2;
                try {
                    try {
                        oOO0Oo00 O000000o = this.O0000OOo.O000000o(this.O0000OOo.O000000o(this.O000000o, this.O0000Oo.O000000o(), bp.O000000o()));
                        if (O000000o != null) {
                            bArr = O000000o.O000000o;
                            charSequence = O000000o.O00000o0;
                        }
                        StringBuilder stringBuilder3;
                        if (bArr == null || bArr.length == 0) {
                            lsVar.setErrorCode(4);
                            this.O0000OoO.append("please check the network");
                            if (!TextUtils.isEmpty(charSequence)) {
                                stringBuilder2 = this.O0000OoO;
                                stringBuilder3 = new StringBuilder(" #csid:");
                                stringBuilder3.append(charSequence);
                                stringBuilder2.append(stringBuilder3.toString());
                            }
                            lsVar.setLocationDetail(this.O0000OoO.toString());
                            return lsVar;
                        }
                        String str = new String(bArr, HttpUtils.ENCODING_UTF_8);
                        if (str.contains("\"status\":\"0\"")) {
                            return bcVar.O000000o(str, this.O000000o, O000000o);
                        }
                        if (str.contains("</body></html>")) {
                            String str2;
                            lsVar.setErrorCode(5);
                            if (this.O00000oO == null || !this.O00000oO.O000000o(this.O0000Oo0)) {
                                stringBuilder2 = this.O0000OoO;
                                str2 = "request may be intercepted";
                            } else {
                                stringBuilder2 = this.O0000OoO;
                                str2 = "make sure you are logged in to the network";
                            }
                            stringBuilder2.append(str2);
                            if (!TextUtils.isEmpty(charSequence)) {
                                stringBuilder2 = this.O0000OoO;
                                stringBuilder3 = new StringBuilder(" #csid:");
                                stringBuilder3.append(charSequence);
                                stringBuilder2.append(stringBuilder3.toString());
                            }
                            lsVar.setLocationDetail(this.O0000OoO.toString());
                            return lsVar;
                        }
                        byte[] O000000o2 = bk.O000000o(bArr);
                        if (O000000o2 == null) {
                            lsVar.setErrorCode(5);
                            this.O0000OoO.append("decrypt response data error");
                            if (!TextUtils.isEmpty(charSequence)) {
                                stringBuilder2 = this.O0000OoO;
                                stringBuilder3 = new StringBuilder(" #csid:");
                                stringBuilder3.append(charSequence);
                                stringBuilder2.append(stringBuilder3.toString());
                            }
                            lsVar.setLocationDetail(this.O0000OoO.toString());
                            return lsVar;
                        }
                        lsVar = bcVar.O000000o(O000000o2);
                        if (lsVar == null) {
                            lsVar = new ls("");
                            lsVar.setErrorCode(5);
                            this.O0000OoO.append("location is null");
                            if (!TextUtils.isEmpty(charSequence)) {
                                stringBuilder2 = this.O0000OoO;
                                stringBuilder3 = new StringBuilder(" #csid:");
                                stringBuilder3.append(charSequence);
                                stringBuilder2.append(stringBuilder3.toString());
                            }
                            lsVar.setLocationDetail(this.O0000OoO.toString());
                            return lsVar;
                        }
                        this.O00000o0 = lsVar.O000000o();
                        if (lsVar.getErrorCode() != 0) {
                            if (!TextUtils.isEmpty(charSequence)) {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(lsVar.getLocationDetail());
                                stringBuilder2.append(" #csid:");
                                stringBuilder2.append(charSequence);
                                lsVar.setLocationDetail(stringBuilder2.toString());
                            }
                            return lsVar;
                        } else if (bd.O000000o(lsVar)) {
                            JSONObject O00000oO = lsVar.O00000oO();
                            if (lsVar.getErrorCode() == 0 && lsVar.getLocationType() == 0) {
                                if ("-5".equals(lsVar.O00000o()) || "1".equals(lsVar.O00000o()) || "2".equals(lsVar.O00000o()) || Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(lsVar.O00000o()) || "24".equals(lsVar.O00000o()) || "-1".equals(lsVar.O00000o())) {
                                    lsVar.setLocationType(5);
                                } else {
                                    lsVar.setLocationType(6);
                                }
                                this.O0000OoO.append(lsVar.O00000o());
                                if (!TextUtils.isEmpty(charSequence)) {
                                    stringBuilder2 = this.O0000OoO;
                                    stringBuilder3 = new StringBuilder(" #csid:");
                                    stringBuilder3.append(charSequence);
                                    stringBuilder2.append(stringBuilder3.toString());
                                }
                                lsVar.setLocationDetail(this.O0000OoO.toString());
                            }
                            return lsVar;
                        } else {
                            str = lsVar.O00000Oo();
                            lsVar.setErrorCode(6);
                            stringBuilder3 = this.O0000OoO;
                            stringBuilder = new StringBuilder("location faile retype:");
                            stringBuilder.append(lsVar.O00000o());
                            stringBuilder.append(" rdesc:");
                            if (str == null) {
                                str = "null";
                            }
                            stringBuilder.append(str);
                            stringBuilder3.append(stringBuilder.toString());
                            if (!TextUtils.isEmpty(charSequence)) {
                                stringBuilder2 = this.O0000OoO;
                                stringBuilder3 = new StringBuilder(" #csid:");
                                stringBuilder3.append(charSequence);
                                stringBuilder2.append(stringBuilder3.toString());
                            }
                            lsVar.setLocationDetail(this.O0000OoO.toString());
                            return lsVar;
                        }
                    } catch (Throwable th) {
                        bp.O000000o(th, "MapNetLocation", "getApsLoc req");
                        lsVar.setErrorCode(4);
                        this.O0000OoO.append("please check the network");
                        lsVar.setLocationDetail(this.O0000OoO.toString());
                        return lsVar;
                    }
                } catch (Throwable th2) {
                    bp.O000000o(th2, "MapNetLocation", "getApsLoc buildV4Dot2");
                    lsVar.setErrorCode(3);
                    stringBuilder2 = this.O0000OoO;
                    stringBuilder = new StringBuilder("buildV4Dot2 error ");
                    stringBuilder.append(th2.getMessage());
                    stringBuilder2.append(stringBuilder.toString());
                    lsVar.setLocationDetail(this.O0000OoO.toString());
                    return lsVar;
                }
            } catch (Throwable th22) {
                bp.O000000o(th22, "MapNetLocation", "getApsLoc");
                stringBuilder = this.O0000OoO;
                StringBuilder stringBuilder4 = new StringBuilder("get parames error:");
                stringBuilder4.append(th22.getMessage());
                stringBuilder.append(stringBuilder4.toString());
                lsVar.setErrorCode(3);
                lsVar.setLocationDetail(this.O0000OoO.toString());
                return lsVar;
            }
        }
        lsVar.setErrorCode(15);
        return lsVar;
    }

    private void O00000o0() {
        try {
            if (this.O0000O0o == null) {
                this.O0000O0o = new O000000o(this, (byte) 0);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            this.O000000o.registerReceiver(this.O0000O0o, intentFilter);
            this.O00000oO.O00000Oo(false);
            this.O00000oo.O00000oo();
        } catch (Throwable th) {
            bp.O000000o(th, "MapNetLocation", "initBroadcastListener");
        }
    }

    public final Inner_3dMap_location O000000o() {
        if (this.O0000OoO.length() > 0) {
            this.O0000OoO.delete(0, this.O0000OoO.length());
        }
        if (O000000o(this.O00000o) && bd.O000000o(this.O0000o00)) {
            return this.O0000o00;
        }
        this.O00000o = bt.O00000Oo();
        if (this.O000000o == null) {
            this.O0000OoO.append("context is null");
            Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location("");
            inner_3dMap_location.setErrorCode(1);
            inner_3dMap_location.setLocationDetail(this.O0000OoO.toString());
            return inner_3dMap_location;
        }
        try {
            this.O00000oo.O00000oo();
        } catch (Throwable th) {
            bp.O000000o(th, "MapNetLocation", "getLocation getCgiListParam");
        }
        try {
            this.O00000oO.O00000Oo(true);
        } catch (Throwable th2) {
            bp.O000000o(th2, "MapNetLocation", "getLocation getScanResultsParam");
        }
        try {
            this.O0000o00 = O00000o();
            this.O0000o00 = O000000o(this.O0000o00, new String[0]);
        } catch (Throwable th22) {
            bp.O000000o(th22, "MapNetLocation", "getLocation getScanResultsParam");
        }
        return this.O0000o00;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
    /* JADX WARNING: Failed to process nested try/catch */
    public final void O000000o(com.autonavi.amap.mapcore.Inner_3dMap_locationOption r5) {
        /*
        r4 = this;
        r4.O0000Ooo = r5;
        r5 = r4.O0000Ooo;
        if (r5 != 0) goto L_0x000d;
    L_0x0006:
        r5 = new com.autonavi.amap.mapcore.Inner_3dMap_locationOption;
        r5.<init>();
        r4.O0000Ooo = r5;
    L_0x000d:
        r5 = r4.O00000oO;	 Catch:{ Throwable -> 0x001d }
        r0 = r4.O0000Ooo;	 Catch:{ Throwable -> 0x001d }
        r0.isWifiActiveScan();	 Catch:{ Throwable -> 0x001d }
        r0 = r4.O0000Ooo;	 Catch:{ Throwable -> 0x001d }
        r0 = r0.isWifiScan();	 Catch:{ Throwable -> 0x001d }
        r5.O00000o0(r0);	 Catch:{ Throwable -> 0x001d }
    L_0x001d:
        r5 = r4.O0000OOo;	 Catch:{ Throwable -> 0x0034 }
        r0 = r4.O0000Ooo;	 Catch:{ Throwable -> 0x0034 }
        r0 = r0.getHttpTimeOut();	 Catch:{ Throwable -> 0x0034 }
        r2 = r4.O0000Ooo;	 Catch:{ Throwable -> 0x0034 }
        r2 = r2.getLocationProtocol();	 Catch:{ Throwable -> 0x0034 }
        r3 = com.autonavi.amap.mapcore.Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationProtocol.HTTPS;	 Catch:{ Throwable -> 0x0034 }
        r2 = r2.equals(r3);	 Catch:{ Throwable -> 0x0034 }
        r5.O000000o(r0, r2);	 Catch:{ Throwable -> 0x0034 }
    L_0x0034:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bb.O000000o(com.autonavi.amap.mapcore.Inner_3dMap_locationOption):void");
    }

    public final void O00000Oo() {
        this.O00000Oo = false;
        this.O00000o0 = null;
        try {
            if (!(this.O000000o == null || this.O0000O0o == null)) {
                this.O000000o.unregisterReceiver(this.O0000O0o);
            }
            if (this.O00000oo != null) {
                this.O00000oo.O0000O0o();
            }
            if (this.O00000oO != null) {
                this.O00000oO.O0000OOo();
            }
            this.O0000O0o = null;
        } catch (Throwable th) {
            this.O0000O0o = null;
            throw th;
        }
    }
}
