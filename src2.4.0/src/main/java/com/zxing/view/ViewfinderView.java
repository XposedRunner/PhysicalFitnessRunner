package com.zxing.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.google.zxing.ResultPoint;
import com.qf.qrcode.R;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.yalantis.ucrop.view.CropImageView;
import defpackage.mc;
import java.util.Collection;
import java.util.HashSet;

public final class ViewfinderView extends View {
    private static final int[] O000000o = new int[]{0, 64, 128, 192, O00000o0, 192, 128, 64};
    private static final long O00000Oo = 100;
    private static final int O00000o0 = 255;
    private static float O0000o = 0.0f;
    private static final int O0000o0o = 6;
    private final Paint O00000o = new Paint();
    private Bitmap O00000oO;
    private final int O00000oo;
    private final int O0000O0o;
    private final int O0000OOo;
    private final int O0000Oo;
    private final int O0000Oo0;
    private int O0000OoO;
    private int O0000Ooo;
    private Collection<ResultPoint> O0000o0;
    private Collection<ResultPoint> O0000o00;
    private int O0000o0O;
    private int O0000oO0 = 0;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.O00000oo = resources.getColor(R.color.viewfinder_mask);
        this.O0000O0o = resources.getColor(R.color.result_view);
        this.O0000OOo = resources.getColor(R.color.viewfinder_frame);
        this.O0000Oo0 = resources.getColor(R.color.viewfinder_laser);
        this.O0000Oo = resources.getColor(R.color.possible_result_points);
        this.O0000OoO = 0;
        this.O0000o00 = new HashSet(5);
        O0000o = context.getResources().getDisplayMetrics().density;
        this.O0000o0O = (int) (20.0f * O0000o);
        this.O0000Ooo = O000000o(8.0f);
    }

    private int O000000o(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void O000000o() {
        this.O00000oO = null;
        invalidate();
    }

    public void O000000o(Bitmap bitmap) {
        this.O00000oO = bitmap;
        invalidate();
    }

    public void O000000o(ResultPoint resultPoint) {
        this.O0000o00.add(resultPoint);
    }

    public void onDraw(Canvas canvas) {
        Rect O00000oO = mc.O000000o().O00000oO();
        if (O00000oO != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.O00000o.setColor(this.O00000oO != null ? this.O0000O0o : this.O00000oo);
            float f = (float) width;
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, (float) O00000oO.top, this.O00000o);
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, (float) O00000oO.top, (float) O00000oO.left, (float) (O00000oO.bottom + 1), this.O00000o);
            float f2 = f;
            canvas.drawRect((float) (O00000oO.right + 1), (float) O00000oO.top, f2, (float) (O00000oO.bottom + 1), this.O00000o);
            canvas.drawRect(CropImageView.DEFAULT_ASPECT_RATIO, (float) (O00000oO.bottom + 1), f2, (float) height, this.O00000o);
            if (this.O00000oO != null) {
                this.O00000o.setAlpha(O00000o0);
                canvas.drawBitmap(this.O00000oO, (float) O00000oO.left, (float) O00000oO.top, this.O00000o);
            } else {
                this.O00000o.setColor(this.O0000OOo);
                canvas.drawRect((float) O00000oO.left, (float) O00000oO.top, (float) (O00000oO.right + 1), (float) (O00000oO.top + 2), this.O00000o);
                canvas.drawRect((float) O00000oO.left, (float) (O00000oO.top + 2), (float) (O00000oO.left + 2), (float) (O00000oO.bottom - 1), this.O00000o);
                canvas.drawRect((float) (O00000oO.right - 1), (float) O00000oO.top, (float) (O00000oO.right + 1), (float) (O00000oO.bottom - 1), this.O00000o);
                canvas.drawRect((float) O00000oO.left, (float) (O00000oO.bottom - 1), (float) (O00000oO.right + 1), (float) (O00000oO.bottom + 1), this.O00000o);
                this.O00000o.setColor(this.O0000Oo0);
                width = (this.O0000oO0 % O00000oO.height()) + O00000oO.top;
                canvas.drawRect((float) ((O00000oO.left + 2) + this.O0000Ooo), (float) (width - 1), (float) ((O00000oO.right - 1) - this.O0000Ooo), (float) (width + 2), this.O00000o);
                this.O0000oO0 += 4;
                invalidate();
                this.O00000o.setColor(this.O0000Oo0);
                canvas.drawRect((float) O00000oO.left, (float) O00000oO.top, (float) (O00000oO.left + this.O0000o0O), (float) (O00000oO.top + 6), this.O00000o);
                Path path = new Path();
                path.moveTo((float) (O00000oO.left + this.O0000o0O), (float) O00000oO.top);
                path.lineTo((float) (O00000oO.left + this.O0000o0O), (float) (O00000oO.top + 6));
                path.lineTo((float) ((O00000oO.left + this.O0000o0O) + 6), (float) O00000oO.top);
                canvas.drawPath(path, this.O00000o);
                canvas.drawRect((float) O00000oO.left, (float) O00000oO.top, (float) (O00000oO.left + 6), (float) (O00000oO.top + this.O0000o0O), this.O00000o);
                path = new Path();
                path.moveTo((float) O00000oO.left, (float) (O00000oO.top + this.O0000o0O));
                path.lineTo((float) (O00000oO.left + 6), (float) (O00000oO.top + this.O0000o0O));
                path.lineTo((float) O00000oO.left, (float) ((O00000oO.top + this.O0000o0O) + 6));
                canvas.drawPath(path, this.O00000o);
                canvas.drawRect((float) (O00000oO.right - this.O0000o0O), (float) O00000oO.top, (float) O00000oO.right, (float) (O00000oO.top + 6), this.O00000o);
                path = new Path();
                path.moveTo((float) (O00000oO.right - this.O0000o0O), (float) O00000oO.top);
                path.lineTo((float) (O00000oO.right - this.O0000o0O), (float) (O00000oO.top + 6));
                path.lineTo((float) ((O00000oO.right - this.O0000o0O) - 6), (float) O00000oO.top);
                canvas.drawPath(path, this.O00000o);
                canvas.drawRect((float) (O00000oO.right - 6), (float) O00000oO.top, (float) O00000oO.right, (float) (O00000oO.top + this.O0000o0O), this.O00000o);
                path = new Path();
                path.moveTo((float) O00000oO.right, (float) (O00000oO.top + this.O0000o0O));
                path.lineTo((float) (O00000oO.right - 6), (float) (O00000oO.top + this.O0000o0O));
                path.lineTo((float) O00000oO.right, (float) ((O00000oO.top + this.O0000o0O) + 6));
                canvas.drawPath(path, this.O00000o);
                canvas.drawRect((float) O00000oO.left, (float) (O00000oO.bottom - 6), (float) (O00000oO.left + this.O0000o0O), (float) O00000oO.bottom, this.O00000o);
                path = new Path();
                path.moveTo((float) (O00000oO.left + this.O0000o0O), (float) O00000oO.bottom);
                path.lineTo((float) (O00000oO.left + this.O0000o0O), (float) (O00000oO.bottom - 6));
                path.lineTo((float) ((O00000oO.left + this.O0000o0O) + 6), (float) O00000oO.bottom);
                canvas.drawPath(path, this.O00000o);
                canvas.drawRect((float) O00000oO.left, (float) (O00000oO.bottom - this.O0000o0O), (float) (O00000oO.left + 6), (float) O00000oO.bottom, this.O00000o);
                path = new Path();
                path.moveTo((float) O00000oO.left, (float) (O00000oO.bottom - this.O0000o0O));
                path.lineTo((float) (O00000oO.left + 6), (float) (O00000oO.bottom - this.O0000o0O));
                path.lineTo((float) O00000oO.left, (float) ((O00000oO.bottom - this.O0000o0O) - 6));
                canvas.drawPath(path, this.O00000o);
                canvas.drawRect((float) (O00000oO.right - this.O0000o0O), (float) (O00000oO.bottom - 6), (float) O00000oO.right, (float) O00000oO.bottom, this.O00000o);
                path = new Path();
                path.moveTo((float) (O00000oO.right - this.O0000o0O), (float) O00000oO.bottom);
                path.lineTo((float) (O00000oO.right - this.O0000o0O), (float) (O00000oO.bottom - 6));
                path.lineTo((float) ((O00000oO.right - this.O0000o0O) - 6), (float) O00000oO.bottom);
                canvas.drawPath(path, this.O00000o);
                canvas.drawRect((float) (O00000oO.right - 6), (float) (O00000oO.bottom - this.O0000o0O), (float) O00000oO.right, (float) O00000oO.bottom, this.O00000o);
                path = new Path();
                path.moveTo((float) O00000oO.right, (float) (O00000oO.bottom - this.O0000o0O));
                path.lineTo((float) (O00000oO.right - 6), (float) (O00000oO.bottom - this.O0000o0O));
                path.lineTo((float) O00000oO.right, (float) ((O00000oO.bottom - this.O0000o0O) - 6));
                canvas.drawPath(path, this.O00000o);
                this.O00000o.setColor(getResources().getColor(R.color.grgray));
                this.O00000o.setTextSize(12.0f * O0000o);
                this.O00000o.setAlpha(200);
                this.O00000o.setTypeface(Typeface.create("System", 1));
                String str = "请将二维码放入框内，即可自动扫描";
                Rect rect = new Rect();
                this.O00000o.getTextBounds(str, 0, str.length(), rect);
                canvas.drawText(str, (float) ((((O00000oO.right - O00000oO.left) / 2) + O00000oO.left) - (rect.width() / 2)), ((float) O00000oO.bottom) + (24.0f * O0000o), this.O00000o);
                Collection<ResultPoint> collection = this.O0000o00;
                Collection<ResultPoint> collection2 = this.O0000o0;
                if (collection.isEmpty()) {
                    this.O0000o0 = null;
                } else {
                    this.O0000o00 = new HashSet(5);
                    this.O0000o0 = collection;
                    this.O00000o.setAlpha(O00000o0);
                    this.O00000o.setColor(this.O0000Oo);
                    for (ResultPoint resultPoint : collection) {
                        canvas.drawCircle(((float) O00000oO.left) + resultPoint.getX(), ((float) O00000oO.top) + resultPoint.getY(), 6.0f, this.O00000o);
                    }
                }
                if (collection2 != null) {
                    this.O00000o.setAlpha(XmPlayerService.CODE_GET_RADIO_SCHEDULES);
                    this.O00000o.setColor(this.O0000Oo);
                    for (ResultPoint resultPoint2 : collection2) {
                        canvas.drawCircle(((float) O00000oO.left) + resultPoint2.getX(), ((float) O00000oO.top) + resultPoint2.getY(), 3.0f, this.O00000o);
                    }
                }
                postInvalidateDelayed(O00000Oo, O00000oO.left, O00000oO.top, O00000oO.right, O00000oO.bottom);
            }
        }
    }
}
