package com.qiyukf.nim.uikit.common.ui.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.qiyukf.nim.uikit.a;

public class MsgThumbImageView extends ImageView {
    private static final Paint b;
    private Drawable a;

    static {
        Paint paint = new Paint();
        b = paint;
        paint.setAntiAlias(true);
        b.setFilterBitmap(true);
        b.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
    }

    public MsgThumbImageView(Context context) {
        super(context);
    }

    public MsgThumbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MsgThumbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a(int i) {
        this.a = i != 0 ? ContextCompat.getDrawable(getContext(), i) : null;
    }

    private void a(int i, int i2) {
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    public final void a(int i, int i2, int i3, int i4) {
        a(i2, i3);
        a(i4);
        setImageDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    public final void a(Bitmap bitmap, int i, int i2, int i3) {
        a(i, i2);
        a(i3);
        setImageBitmap(bitmap);
    }

    public final void a(String str, int i, int i2, int i3) {
        a(i, i2);
        a(i3);
        StringBuilder stringBuilder = new StringBuilder("file://");
        stringBuilder.append(str);
        a.a(stringBuilder.toString(), (ImageView) this, i, i2);
    }

    public boolean isOpaque() {
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        if (this.a != null) {
            int width = getWidth();
            int height = getHeight();
            float f = (float) width;
            float f2 = (float) height;
            canvas.saveLayer(0.0f, 0.0f, f, f2, null, 31);
            if (this.a != null) {
                this.a.setBounds(0, 0, width, height);
                this.a.draw(canvas);
            }
            canvas.saveLayer(0.0f, 0.0f, f, f2, b, 31);
            super.onDraw(canvas);
            canvas.restore();
            canvas.restore();
            return;
        }
        super.onDraw(canvas);
    }
}
