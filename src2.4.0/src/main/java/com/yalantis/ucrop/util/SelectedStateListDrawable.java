package com.yalantis.ucrop.util;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class SelectedStateListDrawable extends StateListDrawable {
    private int mSelectionColor;

    public SelectedStateListDrawable(Drawable drawable, int i) {
        this.mSelectionColor = i;
        addState(new int[]{16842913}, drawable);
        addState(new int[0], drawable);
    }

    public boolean isStateful() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean onStateChange(int[] iArr) {
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            if (iArr[i] == 16842913) {
                i2 = 1;
            }
            i++;
        }
        if (i2 != 0) {
            super.setColorFilter(this.mSelectionColor, Mode.SRC_ATOP);
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}
