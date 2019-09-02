package android.support.v7.widget;

import java.util.ArrayList;

class PositionMap<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    static class ContainerHelpers {
        static final boolean[] EMPTY_BOOLEANS = new boolean[0];
        static final int[] EMPTY_INTS = new int[0];
        static final long[] EMPTY_LONGS = new long[0];
        static final Object[] EMPTY_OBJECTS = new Object[0];

        ContainerHelpers() {
        }

        static int binarySearch(int[] iArr, int i, int i2) {
            i--;
            int i3 = 0;
            while (i3 <= i) {
                int i4 = (i3 + i) >>> 1;
                int i5 = iArr[i4];
                if (i5 < i2) {
                    i3 = i4 + 1;
                } else if (i5 <= i2) {
                    return i4;
                } else {
                    i = i4 - 1;
                }
            }
            return i3 ^ -1;
        }
    }

    public PositionMap() {
        this(10);
    }

    public PositionMap(int i) {
        this.mGarbage = false;
        if (i == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            i = idealIntArraySize(i);
            this.mKeys = new int[i];
            this.mValues = new Object[i];
        }
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        int i3 = i2;
        while (i2 < i) {
            Object obj = objArr[i2];
            if (obj != DELETED) {
                if (i2 != i3) {
                    iArr[i3] = iArr[i2];
                    objArr[i3] = obj;
                    objArr[i2] = null;
                }
                i3++;
            }
            i2++;
        }
        this.mGarbage = false;
        this.mSize = i3;
    }

    static int idealBooleanArraySize(int i) {
        return idealByteArraySize(i);
    }

    static int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    static int idealCharArraySize(int i) {
        return idealByteArraySize(i * 2) / 2;
    }

    static int idealFloatArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    static int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    static int idealLongArraySize(int i) {
        return idealByteArraySize(i * 8) / 8;
    }

    static int idealObjectArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    static int idealShortArraySize(int i) {
        return idealByteArraySize(i * 2) / 2;
    }

    public void append(int i, E e) {
        if (this.mSize == 0 || i > this.mKeys[this.mSize - 1]) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
            }
            int i2 = this.mSize;
            if (i2 >= this.mKeys.length) {
                int idealIntArraySize = idealIntArraySize(i2 + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                System.arraycopy(this.mKeys, 0, iArr, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
                this.mKeys = iArr;
                this.mValues = objArr;
            }
            this.mKeys[i2] = i;
            this.mValues[i2] = e;
            this.mSize = i2 + 1;
            return;
        }
        put(i, e);
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public PositionMap<E> clone() {
        try {
            PositionMap positionMap = (PositionMap) super.clone();
            try {
                positionMap.mKeys = (int[]) this.mKeys.clone();
                positionMap.mValues = (Object[]) this.mValues.clone();
                return positionMap;
            } catch (CloneNotSupportedException unused) {
                return positionMap;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public void delete(int i) {
        i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (i >= 0 && this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    public E get(int i) {
        return get(i, null);
    }

    public E get(int i, E e) {
        i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        return (i < 0 || this.mValues[i] == DELETED) ? e : this.mValues[i];
    }

    public int indexOfKey(int i) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
    }

    public int indexOfValue(E e) {
        if (this.mGarbage) {
            gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void insertKeyRange(int i, int i2) {
    }

    public int keyAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i];
    }

    public void put(int i, E e) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e;
        } else {
            binarySearch ^= -1;
            if (binarySearch >= this.mSize || this.mValues[binarySearch] != DELETED) {
                if (this.mGarbage && this.mSize >= this.mKeys.length) {
                    gc();
                    binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i) ^ -1;
                }
                if (this.mSize >= this.mKeys.length) {
                    int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                    int[] iArr = new int[idealIntArraySize];
                    Object[] objArr = new Object[idealIntArraySize];
                    System.arraycopy(this.mKeys, 0, iArr, 0, this.mKeys.length);
                    System.arraycopy(this.mValues, 0, objArr, 0, this.mValues.length);
                    this.mKeys = iArr;
                    this.mValues = objArr;
                }
                if (this.mSize - binarySearch != 0) {
                    int i2 = binarySearch + 1;
                    System.arraycopy(this.mKeys, binarySearch, this.mKeys, i2, this.mSize - binarySearch);
                    System.arraycopy(this.mValues, binarySearch, this.mValues, i2, this.mSize - binarySearch);
                }
                this.mKeys[binarySearch] = i;
                this.mValues[binarySearch] = e;
                this.mSize++;
            } else {
                this.mKeys[binarySearch] = i;
                this.mValues[binarySearch] = e;
            }
        }
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        if (this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        i2 = Math.min(this.mSize, i2 + i);
        while (i < i2) {
            removeAt(i);
            i++;
        }
    }

    public void removeKeyRange(ArrayList<E> arrayList, int i, int i2) {
    }

    public void setValueAt(int i, E e) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i] = e;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(keyAt(i));
            stringBuilder.append('=');
            PositionMap valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public E valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mValues[i];
    }
}
