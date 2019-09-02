package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* compiled from: MapLocationModel */
public final class ls extends Inner_3dMap_location {
    boolean O000000o = true;
    private String O00000Oo = null;
    private int O00000o;
    private String O00000o0 = "";
    private String O00000oO = "";
    private String O00000oo = "new";
    private JSONObject O0000O0o = null;
    private String O0000OOo = "";
    private long O0000Oo = 0;
    private String O0000Oo0 = "";
    private String O0000OoO = null;

    public ls(String str) {
        super(str);
    }

    public final String O000000o() {
        return this.O00000Oo;
    }

    public final void O000000o(String str) {
        this.O00000Oo = str;
    }

    public final String O00000Oo() {
        return this.O00000o0;
    }

    public final void O00000Oo(String str) {
        this.O00000o0 = str;
    }

    public final String O00000o() {
        return this.O00000oO;
    }

    public final void O00000o(String str) {
        this.O00000oO = str;
    }

    public final int O00000o0() {
        return this.O00000o;
    }

    public final void O00000o0(String str) {
        int i;
        if (!TextUtils.isEmpty(str)) {
            if (getProvider().equals("gps")) {
                this.O00000o = 0;
                return;
            } else if (str.equals("0")) {
                this.O00000o = 0;
                return;
            } else if (str.equals("1")) {
                i = 1;
                this.O00000o = i;
            }
        }
        i = -1;
        this.O00000o = i;
    }

    public final JSONObject O00000oO() {
        return this.O0000O0o;
    }

    public final void O00000oO(String str) {
        this.desc = str;
    }

    public final void setFloor(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                bp.O000000o(th, "MapLocationModel", "setFloor");
                str = null;
            }
        }
        this.floor = str;
    }

    public final JSONObject toJson(int i) {
        try {
            JSONObject toJson = super.toJson(i);
            switch (i) {
                case 1:
                    toJson.put("retype", this.O00000oO);
                    toJson.put("cens", this.O0000Oo0);
                    toJson.put("poiid", this.buildingId);
                    toJson.put("floor", this.floor);
                    toJson.put("coord", this.O00000o);
                    toJson.put("mcell", this.O0000OOo);
                    toJson.put(SocialConstants.PARAM_APP_DESC, this.desc);
                    toJson.put("address", getAddress());
                    if (this.O0000O0o != null && bt.O000000o(toJson, "offpct")) {
                        toJson.put("offpct", this.O0000O0o.getString("offpct"));
                        break;
                    }
                case 2:
                case 3:
                    break;
                default:
                    return toJson;
            }
            toJson.put("type", this.O00000oo);
            toJson.put("isReversegeo", this.O000000o);
            return toJson;
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationModel", "toStr");
            return null;
        }
    }

    public final String toStr(int i) {
        JSONObject toJson;
        try {
            toJson = super.toJson(i);
            toJson.put("nb", this.O0000OoO);
        } catch (Throwable th) {
            bp.O000000o(th, "MapLocationModel", "toStr part2");
            toJson = null;
        }
        return toJson == null ? null : toJson.toString();
    }
}
