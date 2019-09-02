package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    int mActivePointerId;
    private BottomSheetCallback mCallback;
    private final Callback mDragCallback = new Callback() {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return MathUtils.constrain(i, BottomSheetBehavior.this.mMinOffset, BottomSheetBehavior.this.mHideable ? BottomSheetBehavior.this.mParentHeight : BottomSheetBehavior.this.mMaxOffset);
        }

        public int getViewVerticalDragRange(View view) {
            return BottomSheetBehavior.this.mHideable ? BottomSheetBehavior.this.mParentHeight - BottomSheetBehavior.this.mMinOffset : BottomSheetBehavior.this.mMaxOffset - BottomSheetBehavior.this.mMinOffset;
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x006b  */
        public void onViewReleased(android.view.View r4, float r5, float r6) {
            /*
            r3 = this;
            r5 = 0;
            r0 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
            r1 = 4;
            r2 = 3;
            if (r0 >= 0) goto L_0x000d;
        L_0x0007:
            r5 = android.support.design.widget.BottomSheetBehavior.this;
            r5 = r5.mMinOffset;
        L_0x000b:
            r1 = r2;
            goto L_0x004c;
        L_0x000d:
            r0 = android.support.design.widget.BottomSheetBehavior.this;
            r0 = r0.mHideable;
            if (r0 == 0) goto L_0x0021;
        L_0x0013:
            r0 = android.support.design.widget.BottomSheetBehavior.this;
            r0 = r0.shouldHide(r4, r6);
            if (r0 == 0) goto L_0x0021;
        L_0x001b:
            r5 = android.support.design.widget.BottomSheetBehavior.this;
            r5 = r5.mParentHeight;
            r1 = 5;
            goto L_0x004c;
        L_0x0021:
            r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
            if (r5 != 0) goto L_0x0048;
        L_0x0025:
            r5 = r4.getTop();
            r6 = android.support.design.widget.BottomSheetBehavior.this;
            r6 = r6.mMinOffset;
            r6 = r5 - r6;
            r6 = java.lang.Math.abs(r6);
            r0 = android.support.design.widget.BottomSheetBehavior.this;
            r0 = r0.mMaxOffset;
            r5 = r5 - r0;
            r5 = java.lang.Math.abs(r5);
            if (r6 >= r5) goto L_0x0043;
        L_0x003e:
            r5 = android.support.design.widget.BottomSheetBehavior.this;
            r5 = r5.mMinOffset;
            goto L_0x000b;
        L_0x0043:
            r5 = android.support.design.widget.BottomSheetBehavior.this;
            r5 = r5.mMaxOffset;
            goto L_0x004c;
        L_0x0048:
            r5 = android.support.design.widget.BottomSheetBehavior.this;
            r5 = r5.mMaxOffset;
        L_0x004c:
            r6 = android.support.design.widget.BottomSheetBehavior.this;
            r6 = r6.mViewDragHelper;
            r0 = r4.getLeft();
            r5 = r6.settleCapturedViewAt(r0, r5);
            if (r5 == 0) goto L_0x006b;
        L_0x005a:
            r5 = android.support.design.widget.BottomSheetBehavior.this;
            r6 = 2;
            r5.setStateInternal(r6);
            r5 = new android.support.design.widget.BottomSheetBehavior$SettleRunnable;
            r6 = android.support.design.widget.BottomSheetBehavior.this;
            r5.<init>(r4, r1);
            android.support.v4.view.ViewCompat.postOnAnimation(r4, r5);
            goto L_0x0070;
        L_0x006b:
            r4 = android.support.design.widget.BottomSheetBehavior.this;
            r4.setStateInternal(r1);
        L_0x0070:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior$AnonymousClass2.onViewReleased(android.view.View, float, float):void");
        }

        public boolean tryCaptureView(View view, int i) {
            boolean z = true;
            if (BottomSheetBehavior.this.mState == 1 || BottomSheetBehavior.this.mTouchingScrollingChild) {
                return false;
            }
            if (BottomSheetBehavior.this.mState == 3 && BottomSheetBehavior.this.mActivePointerId == i) {
                View view2 = (View) BottomSheetBehavior.this.mNestedScrollingChildRef.get();
                if (view2 != null && ViewCompat.canScrollVertically(view2, -1)) {
                    return false;
                }
            }
            if (BottomSheetBehavior.this.mViewRef == null || BottomSheetBehavior.this.mViewRef.get() != view) {
                z = false;
            }
            return z;
        }
    };
    boolean mHideable;
    private boolean mIgnoreEvents;
    private int mInitialY;
    private int mLastNestedScrollDy;
    int mMaxOffset;
    private float mMaximumVelocity;
    int mMinOffset;
    private boolean mNestedScrolled;
    WeakReference<View> mNestedScrollingChildRef;
    int mParentHeight;
    private int mPeekHeight;
    private boolean mPeekHeightAuto;
    private int mPeekHeightMin;
    private boolean mSkipCollapsed;
    int mState = 4;
    boolean mTouchingScrollingChild;
    private VelocityTracker mVelocityTracker;
    ViewDragHelper mViewDragHelper;
    WeakReference<V> mViewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(@NonNull View view, float f);

        public abstract void onStateChanged(@NonNull View view, int i);
    }

    protected static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    private class SettleRunnable implements Runnable {
        private final int mTargetState;
        private final View mView;

        SettleRunnable(View view, int i) {
            this.mView = view;
            this.mTargetState = i;
        }

        public void run() {
            if (BottomSheetBehavior.this.mViewDragHelper == null || !BottomSheetBehavior.this.mViewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.setStateInternal(this.mTargetState);
            } else {
                ViewCompat.postOnAnimation(this.mView, this);
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            setPeekHeight(peekValue.data);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.mMaximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private View findScrollingChild(View view) {
        if (view instanceof NestedScrollingChild) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
        }
        return null;
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private float getYVelocity() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        return VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
    }

    private void reset() {
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void dispatchOnSlide(int i) {
        View view = (View) this.mViewRef.get();
        if (view != null && this.mCallback != null) {
            if (i > this.mMaxOffset) {
                this.mCallback.onSlide(view, ((float) (this.mMaxOffset - i)) / ((float) (this.mParentHeight - this.mMaxOffset)));
            } else {
                this.mCallback.onSlide(view, ((float) (this.mMaxOffset - i)) / ((float) (this.mMaxOffset - this.mMinOffset)));
            }
        }
    }

    public final int getPeekHeight() {
        return this.mPeekHeightAuto ? -1 : this.mPeekHeight;
    }

    /* Access modifiers changed, original: 0000 */
    @VisibleForTesting
    public int getPeekHeightMin() {
        return this.mPeekHeightMin;
    }

    public boolean getSkipCollapsed() {
        return this.mSkipCollapsed;
    }

    public final int getState() {
        return this.mState;
    }

    public boolean isHideable() {
        return this.mHideable;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = false;
        if (v.isShown()) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                reset();
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        int x = (int) motionEvent.getX();
                        this.mInitialY = (int) motionEvent.getY();
                        View view = (View) this.mNestedScrollingChildRef.get();
                        if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.mInitialY)) {
                            this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.mTouchingScrollingChild = true;
                        }
                        boolean z2 = this.mActivePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.mInitialY);
                        this.mIgnoreEvents = z2;
                        break;
                    case 1:
                        break;
                }
            }
            this.mTouchingScrollingChild = false;
            this.mActivePointerId = -1;
            if (this.mIgnoreEvents) {
                this.mIgnoreEvents = false;
                return false;
            }
            if (!this.mIgnoreEvents && this.mViewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
            View view2 = (View) this.mNestedScrollingChildRef.get();
            if (!(actionMasked != 2 || view2 == null || this.mIgnoreEvents || this.mState == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.mInitialY) - motionEvent.getY()) <= ((float) this.mViewDragHelper.getTouchSlop()))) {
                z = true;
            }
            return z;
        }
        this.mIgnoreEvents = true;
        return false;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            ViewCompat.setFitsSystemWindows(v, true);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.mParentHeight = coordinatorLayout.getHeight();
        if (this.mPeekHeightAuto) {
            if (this.mPeekHeightMin == 0) {
                this.mPeekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            i = Math.max(this.mPeekHeightMin, this.mParentHeight - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            i = this.mPeekHeight;
        }
        this.mMinOffset = Math.max(0, this.mParentHeight - v.getHeight());
        this.mMaxOffset = Math.max(this.mParentHeight - i, this.mMinOffset);
        if (this.mState == 3) {
            ViewCompat.offsetTopAndBottom(v, this.mMinOffset);
        } else if (this.mHideable && this.mState == 5) {
            ViewCompat.offsetTopAndBottom(v, this.mParentHeight);
        } else if (this.mState == 4) {
            ViewCompat.offsetTopAndBottom(v, this.mMaxOffset);
        } else if (this.mState == 1 || this.mState == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        if (this.mViewDragHelper == null) {
            this.mViewDragHelper = ViewDragHelper.create(coordinatorLayout, this.mDragCallback);
        }
        this.mViewRef = new WeakReference(v);
        this.mNestedScrollingChildRef = new WeakReference(findScrollingChild(v));
        return true;
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.mNestedScrollingChildRef.get() && (this.mState != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.mNestedScrollingChildRef.get())) {
            int top = v.getTop();
            i = top - i2;
            if (i2 > 0) {
                if (i < this.mMinOffset) {
                    iArr[1] = top - this.mMinOffset;
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    setStateInternal(3);
                } else {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    setStateInternal(1);
                }
            } else if (i2 < 0 && !ViewCompat.canScrollVertically(view, -1)) {
                if (i <= this.mMaxOffset || this.mHideable) {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    setStateInternal(1);
                } else {
                    iArr[1] = top - this.mMaxOffset;
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    setStateInternal(4);
                }
            }
            dispatchOnSlide(v.getTop());
            this.mLastNestedScrollDy = i2;
            this.mNestedScrolled = true;
        }
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.state == 1 || savedState.state == 2) {
            this.mState = 4;
        } else {
            this.mState = savedState.state;
        }
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.mState);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.mLastNestedScrollDy = 0;
        this.mNestedScrolled = false;
        return (i & 2) != 0;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.mMinOffset) {
            setStateInternal(3);
        } else if (view == this.mNestedScrollingChildRef.get() && this.mNestedScrolled) {
            int i2;
            if (this.mLastNestedScrollDy > 0) {
                i2 = this.mMinOffset;
            } else if (this.mHideable && shouldHide(v, getYVelocity())) {
                i2 = this.mParentHeight;
                i = 5;
            } else {
                if (this.mLastNestedScrollDy == 0) {
                    i2 = v.getTop();
                    i2 = Math.abs(i2 - this.mMinOffset) < Math.abs(i2 - this.mMaxOffset) ? this.mMinOffset : this.mMaxOffset;
                } else {
                    i2 = this.mMaxOffset;
                }
                i = 4;
            }
            if (this.mViewDragHelper.smoothSlideViewTo(v, v.getLeft(), i2)) {
                setStateInternal(2);
                ViewCompat.postOnAnimation(v, new SettleRunnable(v, i));
            } else {
                setStateInternal(i);
            }
            this.mNestedScrolled = false;
        }
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mState == 1 && actionMasked == 0) {
            return true;
        }
        this.mViewDragHelper.processTouchEvent(motionEvent);
        if (actionMasked == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.mIgnoreEvents && Math.abs(((float) this.mInitialY) - motionEvent.getY()) > ((float) this.mViewDragHelper.getTouchSlop())) {
            this.mViewDragHelper.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return this.mIgnoreEvents ^ 1;
    }

    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.mCallback = bottomSheetCallback;
    }

    public void setHideable(boolean z) {
        this.mHideable = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:? A:{SYNTHETIC, RETURN, SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
    public final void setPeekHeight(int r4) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        r2 = -1;
        if (r4 != r2) goto L_0x000c;
    L_0x0005:
        r4 = r3.mPeekHeightAuto;
        if (r4 != 0) goto L_0x0015;
    L_0x0009:
        r3.mPeekHeightAuto = r0;
        goto L_0x0024;
    L_0x000c:
        r2 = r3.mPeekHeightAuto;
        if (r2 != 0) goto L_0x0017;
    L_0x0010:
        r2 = r3.mPeekHeight;
        if (r2 == r4) goto L_0x0015;
    L_0x0014:
        goto L_0x0017;
    L_0x0015:
        r0 = r1;
        goto L_0x0024;
    L_0x0017:
        r3.mPeekHeightAuto = r1;
        r1 = java.lang.Math.max(r1, r4);
        r3.mPeekHeight = r1;
        r1 = r3.mParentHeight;
        r1 = r1 - r4;
        r3.mMaxOffset = r1;
    L_0x0024:
        if (r0 == 0) goto L_0x003c;
    L_0x0026:
        r4 = r3.mState;
        r0 = 4;
        if (r4 != r0) goto L_0x003c;
    L_0x002b:
        r4 = r3.mViewRef;
        if (r4 == 0) goto L_0x003c;
    L_0x002f:
        r4 = r3.mViewRef;
        r4 = r4.get();
        r4 = (android.view.View) r4;
        if (r4 == 0) goto L_0x003c;
    L_0x0039:
        r4.requestLayout();
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.setPeekHeight(int):void");
    }

    public void setSkipCollapsed(boolean z) {
        this.mSkipCollapsed = z;
    }

    public final void setState(final int i) {
        if (i != this.mState) {
            if (this.mViewRef == null) {
                if (i == 4 || i == 3 || (this.mHideable && i == 5)) {
                    this.mState = i;
                }
                return;
            }
            final View view = (View) this.mViewRef.get();
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(view)) {
                    view.post(new Runnable() {
                        public void run() {
                            BottomSheetBehavior.this.startSettlingAnimation(view, i);
                        }
                    });
                } else {
                    startSettlingAnimation(view, i);
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setStateInternal(int i) {
        if (this.mState != i) {
            this.mState = i;
            View view = (View) this.mViewRef.get();
            if (!(view == null || this.mCallback == null)) {
                this.mCallback.onStateChanged(view, i);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean shouldHide(View view, float f) {
        boolean z = true;
        if (this.mSkipCollapsed) {
            return true;
        }
        if (view.getTop() < this.mMaxOffset) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.mMaxOffset)) / ((float) this.mPeekHeight) <= 0.5f) {
            z = false;
        }
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public void startSettlingAnimation(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.mMaxOffset;
        } else if (i == 3) {
            i2 = this.mMinOffset;
        } else if (this.mHideable && i == 5) {
            i2 = this.mParentHeight;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Illegal state argument: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        setStateInternal(2);
        if (this.mViewDragHelper.smoothSlideViewTo(view, view.getLeft(), i2)) {
            ViewCompat.postOnAnimation(view, new SettleRunnable(view, i));
        }
    }
}
