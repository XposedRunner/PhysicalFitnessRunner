package com.qiyukf.nim.uikit.session.helper;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.TextView;

public final class a implements OnTouchListener {
    private a a;
    private boolean b;

    private class a implements Runnable {
        private View b;

        a(View view) {
            this.b = view;
        }

        public final void run() {
            View view = this.b;
            while (!view.performLongClick() && (view.getParent() instanceof View)) {
                view = (View) view.getParent();
            }
            a.this.b = false;
        }
    }

    public static a a() {
        return new a();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a == null) {
            this.a = new a(view);
        }
        TextView textView = (TextView) view;
        textView.setMovementMethod(null);
        Spannable newSpannable = Factory.getInstance().newSpannable(textView.getText());
        int action = motionEvent.getAction();
        if (action == 0 || action == 1 || action == 3) {
            int x = (int) motionEvent.getX();
            x = (x - textView.getTotalPaddingLeft()) + textView.getScrollX();
            int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
            Layout layout = textView.getLayout();
            y = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(y, y, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (action == 0) {
                    this.b = true;
                    view.postDelayed(this.a, (long) ViewConfiguration.getLongPressTimeout());
                    return true;
                }
                if (this.b) {
                    view.removeCallbacks(this.a);
                    if (action == 1) {
                        try {
                            clickableSpanArr[0].onClick(textView);
                        } catch (Throwable unused) {
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
