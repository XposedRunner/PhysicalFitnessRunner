package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;

public class OverlayView extends View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final boolean DEFAULT_FREESTYLE_CROP_ENABLED = false;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    private OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private Path mCircularPath;
    private Paint mCropFrameCornersPaint;
    private Paint mCropFramePaint;
    protected float[] mCropGridCenter;
    private int mCropGridColumnCount;
    protected float[] mCropGridCorners;
    private Paint mCropGridPaint;
    private int mCropGridRowCount;
    private int mCropRectCornerTouchAreaLineLength;
    private int mCropRectMinSize;
    private final RectF mCropViewRect;
    private int mCurrentTouchCornerIndex;
    private int mDimmedColor;
    private Paint mDimmedStrokePaint;
    private float[] mGridPoints;
    private boolean mIsFreestyleCropEnabled;
    private float mPreviousTouchX;
    private float mPreviousTouchY;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private float mTargetAspectRatio;
    private final RectF mTempRect;
    protected int mThisHeight;
    protected int mThisWidth;
    private int mTouchPointThreshold;

    public OverlayView(Context context) {
        this(context, null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCropViewRect = new RectF();
        this.mTempRect = new RectF();
        this.mGridPoints = null;
        this.mCircularPath = new Path();
        this.mDimmedStrokePaint = new Paint(1);
        this.mCropGridPaint = new Paint(1);
        this.mCropFramePaint = new Paint(1);
        this.mCropFrameCornersPaint = new Paint(1);
        this.mIsFreestyleCropEnabled = false;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        this.mTouchPointThreshold = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        init();
    }

    private int getCurrentTouchIndex(float f, float f2) {
        double d = (double) this.mTouchPointThreshold;
        int i = -1;
        for (int i2 = 0; i2 < 8; i2 += 2) {
            double sqrt = Math.sqrt(Math.pow((double) (f - this.mCropGridCorners[i2]), 2.0d) + Math.pow((double) (f2 - this.mCropGridCorners[i2 + 1]), 2.0d));
            if (sqrt < d) {
                i = i2 / 2;
                d = sqrt;
            }
        }
        return (i >= 0 || !this.mCropViewRect.contains(f, f2)) ? i : 4;
    }

    private void initCropFrameStyle(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth((float) dimensionPixelSize);
        this.mCropFramePaint.setColor(color);
        this.mCropFramePaint.setStyle(Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth((float) (dimensionPixelSize * 3));
        this.mCropFrameCornersPaint.setColor(color);
        this.mCropFrameCornersPaint.setStyle(Style.STROKE);
    }

    private void initCropGridStyle(@NonNull TypedArray typedArray) {
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth((float) dimensionPixelSize);
        this.mCropGridPaint.setColor(color);
        this.mCropGridRowCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void updateCropViewRect(float f, float f2) {
        this.mTempRect.set(this.mCropViewRect);
        switch (this.mCurrentTouchCornerIndex) {
            case 0:
                this.mTempRect.set(f, f2, this.mCropViewRect.right, this.mCropViewRect.bottom);
                break;
            case 1:
                this.mTempRect.set(this.mCropViewRect.left, f2, f, this.mCropViewRect.bottom);
                break;
            case 2:
                this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, f, f2);
                break;
            case 3:
                this.mTempRect.set(f, this.mCropViewRect.top, this.mCropViewRect.right, f2);
                break;
            case 4:
                this.mTempRect.offset(f - this.mPreviousTouchX, f2 - this.mPreviousTouchY);
                if (this.mTempRect.left > ((float) getLeft()) && this.mTempRect.top > ((float) getTop()) && this.mTempRect.right < ((float) getRight()) && this.mTempRect.bottom < ((float) getBottom())) {
                    this.mCropViewRect.set(this.mTempRect);
                    updateGridPoints();
                    postInvalidate();
                }
                return;
        }
        Object obj = null;
        Object obj2 = this.mTempRect.height() >= ((float) this.mCropRectMinSize) ? 1 : null;
        if (this.mTempRect.width() >= ((float) this.mCropRectMinSize)) {
            obj = 1;
        }
        this.mCropViewRect.set((obj != null ? this.mTempRect : this.mCropViewRect).left, (obj2 != null ? this.mTempRect : this.mCropViewRect).top, (obj != null ? this.mTempRect : this.mCropViewRect).right, (obj2 != null ? this.mTempRect : this.mCropViewRect).bottom);
        if (!(obj2 == null && obj == null)) {
            updateGridPoints();
            postInvalidate();
        }
    }

    private void updateGridPoints() {
        this.mCropGridCorners = RectUtils.getCornersFromRect(this.mCropViewRect);
        this.mCropGridCenter = RectUtils.getCenterFromRect(this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, Direction.CW);
    }

    /* Access modifiers changed, original: protected */
    public void drawCropGrid(@NonNull Canvas canvas) {
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                int i;
                this.mGridPoints = new float[((this.mCropGridRowCount * 4) + (this.mCropGridColumnCount * 4))];
                int i2 = 0;
                int i3 = 0;
                int i4 = i3;
                while (i3 < this.mCropGridRowCount) {
                    int i5 = i4 + 1;
                    this.mGridPoints[i4] = this.mCropViewRect.left;
                    i = i5 + 1;
                    float f = ((float) i3) + 1.0f;
                    this.mGridPoints[i5] = (this.mCropViewRect.height() * (f / ((float) (this.mCropGridRowCount + 1)))) + this.mCropViewRect.top;
                    int i6 = i + 1;
                    this.mGridPoints[i] = this.mCropViewRect.right;
                    i = i6 + 1;
                    this.mGridPoints[i6] = (this.mCropViewRect.height() * (f / ((float) (this.mCropGridRowCount + 1)))) + this.mCropViewRect.top;
                    i3++;
                    i4 = i;
                }
                while (i2 < this.mCropGridColumnCount) {
                    i = i4 + 1;
                    float f2 = ((float) i2) + 1.0f;
                    this.mGridPoints[i4] = (this.mCropViewRect.width() * (f2 / ((float) (this.mCropGridColumnCount + 1)))) + this.mCropViewRect.left;
                    i4 = i + 1;
                    this.mGridPoints[i] = this.mCropViewRect.top;
                    i = i4 + 1;
                    this.mGridPoints[i4] = (this.mCropViewRect.width() * (f2 / ((float) (this.mCropGridColumnCount + 1)))) + this.mCropViewRect.left;
                    i4 = i + 1;
                    this.mGridPoints[i] = this.mCropViewRect.bottom;
                    i2++;
                }
            }
            if (this.mGridPoints != null) {
                canvas.drawLines(this.mGridPoints, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mIsFreestyleCropEnabled) {
            canvas.save();
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset((float) this.mCropRectCornerTouchAreaLineLength, (float) (-this.mCropRectCornerTouchAreaLineLength));
            canvas.clipRect(this.mTempRect, Op.DIFFERENCE);
            this.mTempRect.set(this.mCropViewRect);
            this.mTempRect.inset((float) (-this.mCropRectCornerTouchAreaLineLength), (float) this.mCropRectCornerTouchAreaLineLength);
            canvas.clipRect(this.mTempRect, Op.DIFFERENCE);
            canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
            canvas.restore();
        }
    }

    /* Access modifiers changed, original: protected */
    public void drawDimmedLayer(@NonNull Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (this.mCircleDimmedLayer) {
            canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
        }
    }

    @NonNull
    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        if (VERSION.SDK_INT < 18 && VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    public boolean isFreestyleCropEnabled() {
        return this.mIsFreestyleCropEnabled;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDimmedLayer(canvas);
        drawCropGrid(canvas);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int paddingLeft = getPaddingLeft();
            i = getPaddingTop();
            i3 = getHeight() - getPaddingBottom();
            this.mThisWidth = (getWidth() - getPaddingRight()) - paddingLeft;
            this.mThisHeight = i3 - i;
            if (this.mShouldSetupCropBounds) {
                this.mShouldSetupCropBounds = false;
                setTargetAspectRatio(this.mTargetAspectRatio);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.mCropViewRect.isEmpty() || !this.mIsFreestyleCropEnabled) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if ((motionEvent.getAction() & 255) == 0) {
            if (this.mPreviousTouchX < CropImageView.DEFAULT_ASPECT_RATIO) {
                this.mPreviousTouchX = x;
                this.mPreviousTouchY = y;
            }
            this.mCurrentTouchCornerIndex = getCurrentTouchIndex(x, y);
            if (this.mCurrentTouchCornerIndex != -1) {
                z = true;
            }
            return z;
        } else if ((motionEvent.getAction() & 255) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
            float min = Math.min(Math.max(x, (float) getPaddingLeft()), (float) (getWidth() - getPaddingRight()));
            x = Math.min(Math.max(y, (float) getPaddingTop()), (float) (getHeight() - getPaddingBottom()));
            updateCropViewRect(min, x);
            this.mPreviousTouchX = min;
            this.mPreviousTouchY = x;
            return true;
        } else {
            if ((motionEvent.getAction() & 255) == 1) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
                this.mCurrentTouchCornerIndex = -1;
                if (this.mCallback != null) {
                    this.mCallback.onCropRectUpdated(this.mCropViewRect);
                }
            }
            return false;
        }
    }

    /* Access modifiers changed, original: protected */
    public void processStyledAttributes(@NonNull TypedArray typedArray) {
        this.mCircleDimmedLayer = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        this.mDimmedColor = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.mDimmedStrokePaint.setColor(this.mDimmedColor);
        this.mDimmedStrokePaint.setStyle(Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth(1.0f);
        initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void setCircleDimmedLayer(boolean z) {
        this.mCircleDimmedLayer = z;
    }

    public void setCropFrameColor(@ColorInt int i) {
        this.mCropFramePaint.setColor(i);
    }

    public void setCropFrameStrokeWidth(@IntRange(from = 0) int i) {
        this.mCropFramePaint.setStrokeWidth((float) i);
    }

    public void setCropGridColor(@ColorInt int i) {
        this.mCropGridPaint.setColor(i);
    }

    public void setCropGridColumnCount(@IntRange(from = 0) int i) {
        this.mCropGridColumnCount = i;
        this.mGridPoints = null;
    }

    public void setCropGridRowCount(@IntRange(from = 0) int i) {
        this.mCropGridRowCount = i;
        this.mGridPoints = null;
    }

    public void setCropGridStrokeWidth(@IntRange(from = 0) int i) {
        this.mCropGridPaint.setStrokeWidth((float) i);
    }

    public void setDimmedColor(@ColorInt int i) {
        this.mDimmedColor = i;
    }

    public void setFreestyleCropEnabled(boolean z) {
        this.mIsFreestyleCropEnabled = z;
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean z) {
        this.mShowCropFrame = z;
    }

    public void setShowCropGrid(boolean z) {
        this.mShowCropGrid = z;
    }

    public void setTargetAspectRatio(float f) {
        this.mTargetAspectRatio = f;
        if (this.mThisWidth > 0) {
            setupCropBounds();
            postInvalidate();
            return;
        }
        this.mShouldSetupCropBounds = true;
    }

    public void setupCropBounds() {
        int i = (int) (((float) this.mThisWidth) / this.mTargetAspectRatio);
        int i2;
        if (i > this.mThisHeight) {
            i = (int) (((float) this.mThisHeight) * this.mTargetAspectRatio);
            i2 = (this.mThisWidth - i) / 2;
            this.mCropViewRect.set((float) (getPaddingLeft() + i2), (float) getPaddingTop(), (float) ((getPaddingLeft() + i) + i2), (float) (getPaddingTop() + this.mThisHeight));
        } else {
            i2 = (this.mThisHeight - i) / 2;
            this.mCropViewRect.set((float) getPaddingLeft(), (float) (getPaddingTop() + i2), (float) (getPaddingLeft() + this.mThisWidth), (float) ((getPaddingTop() + i) + i2));
        }
        if (this.mCallback != null) {
            this.mCallback.onCropRectUpdated(this.mCropViewRect);
        }
        updateGridPoints();
    }
}
