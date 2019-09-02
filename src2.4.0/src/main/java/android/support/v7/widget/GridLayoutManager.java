package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets = new Rect();
    boolean mPendingSpanCountChange = false;
    final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    View[] mSet;
    int mSpanCount = -1;
    SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        /* Access modifiers changed, original: 0000 */
        public int findReferenceIndexFromCache(int i) {
            int size = this.mSpanIndexCache.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.mSpanIndexCache.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            i2--;
            return (i2 < 0 || i2 >= this.mSpanIndexCache.size()) ? -1 : this.mSpanIndexCache.keyAt(i2);
        }

        /* Access modifiers changed, original: 0000 */
        public int getCachedSpanIndex(int i, int i2) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.mSpanIndexCache.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            i2 = getSpanIndex(i, i2);
            this.mSpanIndexCache.put(i, i2);
            return i2;
        }

        public int getSpanGroupIndex(int i, int i2) {
            int spanSize = getSpanSize(i);
            int i3 = 0;
            int i4 = i3;
            int i5 = i4;
            while (i3 < i) {
                int spanSize2 = getSpanSize(i3);
                i4 += spanSize2;
                if (i4 == i2) {
                    i5++;
                    i4 = 0;
                } else if (i4 > i2) {
                    i5++;
                    i4 = spanSize2;
                }
                i3++;
            }
            return i4 + spanSize > i2 ? i5 + 1 : i5;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A:{RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A:{RETURN} */
        public int getSpanIndex(int r6, int r7) {
            /*
            r5 = this;
            r0 = r5.getSpanSize(r6);
            r1 = 0;
            if (r0 != r7) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            r2 = r5.mCacheSpanIndices;
            if (r2 == 0) goto L_0x0028;
        L_0x000c:
            r2 = r5.mSpanIndexCache;
            r2 = r2.size();
            if (r2 <= 0) goto L_0x0028;
        L_0x0014:
            r2 = r5.findReferenceIndexFromCache(r6);
            if (r2 < 0) goto L_0x0028;
        L_0x001a:
            r3 = r5.mSpanIndexCache;
            r3 = r3.get(r2);
            r4 = r5.getSpanSize(r2);
            r3 = r3 + r4;
            r2 = r2 + 1;
            goto L_0x002a;
        L_0x0028:
            r2 = r1;
            r3 = r2;
        L_0x002a:
            if (r2 >= r6) goto L_0x003b;
        L_0x002c:
            r4 = r5.getSpanSize(r2);
            r3 = r3 + r4;
            if (r3 != r7) goto L_0x0035;
        L_0x0033:
            r3 = r1;
            goto L_0x0038;
        L_0x0035:
            if (r3 <= r7) goto L_0x0038;
        L_0x0037:
            r3 = r4;
        L_0x0038:
            r2 = r2 + 1;
            goto L_0x002a;
        L_0x003b:
            r0 = r0 + r3;
            if (r0 > r7) goto L_0x003f;
        L_0x003e:
            return r3;
        L_0x003f:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager$SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            this.mCacheSpanIndices = z;
        }
    }

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }

        public int getSpanSize(int i) {
            return 1;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex = -1;
        int mSpanSize = 0;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setSpanCount(LayoutManager.getProperties(context, attributeSet, i, i2).spanCount);
    }

    private void assignSpans(Recycler recycler, State state, int i, int i2, boolean z) {
        int i3;
        i2 = -1;
        int i4 = 0;
        if (z) {
            i3 = 1;
            i2 = i;
            i = 0;
        } else {
            i--;
            i3 = -1;
        }
        while (i != i2) {
            View view = this.mSet[i];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.mSpanSize = getSpanSize(recycler, state, getPosition(view));
            layoutParams.mSpanIndex = i4;
            i4 += layoutParams.mSpanSize;
            i += i3;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    private void calculateItemBorders(int i) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i);
    }

    static int[] calculateItemBorders(int[] iArr, int i, int i2) {
        int i3 = 1;
        if (!(iArr != null && iArr.length == i + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        i2 %= i;
        int i6 = 0;
        while (i3 <= i) {
            int i7;
            i4 += i2;
            if (i4 <= 0 || i - i4 >= i2) {
                i7 = i5;
            } else {
                i7 = i5 + 1;
                i4 -= i;
            }
            i6 += i7;
            iArr[i3] = i6;
            i3++;
        }
        return iArr;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private void ensureAnchorIsInCorrectSpan(Recycler recycler, State state, AnchorInfo anchorInfo, int i) {
        i = i == 1 ? 1 : 0;
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        if (i != 0) {
            while (spanIndex > 0 && anchorInfo.mPosition > 0) {
                anchorInfo.mPosition--;
                spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
            }
            return;
        }
        i = state.getItemCount() - 1;
        int i2 = anchorInfo.mPosition;
        while (i2 < i) {
            int i3 = i2 + 1;
            int spanIndex2 = getSpanIndex(recycler, state, i3);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i2 = i3;
            spanIndex = spanIndex2;
        }
        anchorInfo.mPosition = i2;
    }

    private void ensureViewSet() {
        if (this.mSet == null || this.mSet.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(Recycler recycler, State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanGroupIndex(i, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find span size for pre layout position. ");
        stringBuilder.append(i);
        Log.w(str, stringBuilder.toString());
        return 0;
    }

    private int getSpanIndex(Recycler recycler, State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        }
        int i2 = this.mPreLayoutSpanIndexCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        stringBuilder.append(i);
        Log.w(str, stringBuilder.toString());
        return 0;
    }

    private int getSpanSize(Recycler recycler, State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i);
        }
        int i2 = this.mPreLayoutSpanSizeCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        stringBuilder.append(i);
        Log.w(str, stringBuilder.toString());
        return 1;
    }

    private void guessMeasurement(float f, int i) {
        calculateItemBorders(Math.max(Math.round(f * ((float) this.mSpanCount)), i));
    }

    private void measureChild(View view, int i, boolean z) {
        int childMeasureSpec;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i2 = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
        int i3 = ((rect.left + rect.right) + layoutParams.leftMargin) + layoutParams.rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            i = LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i3, layoutParams.width, false);
            childMeasureSpec = LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i2, layoutParams.height, true);
        } else {
            i = LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i2, layoutParams.height, false);
            int childMeasureSpec2 = LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i3, layoutParams.width, true);
            childMeasureSpec = i;
            i = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i, childMeasureSpec, z);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z ? shouldReMeasureChild(view, i, i2, layoutParams) : shouldMeasureChild(view, i, i2, layoutParams)) {
            view.measure(i, i2);
        }
    }

    private void updateMeasurements() {
        calculateItemBorders(getOrientation() == 1 ? (getWidth() - getPaddingRight()) - getPaddingLeft() : (getHeight() - getPaddingBottom()) - getPaddingTop());
    }

    public boolean checkLayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* Access modifiers changed, original: 0000 */
    public void collectPrefetchPositionsForLayoutState(State state, LayoutState layoutState, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = this.mSpanCount;
        for (int i2 = 0; i2 < this.mSpanCount && layoutState.hasMore(state) && i > 0; i2++) {
            int i3 = layoutState.mCurrentPosition;
            layoutPrefetchRegistry.addPosition(i3, Math.max(0, layoutState.mScrollingOffset));
            i -= this.mSpanSizeLookup.getSpanSize(i3);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public View findReferenceChild(Recycler recycler, State state, int i, int i2, int i3) {
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3 && getSpanIndex(recycler, state, position) == 0) {
                if (((android.support.v7.widget.RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getColumnCountForAccessibility(Recycler recycler, State state) {
        return this.mOrientation == 1 ? this.mSpanCount : state.getItemCount() < 1 ? 0 : getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    public int getRowCountForAccessibility(Recycler recycler, State state) {
        return this.mOrientation == 0 ? this.mSpanCount : state.getItemCount() < 1 ? 0 : getSpanGroupIndex(recycler, state, state.getItemCount() - 1) + 1;
    }

    /* Access modifiers changed, original: 0000 */
    public int getSpaceForSpanRange(int i, int i2) {
        return (this.mOrientation == 1 && isLayoutRTL()) ? this.mCachedBorders[this.mSpanCount - i] - this.mCachedBorders[(this.mSpanCount - i) - i2] : this.mCachedBorders[i2 + i] - this.mCachedBorders[i];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    /* Access modifiers changed, original: 0000 */
    public void layoutChunk(Recycler recycler, State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i;
        int spanSize;
        Recycler recycler2 = recycler;
        State state2 = state;
        LayoutState layoutState2 = layoutState;
        LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        boolean z = modeInOther != 1073741824;
        int i2 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z) {
            updateMeasurements();
        }
        boolean z2 = layoutState2.mItemDirection == 1;
        int i3 = this.mSpanCount;
        if (!z2) {
            i3 = getSpanIndex(recycler2, state2, layoutState2.mCurrentPosition) + getSpanSize(recycler2, state2, layoutState2.mCurrentPosition);
        }
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.mSpanCount && layoutState2.hasMore(state2) && i3 > 0) {
            i = layoutState2.mCurrentPosition;
            spanSize = getSpanSize(recycler2, state2, i);
            if (spanSize > this.mSpanCount) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Item at position ");
                stringBuilder.append(i);
                stringBuilder.append(" requires ");
                stringBuilder.append(spanSize);
                stringBuilder.append(" spans but GridLayoutManager has only ");
                stringBuilder.append(this.mSpanCount);
                stringBuilder.append(" spans.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            i3 -= spanSize;
            if (i3 < 0) {
                break;
            }
            View next = layoutState2.next(recycler2);
            if (next == null) {
                break;
            }
            i4 += spanSize;
            this.mSet[i5] = next;
            i5++;
        }
        if (i5 == 0) {
            layoutChunkResult2.mFinished = true;
            return;
        }
        View view;
        int decoratedMeasurement;
        float f = 0.0f;
        int i6 = i5;
        assignSpans(recycler2, state2, i5, i4, z2);
        int i7 = 0;
        for (i3 = 0; i3 < i6; i3++) {
            boolean z3;
            view = this.mSet[i3];
            if (layoutState2.mScrapList != null) {
                z3 = false;
                if (z2) {
                    addDisappearingView(view);
                } else {
                    addDisappearingView(view, 0);
                }
            } else if (z2) {
                addView(view);
                z3 = false;
            } else {
                z3 = false;
                addView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, modeInOther, z3);
            i = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (i > i7) {
                i7 = i;
            }
            float decoratedMeasurementInOther = (1.0f * ((float) this.mOrientationHelper.getDecoratedMeasurementInOther(view))) / ((float) ((LayoutParams) view.getLayoutParams()).mSpanSize);
            if (decoratedMeasurementInOther > f) {
                f = decoratedMeasurementInOther;
            }
        }
        if (z) {
            guessMeasurement(f, i2);
            i7 = 0;
            for (i3 = 0; i3 < i6; i3++) {
                view = this.mSet[i3];
                measureChild(view, 1073741824, true);
                decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
                if (decoratedMeasurement > i7) {
                    i7 = decoratedMeasurement;
                }
            }
        }
        for (i3 = 0; i3 < i6; i3++) {
            view = this.mSet[i3];
            if (this.mOrientationHelper.getDecoratedMeasurement(view) != i7) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                i5 = ((rect.top + rect.bottom) + layoutParams.topMargin) + layoutParams.bottomMargin;
                modeInOther = ((rect.left + rect.right) + layoutParams.leftMargin) + layoutParams.rightMargin;
                i4 = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
                if (this.mOrientation == 1) {
                    i = LayoutManager.getChildMeasureSpec(i4, 1073741824, modeInOther, layoutParams.width, false);
                    i4 = MeasureSpec.makeMeasureSpec(i7 - i5, 1073741824);
                    modeInOther = i;
                } else {
                    modeInOther = MeasureSpec.makeMeasureSpec(i7 - modeInOther, 1073741824);
                    i4 = LayoutManager.getChildMeasureSpec(i4, 1073741824, i5, layoutParams.height, false);
                }
                measureChildWithDecorationsAndMargin(view, modeInOther, i4, true);
            }
        }
        spanSize = 0;
        layoutChunkResult2.mConsumed = i7;
        if (this.mOrientation == 1) {
            if (layoutState2.mLayoutDirection == -1) {
                i3 = layoutState2.mOffset;
                i = i3;
                decoratedMeasurement = i3 - i7;
            } else {
                i3 = layoutState2.mOffset;
                decoratedMeasurement = i3;
                i = i7 + i3;
            }
            i3 = 0;
            i7 = i3;
        } else if (layoutState2.mLayoutDirection == -1) {
            i3 = layoutState2.mOffset;
            decoratedMeasurement = 0;
            i = decoratedMeasurement;
            int i8 = i3 - i7;
            i7 = i3;
            i3 = i8;
        } else {
            i3 = layoutState2.mOffset;
            i7 += i3;
            decoratedMeasurement = 0;
            i = decoratedMeasurement;
        }
        while (spanSize < i6) {
            int i9;
            int decoratedMeasurementInOther2;
            int i10;
            View view2 = this.mSet[spanSize];
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (this.mOrientation != 1) {
                decoratedMeasurement = getPaddingTop() + this.mCachedBorders[layoutParams2.mSpanIndex];
                i = this.mOrientationHelper.getDecoratedMeasurementInOther(view2) + decoratedMeasurement;
            } else if (isLayoutRTL()) {
                i3 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - layoutParams2.mSpanIndex];
                i9 = i3;
                decoratedMeasurementInOther2 = i3 - this.mOrientationHelper.getDecoratedMeasurementInOther(view2);
                i2 = decoratedMeasurement;
                i10 = i;
                layoutDecoratedWithMargins(view2, decoratedMeasurementInOther2, i2, i9, i10);
                if (!layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                    layoutChunkResult2.mIgnoreConsumed = true;
                }
                layoutChunkResult2.mFocusable |= view2.hasFocusable();
                spanSize++;
                i3 = decoratedMeasurementInOther2;
                decoratedMeasurement = i2;
                i7 = i9;
                i = i10;
            } else {
                i3 = getPaddingLeft() + this.mCachedBorders[layoutParams2.mSpanIndex];
                i7 = this.mOrientationHelper.getDecoratedMeasurementInOther(view2) + i3;
            }
            decoratedMeasurementInOther2 = i3;
            i9 = i7;
            i2 = decoratedMeasurement;
            i10 = i;
            layoutDecoratedWithMargins(view2, decoratedMeasurementInOther2, i2, i9, i10);
            if (layoutParams2.isItemRemoved()) {
            }
            layoutChunkResult2.mIgnoreConsumed = true;
            layoutChunkResult2.mFocusable |= view2.hasFocusable();
            spanSize++;
            i3 = decoratedMeasurementInOther2;
            decoratedMeasurement = i2;
            i7 = i9;
            i = i10;
        }
        Arrays.fill(this.mSet, null);
    }

    /* Access modifiers changed, original: 0000 */
    public void onAnchorReady(Recycler recycler, State state, AnchorInfo anchorInfo, int i) {
        super.onAnchorReady(recycler, state, anchorInfo, i);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recycler, state, anchorInfo, i);
        }
        ensureViewSet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0104  */
    /* JADX WARNING: Missing block: B:54:0x00d8, code skipped:
            if (r13 == (r2 > r8)) goto L_0x00b3;
     */
    /* JADX WARNING: Missing block: B:64:0x00f5, code skipped:
            if (r13 == r10) goto L_0x00bb;
     */
    public android.view.View onFocusSearchFailed(android.view.View r27, int r28, android.support.v7.widget.RecyclerView.Recycler r29, android.support.v7.widget.RecyclerView.State r30) {
        /*
        r26 = this;
        r0 = r26;
        r1 = r29;
        r2 = r30;
        r3 = r26.findContainingItemView(r27);
        r4 = 0;
        if (r3 != 0) goto L_0x000e;
    L_0x000d:
        return r4;
    L_0x000e:
        r5 = r3.getLayoutParams();
        r5 = (android.support.v7.widget.GridLayoutManager.LayoutParams) r5;
        r6 = r5.mSpanIndex;
        r7 = r5.mSpanIndex;
        r5 = r5.mSpanSize;
        r7 = r7 + r5;
        r5 = super.onFocusSearchFailed(r27, r28, r29, r30);
        if (r5 != 0) goto L_0x0022;
    L_0x0021:
        return r4;
    L_0x0022:
        r5 = r28;
        r5 = r0.convertFocusDirectionToLayoutDirection(r5);
        r9 = 1;
        if (r5 != r9) goto L_0x002d;
    L_0x002b:
        r5 = r9;
        goto L_0x002e;
    L_0x002d:
        r5 = 0;
    L_0x002e:
        r10 = r0.mShouldReverseLayout;
        if (r5 == r10) goto L_0x0034;
    L_0x0032:
        r5 = r9;
        goto L_0x0035;
    L_0x0034:
        r5 = 0;
    L_0x0035:
        r10 = -1;
        if (r5 == 0) goto L_0x0040;
    L_0x0038:
        r5 = r26.getChildCount();
        r5 = r5 - r9;
        r11 = r10;
        r12 = r11;
        goto L_0x0047;
    L_0x0040:
        r5 = r26.getChildCount();
        r11 = r5;
        r12 = r9;
        r5 = 0;
    L_0x0047:
        r13 = r0.mOrientation;
        if (r13 != r9) goto L_0x0053;
    L_0x004b:
        r13 = r26.isLayoutRTL();
        if (r13 == 0) goto L_0x0053;
    L_0x0051:
        r13 = r9;
        goto L_0x0054;
    L_0x0053:
        r13 = 0;
    L_0x0054:
        r14 = r0.getSpanGroupIndex(r1, r2, r5);
        r8 = r10;
        r18 = r8;
        r15 = 0;
        r17 = 0;
        r10 = r4;
    L_0x005f:
        if (r5 == r11) goto L_0x0146;
    L_0x0061:
        r9 = r0.getSpanGroupIndex(r1, r2, r5);
        r1 = r0.getChildAt(r5);
        if (r1 != r3) goto L_0x006d;
    L_0x006b:
        goto L_0x0146;
    L_0x006d:
        r20 = r1.hasFocusable();
        if (r20 == 0) goto L_0x0087;
    L_0x0073:
        if (r9 == r14) goto L_0x0087;
    L_0x0075:
        if (r4 == 0) goto L_0x0079;
    L_0x0077:
        goto L_0x0146;
    L_0x0079:
        r21 = r3;
        r23 = r8;
        r24 = r10;
        r22 = r11;
        r8 = r17;
        r11 = r18;
        goto L_0x0132;
    L_0x0087:
        r9 = r1.getLayoutParams();
        r9 = (android.support.v7.widget.GridLayoutManager.LayoutParams) r9;
        r2 = r9.mSpanIndex;
        r21 = r3;
        r3 = r9.mSpanIndex;
        r22 = r11;
        r11 = r9.mSpanSize;
        r3 = r3 + r11;
        r11 = r1.hasFocusable();
        if (r11 == 0) goto L_0x00a3;
    L_0x009e:
        if (r2 != r6) goto L_0x00a3;
    L_0x00a0:
        if (r3 != r7) goto L_0x00a3;
    L_0x00a2:
        return r1;
    L_0x00a3:
        r11 = r1.hasFocusable();
        if (r11 == 0) goto L_0x00ab;
    L_0x00a9:
        if (r4 == 0) goto L_0x00b3;
    L_0x00ab:
        r11 = r1.hasFocusable();
        if (r11 != 0) goto L_0x00be;
    L_0x00b1:
        if (r10 != 0) goto L_0x00be;
    L_0x00b3:
        r23 = r8;
        r24 = r10;
        r8 = r17;
    L_0x00b9:
        r11 = r18;
    L_0x00bb:
        r19 = 1;
        goto L_0x0102;
    L_0x00be:
        r11 = java.lang.Math.max(r2, r6);
        r20 = java.lang.Math.min(r3, r7);
        r11 = r20 - r11;
        r20 = r1.hasFocusable();
        if (r20 == 0) goto L_0x00db;
    L_0x00ce:
        if (r11 <= r15) goto L_0x00d1;
    L_0x00d0:
        goto L_0x00b3;
    L_0x00d1:
        if (r11 != r15) goto L_0x00f8;
    L_0x00d3:
        if (r2 <= r8) goto L_0x00d7;
    L_0x00d5:
        r11 = 1;
        goto L_0x00d8;
    L_0x00d7:
        r11 = 0;
    L_0x00d8:
        if (r13 != r11) goto L_0x00f8;
    L_0x00da:
        goto L_0x00b3;
    L_0x00db:
        if (r4 != 0) goto L_0x00f8;
    L_0x00dd:
        r23 = r8;
        r24 = r10;
        r8 = 1;
        r10 = 0;
        r16 = r0.isViewPartiallyVisible(r1, r10, r8);
        if (r16 == 0) goto L_0x00fc;
    L_0x00e9:
        r8 = r17;
        if (r11 <= r8) goto L_0x00ee;
    L_0x00ed:
        goto L_0x00b9;
    L_0x00ee:
        if (r11 != r8) goto L_0x00fe;
    L_0x00f0:
        r11 = r18;
        if (r2 <= r11) goto L_0x00f5;
    L_0x00f4:
        r10 = 1;
    L_0x00f5:
        if (r13 != r10) goto L_0x0100;
    L_0x00f7:
        goto L_0x00bb;
    L_0x00f8:
        r23 = r8;
        r24 = r10;
    L_0x00fc:
        r8 = r17;
    L_0x00fe:
        r11 = r18;
    L_0x0100:
        r19 = 0;
    L_0x0102:
        if (r19 == 0) goto L_0x0132;
    L_0x0104:
        r10 = r1.hasFocusable();
        if (r10 == 0) goto L_0x011f;
    L_0x010a:
        r4 = r9.mSpanIndex;
        r3 = java.lang.Math.min(r3, r7);
        r2 = java.lang.Math.max(r2, r6);
        r3 = r3 - r2;
        r15 = r3;
        r17 = r8;
        r18 = r11;
        r10 = r24;
        r8 = r4;
        r4 = r1;
        goto L_0x013a;
    L_0x011f:
        r8 = r9.mSpanIndex;
        r3 = java.lang.Math.min(r3, r7);
        r2 = java.lang.Math.max(r2, r6);
        r3 = r3 - r2;
        r10 = r1;
        r17 = r3;
        r18 = r8;
        r8 = r23;
        goto L_0x013a;
    L_0x0132:
        r17 = r8;
        r18 = r11;
        r8 = r23;
        r10 = r24;
    L_0x013a:
        r5 = r5 + r12;
        r3 = r21;
        r11 = r22;
        r1 = r29;
        r2 = r30;
        r9 = 1;
        goto L_0x005f;
    L_0x0146:
        r24 = r10;
        if (r4 == 0) goto L_0x014c;
    L_0x014a:
        r24 = r4;
    L_0x014c:
        return r24;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
            boolean z;
            if (this.mOrientation == 0) {
                int spanIndex = layoutParams2.getSpanIndex();
                int spanSize = layoutParams2.getSpanSize();
                z = this.mSpanCount > 1 && layoutParams2.getSpanSize() == this.mSpanCount;
                accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(spanIndex, spanSize, spanGroupIndex, 1, z, false));
            } else {
                int spanIndex2 = layoutParams2.getSpanIndex();
                int spanSize2 = layoutParams2.getSpanSize();
                z = this.mSpanCount > 1 && layoutParams2.getSpanSize() == this.mSpanCount;
                accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(spanGroupIndex, 1, spanIndex2, spanSize2, z, false));
            }
            return;
        }
        super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
    }

    public void onLayoutCompleted(State state) {
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
    }

    public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize = LayoutManager.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            i = LayoutManager.chooseSize(i, this.mCachedBorders[this.mCachedBorders.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i = LayoutManager.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            chooseSize = LayoutManager.chooseSize(i2, this.mCachedBorders[this.mCachedBorders.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i, chooseSize);
    }

    public void setSpanCount(int i) {
        if (i != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i < 1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Span count should be at least 1. Provided ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.mSpanCount = i;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            requestLayout();
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }
}
