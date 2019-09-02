package cn.jiguang.a.a.b;

import android.net.wifi.ScanResult;
import cn.jiguang.d.a.a;
import org.json.JSONObject;

public final class i implements Comparable<i> {
    public final String a;
    public final int b;
    public final String c;
    final /* synthetic */ h d;

    public i(h hVar, ScanResult scanResult) {
        this.d = hVar;
        this.a = scanResult.BSSID;
        this.b = scanResult.level;
        this.c = cn.jiguang.g.i.c(scanResult.SSID);
    }

    public i(h hVar, String str, int i, String str2) {
        this.d = hVar;
        this.a = str;
        this.b = i;
        this.c = cn.jiguang.g.i.c(str2);
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac_address", this.a);
            jSONObject.put("signal_strength", this.b);
            jSONObject.put("ssid", this.c);
            jSONObject.put("age", 0);
            jSONObject.put("itime", a.q());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return ((i) obj).b - this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.c != null && this.c.equals(iVar.c) && this.a != null && this.a.equals(iVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() ^ this.a.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("WifiInfo{bssid='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", dBm=");
        stringBuilder.append(this.b);
        stringBuilder.append(", ssid='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
