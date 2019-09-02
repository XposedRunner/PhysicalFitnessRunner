package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IndoorFloorSwitchView */
public class ft extends ScrollView {
    public static final String O000000o = "ft";
    int O00000Oo = 1;
    private LinearLayout O00000o;
    private Context O00000o0;
    private int O00000oO = 0;
    private List<String> O00000oo;
    private int O0000O0o = -1;
    private int O0000OOo;
    private int O0000Oo = Color.parseColor("#eeffffff");
    private Bitmap O0000Oo0 = null;
    private int O0000OoO = Color.parseColor("#44383838");
    private int O0000Ooo = 4;
    private int O0000o = 50;
    private int O0000o0;
    private int O0000o00 = 1;
    private int O0000o0O;
    private Runnable O0000o0o;
    private O000000o O0000oO0;

    /* compiled from: IndoorFloorSwitchView */
    public interface O000000o {
        void O000000o(int i);
    }

    public ft(Context context) {
        super(context);
        O000000o(context);
    }

    public static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int O000000o(View view) {
        O00000Oo(view);
        return view.getMeasuredHeight();
    }

    private void O000000o(int i) {
        if (this.O00000oO != 0) {
            int i2 = (i / this.O00000oO) + this.O0000o00;
            int i3 = i % this.O00000oO;
            i /= this.O00000oO;
            if (i3 == 0) {
                i2 = this.O0000o00 + i;
            } else if (i3 > this.O00000oO / 2) {
                i2 = (i + this.O0000o00) + 1;
            }
            i = this.O00000o.getChildCount();
            i3 = 0;
            while (i3 < i) {
                TextView textView = (TextView) this.O00000o.getChildAt(i3);
                if (textView != null) {
                    if (i2 == i3) {
                        textView.setTextColor(Color.parseColor("#0288ce"));
                    } else {
                        textView.setTextColor(Color.parseColor("#bbbbbb"));
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private void O000000o(Context context) {
        this.O00000o0 = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.O0000Oo0 == null) {
                InputStream open = OOOO0OO.O000000o(context).open("map_indoor_select.png");
                this.O0000Oo0 = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable unused) {
        }
        this.O00000o = new LinearLayout(context);
        this.O00000o.setOrientation(1);
        addView(this.O00000o);
        this.O0000o0o = new Runnable() {
            public void run() {
                if (ft.this.O0000o0O - ft.this.getScrollY() != 0) {
                    ft.this.O0000o0O = ft.this.getScrollY();
                    ft.this.postDelayed(ft.this.O0000o0o, (long) ft.this.O0000o);
                } else if (ft.this.O00000oO != 0) {
                    final int O000000o = ft.this.O0000o0O % ft.this.O00000oO;
                    final int O000000o2 = ft.this.O0000o0O / ft.this.O00000oO;
                    if (O000000o == 0) {
                        ft.this.O00000Oo = O000000o2 + ft.this.O0000o00;
                        ft.this.O0000O0o();
                    } else if (O000000o > ft.this.O00000oO / 2) {
                        ft.this.post(new Runnable() {
                            public void run() {
                                ft.this.smoothScrollTo(0, (ft.this.O0000o0O - O000000o) + ft.this.O00000oO);
                                ft.this.O00000Oo = (O000000o2 + ft.this.O0000o00) + 1;
                                ft.this.O0000O0o();
                            }
                        });
                    } else {
                        ft.this.post(new Runnable() {
                            public void run() {
                                ft.this.smoothScrollTo(0, ft.this.O0000o0O - O000000o);
                                ft.this.O00000Oo = O000000o2 + ft.this.O0000o00;
                                ft.this.O0000O0o();
                            }
                        });
                    }
                }
            }
        };
    }

    private TextView O00000Oo(String str) {
        View textView = new TextView(this.O00000o0);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int O000000o = O000000o(this.O00000o0, 8.0f);
        int O000000o2 = O000000o(this.O00000o0, 6.0f);
        textView.setPadding(O000000o, O000000o2, O000000o, O000000o2);
        if (this.O00000oO == 0) {
            this.O00000oO = O000000o(textView);
            this.O00000o.setLayoutParams(new LayoutParams(-2, this.O00000oO * this.O0000o0));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.O00000oO * this.O0000o0));
        }
        return textView;
    }

    public static void O00000Oo(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    private void O00000oO() {
        if (this.O00000oo != null && this.O00000oo.size() != 0) {
            this.O00000o.removeAllViews();
            this.O0000o0 = (this.O0000o00 * 2) + 1;
            for (int size = this.O00000oo.size() - 1; size >= 0; size--) {
                this.O00000o.addView(O00000Oo((String) this.O00000oo.get(size)));
            }
            O000000o(0);
        }
    }

    private int[] O00000oo() {
        return new int[]{this.O00000oO * this.O0000o00, this.O00000oO * (this.O0000o00 + 1)};
    }

    private void O0000O0o() {
        if (this.O0000oO0 != null) {
            try {
                this.O0000oO0.O000000o(O00000o0());
            } catch (Throwable unused) {
            }
        }
    }

    public void O000000o() {
        this.O0000o0O = getScrollY();
        postDelayed(this.O0000o0o, (long) this.O0000o);
    }

    public void O000000o(O000000o o000000o) {
        this.O0000oO0 = o000000o;
    }

    public void O000000o(String str) {
        if (this.O00000oo != null && this.O00000oo.size() != 0) {
            final int size = ((this.O00000oo.size() - this.O0000o00) - 1) - this.O00000oo.indexOf(str);
            this.O00000Oo = this.O0000o00 + size;
            post(new Runnable() {
                public void run() {
                    ft.this.smoothScrollTo(0, size * ft.this.O00000oO);
                }
            });
        }
    }

    public void O000000o(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public void O000000o(String[] strArr) {
        if (this.O00000oo == null) {
            this.O00000oo = new ArrayList();
        }
        this.O00000oo.clear();
        for (Object add : strArr) {
            this.O00000oo.add(add);
        }
        for (int i = 0; i < this.O0000o00; i++) {
            this.O00000oo.add(0, "");
            this.O00000oo.add("");
        }
        O00000oO();
    }

    public void O00000Oo() {
        if (!(this.O0000Oo0 == null || this.O0000Oo0.isRecycled())) {
            this.O0000Oo0.recycle();
            this.O0000Oo0 = null;
        }
        if (this.O0000oO0 != null) {
            this.O0000oO0 = null;
        }
    }

    public boolean O00000o() {
        return getVisibility() == 0;
    }

    public int O00000o0() {
        if (this.O00000oo == null || this.O00000oo.size() == 0) {
            return 0;
        }
        return Math.min(this.O00000oo.size() - (2 * this.O0000o00), Math.max(0, ((this.O00000oo.size() - 1) - this.O00000Oo) - this.O0000o00));
    }

    public void fling(int i) {
        super.fling(i / 3);
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        O000000o(i2);
        if (i2 > i4) {
            this.O0000O0o = 1;
        } else {
            this.O0000O0o = 0;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.O0000OOo = i;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            O000000o();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i) {
        this.O0000Oo = i;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.O0000OOo == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.O00000o0.getSystemService("window");
                if (windowManager != null) {
                    this.O0000OOo = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new Drawable() {
            private void O000000o(Canvas canvas) {
                canvas.drawColor(ft.this.O0000Oo);
            }

            private void O00000Oo(Canvas canvas) {
                Paint paint = new Paint();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                rect.left = 0;
                rect.top = 0;
                rect.right = ft.this.O0000Oo0.getWidth() + 0;
                rect.bottom = ft.this.O0000Oo0.getHeight() + 0;
                rect2.left = 0;
                rect2.top = ft.this.O00000oo()[0];
                rect2.right = 0 + ft.this.O0000OOo;
                rect2.bottom = ft.this.O00000oo()[1];
                canvas.drawBitmap(ft.this.O0000Oo0, rect, rect2, paint);
            }

            private void O00000o0(Canvas canvas) {
                Paint paint = new Paint();
                Rect clipBounds = canvas.getClipBounds();
                paint.setColor(ft.this.O0000OoO);
                paint.setStyle(Style.STROKE);
                paint.setStrokeWidth((float) ft.this.O0000Ooo);
                canvas.drawRect(clipBounds, paint);
            }

            public void draw(Canvas canvas) {
                try {
                    O000000o(canvas);
                    O00000Oo(canvas);
                    O00000o0(canvas);
                } catch (Throwable unused) {
                }
            }

            public int getOpacity() {
                return 0;
            }

            public void setAlpha(int i) {
            }

            public void setColorFilter(ColorFilter colorFilter) {
            }
        });
    }
}
