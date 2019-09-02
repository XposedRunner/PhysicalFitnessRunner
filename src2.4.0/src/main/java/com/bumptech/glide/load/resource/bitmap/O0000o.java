package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.alibaba.wireless.security.SecExceptionCode;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

/* compiled from: GlideBitmapDrawable */
public class O0000o extends o0OoO00O {
    private int O00000o;
    private final Rect O00000o0;
    private int O00000oO;
    private boolean O00000oo;
    private boolean O0000O0o;
    private O000000o O0000OOo;

    /* compiled from: GlideBitmapDrawable */
    static class O000000o extends ConstantState {
        private static final int O00000o = 6;
        private static final Paint O00000oO = new Paint(6);
        private static final int O00000oo = 119;
        final Bitmap O000000o;
        int O00000Oo;
        Paint O00000o0;

        public O000000o(Bitmap bitmap) {
            this.O00000o0 = O00000oO;
            this.O000000o = bitmap;
        }

        O000000o(O000000o o000000o) {
            this(o000000o.O000000o);
            this.O00000Oo = o000000o.O00000Oo;
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o() {
            if (O00000oO == this.O00000o0) {
                this.O00000o0 = new Paint(6);
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(int i) {
            O000000o();
            this.O00000o0.setAlpha(i);
        }

        /* Access modifiers changed, original: 0000 */
        public void O000000o(ColorFilter colorFilter) {
            O000000o();
            this.O00000o0.setColorFilter(colorFilter);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new O0000o(null, this);
        }

        public Drawable newDrawable(Resources resources) {
            return new O0000o(resources, this);
        }
    }

    public O0000o(Resources resources, Bitmap bitmap) {
        this(resources, new O000000o(bitmap));
    }

    O0000o(Resources resources, O000000o o000000o) {
        this.O00000o0 = new Rect();
        if (o000000o == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        int i;
        this.O0000OOo = o000000o;
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
            if (i == 0) {
                i = GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL;
            }
            o000000o.O00000Oo = i;
        } else {
            i = o000000o.O00000Oo;
        }
        this.O00000o = o000000o.O000000o.getScaledWidth(i);
        this.O00000oO = o000000o.O000000o.getScaledHeight(i);
    }

    public void O000000o(int i) {
    }

    public boolean O000000o() {
        return false;
    }

    public Bitmap O00000Oo() {
        return this.O0000OOo.O000000o;
    }

    public void draw(Canvas canvas) {
        if (this.O00000oo) {
            Gravity.apply(SecExceptionCode.SEC_ERROR_SET_GLOBAL_USER_DATA, this.O00000o, this.O00000oO, getBounds(), this.O00000o0);
            this.O00000oo = false;
        }
        canvas.drawBitmap(this.O0000OOo.O000000o, null, this.O00000o0, this.O0000OOo.O00000o0);
    }

    public ConstantState getConstantState() {
        return this.O0000OOo;
    }

    public int getIntrinsicHeight() {
        return this.O00000oO;
    }

    public int getIntrinsicWidth() {
        return this.O00000o;
    }

    public int getOpacity() {
        Bitmap bitmap = this.O0000OOo.O000000o;
        return (bitmap == null || bitmap.hasAlpha() || this.O0000OOo.O00000o0.getAlpha() < 255) ? -3 : -1;
    }

    public boolean isRunning() {
        return false;
    }

    public Drawable mutate() {
        if (!this.O0000O0o && super.mutate() == this) {
            this.O0000OOo = new O000000o(this.O0000OOo);
            this.O0000O0o = true;
        }
        return this;
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.O00000oo = true;
    }

    public void setAlpha(int i) {
        if (this.O0000OOo.O00000o0.getAlpha() != i) {
            this.O0000OOo.O000000o(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.O0000OOo.O000000o(colorFilter);
        invalidateSelf();
    }

    public void start() {
    }

    public void stop() {
    }
}
