package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: TileOverlayView */
public class O0000o00 {
    List<O0o> O000000o = new ArrayList();
    O000000o O00000Oo = new O000000o();
    OO00O0 O00000o = null;
    List<Integer> O00000o0 = new ArrayList();
    float[] O00000oO = new float[16];
    private ca O00000oo;
    private Context O0000O0o;

    /* compiled from: TileOverlayView */
    static class O000000o implements Serializable, Comparator<Object> {
        O000000o() {
        }

        public int compare(Object obj, Object obj2) {
            O0o o0o = (O0o) obj;
            O0o o0o2 = (O0o) obj2;
            if (!(o0o == null || o0o2 == null)) {
                try {
                    return Float.compare(o0o.getZIndex(), o0o2.getZIndex());
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "TileOverlayView", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public O0000o00(Context context, ca caVar) {
        this.O00000oo = caVar;
        this.O0000O0o = context;
        TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new OO0o00(256, 256, this.O00000oo.getMapConfig()));
        tileProvider.memCacheSize(10485760);
        tileProvider.diskCacheSize(20480);
        this.O00000o = new OO00O0(tileProvider, this, true);
    }

    private boolean O0000Oo0() {
        return this.O00000oo == null ? false : MapsInitializer.isLoadWorldGridMap() || this.O00000oo.getMapConfig().getMapLanguage().equals(AMap.ENGLISH);
    }

    public ca O000000o() {
        return this.O00000oo;
    }

    public TileOverlay O000000o(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        if (tileOverlayOptions == null || tileOverlayOptions.getTileProvider() == null) {
            return null;
        }
        try {
            O0o oo00o0 = new OO00O0(tileOverlayOptions, this, false);
            O000000o(oo00o0);
            oo00o0.O000000o(true);
            this.O00000oo.setRunLowFrame(false);
            return new TileOverlay(oo00o0);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void O000000o(int i) {
        this.O00000o0.add(Integer.valueOf(i));
    }

    public void O000000o(O0o o0o) {
        synchronized (this.O000000o) {
            O00000Oo(o0o);
            this.O000000o.add(o0o);
        }
        O00000o();
    }

    public void O000000o(String str) {
        if (this.O00000o != null) {
            this.O00000o.O000000o(str);
        }
    }

    public void O000000o(boolean z) {
        try {
            if (O0000Oo0()) {
                CameraPosition cameraPosition = this.O00000oo.getCameraPosition();
                if (cameraPosition != null) {
                    if (!cameraPosition.isAbroad || cameraPosition.zoom <= 7.0f) {
                        if (this.O00000o != null) {
                            if (this.O00000oo.getMapConfig().getMapLanguage().equals(AMap.ENGLISH)) {
                                this.O00000o.O000000o(z);
                            } else {
                                this.O00000o.O00000Oo();
                            }
                        }
                    } else if (this.O00000oo.getMapType() == 1) {
                        if (this.O00000o != null) {
                            this.O00000o.O000000o(z);
                        }
                    } else if (this.O00000o != null) {
                        this.O00000o.O00000Oo();
                    }
                } else {
                    return;
                }
            }
            synchronized (this.O000000o) {
                int size = this.O000000o.size();
                for (int i = 0; i < size; i++) {
                    O0o o0o = (O0o) this.O000000o.get(i);
                    if (o0o != null && o0o.isVisible()) {
                        o0o.O000000o(z);
                    }
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "TileOverlayView", "refresh");
        }
    }

    public void O00000Oo() {
        try {
            for (Integer intValue : this.O00000o0) {
                OOo000.O00000Oo(intValue.intValue());
            }
            this.O00000o0.clear();
            if (O0000Oo0() && this.O00000o != null) {
                this.O00000o.O000000o();
            }
            synchronized (this.O000000o) {
                int size = this.O000000o.size();
                for (int i = 0; i < size; i++) {
                    O0o o0o = (O0o) this.O000000o.get(i);
                    if (o0o.isVisible()) {
                        o0o.O000000o();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void O00000Oo(boolean z) {
        if (this.O00000o != null) {
            this.O00000o.O00000Oo(z);
        }
        synchronized (this.O000000o) {
            int size = this.O000000o.size();
            for (int i = 0; i < size; i++) {
                O0o o0o = (O0o) this.O000000o.get(i);
                if (o0o != null) {
                    o0o.O00000Oo(z);
                }
            }
        }
    }

    public boolean O00000Oo(O0o o0o) {
        boolean remove;
        synchronized (this.O000000o) {
            remove = this.O000000o.remove(o0o);
        }
        return remove;
    }

    public void O00000o() {
        synchronized (this.O000000o) {
            Collections.sort(this.O000000o, this.O00000Oo);
        }
    }

    public void O00000o0() {
        synchronized (this.O000000o) {
            int size = this.O000000o.size();
            for (int i = 0; i < size; i++) {
                O0o o0o = (O0o) this.O000000o.get(i);
                if (o0o != null) {
                    o0o.destroy(true);
                }
            }
            this.O000000o.clear();
        }
    }

    public Context O00000oO() {
        return this.O0000O0o;
    }

    public void O00000oo() {
        O00000o0();
        if (this.O00000o != null) {
            this.O00000o.O00000o0();
            this.O00000o.destroy(false);
        }
        this.O00000o = null;
    }

    public float[] O0000O0o() {
        return this.O00000oo != null ? this.O00000oo.O0000ooO() : this.O00000oO;
    }

    public void O0000OOo() {
        if (this.O00000o != null) {
            this.O00000o.clearTileCache();
            OOOO00O.O000000o(this.O0000O0o, "Map3DCache", "time", Long.valueOf(System.currentTimeMillis()));
        }
        synchronized (this.O000000o) {
            int size = this.O000000o.size();
            for (int i = 0; i < size; i++) {
                O0o o0o = (O0o) this.O000000o.get(i);
                if (o0o != null) {
                    o0o.clearTileCache();
                }
            }
        }
    }
}
