package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.view.CropImageView;

public class HorizontalProgressWheelView extends View {
    private final Rect mCanvasClipBounds;
    private float mLastTouchedPosition;
    private int mMiddleLineColor;
    private int mProgressLineHeight;
    private int mProgressLineMargin;
    private Paint mProgressLinePaint;
    private int mProgressLineWidth;
    private boolean mScrollStarted;
    private ScrollingListener mScrollingListener;
    private float mTotalScrollDistance;

    public interface ScrollingListener {
        void onScroll(float f, float f2);

        void onScrollEnd();

        void onScrollStart();
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCanvasClipBounds = new Rect();
        init();
    }

    @TargetApi(21)
    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mCanvasClipBounds = new Rect();
    }

    private void init() {
        this.mMiddleLineColor = ContextCompat.getColor(getContext(), R.color.ucrop_color_progress_wheel_line);
        this.mProgressLineWidth = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.mProgressLineHeight = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.mProgressLineMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        this.mProgressLinePaint = new Paint(1);
        this.mProgressLinePaint.setStyle(Style.STROKE);
        this.mProgressLinePaint.setStrokeWidth((float) this.mProgressLineWidth);
    }

    private void onScrollEvent(MotionEvent motionEvent, float f) {
        this.mTotalScrollDistance -= f;
        postInvalidate();
        this.mLastTouchedPosition = motionEvent.getX();
        if (this.mScrollingListener != null) {
            this.mScrollingListener.onScroll(-f, this.mTotalScrollDistance);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        canvas.getClipBounds(this.mCanvasClipBounds);
        int width = this.mCanvasClipBounds.width() / (this.mProgressLineWidth + this.mProgressLineMargin);
        float f2 = this.mTotalScrollDistance % ((float) (this.mProgressLineMargin + this.mProgressLineWidth));
        this.mProgressLinePaint.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        for (int i = 0; i < width; i++) {
            int i2 = width / 4;
            if (i < i2) {
                this.mProgressLinePaint.setAlpha((int) (255.0f * (((float) i) / ((float) i2))));
            } else if (i > (width * 3) / 4) {
                this.mProgressLinePaint.setAlpha((int) (255.0f * (((float) (width - i)) / ((float) i2))));
            } else {
                this.mProgressLinePaint.setAlpha(255);
            }
            f = -f2;
            canvas.drawLine((((float) this.mCanvasClipBounds.left) + f) + ((float) ((this.mProgressLineWidth + this.mProgressLineMargin) * i)), ((float) this.mCanvasClipBounds.centerY()) - (((float) this.mProgressLineHeight) / 4.0f), (f + ((float) this.mCanvasClipBounds.left)) + ((float) ((this.mProgressLineWidth + this.mProgressLineMargin) * i)), ((float) this.mCanvasClipBounds.centerY()) + (((float) this.mProgressLineHeight) / 4.0f), this.mProgressLinePaint);
        }
        this.mProgressLinePaint.setColor(this.mMiddleLineColor);
        Canvas canvas2 = canvas;
        f = ((float) this.mCanvasClipBounds.centerY()) - (((float) this.mProgressLineHeight) / 2.0f);
        canvas2.drawLine((float) this.mCanvasClipBounds.centerX(), f, (float) this.mCanvasClipBounds.centerX(), (((float) this.mProgressLineHeight) / 2.0f) + ((float) this.mCanvasClipBounds.centerY()), this.mProgressLinePaint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastTouchedPosition = motionEvent.getX();
                break;
            case 1:
                if (this.mScrollingListener != null) {
                    this.mScrollStarted = false;
                    this.mScrollingListener.onScrollEnd();
                    break;
                }
                break;
            case 2:
                float x = motionEvent.getX() - this.mLastTouchedPosition;
                if (x != CropImageView.DEFAULT_ASPECT_RATIO) {
                    if (!this.mScrollStarted) {
                        this.mScrollStarted = true;
                        if (this.mScrollingListener != null) {
                            this.mScrollingListener.onScrollStart();
                        }
                    }
                    onScrollEvent(motionEvent, x);
                    break;
                }
                break;
        }
        return true;
    }

    public void setMiddleLineColor(@ColorInt int i) {
        this.mMiddleLineColor = i;
        invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.mScrollingListener = scrollingListener;
    }
}
