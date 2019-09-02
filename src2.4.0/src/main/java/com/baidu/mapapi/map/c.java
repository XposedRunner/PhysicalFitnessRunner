package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapsdkplatform.comapi.map.o;

class c implements o {
    final /* synthetic */ BaiduMap a;

    c(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    public Bundle a(int i, int i2, int i3) {
        this.a.F.lock();
        try {
            if (this.a.E != null) {
                Tile a = this.a.E.a(i, i2, i3);
                if (a != null) {
                    Bundle toBundle = a.toBundle();
                    return toBundle;
                }
            }
            this.a.F.unlock();
            return null;
        } finally {
            this.a.F.unlock();
        }
    }
}
