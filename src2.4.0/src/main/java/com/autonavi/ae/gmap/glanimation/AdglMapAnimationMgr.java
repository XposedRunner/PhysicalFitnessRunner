package com.autonavi.ae.gmap.glanimation;

import com.amap.api.maps.AMap.CancelableCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdglMapAnimationMgr {
    private List<AbstractAdglAnimation> list = Collections.synchronizedList(new ArrayList());
    private CancelableCallback mCancelCallback;
    private MapAnimationListener mMapAnimationListener;

    public interface MapAnimationListener {
        void onMapAnimationFinish(CancelableCallback cancelableCallback);
    }

    public void addAnimation(AbstractAdglAnimation abstractAdglAnimation, CancelableCallback cancelableCallback) {
        if (abstractAdglAnimation != null) {
            synchronized (this.list) {
                if (!abstractAdglAnimation.isOver() && this.list.size() > 0) {
                    AbstractAdglAnimation abstractAdglAnimation2 = (AbstractAdglAnimation) this.list.get(this.list.size() - 1);
                    if (abstractAdglAnimation2 != null && (abstractAdglAnimation instanceof AdglMapAnimGroup) && (abstractAdglAnimation2 instanceof AdglMapAnimGroup) && ((AdglMapAnimGroup) abstractAdglAnimation).typeEqueal((AdglMapAnimGroup) abstractAdglAnimation2) && !((AdglMapAnimGroup) abstractAdglAnimation).needMove) {
                        this.list.remove(abstractAdglAnimation2);
                    }
                }
                this.list.add(abstractAdglAnimation);
                this.mCancelCallback = cancelableCallback;
            }
        }
    }

    public synchronized void clearAnimations() {
        this.list.clear();
    }

    /* JADX WARNING: Missing block: B:23:0x0037, code skipped:
            return;
     */
    public synchronized void doAnimations(com.autonavi.ae.gmap.GLMapState r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        if (r3 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r2);
        return;
    L_0x0005:
        r0 = r2.list;	 Catch:{ all -> 0x0038 }
        r0 = r0.size();	 Catch:{ all -> 0x0038 }
        if (r0 > 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r2);
        return;
    L_0x000f:
        r0 = r2.list;	 Catch:{ all -> 0x0038 }
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ all -> 0x0038 }
        r0 = (com.autonavi.ae.gmap.glanimation.AbstractAdglAnimation) r0;	 Catch:{ all -> 0x0038 }
        if (r0 != 0) goto L_0x001c;
    L_0x001a:
        monitor-exit(r2);
        return;
    L_0x001c:
        r1 = r0.isOver();	 Catch:{ all -> 0x0038 }
        if (r1 == 0) goto L_0x0033;
    L_0x0022:
        r3 = r2.mMapAnimationListener;	 Catch:{ all -> 0x0038 }
        if (r3 == 0) goto L_0x002d;
    L_0x0026:
        r3 = r2.mMapAnimationListener;	 Catch:{ all -> 0x0038 }
        r1 = r2.mCancelCallback;	 Catch:{ all -> 0x0038 }
        r3.onMapAnimationFinish(r1);	 Catch:{ all -> 0x0038 }
    L_0x002d:
        r3 = r2.list;	 Catch:{ all -> 0x0038 }
        r3.remove(r0);	 Catch:{ all -> 0x0038 }
        goto L_0x0036;
    L_0x0033:
        r0.doAnimation(r3);	 Catch:{ all -> 0x0038 }
    L_0x0036:
        monitor-exit(r2);
        return;
    L_0x0038:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.ae.gmap.glanimation.AdglMapAnimationMgr.doAnimations(com.autonavi.ae.gmap.GLMapState):void");
    }

    public synchronized int getAnimationsCount() {
        return this.list.size();
    }

    public CancelableCallback getCancelCallback() {
        return this.mCancelCallback;
    }

    public void setMapAnimationListener(MapAnimationListener mapAnimationListener) {
        synchronized (this) {
            this.mMapAnimationListener = mapAnimationListener;
        }
    }

    public void setMapCoreListener() {
    }
}
