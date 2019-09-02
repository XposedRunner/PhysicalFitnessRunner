package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.RemoteException;
import com.amap.api.mapcore.util.OO00O.O0000O0o;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.baidu.mapapi.UIMsg.m_AppUI;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* compiled from: PolygonDelegateImp */
public class OO000OO implements O0o000 {
    private static int O0000oo = 256;
    private static float O0000oo0 = 4.0075016E7f;
    private static int O0000ooO = 20;
    private static double O000O0OO = 1.0E10d;
    Rect O000000o = null;
    private ca O00000Oo;
    private boolean O00000o = true;
    private float O00000o0 = 0.0f;
    private String O00000oO;
    private float O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private List<IPoint> O0000Oo = new Vector();
    private List<LatLng> O0000Oo0;
    private List<BaseHoleOptions> O0000OoO = new Vector();
    private List<BaseHoleOptions> O0000Ooo;
    private boolean O0000o = false;
    private FloatBuffer O0000o0;
    private FloatBuffer O0000o00;
    private int O0000o0O = 0;
    private int O0000o0o = 0;
    private Object O0000oO = new Object();
    private float O0000oO0 = 0.0f;
    private float O0000oOO = 0.0f;
    private O0000O0o O0000oOo;
    private int O0000ooo;
    private FloatBuffer O000O00o;
    private int O00oOooO;
    private FloatBuffer O00oOooo;

    public OO000OO(ca caVar) {
        this.O00000Oo = caVar;
        try {
            this.O00000oO = getId();
        } catch (RemoteException e) {
            ooOOOOoo.O00000o0(e, "PolygonDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private float O000000o(double d) {
        return (float) ((Math.cos((d * 3.141592653589793d) / 180.0d) * ((double) O0000oo0)) / ((double) (O0000oo << O0000ooO)));
    }

    private void O000000o(List<LatLng> list) throws RemoteException {
        Builder builder = LatLngBounds.builder();
        if (this.O000000o == null) {
            this.O000000o = new Rect();
        }
        OOo000.O000000o(this.O000000o);
        this.O0000Oo.clear();
        if (list != null) {
            IPoint obtain;
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    obtain = IPoint.obtain();
                    this.O00000Oo.O000000o(latLng.latitude, latLng.longitude, obtain);
                    this.O0000Oo.add(obtain);
                    OOo000.O00000Oo(this.O000000o, obtain.x, obtain.y);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.O0000Oo.size();
            if (size > 1) {
                obtain = (IPoint) this.O0000Oo.get(0);
                size--;
                IPoint iPoint = (IPoint) this.O0000Oo.get(size);
                if (obtain.x == iPoint.x && obtain.y == iPoint.y) {
                    this.O0000Oo.remove(size);
                }
            }
        }
        this.O000000o.sort();
        if (this.O0000o00 != null) {
            this.O0000o00.clear();
        }
        if (this.O0000o0 != null) {
            this.O0000o0.clear();
        }
        if (OOo000.O000000o(this.O0000Oo, 0, this.O0000Oo.size())) {
            Collections.reverse(this.O0000Oo);
        }
        this.O0000o0O = 0;
        this.O0000o0o = 0;
        this.O00000Oo.setRunLowFrame(false);
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
                if (O000O0OO == 1.0E10d) {
                    O000O0OO = 1.0E8d;
                } else {
                    O000O0OO = 1.0E10d;
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
            this.O0000ooo = iPointArr.length;
            this.O00oOooO = O000000o.length;
            this.O00oOooo = OOo000.O000000o(fArr);
            this.O000O00o = OOo000.O000000o(fArr2);
        }
    }

    private boolean O000000o(PolygonHoleOptions polygonHoleOptions) {
        boolean z = true;
        try {
            List points = polygonHoleOptions.getPoints();
            int i = 0;
            while (i < points.size()) {
                boolean O000000o = OOo000.O000000o((LatLng) points.get(i), getPoints());
                if (!O000000o) {
                    return O000000o;
                }
                i++;
                z = O000000o;
            }
            return z;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PolygonDelegateImp", "isPolygonInPolygon");
            th.printStackTrace();
            return true;
        }
    }

    private boolean O000000o(IPoint iPoint, IPoint iPoint2) {
        return ((float) (iPoint2.x - iPoint.x)) >= this.O0000oO0 || ((float) (iPoint2.x - iPoint.x)) <= (-this.O0000oO0) || ((float) (iPoint2.y - iPoint.y)) >= this.O0000oO0 || ((float) (iPoint2.y - iPoint.y)) <= (-this.O0000oO0);
    }

    private boolean O000000o(Rectangle rectangle) {
        this.O0000oOO = this.O00000Oo.O0000O0o();
        O00000oo();
        if (this.O0000oOO <= ((float) 10) || rectangle == null) {
            return false;
        }
        try {
            return !rectangle.contains(this.O000000o);
        } catch (Throwable unused) {
            return false;
        }
    }

    static IPoint[] O000000o(IPoint[] iPointArr) {
        int i = 0;
        int length = iPointArr.length;
        double[] dArr = new double[(length * 2)];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            dArr[i3] = ((double) iPointArr[i2].x) * O000O0OO;
            dArr[i3 + 1] = ((double) iPointArr[i2].y) * O000O0OO;
        }
        OOOOO00 O000000o = new OO0o().O000000o(dArr);
        length = O000000o.O00000Oo;
        IPoint[] iPointArr2 = new IPoint[length];
        while (i < length) {
            iPointArr2[i] = new IPoint();
            iPointArr2[i].x = (int) (dArr[O000000o.O000000o(i) * 2] / O000O0OO);
            iPointArr2[i].y = (int) (dArr[(O000000o.O000000o(i) * 2) + 1] / O000O0OO);
            i++;
        }
        return iPointArr2;
    }

    private double O00000Oo(double d) {
        return 1.0d / ((double) O000000o(d));
    }

    private List<IPoint> O00000Oo(List<LatLng> list) throws RemoteException {
        List arrayList = new ArrayList();
        if (list != null) {
            IPoint obtain;
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    obtain = IPoint.obtain();
                    this.O00000Oo.O000000o(latLng.latitude, latLng.longitude, obtain);
                    arrayList.add(obtain);
                    OOo000.O00000Oo(this.O000000o, obtain.x, obtain.y);
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

    private void O00000Oo() {
        if (this.O00000Oo != null) {
            this.O0000oOo = (O0000O0o) this.O00000Oo.O0000oOo(3);
        }
    }

    private void O00000Oo(List<IPoint> list, int i, int i2) throws RemoteException {
        O00000oo();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (size >= 2) {
            int i3;
            IPoint iPoint;
            int i4 = 0;
            IPoint iPoint2 = (IPoint) list.get(0);
            arrayList.add(iPoint2);
            IPoint iPoint3 = iPoint2;
            int i5 = 1;
            while (true) {
                i3 = size - 1;
                if (i5 >= i3) {
                    break;
                }
                iPoint = (IPoint) list.get(i5);
                if (O000000o(iPoint3, iPoint)) {
                    arrayList.add(iPoint);
                    iPoint3 = iPoint;
                }
                i5++;
            }
            arrayList.add(list.get(i3));
            float[] fArr = new float[(arrayList.size() * 3)];
            IPoint[] iPointArr = new IPoint[arrayList.size()];
            Iterator it = arrayList.iterator();
            int i6 = 0;
            while (it.hasNext()) {
                iPoint = (IPoint) it.next();
                int i7 = i6 * 3;
                fArr[i7] = (float) (iPoint.x - i);
                fArr[i7 + 1] = (float) (iPoint.y - i2);
                fArr[i7 + 2] = 0.0f;
                iPointArr[i6] = iPoint;
                i6++;
            }
            IPoint[] O000000o = O000000o(iPointArr);
            if (O000000o.length == 0) {
                if (O000O0OO == 1.0E10d) {
                    O000O0OO = 1.0E8d;
                } else {
                    O000O0OO = 1.0E10d;
                }
                O000000o = O000000o(iPointArr);
            }
            float[] fArr2 = new float[(3 * O000000o.length)];
            i6 = O000000o.length;
            i3 = 0;
            while (i4 < i6) {
                IPoint iPoint4 = O000000o[i4];
                int i8 = i3 * 3;
                fArr2[i8] = (float) (iPoint4.x - i);
                fArr2[i8 + 1] = (float) (iPoint4.y - i2);
                fArr2[i8 + 2] = 0.0f;
                i3++;
                i4++;
            }
            this.O0000o0O = iPointArr.length;
            this.O0000o0o = O000000o.length;
            this.O0000o00 = OOo000.O000000o(fArr);
            this.O0000o0 = OOo000.O000000o(fArr2);
        }
    }

    private boolean O00000Oo(CircleHoleOptions circleHoleOptions) {
        try {
            if (!OOo000.O00000Oo(getPoints(), circleHoleOptions) && contains(circleHoleOptions.getCenter())) {
                return true;
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PolygonDelegateImp", "isCircleInPolygon");
            th.printStackTrace();
        }
        return false;
    }

    private void O00000o() throws RemoteException {
        MapConfig mapConfig = this.O00000Oo.getMapConfig();
        if (this.O0000OoO != null && this.O0000OoO.size() > 0) {
            GLES20.glClearStencil(0);
            GLES20.glStencilMask(255);
            GLES20.glClear(1024);
            GLES20.glFlush();
            GLES20.glEnable(2960);
            GLES20.glColorMask(false, false, false, false);
            GLES20.glStencilFunc(512, 1, 255);
            GLES20.glStencilOp(7681, 7680, 7680);
            for (int i = 0; i < this.O0000OoO.size(); i++) {
                BaseHoleOptions baseHoleOptions = (BaseHoleOptions) this.O0000OoO.get(i);
                boolean z = baseHoleOptions instanceof PolygonHoleOptions;
                if (z) {
                    O000000o(O00000Oo(((PolygonHoleOptions) baseHoleOptions).getPoints()), mapConfig.getSX(), mapConfig.getSY());
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                    this.O00000Oo.O00000oo();
                    O000000o(circleHoleOptions);
                }
                if (this.O00oOooo != null && this.O0000ooo > 0) {
                    if (this.O0000oOo == null || this.O0000oOo.O00000o0()) {
                        O00000Oo();
                    }
                    if (z) {
                        OOO00Oo.O000000o(this.O0000oOo, -1, this.O0000OOo, this.O00oOooo, this.O00000oo, this.O000O00o, this.O0000ooo, this.O00oOooO, this.O00000Oo.O0000ooO());
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        OOO00Oo.O000000o(this.O0000oOo, Color.argb(200, 80, 1, 1), Color.argb(200, 1, 1, 1), this.O00oOooo, 5.0f, this.O0000ooo, this.O00000Oo.O0000ooO(), 0.0f, 0);
                    }
                }
            }
            GLES20.glColorMask(true, true, true, true);
            GLES20.glStencilFunc(m_AppUI.MSG_CITY_SUP_DOM, 1, 255);
            GLES20.glStencilMask(0);
        }
    }

    private void O00000oO() throws RemoteException {
        int i = 0;
        GLES20.glClearStencil(0);
        GLES20.glClear(1024);
        GLES20.glDisable(2960);
        MapConfig mapConfig = this.O00000Oo.getMapConfig();
        if (this.O0000OoO != null && this.O0000OoO.size() > 0) {
            while (i < this.O0000OoO.size()) {
                BaseHoleOptions baseHoleOptions = (BaseHoleOptions) this.O0000OoO.get(i);
                boolean z = baseHoleOptions instanceof PolygonHoleOptions;
                if (z) {
                    O000000o(O00000Oo(((PolygonHoleOptions) baseHoleOptions).getPoints()), mapConfig.getSX(), mapConfig.getSY());
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                    this.O00000Oo.O00000oo();
                    O000000o(circleHoleOptions);
                }
                if (this.O00oOooo != null && this.O0000ooo > 0) {
                    if (this.O0000oOo == null || this.O0000oOo.O00000o0()) {
                        O00000Oo();
                    }
                    if (z) {
                        OOO00Oo.O00000Oo(this.O0000oOo, 0, this.O0000OOo, this.O00oOooo, this.O00000oo, this.O000O00o, this.O0000ooo, this.O00oOooO, this.O00000Oo.O0000ooO());
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        OOO00Oo.O00000Oo(this.O0000oOo, 0, this.O0000OOo, this.O00oOooo, this.O00000oo, this.O0000ooo, this.O00000Oo.O0000ooO(), 1.0f, -1);
                    }
                }
                i++;
            }
        }
    }

    private void O00000oo() {
        float O0000O0o = this.O00000Oo.O0000O0o();
        if (this.O0000Oo.size() <= 5000) {
            this.O0000oO0 = this.O00000Oo.O00000o0().getMapLenWithWin(2);
        } else if (O0000O0o <= ((float) 12)) {
            float f = (this.O00000oo / 2.0f) + (O0000O0o / 2.0f);
            O0000O0o = 200.0f;
            if (f <= 200.0f) {
                O0000O0o = f;
            }
            this.O0000oO0 = this.O00000Oo.O00000o0().getMapLenWithWin((int) O0000O0o);
        } else {
            this.O0000oO0 = this.O00000Oo.O00000o0().getMapLenWithWin(10);
        }
    }

    public void O000000o(CircleHoleOptions circleHoleOptions) throws RemoteException {
        if (circleHoleOptions.getCenter() != null) {
            IPoint obtain = IPoint.obtain();
            FPoint obtain2 = FPoint.obtain();
            GLMapState.lonlat2Geo(circleHoleOptions.getCenter().longitude, circleHoleOptions.getCenter().latitude, obtain);
            float[] fArr = new float[1086];
            double O00000Oo = O00000Oo(circleHoleOptions.getCenter().latitude) * circleHoleOptions.getRadius();
            int sx = this.O00000Oo.getMapConfig().getSX();
            int sy = this.O00000Oo.getMapConfig().getSY();
            obtain2.x = (float) (obtain.x - sx);
            obtain2.y = (float) (obtain.y - sy);
            int i = 0;
            fArr[0] = obtain2.x;
            fArr[1] = obtain2.y;
            fArr[2] = 0.0f;
            while (i < 361) {
                double d = (((double) i) * 3.141592653589793d) / 180.0d;
                double sin = Math.sin(d) * O00000Oo;
                int i2 = i;
                int i3 = (int) (((double) obtain.x) + sin);
                i = (int) (((double) obtain.y) + (Math.cos(d) * O00000Oo));
                obtain2.x = (float) (i3 - sx);
                obtain2.y = (float) (i - sy);
                obtain2.x = (float) (i3 - this.O00000Oo.getMapConfig().getSX());
                obtain2.y = (float) (i - this.O00000Oo.getMapConfig().getSY());
                i = i2 + 1;
                i3 = i * 3;
                fArr[i3] = obtain2.x;
                fArr[i3 + 1] = obtain2.y;
                fArr[i3 + 2] = 0.0f;
                Object obj = null;
            }
            this.O0000ooo = fArr.length / 3;
            this.O00oOooo = OOo000.O000000o(fArr);
            obtain.recycle();
            obtain2.recycle();
        }
    }

    public void O000000o(MapConfig mapConfig) throws RemoteException {
        if (this.O0000Oo != null && this.O0000Oo.size() != 0) {
            Rectangle geoRectangle = mapConfig.getGeoRectangle();
            geoRectangle.getClipRect();
            List list = this.O0000Oo;
            O000000o(geoRectangle);
            O00000o();
            if (list.size() > 2) {
                O00000Oo(list, mapConfig.getSX(), mapConfig.getSY());
                if (this.O0000o00 != null && this.O0000o0 != null && this.O0000o0O > 0 && this.O0000o0o > 0) {
                    if (this.O0000oOo == null || this.O0000oOo.O00000o0()) {
                        O00000Oo();
                    }
                    OOO00Oo.O000000o(this.O0000oOo, this.O0000O0o, this.O0000OOo, this.O0000o00, this.O00000oo, this.O0000o0, this.O0000o0O, this.O0000o0o, this.O00000Oo.O0000ooO());
                }
            }
            O00000oO();
            this.O0000o = true;
        }
    }

    public boolean O000000o() {
        return this.O00000Oo.getMapConfig().getGeoRectangle().isOverlap(this.O000000o);
    }

    public boolean O00000o0() {
        return this.O0000o;
    }

    public boolean contains(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return false;
        }
        try {
            if (this.O0000OoO != null && this.O0000OoO.size() > 0) {
                for (BaseHoleOptions O000000o : this.O0000OoO) {
                    if (OOo000.O000000o(O000000o, latLng)) {
                        return false;
                    }
                }
            }
            return OOo000.O000000o(latLng, getPoints());
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PolygonDelegateImp", "contains");
            th.printStackTrace();
            return false;
        }
    }

    public void destroy() {
        try {
            if (this.O0000o00 != null) {
                this.O0000o00.clear();
                this.O0000o00 = null;
            }
            if (this.O0000o0 != null) {
                this.O0000o0 = null;
            }
            if (this.O00oOooo != null) {
                this.O00oOooo.clear();
                this.O00oOooo = null;
            }
            if (this.O000O00o != null) {
                this.O000O00o.clear();
                this.O000O00o = null;
            }
            if (this.O0000OoO != null) {
                this.O0000OoO.clear();
            }
            if (this.O0000Ooo != null) {
                this.O0000Ooo.clear();
            }
            this.O0000OoO = null;
            this.O0000Ooo = null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PolygonDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public int getFillColor() throws RemoteException {
        return this.O0000O0o;
    }

    public List<BaseHoleOptions> getHoleOptions() {
        return this.O0000OoO;
    }

    public String getId() throws RemoteException {
        if (this.O00000oO == null) {
            this.O00000oO = this.O00000Oo.O00000o("Polygon");
        }
        return this.O00000oO;
    }

    public List<LatLng> getPoints() throws RemoteException {
        return this.O0000Oo0;
    }

    public int getStrokeColor() throws RemoteException {
        return this.O0000OOo;
    }

    public float getStrokeWidth() throws RemoteException {
        return this.O00000oo;
    }

    public float getZIndex() throws RemoteException {
        return this.O00000o0;
    }

    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    public boolean isAboveMaskLayer() {
        return false;
    }

    public boolean isVisible() throws RemoteException {
        return this.O00000o;
    }

    public void remove() throws RemoteException {
        this.O00000Oo.O000000o(getId());
        this.O00000Oo.setRunLowFrame(false);
    }

    public void setAboveMaskLayer(boolean z) {
    }

    public void setFillColor(int i) throws RemoteException {
        this.O0000O0o = i;
        this.O00000Oo.setRunLowFrame(false);
    }

    public void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.O0000Ooo = list;
            if (this.O0000OoO == null) {
                this.O0000OoO = new ArrayList();
            } else {
                this.O0000OoO.clear();
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    BaseHoleOptions baseHoleOptions = (BaseHoleOptions) list.get(i);
                    if (baseHoleOptions instanceof PolygonHoleOptions) {
                        PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                        if (O000000o(polygonHoleOptions) && !OOo000.O000000o(this.O0000OoO, polygonHoleOptions)) {
                            this.O0000OoO.add(polygonHoleOptions);
                        }
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                        if (O00000Oo(circleHoleOptions) && !OOo000.O000000o(this.O0000OoO, circleHoleOptions)) {
                            this.O0000OoO.add(circleHoleOptions);
                        }
                    }
                }
            } else {
                this.O0000OoO.clear();
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PolygonDelegateImp", "setHoleOptions");
            th.printStackTrace();
        }
        this.O00000Oo.setRunLowFrame(false);
    }

    public void setPoints(List<LatLng> list) throws RemoteException {
        synchronized (this.O0000oO) {
            this.O0000Oo0 = list;
            O000000o((List) list);
            this.O00000Oo.setRunLowFrame(false);
            setHoleOptions(this.O0000Ooo);
        }
    }

    public void setStrokeColor(int i) throws RemoteException {
        this.O0000OOo = i;
        this.O00000Oo.setRunLowFrame(false);
    }

    public void setStrokeWidth(float f) throws RemoteException {
        this.O00000oo = f;
        this.O00000Oo.setRunLowFrame(false);
    }

    public void setVisible(boolean z) throws RemoteException {
        this.O00000o = z;
        this.O00000Oo.setRunLowFrame(false);
    }

    public void setZIndex(float f) throws RemoteException {
        this.O00000o0 = f;
        this.O00000Oo.O00000oo();
        this.O00000Oo.setRunLowFrame(false);
    }
}
