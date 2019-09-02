package org.xutils.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DoubleKeyValueMap<K1, K2, V> {
    private final ConcurrentHashMap<K1, ConcurrentHashMap<K2, V>> k1_k2V_map = new ConcurrentHashMap();

    public void clear() {
        if (this.k1_k2V_map.size() > 0) {
            for (ConcurrentHashMap clear : this.k1_k2V_map.values()) {
                clear.clear();
            }
            this.k1_k2V_map.clear();
        }
    }

    public boolean containsKey(K1 k1) {
        return this.k1_k2V_map.containsKey(k1);
    }

    public boolean containsKey(K1 k1, K2 k2) {
        return this.k1_k2V_map.containsKey(k1) ? ((ConcurrentHashMap) this.k1_k2V_map.get(k1)).containsKey(k2) : false;
    }

    public V get(K1 k1, K2 k2) {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.k1_k2V_map.get(k1);
        return concurrentHashMap == null ? null : concurrentHashMap.get(k2);
    }

    public ConcurrentHashMap<K2, V> get(K1 k1) {
        return (ConcurrentHashMap) this.k1_k2V_map.get(k1);
    }

    public Collection<V> getAllValues() {
        Set<Object> keySet = this.k1_k2V_map.keySet();
        if (keySet == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : keySet) {
            Collection values = ((ConcurrentHashMap) this.k1_k2V_map.get(obj)).values();
            if (values != null) {
                arrayList.addAll(values);
            }
        }
        return arrayList;
    }

    public Collection<V> getAllValues(K1 k1) {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.k1_k2V_map.get(k1);
        return concurrentHashMap == null ? null : concurrentHashMap.values();
    }

    public Set<K1> getFirstKeys() {
        return this.k1_k2V_map.keySet();
    }

    public void put(K1 k1, K2 k2, V v) {
        if (k1 != null && k2 != null && v != null) {
            ConcurrentHashMap concurrentHashMap;
            if (this.k1_k2V_map.containsKey(k1)) {
                concurrentHashMap = (ConcurrentHashMap) this.k1_k2V_map.get(k1);
                if (concurrentHashMap != null) {
                    concurrentHashMap.put(k2, v);
                } else {
                    concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(k2, v);
                    this.k1_k2V_map.put(k1, concurrentHashMap);
                }
            } else {
                concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.put(k2, v);
                this.k1_k2V_map.put(k1, concurrentHashMap);
            }
        }
    }

    public void remove(K1 k1) {
        this.k1_k2V_map.remove(k1);
    }

    public void remove(K1 k1, K2 k2) {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.k1_k2V_map.get(k1);
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(k2);
        }
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            this.k1_k2V_map.remove(k1);
        }
    }

    public int size() {
        int i = 0;
        if (this.k1_k2V_map.size() == 0) {
            return 0;
        }
        for (ConcurrentHashMap size : this.k1_k2V_map.values()) {
            i += size.size();
        }
        return i;
    }
}
