package com.umeng.socialize.shareboard;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.umeng.socialize.shareboard.widgets.SocializeViewPager;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000o00.O0000o;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

/* compiled from: UMActionFrame */
class O0000Oo0 extends LinearLayout {
    private O00000Oo O000000o;
    private OnDismissListener O00000Oo;

    public O0000Oo0(Context context) {
        super(context);
    }

    public O0000Oo0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(11)
    public O0000Oo0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public O0000Oo0(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    private int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void O000000o(View view, int i) {
        int O000000o = O000000o(20.0f);
        LayoutParams layoutParams = new LayoutParams(-1, O000000o((float) i));
        layoutParams.topMargin = O000000o;
        i = O000000o(10.0f);
        layoutParams.rightMargin = i;
        layoutParams.leftMargin = i;
        view.setLayoutParams(layoutParams);
        view.setPadding(0, 0, 0, O000000o);
    }

    private void O00000Oo(List<O00000o> list) {
        setBackgroundColor(Color.argb(50, 0, 0, 0));
        AlphaAnimation alphaAnimation = new AlphaAnimation(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        alphaAnimation.setDuration(100);
        setAnimation(alphaAnimation);
        setOrientation(1);
        if (this.O000000o.O0000o0O == O00000Oo.O00000o0) {
            setGravity(80);
        } else if (this.O000000o.O0000o0O == O00000Oo.O00000Oo) {
            setGravity(17);
            int O000000o = O000000o(36.0f);
            setPadding(O000000o, 0, O000000o, 0);
        }
        setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (O0000Oo0.this.O00000Oo != null) {
                    O0000Oo0.this.O00000Oo.onDismiss();
                }
            }
        });
        View O00000o0 = O00000o0(list);
        if (O00000o0 != null) {
            O00000o0.setClickable(true);
            addView(O00000o0);
        }
    }

    private StateListDrawable O00000o() {
        ColorDrawable colorDrawable = new ColorDrawable(this.O000000o.O0000o00);
        ColorDrawable colorDrawable2 = new ColorDrawable(this.O000000o.O0000o0);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, colorDrawable2);
        stateListDrawable.addState(new int[0], colorDrawable);
        return stateListDrawable;
    }

    private View O00000o0() {
        TextView textView = new TextView(getContext());
        textView.setText(this.O000000o.O0000OOo);
        textView.setTextColor(this.O000000o.O0000Oo0);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        textView.setMaxLines(1);
        textView.setEllipsize(TruncateAt.END);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.topMargin = O000000o(20.0f);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private View O00000o0(List<O00000o> list) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(this.O000000o.O0000o0o);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        if (this.O000000o.O0000o0O == O00000Oo.O00000Oo && this.O000000o.O0000oo != 0) {
            layoutParams.topMargin = this.O000000o.O0000oo;
        }
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        if (this.O000000o.O0000O0o) {
            linearLayout.addView(O00000o0());
        }
        int O0000Ooo = this.O000000o.O0000Ooo(list.size());
        View O00000oO = O00000oO();
        IndicatorView indicatorView = null;
        if (O00000oO != null) {
            O0000OOo o0000OOo = new O0000OOo(getContext(), this.O000000o);
            o0000OOo.O000000o(list);
            O000000o(O00000oO, O0000Ooo);
            linearLayout.addView(O00000oO);
            O00000oO.setAdapter(o0000OOo);
            if (this.O000000o.O000O0oo) {
                indicatorView = O000000o();
            }
            if (indicatorView != null) {
                indicatorView.setPageCount(o0000OOo.getCount());
                linearLayout.addView(indicatorView);
            }
            AnonymousClass2 anonymousClass2 = new OnPageChangeListener() {
                public void onPageScrollStateChanged(int i) {
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                    if (indicatorView != null) {
                        indicatorView.setSelectedPosition(i);
                    }
                }
            };
            if (O00000oo()) {
                O00000oO.addOnPageChangeListener(anonymousClass2);
            } else {
                O00000oO.setOnPageChangeListener(anonymousClass2);
            }
        } else {
            O00000oO = O0000O0o();
            if (O00000oO == null) {
                return null;
            }
            O0000O0o o0000O0o = new O0000O0o(getContext(), this.O000000o);
            o0000O0o.O000000o(list);
            O000000o(O00000oO, O0000Ooo);
            linearLayout.addView(O00000oO);
            O00000oO.setAdapter(o0000O0o);
            if (this.O000000o.O000O0oo) {
                indicatorView = O000000o();
            }
            if (indicatorView != null) {
                indicatorView.setPageCount(o0000O0o.O000000o());
                linearLayout.addView(indicatorView);
            }
            O00000oO.addOnPageChangeListener(new SocializeViewPager.OnPageChangeListener() {
                public void O000000o(int i) {
                    if (indicatorView != null) {
                        indicatorView.setSelectedPosition(i);
                    }
                }

                public void O000000o(int i, float f, int i2) {
                }

                public void O00000Oo(int i) {
                }
            });
        }
        if (this.O000000o.O0000Oo) {
            linearLayout.addView(O00000Oo());
        }
        return linearLayout;
    }

    private ViewPager O00000oO() {
        try {
            return (ViewPager) Class.forName("android.support.v4.view.ViewPager").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{getContext()});
        } catch (Exception e) {
            O0000O0o.O000000o(e);
            return null;
        }
    }

    private boolean O00000oo() {
        try {
            return Class.forName("android.support.v4.view.ViewPager").getMethod("addOnPageChangeListener", new Class[]{OnPageChangeListener.class}) != null;
        } catch (Exception e) {
            O0000O0o.O000000o(e);
        }
    }

    private SocializeViewPager O0000O0o() {
        try {
            return (SocializeViewPager) Class.forName("com.umeng.socialize.shareboard.widgets.SocializeViewPager").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{getContext()});
        } catch (Exception e) {
            O0000O0o.O000000o(O0000o.O00000Oo, e);
            return null;
        }
    }

    public IndicatorView O000000o() {
        int O000000o = O000000o(20.0f);
        IndicatorView indicatorView = new IndicatorView(getContext());
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.bottomMargin = O000000o;
        indicatorView.setLayoutParams(layoutParams);
        indicatorView.O00000Oo(this.O000000o.O000OO00, this.O000000o.O000OO0o);
        indicatorView.O000000o(3, 5);
        return indicatorView;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(OnDismissListener onDismissListener) {
        this.O00000Oo = onDismissListener;
    }

    public void O000000o(List<O00000o> list) {
        O000000o((List) list, new O00000Oo());
    }

    public void O000000o(List<O00000o> list, O00000Oo o00000Oo) {
        if (o00000Oo == null) {
            this.O000000o = new O00000Oo();
        } else {
            this.O000000o = o00000Oo;
        }
        O00000Oo(list);
    }

    public View O00000Oo() {
        TextView textView = new TextView(getContext());
        textView.setText(this.O000000o.O0000OoO);
        textView.setTextColor(this.O000000o.O0000Ooo);
        textView.setClickable(true);
        textView.setTextSize(15.0f);
        textView.setGravity(17);
        if (this.O000000o.O0000o0 == 0) {
            textView.setBackgroundColor(this.O000000o.O0000o00);
        } else if (VERSION.SDK_INT >= 16) {
            textView.setBackground(O00000o());
        } else {
            textView.setBackgroundDrawable(O00000o());
        }
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (O0000Oo0.this.O00000Oo != null) {
                    O0000Oo0.this.O00000Oo.onDismiss();
                }
            }
        });
        textView.setLayoutParams(new LayoutParams(-1, O000000o(50.0f)));
        return textView;
    }
}
