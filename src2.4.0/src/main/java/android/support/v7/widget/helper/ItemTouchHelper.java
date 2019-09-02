package android.support.v7.widget.helper;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends ItemDecoration implements OnChildAttachStateChangeListener {
    static final int ACTION_MODE_DRAG_MASK = 16711680;
    private static final int ACTION_MODE_IDLE_MASK = 255;
    static final int ACTION_MODE_SWIPE_MASK = 65280;
    public static final int ACTION_STATE_DRAG = 2;
    public static final int ACTION_STATE_IDLE = 0;
    public static final int ACTION_STATE_SWIPE = 1;
    static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_DRAG = 8;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
    static final boolean DEBUG = false;
    static final int DIRECTION_FLAG_COUNT = 8;
    public static final int DOWN = 2;
    public static final int END = 32;
    public static final int LEFT = 4;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int RIGHT = 8;
    public static final int START = 16;
    static final String TAG = "ItemTouchHelper";
    public static final int UP = 1;
    int mActionState = 0;
    int mActivePointerId = -1;
    Callback mCallback;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
    private List<Integer> mDistances;
    private long mDragScrollStartTimeInMs;
    float mDx;
    float mDy;
    GestureDetectorCompat mGestureDetector;
    float mInitialTouchX;
    float mInitialTouchY;
    float mMaxSwipeVelocity;
    private final OnItemTouchListener mOnItemTouchListener = new OnItemTouchListener() {
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked == 0) {
                ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(0);
                ItemTouchHelper.this.mInitialTouchX = motionEvent.getX();
                ItemTouchHelper.this.mInitialTouchY = motionEvent.getY();
                ItemTouchHelper.this.obtainVelocityTracker();
                if (ItemTouchHelper.this.mSelected == null) {
                    RecoverAnimation findAnimation = ItemTouchHelper.this.findAnimation(motionEvent);
                    if (findAnimation != null) {
                        ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                        itemTouchHelper.mInitialTouchX -= findAnimation.mX;
                        itemTouchHelper = ItemTouchHelper.this;
                        itemTouchHelper.mInitialTouchY -= findAnimation.mY;
                        ItemTouchHelper.this.endRecoverAnimation(findAnimation.mViewHolder, true);
                        if (ItemTouchHelper.this.mPendingCleanup.remove(findAnimation.mViewHolder.itemView)) {
                            ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, findAnimation.mViewHolder);
                        }
                        ItemTouchHelper.this.select(findAnimation.mViewHolder, findAnimation.mActionState);
                        ItemTouchHelper.this.updateDxDy(motionEvent, ItemTouchHelper.this.mSelectedFlags, 0);
                    }
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper.this.mActivePointerId = -1;
                ItemTouchHelper.this.select(null, 0);
            } else if (ItemTouchHelper.this.mActivePointerId != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                }
            }
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            return ItemTouchHelper.this.mSelected != null;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                ItemTouchHelper.this.select(null, 0);
            }
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.mGestureDetector.onTouchEvent(motionEvent);
            if (ItemTouchHelper.this.mVelocityTracker != null) {
                ItemTouchHelper.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.mActivePointerId != -1) {
                int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.checkSelectForSwipe(actionMasked, motionEvent, findPointerIndex);
                }
                ViewHolder viewHolder = ItemTouchHelper.this.mSelected;
                if (viewHolder != null) {
                    int i = 0;
                    if (actionMasked != 6) {
                        switch (actionMasked) {
                            case 1:
                                break;
                            case 2:
                                if (findPointerIndex >= 0) {
                                    ItemTouchHelper.this.updateDxDy(motionEvent, ItemTouchHelper.this.mSelectedFlags, findPointerIndex);
                                    ItemTouchHelper.this.moveIfNecessary(viewHolder);
                                    ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                                    ItemTouchHelper.this.mScrollRunnable.run();
                                    ItemTouchHelper.this.mRecyclerView.invalidate();
                                    break;
                                }
                                break;
                            case 3:
                                if (ItemTouchHelper.this.mVelocityTracker != null) {
                                    ItemTouchHelper.this.mVelocityTracker.clear();
                                    break;
                                }
                                break;
                        }
                        ItemTouchHelper.this.select(null, 0);
                        ItemTouchHelper.this.mActivePointerId = -1;
                    } else {
                        actionMasked = MotionEventCompat.getActionIndex(motionEvent);
                        if (motionEvent.getPointerId(actionMasked) == ItemTouchHelper.this.mActivePointerId) {
                            if (actionMasked == 0) {
                                i = 1;
                            }
                            ItemTouchHelper.this.mActivePointerId = motionEvent.getPointerId(i);
                            ItemTouchHelper.this.updateDxDy(motionEvent, ItemTouchHelper.this.mSelectedFlags, actionMasked);
                        }
                    }
                }
            }
        }
    };
    View mOverdrawChild = null;
    int mOverdrawChildPosition = -1;
    final List<View> mPendingCleanup = new ArrayList();
    List<RecoverAnimation> mRecoverAnimations = new ArrayList();
    RecyclerView mRecyclerView;
    final Runnable mScrollRunnable = new Runnable() {
        public void run() {
            if (ItemTouchHelper.this.mSelected != null && ItemTouchHelper.this.scrollIfNecessary()) {
                if (ItemTouchHelper.this.mSelected != null) {
                    ItemTouchHelper.this.moveIfNecessary(ItemTouchHelper.this.mSelected);
                }
                ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
                ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, this);
            }
        }
    };
    ViewHolder mSelected = null;
    int mSelectedFlags;
    float mSelectedStartX;
    float mSelectedStartY;
    private int mSlop;
    private List<ViewHolder> mSwapTargets;
    float mSwipeEscapeVelocity;
    private final float[] mTmpPosition = new float[2];
    private Rect mTmpRect;
    VelocityTracker mVelocityTracker;

    public interface ViewDropHandler {
        void prepareForDrop(View view, View view2, int i, int i2);
    }

    private class RecoverAnimation implements AnimatorListenerCompat {
        final int mActionState;
        final int mAnimationType;
        boolean mEnded = false;
        private float mFraction;
        public boolean mIsPendingCleanup;
        boolean mOverridden = false;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        private final ValueAnimatorCompat mValueAnimator;
        final ViewHolder mViewHolder;
        float mX;
        float mY;

        public RecoverAnimation(ViewHolder viewHolder, int i, int i2, float f, float f2, float f3, float f4) {
            this.mActionState = i2;
            this.mAnimationType = i;
            this.mViewHolder = viewHolder;
            this.mStartDx = f;
            this.mStartDy = f2;
            this.mTargetX = f3;
            this.mTargetY = f4;
            this.mValueAnimator = AnimatorCompatHelper.emptyValueAnimator();
            this.mValueAnimator.addUpdateListener(new AnimatorUpdateListenerCompat(ItemTouchHelper.this) {
                public void onAnimationUpdate(ValueAnimatorCompat valueAnimatorCompat) {
                    RecoverAnimation.this.setFraction(valueAnimatorCompat.getAnimatedFraction());
                }
            });
            this.mValueAnimator.setTarget(viewHolder.itemView);
            this.mValueAnimator.addListener(this);
            setFraction(0.0f);
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        public void onAnimationCancel(ValueAnimatorCompat valueAnimatorCompat) {
            setFraction(1.0f);
        }

        public void onAnimationEnd(ValueAnimatorCompat valueAnimatorCompat) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        public void onAnimationRepeat(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void onAnimationStart(ValueAnimatorCompat valueAnimatorCompat) {
        }

        public void setDuration(long j) {
            this.mValueAnimator.setDuration(j);
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void update() {
            if (this.mStartDx == this.mTargetX) {
                this.mX = ViewCompat.getTranslationX(this.mViewHolder.itemView);
            } else {
                this.mX = this.mStartDx + (this.mFraction * (this.mTargetX - this.mStartDx));
            }
            if (this.mStartDy == this.mTargetY) {
                this.mY = ViewCompat.getTranslationY(this.mViewHolder.itemView);
            } else {
                this.mY = this.mStartDy + (this.mFraction * (this.mTargetY - this.mStartDy));
            }
        }
    }

    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new Interpolator() {
            public float getInterpolation(float f) {
                return (((f * f) * f) * f) * f;
            }
        };
        private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator() {
            public float getInterpolation(float f) {
                f -= 1.0f;
                return ((((f * f) * f) * f) * f) + 1.0f;
            }
        };
        private static final ItemTouchUIUtil sUICallback;
        private int mCachedMaxScrollSpeed = -1;

        static {
            if (VERSION.SDK_INT >= 21) {
                sUICallback = new Lollipop();
            } else if (VERSION.SDK_INT >= 11) {
                sUICallback = new Honeycomb();
            } else {
                sUICallback = new Gingerbread();
            }
        }

        public static int convertToRelativeDirection(int i, int i2) {
            int i3 = i & ABS_HORIZONTAL_DIR_FLAGS;
            if (i3 == 0) {
                return i;
            }
            i &= i3 ^ -1;
            if (i2 == 0) {
                return i | (i3 << 2);
            }
            i2 = i3 << 1;
            return (i | (-789517 & i2)) | ((i2 & ABS_HORIZONTAL_DIR_FLAGS) << 2);
        }

        public static ItemTouchUIUtil getDefaultUIUtil() {
            return sUICallback;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int i, int i2) {
            return i2 << (i * 8);
        }

        public static int makeMovementFlags(int i, int i2) {
            return makeFlag(2, i) | (makeFlag(1, i2) | makeFlag(0, i2 | i));
        }

        public boolean canDropOver(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder viewHolder2) {
            return true;
        }

        public ViewHolder chooseDropTarget(ViewHolder viewHolder, List<ViewHolder> list, int i, int i2) {
            ViewHolder viewHolder2 = viewHolder;
            int width = i + viewHolder2.itemView.getWidth();
            int height = i2 + viewHolder2.itemView.getHeight();
            int left = i - viewHolder2.itemView.getLeft();
            int top = i2 - viewHolder2.itemView.getTop();
            int size = list.size();
            ViewHolder viewHolder3 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                int right;
                ViewHolder viewHolder4 = (ViewHolder) list.get(i4);
                if (left > 0) {
                    right = viewHolder4.itemView.getRight() - width;
                    if (right < 0 && viewHolder4.itemView.getRight() > viewHolder2.itemView.getRight()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            viewHolder3 = viewHolder4;
                            i3 = right;
                        }
                    }
                }
                if (left < 0) {
                    right = viewHolder4.itemView.getLeft() - i;
                    if (right > 0 && viewHolder4.itemView.getLeft() < viewHolder2.itemView.getLeft()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            viewHolder3 = viewHolder4;
                            i3 = right;
                        }
                    }
                }
                if (top < 0) {
                    right = viewHolder4.itemView.getTop() - i2;
                    if (right > 0 && viewHolder4.itemView.getTop() < viewHolder2.itemView.getTop()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            viewHolder3 = viewHolder4;
                            i3 = right;
                        }
                    }
                }
                if (top > 0) {
                    right = viewHolder4.itemView.getBottom() - height;
                    if (right < 0 && viewHolder4.itemView.getBottom() > viewHolder2.itemView.getBottom()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            viewHolder3 = viewHolder4;
                            i3 = right;
                        }
                    }
                }
            }
            return viewHolder3;
        }

        public void clearView(RecyclerView recyclerView, ViewHolder viewHolder) {
            sUICallback.clearView(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i, int i2) {
            int i3 = i & RELATIVE_DIR_FLAGS;
            if (i3 == 0) {
                return i;
            }
            i &= i3 ^ -1;
            if (i2 == 0) {
                return i | (i3 >> 2);
            }
            i2 = i3 >> 1;
            return (i | (-3158065 & i2)) | ((i2 & RELATIVE_DIR_FLAGS) >> 2);
        }

        /* Access modifiers changed, original: final */
        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), ViewCompat.getLayoutDirection(recyclerView));
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i == 8 ? 200 : 250;
            }
            return i == 8 ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean hasDragFlag(RecyclerView recyclerView, ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) != 0;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean hasSwipeFlag(RecyclerView recyclerView, ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i, int i2, int i3, long j) {
            float f = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i2)) * getMaxDragScroll(recyclerView))) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                f = ((float) j) / 2000.0f;
            }
            signum = (int) (((float) signum) * sDragScrollInterpolator.getInterpolation(f));
            if (signum != 0) {
                return signum;
            }
            return i2 > 0 ? 1 : -1;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            sUICallback.onDraw(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            sUICallback.onDrawOver(canvas, recyclerView, viewHolder.itemView, f, f2, i, z);
        }

        /* Access modifiers changed, original: 0000 */
        public void onDraw(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            Canvas canvas2 = canvas;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = (RecoverAnimation) list.get(i2);
                recoverAnimation.update();
                int save = canvas2.save();
                onChildDraw(canvas2, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                canvas2.restoreToCount(save);
            }
            if (viewHolder != null) {
                size = canvas2.save();
                onChildDraw(canvas2, recyclerView, viewHolder, f, f2, i, true);
                canvas2.restoreToCount(size);
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, ViewHolder viewHolder, List<RecoverAnimation> list, int i, float f, float f2) {
            int i2;
            Canvas canvas2 = canvas;
            List<RecoverAnimation> list2 = list;
            int size = list.size();
            int i3 = 0;
            for (i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = (RecoverAnimation) list2.get(i2);
                int save = canvas2.save();
                onChildDrawOver(canvas2, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, recoverAnimation.mActionState, false);
                canvas2.restoreToCount(save);
            }
            if (viewHolder != null) {
                i2 = canvas2.save();
                onChildDrawOver(canvas2, recyclerView, viewHolder, f, f2, i, true);
                canvas2.restoreToCount(i2);
            }
            for (size--; size >= 0; size--) {
                RecoverAnimation recoverAnimation2 = (RecoverAnimation) list2.get(size);
                if (recoverAnimation2.mEnded && !recoverAnimation2.mIsPendingCleanup) {
                    list2.remove(size);
                } else if (!recoverAnimation2.mEnded) {
                    i3 = 1;
                }
            }
            if (i3 != 0) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(RecyclerView recyclerView, ViewHolder viewHolder, ViewHolder viewHolder2);

        public void onMoved(RecyclerView recyclerView, ViewHolder viewHolder, int i, ViewHolder viewHolder2, int i2, int i3, int i4) {
            LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof ViewDropHandler) {
                ((ViewDropHandler) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i3, i4);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i2);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i2);
                }
            }
        }

        public void onSelectedChanged(ViewHolder viewHolder, int i) {
            if (viewHolder != null) {
                sUICallback.onSelected(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(ViewHolder viewHolder, int i);
    }

    private class ItemTouchHelperGestureListener extends SimpleOnGestureListener {
        ItemTouchHelperGestureListener() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View findChildView = ItemTouchHelper.this.findChildView(motionEvent);
            if (findChildView != null) {
                ViewHolder childViewHolder = ItemTouchHelper.this.mRecyclerView.getChildViewHolder(findChildView);
                if (childViewHolder != null && ItemTouchHelper.this.mCallback.hasDragFlag(ItemTouchHelper.this.mRecyclerView, childViewHolder) && motionEvent.getPointerId(0) == ItemTouchHelper.this.mActivePointerId) {
                    int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper.this.mInitialTouchX = x;
                    ItemTouchHelper.this.mInitialTouchY = y;
                    ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                    ItemTouchHelper.this.mDy = 0.0f;
                    itemTouchHelper.mDx = 0.0f;
                    if (ItemTouchHelper.this.mCallback.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.select(childViewHolder, 2);
                    }
                }
            }
        }
    }

    public static abstract class SimpleCallback extends Callback {
        private int mDefaultDragDirs;
        private int mDefaultSwipeDirs;

        public SimpleCallback(int i, int i2) {
            this.mDefaultSwipeDirs = i2;
            this.mDefaultDragDirs = i;
        }

        public int getDragDirs(RecyclerView recyclerView, ViewHolder viewHolder) {
            return this.mDefaultDragDirs;
        }

        public int getMovementFlags(RecyclerView recyclerView, ViewHolder viewHolder) {
            return Callback.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        public int getSwipeDirs(RecyclerView recyclerView, ViewHolder viewHolder) {
            return this.mDefaultSwipeDirs;
        }

        public void setDefaultDragDirs(int i) {
            this.mDefaultDragDirs = i;
        }

        public void setDefaultSwipeDirs(int i) {
            this.mDefaultSwipeDirs = i;
        }
    }

    public ItemTouchHelper(Callback callback) {
        this.mCallback = callback;
    }

    private void addChildDrawingOrderCallback() {
        if (VERSION.SDK_INT < 21) {
            if (this.mChildDrawingOrderCallback == null) {
                this.mChildDrawingOrderCallback = new ChildDrawingOrderCallback() {
                    public int onGetChildDrawingOrder(int i, int i2) {
                        if (ItemTouchHelper.this.mOverdrawChild == null) {
                            return i2;
                        }
                        int i3 = ItemTouchHelper.this.mOverdrawChildPosition;
                        if (i3 == -1) {
                            i3 = ItemTouchHelper.this.mRecyclerView.indexOfChild(ItemTouchHelper.this.mOverdrawChild);
                            ItemTouchHelper.this.mOverdrawChildPosition = i3;
                        }
                        if (i2 == i - 1) {
                            return i3;
                        }
                        if (i2 >= i3) {
                            i2++;
                        }
                        return i2;
                    }
                };
            }
            this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
        }
    }

    private int checkHorizontalSwipe(ViewHolder viewHolder, int i) {
        if ((i & 12) != 0) {
            float abs;
            int i2 = 4;
            int i3 = this.mDx > 0.0f ? 8 : 4;
            if (this.mVelocityTracker != null && this.mActivePointerId > -1) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
                float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
                if (xVelocity > 0.0f) {
                    i2 = 8;
                }
                abs = Math.abs(xVelocity);
                if ((i2 & i) != 0 && i3 == i2 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(yVelocity)) {
                    return i2;
                }
            }
            abs = ((float) this.mRecyclerView.getWidth()) * this.mCallback.getSwipeThreshold(viewHolder);
            if ((i & i3) != 0 && Math.abs(this.mDx) > abs) {
                return i3;
            }
        }
        return 0;
    }

    private int checkVerticalSwipe(ViewHolder viewHolder, int i) {
        if ((i & 3) != 0) {
            float abs;
            int i2 = 1;
            int i3 = this.mDy > 0.0f ? 2 : 1;
            if (this.mVelocityTracker != null && this.mActivePointerId > -1) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float xVelocity = VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId);
                float yVelocity = VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId);
                if (yVelocity > 0.0f) {
                    i2 = 2;
                }
                abs = Math.abs(yVelocity);
                if ((i2 & i) != 0 && i2 == i3 && abs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity) && abs > Math.abs(xVelocity)) {
                    return i2;
                }
            }
            abs = ((float) this.mRecyclerView.getHeight()) * this.mCallback.getSwipeThreshold(viewHolder);
            if ((i & i3) != 0 && Math.abs(this.mDy) > abs) {
                return i3;
            }
        }
        return 0;
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            this.mCallback.clearView(this.mRecyclerView, ((RecoverAnimation) this.mRecoverAnimations.get(0)).mViewHolder);
        }
        this.mRecoverAnimations.clear();
        this.mOverdrawChild = null;
        this.mOverdrawChildPosition = -1;
        releaseVelocityTracker();
    }

    private List<ViewHolder> findSwapTargets(ViewHolder viewHolder) {
        ViewHolder viewHolder2 = viewHolder;
        if (this.mSwapTargets == null) {
            this.mSwapTargets = new ArrayList();
            this.mDistances = new ArrayList();
        } else {
            this.mSwapTargets.clear();
            this.mDistances.clear();
        }
        int boundingBoxMargin = this.mCallback.getBoundingBoxMargin();
        int round = Math.round(this.mSelectedStartX + this.mDx) - boundingBoxMargin;
        int round2 = Math.round(this.mSelectedStartY + this.mDy) - boundingBoxMargin;
        boundingBoxMargin *= 2;
        int width = (viewHolder2.itemView.getWidth() + round) + boundingBoxMargin;
        int height = (viewHolder2.itemView.getHeight() + round2) + boundingBoxMargin;
        boundingBoxMargin = (round + width) / 2;
        int i = (round2 + height) / 2;
        LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = layoutManager.getChildAt(i2);
            if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(childAt);
                if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, childViewHolder)) {
                    int abs = Math.abs(boundingBoxMargin - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i - ((childAt.getTop() + childAt.getBottom()) / 2));
                    abs = (abs * abs) + (abs2 * abs2);
                    abs2 = this.mSwapTargets.size();
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < abs2 && abs > ((Integer) this.mDistances.get(i4)).intValue()) {
                        i3++;
                        i4++;
                        viewHolder2 = viewHolder;
                    }
                    this.mSwapTargets.add(i3, childViewHolder);
                    this.mDistances.add(i3, Integer.valueOf(abs));
                }
            }
            i2++;
            viewHolder2 = viewHolder;
        }
        return this.mSwapTargets;
    }

    private ViewHolder findSwipedView(MotionEvent motionEvent) {
        LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (this.mActivePointerId == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        float x = motionEvent.getX(findPointerIndex) - this.mInitialTouchX;
        float y = motionEvent.getY(findPointerIndex) - this.mInitialTouchY;
        x = Math.abs(x);
        y = Math.abs(y);
        if (x < ((float) this.mSlop) && y < ((float) this.mSlop)) {
            return null;
        }
        if (x > y && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if (y > x && layoutManager.canScrollVertically()) {
            return null;
        }
        View findChildView = findChildView(motionEvent);
        return findChildView == null ? null : this.mRecyclerView.getChildViewHolder(findChildView);
    }

    private void getSelectedDxDy(float[] fArr) {
        if ((this.mSelectedFlags & 12) != 0) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - ((float) this.mSelected.itemView.getLeft());
        } else {
            fArr[0] = ViewCompat.getTranslationX(this.mSelected.itemView);
        }
        if ((this.mSelectedFlags & 3) != 0) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - ((float) this.mSelected.itemView.getTop());
        } else {
            fArr[1] = ViewCompat.getTranslationY(this.mSelected.itemView);
        }
    }

    private static boolean hitTest(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    private void initGestureDetector() {
        if (this.mGestureDetector == null) {
            this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), new ItemTouchHelperGestureListener());
        }
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
        initGestureDetector();
    }

    private int swipeIfNecessary(ViewHolder viewHolder) {
        if (this.mActionState == 2) {
            return 0;
        }
        int movementFlags = this.mCallback.getMovementFlags(this.mRecyclerView, viewHolder);
        int convertToAbsoluteDirection = (this.mCallback.convertToAbsoluteDirection(movementFlags, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        movementFlags = (movementFlags & 65280) >> 8;
        int checkHorizontalSwipe;
        int checkVerticalSwipe;
        if (Math.abs(this.mDx) > Math.abs(this.mDy)) {
            checkHorizontalSwipe = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
            if (checkHorizontalSwipe > 0) {
                return (movementFlags & checkHorizontalSwipe) == 0 ? Callback.convertToRelativeDirection(checkHorizontalSwipe, ViewCompat.getLayoutDirection(this.mRecyclerView)) : checkHorizontalSwipe;
            } else {
                checkVerticalSwipe = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
                if (checkVerticalSwipe > 0) {
                    return checkVerticalSwipe;
                }
            }
        }
        checkHorizontalSwipe = checkVerticalSwipe(viewHolder, convertToAbsoluteDirection);
        if (checkHorizontalSwipe > 0) {
            return checkHorizontalSwipe;
        }
        checkVerticalSwipe = checkHorizontalSwipe(viewHolder, convertToAbsoluteDirection);
        if (checkVerticalSwipe > 0) {
            return (movementFlags & checkVerticalSwipe) == 0 ? Callback.convertToRelativeDirection(checkVerticalSwipe, ViewCompat.getLayoutDirection(this.mRecyclerView)) : checkVerticalSwipe;
        }
        return 0;
    }

    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        if (this.mRecyclerView != recyclerView) {
            if (this.mRecyclerView != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (this.mRecyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.mSwipeEscapeVelocity = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                this.mMaxSwipeVelocity = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                setupCallbacks();
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:46:0x0094, code skipped:
            return false;
     */
    public boolean checkSelectForSwipe(int r9, android.view.MotionEvent r10, int r11) {
        /*
        r8 = this;
        r0 = r8.mSelected;
        r1 = 0;
        if (r0 != 0) goto L_0x0094;
    L_0x0005:
        r0 = 2;
        if (r9 != r0) goto L_0x0094;
    L_0x0008:
        r9 = r8.mActionState;
        if (r9 == r0) goto L_0x0094;
    L_0x000c:
        r9 = r8.mCallback;
        r9 = r9.isItemViewSwipeEnabled();
        if (r9 != 0) goto L_0x0016;
    L_0x0014:
        goto L_0x0094;
    L_0x0016:
        r9 = r8.mRecyclerView;
        r9 = r9.getScrollState();
        r2 = 1;
        if (r9 != r2) goto L_0x0020;
    L_0x001f:
        return r1;
    L_0x0020:
        r9 = r8.findSwipedView(r10);
        if (r9 != 0) goto L_0x0027;
    L_0x0026:
        return r1;
    L_0x0027:
        r3 = r8.mCallback;
        r4 = r8.mRecyclerView;
        r3 = r3.getAbsoluteMovementFlags(r4, r9);
        r4 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r3 = r3 & r4;
        r3 = r3 >> 8;
        if (r3 != 0) goto L_0x0038;
    L_0x0037:
        return r1;
    L_0x0038:
        r4 = r10.getX(r11);
        r11 = r10.getY(r11);
        r5 = r8.mInitialTouchX;
        r4 = r4 - r5;
        r5 = r8.mInitialTouchY;
        r11 = r11 - r5;
        r5 = java.lang.Math.abs(r4);
        r6 = java.lang.Math.abs(r11);
        r7 = r8.mSlop;
        r7 = (float) r7;
        r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r7 >= 0) goto L_0x005d;
    L_0x0055:
        r7 = r8.mSlop;
        r7 = (float) r7;
        r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r7 >= 0) goto L_0x005d;
    L_0x005c:
        return r1;
    L_0x005d:
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        r6 = 0;
        if (r5 <= 0) goto L_0x0074;
    L_0x0062:
        r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r11 >= 0) goto L_0x006b;
    L_0x0066:
        r11 = r3 & 4;
        if (r11 != 0) goto L_0x006b;
    L_0x006a:
        return r1;
    L_0x006b:
        r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r11 <= 0) goto L_0x0086;
    L_0x006f:
        r11 = r3 & 8;
        if (r11 != 0) goto L_0x0086;
    L_0x0073:
        return r1;
    L_0x0074:
        r4 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x007d;
    L_0x0078:
        r4 = r3 & 1;
        if (r4 != 0) goto L_0x007d;
    L_0x007c:
        return r1;
    L_0x007d:
        r11 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1));
        if (r11 <= 0) goto L_0x0086;
    L_0x0081:
        r11 = r3 & 2;
        if (r11 != 0) goto L_0x0086;
    L_0x0085:
        return r1;
    L_0x0086:
        r8.mDy = r6;
        r8.mDx = r6;
        r10 = r10.getPointerId(r1);
        r8.mActivePointerId = r10;
        r8.select(r9, r2);
        return r2;
    L_0x0094:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.helper.ItemTouchHelper.checkSelectForSwipe(int, android.view.MotionEvent, int):boolean");
    }

    /* Access modifiers changed, original: 0000 */
    public int endRecoverAnimation(ViewHolder viewHolder, boolean z) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = (RecoverAnimation) this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return recoverAnimation.mAnimationType;
            }
        }
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public RecoverAnimation findAnimation(MotionEvent motionEvent) {
        if (this.mRecoverAnimations.isEmpty()) {
            return null;
        }
        View findChildView = findChildView(motionEvent);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = (RecoverAnimation) this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder.itemView == findChildView) {
                return recoverAnimation;
            }
        }
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public View findChildView(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.mSelected != null) {
            View view = this.mSelected.itemView;
            if (hitTest(view, x, y, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view;
            }
        }
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = (RecoverAnimation) this.mRecoverAnimations.get(size);
            View view2 = recoverAnimation.mViewHolder.itemView;
            if (hitTest(view2, x, y, recoverAnimation.mX, recoverAnimation.mY)) {
                return view2;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x, y);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        rect.setEmpty();
    }

    /* Access modifiers changed, original: 0000 */
    public boolean hasRunningRecoverAnim() {
        int size = this.mRecoverAnimations.size();
        for (int i = 0; i < size; i++) {
            if (!((RecoverAnimation) this.mRecoverAnimations.get(i)).mEnded) {
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void moveIfNecessary(ViewHolder viewHolder) {
        if (!this.mRecyclerView.isLayoutRequested() && this.mActionState == 2) {
            float moveThreshold = this.mCallback.getMoveThreshold(viewHolder);
            int i = (int) (this.mSelectedStartX + this.mDx);
            int i2 = (int) (this.mSelectedStartY + this.mDy);
            if (((float) Math.abs(i2 - viewHolder.itemView.getTop())) >= ((float) viewHolder.itemView.getHeight()) * moveThreshold || ((float) Math.abs(i - viewHolder.itemView.getLeft())) >= ((float) viewHolder.itemView.getWidth()) * moveThreshold) {
                List findSwapTargets = findSwapTargets(viewHolder);
                if (findSwapTargets.size() != 0) {
                    ViewHolder chooseDropTarget = this.mCallback.chooseDropTarget(viewHolder, findSwapTargets, i, i2);
                    if (chooseDropTarget == null) {
                        this.mSwapTargets.clear();
                        this.mDistances.clear();
                        return;
                    }
                    int adapterPosition = chooseDropTarget.getAdapterPosition();
                    int adapterPosition2 = viewHolder.getAdapterPosition();
                    if (this.mCallback.onMove(this.mRecyclerView, viewHolder, chooseDropTarget)) {
                        this.mCallback.onMoved(this.mRecyclerView, viewHolder, adapterPosition2, chooseDropTarget, adapterPosition, i, i2);
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void obtainVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    public void onChildViewAttachedToWindow(View view) {
    }

    public void onChildViewDetachedFromWindow(View view) {
        removeChildDrawingOrderCallbackIfNecessary(view);
        ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder != null) {
            if (this.mSelected == null || childViewHolder != this.mSelected) {
                endRecoverAnimation(childViewHolder, false);
                if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
                    this.mCallback.clearView(this.mRecyclerView, childViewHolder);
                }
            } else {
                select(null, 0);
            }
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
        float f;
        float f2;
        this.mOverdrawChildPosition = -1;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float f3 = this.mTmpPosition[0];
            f = this.mTmpPosition[1];
            f2 = f3;
        } else {
            f2 = 0.0f;
            f = f2;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f2, f);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
        float f;
        float f2;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float f3 = this.mTmpPosition[0];
            f = this.mTmpPosition[1];
            f2 = f3;
        } else {
            f2 = 0.0f;
            f = f2;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f2, f);
    }

    /* Access modifiers changed, original: 0000 */
    public void postDispatchSwipe(final RecoverAnimation recoverAnimation, final int i) {
        this.mRecyclerView.post(new Runnable() {
            public void run() {
                if (ItemTouchHelper.this.mRecyclerView != null && ItemTouchHelper.this.mRecyclerView.isAttachedToWindow() && !recoverAnimation.mOverridden && recoverAnimation.mViewHolder.getAdapterPosition() != -1) {
                    ItemAnimator itemAnimator = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !ItemTouchHelper.this.hasRunningRecoverAnim()) {
                        ItemTouchHelper.this.mCallback.onSwiped(recoverAnimation.mViewHolder, i);
                    } else {
                        ItemTouchHelper.this.mRecyclerView.post(this);
                    }
                }
            }
        });
    }

    /* Access modifiers changed, original: 0000 */
    public void removeChildDrawingOrderCallbackIfNecessary(View view) {
        if (view == this.mOverdrawChild) {
            this.mOverdrawChild = null;
            if (this.mChildDrawingOrderCallback != null) {
                this.mRecyclerView.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0104 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0104 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARNING: Missing block: B:32:0x00c8, code skipped:
            if (r1 > 0) goto L_0x00cc;
     */
    public boolean scrollIfNecessary() {
        /*
        r18 = this;
        r0 = r18;
        r1 = r0.mSelected;
        r2 = 0;
        r3 = -9223372036854775808;
        if (r1 != 0) goto L_0x000c;
    L_0x0009:
        r0.mDragScrollStartTimeInMs = r3;
        return r2;
    L_0x000c:
        r5 = java.lang.System.currentTimeMillis();
        r7 = r0.mDragScrollStartTimeInMs;
        r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r1 != 0) goto L_0x0019;
    L_0x0016:
        r7 = 0;
        goto L_0x001e;
    L_0x0019:
        r7 = r0.mDragScrollStartTimeInMs;
        r9 = r5 - r7;
        r7 = r9;
    L_0x001e:
        r1 = r0.mRecyclerView;
        r1 = r1.getLayoutManager();
        r9 = r0.mTmpRect;
        if (r9 != 0) goto L_0x002f;
    L_0x0028:
        r9 = new android.graphics.Rect;
        r9.<init>();
        r0.mTmpRect = r9;
    L_0x002f:
        r9 = r0.mSelected;
        r9 = r9.itemView;
        r10 = r0.mTmpRect;
        r1.calculateItemDecorationsForChild(r9, r10);
        r9 = r1.canScrollHorizontally();
        r10 = 0;
        if (r9 == 0) goto L_0x0082;
    L_0x003f:
        r9 = r0.mSelectedStartX;
        r11 = r0.mDx;
        r9 = r9 + r11;
        r9 = (int) r9;
        r11 = r0.mTmpRect;
        r11 = r11.left;
        r11 = r9 - r11;
        r12 = r0.mRecyclerView;
        r12 = r12.getPaddingLeft();
        r11 = r11 - r12;
        r12 = r0.mDx;
        r12 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r12 >= 0) goto L_0x005c;
    L_0x0058:
        if (r11 >= 0) goto L_0x005c;
    L_0x005a:
        r14 = r11;
        goto L_0x0083;
    L_0x005c:
        r11 = r0.mDx;
        r11 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1));
        if (r11 <= 0) goto L_0x0082;
    L_0x0062:
        r11 = r0.mSelected;
        r11 = r11.itemView;
        r11 = r11.getWidth();
        r9 = r9 + r11;
        r11 = r0.mTmpRect;
        r11 = r11.right;
        r9 = r9 + r11;
        r11 = r0.mRecyclerView;
        r11 = r11.getWidth();
        r12 = r0.mRecyclerView;
        r12 = r12.getPaddingRight();
        r11 = r11 - r12;
        r9 = r9 - r11;
        if (r9 <= 0) goto L_0x0082;
    L_0x0080:
        r14 = r9;
        goto L_0x0083;
    L_0x0082:
        r14 = r2;
    L_0x0083:
        r1 = r1.canScrollVertically();
        if (r1 == 0) goto L_0x00cb;
    L_0x0089:
        r1 = r0.mSelectedStartY;
        r9 = r0.mDy;
        r1 = r1 + r9;
        r1 = (int) r1;
        r9 = r0.mTmpRect;
        r9 = r9.top;
        r9 = r1 - r9;
        r11 = r0.mRecyclerView;
        r11 = r11.getPaddingTop();
        r9 = r9 - r11;
        r11 = r0.mDy;
        r11 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1));
        if (r11 >= 0) goto L_0x00a6;
    L_0x00a2:
        if (r9 >= 0) goto L_0x00a6;
    L_0x00a4:
        r1 = r9;
        goto L_0x00cc;
    L_0x00a6:
        r9 = r0.mDy;
        r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1));
        if (r9 <= 0) goto L_0x00cb;
    L_0x00ac:
        r9 = r0.mSelected;
        r9 = r9.itemView;
        r9 = r9.getHeight();
        r1 = r1 + r9;
        r9 = r0.mTmpRect;
        r9 = r9.bottom;
        r1 = r1 + r9;
        r9 = r0.mRecyclerView;
        r9 = r9.getHeight();
        r10 = r0.mRecyclerView;
        r10 = r10.getPaddingBottom();
        r9 = r9 - r10;
        r1 = r1 - r9;
        if (r1 <= 0) goto L_0x00cb;
    L_0x00ca:
        goto L_0x00cc;
    L_0x00cb:
        r1 = r2;
    L_0x00cc:
        if (r14 == 0) goto L_0x00e6;
    L_0x00ce:
        r11 = r0.mCallback;
        r12 = r0.mRecyclerView;
        r9 = r0.mSelected;
        r9 = r9.itemView;
        r13 = r9.getWidth();
        r9 = r0.mRecyclerView;
        r15 = r9.getWidth();
        r16 = r7;
        r14 = r11.interpolateOutOfBoundsScroll(r12, r13, r14, r15, r16);
    L_0x00e6:
        r9 = r14;
        if (r1 == 0) goto L_0x0102;
    L_0x00e9:
        r11 = r0.mCallback;
        r12 = r0.mRecyclerView;
        r10 = r0.mSelected;
        r10 = r10.itemView;
        r13 = r10.getHeight();
        r10 = r0.mRecyclerView;
        r15 = r10.getHeight();
        r14 = r1;
        r16 = r7;
        r1 = r11.interpolateOutOfBoundsScroll(r12, r13, r14, r15, r16);
    L_0x0102:
        if (r9 != 0) goto L_0x010a;
    L_0x0104:
        if (r1 == 0) goto L_0x0107;
    L_0x0106:
        goto L_0x010a;
    L_0x0107:
        r0.mDragScrollStartTimeInMs = r3;
        return r2;
    L_0x010a:
        r7 = r0.mDragScrollStartTimeInMs;
        r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r2 != 0) goto L_0x0112;
    L_0x0110:
        r0.mDragScrollStartTimeInMs = r5;
    L_0x0112:
        r2 = r0.mRecyclerView;
        r2.scrollBy(r9, r1);
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.helper.ItemTouchHelper.scrollIfNecessary():boolean");
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d  */
    public void select(android.support.v7.widget.RecyclerView.ViewHolder r25, int r26) {
        /*
        r24 = this;
        r11 = r24;
        r12 = r25;
        r13 = r26;
        r0 = r11.mSelected;
        if (r12 != r0) goto L_0x000f;
    L_0x000a:
        r0 = r11.mActionState;
        if (r13 != r0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = -9223372036854775808;
        r11.mDragScrollStartTimeInMs = r0;
        r4 = r11.mActionState;
        r14 = 1;
        r11.endRecoverAnimation(r12, r14);
        r11.mActionState = r13;
        r15 = 2;
        if (r13 != r15) goto L_0x0025;
    L_0x001e:
        r0 = r12.itemView;
        r11.mOverdrawChild = r0;
        r24.addChildDrawingOrderCallback();
    L_0x0025:
        r10 = 8;
        r0 = r10 * r13;
        r0 = r0 + r10;
        r0 = r14 << r0;
        r16 = r0 + -1;
        r0 = r11.mSelected;
        r9 = 0;
        if (r0 == 0) goto L_0x00e4;
    L_0x0033:
        r8 = r11.mSelected;
        r0 = r8.itemView;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00d0;
    L_0x003d:
        if (r4 != r15) goto L_0x0041;
    L_0x003f:
        r7 = r9;
        goto L_0x0046;
    L_0x0041:
        r0 = r11.swipeIfNecessary(r8);
        r7 = r0;
    L_0x0046:
        r24.releaseVelocityTracker();
        r0 = 4;
        r1 = 0;
        if (r7 == r0) goto L_0x0072;
    L_0x004d:
        if (r7 == r10) goto L_0x0072;
    L_0x004f:
        r2 = 16;
        if (r7 == r2) goto L_0x0072;
    L_0x0053:
        r2 = 32;
        if (r7 == r2) goto L_0x0072;
    L_0x0057:
        switch(r7) {
            case 1: goto L_0x005f;
            case 2: goto L_0x005f;
            default: goto L_0x005a;
        };
    L_0x005a:
        r17 = r1;
        r18 = r17;
        goto L_0x0084;
    L_0x005f:
        r2 = r11.mDy;
        r2 = java.lang.Math.signum(r2);
        r3 = r11.mRecyclerView;
        r3 = r3.getHeight();
        r3 = (float) r3;
        r2 = r2 * r3;
        r17 = r1;
        r18 = r2;
        goto L_0x0084;
    L_0x0072:
        r2 = r11.mDx;
        r2 = java.lang.Math.signum(r2);
        r3 = r11.mRecyclerView;
        r3 = r3.getWidth();
        r3 = (float) r3;
        r2 = r2 * r3;
        r18 = r1;
        r17 = r2;
    L_0x0084:
        if (r4 != r15) goto L_0x0088;
    L_0x0086:
        r6 = r10;
        goto L_0x008d;
    L_0x0088:
        if (r7 <= 0) goto L_0x008c;
    L_0x008a:
        r6 = r15;
        goto L_0x008d;
    L_0x008c:
        r6 = r0;
    L_0x008d:
        r0 = r11.mTmpPosition;
        r11.getSelectedDxDy(r0);
        r0 = r11.mTmpPosition;
        r19 = r0[r9];
        r0 = r11.mTmpPosition;
        r20 = r0[r14];
        r5 = new android.support.v7.widget.helper.ItemTouchHelper$3;
        r0 = r5;
        r1 = r11;
        r2 = r8;
        r3 = r6;
        r14 = r5;
        r5 = r19;
        r15 = r6;
        r6 = r20;
        r21 = r7;
        r7 = r17;
        r22 = r8;
        r8 = r18;
        r9 = r21;
        r21 = r10;
        r10 = r22;
        r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r0 = r11.mCallback;
        r1 = r11.mRecyclerView;
        r2 = r17 - r19;
        r3 = r18 - r20;
        r0 = r0.getAnimationDuration(r1, r15, r2, r3);
        r14.setDuration(r0);
        r0 = r11.mRecoverAnimations;
        r0.add(r14);
        r14.start();
        r9 = 1;
        goto L_0x00e0;
    L_0x00d0:
        r0 = r8;
        r21 = r10;
        r1 = r0.itemView;
        r11.removeChildDrawingOrderCallbackIfNecessary(r1);
        r1 = r11.mCallback;
        r2 = r11.mRecyclerView;
        r1.clearView(r2, r0);
        r9 = 0;
    L_0x00e0:
        r0 = 0;
        r11.mSelected = r0;
        goto L_0x00e7;
    L_0x00e4:
        r21 = r10;
        r9 = 0;
    L_0x00e7:
        if (r12 == 0) goto L_0x011a;
    L_0x00e9:
        r0 = r11.mCallback;
        r1 = r11.mRecyclerView;
        r0 = r0.getAbsoluteMovementFlags(r1, r12);
        r0 = r0 & r16;
        r1 = r11.mActionState;
        r1 = r1 * 8;
        r0 = r0 >> r1;
        r11.mSelectedFlags = r0;
        r0 = r12.itemView;
        r0 = r0.getLeft();
        r0 = (float) r0;
        r11.mSelectedStartX = r0;
        r0 = r12.itemView;
        r0 = r0.getTop();
        r0 = (float) r0;
        r11.mSelectedStartY = r0;
        r11.mSelected = r12;
        r0 = 2;
        if (r13 != r0) goto L_0x011a;
    L_0x0111:
        r0 = r11.mSelected;
        r0 = r0.itemView;
        r1 = 0;
        r0.performHapticFeedback(r1);
        goto L_0x011b;
    L_0x011a:
        r1 = 0;
    L_0x011b:
        r0 = r11.mRecyclerView;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x012b;
    L_0x0123:
        r2 = r11.mSelected;
        if (r2 == 0) goto L_0x0128;
    L_0x0127:
        r1 = 1;
    L_0x0128:
        r0.requestDisallowInterceptTouchEvent(r1);
    L_0x012b:
        if (r9 != 0) goto L_0x0136;
    L_0x012d:
        r0 = r11.mRecyclerView;
        r0 = r0.getLayoutManager();
        r0.requestSimpleAnimationsInNextLayout();
    L_0x0136:
        r0 = r11.mCallback;
        r1 = r11.mSelected;
        r2 = r11.mActionState;
        r0.onSelectedChanged(r1, r2);
        r0 = r11.mRecyclerView;
        r0.invalidate();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.helper.ItemTouchHelper.select(android.support.v7.widget.RecyclerView$ViewHolder, int):void");
    }

    public void startDrag(ViewHolder viewHolder) {
        if (!this.mCallback.hasDragFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start drag has been called but swiping is not enabled");
        } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 2);
        }
    }

    public void startSwipe(ViewHolder viewHolder) {
        if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, viewHolder)) {
            Log.e(TAG, "Start swipe has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.mRecyclerView) {
            Log.e(TAG, "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
        } else {
            obtainVelocityTracker();
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            select(viewHolder, 1);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void updateDxDy(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.mDx = x - this.mInitialTouchX;
        this.mDy = y - this.mInitialTouchY;
        if ((i & 4) == 0) {
            this.mDx = Math.max(0.0f, this.mDx);
        }
        if ((i & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
        }
        if ((i & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((i & 2) == 0) {
            this.mDy = Math.min(0.0f, this.mDy);
        }
    }
}
