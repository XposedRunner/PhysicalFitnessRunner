package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public static class LayoutParams extends MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        i2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* Access modifiers changed, original: 0000 */
    public void drawDividersHorizontal(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i = 0;
        while (i < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, isLayoutRtl ? virtualChildAt.getRight() + layoutParams.rightMargin : (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                virtualChildCount = isLayoutRtl ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.mDividerWidth;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                virtualChildCount = isLayoutRtl ? (virtualChildAt2.getLeft() - layoutParams2.leftMargin) - this.mDividerWidth : virtualChildAt2.getRight() + layoutParams2.rightMargin;
            }
            drawVerticalDivider(canvas, virtualChildCount);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                virtualChildCount = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                virtualChildCount = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, virtualChildCount);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    /* Access modifiers changed, original: 0000 */
    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new LayoutParams(-2, -2) : this.mOrientation == 1 ? new LayoutParams(-1, -2) : null;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.mBaselineAlignedChildIndex);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i = this.mBaselineChildTop;
            if (this.mOrientation == 1) {
                int i2 = this.mGravity & 112;
                if (i2 != 48) {
                    if (i2 == 16) {
                        i += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                    } else if (i2 == 80) {
                        i = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                    }
                }
            }
            return (i + ((LayoutParams) childAt.getLayoutParams()).topMargin) + baseline;
        } else if (this.mBaselineAlignedChildIndex == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    /* Access modifiers changed, original: 0000 */
    public int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    /* Access modifiers changed, original: 0000 */
    public int getLocationOffset(View view) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    /* Access modifiers changed, original: 0000 */
    public View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    /* Access modifiers changed, original: 0000 */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* Access modifiers changed, original: protected */
    public boolean hasDividerBeforeChildAt(int i) {
        boolean z = false;
        if (i == 0) {
            if ((this.mShowDividers & 1) != 0) {
                z = true;
            }
            return z;
        } else if (i == getChildCount()) {
            if ((this.mShowDividers & 4) != 0) {
                z = true;
            }
            return z;
        } else if ((this.mShowDividers & 2) == 0) {
            return false;
        } else {
            for (i--; i >= 0; i--) {
                if (getChildAt(i).getVisibility() != 8) {
                    z = true;
                    break;
                }
            }
            return z;
        }
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010a  */
    public void layoutHorizontal(int r28, int r29, int r30, int r31) {
        /*
        r27 = this;
        r6 = r27;
        r2 = android.support.v7.widget.ViewUtils.isLayoutRtl(r27);
        r7 = r27.getPaddingTop();
        r3 = r31 - r29;
        r4 = r27.getPaddingBottom();
        r8 = r3 - r4;
        r3 = r3 - r7;
        r4 = r27.getPaddingBottom();
        r9 = r3 - r4;
        r10 = r27.getVirtualChildCount();
        r3 = r6.mGravity;
        r4 = 8388615; // 0x800007 float:1.1754953E-38 double:4.1445265E-317;
        r3 = r3 & r4;
        r4 = r6.mGravity;
        r11 = r4 & 112;
        r12 = r6.mBaselineAligned;
        r13 = r6.mMaxAscent;
        r14 = r6.mMaxDescent;
        r4 = android.support.v4.view.ViewCompat.getLayoutDirection(r27);
        r3 = android.support.v4.view.GravityCompat.getAbsoluteGravity(r3, r4);
        r15 = 2;
        r5 = 1;
        if (r3 == r5) goto L_0x004e;
    L_0x0039:
        r4 = 5;
        if (r3 == r4) goto L_0x0041;
    L_0x003c:
        r0 = r27.getPaddingLeft();
        goto L_0x0059;
    L_0x0041:
        r3 = r27.getPaddingLeft();
        r3 = r3 + r30;
        r3 = r3 - r28;
        r0 = r6.mTotalLength;
        r0 = r3 - r0;
        goto L_0x0059;
    L_0x004e:
        r3 = r27.getPaddingLeft();
        r0 = r30 - r28;
        r1 = r6.mTotalLength;
        r0 = r0 - r1;
        r0 = r0 / r15;
        r0 = r0 + r3;
    L_0x0059:
        r1 = 0;
        if (r2 == 0) goto L_0x0063;
    L_0x005c:
        r2 = r10 + -1;
        r16 = r2;
        r17 = -1;
        goto L_0x0067;
    L_0x0063:
        r16 = r1;
        r17 = r5;
    L_0x0067:
        r3 = r1;
    L_0x0068:
        if (r3 >= r10) goto L_0x0153;
    L_0x006a:
        r1 = r17 * r3;
        r2 = r16 + r1;
        r1 = r6.getVirtualChildAt(r2);
        if (r1 != 0) goto L_0x0085;
    L_0x0074:
        r1 = r6.measureNullChild(r2);
        r0 = r0 + r1;
        r18 = r5;
        r26 = r7;
        r23 = r10;
        r24 = r11;
    L_0x0081:
        r20 = -1;
        goto L_0x0146;
    L_0x0085:
        r5 = r1.getVisibility();
        r15 = 8;
        if (r5 == r15) goto L_0x013a;
    L_0x008d:
        r15 = r1.getMeasuredWidth();
        r5 = r1.getMeasuredHeight();
        r20 = r1.getLayoutParams();
        r4 = r20;
        r4 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r4;
        if (r12 == 0) goto L_0x00ad;
    L_0x009f:
        r22 = r3;
        r3 = r4.height;
        r23 = r10;
        r10 = -1;
        if (r3 == r10) goto L_0x00b1;
    L_0x00a8:
        r3 = r1.getBaseline();
        goto L_0x00b2;
    L_0x00ad:
        r22 = r3;
        r23 = r10;
    L_0x00b1:
        r3 = -1;
    L_0x00b2:
        r10 = r4.gravity;
        if (r10 >= 0) goto L_0x00b7;
    L_0x00b6:
        r10 = r11;
    L_0x00b7:
        r10 = r10 & 112;
        r24 = r11;
        r11 = 16;
        if (r10 == r11) goto L_0x00f6;
    L_0x00bf:
        r11 = 48;
        if (r10 == r11) goto L_0x00e3;
    L_0x00c3:
        r11 = 80;
        if (r10 == r11) goto L_0x00cc;
    L_0x00c7:
        r3 = r7;
        r11 = -1;
    L_0x00c9:
        r18 = 1;
        goto L_0x0104;
    L_0x00cc:
        r10 = r8 - r5;
        r11 = r4.bottomMargin;
        r10 = r10 - r11;
        r11 = -1;
        if (r3 == r11) goto L_0x00e1;
    L_0x00d4:
        r20 = r1.getMeasuredHeight();
        r20 = r20 - r3;
        r3 = 2;
        r21 = r14[r3];
        r21 = r21 - r20;
        r10 = r10 - r21;
    L_0x00e1:
        r3 = r10;
        goto L_0x00c9;
    L_0x00e3:
        r11 = -1;
        r10 = r4.topMargin;
        r10 = r10 + r7;
        if (r3 == r11) goto L_0x00f2;
    L_0x00e9:
        r18 = 1;
        r20 = r13[r18];
        r20 = r20 - r3;
        r10 = r10 + r20;
        goto L_0x00f4;
    L_0x00f2:
        r18 = 1;
    L_0x00f4:
        r3 = r10;
        goto L_0x0104;
    L_0x00f6:
        r11 = -1;
        r18 = 1;
        r3 = r9 - r5;
        r10 = 2;
        r3 = r3 / r10;
        r3 = r3 + r7;
        r10 = r4.topMargin;
        r3 = r3 + r10;
        r10 = r4.bottomMargin;
        r3 = r3 - r10;
    L_0x0104:
        r10 = r6.hasDividerBeforeChildAt(r2);
        if (r10 == 0) goto L_0x010d;
    L_0x010a:
        r10 = r6.mDividerWidth;
        r0 = r0 + r10;
    L_0x010d:
        r10 = r4.leftMargin;
        r10 = r10 + r0;
        r0 = r6.getLocationOffset(r1);
        r19 = r10 + r0;
        r0 = r6;
        r25 = r1;
        r11 = r2;
        r2 = r19;
        r19 = r22;
        r26 = r7;
        r20 = -1;
        r7 = r4;
        r4 = r15;
        r0.setChildFrame(r1, r2, r3, r4, r5);
        r0 = r7.rightMargin;
        r15 = r15 + r0;
        r0 = r25;
        r1 = r6.getNextLocationOffset(r0);
        r15 = r15 + r1;
        r10 = r10 + r15;
        r0 = r6.getChildrenSkipCount(r0, r11);
        r3 = r19 + r0;
        r0 = r10;
        goto L_0x0146;
    L_0x013a:
        r19 = r3;
        r26 = r7;
        r23 = r10;
        r24 = r11;
        r18 = 1;
        goto L_0x0081;
    L_0x0146:
        r3 = r3 + 1;
        r5 = r18;
        r10 = r23;
        r11 = r24;
        r7 = r26;
        r15 = 2;
        goto L_0x0068;
    L_0x0153:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.layoutHorizontal(int, int, int, int):void");
    }

    /* Access modifiers changed, original: 0000 */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        i5 = this.mGravity & 112;
        int i6 = this.mGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int paddingTop = i5 != 16 ? i5 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.mTotalLength : (((i4 - i2) - this.mTotalLength) / 2) + getPaddingTop();
        int i7 = 0;
        while (i7 < virtualChildCount) {
            int i8;
            View virtualChildAt = getVirtualChildAt(i7);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i7);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                i8 = layoutParams.gravity;
                if (i8 < 0) {
                    i8 = i6;
                }
                i8 = GravityCompat.getAbsoluteGravity(i8, ViewCompat.getLayoutDirection(this)) & 7;
                i8 = i8 != 1 ? i8 != 5 ? layoutParams.leftMargin + paddingLeft : (paddingRight - measuredWidth) - layoutParams.rightMargin : ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                i5 = i8;
                if (hasDividerBeforeChildAt(i7)) {
                    paddingTop += this.mDividerHeight;
                }
                int i9 = paddingTop + layoutParams.topMargin;
                LayoutParams layoutParams2 = layoutParams;
                setChildFrame(virtualChildAt, i5, i9 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i7 += getChildrenSkipCount(virtualChildAt, i7);
                paddingTop = i9 + ((measuredHeight + layoutParams2.bottomMargin) + getNextLocationOffset(virtualChildAt));
                i8 = 1;
                i7 += i8;
            }
            i8 = 1;
            i7 += i8;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x043f  */
    public void measureHorizontal(int r40, int r41) {
        /*
        r39 = this;
        r7 = r39;
        r8 = r40;
        r9 = r41;
        r10 = 0;
        r7.mTotalLength = r10;
        r11 = r39.getVirtualChildCount();
        r12 = android.view.View.MeasureSpec.getMode(r40);
        r13 = android.view.View.MeasureSpec.getMode(r41);
        r0 = r7.mMaxAscent;
        r14 = 4;
        if (r0 == 0) goto L_0x001e;
    L_0x001a:
        r0 = r7.mMaxDescent;
        if (r0 != 0) goto L_0x0026;
    L_0x001e:
        r0 = new int[r14];
        r7.mMaxAscent = r0;
        r0 = new int[r14];
        r7.mMaxDescent = r0;
    L_0x0026:
        r15 = r7.mMaxAscent;
        r6 = r7.mMaxDescent;
        r16 = 3;
        r5 = -1;
        r15[r16] = r5;
        r17 = 2;
        r15[r17] = r5;
        r18 = 1;
        r15[r18] = r5;
        r15[r10] = r5;
        r6[r16] = r5;
        r6[r17] = r5;
        r6[r18] = r5;
        r6[r10] = r5;
        r4 = r7.mBaselineAligned;
        r3 = r7.mUseLargestChild;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 != r2) goto L_0x004c;
    L_0x0049:
        r19 = r18;
        goto L_0x004e;
    L_0x004c:
        r19 = r10;
    L_0x004e:
        r20 = 0;
        r0 = r10;
        r22 = r0;
        r23 = r22;
        r24 = r23;
        r25 = r24;
        r26 = r25;
        r28 = r26;
        r27 = r18;
        r21 = r20;
        r14 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x0063:
        r29 = r6;
        r1 = 8;
        if (r0 >= r11) goto L_0x020d;
    L_0x0069:
        r6 = r7.getVirtualChildAt(r0);
        if (r6 != 0) goto L_0x0082;
    L_0x006f:
        r1 = r7.mTotalLength;
        r6 = r7.measureNullChild(r0);
        r1 = r1 + r6;
        r7.mTotalLength = r1;
    L_0x0078:
        r1 = r0;
        r0 = r2;
        r30 = r3;
        r32 = r4;
        r35 = r12;
        goto L_0x01fb;
    L_0x0082:
        r5 = r6.getVisibility();
        if (r5 != r1) goto L_0x008e;
    L_0x0088:
        r1 = r7.getChildrenSkipCount(r6, r0);
        r0 = r0 + r1;
        goto L_0x0078;
    L_0x008e:
        r1 = r7.hasDividerBeforeChildAt(r0);
        if (r1 == 0) goto L_0x009b;
    L_0x0094:
        r1 = r7.mTotalLength;
        r5 = r7.mDividerWidth;
        r1 = r1 + r5;
        r7.mTotalLength = r1;
    L_0x009b:
        r1 = r6.getLayoutParams();
        r5 = r1;
        r5 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r5;
        r1 = r5.weight;
        r21 = r21 + r1;
        if (r12 != r2) goto L_0x00f7;
    L_0x00a8:
        r1 = r5.width;
        if (r1 != 0) goto L_0x00f7;
    L_0x00ac:
        r1 = r5.weight;
        r1 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1));
        if (r1 <= 0) goto L_0x00f7;
    L_0x00b2:
        if (r19 == 0) goto L_0x00bf;
    L_0x00b4:
        r1 = r7.mTotalLength;
        r2 = r5.leftMargin;
        r10 = r5.rightMargin;
        r2 = r2 + r10;
        r1 = r1 + r2;
        r7.mTotalLength = r1;
        goto L_0x00cd;
    L_0x00bf:
        r1 = r7.mTotalLength;
        r2 = r5.leftMargin;
        r2 = r2 + r1;
        r10 = r5.rightMargin;
        r2 = r2 + r10;
        r1 = java.lang.Math.max(r1, r2);
        r7.mTotalLength = r1;
    L_0x00cd:
        if (r4 == 0) goto L_0x00e5;
    L_0x00cf:
        r1 = 0;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r1);
        r6.measure(r2, r2);
        r34 = r0;
        r30 = r3;
        r32 = r4;
        r8 = r5;
        r35 = r12;
        r31 = -2;
        r12 = r6;
        goto L_0x016c;
    L_0x00e5:
        r34 = r0;
        r30 = r3;
        r32 = r4;
        r8 = r5;
        r35 = r12;
        r23 = r18;
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r31 = -2;
        r12 = r6;
        goto L_0x016e;
    L_0x00f7:
        r1 = r5.width;
        if (r1 != 0) goto L_0x0106;
    L_0x00fb:
        r1 = r5.weight;
        r1 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1));
        if (r1 <= 0) goto L_0x0106;
    L_0x0101:
        r10 = -2;
        r5.width = r10;
        r2 = 0;
        goto L_0x0109;
    L_0x0106:
        r10 = -2;
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x0109:
        r1 = (r21 > r20 ? 1 : (r21 == r20 ? 0 : -1));
        if (r1 != 0) goto L_0x0112;
    L_0x010d:
        r1 = r7.mTotalLength;
        r31 = r1;
        goto L_0x0114;
    L_0x0112:
        r31 = 0;
    L_0x0114:
        r33 = 0;
        r1 = r0;
        r0 = r7;
        r34 = r1;
        r10 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r1 = r6;
        r10 = r2;
        r2 = r34;
        r30 = r3;
        r3 = r8;
        r32 = r4;
        r4 = r31;
        r8 = r5;
        r35 = r12;
        r12 = -1;
        r5 = r9;
        r12 = r6;
        r31 = -2;
        r6 = r33;
        r0.measureChildBeforeLayout(r1, r2, r3, r4, r5, r6);
        r0 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r10 == r0) goto L_0x013a;
    L_0x0138:
        r8.width = r10;
    L_0x013a:
        r0 = r12.getMeasuredWidth();
        if (r19 == 0) goto L_0x0151;
    L_0x0140:
        r1 = r7.mTotalLength;
        r2 = r8.leftMargin;
        r2 = r2 + r0;
        r3 = r8.rightMargin;
        r2 = r2 + r3;
        r3 = r7.getNextLocationOffset(r12);
        r2 = r2 + r3;
        r1 = r1 + r2;
        r7.mTotalLength = r1;
        goto L_0x0166;
    L_0x0151:
        r1 = r7.mTotalLength;
        r2 = r1 + r0;
        r3 = r8.leftMargin;
        r2 = r2 + r3;
        r3 = r8.rightMargin;
        r2 = r2 + r3;
        r3 = r7.getNextLocationOffset(r12);
        r2 = r2 + r3;
        r1 = java.lang.Math.max(r1, r2);
        r7.mTotalLength = r1;
    L_0x0166:
        if (r30 == 0) goto L_0x016c;
    L_0x0168:
        r14 = java.lang.Math.max(r0, r14);
    L_0x016c:
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x016e:
        if (r13 == r0) goto L_0x017a;
    L_0x0170:
        r1 = r8.height;
        r2 = -1;
        if (r1 != r2) goto L_0x017a;
    L_0x0175:
        r1 = r18;
        r28 = r1;
        goto L_0x017b;
    L_0x017a:
        r1 = 0;
    L_0x017b:
        r2 = r8.topMargin;
        r3 = r8.bottomMargin;
        r2 = r2 + r3;
        r3 = r12.getMeasuredHeight();
        r3 = r3 + r2;
        r4 = android.support.v4.view.ViewCompat.getMeasuredState(r12);
        r10 = r26;
        r4 = android.support.v7.widget.ViewUtils.combineMeasuredStates(r10, r4);
        if (r32 == 0) goto L_0x01bb;
    L_0x0191:
        r5 = r12.getBaseline();
        r6 = -1;
        if (r5 == r6) goto L_0x01bb;
    L_0x0198:
        r6 = r8.gravity;
        if (r6 >= 0) goto L_0x019f;
    L_0x019c:
        r6 = r7.mGravity;
        goto L_0x01a1;
    L_0x019f:
        r6 = r8.gravity;
    L_0x01a1:
        r6 = r6 & 112;
        r10 = 4;
        r6 = r6 >> r10;
        r6 = r6 & -2;
        r6 = r6 >> 1;
        r10 = r15[r6];
        r10 = java.lang.Math.max(r10, r5);
        r15[r6] = r10;
        r10 = r29[r6];
        r5 = r3 - r5;
        r5 = java.lang.Math.max(r10, r5);
        r29[r6] = r5;
    L_0x01bb:
        r5 = r22;
        r5 = java.lang.Math.max(r5, r3);
        if (r27 == 0) goto L_0x01cb;
    L_0x01c3:
        r6 = r8.height;
        r10 = -1;
        if (r6 != r10) goto L_0x01cb;
    L_0x01c8:
        r6 = r18;
        goto L_0x01cc;
    L_0x01cb:
        r6 = 0;
    L_0x01cc:
        r8 = r8.weight;
        r8 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1));
        if (r8 <= 0) goto L_0x01e2;
    L_0x01d2:
        if (r1 == 0) goto L_0x01d7;
    L_0x01d4:
        r8 = r25;
        goto L_0x01d9;
    L_0x01d7:
        r2 = r3;
        goto L_0x01d4;
    L_0x01d9:
        r25 = java.lang.Math.max(r8, r2);
        r8 = r25;
    L_0x01df:
        r10 = r34;
        goto L_0x01ee;
    L_0x01e2:
        r8 = r25;
        if (r1 == 0) goto L_0x01e7;
    L_0x01e6:
        r3 = r2;
    L_0x01e7:
        r2 = r24;
        r24 = java.lang.Math.max(r2, r3);
        goto L_0x01df;
    L_0x01ee:
        r1 = r7.getChildrenSkipCount(r12, r10);
        r1 = r1 + r10;
        r26 = r4;
        r22 = r5;
        r27 = r6;
        r25 = r8;
    L_0x01fb:
        r1 = r1 + 1;
        r2 = r0;
        r0 = r1;
        r6 = r29;
        r3 = r30;
        r4 = r32;
        r12 = r35;
        r5 = -1;
        r8 = r40;
        r10 = 0;
        goto L_0x0063;
    L_0x020d:
        r0 = r2;
        r30 = r3;
        r32 = r4;
        r35 = r12;
        r5 = r22;
        r2 = r24;
        r8 = r25;
        r10 = r26;
        r31 = -2;
        r3 = r7.mTotalLength;
        if (r3 <= 0) goto L_0x022f;
    L_0x0222:
        r3 = r7.hasDividerBeforeChildAt(r11);
        if (r3 == 0) goto L_0x022f;
    L_0x0228:
        r3 = r7.mTotalLength;
        r4 = r7.mDividerWidth;
        r3 = r3 + r4;
        r7.mTotalLength = r3;
    L_0x022f:
        r3 = r15[r18];
        r4 = -1;
        if (r3 != r4) goto L_0x0241;
    L_0x0234:
        r3 = 0;
        r6 = r15[r3];
        if (r6 != r4) goto L_0x0241;
    L_0x0239:
        r3 = r15[r17];
        if (r3 != r4) goto L_0x0241;
    L_0x023d:
        r3 = r15[r16];
        if (r3 == r4) goto L_0x0271;
    L_0x0241:
        r3 = r15[r16];
        r4 = 0;
        r6 = r15[r4];
        r12 = r15[r18];
        r0 = r15[r17];
        r0 = java.lang.Math.max(r12, r0);
        r0 = java.lang.Math.max(r6, r0);
        r0 = java.lang.Math.max(r3, r0);
        r3 = r29[r16];
        r6 = r29[r4];
        r4 = r29[r18];
        r12 = r29[r17];
        r4 = java.lang.Math.max(r4, r12);
        r4 = java.lang.Math.max(r6, r4);
        r3 = java.lang.Math.max(r3, r4);
        r0 = r0 + r3;
        r22 = java.lang.Math.max(r5, r0);
        r5 = r22;
    L_0x0271:
        if (r30 == 0) goto L_0x02d4;
    L_0x0273:
        r0 = r35;
        r3 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r0 == r3) goto L_0x027b;
    L_0x0279:
        if (r0 != 0) goto L_0x02d6;
    L_0x027b:
        r3 = 0;
        r7.mTotalLength = r3;
        r3 = 0;
    L_0x027f:
        if (r3 >= r11) goto L_0x02d6;
    L_0x0281:
        r4 = r7.getVirtualChildAt(r3);
        if (r4 != 0) goto L_0x0291;
    L_0x0287:
        r4 = r7.mTotalLength;
        r6 = r7.measureNullChild(r3);
        r4 = r4 + r6;
        r7.mTotalLength = r4;
        goto L_0x029c;
    L_0x0291:
        r6 = r4.getVisibility();
        if (r6 != r1) goto L_0x029f;
    L_0x0297:
        r4 = r7.getChildrenSkipCount(r4, r3);
        r3 = r3 + r4;
    L_0x029c:
        r36 = r3;
        goto L_0x02cf;
    L_0x029f:
        r6 = r4.getLayoutParams();
        r6 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r6;
        if (r19 == 0) goto L_0x02b8;
    L_0x02a7:
        r12 = r7.mTotalLength;
        r1 = r6.leftMargin;
        r1 = r1 + r14;
        r6 = r6.rightMargin;
        r1 = r1 + r6;
        r4 = r7.getNextLocationOffset(r4);
        r1 = r1 + r4;
        r12 = r12 + r1;
        r7.mTotalLength = r12;
        goto L_0x029c;
    L_0x02b8:
        r1 = r7.mTotalLength;
        r12 = r1 + r14;
        r36 = r3;
        r3 = r6.leftMargin;
        r12 = r12 + r3;
        r3 = r6.rightMargin;
        r12 = r12 + r3;
        r3 = r7.getNextLocationOffset(r4);
        r12 = r12 + r3;
        r1 = java.lang.Math.max(r1, r12);
        r7.mTotalLength = r1;
    L_0x02cf:
        r3 = r36 + 1;
        r1 = 8;
        goto L_0x027f;
    L_0x02d4:
        r0 = r35;
    L_0x02d6:
        r1 = r7.mTotalLength;
        r3 = r39.getPaddingLeft();
        r4 = r39.getPaddingRight();
        r3 = r3 + r4;
        r1 = r1 + r3;
        r7.mTotalLength = r1;
        r1 = r7.mTotalLength;
        r3 = r39.getSuggestedMinimumWidth();
        r1 = java.lang.Math.max(r1, r3);
        r3 = r40;
        r4 = 0;
        r1 = android.support.v4.view.ViewCompat.resolveSizeAndState(r1, r3, r4);
        r4 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        r4 = r4 & r1;
        r6 = r7.mTotalLength;
        r4 = r4 - r6;
        if (r23 != 0) goto L_0x0346;
    L_0x02fe:
        if (r4 == 0) goto L_0x0305;
    L_0x0300:
        r12 = (r21 > r20 ? 1 : (r21 == r20 ? 0 : -1));
        if (r12 <= 0) goto L_0x0305;
    L_0x0304:
        goto L_0x0346;
    L_0x0305:
        r2 = java.lang.Math.max(r2, r8);
        if (r30 == 0) goto L_0x0341;
    L_0x030b:
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r0 == r4) goto L_0x0341;
    L_0x030f:
        r0 = 0;
    L_0x0310:
        if (r0 >= r11) goto L_0x0341;
    L_0x0312:
        r4 = r7.getVirtualChildAt(r0);
        if (r4 == 0) goto L_0x033e;
    L_0x0318:
        r8 = r4.getVisibility();
        r12 = 8;
        if (r8 != r12) goto L_0x0321;
    L_0x0320:
        goto L_0x033e;
    L_0x0321:
        r8 = r4.getLayoutParams();
        r8 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r8;
        r8 = r8.weight;
        r8 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1));
        if (r8 <= 0) goto L_0x033e;
    L_0x032d:
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r12 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r8);
        r15 = r4.getMeasuredHeight();
        r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r8);
        r4.measure(r12, r15);
    L_0x033e:
        r0 = r0 + 1;
        goto L_0x0310;
    L_0x0341:
        r12 = r2;
        r37 = r11;
        goto L_0x04d2;
    L_0x0346:
        r5 = r7.mWeightSum;
        r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1));
        if (r5 <= 0) goto L_0x0350;
    L_0x034c:
        r5 = r7.mWeightSum;
    L_0x034e:
        r8 = -1;
        goto L_0x0353;
    L_0x0350:
        r5 = r21;
        goto L_0x034e;
    L_0x0353:
        r15[r16] = r8;
        r15[r17] = r8;
        r15[r18] = r8;
        r12 = 0;
        r15[r12] = r8;
        r29[r16] = r8;
        r29[r17] = r8;
        r29[r18] = r8;
        r29[r12] = r8;
        r7.mTotalLength = r12;
        r12 = r2;
        r2 = 0;
        r8 = -1;
    L_0x0369:
        if (r2 >= r11) goto L_0x047e;
    L_0x036b:
        r14 = r7.getVirtualChildAt(r2);
        if (r14 == 0) goto L_0x0472;
    L_0x0371:
        r6 = r14.getVisibility();
        r3 = 8;
        if (r6 != r3) goto L_0x037b;
    L_0x0379:
        goto L_0x0472;
    L_0x037b:
        r6 = r14.getLayoutParams();
        r6 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r6;
        r3 = r6.weight;
        r21 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1));
        if (r21 <= 0) goto L_0x03da;
    L_0x0387:
        r37 = r11;
        r11 = (float) r4;
        r11 = r11 * r3;
        r11 = r11 / r5;
        r11 = (int) r11;
        r5 = r5 - r3;
        r4 = r4 - r11;
        r3 = r39.getPaddingTop();
        r21 = r39.getPaddingBottom();
        r3 = r3 + r21;
        r38 = r4;
        r4 = r6.topMargin;
        r3 = r3 + r4;
        r4 = r6.bottomMargin;
        r3 = r3 + r4;
        r4 = r6.height;
        r3 = getChildMeasureSpec(r9, r3, r4);
        r4 = r6.width;
        if (r4 != 0) goto L_0x03bc;
    L_0x03ab:
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r0 == r4) goto L_0x03b0;
    L_0x03af:
        goto L_0x03be;
    L_0x03b0:
        if (r11 <= 0) goto L_0x03b3;
    L_0x03b2:
        goto L_0x03b4;
    L_0x03b3:
        r11 = 0;
    L_0x03b4:
        r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r4);
        r14.measure(r11, r3);
        goto L_0x03ce;
    L_0x03bc:
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x03be:
        r21 = r14.getMeasuredWidth();
        r11 = r21 + r11;
        if (r11 >= 0) goto L_0x03c7;
    L_0x03c6:
        r11 = 0;
    L_0x03c7:
        r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r4);
        r14.measure(r11, r3);
    L_0x03ce:
        r3 = android.support.v4.view.ViewCompat.getMeasuredState(r14);
        r4 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r3 = r3 & r4;
        r10 = android.support.v7.widget.ViewUtils.combineMeasuredStates(r10, r3);
        goto L_0x03de;
    L_0x03da:
        r37 = r11;
        r38 = r4;
    L_0x03de:
        if (r19 == 0) goto L_0x03f7;
    L_0x03e0:
        r3 = r7.mTotalLength;
        r4 = r14.getMeasuredWidth();
        r11 = r6.leftMargin;
        r4 = r4 + r11;
        r11 = r6.rightMargin;
        r4 = r4 + r11;
        r11 = r7.getNextLocationOffset(r14);
        r4 = r4 + r11;
        r3 = r3 + r4;
        r7.mTotalLength = r3;
    L_0x03f4:
        r3 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x0410;
    L_0x03f7:
        r3 = r7.mTotalLength;
        r4 = r14.getMeasuredWidth();
        r4 = r4 + r3;
        r11 = r6.leftMargin;
        r4 = r4 + r11;
        r11 = r6.rightMargin;
        r4 = r4 + r11;
        r11 = r7.getNextLocationOffset(r14);
        r4 = r4 + r11;
        r3 = java.lang.Math.max(r3, r4);
        r7.mTotalLength = r3;
        goto L_0x03f4;
    L_0x0410:
        if (r13 == r3) goto L_0x041a;
    L_0x0412:
        r3 = r6.height;
        r4 = -1;
        if (r3 != r4) goto L_0x041a;
    L_0x0417:
        r3 = r18;
        goto L_0x041b;
    L_0x041a:
        r3 = 0;
    L_0x041b:
        r4 = r6.topMargin;
        r11 = r6.bottomMargin;
        r4 = r4 + r11;
        r11 = r14.getMeasuredHeight();
        r11 = r11 + r4;
        r8 = java.lang.Math.max(r8, r11);
        if (r3 == 0) goto L_0x042c;
    L_0x042b:
        goto L_0x042d;
    L_0x042c:
        r4 = r11;
    L_0x042d:
        r3 = java.lang.Math.max(r12, r4);
        if (r27 == 0) goto L_0x043b;
    L_0x0433:
        r4 = r6.height;
        r12 = -1;
        if (r4 != r12) goto L_0x043c;
    L_0x0438:
        r4 = r18;
        goto L_0x043d;
    L_0x043b:
        r12 = -1;
    L_0x043c:
        r4 = 0;
    L_0x043d:
        if (r32 == 0) goto L_0x046a;
    L_0x043f:
        r14 = r14.getBaseline();
        if (r14 == r12) goto L_0x046a;
    L_0x0445:
        r12 = r6.gravity;
        if (r12 >= 0) goto L_0x044c;
    L_0x0449:
        r6 = r7.mGravity;
        goto L_0x044e;
    L_0x044c:
        r6 = r6.gravity;
    L_0x044e:
        r6 = r6 & 112;
        r21 = 4;
        r6 = r6 >> 4;
        r6 = r6 & -2;
        r6 = r6 >> 1;
        r12 = r15[r6];
        r12 = java.lang.Math.max(r12, r14);
        r15[r6] = r12;
        r12 = r29[r6];
        r11 = r11 - r14;
        r11 = java.lang.Math.max(r12, r11);
        r29[r6] = r11;
        goto L_0x046c;
    L_0x046a:
        r21 = 4;
    L_0x046c:
        r12 = r3;
        r27 = r4;
        r4 = r38;
        goto L_0x0476;
    L_0x0472:
        r37 = r11;
        r21 = 4;
    L_0x0476:
        r2 = r2 + 1;
        r11 = r37;
        r3 = r40;
        goto L_0x0369;
    L_0x047e:
        r37 = r11;
        r0 = r7.mTotalLength;
        r2 = r39.getPaddingLeft();
        r3 = r39.getPaddingRight();
        r2 = r2 + r3;
        r0 = r0 + r2;
        r7.mTotalLength = r0;
        r0 = r15[r18];
        r2 = -1;
        if (r0 != r2) goto L_0x04a3;
    L_0x0493:
        r0 = 0;
        r3 = r15[r0];
        if (r3 != r2) goto L_0x04a3;
    L_0x0498:
        r0 = r15[r17];
        if (r0 != r2) goto L_0x04a3;
    L_0x049c:
        r0 = r15[r16];
        if (r0 == r2) goto L_0x04a1;
    L_0x04a0:
        goto L_0x04a3;
    L_0x04a1:
        r5 = r8;
        goto L_0x04d2;
    L_0x04a3:
        r0 = r15[r16];
        r2 = 0;
        r3 = r15[r2];
        r4 = r15[r18];
        r5 = r15[r17];
        r4 = java.lang.Math.max(r4, r5);
        r3 = java.lang.Math.max(r3, r4);
        r0 = java.lang.Math.max(r0, r3);
        r3 = r29[r16];
        r2 = r29[r2];
        r4 = r29[r18];
        r5 = r29[r17];
        r4 = java.lang.Math.max(r4, r5);
        r2 = java.lang.Math.max(r2, r4);
        r2 = java.lang.Math.max(r3, r2);
        r0 = r0 + r2;
        r0 = java.lang.Math.max(r8, r0);
        r5 = r0;
    L_0x04d2:
        if (r27 != 0) goto L_0x04d9;
    L_0x04d4:
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r13 == r0) goto L_0x04d9;
    L_0x04d8:
        goto L_0x04da;
    L_0x04d9:
        r12 = r5;
    L_0x04da:
        r0 = r39.getPaddingTop();
        r2 = r39.getPaddingBottom();
        r0 = r0 + r2;
        r12 = r12 + r0;
        r0 = r39.getSuggestedMinimumHeight();
        r0 = java.lang.Math.max(r12, r0);
        r2 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r2 = r2 & r10;
        r1 = r1 | r2;
        r2 = r10 << 16;
        r0 = android.support.v4.view.ViewCompat.resolveSizeAndState(r0, r9, r2);
        r7.setMeasuredDimension(r1, r0);
        if (r28 == 0) goto L_0x0502;
    L_0x04fb:
        r1 = r37;
        r0 = r40;
        r7.forceUniformHeight(r1, r0);
    L_0x0502:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.measureHorizontal(int, int):void");
    }

    /* Access modifiers changed, original: 0000 */
    public int measureNullChild(int i) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0337  */
    public void measureVertical(int r40, int r41) {
        /*
        r39 = this;
        r7 = r39;
        r8 = r40;
        r9 = r41;
        r10 = 0;
        r7.mTotalLength = r10;
        r11 = r39.getVirtualChildCount();
        r12 = android.view.View.MeasureSpec.getMode(r40);
        r13 = android.view.View.MeasureSpec.getMode(r41);
        r14 = r7.mBaselineAlignedChildIndex;
        r15 = r7.mUseLargestChild;
        r16 = 0;
        r17 = 1;
        r1 = r10;
        r3 = r1;
        r5 = r3;
        r18 = r5;
        r20 = r18;
        r21 = r20;
        r0 = r16;
        r19 = r17;
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x002c:
        if (r5 >= r11) goto L_0x01a6;
    L_0x002e:
        r4 = r7.getVirtualChildAt(r5);
        if (r4 != 0) goto L_0x0047;
    L_0x0034:
        r4 = r7.mTotalLength;
        r22 = r7.measureNullChild(r5);
        r4 = r4 + r22;
        r7.mTotalLength = r4;
        r4 = r10;
        r31 = r11;
        r28 = r13;
    L_0x0043:
        r10 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        goto L_0x0199;
    L_0x0047:
        r6 = r4.getVisibility();
        r25 = r1;
        r1 = 8;
        if (r6 != r1) goto L_0x005e;
    L_0x0051:
        r1 = r7.getChildrenSkipCount(r4, r5);
        r5 = r5 + r1;
        r4 = r10;
        r31 = r11;
        r28 = r13;
        r1 = r25;
        goto L_0x0043;
    L_0x005e:
        r1 = r7.hasDividerBeforeChildAt(r5);
        if (r1 == 0) goto L_0x006b;
    L_0x0064:
        r1 = r7.mTotalLength;
        r6 = r7.mDividerHeight;
        r1 = r1 + r6;
        r7.mTotalLength = r1;
    L_0x006b:
        r1 = r4.getLayoutParams();
        r6 = r1;
        r6 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r6;
        r1 = r6.weight;
        r23 = r0 + r1;
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r13 != r1) goto L_0x00a9;
    L_0x007a:
        r0 = r6.height;
        if (r0 != 0) goto L_0x00a9;
    L_0x007e:
        r0 = r6.weight;
        r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1));
        if (r0 <= 0) goto L_0x00a9;
    L_0x0084:
        r0 = r7.mTotalLength;
        r1 = r6.topMargin;
        r1 = r1 + r0;
        r26 = r2;
        r2 = r6.bottomMargin;
        r1 = r1 + r2;
        r0 = java.lang.Math.max(r0, r1);
        r7.mTotalLength = r0;
        r33 = r3;
        r8 = r4;
        r9 = r6;
        r34 = r10;
        r31 = r11;
        r28 = r13;
        r18 = r17;
        r32 = r21;
        r13 = r25;
        r10 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r11 = r5;
        goto L_0x011d;
    L_0x00a9:
        r26 = r2;
        r0 = r6.height;
        if (r0 != 0) goto L_0x00ba;
    L_0x00af:
        r0 = r6.weight;
        r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1));
        if (r0 <= 0) goto L_0x00ba;
    L_0x00b5:
        r0 = -2;
        r6.height = r0;
        r2 = 0;
        goto L_0x00bc;
    L_0x00ba:
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x00bc:
        r24 = 0;
        r0 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1));
        if (r0 != 0) goto L_0x00c7;
    L_0x00c2:
        r0 = r7.mTotalLength;
        r27 = r0;
        goto L_0x00c9;
    L_0x00c7:
        r27 = 0;
    L_0x00c9:
        r0 = r7;
        r28 = r13;
        r13 = r25;
        r25 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = r4;
        r29 = r2;
        r30 = r26;
        r2 = r5;
        r31 = r11;
        r11 = r3;
        r3 = r8;
        r8 = r4;
        r33 = r11;
        r32 = r21;
        r11 = r25;
        r4 = r24;
        r11 = r5;
        r5 = r9;
        r9 = r6;
        r34 = r10;
        r10 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r6 = r27;
        r0.measureChildBeforeLayout(r1, r2, r3, r4, r5, r6);
        r0 = r29;
        if (r0 == r10) goto L_0x00f5;
    L_0x00f3:
        r9.height = r0;
    L_0x00f5:
        r0 = r8.getMeasuredHeight();
        r1 = r7.mTotalLength;
        r2 = r1 + r0;
        r3 = r9.topMargin;
        r2 = r2 + r3;
        r3 = r9.bottomMargin;
        r2 = r2 + r3;
        r3 = r7.getNextLocationOffset(r8);
        r2 = r2 + r3;
        r1 = java.lang.Math.max(r1, r2);
        r7.mTotalLength = r1;
        if (r15 == 0) goto L_0x0119;
    L_0x0110:
        r6 = r30;
        r2 = java.lang.Math.max(r0, r6);
        r26 = r2;
        goto L_0x011d;
    L_0x0119:
        r6 = r30;
        r26 = r6;
    L_0x011d:
        if (r14 < 0) goto L_0x0127;
    L_0x011f:
        r5 = r11 + 1;
        if (r14 != r5) goto L_0x0127;
    L_0x0123:
        r0 = r7.mTotalLength;
        r7.mBaselineChildTop = r0;
    L_0x0127:
        if (r11 >= r14) goto L_0x0137;
    L_0x0129:
        r0 = r9.weight;
        r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1));
        if (r0 <= 0) goto L_0x0137;
    L_0x012f:
        r0 = new java.lang.RuntimeException;
        r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.";
        r0.<init>(r1);
        throw r0;
    L_0x0137:
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 == r0) goto L_0x0145;
    L_0x013b:
        r0 = r9.width;
        r1 = -1;
        if (r0 != r1) goto L_0x0146;
    L_0x0140:
        r0 = r17;
        r20 = r0;
        goto L_0x0147;
    L_0x0145:
        r1 = -1;
    L_0x0146:
        r0 = 0;
    L_0x0147:
        r2 = r9.leftMargin;
        r3 = r9.rightMargin;
        r2 = r2 + r3;
        r3 = r8.getMeasuredWidth();
        r3 = r3 + r2;
        r4 = java.lang.Math.max(r13, r3);
        r5 = android.support.v4.view.ViewCompat.getMeasuredState(r8);
        r6 = r34;
        r5 = android.support.v7.widget.ViewUtils.combineMeasuredStates(r6, r5);
        if (r19 == 0) goto L_0x0168;
    L_0x0161:
        r6 = r9.width;
        if (r6 != r1) goto L_0x0168;
    L_0x0165:
        r1 = r17;
        goto L_0x0169;
    L_0x0168:
        r1 = 0;
    L_0x0169:
        r6 = r9.weight;
        r6 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1));
        if (r6 <= 0) goto L_0x017b;
    L_0x016f:
        if (r0 == 0) goto L_0x0174;
    L_0x0171:
        r9 = r33;
        goto L_0x0176;
    L_0x0174:
        r2 = r3;
        goto L_0x0171;
    L_0x0176:
        r3 = java.lang.Math.max(r9, r2);
        goto L_0x0189;
    L_0x017b:
        r9 = r33;
        if (r0 == 0) goto L_0x0180;
    L_0x017f:
        r3 = r2;
    L_0x0180:
        r2 = r32;
        r21 = java.lang.Math.max(r2, r3);
        r3 = r9;
        r32 = r21;
    L_0x0189:
        r0 = r7.getChildrenSkipCount(r8, r11);
        r0 = r0 + r11;
        r19 = r1;
        r1 = r4;
        r4 = r5;
        r2 = r26;
        r21 = r32;
        r5 = r0;
        r0 = r23;
    L_0x0199:
        r5 = r5 + 1;
        r10 = r4;
        r13 = r28;
        r11 = r31;
        r8 = r40;
        r9 = r41;
        goto L_0x002c;
    L_0x01a6:
        r6 = r2;
        r9 = r3;
        r4 = r10;
        r31 = r11;
        r28 = r13;
        r2 = r21;
        r10 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r13 = r1;
        r1 = -1;
        r3 = r7.mTotalLength;
        if (r3 <= 0) goto L_0x01c7;
    L_0x01b7:
        r3 = r31;
        r5 = r7.hasDividerBeforeChildAt(r3);
        if (r5 == 0) goto L_0x01c9;
    L_0x01bf:
        r5 = r7.mTotalLength;
        r8 = r7.mDividerHeight;
        r5 = r5 + r8;
        r7.mTotalLength = r5;
        goto L_0x01c9;
    L_0x01c7:
        r3 = r31;
    L_0x01c9:
        if (r15 == 0) goto L_0x0217;
    L_0x01cb:
        r5 = r28;
        if (r5 == r10) goto L_0x01d1;
    L_0x01cf:
        if (r5 != 0) goto L_0x0219;
    L_0x01d1:
        r8 = 0;
        r7.mTotalLength = r8;
        r8 = 0;
    L_0x01d5:
        if (r8 >= r3) goto L_0x0219;
    L_0x01d7:
        r10 = r7.getVirtualChildAt(r8);
        if (r10 != 0) goto L_0x01e7;
    L_0x01dd:
        r10 = r7.mTotalLength;
        r11 = r7.measureNullChild(r8);
        r10 = r10 + r11;
        r7.mTotalLength = r10;
        goto L_0x0213;
    L_0x01e7:
        r11 = r10.getVisibility();
        r14 = 8;
        if (r11 != r14) goto L_0x01f5;
    L_0x01ef:
        r10 = r7.getChildrenSkipCount(r10, r8);
        r8 = r8 + r10;
        goto L_0x0213;
    L_0x01f5:
        r11 = r10.getLayoutParams();
        r11 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r11;
        r14 = r7.mTotalLength;
        r21 = r14 + r6;
        r1 = r11.topMargin;
        r21 = r21 + r1;
        r1 = r11.bottomMargin;
        r21 = r21 + r1;
        r1 = r7.getNextLocationOffset(r10);
        r1 = r21 + r1;
        r1 = java.lang.Math.max(r14, r1);
        r7.mTotalLength = r1;
    L_0x0213:
        r8 = r8 + 1;
        r1 = -1;
        goto L_0x01d5;
    L_0x0217:
        r5 = r28;
    L_0x0219:
        r1 = r7.mTotalLength;
        r8 = r39.getPaddingTop();
        r10 = r39.getPaddingBottom();
        r8 = r8 + r10;
        r1 = r1 + r8;
        r7.mTotalLength = r1;
        r1 = r7.mTotalLength;
        r8 = r39.getSuggestedMinimumHeight();
        r1 = java.lang.Math.max(r1, r8);
        r8 = r41;
        r10 = 0;
        r1 = android.support.v4.view.ViewCompat.resolveSizeAndState(r1, r8, r10);
        r10 = 16777215; // 0xffffff float:2.3509886E-38 double:8.2890456E-317;
        r10 = r10 & r1;
        r11 = r7.mTotalLength;
        r10 = r10 - r11;
        if (r18 != 0) goto L_0x0288;
    L_0x0241:
        if (r10 == 0) goto L_0x0248;
    L_0x0243:
        r11 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1));
        if (r11 <= 0) goto L_0x0248;
    L_0x0247:
        goto L_0x0288;
    L_0x0248:
        r0 = java.lang.Math.max(r2, r9);
        if (r15 == 0) goto L_0x0284;
    L_0x024e:
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r5 == r2) goto L_0x0284;
    L_0x0252:
        r2 = 0;
    L_0x0253:
        if (r2 >= r3) goto L_0x0284;
    L_0x0255:
        r5 = r7.getVirtualChildAt(r2);
        if (r5 == 0) goto L_0x0281;
    L_0x025b:
        r9 = r5.getVisibility();
        r10 = 8;
        if (r9 != r10) goto L_0x0264;
    L_0x0263:
        goto L_0x0281;
    L_0x0264:
        r9 = r5.getLayoutParams();
        r9 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r9;
        r9 = r9.weight;
        r9 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1));
        if (r9 <= 0) goto L_0x0281;
    L_0x0270:
        r9 = r5.getMeasuredWidth();
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10);
        r11 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r10);
        r5.measure(r9, r11);
    L_0x0281:
        r2 = r2 + 1;
        goto L_0x0253;
    L_0x0284:
        r9 = r40;
        goto L_0x0380;
    L_0x0288:
        r6 = r7.mWeightSum;
        r6 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1));
        if (r6 <= 0) goto L_0x0290;
    L_0x028e:
        r0 = r7.mWeightSum;
    L_0x0290:
        r6 = 0;
        r7.mTotalLength = r6;
        r9 = r0;
        r0 = r6;
        r38 = r10;
        r10 = r4;
        r4 = r38;
    L_0x029a:
        if (r0 >= r3) goto L_0x036e;
    L_0x029c:
        r11 = r7.getVirtualChildAt(r0);
        r14 = r11.getVisibility();
        r15 = 8;
        if (r14 != r15) goto L_0x02ae;
    L_0x02a8:
        r36 = r9;
        r9 = r40;
        goto L_0x0367;
    L_0x02ae:
        r14 = r11.getLayoutParams();
        r14 = (android.support.v7.widget.LinearLayoutCompat.LayoutParams) r14;
        r6 = r14.weight;
        r18 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1));
        if (r18 <= 0) goto L_0x030e;
    L_0x02ba:
        r15 = (float) r4;
        r15 = r15 * r6;
        r15 = r15 / r9;
        r15 = (int) r15;
        r9 = r9 - r6;
        r4 = r4 - r15;
        r6 = r39.getPaddingLeft();
        r18 = r39.getPaddingRight();
        r6 = r6 + r18;
        r35 = r4;
        r4 = r14.leftMargin;
        r6 = r6 + r4;
        r4 = r14.rightMargin;
        r6 = r6 + r4;
        r4 = r14.width;
        r36 = r9;
        r9 = r40;
        r4 = getChildMeasureSpec(r9, r6, r4);
        r6 = r14.height;
        if (r6 != 0) goto L_0x02f1;
    L_0x02e0:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r5 == r6) goto L_0x02e5;
    L_0x02e4:
        goto L_0x02f3;
    L_0x02e5:
        if (r15 <= 0) goto L_0x02e8;
    L_0x02e7:
        goto L_0x02e9;
    L_0x02e8:
        r15 = 0;
    L_0x02e9:
        r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r6);
        r11.measure(r4, r15);
        goto L_0x0303;
    L_0x02f1:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x02f3:
        r18 = r11.getMeasuredHeight();
        r15 = r18 + r15;
        if (r15 >= 0) goto L_0x02fc;
    L_0x02fb:
        r15 = 0;
    L_0x02fc:
        r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r6);
        r11.measure(r4, r15);
    L_0x0303:
        r4 = android.support.v4.view.ViewCompat.getMeasuredState(r11);
        r4 = r4 & -256;
        r10 = android.support.v7.widget.ViewUtils.combineMeasuredStates(r10, r4);
        goto L_0x0315;
    L_0x030e:
        r6 = r9;
        r9 = r40;
        r35 = r4;
        r36 = r6;
    L_0x0315:
        r4 = r14.leftMargin;
        r6 = r14.rightMargin;
        r4 = r4 + r6;
        r6 = r11.getMeasuredWidth();
        r6 = r6 + r4;
        r13 = java.lang.Math.max(r13, r6);
        r15 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 == r15) goto L_0x0331;
    L_0x0327:
        r15 = r14.width;
        r37 = r4;
        r4 = -1;
        if (r15 != r4) goto L_0x0334;
    L_0x032e:
        r15 = r17;
        goto L_0x0335;
    L_0x0331:
        r37 = r4;
        r4 = -1;
    L_0x0334:
        r15 = 0;
    L_0x0335:
        if (r15 == 0) goto L_0x0339;
    L_0x0337:
        r6 = r37;
    L_0x0339:
        r2 = java.lang.Math.max(r2, r6);
        if (r19 == 0) goto L_0x0346;
    L_0x033f:
        r6 = r14.width;
        if (r6 != r4) goto L_0x0346;
    L_0x0343:
        r6 = r17;
        goto L_0x0347;
    L_0x0346:
        r6 = 0;
    L_0x0347:
        r15 = r7.mTotalLength;
        r18 = r11.getMeasuredHeight();
        r18 = r15 + r18;
        r4 = r14.topMargin;
        r18 = r18 + r4;
        r4 = r14.bottomMargin;
        r18 = r18 + r4;
        r4 = r7.getNextLocationOffset(r11);
        r4 = r18 + r4;
        r4 = java.lang.Math.max(r15, r4);
        r7.mTotalLength = r4;
        r19 = r6;
        r4 = r35;
    L_0x0367:
        r0 = r0 + 1;
        r9 = r36;
        r6 = 0;
        goto L_0x029a;
    L_0x036e:
        r9 = r40;
        r0 = r7.mTotalLength;
        r4 = r39.getPaddingTop();
        r5 = r39.getPaddingBottom();
        r4 = r4 + r5;
        r0 = r0 + r4;
        r7.mTotalLength = r0;
        r0 = r2;
        r4 = r10;
    L_0x0380:
        if (r19 != 0) goto L_0x0387;
    L_0x0382:
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 == r2) goto L_0x0387;
    L_0x0386:
        r13 = r0;
    L_0x0387:
        r0 = r39.getPaddingLeft();
        r2 = r39.getPaddingRight();
        r0 = r0 + r2;
        r13 = r13 + r0;
        r0 = r39.getSuggestedMinimumWidth();
        r0 = java.lang.Math.max(r13, r0);
        r0 = android.support.v4.view.ViewCompat.resolveSizeAndState(r0, r9, r4);
        r7.setMeasuredDimension(r0, r1);
        if (r20 == 0) goto L_0x03a5;
    L_0x03a2:
        r7.forceUniformWidth(r3, r8);
    L_0x03a5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutCompat.measureVertical(int, int):void");
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("base aligned child index out of range (0, ");
            stringBuilder.append(getChildCount());
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            boolean z = false;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        i &= GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if ((GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK & this.mGravity) != i) {
            this.mGravity = i | (this.mGravity & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        i &= 112;
        if ((this.mGravity & 112) != i) {
            this.mGravity = i | (this.mGravity & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
