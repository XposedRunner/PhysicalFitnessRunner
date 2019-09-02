package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import android.os.RemoteException;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import com.amap.api.mapcore.util.OO00O.O0000O0o;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.baidu.mapapi.UIMsg.m_AppUI;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: CircleDelegateImp */
public class O0OOO0 implements O0Oo000 {
    private static Object O0000oo0 = new Object();
    private static float O0000ooo = 4.0075016E7f;
    private static double O000O00o = 1.0E10d;
    private static int O00oOooO = 256;
    private static int O00oOooo = 20;
    float O000000o = 0.0f;
    private LatLng O00000Oo = null;
    private float O00000o = 10.0f;
    private double O00000o0 = 0.0d;
    private int O00000oO = ViewCompat.MEASURED_STATE_MASK;
    private int O00000oo = 0;
    private float O0000O0o = 0.0f;
    private boolean O0000OOo = true;
    private ca O0000Oo;
    private String O0000Oo0;
    private FloatBuffer O0000OoO;
    private int O0000Ooo = 0;
    private List<BaseHoleOptions> O0000o;
    private IPoint O0000o0 = IPoint.obtain();
    private boolean O0000o00 = false;
    private FPoint O0000o0O = FPoint.obtain();
    private List<BaseHoleOptions> O0000o0o;
    private int O0000oO;
    private int O0000oO0;
    private FloatBuffer O0000oOO;
    private FloatBuffer O0000oOo;
    private int O0000oo = -1;
    private O0000O0o O0000ooO;

    public O0OOO0(ca caVar) {
        this.O0000Oo = caVar;
        try {
            this.O0000Oo0 = getId();
        } catch (RemoteException e) {
            ooOOOOoo.O00000o0(e, "CircleDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private float O000000o(double d) {
        return (float) ((Math.cos((d * 3.141592653589793d) / 180.0d) * ((double) O0000ooo)) / ((double) (O00oOooO << O00oOooo)));
    }

    private List<IPoint> O000000o(List<LatLng> list) throws RemoteException {
        List arrayList = new ArrayList();
        if (list != null) {
            IPoint obtain;
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    obtain = IPoint.obtain();
                    this.O0000Oo.O000000o(latLng.latitude, latLng.longitude, obtain);
                    arrayList.add(obtain);
                    obj = latLng;
                }
            }
            int size = arrayList.size();
            if (size > 1) {
                IPoint iPoint = (IPoint) arrayList.get(0);
                size--;
                obtain = (IPoint) arrayList.get(size);
                if (iPoint.x == obtain.x && iPoint.y == obtain.y) {
                    arrayList.remove(size);
                }
            }
        }
        if (OOo000.O000000o(arrayList, 0, arrayList.size())) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    private void O000000o(List<IPoint> list, int i, int i2) throws RemoteException {
        if (list.size() >= 2) {
            float[] fArr = new float[(list.size() * 3)];
            IPoint[] iPointArr = new IPoint[list.size()];
            int i3 = 0;
            int i4 = 0;
            for (IPoint iPoint : list) {
                int i5 = i4 * 3;
                fArr[i5] = (float) (iPoint.x - i);
                fArr[i5 + 1] = (float) (iPoint.y - i2);
                fArr[i5 + 2] = 0.0f;
                iPointArr[i4] = iPoint;
                i4++;
            }
            IPoint[] O000000o = O000000o(iPointArr);
            if (O000000o.length == 0) {
                if (O000O00o == 1.0E10d) {
                    O000O00o = 1.0E8d;
                } else {
                    O000O00o = 1.0E10d;
                }
                O000000o = O000000o(iPointArr);
            }
            float[] fArr2 = new float[(3 * O000000o.length)];
            i4 = O000000o.length;
            int i6 = 0;
            while (i3 < i4) {
                IPoint iPoint2 = O000000o[i3];
                int i7 = i6 * 3;
                fArr2[i7] = (float) (iPoint2.x - i);
                fArr2[i7 + 1] = (float) (iPoint2.y - i2);
                fArr2[i7 + 2] = 0.0f;
                i6++;
                i3++;
            }
            this.O0000oO0 = iPointArr.length;
            this.O0000oO = O000000o.length;
            this.O0000oOO = OOo000.O000000o(fArr);
            this.O0000oOo = OOo000.O000000o(fArr2);
        }
    }

    private boolean O000000o(PolygonHoleOptions polygonHoleOptions) {
        boolean z = true;
        try {
            List points = polygonHoleOptions.getPoints();
            int i = 0;
            while (i < points.size()) {
                boolean contains = contains((LatLng) points.get(i));
                if (!contains) {
                    return contains;
                }
                i++;
                z = contains;
            }
            return z;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
            return true;
        }
    }

    static IPoint[] O000000o(IPoint[] iPointArr) {
        int i = 0;
        int length = iPointArr.length;
        double[] dArr = new double[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            dArr[i3] = ((double) iPointArr[i2].x) * O000O00o;
            dArr[i3 + 1] = ((double) iPointArr[i2].y) * O000O00o;
        }
        OOOOO00 O000000o = new OO0o().O000000o(dArr);
        length = O000000o.O00000Oo;
        IPoint[] iPointArr2 = new IPoint[length];
        while (i < length) {
            iPointArr2[i] = new IPoint();
            iPointArr2[i].x = (int) (dArr[O000000o.O000000o(i) * 2] / O000O00o);
            iPointArr2[i].y = (int) (dArr[(O000000o.O000000o(i) * 2) + 1] / O000O00o);
            i++;
        }
        return iPointArr2;
    }

    private double O00000Oo(double d) {
        return 1.0d / ((double) O000000o(d));
    }

    private boolean O00000Oo(CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), getCenter())) <= getRadius() - circleHoleOptions.getRadius();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    private void O00000oO() {
        if (this.O0000Oo != null) {
            this.O0000ooO = (O0000O0o) this.O0000Oo.O0000oOo(3);
        }
    }

    private void O00000oo() throws RemoteException {
        MapConfig mapConfig = this.O0000Oo.getMapConfig();
        if (this.O0000o0o != null && this.O0000o0o.size() > 0) {
            GLES20.glClearStencil(0);
            GLES20.glStencilMask(255);
            GLES20.glClear(1024);
            GLES20.glFlush();
            GLES20.glEnable(2960);
            GLES20.glColorMask(false, false, false, false);
            GLES20.glStencilFunc(512, 1, 255);
            GLES20.glStencilOp(7681, 7680, 7680);
            for (int i = 0; i < this.O0000o0o.size(); i++) {
                BaseHoleOptions baseHoleOptions = (BaseHoleOptions) this.O0000o0o.get(i);
                boolean z = baseHoleOptions instanceof PolygonHoleOptions;
                if (z) {
                    O000000o(O000000o(((PolygonHoleOptions) baseHoleOptions).getPoints()), mapConfig.getSX(), mapConfig.getSY());
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                    this.O0000Oo.O00000oo();
                    O000000o(circleHoleOptions);
                }
                if (this.O0000oOO != null && this.O0000oO0 > 0) {
                    if (this.O0000ooO == null || this.O0000ooO.O00000o0()) {
                        O00000oO();
                    }
                    if (z) {
                        OOO00Oo.O000000o(this.O0000ooO, -1, this.O00000oo, this.O0000oOO, getStrokeWidth(), this.O0000oOo, this.O0000oO0, this.O0000oO, this.O0000Oo.O0000ooO());
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        OOO00Oo.O000000o(this.O0000ooO, -1, -1, this.O0000oOO, 10.0f, this.O0000oO0, this.O0000Oo.O0000ooO(), 0.0f, 0);
                    }
                }
            }
            GLES20.glColorMask(true, true, true, true);
            GLES20.glStencilFunc(m_AppUI.MSG_CITY_SUP_DOM, 1, 255);
            GLES20.glStencilMask(0);
        }
    }

    private void O0000O0o() throws RemoteException {
        int i = 0;
        GLES20.glClearStencil(0);
        GLES20.glClear(1024);
        GLES20.glDisable(2960);
        MapConfig mapConfig = this.O0000Oo.getMapConfig();
        if (this.O0000o0o != null && this.O0000o0o.size() > 0) {
            while (i < this.O0000o0o.size()) {
                BaseHoleOptions baseHoleOptions = (BaseHoleOptions) this.O0000o0o.get(i);
                boolean z = baseHoleOptions instanceof PolygonHoleOptions;
                if (z) {
                    O000000o(O000000o(((PolygonHoleOptions) baseHoleOptions).getPoints()), mapConfig.getSX(), mapConfig.getSY());
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                    this.O0000Oo.O00000oo();
                    O000000o(circleHoleOptions);
                }
                if (this.O0000oOO != null && this.O0000oO0 > 0) {
                    if (this.O0000ooO == null || this.O0000ooO.O00000o0()) {
                        O00000oO();
                    }
                    if (z) {
                        OOO00Oo.O00000Oo(this.O0000ooO, 0, this.O00000oO, this.O0000oOO, this.O00000o, this.O0000oOo, this.O0000oO0, this.O0000oO, this.O0000Oo.O0000ooO());
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        OOO00Oo.O00000Oo(this.O0000ooO, 0, this.O00000oO, this.O0000oOO, this.O00000o, this.O0000oO0, this.O0000Oo.O0000ooO(), this.O000000o, -1);
                    }
                }
                i++;
            }
        }
    }

    public void O000000o(CircleHoleOptions circleHoleOptions) throws RemoteException {
        if (circleHoleOptions.getCenter() != null) {
            IPoint obtain = IPoint.obtain();
            FPoint obtain2 = FPoint.obtain();
            GLMapState.lonlat2Geo(circleHoleOptions.getCenter().longitude, circleHoleOptions.getCenter().latitude, obtain);
            float[] fArr = new float[1086];
            double O00000Oo = O00000Oo(circleHoleOptions.getCenter().latitude) * circleHoleOptions.getRadius();
            obtain2.x = (float) (obtain.x - this.O0000Oo.getMapConfig().getSX());
            obtain2.y = (float) (obtain.y - this.O0000Oo.getMapConfig().getSY());
            int i = 0;
            fArr[0] = obtain2.x;
            fArr[1] = obtain2.y;
            fArr[2] = 0.0f;
            while (i < 361) {
                double d = (((double) i) * 3.141592653589793d) / 180.0d;
                double sin = Math.sin(d) * O00000Oo;
                int cos = (int) (((double) obtain.y) + (Math.cos(d) * O00000Oo));
                obtain2.x = (float) (((int) (((double) obtain.x) + sin)) - this.O0000Oo.getMapConfig().getSX());
                obtain2.y = (float) (cos - this.O0000Oo.getMapConfig().getSY());
                i++;
                cos = i * 3;
                fArr[cos] = obtain2.x;
                fArr[cos + 1] = obtain2.y;
                fArr[cos + 2] = 0.0f;
            }
            this.O0000oO0 = fArr.length / 3;
            this.O0000oOO = OOo000.O000000o(fArr);
            obtain.recycle();
            obtain2.recycle();
        }
    }

    public void O000000o(MapConfig mapConfig) throws RemoteException {
        if (this.O00000Oo != null && this.O00000o0 > 0.0d && this.O0000OOo) {
            O00000Oo();
            O00000oo();
            if (this.O0000OoO != null && this.O0000Ooo > 0) {
                if (this.O0000ooO == null || this.O0000ooO.O00000o0()) {
                    O00000oO();
                }
                this.O000000o = this.O0000Oo.getMapConfig().getMapPerPixelUnitLength();
                OOO00Oo.O000000o(this.O0000ooO, this.O00000oo, this.O00000oO, this.O0000OoO, this.O00000o, this.O0000Ooo, this.O0000Oo.O0000ooO(), this.O000000o, this.O0000Oo.O00000oo(this.O0000oo));
            }
            O0000O0o();
            this.O0000o00 = true;
        }
    }

    public boolean O000000o() {
        return true;
    }

    public boolean O00000Oo() throws RemoteException {
        synchronized (O0000oo0) {
            int i = 0;
            this.O0000o00 = false;
            if (this.O00000Oo != null) {
                float[] fArr = new float[1086];
                double O00000Oo = O00000Oo(this.O00000Oo.latitude) * this.O00000o0;
                this.O0000Oo.O00000o0();
                this.O0000o0O.x = (float) (this.O0000o0.x - this.O0000Oo.getMapConfig().getSX());
                this.O0000o0O.y = (float) (this.O0000o0.y - this.O0000Oo.getMapConfig().getSY());
                fArr[0] = this.O0000o0O.x;
                fArr[1] = this.O0000o0O.y;
                fArr[2] = 0.0f;
                while (i < 361) {
                    double d = (((double) i) * 3.141592653589793d) / 180.0d;
                    double sin = Math.sin(d) * O00000Oo;
                    int i2 = (int) (((double) this.O0000o0.x) + sin);
                    int cos = (int) (((double) this.O0000o0.y) + (Math.cos(d) * O00000Oo));
                    this.O0000o0O.x = (float) (i2 - this.O0000Oo.getMapConfig().getSX());
                    this.O0000o0O.y = (float) (cos - this.O0000Oo.getMapConfig().getSY());
                    i++;
                    cos = i * 3;
                    fArr[cos] = this.O0000o0O.x;
                    fArr[cos + 1] = this.O0000o0O.y;
                    fArr[cos + 2] = 0.0f;
                }
                this.O0000Ooo = fArr.length / 3;
                this.O0000OoO = OOo000.O000000o(fArr);
            }
        }
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o() {
        this.O0000Ooo = 0;
        if (this.O0000OoO != null) {
            this.O0000OoO.clear();
        }
        this.O0000Oo.setRunLowFrame(false);
        setHoleOptions(this.O0000o);
    }

    public boolean O00000o0() {
        return this.O0000o00;
    }

    public boolean contains(LatLng latLng) throws RemoteException {
        if (this.O0000o0o != null && this.O0000o0o.size() > 0) {
            for (BaseHoleOptions O000000o : this.O0000o0o) {
                if (OOo000.O000000o(O000000o, latLng)) {
                    return false;
                }
            }
        }
        return this.O00000o0 >= ((double) AMapUtils.calculateLineDistance(this.O00000Oo, latLng));
    }

    public void destroy() {
        try {
            this.O00000Oo = null;
            if (this.O0000OoO != null) {
                this.O0000OoO.clear();
                this.O0000OoO = null;
            }
            if (this.O0000oOO != null) {
                this.O0000oOO.clear();
                this.O0000oOO = null;
            }
            if (this.O0000oOo != null) {
                this.O0000oOo.clear();
                this.O0000oOo = null;
            }
            if (this.O0000o0o != null) {
                this.O0000o0o.clear();
            }
            if (this.O0000o != null) {
                this.O0000o.clear();
            }
            this.O0000o0o = null;
            this.O0000o = null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "CircleDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "CircleDelegateImp destroy");
        }
    }

    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public LatLng getCenter() throws RemoteException {
        return this.O00000Oo;
    }

    public int getDottedLineType() {
        return this.O0000oo;
    }

    public int getFillColor() throws RemoteException {
        return this.O00000oo;
    }

    public List<BaseHoleOptions> getHoleOptions() throws RemoteException {
        return this.O0000o0o;
    }

    public String getId() throws RemoteException {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = this.O0000Oo.O00000o("Circle");
        }
        return this.O0000Oo0;
    }

    public double getRadius() throws RemoteException {
        return this.O00000o0;
    }

    public int getStrokeColor() throws RemoteException {
        return this.O00000oO;
    }

    public float getStrokeWidth() throws RemoteException {
        return this.O00000o;
    }

    public float getZIndex() throws RemoteException {
        return this.O0000O0o;
    }

    public int hashCodeRemote() throws RemoteException {
        return 0;
    }

    public boolean isAboveMaskLayer() {
        return false;
    }

    public boolean isVisible() throws RemoteException {
        return this.O0000OOo;
    }

    public void remove() throws RemoteException {
        this.O0000Oo.O000000o(getId());
        this.O0000Oo.setRunLowFrame(false);
    }

    public void setAboveMaskLayer(boolean z) {
    }

    public void setCenter(LatLng latLng) throws RemoteException {
        synchronized (O0000oo0) {
            if (latLng != null) {
                try {
                    this.O00000Oo = latLng;
                    GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, this.O0000o0);
                    O00000o();
                } catch (Throwable th) {
                }
            }
        }
    }

    public void setDottedLineType(int i) {
        this.O0000oo = i;
    }

    public void setFillColor(int i) throws RemoteException {
        this.O00000oo = i;
        this.O0000Oo.setRunLowFrame(false);
    }

    public void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.O0000o = list;
            if (this.O0000o0o == null) {
                this.O0000o0o = new ArrayList();
            } else {
                this.O0000o0o.clear();
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    BaseHoleOptions baseHoleOptions = (BaseHoleOptions) list.get(i);
                    if (baseHoleOptions instanceof PolygonHoleOptions) {
                        PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                        if (O000000o(polygonHoleOptions) && !OOo000.O000000o(this.O0000o0o, polygonHoleOptions)) {
                            this.O0000o0o.add(polygonHoleOptions);
                        }
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                        if (O00000Oo(circleHoleOptions) && !OOo000.O000000o(this.O0000o0o, circleHoleOptions)) {
                            this.O0000o0o.add(circleHoleOptions);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PolygonDelegateImp", "setHoleOptions");
            th.printStackTrace();
        }
    }

    public void setRadius(double d) throws RemoteException {
        this.O00000o0 = d;
        O00000o();
    }

    public void setStrokeColor(int i) throws RemoteException {
        this.O00000oO = i;
        this.O0000Oo.setRunLowFrame(false);
    }

    public void setStrokeWidth(float f) throws RemoteException {
        this.O00000o = f;
        this.O0000Oo.setRunLowFrame(false);
    }

    public void setVisible(boolean z) throws RemoteException {
        this.O0000OOo = z;
        this.O0000Oo.setRunLowFrame(false);
    }

    public void setZIndex(float f) throws RemoteException {
        this.O0000O0o = f;
        this.O0000Oo.O00000oo();
        this.O0000Oo.setRunLowFrame(false);
    }
}
