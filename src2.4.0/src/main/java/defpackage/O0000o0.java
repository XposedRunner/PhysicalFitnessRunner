package defpackage;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.OverScroller;
import java.util.List;

/* compiled from: GestureController */
/* renamed from: O0000o0 */
public class O0000o0 implements OnTouchListener {
    private static final float O000000o = 0.9f;
    private static final PointF O00000Oo = new PointF();
    private final int O00000o;
    private final int O00000o0;
    private final int O00000oO;
    private O00000o0 O00000oo;
    private O0000O0o O0000O0o;
    private final List<O00000o> O0000OOo;
    private final GestureDetector O0000Oo;
    private final O000OOOo O0000Oo0;
    private final ScaleGestureDetector O0000OoO;
    private final O000o O0000Ooo;
    private float O0000o;
    private boolean O0000o0;
    private boolean O0000o00;
    private boolean O0000o0O;
    private float O0000o0o;
    private boolean O0000oO;
    private boolean O0000oO0;
    private boolean O0000oOO;
    private boolean O0000oOo;
    private final OverScroller O0000oo;
    private O0000Oo0 O0000oo0;
    private final O00O00o0 O0000ooO;
    private final O000o000 O0000ooo;
    private final O000O00o O000O00o;
    private final O000O0OO O000O0OO;
    private final O000O0OO O000O0Oo;
    private final O000OOo O000O0o0;
    private final O000O0o0 O00oOoOo;
    private final O000O0OO O00oOooO;
    private final O000O0OO O00oOooo;

    /* compiled from: GestureController */
    /* renamed from: O0000o0$O000000o */
    private class O000000o implements defpackage.O000o.O000000o, OnDoubleTapListener, OnGestureListener, OnScaleGestureListener {
        final /* synthetic */ O0000o0 O000000o;

        private O000000o(O0000o0 o0000o0) {
        }

        /* synthetic */ O000000o(O0000o0 o0000o0, 1 1) {
        }

        public boolean O000000o(@NonNull O000o o000o) {
            return false;
        }

        public boolean O00000Oo(@NonNull O000o o000o) {
            return false;
        }

        public void O00000o0(@NonNull O000o o000o) {
        }

        public boolean onDoubleTap(@NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean onDoubleTapEvent(@NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean onDown(@NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean onFling(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onLongPress(@NonNull MotionEvent motionEvent) {
        }

        public boolean onScale(@NonNull ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        public boolean onScaleBegin(@NonNull ScaleGestureDetector scaleGestureDetector) {
            return false;
        }

        public void onScaleEnd(@NonNull ScaleGestureDetector scaleGestureDetector) {
        }

        public boolean onScroll(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void onShowPress(@NonNull MotionEvent motionEvent) {
        }

        public boolean onSingleTapConfirmed(@NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: GestureController */
    /* renamed from: O0000o0$O00000Oo */
    private class O00000Oo extends O000OOOo {
        final /* synthetic */ O0000o0 O000000o;

        O00000Oo(O0000o0 o0000o0, @NonNull View view) {
        }

        public boolean O000000o() {
            return false;
        }
    }

    /* compiled from: GestureController */
    /* renamed from: O0000o0$O00000o0 */
    public interface O00000o0 {
        void O000000o(@NonNull MotionEvent motionEvent);

        void O00000Oo(@NonNull MotionEvent motionEvent);

        boolean O00000o(@NonNull MotionEvent motionEvent);

        boolean O00000o0(@NonNull MotionEvent motionEvent);

        void O00000oO(@NonNull MotionEvent motionEvent);

        boolean O00000oo(@NonNull MotionEvent motionEvent);
    }

    /* compiled from: GestureController */
    /* renamed from: O0000o0$O00000o */
    public interface O00000o {
        void O000000o(O000O0OO o000o0oo);

        void O000000o(O000O0OO o000o0oo, O000O0OO o000o0oo2);
    }

    /* compiled from: GestureController */
    /* renamed from: O0000o0$O0000O0o */
    public interface O0000O0o {
        void O000000o(O0000Oo0 o0000Oo0);
    }

    /* compiled from: GestureController */
    /* renamed from: O0000o0$O0000OOo */
    public static class O0000OOo implements O00000o0 {
        public void O000000o(@NonNull MotionEvent motionEvent) {
        }

        public void O00000Oo(@NonNull MotionEvent motionEvent) {
        }

        public boolean O00000o(@NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean O00000o0(@NonNull MotionEvent motionEvent) {
            return false;
        }

        public void O00000oO(@NonNull MotionEvent motionEvent) {
        }

        public boolean O00000oo(@NonNull MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: GestureController */
    /* renamed from: O0000o0$O0000Oo0 */
    public enum O0000Oo0 {
        NONE,
        USER,
        ANIMATION
    }

    public O0000o0(@NonNull View view) {
    }

    private int O000000o(float f) {
        return 0;
    }

    private boolean O000000o(@Nullable O000O0OO o000o0oo, boolean z) {
        return false;
    }

    private void O0000o0O() {
    }

    public O000O00o O000000o() {
        return null;
    }

    public void O000000o(float f, float f2) {
    }

    public void O000000o(@Nullable O00000o0 o00000o0) {
    }

    public void O000000o(@NonNull O00000o o00000o) {
    }

    public void O000000o(@Nullable O0000O0o o0000O0o) {
    }

    public void O000000o(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(int i, int i2) {
        return false;
    }

    public boolean O000000o(@Nullable O000O0OO o000o0oo) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(O000o o000o) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(@NonNull MotionEvent motionEvent) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(ScaleGestureDetector scaleGestureDetector) {
        return false;
    }

    public O000O0OO O00000Oo() {
        return null;
    }

    public void O00000Oo(O00000o o00000o) {
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(@NonNull MotionEvent motionEvent) {
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000Oo(O000o o000o) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000Oo(@NonNull MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000Oo(ScaleGestureDetector scaleGestureDetector) {
        return false;
    }

    public void O00000o() {
    }

    /* Access modifiers changed, original: protected */
    public void O00000o(@NonNull MotionEvent motionEvent) {
    }

    public O000O0o0 O00000o0() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void O00000o0(O000o o000o) {
    }

    /* Access modifiers changed, original: protected */
    public void O00000o0(ScaleGestureDetector scaleGestureDetector) {
    }

    /* Access modifiers changed, original: protected */
    public void O00000o0(boolean z) {
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000o0(@NonNull MotionEvent motionEvent) {
        return false;
    }

    public void O00000oO() {
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000oO(MotionEvent motionEvent) {
        return false;
    }

    public boolean O00000oo() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000oo(MotionEvent motionEvent) {
        return false;
    }

    public boolean O0000O0o() {
        return false;
    }

    public boolean O0000OOo() {
        return false;
    }

    public void O0000Oo() {
    }

    public boolean O0000Oo0() {
        return false;
    }

    public void O0000OoO() {
    }

    public void O0000Ooo() {
    }

    /* Access modifiers changed, original: protected */
    public void O0000o0() {
    }

    /* Access modifiers changed, original: protected */
    public void O0000o00() {
    }

    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        return false;
    }
}
