package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.Animation.AnimationListener;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.nio.FloatBuffer;

/* compiled from: PopupOverlay */
public class OO000o implements O000o000, OooOO, IInfoWindowManager {
    ca O000000o = null;
    float[] O00000Oo = new float[12];
    float[] O00000o = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    O000000o O00000o0;
    long O00000oO = 0;
    O000o00 O00000oo;
    private Context O0000O0o;
    private bi O0000OOo;
    private int O0000Oo = 0;
    private boolean O0000Oo0 = false;
    private int O0000OoO = 0;
    private int O0000Ooo = 0;
    private boolean O0000o = true;
    private FPoint O0000o0;
    private int O0000o00 = 0;
    private FloatBuffer O0000o0O = null;
    private String O0000o0o;
    private float O0000oO = 0.5f;
    private FloatBuffer O0000oO0;
    private float O0000oOO = 1.0f;
    private boolean O0000oOo;
    private Bitmap O0000oo;
    private Bitmap O0000oo0;
    private Rect O0000ooO = new Rect();
    private float O0000ooo = 0.0f;
    private Bitmap O000O00o = null;
    private Bitmap O000O0OO = null;
    private Bitmap O000O0Oo = null;
    private boolean O000O0o = false;
    private boolean O000O0o0 = false;
    private GLAnimation O000O0oO;
    private GLAnimation O000O0oo;
    private boolean O000OO00 = false;
    private boolean O000OO0o = true;
    private Bitmap O00oOoOo = null;
    private int O00oOooO;
    private boolean O00oOooo = true;

    /* compiled from: PopupOverlay */
    static class O000000o extends OO00O0o {
        int O000000o;
        int O00000Oo;
        int O00000o0;

        O000000o(String str) {
            if (O000000o(str)) {
                this.O000000o = O00000o0("aMVP");
                this.O00000Oo = O00000Oo("aVertex");
                this.O00000o0 = O00000Oo("aTextureCoord");
            }
        }
    }

    public OO000o(ca caVar, Context context) {
        this.O0000O0o = context;
        this.O000000o = caVar;
        this.O0000o0o = getId();
    }

    private Bitmap O000000o(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.O0000O0o != null) {
            View linearLayout = new LinearLayout(this.O0000O0o);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return OOo000.O000000o(view);
    }

    private void O000000o(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null && i != 0) {
            if (this.O00000o0 == null) {
                O0000O0o();
            }
            this.O00000o0.O000000o();
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glEnableVertexAttribArray(this.O00000o0.O00000Oo);
            GLES20.glVertexAttribPointer(this.O00000o0.O00000Oo, 3, 5126, false, 12, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.O00000o0.O00000o0);
            GLES20.glVertexAttribPointer(this.O00000o0.O00000o0, 2, 5126, false, 8, floatBuffer2);
            GLES20.glUniformMatrix4fv(this.O00000o0.O000000o, 1, false, this.O00000o, 0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES20.glDisableVertexAttribArray(this.O00000o0.O00000Oo);
            GLES20.glDisableVertexAttribArray(this.O00000o0.O00000o0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUseProgram(0);
            GLES20.glDisable(3042);
        }
    }

    private void O00000Oo(boolean z) {
        if (z) {
            O00000Oo(O0000OoO());
        } else {
            O00000Oo(O0000Ooo());
        }
    }

    private synchronized void O00000o(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                O00000o0(this.O000O0OO);
                this.O000O0OO = bitmap;
            }
        }
    }

    private synchronized void O00000o0(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    private void O00000o0(final boolean z) {
        if (this.O000O0oo != null) {
            this.O000OO0o = false;
            this.O000OO00 = true;
            this.O000O0oo.startNow();
            this.O000O0oo.setAnimationListener(new AnimationListener() {
                public void onAnimationEnd() {
                    if (OO000o.this.O000O0oO != null) {
                        OO000o.this.O000OO00 = true;
                        OO000o.this.O000O0oO.startNow();
                        OO000o.this.O00000Oo(z);
                    }
                }

                public void onAnimationStart() {
                }
            });
        } else if (this.O000O0oO != null) {
            this.O000OO00 = true;
            this.O000O0oO.startNow();
            O00000Oo(z);
        } else {
            O00000Oo(z);
        }
    }

    private synchronized void O00000oO(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                O00000o0(this.O000O0Oo);
                this.O000O0Oo = bitmap;
            }
        }
    }

    private synchronized void O00000oo(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                O00000o0(this.O00oOoOo);
                this.O00oOoOo = bitmap;
            }
        }
    }

    private boolean O0000O0o(Bitmap bitmap) {
        return (this.O000O00o == null || bitmap.hashCode() != this.O000O00o.hashCode()) ? (this.O000O0Oo == null || bitmap.hashCode() != this.O000O0Oo.hashCode()) ? (this.O000O0OO == null || bitmap.hashCode() != this.O000O0OO.hashCode()) ? this.O00oOoOo != null && bitmap.hashCode() == this.O00oOoOo.hashCode() : true : true : true;
    }

    private synchronized Bitmap O0000OoO() {
        return this.O000O00o;
    }

    private synchronized Bitmap O0000Ooo() {
        return this.O000O0Oo;
    }

    private synchronized void O0000o() {
        if (this.O0000oo0 != null) {
            Bitmap bitmap = this.O0000oo0;
            if (bitmap != null) {
                bitmap.recycle();
                this.O0000oo0 = null;
            }
        }
        if (!(this.O0000oo == null || this.O0000oo.isRecycled())) {
            this.O0000oo.recycle();
            this.O0000oo = null;
        }
        if (!(this.O000O00o == null || this.O000O00o.isRecycled())) {
            this.O000O00o.recycle();
        }
        if (!(this.O000O0OO == null || this.O000O0OO.isRecycled())) {
            this.O000O0OO.recycle();
        }
        if (!(this.O000O0Oo == null || this.O000O0Oo.isRecycled())) {
            this.O000O0Oo.recycle();
        }
        if (!(this.O00oOoOo == null || this.O00oOoOo.isRecycled())) {
            this.O00oOoOo.recycle();
        }
    }

    private int O0000o0() {
        int[] iArr = new int[]{0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void O0000o00() {
        GLTransformation gLTransformation;
        if (!this.O000OO0o && this.O000O0oo != null && !this.O000O0oo.hasEnded()) {
            this.O000OO00 = true;
            gLTransformation = new GLTransformation();
            this.O000O0oo.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation);
            if (gLTransformation != null && !Double.isNaN(gLTransformation.scaleX) && !Double.isNaN(gLTransformation.scaleY)) {
                this.O0000ooo = (float) gLTransformation.scaleX;
            }
        } else if (this.O000O0oO == null || this.O000O0oO.hasEnded()) {
            this.O0000ooo = 1.0f;
            this.O000OO00 = false;
        } else {
            this.O000OO0o = false;
            this.O000OO00 = true;
            this.O0000Oo = this.O0000Ooo;
            this.O0000OoO = this.O0000o00;
            gLTransformation = new GLTransformation();
            this.O000O0oO.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation);
            if (gLTransformation != null && !Double.isNaN(gLTransformation.scaleX) && !Double.isNaN(gLTransformation.scaleY)) {
                this.O0000ooo = (float) gLTransformation.scaleX;
            }
        }
    }

    private void O0000o0O() {
        if (!this.O00oOooo || this.O0000oo0 == null) {
            O00000Oo(O0000Ooo());
        } else {
            O00000o0(false);
        }
        O000000o(false);
    }

    private void O0000o0o() {
        if (this.O00oOooo || this.O0000oo0 == null) {
            O00000Oo(O0000OoO());
        } else {
            O00000o0(true);
        }
        O000000o(true);
    }

    private Rect O0000oO() {
        return new Rect(this.O0000ooO.left, this.O0000ooO.top, this.O0000ooO.right, this.O0000ooO.top + O0000oOo());
    }

    private void O0000oO0() {
    }

    private Rect O0000oOO() {
        return new Rect(this.O0000ooO.left, this.O0000ooO.top, this.O0000ooO.right, this.O0000ooO.top + O0000oo0());
    }

    private int O0000oOo() {
        return (this.O000O00o == null || this.O000O00o.isRecycled()) ? 0 : this.O000O00o.getHeight();
    }

    private int O0000oo0() {
        return (this.O000O0Oo == null || this.O000O0Oo.isRecycled()) ? 0 : this.O000O0Oo.getHeight();
    }

    public synchronized void O000000o(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                this.O000O00o = bitmap;
            }
        }
    }

    public void O000000o(O000o00 o000o00) {
        synchronized (this) {
            this.O00000oo = o000o00;
        }
    }

    public synchronized void O000000o(bi biVar) throws RemoteException {
        if (biVar != null) {
            if (biVar.isInfoWindowEnable()) {
                if (!(this.O0000OOo == null || this.O0000OOo.getId().equals(biVar.getId()))) {
                    a_();
                }
                if (this.O00000oo != null) {
                    this.O0000OOo = biVar;
                    biVar.O000000o(true);
                    setVisible(true);
                    O0000Oo();
                }
                this.O000O0o0 = true;
            }
        }
    }

    public void O000000o(FPoint fPoint) {
        this.O0000o0 = fPoint;
    }

    public void O000000o(MapConfig mapConfig) throws RemoteException {
    }

    public void O000000o(boolean z) {
        this.O00oOooo = z;
    }

    public boolean O000000o() {
        return true;
    }

    /* JADX WARNING: Missing block: B:26:0x011d, code skipped:
            return false;
     */
    public boolean O000000o(int r12, int r13) {
        /*
        r11 = this;
        r0 = r11.O000000o;
        r0 = r0.O00000o0();
        r1 = r11.O0000o0;
        r2 = 0;
        if (r1 == 0) goto L_0x011e;
    L_0x000b:
        if (r0 != 0) goto L_0x000f;
    L_0x000d:
        goto L_0x011e;
    L_0x000f:
        r1 = com.autonavi.amap.mapcore.IPoint.obtain();
        r3 = r11.O000000o;
        r3 = r3.getMapConfig();
        if (r3 == 0) goto L_0x0045;
    L_0x001b:
        if (r0 == 0) goto L_0x0045;
    L_0x001d:
        r4 = com.autonavi.amap.mapcore.FPoint.obtain();
        r5 = r3.getSX();
        r6 = r11.O0000o0;
        r6 = r6.x;
        r6 = (int) r6;
        r5 = r5 + r6;
        r3 = r3.getSY();
        r6 = r11.O0000o0;
        r6 = r6.y;
        r6 = (int) r6;
        r3 = r3 + r6;
        r0.p20ToScreenPoint(r5, r3, r4);
        r0 = r4.x;
        r0 = (int) r0;
        r1.x = r0;
        r0 = r4.y;
        r0 = (int) r0;
        r1.y = r0;
        r4.recycle();
    L_0x0045:
        r0 = r11.O00000oO();
        r3 = r11.O00000oo();
        r4 = r1.x;
        r5 = r11.O0000Oo;
        r4 = r4 + r5;
        r4 = (float) r4;
        r5 = (float) r0;
        r6 = r11.O0000oO;
        r5 = r5 * r6;
        r4 = r4 - r5;
        r4 = (int) r4;
        r5 = r1.y;
        r6 = r11.O0000OoO;
        r5 = r5 + r6;
        r5 = (float) r5;
        r6 = (float) r3;
        r7 = r11.O0000oOO;
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r7 = r8 - r7;
        r6 = r6 * r7;
        r5 = r5 + r6;
        r5 = (int) r5;
        r1.recycle();
        r1 = r4 - r0;
        if (r1 > r12) goto L_0x011d;
    L_0x0070:
        r12 = -r0;
        r0 = 2;
        r12 = r12 * r0;
        if (r4 < r12) goto L_0x011d;
    L_0x0075:
        r12 = -r3;
        r12 = r12 * r0;
        if (r5 < r12) goto L_0x011d;
    L_0x0079:
        r12 = r5 - r3;
        if (r12 <= r13) goto L_0x007f;
    L_0x007d:
        goto L_0x011d;
    L_0x007f:
        r12 = r11.O0000oo0;
        if (r12 != 0) goto L_0x0084;
    L_0x0083:
        return r2;
    L_0x0084:
        r12 = r11.O0000oo0;
        r12 = r12.getWidth();
        r1 = r11.O0000oo0;
        r1 = r1.getHeight();
        r3 = r11.O0000oO0;
        r6 = 8;
        if (r3 != 0) goto L_0x00a1;
    L_0x0096:
        r3 = new float[r6];
        r3 = {0, 1065353216, 1065353216, 1065353216, 1065353216, 0, 0, 0};
        r3 = com.amap.api.mapcore.util.OOo000.O000000o(r3);
        r11.O0000oO0 = r3;
    L_0x00a1:
        r3 = r11.O0000ooo;
        r8 = r8 - r3;
        r7 = (double) r8;
        r9 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r7 = r7 * r9;
        r9 = (double) r12;
        r7 = r7 * r9;
        r3 = (int) r7;
        r7 = r11.O00000Oo;
        r8 = r4 + r3;
        r9 = (float) r8;
        r7[r2] = r9;
        r2 = r11.O0000ooO;
        r2.left = r8;
        r2 = r11.O00000Oo;
        r13 = r13 - r5;
        r7 = (float) r13;
        r8 = 1;
        r2[r8] = r7;
        r2 = r11.O00000Oo;
        r10 = 0;
        r2[r0] = r10;
        r0 = r11.O00000Oo;
        r2 = 3;
        r4 = r4 + r12;
        r12 = r4 - r3;
        r12 = (float) r12;
        r0[r2] = r12;
        r0 = r11.O00000Oo;
        r2 = 4;
        r0[r2] = r7;
        r0 = r11.O0000ooO;
        r2 = r5 - r1;
        r0.top = r2;
        r0 = r11.O00000Oo;
        r2 = 5;
        r0[r2] = r10;
        r0 = r11.O00000Oo;
        r2 = 6;
        r0[r2] = r12;
        r12 = r11.O0000ooO;
        r12.right = r4;
        r12 = r11.O00000Oo;
        r0 = 7;
        r13 = r13 + r1;
        r13 = (float) r13;
        r12[r0] = r13;
        r12 = r11.O0000ooO;
        r12.bottom = r5;
        r12 = r11.O00000Oo;
        r12[r6] = r10;
        r12 = r11.O00000Oo;
        r0 = 9;
        r12[r0] = r9;
        r12 = r11.O00000Oo;
        r0 = 10;
        r12[r0] = r13;
        r12 = r11.O00000Oo;
        r13 = 11;
        r12[r13] = r10;
        r12 = r11.O0000o0O;
        if (r12 != 0) goto L_0x0112;
    L_0x0109:
        r12 = r11.O00000Oo;
        r12 = com.amap.api.mapcore.util.OOo000.O000000o(r12);
        r11.O0000o0O = r12;
        goto L_0x011c;
    L_0x0112:
        r12 = r11.O00000Oo;
        r13 = r11.O0000o0O;
        r12 = com.amap.api.mapcore.util.OOo000.O000000o(r12, r13);
        r11.O0000o0O = r12;
    L_0x011c:
        return r8;
    L_0x011d:
        return r2;
    L_0x011e:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o.O000000o(int, int):boolean");
    }

    /* JADX WARNING: Missing block: B:11:0x0023, code skipped:
            return false;
     */
    public boolean O000000o(android.view.MotionEvent r4) {
        /*
        r3 = this;
        r0 = r3.O0000o;
        r1 = 0;
        if (r0 == 0) goto L_0x0023;
    L_0x0005:
        r0 = r3.O0000OOo;
        if (r0 == 0) goto L_0x0023;
    L_0x0009:
        r0 = r3.O000O0o0;
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0023;
    L_0x000e:
        r0 = r3.O0000ooO;
        r2 = r4.getX();
        r2 = (int) r2;
        r4 = r4.getY();
        r4 = (int) r4;
        r4 = com.amap.api.mapcore.util.OOo000.O000000o(r0, r2, r4);
        if (r4 == 0) goto L_0x0022;
    L_0x0020:
        r4 = 1;
        return r4;
    L_0x0022:
        return r1;
    L_0x0023:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o.O000000o(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Missing block: B:9:0x0011, code skipped:
            r0 = true;
     */
    /* JADX WARNING: Missing block: B:11:?, code skipped:
            setVisible(true);
            r2 = r10.O0000OOo.O0000Ooo();
            r3 = r10.O0000OOo.O0000OOo() + r10.O0000OOo.O00000oo();
            r4 = (r10.O0000OOo.O0000Oo0() + r10.O0000OOo.O0000O0o()) + 2;
     */
    /* JADX WARNING: Missing block: B:12:0x003b, code skipped:
            if ((r10.O0000OOo instanceof com.amap.api.mapcore.util.Oo0OOo) == false) goto L_0x00fc;
     */
    /* JADX WARNING: Missing block: B:13:0x003d, code skipped:
            monitor-enter(r10);
     */
    /* JADX WARNING: Missing block: B:16:0x0042, code skipped:
            if (O0000Oo0() == false) goto L_0x0053;
     */
    /* JADX WARNING: Missing block: B:18:0x0046, code skipped:
            if (r10.O0000oo0 != null) goto L_0x0051;
     */
    /* JADX WARNING: Missing block: B:20:0x004a, code skipped:
            if (r10.O000O00o != null) goto L_0x0053;
     */
    /* JADX WARNING: Missing block: B:22:0x004e, code skipped:
            if (r10.O000O0Oo == null) goto L_0x0051;
     */
    /* JADX WARNING: Missing block: B:24:0x0051, code skipped:
            r5 = false;
     */
    /* JADX WARNING: Missing block: B:25:0x0053, code skipped:
            r5 = true;
     */
    /* JADX WARNING: Missing block: B:26:0x0054, code skipped:
            if (r5 == false) goto L_0x00f7;
     */
    /* JADX WARNING: Missing block: B:27:0x0056, code skipped:
            r5 = ((com.amap.api.mapcore.util.Oo0OOo) r10.O0000OOo).getIMarkerAction();
     */
    /* JADX WARNING: Missing block: B:28:0x005e, code skipped:
            if (r5 == null) goto L_0x006b;
     */
    /* JADX WARNING: Missing block: B:30:0x0064, code skipped:
            if (r5.isInfoWindowEnable() != false) goto L_0x006b;
     */
    /* JADX WARNING: Missing block: B:31:0x0066, code skipped:
            setVisible(false);
     */
    /* JADX WARNING: Missing block: B:32:0x0069, code skipped:
            monitor-exit(r10);
     */
    /* JADX WARNING: Missing block: B:33:0x006a, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:34:0x006b, code skipped:
            setVisible(true);
     */
    /* JADX WARNING: Missing block: B:35:0x006e, code skipped:
            if (r5 == null) goto L_0x00e8;
     */
    /* JADX WARNING: Missing block: B:37:0x0074, code skipped:
            if (r5.isInfoWindowAutoOverturn() == false) goto L_0x00e8;
     */
    /* JADX WARNING: Missing block: B:38:0x0076, code skipped:
            r6 = O0000oO();
            r7 = O0000oOO();
     */
    /* JADX WARNING: Missing block: B:39:0x0082, code skipped:
            if (O00000o() == false) goto L_0x0093;
     */
    /* JADX WARNING: Missing block: B:40:0x0084, code skipped:
            r7.offset(0, (r2.height() + r6.height()) + 2);
     */
    /* JADX WARNING: Missing block: B:41:0x0093, code skipped:
            r6.offset(0, -((r2.height() + r6.height()) + 2));
     */
    /* JADX WARNING: Missing block: B:42:0x00a2, code skipped:
            r6 = r10.O000000o.O000000o(r5, r6);
            r5 = r10.O000000o.O000000o(r5, r7);
     */
    /* JADX WARNING: Missing block: B:43:0x00ae, code skipped:
            if (r6 <= 0) goto L_0x00b7;
     */
    /* JADX WARNING: Missing block: B:44:0x00b0, code skipped:
            if (r5 == 0) goto L_0x00b8;
     */
    /* JADX WARNING: Missing block: B:45:0x00b2, code skipped:
            if (r5 <= 0) goto L_0x00b7;
     */
    /* JADX WARNING: Missing block: B:46:0x00b4, code skipped:
            if (r6 >= r5) goto L_0x00b7;
     */
    /* JADX WARNING: Missing block: B:48:0x00b7, code skipped:
            r0 = false;
     */
    /* JADX WARNING: Missing block: B:49:0x00b8, code skipped:
            if (r0 == false) goto L_0x00d8;
     */
    /* JADX WARNING: Missing block: B:50:0x00ba, code skipped:
            r4 = (((r10.O0000OOo.O0000Oo0() + r10.O0000OOo.O0000O0o()) + 2) + r2.height()) + r7.height();
            O0000o0O();
     */
    /* JADX WARNING: Missing block: B:51:0x00d8, code skipped:
            O0000o0o();
     */
    /* JADX WARNING: Missing block: B:52:0x00db, code skipped:
            O000000o(r10.O0000OOo.O00000Oo());
            O00000o0(r3, r4);
     */
    /* JADX WARNING: Missing block: B:53:0x00e8, code skipped:
            O000000o(r10.O0000OOo.O00000Oo());
            O00000o0(r3, r4);
            O0000o0o();
     */
    /* JADX WARNING: Missing block: B:54:0x00f7, code skipped:
            monitor-exit(r10);
     */
    /* JADX WARNING: Missing block: B:61:0x0100, code skipped:
            if (O0000Oo0() == false) goto L_0x010e;
     */
    /* JADX WARNING: Missing block: B:63:0x0104, code skipped:
            if (r10.O0000oo0 != null) goto L_0x0139;
     */
    /* JADX WARNING: Missing block: B:65:0x0108, code skipped:
            if (r10.O000O00o != null) goto L_0x010e;
     */
    /* JADX WARNING: Missing block: B:67:0x010c, code skipped:
            if (r10.O000O0Oo == null) goto L_0x0139;
     */
    /* JADX WARNING: Missing block: B:69:0x0114, code skipped:
            if (r10.O0000OOo.isInfoWindowEnable() != false) goto L_0x011a;
     */
    /* JADX WARNING: Missing block: B:70:0x0116, code skipped:
            setVisible(false);
     */
    /* JADX WARNING: Missing block: B:71:0x0119, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:72:0x011a, code skipped:
            setVisible(true);
            O000000o(r10.O0000OOo.O00000Oo());
            O00000o0(r3, r4);
            O0000o0o();
     */
    public void O00000Oo() {
        /*
        r10 = this;
        monitor-enter(r10);	 Catch:{ Throwable -> 0x0135 }
        r0 = r10.O0000OOo;	 Catch:{ all -> 0x0132 }
        r1 = 0;
        if (r0 == 0) goto L_0x012d;
    L_0x0006:
        r0 = r10.O0000OOo;	 Catch:{ all -> 0x0132 }
        r0 = r0.O0000OoO();	 Catch:{ all -> 0x0132 }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        goto L_0x012d;
    L_0x0010:
        monitor-exit(r10);	 Catch:{ all -> 0x0132 }
        r0 = 1;
        r10.setVisible(r0);	 Catch:{ Throwable -> 0x0135 }
        r2 = r10.O0000OOo;	 Catch:{ Throwable -> 0x0135 }
        r2 = r2.O0000Ooo();	 Catch:{ Throwable -> 0x0135 }
        r3 = r10.O0000OOo;	 Catch:{ Throwable -> 0x0135 }
        r3 = r3.O0000OOo();	 Catch:{ Throwable -> 0x0135 }
        r4 = r10.O0000OOo;	 Catch:{ Throwable -> 0x0135 }
        r4 = r4.O00000oo();	 Catch:{ Throwable -> 0x0135 }
        r3 = r3 + r4;
        r4 = r10.O0000OOo;	 Catch:{ Throwable -> 0x0135 }
        r4 = r4.O0000Oo0();	 Catch:{ Throwable -> 0x0135 }
        r5 = r10.O0000OOo;	 Catch:{ Throwable -> 0x0135 }
        r5 = r5.O0000O0o();	 Catch:{ Throwable -> 0x0135 }
        r4 = r4 + r5;
        r4 = r4 + 2;
        r5 = r10.O0000OOo;	 Catch:{ Throwable -> 0x0135 }
        r5 = r5 instanceof com.amap.api.mapcore.util.Oo0OOo;	 Catch:{ Throwable -> 0x0135 }
        if (r5 == 0) goto L_0x00fc;
    L_0x003d:
        monitor-enter(r10);	 Catch:{ Throwable -> 0x0135 }
        r5 = r10.O0000Oo0();	 Catch:{ all -> 0x00f9 }
        if (r5 == 0) goto L_0x0053;
    L_0x0044:
        r5 = r10.O0000oo0;	 Catch:{ all -> 0x00f9 }
        if (r5 != 0) goto L_0x0051;
    L_0x0048:
        r5 = r10.O000O00o;	 Catch:{ all -> 0x00f9 }
        if (r5 != 0) goto L_0x0053;
    L_0x004c:
        r5 = r10.O000O0Oo;	 Catch:{ all -> 0x00f9 }
        if (r5 == 0) goto L_0x0051;
    L_0x0050:
        goto L_0x0053;
    L_0x0051:
        r5 = r1;
        goto L_0x0054;
    L_0x0053:
        r5 = r0;
    L_0x0054:
        if (r5 == 0) goto L_0x00f7;
    L_0x0056:
        r5 = r10.O0000OOo;	 Catch:{ all -> 0x00f9 }
        r5 = (com.amap.api.mapcore.util.Oo0OOo) r5;	 Catch:{ all -> 0x00f9 }
        r5 = r5.getIMarkerAction();	 Catch:{ all -> 0x00f9 }
        if (r5 == 0) goto L_0x006b;
    L_0x0060:
        r6 = r5.isInfoWindowEnable();	 Catch:{ all -> 0x00f9 }
        if (r6 != 0) goto L_0x006b;
    L_0x0066:
        r10.setVisible(r1);	 Catch:{ all -> 0x00f9 }
        monitor-exit(r10);	 Catch:{ all -> 0x00f9 }
        return;
    L_0x006b:
        r10.setVisible(r0);	 Catch:{ all -> 0x00f9 }
        if (r5 == 0) goto L_0x00e8;
    L_0x0070:
        r6 = r5.isInfoWindowAutoOverturn();	 Catch:{ all -> 0x00f9 }
        if (r6 == 0) goto L_0x00e8;
    L_0x0076:
        r6 = r10.O0000oO();	 Catch:{ all -> 0x00f9 }
        r7 = r10.O0000oOO();	 Catch:{ all -> 0x00f9 }
        r8 = r10.O00000o();	 Catch:{ all -> 0x00f9 }
        if (r8 == 0) goto L_0x0093;
    L_0x0084:
        r8 = r2.height();	 Catch:{ all -> 0x00f9 }
        r9 = r6.height();	 Catch:{ all -> 0x00f9 }
        r8 = r8 + r9;
        r8 = r8 + 2;
        r7.offset(r1, r8);	 Catch:{ all -> 0x00f9 }
        goto L_0x00a2;
    L_0x0093:
        r8 = r2.height();	 Catch:{ all -> 0x00f9 }
        r9 = r6.height();	 Catch:{ all -> 0x00f9 }
        r8 = r8 + r9;
        r8 = r8 + 2;
        r8 = -r8;
        r6.offset(r1, r8);	 Catch:{ all -> 0x00f9 }
    L_0x00a2:
        r8 = r10.O000000o;	 Catch:{ all -> 0x00f9 }
        r6 = r8.O000000o(r5, r6);	 Catch:{ all -> 0x00f9 }
        r8 = r10.O000000o;	 Catch:{ all -> 0x00f9 }
        r5 = r8.O000000o(r5, r7);	 Catch:{ all -> 0x00f9 }
        if (r6 <= 0) goto L_0x00b7;
    L_0x00b0:
        if (r5 == 0) goto L_0x00b8;
    L_0x00b2:
        if (r5 <= 0) goto L_0x00b7;
    L_0x00b4:
        if (r6 >= r5) goto L_0x00b7;
    L_0x00b6:
        goto L_0x00b8;
    L_0x00b7:
        r0 = r1;
    L_0x00b8:
        if (r0 == 0) goto L_0x00d8;
    L_0x00ba:
        r0 = r10.O0000OOo;	 Catch:{ all -> 0x00f9 }
        r0 = r0.O0000Oo0();	 Catch:{ all -> 0x00f9 }
        r1 = r10.O0000OOo;	 Catch:{ all -> 0x00f9 }
        r1 = r1.O0000O0o();	 Catch:{ all -> 0x00f9 }
        r0 = r0 + r1;
        r0 = r0 + 2;
        r1 = r2.height();	 Catch:{ all -> 0x00f9 }
        r0 = r0 + r1;
        r1 = r7.height();	 Catch:{ all -> 0x00f9 }
        r4 = r0 + r1;
        r10.O0000o0O();	 Catch:{ all -> 0x00f9 }
        goto L_0x00db;
    L_0x00d8:
        r10.O0000o0o();	 Catch:{ all -> 0x00f9 }
    L_0x00db:
        r0 = r10.O0000OOo;	 Catch:{ all -> 0x00f9 }
        r0 = r0.O00000Oo();	 Catch:{ all -> 0x00f9 }
        r10.O000000o(r0);	 Catch:{ all -> 0x00f9 }
        r10.O00000o0(r3, r4);	 Catch:{ all -> 0x00f9 }
        goto L_0x00f7;
    L_0x00e8:
        r0 = r10.O0000OOo;	 Catch:{ all -> 0x00f9 }
        r0 = r0.O00000Oo();	 Catch:{ all -> 0x00f9 }
        r10.O000000o(r0);	 Catch:{ all -> 0x00f9 }
        r10.O00000o0(r3, r4);	 Catch:{ all -> 0x00f9 }
        r10.O0000o0o();	 Catch:{ all -> 0x00f9 }
    L_0x00f7:
        monitor-exit(r10);	 Catch:{ all -> 0x00f9 }
        goto L_0x0139;
    L_0x00f9:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x00f9 }
        throw r0;	 Catch:{ Throwable -> 0x0135 }
    L_0x00fc:
        r2 = r10.O0000Oo0();	 Catch:{ Throwable -> 0x0135 }
        if (r2 == 0) goto L_0x010e;
    L_0x0102:
        r2 = r10.O0000oo0;	 Catch:{ Throwable -> 0x0135 }
        if (r2 != 0) goto L_0x0139;
    L_0x0106:
        r2 = r10.O000O00o;	 Catch:{ Throwable -> 0x0135 }
        if (r2 != 0) goto L_0x010e;
    L_0x010a:
        r2 = r10.O000O0Oo;	 Catch:{ Throwable -> 0x0135 }
        if (r2 == 0) goto L_0x0139;
    L_0x010e:
        r2 = r10.O0000OOo;	 Catch:{ Throwable -> 0x0135 }
        r2 = r2.isInfoWindowEnable();	 Catch:{ Throwable -> 0x0135 }
        if (r2 != 0) goto L_0x011a;
    L_0x0116:
        r10.setVisible(r1);	 Catch:{ Throwable -> 0x0135 }
        return;
    L_0x011a:
        r10.setVisible(r0);	 Catch:{ Throwable -> 0x0135 }
        r0 = r10.O0000OOo;	 Catch:{ Throwable -> 0x0135 }
        r0 = r0.O00000Oo();	 Catch:{ Throwable -> 0x0135 }
        r10.O000000o(r0);	 Catch:{ Throwable -> 0x0135 }
        r10.O00000o0(r3, r4);	 Catch:{ Throwable -> 0x0135 }
        r10.O0000o0o();	 Catch:{ Throwable -> 0x0135 }
        goto L_0x0139;
    L_0x012d:
        r10.setVisible(r1);	 Catch:{ all -> 0x0132 }
        monitor-exit(r10);	 Catch:{ all -> 0x0132 }
        return;
    L_0x0132:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0132 }
        throw r0;	 Catch:{ Throwable -> 0x0135 }
    L_0x0135:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0139:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o.O00000Oo():void");
    }

    public void O00000Oo(int i, int i2) {
        if (this.O0000o && this.O0000o0 != null && this.O0000oo0 != null) {
            O0000OOo();
            this.O0000oo0.isRecycled();
            if (!(this.O000O0o || this.O0000oo0.isRecycled())) {
                try {
                    if (this.O00oOooO != 0) {
                        GLES20.glDeleteTextures(1, new int[]{this.O00oOooO}, 0);
                    } else {
                        this.O00oOooO = O0000o0();
                    }
                    synchronized (this) {
                        if (!(this.O0000oo0 == null || this.O0000oo0.isRecycled())) {
                            OOo000.O00000Oo(this.O00oOooO, this.O0000oo0, false);
                            this.O000O0o = true;
                        }
                    }
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "PopupOverlay", "drawMarker");
                    th.printStackTrace();
                    return;
                }
            }
            O0000o00();
            if (O000000o(i, i2)) {
                Matrix.setIdentityM(this.O00000o, 0);
                Matrix.orthoM(this.O00000o, 0, 0.0f, (float) i, 0.0f, (float) i2, 1.0f, -1.0f);
                O000000o(this.O00oOooO, this.O0000o0O, this.O0000oO0);
                if (this.O0000oOo) {
                    this.O0000oOo = false;
                    O0000oO0();
                }
            }
        }
    }

    /* JADX WARNING: Missing block: B:35:0x0057, code skipped:
            return;
     */
    public synchronized void O00000Oo(android.graphics.Bitmap r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        if (r3 == 0) goto L_0x0056;
    L_0x0003:
        r0 = r3.isRecycled();	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0056;
    L_0x000a:
        r0 = r2.O0000oo0;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        if (r0 == 0) goto L_0x001c;
    L_0x000e:
        r0 = r2.O0000oo0;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r0 = r0.hashCode();	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r1 = r3.hashCode();	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        if (r0 != r1) goto L_0x001c;
    L_0x001a:
        monitor-exit(r2);
        return;
    L_0x001c:
        r0 = r2.O0000oo0;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        if (r0 == 0) goto L_0x004b;
    L_0x0020:
        r0 = r2.O000O00o;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        if (r0 != 0) goto L_0x003a;
    L_0x0024:
        r0 = r2.O000O0OO;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        if (r0 != 0) goto L_0x003a;
    L_0x0028:
        r0 = r2.O000O0Oo;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        if (r0 != 0) goto L_0x003a;
    L_0x002c:
        r0 = r2.O00oOoOo;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        if (r0 != 0) goto L_0x003a;
    L_0x0030:
        r0 = r2.O0000oo;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r2.O00000o0(r0);	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r0 = r2.O0000oo0;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r2.O0000oo = r0;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        goto L_0x004b;
    L_0x003a:
        r0 = r2.O0000oo0;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r0 = r2.O0000O0o(r0);	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        if (r0 != 0) goto L_0x004b;
    L_0x0042:
        r0 = r2.O0000oo;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r2.O00000o0(r0);	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r0 = r2.O0000oo0;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r2.O0000oo = r0;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
    L_0x004b:
        r0 = 0;
        r2.O000O0o = r0;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        r2.O0000oo0 = r3;	 Catch:{ Throwable -> 0x0054, all -> 0x0051 }
        goto L_0x0054;
    L_0x0051:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
    L_0x0054:
        monitor-exit(r2);
        return;
    L_0x0056:
        monitor-exit(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o.O00000Oo(android.graphics.Bitmap):void");
    }

    public boolean O00000o() {
        return this.O00oOooo;
    }

    public void O00000o0(int i, int i2) throws RemoteException {
        if (this.O000OO00) {
            this.O0000Ooo = i;
            this.O0000o00 = i2;
            return;
        }
        this.O0000Oo = i;
        this.O0000OoO = i2;
        this.O0000Ooo = i;
        this.O0000o00 = i2;
    }

    public boolean O00000o0() {
        return false;
    }

    /* JADX WARNING: Missing block: B:12:0x0017, code skipped:
            return 0;
     */
    public int O00000oO() {
        /*
        r2 = this;
        r0 = 0;
        monitor-enter(r2);	 Catch:{ Throwable -> 0x001b }
        r1 = r2.O0000oo0;	 Catch:{ all -> 0x0018 }
        if (r1 == 0) goto L_0x0016;
    L_0x0006:
        r1 = r2.O0000oo0;	 Catch:{ all -> 0x0018 }
        r1 = r1.isRecycled();	 Catch:{ all -> 0x0018 }
        if (r1 != 0) goto L_0x0016;
    L_0x000e:
        r1 = r2.O0000oo0;	 Catch:{ all -> 0x0018 }
        r1 = r1.getWidth();	 Catch:{ all -> 0x0018 }
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        return r1;
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        return r0;
    L_0x0018:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0018 }
        throw r1;	 Catch:{ Throwable -> 0x001b }
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO000o.O00000oO():int");
    }

    public int O00000oo() {
        try {
            return (this.O0000oo0 == null || this.O0000oo0.isRecycled()) ? 0 : this.O0000oo0.getHeight();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void O0000O0o() {
        this.O00000o0 = new O000000o("texture.glsl");
    }

    /* Access modifiers changed, original: protected */
    public void O0000OOo() {
        long j;
        long O00000o0;
        synchronized (this) {
            j = 100;
            if (this.O00000oo != null) {
                if (this.O0000OOo instanceof Oo0OOo) {
                    O00000o0 = this.O00000oo.O00000o0(new Marker((IMarker) this.O0000OOo));
                } else {
                    O00000o0 = this.O00000oo.O00000o0(new GL3DModel((O0OOO0O) this.O0000OOo));
                }
                if (O00000o0 <= 0) {
                    j = Long.MAX_VALUE;
                } else if (O00000o0 > 100) {
                    j = O00000o0;
                }
            } else {
                j = 0;
            }
        }
        O00000o0 = System.currentTimeMillis();
        if (O00000o0 - this.O00000oO > j) {
            if (this.O00000oO != 0) {
                try {
                    O000000o(this.O0000OOo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.O00000oO = O00000o0;
        }
    }

    /* Access modifiers changed, original: protected */
    public void O0000Oo() {
        try {
            Bitmap O000000o;
            if (this.O0000OOo instanceof Oo0OOo) {
                Marker marker = new Marker((IMarker) this.O0000OOo);
                if (this.O00000oo != null) {
                    O000000o = O000000o(this.O00000oo.O000000o((BasePointOverlay) marker));
                    if (O000000o == null) {
                        View O00000Oo = this.O00000oo.O00000Oo((BasePointOverlay) marker);
                        if (O00000Oo != null) {
                            if (O00000Oo.getBackground() == null) {
                                O00000Oo.setBackground(this.O00000oo.O00000oo());
                            }
                            O000000o = O000000o(O00000Oo);
                        }
                    }
                    O000000o(O000000o);
                    O00000o(O000000o(this.O00000oo.O000000o(marker)));
                    O00000oO(O000000o(this.O00000oo.O00000Oo(marker)));
                    O00000oo(O000000o(this.O00000oo.O00000o0(marker)));
                }
            } else if (this.O00000oo != null) {
                BasePointOverlay gL3DModel = new GL3DModel((O0OOO0O) this.O0000OOo);
                O000000o = O000000o(this.O00000oo.O000000o(gL3DModel));
                if (O000000o == null) {
                    View O00000Oo2 = this.O00000oo.O00000Oo(gL3DModel);
                    if (O00000Oo2 != null) {
                        if (O00000Oo2.getBackground() == null) {
                            O00000Oo2.setBackground(this.O00000oo.O00000oo());
                        }
                        O000000o = O000000o(O00000Oo2);
                    }
                }
                O000000o(O000000o);
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PopupOverlay", "getInfoWindow");
            th.printStackTrace();
        }
    }

    public boolean O0000Oo0() {
        return this.O000OO00;
    }

    public synchronized void a_() {
        setVisible(false);
        O0000o();
        this.O000O0o0 = false;
    }

    public void destroy() {
        if (this.O0000Oo0) {
            try {
                remove();
                O0000o();
                if (this.O0000oO0 != null) {
                    this.O0000oO0.clear();
                    this.O0000oO0 = null;
                }
                if (this.O0000o0O != null) {
                    this.O0000o0O.clear();
                    this.O0000o0O = null;
                }
                this.O0000o0 = null;
                this.O00oOooO = 0;
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "PopupOverlay", "realDestroy");
                th.printStackTrace();
            }
        }
    }

    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    public String getId() {
        if (this.O0000o0o == null) {
            this.O0000o0o = "PopupOverlay";
        }
        return this.O0000o0o;
    }

    public float getZIndex() {
        return 0.0f;
    }

    public int hashCodeRemote() {
        return super.hashCode();
    }

    public boolean isAboveMaskLayer() {
        return false;
    }

    public boolean isVisible() {
        return this.O0000o;
    }

    public void remove() throws RemoteException {
    }

    public void setAboveMaskLayer(boolean z) {
    }

    public void setInfoWindowAnimation(Animation animation, AnimationListener animationListener) {
    }

    public void setInfoWindowAppearAnimation(Animation animation) {
        if (this.O000O0oo == null || !this.O000O0oo.equals(animation.glAnimation)) {
            this.O000O0oO = animation.glAnimation;
            return;
        }
        try {
            this.O000O0oO = animation.glAnimation.clone();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
        }
    }

    public void setInfoWindowBackColor(int i) {
    }

    public void setInfoWindowBackEnable(boolean z) {
    }

    public void setInfoWindowBackScale(float f, float f2) {
    }

    public void setInfoWindowDisappearAnimation(Animation animation) {
        if (this.O000O0oO == null || !this.O000O0oO.equals(animation.glAnimation)) {
            this.O000O0oo = animation.glAnimation;
            return;
        }
        try {
            this.O000O0oo = animation.glAnimation.clone();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
        }
    }

    public void setInfoWindowMovingAnimation(Animation animation) {
    }

    public void setVisible(boolean z) {
        if (!this.O0000o && z) {
            this.O0000oOo = true;
        }
        this.O0000o = z;
    }

    public void setZIndex(float f) {
    }

    public void startAnimation() {
    }
}
