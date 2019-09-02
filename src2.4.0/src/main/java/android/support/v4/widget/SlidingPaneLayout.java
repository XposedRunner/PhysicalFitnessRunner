package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    static final SlidingPanelLayoutImpl IMPL;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    final ViewDragHelper mDragHelper;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList<DisableLayerRunnable> mPostedRunnables;
    boolean mPreservedOpenState;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        AccessibilityDelegate() {
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.mTmpRect;
            accessibilityNodeInfoCompat2.getBoundsInParent(rect);
            accessibilityNodeInfoCompat.setBoundsInParent(rect);
            accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setBoundsInScreen(rect);
            accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
            accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
            accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
            accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
            accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
            accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
            accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
            accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
            accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
            accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
            accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
            accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
            accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean filter(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(view, obtain);
            copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
            obtain.recycle();
            accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.setSource(view);
            ViewParent parentForAccessibility = ViewCompat.getParentForAccessibility(view);
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!filter(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.setImportantForAccessibility(childAt, 1);
                    accessibilityNodeInfoCompat.addChild(childAt);
                }
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return !filter(view) ? super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : false;
        }
    }

    private class DisableLayerRunnable implements Runnable {
        final View mChildView;

        DisableLayerRunnable(View view) {
            this.mChildView = view;
        }

        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                ViewCompat.setLayerType(this.mChildView, 0, null);
                SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    private class DragHelperCallback extends Callback {
        DragHelperCallback() {
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                i2 = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.mSlideableView.getWidth());
                return Math.max(Math.min(i, i2), i2 - SlidingPaneLayout.this.mSlideRange);
            }
            i2 = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i, i2), SlidingPaneLayout.this.mSlideRange + i2);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        public void onEdgeDragStarted(int i, int i2) {
            SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, i2);
        }

        public void onViewCaptured(View view, int i) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        public void onViewDragStateChanged(int i) {
            if (SlidingPaneLayout.this.mDragHelper.getViewDragState() != 0) {
                return;
            }
            if (SlidingPaneLayout.this.mSlideOffset == 0.0f) {
                SlidingPaneLayout.this.updateObscuredViewsVisibility(SlidingPaneLayout.this.mSlideableView);
                SlidingPaneLayout.this.dispatchOnPanelClosed(SlidingPaneLayout.this.mSlideableView);
                SlidingPaneLayout.this.mPreservedOpenState = false;
                return;
            }
            SlidingPaneLayout.this.dispatchOnPanelOpened(SlidingPaneLayout.this.mSlideableView);
            SlidingPaneLayout.this.mPreservedOpenState = true;
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.onPanelDragged(i);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View view, float f, float f2) {
            int width;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f < 0.0f || (f == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.mSlideRange;
                }
                width = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                width = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > 0.0f || (f == 0.0f && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    width += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(width, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View view, int i) {
            return SlidingPaneLayout.this.mIsUnableToDrag ? false : ((LayoutParams) view.getLayoutParams()).slideable;
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        private static final int[] ATTRS = new int[]{16843137};
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.weight = layoutParams.weight;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(View view);

        void onPanelOpened(View view);

        void onPanelSlide(View view, float f);
    }

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        boolean isOpen;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isOpen);
        }
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelClosed(View view) {
        }

        public void onPanelOpened(View view) {
        }

        public void onPanelSlide(View view, float f) {
        }
    }

    interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view);
    }

    static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        SlidingPanelLayoutImplBase() {
        }

        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.postInvalidateOnAnimation(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {
        private Method mGetDisplayList;
        private Field mRecreateDisplayList;

        SlidingPanelLayoutImplJB() {
            try {
                this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (NoSuchMethodException e) {
                Log.e(SlidingPaneLayout.TAG, "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                this.mRecreateDisplayList.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(SlidingPaneLayout.TAG, "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.mGetDisplayList == null || this.mRecreateDisplayList == null) {
                view.invalidate();
                return;
            }
            try {
                this.mRecreateDisplayList.setBoolean(view, true);
                this.mGetDisplayList.invoke(view, (Object[]) null);
            } catch (Exception e) {
                Log.e(SlidingPaneLayout.TAG, "Error refreshing display list state", e);
            }
            super.invalidateChildRegion(slidingPaneLayout, view);
        }
    }

    static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        SlidingPanelLayoutImplJBMR1() {
        }

        public void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.setLayerPaint(view, ((LayoutParams) view.getLayoutParams()).dimPaint);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 17) {
            IMPL = new SlidingPanelLayoutImplJBMR1();
        } else if (i >= 16) {
            IMPL = new SlidingPanelLayoutImplJB();
        } else {
            IMPL = new SlidingPanelLayoutImplBase();
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f) + 0.5f);
        ViewConfiguration.get(context);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        this.mDragHelper = ViewDragHelper.create(this, 0.5f, new DragHelperCallback());
        this.mDragHelper.setMinVelocity(400.0f * f);
    }

    private boolean closePane(View view, int i) {
        if (!this.mFirstLayout && !smoothSlideTo(0.0f, i)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void dimChildView(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((ViewCompat.MEASURED_STATE_MASK & i) >>> 24)) * f)) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK);
            if (layoutParams.dimPaint == null) {
                layoutParams.dimPaint = new Paint();
            }
            layoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (ViewCompat.getLayerType(view) != 2) {
                ViewCompat.setLayerType(view, 2, layoutParams.dimPaint);
            }
            invalidateChildRegion(view);
        } else if (ViewCompat.getLayerType(view) != 0) {
            if (layoutParams.dimPaint != null) {
                layoutParams.dimPaint.setColorFilter(null);
            }
            DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            this.mPostedRunnables.add(disableLayerRunnable);
            ViewCompat.postOnAnimation(this, disableLayerRunnable);
        }
    }

    private boolean openPane(View view, int i) {
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    private void parallaxOtherViews(float r10) {
        /*
        r9 = this;
        r0 = r9.isLayoutRtlSupport();
        r1 = r9.mSlideableView;
        r1 = r1.getLayoutParams();
        r1 = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) r1;
        r2 = r1.dimWhenOffset;
        r3 = 0;
        if (r2 == 0) goto L_0x001c;
    L_0x0011:
        if (r0 == 0) goto L_0x0016;
    L_0x0013:
        r1 = r1.rightMargin;
        goto L_0x0018;
    L_0x0016:
        r1 = r1.leftMargin;
    L_0x0018:
        if (r1 > 0) goto L_0x001c;
    L_0x001a:
        r1 = 1;
        goto L_0x001d;
    L_0x001c:
        r1 = r3;
    L_0x001d:
        r2 = r9.getChildCount();
    L_0x0021:
        if (r3 >= r2) goto L_0x005b;
    L_0x0023:
        r4 = r9.getChildAt(r3);
        r5 = r9.mSlideableView;
        if (r4 != r5) goto L_0x002c;
    L_0x002b:
        goto L_0x0058;
    L_0x002c:
        r5 = r9.mParallaxOffset;
        r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r5 = r6 - r5;
        r7 = r9.mParallaxBy;
        r7 = (float) r7;
        r5 = r5 * r7;
        r5 = (int) r5;
        r9.mParallaxOffset = r10;
        r7 = r6 - r10;
        r8 = r9.mParallaxBy;
        r8 = (float) r8;
        r7 = r7 * r8;
        r7 = (int) r7;
        r5 = r5 - r7;
        if (r0 == 0) goto L_0x0044;
    L_0x0043:
        r5 = -r5;
    L_0x0044:
        r4.offsetLeftAndRight(r5);
        if (r1 == 0) goto L_0x0058;
    L_0x0049:
        if (r0 == 0) goto L_0x004f;
    L_0x004b:
        r5 = r9.mParallaxOffset;
        r5 = r5 - r6;
        goto L_0x0053;
    L_0x004f:
        r5 = r9.mParallaxOffset;
        r5 = r6 - r5;
    L_0x0053:
        r6 = r9.mCoveredFadeColor;
        r9.dimChildView(r4, r5, r6);
    L_0x0058:
        r3 = r3 + 1;
        goto L_0x0021;
    L_0x005b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.parallaxOtherViews(float):void");
    }

    private static boolean viewIsOpaque(View view) {
        boolean z = true;
        if (view.isOpaque()) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        if (background == null) {
            return false;
        }
        if (background.getOpacity() != -1) {
            z = false;
        }
        return z;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:22:0x0065, code skipped:
            if (android.support.v4.view.ViewCompat.canScrollHorizontally(r0, isLayoutRtlSupport() ? r16 : -r16) != false) goto L_0x0069;
     */
    public boolean canScroll(android.view.View r14, boolean r15, int r16, int r17, int r18) {
        /*
        r13 = this;
        r0 = r14;
        r1 = r0 instanceof android.view.ViewGroup;
        r2 = 1;
        if (r1 == 0) goto L_0x0053;
    L_0x0006:
        r1 = r0;
        r1 = (android.view.ViewGroup) r1;
        r3 = r0.getScrollX();
        r4 = r0.getScrollY();
        r5 = r1.getChildCount();
        r5 = r5 - r2;
    L_0x0016:
        if (r5 < 0) goto L_0x0053;
    L_0x0018:
        r7 = r1.getChildAt(r5);
        r6 = r17 + r3;
        r8 = r7.getLeft();
        if (r6 < r8) goto L_0x0050;
    L_0x0024:
        r8 = r7.getRight();
        if (r6 >= r8) goto L_0x0050;
    L_0x002a:
        r8 = r18 + r4;
        r9 = r7.getTop();
        if (r8 < r9) goto L_0x0050;
    L_0x0032:
        r9 = r7.getBottom();
        if (r8 >= r9) goto L_0x0050;
    L_0x0038:
        r9 = 1;
        r10 = r7.getLeft();
        r10 = r6 - r10;
        r6 = r7.getTop();
        r11 = r8 - r6;
        r6 = r13;
        r8 = r9;
        r9 = r16;
        r6 = r6.canScroll(r7, r8, r9, r10, r11);
        if (r6 == 0) goto L_0x0050;
    L_0x004f:
        return r2;
    L_0x0050:
        r5 = r5 + -1;
        goto L_0x0016;
    L_0x0053:
        if (r15 == 0) goto L_0x0068;
    L_0x0055:
        r1 = r13.isLayoutRtlSupport();
        if (r1 == 0) goto L_0x005e;
    L_0x005b:
        r1 = r16;
        goto L_0x0061;
    L_0x005e:
        r1 = r16;
        r1 = -r1;
    L_0x0061:
        r0 = android.support.v4.view.ViewCompat.canScrollHorizontally(r0, r1);
        if (r0 == 0) goto L_0x0068;
    L_0x0067:
        goto L_0x0069;
    L_0x0068:
        r2 = 0;
    L_0x0069:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.canScroll(android.view.View, boolean, int, int, int):boolean");
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (this.mCanSlide) {
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                this.mDragHelper.abort();
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnPanelClosed(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnPanelOpened(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnPanelSlide(View view) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelSlide(view, this.mSlideOffset);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = isLayoutRtlSupport() ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (isLayoutRtlSupport()) {
                right = childAt.getRight();
                intrinsicWidth += right;
            } else {
                right = childAt.getLeft();
                int i = right - intrinsicWidth;
                intrinsicWidth = right;
                right = i;
            }
            drawable.setBounds(right, top, intrinsicWidth, bottom);
            drawable.draw(canvas);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save(2);
        if (!(!this.mCanSlide || layoutParams.slideable || this.mSlideableView == null)) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                this.mTmpRect.left = Math.max(this.mTmpRect.left, this.mSlideableView.getRight());
            } else {
                this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        if (VERSION.SDK_INT >= 11) {
            drawChild = super.drawChild(canvas, view, j);
        } else if (!layoutParams.dimWhenOffset || this.mSlideOffset <= 0.0f) {
            if (view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(false);
            }
            drawChild = super.drawChild(canvas, view, j);
        } else {
            if (!view.isDrawingCacheEnabled()) {
                view.setDrawingCacheEnabled(true);
            }
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                canvas.drawBitmap(drawingCache, (float) view.getLeft(), (float) view.getTop(), layoutParams.dimPaint);
                drawChild = false;
            } else {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("drawChild: child view ");
                stringBuilder.append(view);
                stringBuilder.append(" returned null drawing cache");
                Log.e(str, stringBuilder.toString());
                drawChild = super.drawChild(canvas, view, j);
            }
        }
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    /* Access modifiers changed, original: 0000 */
    public void invalidateChildRegion(View view) {
        IMPL.invalidateChildRegion(this, view);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isDimmed(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.mCanSlide && layoutParams.dimWhenOffset && this.mSlideOffset > 0.0f) {
            z = true;
        }
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isLayoutRtlSupport() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i = 0; i < size; i++) {
            ((DisableLayerRunnable) this.mPostedRunnables.get(i)).run();
        }
        this.mPostedRunnables.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = true;
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1) {
            View childAt = getChildAt(1);
            if (childAt != null) {
                this.mPreservedOpenState = this.mDragHelper.isViewUnder(childAt, (int) motionEvent.getX(), (int) motionEvent.getY()) ^ 1;
            }
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.cancel();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.cancel();
            return false;
        } else {
            boolean z2;
            float x;
            float y;
            if (actionMasked == 0) {
                this.mIsUnableToDrag = false;
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y) && isDimmed(this.mSlideableView)) {
                    z2 = true;
                    if (!(this.mDragHelper.shouldInterceptTouchEvent(motionEvent) || z2)) {
                        z = false;
                    }
                    return z;
                }
            } else if (actionMasked == 2) {
                x = motionEvent.getX();
                y = motionEvent.getY();
                x = Math.abs(x - this.mInitialMotionX);
                y = Math.abs(y - this.mInitialMotionY);
                if (x > ((float) this.mDragHelper.getTouchSlop()) && y > x) {
                    this.mDragHelper.cancel();
                    this.mIsUnableToDrag = true;
                    return false;
                }
            }
            z2 = false;
            z = false;
            return z;
        }
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c0  */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
        r19 = this;
        r0 = r19;
        r1 = r19.isLayoutRtlSupport();
        r2 = 1;
        if (r1 == 0) goto L_0x0010;
    L_0x0009:
        r3 = r0.mDragHelper;
        r4 = 2;
        r3.setEdgeTrackingEnabled(r4);
        goto L_0x0015;
    L_0x0010:
        r3 = r0.mDragHelper;
        r3.setEdgeTrackingEnabled(r2);
    L_0x0015:
        r3 = r23 - r21;
        if (r1 == 0) goto L_0x001e;
    L_0x0019:
        r4 = r19.getPaddingRight();
        goto L_0x0022;
    L_0x001e:
        r4 = r19.getPaddingLeft();
    L_0x0022:
        if (r1 == 0) goto L_0x0029;
    L_0x0024:
        r5 = r19.getPaddingLeft();
        goto L_0x002d;
    L_0x0029:
        r5 = r19.getPaddingRight();
    L_0x002d:
        r6 = r19.getPaddingTop();
        r7 = r19.getChildCount();
        r8 = r0.mFirstLayout;
        if (r8 == 0) goto L_0x0047;
    L_0x0039:
        r8 = r0.mCanSlide;
        if (r8 == 0) goto L_0x0044;
    L_0x003d:
        r8 = r0.mPreservedOpenState;
        if (r8 == 0) goto L_0x0044;
    L_0x0041:
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        goto L_0x0045;
    L_0x0044:
        r8 = 0;
    L_0x0045:
        r0.mSlideOffset = r8;
    L_0x0047:
        r11 = r4;
        r12 = r11;
        r4 = 0;
    L_0x004a:
        if (r4 >= r7) goto L_0x00dd;
    L_0x004c:
        r13 = r0.getChildAt(r4);
        r14 = r13.getVisibility();
        r15 = 8;
        if (r14 != r15) goto L_0x005c;
    L_0x0058:
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        goto L_0x00d8;
    L_0x005c:
        r14 = r13.getLayoutParams();
        r14 = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) r14;
        r15 = r13.getMeasuredWidth();
        r2 = r14.slideable;
        if (r2 == 0) goto L_0x00a4;
    L_0x006a:
        r2 = r14.leftMargin;
        r8 = r14.rightMargin;
        r2 = r2 + r8;
        r8 = r3 - r5;
        r9 = r0.mOverhangSize;
        r9 = r8 - r9;
        r9 = java.lang.Math.min(r11, r9);
        r9 = r9 - r12;
        r9 = r9 - r2;
        r0.mSlideRange = r9;
        if (r1 == 0) goto L_0x0082;
    L_0x007f:
        r2 = r14.rightMargin;
        goto L_0x0084;
    L_0x0082:
        r2 = r14.leftMargin;
    L_0x0084:
        r16 = r12 + r2;
        r16 = r16 + r9;
        r17 = r15 / 2;
        r10 = r16 + r17;
        if (r10 <= r8) goto L_0x0090;
    L_0x008e:
        r8 = 1;
        goto L_0x0091;
    L_0x0090:
        r8 = 0;
    L_0x0091:
        r14.dimWhenOffset = r8;
        r8 = (float) r9;
        r9 = r0.mSlideOffset;
        r8 = r8 * r9;
        r8 = (int) r8;
        r2 = r2 + r8;
        r2 = r2 + r12;
        r8 = (float) r8;
        r9 = r0.mSlideRange;
        r9 = (float) r9;
        r8 = r8 / r9;
        r0.mSlideOffset = r8;
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        goto L_0x00bd;
    L_0x00a4:
        r2 = r0.mCanSlide;
        if (r2 == 0) goto L_0x00ba;
    L_0x00a8:
        r2 = r0.mParallaxBy;
        if (r2 == 0) goto L_0x00ba;
    L_0x00ac:
        r2 = r0.mSlideOffset;
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r10 = r8 - r2;
        r2 = r0.mParallaxBy;
        r2 = (float) r2;
        r10 = r10 * r2;
        r2 = (int) r10;
        r9 = r2;
        r2 = r11;
        goto L_0x00be;
    L_0x00ba:
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = r11;
    L_0x00bd:
        r9 = 0;
    L_0x00be:
        if (r1 == 0) goto L_0x00c6;
    L_0x00c0:
        r10 = r3 - r2;
        r10 = r10 + r9;
        r9 = r10 - r15;
        goto L_0x00ca;
    L_0x00c6:
        r9 = r2 - r9;
        r10 = r9 + r15;
    L_0x00ca:
        r12 = r13.getMeasuredHeight();
        r12 = r12 + r6;
        r13.layout(r9, r6, r10, r12);
        r9 = r13.getWidth();
        r11 = r11 + r9;
        r12 = r2;
    L_0x00d8:
        r4 = r4 + 1;
        r2 = 1;
        goto L_0x004a;
    L_0x00dd:
        r1 = r0.mFirstLayout;
        if (r1 == 0) goto L_0x0119;
    L_0x00e1:
        r1 = r0.mCanSlide;
        if (r1 == 0) goto L_0x0104;
    L_0x00e5:
        r1 = r0.mParallaxBy;
        if (r1 == 0) goto L_0x00ee;
    L_0x00e9:
        r1 = r0.mSlideOffset;
        r0.parallaxOtherViews(r1);
    L_0x00ee:
        r1 = r0.mSlideableView;
        r1 = r1.getLayoutParams();
        r1 = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) r1;
        r1 = r1.dimWhenOffset;
        if (r1 == 0) goto L_0x0114;
    L_0x00fa:
        r1 = r0.mSlideableView;
        r2 = r0.mSlideOffset;
        r3 = r0.mSliderFadeColor;
        r0.dimChildView(r1, r2, r3);
        goto L_0x0114;
    L_0x0104:
        r1 = 0;
    L_0x0105:
        if (r1 >= r7) goto L_0x0114;
    L_0x0107:
        r2 = r0.getChildAt(r1);
        r3 = r0.mSliderFadeColor;
        r4 = 0;
        r0.dimChildView(r2, r4, r3);
        r1 = r1 + 1;
        goto L_0x0105;
    L_0x0114:
        r1 = r0.mSlideableView;
        r0.updateObscuredViewsVisibility(r1);
    L_0x0119:
        r1 = 0;
        r0.mFirstLayout = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01f4  */
    public void onMeasure(int r21, int r22) {
        /*
        r20 = this;
        r0 = r20;
        r1 = android.view.View.MeasureSpec.getMode(r21);
        r2 = android.view.View.MeasureSpec.getSize(r21);
        r3 = android.view.View.MeasureSpec.getMode(r22);
        r4 = android.view.View.MeasureSpec.getSize(r22);
        r5 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r1 == r7) goto L_0x002f;
    L_0x001a:
        r8 = r20.isInEditMode();
        if (r8 == 0) goto L_0x0027;
    L_0x0020:
        if (r1 != r6) goto L_0x0023;
    L_0x0022:
        goto L_0x0044;
    L_0x0023:
        if (r1 != 0) goto L_0x0044;
    L_0x0025:
        r2 = r5;
        goto L_0x0044;
    L_0x0027:
        r1 = new java.lang.IllegalStateException;
        r2 = "Width must have an exact value or MATCH_PARENT";
        r1.<init>(r2);
        throw r1;
    L_0x002f:
        if (r3 != 0) goto L_0x0044;
    L_0x0031:
        r1 = r20.isInEditMode();
        if (r1 == 0) goto L_0x003c;
    L_0x0037:
        if (r3 != 0) goto L_0x0044;
    L_0x0039:
        r4 = r5;
        r3 = r6;
        goto L_0x0044;
    L_0x003c:
        r1 = new java.lang.IllegalStateException;
        r2 = "Height must not be UNSPECIFIED";
        r1.<init>(r2);
        throw r1;
    L_0x0044:
        r5 = 0;
        if (r3 == r6) goto L_0x0058;
    L_0x0047:
        if (r3 == r7) goto L_0x004c;
    L_0x0049:
        r4 = r5;
        r8 = -1;
        goto L_0x0064;
    L_0x004c:
        r8 = r20.getPaddingTop();
        r4 = r4 - r8;
        r8 = r20.getPaddingBottom();
        r4 = r4 - r8;
        r8 = r4;
        goto L_0x0064;
    L_0x0058:
        r8 = r20.getPaddingTop();
        r4 = r4 - r8;
        r8 = r20.getPaddingBottom();
        r4 = r4 - r8;
        r8 = r4;
        r4 = r5;
    L_0x0064:
        r9 = r20.getPaddingLeft();
        r9 = r2 - r9;
        r10 = r20.getPaddingRight();
        r9 = r9 - r10;
        r10 = r20.getChildCount();
        r11 = 2;
        if (r10 <= r11) goto L_0x007d;
    L_0x0076:
        r11 = "SlidingPaneLayout";
        r12 = "onMeasure: More than two child views are not supported.";
        android.util.Log.e(r11, r12);
    L_0x007d:
        r11 = 0;
        r0.mSlideableView = r11;
        r14 = r4;
        r4 = r5;
        r12 = r4;
        r15 = r9;
        r13 = 0;
    L_0x0085:
        r7 = 8;
        r16 = 1;
        if (r4 >= r10) goto L_0x0129;
    L_0x008b:
        r6 = r0.getChildAt(r4);
        r18 = r6.getLayoutParams();
        r1 = r18;
        r1 = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) r1;
        r11 = r6.getVisibility();
        if (r11 != r7) goto L_0x00a1;
    L_0x009d:
        r1.dimWhenOffset = r5;
        goto L_0x0122;
    L_0x00a1:
        r7 = r1.weight;
        r11 = 0;
        r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1));
        if (r7 <= 0) goto L_0x00b1;
    L_0x00a8:
        r7 = r1.weight;
        r13 = r13 + r7;
        r7 = r1.width;
        if (r7 != 0) goto L_0x00b1;
    L_0x00af:
        goto L_0x0122;
    L_0x00b1:
        r7 = r1.leftMargin;
        r11 = r1.rightMargin;
        r7 = r7 + r11;
        r11 = r1.width;
        r5 = -2;
        if (r11 != r5) goto L_0x00c6;
    L_0x00bb:
        r5 = r9 - r7;
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r7);
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x00dc;
    L_0x00c6:
        r5 = r1.width;
        r11 = -1;
        if (r5 != r11) goto L_0x00d4;
    L_0x00cb:
        r5 = r9 - r7;
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r7);
        goto L_0x00dc;
    L_0x00d4:
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r1.width;
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r7);
    L_0x00dc:
        r11 = r1.height;
        r7 = -2;
        if (r11 != r7) goto L_0x00e8;
    L_0x00e1:
        r7 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r11 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r7);
        goto L_0x00fc;
    L_0x00e8:
        r7 = r1.height;
        r11 = -1;
        if (r7 != r11) goto L_0x00f4;
    L_0x00ed:
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r7);
        goto L_0x00fc;
    L_0x00f4:
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = r1.height;
        r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r7);
    L_0x00fc:
        r6.measure(r5, r11);
        r5 = r6.getMeasuredWidth();
        r7 = r6.getMeasuredHeight();
        r11 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r3 != r11) goto L_0x0111;
    L_0x010b:
        if (r7 <= r14) goto L_0x0111;
    L_0x010d:
        r14 = java.lang.Math.min(r7, r8);
    L_0x0111:
        r15 = r15 - r5;
        if (r15 >= 0) goto L_0x0117;
    L_0x0114:
        r5 = r16;
        goto L_0x0118;
    L_0x0117:
        r5 = 0;
    L_0x0118:
        r1.slideable = r5;
        r5 = r5 | r12;
        r1 = r1.slideable;
        if (r1 == 0) goto L_0x0121;
    L_0x011f:
        r0.mSlideableView = r6;
    L_0x0121:
        r12 = r5;
    L_0x0122:
        r4 = r4 + 1;
        r5 = 0;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        goto L_0x0085;
    L_0x0129:
        if (r12 != 0) goto L_0x0130;
    L_0x012b:
        r1 = 0;
        r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1));
        if (r3 <= 0) goto L_0x0229;
    L_0x0130:
        r1 = r0.mOverhangSize;
        r1 = r9 - r1;
        r3 = 0;
    L_0x0135:
        if (r3 >= r10) goto L_0x0229;
    L_0x0137:
        r4 = r0.getChildAt(r3);
        r5 = r4.getVisibility();
        if (r5 != r7) goto L_0x0148;
    L_0x0141:
        r19 = r1;
    L_0x0143:
        r1 = 0;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x0221;
    L_0x0148:
        r5 = r4.getLayoutParams();
        r5 = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) r5;
        r6 = r4.getVisibility();
        if (r6 != r7) goto L_0x0155;
    L_0x0154:
        goto L_0x0141;
    L_0x0155:
        r6 = r5.width;
        if (r6 != 0) goto L_0x0163;
    L_0x0159:
        r6 = r5.weight;
        r11 = 0;
        r6 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1));
        if (r6 <= 0) goto L_0x0163;
    L_0x0160:
        r6 = r16;
        goto L_0x0164;
    L_0x0163:
        r6 = 0;
    L_0x0164:
        if (r6 == 0) goto L_0x0168;
    L_0x0166:
        r11 = 0;
        goto L_0x016c;
    L_0x0168:
        r11 = r4.getMeasuredWidth();
    L_0x016c:
        if (r12 == 0) goto L_0x01b6;
    L_0x016e:
        r7 = r0.mSlideableView;
        if (r4 == r7) goto L_0x01b6;
    L_0x0172:
        r7 = r5.width;
        if (r7 >= 0) goto L_0x0141;
    L_0x0176:
        if (r11 > r1) goto L_0x017f;
    L_0x0178:
        r7 = r5.weight;
        r11 = 0;
        r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1));
        if (r7 <= 0) goto L_0x0141;
    L_0x017f:
        if (r6 == 0) goto L_0x01a4;
    L_0x0181:
        r6 = r5.height;
        r7 = -2;
        if (r6 != r7) goto L_0x018f;
    L_0x0186:
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6);
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x01ae;
    L_0x018f:
        r6 = r5.height;
        r7 = -1;
        if (r6 != r7) goto L_0x019b;
    L_0x0194:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6);
        goto L_0x01ae;
    L_0x019b:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r5.height;
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r6);
        goto L_0x01ae;
    L_0x01a4:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r4.getMeasuredHeight();
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r6);
    L_0x01ae:
        r7 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r6);
        r4.measure(r7, r5);
        goto L_0x0141;
    L_0x01b6:
        r6 = r5.weight;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 <= 0) goto L_0x0141;
    L_0x01bd:
        r6 = r5.width;
        if (r6 != 0) goto L_0x01e6;
    L_0x01c1:
        r6 = r5.height;
        r7 = -2;
        if (r6 != r7) goto L_0x01d1;
    L_0x01c6:
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r17 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6);
        r7 = r17;
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x01f2;
    L_0x01d1:
        r6 = r5.height;
        r7 = -1;
        if (r6 != r7) goto L_0x01dd;
    L_0x01d6:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r17 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6);
        goto L_0x01f0;
    L_0x01dd:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r5.height;
        r17 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r6);
        goto L_0x01f0;
    L_0x01e6:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r4.getMeasuredHeight();
        r17 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r6);
    L_0x01f0:
        r7 = r17;
    L_0x01f2:
        if (r12 == 0) goto L_0x020a;
    L_0x01f4:
        r6 = r5.leftMargin;
        r5 = r5.rightMargin;
        r6 = r6 + r5;
        r5 = r9 - r6;
        r19 = r1;
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r6);
        if (r11 == r5) goto L_0x0143;
    L_0x0205:
        r4.measure(r1, r7);
        goto L_0x0143;
    L_0x020a:
        r19 = r1;
        r1 = 0;
        r6 = java.lang.Math.max(r1, r15);
        r5 = r5.weight;
        r6 = (float) r6;
        r5 = r5 * r6;
        r5 = r5 / r13;
        r5 = (int) r5;
        r11 = r11 + r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r5);
        r4.measure(r6, r7);
    L_0x0221:
        r3 = r3 + 1;
        r1 = r19;
        r7 = 8;
        goto L_0x0135;
    L_0x0229:
        r1 = r20.getPaddingTop();
        r14 = r14 + r1;
        r1 = r20.getPaddingBottom();
        r14 = r14 + r1;
        r0.setMeasuredDimension(r2, r14);
        r0.mCanSlide = r12;
        r1 = r0.mDragHelper;
        r1 = r1.getViewDragState();
        if (r1 == 0) goto L_0x0247;
    L_0x0240:
        if (r12 != 0) goto L_0x0247;
    L_0x0242:
        r1 = r0.mDragHelper;
        r1.abort();
    L_0x0247:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    /* Access modifiers changed, original: 0000 */
    public void onPanelDragged(int i) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0f;
            return;
        }
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (isLayoutRtlSupport) {
            i = (getWidth() - i) - width;
        }
        this.mSlideOffset = ((float) (i - ((isLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()) + (isLayoutRtlSupport ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) this.mSlideRange);
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(this.mSlideOffset);
        }
        if (layoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (savedState.isOpen) {
                openPane();
            } else {
                closePane();
            }
            this.mPreservedOpenState = savedState.isOpen;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                break;
            case 1:
                if (isDimmed(this.mSlideableView)) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    float f = x - this.mInitialMotionX;
                    float f2 = y - this.mInitialMotionY;
                    int touchSlop = this.mDragHelper.getTouchSlop();
                    if ((f * f) + (f2 * f2) < ((float) (touchSlop * touchSlop)) && this.mDragHelper.isViewUnder(this.mSlideableView, (int) x, (int) y)) {
                        closePane(this.mSlideableView, 0);
                        break;
                    }
                }
                break;
        }
        return true;
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.mCanSlide) {
            this.mPreservedOpenState = view == this.mSlideableView;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        this.mCoveredFadeColor = i;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.mPanelSlideListener = panelSlideListener;
    }

    public void setParallaxDistance(int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(ContextCompat.getDrawable(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(ContextCompat.getDrawable(getContext(), i));
    }

    public void setSliderFadeColor(@ColorInt int i) {
        this.mSliderFadeColor = i;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    /* Access modifiers changed, original: 0000 */
    public boolean smoothSlideTo(float f, int i) {
        if (!this.mCanSlide) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (isLayoutRtlSupport()) {
            width = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f * ((float) this.mSlideRange))) + ((float) this.mSlideableView.getWidth())));
        } else {
            width = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f * ((float) this.mSlideRange)));
        }
        if (!this.mDragHelper.smoothSlideViewTo(this.mSlideableView, width, this.mSlideableView.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        ViewCompat.postInvalidateOnAnimation(this);
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public void updateObscuredViewsVisibility(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        View view2 = view;
        boolean isLayoutRtlSupport = isLayoutRtlSupport();
        int width = isLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = isLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i = view.getLeft();
            i2 = view.getRight();
            i3 = view.getTop();
            i4 = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view2) {
                boolean z;
                if (childAt.getVisibility() == 8) {
                    z = isLayoutRtlSupport;
                } else {
                    int i6;
                    int max = Math.max(isLayoutRtlSupport ? paddingLeft : width, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    if (isLayoutRtlSupport) {
                        z = isLayoutRtlSupport;
                        i6 = width;
                    } else {
                        z = isLayoutRtlSupport;
                        i6 = paddingLeft;
                    }
                    max = (max < i || max2 < i3 || Math.min(i6, childAt.getRight()) > i2 || Math.min(height, childAt.getBottom()) > i4) ? 0 : 4;
                    childAt.setVisibility(max);
                }
                i5++;
                isLayoutRtlSupport = z;
                view2 = view;
            } else {
                return;
            }
        }
    }
}
