package com.ms.square.android.expandabletextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableTextView extends LinearLayout implements OnClickListener {
    private static final int O00000o = 8;
    private static final String O00000o0 = "ExpandableTextView";
    private static final int O00000oO = 300;
    private static final float O00000oo = 0.7f;
    protected TextView O000000o;
    protected ImageButton O00000Oo;
    private boolean O0000O0o;
    private boolean O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private boolean O0000o;
    private Drawable O0000o0;
    private Drawable O0000o00;
    private int O0000o0O;
    private float O0000o0o;
    private SparseBooleanArray O0000oO;
    private O00000Oo O0000oO0;
    private int O0000oOO;

    class O000000o extends Animation {
        private final View O00000Oo;
        private final int O00000o;
        private final int O00000o0;

        public O000000o(View view, int i, int i2) {
            this.O00000Oo = view;
            this.O00000o0 = i;
            this.O00000o = i2;
            setDuration((long) ExpandableTextView.this.O0000o0O);
        }

        /* Access modifiers changed, original: protected */
        public void applyTransformation(float f, Transformation transformation) {
            int i = (int) ((((float) (this.O00000o - this.O00000o0)) * f) + ((float) this.O00000o0));
            ExpandableTextView.this.O000000o.setMaxHeight(i - ExpandableTextView.this.O0000Ooo);
            if (Float.compare(ExpandableTextView.this.O0000o0o, 1.0f) != 0) {
                ExpandableTextView.O00000Oo(ExpandableTextView.this.O000000o, ExpandableTextView.this.O0000o0o + (f * (1.0f - ExpandableTextView.this.O0000o0o)));
            }
            this.O00000Oo.getLayoutParams().height = i;
            this.O00000Oo.requestLayout();
        }

        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
        }

        public boolean willChangeBounds() {
            return true;
        }
    }

    public interface O00000Oo {
        void O000000o(TextView textView, boolean z);
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0000OOo = true;
        O000000o(attributeSet);
    }

    @TargetApi(11)
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000OOo = true;
        O000000o(attributeSet);
    }

    private static int O000000o(@NonNull TextView textView) {
        return textView.getLayout().getLineTop(textView.getLineCount()) + (textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom());
    }

    @TargetApi(21)
    private static Drawable O000000o(@NonNull Context context, int i) {
        Resources resources = context.getResources();
        return O00000o0() ? resources.getDrawable(i, context.getTheme()) : resources.getDrawable(i);
    }

    private void O000000o() {
        this.O000000o = (TextView) findViewById(R.id.expandable_text);
        this.O000000o.setOnClickListener(this);
        this.O00000Oo = (ImageButton) findViewById(R.id.expand_collapse);
        this.O00000Oo.setImageDrawable(this.O0000OOo ? this.O0000o00 : this.O0000o0);
        this.O00000Oo.setOnClickListener(this);
    }

    private void O000000o(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView);
        this.O0000OoO = obtainStyledAttributes.getInt(R.styleable.ExpandableTextView_maxCollapsedLines, 8);
        this.O0000o0O = obtainStyledAttributes.getInt(R.styleable.ExpandableTextView_animDuration, 300);
        this.O0000o0o = obtainStyledAttributes.getFloat(R.styleable.ExpandableTextView_animAlphaStart, 0.7f);
        this.O0000o00 = obtainStyledAttributes.getDrawable(R.styleable.ExpandableTextView_expandDrawable);
        this.O0000o0 = obtainStyledAttributes.getDrawable(R.styleable.ExpandableTextView_collapseDrawable);
        if (this.O0000o00 == null) {
            this.O0000o00 = O000000o(getContext(), R.drawable.ic_expand_small_holo_light);
        }
        if (this.O0000o0 == null) {
            this.O0000o0 = O000000o(getContext(), R.drawable.ic_collapse_small_holo_light);
        }
        obtainStyledAttributes.recycle();
        setOrientation(1);
        setVisibility(8);
    }

    @TargetApi(11)
    private static void O00000Oo(View view, float f) {
        if (O00000Oo()) {
            view.setAlpha(f);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private static boolean O00000Oo() {
        return VERSION.SDK_INT >= 11;
    }

    private static boolean O00000o0() {
        return VERSION.SDK_INT >= 21;
    }

    public void O000000o(@Nullable CharSequence charSequence, @NonNull SparseBooleanArray sparseBooleanArray, int i) {
        this.O0000oO = sparseBooleanArray;
        this.O0000oOO = i;
        boolean z = sparseBooleanArray.get(i, true);
        clearAnimation();
        this.O0000OOo = z;
        this.O00000Oo.setImageDrawable(this.O0000OOo ? this.O0000o00 : this.O0000o0);
        setText(charSequence);
        getLayoutParams().height = -2;
        requestLayout();
    }

    @Nullable
    public CharSequence getText() {
        return this.O000000o == null ? "" : this.O000000o.getText();
    }

    public void onClick(View view) {
        if (this.O00000Oo.getVisibility() == 0) {
            this.O0000OOo ^= 1;
            this.O00000Oo.setImageDrawable(this.O0000OOo ? this.O0000o00 : this.O0000o0);
            if (this.O0000oO != null) {
                this.O0000oO.put(this.O0000oOO, this.O0000OOo);
            }
            this.O0000o = true;
            Animation o000000o = this.O0000OOo ? new O000000o(this, getHeight(), this.O0000Oo0) : new O000000o(this, getHeight(), (getHeight() + this.O0000Oo) - this.O000000o.getHeight());
            o000000o.setFillAfter(true);
            o000000o.setAnimationListener(new AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    ExpandableTextView.this.clearAnimation();
                    ExpandableTextView.this.O0000o = false;
                    if (ExpandableTextView.this.O0000oO0 != null) {
                        ExpandableTextView.this.O0000oO0.O000000o(ExpandableTextView.this.O000000o, ExpandableTextView.this.O0000OOo ^ 1);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    ExpandableTextView.O00000Oo(ExpandableTextView.this.O000000o, ExpandableTextView.this.O0000o0o);
                }
            });
            clearAnimation();
            startAnimation(o000000o);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        O000000o();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.O0000o;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (!this.O0000O0o || getVisibility() == 8) {
            super.onMeasure(i, i2);
            return;
        }
        this.O0000O0o = false;
        this.O00000Oo.setVisibility(8);
        this.O000000o.setMaxLines(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        super.onMeasure(i, i2);
        if (this.O000000o.getLineCount() > this.O0000OoO) {
            this.O0000Oo = O000000o(this.O000000o);
            if (this.O0000OOo) {
                this.O000000o.setMaxLines(this.O0000OoO);
            }
            this.O00000Oo.setVisibility(0);
            super.onMeasure(i, i2);
            if (this.O0000OOo) {
                this.O000000o.post(new Runnable() {
                    public void run() {
                        ExpandableTextView.this.O0000Ooo = ExpandableTextView.this.getHeight() - ExpandableTextView.this.O000000o.getHeight();
                    }
                });
                this.O0000Oo0 = getMeasuredHeight();
            }
        }
    }

    public void setOnExpandStateChangeListener(@Nullable O00000Oo o00000Oo) {
        this.O0000oO0 = o00000Oo;
    }

    public void setOrientation(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
        }
        super.setOrientation(i);
    }

    public void setText(@Nullable CharSequence charSequence) {
        this.O0000O0o = true;
        this.O000000o.setText(charSequence);
        setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }
}
