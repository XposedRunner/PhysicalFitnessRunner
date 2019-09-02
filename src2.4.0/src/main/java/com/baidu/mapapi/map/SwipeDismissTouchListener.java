package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;

public class SwipeDismissTouchListener implements OnTouchListener {
    private int a;
    private int b;
    private int c;
    private long d;
    private View e;
    private DismissCallbacks f;
    private int g = 1;
    private float h;
    private float i;
    private boolean j;
    private int k;
    private Object l;
    private VelocityTracker m;
    private float n;
    private boolean o;
    private boolean p;

    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotify();
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.a = viewConfiguration.getScaledTouchSlop();
        this.b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.d = (long) view.getContext().getResources().getInteger(17694720);
        this.e = view;
        this.e.getContext();
        this.l = obj;
        this.f = dismissCallbacks;
    }

    @TargetApi(11)
    private void a() {
        LayoutParams layoutParams = this.e.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{this.e.getHeight(), 1}).setDuration(this.d);
        duration.addListener(new p(this, layoutParams, r1));
        duration.addUpdateListener(new q(this, layoutParams));
        duration.start();
    }

    /* JADX WARNING: Missing block: B:82:0x0186, code skipped:
            if (r10.j != false) goto L_0x0024;
     */
    @android.annotation.TargetApi(12)
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
        r10 = this;
        r11 = r10.n;
        r0 = 0;
        r12.offsetLocation(r11, r0);
        r11 = r10.g;
        r1 = 2;
        if (r11 >= r1) goto L_0x0013;
    L_0x000b:
        r11 = r10.e;
        r11 = r11.getWidth();
        r10.g = r11;
    L_0x0013:
        r11 = r12.getActionMasked();
        r1 = 3;
        r2 = 0;
        r3 = 1;
        r4 = 0;
        switch(r11) {
            case 0: goto L_0x018a;
            case 1: goto L_0x00db;
            case 2: goto L_0x0047;
            case 3: goto L_0x001f;
            default: goto L_0x001e;
        };
    L_0x001e:
        return r4;
    L_0x001f:
        r11 = r10.m;
        if (r11 != 0) goto L_0x0024;
    L_0x0023:
        return r4;
    L_0x0024:
        r11 = r10.e;
        r11 = r11.animate();
        r11 = r11.translationX(r0);
        r5 = r10.d;
        r11 = r11.setDuration(r5);
        r11.setListener(r2);
    L_0x0037:
        r11 = r10.m;
        r11.recycle();
        r10.m = r2;
        r10.n = r0;
        r10.h = r0;
        r10.i = r0;
        r10.j = r4;
        return r4;
    L_0x0047:
        r11 = r10.m;
        if (r11 != 0) goto L_0x004c;
    L_0x004b:
        return r4;
    L_0x004c:
        r11 = r10.m;
        r11.addMovement(r12);
        r11 = r12.getRawX();
        r2 = r10.h;
        r11 = r11 - r2;
        r2 = r12.getRawY();
        r5 = r10.i;
        r2 = r2 - r5;
        r5 = java.lang.Math.abs(r11);
        r6 = r10.a;
        r6 = (float) r6;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x00cb;
    L_0x006a:
        r2 = java.lang.Math.abs(r2);
        r5 = java.lang.Math.abs(r11);
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r5 / r6;
        r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r2 >= 0) goto L_0x00cb;
    L_0x0079:
        r10.j = r3;
        r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0082;
    L_0x007f:
        r0 = r10.a;
        goto L_0x0085;
    L_0x0082:
        r0 = r10.a;
        r0 = -r0;
    L_0x0085:
        r10.k = r0;
        r0 = r10.e;
        r0 = r0.getParent();
        r0.requestDisallowInterceptTouchEvent(r3);
        r0 = r10.o;
        if (r0 != 0) goto L_0x009b;
    L_0x0094:
        r10.o = r3;
        r0 = r10.f;
        r0.onNotify();
    L_0x009b:
        r0 = java.lang.Math.abs(r11);
        r2 = r10.g;
        r2 = r2 / r1;
        r2 = (float) r2;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00b3;
    L_0x00a7:
        r0 = r10.p;
        if (r0 != 0) goto L_0x00b5;
    L_0x00ab:
        r10.p = r3;
        r0 = r10.f;
        r0.onNotify();
        goto L_0x00b5;
    L_0x00b3:
        r10.p = r4;
    L_0x00b5:
        r0 = android.view.MotionEvent.obtain(r12);
        r12 = r12.getActionIndex();
        r12 = r12 << 8;
        r12 = r12 | r1;
        r0.setAction(r12);
        r12 = r10.e;
        r12.onTouchEvent(r0);
        r0.recycle();
    L_0x00cb:
        r12 = r10.j;
        if (r12 == 0) goto L_0x01ae;
    L_0x00cf:
        r10.n = r11;
        r12 = r10.e;
        r0 = r10.k;
        r0 = (float) r0;
        r11 = r11 - r0;
        r12.setTranslationX(r11);
        return r3;
    L_0x00db:
        r11 = r10.m;
        if (r11 != 0) goto L_0x00e0;
    L_0x00df:
        return r4;
    L_0x00e0:
        r11 = r12.getRawX();
        r5 = r10.h;
        r11 = r11 - r5;
        r5 = r10.m;
        r5.addMovement(r12);
        r12 = r10.m;
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12.computeCurrentVelocity(r5);
        r12 = r10.m;
        r12 = r12.getXVelocity();
        r5 = java.lang.Math.abs(r12);
        r6 = r10.m;
        r6 = r6.getYVelocity();
        r6 = java.lang.Math.abs(r6);
        r7 = java.lang.Math.abs(r11);
        r8 = r10.g;
        r8 = r8 / r1;
        r1 = (float) r8;
        r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1));
        if (r1 <= 0) goto L_0x0122;
    L_0x0113:
        r1 = r10.j;
        if (r1 == 0) goto L_0x0122;
    L_0x0117:
        r11 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r11 <= 0) goto L_0x011d;
    L_0x011b:
        r11 = r3;
        goto L_0x011e;
    L_0x011d:
        r11 = r4;
    L_0x011e:
        r9 = r3;
        r3 = r11;
        r11 = r9;
        goto L_0x015e;
    L_0x0122:
        r1 = r10.b;
        r1 = (float) r1;
        r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));
        if (r1 > 0) goto L_0x015c;
    L_0x0129:
        r1 = r10.c;
        r1 = (float) r1;
        r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));
        if (r1 > 0) goto L_0x015c;
    L_0x0130:
        r1 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r1 >= 0) goto L_0x015c;
    L_0x0134:
        r1 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r1 >= 0) goto L_0x015c;
    L_0x0138:
        r1 = r10.j;
        if (r1 == 0) goto L_0x015c;
    L_0x013c:
        r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r12 >= 0) goto L_0x0142;
    L_0x0140:
        r12 = r3;
        goto L_0x0143;
    L_0x0142:
        r12 = r4;
    L_0x0143:
        r11 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r11 >= 0) goto L_0x0149;
    L_0x0147:
        r11 = r3;
        goto L_0x014a;
    L_0x0149:
        r11 = r4;
    L_0x014a:
        if (r12 != r11) goto L_0x014e;
    L_0x014c:
        r11 = r3;
        goto L_0x014f;
    L_0x014e:
        r11 = r4;
    L_0x014f:
        r12 = r10.m;
        r12 = r12.getXVelocity();
        r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1));
        if (r12 <= 0) goto L_0x015a;
    L_0x0159:
        goto L_0x015e;
    L_0x015a:
        r3 = r4;
        goto L_0x015e;
    L_0x015c:
        r11 = r4;
        r3 = r11;
    L_0x015e:
        if (r11 == 0) goto L_0x0184;
    L_0x0160:
        r11 = r10.e;
        r11 = r11.animate();
        if (r3 == 0) goto L_0x016c;
    L_0x0168:
        r12 = r10.g;
    L_0x016a:
        r12 = (float) r12;
        goto L_0x0170;
    L_0x016c:
        r12 = r10.g;
        r12 = -r12;
        goto L_0x016a;
    L_0x0170:
        r11 = r11.translationX(r12);
        r5 = r10.d;
        r11 = r11.setDuration(r5);
        r12 = new com.baidu.mapapi.map.o;
        r12.<init>(r10);
        r11.setListener(r12);
        goto L_0x0037;
    L_0x0184:
        r11 = r10.j;
        if (r11 == 0) goto L_0x0037;
    L_0x0188:
        goto L_0x0024;
    L_0x018a:
        r11 = r12.getRawX();
        r10.h = r11;
        r11 = r12.getRawY();
        r10.i = r11;
        r11 = r10.f;
        r0 = r10.l;
        r11 = r11.canDismiss(r0);
        if (r11 == 0) goto L_0x01ad;
    L_0x01a0:
        r10.o = r4;
        r11 = android.view.VelocityTracker.obtain();
        r10.m = r11;
        r11 = r10.m;
        r11.addMovement(r12);
    L_0x01ad:
        return r3;
    L_0x01ae:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.SwipeDismissTouchListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
