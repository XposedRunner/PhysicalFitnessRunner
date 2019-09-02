package com.zjwh.android_wh_physicalfitness.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import s.h.e.l.l.C;

/* compiled from: CusDialog */
public class O0000O0o extends Dialog {
    TextView O000000o;
    private Handler O00000Oo = new Handler();
    private Runnable O00000o0 = new Runnable() {
        public void run() {
            int parseInt = Integer.parseInt(O0000O0o.this.O000000o.getText().toString());
            if (parseInt != 1) {
                O0000O0o.this.O000000o();
                O0000O0o.this.O000000o.setText(String.valueOf(parseInt - 1));
                O0000O0o.this.O00000Oo.postDelayed(this, 1000);
            }
        }
    };

    static {
        C.i(16777377);
    }

    public O0000O0o(Context context) {
        super(context, R.style.fullscreen);
        setOwnerActivity((Activity) context);
    }

    private void O000000o() {
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(1000);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.8f);
        alphaAnimation.setDuration(1000);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.O000000o.startAnimation(animationSet);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.layout_popupwindow);
        this.O000000o = (TextView) findViewById(R.id.tv_time);
        this.O000000o.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Impact.ttf"));
        O000000o();
        this.O00000Oo.postDelayed(this.O00000o0, 1000);
    }

    public native void onStop();
}
