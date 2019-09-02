package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.yalantis.ucrop.UCrop.Options;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.CropImageView;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView.TransformImageListener;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s.h.e.l.l.C;

public class UCropActivity extends AppCompatActivity {
    public static final int ALL = 3;
    public static final CompressFormat DEFAULT_COMPRESS_FORMAT = CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    private static final String TAG = "UCropActivity";
    private int mActiveWidgetColor;
    private int[] mAllowedGestures = new int[]{1, 2, 3};
    private View mBlockingView;
    private CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    private GestureCropImageView mGestureCropImageView;
    private TransformImageListener mImageListener = new TransformImageListener() {
        public void onLoadComplete() {
            UCropActivity.this.mUCropView.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.mBlockingView.setClickable(false);
            UCropActivity.this.mShowLoader = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        public void onLoadFailure(@NonNull Exception exception) {
            UCropActivity.this.setResultError(exception);
            UCropActivity.this.finish();
        }

        public void onRotate(float f) {
            UCropActivity.this.setAngleText(f);
        }

        public void onScale(float f) {
            UCropActivity.this.setScaleText(f);
        }
    };
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;
    private boolean mShowBottomControls;
    private boolean mShowLoader = true;
    private final OnClickListener mStateClickListener = new OnClickListener() {
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropActivity.this.setWidgetState(view.getId());
            }
        }
    };
    private int mStatusBarColor;
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;
    private int mToolbarColor;
    private String mToolbarTitle;
    private int mToolbarWidgetColor;
    private UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;

    static {
        C.i(16777272);
    }

    private native void addBlockingView();

    private void initiateRootViews() {
        this.mUCropView = (UCropView) findViewById(R.id.ucrop);
        this.mGestureCropImageView = this.mUCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, Mode.SRC_ATOP);
    }

    private void processOptions(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra(Options.EXTRA_COMPRESSION_FORMAT_NAME);
        CompressFormat valueOf = !TextUtils.isEmpty(stringExtra) ? CompressFormat.valueOf(stringExtra) : null;
        if (valueOf == null) {
            valueOf = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = valueOf;
        this.mCompressQuality = intent.getIntExtra(Options.EXTRA_COMPRESSION_QUALITY, 90);
        int[] intArrayExtra = intent.getIntArrayExtra(Options.EXTRA_ALLOWED_GESTURES);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.mAllowedGestures = intArrayExtra;
        }
        this.mGestureCropImageView.setMaxBitmapSize(intent.getIntExtra(Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(intent.getFloatExtra(Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration((long) intent.getIntExtra(Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        this.mOverlayView.setFreestyleCropEnabled(intent.getBooleanExtra(Options.EXTRA_FREE_STYLE_CROP, false));
        this.mOverlayView.setDimmedColor(intent.getIntExtra(Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(intent.getBooleanExtra(Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.mOverlayView.setShowCropFrame(intent.getBooleanExtra(Options.EXTRA_SHOW_CROP_FRAME, true));
        this.mOverlayView.setCropFrameColor(intent.getIntExtra(Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(intent.getIntExtra(Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(intent.getBooleanExtra(Options.EXTRA_SHOW_CROP_GRID, true));
        this.mOverlayView.setCropGridRowCount(intent.getIntExtra(Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.mOverlayView.setCropGridColumnCount(intent.getIntExtra(Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.mOverlayView.setCropGridColor(intent.getIntExtra(Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(intent.getIntExtra(Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_X, CropImageView.DEFAULT_ASPECT_RATIO);
        float floatExtra2 = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_Y, CropImageView.DEFAULT_ASPECT_RATIO);
        int intExtra = intent.getIntExtra(Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (floatExtra > CropImageView.DEFAULT_ASPECT_RATIO && floatExtra2 > CropImageView.DEFAULT_ASPECT_RATIO) {
            if (this.mWrapperStateAspectRatio != null) {
                this.mWrapperStateAspectRatio.setVisibility(8);
            }
            this.mGestureCropImageView.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra == null || intExtra >= parcelableArrayListExtra.size()) {
            this.mGestureCropImageView.setTargetAspectRatio(CropImageView.DEFAULT_ASPECT_RATIO);
        } else {
            this.mGestureCropImageView.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioX() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioY());
        }
        int intExtra2 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_X, 0);
        int intExtra3 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (intExtra2 > 0 && intExtra3 > 0) {
            this.mGestureCropImageView.setMaxResultImageSizeX(intExtra2);
            this.mGestureCropImageView.setMaxResultImageSizeY(intExtra3);
        }
    }

    private native void resetRotation();

    private native void rotateByAngle(int i);

    private native void setAllowedGestures(int i);

    private native void setAngleText(float f);

    private void setImageData(@NonNull Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) intent.getParcelableExtra(UCrop.EXTRA_OUTPUT_URI);
        processOptions(intent);
        if (uri == null || uri2 == null) {
            setResultError(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
            finish();
            return;
        }
        try {
            this.mGestureCropImageView.setImageUri(uri, uri2);
        } catch (Exception e) {
            setResultError(e);
            finish();
        }
    }

    private native void setInitialState();

    private native void setScaleText(float f);

    @TargetApi(21)
    private void setStatusBarColor(@ColorInt int i) {
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(i);
            }
        }
    }

    private void setWidgetState(@IdRes int i) {
        if (this.mShowBottomControls) {
            this.mWrapperStateAspectRatio.setSelected(i == R.id.state_aspect_ratio);
            this.mWrapperStateRotate.setSelected(i == R.id.state_rotate);
            this.mWrapperStateScale.setSelected(i == R.id.state_scale);
            int i2 = 8;
            this.mLayoutAspectRatio.setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
            this.mLayoutRotate.setVisibility(i == R.id.state_rotate ? 0 : 8);
            ViewGroup viewGroup = this.mLayoutScale;
            if (i == R.id.state_scale) {
                i2 = 0;
            }
            viewGroup.setVisibility(i2);
            if (i == R.id.state_scale) {
                setAllowedGestures(0);
            } else if (i == R.id.state_rotate) {
                setAllowedGestures(1);
            } else {
                setAllowedGestures(2);
            }
        }
    }

    private native void setupAppBar();

    private void setupAspectRatioWidget(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra(Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            intExtra = 2;
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        LayoutParams layoutParams = new LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            AspectRatio aspectRatio = (AspectRatio) it.next();
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveWidgetColor);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            linearLayout.addView(frameLayout);
            this.mCropAspectRatioViews.add(frameLayout);
        }
        ((ViewGroup) this.mCropAspectRatioViews.get(intExtra)).setSelected(true);
        for (ViewGroup onClickListener : this.mCropAspectRatioViews) {
            onClickListener.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    UCropActivity.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
                    if (!view.isSelected()) {
                        for (View view2 : UCropActivity.this.mCropAspectRatioViews) {
                            view2.setSelected(view2 == view);
                        }
                    }
                }
            });
        }
    }

    private native void setupRotateWidget();

    private native void setupScaleWidget();

    private native void setupStatesWrapper();

    private void setupViews(@NonNull Intent intent) {
        this.mStatusBarColor = intent.getIntExtra(Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra(Options.EXTRA_TOOL_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.mActiveWidgetColor = intent.getIntExtra(Options.EXTRA_UCROP_COLOR_WIDGET_ACTIVE, ContextCompat.getColor(this, R.color.ucrop_color_widget_active));
        this.mToolbarWidgetColor = intent.getIntExtra(Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.mToolbarTitle = intent.getStringExtra(Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.mToolbarTitle = !TextUtils.isEmpty(this.mToolbarTitle) ? this.mToolbarTitle : getResources().getString(R.string.ucrop_label_edit_photo);
        this.mLogoColor = intent.getIntExtra(Options.EXTRA_UCROP_LOGO_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_default_logo));
        this.mShowBottomControls = intent.getBooleanExtra(Options.EXTRA_HIDE_BOTTOM_CONTROLS, false) ^ 1;
        setupAppBar();
        initiateRootViews();
        if (this.mShowBottomControls) {
            View.inflate(this, R.layout.ucrop_controls, (ViewGroup) findViewById(R.id.ucrop_photobox));
            this.mWrapperStateAspectRatio = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio.setOnClickListener(this.mStateClickListener);
            this.mWrapperStateRotate = (ViewGroup) findViewById(R.id.state_rotate);
            this.mWrapperStateRotate.setOnClickListener(this.mStateClickListener);
            this.mWrapperStateScale = (ViewGroup) findViewById(R.id.state_scale);
            this.mWrapperStateScale.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            setupAspectRatioWidget(intent);
            setupRotateWidget();
            setupScaleWidget();
            setupStatesWrapper();
        }
    }

    public native void cropAndSaveImage();

    public native void onCreate(Bundle bundle);

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.mToolbarWidgetColor, Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (IllegalStateException e) {
                Log.i(TAG, String.format("%s - %s", new Object[]{e.getMessage(), getString(R.string.ucrop_mutate_exception_hint)}));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.menu_crop);
        Drawable icon2 = findItem2.getIcon();
        if (icon2 != null) {
            icon2.mutate();
            icon2.setColorFilter(this.mToolbarWidgetColor, Mode.SRC_ATOP);
            findItem2.setIcon(icon2);
        }
        return true;
    }

    public native boolean onOptionsItemSelected(MenuItem menuItem);

    public native boolean onPrepareOptionsMenu(Menu menu);

    public native void onStop();

    public native void setResultError(Throwable th);

    public native void setResultUri(Uri uri, float f, int i, int i2);
}
