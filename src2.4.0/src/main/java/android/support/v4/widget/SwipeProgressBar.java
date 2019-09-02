package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

final class SwipeProgressBar {
    private static final int ANIMATION_DURATION_MS = 2000;
    private static final int COLOR1 = -1291845632;
    private static final int COLOR2 = Integer.MIN_VALUE;
    private static final int COLOR3 = 1291845632;
    private static final int COLOR4 = 436207616;
    private static final int FINISH_ANIMATION_DURATION_MS = 1000;
    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();
    private Rect mBounds = new Rect();
    private final RectF mClipRect = new RectF();
    private int mColor1;
    private int mColor2;
    private int mColor3;
    private int mColor4;
    private long mFinishTime;
    private final Paint mPaint = new Paint();
    private View mParent;
    private boolean mRunning;
    private long mStartTime;
    private float mTriggerPercentage;

    SwipeProgressBar(View view) {
        this.mParent = view;
        this.mColor1 = COLOR1;
        this.mColor2 = Integer.MIN_VALUE;
        this.mColor3 = COLOR3;
        this.mColor4 = COLOR4;
    }

    private void drawCircle(Canvas canvas, float f, float f2, int i, float f3) {
        this.mPaint.setColor(i);
        canvas.save();
        canvas.translate(f, f2);
        f2 = INTERPOLATOR.getInterpolation(f3);
        canvas.scale(f2, f2);
        canvas.drawCircle(0.0f, 0.0f, f, this.mPaint);
        canvas.restore();
    }

    private void drawTrigger(Canvas canvas, int i, int i2) {
        this.mPaint.setColor(this.mColor1);
        float f = (float) i;
        canvas.drawCircle(f, (float) i2, this.mTriggerPercentage * f, this.mPaint);
    }

    /* Access modifiers changed, original: 0000 */
    public void draw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = this.mBounds.width();
        int height = this.mBounds.height();
        int i = width / 2;
        int i2 = height / 2;
        int save = canvas.save();
        canvas2.clipRect(this.mBounds);
        if (this.mRunning || this.mFinishTime > 0) {
            Canvas canvas3;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j = (currentAnimationTimeMillis - this.mStartTime) / 2000;
            float f = ((float) ((currentAnimationTimeMillis - this.mStartTime) % 2000)) / 20.0f;
            Object obj;
            if (this.mRunning) {
                obj = null;
            } else if (currentAnimationTimeMillis - this.mFinishTime >= 1000) {
                this.mFinishTime = 0;
                return;
            } else {
                float f2 = (float) i;
                float interpolation = INTERPOLATOR.getInterpolation((((float) ((currentAnimationTimeMillis - this.mFinishTime) % 1000)) / 10.0f) / 100.0f) * f2;
                this.mClipRect.set(f2 - interpolation, 0.0f, f2 + interpolation, (float) height);
                canvas2.saveLayerAlpha(this.mClipRect, 0, 0);
                obj = 1;
            }
            if (j == 0) {
                canvas2.drawColor(this.mColor1);
            } else if (f >= 0.0f && f < 25.0f) {
                canvas2.drawColor(this.mColor4);
            } else if (f >= 25.0f && f < 50.0f) {
                canvas2.drawColor(this.mColor1);
            } else if (f < 50.0f || f >= 75.0f) {
                canvas2.drawColor(this.mColor3);
            } else {
                canvas2.drawColor(this.mColor2);
            }
            if (f >= 0.0f && f <= 25.0f) {
                canvas3 = canvas2;
                drawCircle(canvas3, (float) i, (float) i2, this.mColor1, ((f + 25.0f) * 2.0f) / 100.0f);
            }
            if (f >= 0.0f && f <= 50.0f) {
                canvas3 = canvas2;
                drawCircle(canvas3, (float) i, (float) i2, this.mColor2, (f * 2.0f) / 100.0f);
            }
            if (f >= 25.0f && f <= 75.0f) {
                canvas3 = canvas2;
                drawCircle(canvas3, (float) i, (float) i2, this.mColor3, ((f - 25.0f) * 2.0f) / 100.0f);
            }
            if (f >= 50.0f && f <= 100.0f) {
                canvas3 = canvas2;
                drawCircle(canvas3, (float) i, (float) i2, this.mColor4, ((f - 50.0f) * 2.0f) / 100.0f);
            }
            if (f >= 75.0f && f <= 100.0f) {
                canvas3 = canvas2;
                drawCircle(canvas3, (float) i, (float) i2, this.mColor1, ((f - 75.0f) * 2.0f) / 100.0f);
            }
            if (this.mTriggerPercentage > 0.0f && obj != null) {
                canvas2.restoreToCount(save);
                width = canvas.save();
                canvas2.clipRect(this.mBounds);
                drawTrigger(canvas2, i, i2);
                save = width;
            }
            ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
        } else if (this.mTriggerPercentage > 0.0f && ((double) this.mTriggerPercentage) <= 1.0d) {
            drawTrigger(canvas2, i, i2);
        }
        canvas2.restoreToCount(save);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean isRunning() {
        return this.mRunning || this.mFinishTime > 0;
    }

    /* Access modifiers changed, original: 0000 */
    public void setBounds(int i, int i2, int i3, int i4) {
        this.mBounds.left = i;
        this.mBounds.top = i2;
        this.mBounds.right = i3;
        this.mBounds.bottom = i4;
    }

    /* Access modifiers changed, original: 0000 */
    public void setColorScheme(int i, int i2, int i3, int i4) {
        this.mColor1 = i;
        this.mColor2 = i2;
        this.mColor3 = i3;
        this.mColor4 = i4;
    }

    /* Access modifiers changed, original: 0000 */
    public void setTriggerPercentage(float f) {
        this.mTriggerPercentage = f;
        this.mStartTime = 0;
        ViewCompat.postInvalidateOnAnimation(this.mParent, this.mBounds.left, this.mBounds.top, this.mBounds.right, this.mBounds.bottom);
    }

    /* Access modifiers changed, original: 0000 */
    public void start() {
        if (!this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = true;
            this.mParent.postInvalidate();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void stop() {
        if (this.mRunning) {
            this.mTriggerPercentage = 0.0f;
            this.mFinishTime = AnimationUtils.currentAnimationTimeMillis();
            this.mRunning = false;
            this.mParent.postInvalidate();
        }
    }
}
