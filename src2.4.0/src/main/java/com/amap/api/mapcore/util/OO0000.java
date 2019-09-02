package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.maps.model.LatLng;
import com.autonavi.ae.gmap.gloverlay.GLOverlay.EAMapOverlayTpye;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AMapNativeRenderer;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/* compiled from: NavigateArrowDelegateImp */
public class OO0000 implements O0Oo {
    int[] O000000o = null;
    int[] O00000Oo = null;
    float O00000o;
    float O00000o0;
    float O00000oO;
    float O00000oo;
    Rect O0000O0o = null;
    boolean O0000OOo = false;
    int O0000Oo = 0;
    float[] O0000Oo0;
    private ca O0000OoO;
    private float O0000Ooo = 10.0f;
    private String O0000o;
    private int O0000o0 = ViewCompat.MEASURED_STATE_MASK;
    private int O0000o00 = ViewCompat.MEASURED_STATE_MASK;
    private float O0000o0O = 0.0f;
    private boolean O0000o0o = true;
    private int O0000oO = 0;
    private List<IPoint> O0000oO0 = new Vector();
    private boolean O0000oOO = false;
    private boolean O0000oOo = false;
    private boolean O0000oo = false;
    private boolean O0000oo0 = false;
    private Object O0000ooO = new Object();
    private String O0000ooo = null;
    private final int O00oOooO = Color.argb(0, 0, 0, 0);
    private boolean O00oOooo = true;

    public OO0000(ca caVar) {
        this.O0000OoO = caVar;
        try {
            this.O0000o = getId();
        } catch (RemoteException e) {
            ooOOOOoo.O00000o0(e, "NavigateArrowDelegateImp", "create");
            e.printStackTrace();
        }
        this.O0000OOo = false;
    }

    private List<LatLng> O00000Oo() throws RemoteException {
        if (this.O0000oO0 == null) {
            return null;
        }
        ArrayList arrayList;
        synchronized (this.O0000ooO) {
            arrayList = new ArrayList();
            for (IPoint iPoint : this.O0000oO0) {
                if (iPoint != null) {
                    DPoint obtain = DPoint.obtain();
                    this.O0000OoO.O000000o(iPoint.x, iPoint.y, obtain);
                    arrayList.add(new LatLng(obtain.y, obtain.x));
                    obtain.recycle();
                }
            }
        }
        return arrayList;
    }

    public void O000000o(MapConfig mapConfig) throws RemoteException {
        if (!this.O0000OOo && this.O0000oO0 != null && this.O0000oO0.size() != 0 && this.O0000Ooo > 0.0f) {
            if (!this.O0000oOo) {
                if (this.O0000ooo != null && this.O0000oo0) {
                    this.O0000OoO.O000000o().updateNativeArrowOverlay(1, this.O0000ooo, this.O000000o, this.O00000Oo, this.O0000o00, this.O0000o0, this.O00oOooO, this.O0000Ooo, 111, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, false);
                    this.O00oOooo = false;
                }
                O00000Oo(this.O0000OoO.getMapConfig());
                if (this.O0000Oo0 != null && this.O0000oO > 0) {
                    AMapNativeRenderer.nativeDrawLineByTextureID(this.O0000Oo0, this.O0000Oo, this.O0000OoO.O00000o0().getMapLenWithWin((int) this.O0000Ooo), this.O0000OoO.O00000o(), this.O00000o, this.O00000oO, this.O00000oo, this.O00000o0, 0.0f, false, true, true, this.O0000OoO.O0000ooO(), 2, 0);
                    this.O0000oo0 = false;
                    this.O0000oo = false;
                }
            } else if (!(this.O0000OoO == null || this.O0000OoO.O000000o() == null)) {
                if (this.O0000ooo == null) {
                    this.O0000ooo = this.O0000OoO.O000000o().addNativeOverlay(1, EAMapOverlayTpye.AMAPOVERLAY_ARROW.ordinal(), hashCode());
                }
                if (this.O0000ooo != null && this.O00oOooo) {
                    this.O0000OoO.O000000o().updateNativeArrowOverlay(1, this.O0000ooo, this.O000000o, this.O00000Oo, this.O0000o00, this.O0000o0, this.O00oOooO, this.O0000Ooo, 111, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, this.O0000o0o);
                    this.O0000oo0 = true;
                    this.O0000oo = this.O0000o0o;
                    this.O00oOooo = false;
                }
            }
            this.O0000oOO = true;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(List<LatLng> list) throws RemoteException {
        synchronized (this.O0000ooO) {
            this.O0000oO0.clear();
            if (this.O0000O0o == null) {
                this.O0000O0o = new Rect();
            }
            OOo000.O000000o(this.O0000O0o);
            if (list != null) {
                Object obj = null;
                for (LatLng latLng : list) {
                    if (latLng != null) {
                        if (!latLng.equals(obj)) {
                            IPoint obtain = IPoint.obtain();
                            this.O0000OoO.O000000o(latLng.latitude, latLng.longitude, obtain);
                            this.O0000oO0.add(obtain);
                            OOo000.O00000Oo(this.O0000O0o, obtain.x, obtain.y);
                            obj = latLng;
                        }
                    }
                }
            }
            this.O0000oO = 0;
            this.O0000O0o.sort();
            int size = this.O0000oO0.size();
            this.O000000o = new int[size];
            this.O00000Oo = new int[size];
            int i = 0;
            for (IPoint iPoint : this.O0000oO0) {
                this.O000000o[i] = iPoint.x;
                this.O00000Oo[i] = iPoint.y;
                i++;
            }
        }
        this.O0000OoO.setRunLowFrame(false);
    }

    public boolean O000000o() {
        if (this.O0000O0o == null) {
            return false;
        }
        Rectangle geoRectangle = this.O0000OoO.getMapConfig().getGeoRectangle();
        return geoRectangle != null && geoRectangle.isOverlap(this.O0000O0o);
    }

    public boolean O00000Oo(MapConfig mapConfig) throws RemoteException {
        synchronized (this.O0000ooO) {
            int sx = mapConfig.getSX();
            int sy = mapConfig.getSY();
            int i = 0;
            this.O0000oOO = false;
            int size = this.O0000oO0.size();
            if (this.O0000Oo0 == null || this.O0000Oo0.length < 3 * size) {
                this.O0000Oo0 = new float[(3 * size)];
            }
            this.O0000Oo = 3 * size;
            for (IPoint iPoint : this.O0000oO0) {
                int i2 = i * 3;
                this.O0000Oo0[i2] = (float) (iPoint.x - sx);
                this.O0000Oo0[i2 + 1] = (float) (iPoint.y - sy);
                this.O0000Oo0[i2 + 2] = 0.0f;
                i++;
            }
            this.O0000oO = this.O0000oO0.size();
        }
        return true;
    }

    public boolean O00000o0() {
        return this.O0000oOO;
    }

    public void destroy() {
        try {
            remove();
            if (this.O0000Oo0 != null) {
                this.O0000Oo0 = null;
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "NavigateArrowDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "NavigateArrowDelegateImp destroy");
        }
    }

    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public String getId() throws RemoteException {
        if (this.O0000o == null) {
            this.O0000o = this.O0000OoO.O00000o("NavigateArrow");
        }
        return this.O0000o;
    }

    public List<LatLng> getPoints() throws RemoteException {
        return O00000Oo();
    }

    public int getSideColor() throws RemoteException {
        return this.O0000o0;
    }

    public int getTopColor() throws RemoteException {
        return this.O0000o00;
    }

    public float getWidth() throws RemoteException {
        return this.O0000Ooo;
    }

    public float getZIndex() throws RemoteException {
        return this.O0000o0O;
    }

    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    public boolean is3DModel() {
        return this.O0000oOo;
    }

    public boolean isAboveMaskLayer() {
        return false;
    }

    public boolean isVisible() throws RemoteException {
        if (!this.O0000oOo) {
            return this.O0000o0o;
        }
        boolean z = this.O0000o0o || this.O0000oo;
        return z;
    }

    public void remove() throws RemoteException {
        if (!this.O0000OOo) {
            if (!(this.O0000OoO == null || this.O0000OoO.O000000o() == null || this.O0000ooo == null)) {
                this.O0000OoO.queueEvent(new Runnable() {
                    public void run() {
                        if (OO0000.this.O0000OoO != null && OO0000.this.O0000OoO.O000000o() != null) {
                            if (OO0000.this.O0000ooo != null) {
                                OO0000.this.O0000OoO.O000000o().removeNativeOverlay(1, OO0000.this.O0000ooo);
                            }
                            OO0000.this.O0000ooo = null;
                        }
                    }
                });
            }
            this.O0000OoO.O000000o(getId());
            this.O0000OoO.setRunLowFrame(false);
            this.O0000OOo = true;
        }
    }

    public void set3DModel(boolean z) {
        this.O0000oOo = z;
        this.O0000oo = this.O0000o0o;
        this.O00oOooo = true;
    }

    public void setAboveMaskLayer(boolean z) {
    }

    public void setPoints(List<LatLng> list) throws RemoteException {
        O000000o((List) list);
        this.O00oOooo = true;
    }

    public void setSideColor(int i) throws RemoteException {
        this.O0000o0 = i;
        this.O0000OoO.setRunLowFrame(false);
        this.O00oOooo = true;
    }

    public void setTopColor(int i) throws RemoteException {
        this.O0000o00 = i;
        this.O00000o0 = ((float) Color.alpha(i)) / 255.0f;
        this.O00000o = ((float) Color.red(i)) / 255.0f;
        this.O00000oO = ((float) Color.green(i)) / 255.0f;
        this.O00000oo = ((float) Color.blue(i)) / 255.0f;
        this.O0000OoO.setRunLowFrame(false);
        this.O00oOooo = true;
    }

    public void setVisible(boolean z) throws RemoteException {
        this.O0000o0o = z;
        this.O0000OoO.setRunLowFrame(false);
        this.O00oOooo = true;
    }

    public void setWidth(float f) throws RemoteException {
        this.O0000Ooo = f;
        this.O0000OoO.setRunLowFrame(false);
        this.O00oOooo = true;
    }

    public void setZIndex(float f) throws RemoteException {
        this.O0000o0O = f;
        this.O0000OoO.O00000oo();
        this.O0000OoO.setRunLowFrame(false);
    }
}
