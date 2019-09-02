package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import com.yalantis.ucrop.view.CropImageView;

/* compiled from: ScaleGestureDetectorFixed */
/* renamed from: oooOoO */
public class oooOoO extends ScaleGestureDetector {
    private float O000000o;
    private float O00000Oo;

    public oooOoO(Context context, OnScaleGestureListener onScaleGestureListener) {
    }

    private void O000000o() {
    }

    @TargetApi(19)
    private boolean O00000Oo() {
        return false;
    }

    public float getScaleFactor() {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        return false;
    }
}
