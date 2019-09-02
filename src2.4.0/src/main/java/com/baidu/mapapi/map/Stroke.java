package com.baidu.mapapi.map;

import android.os.Bundle;

public final class Stroke {
    public final int color;
    public final int strokeWidth;

    public Stroke(int i, int i2) {
        if (i <= 0) {
            i = 5;
        }
        this.strokeWidth = i;
        this.color = i2;
    }

    /* Access modifiers changed, original: 0000 */
    public Bundle a(Bundle bundle) {
        bundle.putInt("width", this.strokeWidth);
        Overlay.a(this.color, bundle);
        return bundle;
    }
}
