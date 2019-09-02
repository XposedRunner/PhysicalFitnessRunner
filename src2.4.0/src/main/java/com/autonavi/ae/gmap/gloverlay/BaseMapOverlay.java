package com.autonavi.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import com.amap.api.mapcore.util.ca;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public abstract class BaseMapOverlay<T extends GLOverlay, E> implements Serializable {
    private static final long serialVersionUID = 1;
    protected Context mContext;
    protected int mEngineID = 1;
    protected T mGLOverlay;
    protected Vector<E> mItemList = null;
    protected int mLastFocusedIndex;
    protected ca mMapView;

    public BaseMapOverlay(int i, Context context, ca caVar) {
        this.mEngineID = i;
        this.mContext = context;
        this.mMapView = caVar;
        this.mItemList = new Vector();
        iniGLOverlay();
    }

    public abstract void addItem(E e);

    public boolean clear() {
        try {
            this.mItemList.clear();
            clearFocus();
            if (this.mGLOverlay != null) {
                this.mGLOverlay.removeAll();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void clearFocus() {
        this.mLastFocusedIndex = -1;
        this.mGLOverlay.clearFocus();
    }

    public T getGLOverlay() {
        return this.mGLOverlay;
    }

    /* JADX WARNING: Missing block: B:15:0x001c, code skipped:
            return null;
     */
    public final E getItem(int r4) {
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.mItemList;	 Catch:{ IndexOutOfBoundsException -> 0x001f }
        monitor-enter(r1);	 Catch:{ IndexOutOfBoundsException -> 0x001f }
        if (r4 < 0) goto L_0x001b;
    L_0x0006:
        r2 = r3.mItemList;	 Catch:{ all -> 0x0019 }
        r2 = r2.size();	 Catch:{ all -> 0x0019 }
        r2 = r2 + -1;
        if (r4 <= r2) goto L_0x0011;
    L_0x0010:
        goto L_0x001b;
    L_0x0011:
        r2 = r3.mItemList;	 Catch:{ all -> 0x0019 }
        r4 = r2.get(r4);	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        return r4;
    L_0x0019:
        r4 = move-exception;
        goto L_0x001d;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        return r0;
    L_0x001d:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r4;	 Catch:{ IndexOutOfBoundsException -> 0x001f }
    L_0x001f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.ae.gmap.gloverlay.BaseMapOverlay.getItem(int):java.lang.Object");
    }

    public List<E> getItems() {
        return this.mItemList;
    }

    public int getSize() {
        return this.mItemList.size();
    }

    public abstract void iniGLOverlay();

    public boolean isClickable() {
        return this.mGLOverlay != null ? this.mGLOverlay.isClickable() : false;
    }

    public boolean isVisible() {
        return this.mGLOverlay != null ? this.mGLOverlay.isVisible() : false;
    }

    public void releaseInstance() {
        this.mMapView.queueEvent(new Runnable() {
            public void run() {
                if (BaseMapOverlay.this.getGLOverlay() != null) {
                    if (BaseMapOverlay.this.mMapView != null && BaseMapOverlay.this.mMapView.isMaploaded()) {
                        BaseMapOverlay.this.mMapView.removeEngineGLOverlay(BaseMapOverlay.this);
                    }
                    BaseMapOverlay.this.getGLOverlay().releaseInstance();
                    BaseMapOverlay.this.mGLOverlay = null;
                }
            }
        });
    }

    public boolean removeAll() {
        return clear();
    }

    public void removeItem(int i) {
        if (i >= 0) {
            try {
                if (i <= this.mItemList.size() - 1) {
                    if (i == this.mLastFocusedIndex) {
                        this.mLastFocusedIndex = -1;
                        clearFocus();
                    }
                    this.mItemList.remove(i);
                    if (this.mGLOverlay != null) {
                        this.mGLOverlay.removeItem(i);
                    }
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public void removeItem(E e) {
        if (e != null) {
            try {
                synchronized (this.mItemList) {
                    removeItem(this.mItemList.indexOf(e));
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public abstract void resumeMarker(Bitmap bitmap);

    public void setClickable(boolean z) {
        if (this.mGLOverlay != null) {
            this.mGLOverlay.setClickable(z);
        }
    }

    public void setVisible(boolean z) {
        if (this.mGLOverlay != null) {
            this.mGLOverlay.setVisible(z);
        }
    }
}
