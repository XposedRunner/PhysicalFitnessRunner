package se.emilsjolander.stickylistheaders;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;

public class StickyListHeadersListView extends FrameLayout {
    private AdapterWrapper mAdapter;
    private boolean mAreHeadersSticky;
    private boolean mClippingToPadding;
    private AdapterWrapperDataSetObserver mDataSetObserver;
    private Drawable mDivider;
    private int mDividerHeight;
    private float mDownY;
    private View mHeader;
    private Long mHeaderId;
    private Integer mHeaderOffset;
    private boolean mHeaderOwnsTouch;
    private Integer mHeaderPosition;
    private boolean mIsDrawingListUnderStickyHeader;
    private WrapperViewList mList;
    private OnHeaderClickListener mOnHeaderClickListener;
    private OnScrollListener mOnScrollListenerDelegate;
    private OnStickyHeaderChangedListener mOnStickyHeaderChangedListener;
    private OnStickyHeaderOffsetChangedListener mOnStickyHeaderOffsetChangedListener;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private int mStickyHeaderTopOffset;
    private float mTouchSlop;

    /* renamed from: se.emilsjolander.stickylistheaders.StickyListHeadersListView$5 */
    class AnonymousClass5 implements OnTouchListener {
        final /* synthetic */ StickyListHeadersListView this$0;
        final /* synthetic */ OnTouchListener val$l;

        AnonymousClass5(StickyListHeadersListView stickyListHeadersListView, OnTouchListener onTouchListener) {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    private class AdapterWrapperDataSetObserver extends DataSetObserver {
        final /* synthetic */ StickyListHeadersListView this$0;

        private AdapterWrapperDataSetObserver(StickyListHeadersListView stickyListHeadersListView) {
        }

        /* synthetic */ AdapterWrapperDataSetObserver(StickyListHeadersListView stickyListHeadersListView, AnonymousClass1 anonymousClass1) {
        }

        public void onChanged() {
        }

        public void onInvalidated() {
        }
    }

    private class AdapterWrapperHeaderClickHandler implements OnHeaderClickListener {
        final /* synthetic */ StickyListHeadersListView this$0;

        private AdapterWrapperHeaderClickHandler(StickyListHeadersListView stickyListHeadersListView) {
        }

        /* synthetic */ AdapterWrapperHeaderClickHandler(StickyListHeadersListView stickyListHeadersListView, AnonymousClass1 anonymousClass1) {
        }

        public void onHeaderClick(View view, int i, long j) {
        }

        public boolean onHeaderLongClick(View view, int i, long j) {
            return false;
        }
    }

    public interface OnHeaderClickListener {
        void onHeaderClick(StickyListHeadersListView stickyListHeadersListView, View view, int i, long j, boolean z);

        boolean onHeaderLongClick(StickyListHeadersListView stickyListHeadersListView, View view, int i, long j, boolean z);
    }

    public interface OnStickyHeaderChangedListener {
        void onStickyHeaderChanged(StickyListHeadersListView stickyListHeadersListView, View view, int i, long j);
    }

    public interface OnStickyHeaderOffsetChangedListener {
        void onStickyHeaderOffsetChanged(StickyListHeadersListView stickyListHeadersListView, View view, int i);
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return null;
            }

            public SavedState[] newArray(int i) {
                return null;
            }
        };
        private Parcelable wrappedState;

        private SavedState(Parcel parcel) {
        }

        SavedState(Parcelable parcelable, Parcelable parcelable2) {
        }

        public void writeToParcel(Parcel parcel, int i) {
        }
    }

    private class WrapperListScrollListener implements OnScrollListener {
        final /* synthetic */ StickyListHeadersListView this$0;

        private WrapperListScrollListener(StickyListHeadersListView stickyListHeadersListView) {
        }

        /* synthetic */ WrapperListScrollListener(StickyListHeadersListView stickyListHeadersListView, AnonymousClass1 anonymousClass1) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    private class WrapperViewListLifeCycleListener implements LifeCycleListener {
        final /* synthetic */ StickyListHeadersListView this$0;

        private WrapperViewListLifeCycleListener(StickyListHeadersListView stickyListHeadersListView) {
        }

        /* synthetic */ WrapperViewListLifeCycleListener(StickyListHeadersListView stickyListHeadersListView, AnonymousClass1 anonymousClass1) {
        }

        public void onDispatchDrawOccurred(Canvas canvas) {
        }
    }

    public StickyListHeadersListView(Context context) {
    }

    public StickyListHeadersListView(Context context, AttributeSet attributeSet) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    @android.annotation.TargetApi(11)
    public StickyListHeadersListView(android.content.Context r6, android.util.AttributeSet r7, int r8) {
        /*
        r5 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: se.emilsjolander.stickylistheaders.StickyListHeadersListView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    static /* synthetic */ void access$600(StickyListHeadersListView stickyListHeadersListView) {
    }

    static /* synthetic */ void access$900(StickyListHeadersListView stickyListHeadersListView, int i) {
    }

    private void clearHeader() {
    }

    private void ensureHeaderHasCorrectLayoutParams(View view) {
    }

    private boolean isStartOfSection(int i) {
        return false;
    }

    private void measureHeader(View view) {
    }

    private boolean requireSdkVersion(int i) {
        return false;
    }

    @SuppressLint({"NewApi"})
    private void setHeaderOffet(int i) {
    }

    private int stickyHeaderTop() {
        return 0;
    }

    private void swapHeader(View view) {
    }

    private void updateHeader(int i) {
    }

    private void updateHeaderVisibilities() {
    }

    private void updateOrClearHeader(int i) {
    }

    public void addFooterView(View view) {
    }

    public void addFooterView(View view, Object obj, boolean z) {
    }

    public void addHeaderView(View view) {
    }

    public void addHeaderView(View view, Object obj, boolean z) {
    }

    public boolean areHeadersSticky() {
        return false;
    }

    @TargetApi(14)
    public boolean canScrollVertically(int i) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public StickyListHeadersAdapter getAdapter() {
        return null;
    }

    @Deprecated
    public boolean getAreHeadersSticky() {
        return false;
    }

    @TargetApi(11)
    public int getCheckedItemCount() {
        return 0;
    }

    @TargetApi(8)
    public long[] getCheckedItemIds() {
        return null;
    }

    @TargetApi(11)
    public int getCheckedItemPosition() {
        return 0;
    }

    @TargetApi(11)
    public SparseBooleanArray getCheckedItemPositions() {
        return null;
    }

    public int getCount() {
        return 0;
    }

    public Drawable getDivider() {
        return null;
    }

    public int getDividerHeight() {
        return 0;
    }

    public View getEmptyView() {
        return null;
    }

    public int getFirstVisiblePosition() {
        return 0;
    }

    public int getFooterViewsCount() {
        return 0;
    }

    public int getHeaderOverlap(int i) {
        return 0;
    }

    public int getHeaderViewsCount() {
        return 0;
    }

    public Object getItemAtPosition(int i) {
        return null;
    }

    public long getItemIdAtPosition(int i) {
        return 0;
    }

    public int getLastVisiblePosition() {
        return 0;
    }

    public View getListChildAt(int i) {
        return null;
    }

    public int getListChildCount() {
        return 0;
    }

    @TargetApi(9)
    public int getOverScrollMode() {
        return 0;
    }

    public int getPaddingBottom() {
        return 0;
    }

    public int getPaddingLeft() {
        return 0;
    }

    public int getPaddingRight() {
        return 0;
    }

    public int getPaddingTop() {
        return 0;
    }

    public int getPositionForView(View view) {
        return 0;
    }

    public int getScrollBarStyle() {
        return 0;
    }

    public int getStickyHeaderTopOffset() {
        return 0;
    }

    public ListView getWrappedList() {
        return null;
    }

    public void invalidateViews() {
    }

    public boolean isDrawingListUnderStickyHeader() {
        return false;
    }

    @TargetApi(11)
    public boolean isFastScrollAlwaysVisible() {
        return false;
    }

    public boolean isHorizontalScrollBarEnabled() {
        return false;
    }

    public boolean isStackFromBottom() {
        return false;
    }

    public boolean isVerticalScrollBarEnabled() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void recomputePadding() {
    }

    public void removeFooterView(View view) {
    }

    public void removeHeaderView(View view) {
    }

    public void setAdapter(StickyListHeadersAdapter stickyListHeadersAdapter) {
    }

    public void setAreHeadersSticky(boolean z) {
    }

    public void setBlockLayoutChildren(boolean z) {
    }

    @TargetApi(11)
    public void setChoiceMode(int i) {
    }

    public void setClipToPadding(boolean z) {
    }

    public void setDivider(Drawable drawable) {
    }

    public void setDividerHeight(int i) {
    }

    public void setDrawingListUnderStickyHeader(boolean z) {
    }

    public void setEmptyView(View view) {
    }

    @TargetApi(11)
    public void setFastScrollAlwaysVisible(boolean z) {
    }

    public void setFastScrollEnabled(boolean z) {
    }

    public void setHorizontalScrollBarEnabled(boolean z) {
    }

    @TargetApi(11)
    public void setItemChecked(int i, boolean z) {
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(MultiChoiceModeListener multiChoiceModeListener) {
    }

    public void setOnCreateContextMenuListener(OnCreateContextMenuListener onCreateContextMenuListener) {
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
    }

    public void setOnStickyHeaderChangedListener(OnStickyHeaderChangedListener onStickyHeaderChangedListener) {
    }

    public void setOnStickyHeaderOffsetChangedListener(OnStickyHeaderOffsetChangedListener onStickyHeaderOffsetChangedListener) {
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
    }

    @TargetApi(9)
    public void setOverScrollMode(int i) {
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setScrollBarStyle(int i) {
    }

    public void setSelection(int i) {
    }

    public void setSelectionAfterHeaderView() {
    }

    public void setSelectionFromTop(int i, int i2) {
    }

    public void setSelector(int i) {
    }

    public void setSelector(Drawable drawable) {
    }

    public void setStackFromBottom(boolean z) {
    }

    public void setStickyHeaderTopOffset(int i) {
    }

    public void setTranscriptMode(int i) {
    }

    public void setVerticalScrollBarEnabled(boolean z) {
    }

    public boolean showContextMenu() {
        return false;
    }

    @TargetApi(8)
    public void smoothScrollBy(int i, int i2) {
    }

    @TargetApi(11)
    public void smoothScrollByOffset(int i) {
    }

    @SuppressLint({"NewApi"})
    @TargetApi(8)
    public void smoothScrollToPosition(int i) {
    }

    @TargetApi(8)
    public void smoothScrollToPosition(int i, int i2) {
    }

    @TargetApi(11)
    public void smoothScrollToPositionFromTop(int i, int i2) {
    }

    @TargetApi(11)
    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
    }
}
