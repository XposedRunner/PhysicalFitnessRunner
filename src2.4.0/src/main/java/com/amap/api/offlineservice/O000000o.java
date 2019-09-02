package com.amap.api.offlineservice;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.maps.offlinemap.OfflineMapActivity;

/* compiled from: ServiceModule */
public abstract class O000000o {
    protected OfflineMapActivity O000000o = null;

    public int O000000o(float f) {
        return this.O000000o != null ? (int) ((f * (((float) this.O000000o.getResources().getDisplayMetrics().densityDpi) / 160.0f)) + 0.5f) : (int) f;
    }

    public abstract void O000000o();

    public void O000000o(Bundle bundle) {
        this.O000000o.showScr();
    }

    public abstract void O000000o(View view);

    public void O000000o(OfflineMapActivity offlineMapActivity) {
        this.O000000o = offlineMapActivity;
    }

    public abstract RelativeLayout O00000Oo();

    public abstract void O00000o0();

    public boolean O00000oO() {
        return true;
    }

    public void O00000oo() {
    }

    public void O0000O0o() {
    }

    public void O0000OOo() {
    }

    public void O0000Oo0() {
    }
}
