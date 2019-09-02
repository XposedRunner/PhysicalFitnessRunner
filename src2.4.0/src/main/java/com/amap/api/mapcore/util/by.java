package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.mapcore.MapConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

/* compiled from: GlOverlayLayer */
public class by implements IGlOverlayLayer {
    ca O000000o;
    O000000o O00000Oo = new O000000o();
    private int O00000o = 0;
    private OO00O O00000o0;
    private List<OooOO> O00000oO = new Vector(500);
    private List<O0000O0o> O00000oo = new ArrayList();
    private int[] O0000O0o = new int[1];
    private Handler O0000OOo = new Handler(Looper.getMainLooper());
    private Runnable O0000Oo0 = new Runnable() {
        public synchronized void run() {
            try {
                synchronized (by.this) {
                    if (by.this.O00000oO != null && by.this.O00000oO.size() > 0) {
                        Collections.sort(by.this.O00000oO, by.this.O00000Oo);
                    }
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "MapOverlayImageView", "changeOverlayIndex");
            }
            return;
        }
    };

    /* compiled from: GlOverlayLayer */
    static class O000000o implements Serializable, Comparator<Object> {
        O000000o() {
        }

        public int compare(Object obj, Object obj2) {
            OooOO oooOO = (OooOO) obj;
            OooOO oooOO2 = (OooOO) obj2;
            if (!(oooOO == null || oooOO2 == null)) {
                try {
                    if (oooOO.getZIndex() > oooOO2.getZIndex()) {
                        return 1;
                    }
                    if (oooOO.getZIndex() < oooOO2.getZIndex()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "GlOverlayLayer", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public by(ca caVar) {
        this.O000000o = caVar;
    }

    private void O000000o(OooOO oooOO) throws RemoteException {
        this.O00000oO.add(oooOO);
        O00000oO();
    }

    public boolean IsCircleContainPoint(CircleOptions circleOptions, LatLng latLng) {
        return false;
    }

    public boolean IsPolygonContainsPoint(PolygonOptions polygonOptions, LatLng latLng) {
        return false;
    }

    public O0000O0o O000000o(BitmapDescriptor bitmapDescriptor) {
        return this.O000000o != null ? this.O000000o.O000000o(bitmapDescriptor, true) : null;
    }

    public synchronized O0OOOOO O000000o(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        OooOO o0OO0Oo = new O0OO0Oo(this.O000000o);
        o0OO0Oo.setStrokeColor(arcOptions.getStrokeColor());
        o0OO0Oo.O000000o(arcOptions.getStart());
        o0OO0Oo.O00000Oo(arcOptions.getPassed());
        o0OO0Oo.O00000o0(arcOptions.getEnd());
        o0OO0Oo.setVisible(arcOptions.isVisible());
        o0OO0Oo.setStrokeWidth(arcOptions.getStrokeWidth());
        o0OO0Oo.setZIndex(arcOptions.getZIndex());
        O000000o(o0OO0Oo);
        return o0OO0Oo;
    }

    public O0OOo O000000o() throws RemoteException {
        OooOO o0ooo00 = new O0OOO00(this);
        o0ooo00.O000000o(this.O00000o0);
        O000000o(o0ooo00);
        return o0ooo00;
    }

    public synchronized O0Oo000 O000000o(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        OooOO o0ooo0 = new O0OOO0(this.O000000o);
        o0ooo0.setFillColor(circleOptions.getFillColor());
        o0ooo0.setCenter(circleOptions.getCenter());
        o0ooo0.setVisible(circleOptions.isVisible());
        o0ooo0.setHoleOptions(circleOptions.getHoleOptions());
        o0ooo0.setStrokeWidth(circleOptions.getStrokeWidth());
        o0ooo0.setZIndex(circleOptions.getZIndex());
        o0ooo0.setStrokeColor(circleOptions.getStrokeColor());
        o0ooo0.setRadius(circleOptions.getRadius());
        o0ooo0.setDottedLineType(circleOptions.getStrokeDottedLineType());
        O000000o(o0ooo0);
        return o0ooo0;
    }

    public synchronized O0Oo00 O000000o(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        OooOO oO0oO = new OO0oO(this.O000000o, this);
        oO0oO.O000000o(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        oO0oO.setDimensions(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        oO0oO.setImage(groundOverlayOptions.getImage());
        oO0oO.setPosition(groundOverlayOptions.getLocation());
        oO0oO.setPositionFromBounds(groundOverlayOptions.getBounds());
        oO0oO.setBearing(groundOverlayOptions.getBearing());
        oO0oO.setTransparency(groundOverlayOptions.getTransparency());
        oO0oO.setVisible(groundOverlayOptions.isVisible());
        oO0oO.setZIndex(groundOverlayOptions.getZIndex());
        O000000o(oO0oO);
        return oO0oO;
    }

    public synchronized O0Oo O000000o(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        OooOO oo0000 = new OO0000(this.O000000o);
        oo0000.setTopColor(navigateArrowOptions.getTopColor());
        oo0000.setSideColor(navigateArrowOptions.getSideColor());
        oo0000.setPoints(navigateArrowOptions.getPoints());
        oo0000.setVisible(navigateArrowOptions.isVisible());
        oo0000.setWidth(navigateArrowOptions.getWidth());
        oo0000.setZIndex(navigateArrowOptions.getZIndex());
        oo0000.set3DModel(navigateArrowOptions.is3DModel());
        O000000o(oo0000);
        return oo0000;
    }

    public synchronized O0o0000 O000000o(ParticleOverlayOptions particleOverlayOptions) throws RemoteException {
        if (particleOverlayOptions == null) {
            return null;
        }
        OooOO oO0000o = new OO0000o(this);
        oO0000o.O000000o(particleOverlayOptions);
        O000000o(oO0000o);
        return oO0000o;
    }

    public synchronized O0o000 O000000o(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        OooOO oo000oo = new OO000OO(this.O000000o);
        oo000oo.setFillColor(polygonOptions.getFillColor());
        oo000oo.setPoints(polygonOptions.getPoints());
        oo000oo.setHoleOptions(polygonOptions.getHoleOptions());
        oo000oo.setVisible(polygonOptions.isVisible());
        oo000oo.setStrokeWidth(polygonOptions.getStrokeWidth());
        oo000oo.setZIndex(polygonOptions.getZIndex());
        oo000oo.setStrokeColor(polygonOptions.getStrokeColor());
        O000000o(oo000oo);
        return oo000oo;
    }

    public synchronized O0o00 O000000o(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        OooOO oO000o0 = new OO000o0(this, polylineOptions);
        if (this.O00000o0 != null) {
            oO000o0.O000000o(this.O00000o0);
        }
        O000000o(oO000o0);
        return oO000o0;
    }

    public synchronized OooOO O000000o(LatLng latLng) {
        for (OooOO oooOO : this.O00000oO) {
            if (oooOO != null && oooOO.O00000o0() && (oooOO instanceof O0o00) && ((O0o00) oooOO).O000000o(latLng)) {
                return oooOO;
            }
        }
        return null;
    }

    public synchronized String O000000o(String str) {
        StringBuilder stringBuilder;
        this.O00000o++;
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.O00000o);
        return stringBuilder.toString();
    }

    public void O000000o(O0000O0o o0000O0o) {
        synchronized (this.O00000oo) {
            if (o0000O0o != null) {
                try {
                    this.O00000oo.add(o0000O0o);
                } catch (Throwable th) {
                }
            }
        }
    }

    public void O000000o(OO00O oo00o) {
        this.O00000o0 = oo00o;
    }

    public void O000000o(boolean z) {
        if (this.O000000o != null) {
            this.O000000o.setRunLowFrame(z);
        }
    }

    public synchronized void O000000o(boolean z, int i) {
        try {
            O00000oo();
            MapConfig mapConfig = this.O000000o.getMapConfig();
            if (mapConfig != null) {
                int size = this.O00000oO.size();
                for (OooOO oooOO : this.O00000oO) {
                    if (oooOO.isVisible()) {
                        if (size > 20) {
                            if (oooOO.O000000o()) {
                                if (z) {
                                    if (oooOO.getZIndex() <= ((float) i)) {
                                        oooOO.O000000o(mapConfig);
                                    }
                                } else if (oooOO.getZIndex() > ((float) i)) {
                                    oooOO.O000000o(mapConfig);
                                }
                            }
                        } else if (z) {
                            if (oooOO.getZIndex() <= ((float) i)) {
                                oooOO.O000000o(mapConfig);
                            }
                        } else if (oooOO.getZIndex() > ((float) i)) {
                            oooOO.O000000o(mapConfig);
                        }
                    }
                }
            } else {
                return;
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "GlOverlayLayer", "draw");
        }
        return;
    }

    public OO00O O00000Oo() {
        return this.O00000o0;
    }

    public synchronized void O00000Oo(String str) {
        if (str != null) {
            try {
                if (str.trim().length() != 0) {
                    Object obj = null;
                    for (OooOO oooOO : this.O00000oO) {
                        if (str.equals(oooOO.getId())) {
                            obj = oooOO;
                            break;
                        }
                    }
                    this.O00000oO.clear();
                    if (obj != null) {
                        this.O00000oO.add(obj);
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                ooOOOOoo.O00000o0(th2, "GlOverlayLayer", "clear");
                th2.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("GlOverlayLayer clear erro");
                stringBuilder.append(th2.getMessage());
                Log.d("amapApi", stringBuilder.toString());
            } finally {
            }
        }
        this.O00000oO.clear();
        O00000o0();
    }

    public synchronized void O00000o() {
        try {
            for (OooOO destroy : this.O00000oO) {
                destroy.destroy();
            }
            O00000Oo(null);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "GlOverlayLayer", "destory");
            th.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GlOverlayLayer destory erro");
            stringBuilder.append(th.getMessage());
            Log.d("amapApi", stringBuilder.toString());
        }
        return;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized OooOO O00000o0(String str) throws RemoteException {
        for (OooOO oooOO : this.O00000oO) {
            if (oooOO != null && oooOO.getId().equals(str)) {
                return oooOO;
            }
        }
        return null;
    }

    public synchronized void O00000o0() {
        this.O00000o = 0;
    }

    public synchronized void O00000oO() {
        this.O0000OOo.removeCallbacks(this.O0000Oo0);
        this.O0000OOo.postDelayed(this.O0000Oo0, 10);
    }

    public void O00000oo() {
        synchronized (this.O00000oo) {
            for (int i = 0; i < this.O00000oo.size(); i++) {
                O0000O0o o0000O0o = (O0000O0o) this.O00000oo.get(i);
                if (o0000O0o != null) {
                    o0000O0o.O0000o00();
                    if (o0000O0o.O0000o0() <= 0) {
                        this.O0000O0o[0] = o0000O0o.O0000OoO();
                        GLES20.glDeleteTextures(1, this.O0000O0o, 0);
                        if (this.O000000o != null) {
                            this.O000000o.O00000o0(o0000O0o.O0000o0O());
                        }
                    }
                }
            }
            this.O00000oo.clear();
        }
    }

    public ca O0000O0o() {
        return this.O000000o;
    }

    public float[] O0000OOo() {
        return this.O000000o != null ? this.O000000o.O0000ooO() : new float[16];
    }

    public int getCurrentParticleNum(String str) {
        return 0;
    }

    public LatLng getNearestLatLng(PolylineOptions polylineOptions, LatLng latLng) {
        return null;
    }

    public void prepareIcon(Object obj) {
    }

    public void processCircleHoleOption(CircleOptions circleOptions) {
    }

    public void processPolygonHoleOption(PolygonOptions polygonOptions) {
    }

    public synchronized boolean removeOverlay(String str) throws RemoteException {
        OooOO O00000o0 = O00000o0(str);
        if (O00000o0 == null) {
            return false;
        }
        return this.O00000oO.remove(O00000o0);
    }

    public void updateOption(String str, Object obj) {
    }
}
