package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.zjwh.android_wh_physicalfitness.R;

public class ExpandableLayout extends RelativeLayout {
    private Boolean O000000o = Boolean.valueOf(false);
    private Boolean O00000Oo = Boolean.valueOf(true);
    private FrameLayout O00000o;
    private Integer O00000o0;
    private FrameLayout O00000oO;
    private Animation O00000oo;
    private O000000o O0000O0o;
    private View O0000OOo;
    private int O0000Oo;
    private int O0000Oo0;

    public interface O000000o {
        void O000000o(View view, boolean z);
    }

    public ExpandableLayout(Context context) {
        super(context);
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet);
    }

    private void O000000o(Context context, AttributeSet attributeSet) {
        View inflate = View.inflate(context, R.layout.view_expandable, this);
        this.O00000oO = (FrameLayout) inflate.findViewById(R.id.view_expandable_headerlayout);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableLayout);
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(0, -1);
        this.O00000o = (FrameLayout) inflate.findViewById(R.id.view_expandable_contentLayout);
        if (resourceId == -1 || resourceId2 == -1) {
            throw new IllegalArgumentException("HeaderLayout and ContentLayout cannot be null!");
        } else if (!isInEditMode()) {
            this.O00000o0 = Integer.valueOf(obtainStyledAttributes.getInt(1, getContext().getResources().getInteger(17694720)));
            this.O0000OOo = View.inflate(context, resourceId, null);
            this.O0000OOo.setLayoutParams(new LayoutParams(-1, -2));
            this.O00000oO.addView(this.O0000OOo);
            View inflate2 = View.inflate(context, resourceId2, null);
            inflate2.setLayoutParams(new LayoutParams(-1, -2));
            this.O00000o.addView(inflate2);
            this.O00000oO.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!ExpandableLayout.this.O000000o.booleanValue()) {
                        if (ExpandableLayout.this.O00000Oo.booleanValue()) {
                            ExpandableLayout.this.O00000Oo(ExpandableLayout.this.O00000o);
                        } else {
                            ExpandableLayout.this.O000000o(ExpandableLayout.this.O00000o);
                        }
                        if (ExpandableLayout.this.O0000O0o != null) {
                            ExpandableLayout.this.O0000O0o.O000000o(ExpandableLayout.this, ExpandableLayout.this.O00000Oo.booleanValue());
                        }
                        ExpandableLayout.this.O000000o = Boolean.valueOf(true);
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                ExpandableLayout.this.O000000o = Boolean.valueOf(false);
                            }
                        }, (long) ExpandableLayout.this.O00000o0.intValue());
                    }
                }
            });
            obtainStyledAttributes.recycle();
        }
    }

    private void O000000o(final View view) {
        this.O00000oo = new Animation() {
            /* Access modifiers changed, original: protected */
            public void applyTransformation(float f, Transformation transformation) {
                if (f == 1.0f) {
                    ExpandableLayout.this.O00000Oo = Boolean.valueOf(true);
                    if (ExpandableLayout.this.O0000O0o != null) {
                        ExpandableLayout.this.O0000O0o.O000000o(ExpandableLayout.this, true);
                    }
                }
                ((RelativeLayout.LayoutParams) view.getLayoutParams()).setMargins(0, (int) (-(((float) ExpandableLayout.this.O0000Oo0) * (1.0f - f))), 0, 0);
                view.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        this.O00000oo.setDuration((long) this.O00000o0.intValue());
        view.startAnimation(this.O00000oo);
    }

    private void O00000Oo(final View view) {
        this.O00000oo = new Animation() {
            /* Access modifiers changed, original: protected */
            public void applyTransformation(float f, Transformation transformation) {
                if (f == 1.0f) {
                    ExpandableLayout.this.O00000Oo = Boolean.valueOf(false);
                    if (ExpandableLayout.this.O0000O0o != null) {
                        ExpandableLayout.this.O0000O0o.O000000o(ExpandableLayout.this, false);
                        return;
                    }
                    return;
                }
                ((RelativeLayout.LayoutParams) view.getLayoutParams()).setMargins(0, (int) (-(((float) ExpandableLayout.this.O0000Oo0) * f)), 0, 0);
                view.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        this.O00000oo.setDuration((long) this.O00000o0.intValue());
        view.startAnimation(this.O00000oo);
    }

    public Boolean O000000o() {
        return this.O00000Oo;
    }

    public void O00000Oo() {
        if (!this.O000000o.booleanValue()) {
            O000000o(this.O00000o);
            this.O000000o = Boolean.valueOf(true);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ExpandableLayout.this.O000000o = Boolean.valueOf(false);
                }
            }, (long) this.O00000o0.intValue());
        }
    }

    public void O00000o0() {
        if (!this.O000000o.booleanValue()) {
            O00000Oo(this.O00000o);
            this.O000000o = Boolean.valueOf(true);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    ExpandableLayout.this.O000000o = Boolean.valueOf(false);
                }
            }, (long) this.O00000o0.intValue());
        }
    }

    public FrameLayout getContentLayout() {
        return this.O00000o;
    }

    public FrameLayout getHeaderLayout() {
        return this.O00000oO;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        this.O00000o.measure(MeasureSpec.makeMeasureSpec(this.O0000OOo.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
        this.O0000Oo = this.O00000o.getMeasuredHeight();
        this.O0000Oo0 = (this.O0000Oo - this.O00000oO.getMeasuredHeight()) + 4;
        super.onMeasure(i, i2);
    }

    public void setLayoutAnimationListener(AnimationListener animationListener) {
        this.O00000oo.setAnimationListener(animationListener);
    }

    public void setOnExpandListener(O000000o o000000o) {
        this.O0000O0o = o000000o;
    }
}
