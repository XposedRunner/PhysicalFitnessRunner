package com.qiyukf.nim.uikit.common.ui.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.qiyukf.unicorn.R;

public class ShapedImageView extends ImageView {
    private static final ScaleType a = ScaleType.CENTER_CROP;
    private static final Config b = Config.ARGB_8888;
    private final RectF c;
    private final RectF d;
    private final Matrix e;
    private final Paint f;
    private final Paint g;
    private final Paint h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Bitmap m;
    private BitmapShader n;
    private int o;
    private int p;
    private float q;
    private float r;
    private ColorFilter s;
    private boolean t;
    private boolean u;
    private boolean v;

    public ShapedImageView(Context context) {
        super(context);
        this.c = new RectF();
        this.d = new RectF();
        this.e = new Matrix();
        this.f = new Paint();
        this.g = new Paint();
        this.h = new Paint();
        this.i = ViewCompat.MEASURED_STATE_MASK;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        a();
    }

    public ShapedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShapedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new RectF();
        this.d = new RectF();
        this.e = new Matrix();
        this.f = new Paint();
        this.g = new Paint();
        this.h = new Paint();
        this.i = ViewCompat.MEASURED_STATE_MASK;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        TypedArray obtainAttributes = getResources().obtainAttributes(attributeSet, R.styleable.ShapedImageView);
        this.j = obtainAttributes.getDimensionPixelSize(R.styleable.ShapedImageView_ysf_siv_border_width, 0);
        this.i = obtainAttributes.getColor(R.styleable.ShapedImageView_ysf_siv_border_color, ViewCompat.MEASURED_STATE_MASK);
        this.v = obtainAttributes.getBoolean(R.styleable.ShapedImageView_ysf_siv_border_overlay, false);
        this.k = obtainAttributes.getColor(R.styleable.ShapedImageView_ysf_siv_fill_color, 0);
        this.l = obtainAttributes.getInteger(R.styleable.ShapedImageView_ysf_siv_shape, 0);
        obtainAttributes.recycle();
        a();
    }

    private static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, b) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), b);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void a() {
        super.setScaleType(a);
        this.t = true;
        if (this.u) {
            b();
            this.u = false;
        }
    }

    private void b() {
        if (!this.t) {
            this.u = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.m == null) {
                invalidate();
                return;
            }
            float height;
            float width;
            this.n = new BitmapShader(this.m, TileMode.CLAMP, TileMode.CLAMP);
            this.f.setAntiAlias(true);
            this.f.setShader(this.n);
            this.g.setStyle(Style.STROKE);
            this.g.setAntiAlias(true);
            this.g.setColor(this.i);
            this.g.setStrokeWidth((float) this.j);
            this.h.setStyle(Style.FILL);
            this.h.setAntiAlias(true);
            this.h.setColor(this.k);
            this.p = this.m.getHeight();
            this.o = this.m.getWidth();
            float f = 0.0f;
            this.d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.r = Math.min((this.d.height() - ((float) this.j)) / 2.0f, (this.d.width() - ((float) this.j)) / 2.0f);
            this.c.set(this.d);
            if (!this.v) {
                this.c.inset((float) this.j, (float) this.j);
            }
            this.q = Math.min(this.c.height() / 2.0f, this.c.width() / 2.0f);
            this.e.set(null);
            if (((float) this.o) * this.c.height() > this.c.width() * ((float) this.p)) {
                height = this.c.height() / ((float) this.p);
                width = (this.c.width() - (((float) this.o) * height)) * 0.5f;
            } else {
                height = this.c.width() / ((float) this.o);
                f = (this.c.height() - (((float) this.p) * height)) * 0.5f;
                width = 0.0f;
            }
            this.e.setScale(height, height);
            this.e.postTranslate(((float) ((int) (width + 0.5f))) + this.c.left, ((float) ((int) (f + 0.5f))) + this.c.top);
            this.n.setLocalMatrix(this.e);
            invalidate();
        }
    }

    public final void a(int i) {
        if (this.l != i && (i >= 0 || i <= 1)) {
            this.l = i;
        }
    }

    public ScaleType getScaleType() {
        return a;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        if (this.m != null) {
            if (this.l != 1) {
                if (this.k != 0) {
                    canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.q, this.h);
                }
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.q, this.f);
                if (this.j != 0) {
                    canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.r, this.g);
                }
                return;
            }
            if (this.k != 0) {
                canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.h);
            }
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f);
            if (this.j != 0) {
                canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.g);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b();
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.s) {
            this.s = colorFilter;
            this.f.setColorFilter(this.s);
            invalidate();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.m = bitmap;
        b();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.m = a(drawable);
        b();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.m = a(getDrawable());
        b();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.m = uri != null ? a(getDrawable()) : null;
        b();
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }
}
