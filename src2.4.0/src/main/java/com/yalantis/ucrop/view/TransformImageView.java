package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.util.RectUtils;

public class TransformImageView extends ImageView {
    private static final int MATRIX_VALUES_COUNT = 9;
    private static final int RECT_CENTER_POINT_COORDS = 2;
    private static final int RECT_CORNER_POINTS_COORDS = 8;
    private static final String TAG = "TransformImageView";
    protected boolean mBitmapDecoded;
    protected boolean mBitmapLaidOut;
    protected final float[] mCurrentImageCenter;
    protected final float[] mCurrentImageCorners;
    protected Matrix mCurrentImageMatrix;
    private ExifInfo mExifInfo;
    private String mImageInputPath;
    private String mImageOutputPath;
    private float[] mInitialImageCenter;
    private float[] mInitialImageCorners;
    private final float[] mMatrixValues;
    private int mMaxBitmapSize;
    protected int mThisHeight;
    protected int mThisWidth;
    protected TransformImageListener mTransformImageListener;

    public interface TransformImageListener {
        void onLoadComplete();

        void onLoadFailure(@NonNull Exception exception);

        void onRotate(float f);

        void onScale(float f);
    }

    public TransformImageView(Context context) {
        this(context, null);
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentImageCorners = new float[8];
        this.mCurrentImageCenter = new float[2];
        this.mMatrixValues = new float[9];
        this.mCurrentImageMatrix = new Matrix();
        this.mBitmapDecoded = false;
        this.mBitmapLaidOut = false;
        this.mMaxBitmapSize = 0;
        init();
    }

    private void updateCurrentImagePoints() {
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCorners, this.mInitialImageCorners);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCenter, this.mInitialImageCenter);
    }

    public float getCurrentAngle() {
        return getMatrixAngle(this.mCurrentImageMatrix);
    }

    public float getCurrentScale() {
        return getMatrixScale(this.mCurrentImageMatrix);
    }

    public ExifInfo getExifInfo() {
        return this.mExifInfo;
    }

    public String getImageInputPath() {
        return this.mImageInputPath;
    }

    public String getImageOutputPath() {
        return this.mImageOutputPath;
    }

    public float getMatrixAngle(@NonNull Matrix matrix) {
        return (float) (-(Math.atan2((double) getMatrixValue(matrix, 1), (double) getMatrixValue(matrix, 0)) * 57.29577951308232d));
    }

    public float getMatrixScale(@NonNull Matrix matrix) {
        return (float) Math.sqrt(Math.pow((double) getMatrixValue(matrix, 0), 2.0d) + Math.pow((double) getMatrixValue(matrix, 3), 2.0d));
    }

    /* Access modifiers changed, original: protected */
    public float getMatrixValue(@NonNull Matrix matrix, @IntRange(from = 0, to = 9) int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    public int getMaxBitmapSize() {
        if (this.mMaxBitmapSize <= 0) {
            this.mMaxBitmapSize = BitmapLoadUtils.calculateMaxBitmapSize(getContext());
        }
        return this.mMaxBitmapSize;
    }

    @Nullable
    public Bitmap getViewBitmap() {
        return (getDrawable() == null || !(getDrawable() instanceof FastBitmapDrawable)) ? null : ((FastBitmapDrawable) getDrawable()).getBitmap();
    }

    /* Access modifiers changed, original: protected */
    public void init() {
        setScaleType(ScaleType.MATRIX);
    }

    /* Access modifiers changed, original: protected */
    public void onImageLaidOut() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            Log.d(TAG, String.format("Image size: [%d:%d]", new Object[]{Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight)}));
            RectF rectF = new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, intrinsicWidth, intrinsicHeight);
            this.mInitialImageCorners = RectUtils.getCornersFromRect(rectF);
            this.mInitialImageCenter = RectUtils.getCenterFromRect(rectF);
            this.mBitmapLaidOut = true;
            if (this.mTransformImageListener != null) {
                this.mTransformImageListener.onLoadComplete();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || (this.mBitmapDecoded && !this.mBitmapLaidOut)) {
            int paddingLeft = getPaddingLeft();
            i = getPaddingTop();
            i3 = getHeight() - getPaddingBottom();
            this.mThisWidth = (getWidth() - getPaddingRight()) - paddingLeft;
            this.mThisHeight = i3 - i;
            onImageLaidOut();
        }
    }

    public void postRotate(float f, float f2, float f3) {
        if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
            this.mCurrentImageMatrix.postRotate(f, f2, f3);
            setImageMatrix(this.mCurrentImageMatrix);
            if (this.mTransformImageListener != null) {
                this.mTransformImageListener.onRotate(getMatrixAngle(this.mCurrentImageMatrix));
            }
        }
    }

    public void postScale(float f, float f2, float f3) {
        if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
            this.mCurrentImageMatrix.postScale(f, f, f2, f3);
            setImageMatrix(this.mCurrentImageMatrix);
            if (this.mTransformImageListener != null) {
                this.mTransformImageListener.onScale(getMatrixScale(this.mCurrentImageMatrix));
            }
        }
    }

    public void postTranslate(float f, float f2) {
        if (f != CropImageView.DEFAULT_ASPECT_RATIO || f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
            this.mCurrentImageMatrix.postTranslate(f, f2);
            setImageMatrix(this.mCurrentImageMatrix);
        }
    }

    /* Access modifiers changed, original: protected */
    public void printMatrix(@NonNull String str, @NonNull Matrix matrix) {
        float matrixValue = getMatrixValue(matrix, 2);
        float matrixValue2 = getMatrixValue(matrix, 5);
        float matrixScale = getMatrixScale(matrix);
        float matrixAngle = getMatrixAngle(matrix);
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(": matrix: { x: ");
        stringBuilder.append(matrixValue);
        stringBuilder.append(", y: ");
        stringBuilder.append(matrixValue2);
        stringBuilder.append(", scale: ");
        stringBuilder.append(matrixScale);
        stringBuilder.append(", angle: ");
        stringBuilder.append(matrixAngle);
        stringBuilder.append(" }");
        Log.d(str2, stringBuilder.toString());
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new FastBitmapDrawable(bitmap));
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.mCurrentImageMatrix.set(matrix);
        updateCurrentImagePoints();
    }

    public void setImageUri(@NonNull Uri uri, @Nullable Uri uri2) throws Exception {
        int maxBitmapSize = getMaxBitmapSize();
        BitmapLoadUtils.decodeBitmapInBackground(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new BitmapLoadCallback() {
            public void onBitmapLoaded(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo, @NonNull String str, @Nullable String str2) {
                TransformImageView.this.mImageInputPath = str;
                TransformImageView.this.mImageOutputPath = str2;
                TransformImageView.this.mExifInfo = exifInfo;
                TransformImageView.this.mBitmapDecoded = true;
                TransformImageView.this.setImageBitmap(bitmap);
            }

            public void onFailure(@NonNull Exception exception) {
                Log.e(TransformImageView.TAG, "onFailure: setImageUri", exception);
                if (TransformImageView.this.mTransformImageListener != null) {
                    TransformImageView.this.mTransformImageListener.onLoadFailure(exception);
                }
            }
        });
    }

    public void setMaxBitmapSize(int i) {
        this.mMaxBitmapSize = i;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType == ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w(TAG, "Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(TransformImageListener transformImageListener) {
        this.mTransformImageListener = transformImageListener;
    }
}
