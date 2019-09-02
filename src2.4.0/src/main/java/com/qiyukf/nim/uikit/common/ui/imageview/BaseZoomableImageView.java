package com.qiyukf.nim.uikit.common.ui.imageview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.qiyukf.nimlib.k.b.c;

public abstract class BaseZoomableImageView extends View {
    protected Bitmap a;
    protected a b;
    protected ViewPager c;
    private Matrix d;
    private Matrix e;
    private Matrix f;
    private Matrix g;
    private Paint h;
    private float[] i;
    private int j;
    private int k;
    private float l;
    private Runnable m;
    private Runnable n;
    private double o;
    private Runnable p;
    private boolean q;
    private boolean r;
    private boolean s;

    public BaseZoomableImageView(Context context) {
        super(context);
        this.d = new Matrix();
        this.e = new Matrix();
        this.f = new Matrix();
        this.g = new Matrix();
        this.i = new float[9];
        this.j = -1;
        this.k = -1;
        this.m = null;
        this.n = null;
        this.o = 0.0d;
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = true;
        a(context);
    }

    public BaseZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Matrix();
        this.e = new Matrix();
        this.f = new Matrix();
        this.g = new Matrix();
        this.i = new float[9];
        this.j = -1;
        this.k = -1;
        this.m = null;
        this.n = null;
        this.o = 0.0d;
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = true;
        a(context);
    }

    public BaseZoomableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Matrix();
        this.e = new Matrix();
        this.f = new Matrix();
        this.g = new Matrix();
        this.i = new float[9];
        this.j = -1;
        this.k = -1;
        this.m = null;
        this.n = null;
        this.o = 0.0d;
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = true;
        a(context);
    }

    @TargetApi(21)
    public BaseZoomableImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = new Matrix();
        this.e = new Matrix();
        this.f = new Matrix();
        this.g = new Matrix();
        this.i = new float[9];
        this.j = -1;
        this.k = -1;
        this.m = null;
        this.n = null;
        this.o = 0.0d;
        this.p = null;
        this.q = false;
        this.r = false;
        this.s = true;
        a(context);
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.i);
        return this.i[i];
    }

    @SuppressLint({"NewApi"})
    private void a(Context context) {
        this.h = new Paint();
        this.h.setDither(true);
        this.h.setFilterBitmap(true);
        this.h.setAntiAlias(true);
        if (context.getResources().getConfiguration().orientation == 2) {
            this.r = true;
        } else {
            this.r = false;
        }
        this.n = new Runnable() {
            public final void run() {
                BaseZoomableImageView.this.postInvalidate();
            }
        };
    }

    private void a(Matrix matrix) {
        Object matrix2;
        if (matrix2 != null && matrix2.isIdentity()) {
            matrix2 = null;
        }
        if ((matrix2 == null && !this.g.isIdentity()) || (matrix2 != null && !this.g.equals(matrix2))) {
            this.g.set(matrix2);
            invalidate();
        }
    }

    private Matrix h() {
        this.f.set(this.d);
        this.f.postConcat(this.e);
        return this.f;
    }

    public final Bitmap a() {
        return this.a;
    }

    public final void a(float f) {
        a(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(float f, float f2, float f3) {
        if (f > this.l) {
            f = this.l;
        }
        f /= d();
        this.e.postScale(f, f, f2, f3);
        a(h());
        c();
    }

    public final void a(Bitmap bitmap) {
        a(bitmap, true);
    }

    @SuppressLint({"NewApi"})
    public final void a(final Bitmap bitmap, final boolean z) {
        int i = 1;
        if (VERSION.SDK_INT >= 14) {
            if (bitmap == null || (bitmap.getHeight() <= c.a() && bitmap.getWidth() <= c.a())) {
                setLayerType(2, null);
            } else {
                setLayerType(1, null);
            }
        }
        if (getWidth() <= 0) {
            this.m = new Runnable() {
                public final void run() {
                    BaseZoomableImageView.this.a(bitmap, z);
                }
            };
            return;
        }
        Bitmap bitmap2 = this.a;
        if (bitmap != null) {
            Matrix matrix = this.d;
            float width = (float) getWidth();
            float height = (float) getHeight();
            matrix.reset();
            float min = Math.min(width / ((float) bitmap.getWidth()), 1.0f);
            float min2 = Math.min(height / ((float) bitmap.getHeight()), 1.0f);
            if (min > min2) {
                min = min2;
            }
            matrix.setScale(min, min);
            matrix.postTranslate((width - (((float) bitmap.getWidth()) * min)) / 2.0f, (height - (((float) bitmap.getHeight()) * min)) / 2.0f);
        } else {
            this.d.reset();
        }
        this.a = bitmap;
        if (!(bitmap2 == null || bitmap2 == this.a || bitmap2.isRecycled())) {
            bitmap2.recycle();
        }
        this.e.reset();
        a(h());
        this.l = e();
        if (z && this.a != null) {
            float width2 = ((float) this.j) / ((float) this.a.getWidth());
            if (!this.s || (((float) this.a.getHeight()) / ((float) this.a.getWidth()) <= 5.0f && (!this.r || ((float) this.a.getHeight()) / ((float) this.a.getWidth()) <= 2.0f))) {
                i = 0;
                width2 = 0.0f;
            }
            if (i != 0) {
                width2 /= d();
                this.d.reset();
                this.e.postScale(width2, width2, 0.0f, 0.0f);
                a(h());
                return;
            }
            a(f());
        }
    }

    public final void a(ViewPager viewPager) {
        this.c = viewPager;
    }

    public final void a(a aVar) {
        this.b = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean a(float f, float f2) {
        return this.e.postTranslate(f, f2);
    }

    public final void b() {
        if (!(this.a == null || this.a.isRecycled())) {
            this.a.recycle();
        }
        this.a = null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(float f, float f2) {
        final long currentTimeMillis = System.currentTimeMillis();
        final float f3 = f;
        final float f4 = f2;
        this.p = new Runnable() {
            float a;
            float b;
            final /* synthetic */ float c = 300.0f;

            public final void run() {
                float min = Math.min(this.c, (float) (System.currentTimeMillis() - currentTimeMillis));
                float c = ((min / this.c) - 1.0f);
                float c2 = ((min / this.c) - 1.0f);
                BaseZoomableImageView.this.a(c - this.a, c2 - this.b);
                BaseZoomableImageView.this.c();
                this.a = c;
                this.b = c2;
                if (min < this.c) {
                    BaseZoomableImageView.this.q = BaseZoomableImageView.this.post(this);
                } else {
                    BaseZoomableImageView.this.g();
                }
            }
        };
        this.q = post(this.p);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(float f, float f2, float f3) {
        final float d = (f - d()) / 200.0f;
        final float d2 = d();
        final long currentTimeMillis = System.currentTimeMillis();
        final float f4 = f2;
        final float f5 = f3;
        post(new Runnable() {
            final /* synthetic */ float a = 200.0f;

            public final void run() {
                float min = Math.min(this.a, (float) (System.currentTimeMillis() - currentTimeMillis));
                BaseZoomableImageView.this.a(d2 + (d * min), f4, f5);
                if (min < this.a) {
                    BaseZoomableImageView.this.post(this);
                }
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean b(float f) {
        try {
            if (this.f != null) {
                float a = a(this.f, 2);
                float width = ((float) getWidth()) - a;
                if ((a == 0.0f && f <= 0.0f) || (width == ((float) this.a.getWidth()) * a(this.f, 0) && f >= 0.0f)) {
                    System.out.println("ScrollOver");
                    return true;
                }
            }
        } catch (IllegalArgumentException e) {
            Log.v("Vincent", "isScrollOver");
            e.printStackTrace();
        }
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void c() {
        if (this.a != null) {
            float f;
            Matrix h = h();
            float[] fArr = new float[]{0.0f, 0.0f};
            float[] fArr2 = new float[]{(float) this.a.getWidth(), (float) this.a.getHeight()};
            h.mapPoints(fArr);
            h.mapPoints(fArr2);
            float f2 = fArr2[1] - fArr[1];
            float f3 = fArr2[0] - fArr[0];
            float height = (float) getHeight();
            float f4 = 0.0f;
            f2 = f2 < height ? ((height - f2) / 2.0f) - fArr[1] : fArr[1] > 0.0f ? -fArr[1] : fArr2[1] < height ? ((float) getHeight()) - fArr2[1] : 0.0f;
            float width = (float) getWidth();
            if (f3 < width) {
                width = (width - f3) / 2.0f;
                f = fArr[0];
            } else {
                if (fArr[0] > 0.0f) {
                    f4 = -fArr[0];
                } else if (fArr2[0] < width) {
                    f = fArr2[0];
                }
                a(f4, f2);
                a(h());
            }
            f4 = width - f;
            a(f4, f2);
            a(h());
        }
    }

    public final float d() {
        return this.a != null ? a(this.e, 0) : 1.0f;
    }

    /* Access modifiers changed, original: protected|final */
    public final float e() {
        if (this.a == null) {
            return 1.0f;
        }
        float max = Math.max(((float) this.a.getWidth()) / ((float) this.j), ((float) this.a.getHeight()) / ((float) this.k)) * 16.0f;
        if (max < 1.0f) {
            max = 1.0f;
        }
        return max;
    }

    public final float f() {
        return this.a == null ? 1.0f : Math.max(Math.min(((float) this.j) / ((float) this.a.getWidth()), ((float) this.k) / ((float) this.a.getHeight())), 1.0f);
    }

    /* Access modifiers changed, original: protected|final */
    public final void g() {
        removeCallbacks(this.p);
        if (this.q) {
            this.q = false;
        }
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"NewApi"})
    public void onDraw(Canvas canvas) {
        if (!(this.a == null || this.a.isRecycled())) {
            if (VERSION.SDK_INT >= 14 && getLayerType() == 2) {
                canvas.drawBitmap(this.a, this.g, null);
            } else if (((double) System.currentTimeMillis()) - this.o > 250.0d) {
                canvas.drawBitmap(this.a, this.g, this.h);
                this.o = (double) System.currentTimeMillis();
            } else {
                canvas.drawBitmap(this.a, this.g, null);
                removeCallbacks(this.n);
                postDelayed(this.n, 250);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.j = i3 - i;
        this.k = i4 - i2;
        Runnable runnable = this.m;
        if (runnable != null) {
            this.m = null;
            runnable.run();
        }
    }
}
