package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ActionBarContainer extends FrameLayout {
    private View mActionBarView;
    Drawable mBackground;
    private View mContextView;
    private int mHeight;
    boolean mIsSplit;
    boolean mIsStacked;
    private boolean mIsTransitioning;
    Drawable mSplitBackground;
    Drawable mStackedBackground;
    private View mTabContainer;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.setBackground(this, VERSION.SDK_INT >= 21 ? new ActionBarBackgroundDrawableV21(this) : new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.mBackground = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.mStackedBackground = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id.split_action_bar) {
            this.mIsSplit = true;
            this.mSplitBackground = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (this.mIsSplit ? this.mSplitBackground != null : !(this.mBackground == null && this.mStackedBackground == null)) {
            z = true;
        }
        setWillNotDraw(z);
    }

    private int getMeasuredHeightWithMargins(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return (view.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
    }

    private boolean isCollapsed(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mBackground != null && this.mBackground.isStateful()) {
            this.mBackground.setState(getDrawableState());
        }
        if (this.mStackedBackground != null && this.mStackedBackground.isStateful()) {
            this.mStackedBackground.setState(getDrawableState());
        }
        if (this.mSplitBackground != null && this.mSplitBackground.isStateful()) {
            this.mSplitBackground.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.mBackground != null) {
                this.mBackground.jumpToCurrentState();
            }
            if (this.mStackedBackground != null) {
                this.mStackedBackground.jumpToCurrentState();
            }
            if (this.mSplitBackground != null) {
                this.mSplitBackground.jumpToCurrentState();
            }
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = findViewById(R.id.action_bar);
        this.mContextView = findViewById(R.id.action_context_bar);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mIsTransitioning || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A:{SYNTHETIC, RETURN} */
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        /*
        r5 = this;
        super.onLayout(r6, r7, r8, r9, r10);
        r6 = r5.mTabContainer;
        r8 = 8;
        r10 = 1;
        r0 = 0;
        if (r6 == 0) goto L_0x0013;
    L_0x000b:
        r1 = r6.getVisibility();
        if (r1 == r8) goto L_0x0013;
    L_0x0011:
        r1 = r10;
        goto L_0x0014;
    L_0x0013:
        r1 = r0;
    L_0x0014:
        if (r6 == 0) goto L_0x0035;
    L_0x0016:
        r2 = r6.getVisibility();
        if (r2 == r8) goto L_0x0035;
    L_0x001c:
        r8 = r5.getMeasuredHeight();
        r2 = r6.getLayoutParams();
        r2 = (android.widget.FrameLayout.LayoutParams) r2;
        r3 = r6.getMeasuredHeight();
        r3 = r8 - r3;
        r4 = r2.bottomMargin;
        r3 = r3 - r4;
        r2 = r2.bottomMargin;
        r8 = r8 - r2;
        r6.layout(r7, r3, r9, r8);
    L_0x0035:
        r7 = r5.mIsSplit;
        if (r7 == 0) goto L_0x004f;
    L_0x0039:
        r6 = r5.mSplitBackground;
        if (r6 == 0) goto L_0x004c;
    L_0x003d:
        r6 = r5.mSplitBackground;
        r7 = r5.getMeasuredWidth();
        r8 = r5.getMeasuredHeight();
        r6.setBounds(r0, r0, r7, r8);
        goto L_0x00c6;
    L_0x004c:
        r10 = r0;
        goto L_0x00c6;
    L_0x004f:
        r7 = r5.mBackground;
        if (r7 == 0) goto L_0x00a9;
    L_0x0053:
        r7 = r5.mActionBarView;
        r7 = r7.getVisibility();
        if (r7 != 0) goto L_0x0079;
    L_0x005b:
        r7 = r5.mBackground;
        r8 = r5.mActionBarView;
        r8 = r8.getLeft();
        r9 = r5.mActionBarView;
        r9 = r9.getTop();
        r0 = r5.mActionBarView;
        r0 = r0.getRight();
        r2 = r5.mActionBarView;
        r2 = r2.getBottom();
        r7.setBounds(r8, r9, r0, r2);
        goto L_0x00a8;
    L_0x0079:
        r7 = r5.mContextView;
        if (r7 == 0) goto L_0x00a3;
    L_0x007d:
        r7 = r5.mContextView;
        r7 = r7.getVisibility();
        if (r7 != 0) goto L_0x00a3;
    L_0x0085:
        r7 = r5.mBackground;
        r8 = r5.mContextView;
        r8 = r8.getLeft();
        r9 = r5.mContextView;
        r9 = r9.getTop();
        r0 = r5.mContextView;
        r0 = r0.getRight();
        r2 = r5.mContextView;
        r2 = r2.getBottom();
        r7.setBounds(r8, r9, r0, r2);
        goto L_0x00a8;
    L_0x00a3:
        r7 = r5.mBackground;
        r7.setBounds(r0, r0, r0, r0);
    L_0x00a8:
        r0 = r10;
    L_0x00a9:
        r5.mIsStacked = r1;
        if (r1 == 0) goto L_0x004c;
    L_0x00ad:
        r7 = r5.mStackedBackground;
        if (r7 == 0) goto L_0x004c;
    L_0x00b1:
        r7 = r5.mStackedBackground;
        r8 = r6.getLeft();
        r9 = r6.getTop();
        r0 = r6.getRight();
        r6 = r6.getBottom();
        r7.setBounds(r8, r9, r0, r6);
    L_0x00c6:
        if (r10 == 0) goto L_0x00cb;
    L_0x00c8:
        r5.invalidate();
    L_0x00cb:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionBarContainer.onLayout(boolean, int, int, int, int):void");
    }

    public void onMeasure(int i, int i2) {
        if (this.mActionBarView == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.mHeight >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.mActionBarView != null) {
            i = MeasureSpec.getMode(i2);
            if (!(this.mTabContainer == null || this.mTabContainer.getVisibility() == 8 || i == 1073741824)) {
                int measuredHeightWithMargins = !isCollapsed(this.mActionBarView) ? getMeasuredHeightWithMargins(this.mActionBarView) : !isCollapsed(this.mContextView) ? getMeasuredHeightWithMargins(this.mContextView) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(measuredHeightWithMargins + getMeasuredHeightWithMargins(this.mTabContainer), i == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        if (this.mBackground != null) {
            this.mBackground.setCallback(null);
            unscheduleDrawable(this.mBackground);
        }
        this.mBackground = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mActionBarView != null) {
                this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
            }
        }
        boolean z = false;
        if (this.mIsSplit ? this.mSplitBackground != null : !(this.mBackground == null && this.mStackedBackground == null)) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        if (this.mSplitBackground != null) {
            this.mSplitBackground.setCallback(null);
            unscheduleDrawable(this.mSplitBackground);
        }
        this.mSplitBackground = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mIsSplit && this.mSplitBackground != null) {
                this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.mIsSplit ? this.mSplitBackground != null : !(this.mBackground == null && this.mStackedBackground == null)) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        if (this.mStackedBackground != null) {
            this.mStackedBackground.setCallback(null);
            unscheduleDrawable(this.mStackedBackground);
        }
        this.mStackedBackground = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.mIsStacked && this.mStackedBackground != null) {
                this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
            }
        }
        boolean z = false;
        if (this.mIsSplit ? this.mSplitBackground != null : !(this.mBackground == null && this.mStackedBackground == null)) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.mTabContainer != null) {
            removeView(this.mTabContainer);
        }
        this.mTabContainer = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.mIsTransitioning = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.mBackground != null) {
            this.mBackground.setVisible(z, false);
        }
        if (this.mStackedBackground != null) {
            this.mStackedBackground.setVisible(z, false);
        }
        if (this.mSplitBackground != null) {
            this.mSplitBackground.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i) {
        return i != 0 ? super.startActionModeForChild(view, callback, i) : null;
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.mBackground && !this.mIsSplit) || ((drawable == this.mStackedBackground && this.mIsStacked) || ((drawable == this.mSplitBackground && this.mIsSplit) || super.verifyDrawable(drawable)));
    }
}
