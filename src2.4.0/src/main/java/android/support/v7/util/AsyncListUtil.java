package android.support.v7.util;

import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.support.v7.util.ThreadUtil.BackgroundCallback;
import android.support.v7.util.ThreadUtil.MainThreadCallback;
import android.support.v7.util.TileList.Tile;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final BackgroundCallback<T> mBackgroundCallback = new BackgroundCallback<T>() {
        private int mFirstRequiredTileStart;
        private int mGeneration;
        private int mItemCount;
        private int mLastRequiredTileStart;
        final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
        private Tile<T> mRecycledRoot;

        private Tile<T> acquireTile() {
            if (this.mRecycledRoot == null) {
                return new Tile(AsyncListUtil.this.mTClass, AsyncListUtil.this.mTileSize);
            }
            Tile tile = this.mRecycledRoot;
            this.mRecycledRoot = this.mRecycledRoot.mNext;
            return tile;
        }

        private void addTile(Tile<T> tile) {
            this.mLoadedTiles.put(tile.mStartPosition, true);
            AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
        }

        private void flushTileCache(int i) {
            int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
            while (this.mLoadedTiles.size() >= maxCachedTiles) {
                int keyAt = this.mLoadedTiles.keyAt(0);
                int keyAt2 = this.mLoadedTiles.keyAt(this.mLoadedTiles.size() - 1);
                int i2 = this.mFirstRequiredTileStart - keyAt;
                int i3 = keyAt2 - this.mLastRequiredTileStart;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    removeTile(keyAt);
                } else if (i3 > 0 && (i2 < i3 || i == 1)) {
                    removeTile(keyAt2);
                } else {
                    return;
                }
            }
        }

        private int getTileStart(int i) {
            return i - (i % AsyncListUtil.this.mTileSize);
        }

        private boolean isTileLoaded(int i) {
            return this.mLoadedTiles.get(i);
        }

        private void log(String str, Object... objArr) {
            String str2 = AsyncListUtil.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[BKGR] ");
            stringBuilder.append(String.format(str, objArr));
            Log.d(str2, stringBuilder.toString());
        }

        private void removeTile(int i) {
            this.mLoadedTiles.delete(i);
            AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i);
        }

        private void requestTiles(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.mBackgroundProxy.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.mTileSize;
            }
        }

        public void loadTile(int i, int i2) {
            if (!isTileLoaded(i)) {
                Tile acquireTile = acquireTile();
                acquireTile.mStartPosition = i;
                acquireTile.mItemCount = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - acquireTile.mStartPosition);
                AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, acquireTile.mItemCount);
                flushTileCache(i2);
                addTile(acquireTile);
            }
        }

        public void recycleTile(Tile<T> tile) {
            AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
            tile.mNext = this.mRecycledRoot;
            this.mRecycledRoot = tile;
        }

        public void refresh(int i) {
            this.mGeneration = i;
            this.mLoadedTiles.clear();
            this.mItemCount = AsyncListUtil.this.mDataCallback.refreshData();
            AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, this.mItemCount);
        }

        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i <= i2) {
                i = getTileStart(i);
                i2 = getTileStart(i2);
                this.mFirstRequiredTileStart = getTileStart(i3);
                this.mLastRequiredTileStart = getTileStart(i4);
                if (i5 == 1) {
                    requestTiles(this.mFirstRequiredTileStart, i2, i5, true);
                    requestTiles(i2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i5, false);
                } else {
                    requestTiles(i, this.mLastRequiredTileStart, i5, false);
                    requestTiles(this.mFirstRequiredTileStart, i - AsyncListUtil.this.mTileSize, i5, true);
                }
            }
        }
    };
    final BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration = 0;
    int mItemCount = 0;
    private final MainThreadCallback<T> mMainThreadCallback = new MainThreadCallback<T>() {
        private boolean isRequestedGeneration(int i) {
            return i == AsyncListUtil.this.mRequestedGeneration;
        }

        private void recycleAllTiles() {
            for (int i = 0; i < AsyncListUtil.this.mTileList.size(); i++) {
                AsyncListUtil.this.mBackgroundProxy.recycleTile(AsyncListUtil.this.mTileList.getAtIndex(i));
            }
            AsyncListUtil.this.mTileList.clear();
        }

        public void addTile(int i, Tile<T> tile) {
            if (isRequestedGeneration(i)) {
                Tile addOrReplace = AsyncListUtil.this.mTileList.addOrReplace(tile);
                if (addOrReplace != null) {
                    String str = AsyncListUtil.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("duplicate tile @");
                    stringBuilder.append(addOrReplace.mStartPosition);
                    Log.e(str, stringBuilder.toString());
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(addOrReplace);
                }
                i = tile.mStartPosition + tile.mItemCount;
                int i2 = 0;
                while (i2 < AsyncListUtil.this.mMissingPositions.size()) {
                    int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i2);
                    if (tile.mStartPosition > keyAt || keyAt >= i) {
                        i2++;
                    } else {
                        AsyncListUtil.this.mMissingPositions.removeAt(i2);
                        AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                    }
                }
                return;
            }
            AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
        }

        public void removeTile(int i, int i2) {
            if (isRequestedGeneration(i)) {
                Tile removeAtPos = AsyncListUtil.this.mTileList.removeAtPos(i2);
                if (removeAtPos == null) {
                    String str = AsyncListUtil.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("tile not found @");
                    stringBuilder.append(i2);
                    Log.e(str, stringBuilder.toString());
                    return;
                }
                AsyncListUtil.this.mBackgroundProxy.recycleTile(removeAtPos);
            }
        }

        public void updateItemCount(int i, int i2) {
            if (isRequestedGeneration(i)) {
                AsyncListUtil.this.mItemCount = i2;
                AsyncListUtil.this.mViewCallback.onDataRefresh();
                AsyncListUtil.this.mDisplayedGeneration = AsyncListUtil.this.mRequestedGeneration;
                recycleAllTiles();
                AsyncListUtil.this.mAllowScrollHints = false;
                AsyncListUtil.this.updateRange();
            }
        }
    };
    final MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions = new SparseIntArray();
    final int[] mPrevRange = new int[2];
    int mRequestedGeneration = this.mDisplayedGeneration;
    private int mScrollHint = 0;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    final ViewCallback mViewCallback;

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(T[] tArr, int i, int i2);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(T[] tArr, int i) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public void extendRangeInto(int[] iArr, int[] iArr2, int i) {
            int i2 = (iArr[1] - iArr[0]) + 1;
            int i3 = i2 / 2;
            iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
            int i4 = iArr[1];
            if (i != 2) {
                i2 = i3;
            }
            iArr2[1] = i4 + i2;
        }

        @UiThread
        public abstract void getItemRangeInto(int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i);
    }

    public AsyncListUtil(Class<T> cls, int i, DataCallback<T> dataCallback, ViewCallback viewCallback) {
        this.mTClass = cls;
        this.mTileSize = i;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList(this.mTileSize);
        MessageThreadUtil messageThreadUtil = new MessageThreadUtil();
        this.mMainThreadProxy = messageThreadUtil.getMainThreadProxy(this.mMainThreadCallback);
        this.mBackgroundProxy = messageThreadUtil.getBackgroundProxy(this.mBackgroundCallback);
        refresh();
    }

    private boolean isRefreshPending() {
        return this.mRequestedGeneration != this.mDisplayedGeneration;
    }

    public T getItem(int i) {
        if (i < 0 || i >= this.mItemCount) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append(" is not within 0 and ");
            stringBuilder.append(this.mItemCount);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        Object itemAt = this.mTileList.getItemAt(i);
        if (itemAt == null && !isRefreshPending()) {
            this.mMissingPositions.put(i, 0);
        }
        return itemAt;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    /* Access modifiers changed, original: varargs */
    public void log(String str, Object... objArr) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[MAIN] ");
        stringBuilder.append(String.format(str, objArr));
        Log.d(str2, stringBuilder.toString());
    }

    public void onRangeChanged() {
        if (!isRefreshPending()) {
            updateRange();
            this.mAllowScrollHints = true;
        }
    }

    public void refresh() {
        this.mMissingPositions.clear();
        BackgroundCallback backgroundCallback = this.mBackgroundProxy;
        int i = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i;
        backgroundCallback.refresh(i);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Missing block: B:23:0x00bb, code skipped:
            return;
     */
    public void updateRange() {
        /*
        r10 = this;
        r0 = r10.mViewCallback;
        r1 = r10.mTmpRange;
        r0.getItemRangeInto(r1);
        r0 = r10.mTmpRange;
        r1 = 0;
        r0 = r0[r1];
        r2 = r10.mTmpRange;
        r3 = 1;
        r2 = r2[r3];
        if (r0 > r2) goto L_0x00bb;
    L_0x0013:
        r0 = r10.mTmpRange;
        r0 = r0[r1];
        if (r0 >= 0) goto L_0x001b;
    L_0x0019:
        goto L_0x00bb;
    L_0x001b:
        r0 = r10.mTmpRange;
        r0 = r0[r3];
        r2 = r10.mItemCount;
        if (r0 < r2) goto L_0x0024;
    L_0x0023:
        return;
    L_0x0024:
        r0 = r10.mAllowScrollHints;
        if (r0 != 0) goto L_0x002b;
    L_0x0028:
        r10.mScrollHint = r1;
        goto L_0x005d;
    L_0x002b:
        r0 = r10.mTmpRange;
        r0 = r0[r1];
        r2 = r10.mPrevRange;
        r2 = r2[r3];
        if (r0 > r2) goto L_0x005b;
    L_0x0035:
        r0 = r10.mPrevRange;
        r0 = r0[r1];
        r2 = r10.mTmpRange;
        r2 = r2[r3];
        if (r0 <= r2) goto L_0x0040;
    L_0x003f:
        goto L_0x005b;
    L_0x0040:
        r0 = r10.mTmpRange;
        r0 = r0[r1];
        r2 = r10.mPrevRange;
        r2 = r2[r1];
        if (r0 >= r2) goto L_0x004d;
    L_0x004a:
        r10.mScrollHint = r3;
        goto L_0x005d;
    L_0x004d:
        r0 = r10.mTmpRange;
        r0 = r0[r1];
        r2 = r10.mPrevRange;
        r2 = r2[r1];
        if (r0 <= r2) goto L_0x005d;
    L_0x0057:
        r0 = 2;
        r10.mScrollHint = r0;
        goto L_0x005d;
    L_0x005b:
        r10.mScrollHint = r1;
    L_0x005d:
        r0 = r10.mPrevRange;
        r2 = r10.mTmpRange;
        r2 = r2[r1];
        r0[r1] = r2;
        r0 = r10.mPrevRange;
        r2 = r10.mTmpRange;
        r2 = r2[r3];
        r0[r3] = r2;
        r0 = r10.mViewCallback;
        r2 = r10.mTmpRange;
        r4 = r10.mTmpRangeExtended;
        r5 = r10.mScrollHint;
        r0.extendRangeInto(r2, r4, r5);
        r0 = r10.mTmpRangeExtended;
        r2 = r10.mTmpRange;
        r2 = r2[r1];
        r4 = r10.mTmpRangeExtended;
        r4 = r4[r1];
        r4 = java.lang.Math.max(r4, r1);
        r2 = java.lang.Math.min(r2, r4);
        r0[r1] = r2;
        r0 = r10.mTmpRangeExtended;
        r2 = r10.mTmpRange;
        r2 = r2[r3];
        r4 = r10.mTmpRangeExtended;
        r4 = r4[r3];
        r5 = r10.mItemCount;
        r5 = r5 - r3;
        r4 = java.lang.Math.min(r4, r5);
        r2 = java.lang.Math.max(r2, r4);
        r0[r3] = r2;
        r4 = r10.mBackgroundProxy;
        r0 = r10.mTmpRange;
        r5 = r0[r1];
        r0 = r10.mTmpRange;
        r6 = r0[r3];
        r0 = r10.mTmpRangeExtended;
        r7 = r0[r1];
        r0 = r10.mTmpRangeExtended;
        r8 = r0[r3];
        r9 = r10.mScrollHint;
        r4.updateRange(r5, r6, r7, r8, r9);
        return;
    L_0x00bb:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.util.AsyncListUtil.updateRange():void");
    }
}
