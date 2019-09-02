package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class BarcodeValue {
    private final Map<Integer, Integer> values = new HashMap();

    BarcodeValue() {
    }

    public Integer getConfidence(int i) {
        return (Integer) this.values.get(Integer.valueOf(i));
    }

    /* Access modifiers changed, original: 0000 */
    public int[] getValue() {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Entry entry : this.values.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > i) {
                i = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (((Integer) entry.getValue()).intValue() == i) {
                arrayList.add(entry.getKey());
            }
        }
        return PDF417Common.toIntArray(arrayList);
    }

    /* Access modifiers changed, original: 0000 */
    public void setValue(int i) {
        Integer num = (Integer) this.values.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(0);
        }
        this.values.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }
}
