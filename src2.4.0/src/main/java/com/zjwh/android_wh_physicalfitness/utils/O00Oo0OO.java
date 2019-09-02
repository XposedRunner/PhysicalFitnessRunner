package com.zjwh.android_wh_physicalfitness.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.PopupWindow;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O000000o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O00000o0;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import com.zjwh.android_wh_physicalfitness.view.dialog.SportMoodAddDialog;
import org.xutils.common.util.DensityUtil;

/* compiled from: ViewUtils */
public class O00Oo0OO {
    private static final int O000000o = 0;
    private static final int O00000Oo = 1;
    private static final int O00000o = 200;
    private static final int O00000o0 = 2;
    private static int O00000oO;

    public static int O000000o(Resources resources) {
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static void O000000o(Context context, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.topMargin += O00OOOo.O000000o(context);
    }

    public static void O000000o(final View view) {
        if (!O00000o(view)) {
            view.animate().cancel();
            if (O00000oO(view)) {
                O00000oO = 1;
                view.animate().scaleX(CropImageView.DEFAULT_ASPECT_RATIO).scaleY(CropImageView.DEFAULT_ASPECT_RATIO).alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(200).setInterpolator(new FastOutLinearInInterpolator()).setListener(new AnimatorListenerAdapter() {
                    private boolean O00000Oo;

                    public void onAnimationCancel(Animator animator) {
                        this.O00000Oo = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        O00Oo0OO.O00000oO = 0;
                        if (!this.O00000Oo) {
                            view.setVisibility(8);
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        view.setVisibility(0);
                        this.O00000Oo = false;
                    }
                });
            } else {
                view.setVisibility(8);
            }
        }
    }

    public static void O000000o(final View view, final String str, String str2, final OnClickListener onClickListener) {
        if (((Boolean) O00O0Oo0.O00000o0(SportMoodAddDialog.O00000Oo, Boolean.valueOf(true))).booleanValue()) {
            new O0000Oo(view.getContext()).O000000o().O000000o("关闭运动心情").O00000Oo(str2).O00000Oo("取消", null).O000000o("关闭", new OnClickListener() {
                public void onClick(View view) {
                    Context context = view.getContext();
                    String str = O000000o.O0000o00;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(O00000o0.O00000o0);
                    stringBuilder.append(str);
                    O00Oo00o.O000000o(context, str, stringBuilder.toString());
                    O00O0Oo0.O000000o(SportMoodAddDialog.O00000Oo, Boolean.valueOf(false));
                    if (onClickListener != null) {
                        onClickListener.onClick(view);
                    }
                }
            }).O00000Oo();
        } else if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static void O000000o(PopupWindow popupWindow, View view) {
        if (VERSION.SDK_INT >= 24) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int height = iArr[1] + view.getHeight();
            popupWindow.setHeight((DensityUtil.getScreenHeight() - height) + (!O000000o(O00Oo0.O00000oo(view.getContext())) ? O000000o(view.getResources()) : 0));
            popupWindow.showAtLocation(view, 0, 0, height);
            return;
        }
        popupWindow.showAsDropDown(view);
    }

    public static boolean O000000o(Activity activity) {
        boolean z = false;
        if (VERSION.SDK_INT >= 17) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            if (Build.MANUFACTURER.startsWith("Xiaomi")) {
                if (!(point2.y == point.y || O00Oo0.O0000OOo(activity))) {
                    z = true;
                }
                return z;
            }
            if (point2.y != point.y) {
                z = true;
            }
            return z;
        }
        boolean hasPermanentMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (!(hasPermanentMenuKey || deviceHasKey)) {
            z = true;
        }
        return z;
    }

    public static void O00000Oo(final View view) {
        if (!O00000o0(view)) {
            view.animate().cancel();
            if (O00000oO(view)) {
                O00000oO = 2;
                if (view.getVisibility() != 0) {
                    view.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                    view.setScaleY(CropImageView.DEFAULT_ASPECT_RATIO);
                    view.setScaleX(CropImageView.DEFAULT_ASPECT_RATIO);
                }
                view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(new FastOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        O00Oo0OO.O00000oO = 0;
                    }

                    public void onAnimationStart(Animator animator) {
                        view.setVisibility(0);
                    }
                });
            } else {
                view.setVisibility(0);
                view.setAlpha(1.0f);
                view.setScaleY(1.0f);
                view.setScaleX(1.0f);
            }
        }
    }

    private static boolean O00000o(View view) {
        boolean z = false;
        if (view.getVisibility() == 0) {
            if (O00000oO == 1) {
                z = true;
            }
            return z;
        }
        if (O00000oO != 2) {
            z = true;
        }
        return z;
    }

    private static boolean O00000o0(View view) {
        boolean z = false;
        if (view.getVisibility() != 0) {
            if (O00000oO == 2) {
                z = true;
            }
            return z;
        }
        if (O00000oO != 1) {
            z = true;
        }
        return z;
    }

    private static boolean O00000oO(View view) {
        return ViewCompat.isLaidOut(view) && !view.isInEditMode();
    }
}
