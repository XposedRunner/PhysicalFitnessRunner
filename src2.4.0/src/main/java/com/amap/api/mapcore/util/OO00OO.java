package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TextDelegateImp */
public class OO00OO implements O0o0 {
    private static int O000000o;
    private float O00000Oo = 0.0f;
    private int O00000o = 4;
    private float O00000o0 = 0.0f;
    private int O00000oO = 32;
    private FPoint O00000oo = FPoint.obtain();
    private int O0000O0o;
    private BitmapDescriptor O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private String O0000OoO;
    private LatLng O0000Ooo;
    private Object O0000o;
    private float O0000o0 = 1.0f;
    private float O0000o00 = 0.5f;
    private boolean O0000o0O = true;
    private O00000Oo O0000o0o;
    private int O0000oO;
    private String O0000oO0;
    private int O0000oOO;
    private int O0000oOo;
    private float O0000oo;
    private Typeface O0000oo0;
    private Rect O0000ooO = new Rect();
    private Paint O0000ooo = new Paint();
    private boolean O000O00o = false;
    private List<O0000O0o> O000O0OO = new ArrayList();
    private boolean O000O0Oo = false;
    private float[] O000O0o0 = new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private boolean O00oOoOo = false;
    private int O00oOooO;
    private int O00oOooo;

    public OO00OO(TextOptions textOptions, O00000Oo o00000Oo) throws RemoteException {
        this.O0000o0o = o00000Oo;
        if (textOptions.getPosition() != null) {
            this.O0000Ooo = textOptions.getPosition();
        }
        setAlign(textOptions.getAlignX(), textOptions.getAlignY());
        this.O0000o0O = textOptions.isVisible();
        this.O0000oO0 = textOptions.getText();
        this.O0000oO = textOptions.getBackgroundColor();
        this.O0000oOO = textOptions.getFontColor();
        this.O0000oOo = textOptions.getFontSize();
        this.O0000o = textOptions.getObject();
        this.O0000oo = textOptions.getZIndex();
        this.O0000oo0 = textOptions.getTypeface();
        this.O0000OoO = getId();
        setRotateAngle(textOptions.getRotate());
        O00000o0();
        O00000Oo();
    }

    private int O000000o(boolean z, BitmapDescriptor bitmapDescriptor) {
        O0000O0o O000000o;
        O0000O0o();
        if (z) {
            O000000o = this.O0000o0o.O00000o0().O000000o(bitmapDescriptor);
            if (O000000o != null) {
                int O0000OoO = O000000o.O0000OoO();
                O000000o(O000000o);
                return O0000OoO;
            }
        }
        O000000o = null;
        int i = 0;
        if (O000000o == null) {
            O000000o = new O0000O0o(bitmapDescriptor, 0);
        }
        Bitmap bitmap = bitmapDescriptor.getBitmap();
        if (!(bitmap == null || bitmap.isRecycled())) {
            i = O0000OOo();
            O000000o.O000000o(i);
            if (z) {
                this.O0000o0o.O00000o0().O000000o(O000000o);
            }
            O000000o(O000000o);
            OOo000.O00000Oo(i, bitmap, true);
        }
        return i;
    }

    private static String O000000o(String str) {
        O000000o++;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(O000000o);
        return stringBuilder.toString();
    }

    private void O000000o(O0000O0o o0000O0o) {
        if (o0000O0o != null) {
            this.O000O0OO.add(o0000O0o);
            o0000O0o.O0000Ooo();
        }
    }

    private void O00000Oo(ca caVar, float[] fArr, int i, float f) throws RemoteException {
        float f2 = ((float) this.O0000Oo0) * f;
        f *= (float) this.O0000Oo;
        float f3 = this.O00000oo.x;
        float f4 = this.O00000oo.y;
        float sc = caVar.getMapConfig().getSC();
        this.O000O0o0[0] = f3 - (this.O0000o00 * f2);
        this.O000O0o0[1] = ((1.0f - this.O0000o0) * f) + f4;
        this.O000O0o0[2] = f3;
        this.O000O0o0[3] = f4;
        this.O000O0o0[6] = this.O00000Oo;
        this.O000O0o0[7] = sc;
        this.O000O0o0[9] = ((1.0f - this.O0000o00) * f2) + f3;
        this.O000O0o0[10] = ((1.0f - this.O0000o0) * f) + f4;
        this.O000O0o0[11] = f3;
        this.O000O0o0[12] = f4;
        this.O000O0o0[15] = this.O00000Oo;
        this.O000O0o0[16] = sc;
        this.O000O0o0[18] = ((1.0f - this.O0000o00) * f2) + f3;
        this.O000O0o0[19] = f4 - (this.O0000o0 * f);
        this.O000O0o0[20] = f3;
        this.O000O0o0[21] = f4;
        this.O000O0o0[24] = this.O00000Oo;
        this.O000O0o0[25] = sc;
        this.O000O0o0[27] = f3 - (f2 * this.O0000o00);
        this.O000O0o0[28] = f4 - (f * this.O0000o0);
        this.O000O0o0[29] = f3;
        this.O000O0o0[30] = f4;
        this.O000O0o0[33] = this.O00000Oo;
        this.O000O0o0[34] = sc;
        System.arraycopy(this.O000O0o0, 0, fArr, i, this.O000O0o0.length);
    }

    private void O00000o0() {
        if (this.O0000oO0 != null && this.O0000oO0.trim().length() > 0) {
            try {
                this.O0000ooo.setTypeface(this.O0000oo0);
                this.O0000ooo.setSubpixelText(true);
                this.O0000ooo.setAntiAlias(true);
                this.O0000ooo.setStrokeWidth(5.0f);
                this.O0000ooo.setStrokeCap(Cap.ROUND);
                this.O0000ooo.setTextSize((float) this.O0000oOo);
                this.O0000ooo.setTextAlign(Align.CENTER);
                this.O0000ooo.setColor(this.O0000oOO);
                FontMetrics fontMetrics = this.O0000ooo.getFontMetrics();
                int i = (int) (fontMetrics.descent - fontMetrics.ascent);
                int i2 = (int) (((((float) i) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
                this.O0000ooo.getTextBounds(this.O0000oO0, 0, this.O0000oO0.length(), this.O0000ooO);
                Bitmap createBitmap = Bitmap.createBitmap(this.O0000ooO.width() + 6, i, Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(this.O0000oO);
                canvas.drawText(this.O0000oO0, (float) (this.O0000ooO.centerX() + 3), (float) i2, this.O0000ooo);
                this.O0000OOo = BitmapDescriptorFactory.fromBitmap(createBitmap);
                this.O0000Oo0 = this.O0000OOo.getWidth();
                this.O0000Oo = this.O0000OOo.getHeight();
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "TextDelegateImp", "initBitmap");
            }
        }
    }

    private void O00000oo() {
        if (this.O0000o0o.O00000o0() != null) {
            this.O0000o0o.O00000o0().setRunLowFrame(false);
        }
    }

    private void O0000O0o() {
        if (this.O000O0OO != null) {
            for (O0000O0o o0000O0o : this.O000O0OO) {
                if (!(o0000O0o == null || this.O0000o0o == null)) {
                    this.O0000o0o.O000000o(o0000O0o);
                }
            }
            this.O000O0OO.clear();
        }
    }

    private int O0000OOo() {
        int[] iArr = new int[]{0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private synchronized void O0000Oo0() {
        O00000o0();
        this.O00oOoOo = false;
        O00000oo();
    }

    public void O000000o(ca caVar) {
        if (!this.O00oOoOo) {
            try {
                this.O0000O0o = O000000o(VERSION.SDK_INT >= 12, this.O0000OOo);
                this.O00oOoOo = true;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "TextDelegateImp", "loadtexture");
                th.printStackTrace();
            }
        }
    }

    public void O000000o(ca caVar, float[] fArr, int i, float f) {
        if (this.O0000o0O && !this.O000O0Oo && this.O0000Ooo != null && this.O0000OOo != null) {
            this.O00000oo.x = (float) (this.O00oOooO - caVar.getMapConfig().getSX());
            this.O00000oo.y = (float) (this.O00oOooo - caVar.getMapConfig().getSY());
            try {
                O00000Oo(caVar, fArr, i, f);
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "TextDelegateImp", "drawMarker");
            }
        }
    }

    public boolean O000000o() {
        return true;
    }

    public void O00000Oo(boolean z) {
        this.O000O00o = z;
    }

    public boolean O00000Oo() {
        if (this.O0000Ooo == null) {
            return false;
        }
        IPoint obtain = IPoint.obtain();
        GLMapState.lonlat2Geo(this.O0000Ooo.longitude, this.O0000Ooo.latitude, obtain);
        this.O00oOooO = obtain.x;
        this.O00oOooo = obtain.y;
        this.O0000o0o.O00000o0().O000000o(this.O0000Ooo.latitude, this.O0000Ooo.longitude, this.O00000oo);
        obtain.recycle();
        return true;
    }

    public int O00000o() {
        try {
            return this.O0000O0o;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public boolean O00000oO() {
        return this.O000O00o;
    }

    public boolean O0000OoO() {
        Rectangle geoRectangle = this.O0000o0o.O00000o0().getMapConfig().getGeoRectangle();
        return geoRectangle != null && geoRectangle.contains(this.O00oOooO, this.O00oOooo);
    }

    public Rect O0000Ooo() {
        return null;
    }

    public void destroy(boolean z) {
        try {
            this.O000O0Oo = true;
            if (z) {
                remove();
            }
            if (this.O000O0OO != null && this.O000O0OO.size() > 0) {
                for (int i = 0; i < this.O000O0OO.size(); i++) {
                    O0000O0o o0000O0o = (O0000O0o) this.O000O0OO.get(i);
                    if (!(o0000O0o == null || this.O0000o0o == null)) {
                        this.O0000o0o.O000000o(o0000O0o);
                        if (this.O0000o0o.O00000o0() != null) {
                            this.O0000o0o.O00000o0().O00000o0(o0000O0o.O0000o0O());
                        }
                    }
                }
                this.O000O0OO.clear();
            }
            if (this.O0000OOo != null) {
                this.O0000OOo.recycle();
                this.O0000OOo = null;
            }
            this.O0000Ooo = null;
            this.O0000o = null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "TextDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "TextDelegateImp destroy");
        }
    }

    public boolean equalsRemote(IOverlayImage iOverlayImage) throws RemoteException {
        return equals(iOverlayImage) || iOverlayImage.getId().equals(getId());
    }

    public int getAlignX() throws RemoteException {
        return this.O00000o;
    }

    public int getAlignY() {
        return this.O00000oO;
    }

    public float getAnchorU() {
        return this.O0000o00;
    }

    public float getAnchorV() {
        return this.O0000o0;
    }

    public int getBackgroundColor() throws RemoteException {
        return this.O0000oO;
    }

    public int getFontColor() throws RemoteException {
        return this.O0000oOO;
    }

    public int getFontSize() throws RemoteException {
        return this.O0000oOo;
    }

    public String getId() {
        if (this.O0000OoO == null) {
            this.O0000OoO = O000000o("Text");
        }
        return this.O0000OoO;
    }

    public Object getObject() {
        return this.O0000o;
    }

    public LatLng getPosition() {
        return this.O0000Ooo;
    }

    public float getRotateAngle() {
        return this.O00000o0;
    }

    public String getText() throws RemoteException {
        return this.O0000oO0;
    }

    public Typeface getTypeface() throws RemoteException {
        return this.O0000oo0;
    }

    public float getZIndex() {
        return this.O0000oo;
    }

    public int hashCodeRemote() {
        return super.hashCode();
    }

    public boolean isInfoWindowShown() {
        return false;
    }

    public boolean isVisible() {
        return this.O0000o0O;
    }

    public synchronized boolean remove() {
        O00000oo();
        this.O0000o0O = false;
        return this.O0000o0o.O000000o((OoO0o) this);
    }

    public void setAlign(int i, int i2) throws RemoteException {
        this.O00000o = i;
        if (i != 4) {
            switch (i) {
                case 1:
                    this.O0000o00 = 0.0f;
                    break;
                case 2:
                    this.O0000o00 = 1.0f;
                    break;
                default:
                    this.O0000o00 = 0.5f;
                    break;
            }
        }
        this.O0000o00 = 0.5f;
        this.O00000oO = i2;
        if (i2 == 8) {
            this.O0000o0 = 0.0f;
        } else if (i2 == 16) {
            this.O0000o0 = 1.0f;
        } else if (i2 != 32) {
            this.O0000o0 = 0.5f;
        } else {
            this.O0000o0 = 0.5f;
        }
        O00000oo();
    }

    public void setAnchor(float f, float f2) {
    }

    public void setBackgroundColor(int i) throws RemoteException {
        this.O0000oO = i;
        O0000Oo0();
    }

    public void setFontColor(int i) throws RemoteException {
        this.O0000oOO = i;
        O0000Oo0();
    }

    public void setFontSize(int i) throws RemoteException {
        this.O0000oOo = i;
        O0000Oo0();
    }

    public void setObject(Object obj) {
        this.O0000o = obj;
    }

    public void setPosition(LatLng latLng) {
        this.O0000Ooo = latLng;
        O00000Oo();
        O00000oo();
    }

    public void setRotateAngle(float f) {
        this.O00000o0 = f;
        this.O00000Oo = (((-f) % 360.0f) + 360.0f) % 360.0f;
        O00000oo();
    }

    public void setText(String str) throws RemoteException {
        this.O0000oO0 = str;
        O0000Oo0();
    }

    public void setTypeface(Typeface typeface) throws RemoteException {
        this.O0000oo0 = typeface;
        O0000Oo0();
    }

    public void setVisible(boolean z) {
        if (this.O0000o0O != z) {
            this.O0000o0O = z;
            O00000oo();
        }
    }

    public void setZIndex(float f) {
        this.O0000oo = f;
        this.O0000o0o.O00000oo();
    }
}
