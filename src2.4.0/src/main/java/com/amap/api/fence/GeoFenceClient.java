package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.location.DPoint;
import com.loc.O000000o;
import com.loc.O000OOo;
import com.loc.O0o0000;
import com.loc.OO0o000;
import java.util.ArrayList;
import java.util.List;

public class GeoFenceClient {
    public static final int GEOFENCE_IN = 1;
    public static final int GEOFENCE_OUT = 2;
    public static final int GEOFENCE_STAYED = 4;
    Context a = null;
    GeoFenceManagerBase b = null;

    public GeoFenceClient(Context context) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                O0o0000.O000000o(th, "GeoFenceClient", "<init>");
                return;
            }
        }
        this.a = context.getApplicationContext();
        this.b = a(this.a);
    }

    private static GeoFenceManagerBase a(Context context) {
        GeoFenceManagerBase geoFenceManagerBase;
        try {
            geoFenceManagerBase = (GeoFenceManagerBase) O000OOo.O000000o(context, O0o0000.O00000Oo(), OO0o000.O00000o0("EY29tLmFtYXAuYXBpLmZlbmNlLkdlb0ZlbmNlTWFuYWdlcldyYXBwZXI="), O000000o.class, new Class[]{Context.class}, new Object[]{context});
        } catch (Throwable unused) {
            geoFenceManagerBase = new O000000o(context);
        }
        return geoFenceManagerBase == null ? new O000000o(context) : geoFenceManagerBase;
    }

    public void addGeoFence(DPoint dPoint, float f, String str) {
        try {
            this.b.addRoundGeoFence(dPoint, f, str);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "addGeoFence round");
        }
    }

    public void addGeoFence(String str, String str2) {
        try {
            this.b.addDistrictGeoFence(str, str2);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "addGeoFence district");
        }
    }

    public void addGeoFence(String str, String str2, DPoint dPoint, float f, int i, String str3) {
        try {
            this.b.addNearbyGeoFence(str, str2, dPoint, f, i, str3);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(String str, String str2, String str3, int i, String str4) {
        try {
            this.b.addKeywordGeoFence(str, str2, str3, i, str4);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "addGeoFence searche");
        }
    }

    public void addGeoFence(List<DPoint> list, String str) {
        try {
            this.b.addPolygonGeoFence(list, str);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "addGeoFence polygon");
        }
    }

    public PendingIntent createPendingIntent(String str) {
        try {
            return this.b.createPendingIntent(str);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "creatPendingIntent");
            return null;
        }
    }

    public List<GeoFence> getAllGeoFence() {
        ArrayList arrayList = new ArrayList();
        try {
            return this.b.getAllGeoFence();
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "getGeoFenceList");
            return arrayList;
        }
    }

    public boolean isPause() {
        try {
            return this.b.isPause();
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "isPause");
            return true;
        }
    }

    public void pauseGeoFence() {
        try {
            this.b.pauseGeoFence();
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "pauseGeoFence");
        }
    }

    public void removeGeoFence() {
        try {
            this.b.removeGeoFence();
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "removeGeoFence");
        }
    }

    public boolean removeGeoFence(GeoFence geoFence) {
        try {
            return this.b.removeGeoFence(geoFence);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "removeGeoFence1");
            return false;
        }
    }

    public void resumeGeoFence() {
        try {
            this.b.resumeGeoFence();
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "resumeGeoFence");
        }
    }

    public void setActivateAction(int i) {
        try {
            this.b.setActivateAction(i);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "setActivatesAction");
        }
    }

    public void setGeoFenceAble(String str, boolean z) {
        try {
            this.b.setGeoFenceAble(str, z);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "setGeoFenceAble");
        }
    }

    public void setGeoFenceListener(GeoFenceListener geoFenceListener) {
        try {
            this.b.setGeoFenceListener(geoFenceListener);
        } catch (Throwable th) {
            O0o0000.O000000o(th, "GeoFenceClient", "setGeoFenceListener");
        }
    }
}
