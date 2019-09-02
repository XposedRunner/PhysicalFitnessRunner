package defpackage;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.yalantis.ucrop.view.CropImageView;

/* compiled from: SlideOnTop */
/* renamed from: d */
public class d extends oOOo0000 {
    /* Access modifiers changed, original: protected */
    public long O000000o(long j) {
        return j;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(View view) {
        AnimatorSet O00000Oo = O00000Oo();
        Animator[] animatorArr = new Animator[1];
        animatorArr[0] = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) (-view.getWidth()), -10.0f, -20.0f, -5.0f, -10.0f, CropImageView.DEFAULT_ASPECT_RATIO}).setDuration(this.O00000Oo);
        O00000Oo.playTogether(animatorArr);
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(View view) {
        AnimatorSet O00000Oo = O00000Oo();
        Animator[] animatorArr = new Animator[1];
        animatorArr[0] = ObjectAnimator.ofFloat(view, "translationY", new float[]{CropImageView.DEFAULT_ASPECT_RATIO, -10.0f, -5.0f, (float) (-view.getWidth())}).setDuration(this.O00000Oo);
        O00000Oo.playTogether(animatorArr);
    }
}
