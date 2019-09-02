package com.loc;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.amap.api.location.AMapLocation;
import java.util.List;
import org.json.JSONObject;

/* compiled from: LastLocationManager */
public final class OO00O {
    static OO0oO O00000Oo;
    static O000O0o O00000oO;
    static long O0000O0o;
    String O000000o = null;
    OO0oO O00000o = null;
    OO0oO O00000o0 = null;
    long O00000oo = 0;
    boolean O0000OOo = false;
    private Context O0000Oo0;

    public OO00O(Context context) {
        this.O0000Oo0 = context.getApplicationContext();
    }

    private void O00000oO() {
        if (O00000Oo == null || OO000OO.O00000o0() - O0000O0o > 180000) {
            OO0oO O00000oo = O00000oo();
            O0000O0o = OO000OO.O00000o0();
            if (O00000oo != null && OO000OO.O000000o(O00000oo.O000000o())) {
                O00000Oo = O00000oo;
            }
        }
    }

    private OO0oO O00000oo() {
        Throwable th;
        CharSequence charSequence = null;
        if (this.O0000Oo0 == null) {
            return null;
        }
        O000000o();
        OO0oO oO0oO;
        try {
            if (O00000oO == null) {
                return null;
            }
            List O00000Oo = O00000oO.O00000Oo("_id=1", OO0oO.class);
            if (O00000Oo == null || O00000Oo.size() <= 0) {
                oO0oO = null;
            } else {
                oO0oO = (OO0oO) O00000Oo.get(0);
                try {
                    String str;
                    String str2;
                    byte[] O00000Oo2 = oOo00.O00000Oo(oO0oO.O00000o0());
                    if (O00000Oo2 != null && O00000Oo2.length > 0) {
                        O00000Oo2 = O0OOO0.O00000o(O00000Oo2, this.O000000o);
                        if (O00000Oo2 != null && O00000Oo2.length > 0) {
                            str = new String(O00000Oo2, HttpUtils.ENCODING_UTF_8);
                            O00000Oo2 = oOo00.O00000Oo(oO0oO.O00000Oo());
                            if (O00000Oo2 != null && O00000Oo2.length > 0) {
                                O00000Oo2 = O0OOO0.O00000o(O00000Oo2, this.O000000o);
                                if (O00000Oo2 != null && O00000Oo2.length > 0) {
                                    str2 = new String(O00000Oo2, HttpUtils.ENCODING_UTF_8);
                                }
                            }
                            oO0oO.O000000o(str2);
                            charSequence = str;
                        }
                    }
                    str = null;
                    O00000Oo2 = oOo00.O00000Oo(oO0oO.O00000Oo());
                    O00000Oo2 = O0OOO0.O00000o(O00000Oo2, this.O000000o);
                    str2 = new String(O00000Oo2, HttpUtils.ENCODING_UTF_8);
                    oO0oO.O000000o(str2);
                    charSequence = str;
                } catch (Throwable th2) {
                    th = th2;
                    O0o0000.O000000o(th, "LastLocationManager", "readLastFix");
                    return oO0oO;
                }
            }
            if (!TextUtils.isEmpty(charSequence)) {
                AMapLocation aMapLocation = new AMapLocation("");
                O0o0000.O000000o(aMapLocation, new JSONObject(charSequence));
                if (OO000OO.O00000Oo(aMapLocation)) {
                    oO0oO.O000000o(aMapLocation);
                    return oO0oO;
                }
            }
            return oO0oO;
        } catch (Throwable th3) {
            th = th3;
            oO0oO = null;
            O0o0000.O000000o(th, "LastLocationManager", "readLastFix");
            return oO0oO;
        }
    }

    public final AMapLocation O000000o(AMapLocation aMapLocation, String str, long j) {
        Throwable th;
        if (aMapLocation == null) {
            return aMapLocation;
        }
        if (!(aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1)) {
            if (aMapLocation.getErrorCode() == 7) {
                return aMapLocation;
            }
            try {
                O00000oO();
                if (O00000Oo == null || O00000Oo.O000000o() == null) {
                    return aMapLocation;
                }
                boolean z = false;
                if (TextUtils.isEmpty(str)) {
                    long O00000o0 = OO000OO.O00000o0() - O00000Oo.O00000o();
                    if (O00000o0 >= 0 && O00000o0 <= j) {
                        z = true;
                    }
                    aMapLocation.setTrustedLevel(3);
                } else {
                    z = OO000OO.O000000o(O00000Oo.O00000Oo(), str);
                    aMapLocation.setTrustedLevel(2);
                }
                if (z) {
                    AMapLocation O000000o = O00000Oo.O000000o();
                    try {
                        O000000o.setLocationType(9);
                        O000000o.setFixLastLocation(true);
                        O000000o.setLocationDetail(aMapLocation.getLocationDetail());
                        return O000000o;
                    } catch (Throwable th2) {
                        AMapLocation aMapLocation2 = O000000o;
                        th = th2;
                        aMapLocation = aMapLocation2;
                        O0o0000.O000000o(th, "LastLocationManager", "fixLastLocation");
                        return aMapLocation;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                O0o0000.O000000o(th, "LastLocationManager", "fixLastLocation");
                return aMapLocation;
            }
        }
        return aMapLocation;
    }

    public final void O000000o() {
        if (!this.O0000OOo) {
            try {
                if (this.O000000o == null) {
                    this.O000000o = O0OOO0.O000000o("MD5", OO0O0o0.O0000oo0(this.O0000Oo0));
                }
                if (O00000oO == null) {
                    O00000oO = new O000O0o(this.O0000Oo0, O000O0o.O000000o(O0OOOo0.class), OO000OO.O0000Oo());
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "LastLocationManager", "<init>:DBOperation");
            }
            this.O0000OOo = true;
        }
    }

    public final boolean O000000o(AMapLocation aMapLocation, String str) {
        if (this.O0000Oo0 == null || aMapLocation == null || !OO000OO.O000000o(aMapLocation) || aMapLocation.getLocationType() == 2 || aMapLocation.isMock() || aMapLocation.isFixLastLocation()) {
            return false;
        }
        OO0oO oO0oO = new OO0oO();
        oO0oO.O000000o(aMapLocation);
        if (aMapLocation.getLocationType() == 1) {
            oO0oO.O000000o(null);
        } else {
            oO0oO.O000000o(str);
        }
        try {
            O00000Oo = oO0oO;
            O0000O0o = OO000OO.O00000o0();
            this.O00000o0 = oO0oO;
            return (this.O00000o == null || OO000OO.O000000o(this.O00000o.O000000o(), oO0oO.O000000o()) > 500.0f) && OO000OO.O00000o0() - this.O00000oo > StatisticConfig.MIN_UPLOAD_INTERVAL;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "LastLocationManager", "setLastFix");
        }
    }

    public final AMapLocation O00000Oo() {
        O00000oO();
        return (O00000Oo != null && OO000OO.O000000o(O00000Oo.O000000o())) ? O00000Oo.O000000o() : null;
    }

    public final void O00000o() {
        try {
            O000000o();
            if (this.O00000o0 != null && OO000OO.O000000o(this.O00000o0.O000000o()) && O00000oO != null && this.O00000o0 != this.O00000o && this.O00000o0.O00000o() == 0) {
                CharSequence charSequence;
                String toStr = this.O00000o0.O000000o().toStr();
                String O00000Oo = this.O00000o0.O00000Oo();
                this.O00000o = this.O00000o0;
                String str = null;
                if (TextUtils.isEmpty(toStr)) {
                    charSequence = null;
                } else {
                    charSequence = oOo00.O00000Oo(O0OOO0.O00000o0(toStr.getBytes(HttpUtils.ENCODING_UTF_8), this.O000000o));
                    if (!TextUtils.isEmpty(O00000Oo)) {
                        str = oOo00.O00000Oo(O0OOO0.O00000o0(O00000Oo.getBytes(HttpUtils.ENCODING_UTF_8), this.O000000o));
                    }
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    Object oO0oO = new OO0oO();
                    oO0oO.O00000Oo(charSequence);
                    oO0oO.O000000o(OO000OO.O00000o0());
                    oO0oO.O000000o(str);
                    O00000oO.O000000o(oO0oO, "_id=1");
                    this.O00000oo = OO000OO.O00000o0();
                    if (O00000Oo != null) {
                        O00000Oo.O000000o(OO000OO.O00000o0());
                    }
                }
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "LastLocationManager", "saveLastFix");
        }
    }

    public final void O00000o0() {
        try {
            O00000o();
            this.O00000oo = 0;
            this.O0000OOo = false;
            this.O00000o0 = null;
            this.O00000o = null;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "LastLocationManager", "destroy");
        }
    }
}
