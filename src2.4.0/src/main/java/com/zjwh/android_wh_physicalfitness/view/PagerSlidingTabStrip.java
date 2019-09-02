package com.zjwh.android_wh_physicalfitness.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.entity.DynamicTabBean;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.PageTabEvt;
import java.util.List;
import org.greenrobot.eventbus.O00000o0;
import org.xutils.common.util.DensityUtil;

public class PagerSlidingTabStrip extends HorizontalScrollView {
    public static final int O000000o = 0;
    public static final int O00000Oo = 1;
    public static final int O00000o = 3;
    public static final int O00000o0 = 2;
    private static final String O00000oO = "tab_bar_view_active";
    private static final String O00000oo = "tab_bar_view_inactive";
    private LayoutParams O0000O0o;
    private LayoutParams O0000OOo;
    private LinearLayout O0000Oo;
    private final O000000o O0000Oo0;
    private ViewPager O0000OoO;
    private int O0000Ooo;
    private int O0000o;
    private int O0000o0;
    private int O0000o00;
    private float O0000o0O;
    private Paint O0000o0o;
    private int O0000oO;
    private boolean O0000oO0;
    private int O0000oOO;
    private float O0000oOo;
    private float O0000oo;
    private float O0000oo0;
    private float O0000ooO;
    private float O0000ooo;
    private int O000O00o;
    private int O000O0OO;
    private int O000O0Oo;
    private int O000O0o;
    private List<DynamicTabBean> O000O0o0;
    private Path O000O0oO;
    private long O00oOoOo;
    private int O00oOooO;
    private int O00oOooo;

    private class O000000o implements OnPageChangeListener {
        private O000000o() {
        }

        /* synthetic */ O000000o(PagerSlidingTabStrip pagerSlidingTabStrip, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.this.O00000Oo(PagerSlidingTabStrip.this.O0000OoO.getCurrentItem(), 0);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            PagerSlidingTabStrip.this.O0000o0 = i;
            PagerSlidingTabStrip.this.O0000o0O = f;
            PagerSlidingTabStrip.this.O00000Oo(i, (int) (f * ((float) PagerSlidingTabStrip.this.O0000Oo.getChildAt(i).getWidth())));
            PagerSlidingTabStrip.this.invalidate();
        }

        public void onPageSelected(int i) {
            PagerSlidingTabStrip.this.O000000o(PagerSlidingTabStrip.this.O0000Oo.findViewWithTag(PagerSlidingTabStrip.O00000oO), PagerSlidingTabStrip.this.O000O0OO);
            PagerSlidingTabStrip.this.O00000Oo(PagerSlidingTabStrip.this.O0000Oo.getChildAt(i), i);
            PagerSlidingTabStrip.this.O000O0OO = i;
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            /* renamed from: O000000o */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: O000000o */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int O000000o;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.O000000o = parcel.readInt();
        }

        /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.O000000o);
        }
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Oo0 = new O000000o(this, null);
        this.O0000Ooo = 1;
        this.O0000o0 = 0;
        this.O0000o0O = CropImageView.DEFAULT_ASPECT_RATIO;
        this.O0000o = -13384510;
        this.O0000oO0 = false;
        this.O0000oO = 52;
        this.O0000oOO = 3;
        this.O0000oOo = 7.0f;
        this.O0000oo0 = 1.0f;
        this.O0000oo = 18.0f;
        this.O0000ooO = 0.86f;
        this.O0000ooo = 1.0f;
        this.O00oOooO = -12237499;
        this.O00oOooo = -13384510;
        this.O000O00o = 17170445;
        this.O000O0Oo = -1;
        this.O000O0o = 0;
        this.O000O0oO = new Path();
        setFillViewport(true);
        setWillNotDraw(false);
        this.O0000Oo = new LinearLayout(context);
        this.O0000Oo.setOrientation(0);
        this.O0000Oo.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.O0000Oo);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.O0000oO = (int) TypedValue.applyDimension(1, (float) this.O0000oO, displayMetrics);
        this.O0000oOo = TypedValue.applyDimension(1, this.O0000oOo, displayMetrics);
        this.O0000oo0 = TypedValue.applyDimension(1, this.O0000oo0, displayMetrics);
        this.O0000oOO = (int) TypedValue.applyDimension(1, (float) this.O0000oOO, displayMetrics);
        this.O0000oo = TypedValue.applyDimension(2, this.O0000oo, displayMetrics);
        this.O0000ooo = TypedValue.applyDimension(2, this.O0000ooo, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PagerSlidingTabStrip);
        this.O0000o = obtainStyledAttributes.getColor(0, this.O0000o);
        this.O0000oOo = obtainStyledAttributes.getDimension(1, this.O0000oOo);
        this.O0000oo0 = obtainStyledAttributes.getDimension(2, this.O0000oo0);
        this.O0000oOO = obtainStyledAttributes.getDimensionPixelSize(5, this.O0000oOO);
        this.O0000oO0 = obtainStyledAttributes.getBoolean(4, this.O0000oO0);
        this.O0000oO = obtainStyledAttributes.getDimensionPixelSize(3, this.O0000oO);
        this.O0000oo = obtainStyledAttributes.getDimension(9, this.O0000oo);
        this.O00oOooO = obtainStyledAttributes.getColor(6, this.O00oOooO);
        this.O00oOooo = obtainStyledAttributes.getColor(7, this.O00oOooo);
        this.O0000Ooo = obtainStyledAttributes.getInt(12, 1);
        this.O0000ooO = obtainStyledAttributes.getFloat(8, this.O0000ooO);
        this.O0000ooo = obtainStyledAttributes.getDimension(11, this.O0000ooo);
        obtainStyledAttributes.recycle();
        this.O0000o0o = new Paint();
        this.O0000o0o.setAntiAlias(true);
        this.O0000o0o.setColor(this.O0000o);
        this.O0000o0o.setStyle(Style.STROKE);
        this.O0000o0o.setStrokeCap(Cap.ROUND);
        this.O0000o0o.setStrokeWidth(this.O0000oo0);
        this.O0000O0o = new LayoutParams(-2, -1);
        this.O0000OOo = new LayoutParams(0, -1, 1.0f);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme() != null) {
            context.getTheme().resolveAttribute(2130968970, typedValue, true);
        }
        this.O000O00o = typedValue.resourceId;
    }

    private void O000000o(int i, int i2) {
        View imageView = new ImageView(getContext());
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        imageView.setImageResource(i2);
        imageView.setBackgroundResource(this.O000O00o);
        O000000o(i, imageView);
    }

    private void O000000o(final int i, View view) {
        view.setId(i);
        view.setFocusable(true);
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (view.getId() != PagerSlidingTabStrip.this.O000O0Oo) {
                    PagerSlidingTabStrip.this.O00oOoOo = System.currentTimeMillis();
                    PagerSlidingTabStrip.this.O000O0Oo = view.getId();
                    PagerSlidingTabStrip.this.O0000OoO.setCurrentItem(i);
                } else if (System.currentTimeMillis() - PagerSlidingTabStrip.this.O00oOoOo < 200) {
                    O00000o0.O000000o().O00000o(new PageTabEvt(i));
                    PagerSlidingTabStrip.this.O00oOoOo = 0;
                    PagerSlidingTabStrip.this.O000O0Oo = -1;
                } else {
                    PagerSlidingTabStrip.this.O00oOoOo = System.currentTimeMillis();
                }
            }
        });
        view.setPadding(this.O0000oOO, 0, this.O0000oOO, 0);
        this.O0000Oo.addView(view, i, this.O0000oO0 ? this.O0000OOo : this.O0000O0o);
    }

    private void O000000o(int i, String str) {
        View textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setBackgroundResource(this.O000O00o);
        O000000o(i, textView);
    }

    private void O000000o(int i, String str, boolean z) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sliding_tab_red_point_view, null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tab);
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        inflate.setBackgroundResource(this.O000O00o);
        if (z) {
            inflate.findViewById(R.id.red_point).setVisibility(0);
        }
        O000000o(i, inflate);
    }

    private void O000000o(View view, int i) {
        if (view != null) {
            view.setTag(O00000oo);
            TextView textView;
            if (this.O0000Ooo == 2) {
                textView = (TextView) view.findViewById(R.id.tab);
                textView.setTextColor(this.O00oOooO);
                textView.setTextSize(0, this.O0000oo);
            } else if (this.O0000Ooo != 3) {
                textView = (TextView) view;
                textView.setTextColor(this.O00oOooO);
                textView.setTextSize(0, this.O0000oo);
            } else if (this.O000O0o0 != null && this.O000O0o0.size() >= i) {
                DynamicTabBean dynamicTabBean = (DynamicTabBean) this.O000O0o0.get(i);
                if (dynamicTabBean.isImage()) {
                    ((ImageView) view).setImageResource(dynamicTabBean.getImageResId());
                } else {
                    textView = (TextView) view;
                    textView.setTextColor(this.O00oOooO);
                    textView.setTextSize(0, this.O0000oo);
                }
            } else {
                return;
            }
            invalidate();
        }
    }

    private void O00000Oo(int i, int i2) {
        if (this.O0000o00 != 0) {
            int left = this.O0000Oo.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.O0000oO;
            }
            if (left != this.O000O0o) {
                this.O000O0o = left;
                scrollTo(left, 0);
            }
        }
    }

    private void O00000Oo(View view, int i) {
        if (view != null) {
            view.setTag(O00000oO);
            TextView textView;
            if (this.O0000Ooo == 2) {
                textView = (TextView) view.findViewById(R.id.tab);
                textView.setTextColor(this.O00oOooo);
                textView.setTextSize(0, this.O0000oo);
            } else if (this.O0000Ooo != 3) {
                textView = (TextView) view;
                textView.setTextColor(this.O00oOooo);
                textView.setTextSize(0, this.O0000oo);
            } else if (this.O000O0o0 != null && this.O000O0o0.size() >= i) {
                DynamicTabBean dynamicTabBean = (DynamicTabBean) this.O000O0o0.get(i);
                if (dynamicTabBean.isImage()) {
                    ((ImageView) view).setImageResource(dynamicTabBean.getImageSelectResId());
                } else {
                    textView = (TextView) view;
                    textView.setTextColor(this.O00oOooo);
                    textView.setTextSize(0, this.O0000oo);
                }
            } else {
                return;
            }
            invalidate();
        }
    }

    private void O00000o0() {
        for (int i = 0; i < this.O0000o00; i++) {
            View childAt = this.O0000Oo.getChildAt(i);
            if (i == this.O0000o0) {
                O00000Oo(childAt, i);
            } else {
                O000000o(childAt, i);
            }
        }
    }

    public void O000000o() {
        this.O0000Oo.removeAllViews();
        this.O0000o00 = this.O0000OoO.getAdapter().getCount();
        int i = 0;
        while (i < this.O0000o00) {
            if (this.O0000Ooo == 2) {
                O000000o(i, this.O0000OoO.getAdapter().getPageTitle(i).toString(), this.O0000OoO.getAdapter().getItemPosition(Integer.valueOf(i)) > 0);
            } else if (this.O0000Ooo != 3) {
                O000000o(i, this.O0000OoO.getAdapter().getPageTitle(i).toString());
            } else if (this.O000O0o0 == null || this.O000O0o0.size() != this.O0000o00) {
                throw new NullPointerException("Are you set right items?");
            } else {
                DynamicTabBean dynamicTabBean = (DynamicTabBean) this.O000O0o0.get(i);
                if (dynamicTabBean.isImage()) {
                    O000000o(i, this.O0000OoO.getCurrentItem() == i ? dynamicTabBean.getImageSelectResId() : dynamicTabBean.getImageResId());
                } else {
                    O000000o(i, dynamicTabBean.getText());
                }
            }
            i++;
        }
        this.O0000o0 = this.O0000OoO.getCurrentItem();
        O00000o0();
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                PagerSlidingTabStrip.this.O0000o0 = PagerSlidingTabStrip.this.O0000OoO.getCurrentItem();
                PagerSlidingTabStrip.this.O00000Oo(PagerSlidingTabStrip.this.O0000o0, 0);
            }
        });
    }

    public void O000000o(int i) {
        if (this.O0000Oo.getChildCount() > i) {
            View findViewById = this.O0000Oo.getChildAt(i).findViewById(R.id.red_point);
            if (findViewById.getVisibility() == 0) {
                findViewById.setVisibility(8);
            }
        }
    }

    public boolean O00000Oo() {
        return this.O0000oO0;
    }

    public int getIndicatorColor() {
        return this.O0000o;
    }

    public float getIndicatorHeight() {
        return this.O0000oOo;
    }

    public float getIndicatorStrokeWidth() {
        return this.O0000oo0;
    }

    public List<DynamicTabBean> getItems() {
        return this.O000O0o0;
    }

    public int getScrollOffset() {
        return this.O0000oO;
    }

    public int getTabPaddingLeftRight() {
        return this.O0000oOO;
    }

    public int getTabTextColor() {
        return this.O00oOooO;
    }

    public int getTabTextColorHighlight() {
        return this.O00oOooo;
    }

    public float getTabTextScale() {
        return this.O0000ooO;
    }

    public float getTabTextSize() {
        return this.O0000oo;
    }

    public float getTabTextTranslationY() {
        return this.O0000ooo;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.O0000o00 != 0) {
            int height = getHeight();
            float dip2px = (float) DensityUtil.dip2px(18.0f);
            View childAt = this.O0000Oo.getChildAt(this.O0000o0);
            float left = (float) childAt.getLeft();
            float right = (float) childAt.getRight();
            if (this.O0000o0O > CropImageView.DEFAULT_ASPECT_RATIO && this.O0000o0 < this.O0000o00 - 1) {
                View childAt2 = this.O0000Oo.getChildAt(this.O0000o0 + 1);
                float left2 = (float) childAt2.getLeft();
                left = (this.O0000o0O * left2) + ((1.0f - this.O0000o0O) * left);
                right = (this.O0000o0O * ((float) childAt2.getRight())) + ((1.0f - this.O0000o0O) * right);
            }
            left = (left + ((right - left) / 2.0f)) + ((float) this.O0000oOO);
            float f = ((float) height) - (this.O0000oo0 / 2.0f);
            this.O000O0oO.reset();
            this.O000O0oO.moveTo(left - dip2px, f);
            this.O000O0oO.lineTo(left + dip2px, f);
            canvas.drawPath(this.O000O0oO, this.O0000o0o);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.O0000o0 = savedState.O000000o;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.O000000o = this.O0000o0;
        return savedState;
    }

    public void setIndicatorColor(int i) {
        this.O0000o = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.O0000o = getResources().getColor(i);
        invalidate();
    }

    public void setIndicatorHeight(float f) {
        this.O0000oOo = f;
        invalidate();
    }

    public void setIndicatorStrokeWidth(float f) {
        this.O0000oo0 = f;
        invalidate();
    }

    public void setItems(List<DynamicTabBean> list) {
        this.O000O0o0 = list;
    }

    public void setScrollOffset(int i) {
        this.O0000oO = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        this.O0000oO0 = z;
        requestLayout();
    }

    public void setTabPaddingLeftRight(int i) {
        this.O0000oOO = i;
        O00000o0();
    }

    public void setTabTextColor(int i) {
        this.O00oOooO = i;
        O00000o0();
    }

    public void setTabTextColorHighlight(int i) {
        this.O00oOooo = i;
        O00000o0();
    }

    public void setTabTextScale(float f) {
        this.O0000ooO = f;
        O00000o0();
    }

    public void setTabTextSize(float f) {
        this.O0000oo = f;
        O00000o0();
    }

    public void setTabTextTranslationY(float f) {
        this.O0000ooo = f;
        O00000o0();
    }

    public void setTextSize(int i) {
        this.O0000oo = (float) i;
        O00000o0();
    }

    public void setViewPager(ViewPager viewPager) {
        this.O0000OoO = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.addOnPageChangeListener(this.O0000Oo0);
        O000000o();
    }
}
