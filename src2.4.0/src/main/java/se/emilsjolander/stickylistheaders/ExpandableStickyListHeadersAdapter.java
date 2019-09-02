package se.emilsjolander.stickylistheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

class ExpandableStickyListHeadersAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    List<Long> mCollapseHeaderIds;
    DistinctMultiHashMap<Integer, View> mHeaderIdToViewMap;
    private final StickyListHeadersAdapter mInnerAdapter;
    DualHashMap<View, Long> mViewToItemIdMap;

    ExpandableStickyListHeadersAdapter(StickyListHeadersAdapter stickyListHeadersAdapter) {
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public void collapse(long j) {
    }

    public void expand(long j) {
    }

    public long findItemIdByView(View view) {
        return 0;
    }

    public View findViewByItemId(long j) {
        return null;
    }

    public int getCount() {
        return 0;
    }

    public long getHeaderId(int i) {
        return 0;
    }

    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getItemViewType(int i) {
        return 0;
    }

    public List<View> getItemViewsByHeaderId(long j) {
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public int getViewTypeCount() {
        return 0;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isEnabled(int i) {
        return false;
    }

    public boolean isHeaderCollapsed(long j) {
        return false;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
