package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

class AdapterWrapper extends BaseAdapter implements StickyListHeadersAdapter {
    private final Context mContext;
    private DataSetObserver mDataSetObserver;
    StickyListHeadersAdapter mDelegate;
    private Drawable mDivider;
    private int mDividerHeight;
    private final List<View> mHeaderCache;
    private OnHeaderClickListener mOnHeaderClickListener;

    /* renamed from: se.emilsjolander.stickylistheaders.AdapterWrapper$2 */
    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ AdapterWrapper this$0;
        final /* synthetic */ int val$position;

        AnonymousClass2(AdapterWrapper adapterWrapper, int i) {
        }

        public void onClick(View view) {
        }
    }

    /* renamed from: se.emilsjolander.stickylistheaders.AdapterWrapper$3 */
    class AnonymousClass3 implements OnLongClickListener {
        final /* synthetic */ AdapterWrapper this$0;
        final /* synthetic */ int val$position;

        AnonymousClass3(AdapterWrapper adapterWrapper, int i) {
        }

        public boolean onLongClick(View view) {
            return false;
        }
    }

    interface OnHeaderClickListener {
        void onHeaderClick(View view, int i, long j);

        boolean onHeaderLongClick(View view, int i, long j);
    }

    AdapterWrapper(Context context, StickyListHeadersAdapter stickyListHeadersAdapter) {
    }

    static /* synthetic */ void access$101(AdapterWrapper adapterWrapper) {
    }

    static /* synthetic */ void access$201(AdapterWrapper adapterWrapper) {
    }

    private View configureHeader(WrapperView wrapperView, int i) {
        return null;
    }

    private View popHeader() {
        return null;
    }

    private boolean previousPositionHasSameHeader(int i) {
        return false;
    }

    private void recycleHeaderIfExists(WrapperView wrapperView) {
    }

    public boolean areAllItemsEnabled() {
        return false;
    }

    public boolean equals(Object obj) {
        return false;
    }

    public int getCount() {
        return 0;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return null;
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

    public WrapperView getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public int getViewTypeCount() {
        return 0;
    }

    public boolean hasStableIds() {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isEnabled(int i) {
        return false;
    }

    public void notifyDataSetChanged() {
    }

    public void notifyDataSetInvalidated() {
    }

    /* Access modifiers changed, original: 0000 */
    public void setDivider(Drawable drawable, int i) {
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
    }

    public String toString() {
        return null;
    }
}
