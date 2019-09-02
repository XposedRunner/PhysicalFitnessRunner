package se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.widget.SectionIndexer;

class SectionIndexerAdapterWrapper extends AdapterWrapper implements SectionIndexer {
    SectionIndexer mSectionIndexerDelegate;

    SectionIndexerAdapterWrapper(Context context, StickyListHeadersAdapter stickyListHeadersAdapter) {
    }

    public int getPositionForSection(int i) {
        return 0;
    }

    public int getSectionForPosition(int i) {
        return 0;
    }

    public Object[] getSections() {
        return null;
    }
}
