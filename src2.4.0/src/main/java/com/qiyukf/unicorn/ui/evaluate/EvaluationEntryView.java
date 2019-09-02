package com.qiyukf.unicorn.ui.evaluate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.unicorn.R;

public class EvaluationEntryView extends LinearLayout {
    private ImageView a;
    private TextView b;

    public EvaluationEntryView(Context context) {
        this(context, null);
    }

    public EvaluationEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setGravity(1);
        setOrientation(1);
        this.a = new ImageView(getContext());
        this.a.setPadding(0, d.a(5.0f), 0, d.a(5.0f));
        this.a.setScaleType(ScaleType.CENTER_INSIDE);
        addView(this.a, new LayoutParams(-2, -2));
        this.b = new TextView(getContext());
        this.b.setBackgroundResource(R.drawable.ysf_evaluation_dialog_select_text_bg_selector);
        this.b.setPadding(d.a(5.0f), d.a(3.0f), d.a(5.0f), d.a(3.0f));
        this.b.setTextColor(getResources().getColorStateList(R.color.ysf_evaluation_dialog_select_text_selector));
        this.b.setTextSize(9.0f);
        addView(this.b, new LayoutParams(-2, -2));
    }

    public final void a() {
        this.a.clearAnimation();
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(250);
        scaleAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(250);
        scaleAnimation2.setFillAfter(true);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        this.a.startAnimation(animationSet);
    }

    public final void a(int i) {
        this.a.setImageResource(i);
    }

    public final void a(String str) {
        this.b.setText(str);
    }
}
