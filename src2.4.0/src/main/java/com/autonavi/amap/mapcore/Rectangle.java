package com.autonavi.amap.mapcore;

import android.graphics.Rect;

public class Rectangle {
    private int beyond180Mode = 0;
    public float bottom;
    public FPoint[] clipMapRect = null;
    public IPoint[] clipRect = null;
    public float left;
    public Rect rect = new Rect();
    public float right;
    public float top;

    public Rectangle(float f, float f2, float f3, float f4) {
        if (f < f2 && f4 > f3) {
            this.left = f;
            this.right = f2;
            this.top = f4;
            this.bottom = f3;
        }
    }

    public Rectangle(Rect rect, int i, int i2) {
        this.rect = rect;
        if (rect != null) {
            updateRect(rect, i, i2);
            updateClipRect();
            updateClipMapRect(rect.centerX(), rect.centerY());
        }
    }

    private void updateClipMapRect(int i, int i2) {
        if (this.clipMapRect == null) {
            this.clipMapRect = new FPoint[4];
            this.clipMapRect[0] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[1] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[2] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[3] = FPoint.obtain(0.0f, 0.0f);
        }
        if (this.rect != null) {
            this.clipMapRect[0].x = (float) (this.rect.left - i);
            this.clipMapRect[0].y = (float) (this.rect.top - i2);
            this.clipMapRect[1].x = (float) (this.rect.right - i);
            this.clipMapRect[1].y = (float) (this.rect.top - i2);
            this.clipMapRect[2].x = (float) (this.rect.right - i);
            this.clipMapRect[2].y = (float) (this.rect.bottom - i2);
            this.clipMapRect[3].x = (float) (this.rect.left - i);
            this.clipMapRect[3].y = (float) (this.rect.bottom - i2);
        }
    }

    private void updateClipRect() {
        if (this.clipRect == null) {
            this.clipRect = new IPoint[4];
            this.clipRect[0] = IPoint.obtain(0, 0);
            this.clipRect[1] = IPoint.obtain(0, 0);
            this.clipRect[2] = IPoint.obtain(0, 0);
            this.clipRect[3] = IPoint.obtain(0, 0);
        }
        if (this.rect != null) {
            this.clipRect[0].x = this.rect.left;
            this.clipRect[0].y = this.rect.top;
            this.clipRect[1].x = this.rect.right;
            this.clipRect[1].y = this.rect.top;
            this.clipRect[2].x = this.rect.right;
            this.clipRect[2].y = this.rect.bottom;
            this.clipRect[3].x = this.rect.left;
            this.clipRect[3].y = this.rect.bottom;
        }
    }

    public boolean contains(int i, int i2) {
        if (this.rect != null) {
            if (this.rect.contains(i, i2)) {
                return true;
            }
            if (this.beyond180Mode != 0 && (this.rect.contains(i - AMapEngineUtils.MAX_P20_WIDTH, i2) || this.rect.contains(i + AMapEngineUtils.MAX_P20_WIDTH, i2))) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Rect rect) {
        return rect == null ? false : this.rect.contains(rect);
    }

    public boolean contains(IPoint iPoint) {
        return iPoint == null ? false : contains(iPoint.x, iPoint.y);
    }

    public int getBeyond180Mode() {
        return this.beyond180Mode;
    }

    public FPoint[] getClipMapRect() {
        return this.clipMapRect;
    }

    public IPoint[] getClipRect() {
        return this.clipRect;
    }

    public Rect getRect() {
        return this.rect;
    }

    public boolean isOverlap(int i, int i2, int i3, int i4) {
        return this.rect != null && this.rect.left + this.rect.width() > i && i + i3 > this.rect.left && this.rect.top + this.rect.height() > i2 && i2 + i4 > this.rect.top;
    }

    /* JADX WARNING: Missing block: B:14:0x0043, code skipped:
            return false;
     */
    public boolean isOverlap(android.graphics.Rect r4) {
        /*
        r3 = this;
        r0 = r3.rect;
        r1 = 0;
        if (r0 == 0) goto L_0x0043;
    L_0x0005:
        if (r4 != 0) goto L_0x0008;
    L_0x0007:
        goto L_0x0043;
    L_0x0008:
        r0 = r3.rect;
        r0 = r0.left;
        r2 = r3.rect;
        r2 = r2.width();
        r0 = r0 + r2;
        r2 = r4.left;
        if (r0 <= r2) goto L_0x0042;
    L_0x0017:
        r0 = r4.left;
        r2 = r4.width();
        r0 = r0 + r2;
        r2 = r3.rect;
        r2 = r2.left;
        if (r0 <= r2) goto L_0x0042;
    L_0x0024:
        r0 = r3.rect;
        r0 = r0.top;
        r2 = r3.rect;
        r2 = r2.height();
        r0 = r0 + r2;
        r2 = r4.top;
        if (r0 <= r2) goto L_0x0042;
    L_0x0033:
        r0 = r4.top;
        r4 = r4.height();
        r0 = r0 + r4;
        r4 = r3.rect;
        r4 = r4.top;
        if (r0 <= r4) goto L_0x0042;
    L_0x0040:
        r4 = 1;
        return r4;
    L_0x0042:
        return r1;
    L_0x0043:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.amap.mapcore.Rectangle.isOverlap(android.graphics.Rect):boolean");
    }

    public void updateRect(Rect rect, int i, int i2) {
        if (rect != null) {
            this.rect = rect;
            this.rect.inset((-rect.width()) / 8, (-rect.height()) / 8);
            if ((((float) this.rect.left) / 100000.0f) * (((float) this.rect.right) / 100000.0f) < 0.0f) {
                this.beyond180Mode = -1;
            } else if (this.rect.right > AMapEngineUtils.MAX_P20_WIDTH) {
                this.beyond180Mode = 1;
            } else {
                this.beyond180Mode = 0;
            }
            updateClipRect();
            updateClipMapRect(i, i2);
        }
    }
}
