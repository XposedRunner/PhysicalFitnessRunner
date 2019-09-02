package cn.jiguang.a.a.b;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

final class d implements LocationListener {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void onLocationChanged(Location location) {
        if (location != null) {
            this.a.a(location, this.a.c, false);
        }
        this.a.d();
    }

    public final void onProviderDisabled(String str) {
        this.a.d();
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
        if (i == 0) {
            this.a.d();
        }
    }
}
