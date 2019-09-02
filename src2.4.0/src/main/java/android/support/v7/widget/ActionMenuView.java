package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat implements ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    @RestrictTo({Scope.LIBRARY_GROUP})
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    private class ActionMenuPresenterCallback implements Callback {
        ActionMenuPresenterCallback() {
        }

        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        }

        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.LinearLayoutCompat.LayoutParams {
        @ExportedProperty
        public int cellsUsed;
        @ExportedProperty
        public boolean expandable;
        boolean expanded;
        @ExportedProperty
        public int extraPixels;
        @ExportedProperty
        public boolean isOverflowButton;
        @ExportedProperty
        public boolean preventEdgeOffset;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isOverflowButton = false;
        }

        LayoutParams(int i, int i2, boolean z) {
            super(i, i2);
            this.isOverflowButton = z;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((android.view.ViewGroup.LayoutParams) layoutParams);
            this.isOverflowButton = layoutParams.isOverflowButton;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.mOnMenuItemClickListener != null && ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
        }

        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.mMenuBuilderCallback != null) {
                ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f);
        this.mGeneratedItemPadding = (int) (4.0f * f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    static int measureChildForCells(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        i3 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.hasText();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), i3);
            i2 = view.getMeasuredWidth();
            int i6 = i2 / i;
            if (i2 % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (!layoutParams.isOverflowButton && z2) {
            z = true;
        }
        layoutParams.expandable = z;
        layoutParams.cellsUsed = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i * i5, 1073741824), i3);
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:133:0x0267 A:{LOOP_START, LOOP:5: B:133:0x0267->B:138:0x0289, PHI: r3 r32 } */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0290  */
    private void onMeasureExactFormat(int r35, int r36) {
        /*
        r34 = this;
        r0 = r34;
        r1 = android.view.View.MeasureSpec.getMode(r36);
        r2 = android.view.View.MeasureSpec.getSize(r35);
        r3 = android.view.View.MeasureSpec.getSize(r36);
        r4 = r34.getPaddingLeft();
        r5 = r34.getPaddingRight();
        r4 = r4 + r5;
        r5 = r34.getPaddingTop();
        r6 = r34.getPaddingBottom();
        r5 = r5 + r6;
        r6 = -2;
        r7 = r36;
        r6 = getChildMeasureSpec(r7, r5, r6);
        r2 = r2 - r4;
        r4 = r0.mMinCellSize;
        r4 = r2 / r4;
        r7 = r0.mMinCellSize;
        r7 = r2 % r7;
        r8 = 0;
        if (r4 != 0) goto L_0x0037;
    L_0x0033:
        r0.setMeasuredDimension(r2, r8);
        return;
    L_0x0037:
        r9 = r0.mMinCellSize;
        r7 = r7 / r4;
        r9 = r9 + r7;
        r7 = r34.getChildCount();
        r14 = r4;
        r4 = r8;
        r10 = r4;
        r12 = r10;
        r13 = r12;
        r15 = r13;
        r16 = r15;
        r19 = 0;
    L_0x0049:
        if (r4 >= r7) goto L_0x00da;
    L_0x004b:
        r11 = r0.getChildAt(r4);
        r8 = r11.getVisibility();
        r21 = r3;
        r3 = 8;
        if (r8 != r3) goto L_0x005d;
    L_0x0059:
        r23 = r2;
        goto L_0x00d1;
    L_0x005d:
        r3 = r11 instanceof android.support.v7.view.menu.ActionMenuItemView;
        r13 = r13 + 1;
        if (r3 == 0) goto L_0x0070;
    L_0x0063:
        r8 = r0.mGeneratedItemPadding;
        r22 = r13;
        r13 = r0.mGeneratedItemPadding;
        r23 = r2;
        r2 = 0;
        r11.setPadding(r8, r2, r13, r2);
        goto L_0x0075;
    L_0x0070:
        r23 = r2;
        r22 = r13;
        r2 = 0;
    L_0x0075:
        r8 = r11.getLayoutParams();
        r8 = (android.support.v7.widget.ActionMenuView.LayoutParams) r8;
        r8.expanded = r2;
        r8.extraPixels = r2;
        r8.cellsUsed = r2;
        r8.expandable = r2;
        r8.leftMargin = r2;
        r8.rightMargin = r2;
        if (r3 == 0) goto L_0x0094;
    L_0x0089:
        r2 = r11;
        r2 = (android.support.v7.view.menu.ActionMenuItemView) r2;
        r2 = r2.hasText();
        if (r2 == 0) goto L_0x0094;
    L_0x0092:
        r2 = 1;
        goto L_0x0095;
    L_0x0094:
        r2 = 0;
    L_0x0095:
        r8.preventEdgeOffset = r2;
        r2 = r8.isOverflowButton;
        if (r2 == 0) goto L_0x009d;
    L_0x009b:
        r2 = 1;
        goto L_0x009e;
    L_0x009d:
        r2 = r14;
    L_0x009e:
        r2 = measureChildForCells(r11, r9, r2, r6, r5);
        r3 = java.lang.Math.max(r15, r2);
        r13 = r8.expandable;
        if (r13 == 0) goto L_0x00ac;
    L_0x00aa:
        r16 = r16 + 1;
    L_0x00ac:
        r8 = r8.isOverflowButton;
        if (r8 == 0) goto L_0x00b1;
    L_0x00b0:
        r12 = 1;
    L_0x00b1:
        r14 = r14 - r2;
        r8 = r11.getMeasuredHeight();
        r10 = java.lang.Math.max(r10, r8);
        r8 = 1;
        if (r2 != r8) goto L_0x00cb;
    L_0x00bd:
        r2 = r8 << r4;
        r24 = r3;
        r2 = (long) r2;
        r25 = r19 | r2;
        r13 = r22;
        r15 = r24;
        r19 = r25;
        goto L_0x00d1;
    L_0x00cb:
        r24 = r3;
        r13 = r22;
        r15 = r24;
    L_0x00d1:
        r4 = r4 + 1;
        r3 = r21;
        r2 = r23;
        r8 = 0;
        goto L_0x0049;
    L_0x00da:
        r23 = r2;
        r21 = r3;
        r2 = 2;
        if (r12 == 0) goto L_0x00e5;
    L_0x00e1:
        if (r13 != r2) goto L_0x00e5;
    L_0x00e3:
        r3 = 1;
        goto L_0x00e6;
    L_0x00e5:
        r3 = 0;
    L_0x00e6:
        r4 = 0;
    L_0x00e7:
        if (r16 <= 0) goto L_0x0192;
    L_0x00e9:
        if (r14 <= 0) goto L_0x0192;
    L_0x00eb:
        r5 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r11 = r5;
        r5 = 0;
        r8 = 0;
        r24 = 0;
    L_0x00f3:
        if (r5 >= r7) goto L_0x012f;
    L_0x00f5:
        r2 = r0.getChildAt(r5);
        r2 = r2.getLayoutParams();
        r2 = (android.support.v7.widget.ActionMenuView.LayoutParams) r2;
        r27 = r4;
        r4 = r2.expandable;
        if (r4 != 0) goto L_0x0108;
    L_0x0105:
        r28 = r5;
        goto L_0x0129;
    L_0x0108:
        r4 = r2.cellsUsed;
        if (r4 >= r11) goto L_0x0119;
    L_0x010c:
        r2 = r2.cellsUsed;
        r4 = 1;
        r8 = r4 << r5;
        r28 = r5;
        r4 = (long) r8;
        r11 = r2;
        r24 = r4;
        r8 = 1;
        goto L_0x0129;
    L_0x0119:
        r28 = r5;
        r2 = r2.cellsUsed;
        if (r2 != r11) goto L_0x0129;
    L_0x011f:
        r2 = 1;
        r4 = r2 << r28;
        r4 = (long) r4;
        r29 = r24 | r4;
        r8 = r8 + 1;
        r24 = r29;
    L_0x0129:
        r5 = r28 + 1;
        r4 = r27;
        r2 = 2;
        goto L_0x00f3;
    L_0x012f:
        r27 = r4;
        r4 = r19 | r24;
        if (r8 <= r14) goto L_0x013c;
    L_0x0135:
        r32 = r6;
        r33 = r7;
        r31 = r10;
        goto L_0x019c;
    L_0x013c:
        r11 = r11 + 1;
        r19 = r4;
        r2 = 0;
    L_0x0141:
        if (r2 >= r7) goto L_0x018e;
    L_0x0143:
        r4 = r0.getChildAt(r2);
        r5 = r4.getLayoutParams();
        r5 = (android.support.v7.widget.ActionMenuView.LayoutParams) r5;
        r31 = r10;
        r8 = 1;
        r10 = r8 << r2;
        r32 = r6;
        r33 = r7;
        r6 = (long) r10;
        r27 = r24 & r6;
        r17 = 0;
        r8 = (r27 > r17 ? 1 : (r27 == r17 ? 0 : -1));
        if (r8 != 0) goto L_0x0168;
    L_0x015f:
        r4 = r5.cellsUsed;
        if (r4 != r11) goto L_0x0185;
    L_0x0163:
        r4 = r19 | r6;
        r19 = r4;
        goto L_0x0185;
    L_0x0168:
        if (r3 == 0) goto L_0x017b;
    L_0x016a:
        r6 = r5.preventEdgeOffset;
        if (r6 == 0) goto L_0x017b;
    L_0x016e:
        r6 = 1;
        if (r14 != r6) goto L_0x017c;
    L_0x0171:
        r7 = r0.mGeneratedItemPadding;
        r7 = r7 + r9;
        r8 = r0.mGeneratedItemPadding;
        r10 = 0;
        r4.setPadding(r7, r10, r8, r10);
        goto L_0x017c;
    L_0x017b:
        r6 = 1;
    L_0x017c:
        r4 = r5.cellsUsed;
        r4 = r4 + r6;
        r5.cellsUsed = r4;
        r5.expanded = r6;
        r14 = r14 + -1;
    L_0x0185:
        r2 = r2 + 1;
        r10 = r31;
        r6 = r32;
        r7 = r33;
        goto L_0x0141;
    L_0x018e:
        r2 = 2;
        r4 = 1;
        goto L_0x00e7;
    L_0x0192:
        r27 = r4;
        r32 = r6;
        r33 = r7;
        r31 = r10;
        r4 = r19;
    L_0x019c:
        if (r12 != 0) goto L_0x01a3;
    L_0x019e:
        r2 = 1;
        if (r13 != r2) goto L_0x01a4;
    L_0x01a1:
        r3 = r2;
        goto L_0x01a5;
    L_0x01a3:
        r2 = 1;
    L_0x01a4:
        r3 = 0;
    L_0x01a5:
        if (r14 <= 0) goto L_0x025e;
    L_0x01a7:
        r6 = 0;
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x025e;
    L_0x01ad:
        r13 = r13 - r2;
        if (r14 < r13) goto L_0x01b4;
    L_0x01b0:
        if (r3 != 0) goto L_0x01b4;
    L_0x01b2:
        if (r15 <= r2) goto L_0x025e;
    L_0x01b4:
        r2 = java.lang.Long.bitCount(r4);
        r2 = (float) r2;
        if (r3 != 0) goto L_0x01f7;
    L_0x01bb:
        r6 = 1;
        r10 = r4 & r6;
        r6 = 0;
        r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        if (r3 == 0) goto L_0x01d8;
    L_0x01c7:
        r3 = 0;
        r7 = r0.getChildAt(r3);
        r7 = r7.getLayoutParams();
        r7 = (android.support.v7.widget.ActionMenuView.LayoutParams) r7;
        r7 = r7.preventEdgeOffset;
        if (r7 != 0) goto L_0x01d9;
    L_0x01d6:
        r2 = r2 - r6;
        goto L_0x01d9;
    L_0x01d8:
        r3 = 0;
    L_0x01d9:
        r7 = r33 + -1;
        r8 = 1;
        r10 = r8 << r7;
        r10 = (long) r10;
        r12 = r4 & r10;
        r10 = 0;
        r8 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r8 == 0) goto L_0x01f8;
    L_0x01e7:
        r7 = r0.getChildAt(r7);
        r7 = r7.getLayoutParams();
        r7 = (android.support.v7.widget.ActionMenuView.LayoutParams) r7;
        r7 = r7.preventEdgeOffset;
        if (r7 != 0) goto L_0x01f8;
    L_0x01f5:
        r2 = r2 - r6;
        goto L_0x01f8;
    L_0x01f7:
        r3 = 0;
    L_0x01f8:
        r6 = 0;
        r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x0202;
    L_0x01fd:
        r14 = r14 * r9;
        r6 = (float) r14;
        r6 = r6 / r2;
        r8 = (int) r6;
        goto L_0x0203;
    L_0x0202:
        r8 = r3;
    L_0x0203:
        r6 = r3;
        r11 = r27;
        r2 = r33;
    L_0x0208:
        if (r6 >= r2) goto L_0x0263;
    L_0x020a:
        r7 = 1;
        r10 = r7 << r6;
        r12 = (long) r10;
        r14 = r4 & r12;
        r12 = 0;
        r7 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1));
        if (r7 != 0) goto L_0x0219;
    L_0x0216:
        r7 = 1;
        r14 = 2;
        goto L_0x025b;
    L_0x0219:
        r7 = r0.getChildAt(r6);
        r10 = r7.getLayoutParams();
        r10 = (android.support.v7.widget.ActionMenuView.LayoutParams) r10;
        r7 = r7 instanceof android.support.v7.view.menu.ActionMenuItemView;
        if (r7 == 0) goto L_0x023c;
    L_0x0227:
        r10.extraPixels = r8;
        r7 = 1;
        r10.expanded = r7;
        if (r6 != 0) goto L_0x0238;
    L_0x022e:
        r7 = r10.preventEdgeOffset;
        if (r7 != 0) goto L_0x0238;
    L_0x0232:
        r7 = -r8;
        r14 = 2;
        r7 = r7 / r14;
        r10.leftMargin = r7;
        goto L_0x0239;
    L_0x0238:
        r14 = 2;
    L_0x0239:
        r7 = 1;
        r11 = 1;
        goto L_0x025b;
    L_0x023c:
        r14 = 2;
        r7 = r10.isOverflowButton;
        if (r7 == 0) goto L_0x024c;
    L_0x0241:
        r10.extraPixels = r8;
        r7 = 1;
        r10.expanded = r7;
        r11 = -r8;
        r11 = r11 / r14;
        r10.rightMargin = r11;
        r11 = r7;
        goto L_0x025b;
    L_0x024c:
        r7 = 1;
        if (r6 == 0) goto L_0x0253;
    L_0x024f:
        r15 = r8 / 2;
        r10.leftMargin = r15;
    L_0x0253:
        r15 = r2 + -1;
        if (r6 == r15) goto L_0x025b;
    L_0x0257:
        r15 = r8 / 2;
        r10.rightMargin = r15;
    L_0x025b:
        r6 = r6 + 1;
        goto L_0x0208;
    L_0x025e:
        r2 = r33;
        r3 = 0;
        r11 = r27;
    L_0x0263:
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r11 == 0) goto L_0x028e;
    L_0x0267:
        if (r3 >= r2) goto L_0x028e;
    L_0x0269:
        r5 = r0.getChildAt(r3);
        r6 = r5.getLayoutParams();
        r6 = (android.support.v7.widget.ActionMenuView.LayoutParams) r6;
        r7 = r6.expanded;
        if (r7 != 0) goto L_0x027a;
    L_0x0277:
        r7 = r32;
        goto L_0x0289;
    L_0x027a:
        r7 = r6.cellsUsed;
        r7 = r7 * r9;
        r6 = r6.extraPixels;
        r7 = r7 + r6;
        r6 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r4);
        r7 = r32;
        r5.measure(r6, r7);
    L_0x0289:
        r3 = r3 + 1;
        r32 = r7;
        goto L_0x0267;
    L_0x028e:
        if (r1 == r4) goto L_0x0295;
    L_0x0290:
        r2 = r23;
        r1 = r31;
        goto L_0x0299;
    L_0x0295:
        r1 = r21;
        r2 = r23;
    L_0x0299:
        r0.setMeasuredDimension(r2, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionMenuView.onMeasureExactFormat(int, int):void");
    }

    /* Access modifiers changed, original: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public void dismissPopupMenus() {
        if (this.mPresenter != null) {
            this.mPresenter.dismissPopupMenus();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.isOverflowButton = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            this.mMenu = new MenuBuilder(context);
            this.mMenu.setCallback(new MenuBuilderCallback());
            this.mPresenter = new ActionMenuPresenter(context);
            this.mPresenter.setReserveOverflow(true);
            this.mPresenter.setCallback(this.mActionMenuPresenterCallback != null ? this.mActionMenuPresenterCallback : new ActionMenuPresenterCallback());
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.setMenuView(this);
        }
        return this.mMenu;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int getWindowAnimations() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean hasSupportDividerBeforeChildAt(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = 0 | ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        if (i > 0 && (childAt2 instanceof ActionMenuChildView)) {
            z |= ((ActionMenuChildView) childAt2).needsDividerBefore();
        }
        return z;
    }

    public boolean hideOverflowMenu() {
        return this.mPresenter != null && this.mPresenter.hideOverflowMenu();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean isOverflowMenuShowPending() {
        return this.mPresenter != null && this.mPresenter.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.mPresenter != null && this.mPresenter.isOverflowMenuShowing();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mPresenter != null) {
            this.mPresenter.updateMenuView(false);
            if (this.mPresenter.isOverflowMenuShowing()) {
                this.mPresenter.hideOverflowMenu();
                this.mPresenter.showOverflowMenu();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mFormatItems) {
            int i5;
            int childCount = getChildCount();
            int i6 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i7 = i3 - i;
            int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            int i8 = paddingRight;
            int i9 = 0;
            int i10 = 0;
            for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
                View childAt = getChildAt(paddingRight);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.isOverflowButton) {
                        int paddingLeft;
                        int i11;
                        i9 = childAt.getMeasuredWidth();
                        if (hasSupportDividerBeforeChildAt(paddingRight)) {
                            i9 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (isLayoutRtl) {
                            paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
                            i11 = paddingLeft + i9;
                        } else {
                            i11 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                            paddingLeft = i11 - i9;
                        }
                        i5 = i6 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i5, i11, measuredHeight + i5);
                        i8 -= i9;
                        i9 = 1;
                    } else {
                        i8 -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                        boolean hasSupportDividerBeforeChildAt = hasSupportDividerBeforeChildAt(paddingRight);
                        i10++;
                    }
                }
            }
            if (childCount == 1 && i9 == 0) {
                View childAt2 = getChildAt(0);
                dividerWidth = childAt2.getMeasuredWidth();
                paddingRight = childAt2.getMeasuredHeight();
                i7 = (i7 / 2) - (dividerWidth / 2);
                i6 -= paddingRight / 2;
                childAt2.layout(i7, i6, dividerWidth + i7, paddingRight + i6);
                return;
            }
            i10 -= i9 ^ 1;
            if (i10 > 0) {
                i5 = i8 / i10;
                dividerWidth = 0;
            } else {
                dividerWidth = 0;
                i5 = 0;
            }
            i7 = Math.max(dividerWidth, i5);
            View childAt3;
            LayoutParams layoutParams2;
            if (isLayoutRtl) {
                paddingRight = getWidth() - getPaddingRight();
                while (dividerWidth < childCount) {
                    childAt3 = getChildAt(dividerWidth);
                    layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    if (!(childAt3.getVisibility() == 8 || layoutParams2.isOverflowButton)) {
                        paddingRight -= layoutParams2.rightMargin;
                        i9 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        i8 = i6 - (i10 / 2);
                        childAt3.layout(paddingRight - i9, i8, paddingRight, i10 + i8);
                        paddingRight -= (i9 + layoutParams2.leftMargin) + i7;
                    }
                    dividerWidth++;
                }
            } else {
                paddingRight = getPaddingLeft();
                while (dividerWidth < childCount) {
                    childAt3 = getChildAt(dividerWidth);
                    layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                    if (!(childAt3.getVisibility() == 8 || layoutParams2.isOverflowButton)) {
                        paddingRight += layoutParams2.leftMargin;
                        i9 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        i8 = i6 - (i10 / 2);
                        childAt3.layout(paddingRight, i8, paddingRight + i9, i10 + i8);
                        paddingRight += (i9 + layoutParams2.rightMargin) + i7;
                    }
                    dividerWidth++;
                }
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        boolean z = this.mFormatItems;
        this.mFormatItems = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.mFormatItems) {
            this.mFormatItemsWidth = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.mFormatItems || this.mMenu == null || size == this.mFormatItemsWidth)) {
            this.mFormatItemsWidth = size;
            this.mMenu.onItemsChanged(true);
        }
        size = getChildCount();
        if (!this.mFormatItems || size <= 0) {
            for (int i3 = 0; i3 < size; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        onMeasureExactFormat(i, i2);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setExpandedActionViewsExclusive(boolean z) {
        this.mPresenter.setExpandedActionViewsExclusive(z);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setMenuCallbacks(Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setOverflowReserved(boolean z) {
        this.mReserveOverflow = z;
    }

    public void setPopupTheme(@StyleRes int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        this.mPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        return this.mPresenter != null && this.mPresenter.showOverflowMenu();
    }
}
