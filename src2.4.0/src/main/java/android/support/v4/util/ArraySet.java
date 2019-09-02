package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static final String TAG = "ArraySet";
    static Object[] sBaseCache;
    static int sBaseCacheSize;
    static Object[] sTwiceBaseCache;
    static int sTwiceBaseCacheSize;
    Object[] mArray;
    MapCollections<E, E> mCollections;
    int[] mHashes;
    final boolean mIdentityHashCode;
    int mSize;

    public ArraySet() {
        this(0, false);
    }

    public ArraySet(int i) {
        this(i, false);
    }

    public ArraySet(int i, boolean z) {
        this.mIdentityHashCode = z;
        if (i == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }

    public ArraySet(ArraySet<E> arraySet) {
        this();
        if (arraySet != null) {
            addAll((ArraySet) arraySet);
        }
    }

    public ArraySet(Collection<E> collection) {
        this();
        if (collection != null) {
            addAll((Collection) collection);
        }
    }

    private void allocArrays(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCache != null) {
                    objArr = sTwiceBaseCache;
                    this.mArray = objArr;
                    sTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    sTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCache != null) {
                    objArr = sBaseCache;
                    this.mArray = objArr;
                    sBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    sBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[i];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (sTwiceBaseCacheSize < 10) {
                    objArr[0] = sTwiceBaseCache;
                    objArr[1] = iArr;
                    for (i--; i >= 2; i--) {
                        objArr[i] = null;
                    }
                    sTwiceBaseCache = objArr;
                    sTwiceBaseCacheSize++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (sBaseCacheSize < 10) {
                    objArr[0] = sBaseCache;
                    objArr[1] = iArr;
                    for (i--; i >= 2; i--) {
                        objArr[i] = null;
                    }
                    sBaseCache = objArr;
                    sBaseCacheSize++;
                }
            }
        }
    }

    private MapCollections<E, E> getCollection() {
        if (this.mCollections == null) {
            this.mCollections = new MapCollections<E, E>() {
                /* Access modifiers changed, original: protected */
                public void colClear() {
                    ArraySet.this.clear();
                }

                /* Access modifiers changed, original: protected */
                public Object colGetEntry(int i, int i2) {
                    return ArraySet.this.mArray[i];
                }

                /* Access modifiers changed, original: protected */
                public Map<E, E> colGetMap() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* Access modifiers changed, original: protected */
                public int colGetSize() {
                    return ArraySet.this.mSize;
                }

                /* Access modifiers changed, original: protected */
                public int colIndexOfKey(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                /* Access modifiers changed, original: protected */
                public int colIndexOfValue(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                /* Access modifiers changed, original: protected */
                public void colPut(E e, E e2) {
                    ArraySet.this.add(e);
                }

                /* Access modifiers changed, original: protected */
                public void colRemoveAt(int i) {
                    ArraySet.this.removeAt(i);
                }

                /* Access modifiers changed, original: protected */
                public E colSetValue(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        return this.mCollections;
    }

    private int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i2, i);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch])) {
            return binarySearch;
        }
        int i3 = binarySearch + 1;
        while (i3 < i2 && this.mHashes[i3] == i) {
            if (obj.equals(this.mArray[i3])) {
                return i3;
            }
            i3++;
        }
        binarySearch--;
        while (binarySearch >= 0 && this.mHashes[binarySearch] == i) {
            if (obj.equals(this.mArray[binarySearch])) {
                return binarySearch;
            }
            binarySearch--;
        }
        return i3 ^ -1;
    }

    private int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i, 0);
        if (binarySearch < 0 || this.mArray[binarySearch] == null) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.mHashes[i2] == 0) {
            if (this.mArray[i2] == null) {
                return i2;
            }
            i2++;
        }
        binarySearch--;
        while (binarySearch >= 0 && this.mHashes[binarySearch] == 0) {
            if (this.mArray[binarySearch] == null) {
                return binarySearch;
            }
            binarySearch--;
        }
        return i2 ^ -1;
    }

    public boolean add(E e) {
        int indexOfNull;
        boolean z;
        if (e == null) {
            indexOfNull = indexOfNull();
            z = false;
        } else {
            boolean identityHashCode = this.mIdentityHashCode ? System.identityHashCode(e) : e.hashCode();
            z = identityHashCode;
            indexOfNull = indexOf(e, identityHashCode);
        }
        if (indexOfNull >= 0) {
            return false;
        }
        int i;
        indexOfNull ^= -1;
        if (this.mSize >= this.mHashes.length) {
            i = 4;
            if (this.mSize >= 8) {
                i = (this.mSize >> 1) + this.mSize;
            } else if (this.mSize >= 4) {
                i = 8;
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i);
            if (this.mHashes.length > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
        if (indexOfNull < this.mSize) {
            i = indexOfNull + 1;
            System.arraycopy(this.mHashes, indexOfNull, this.mHashes, i, this.mSize - indexOfNull);
            System.arraycopy(this.mArray, indexOfNull, this.mArray, i, this.mSize - indexOfNull);
        }
        this.mHashes[indexOfNull] = z;
        this.mArray[indexOfNull] = e;
        this.mSize++;
        return true;
    }

    public void addAll(ArraySet<? extends E> arraySet) {
        int i = arraySet.mSize;
        ensureCapacity(this.mSize + i);
        int i2 = 0;
        if (this.mSize != 0) {
            while (i2 < i) {
                add(arraySet.valueAt(i2));
                i2++;
            }
        } else if (i > 0) {
            System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i);
            System.arraycopy(arraySet.mArray, 0, this.mArray, 0, i);
            this.mSize = i;
        }
    }

    public boolean addAll(Collection<? extends E> collection) {
        ensureCapacity(this.mSize + collection.size());
        int i = 0;
        for (Object add : collection) {
            i |= add(add);
        }
        return i;
    }

    public void append(E e) {
        int i = this.mSize;
        int identityHashCode = e == null ? 0 : this.mIdentityHashCode ? System.identityHashCode(e) : e.hashCode();
        if (i >= this.mHashes.length) {
            throw new IllegalStateException("Array is full");
        } else if (i <= 0 || this.mHashes[i - 1] <= identityHashCode) {
            this.mSize = i + 1;
            this.mHashes[i] = identityHashCode;
            this.mArray[i] = e;
        } else {
            add(e);
        }
    }

    public void clear() {
        if (this.mSize != 0) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int i) {
        if (this.mHashes.length < i) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            allocArrays(i);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
            }
            freeArrays(iArr, objArr, this.mSize);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        int i = 0;
        while (i < this.mSize) {
            try {
                if (!set.contains(valueAt(i))) {
                    return false;
                }
                i++;
            } catch (NullPointerException unused) {
                return false;
            } catch (ClassCastException unused2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        int i = 0;
        int i2 = 0;
        while (i < this.mSize) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return indexOfNull();
        }
        return indexOf(obj, this.mIdentityHashCode ? System.identityHashCode(obj) : obj.hashCode());
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public Iterator<E> iterator() {
        return getCollection().getKeySet().iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public boolean removeAll(ArraySet<? extends E> arraySet) {
        int i = arraySet.mSize;
        int i2 = this.mSize;
        for (int i3 = 0; i3 < i; i3++) {
            remove(arraySet.valueAt(i3));
        }
        return i2 != this.mSize;
    }

    public boolean removeAll(Collection<?> collection) {
        int i = 0;
        for (Object remove : collection) {
            i |= remove(remove);
        }
        return i;
    }

    public E removeAt(int i) {
        E e = this.mArray[i];
        if (this.mSize <= 1) {
            freeArrays(this.mHashes, this.mArray, this.mSize);
            this.mHashes = INT;
            this.mArray = OBJECT;
            this.mSize = 0;
        } else {
            int i2 = 8;
            int i3;
            if (this.mHashes.length <= 8 || this.mSize >= this.mHashes.length / 3) {
                this.mSize--;
                if (i < this.mSize) {
                    i3 = i + 1;
                    System.arraycopy(this.mHashes, i3, this.mHashes, i, this.mSize - i);
                    System.arraycopy(this.mArray, i3, this.mArray, i, this.mSize - i);
                }
                this.mArray[this.mSize] = null;
            } else {
                if (this.mSize > 8) {
                    i2 = (this.mSize >> 1) + this.mSize;
                }
                int[] iArr = this.mHashes;
                Object[] objArr = this.mArray;
                allocArrays(i2);
                this.mSize--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i);
                    System.arraycopy(objArr, 0, this.mArray, 0, i);
                }
                if (i < this.mSize) {
                    i3 = i + 1;
                    System.arraycopy(iArr, i3, this.mHashes, i, this.mSize - i);
                    System.arraycopy(objArr, i3, this.mArray, i, this.mSize - i);
                }
            }
        }
        return e;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.mSize - 1; i >= 0; i--) {
            if (!collection.contains(this.mArray[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.mSize;
    }

    public Object[] toArray() {
        Object[] objArr = new Object[this.mSize];
        System.arraycopy(this.mArray, 0, objArr, 0, this.mSize);
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        Object tArr2;
        if (tArr2.length < this.mSize) {
            tArr2 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), this.mSize);
        }
        System.arraycopy(this.mArray, 0, tArr2, 0, this.mSize);
        if (tArr2.length > this.mSize) {
            tArr2[this.mSize] = null;
        }
        return tArr2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            ArraySet valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public E valueAt(int i) {
        return this.mArray[i];
    }
}
