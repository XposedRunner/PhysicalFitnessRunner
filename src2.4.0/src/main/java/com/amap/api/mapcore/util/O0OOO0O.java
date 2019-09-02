package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.view.animation.AnimationUtils;
import com.amap.api.mapcore.util.OO00O.O00000Oo;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.amap.mapcore.interfaces.IglModel;
import java.util.List;

/* compiled from: Gl3DModelImp */
public class O0OOO0O extends bi implements IglModel {
    float[] O000000o = new float[16];
    float[] O00000Oo = new float[16];
    float O00000o = 1.0f;
    Rect O00000o0 = new Rect(0, 0, 0, 0);
    private boolean O00000oO = true;
    private String O00000oo;
    private float[] O0000O0o = new float[16];
    private bx O0000OOo;
    private ca O0000Oo;
    private BitmapDescriptor O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private Bitmap O0000o;
    private GLAnimation O0000o0;
    private LatLng O0000o00;
    private boolean O0000o0O = true;
    private boolean O0000o0o = true;
    private float O0000oO;
    private O00000Oo O0000oO0;
    private Object O0000oOO;
    private float O0000oOo = 18.0f;
    private float O0000oo = 0.0f;
    private float O0000oo0 = -1.0f;
    private boolean O0000ooO = false;
    private bv O0000ooo;
    private boolean O000O00o = false;
    private FPoint O000O0OO = FPoint.obtain();
    private int O000O0Oo = 0;
    private float O000O0o = 0.5f;
    private float O000O0o0 = 0.5f;
    private String O000O0oO;
    private String O000O0oo;
    private float O000OO00 = -1.0f;
    private int O00oOoOo = 0;
    private int O00oOooO;
    private boolean O00oOooo = false;

    public O0OOO0O(bv bvVar, GL3DModelOptions gL3DModelOptions, ca caVar) {
        int i = 1;
        if (gL3DModelOptions != null && caVar != null) {
            this.O0000ooo = bvVar;
            this.O0000Oo = caVar;
            this.O0000Oo0 = gL3DModelOptions.getBitmapDescriptor();
            List textrue = gL3DModelOptions.getTextrue();
            List vertext = gL3DModelOptions.getVertext();
            this.O0000o00 = gL3DModelOptions.getLatLng();
            this.O0000oO = gL3DModelOptions.getAngle();
            setModelFixedLength(gL3DModelOptions.getModelFixedLength());
            if (this.O0000o00 != null) {
                IPoint obtain = IPoint.obtain();
                GLMapState.lonlat2Geo(this.O0000o00.longitude, this.O0000o00.latitude, obtain);
                this.O0000OoO = obtain.x;
                this.O0000Ooo = obtain.y;
            }
            if (!(textrue == null || textrue.size() <= 0 || vertext == null)) {
                int i2 = vertext.size() > 0 ? 1 : 0;
                if (this.O0000Oo0 == null) {
                    i = 0;
                }
                if ((i2 & i) != 0) {
                    this.O0000OOo = new bx(vertext, textrue);
                    this.O0000OOo.O000000o(this.O0000oO);
                }
            }
            this.O000000o = new float[16];
            this.O00000Oo = new float[4];
        }
    }

    private int O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            this.O0000o = bitmap;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, this.O0000o, 0);
        return iArr[0];
    }

    private void O000000o(GLAnimation gLAnimation) {
        if (gLAnimation instanceof GLTranslateAnimation) {
            GLTranslateAnimation gLTranslateAnimation = (GLTranslateAnimation) gLAnimation;
            gLTranslateAnimation.mFromXDelta = (double) this.O0000OoO;
            gLTranslateAnimation.mFromYDelta = (double) this.O0000Ooo;
            IPoint obtain = IPoint.obtain();
            GLMapState.lonlat2Geo(gLTranslateAnimation.mToXDelta, gLTranslateAnimation.mToYDelta, obtain);
            gLTranslateAnimation.mToXDelta = (double) obtain.x;
            gLTranslateAnimation.mToYDelta = (double) obtain.y;
            obtain.recycle();
        }
    }

    private float O0000o0() {
        return (this.O0000Oo.getMapConfig().getMapPerPixelUnitLength() * this.O0000oo) / this.O0000OOo.O000000o();
    }

    private float O0000o00() {
        float mapPerPixelUnitLength = this.O0000Oo.getMapConfig().getMapPerPixelUnitLength();
        if (this.O0000Oo.getMapConfig().getSZ() < this.O0000oOo) {
            return mapPerPixelUnitLength / this.O0000oo0;
        }
        this.O000OO00 = mapPerPixelUnitLength;
        return mapPerPixelUnitLength / this.O000OO00;
    }

    private void O0000o0O() {
        if (this.O0000o0O || this.O0000o0 == null || this.O0000o0.hasEnded()) {
            this.O0000o0O = true;
            return;
        }
        O0000o0o();
        GLTransformation gLTransformation = new GLTransformation();
        this.O0000o0.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation);
        if (gLTransformation != null && !Double.isNaN(gLTransformation.x) && !Double.isNaN(gLTransformation.y)) {
            double d = gLTransformation.x;
            double d2 = gLTransformation.y;
            this.O0000OoO = (int) d;
            this.O0000Ooo = (int) d2;
        }
    }

    private void O0000o0o() {
        if (this.O0000Oo != null) {
            this.O0000Oo.setRunLowFrame(false);
        }
    }

    public void O000000o() {
        try {
            if (this.O0000OOo != null) {
                if (this.O0000oO0 == null) {
                    this.O0000oO0 = (O00000Oo) this.O0000Oo.O0000oOo(5);
                }
                if (this.O0000oo0 == -1.0f) {
                    this.O0000oo0 = this.O0000Oo.O0000oo0((int) this.O0000oOo);
                }
                if (this.O00000oO) {
                    this.O00oOooO = O000000o(this.O0000Oo0.getBitmap());
                    this.O0000OOo.O000000o(this.O00oOooO);
                    this.O00000oO = false;
                }
                O0000o0O();
                float sx = (float) (this.O0000OoO - this.O0000Oo.getMapConfig().getSX());
                this.O000O0OO.x = sx;
                float sy = (float) (this.O0000Ooo - this.O0000Oo.getMapConfig().getSY());
                this.O000O0OO.y = sy;
                Matrix.setIdentityM(this.O0000O0o, 0);
                Matrix.multiplyMM(this.O0000O0o, 0, this.O0000Oo.getProjectionMatrix(), 0, this.O0000Oo.getViewMatrix(), 0);
                Matrix.translateM(this.O0000O0o, 0, sx, sy, 0.0f);
                if (this.O0000ooO) {
                    this.O00000o = O0000o0();
                } else {
                    this.O00000o = O0000o00();
                }
                Matrix.scaleM(this.O0000O0o, 0, this.O00000o, this.O00000o, this.O00000o);
                this.O0000OOo.O000000o(this.O0000oO0, this.O0000O0o);
                if (this.O000O00o) {
                    this.O0000Oo.O0000Oo();
                    this.O000O00o = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O000000o(String str) {
        this.O00000oo = str;
    }

    public void O000000o(boolean z) {
        this.O00oOooo = z;
        this.O000O00o = true;
    }

    public FPoint O00000Oo() {
        return this.O000O0OO;
    }

    public int O00000o() {
        return (int) ((this.O0000OOo.O00000Oo() * this.O00000o) / this.O0000Oo.getMapConfig().getMapPerPixelUnitLength());
    }

    public LatLng O00000o0() {
        return null;
    }

    public int O00000oO() {
        return (int) ((this.O0000OOo.O000000o() * this.O00000o) / this.O0000Oo.getMapConfig().getMapPerPixelUnitLength());
    }

    public int O00000oo() {
        return 0;
    }

    public int O0000O0o() {
        return 0;
    }

    public int O0000OOo() {
        return this.O000O0Oo;
    }

    public boolean O0000Oo() {
        return false;
    }

    public int O0000Oo0() {
        return this.O00oOoOo;
    }

    public boolean O0000OoO() {
        return this.O0000Oo.getMapConfig().getGeoRectangle().contains(this.O0000OoO, this.O0000Ooo);
    }

    public Rect O0000Ooo() {
        try {
            GLMapState O00000o0 = this.O0000Oo.O00000o0();
            int O00000o = O00000o();
            int O00000oO = O00000oO();
            FPoint obtain = FPoint.obtain();
            O00000o0.p20ToScreenPoint(this.O0000OoO, this.O0000Ooo, obtain);
            Matrix.setIdentityM(this.O000000o, 0);
            Matrix.rotateM(this.O000000o, 0, -this.O0000oO, 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(this.O000000o, 0, this.O0000Oo.getMapConfig().getSC(), 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.O000000o, 0, this.O0000Oo.getMapConfig().getSR(), 0.0f, 0.0f, 1.0f);
            r3 = new float[4];
            float f = (float) (-O00000o);
            this.O00000Oo[0] = this.O000O0o0 * f;
            float f2 = (float) O00000oO;
            this.O00000Oo[1] = this.O000O0o * f2;
            this.O00000Oo[2] = 0.0f;
            this.O00000Oo[3] = 1.0f;
            Matrix.multiplyMV(r3, 0, this.O000000o, 0, this.O00000Oo, 0);
            this.O00000o0.set((int) (obtain.x + r3[0]), (int) (obtain.y - r3[1]), (int) (obtain.x + r3[0]), (int) (obtain.y - r3[1]));
            float f3 = (float) O00000o;
            this.O00000Oo[0] = (1.0f - this.O000O0o0) * f3;
            this.O00000Oo[1] = f2 * this.O000O0o;
            this.O00000Oo[2] = 0.0f;
            this.O00000Oo[3] = 1.0f;
            Matrix.multiplyMV(r3, 0, this.O000000o, 0, this.O00000Oo, 0);
            this.O00000o0.union((int) (obtain.x + r3[0]), (int) (obtain.y - r3[1]));
            this.O00000Oo[0] = f3 * (1.0f - this.O000O0o0);
            float f4 = (float) (-O00000oO);
            this.O00000Oo[1] = (1.0f - this.O000O0o) * f4;
            this.O00000Oo[2] = 0.0f;
            this.O00000Oo[3] = 1.0f;
            Matrix.multiplyMV(r3, 0, this.O000000o, 0, this.O00000Oo, 0);
            this.O00000o0.union((int) (obtain.x + r3[0]), (int) (obtain.y - r3[1]));
            this.O00000Oo[0] = f * this.O000O0o0;
            this.O00000Oo[1] = f4 * (1.0f - this.O000O0o);
            this.O00000Oo[2] = 0.0f;
            this.O00000Oo[3] = 1.0f;
            Matrix.multiplyMV(r3, 0, this.O000000o, 0, this.O00000Oo, 0);
            this.O00000o0.union((int) (obtain.x + r3[0]), (int) (obtain.y - r3[1]));
            this.O000O0Oo = this.O00000o0.centerX() - ((int) obtain.x);
            this.O00oOoOo = this.O00000o0.top - ((int) obtain.y);
            obtain.recycle();
            return this.O00000o0;
        } catch (Throwable th) {
            Throwable th2 = th;
            ooOOOOoo.O00000o0(th2, "MarkerDelegateImp", "getRect");
            th2.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    public void destroy() {
        if (this.O0000o != null) {
            this.O0000o.recycle();
        }
        this.O0000ooo.O000000o(this.O00oOooO);
        this.O0000OOo.O00000o0();
    }

    public String getId() {
        return this.O00000oo;
    }

    public Object getObject() {
        return this.O0000oOO;
    }

    public LatLng getPosition() {
        return this.O0000o00;
    }

    public float getRotateAngle() {
        return 0.0f;
    }

    public String getSnippet() {
        return this.O000O0oO;
    }

    public String getTitle() {
        return this.O000O0oo;
    }

    public boolean isInfoWindowEnable() {
        return true;
    }

    public boolean isVisible() {
        return this.O0000o0o;
    }

    public boolean remove() {
        if (this.O0000Oo != null) {
            this.O0000Oo.O00000Oo(this.O00000oo);
        }
        return true;
    }

    public void setAnimation(Animation animation) {
        if (animation != null) {
            this.O0000o0 = animation.glAnimation;
        }
    }

    public void setGeoPoint(IPoint iPoint) {
        if (iPoint != null) {
            this.O0000OoO = iPoint.x;
            this.O0000Ooo = iPoint.y;
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat(this.O0000OoO, this.O0000Ooo, obtain);
            this.O0000o00 = new LatLng(obtain.y, obtain.x, false);
            obtain.recycle();
        }
        this.O0000Oo.requestRender();
    }

    public void setModelFixedLength(int i) {
        if (i > 0) {
            this.O0000oo = (float) i;
            this.O0000ooO = true;
            return;
        }
        this.O0000oo = 0.0f;
        this.O0000ooO = false;
    }

    public void setObject(Object obj) {
        this.O0000oOO = obj;
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.O0000o00 = latLng;
            IPoint obtain = IPoint.obtain();
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
            this.O0000OoO = obtain.x;
            this.O0000Ooo = obtain.y;
            obtain.recycle();
        }
        this.O000O00o = true;
        this.O0000Oo.requestRender();
    }

    public void setRotateAngle(float f) {
        this.O0000oO = f;
        if (this.O0000OOo != null) {
            this.O0000OOo.O000000o(this.O0000oO - this.O0000Oo.getMapConfig().getSR());
        }
        this.O000O00o = true;
    }

    public void setSnippet(String str) {
        this.O000O0oO = str;
    }

    public void setTitle(String str) {
        this.O000O0oo = str;
    }

    public void setVisible(boolean z) {
        this.O0000o0o = z;
    }

    public void setZoomLimit(float f) {
        this.O0000oOo = f;
        this.O0000oo0 = this.O0000Oo.O0000oo0((int) this.O0000oOo);
    }

    public void showInfoWindow() {
        try {
            this.O0000Oo.O000000o((bi) this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean startAnimation() {
        if (this.O0000o0 != null) {
            if (this.O0000o0 instanceof GLAnimationSet) {
                GLAnimationSet gLAnimationSet = (GLAnimationSet) this.O0000o0;
                for (GLAnimation gLAnimation : gLAnimationSet.getAnimations()) {
                    O000000o(gLAnimation);
                    gLAnimation.setDuration(gLAnimationSet.getDuration());
                }
            } else {
                O000000o(this.O0000o0);
            }
            this.O0000o0O = false;
            this.O0000o0.start();
        }
        return false;
    }
}
