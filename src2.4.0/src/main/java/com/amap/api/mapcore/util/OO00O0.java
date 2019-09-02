package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.amap.api.mapcore.util.OO00O.O0000OOo;
import com.amap.api.mapcore.util.OO0Oo00.O0000O0o;
import com.amap.api.mapcore.util.o0ooo0OO.O00000o0;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.ITileOverlay;
import java.lang.ref.WeakReference;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TileOverlayDelegateImp */
public class OO00O0 implements O0o {
    private static int O0000OOo;
    O0000OOo O000000o;
    private O0000o00 O00000Oo;
    private Float O00000o;
    private TileProvider O00000o0;
    private boolean O00000oO;
    private boolean O00000oo = false;
    private ca O0000O0o;
    private int O0000Oo = 256;
    private int O0000Oo0 = 256;
    private int O0000OoO = -1;
    private OOOo00 O0000Ooo;
    private FloatBuffer O0000o = null;
    private boolean O0000o0 = false;
    private List<O000000o> O0000o00 = new ArrayList();
    private O00000Oo O0000o0O = null;
    private String O0000o0o = null;

    /* compiled from: TileOverlayDelegateImp */
    public static class O000000o implements Cloneable {
        public int O000000o;
        public int O00000Oo;
        public int O00000o;
        public int O00000o0;
        public IPoint O00000oO;
        public int O00000oo = 0;
        public boolean O0000O0o = false;
        public FloatBuffer O0000OOo = null;
        public com.amap.api.mapcore.util.o0ooo0OO.O000000o O0000Oo = null;
        public Bitmap O0000Oo0 = null;
        public int O0000OoO = 0;
        private ca O0000Ooo;
        private OOOo00 O0000o0;
        private O0000o00 O0000o00;

        public O000000o(int i, int i2, int i3, int i4, ca caVar, O0000o00 o0000o00, OOOo00 oOOo00) {
            this.O000000o = i;
            this.O00000Oo = i2;
            this.O00000o0 = i3;
            this.O00000o = i4;
            this.O0000Ooo = caVar;
            this.O0000o00 = o0000o00;
            this.O0000o0 = oOOo00;
        }

        public O000000o(O000000o o000000o) {
            this.O000000o = o000000o.O000000o;
            this.O00000Oo = o000000o.O00000Oo;
            this.O00000o0 = o000000o.O00000o0;
            this.O00000o = o000000o.O00000o;
            this.O00000oO = o000000o.O00000oO;
            this.O0000OOo = o000000o.O0000OOo;
            this.O0000OoO = 0;
            this.O0000o00 = o000000o.O0000o00;
            this.O0000Ooo = o000000o.O0000Ooo;
            this.O0000o0 = o000000o.O0000o0;
        }

        /* renamed from: O000000o */
        public O000000o clone() {
            try {
                O000000o o000000o = (O000000o) super.clone();
                o000000o.O000000o = this.O000000o;
                o000000o.O00000Oo = this.O00000Oo;
                o000000o.O00000o0 = this.O00000o0;
                o000000o.O00000o = this.O00000o;
                o000000o.O00000oO = (IPoint) this.O00000oO.clone();
                o000000o.O0000OOo = this.O0000OOo.asReadOnlyBuffer();
                this.O0000OoO = 0;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new O000000o(this);
        }

        public synchronized void O000000o(Bitmap bitmap) {
            if (bitmap != null) {
                try {
                    if (!bitmap.isRecycled()) {
                        this.O0000Oo = null;
                        this.O0000Oo0 = bitmap;
                        this.O0000Ooo.setRunLowFrame(false);
                    }
                } catch (Throwable th) {
                }
            }
            if (this.O0000OoO < 3) {
                this.O0000OoO++;
                if (this.O0000o0 != null) {
                    this.O0000o0.O000000o(true, this);
                }
            }
        }

        public void O00000Oo() {
            try {
                o0ooo0OO.O000000o(this);
                if (this.O0000O0o) {
                    this.O0000o00.O000000o(this.O00000oo);
                }
                this.O0000O0o = false;
                this.O00000oo = 0;
                if (!(this.O0000Oo0 == null || this.O0000Oo0.isRecycled())) {
                    this.O0000Oo0.recycle();
                }
                this.O0000Oo0 = null;
                if (this.O0000OOo != null) {
                    this.O0000OOo.clear();
                }
                this.O0000OOo = null;
                this.O0000Oo = null;
                this.O0000OoO = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O000000o)) {
                return false;
            }
            O000000o o000000o = (O000000o) obj;
            if (!(this.O000000o == o000000o.O000000o && this.O00000Oo == o000000o.O00000Oo && this.O00000o0 == o000000o.O00000o0 && this.O00000o == o000000o.O00000o)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (((this.O000000o * 7) + (this.O00000Oo * 11)) + (this.O00000o0 * 13)) + this.O00000o;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.O000000o);
            stringBuilder.append("-");
            stringBuilder.append(this.O00000Oo);
            stringBuilder.append("-");
            stringBuilder.append(this.O00000o0);
            stringBuilder.append("-");
            stringBuilder.append(this.O00000o);
            return stringBuilder.toString();
        }
    }

    /* compiled from: TileOverlayDelegateImp */
    private static class O00000Oo extends OO0Oo00<Void, Void, List<O000000o>> {
        private int O00000o;
        private boolean O00000oO;
        private int O00000oo = 256;
        private int O0000O0o = 256;
        private int O0000OOo = 0;
        private List<O000000o> O0000Oo;
        private WeakReference<ca> O0000Oo0;
        private boolean O0000OoO;
        private WeakReference<O0000o00> O0000Ooo;
        private WeakReference<OOOo00> O0000o00;

        public O00000Oo(boolean z, ca caVar, int i, int i2, int i3, List<O000000o> list, boolean z2, O0000o00 o0000o00, OOOo00 oOOo00) {
            this.O00000oO = z;
            this.O0000Oo0 = new WeakReference(caVar);
            this.O00000oo = i;
            this.O0000O0o = i2;
            this.O0000OOo = i3;
            this.O0000Oo = list;
            this.O0000OoO = z2;
            this.O0000Ooo = new WeakReference(o0000o00);
            this.O0000o00 = new WeakReference(oOOo00);
        }

        /* Access modifiers changed, original: protected|varargs */
        public List<O000000o> O000000o(Void... voidArr) {
            try {
                ca caVar = (ca) this.O0000Oo0.get();
                if (caVar == null) {
                    return null;
                }
                int mapWidth = caVar.getMapWidth();
                int mapHeight = caVar.getMapHeight();
                this.O00000o = (int) caVar.O0000O0o();
                if (mapWidth > 0) {
                    if (mapHeight > 0) {
                        return OO00O0.O00000Oo(caVar, this.O00000o, this.O00000oo, this.O0000O0o, this.O0000OOo, (O0000o00) this.O0000Ooo.get(), (OOOo00) this.O0000o00.get());
                    }
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(List<O000000o> list) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        OO00O0.O00000Oo((ca) this.O0000Oo0.get(), list, this.O00000o, this.O00000oO, this.O0000Oo, this.O0000OoO, (O0000o00) this.O0000Ooo.get(), (OOOo00) this.O0000o00.get());
                        list.clear();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public OO00O0(TileOverlayOptions tileOverlayOptions, O0000o00 o0000o00, boolean z) {
        com.amap.api.mapcore.util.o0OOoOoo.O000000o o000000o;
        this.O00000Oo = o0000o00;
        this.O00000o0 = tileOverlayOptions.getTileProvider();
        this.O0000Oo0 = this.O00000o0.getTileWidth();
        this.O0000Oo = this.O00000o0.getTileHeight();
        this.O0000o = OOo000.O000000o(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
        this.O00000o = Float.valueOf(tileOverlayOptions.getZIndex());
        this.O00000oO = tileOverlayOptions.isVisible();
        this.O00000oo = z;
        if (this.O00000oo) {
            this.O0000o0o = "TileOverlay0";
        } else {
            this.O0000o0o = getId();
        }
        this.O0000O0o = this.O00000Oo.O000000o();
        this.O0000OoO = Integer.parseInt(this.O0000o0o.substring("TileOverlay".length()));
        if (z) {
            try {
                o000000o = new com.amap.api.mapcore.util.o0OOoOoo.O000000o(this.O00000Oo.O00000oO(), this.O0000o0o, o0000o00.O000000o().getMapConfig().getMapLanguage());
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        o000000o = new com.amap.api.mapcore.util.o0OOoOoo.O000000o(this.O00000Oo.O00000oO(), this.O0000o0o);
        o000000o.O000000o(tileOverlayOptions.getMemoryCacheEnabled());
        if (this.O00000oo) {
            o000000o.O0000Oo0 = false;
        }
        o000000o.O00000Oo(tileOverlayOptions.getDiskCacheEnabled());
        o000000o.O000000o(tileOverlayOptions.getMemCacheSize());
        o000000o.O000000o(tileOverlayOptions.getDiskCacheSize());
        String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
        if (!(diskCacheDir == null || "".equals(diskCacheDir))) {
            o000000o.O000000o(diskCacheDir);
        }
        this.O0000Ooo = new OOOo00(this.O00000Oo.O00000oO(), this.O0000Oo0, this.O0000Oo);
        this.O0000Ooo.O000000o(this.O00000o0);
        this.O0000Ooo.O000000o(o000000o);
        this.O0000Ooo.O000000o((O00000o0) new O00000o0() {
            public void O000000o() {
                OO00O0.this.O0000O0o.O0000o();
            }
        });
    }

    private void O000000o(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null && i != 0) {
            if (this.O000000o == null || this.O000000o.O00000o0()) {
                O00000oO();
            }
            this.O000000o.O000000o();
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glEnableVertexAttribArray(this.O000000o.O00000Oo);
            GLES20.glVertexAttribPointer(this.O000000o.O00000Oo, 3, 5126, false, 12, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.O000000o.O00000o0);
            GLES20.glVertexAttribPointer(this.O000000o.O00000o0, 2, 5126, false, 8, floatBuffer2);
            GLES20.glUniformMatrix4fv(this.O000000o.O000000o, 1, false, this.O00000Oo.O0000O0o(), 0);
            GLES20.glDrawArrays(6, 0, 4);
            GLES20.glDisableVertexAttribArray(this.O000000o.O00000Oo);
            GLES20.glDisableVertexAttribArray(this.O000000o.O00000o0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUseProgram(0);
            GLES20.glDisable(3042);
        }
    }

    private boolean O000000o(O000000o o000000o) {
        float f = (float) o000000o.O00000o0;
        int i = this.O0000Oo0;
        int i2 = this.O0000Oo;
        int i3 = o000000o.O00000oO.x;
        int i4 = 1 << (20 - ((int) f));
        i2 *= i4;
        int i5 = o000000o.O00000oO.y + i2;
        MapConfig mapConfig = this.O0000O0o.getMapConfig();
        r7 = new float[12];
        i4 = (i4 * i) + i3;
        r7[3] = (float) (i4 - mapConfig.getSX());
        r7[4] = (float) (i5 - mapConfig.getSY());
        r7[5] = 0.0f;
        r7[6] = (float) (i4 - mapConfig.getSX());
        i5 -= i2;
        r7[7] = (float) (i5 - mapConfig.getSY());
        r7[8] = 0.0f;
        r7[9] = (float) (i3 - mapConfig.getSX());
        r7[10] = (float) (i5 - mapConfig.getSY());
        r7[11] = 0.0f;
        if (o000000o.O0000OOo == null) {
            o000000o.O0000OOo = OOo000.O000000o(r7);
        } else {
            o000000o.O0000OOo = OOo000.O000000o(r7, o000000o.O0000OOo);
        }
        return true;
    }

    private static String O00000Oo(String str) {
        O0000OOo++;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(O0000OOo);
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x017c  */
    private static java.util.ArrayList<com.amap.api.mapcore.util.OO00O0.O000000o> O00000Oo(com.amap.api.mapcore.util.ca r29, int r30, int r31, int r32, int r33, com.amap.api.mapcore.util.O0000o00 r34, com.amap.api.mapcore.util.OOOo00 r35) {
        /*
        r2 = r29.O00000o0();
        r3 = r29.getMapConfig();
        r3 = r3.getGeoRectangle();
        r3 = r3.getRect();
        r4 = com.autonavi.amap.mapcore.IPoint.obtain();
        r5 = com.autonavi.amap.mapcore.IPoint.obtain();
        r6 = r3.left;
        r4.x = r6;
        r6 = r3.top;
        r4.y = r6;
        r6 = r4.x;
        r7 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r6 = java.lang.Math.min(r7, r6);
        r8 = r4.x;
        r9 = 0;
        r8 = java.lang.Math.max(r9, r8);
        r10 = r4.y;
        r7 = java.lang.Math.min(r7, r10);
        r10 = r4.y;
        r10 = java.lang.Math.max(r9, r10);
        r11 = r3.right;
        r4.x = r11;
        r11 = r3.top;
        r4.y = r11;
        r11 = r4.x;
        r6 = java.lang.Math.min(r6, r11);
        r11 = r4.x;
        r8 = java.lang.Math.max(r8, r11);
        r11 = r4.y;
        r7 = java.lang.Math.min(r7, r11);
        r11 = r4.y;
        r10 = java.lang.Math.max(r10, r11);
        r11 = r3.left;
        r4.x = r11;
        r11 = r3.bottom;
        r4.y = r11;
        r11 = r4.x;
        r6 = java.lang.Math.min(r6, r11);
        r11 = r4.x;
        r8 = java.lang.Math.max(r8, r11);
        r11 = r4.y;
        r7 = java.lang.Math.min(r7, r11);
        r11 = r4.y;
        r10 = java.lang.Math.max(r10, r11);
        r11 = r3.right;
        r4.x = r11;
        r3 = r3.bottom;
        r4.y = r3;
        r3 = r4.x;
        r3 = java.lang.Math.min(r6, r3);
        r6 = r4.x;
        r6 = java.lang.Math.max(r8, r6);
        r8 = r4.y;
        r7 = java.lang.Math.min(r7, r8);
        r8 = r4.y;
        r8 = java.lang.Math.max(r10, r8);
        r18 = 20 - r30;
        r19 = 1;
        r10 = r19 << r18;
        r11 = r10 * r31;
        r3 = r3 - r11;
        r10 = r10 * r32;
        r7 = r7 - r10;
        r2.getMapGeoCenter(r5);
        r2 = r5.x;
        r2 = r2 >> r18;
        r2 = r2 / r31;
        r10 = r5.y;
        r10 = r10 >> r18;
        r20 = r10 / r32;
        r10 = r2 << r18;
        r15 = r10 * r31;
        r10 = r20 << r18;
        r14 = r10 * r32;
        r13 = new com.amap.api.mapcore.util.OO00O0$O000000o;
        r10 = r13;
        r11 = r2;
        r12 = r20;
        r9 = r13;
        r13 = r30;
        r21 = r7;
        r7 = r14;
        r14 = r33;
        r22 = r8;
        r8 = r15;
        r15 = r29;
        r16 = r34;
        r17 = r35;
        r10.<init>(r11, r12, r13, r14, r15, r16, r17);
        r7 = com.autonavi.amap.mapcore.IPoint.obtain(r8, r7);
        r9.O00000oO = r7;
        r4.recycle();
        r5.recycle();
        r4 = new java.util.ArrayList;
        r4.<init>();
        r4.add(r9);
        r5 = r19;
    L_0x00ef:
        r7 = r2 - r5;
        r8 = r7;
        r9 = 0;
    L_0x00f3:
        r15 = r2 + r5;
        if (r8 > r15) goto L_0x01a2;
    L_0x00f7:
        r12 = r20 + r5;
        r15 = new com.autonavi.amap.mapcore.IPoint;
        r10 = r8 << r18;
        r14 = r10 * r31;
        r10 = r12 << r18;
        r10 = r10 * r32;
        r15.<init>(r14, r10);
        r10 = r15.x;
        if (r10 >= r6) goto L_0x0153;
    L_0x010a:
        r10 = r15.x;
        if (r10 <= r3) goto L_0x0153;
    L_0x010e:
        r10 = r15.y;
        r13 = r22;
        if (r10 >= r13) goto L_0x0149;
    L_0x0114:
        r10 = r15.y;
        r11 = r21;
        if (r10 <= r11) goto L_0x0140;
    L_0x011a:
        if (r9 != 0) goto L_0x011e;
    L_0x011c:
        r9 = r19;
    L_0x011e:
        r10 = new com.amap.api.mapcore.util.OO00O0$O000000o;
        r23 = r10;
        r24 = r2;
        r2 = r11;
        r11 = r8;
        r25 = r9;
        r9 = r13;
        r13 = r30;
        r26 = r7;
        r7 = r14;
        r14 = r33;
        r0 = r15;
        r15 = r29;
        r16 = r34;
        r17 = r35;
        r10.<init>(r11, r12, r13, r14, r15, r16, r17);
        r10.O00000oO = r0;
        r4.add(r10);
        goto L_0x015f;
    L_0x0140:
        r24 = r2;
        r26 = r7;
        r0 = r9;
        r2 = r11;
        r9 = r13;
        r7 = r14;
        goto L_0x015d;
    L_0x0149:
        r24 = r2;
        r26 = r7;
        r0 = r9;
        r9 = r13;
        r7 = r14;
        r2 = r21;
        goto L_0x015d;
    L_0x0153:
        r24 = r2;
        r26 = r7;
        r0 = r9;
        r7 = r14;
        r2 = r21;
        r9 = r22;
    L_0x015d:
        r25 = r0;
    L_0x015f:
        r12 = r20 - r5;
        r0 = new com.autonavi.amap.mapcore.IPoint;
        r10 = r12 << r18;
        r10 = r10 * r32;
        r0.<init>(r7, r10);
        r7 = r0.x;
        if (r7 >= r6) goto L_0x0194;
    L_0x016e:
        r7 = r0.x;
        if (r7 <= r3) goto L_0x0194;
    L_0x0172:
        r7 = r0.y;
        if (r7 >= r9) goto L_0x0194;
    L_0x0176:
        r7 = r0.y;
        if (r7 <= r2) goto L_0x0194;
    L_0x017a:
        if (r25 != 0) goto L_0x017e;
    L_0x017c:
        r25 = r19;
    L_0x017e:
        r7 = new com.amap.api.mapcore.util.OO00O0$O000000o;
        r10 = r7;
        r11 = r8;
        r13 = r30;
        r14 = r33;
        r15 = r29;
        r16 = r34;
        r17 = r35;
        r10.<init>(r11, r12, r13, r14, r15, r16, r17);
        r7.O00000oO = r0;
        r4.add(r7);
    L_0x0194:
        r8 = r8 + 1;
        r21 = r2;
        r22 = r9;
        r2 = r24;
        r9 = r25;
        r7 = r26;
        goto L_0x00f3;
    L_0x01a2:
        r24 = r2;
        r26 = r7;
        r0 = r9;
        r2 = r21;
        r9 = r22;
        r7 = r20 + r5;
        r7 = r7 + -1;
    L_0x01af:
        r8 = r20 - r5;
        if (r7 <= r8) goto L_0x0234;
    L_0x01b3:
        r8 = new com.autonavi.amap.mapcore.IPoint;
        r10 = r15 << r18;
        r10 = r10 * r31;
        r11 = r7 << r18;
        r14 = r11 * r32;
        r8.<init>(r10, r14);
        r10 = r8.x;
        if (r10 >= r6) goto L_0x01f2;
    L_0x01c4:
        r10 = r8.x;
        if (r10 <= r3) goto L_0x01f2;
    L_0x01c8:
        r10 = r8.y;
        if (r10 >= r9) goto L_0x01f2;
    L_0x01cc:
        r10 = r8.y;
        if (r10 <= r2) goto L_0x01f2;
    L_0x01d0:
        if (r0 != 0) goto L_0x01d4;
    L_0x01d2:
        r0 = r19;
    L_0x01d4:
        r13 = new com.amap.api.mapcore.util.OO00O0$O000000o;
        r10 = r13;
        r11 = r15;
        r12 = r7;
        r27 = r0;
        r0 = r13;
        r13 = r30;
        r1 = r14;
        r14 = r33;
        r22 = r15;
        r15 = r29;
        r16 = r34;
        r17 = r35;
        r10.<init>(r11, r12, r13, r14, r15, r16, r17);
        r0.O00000oO = r8;
        r4.add(r0);
        goto L_0x01f7;
    L_0x01f2:
        r1 = r14;
        r22 = r15;
        r27 = r0;
    L_0x01f7:
        r0 = new com.autonavi.amap.mapcore.IPoint;
        r8 = r26 << r18;
        r8 = r8 * r31;
        r0.<init>(r8, r1);
        r1 = r0.x;
        if (r1 >= r6) goto L_0x022c;
    L_0x0204:
        r1 = r0.x;
        if (r1 <= r3) goto L_0x022c;
    L_0x0208:
        r1 = r0.y;
        if (r1 >= r9) goto L_0x022c;
    L_0x020c:
        r1 = r0.y;
        if (r1 <= r2) goto L_0x022c;
    L_0x0210:
        if (r27 != 0) goto L_0x0214;
    L_0x0212:
        r27 = r19;
    L_0x0214:
        r1 = new com.amap.api.mapcore.util.OO00O0$O000000o;
        r10 = r1;
        r11 = r26;
        r12 = r7;
        r13 = r30;
        r14 = r33;
        r15 = r29;
        r16 = r34;
        r17 = r35;
        r10.<init>(r11, r12, r13, r14, r15, r16, r17);
        r1.O00000oO = r0;
        r4.add(r1);
    L_0x022c:
        r0 = r27;
        r7 = r7 + -1;
        r15 = r22;
        goto L_0x01af;
    L_0x0234:
        if (r0 != 0) goto L_0x0237;
    L_0x0236:
        return r4;
    L_0x0237:
        r5 = r5 + 1;
        r21 = r2;
        r22 = r9;
        r2 = r24;
        goto L_0x00ef;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.OO00O0.O00000Oo(com.amap.api.mapcore.util.ca, int, int, int, int, com.amap.api.mapcore.util.O0000o00, com.amap.api.mapcore.util.OOOo00):java.util.ArrayList");
    }

    private static boolean O00000Oo(ca caVar, List<O000000o> list, int i, boolean z, List<O000000o> list2, boolean z2, O0000o00 o0000o00, OOOo00 oOOo00) {
        int i2 = 0;
        if (list == null || list2 == null) {
            return false;
        }
        synchronized (list2) {
            Iterator it = list2.iterator();
            while (true) {
                boolean z3 = true;
                if (!it.hasNext()) {
                    break;
                }
                O000000o o000000o = (O000000o) it.next();
                for (O000000o o000000o2 : list) {
                    if (o000000o.equals(o000000o2) && o000000o.O0000O0o) {
                        o000000o2.O0000O0o = o000000o.O0000O0o;
                        o000000o2.O00000oo = o000000o.O00000oo;
                        break;
                    }
                }
                z3 = false;
                if (!z3) {
                    o000000o.O00000Oo();
                }
            }
            list2.clear();
        }
        if (i > ((int) caVar.getMaxZoomLevel()) || i < ((int) caVar.getMinZoomLevel())) {
            return false;
        }
        int size = list.size();
        if (size <= 0) {
            return false;
        }
        while (i2 < size) {
            O000000o o000000o3 = (O000000o) list.get(i2);
            if (o000000o3 != null) {
                if (z2) {
                    if (o0000o00.O000000o().getMapConfig().getMapLanguage().equals("zh_cn")) {
                        if (MapsInitializer.isLoadWorldGridMap()) {
                            if (o000000o3.O00000o0 >= 7) {
                                if (OOOO0O.O000000o(o000000o3.O000000o, o000000o3.O00000Oo, o000000o3.O00000o0)) {
                                }
                            }
                        }
                    } else if (!(MapsInitializer.isLoadWorldGridMap() || o000000o3.O00000o0 < 7 || OOOO0O.O000000o(o000000o3.O000000o, o000000o3.O00000Oo, o000000o3.O00000o0))) {
                    }
                }
                list2.add(o000000o3);
                if (!(o000000o3.O0000O0o || oOOo00 == null)) {
                    oOOo00.O000000o(z, o000000o3);
                }
            }
            i2++;
        }
        return true;
    }

    private void O00000o() {
        if (this.O0000o0O != null && this.O0000o0O.O000000o() == O0000O0o.RUNNING) {
            this.O0000o0O.O000000o(true);
        }
    }

    private void O00000o0(boolean z) {
        this.O0000o0O = new O00000Oo(z, this.O0000O0o, this.O0000Oo0, this.O0000Oo, this.O0000OoO, this.O0000o00, this.O00000oo, this.O00000Oo, this.O0000Ooo);
        this.O0000o0O.O00000o0((Object[]) new Void[0]);
    }

    private void O00000oO() {
        if (this.O00000Oo != null && this.O00000Oo.O000000o() != null) {
            this.O000000o = (O0000OOo) this.O00000Oo.O000000o().O0000oOo(0);
        }
    }

    public void O000000o() {
        if (this.O0000o00 != null) {
            synchronized (this.O0000o00) {
                if (this.O0000o00.size() == 0) {
                    return;
                }
                int size = this.O0000o00.size();
                for (int i = 0; i < size; i++) {
                    O000000o o000000o = (O000000o) this.O0000o00.get(i);
                    if (!o000000o.O0000O0o) {
                        try {
                            IPoint iPoint = o000000o.O00000oO;
                            if (!(o000000o.O0000Oo0 == null || o000000o.O0000Oo0.isRecycled() || iPoint == null)) {
                                o000000o.O00000oo = OOo000.O000000o(o000000o.O0000Oo0);
                                if (o000000o.O00000oo != 0) {
                                    o000000o.O0000O0o = true;
                                }
                                o000000o.O0000Oo0 = null;
                            }
                        } catch (Throwable th) {
                            ooOOOOoo.O00000o0(th, "TileOverlayDelegateImp", "drawTiles");
                        }
                    }
                    if (o000000o.O0000O0o) {
                        O000000o(o000000o);
                        O000000o(o000000o.O00000oo, o000000o.O0000OOo, this.O0000o);
                    }
                }
            }
        }
    }

    public void O000000o(String str) {
        O00000o();
        O00000Oo();
        if (this.O0000Ooo != null) {
            this.O0000Ooo.O000000o(true);
            this.O0000Ooo.O000000o(str);
            this.O0000Ooo.O000000o(false);
        }
        O00000o0(true);
    }

    public void O000000o(boolean z) {
        if (!this.O0000o0) {
            O00000o();
            O00000o0(z);
        }
    }

    public void O00000Oo() {
        if (this.O0000o00 != null) {
            synchronized (this.O0000o00) {
                this.O0000o00.clear();
            }
        }
    }

    public void O00000Oo(boolean z) {
        if (this.O0000o0 != z) {
            this.O0000o0 = z;
            if (this.O0000Ooo != null) {
                this.O0000Ooo.O000000o(z);
            }
        }
    }

    public void O00000o0() {
        O00000o();
        synchronized (this.O0000o00) {
            int size = this.O0000o00.size();
            for (int i = 0; i < size; i++) {
                ((O000000o) this.O0000o00.get(i)).O00000Oo();
            }
            this.O0000o00.clear();
        }
    }

    public void clearTileCache() {
        if (this.O0000Ooo != null) {
            this.O0000Ooo.O00000oo();
        }
    }

    public void destroy(boolean z) {
        O00000o();
        synchronized (this.O0000o00) {
            int size = this.O0000o00.size();
            for (int i = 0; i < size; i++) {
                ((O000000o) this.O0000o00.get(i)).O00000Oo();
            }
            this.O0000o00.clear();
        }
        if (this.O0000Ooo != null) {
            this.O0000Ooo.O00000o0(z);
            this.O0000Ooo.O000000o(true);
            this.O0000Ooo.O000000o(null);
        }
    }

    public boolean equalsRemote(ITileOverlay iTileOverlay) {
        return equals(iTileOverlay) || iTileOverlay.getId().equals(getId());
    }

    public String getId() {
        if (this.O0000o0o == null) {
            this.O0000o0o = O00000Oo("TileOverlay");
        }
        return this.O0000o0o;
    }

    public float getZIndex() {
        return this.O00000o.floatValue();
    }

    public int hashCodeRemote() {
        return super.hashCode();
    }

    public boolean isVisible() {
        return this.O00000oO;
    }

    public void remove() {
        this.O00000Oo.O00000Oo((O0o) this);
        this.O0000O0o.setRunLowFrame(false);
    }

    public void setVisible(boolean z) {
        this.O00000oO = z;
        this.O0000O0o.setRunLowFrame(false);
        if (z) {
            O000000o(true);
        }
    }

    public void setZIndex(float f) {
        this.O00000o = Float.valueOf(f);
        this.O00000Oo.O00000o();
    }
}
