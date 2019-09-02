package com.amap.api.mapcore.util;

import android.graphics.Rect;
import android.opengl.Matrix;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: MultiPointOverlayDelegate */
public class O00O00Oo implements IMultiPointOverlay {
    private static int O00oOoOo;
    BitmapDescriptor O000000o = BitmapDescriptorFactory.defaultMarker();
    BitmapDescriptor O00000Oo = null;
    float O00000o = 0.0f;
    float O00000o0 = 0.0f;
    float O00000oO = 0.0f;
    float O00000oo = 0.5f;
    float O0000O0o = 0.5f;
    List<MultiPointItem> O0000OOo;
    O00O000o O0000Oo = null;
    O00O00o O0000Oo0 = null;
    O00O000o O0000OoO = new O00O000o(0, 1, 0, 1);
    List<MultiPointItem> O0000Ooo = new ArrayList();
    float[] O0000o = new float[4];
    O00O00o0 O0000o0;
    IPoint O0000o00;
    List<oooOoO> O0000o0O = new ArrayList();
    float[] O0000o0o = new float[16];
    Rect O0000oO = new Rect();
    float[] O0000oO0 = new float[4];
    O00O000o O0000oOO = null;
    O00O000o O0000oOo = null;
    int O0000oo = 0;
    int O0000oo0 = 0;
    float[] O0000ooO = new float[12];
    String O0000ooo = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
    private String O000O00o;
    private float[] O000O0OO = new float[]{-0.5f, -0.5f, 0.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f, -0.5f, 0.0f, 0.0f, 1.0f, 0.0f};
    private boolean O000O0Oo = true;
    private List<String> O000O0o = new ArrayList();
    private ExecutorService O000O0o0 = null;
    private float[] O000O0oO = new float[(oooOoO.O000000o * 3)];
    String O00oOooO = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(0,0,1,1.0);\n}";
    int O00oOooo = -1;

    public O00O00Oo(MultiPointOverlayOptions multiPointOverlayOptions, O00O00o0 o00O00o0) {
        this.O0000o0 = o00O00o0;
        O000000o(multiPointOverlayOptions);
        oooOoO oooooo = new oooOoO(O000000o(), this);
        oooooo.O000000o(o00O00o0.O000000o());
        oooooo.O000000o(this.O00000Oo);
        this.O0000o0O.add(oooooo);
    }

    private static String O000000o(String str) {
        O00oOoOo++;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(O00oOoOo);
        return stringBuilder.toString();
    }

    private void O000000o(float f, float f2, float f3, float f4) {
        float f5 = f;
        float f6 = f2;
        if (this.O0000OoO == null) {
            this.O0000OoO = new O00O000o(0, 1, 0, 1);
        }
        this.O0000oO.set(0, 0, 0, 0);
        IPoint iPoint = new IPoint();
        float f7 = this.O00000oo;
        float f8 = this.O0000O0o;
        Matrix.setIdentityM(this.O0000o0o, 0);
        Matrix.rotateM(this.O0000o0o, 0, -f3, 0.0f, 0.0f, 1.0f);
        this.O0000oO0[0] = 0.0f;
        this.O0000oO0[1] = 0.0f;
        this.O0000oO0[2] = 0.0f;
        this.O0000oO0[3] = 0.0f;
        float f9 = (-f5) * f7;
        this.O0000o[0] = f9;
        float f10 = f6 * f8;
        this.O0000o[1] = f10;
        this.O0000o[2] = 0.0f;
        this.O0000o[3] = 1.0f;
        Matrix.multiplyMV(this.O0000oO0, 0, this.O0000o0o, 0, this.O0000o, 0);
        this.O0000oO.set((int) (((float) iPoint.x) + this.O0000oO0[0]), (int) (((float) iPoint.y) - this.O0000oO0[1]), (int) (((float) iPoint.x) + this.O0000oO0[0]), (int) (((float) iPoint.y) - this.O0000oO0[1]));
        f5 *= 1.0f - f7;
        this.O0000o[0] = f5;
        this.O0000o[1] = f10;
        this.O0000o[2] = 0.0f;
        this.O0000o[3] = 1.0f;
        Matrix.multiplyMV(this.O0000oO0, 0, this.O0000o0o, 0, this.O0000o, 0);
        this.O0000oO.union((int) (((float) iPoint.x) + this.O0000oO0[0]), (int) (((float) iPoint.y) - this.O0000oO0[1]));
        this.O0000o[0] = f5;
        f6 = (-f6) * (1.0f - f8);
        this.O0000o[1] = f6;
        this.O0000o[2] = 0.0f;
        this.O0000o[3] = 1.0f;
        Matrix.multiplyMV(this.O0000oO0, 0, this.O0000o0o, 0, this.O0000o, 0);
        this.O0000oO.union((int) (((float) iPoint.x) + this.O0000oO0[0]), (int) (((float) iPoint.y) - this.O0000oO0[1]));
        this.O0000o[0] = f9;
        this.O0000o[1] = f6;
        this.O0000o[2] = 0.0f;
        this.O0000o[3] = 1.0f;
        Matrix.multiplyMV(this.O0000oO0, 0, this.O0000o0o, 0, this.O0000o, 0);
        this.O0000oO.union((int) (((float) iPoint.x) + this.O0000oO0[0]), (int) (((float) iPoint.y) - this.O0000oO0[1]));
        this.O0000OoO.O000000o(this.O0000oO.left, this.O0000oO.right, this.O0000oO.top, this.O0000oO.bottom);
    }

    private void O000000o(MultiPointOverlayOptions multiPointOverlayOptions) {
        if (multiPointOverlayOptions != null) {
            if (multiPointOverlayOptions.getIcon() == null || multiPointOverlayOptions.getIcon().getBitmap() == null || multiPointOverlayOptions.getIcon().getBitmap().isRecycled()) {
                this.O00000Oo = this.O000000o;
            } else {
                this.O00000Oo = multiPointOverlayOptions.getIcon();
            }
            this.O00000oo = multiPointOverlayOptions.getAnchorU();
            this.O0000O0o = multiPointOverlayOptions.getAnchorV();
        }
    }

    private void O000000o(MapConfig mapConfig) {
        if (mapConfig != null) {
            Rect rect = mapConfig.getGeoRectangle().getRect();
            if (this.O0000Oo == null) {
                this.O0000Oo = new O00O000o(rect.left, rect.right, rect.top, rect.bottom);
            } else {
                this.O0000Oo.O000000o(rect.left, rect.right, rect.top, rect.bottom);
            }
        }
    }

    private float[] O000000o() {
        if (this.O000O0OO == null) {
            return null;
        }
        float[] fArr = (float[]) this.O000O0OO.clone();
        float f = this.O00000oo - 0.5f;
        float f2 = this.O0000O0o - 0.5f;
        fArr[0] = fArr[0] + f;
        fArr[1] = fArr[1] - f2;
        fArr[6] = fArr[6] + f;
        fArr[7] = fArr[7] - f2;
        fArr[12] = fArr[12] + f;
        fArr[13] = fArr[13] - f2;
        fArr[18] = fArr[18] + f;
        fArr[19] = fArr[19] - f2;
        return fArr;
    }

    private O00O000o O00000Oo() {
        if (this.O0000OOo == null || this.O0000OOo.size() == 0) {
            return null;
        }
        Iterator it = this.O0000OOo.iterator();
        MultiPointItem multiPointItem = (MultiPointItem) it.next();
        int i = multiPointItem.getIPoint().x;
        int i2 = multiPointItem.getIPoint().x;
        int i3 = multiPointItem.getIPoint().y;
        int i4 = multiPointItem.getIPoint().y;
        while (it.hasNext()) {
            MultiPointItem multiPointItem2 = (MultiPointItem) it.next();
            int i5 = multiPointItem2.getIPoint().x;
            int i6 = multiPointItem2.getIPoint().y;
            if (i5 < i) {
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
            if (i6 < i3) {
                i3 = i6;
            }
            if (i6 > i4) {
                i4 = i6;
            }
        }
        return new O00O000o(i, i2, i3, i4);
    }

    private void O00000o() {
        if (this.O0000o0 != null) {
            this.O0000o0.O00000o();
        }
    }

    private void O00000o0() {
        if (this.O000O0o0 == null) {
            long j = (long) 1;
            this.O000O0o0 = new ThreadPoolExecutor(1, 2, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), new OOO0o00("MultiPointOverlay"), new AbortPolicy());
        }
        for (final oooOoO oooooo : this.O0000o0O) {
            if (!(oooooo == null || oooooo.O00000Oo())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(oooooo.hashCode());
                stringBuilder.append("");
                final String stringBuilder2 = stringBuilder.toString();
                if (!this.O000O0o.contains(stringBuilder2)) {
                    this.O000O0o.add(stringBuilder2);
                    this.O000O0o0.execute(new Runnable() {
                        public void run() {
                            if (!oooooo.O00000Oo()) {
                                oooooo.O000000o();
                                O00O00Oo.this.O000O0o.remove(stringBuilder2);
                            }
                        }
                    });
                }
            }
        }
    }

    public void addItem(MultiPointItem multiPointItem) {
        O00000o();
    }

    /* JADX WARNING: Missing block: B:43:?, code skipped:
            O00000o();
     */
    public void addItems(java.util.List<com.amap.api.maps.model.MultiPointItem> r9) {
        /*
        r8 = this;
        if (r9 == 0) goto L_0x00aa;
    L_0x0002:
        r0 = r9.size();	 Catch:{ Throwable -> 0x00a1 }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x00aa;
    L_0x000a:
        monitor-enter(r8);	 Catch:{ Throwable -> 0x00a1 }
        r0 = r8.O0000OOo;	 Catch:{ all -> 0x009e }
        if (r0 != 0) goto L_0x0016;
    L_0x000f:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x009e }
        r0.<init>();	 Catch:{ all -> 0x009e }
        r8.O0000OOo = r0;	 Catch:{ all -> 0x009e }
    L_0x0016:
        r0 = r8.O0000OOo;	 Catch:{ all -> 0x009e }
        r0.clear();	 Catch:{ all -> 0x009e }
        r0 = r8.O0000OOo;	 Catch:{ all -> 0x009e }
        r0.addAll(r9);	 Catch:{ all -> 0x009e }
        r9 = r8.O0000OOo;	 Catch:{ all -> 0x009e }
        r9 = r9.size();	 Catch:{ all -> 0x009e }
        r0 = 0;
        r1 = r0;
    L_0x0028:
        if (r1 >= r9) goto L_0x0060;
    L_0x002a:
        r2 = r8.O0000OOo;	 Catch:{ all -> 0x009e }
        if (r2 != 0) goto L_0x0030;
    L_0x002e:
        monitor-exit(r8);	 Catch:{ all -> 0x009e }
        return;
    L_0x0030:
        r2 = r8.O0000OOo;	 Catch:{ all -> 0x009e }
        r2 = r2.get(r1);	 Catch:{ all -> 0x009e }
        r2 = (com.amap.api.maps.model.MultiPointItem) r2;	 Catch:{ all -> 0x009e }
        if (r2 == 0) goto L_0x005d;
    L_0x003a:
        r3 = r2.getLatLng();	 Catch:{ all -> 0x009e }
        if (r3 == 0) goto L_0x005d;
    L_0x0040:
        r3 = r2.getIPoint();	 Catch:{ all -> 0x009e }
        if (r3 != 0) goto L_0x005d;
    L_0x0046:
        r3 = new com.autonavi.amap.mapcore.IPoint;	 Catch:{ all -> 0x009e }
        r3.<init>();	 Catch:{ all -> 0x009e }
        r4 = r2.getLatLng();	 Catch:{ all -> 0x009e }
        r4 = r4.longitude;	 Catch:{ all -> 0x009e }
        r6 = r2.getLatLng();	 Catch:{ all -> 0x009e }
        r6 = r6.latitude;	 Catch:{ all -> 0x009e }
        com.autonavi.amap.mapcore.MapProjection.lonlat2Geo(r4, r6, r3);	 Catch:{ all -> 0x009e }
        r2.setIPoint(r3);	 Catch:{ all -> 0x009e }
    L_0x005d:
        r1 = r1 + 1;
        goto L_0x0028;
    L_0x0060:
        r9 = r8.O0000Oo0;	 Catch:{ all -> 0x009e }
        if (r9 != 0) goto L_0x0071;
    L_0x0064:
        r9 = r8.O00000Oo();	 Catch:{ all -> 0x009e }
        if (r9 == 0) goto L_0x0071;
    L_0x006a:
        r1 = new com.amap.api.mapcore.util.O00O00o;	 Catch:{ all -> 0x009e }
        r1.<init>(r9);	 Catch:{ all -> 0x009e }
        r8.O0000Oo0 = r1;	 Catch:{ all -> 0x009e }
    L_0x0071:
        r9 = r8.O0000OOo;	 Catch:{ all -> 0x009e }
        if (r9 == 0) goto L_0x0099;
    L_0x0075:
        r9 = r8.O0000OOo;	 Catch:{ all -> 0x009e }
        r9 = r9.size();	 Catch:{ all -> 0x009e }
    L_0x007b:
        if (r0 >= r9) goto L_0x0099;
    L_0x007d:
        r1 = r8.O0000OOo;	 Catch:{ all -> 0x009e }
        r1 = r1.get(r0);	 Catch:{ all -> 0x009e }
        r1 = (com.amap.api.maps.model.MultiPointItem) r1;	 Catch:{ all -> 0x009e }
        if (r1 == 0) goto L_0x0096;
    L_0x0087:
        r2 = r1.getIPoint();	 Catch:{ all -> 0x009e }
        if (r2 == 0) goto L_0x0096;
    L_0x008d:
        r2 = r8.O0000Oo0;	 Catch:{ all -> 0x009e }
        if (r2 == 0) goto L_0x0096;
    L_0x0091:
        r2 = r8.O0000Oo0;	 Catch:{ all -> 0x009e }
        r2.O000000o(r1);	 Catch:{ all -> 0x009e }
    L_0x0096:
        r0 = r0 + 1;
        goto L_0x007b;
    L_0x0099:
        monitor-exit(r8);	 Catch:{ all -> 0x009e }
        r8.O00000o();	 Catch:{ Throwable -> 0x00a1 }
        goto L_0x00a9;
    L_0x009e:
        r9 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x009e }
        throw r9;	 Catch:{ Throwable -> 0x00a1 }
    L_0x00a1:
        r9 = move-exception;
        r0 = "MultiPointOverlayDelegate";
        r1 = "addItems";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r9, r0, r1);
    L_0x00a9:
        return;
    L_0x00aa:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00O00Oo.addItems(java.util.List):void");
    }

    public void destroy(boolean z) {
        remove(z);
        if (this.O00000Oo != null) {
            this.O00000Oo.recycle();
        }
    }

    public void draw(MapConfig mapConfig, float[] fArr, float[] fArr2) {
        Throwable th;
        int i;
        Throwable th2;
        try {
            if (this.O000O0Oo) {
                O00000o0();
                int i2 = 1;
                if (this.O0000o0O.size() >= 1 && this.O0000Oo0 != null && mapConfig != null) {
                    float sr = mapConfig.getSR();
                    float sc = mapConfig.getSC();
                    if (mapConfig.getChangeRatio() != 1.0d || this.O0000Ooo.size() == 0) {
                        synchronized (this.O0000Ooo) {
                            O000000o(mapConfig);
                            this.O0000Ooo.clear();
                            this.O00000o0 = mapConfig.getMapPerPixelUnitLength();
                            this.O00000o = this.O00000o0 * ((float) this.O00000Oo.getWidth());
                            this.O00000oO = this.O00000o0 * ((float) this.O00000Oo.getHeight());
                            double d = (double) ((this.O00000o * this.O00000oO) * 16.0f);
                            O000000o(this.O00000o, this.O00000oO, sr, sc);
                            this.O0000Oo0.O000000o(this.O0000Oo, this.O0000Ooo, d);
                        }
                    }
                    if (this.O0000o00 == null) {
                        this.O0000o00 = new IPoint();
                    }
                    if (!(this.O0000o00 == null || mapConfig == null)) {
                        this.O0000o00.x = mapConfig.getSX();
                        this.O0000o00.y = mapConfig.getSY();
                    }
                    i = 0;
                    th2 = (oooOoO) this.O0000o0O.get(0);
                    List list = this.O0000Ooo;
                    synchronized (list) {
                        List list2;
                        try {
                            int i3;
                            Iterator it = this.O0000Ooo.iterator();
                            while (it.hasNext()) {
                                IPoint iPoint = ((MultiPointItem) it.next()).getIPoint();
                                if (iPoint != null) {
                                    Iterator it2;
                                    int i4 = iPoint.x - this.O0000o00.x;
                                    int i5 = iPoint.y - this.O0000o00.y;
                                    if (th2 != null && th2.O00000Oo()) {
                                        if (!th2.O00000o()) {
                                            try {
                                                if (this.O0000o0 != null) {
                                                    th2.O000000o(this.O0000o0.O000000o());
                                                }
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                list2 = list;
                                                throw th2;
                                            }
                                        }
                                        int i6 = i3 * 3;
                                        this.O000O0oO[i + i6] = (float) i4;
                                        this.O000O0oO[i2 + i6] = (float) i5;
                                        this.O000O0oO[2 + i6] = 0.0f;
                                        int i7 = i3 + 1;
                                        if (i7 >= oooOoO.O000000o) {
                                            i3 = i7;
                                            it2 = it;
                                            it = sc;
                                            list2 = list;
                                            list = i3;
                                            try {
                                                th2.O000000o(fArr, fArr2, this.O000O0oO, this.O00000o, this.O00000oO, sr, it, list);
                                                i3 = i;
                                                it = it2;
                                                list = list2;
                                            } catch (Throwable th4) {
                                                th3 = th4;
                                                th2 = th3;
                                                throw th2;
                                            }
                                        } else {
                                            i3 = i7;
                                        }
                                    }
                                    it2 = it;
                                    list2 = list;
                                    it = it2;
                                    list = list2;
                                }
                            }
                            if (i3 > 0) {
                                it = sc;
                                list = i3;
                                th2.O000000o(fArr, fArr2, this.O000O0oO, this.O00000o, this.O00000oO, sr, it, list);
                            }
                        } catch (Throwable th5) {
                            th3 = th5;
                            list2 = list;
                            th2 = th3;
                            throw th2;
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            ooOOOOoo.O00000o0(th2, "MultiPointOverlayDelegate", "draw");
        } finally {
            th2 = 
/*
Method generation error in method: com.amap.api.mapcore.util.O00O00Oo.draw(com.autonavi.amap.mapcore.MapConfig, float[], float[]):void, dex: 
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0156: MERGE  (r2_8 'th2' java.lang.Throwable) = (r0_7 'th6' int), (r15_7 'i' int) in method: com.amap.api.mapcore.util.O00O00Oo.draw(com.autonavi.amap.mapcore.MapConfig, float[], float[]):void, dex: 
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 21 more

*/

    public String getId() throws RemoteException {
        if (this.O000O00o == null) {
            this.O000O00o = O000000o("MultiPointOverlay");
        }
        return this.O000O00o;
    }

    public MultiPointItem onClick(IPoint iPoint) {
        if (!this.O000O0Oo || this.O0000Oo0 == null) {
            return null;
        }
        if (this.O0000oOO == null) {
            this.O0000oOO = new O00O000o(0, 1, 0, 1);
        }
        int i = (int) (this.O00000o0 * 8.0f);
        this.O0000oOO.O000000o(iPoint.x - i, iPoint.x + i, iPoint.y - i, iPoint.y + i);
        synchronized (this.O0000Ooo) {
            for (i = this.O0000Ooo.size() - 1; i >= 0; i--) {
                MultiPointItem multiPointItem = (MultiPointItem) this.O0000Ooo.get(i);
                IPoint iPoint2 = multiPointItem.getIPoint();
                if (iPoint2 != null) {
                    if (this.O0000OoO == null) {
                        return null;
                    }
                    if (this.O0000oOo == null) {
                        this.O0000oOo = new O00O000o(0, 1, 0, 1);
                    }
                    this.O0000oOo.O000000o(iPoint2.x + this.O0000OoO.O000000o, iPoint2.x + this.O0000OoO.O00000o0, iPoint2.y + this.O0000OoO.O00000Oo, iPoint2.y + this.O0000OoO.O00000o);
                    if (this.O0000oOo.O000000o(this.O0000oOO)) {
                        return multiPointItem;
                    }
                }
            }
            return null;
        }
    }

    public void remove(boolean z) {
        this.O000O0Oo = false;
        this.O0000oo0 = 0;
        this.O0000oo = 0;
        if (this.O000000o != null) {
            this.O000000o.recycle();
        }
        synchronized (this) {
            if (this.O0000OOo != null) {
                this.O0000OOo.clear();
                this.O0000OOo = null;
            }
        }
        if (this.O0000Oo0 != null) {
            this.O0000Oo0.O000000o();
            this.O0000Oo0 = null;
        }
        if (this.O0000Ooo != null) {
            this.O0000Ooo.clear();
        }
        if (this.O000O0o0 != null) {
            this.O000O0o0.shutdownNow();
            this.O000O0o0 = null;
        }
        if (this.O000O0o != null) {
            this.O000O0o.clear();
        }
        if (this.O0000o0O != null) {
            for (oooOoO oooooo : this.O0000o0O) {
                if (oooooo != null) {
                    oooooo.O00000o0();
                }
            }
            this.O0000o0O.clear();
        }
        if (z && this.O0000o0 != null) {
            this.O0000o0.O000000o(this);
            this.O0000o0.O00000o();
        }
        this.O0000o0 = null;
        this.O000O0OO = null;
    }

    public void setAnchor(float f, float f2) {
        this.O00000oo = f;
        this.O0000O0o = f2;
        O00000o();
    }

    public void setVisible(boolean z) {
        if (this.O000O0Oo != z) {
            O00000o();
        }
        this.O000O0Oo = z;
    }
}
