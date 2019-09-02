package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class ExpandableStickyListHeadersListView extends StickyListHeadersListView {
    public static final int ANIMATION_COLLAPSE = 1;
    public static final int ANIMATION_EXPAND = 0;
    IAnimationExecutor mDefaultAnimExecutor;
    ExpandableStickyListHeadersAdapter mExpandableStickyListHeadersAdapter;

    public interface IAnimationExecutor {
        void executeAnim(View view, int i);
    }

    public ExpandableStickyListHeadersListView(Context context) {
    }

    public ExpandableStickyListHeadersListView(Context context, AttributeSet attributeSet) {
    }

    public ExpandableStickyListHeadersListView(Context context, AttributeSet attributeSet, int i) {
    }

    private void animateView(View view, int i) {
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

    public ExpandableStickyListHeadersAdapter getAdapter() {
        return null;
    }

    public boolean isHeaderCollapsed(long j) {
        return false;
    }

    public void setAdapter(StickyListHeadersAdapter stickyListHeadersAdapter) {
    }

    public void setAnimExecutor(IAnimationExecutor iAnimationExecutor) {
    }
}
