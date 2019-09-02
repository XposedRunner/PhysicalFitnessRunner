package com.geetest.sdk.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.geetest.sdk.GT3GeetestUtils;
import com.geetest.sdk.O00O00o;
import com.geetest.sdk.O00O0OOo;
import com.geetest.sdk.O00O0o;
import com.geetest.sdk.O0OO00O;
import com.geetest.sdk.O0Oo00;
import com.geetest.sdk.R;
import java.util.ArrayList;
import java.util.List;

public class GT3GeetestButton extends LinearLayout {
    private boolean ajaxisfinish = true;
    private boolean canDownTime = false;
    private boolean canTouch = false;
    private boolean candodododo = false;
    private Context context;
    private boolean downTime = false;
    private GT3GeetestUtils geetestUnbindHolder;
    private GT3GeetestView geetestView;
    private boolean gogogogo = true;
    private boolean islogo;
    private ImageView ivGeetestLogo;
    private final List<String> list = new ArrayList();
    private O000000o listenerImpl;
    private boolean sensorAvailable = true;
    private boolean touch = true;
    private TextView tvTestGeetest;
    private TextView tverror;
    private TextView tverrorcode;

    class O000000o implements com.geetest.sdk.O000000o.O000000o {
        O000000o() {
        }

        public final void O000000o() {
            GT3GeetestButton.this.candodododo = false;
        }

        public final void O000000o(String str, String str2) {
            GT3GeetestButton.this.candodododo = true;
            GT3GeetestButton.this.ajaxisfinish = true;
            if (GT3GeetestButton.this.context != null && !((Activity) GT3GeetestButton.this.context).isFinishing()) {
                ((Activity) GT3GeetestButton.this.context).runOnUiThread(new O0000Oo(this, str2, str));
            }
        }

        public final void O00000Oo() {
            GT3GeetestButton.this.candodododo = true;
            GT3GeetestButton.this.ajaxisfinish = true;
        }

        public final void O00000o() {
            if (GT3GeetestButton.this.context != null && !((Activity) GT3GeetestButton.this.context).isFinishing()) {
                ((Activity) GT3GeetestButton.this.context).runOnUiThread(new O0000O0o(this));
            }
        }

        public final void O00000o0() {
            GT3GeetestButton.this.ajaxisfinish = false;
            GT3GeetestButton.this.downTime = false;
            if (GT3GeetestButton.this.context != null && !((Activity) GT3GeetestButton.this.context).isFinishing()) {
                ((Activity) GT3GeetestButton.this.context).runOnUiThread(new O00000o(this));
            }
        }

        public final void O00000oO() {
            GT3GeetestButton.this.ajaxisfinish = true;
            if (GT3GeetestButton.this.context != null && !((Activity) GT3GeetestButton.this.context).isFinishing()) {
                ((Activity) GT3GeetestButton.this.context).runOnUiThread(new O0000OOo(this));
            }
        }

        public final void O00000oo() {
            GT3GeetestButton.this.candodododo = true;
            GT3GeetestButton.this.downTime = true;
            GT3GeetestButton.this.canDownTime = true;
        }

        public final void O0000O0o() {
            if (GT3GeetestButton.this.context != null && !((Activity) GT3GeetestButton.this.context).isFinishing()) {
                ((Activity) GT3GeetestButton.this.context).runOnUiThread(new O0000Oo0(this));
            }
        }

        public final void O0000OOo() {
            GT3GeetestButton.this.islogo = true;
            GT3GeetestButton.this.ivGeetestLogo.setClickable(true);
        }

        public final void O0000Oo0() {
            GT3GeetestButton.this.islogo = false;
            GT3GeetestButton.this.ivGeetestLogo.setClickable(false);
        }
    }

    public GT3GeetestButton(Context context) {
        super(context);
        init(context);
    }

    public GT3GeetestButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public GT3GeetestButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        if (TextUtils.isEmpty(O00O0o.O00000oO())) {
            O00O0o.O000000o(context);
        }
        View inflate = ((LayoutInflater) context.getApplicationContext().getSystemService("layout_inflater")).inflate(R.layout.gt3_ll_geetest_view, this);
        this.geetestView = (GT3GeetestView) inflate.findViewById(R.id.geetest_view);
        this.tverror = (TextView) inflate.findViewById(R.id.tv_test_geetest_cof);
        this.tverrorcode = (TextView) inflate.findViewById(R.id.tv_test_geetest_cord);
        this.tvTestGeetest = (TextView) inflate.findViewById(R.id.tv_test_geetest);
        this.ivGeetestLogo = (ImageView) inflate.findViewById(R.id.iv_geetest_logo);
        this.ivGeetestLogo.setOnClickListener(new O000000o(this, context));
        this.geetestView.O000000o();
        setBackgroundResource(R.drawable.gt3_lin_bg_shape);
        this.listenerImpl = new O000000o();
        O000000o o000000o = this.listenerImpl;
        GT3GeetestButton.this.candodododo = true;
        if (GT3GeetestButton.this.sensorAvailable) {
            GT3GeetestButton.this.downTime = false;
            if (!(GT3GeetestButton.this.context == null || ((Activity) GT3GeetestButton.this.context).isFinishing())) {
                ((Activity) GT3GeetestButton.this.context).runOnUiThread(new O00000Oo(o000000o));
                return;
            }
        }
        GT3GeetestButton.this.downTime = false;
        if (!(GT3GeetestButton.this.context == null || ((Activity) GT3GeetestButton.this.context).isFinishing())) {
            ((Activity) GT3GeetestButton.this.context).runOnUiThread(new O00000o0(o000000o));
        }
    }

    private String noTrueMsg() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(Integer.valueOf(0));
        arrayList.add(Integer.valueOf(0));
        arrayList.add(Integer.valueOf(0));
        arrayList.add(Integer.valueOf(0));
        return arrayList.toString();
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Context context = this.context;
        O00O00o o00O00o = new O00O00o();
        int O000000o = O0OO00O.O000000o(context, (float) O00O00o.O000000o());
        postInvalidate();
        super.onDraw(canvas);
        if (O0Oo00.O000000o(this.context)) {
            this.gogogogo = true;
        } else {
            this.gogogogo = false;
            this.geetestView.O0000OOo();
            setBackgroundResource(R.drawable.gt3_lin_file_shape);
            if (this.islogo) {
                this.ivGeetestLogo.setImageResource(R.mipmap.gt3logogray);
            }
            this.tvTestGeetest.setText(O00O0o.O00000Oo());
            this.tverrorcode.setText("201");
            this.tverrorcode.setVisibility(0);
            this.tverror.setVisibility(0);
            this.tverror.setText(O00O0o.O0000Oo());
            this.tvTestGeetest.setTextColor(-13092808);
            this.tvTestGeetest.setAlpha(1.0f);
        }
        if (this.downTime) {
            Path path = new Path();
            Paint paint = new Paint(1536);
            paint.setAntiAlias(true);
            O00O0OOo o00O0OOo = new O00O0OOo();
            paint.setColor(O00O0OOo.O0000OOo());
            paint.setStyle(Style.FILL);
            paint.setStrokeWidth(1.0f);
            path.moveTo((float) (getWidth() - O000000o), 0.0f);
            path.lineTo((float) getWidth(), 0.0f);
            path.lineTo((float) getWidth(), (float) O000000o);
            path.close();
            canvas.drawPath(path, paint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.touch) {
            this.touch = false;
            this.tverrorcode.setVisibility(8);
            this.tverror.setText(O00O0o.O0000Oo());
            this.tverror.setVisibility(8);
            this.geetestUnbindHolder.getHolder().O000000o().O00000Oo();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setGeetestUtils(GT3GeetestUtils gT3GeetestUtils) {
        this.geetestUnbindHolder = gT3GeetestUtils;
        gT3GeetestUtils.getHolder().O000000o().setButtonListener(this.listenerImpl);
    }
}
