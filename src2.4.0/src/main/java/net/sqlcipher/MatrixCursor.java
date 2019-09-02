package net.sqlcipher;

import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;

public class MatrixCursor extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    public class RowBuilder {
        private final int endIndex;
        private int index;
        final /* synthetic */ MatrixCursor this$0;

        RowBuilder(MatrixCursor matrixCursor, int i, int i2) {
        }

        public RowBuilder add(Object obj) {
            return null;
        }
    }

    public MatrixCursor(String[] strArr) {
    }

    public MatrixCursor(String[] strArr, int i) {
    }

    private void addRow(ArrayList<?> arrayList, int i) {
    }

    private void ensureCapacity(int i) {
    }

    private Object get(int i) {
        return null;
    }

    public void addRow(Iterable<?> iterable) {
    }

    public void addRow(Object[] objArr) {
    }

    public String[] getColumnNames() {
        return null;
    }

    public int getCount() {
        return 0;
    }

    public double getDouble(int i) {
        return 0.0d;
    }

    public float getFloat(int i) {
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    public int getInt(int i) {
        return 0;
    }

    public long getLong(int i) {
        return 0;
    }

    public short getShort(int i) {
        return (short) 0;
    }

    public String getString(int i) {
        return null;
    }

    public int getType(int i) {
        return 0;
    }

    public boolean isNull(int i) {
        return false;
    }

    public RowBuilder newRow() {
        return null;
    }
}
