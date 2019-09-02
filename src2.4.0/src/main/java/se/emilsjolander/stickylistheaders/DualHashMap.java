package se.emilsjolander.stickylistheaders;

import java.util.HashMap;

class DualHashMap<TKey, TValue> {
    HashMap<TKey, TValue> mKeyToValue;
    HashMap<TValue, TKey> mValueToKey;

    DualHashMap() {
    }

    public TValue get(TKey tKey) {
        return null;
    }

    public TKey getKey(TValue tValue) {
        return null;
    }

    public void put(TKey tKey, TValue tValue) {
    }

    public void remove(TKey tKey) {
    }

    public void removeByValue(TValue tValue) {
    }
}
