package com.autonavi.aps.amapapi.model;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption.GeoLanguage;
import com.loc.O0o0000;
import com.loc.OO000OO;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

public class AMapLocationServer extends AMapLocation {
    protected String d = "";
    boolean e = true;
    String f = String.valueOf(GeoLanguage.DEFAULT);
    private String g = null;
    private String h = "";
    private int i;
    private String j = "";
    private String k = "new";
    private JSONObject l = null;
    private String m = "";
    private String n = "";
    private long o = 0;
    private String p = null;

    public AMapLocationServer(String str) {
        super(str);
    }

    public final String a() {
        return this.g;
    }

    public final void a(long j) {
        this.o = j;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void a(JSONObject jSONObject) {
        this.l = jSONObject;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final String b() {
        return this.h;
    }

    public final void b(String str) {
        this.h = str;
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                O0o0000.O000000o((AMapLocation) this, jSONObject);
                this.k = jSONObject.optString("type", this.k);
                this.j = jSONObject.optString("retype", this.j);
                String optString = jSONObject.optString("cens", this.n);
                if (!TextUtils.isEmpty(optString)) {
                    for (CharSequence charSequence : optString.split("\\*")) {
                        if (!TextUtils.isEmpty(charSequence)) {
                            String[] split = charSequence.split(",");
                            setLongitude(OO000OO.O00000oo(split[0]));
                            setLatitude(OO000OO.O00000oo(split[1]));
                            setAccuracy((float) OO000OO.O0000OOo(split[2]));
                            break;
                        }
                    }
                    this.n = optString;
                }
                this.d = jSONObject.optString(SocialConstants.PARAM_APP_DESC, this.d);
                c(jSONObject.optString("coord", String.valueOf(this.i)));
                this.m = jSONObject.optString("mcell", this.m);
                this.e = jSONObject.optBoolean("isReversegeo", this.e);
                this.f = jSONObject.optString("geoLanguage", this.f);
                if (OO000OO.O000000o(jSONObject, "poiid")) {
                    setBuildingId(jSONObject.optString("poiid"));
                }
                if (OO000OO.O000000o(jSONObject, "pid")) {
                    setBuildingId(jSONObject.optString("pid"));
                }
                if (OO000OO.O000000o(jSONObject, "floor")) {
                    setFloor(jSONObject.optString("floor"));
                }
                if (OO000OO.O000000o(jSONObject, "flr")) {
                    setFloor(jSONObject.optString("flr"));
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AmapLoc", "AmapLoc");
            }
        }
    }

    public final int c() {
        return this.i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    public final void c(java.lang.String r2) {
        /*
        r1 = this;
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 != 0) goto L_0x001a;
    L_0x0006:
        r0 = "0";
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x0010;
    L_0x000e:
        r2 = 0;
        goto L_0x001b;
    L_0x0010:
        r0 = "1";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x001a;
    L_0x0018:
        r2 = 1;
        goto L_0x001b;
    L_0x001a:
        r2 = -1;
    L_0x001b:
        r1.i = r2;
        r2 = r1.i;
        if (r2 != 0) goto L_0x0027;
    L_0x0021:
        r2 = "WGS84";
    L_0x0023:
        super.setCoordType(r2);
        return;
    L_0x0027:
        r2 = "GCJ02";
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.model.AMapLocationServer.c(java.lang.String):void");
    }

    public final String d() {
        return this.j;
    }

    public final void d(String str) {
        this.j = str;
    }

    public final String e() {
        return this.k;
    }

    public final void e(String str) {
        this.k = str;
    }

    public final JSONObject f() {
        return this.l;
    }

    public final void f(String str) {
        this.f = str;
    }

    public final String g() {
        return this.m;
    }

    public final void g(String str) {
        this.d = str;
    }

    public final AMapLocationServer h() {
        String str = this.m;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 3) {
            return null;
        }
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setProvider(getProvider());
        aMapLocationServer.setLongitude(OO000OO.O00000oo(split[0]));
        aMapLocationServer.setLatitude(OO000OO.O00000oo(split[1]));
        aMapLocationServer.setAccuracy(OO000OO.O0000O0o(split[2]));
        aMapLocationServer.setCityCode(getCityCode());
        aMapLocationServer.setAdCode(getAdCode());
        aMapLocationServer.setCountry(getCountry());
        aMapLocationServer.setProvince(getProvince());
        aMapLocationServer.setCity(getCity());
        aMapLocationServer.setTime(getTime());
        aMapLocationServer.k = this.k;
        aMapLocationServer.c(String.valueOf(this.i));
        return !OO000OO.O000000o(aMapLocationServer) ? null : aMapLocationServer;
    }

    public final void h(String str) {
        this.p = str;
    }

    public final boolean i() {
        return this.e;
    }

    public final String j() {
        return this.f;
    }

    public final long k() {
        return this.o;
    }

    public final String l() {
        return this.p;
    }

    public JSONObject toJson(int i) {
        try {
            JSONObject toJson = super.toJson(i);
            switch (i) {
                case 1:
                    toJson.put("retype", this.j);
                    toJson.put("cens", this.n);
                    toJson.put("coord", this.i);
                    toJson.put("mcell", this.m);
                    toJson.put(SocialConstants.PARAM_APP_DESC, this.d);
                    toJson.put("address", getAddress());
                    if (this.l != null && OO000OO.O000000o(toJson, "offpct")) {
                        toJson.put("offpct", this.l.getString("offpct"));
                        break;
                    }
                case 2:
                case 3:
                    break;
                default:
                    return toJson;
            }
            toJson.put("type", this.k);
            toJson.put("isReversegeo", this.e);
            toJson.put("geoLanguage", this.f);
            return toJson;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AmapLoc", "toStr");
            return null;
        }
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int i) {
        JSONObject toJson;
        try {
            toJson = toJson(i);
            toJson.put("nb", this.p);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocation", "toStr part2");
            toJson = null;
        }
        return toJson == null ? null : toJson.toString();
    }
}
