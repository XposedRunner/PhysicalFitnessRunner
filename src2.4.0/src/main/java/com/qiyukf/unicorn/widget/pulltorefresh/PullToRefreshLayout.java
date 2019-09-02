package com.qiyukf.unicorn.widget.pulltorefresh;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qiyukf.unicorn.R;
import java.util.Timer;
import java.util.TimerTask;

public class PullToRefreshLayout extends FrameLayout {
    private Runnable A;
    private int a;
    private a b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private b h;
    private Handler i;
    private boolean j;
    private boolean k;
    private float l;
    private RotateAnimation m;
    private RotateAnimation n;
    private View o;
    private ImageView p;
    private ProgressBar q;
    private TextView r;
    private View s;
    private ImageView t;
    private ProgressBar u;
    private TextView v;
    private View w;
    private int x;
    private boolean y;
    private boolean z;

    public interface a {
        void d();
    }

    private class b {
        private Timer b = new Timer();
        private a c;
        private boolean d = false;

        private class a extends TimerTask {
            private a() {
            }

            /* synthetic */ a(b bVar, byte b) {
                this();
            }

            public final void run() {
                PullToRefreshLayout.this.i.post(PullToRefreshLayout.this.A);
            }
        }

        public final void a() {
            if (!this.d) {
                if (this.c != null) {
                    this.c.cancel();
                    this.c = null;
                }
                this.c = new a(this, (byte) 0);
                this.b.schedule(this.c, 0, 5);
            }
        }

        public final void b() {
            if (this.c != null) {
                this.c.cancel();
                this.c = null;
            }
        }

        public final void c() {
            this.d = true;
            b();
            this.b.cancel();
        }
    }

    public PullToRefreshLayout(Context context) {
        this(context, null);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.c = 0.0f;
        this.d = 0.0f;
        this.f = 200.0f;
        this.g = 200.0f;
        this.h = new b();
        this.i = new Handler();
        this.j = false;
        this.k = false;
        this.l = 2.0f;
        this.y = true;
        this.z = true;
        this.A = new Runnable() {
            public final void run() {
                float tan = (float) (8.0d + (5.0d * Math.tan((1.5707963267948966d / ((double) PullToRefreshLayout.this.getMeasuredHeight())) * ((double) (PullToRefreshLayout.this.c + Math.abs(PullToRefreshLayout.this.d))))));
                if (!PullToRefreshLayout.this.k) {
                    if (PullToRefreshLayout.this.a == 2 && PullToRefreshLayout.this.c <= PullToRefreshLayout.this.f) {
                        PullToRefreshLayout.this.c = PullToRefreshLayout.this.f;
                    } else if (PullToRefreshLayout.this.a == 4 && (-PullToRefreshLayout.this.d) <= PullToRefreshLayout.this.g) {
                        PullToRefreshLayout.this.d = -PullToRefreshLayout.this.g;
                    }
                    PullToRefreshLayout.this.h.b();
                }
                if (PullToRefreshLayout.this.c > 0.0f) {
                    PullToRefreshLayout.this.c = PullToRefreshLayout.this.c - tan;
                } else if (PullToRefreshLayout.this.d < 0.0f) {
                    PullToRefreshLayout.this.d = PullToRefreshLayout.this.d + tan;
                }
                if (PullToRefreshLayout.this.c < 0.0f) {
                    PullToRefreshLayout.this.c = 0.0f;
                    PullToRefreshLayout.this.p.clearAnimation();
                    if (!(PullToRefreshLayout.this.a == 2 || PullToRefreshLayout.this.a == 4)) {
                        PullToRefreshLayout.this.b(0);
                    }
                    PullToRefreshLayout.this.h.b();
                    PullToRefreshLayout.this.requestLayout();
                }
                if (PullToRefreshLayout.this.d > 0.0f) {
                    PullToRefreshLayout.this.d = 0.0f;
                    PullToRefreshLayout.this.t.clearAnimation();
                    if (!(PullToRefreshLayout.this.a == 2 || PullToRefreshLayout.this.a == 4)) {
                        PullToRefreshLayout.this.b(0);
                    }
                    PullToRefreshLayout.this.h.b();
                    PullToRefreshLayout.this.requestLayout();
                }
                PullToRefreshLayout.this.requestLayout();
                if (PullToRefreshLayout.this.c + Math.abs(PullToRefreshLayout.this.d) == 0.0f) {
                    PullToRefreshLayout.this.h.b();
                }
            }
        };
        this.m = new RotateAnimation(0.0f, 180.0f, 1, 0.5f, 1, 0.5f);
        this.m.setInterpolator(new LinearInterpolator());
        this.m.setFillAfter(true);
        this.m.setDuration(100);
        this.n = new RotateAnimation(180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.n.setInterpolator(new LinearInterpolator());
        this.n.setFillAfter(true);
        this.n.setDuration(100);
    }

    private void a() {
        this.y = true;
        this.z = true;
    }

    private void b() {
        if (this.h != null) {
            this.h.a();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:17:0x0084 in {2, 4, 5, 7, 8, 9, 12, 15, 16} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    private void b(int r3) {
        /*
        r2 = this;
        r2.a = r3;
        r3 = r2.a;
        r0 = 4;
        r1 = 0;
        switch(r3) {
            case 0: goto L_0x0050;
            case 1: goto L_0x0044;
            case 2: goto L_0x0030;
            case 3: goto L_0x0021;
            case 4: goto L_0x000a;
            default: goto L_0x0009;
        };
        return;
        r3 = r2.t;
        r3.clearAnimation();
        r3 = r2.t;
        r3.setVisibility(r0);
        r3 = r2.u;
        r3.setVisibility(r1);
        r3 = r2.v;
        r0 = com.qiyukf.unicorn.R.string.ysf_ptr_loading;
        r3.setText(r0);
        return;
        r3 = r2.t;
        r0 = r2.m;
        r3.startAnimation(r0);
        r3 = r2.v;
        r0 = com.qiyukf.unicorn.R.string.ysf_ptr_release_to_load;
        r3.setText(r0);
        return;
        r3 = r2.p;
        r3.clearAnimation();
        r3 = r2.p;
        r3.setVisibility(r0);
        r3 = r2.q;
        r3.setVisibility(r1);
        r3 = r2.r;
        r0 = com.qiyukf.unicorn.R.string.ysf_ptr_refreshing;
        goto L_0x002c;
        r3 = r2.p;
        r0 = r2.m;
        r3.startAnimation(r0);
        r3 = r2.r;
        r0 = com.qiyukf.unicorn.R.string.ysf_ptr_release_to_refresh;
        goto L_0x002c;
        r3 = r2.p;
        r3 = r3.getAnimation();
        if (r3 == 0) goto L_0x005f;
        r3 = r2.p;
        r0 = r2.n;
        r3.startAnimation(r0);
        r3 = r2.p;
        r3.setVisibility(r1);
        r3 = r2.r;
        r0 = com.qiyukf.unicorn.R.string.ysf_ptr_pull_to_refresh;
        r3.setText(r0);
        r3 = r2.t;
        r3 = r3.getAnimation();
        if (r3 == 0) goto L_0x007a;
        r3 = r2.t;
        r0 = r2.n;
        r3.startAnimation(r0);
        r3 = r2.t;
        r3.setVisibility(r1);
        r3 = r2.v;
        r0 = com.qiyukf.unicorn.R.string.ysf_ptr_pull_to_load;
        goto L_0x002c;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout.b(int):void");
    }

    public final void a(int i) {
        TextView textView;
        int i2;
        this.u.setVisibility(4);
        if (i == 0) {
            textView = this.v;
            i2 = R.string.ysf_ptr_load_succeed;
        } else if (i != 2) {
            textView = this.v;
            i2 = R.string.ysf_ptr_load_failed;
        } else {
            textView = this.v;
            i2 = R.string.ysf_ptr_load_completed;
        }
        textView.setText(i2);
        if (this.d >= 0.0f || !(i == 1 || i == 2)) {
            b(5);
            post(new Runnable() {
                public final void run() {
                    ((a) PullToRefreshLayout.this.w).a((int) (-PullToRefreshLayout.this.d));
                    PullToRefreshLayout.this.d = 0.0f;
                    PullToRefreshLayout.this.requestLayout();
                }
            });
            return;
        }
        postDelayed(new Runnable() {
            public final void run() {
                PullToRefreshLayout.this.b(5);
                PullToRefreshLayout.this.b();
            }
        }, 1000);
    }

    public final void a(a aVar) {
        this.b = aVar;
    }

    /* JADX WARNING: Missing block: B:29:0x007f, code skipped:
            if (r9.a == 4) goto L_0x00b3;
     */
    /* JADX WARNING: Missing block: B:37:0x00b1, code skipped:
            if (r9.a == 2) goto L_0x00b3;
     */
    public boolean dispatchTouchEvent(android.view.MotionEvent r10) {
        /*
        r9 = this;
        r0 = r10.getActionMasked();
        r1 = 2;
        r2 = 4;
        r3 = 3;
        r4 = 0;
        r5 = 1;
        switch(r0) {
            case 0: goto L_0x0186;
            case 1: goto L_0x0155;
            case 2: goto L_0x0013;
            case 3: goto L_0x000c;
            case 4: goto L_0x000c;
            case 5: goto L_0x000e;
            case 6: goto L_0x000e;
            default: goto L_0x000c;
        };
    L_0x000c:
        goto L_0x0196;
    L_0x000e:
        r0 = -1;
        r9.x = r0;
        goto L_0x0196;
    L_0x0013:
        r0 = r9.x;
        r6 = 0;
        if (r0 != 0) goto L_0x00b6;
    L_0x0018:
        r0 = r9.c;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 > 0) goto L_0x0082;
    L_0x001e:
        r0 = r9.w;
        r0 = (com.qiyukf.unicorn.widget.pulltorefresh.a) r0;
        r0 = r0.a();
        if (r0 == 0) goto L_0x0031;
    L_0x0028:
        r0 = r9.y;
        if (r0 == 0) goto L_0x0031;
    L_0x002c:
        r0 = r9.a;
        if (r0 == r2) goto L_0x0031;
    L_0x0030:
        goto L_0x0082;
    L_0x0031:
        r0 = r9.d;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 < 0) goto L_0x004e;
    L_0x0037:
        r0 = r9.w;
        r0 = (com.qiyukf.unicorn.widget.pulltorefresh.a) r0;
        r0 = r0.b();
        if (r0 == 0) goto L_0x004a;
    L_0x0041:
        r0 = r9.z;
        if (r0 == 0) goto L_0x004a;
    L_0x0045:
        r0 = r9.a;
        if (r0 == r1) goto L_0x004a;
    L_0x0049:
        goto L_0x004e;
    L_0x004a:
        r9.a();
        goto L_0x00b8;
    L_0x004e:
        r0 = r9.d;
        r1 = r10.getY();
        r7 = r9.e;
        r1 = r1 - r7;
        r7 = r9.l;
        r1 = r1 / r7;
        r0 = r0 + r1;
        r9.d = r0;
        r0 = r9.d;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x0069;
    L_0x0063:
        r9.d = r6;
        r9.y = r5;
        r9.z = r4;
    L_0x0069:
        r0 = r9.d;
        r1 = r9.getMeasuredHeight();
        r1 = -r1;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x007d;
    L_0x0075:
        r0 = r9.getMeasuredHeight();
        r0 = -r0;
        r0 = (float) r0;
        r9.d = r0;
    L_0x007d:
        r0 = r9.a;
        if (r0 != r2) goto L_0x00b8;
    L_0x0081:
        goto L_0x00b3;
    L_0x0082:
        r0 = r9.c;
        r2 = r10.getY();
        r7 = r9.e;
        r2 = r2 - r7;
        r7 = r9.l;
        r2 = r2 / r7;
        r0 = r0 + r2;
        r9.c = r0;
        r0 = r9.c;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x009d;
    L_0x0097:
        r9.c = r6;
        r9.y = r4;
        r9.z = r5;
    L_0x009d:
        r0 = r9.c;
        r2 = r9.getMeasuredHeight();
        r2 = (float) r2;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00af;
    L_0x00a8:
        r0 = r9.getMeasuredHeight();
        r0 = (float) r0;
        r9.c = r0;
    L_0x00af:
        r0 = r9.a;
        if (r0 != r1) goto L_0x00b8;
    L_0x00b3:
        r9.k = r5;
        goto L_0x00b8;
    L_0x00b6:
        r9.x = r4;
    L_0x00b8:
        r0 = r10.getY();
        r9.e = r0;
        r0 = 4609753056924675352; // 0x3ff921fb54442d18 float:3.37028055E12 double:1.5707963267948966;
        r2 = r9.getMeasuredHeight();
        r7 = (double) r2;
        r0 = r0 / r7;
        r2 = r9.c;
        r7 = r9.d;
        r7 = java.lang.Math.abs(r7);
        r2 = r2 + r7;
        r7 = (double) r2;
        r0 = r0 * r7;
        r0 = java.lang.Math.tan(r0);
        r7 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r0 = r0 * r7;
        r7 = r7 + r0;
        r0 = (float) r7;
        r9.l = r0;
        r0 = r9.c;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 > 0) goto L_0x00eb;
    L_0x00e5:
        r0 = r9.d;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x00ee;
    L_0x00eb:
        r9.requestLayout();
    L_0x00ee:
        r0 = r9.c;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        r1 = 5;
        if (r0 <= 0) goto L_0x0118;
    L_0x00f5:
        r0 = r9.c;
        r2 = r9.f;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x0108;
    L_0x00fd:
        r0 = r9.a;
        if (r0 == r5) goto L_0x0105;
    L_0x0101:
        r0 = r9.a;
        if (r0 != r1) goto L_0x0108;
    L_0x0105:
        r9.b(r4);
    L_0x0108:
        r0 = r9.c;
        r1 = r9.f;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x0142;
    L_0x0110:
        r0 = r9.a;
        if (r0 != 0) goto L_0x0142;
    L_0x0114:
        r9.b(r5);
        goto L_0x0142;
    L_0x0118:
        r0 = r9.d;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x0142;
    L_0x011e:
        r0 = r9.d;
        r0 = -r0;
        r2 = r9.g;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x0132;
    L_0x0127:
        r0 = r9.a;
        if (r0 == r3) goto L_0x012f;
    L_0x012b:
        r0 = r9.a;
        if (r0 != r1) goto L_0x0132;
    L_0x012f:
        r9.b(r4);
    L_0x0132:
        r0 = r9.d;
        r0 = -r0;
        r1 = r9.g;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 < 0) goto L_0x0142;
    L_0x013b:
        r0 = r9.a;
        if (r0 != 0) goto L_0x0142;
    L_0x013f:
        r9.b(r3);
    L_0x0142:
        r0 = r9.c;
        r1 = r9.d;
        r1 = java.lang.Math.abs(r1);
        r0 = r0 + r1;
        r1 = 1090519040; // 0x41000000 float:8.0 double:5.38787994E-315;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0196;
    L_0x0151:
        r10.setAction(r3);
        goto L_0x0196;
    L_0x0155:
        r0 = r9.c;
        r6 = r9.f;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 > 0) goto L_0x0166;
    L_0x015d:
        r0 = r9.d;
        r0 = -r0;
        r6 = r9.g;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x0168;
    L_0x0166:
        r9.k = r4;
    L_0x0168:
        r0 = r9.a;
        if (r0 != r5) goto L_0x0172;
    L_0x016c:
        r9.b(r1);
        r0 = r9.b;
        goto L_0x0182;
    L_0x0172:
        r0 = r9.a;
        if (r0 != r3) goto L_0x0182;
    L_0x0176:
        r9.b(r2);
        r0 = r9.b;
        if (r0 == 0) goto L_0x0182;
    L_0x017d:
        r0 = r9.b;
        r0.d();
    L_0x0182:
        r9.b();
        goto L_0x0196;
    L_0x0186:
        r0 = r10.getY();
        r9.e = r0;
        r0 = r9.h;
        r0.b();
        r9.x = r4;
        r9.a();
    L_0x0196:
        r10 = super.dispatchTouchEvent(r10);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.o = LayoutInflater.from(getContext()).inflate(R.layout.ysf_ptr_header, this, false);
        this.s = LayoutInflater.from(getContext()).inflate(R.layout.ysf_ptr_footer, this, false);
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        addView(this.o, 0, layoutParams);
        addView(this.s, layoutParams);
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        this.h.c();
        super.onDetachedFromWindow();
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.j) {
            this.o = getChildAt(0);
            this.w = getChildAt(1);
            this.s = getChildAt(2);
            this.j = true;
            this.p = (ImageView) this.o.findViewById(R.id.ysf_ptr_header_pull_icon);
            this.q = (ProgressBar) this.o.findViewById(R.id.ysf_ptr_header_refreshing_icon);
            this.r = (TextView) this.o.findViewById(R.id.ysf_ptr_header_state_hint);
            this.t = (ImageView) this.s.findViewById(R.id.ysf_ptr_footer_pull_icon);
            this.u = (ProgressBar) this.s.findViewById(R.id.ysf_ptr_footer_loading_icon);
            this.v = (TextView) this.s.findViewById(R.id.ysf_ptr_footer_state_hint);
            this.f = (float) ((ViewGroup) this.o).getChildAt(0).getMeasuredHeight();
            this.g = (float) ((ViewGroup) this.s).getChildAt(0).getMeasuredHeight();
        }
        this.o.layout(0, ((int) (this.c + this.d)) - this.o.getMeasuredHeight(), this.o.getMeasuredWidth(), (int) (this.c + this.d));
        this.w.layout(0, (int) (this.c + this.d), this.w.getMeasuredWidth(), ((int) (this.c + this.d)) + this.w.getMeasuredHeight());
        this.s.layout(0, ((int) (this.c + this.d)) + this.w.getMeasuredHeight(), this.s.getMeasuredWidth(), (((int) (this.c + this.d)) + this.w.getMeasuredHeight()) + this.s.getMeasuredHeight());
    }
}
