package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;

/* compiled from: ArcDelegateImp */
public class O0OO0Oo implements O0OOOOO {
    float O000000o;
    float O00000Oo;
    float O00000o;
    float O00000o0;
    private LatLng O00000oO;
    private LatLng O00000oo;
    private LatLng O0000O0o;
    private float O0000OOo = 10.0f;
    private float O0000Oo = 0.0f;
    private int O0000Oo0 = ViewCompat.MEASURED_STATE_MASK;
    private boolean O0000OoO = true;
    private String O0000Ooo;
    private double O0000o = 0.0d;
    private float[] O0000o0;
    private ca O0000o00;
    private int O0000o0O = 0;
    private boolean O0000o0o = false;
    private double O0000oO = 0.0d;
    private double O0000oO0 = 0.0d;

    public O0OO0Oo(ca caVar) {
        this.O0000o00 = caVar;
        try {
            this.O0000Ooo = getId();
        } catch (RemoteException e) {
            ooOOOOoo.O00000o0(e, "ArcDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private double O000000o(double d, double d2, double d3, double d4) {
        d2 = (d2 - d4) / this.O0000o;
        if (Math.abs(d2) > 1.0d) {
            d2 = Math.signum(d2);
        }
        d2 = Math.asin(d2);
        return d2 >= 0.0d ? d3 < d ? 3.141592653589793d - Math.abs(d2) : d2 : d3 < d ? 3.141592653589793d - d2 : d2 + 6.283185307179586d;
    }

    private FPoint O000000o(GLMapState gLMapState, double d, double d2, double d3) {
        int cos = (int) (d2 + (Math.cos(d) * this.O0000o));
        int i = (int) (d3 + ((-Math.sin(d)) * this.O0000o));
        FPoint obtain = FPoint.obtain();
        MapConfig mapConfig = this.O0000o00.getMapConfig();
        if (mapConfig != null) {
            obtain.x = (float) (cos - mapConfig.getSX());
            obtain.y = (float) (i - mapConfig.getSY());
        }
        return obtain;
    }

    private boolean O00000o() {
        return Math.abs((((this.O00000oO.latitude - this.O00000oo.latitude) * (this.O00000oo.longitude - this.O0000O0o.longitude)) * Math.pow(10.0d, 6.0d)) - (((this.O00000oO.longitude - this.O00000oo.longitude) * (this.O00000oo.latitude - this.O0000O0o.latitude)) * Math.pow(10.0d, 6.0d))) >= 1.0E-6d;
    }

    private DPoint O00000oO() {
        IPoint obtain = IPoint.obtain();
        this.O0000o00.O000000o(this.O00000oO.latitude, this.O00000oO.longitude, obtain);
        IPoint obtain2 = IPoint.obtain();
        this.O0000o00.O000000o(this.O00000oo.latitude, this.O00000oo.longitude, obtain2);
        IPoint obtain3 = IPoint.obtain();
        this.O0000o00.O000000o(this.O0000O0o.latitude, this.O0000O0o.longitude, obtain3);
        double d = (double) obtain.x;
        double d2 = (double) obtain.y;
        double d3 = (double) obtain2.x;
        double d4 = (double) obtain2.y;
        double d5 = (double) obtain3.x;
        IPoint iPoint = obtain;
        IPoint iPoint2 = obtain3;
        double d6 = (double) obtain3.y;
        double d7 = d6 - d2;
        double d8 = d4 * d4;
        double d9 = d2 * d2;
        double d10 = d3 * d3;
        double d11 = d * d;
        double d12 = d4 - d2;
        double d13 = d6 * d6;
        double d14 = d5 * d5;
        double d15 = d3 - d;
        double d16 = d5 - d;
        double d17 = d6;
        d6 = (((((d8 - d9) + d10) - d11) * d7) + ((((d9 - d13) + d11) - d14) * d12)) / (((2.0d * d15) * d7) - ((2.0d * d16) * d12));
        double d18 = d3;
        d3 = (((((d10 - d11) + d8) - d9) * d16) + ((((d11 - d14) + d9) - d13) * d15)) / (((d12 * 2.0d) * d16) - ((2.0d * d7) * d15));
        d7 = d - d6;
        d8 = d2 - d3;
        double d19 = d5;
        this.O0000o = Math.sqrt((d7 * d7) + (d8 * d8));
        d7 = d19;
        d8 = d4;
        d4 = d3;
        IPoint iPoint3 = obtain2;
        this.O0000oO0 = O000000o(d6, d4, d, d2);
        d5 = d6;
        d2 = O000000o(d5, d4, d18, d8);
        this.O0000oO = O000000o(d5, d4, d7, d17);
        if (this.O0000oO0 < this.O0000oO) {
            if (d2 <= this.O0000oO0 || d2 >= this.O0000oO) {
                this.O0000oO -= 6.283185307179586d;
            }
        } else if (d2 <= this.O0000oO || d2 >= this.O0000oO0) {
            this.O0000oO += 6.283185307179586d;
        }
        iPoint.recycle();
        iPoint3.recycle();
        iPoint2.recycle();
        return DPoint.obtain(d6, d3);
    }

    public void O000000o(LatLng latLng) {
        this.O00000oO = latLng;
    }

    public void O000000o(MapConfig mapConfig) throws RemoteException {
        if (this.O00000oO != null && this.O00000oo != null && this.O0000O0o != null && this.O0000OoO) {
            O00000Oo();
            if (this.O0000o0 != null && this.O0000o0O > 0) {
                float mapLenWithWin = this.O0000o00.O00000o0().getMapLenWithWin((int) this.O0000OOo);
                this.O0000o00.O00000o0().getMapLenWithWin(1);
                AMapNativeRenderer.nativeDrawLineByTextureID(this.O0000o0, this.O0000o0.length, mapLenWithWin, this.O0000o00.O00000o(), this.O00000Oo, this.O00000o0, this.O00000o, this.O000000o, 0.0f, false, true, false, this.O0000o00.O0000ooO(), 3, 0);
            }
            this.O0000o0o = true;
        }
    }

    public boolean O000000o() {
        return true;
    }

    public void O00000Oo(LatLng latLng) {
        this.O00000oo = latLng;
    }

    public boolean O00000Oo() throws RemoteException {
        if (this.O00000oO == null || this.O00000oo == null || this.O0000O0o == null || !this.O0000OoO) {
            return false;
        }
        try {
            this.O0000o0o = false;
            GLMapState O00000o0 = this.O0000o00.O00000o0();
            if (O00000o()) {
                FPoint[] fPointArr;
                DPoint O00000oO = O00000oO();
                int abs = (int) ((Math.abs(this.O0000oO - this.O0000oO0) * 180.0d) / 3.141592653589793d);
                double d = (this.O0000oO - this.O0000oO0) / ((double) abs);
                FPoint[] fPointArr2 = new FPoint[(abs + 1)];
                this.O0000o0 = new float[(3 * fPointArr2.length)];
                int i = 0;
                while (i <= abs) {
                    int i2;
                    if (i == abs) {
                        FPoint obtain = FPoint.obtain();
                        this.O0000o00.O000000o(this.O0000O0o.latitude, this.O0000O0o.longitude, obtain);
                        fPointArr2[i] = obtain;
                        fPointArr = fPointArr2;
                        i2 = i;
                    } else {
                        fPointArr = fPointArr2;
                        i2 = i;
                        fPointArr[i2] = O000000o(O00000o0, (((double) i) * d) + this.O0000oO0, O00000oO.x, O00000oO.y);
                    }
                    GLMapState gLMapState = O00000o0;
                    fPointArr[i2] = O000000o(gLMapState, (((double) i2) * d) + this.O0000oO0, O00000oO.x, O00000oO.y);
                    i = i2 * 3;
                    this.O0000o0[i] = fPointArr[i2].x;
                    this.O0000o0[i + 1] = fPointArr[i2].y;
                    this.O0000o0[i + 2] = 0.0f;
                    i = i2 + 1;
                    fPointArr2 = fPointArr;
                }
                fPointArr = fPointArr2;
                O00000oO.recycle();
                this.O0000o0O = fPointArr.length;
                return true;
            }
            FPoint[] fPointArr3 = new FPoint[3];
            this.O0000o0 = new float[(fPointArr3.length * 3)];
            FPoint obtain2 = FPoint.obtain();
            this.O0000o00.O000000o(this.O00000oO.latitude, this.O00000oO.longitude, obtain2);
            fPointArr3[0] = obtain2;
            obtain2 = FPoint.obtain();
            this.O0000o00.O000000o(this.O00000oo.latitude, this.O00000oo.longitude, obtain2);
            fPointArr3[1] = obtain2;
            obtain2 = FPoint.obtain();
            this.O0000o00.O000000o(this.O0000O0o.latitude, this.O0000O0o.longitude, obtain2);
            fPointArr3[2] = obtain2;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = i3 * 3;
                this.O0000o0[i4] = fPointArr3[i3].x;
                this.O0000o0[i4 + 1] = fPointArr3[i3].y;
                this.O0000o0[i4 + 2] = 0.0f;
            }
            this.O0000o0O = fPointArr3.length;
            return true;
        } catch (Throwable th) {
            Throwable th2 = th;
            ooOOOOoo.O00000o0(th2, "ArcDelegateImp", "calMapFPoint");
            th2.printStackTrace();
            return false;
        }
    }

    public void O00000o0(LatLng latLng) {
        this.O0000O0o = latLng;
    }

    public boolean O00000o0() {
        return this.O0000o0o;
    }

    public void destroy() {
        try {
            this.O00000oO = null;
            this.O00000oo = null;
            this.O0000O0o = null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "ArcDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "ArcDelegateImp destroy");
        }
    }

    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public String getId() throws RemoteException {
        if (this.O0000Ooo == null) {
            this.O0000Ooo = this.O0000o00.O00000o("Arc");
        }
        return this.O0000Ooo;
    }

    public int getStrokeColor() throws RemoteException {
        return this.O0000Oo0;
    }

    public float getStrokeWidth() throws RemoteException {
        return this.O0000OOo;
    }

    public float getZIndex() throws RemoteException {
        return this.O0000Oo;
    }

    public int hashCodeRemote() throws RemoteException {
        return 0;
    }

    public boolean isAboveMaskLayer() {
        return false;
    }

    public boolean isVisible() throws RemoteException {
        return this.O0000OoO;
    }

    public void remove() throws RemoteException {
        this.O0000o00.O000000o(getId());
        this.O0000o00.setRunLowFrame(false);
    }

    public void setAboveMaskLayer(boolean z) {
    }

    public void setStrokeColor(int i) throws RemoteException {
        this.O0000Oo0 = i;
        this.O000000o = ((float) Color.alpha(i)) / 255.0f;
        this.O00000Oo = ((float) Color.red(i)) / 255.0f;
        this.O00000o0 = ((float) Color.green(i)) / 255.0f;
        this.O00000o = ((float) Color.blue(i)) / 255.0f;
        this.O0000o00.setRunLowFrame(false);
    }

    public void setStrokeWidth(float f) throws RemoteException {
        this.O0000OOo = f;
        this.O0000o00.setRunLowFrame(false);
    }

    public void setVisible(boolean z) throws RemoteException {
        this.O0000OoO = z;
        this.O0000o00.setRunLowFrame(false);
    }

    public void setZIndex(float f) throws RemoteException {
        this.O0000Oo = f;
        this.O0000o00.O00000oo();
        this.O0000o00.setRunLowFrame(false);
    }
}
