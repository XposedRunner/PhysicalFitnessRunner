package defpackage;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.yalantis.ucrop.view.CropImageView;

/* compiled from: Scale */
/* renamed from: b */
public class b extends oOOo0000 {
    /* Access modifiers changed, original: protected */
    public long O000000o(long j) {
        return j;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(View view) {
        AnimatorSet O00000Oo = O00000Oo();
        r1 = new Animator[4];
        r1[0] = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) ((-view.getHeight()) / 2), CropImageView.DEFAULT_ASPECT_RATIO}).setDuration(this.O00000Oo);
        r1[1] = ObjectAnimator.ofFloat(view, "scaleX", new float[]{0.3f, 0.5f, 1.0f}).setDuration(this.O00000Oo);
        r1[2] = ObjectAnimator.ofFloat(view, "scaleY", new float[]{0.3f, 0.5f, 1.0f, 1.1f, 1.0f}).setDuration(this.O00000Oo);
        r1[3] = ObjectAnimator.ofFloat(view, "alpha", new float[]{CropImageView.DEFAULT_ASPECT_RATIO, 1.0f}).setDuration((this.O00000Oo * 3) / 2);
        O00000Oo.playTogether(r1);
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(View view) {
        AnimatorSet O00000Oo = O00000Oo();
        r1 = new Animator[4];
        r1[0] = ObjectAnimator.ofFloat(view, "translationY", new float[]{CropImageView.DEFAULT_ASPECT_RATIO, (float) ((-view.getHeight()) / 2)}).setDuration(this.O00000Oo);
        r1[1] = ObjectAnimator.ofFloat(view, "scaleX", new float[]{1.0f, 0.5f, CropImageView.DEFAULT_ASPECT_RATIO}).setDuration(this.O00000Oo);
        r1[2] = ObjectAnimator.ofFloat(view, "scaleY", new float[]{1.0f, 0.5f, CropImageView.DEFAULT_ASPECT_RATIO}).setDuration(this.O00000Oo);
        r1[3] = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, CropImageView.DEFAULT_ASPECT_RATIO}).setDuration((this.O00000Oo * 3) / 2);
        O00000Oo.playTogether(r1);
    }
}
