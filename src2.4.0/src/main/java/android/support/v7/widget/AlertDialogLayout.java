package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.LinearLayoutCompat.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

@RestrictTo({Scope.LIBRARY_GROUP})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    private boolean tryOnMeasure(int i, int i2) {
        int i3;
        int combineMeasuredStates;
        int resolveMinimumHeight;
        int measuredHeight;
        int measuredHeight2;
        int i4 = i;
        int i5 = i2;
        int childCount = getChildCount();
        View view = null;
        View view2 = view;
        View view3 = view2;
        for (i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        i3 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode = MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i4, 0);
            paddingTop += view.getMeasuredHeight();
            combineMeasuredStates = ViewCompat.combineMeasuredStates(0, ViewCompat.getMeasuredState(view));
        } else {
            combineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i4, 0);
            resolveMinimumHeight = resolveMinimumHeight(view2);
            measuredHeight = view2.getMeasuredHeight() - resolveMinimumHeight;
            paddingTop += resolveMinimumHeight;
            combineMeasuredStates = ViewCompat.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(view2));
        } else {
            resolveMinimumHeight = 0;
            measuredHeight = resolveMinimumHeight;
        }
        if (view3 != null) {
            view3.measure(i4, i3 == 0 ? 0 : MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), i3));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingTop += measuredHeight2;
            combineMeasuredStates = ViewCompat.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(view3));
        } else {
            measuredHeight2 = 0;
        }
        size -= paddingTop;
        if (view2 != null) {
            paddingTop -= resolveMinimumHeight;
            measuredHeight = Math.min(size, measuredHeight);
            if (measuredHeight > 0) {
                size -= measuredHeight;
                resolveMinimumHeight += measuredHeight;
            }
            view2.measure(i4, MeasureSpec.makeMeasureSpec(resolveMinimumHeight, 1073741824));
            paddingTop += view2.getMeasuredHeight();
            combineMeasuredStates = ViewCompat.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(view2));
        }
        if (view3 != null && size > 0) {
            paddingTop -= measuredHeight2;
            view3.measure(i4, MeasureSpec.makeMeasureSpec(measuredHeight2 + size, i3));
            paddingTop += view3.getMeasuredHeight();
            combineMeasuredStates = ViewCompat.combineMeasuredStates(combineMeasuredStates, ViewCompat.getMeasuredState(view3));
        }
        int i6 = 0;
        for (i3 = 0; i3 < childCount; i3++) {
            view3 = getChildAt(i3);
            if (view3.getVisibility() != 8) {
                i6 = Math.max(i6, view3.getMeasuredWidth());
            }
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(i6 + (getPaddingLeft() + getPaddingRight()), i4, combineMeasuredStates), ViewCompat.resolveSizeAndState(paddingTop, i5, 0));
        if (mode != 1073741824) {
            forceUniformWidth(childCount, i5);
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        i5 = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i6 = gravity & 112;
        int i7 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int paddingTop = i6 != 16 ? i6 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - i5 : (((i4 - i2) - i5) / 2) + getPaddingTop();
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                i6 = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i5 = layoutParams.gravity;
                if (i5 < 0) {
                    i5 = i7;
                }
                i5 = GravityCompat.getAbsoluteGravity(i5, ViewCompat.getLayoutDirection(this)) & 7;
                i5 = i5 != 1 ? i5 != 5 ? layoutParams.leftMargin + paddingLeft : (paddingRight - i6) - layoutParams.rightMargin : ((((paddingRight2 - i6) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                if (hasDividerBeforeChildAt(i8)) {
                    paddingTop += intrinsicHeight;
                }
                int i9 = paddingTop + layoutParams.topMargin;
                setChildFrame(childAt, i5, i9, i6, measuredHeight);
                paddingTop = i9 + (measuredHeight + layoutParams.bottomMargin);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (!tryOnMeasure(i, i2)) {
            super.onMeasure(i, i2);
        }
    }
}
