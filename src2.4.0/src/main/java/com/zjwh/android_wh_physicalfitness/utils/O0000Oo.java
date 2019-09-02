package com.zjwh.android_wh_physicalfitness.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xutils.common.util.DensityUtil;

/* compiled from: BitmapUtil */
public class O0000Oo {
    public static Bitmap O000000o(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
        if (createBitmap != null) {
            Canvas canvas = new Canvas(createBitmap);
            view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            Drawable background = view.getBackground();
            if (background != null) {
                background.draw(canvas);
            } else {
                canvas.drawColor(-1);
            }
            view.draw(canvas);
        }
        return createBitmap;
    }

    public static Bitmap O000000o(View view, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate((float) (-view.getScrollX()), (float) (-view.getScrollY()));
        view.draw(canvas);
        return createBitmap;
    }

    public static Bitmap O000000o(View view, int i, int i2, float f, float f2, int i3) {
        float f3 = (float) i3;
        float f4 = 1.0f / f3;
        Bitmap createBitmap = Bitmap.createBitmap((int) ((((float) i) * f4) - (f / f3)), (int) ((((float) i2) * f4) - (f2 / f3)), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate((-f) / f3, (-f2) / f3);
        if (i3 > 1) {
            canvas.scale(f4, f4);
        }
        view.draw(canvas);
        return createBitmap;
    }

    public static void O000000o(Bitmap bitmap, String str, int i) {
        File file = new File(str);
        O000000o(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (bitmap.compress(CompressFormat.JPEG, i, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            O000000o(file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @TargetApi(12)
    public static void O000000o(View view, float f) {
        if (O000000o()) {
            view.setAlpha(f);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    @TargetApi(12)
    public static void O000000o(View view, float f, float f2, int i, final Runnable runnable) {
        if (O000000o()) {
            ViewPropertyAnimator duration = view.animate().alpha(f2).setDuration((long) i);
            if (runnable != null) {
                duration.setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        runnable.run();
                    }
                });
                return;
            }
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration((long) i);
        alphaAnimation.setFillAfter(true);
        if (runnable != null) {
            alphaAnimation.setAnimationListener(new AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    new Handler().post(runnable);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
        }
        view.startAnimation(alphaAnimation);
    }

    private static void O000000o(File file) {
        File file2 = new File(file.getParent());
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    private static void O000000o(String str) {
        MediaScannerConnection.scanFile(MyApplication.O000000o(), new String[]{str}, null, null);
    }

    public static boolean O000000o() {
        return VERSION.SDK_INT >= 12;
    }

    public static boolean O000000o(Context context, Bitmap bitmap) {
        String O00000o0 = O00oOooO.O00000o0();
        File file = new File(O00000o0);
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(".jpg");
        File file2 = new File(file, stringBuilder.toString());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            boolean compress = bitmap.compress(CompressFormat.JPEG, 60, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file2)));
            if (!compress) {
                return false;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(context.getString(2131689512));
            stringBuilder2.append("：图片已保存至");
            stringBuilder2.append(O00000o0);
            stringBuilder2.append("文件夹");
            O00Oo00.O000000o(stringBuilder2.toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Bitmap O00000Oo(View view) {
        view.setDrawingCacheEnabled(true);
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, DensityUtil.dip2px(25.0f), DensityUtil.dip2px(25.0f));
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache);
        drawingCache.recycle();
        return createBitmap;
    }
}
