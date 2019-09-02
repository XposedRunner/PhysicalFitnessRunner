package com.zxing.view;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/* compiled from: ViewfinderResultPointCallback */
public final class O000000o implements ResultPointCallback {
    private final ViewfinderView O000000o;

    public O000000o(ViewfinderView viewfinderView) {
        this.O000000o = viewfinderView;
    }

    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.O000000o.O000000o(resultPoint);
    }
}
