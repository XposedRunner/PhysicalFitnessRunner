package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.R;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

@RestrictTo({Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    private final int mActiveItemMaxWidth;
    private final BottomNavigationAnimationHelperBase mAnimationHelper;
    private BottomNavigationItemView[] mButtons;
    private final int mInactiveItemMaxWidth;
    private final int mInactiveItemMinWidth;
    private int mItemBackgroundRes;
    private final int mItemHeight;
    private ColorStateList mItemIconTint;
    private final Pool<BottomNavigationItemView> mItemPool;
    private ColorStateList mItemTextColor;
    private MenuBuilder mMenu;
    private final OnClickListener mOnClickListener;
    private BottomNavigationPresenter mPresenter;
    private int mSelectedItemId;
    private int mSelectedItemPosition;
    private boolean mShiftingMode;
    private int[] mTempChildWidths;

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemPool = new SynchronizedPool(5);
        this.mShiftingMode = true;
        this.mSelectedItemId = 0;
        this.mSelectedItemPosition = 0;
        Resources resources = getResources();
        this.mInactiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.mInactiveItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.mActiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.mItemHeight = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        if (VERSION.SDK_INT >= 14) {
            this.mAnimationHelper = new BottomNavigationAnimationHelperIcs();
        } else {
            this.mAnimationHelper = new BottomNavigationAnimationHelperBase();
        }
        this.mOnClickListener = new OnClickListener() {
            public void onClick(View view) {
                MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
                if (!BottomNavigationMenuView.this.mMenu.performItemAction(itemData, BottomNavigationMenuView.this.mPresenter, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        this.mTempChildWidths = new int[5];
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView bottomNavigationItemView = (BottomNavigationItemView) this.mItemPool.acquire();
        return bottomNavigationItemView == null ? new BottomNavigationItemView(getContext()) : bottomNavigationItemView;
    }

    public void buildMenuView() {
        removeAllViews();
        if (this.mButtons != null) {
            for (Object release : this.mButtons) {
                this.mItemPool.release(release);
            }
        }
        if (this.mMenu.size() == 0) {
            this.mSelectedItemId = 0;
            this.mSelectedItemPosition = 0;
            this.mButtons = null;
            return;
        }
        this.mButtons = new BottomNavigationItemView[this.mMenu.size()];
        this.mShiftingMode = this.mMenu.size() > 3;
        for (int i = 0; i < this.mMenu.size(); i++) {
            this.mPresenter.setUpdateSuspended(true);
            this.mMenu.getItem(i).setCheckable(true);
            this.mPresenter.setUpdateSuspended(false);
            BottomNavigationItemView newItem = getNewItem();
            this.mButtons[i] = newItem;
            newItem.setIconTintList(this.mItemIconTint);
            newItem.setTextColor(this.mItemTextColor);
            newItem.setItemBackground(this.mItemBackgroundRes);
            newItem.setShiftingMode(this.mShiftingMode);
            newItem.initialize((MenuItemImpl) this.mMenu.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.mOnClickListener);
            addView(newItem);
        }
        this.mSelectedItemPosition = Math.min(this.mMenu.size() - 1, this.mSelectedItemPosition);
        this.mMenu.getItem(this.mSelectedItemPosition).setChecked(true);
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.mItemIconTint;
    }

    public int getItemBackgroundRes() {
        return this.mItemBackgroundRes;
    }

    public ColorStateList getItemTextColor() {
        return this.mItemTextColor;
    }

    public int getSelectedItemId() {
        return this.mSelectedItemId;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        i3 -= i;
        i4 -= i2;
        i2 = 0;
        int i5 = i2;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i6 = i3 - i5;
                    childAt.layout(i6 - childAt.getMeasuredWidth(), 0, i6, i4);
                } else {
                    childAt.layout(i5, 0, childAt.getMeasuredWidth() + i5, i4);
                }
                i5 += childAt.getMeasuredWidth();
            }
            i2++;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        i = MeasureSpec.getSize(i);
        i2 = getChildCount();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824);
        int min;
        if (this.mShiftingMode) {
            i3 = i2 - 1;
            min = Math.min(i - (this.mInactiveItemMinWidth * i3), this.mActiveItemMaxWidth);
            i -= min;
            int min2 = Math.min(i / i3, this.mInactiveItemMaxWidth);
            i3 = i - (i3 * min2);
            i = 0;
            while (i < i2) {
                this.mTempChildWidths[i] = i == this.mSelectedItemPosition ? min : min2;
                if (i3 > 0) {
                    int[] iArr = this.mTempChildWidths;
                    iArr[i] = iArr[i] + 1;
                    i3--;
                }
                i++;
            }
        } else {
            i3 = Math.min(i / (i2 == 0 ? 1 : i2), this.mActiveItemMaxWidth);
            min = i - (i3 * i2);
            for (i = 0; i < i2; i++) {
                this.mTempChildWidths[i] = i3;
                if (min > 0) {
                    int[] iArr2 = this.mTempChildWidths;
                    iArr2[i] = iArr2[i] + 1;
                    min--;
                }
            }
        }
        i = 0;
        i3 = i;
        while (i < i2) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                childAt.measure(MeasureSpec.makeMeasureSpec(this.mTempChildWidths[i], 1073741824), makeMeasureSpec);
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                i3 += childAt.getMeasuredWidth();
            }
            i++;
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(i3, MeasureSpec.makeMeasureSpec(i3, 1073741824), 0), ViewCompat.resolveSizeAndState(this.mItemHeight, makeMeasureSpec, 0));
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.mItemIconTint = colorStateList;
        if (this.mButtons != null) {
            for (BottomNavigationItemView iconTintList : this.mButtons) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.mItemBackgroundRes = i;
        if (this.mButtons != null) {
            for (BottomNavigationItemView itemBackground : this.mButtons) {
                itemBackground.setItemBackground(i);
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.mItemTextColor = colorStateList;
        if (this.mButtons != null) {
            for (BottomNavigationItemView textColor : this.mButtons) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.mPresenter = bottomNavigationPresenter;
    }

    /* Access modifiers changed, original: 0000 */
    public void tryRestoreSelectedItemId(int i) {
        int size = this.mMenu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.mMenu.getItem(i2);
            if (i == item.getItemId()) {
                this.mSelectedItemId = i;
                this.mSelectedItemPosition = i2;
                item.setChecked(true);
                return;
            }
        }
    }

    public void updateMenuView() {
        int size = this.mMenu.size();
        if (size != this.mButtons.length) {
            buildMenuView();
            return;
        }
        int i = this.mSelectedItemId;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.mMenu.getItem(i2);
            if (item.isChecked()) {
                this.mSelectedItemId = item.getItemId();
                this.mSelectedItemPosition = i2;
            }
        }
        if (i != this.mSelectedItemId) {
            this.mAnimationHelper.beginDelayedTransition(this);
        }
        for (i = 0; i < size; i++) {
            this.mPresenter.setUpdateSuspended(true);
            this.mButtons[i].initialize((MenuItemImpl) this.mMenu.getItem(i), 0);
            this.mPresenter.setUpdateSuspended(false);
        }
    }
}
