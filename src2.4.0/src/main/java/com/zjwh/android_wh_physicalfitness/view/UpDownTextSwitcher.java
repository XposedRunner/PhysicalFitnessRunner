package com.zjwh.android_wh_physicalfitness.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import com.zjwh.android_wh_physicalfitness.R;
import java.lang.ref.WeakReference;
import java.util.List;

public class UpDownTextSwitcher extends TextSwitcher {
    private static final int O000000o = 123;
    private Handler O00000Oo = new O000000o(this);
    private int O00000o = 1;
    private List<String> O00000o0;
    private float O00000oO = 16.0f;
    private int O00000oo;

    private static class O000000o extends Handler {
        private final WeakReference<UpDownTextSwitcher> O000000o;

        O000000o(UpDownTextSwitcher upDownTextSwitcher) {
            this.O000000o = new WeakReference(upDownTextSwitcher);
        }

        public void handleMessage(Message message) {
            if (this.O000000o.get() != null && message.what == 123) {
                UpDownTextSwitcher upDownTextSwitcher = (UpDownTextSwitcher) this.O000000o.get();
                upDownTextSwitcher.setText(message.obj.toString());
                upDownTextSwitcher.setTag(Integer.valueOf(upDownTextSwitcher.O00000o % upDownTextSwitcher.O00000o0.size()));
                upDownTextSwitcher.setCurPosition(UpDownTextSwitcher.O00000o0(upDownTextSwitcher));
                upDownTextSwitcher.O000000o();
            }
        }
    }

    public UpDownTextSwitcher(Context context) {
        super(context);
        O000000o(context, null);
    }

    public UpDownTextSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet);
    }

    private void O000000o(final Context context, AttributeSet attributeSet) {
        this.O00000oO = TypedValue.applyDimension(2, this.O00000oO, getResources().getDisplayMetrics());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UpDownTextSwitcher);
        this.O00000oO = obtainStyledAttributes.getDimension(1, this.O00000oO);
        this.O00000oo = obtainStyledAttributes.getColor(0, ContextCompat.getColor(context, R.color.red));
        obtainStyledAttributes.recycle();
        setInAnimation(AnimationUtils.loadAnimation(context, R.anim.textswitcher_in));
        setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.textswitcher_out));
        setFactory(new ViewFactory() {
            public View makeView() {
                TextView textView = new TextView(context);
                textView.setTextColor(UpDownTextSwitcher.this.O00000oo);
                textView.setGravity(16);
                textView.setTextSize(0, UpDownTextSwitcher.this.O00000oO);
                textView.setSingleLine();
                textView.setEllipsize(TruncateAt.END);
                textView.setLayoutParams(new LayoutParams(-1, -1));
                return textView;
            }
        });
    }

    static /* synthetic */ int O00000o0(UpDownTextSwitcher upDownTextSwitcher) {
        int i = upDownTextSwitcher.O00000o + 1;
        upDownTextSwitcher.O00000o = i;
        return i;
    }

    public void O000000o() {
        if (this.O00000o0 != null && this.O00000o0.size() > 1) {
            O00000Oo();
            Message obtainMessage = this.O00000Oo.obtainMessage();
            obtainMessage.what = 123;
            obtainMessage.obj = this.O00000o0.get(this.O00000o % this.O00000o0.size());
            this.O00000Oo.sendMessageDelayed(obtainMessage, 3000);
        }
    }

    public void O00000Oo() {
        this.O00000Oo.removeMessages(123);
    }

    public void setCurPosition(int i) {
        this.O00000o = i;
    }

    public void setMessage(List<String> list) {
        this.O00000o0 = list;
    }
}
