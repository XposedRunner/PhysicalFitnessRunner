package se.emilsjolander.stickylistheaders;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class DistinctMultiHashMap<TKey, TItemValue> {
    private IDMapper<TKey, TItemValue> mIDMapper;
    LinkedHashMap<Object, List<TItemValue>> mKeyToValuesMap;
    LinkedHashMap<Object, TKey> mValueToKeyIndexer;

    interface IDMapper<TKey, TItemValue> {
        TKey keyIdToKey(Object obj);

        Object keyToKeyId(TKey tKey);

        TItemValue valueIdToValue(Object obj);

        Object valueToValueId(TItemValue tItemValue);
    }

    DistinctMultiHashMap() {
    }

    DistinctMultiHashMap(IDMapper<TKey, TItemValue> iDMapper) {
    }

    public void add(TKey tKey, TItemValue tItemValue) {
    }

    public void clear() {
    }

    public void clearValues() {
    }

    /* Access modifiers changed, original: protected */
    public boolean containsValue(List<TItemValue> list, TItemValue tItemValue) {
        return false;
    }

    public Set<Entry<Object, List<TItemValue>>> entrySet() {
        return null;
    }

    public List<TItemValue> get(TKey tKey) {
        return null;
    }

    public TKey getKey(TItemValue tItemValue) {
        return null;
    }

    public TItemValue getValueByPosition(int i) {
        return null;
    }

    public void removeKey(TKey tKey) {
    }

    public void removeValue(TItemValue tItemValue) {
    }

    public Set<Entry<Object, TKey>> reverseEntrySet() {
        return null;
    }

    public int size() {
        return 0;
    }

    public int valuesSize() {
        return 0;
    }
}
