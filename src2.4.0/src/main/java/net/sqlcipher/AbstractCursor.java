package net.sqlcipher;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.CursorWindow;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor implements CrossProcessCursor, Cursor {
    private static final String TAG = "Cursor";
    protected boolean mClosed = false;
    ContentObservable mContentObservable = new ContentObservable();
    protected ContentResolver mContentResolver;
    protected Long mCurrentRowID = null;
    DataSetObservable mDataSetObservable = new DataSetObservable();
    private Bundle mExtras = Bundle.EMPTY;
    private Uri mNotifyUri;
    protected int mPos = -1;
    protected int mRowIdColumnIndex = -1;
    private ContentObserver mSelfObserver;
    private final Object mSelfObserverLock = new Object();
    private boolean mSelfObserverRegistered;
    protected HashMap<Long, Map<String, Object>> mUpdatedRows = new HashMap();

    protected static class SelfContentObserver extends ContentObserver {
        WeakReference<AbstractCursor> mCursor;

        public SelfContentObserver(AbstractCursor abstractCursor) {
            super(null);
            this.mCursor = new WeakReference(abstractCursor);
        }

        public boolean deliverSelfNotifications() {
            return false;
        }

        public void onChange(boolean z) {
            AbstractCursor abstractCursor = (AbstractCursor) this.mCursor.get();
            if (abstractCursor != null) {
                abstractCursor.onChange(false);
            }
        }
    }

    public void abortUpdates() {
        synchronized (this.mUpdatedRows) {
            this.mUpdatedRows.clear();
        }
    }

    /* Access modifiers changed, original: protected */
    public void checkPosition() {
        if (-1 == this.mPos || getCount() == this.mPos) {
            throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
        }
    }

    public void close() {
        this.mClosed = true;
        this.mContentObservable.unregisterAll();
        deactivateInternal();
    }

    public boolean commitUpdates() {
        return commitUpdates(null);
    }

    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        return false;
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        String string = getString(i);
        if (string != null) {
            char[] cArr = charArrayBuffer.data;
            if (cArr == null || cArr.length < string.length()) {
                charArrayBuffer.data = string.toCharArray();
            } else {
                string.getChars(0, string.length(), cArr, 0);
            }
            charArrayBuffer.sizeCopied = string.length();
            return;
        }
        charArrayBuffer.sizeCopied = 0;
    }

    public void deactivate() {
        deactivateInternal();
    }

    public void deactivateInternal() {
        if (this.mSelfObserver != null) {
            this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
            this.mSelfObserverRegistered = false;
        }
        this.mDataSetObservable.notifyInvalidated();
    }

    public boolean deleteRow() {
        return false;
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        DatabaseUtils.cursorFillWindow(this, i, cursorWindow);
    }

    /* Access modifiers changed, original: protected */
    public void finalize() {
        if (this.mSelfObserver != null && this.mSelfObserverRegistered) {
            this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
        }
    }

    public byte[] getBlob(int i) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    public int getColumnCount() {
        return getColumnNames().length;
    }

    public int getColumnIndex(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Exception exception = new Exception();
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("requesting column name with table name -- ");
            stringBuilder.append(str);
            Log.e(str2, stringBuilder.toString(), exception);
            str = str.substring(lastIndexOf + 1);
        }
        String[] columnNames = getColumnNames();
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            if (columnNames[i].equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    public int getColumnIndexOrThrow(String str) {
        int columnIndex = getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("column '");
        stringBuilder.append(str);
        stringBuilder.append("' does not exist");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public String getColumnName(int i) {
        return getColumnNames()[i];
    }

    public abstract String[] getColumnNames();

    public abstract int getCount();

    /* Access modifiers changed, original: protected */
    public DataSetObservable getDataSetObservable() {
        return this.mDataSetObservable;
    }

    public abstract double getDouble(int i);

    public Bundle getExtras() {
        return this.mExtras;
    }

    public abstract float getFloat(int i);

    public abstract int getInt(int i);

    public abstract long getLong(int i);

    public Uri getNotificationUri() {
        return this.mNotifyUri;
    }

    public final int getPosition() {
        return this.mPos;
    }

    public abstract short getShort(int i);

    public abstract String getString(int i);

    public abstract int getType(int i);

    /* Access modifiers changed, original: protected */
    public Object getUpdatedField(int i) {
        return ((Map) this.mUpdatedRows.get(this.mCurrentRowID)).get(getColumnNames()[i]);
    }

    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    public CursorWindow getWindow() {
        return null;
    }

    public boolean hasUpdates() {
        boolean z;
        synchronized (this.mUpdatedRows) {
            z = this.mUpdatedRows.size() > 0;
        }
        return z;
    }

    public final boolean isAfterLast() {
        boolean z = true;
        if (getCount() == 0) {
            return true;
        }
        if (this.mPos != getCount()) {
            z = false;
        }
        return z;
    }

    public final boolean isBeforeFirst() {
        boolean z = true;
        if (getCount() == 0) {
            return true;
        }
        if (this.mPos != -1) {
            z = false;
        }
        return z;
    }

    public boolean isClosed() {
        return this.mClosed;
    }

    /* Access modifiers changed, original: protected */
    public boolean isFieldUpdated(int i) {
        if (this.mRowIdColumnIndex != -1 && this.mUpdatedRows.size() > 0) {
            Map map = (Map) this.mUpdatedRows.get(this.mCurrentRowID);
            if (map != null && map.containsKey(getColumnNames()[i])) {
                return true;
            }
        }
        return false;
    }

    public final boolean isFirst() {
        return this.mPos == 0 && getCount() != 0;
    }

    public final boolean isLast() {
        int count = getCount();
        return this.mPos == count + -1 && count != 0;
    }

    public abstract boolean isNull(int i);

    public final boolean move(int i) {
        return moveToPosition(this.mPos + i);
    }

    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    public final boolean moveToNext() {
        return moveToPosition(this.mPos + 1);
    }

    public final boolean moveToPosition(int i) {
        int count = getCount();
        if (i >= count) {
            this.mPos = count;
            return false;
        } else if (i < 0) {
            this.mPos = -1;
            return false;
        } else if (i == this.mPos) {
            return true;
        } else {
            boolean onMove = onMove(this.mPos, i);
            if (onMove) {
                this.mPos = i;
                if (this.mRowIdColumnIndex != -1) {
                    this.mCurrentRowID = Long.valueOf(getLong(this.mRowIdColumnIndex));
                }
            } else {
                this.mPos = -1;
            }
            return onMove;
        }
    }

    public final boolean moveToPrevious() {
        return moveToPosition(this.mPos - 1);
    }

    /* Access modifiers changed, original: protected */
    public void notifyDataSetChange() {
        this.mDataSetObservable.notifyChanged();
    }

    /* Access modifiers changed, original: protected */
    public void onChange(boolean z) {
        synchronized (this.mSelfObserverLock) {
            this.mContentObservable.dispatchChange(z);
            if (this.mNotifyUri != null && z) {
                this.mContentResolver.notifyChange(this.mNotifyUri, this.mSelfObserver);
            }
        }
    }

    public boolean onMove(int i, int i2) {
        return true;
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        this.mContentObservable.registerObserver(contentObserver);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.registerObserver(dataSetObserver);
    }

    public boolean requery() {
        if (!(this.mSelfObserver == null || this.mSelfObserverRegistered)) {
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, this.mSelfObserver);
            this.mSelfObserverRegistered = true;
        }
        this.mDataSetObservable.notifyChanged();
        return true;
    }

    public Bundle respond(Bundle bundle) {
        return Bundle.EMPTY;
    }

    public void setExtras(Bundle bundle) {
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        this.mExtras = bundle;
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        synchronized (this.mSelfObserverLock) {
            this.mNotifyUri = uri;
            this.mContentResolver = contentResolver;
            if (this.mSelfObserver != null) {
                this.mContentResolver.unregisterContentObserver(this.mSelfObserver);
            }
            this.mSelfObserver = new SelfContentObserver(this);
            this.mContentResolver.registerContentObserver(this.mNotifyUri, true, this.mSelfObserver);
            this.mSelfObserverRegistered = true;
        }
    }

    public boolean supportsUpdates() {
        return this.mRowIdColumnIndex != -1;
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        if (!this.mClosed) {
            this.mContentObservable.unregisterObserver(contentObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDataSetObservable.unregisterObserver(dataSetObserver);
    }

    public boolean update(int i, Object obj) {
        if (!supportsUpdates()) {
            return false;
        }
        Long l = new Long(getLong(this.mRowIdColumnIndex));
        if (l == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("null rowid. mRowIdColumnIndex = ");
            stringBuilder.append(this.mRowIdColumnIndex);
            throw new IllegalStateException(stringBuilder.toString());
        }
        synchronized (this.mUpdatedRows) {
            Map map = (Map) this.mUpdatedRows.get(l);
            if (map == null) {
                map = new HashMap();
                this.mUpdatedRows.put(l, map);
            }
            map.put(getColumnNames()[i], obj);
        }
        return true;
    }

    public boolean updateBlob(int i, byte[] bArr) {
        return update(i, bArr);
    }

    public boolean updateDouble(int i, double d) {
        return update(i, Double.valueOf(d));
    }

    public boolean updateFloat(int i, float f) {
        return update(i, Float.valueOf(f));
    }

    public boolean updateInt(int i, int i2) {
        return update(i, Integer.valueOf(i2));
    }

    public boolean updateLong(int i, long j) {
        return update(i, Long.valueOf(j));
    }

    public boolean updateShort(int i, short s) {
        return update(i, Short.valueOf(s));
    }

    public boolean updateString(int i, String str) {
        return update(i, str);
    }

    public boolean updateToNull(int i) {
        return update(i, null);
    }
}
