package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.support.v4.app.SemesterTipDialog;
import android.util.Log;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.OO00O.O00000o;
import com.amap.api.mapcore.util.OOo0.O00000o0;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.LatLngBounds.Builder;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import java.io.Serializable;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: MapOverlayImageView */
public final class O00000Oo {
    ca O000000o;
    float[] O00000Oo = new float[180000];
    int O00000o = 0;
    public O00000o O00000o0;
    int O00000oO = 0;
    private List<OoO0o> O00000oo = new ArrayList(500);
    private List<O0000O0o> O0000O0o = new ArrayList();
    private List<OoO0o> O0000OOo = new ArrayList();
    private boolean O0000Oo = true;
    private O000000o O0000Oo0 = new O000000o();
    private IPoint O0000OoO;
    private bi O0000Ooo;
    private HandlerThread O0000o;
    private OOo0 O0000o0;
    private O0Oo0 O0000o00;
    private OOO0o0 O0000o0O;
    private FloatBuffer O0000o0o;
    private int[] O0000oO = new int[1];
    private Handler O0000oO0;
    private Runnable O0000oOO = new Runnable() {
        public void run() {
            synchronized (O00000Oo.this.O00000oo) {
                O00000Oo.this.O0000Oo();
            }
        }
    };

    /* compiled from: MapOverlayImageView */
    static class O000000o implements Serializable, Comparator<Object> {
        O000000o() {
        }

        public int compare(Object obj, Object obj2) {
            OoO0o ooO0o = (OoO0o) obj;
            OoO0o ooO0o2 = (OoO0o) obj2;
            if (!(ooO0o == null || ooO0o2 == null)) {
                try {
                    return Float.compare(ooO0o.getZIndex(), ooO0o2.getZIndex());
                } catch (Throwable th) {
                    ooOOOOoo.O00000o0(th, "MapOverlayImageView", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public O00000Oo(Context context, ca caVar) {
        this.O000000o = caVar;
        this.O0000o0 = new OOo0(512, 1024);
        this.O0000o0O = new OOO0o0();
        this.O0000o = new HandlerThread("AMapZindexSortThread");
        this.O0000o.start();
        this.O0000oO0 = new Handler(this.O0000o.getLooper());
    }

    private void O000000o(int i) {
        if (i > 5000) {
            i = 5000;
        }
        if (this.O00000o == 0) {
            int[] iArr = new int[2];
            int i2 = 0;
            GLES20.glGenBuffers(2, iArr, 0);
            this.O00000o = iArr[0];
            this.O00000oO = iArr[1];
            ShortBuffer O00000Oo = this.O0000o0O.O00000Oo(30000);
            short[] sArr = new short[30000];
            while (i2 < 5000) {
                int i3 = 6 * i2;
                int i4 = 4 * i2;
                short s = (short) (i4 + 0);
                sArr[i3 + 0] = s;
                sArr[i3 + 1] = (short) (i4 + 1);
                short s2 = (short) (i4 + 2);
                sArr[i3 + 2] = s2;
                sArr[i3 + 3] = s;
                sArr[i3 + 4] = s2;
                sArr[i3 + 5] = (short) (i4 + 3);
                i2++;
            }
            O00000Oo.put(sArr);
            O00000Oo.flip();
            GLES20.glBindBuffer(34963, this.O00000oO);
            GLES20.glBufferData(34963, SemesterTipDialog.REQUEST_CODE_SEMESTER_DIALOG, O00000Oo, 35044);
        }
        GLES20.glBindBuffer(34962, this.O00000o);
        GLES20.glBufferData(34962, (i * 36) * 4, this.O0000o0o, 35044);
    }

    private void O000000o(int i, int i2, int i3, int i4) {
        if (i2 != 0 && i != 0) {
            this.O0000o0o = this.O0000o0O.O00000o0(i2 * 36);
            this.O0000o0o.put(this.O00000Oo, i3, i4);
            this.O0000o0o.flip();
            O000000o(i2);
            O000000o(i, i4, i2, this.O0000o0o, this.O000000o.getMapConfig());
            this.O0000o0O.O000000o();
        }
    }

    private void O000000o(int i, int i2, int i3, FloatBuffer floatBuffer, MapConfig mapConfig) {
        if (i != 0 && floatBuffer != null && i3 != 0) {
            if (this.O00000o0 == null || this.O00000o0.O00000o0()) {
                O0000OoO();
            }
            this.O00000o0.O000000o();
            GLES20.glUniform1f(this.O00000o0.O0000OOo, mapConfig.getSR());
            GLES20.glEnableVertexAttribArray(this.O00000o0.O00000Oo);
            GLES20.glBindBuffer(34962, this.O00000o);
            GLES20.glVertexAttribPointer(this.O00000o0.O00000Oo, 4, 5126, false, 36, 0);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glEnableVertexAttribArray(this.O00000o0.O00000o0);
            GLES20.glBindBuffer(34962, this.O00000o);
            GLES20.glVertexAttribPointer(this.O00000o0.O00000o0, 2, 5126, false, 36, 16);
            GLES20.glEnableVertexAttribArray(this.O00000o0.O0000O0o);
            GLES20.glBindBuffer(34962, this.O00000o);
            GLES20.glVertexAttribPointer(this.O00000o0.O0000O0o, 3, 5126, false, 36, 24);
            GLES20.glUniformMatrix4fv(this.O00000o0.O000000o, 1, false, O00000Oo(), 0);
            GLES20.glBindBuffer(34963, this.O00000oO);
            GLES20.glDrawElements(4, 6 * i3, 5123, 0);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glBindBuffer(34963, 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glDisableVertexAttribArray(this.O00000o0.O00000Oo);
            GLES20.glDisableVertexAttribArray(this.O00000o0.O00000o0);
            GLES20.glDisable(3042);
            GLES20.glUseProgram(0);
        }
    }

    private void O00000o(OoO0o ooO0o) {
        try {
            this.O00000oo.add(ooO0o);
            O00000oo();
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MapOverlayImageView", "addMarker");
        }
    }

    private void O0000Oo() {
        try {
            Collections.sort(this.O00000oo, this.O0000Oo0);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MapOverlayImageView", "changeOverlayIndex");
        }
    }

    private void O0000OoO() {
        if (this.O00000o0 == null && this.O000000o != null) {
            this.O00000o0 = (O00000o) this.O000000o.O0000oOo(1);
        }
    }

    public bi O000000o(MotionEvent motionEvent) {
        synchronized (this.O00000oo) {
            for (int size = this.O00000oo.size() - 1; size >= 0; size--) {
                OoO0o ooO0o = (OoO0o) this.O00000oo.get(size);
                if ((ooO0o instanceof Oo0OOo) && OOo000.O000000o(ooO0o.O0000Ooo(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.O0000Ooo = (Oo0OOo) ooO0o;
                    bi biVar = this.O0000Ooo;
                    return biVar;
                }
            }
            return null;
        }
    }

    public Marker O000000o(MarkerOptions markerOptions) throws RemoteException {
        if (markerOptions == null) {
            return null;
        }
        Marker marker;
        Oo0OOo oo0OOo = new Oo0OOo(markerOptions, this);
        synchronized (this.O00000oo) {
            O00000o(oo0OOo);
            OOO0O0O.O000000o(this.O00000oo.size());
            marker = new Marker(oo0OOo);
        }
        return marker;
    }

    public Text O000000o(TextOptions textOptions) throws RemoteException {
        if (textOptions == null) {
            return null;
        }
        Text text;
        synchronized (this.O00000oo) {
            OO00OO oo00oo = new OO00OO(textOptions, this);
            O00000o(oo00oo);
            text = new Text(oo00oo);
        }
        return text;
    }

    public ArrayList<Marker> O000000o(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            int i = 0;
            if (arrayList.size() == 1) {
                MarkerOptions markerOptions = (MarkerOptions) arrayList.get(0);
                if (markerOptions != null) {
                    arrayList2.add(O000000o(markerOptions));
                    if (z && markerOptions.getPosition() != null) {
                        this.O000000o.O000000o(O000O0o0.O000000o(markerOptions.getPosition(), 18.0f));
                    }
                    return arrayList2;
                }
            }
            final Builder builder = LatLngBounds.builder();
            while (i < arrayList.size()) {
                MarkerOptions markerOptions2 = (MarkerOptions) arrayList.get(i);
                if (arrayList.get(i) != null) {
                    arrayList2.add(O000000o(markerOptions2));
                    if (markerOptions2.getPosition() != null) {
                        builder.include(markerOptions2.getPosition());
                    }
                }
                i++;
            }
            if (z && arrayList2.size() > 0) {
                this.O000000o.getMainHandler().postDelayed(new Runnable() {
                    public void run() {
                        try {
                            O00000Oo.this.O000000o.O000000o(O000O0o0.O000000o(builder.build(), 50));
                        } catch (Throwable unused) {
                        }
                    }
                }, 50);
            }
            return arrayList2;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "AMapDelegateImpGLSurfaceView", "addMarkers");
            th.printStackTrace();
            return arrayList2;
        }
    }

    public void O000000o() {
        this.O0000o00 = null;
    }

    public void O000000o(O0000O0o o0000O0o) {
        synchronized (this.O0000O0o) {
            if (o0000O0o != null) {
                try {
                    this.O0000O0o.add(o0000O0o);
                } catch (Throwable th) {
                }
            }
        }
    }

    public void O000000o(O0Oo0 o0Oo0) {
        try {
            if (this.O0000o00 != null) {
                if (o0Oo0 == null || !o0Oo0.getId().equals(this.O0000o00.getId())) {
                    this.O0000o00.O00000Oo(false);
                } else {
                    return;
                }
            }
            if (this.O00000oo.contains(o0Oo0)) {
                if (o0Oo0 != null) {
                    o0Oo0.O00000Oo(true);
                }
                this.O0000o00 = o0Oo0;
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MapOverlayImageView", "set2Top");
        }
    }

    public void O000000o(bi biVar) {
        if (this.O0000OoO == null) {
            this.O0000OoO = IPoint.obtain();
        }
        Rect O0000Ooo = biVar.O0000Ooo();
        this.O0000OoO = IPoint.obtain(O0000Ooo.left + (O0000Ooo.width() / 2), O0000Ooo.top);
        this.O0000Ooo = biVar;
        try {
            this.O000000o.O000000o(this.O0000Ooo);
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MapOverlayImageView", "showInfoWindow");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001d A:{SYNTHETIC} */
    public void O000000o(java.lang.String r7) {
        /*
        r6 = this;
        r0 = 0;
        if (r7 == 0) goto L_0x0012;
    L_0x0003:
        r1 = r7.trim();	 Catch:{ Throwable -> 0x0010 }
        r1 = r1.length();	 Catch:{ Throwable -> 0x0010 }
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0012;
    L_0x000e:
        r1 = r0;
        goto L_0x0013;
    L_0x0010:
        r7 = move-exception;
        goto L_0x0068;
    L_0x0012:
        r1 = 1;
    L_0x0013:
        r2 = 0;
        r6.O0000Ooo = r2;	 Catch:{ Throwable -> 0x0010 }
        r6.O0000OoO = r2;	 Catch:{ Throwable -> 0x0010 }
        r6.O0000o00 = r2;	 Catch:{ Throwable -> 0x0010 }
        r3 = r6.O00000oo;	 Catch:{ Throwable -> 0x0010 }
        monitor-enter(r3);	 Catch:{ Throwable -> 0x0010 }
        r4 = r6.O0000OOo;	 Catch:{ all -> 0x0065 }
        r4.clear();	 Catch:{ all -> 0x0065 }
        if (r1 == 0) goto L_0x002a;
    L_0x0024:
        r7 = r6.O00000oo;	 Catch:{ all -> 0x0065 }
        r7.clear();	 Catch:{ all -> 0x0065 }
        goto L_0x0063;
    L_0x002a:
        r1 = r6.O00000oo;	 Catch:{ all -> 0x0065 }
        r1 = r1.size();	 Catch:{ all -> 0x0065 }
    L_0x0030:
        if (r0 >= r1) goto L_0x0049;
    L_0x0032:
        r4 = r6.O00000oo;	 Catch:{ all -> 0x0065 }
        r4 = r4.get(r0);	 Catch:{ all -> 0x0065 }
        r4 = (com.amap.api.mapcore.util.OoO0o) r4;	 Catch:{ all -> 0x0065 }
        r5 = r4.getId();	 Catch:{ all -> 0x0065 }
        r5 = r7.equals(r5);	 Catch:{ all -> 0x0065 }
        if (r5 == 0) goto L_0x0046;
    L_0x0044:
        r2 = r4;
        goto L_0x0049;
    L_0x0046:
        r0 = r0 + 1;
        goto L_0x0030;
    L_0x0049:
        r7 = r6.O00000oo;	 Catch:{ all -> 0x0065 }
        r7.clear();	 Catch:{ all -> 0x0065 }
        if (r2 == 0) goto L_0x0063;
    L_0x0050:
        r7 = r6.O00000oo;	 Catch:{ all -> 0x0065 }
        r7.add(r2);	 Catch:{ all -> 0x0065 }
        r7 = r2.O00000oO();	 Catch:{ all -> 0x0065 }
        if (r7 == 0) goto L_0x0063;
    L_0x005b:
        r7 = r2 instanceof com.amap.api.mapcore.util.O0Oo0;	 Catch:{ all -> 0x0065 }
        if (r7 == 0) goto L_0x0063;
    L_0x005f:
        r2 = (com.amap.api.mapcore.util.O0Oo0) r2;	 Catch:{ all -> 0x0065 }
        r6.O0000o00 = r2;	 Catch:{ all -> 0x0065 }
    L_0x0063:
        monitor-exit(r3);	 Catch:{ all -> 0x0065 }
        goto L_0x0072;
    L_0x0065:
        r7 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0065 }
        throw r7;	 Catch:{ Throwable -> 0x0010 }
    L_0x0068:
        r0 = "MapOverlayImageView";
        r1 = "clear";
        com.amap.api.mapcore.util.ooOOOOoo.O00000o0(r7, r0, r1);
        r7.printStackTrace();
    L_0x0072:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00000Oo.O000000o(java.lang.String):void");
    }

    public void O000000o(boolean z) {
        try {
            if (this.O000000o != null) {
                float mapPerPixelUnitLength = this.O000000o.getMapConfig().getMapPerPixelUnitLength();
                synchronized (this.O00000oo) {
                    O0000OOo();
                    if (this.O00000oo.size() == 0) {
                        return;
                    }
                    int i;
                    this.O0000OOo.clear();
                    int size = this.O00000oo.size();
                    for (i = 0; i < size; i++) {
                        OoO0o ooO0o = (OoO0o) this.O00000oo.get(i);
                        if (z) {
                            if (ooO0o.getZIndex() != 2.14748365E9f) {
                            }
                        } else if (ooO0o.getZIndex() == 2.14748365E9f) {
                        }
                        if (!ooO0o.isVisible()) {
                            continue;
                        } else if (!ooO0o.O00000oO()) {
                            this.O0000Oo = ooO0o.O000000o();
                            if (ooO0o.O0000OoO() || ooO0o.isInfoWindowShown()) {
                                try {
                                    this.O0000OOo.add(ooO0o);
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                        }
                    }
                    if (this.O0000o00 != null && this.O0000o00.isVisible()) {
                        this.O0000OOo.add(this.O0000o00);
                    }
                    if (this.O0000OOo.size() > 0) {
                        int size2 = this.O0000OOo.size();
                        size = 0;
                        i = size;
                        int i2 = i;
                        int i3 = i2;
                        int i4 = i3;
                        while (size < size2) {
                            OoO0o ooO0o2 = (OoO0o) this.O0000OOo.get(size);
                            synchronized (ooO0o2) {
                                int O00000o;
                                ooO0o2.O000000o(this.O000000o);
                                if (size == 0) {
                                    i2 = ooO0o2.O00000o();
                                } else {
                                    O00000o = ooO0o2.O00000o();
                                    if (O00000o != i2) {
                                        O000000o(i2, i, i3, i4);
                                        i = 0;
                                        i3 = i;
                                        i4 = i3;
                                        i2 = O00000o;
                                    }
                                }
                                ooO0o2.O000000o(this.O000000o, this.O00000Oo, i4, mapPerPixelUnitLength);
                                O00000o = ooO0o2.O00000o();
                                if (O00000o != i2) {
                                    O000000o(i2, i, i3, i4);
                                    i = 0;
                                    i3 = i4;
                                    i2 = O00000o;
                                    i4 = i;
                                }
                                i4 += 36;
                                i++;
                                if (i == 5000) {
                                    O000000o(i2, i, i3, i4);
                                    i = 0;
                                    i3 = i;
                                    i4 = i3;
                                }
                            }
                            size++;
                        }
                        if (i > 0) {
                            O000000o(i2, i, i3, i4);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public synchronized boolean O000000o(Bitmap bitmap, O0000O0o o0000O0o) {
        O00000o0 O000000o = this.O0000o0.O000000o(bitmap.getWidth() + 1, bitmap.getHeight() + 1, o0000O0o.O0000o0O());
        if (O000000o == null) {
            return false;
        }
        o0000O0o.O00000oo(((float) O000000o.O000000o) / ((float) this.O0000o0.O000000o()));
        o0000O0o.O00000oO(((float) O000000o.O00000Oo) / ((float) this.O0000o0.O00000Oo()));
        o0000O0o.O0000O0o(((float) ((O000000o.O000000o + O000000o.O00000o0) - 1)) / ((float) this.O0000o0.O000000o()));
        o0000O0o.O0000OOo(((float) ((O000000o.O00000Oo + O000000o.O00000o) - 1)) / ((float) this.O0000o0.O00000Oo()));
        o0000O0o.O00000o0((((float) O000000o.O000000o) + 0.5f) / ((float) this.O0000o0.O000000o()));
        o0000O0o.O00000o((((float) O000000o.O00000Oo) + 0.5f) / ((float) this.O0000o0.O00000Oo()));
        o0000O0o.O000000o((((float) ((O000000o.O000000o + O000000o.O00000o0) - 1)) - 0.5f) / ((float) this.O0000o0.O000000o()));
        o0000O0o.O00000Oo((((float) ((O000000o.O00000Oo + O000000o.O00000o) - 1)) - 0.5f) / ((float) this.O0000o0.O00000Oo()));
        o0000O0o.O000000o(true);
        return true;
    }

    public boolean O000000o(OoO0o ooO0o) {
        boolean remove;
        synchronized (this.O00000oo) {
            try {
                if (this.O0000o00 != null && this.O0000o00.getId().equals(ooO0o.getId())) {
                    this.O0000o00 = null;
                }
                O00000Oo(ooO0o);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            remove = this.O00000oo.remove(ooO0o);
        }
        return remove;
    }

    public void O00000Oo(OoO0o ooO0o) {
        try {
            if (ooO0o.isInfoWindowShown()) {
                this.O000000o.O0000Oo0();
                this.O0000Ooo = null;
            } else if (this.O0000Ooo != null && this.O0000Ooo.getId().equals(ooO0o.getId())) {
                this.O0000Ooo = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean O00000Oo(MotionEvent motionEvent) throws RemoteException {
        boolean z;
        synchronized (this.O00000oo) {
            z = false;
            for (int size = this.O00000oo.size() - 1; size >= 0; size--) {
                OoO0o ooO0o = (OoO0o) this.O00000oo.get(size);
                if ((ooO0o instanceof Oo0OOo) && ooO0o.isVisible() && ((Oo0OOo) ooO0o).isClickable()) {
                    Rect O0000Ooo = ooO0o.O0000Ooo();
                    boolean O000000o = OOo000.O000000o(O0000Ooo, (int) motionEvent.getX(), (int) motionEvent.getY());
                    if (O000000o) {
                        this.O0000OoO = IPoint.obtain(O0000Ooo.left + (O0000Ooo.width() / 2), O0000Ooo.top);
                        this.O0000Ooo = (Oo0OOo) ooO0o;
                        z = O000000o;
                        break;
                    }
                }
            }
        }
        return z;
    }

    public float[] O00000Oo() {
        return this.O000000o != null ? this.O000000o.O0000ooO() : new float[16];
    }

    public bi O00000o() {
        return this.O0000Ooo;
    }

    public ca O00000o0() {
        return this.O000000o;
    }

    public boolean O00000o0(OoO0o ooO0o) {
        boolean contains;
        synchronized (this.O00000oo) {
            contains = this.O00000oo.contains(ooO0o);
        }
        return contains;
    }

    public List<Marker> O00000oO() {
        ArrayList arrayList;
        synchronized (this.O00000oo) {
            arrayList = new ArrayList();
            try {
                for (OoO0o ooO0o : this.O00000oo) {
                    if ((ooO0o instanceof Oo0OOo) && ooO0o.O0000OoO()) {
                        arrayList.add(new Marker((IMarker) ooO0o));
                    }
                }
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "MapOverlayImageView", "getMapScreenMarkers");
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    public void O00000oo() {
        if (this.O0000oO0 != null) {
            this.O0000oO0.removeCallbacks(this.O0000oOO);
            this.O0000oO0.postDelayed(this.O0000oOO, 10);
        }
    }

    /* Access modifiers changed, original: protected */
    public int O0000O0o() {
        int size;
        synchronized (this.O00000oo) {
            size = this.O00000oo.size();
        }
        return size;
    }

    public void O0000OOo() {
        synchronized (this.O0000O0o) {
            int O00000oO = this.O000000o.O00000oO();
            for (int i = 0; i < this.O0000O0o.size(); i++) {
                O0000O0o o0000O0o = (O0000O0o) this.O0000O0o.get(i);
                if (o0000O0o != null) {
                    o0000O0o.O0000o00();
                    if (o0000O0o.O0000o0() <= 0) {
                        if (o0000O0o.O0000OoO() == O00000oO) {
                            this.O0000o0.O000000o(o0000O0o.O0000o0O());
                        } else {
                            this.O0000oO[0] = o0000O0o.O0000OoO();
                            GLES20.glDeleteTextures(1, this.O0000oO, 0);
                        }
                        if (this.O000000o != null) {
                            this.O000000o.O00000o0(o0000O0o.O0000o0O());
                        }
                    }
                }
            }
            this.O0000O0o.clear();
        }
    }

    public void O0000Oo0() {
        try {
            for (OoO0o ooO0o : this.O00000oo) {
                if (ooO0o != null) {
                    ooO0o.destroy(false);
                }
            }
            O000000o(null);
            if (this.O0000o != null) {
                this.O0000o.quit();
            }
            this.O0000oO0 = null;
            this.O000000o = null;
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MapOverlayImageView", "destroy");
            th.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MapOverlayImageView clear erro");
            stringBuilder.append(th.getMessage());
            Log.d("amapApi", stringBuilder.toString());
        }
    }
}
