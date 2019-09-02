package com.amap.api.mapcore.util;

import android.os.RemoteException;
import com.amap.api.maps.AMap.OnMultiPointClickListener;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MultiPointOverlayManagerLayer */
public class O00O00o0 {
    OO00O O000000o;
    private List<IMultiPointOverlay> O00000Oo = new ArrayList();
    private ca O00000o;
    private OnMultiPointClickListener O00000o0;

    public O00O00o0(ca caVar) {
        this.O00000o = caVar;
    }

    private void O000000o(IMultiPointOverlay iMultiPointOverlay) throws RemoteException {
        synchronized (this.O00000Oo) {
            this.O00000Oo.add(iMultiPointOverlay);
        }
    }

    public OO00O O000000o() {
        this.O000000o = this.O00000o.O0000ooo();
        return this.O000000o;
    }

    public synchronized IMultiPointOverlay O000000o(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        IMultiPointOverlay o00O00Oo = new O00O00Oo(multiPointOverlayOptions, this);
        O000000o(o00O00Oo);
        return o00O00Oo;
    }

    public void O000000o(O00O00Oo o00O00Oo) {
        this.O00000Oo.remove(o00O00Oo);
    }

    public void O000000o(OnMultiPointClickListener onMultiPointClickListener) {
        this.O00000o0 = onMultiPointClickListener;
    }

    public void O000000o(MapConfig mapConfig, float[] fArr, float[] fArr2) {
        try {
            synchronized (this.O00000Oo) {
                for (IMultiPointOverlay draw : this.O00000Oo) {
                    draw.draw(mapConfig, fArr, fArr2);
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MultiPointOverlayManagerLayer", "draw");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Missing block: B:17:0x002e, code skipped:
            return r1;
     */
    public boolean O000000o(com.autonavi.amap.mapcore.IPoint r5) {
        /*
        r4 = this;
        r0 = r4.O00000o0;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r4.O00000Oo;
        monitor-enter(r0);
        r2 = r4.O00000Oo;	 Catch:{ all -> 0x0031 }
        r2 = r2.iterator();	 Catch:{ all -> 0x0031 }
    L_0x000f:
        r3 = r2.hasNext();	 Catch:{ all -> 0x0031 }
        if (r3 == 0) goto L_0x002f;
    L_0x0015:
        r3 = r2.next();	 Catch:{ all -> 0x0031 }
        r3 = (com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay) r3;	 Catch:{ all -> 0x0031 }
        if (r3 == 0) goto L_0x000f;
    L_0x001d:
        r3 = r3.onClick(r5);	 Catch:{ all -> 0x0031 }
        if (r3 == 0) goto L_0x000f;
    L_0x0023:
        r5 = r4.O00000o0;	 Catch:{ all -> 0x0031 }
        if (r5 == 0) goto L_0x002d;
    L_0x0027:
        r5 = r4.O00000o0;	 Catch:{ all -> 0x0031 }
        r1 = r5.onPointClick(r3);	 Catch:{ all -> 0x0031 }
    L_0x002d:
        monitor-exit(r0);	 Catch:{ all -> 0x0031 }
        return r1;
    L_0x002f:
        monitor-exit(r0);	 Catch:{ all -> 0x0031 }
        return r1;
    L_0x0031:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0031 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00O00o0.O000000o(com.autonavi.amap.mapcore.IPoint):boolean");
    }

    public synchronized void O00000Oo() {
        this.O00000o0 = null;
        try {
            synchronized (this.O00000Oo) {
                for (IMultiPointOverlay destroy : this.O00000Oo) {
                    destroy.destroy(false);
                }
                this.O00000Oo.clear();
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MultiPointOverlayManagerLayer", "destory");
            th.printStackTrace();
        }
        return;
    }

    public void O00000o() {
        if (this.O00000o != null) {
            this.O00000o.setRunLowFrame(false);
        }
    }

    public synchronized void O00000o0() {
        try {
            synchronized (this.O00000Oo) {
                this.O00000Oo.clear();
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "MultiPointOverlayManagerLayer", "clear");
            th.printStackTrace();
        }
        return;
    }
}
