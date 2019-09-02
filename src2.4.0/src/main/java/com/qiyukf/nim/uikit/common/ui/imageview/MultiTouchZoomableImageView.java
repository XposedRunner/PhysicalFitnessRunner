package com.qiyukf.nim.uikit.common.ui.imageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;

public class MultiTouchZoomableImageView extends BaseZoomableImageView {
    protected boolean d = false;
    private GestureDetector e;
    private ScaleGestureDetector f;
    private boolean g = false;

    private class a extends SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(MultiTouchZoomableImageView multiTouchZoomableImageView, byte b) {
            this();
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            if (MultiTouchZoomableImageView.this.d() != MultiTouchZoomableImageView.this.f()) {
                MultiTouchZoomableImageView.this.a(MultiTouchZoomableImageView.this.f());
            } else {
                MultiTouchZoomableImageView.this.b(MultiTouchZoomableImageView.this.f() * 3.0f, motionEvent.getX(), motionEvent.getY());
            }
            return true;
        }

        /* JADX WARNING: Missing block: B:7:0x0012, code skipped:
            return false;
     */
        public final boolean onFling(android.view.MotionEvent r6, android.view.MotionEvent r7, float r8, float r9) {
            /*
            r5 = this;
            r0 = 0;
            r1 = 1;
            if (r6 == 0) goto L_0x000a;
        L_0x0004:
            r2 = r6.getPointerCount();
            if (r2 > r1) goto L_0x0012;
        L_0x000a:
            if (r7 == 0) goto L_0x0013;
        L_0x000c:
            r2 = r7.getPointerCount();
            if (r2 <= r1) goto L_0x0013;
        L_0x0012:
            return r0;
        L_0x0013:
            r2 = com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView.this;
            r2 = r2.f;
            r2 = r2.isInProgress();
            if (r2 == 0) goto L_0x0020;
        L_0x001f:
            return r0;
        L_0x0020:
            r0 = r6.getX();
            r2 = r7.getX();
            r0 = r0 - r2;
            r2 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            r3 = 1128792064; // 0x43480000 float:200.0 double:5.5769738E-315;
            if (r0 <= 0) goto L_0x0041;
        L_0x0031:
            r0 = java.lang.Math.abs(r8);
            r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
            if (r0 <= 0) goto L_0x0041;
        L_0x0039:
            r0 = "MultiTouchZoomableImageView";
            r1 = "Fling Left";
        L_0x003d:
            android.util.Log.i(r0, r1);
            goto L_0x00af;
        L_0x0041:
            r0 = r7.getX();
            r4 = r6.getX();
            r0 = r0 - r4;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 <= 0) goto L_0x005b;
        L_0x004e:
            r0 = java.lang.Math.abs(r8);
            r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
            if (r0 <= 0) goto L_0x005b;
        L_0x0056:
            r0 = "MultiTouchZoomableImageView";
            r1 = "Fling Right";
            goto L_0x003d;
        L_0x005b:
            r0 = r6.getY();
            r4 = r7.getY();
            r0 = r0 - r4;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 <= 0) goto L_0x0075;
        L_0x0068:
            r0 = java.lang.Math.abs(r9);
            r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
            if (r0 <= 0) goto L_0x0075;
        L_0x0070:
            r0 = "MultiTouchZoomableImageView";
            r1 = "Fling Up";
            goto L_0x003d;
        L_0x0075:
            r0 = r7.getY();
            r4 = r6.getY();
            r0 = r0 - r4;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 <= 0) goto L_0x00af;
        L_0x0082:
            r0 = java.lang.Math.abs(r9);
            r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
            if (r0 <= 0) goto L_0x00af;
        L_0x008a:
            r0 = "MultiTouchZoomableImageView";
            r2 = "Fling Down";
            android.util.Log.i(r0, r2);
            r0 = com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView.this;
            r0 = r0.d;
            if (r0 != 0) goto L_0x00af;
        L_0x0097:
            r0 = com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView.this;
            r0 = r0.d();
            r2 = com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView.this;
            r2 = r2.f();
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 > 0) goto L_0x00af;
        L_0x00a7:
            r6 = com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView.this;
            r6 = r6.b;
            r6.c();
            return r1;
        L_0x00af:
            r0 = r7.getX();	 Catch:{ NullPointerException -> 0x00e6, IllegalArgumentException -> 0x00e2 }
            r1 = r6.getX();	 Catch:{ NullPointerException -> 0x00e6, IllegalArgumentException -> 0x00e2 }
            r0 = r0 - r1;
            r1 = r7.getY();	 Catch:{ NullPointerException -> 0x00e6, IllegalArgumentException -> 0x00e2 }
            r2 = r6.getY();	 Catch:{ NullPointerException -> 0x00e6, IllegalArgumentException -> 0x00e2 }
            r1 = r1 - r2;
            r2 = java.lang.Math.abs(r8);	 Catch:{ NullPointerException -> 0x00e6, IllegalArgumentException -> 0x00e2 }
            r3 = 1145569280; // 0x44480000 float:800.0 double:5.65986426E-315;
            r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
            if (r2 > 0) goto L_0x00d3;
        L_0x00cb:
            r2 = java.lang.Math.abs(r9);	 Catch:{ NullPointerException -> 0x00e6, IllegalArgumentException -> 0x00e2 }
            r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
            if (r2 <= 0) goto L_0x00e6;
        L_0x00d3:
            r2 = com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView.this;	 Catch:{ NullPointerException -> 0x00e6, IllegalArgumentException -> 0x00e2 }
            r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
            r0 = r0 / r3;
            r1 = r1 / r3;
            r2.b(r0, r1);	 Catch:{ NullPointerException -> 0x00e6, IllegalArgumentException -> 0x00e2 }
            r0 = com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView.this;	 Catch:{ NullPointerException -> 0x00e6, IllegalArgumentException -> 0x00e2 }
            r0.invalidate();	 Catch:{ NullPointerException -> 0x00e6, IllegalArgumentException -> 0x00e2 }
            goto L_0x00e6;
        L_0x00e2:
            r0 = move-exception;
            r0.printStackTrace();
        L_0x00e6:
            r6 = super.onFling(r6, r7, r8, r9);
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.nim.uikit.common.ui.imageview.MultiTouchZoomableImageView$a.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
        }

        public final void onLongPress(MotionEvent motionEvent) {
            if (MultiTouchZoomableImageView.this.b != null && !MultiTouchZoomableImageView.this.g) {
                MultiTouchZoomableImageView.this.b.b();
            }
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent != null) {
                try {
                    if (motionEvent.getPointerCount() <= 1) {
                    }
                    return false;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            if ((motionEvent2 == null || motionEvent2.getPointerCount() <= 1) && (MultiTouchZoomableImageView.this.f == null || !MultiTouchZoomableImageView.this.f.isInProgress())) {
                if (!MultiTouchZoomableImageView.this.d) {
                    if (MultiTouchZoomableImageView.this.d() <= MultiTouchZoomableImageView.this.f()) {
                        if (MultiTouchZoomableImageView.this.c != null) {
                            MultiTouchZoomableImageView.this.c.requestDisallowInterceptTouchEvent(false);
                            return true;
                        }
                        return true;
                    }
                }
                MultiTouchZoomableImageView.this.g();
                MultiTouchZoomableImageView.this.a(-f, -f2);
                if (MultiTouchZoomableImageView.this.b(f)) {
                    if (MultiTouchZoomableImageView.this.c != null) {
                        MultiTouchZoomableImageView.this.c.requestDisallowInterceptTouchEvent(false);
                    }
                } else if (MultiTouchZoomableImageView.this.c != null) {
                    MultiTouchZoomableImageView.this.c.requestDisallowInterceptTouchEvent(true);
                }
                MultiTouchZoomableImageView.this.c();
                return true;
            }
            return false;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (MultiTouchZoomableImageView.this.b == null) {
                return super.onSingleTapConfirmed(motionEvent);
            }
            MultiTouchZoomableImageView.this.b.a();
            return false;
        }
    }

    class b extends SimpleOnScaleGestureListener {
        b() {
        }

        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null && scaleGestureDetector.isInProgress()) {
                try {
                    MultiTouchZoomableImageView.this.a(Math.min(MultiTouchZoomableImageView.this.e(), Math.max(MultiTouchZoomableImageView.this.d() * scaleGestureDetector.getScaleFactor(), 1.0f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    MultiTouchZoomableImageView.this.invalidate();
                    MultiTouchZoomableImageView.this.g = true;
                    return true;
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

    public MultiTouchZoomableImageView(Context context) {
        super(context);
        a(context);
    }

    public MultiTouchZoomableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public MultiTouchZoomableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.f = new ScaleGestureDetector(context, new b());
        this.e = new GestureDetector(context, new a(this, (byte) 0));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if (this.c != null) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        this.c.requestDisallowInterceptTouchEvent(false);
                        this.g = false;
                        break;
                    case 2:
                        this.c.requestDisallowInterceptTouchEvent(true);
                        break;
                    default:
                        break;
                }
            }
            if (this.a != null) {
                this.f.onTouchEvent(motionEvent);
                if (!this.f.isInProgress()) {
                    this.e.onTouchEvent(motionEvent);
                    return true;
                }
                return true;
            }
            this.b.a();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
