package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import android.util.LongSparseArray;

public class BaseMapCallback {
    private static LongSparseArray<b> a = new LongSparseArray();

    public static int ReqLayerData(Bundle bundle, long j, int i, Bundle bundle2) {
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) a.valueAt(i2);
            if (bVar != null && bVar.a(j)) {
                return bVar.a(bundle, j, i, bundle2);
            }
        }
        return 0;
    }

    public static void addLayerDataInterface(long j, b bVar) {
        a.put(j, bVar);
    }

    public static void removeLayerDataInterface(long j) {
        a.remove(j);
    }
}
