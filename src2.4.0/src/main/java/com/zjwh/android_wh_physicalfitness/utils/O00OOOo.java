package com.zjwh.android_wh_physicalfitness.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.ximalaya.ting.android.opensdk.constants.PreferenceConstantsInOpenSdk;

/* compiled from: StatusBarUtil */
public class O00OOOo {
    public static final int O000000o = 112;
    private static final int O00000Oo = 2131297116;
    private static final int O00000o = -123;
    private static final int O00000o0 = 2131297117;

    private static int O000000o(@ColorInt int i, int i2) {
        if (i2 == 0) {
            return i;
        }
        float f = 1.0f - (((float) i2) / 255.0f);
        return ((int) (((double) (((float) (i & 255)) * f)) + 0.5d)) | (((((int) (((double) (((float) ((i >> 16) & 255)) * f)) + 0.5d)) << 16) | -16777216) | (((int) (((double) (((float) ((i >> 8) & 255)) * f)) + 0.5d)) << 8));
    }

    public static int O000000o(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier(PreferenceConstantsInOpenSdk.OPENSDK_KEY_STATUS_BAR_HEIGHT, "dimen", "android"));
    }

    public static void O000000o(Activity activity) {
        if (VERSION.SDK_INT >= 19) {
            O00000oO(activity);
            O00000o0(activity);
        }
    }

    public static void O000000o(Activity activity, @ColorInt int i) {
        O000000o(activity, i, 112);
    }

    public static void O000000o(Activity activity, @ColorInt int i, @IntRange(from = 0, to = 255) int i2) {
        if (VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().setStatusBarColor(O000000o(i, i2));
        } else if (VERSION.SDK_INT >= 19) {
            activity.getWindow().addFlags(67108864);
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            View findViewById = viewGroup.findViewById(2131297116);
            if (findViewById != null) {
                if (findViewById.getVisibility() == 8) {
                    findViewById.setVisibility(0);
                }
                findViewById.setBackgroundColor(O000000o(i, i2));
            } else {
                viewGroup.addView(O00000Oo(activity, i, i2));
            }
            O00000o0(activity);
        }
    }

    public static void O000000o(Activity activity, @IntRange(from = 0, to = 255) int i, View view) {
        if (VERSION.SDK_INT >= 19) {
            O00000o(activity);
            O000000o(activity, i, false);
            if (view != null) {
                Object tag = view.getTag(O00000o);
                if (tag == null || !((Boolean) tag).booleanValue()) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + O000000o((Context) activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setTag(O00000o, Boolean.valueOf(true));
                }
            }
        }
    }

    private static void O000000o(Activity activity, @IntRange(from = 0, to = 255) int i, boolean z) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        View findViewById = viewGroup.findViewById(2131297117);
        if (findViewById != null) {
            if (findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            }
            if (z) {
                findViewById.setBackgroundColor(Color.argb(i, 0, 0, 0));
            } else if (VERSION.SDK_INT >= 23) {
                findViewById.setBackgroundColor(Color.argb(i, 255, 255, 255));
            } else {
                findViewById.setBackgroundColor(Color.argb(i, 64, 64, 64));
            }
        } else if (z) {
            viewGroup.addView(O00000Oo(activity, i));
        } else {
            viewGroup.addView(O00000o0(activity, i));
        }
    }

    public static void O000000o(Activity activity, View view) {
        O000000o(activity, 0, view);
    }

    private static View O00000Oo(Activity activity, int i) {
        View view = new View(activity);
        view.setLayoutParams(new LayoutParams(-1, O000000o((Context) activity)));
        view.setBackgroundColor(Color.argb(i, 0, 0, 0));
        view.setId(2131297117);
        return view;
    }

    private static View O00000Oo(Activity activity, @ColorInt int i, int i2) {
        View view = new View(activity);
        view.setLayoutParams(new LayoutParams(-1, O000000o((Context) activity)));
        view.setBackgroundColor(O000000o(i, i2));
        view.setId(2131297116);
        return view;
    }

    @TargetApi(19)
    private static void O00000Oo(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewById = viewGroup.findViewById(2131297116);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
            ((ViewGroup) ((ViewGroup) activity.findViewById(16908290)).getChildAt(0)).setPadding(0, 0, 0, 0);
        }
    }

    public static void O00000Oo(Activity activity, @IntRange(from = 0, to = 255) int i, View view) {
        O000000o(activity, i, view);
        if (VERSION.SDK_INT >= 19 && VERSION.SDK_INT < 21) {
            O00000Oo(activity);
        }
    }

    public static void O00000Oo(Activity activity, View view) {
        O000000o(activity, 112, view);
    }

    private static void O00000o(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else if (VERSION.SDK_INT >= 19) {
            activity.getWindow().setFlags(67108864, 67108864);
        }
    }

    private static void O00000o(Activity activity, @IntRange(from = 0, to = 255) int i, View view) {
        if (VERSION.SDK_INT >= 19) {
            O00000o(activity);
            O000000o(activity, i, true);
            if (view != null) {
                Object tag = view.getTag(O00000o);
                if (tag == null || !((Boolean) tag).booleanValue()) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + O000000o((Context) activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    view.setTag(O00000o, Boolean.valueOf(true));
                }
            }
        }
    }

    private static View O00000o0(Activity activity, int i) {
        View view = new View(activity);
        view.setLayoutParams(new LayoutParams(-1, O000000o((Context) activity)));
        if (VERSION.SDK_INT >= 23) {
            view.setBackgroundColor(Color.argb(i, 255, 255, 255));
        } else {
            view.setBackgroundColor(Color.argb(i, 64, 64, 64));
        }
        view.setId(2131297117);
        return view;
    }

    private static void O00000o0(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    public static void O00000o0(Activity activity, @IntRange(from = 0, to = 255) int i, View view) {
        O00000o(activity, i, view);
        if (VERSION.SDK_INT >= 19 && VERSION.SDK_INT < 21) {
            O00000Oo(activity);
        }
    }

    public static void O00000o0(Activity activity, View view) {
        O00000Oo(activity, 0, view);
    }

    @TargetApi(19)
    private static void O00000oO(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(67108864);
            activity.getWindow().addFlags(134217728);
            activity.getWindow().setStatusBarColor(0);
            return;
        }
        activity.getWindow().addFlags(67108864);
    }
}
