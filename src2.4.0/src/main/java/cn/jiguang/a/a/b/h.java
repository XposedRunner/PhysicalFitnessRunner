package cn.jiguang.a.a.b;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import cn.jiguang.g.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h {
    private WifiManager a;
    private Context b = null;
    private JSONArray c;

    public h(Context context) {
        this.a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.b = context;
    }

    private List<i> a(JSONArray jSONArray) {
        i iVar = null;
        if (!d()) {
            return null;
        }
        JSONObject a;
        WifiInfo connectionInfo = this.a.getConnectionInfo();
        i iVar2 = connectionInfo != null ? new i(this, connectionInfo.getBSSID(), connectionInfo.getRssi(), connectionInfo.getSSID()) : null;
        List<i> arrayList = new ArrayList();
        if (iVar2 != null) {
            a = iVar2.a();
            a.put("tag", "connect");
            jSONArray.put(a);
        }
        List<ScanResult> scanResults = (VERSION.SDK_INT >= 23 && (this.b == null || !a.a(this.b, "android.permission.ACCESS_COARSE_LOCATION"))) ? null : this.a.getScanResults();
        if (scanResults != null && scanResults.size() > 0) {
            int i = -200;
            for (ScanResult iVar3 : scanResults) {
                i iVar4 = new i(this, iVar3);
                if (!(iVar2 == null || iVar2.equals(iVar4))) {
                    arrayList.add(iVar4);
                    if (!iVar4.c.equals(iVar2.c) && iVar4.b > i) {
                        i = iVar4.b;
                        iVar = iVar4;
                    }
                }
            }
            Collections.sort(arrayList);
            int i2 = 10;
            if (iVar != null) {
                a = iVar.a();
                a.put("tag", "strongest");
                jSONArray.put(a);
                arrayList.remove(iVar);
                i2 = 9;
            }
            if (iVar2 != null) {
                arrayList.remove(iVar2);
                i2--;
            }
            if (arrayList.size() > i2) {
                List subList = arrayList.subList(0, i2);
                arrayList = new ArrayList();
                arrayList.addAll(subList);
            }
        }
        return arrayList;
    }

    private boolean d() {
        try {
            return this.a.isWifiEnabled();
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a() {
        this.c = null;
    }

    public final void b() {
        if (a.a(this.b, "android.permission.ACCESS_WIFI_STATE")) {
            Context context = this.b;
            Object obj = (a.a(context, "android.permission.ACCESS_COARSE_LOCATION") && a.a(context, "android.permission.ACCESS_WIFI_STATE") && a.a(context, "android.permission.CHANGE_WIFI_STATE") && a.a(context, "android.permission.ACCESS_FINE_LOCATION")) ? 1 : null;
            if ((obj != null || a.o(this.b)) && this.a.isWifiEnabled()) {
                JSONArray jSONArray = new JSONArray();
                try {
                    List<i> a = a(jSONArray);
                    if (a != null) {
                        a.size();
                    }
                    if (a != null) {
                        for (i a2 : a) {
                            jSONArray.put(a2.a());
                        }
                    }
                } catch (Throwable unused) {
                }
                this.c = jSONArray;
            }
        }
    }

    public final JSONArray c() {
        return this.c;
    }
}
