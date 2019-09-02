package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.util.RectUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class CropImageView extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0f;
    private CropBoundsChangeListener mCropBoundsChangeListener;
    private final RectF mCropRect;
    private long mImageToWrapCropBoundsAnimDuration;
    private int mMaxResultImageSizeX;
    private int mMaxResultImageSizeY;
    private float mMaxScale;
    private float mMaxScaleMultiplier;
    private float mMinScale;
    private float mTargetAspectRatio;
    private final Matrix mTempMatrix;
    private Runnable mWrapCropBoundsRunnable;
    private Runnable mZoomImageToPositionRunnable;

    private static class WrapCropBoundsRunnable implements Runnable {
        private final float mCenterDiffX;
        private final float mCenterDiffY;
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final long mDurationMs;
        private final float mOldScale;
        private final float mOldX;
        private final float mOldY;
        private final long mStartTime = System.currentTimeMillis();
        private final boolean mWillBeImageInBoundsAfterTranslate;

        public WrapCropBoundsRunnable(CropImageView cropImageView, long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z) {
            this.mCropImageView = new WeakReference(cropImageView);
            this.mDurationMs = j;
            this.mOldX = f;
            this.mOldY = f2;
            this.mCenterDiffX = f3;
            this.mCenterDiffY = f4;
            this.mOldScale = f5;
            this.mDeltaScale = f6;
            this.mWillBeImageInBoundsAfterTranslate = z;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.mCropImageView.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
                float easeOut = CubicEasing.easeOut(min, CropImageView.DEFAULT_ASPECT_RATIO, this.mCenterDiffX, (float) this.mDurationMs);
                float easeOut2 = CubicEasing.easeOut(min, CropImageView.DEFAULT_ASPECT_RATIO, this.mCenterDiffY, (float) this.mDurationMs);
                float easeInOut = CubicEasing.easeInOut(min, CropImageView.DEFAULT_ASPECT_RATIO, this.mDeltaScale, (float) this.mDurationMs);
                if (min < ((float) this.mDurationMs)) {
                    cropImageView.postTranslate(easeOut - (cropImageView.mCurrentImageCenter[0] - this.mOldX), easeOut2 - (cropImageView.mCurrentImageCenter[1] - this.mOldY));
                    if (!this.mWillBeImageInBoundsAfterTranslate) {
                        cropImageView.zoomInImage(this.mOldScale + easeInOut, cropImageView.mCropRect.centerX(), cropImageView.mCropRect.centerY());
                    }
                    if (!cropImageView.isImageWrapCropBounds()) {
                        cropImageView.post(this);
                    }
                }
            }
        }
    }

    private static class ZoomImageToPosition implements Runnable {
        private final WeakReference<CropImageView> mCropImageView;
        private final float mDeltaScale;
        private final float mDestX;
        private final float mDestY;
        private final long mDurationMs;
        private final float mOldScale;
        private final long mStartTime = System.currentTimeMillis();

        public ZoomImageToPosition(CropImageView cropImageView, long j, float f, float f2, float f3, float f4) {
            this.mCropImageView = new WeakReference(cropImageView);
            this.mDurationMs = j;
            this.mOldScale = f;
            this.mDeltaScale = f2;
            this.mDestX = f3;
            this.mDestY = f4;
        }

        public void run() {
            CropImageView cropImageView = (CropImageView) this.mCropImageView.get();
            if (cropImageView != null) {
                float min = (float) Math.min(this.mDurationMs, System.currentTimeMillis() - this.mStartTime);
                float easeInOut = CubicEasing.easeInOut(min, CropImageView.DEFAULT_ASPECT_RATIO, this.mDeltaScale, (float) this.mDurationMs);
                if (min < ((float) this.mDurationMs)) {
                    cropImageView.zoomInImage(this.mOldScale + easeInOut, this.mDestX, this.mDestY);
                    cropImageView.post(this);
                } else {
                    cropImageView.setImageToWrapCropBounds();
                }
            }
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCropRect = new RectF();
        this.mTempMatrix = new Matrix();
        this.mMaxScaleMultiplier = 10.0f;
        this.mZoomImageToPositionRunnable = null;
        this.mMaxResultImageSizeX = 0;
        this.mMaxResultImageSizeY = 0;
        this.mImageToWrapCropBoundsAnimDuration = 500;
    }

    private float[] calculateImageIndents() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        float[] copyOf = Arrays.copyOf(this.mCurrentImageCorners, this.mCurrentImageCorners.length);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(copyOf);
        this.mTempMatrix.mapPoints(cornersFromRect);
        RectF trapToRect = RectUtils.trapToRect(copyOf);
        RectF trapToRect2 = RectUtils.trapToRect(cornersFromRect);
        float f = trapToRect.left - trapToRect2.left;
        float f2 = trapToRect.top - trapToRect2.top;
        float f3 = trapToRect.right - trapToRect2.right;
        float f4 = trapToRect.bottom - trapToRect2.bottom;
        cornersFromRect = new float[4];
        if (f <= DEFAULT_ASPECT_RATIO) {
            f = DEFAULT_ASPECT_RATIO;
        }
        cornersFromRect[0] = f;
        if (f2 <= DEFAULT_ASPECT_RATIO) {
            f2 = DEFAULT_ASPECT_RATIO;
        }
        cornersFromRect[1] = f2;
        if (f3 >= DEFAULT_ASPECT_RATIO) {
            f3 = DEFAULT_ASPECT_RATIO;
        }
        cornersFromRect[2] = f3;
        if (f4 >= DEFAULT_ASPECT_RATIO) {
            f4 = DEFAULT_ASPECT_RATIO;
        }
        cornersFromRect[3] = f4;
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(getCurrentAngle());
        this.mTempMatrix.mapPoints(cornersFromRect);
        return cornersFromRect;
    }

    private void calculateImageScaleBounds() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            calculateImageScaleBounds((float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        }
    }

    private void calculateImageScaleBounds(float f, float f2) {
        this.mMinScale = Math.min(Math.min(this.mCropRect.width() / f, this.mCropRect.width() / f2), Math.min(this.mCropRect.height() / f2, this.mCropRect.height() / f));
        this.mMaxScale = this.mMinScale * this.mMaxScaleMultiplier;
    }

    private void setupInitialImagePosition(float f, float f2) {
        float width = this.mCropRect.width();
        float height = this.mCropRect.height();
        float max = Math.max(this.mCropRect.width() / f, this.mCropRect.height() / f2);
        width = ((width - (f * max)) / 2.0f) + this.mCropRect.left;
        height = ((height - (f2 * max)) / 2.0f) + this.mCropRect.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(max, max);
        this.mCurrentImageMatrix.postTranslate(width, height);
        setImageMatrix(this.mCurrentImageMatrix);
    }

    public void cancelAllAnimations() {
        removeCallbacks(this.mWrapCropBoundsRunnable);
        removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public void cropAndSaveImage(@NonNull CompressFormat compressFormat, int i, @Nullable BitmapCropCallback bitmapCropCallback) {
        cancelAllAnimations();
        setImageToWrapCropBounds(false);
        new BitmapCropTask(getContext(), getViewBitmap(), new ImageState(this.mCropRect, RectUtils.trapToRect(this.mCurrentImageCorners), getCurrentScale(), getCurrentAngle()), new CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, compressFormat, i, getImageInputPath(), getImageOutputPath(), getExifInfo()), bitmapCropCallback).execute(new Void[0]);
    }

    @Nullable
    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    /* Access modifiers changed, original: protected */
    public boolean isImageWrapCropBounds() {
        return isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    /* Access modifiers changed, original: protected */
    public boolean isImageWrapCropBounds(float[] fArr) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-getCurrentAngle());
        fArr = Arrays.copyOf(fArr, fArr.length);
        this.mTempMatrix.mapPoints(fArr);
        float[] cornersFromRect = RectUtils.getCornersFromRect(this.mCropRect);
        this.mTempMatrix.mapPoints(cornersFromRect);
        return RectUtils.trapToRect(fArr).contains(RectUtils.trapToRect(cornersFromRect));
    }

    /* Access modifiers changed, original: protected */
    public void onImageLaidOut() {
        super.onImageLaidOut();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            if (this.mTargetAspectRatio == DEFAULT_ASPECT_RATIO) {
                this.mTargetAspectRatio = intrinsicWidth / intrinsicHeight;
            }
            int i = (int) (((float) this.mThisWidth) / this.mTargetAspectRatio);
            int i2;
            if (i > this.mThisHeight) {
                i = (int) (((float) this.mThisHeight) * this.mTargetAspectRatio);
                i2 = (this.mThisWidth - i) / 2;
                this.mCropRect.set((float) i2, DEFAULT_ASPECT_RATIO, (float) (i + i2), (float) this.mThisHeight);
            } else {
                i2 = (this.mThisHeight - i) / 2;
                this.mCropRect.set(DEFAULT_ASPECT_RATIO, (float) i2, (float) this.mThisWidth, (float) (i + i2));
            }
            calculateImageScaleBounds(intrinsicWidth, intrinsicHeight);
            setupInitialImagePosition(intrinsicWidth, intrinsicHeight);
            if (this.mCropBoundsChangeListener != null) {
                this.mCropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
            }
            if (this.mTransformImageListener != null) {
                this.mTransformImageListener.onScale(getCurrentScale());
                this.mTransformImageListener.onRotate(getCurrentAngle());
            }
        }
    }

    public void postRotate(float f) {
        postRotate(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void postScale(float f, float f2, float f3) {
        if (f > 1.0f && getCurrentScale() * f <= getMaxScale()) {
            super.postScale(f, f2, f3);
        } else if (f < 1.0f && getCurrentScale() * f >= getMinScale()) {
            super.postScale(f, f2, f3);
        }
    }

    /* Access modifiers changed, original: protected */
    public void processStyledAttributes(@NonNull TypedArray typedArray) {
        float abs = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, DEFAULT_ASPECT_RATIO));
        float abs2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, DEFAULT_ASPECT_RATIO));
        if (abs == DEFAULT_ASPECT_RATIO || abs2 == DEFAULT_ASPECT_RATIO) {
            this.mTargetAspectRatio = DEFAULT_ASPECT_RATIO;
        } else {
            this.mTargetAspectRatio = abs / abs2;
        }
    }

    public void setCropBoundsChangeListener(@Nullable CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - ((float) getPaddingLeft()), rectF.top - ((float) getPaddingTop()), rectF.right - ((float) getPaddingRight()), rectF.bottom - ((float) getPaddingBottom()));
        calculateImageScaleBounds();
        setImageToWrapCropBounds();
    }

    public void setImageToWrapCropBounds() {
        setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean z) {
        if (this.mBitmapLaidOut && !isImageWrapCropBounds()) {
            float f;
            float f2;
            float f3;
            float f4 = this.mCurrentImageCenter[0];
            float f5 = this.mCurrentImageCenter[1];
            float currentScale = getCurrentScale();
            float centerX = this.mCropRect.centerX() - f4;
            float centerY = this.mCropRect.centerY() - f5;
            this.mTempMatrix.reset();
            this.mTempMatrix.setTranslate(centerX, centerY);
            float[] copyOf = Arrays.copyOf(this.mCurrentImageCorners, this.mCurrentImageCorners.length);
            this.mTempMatrix.mapPoints(copyOf);
            boolean isImageWrapCropBounds = isImageWrapCropBounds(copyOf);
            if (isImageWrapCropBounds) {
                float[] calculateImageIndents = calculateImageIndents();
                f = -(calculateImageIndents[1] + calculateImageIndents[3]);
                f2 = -(calculateImageIndents[0] + calculateImageIndents[2]);
                f3 = DEFAULT_ASPECT_RATIO;
            } else {
                RectF rectF = new RectF(this.mCropRect);
                this.mTempMatrix.reset();
                this.mTempMatrix.setRotate(getCurrentAngle());
                this.mTempMatrix.mapRect(rectF);
                copyOf = RectUtils.getRectSidesFromCorners(this.mCurrentImageCorners);
                f2 = centerX;
                f3 = (Math.max(rectF.width() / copyOf[0], rectF.height() / copyOf[1]) * currentScale) - currentScale;
                f = centerY;
            }
            if (z) {
                WrapCropBoundsRunnable wrapCropBoundsRunnable = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f4, f5, f2, f, currentScale, f3, isImageWrapCropBounds);
                this.mWrapCropBoundsRunnable = wrapCropBoundsRunnable;
                post(wrapCropBoundsRunnable);
                return;
            }
            postTranslate(f2, f);
            if (!isImageWrapCropBounds) {
                zoomInImage(currentScale + f3, this.mCropRect.centerX(), this.mCropRect.centerY());
            }
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(@IntRange(from = 100) long j) {
        if (j > 0) {
            this.mImageToWrapCropBoundsAnimDuration = j;
            return;
        }
        throw new IllegalArgumentException("Animation duration cannot be negative value.");
    }

    public void setMaxResultImageSizeX(@IntRange(from = 10) int i) {
        this.mMaxResultImageSizeX = i;
    }

    public void setMaxResultImageSizeY(@IntRange(from = 10) int i) {
        this.mMaxResultImageSizeY = i;
    }

    public void setMaxScaleMultiplier(float f) {
        this.mMaxScaleMultiplier = f;
    }

    public void setTargetAspectRatio(float f) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            this.mTargetAspectRatio = f;
            return;
        }
        if (f == DEFAULT_ASPECT_RATIO) {
            this.mTargetAspectRatio = ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        } else {
            this.mTargetAspectRatio = f;
        }
        if (this.mCropBoundsChangeListener != null) {
            this.mCropBoundsChangeListener.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
    }

    /* Access modifiers changed, original: protected */
    public void zoomImageToPosition(float f, float f2, float f3, long j) {
        if (f > getMaxScale()) {
            f = getMaxScale();
        }
        float currentScale = getCurrentScale();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, j, currentScale, f - currentScale, f2, f3);
        this.mZoomImageToPositionRunnable = zoomImageToPosition;
        post(zoomImageToPosition);
    }

    public void zoomInImage(float f) {
        zoomInImage(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomInImage(float f, float f2, float f3) {
        if (f <= getMaxScale()) {
            postScale(f / getCurrentScale(), f2, f3);
        }
    }

    public void zoomOutImage(float f) {
        zoomOutImage(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomOutImage(float f, float f2, float f3) {
        if (f >= getMinScale()) {
            postScale(f / getCurrentScale(), f2, f3);
        }
    }
}
