package defpackage;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.yalantis.ucrop.view.CropImageView;

/* compiled from: Jelly */
/* renamed from: a */
public class a extends oOOo0000 {
    /* Access modifiers changed, original: protected */
    public long O000000o(long j) {
        return j;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(View view) {
        O00000Oo().playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "scaleX", new float[]{0.3f, 0.5f, 0.9f, 0.8f, 0.9f, 1.0f}).setDuration(this.O00000Oo), ObjectAnimator.ofFloat(view, "scaleY", new float[]{0.3f, 0.5f, 0.8f, 0.9f, 0.8f, 1.0f}).setDuration(this.O00000Oo), ObjectAnimator.ofFloat(view, "alpha", new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 1.0f}).setDuration((this.O00000Oo * 3) / 2)});
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(View view) {
        O00000Oo().playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, CropImageView.DEFAULT_ASPECT_RATIO}).setDuration((this.O00000Oo * 2) / 3)});
    }
}
