package com.zjwh.android_wh_physicalfitness.view.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.zjwh.android_wh_physicalfitness.R;
import defpackage.gf;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DecentBanner extends AspectRatioView {
    private static final int O000000o = 200000;
    private static final int O00000Oo = 123;
    private int O00000o = 1000;
    private int O00000o0 = 3;
    private int O00000oO = 0;
    private ViewPager O00000oo;
    private CircleIndicator O0000O0o;
    private Handler O0000OOo = new O00000Oo(this);

    private class O000000o extends Scroller {
        int O000000o;

        O000000o(Context context, int i) {
            super(context);
            this.O000000o = i;
        }

        O000000o(Context context, Interpolator interpolator, int i) {
            super(context, interpolator);
            this.O000000o = i;
        }

        O000000o(Context context, Interpolator interpolator, boolean z, int i) {
            super(context, interpolator, z);
            this.O000000o = i;
        }

        public void startScroll(int i, int i2, int i3, int i4) {
            super.startScroll(i, i2, i3, i4, this.O000000o);
        }

        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            super.startScroll(i, i2, i3, i4, this.O000000o);
        }
    }

    private static class O00000Oo extends Handler {
        private final WeakReference<DecentBanner> O000000o;

        O00000Oo(DecentBanner decentBanner) {
            this.O000000o = new WeakReference(decentBanner);
        }

        public void handleMessage(Message message) {
            if (this.O000000o.get() != null && message.what == 123) {
                DecentBanner decentBanner = (DecentBanner) this.O000000o.get();
                if (decentBanner.O00000oo != null) {
                    decentBanner.O00000oo.setCurrentItem(decentBanner.O00000oo.getCurrentItem() + 1);
                    decentBanner.O000000o();
                }
            }
        }
    }

    public DecentBanner(Context context) {
        super(context);
    }

    public DecentBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DecentBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void O00000Oo(List<O000000o> list, int i, int i2) {
        if (list != null && list.size() != 0) {
            O00000Oo();
            int i3 = 0;
            if (list.size() == 1) {
                removeAllViews();
                addView(((O000000o) list.get(0)).O0000Oo0());
                return;
            }
            removeAllViews();
            inflate(getContext(), R.layout.decent_banner_layout, this);
            this.O0000O0o = (CircleIndicator) findViewById(R.id.indicator);
            this.O00000oo = (ViewPager) findViewById(R.id.viewpager);
            this.O00000o0 = i;
            this.O00000o = i2;
            this.O00000oO = list.size();
            i = this.O00000oO == 2 ? 4 : this.O00000oO;
            ArrayList arrayList = new ArrayList(i);
            while (i3 < i) {
                arrayList.add(((O000000o) list.get(i3 % this.O00000oO)).O0000Oo0());
                i3++;
            }
            this.O00000oo.setAdapter(new O00000Oo(O000000o, arrayList));
            this.O00000oo.setCurrentItem(gf.O000OOo0 - (gf.O000OOo0 % i));
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(this.O00000oo, new O000000o(this.O00000oo.getContext(), null, i2));
            } catch (Exception e) {
                e.printStackTrace();
            }
            O000000o();
            this.O00000oo.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 1 || action == 3) {
                        DecentBanner.this.O00000Oo();
                        DecentBanner.this.O000000o();
                    }
                    return false;
                }
            });
            this.O0000O0o.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    DecentBanner.this.O0000O0o.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    DecentBanner.this.O0000O0o.O000000o(DecentBanner.this.O00000oo, DecentBanner.this.O00000oO);
                }
            });
        }
    }

    public int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void O000000o() {
        O00000Oo();
        this.O0000OOo.sendEmptyMessageDelayed(123, (long) (this.O00000o0 * 1000));
    }

    public void O000000o(O000000o o000000o) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(o000000o);
        O00000Oo(arrayList, this.O00000o0, this.O00000o);
    }

    public void O000000o(List<O000000o> list) {
        O00000Oo(list, this.O00000o0, this.O00000o);
    }

    public void O000000o(List<O000000o> list, int i) {
        O00000Oo(list, i, this.O00000o);
    }

    public void O000000o(List<O000000o> list, int i, int i2) {
        O00000Oo(list, i, i2);
    }

    public void O00000Oo() {
        this.O0000OOo.removeMessages(123);
    }

    public void O00000o0() {
        O00000Oo();
        if (this.O00000oo != null) {
            this.O00000oo.setAdapter(null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 3) {
            switch (action) {
                case 0:
                    O00000Oo();
                    break;
                case 1:
                    break;
            }
        }
        O000000o();
        return false;
    }
}
