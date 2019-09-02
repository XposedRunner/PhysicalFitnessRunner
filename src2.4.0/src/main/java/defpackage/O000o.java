package defpackage;

import android.content.Context;
import android.view.MotionEvent;
import com.yalantis.ucrop.view.CropImageView;

/* compiled from: RotationGestureDetector */
/* renamed from: O000o */
public class O000o {
    private static final float O000000o = 5.0f;
    private final O000000o O00000Oo;
    private float O00000o;
    private float O00000o0;
    private float O00000oO;
    private float O00000oo;
    private float O0000O0o;
    private boolean O0000OOo;
    private boolean O0000Oo0;

    /* compiled from: RotationGestureDetector */
    /* renamed from: O000o$O000000o */
    public interface O000000o {
        boolean O000000o(O000o o000o);

        boolean O00000Oo(O000o o000o);

        void O00000o0(O000o o000o);
    }

    public O000o(Context context, O000000o o000000o) {
    }

    private float O00000Oo(MotionEvent motionEvent) {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    private void O00000oO() {
    }

    private void O00000oo() {
    }

    private boolean O0000O0o() {
        return false;
    }

    public boolean O000000o() {
        return false;
    }

    public boolean O000000o(MotionEvent motionEvent) {
        return false;
    }

    public float O00000Oo() {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public float O00000o() {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public float O00000o0() {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }
}
