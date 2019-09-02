package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.Animation.AnimationListener;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;

public class l extends c {
    private Animator a = null;
    private long b = 0;
    private Interpolator c = null;
    private AnimationListener d = null;
    private int e = 1;
    private int f = 0;
    private Object[] g;

    @TargetApi(11)
    public class a implements TypeEvaluator {
        public Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = (double) f;
            return new LatLng(latLng.latitude + (d * (latLng2.latitude - latLng.latitude)), latLng.longitude + ((latLng2.longitude - latLng.longitude) * d));
        }
    }

    @TargetApi(11)
    public class b implements TypeEvaluator {
        public Object evaluate(float f, Object obj, Object obj2) {
            Point point = (Point) obj;
            Point point2 = (Point) obj2;
            return new Point((int) (((float) point.x) + (((float) (point2.x - point.x)) * f)), (int) (((float) point.y) + (f * ((float) (point2.y - point.y)))));
        }
    }

    public l(Point... pointArr) {
        this.g = pointArr;
    }

    public l(LatLng... latLngArr) {
        this.g = latLngArr;
    }

    /* Access modifiers changed, original: 0000 */
    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        String str;
        TypeEvaluator bVar;
        if (marker.isFixed()) {
            if (this.g[0] instanceof Point) {
                str = "fixedScreenPosition";
                bVar = new b();
            } else {
                throw new ClassCastException("if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
            }
        } else if (this.g[0] instanceof LatLng) {
            str = "position";
            bVar = new a();
        } else {
            throw new ClassCastException("if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
        }
        ObjectAnimator ofObject = ObjectAnimator.ofObject(marker, str, bVar, this.g);
        if (ofObject != null) {
            ofObject.setRepeatCount(this.f);
            ofObject.setRepeatMode(c());
            ofObject.setDuration(this.b);
            if (this.c != null) {
                ofObject.setInterpolator(this.c);
            }
        }
        return ofObject;
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
            animator.addListener(new m(this));
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
