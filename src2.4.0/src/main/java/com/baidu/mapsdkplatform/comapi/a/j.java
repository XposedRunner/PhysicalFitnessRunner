package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.Animation.AnimationListener;
import com.baidu.mapapi.map.Marker;

public class j extends c {
    private Animator a = null;
    private long b = 0;
    private Interpolator c = null;
    private AnimationListener d = null;
    private int e = 1;
    private int f = 0;
    private float[] g;
    private int h = 1;

    public j(int i, float... fArr) {
        this.g = fArr;
        this.h = i;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    @android.annotation.TargetApi(11)
    public android.animation.ObjectAnimator a(com.baidu.mapapi.map.Marker r3) {
        /*
        r2 = this;
        r0 = r2.h;
        r1 = 1;
        if (r0 != r1) goto L_0x000e;
    L_0x0005:
        r0 = "scaleX";
    L_0x0007:
        r1 = r2.g;
        r3 = android.animation.ObjectAnimator.ofFloat(r3, r0, r1);
        goto L_0x0017;
    L_0x000e:
        r0 = r2.h;
        r1 = 2;
        if (r0 != r1) goto L_0x0016;
    L_0x0013:
        r0 = "scaleY";
        goto L_0x0007;
    L_0x0016:
        r3 = 0;
    L_0x0017:
        if (r3 == 0) goto L_0x0033;
    L_0x0019:
        r0 = r2.f;
        r3.setRepeatCount(r0);
        r0 = r2.c();
        r3.setRepeatMode(r0);
        r0 = r2.b;
        r3.setDuration(r0);
        r0 = r2.c;
        if (r0 == 0) goto L_0x0033;
    L_0x002e:
        r0 = r2.c;
        r3.setInterpolator(r0);
    L_0x0033:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.a.j.a(com.baidu.mapapi.map.Marker):android.animation.ObjectAnimator");
    }

    @TargetApi(11)
    public void a() {
        if (this.a != null) {
            this.a.start();
        }
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.b = j;
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(11)
    public void a(Animator animator) {
        if (animator != null) {
            animator.addListener(new k(this));
        }
    }

    public void a(Interpolator interpolator) {
        this.c = interpolator;
    }

    public void a(AnimationListener animationListener) {
        this.d = animationListener;
    }

    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        this.a = a(marker);
        a(this.a);
    }

    @TargetApi(11)
    public void b() {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
    }

    public void b(int i) {
        if (i > 0) {
            this.f = i;
        }
    }

    public int c() {
        return this.e;
    }

    public void c(int i) {
    }
}
