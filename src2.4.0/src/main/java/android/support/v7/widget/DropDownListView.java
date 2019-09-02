package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R;
import android.view.View;

class DropDownListView extends ListViewCompat {
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private ListViewAutoScrollHelper mScrollHelper;

    public DropDownListView(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.mHijackFocus = z;
        setCacheColorHint(0);
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.mClickAnimation != null) {
            this.mClickAnimation.cancel();
            this.mClickAnimation = null;
        }
    }

    private void clickPressedItem(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void setPressedItem(View view, int i, float f, float f2) {
        this.mDrawsInPressedState = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.mMotionPosition != -1) {
            View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.mMotionPosition = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        positionSelectorLikeTouchCompat(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    public boolean hasFocus() {
        return this.mHijackFocus || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.mHijackFocus || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.mHijackFocus || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    public boolean onForwardedEvent(android.view.MotionEvent r8, int r9) {
        /*
        r7 = this;
        r0 = android.support.v4.view.MotionEventCompat.getActionMasked(r8);
        r1 = 0;
        r2 = 1;
        switch(r0) {
            case 1: goto L_0x0011;
            case 2: goto L_0x000f;
            case 3: goto L_0x000c;
            default: goto L_0x0009;
        };
    L_0x0009:
        r9 = r1;
        r3 = r2;
        goto L_0x0041;
    L_0x000c:
        r9 = r1;
        r3 = r9;
        goto L_0x0041;
    L_0x000f:
        r3 = r2;
        goto L_0x0012;
    L_0x0011:
        r3 = r1;
    L_0x0012:
        r9 = r8.findPointerIndex(r9);
        if (r9 >= 0) goto L_0x0019;
    L_0x0018:
        goto L_0x000c;
    L_0x0019:
        r4 = r8.getX(r9);
        r4 = (int) r4;
        r9 = r8.getY(r9);
        r9 = (int) r9;
        r5 = r7.pointToPosition(r4, r9);
        r6 = -1;
        if (r5 != r6) goto L_0x002c;
    L_0x002a:
        r9 = r2;
        goto L_0x0041;
    L_0x002c:
        r3 = r7.getFirstVisiblePosition();
        r3 = r5 - r3;
        r3 = r7.getChildAt(r3);
        r4 = (float) r4;
        r9 = (float) r9;
        r7.setPressedItem(r3, r5, r4, r9);
        if (r0 != r2) goto L_0x0009;
    L_0x003d:
        r7.clickPressedItem(r3, r5);
        goto L_0x0009;
    L_0x0041:
        if (r3 == 0) goto L_0x0045;
    L_0x0043:
        if (r9 == 0) goto L_0x0048;
    L_0x0045:
        r7.clearPressedItem();
    L_0x0048:
        if (r3 == 0) goto L_0x0060;
    L_0x004a:
        r9 = r7.mScrollHelper;
        if (r9 != 0) goto L_0x0055;
    L_0x004e:
        r9 = new android.support.v4.widget.ListViewAutoScrollHelper;
        r9.<init>(r7);
        r7.mScrollHelper = r9;
    L_0x0055:
        r9 = r7.mScrollHelper;
        r9.setEnabled(r2);
        r9 = r7.mScrollHelper;
        r9.onTouch(r7, r8);
        goto L_0x0069;
    L_0x0060:
        r8 = r7.mScrollHelper;
        if (r8 == 0) goto L_0x0069;
    L_0x0064:
        r8 = r7.mScrollHelper;
        r8.setEnabled(r1);
    L_0x0069:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.DropDownListView.onForwardedEvent(android.view.MotionEvent, int):boolean");
    }

    /* Access modifiers changed, original: 0000 */
    public void setListSelectionHidden(boolean z) {
        this.mListSelectionHidden = z;
    }

    /* Access modifiers changed, original: protected */
    public boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat();
    }
}
