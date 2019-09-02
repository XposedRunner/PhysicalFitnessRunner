package com.baidu.mapapi.map;

import android.content.Context;
import android.os.Bundle;
import com.baidu.mapsdkplatform.comapi.map.ai;

class d implements ai {
    final /* synthetic */ BaiduMap a;

    d(BaiduMap baiduMap) {
        this.a = baiduMap;
    }

    public Bundle a(int i, int i2, int i3, Context context) {
        this.a.G.lock();
        try {
            if (this.a.D != null) {
                Tile a = this.a.D.a(i, i2, i3);
                if (a != null) {
                    Bundle toBundle = a.toBundle();
                    return toBundle;
                }
            }
            this.a.G.unlock();
            return null;
        } finally {
            this.a.G.unlock();
        }
    }
}
