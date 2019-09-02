package com.zjwh.android_wh_physicalfitness.view.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import com.yalantis.ucrop.view.CropImageView;

/* compiled from: PhotoViewAttacher */
public class O0000o implements OnLayoutChangeListener, OnTouchListener {
    private static float O000000o = 3.0f;
    private static float O00000Oo = 1.75f;
    private static int O00000o = 200;
    private static float O00000o0 = 1.0f;
    private static final int O00000oO = -1;
    private static final int O00000oo = 0;
    private static final int O0000O0o = 1;
    private static final int O0000OOo = 2;
    private static int O0000Oo0 = 1;
    private Interpolator O0000Oo = new AccelerateDecelerateInterpolator();
    private int O0000OoO = O00000o;
    private float O0000Ooo = O00000o0;
    private ImageView O0000o;
    private float O0000o0 = O000000o;
    private float O0000o00 = O00000Oo;
    private boolean O0000o0O = true;
    private boolean O0000o0o = false;
    private O00000Oo O0000oO;
    private GestureDetector O0000oO0;
    private final Matrix O0000oOO = new Matrix();
    private final Matrix O0000oOo = new Matrix();
    private final RectF O0000oo = new RectF();
    private final Matrix O0000oo0 = new Matrix();
    private final float[] O0000ooO = new float[9];
    private O00000o O0000ooo;
    private O0000o0 O000O00o;
    private OnClickListener O000O0OO;
    private OnLongClickListener O000O0Oo;
    private O0000o00 O000O0o;
    private O0000Oo O000O0o0;
    private O00000Oo O000O0oO;
    private int O000O0oo = 2;
    private ScaleType O000OO = ScaleType.FIT_CENTER;
    private float O000OO00;
    private boolean O000OO0o = true;
    private O00000o0 O000OOOo = new O00000o0() {
        public void O000000o(float f, float f2) {
            if (!O0000o.this.O0000oO.O000000o()) {
                if (O0000o.this.O000O0o != null) {
                    O0000o.this.O000O0o.O000000o(f, f2);
                }
                O0000o.this.O0000oo0.postTranslate(f, f2);
                O0000o.this.O0000o0O();
                ViewParent parent = O0000o.this.O0000o.getParent();
                if (!O0000o.this.O0000o0O || O0000o.this.O0000oO.O000000o() || O0000o.this.O0000o0o) {
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                } else if ((O0000o.this.O000O0oo == 2 || ((O0000o.this.O000O0oo == 0 && f >= 1.0f) || (O0000o.this.O000O0oo == 1 && f <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }

        public void O000000o(float f, float f2, float f3) {
            if (O0000o.this.O00000oo() >= O0000o.this.O0000o0 && f >= 1.0f) {
                return;
            }
            if (O0000o.this.O00000oo() > O0000o.this.O0000Ooo || f > 1.0f) {
                if (O0000o.this.O00oOoOo != null) {
                    O0000o.this.O00oOoOo.O000000o(f, f2, f3);
                }
                O0000o.this.O0000oo0.postScale(f, f, f2, f3);
                O0000o.this.O0000o0O();
            }
        }

        public void O000000o(float f, float f2, float f3, float f4) {
            O0000o.this.O000O0oO = new O00000Oo(O0000o.this.O0000o.getContext());
            O0000o.this.O000O0oO.O000000o(O0000o.this.O000000o(O0000o.this.O0000o), O0000o.this.O00000Oo(O0000o.this.O0000o), (int) f3, (int) f4);
            O0000o.this.O0000o.post(O0000o.this.O000O0oO);
        }
    };
    private O0000Oo0 O00oOoOo;
    private O0000OOo O00oOooO;
    private O0000O0o O00oOooo;

    /* compiled from: PhotoViewAttacher */
    /* renamed from: com.zjwh.android_wh_physicalfitness.view.photoview.O0000o$4 */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] O000000o = new int[ScaleType.values().length];

        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        static {
            /*
            r0 = android.widget.ImageView.ScaleType.values();
            r0 = r0.length;
            r0 = new int[r0];
            O000000o = r0;
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.widget.ImageView.ScaleType.FIT_CENTER;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.widget.ImageView.ScaleType.FIT_START;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.widget.ImageView.ScaleType.FIT_END;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = O000000o;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = android.widget.ImageView.ScaleType.FIT_XY;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.view.photoview.O0000o$AnonymousClass4.<clinit>():void");
        }
    }

    /* compiled from: PhotoViewAttacher */
    private class O000000o implements Runnable {
        private final float O00000Oo;
        private final long O00000o = System.currentTimeMillis();
        private final float O00000o0;
        private final float O00000oO;
        private final float O00000oo;

        public O000000o(float f, float f2, float f3, float f4) {
            this.O00000Oo = f3;
            this.O00000o0 = f4;
            this.O00000oO = f;
            this.O00000oo = f2;
        }

        private float O000000o() {
            return O0000o.this.O0000Oo.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.O00000o)) * 1.0f) / ((float) O0000o.this.O0000OoO)));
        }

        public void run() {
            float O000000o = O000000o();
            O0000o.this.O000OOOo.O000000o((this.O00000oO + ((this.O00000oo - this.O00000oO) * O000000o)) / O0000o.this.O00000oo(), this.O00000Oo, this.O00000o0);
            if (O000000o < 1.0f) {
                O000000o.O000000o(O0000o.this.O0000o, this);
            }
        }
    }

    /* compiled from: PhotoViewAttacher */
    private class O00000Oo implements Runnable {
        private final OverScroller O00000Oo;
        private int O00000o;
        private int O00000o0;

        public O00000Oo(Context context) {
            this.O00000Oo = new OverScroller(context);
        }

        public void O000000o() {
            this.O00000Oo.forceFinished(true);
        }

        public void O000000o(int i, int i2, int i3, int i4) {
            RectF O00000Oo = O0000o.this.O00000Oo();
            if (O00000Oo != null) {
                int round;
                int i5;
                int round2;
                int i6;
                int round3 = Math.round(-O00000Oo.left);
                float f = (float) i;
                if (f < O00000Oo.width()) {
                    round = Math.round(O00000Oo.width() - f);
                    i5 = 0;
                } else {
                    i5 = round3;
                    round = i5;
                }
                int round4 = Math.round(-O00000Oo.top);
                float f2 = (float) i2;
                if (f2 < O00000Oo.height()) {
                    round2 = Math.round(O00000Oo.height() - f2);
                    i6 = 0;
                } else {
                    i6 = round4;
                    round2 = i6;
                }
                this.O00000o0 = round3;
                this.O00000o = round4;
                if (!(round3 == round && round4 == round2)) {
                    this.O00000Oo.fling(round3, round4, i3, i4, i5, round, i6, round2, 0, 0);
                }
            }
        }

        public void run() {
            if (!this.O00000Oo.isFinished() && this.O00000Oo.computeScrollOffset()) {
                int currX = this.O00000Oo.getCurrX();
                int currY = this.O00000Oo.getCurrY();
                O0000o.this.O0000oo0.postTranslate((float) (this.O00000o0 - currX), (float) (this.O00000o - currY));
                O0000o.this.O0000o0O();
                this.O00000o0 = currX;
                this.O00000o = currY;
                O000000o.O000000o(O0000o.this.O0000o, this);
            }
        }
    }

    public O0000o(ImageView imageView) {
        this.O0000o = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (!imageView.isInEditMode()) {
            this.O000OO00 = CropImageView.DEFAULT_ASPECT_RATIO;
            this.O0000oO = new O00000Oo(imageView.getContext(), this.O000OOOo);
            this.O0000oO0 = new GestureDetector(imageView.getContext(), new SimpleOnGestureListener() {
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    return (O0000o.this.O000O0o0 == null || O0000o.this.O00000oo() > O0000o.O00000o0 || motionEvent.getPointerCount() > O0000o.O0000Oo0 || motionEvent.getPointerCount() > O0000o.O0000Oo0) ? false : O0000o.this.O000O0o0.O000000o(motionEvent, motionEvent2, f, f2);
                }

                public void onLongPress(MotionEvent motionEvent) {
                    if (O0000o.this.O000O0Oo != null) {
                        O0000o.this.O000O0Oo.onLongClick(O0000o.this.O0000o);
                    }
                }
            });
            this.O0000oO0.setOnDoubleTapListener(new OnDoubleTapListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    try {
                        float O00000oo = O0000o.this.O00000oo();
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (O00000oo < O0000o.this.O00000o()) {
                            O0000o.this.O000000o(O0000o.this.O00000o(), x, y, true);
                        } else if (O00000oo < O0000o.this.O00000o() || O00000oo >= O0000o.this.O00000oO()) {
                            O0000o.this.O000000o(O0000o.this.O00000o0(), x, y, true);
                        } else {
                            O0000o.this.O000000o(O0000o.this.O00000oO(), x, y, true);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                    return true;
                }

                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    return false;
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    if (O0000o.this.O000O0OO != null) {
                        O0000o.this.O000O0OO.onClick(O0000o.this.O0000o);
                    }
                    RectF O00000Oo = O0000o.this.O00000Oo();
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (O0000o.this.O000O00o != null) {
                        O0000o.this.O000O00o.O000000o(O0000o.this.O0000o, x, y);
                    }
                    if (O00000Oo != null) {
                        if (O00000Oo.contains(x, y)) {
                            x = (x - O00000Oo.left) / O00000Oo.width();
                            y = (y - O00000Oo.top) / O00000Oo.height();
                            if (O0000o.this.O00oOooO != null) {
                                O0000o.this.O00oOooO.O000000o(O0000o.this.O0000o, x, y);
                            }
                            return true;
                        } else if (O0000o.this.O00oOooo != null) {
                            O0000o.this.O00oOooo.O000000o(O0000o.this.O0000o);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private float O000000o(Matrix matrix, int i) {
        matrix.getValues(this.O0000ooO);
        return this.O0000ooO[i];
    }

    private int O000000o(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private void O000000o(Drawable drawable) {
        if (drawable != null) {
            float O000000o = (float) O000000o(this.O0000o);
            float O00000Oo = (float) O00000Oo(this.O0000o);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.O0000oOO.reset();
            float f = (float) intrinsicWidth;
            float f2 = O000000o / f;
            float f3 = (float) intrinsicHeight;
            float f4 = O00000Oo / f3;
            if (this.O000OO != ScaleType.CENTER) {
                if (this.O000OO != ScaleType.CENTER_CROP) {
                    if (this.O000OO != ScaleType.CENTER_INSIDE) {
                        RectF rectF = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, f3);
                        RectF rectF2 = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, O000000o, O00000Oo);
                        if (((int) this.O000OO00) % 180 != 0) {
                            rectF = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f3, f);
                        }
                        switch (AnonymousClass4.O000000o[this.O000OO.ordinal()]) {
                            case 1:
                                this.O0000oOO.setRectToRect(rectF, rectF2, ScaleToFit.CENTER);
                                break;
                            case 2:
                                this.O0000oOO.setRectToRect(rectF, rectF2, ScaleToFit.START);
                                break;
                            case 3:
                                this.O0000oOO.setRectToRect(rectF, rectF2, ScaleToFit.END);
                                break;
                            case 4:
                                this.O0000oOO.setRectToRect(rectF, rectF2, ScaleToFit.FILL);
                                break;
                        }
                    }
                    f2 = Math.min(1.0f, Math.min(f2, f4));
                    this.O0000oOO.postScale(f2, f2);
                    this.O0000oOO.postTranslate((O000000o - (f * f2)) / 2.0f, (O00000Oo - (f3 * f2)) / 2.0f);
                } else {
                    f2 = Math.max(f2, f4);
                    this.O0000oOO.postScale(f2, f2);
                    this.O0000oOO.postTranslate((O000000o - (f * f2)) / 2.0f, (O00000Oo - (f3 * f2)) / 2.0f);
                }
            } else {
                this.O0000oOO.postTranslate((O000000o - f) / 2.0f, (O00000Oo - f3) / 2.0f);
            }
            O0000o0();
        }
    }

    private int O00000Oo(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private void O00000o(Matrix matrix) {
        this.O0000o.setImageMatrix(matrix);
        if (this.O0000ooo != null) {
            RectF O00000oO = O00000oO(matrix);
            if (O00000oO != null) {
                this.O0000ooo.O000000o(O00000oO);
            }
        }
    }

    private RectF O00000oO(Matrix matrix) {
        Drawable drawable = this.O0000o.getDrawable();
        if (drawable == null) {
            return null;
        }
        this.O0000oo.set(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        matrix.mapRect(this.O0000oo);
        return this.O0000oo;
    }

    private void O0000o() {
        if (this.O000O0oO != null) {
            this.O000O0oO.O000000o();
            this.O000O0oO = null;
        }
    }

    private void O0000o0() {
        this.O0000oo0.reset();
        O00000o0(this.O000OO00);
        O00000o(O0000o00());
        O0000o0o();
    }

    private Matrix O0000o00() {
        this.O0000oOo.set(this.O0000oOO);
        this.O0000oOo.postConcat(this.O0000oo0);
        return this.O0000oOo;
    }

    private void O0000o0O() {
        if (O0000o0o()) {
            O00000o(O0000o00());
        }
    }

    /* JADX WARNING: Missing block: B:22:0x0074, code skipped:
            r7 = r4;
     */
    /* JADX WARNING: Missing block: B:25:0x007f, code skipped:
            r9.O000O0oo = 2;
     */
    private boolean O0000o0o() {
        /*
        r9 = this;
        r0 = r9.O0000o00();
        r0 = r9.O00000oO(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r2 = r0.height();
        r3 = r0.width();
        r4 = r9.O0000o;
        r4 = r9.O00000Oo(r4);
        r4 = (float) r4;
        r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 0;
        if (r5 > 0) goto L_0x0040;
    L_0x0022:
        r5 = com.zjwh.android_wh_physicalfitness.view.photoview.O0000o.AnonymousClass4.O000000o;
        r8 = r9.O000OO;
        r8 = r8.ordinal();
        r5 = r5[r8];
        switch(r5) {
            case 2: goto L_0x003c;
            case 3: goto L_0x0036;
            default: goto L_0x002f;
        };
    L_0x002f:
        r4 = r4 - r2;
        r4 = r4 / r6;
        r2 = r0.top;
        r2 = r4 - r2;
        goto L_0x0056;
    L_0x0036:
        r4 = r4 - r2;
        r2 = r0.top;
        r2 = r4 - r2;
        goto L_0x0056;
    L_0x003c:
        r2 = r0.top;
        r2 = -r2;
        goto L_0x0056;
    L_0x0040:
        r2 = r0.top;
        r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r2 <= 0) goto L_0x004a;
    L_0x0046:
        r2 = r0.top;
        r2 = -r2;
        goto L_0x0056;
    L_0x004a:
        r2 = r0.bottom;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x0055;
    L_0x0050:
        r2 = r0.bottom;
        r2 = r4 - r2;
        goto L_0x0056;
    L_0x0055:
        r2 = r7;
    L_0x0056:
        r4 = r9.O0000o;
        r4 = r9.O000000o(r4);
        r4 = (float) r4;
        r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        r8 = 1;
        if (r5 > 0) goto L_0x0083;
    L_0x0062:
        r1 = com.zjwh.android_wh_physicalfitness.view.photoview.O0000o.AnonymousClass4.O000000o;
        r5 = r9.O000OO;
        r5 = r5.ordinal();
        r1 = r1[r5];
        switch(r1) {
            case 2: goto L_0x007b;
            case 3: goto L_0x0076;
            default: goto L_0x006f;
        };
    L_0x006f:
        r4 = r4 - r3;
        r4 = r4 / r6;
        r0 = r0.left;
        r4 = r4 - r0;
    L_0x0074:
        r7 = r4;
        goto L_0x007f;
    L_0x0076:
        r4 = r4 - r3;
        r0 = r0.left;
        r4 = r4 - r0;
        goto L_0x0074;
    L_0x007b:
        r0 = r0.left;
        r0 = -r0;
        r7 = r0;
    L_0x007f:
        r0 = 2;
        r9.O000O0oo = r0;
        goto L_0x009f;
    L_0x0083:
        r3 = r0.left;
        r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r3 <= 0) goto L_0x008f;
    L_0x0089:
        r9.O000O0oo = r1;
        r0 = r0.left;
        r7 = -r0;
        goto L_0x009f;
    L_0x008f:
        r1 = r0.right;
        r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
        if (r1 >= 0) goto L_0x009c;
    L_0x0095:
        r0 = r0.right;
        r7 = r4 - r0;
        r9.O000O0oo = r8;
        goto L_0x009f;
    L_0x009c:
        r0 = -1;
        r9.O000O0oo = r0;
    L_0x009f:
        r0 = r9.O0000oo0;
        r0.postTranslate(r7, r2);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.view.photoview.O0000o.O0000o0o():boolean");
    }

    public void O000000o(float f) {
        this.O000OO00 = f % 360.0f;
        O0000Oo0();
        O00000o0(this.O000OO00);
        O0000o0O();
    }

    public void O000000o(float f, float f2, float f3) {
        O00oOooO.O000000o(f, f2, f3);
        this.O0000Ooo = f;
        this.O0000o00 = f2;
        this.O0000o0 = f3;
    }

    public void O000000o(float f, float f2, float f3, boolean z) {
        if (f < this.O0000Ooo || f > this.O0000o0) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        } else if (z) {
            this.O0000o.post(new O000000o(O00000oo(), f, f2, f3));
        } else {
            this.O0000oo0.setScale(f, f, f2, f3);
            O0000o0O();
        }
    }

    public void O000000o(float f, boolean z) {
        O000000o(f, (float) (this.O0000o.getRight() / 2), (float) (this.O0000o.getBottom() / 2), z);
    }

    public void O000000o(int i) {
        this.O0000OoO = i;
    }

    public void O000000o(OnDoubleTapListener onDoubleTapListener) {
        this.O0000oO0.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void O000000o(OnClickListener onClickListener) {
        this.O000O0OO = onClickListener;
    }

    public void O000000o(OnLongClickListener onLongClickListener) {
        this.O000O0Oo = onLongClickListener;
    }

    public void O000000o(Interpolator interpolator) {
        this.O0000Oo = interpolator;
    }

    public void O000000o(ScaleType scaleType) {
        if (O00oOooO.O000000o(scaleType) && scaleType != this.O000OO) {
            this.O000OO = scaleType;
            O0000Oo0();
        }
    }

    public void O000000o(O00000o o00000o) {
        this.O0000ooo = o00000o;
    }

    public void O000000o(O0000O0o o0000O0o) {
        this.O00oOooo = o0000O0o;
    }

    public void O000000o(O0000OOo o0000OOo) {
        this.O00oOooO = o0000OOo;
    }

    public void O000000o(O0000Oo0 o0000Oo0) {
        this.O00oOoOo = o0000Oo0;
    }

    public void O000000o(O0000Oo o0000Oo) {
        this.O000O0o0 = o0000Oo;
    }

    public void O000000o(O0000o00 o0000o00) {
        this.O000O0o = o0000o00;
    }

    public void O000000o(O0000o0 o0000o0) {
        this.O000O00o = o0000o0;
    }

    public void O000000o(boolean z) {
        this.O0000o0O = z;
    }

    @Deprecated
    public boolean O000000o() {
        return this.O000OO0o;
    }

    public boolean O000000o(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        } else if (this.O0000o.getDrawable() == null) {
            return false;
        } else {
            this.O0000oo0.set(matrix);
            O0000o0O();
            return true;
        }
    }

    public RectF O00000Oo() {
        O0000o0o();
        return O00000oO(O0000o00());
    }

    public void O00000Oo(float f) {
        this.O0000oo0.setRotate(f % 360.0f);
        O0000o0O();
    }

    public void O00000Oo(Matrix matrix) {
        matrix.set(O0000o00());
    }

    public void O00000Oo(boolean z) {
        this.O000OO0o = z;
        O0000Oo0();
    }

    public float O00000o() {
        return this.O0000o00;
    }

    public void O00000o(float f) {
        O00oOooO.O000000o(f, this.O0000o00, this.O0000o0);
        this.O0000Ooo = f;
    }

    public float O00000o0() {
        return this.O0000Ooo;
    }

    public void O00000o0(float f) {
        this.O0000oo0.postRotate(f % 360.0f);
        O0000o0O();
    }

    public void O00000o0(Matrix matrix) {
        matrix.set(this.O0000oo0);
    }

    public float O00000oO() {
        return this.O0000o0;
    }

    public void O00000oO(float f) {
        O00oOooO.O000000o(this.O0000Ooo, f, this.O0000o0);
        this.O0000o00 = f;
    }

    public float O00000oo() {
        return (float) Math.sqrt((double) (((float) Math.pow((double) O000000o(this.O0000oo0, 0), 2.0d)) + ((float) Math.pow((double) O000000o(this.O0000oo0, 3), 2.0d))));
    }

    public void O00000oo(float f) {
        O00oOooO.O000000o(this.O0000Ooo, this.O0000o00, f);
        this.O0000o0 = f;
    }

    public ScaleType O0000O0o() {
        return this.O000OO;
    }

    public void O0000O0o(float f) {
        O000000o(f, false);
    }

    public boolean O0000OOo() {
        return this.O000OO0o;
    }

    public Matrix O0000Oo() {
        return this.O0000oOo;
    }

    public void O0000Oo0() {
        if (this.O000OO0o) {
            O000000o(this.O0000o.getDrawable());
        } else {
            O0000o0();
        }
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i != i5 || i2 != i6 || i3 != i7 || i4 != i8) {
            O000000o(this.O0000o.getDrawable());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b9  */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
        r10 = this;
        r0 = r10.O000OO0o;
        r1 = 0;
        r2 = 1;
        if (r0 == 0) goto L_0x00c2;
    L_0x0006:
        r0 = r11;
        r0 = (android.widget.ImageView) r0;
        r0 = com.zjwh.android_wh_physicalfitness.view.photoview.O00oOooO.O000000o(r0);
        if (r0 == 0) goto L_0x00c2;
    L_0x000f:
        r0 = r12.getAction();
        r3 = 3;
        if (r0 == r3) goto L_0x0027;
    L_0x0016:
        switch(r0) {
            case 0: goto L_0x001a;
            case 1: goto L_0x0027;
            default: goto L_0x0019;
        };
    L_0x0019:
        goto L_0x007a;
    L_0x001a:
        r11 = r11.getParent();
        if (r11 == 0) goto L_0x0023;
    L_0x0020:
        r11.requestDisallowInterceptTouchEvent(r2);
    L_0x0023:
        r10.O0000o();
        goto L_0x007a;
    L_0x0027:
        r0 = r10.O00000oo();
        r3 = r10.O0000Ooo;
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 >= 0) goto L_0x0050;
    L_0x0031:
        r0 = r10.O00000Oo();
        if (r0 == 0) goto L_0x007a;
    L_0x0037:
        r9 = new com.zjwh.android_wh_physicalfitness.view.photoview.O0000o$O000000o;
        r5 = r10.O00000oo();
        r6 = r10.O0000Ooo;
        r7 = r0.centerX();
        r8 = r0.centerY();
        r3 = r9;
        r4 = r10;
        r3.<init>(r5, r6, r7, r8);
        r11.post(r9);
        goto L_0x0078;
    L_0x0050:
        r0 = r10.O00000oo();
        r3 = r10.O0000o0;
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 <= 0) goto L_0x007a;
    L_0x005a:
        r0 = r10.O00000Oo();
        if (r0 == 0) goto L_0x007a;
    L_0x0060:
        r9 = new com.zjwh.android_wh_physicalfitness.view.photoview.O0000o$O000000o;
        r5 = r10.O00000oo();
        r6 = r10.O0000o0;
        r7 = r0.centerX();
        r8 = r0.centerY();
        r3 = r9;
        r4 = r10;
        r3.<init>(r5, r6, r7, r8);
        r11.post(r9);
    L_0x0078:
        r11 = r2;
        goto L_0x007b;
    L_0x007a:
        r11 = r1;
    L_0x007b:
        r0 = r10.O0000oO;
        if (r0 == 0) goto L_0x00b4;
    L_0x007f:
        r11 = r10.O0000oO;
        r11 = r11.O000000o();
        r0 = r10.O0000oO;
        r0 = r0.O00000Oo();
        r3 = r10.O0000oO;
        r3 = r3.O000000o(r12);
        if (r11 != 0) goto L_0x009d;
    L_0x0093:
        r11 = r10.O0000oO;
        r11 = r11.O000000o();
        if (r11 != 0) goto L_0x009d;
    L_0x009b:
        r11 = r2;
        goto L_0x009e;
    L_0x009d:
        r11 = r1;
    L_0x009e:
        if (r0 != 0) goto L_0x00aa;
    L_0x00a0:
        r0 = r10.O0000oO;
        r0 = r0.O00000Oo();
        if (r0 != 0) goto L_0x00aa;
    L_0x00a8:
        r0 = r2;
        goto L_0x00ab;
    L_0x00aa:
        r0 = r1;
    L_0x00ab:
        if (r11 == 0) goto L_0x00b0;
    L_0x00ad:
        if (r0 == 0) goto L_0x00b0;
    L_0x00af:
        r1 = r2;
    L_0x00b0:
        r10.O0000o0o = r1;
        r1 = r3;
        goto L_0x00b5;
    L_0x00b4:
        r1 = r11;
    L_0x00b5:
        r11 = r10.O0000oO0;
        if (r11 == 0) goto L_0x00c2;
    L_0x00b9:
        r11 = r10.O0000oO0;
        r11 = r11.onTouchEvent(r12);
        if (r11 == 0) goto L_0x00c2;
    L_0x00c1:
        r1 = r2;
    L_0x00c2:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.view.photoview.O0000o.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
