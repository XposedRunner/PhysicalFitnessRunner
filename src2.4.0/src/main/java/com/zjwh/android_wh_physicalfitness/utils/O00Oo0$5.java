package com.zjwh.android_wh_physicalfitness.utils;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: Utils */
class O00Oo0$5 implements OnTouchListener {
    O00Oo0$5() {
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (!view.hasFocus()) {
                    view.requestFocus();
                    break;
                }
                break;
        }
        return false;
    }
}
