package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ButtonBarLayout extends LinearLayout {
    private static final int ALLOW_STACKING_MIN_HEIGHT_DP = 320;
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize = -1;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean z = ConfigurationHelper.getScreenHeightDp(getResources()) >= 320;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ButtonBarLayout);
        this.mAllowStacking = obtainStyledAttributes.getBoolean(R.styleable.ButtonBarLayout_allowStacking, z);
        obtainStyledAttributes.recycle();
    }

    private int getNextVisibleChildIndex(int i) {
        int childCount = getChildCount();
        while (i < childCount) {
            if (getChildAt(i).getVisibility() == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private boolean isStacked() {
        return getOrientation() == 1;
    }

    private void setStacked(boolean z) {
        setOrientation(z);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(R.id.spacer);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:21:0x004d, code skipped:
            if ((android.support.v4.view.ViewCompat.getMeasuredWidthAndState(r8) & android.support.v4.view.ViewCompat.MEASURED_STATE_MASK) == 16777216) goto L_0x004f;
     */
    /* JADX WARNING: Missing block: B:23:0x0051, code skipped:
            r0 = false;
     */
    /* JADX WARNING: Missing block: B:28:0x0071, code skipped:
            if (((r6 + getPaddingLeft()) + getPaddingRight()) > r0) goto L_0x004f;
     */
    public void onMeasure(int r9, int r10) {
        /*
        r8 = this;
        r0 = android.view.View.MeasureSpec.getSize(r9);
        r1 = r8.mAllowStacking;
        r2 = 0;
        if (r1 == 0) goto L_0x0018;
    L_0x0009:
        r1 = r8.mLastWidthSize;
        if (r0 <= r1) goto L_0x0016;
    L_0x000d:
        r1 = r8.isStacked();
        if (r1 == 0) goto L_0x0016;
    L_0x0013:
        r8.setStacked(r2);
    L_0x0016:
        r8.mLastWidthSize = r0;
    L_0x0018:
        r1 = r8.isStacked();
        r3 = 1;
        if (r1 != 0) goto L_0x002f;
    L_0x001f:
        r1 = android.view.View.MeasureSpec.getMode(r9);
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r1 != r4) goto L_0x002f;
    L_0x0027:
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1);
        r4 = r3;
        goto L_0x0031;
    L_0x002f:
        r1 = r9;
        r4 = r2;
    L_0x0031:
        super.onMeasure(r1, r10);
        r1 = r8.mAllowStacking;
        if (r1 == 0) goto L_0x007a;
    L_0x0038:
        r1 = r8.isStacked();
        if (r1 != 0) goto L_0x007a;
    L_0x003e:
        r1 = android.os.Build.VERSION.SDK_INT;
        r5 = 11;
        if (r1 < r5) goto L_0x0053;
    L_0x0044:
        r0 = android.support.v4.view.ViewCompat.getMeasuredWidthAndState(r8);
        r1 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r0 = r0 & r1;
        r1 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;
        if (r0 != r1) goto L_0x0051;
    L_0x004f:
        r0 = r3;
        goto L_0x0074;
    L_0x0051:
        r0 = r2;
        goto L_0x0074;
    L_0x0053:
        r1 = r8.getChildCount();
        r5 = r2;
        r6 = r5;
    L_0x0059:
        if (r5 >= r1) goto L_0x0067;
    L_0x005b:
        r7 = r8.getChildAt(r5);
        r7 = r7.getMeasuredWidth();
        r6 = r6 + r7;
        r5 = r5 + 1;
        goto L_0x0059;
    L_0x0067:
        r1 = r8.getPaddingLeft();
        r6 = r6 + r1;
        r1 = r8.getPaddingRight();
        r6 = r6 + r1;
        if (r6 <= r0) goto L_0x0051;
    L_0x0073:
        goto L_0x004f;
    L_0x0074:
        if (r0 == 0) goto L_0x007a;
    L_0x0076:
        r8.setStacked(r3);
        r4 = r3;
    L_0x007a:
        if (r4 == 0) goto L_0x007f;
    L_0x007c:
        super.onMeasure(r9, r10);
    L_0x007f:
        r9 = r8.getNextVisibleChildIndex(r2);
        if (r9 < 0) goto L_0x00cd;
    L_0x0085:
        r10 = r8.getChildAt(r9);
        r0 = r10.getLayoutParams();
        r0 = (android.widget.LinearLayout.LayoutParams) r0;
        r1 = r8.getPaddingTop();
        r10 = r10.getMeasuredHeight();
        r1 = r1 + r10;
        r10 = r0.topMargin;
        r1 = r1 + r10;
        r10 = r0.bottomMargin;
        r1 = r1 + r10;
        r2 = r2 + r1;
        r10 = r8.isStacked();
        if (r10 == 0) goto L_0x00c8;
    L_0x00a5:
        r9 = r9 + r3;
        r9 = r8.getNextVisibleChildIndex(r9);
        if (r9 < 0) goto L_0x00cd;
    L_0x00ac:
        r10 = (float) r2;
        r9 = r8.getChildAt(r9);
        r9 = r9.getPaddingTop();
        r9 = (float) r9;
        r0 = 1098907648; // 0x41800000 float:16.0 double:5.42932517E-315;
        r1 = r8.getResources();
        r1 = r1.getDisplayMetrics();
        r1 = r1.density;
        r0 = r0 * r1;
        r9 = r9 + r0;
        r10 = r10 + r9;
        r9 = (int) r10;
        r2 = r9;
        goto L_0x00cd;
    L_0x00c8:
        r9 = r8.getPaddingBottom();
        r2 = r2 + r9;
    L_0x00cd:
        r9 = android.support.v4.view.ViewCompat.getMinimumHeight(r8);
        if (r9 == r2) goto L_0x00d6;
    L_0x00d3:
        r8.setMinimumHeight(r2);
    L_0x00d6:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ButtonBarLayout.onMeasure(int, int):void");
    }

    public void setAllowStacking(boolean z) {
        if (this.mAllowStacking != z) {
            this.mAllowStacking = z;
            if (!this.mAllowStacking && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
