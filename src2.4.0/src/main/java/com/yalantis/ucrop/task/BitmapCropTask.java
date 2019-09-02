package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.ImageHeaderParser;
import com.yalantis.ucrop.view.CropImageView;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {
    private static final String TAG = "BitmapCropTask";
    private final CompressFormat mCompressFormat;
    private final int mCompressQuality;
    private final WeakReference<Context> mContext;
    private final BitmapCropCallback mCropCallback;
    private final RectF mCropRect;
    private int mCroppedImageHeight;
    private int mCroppedImageWidth;
    private float mCurrentAngle;
    private final RectF mCurrentImageRect;
    private float mCurrentScale;
    private final ExifInfo mExifInfo;
    private final String mImageInputPath;
    private final String mImageOutputPath;
    private final int mMaxResultImageSizeX;
    private final int mMaxResultImageSizeY;
    private Bitmap mViewBitmap;

    public BitmapCropTask(@NonNull Context context, @Nullable Bitmap bitmap, @NonNull ImageState imageState, @NonNull CropParameters cropParameters, @Nullable BitmapCropCallback bitmapCropCallback) {
        this.mContext = new WeakReference(context);
        this.mViewBitmap = bitmap;
        this.mCropRect = imageState.getCropRect();
        this.mCurrentImageRect = imageState.getCurrentImageRect();
        this.mCurrentScale = imageState.getCurrentScale();
        this.mCurrentAngle = imageState.getCurrentAngle();
        this.mMaxResultImageSizeX = cropParameters.getMaxResultImageSizeX();
        this.mMaxResultImageSizeY = cropParameters.getMaxResultImageSizeY();
        this.mCompressFormat = cropParameters.getCompressFormat();
        this.mCompressQuality = cropParameters.getCompressQuality();
        this.mImageInputPath = cropParameters.getImageInputPath();
        this.mImageOutputPath = cropParameters.getImageOutputPath();
        this.mExifInfo = cropParameters.getExifInfo();
        this.mCropCallback = bitmapCropCallback;
    }

    private boolean crop() throws IOException {
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            float width = this.mCropRect.width() / this.mCurrentScale;
            float height = this.mCropRect.height() / this.mCurrentScale;
            if (width > ((float) this.mMaxResultImageSizeX) || height > ((float) this.mMaxResultImageSizeY)) {
                width = Math.min(((float) this.mMaxResultImageSizeX) / width, ((float) this.mMaxResultImageSizeY) / height);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.mViewBitmap, Math.round(((float) this.mViewBitmap.getWidth()) * width), Math.round(((float) this.mViewBitmap.getHeight()) * width), false);
                if (this.mViewBitmap != createScaledBitmap) {
                    this.mViewBitmap.recycle();
                }
                this.mViewBitmap = createScaledBitmap;
                this.mCurrentScale /= width;
            }
        }
        if (this.mCurrentAngle != CropImageView.DEFAULT_ASPECT_RATIO) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.mCurrentAngle, (float) (this.mViewBitmap.getWidth() / 2), (float) (this.mViewBitmap.getHeight() / 2));
            Bitmap createBitmap = Bitmap.createBitmap(this.mViewBitmap, 0, 0, this.mViewBitmap.getWidth(), this.mViewBitmap.getHeight(), matrix, true);
            if (this.mViewBitmap != createBitmap) {
                this.mViewBitmap.recycle();
            }
            this.mViewBitmap = createBitmap;
        }
        int round = Math.round((this.mCropRect.top - this.mCurrentImageRect.top) / this.mCurrentScale);
        int round2 = Math.round((this.mCropRect.left - this.mCurrentImageRect.left) / this.mCurrentScale);
        this.mCroppedImageWidth = Math.round(this.mCropRect.width() / this.mCurrentScale);
        this.mCroppedImageHeight = Math.round(this.mCropRect.height() / this.mCurrentScale);
        boolean shouldCrop = shouldCrop(this.mCroppedImageWidth, this.mCroppedImageHeight);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Should crop: ");
        stringBuilder.append(shouldCrop);
        Log.i(str, stringBuilder.toString());
        if (shouldCrop) {
            ExifInterface exifInterface = new ExifInterface(this.mImageInputPath);
            saveImage(Bitmap.createBitmap(this.mViewBitmap, round2, round, this.mCroppedImageWidth, this.mCroppedImageHeight));
            if (this.mCompressFormat.equals(CompressFormat.JPEG)) {
                ImageHeaderParser.copyExif(exifInterface, this.mCroppedImageWidth, this.mCroppedImageHeight, this.mImageOutputPath);
            }
            return true;
        }
        FileUtils.copyFile(this.mImageInputPath, this.mImageOutputPath);
        return false;
    }

    private void saveImage(@NonNull Bitmap bitmap) throws FileNotFoundException {
        Throwable th;
        Context context = (Context) this.mContext.get();
        if (context != null) {
            Closeable closeable = null;
            try {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(Uri.fromFile(new File(this.mImageOutputPath)));
                try {
                    bitmap.compress(this.mCompressFormat, this.mCompressQuality, openOutputStream);
                    bitmap.recycle();
                    BitmapLoadUtils.close(openOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = openOutputStream;
                    BitmapLoadUtils.close(closeable);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                BitmapLoadUtils.close(closeable);
                throw th;
            }
        }
    }

    private boolean shouldCrop(int i, int i2) {
        i = Math.round(((float) Math.max(i, i2)) / 1000.0f) + 1;
        if (this.mMaxResultImageSizeX > 0 && this.mMaxResultImageSizeY > 0) {
            return true;
        }
        float f = (float) i;
        return Math.abs(this.mCropRect.left - this.mCurrentImageRect.left) > f || Math.abs(this.mCropRect.top - this.mCurrentImageRect.top) > f || Math.abs(this.mCropRect.bottom - this.mCurrentImageRect.bottom) > f || Math.abs(this.mCropRect.right - this.mCurrentImageRect.right) > f;
    }

    /* Access modifiers changed, original: protected|varargs */
    @Nullable
    public Throwable doInBackground(Void... voidArr) {
        if (this.mViewBitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (this.mViewBitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.mCurrentImageRect.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            crop();
            this.mViewBitmap = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onPostExecute(@Nullable Throwable th) {
        if (this.mCropCallback == null) {
            return;
        }
        if (th == null) {
            this.mCropCallback.onBitmapCropped(Uri.fromFile(new File(this.mImageOutputPath)), this.mCroppedImageWidth, this.mCroppedImageHeight);
        } else {
            this.mCropCallback.onCropFailure(th);
        }
    }
}
