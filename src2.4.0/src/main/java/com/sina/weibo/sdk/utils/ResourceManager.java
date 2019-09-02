package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.jiguang.net.HttpUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class ResourceManager {
    private static final String DRAWABLE = "drawable";
    private static final String DRAWABLE_HDPI = "drawable-hdpi";
    private static final String DRAWABLE_LDPI = "drawable-ldpi";
    private static final String DRAWABLE_MDPI = "drawable-mdpi";
    private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
    private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
    private static final String[] PRE_INSTALL_DRAWBLE_PATHS = new String[]{DRAWABLE_XXHDPI, DRAWABLE_XHDPI, DRAWABLE_HDPI, DRAWABLE_MDPI, DRAWABLE_LDPI, DRAWABLE};
    private static final String TAG = "com.sina.weibo.sdk.utils.ResourceManager";

    public static ColorStateList createColorStateList(int i, int i2) {
        int[] iArr = new int[]{i2, i2, i2, i};
        int[][] iArr2 = new int[4][];
        iArr2[0] = new int[]{16842919};
        iArr2[1] = new int[]{16842913};
        iArr2[2] = new int[]{16842908};
        iArr2[3] = StateSet.WILD_CARD;
        return new ColorStateList(iArr2, iArr);
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2) {
        Drawable ninePatchDrawable = str.indexOf(".9") > -1 ? getNinePatchDrawable(context, str) : getDrawable(context, str);
        Drawable ninePatchDrawable2 = str2.indexOf(".9") > -1 ? getNinePatchDrawable(context, str2) : getDrawable(context, str2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, ninePatchDrawable2);
        stateListDrawable.addState(new int[]{16842913}, ninePatchDrawable2);
        stateListDrawable.addState(new int[]{16842908}, ninePatchDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, ninePatchDrawable);
        return stateListDrawable;
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2, String str3) {
        Drawable ninePatchDrawable = str.indexOf(".9") > -1 ? getNinePatchDrawable(context, str) : getDrawable(context, str);
        Drawable ninePatchDrawable2 = str3.indexOf(".9") > -1 ? getNinePatchDrawable(context, str3) : getDrawable(context, str3);
        Drawable ninePatchDrawable3 = str2.indexOf(".9") > -1 ? getNinePatchDrawable(context, str2) : getDrawable(context, str2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, ninePatchDrawable3);
        stateListDrawable.addState(new int[]{16842913}, ninePatchDrawable3);
        stateListDrawable.addState(new int[]{16842908}, ninePatchDrawable3);
        stateListDrawable.addState(new int[]{16842766}, ninePatchDrawable2);
        stateListDrawable.addState(StateSet.WILD_CARD, ninePatchDrawable);
        return stateListDrawable;
    }

    public static int dp2px(Context context, int i) {
        return (int) (((double) (((float) i) * context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    private static Drawable extractDrawable(Context context, String str) throws Exception {
        InputStream open = context.getAssets().open(str);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedValue typedValue = new TypedValue();
        typedValue.density = displayMetrics.densityDpi;
        Drawable createFromResourceStream = Drawable.createFromResourceStream(context.getResources(), typedValue, open, str);
        open.close();
        return createFromResourceStream;
    }

    private static View extractView(Context context, String str, ViewGroup viewGroup) throws Exception {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(context.getAssets().openXmlResourceParser(str), viewGroup);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARNING: Missing block: B:21:0x0065, code skipped:
            if (java.lang.Math.abs(r4 - r2) <= java.lang.Math.abs(r4 - r5)) goto L_0x0072;
     */
    private static java.lang.String getAppropriatePathOfDrawable(android.content.Context r8, java.lang.String r9) {
        /*
        r0 = android.text.TextUtils.isEmpty(r9);
        r1 = 0;
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r8 = TAG;
        r9 = "id is NOT correct!";
        com.sina.weibo.sdk.utils.LogUtil.e(r8, r9);
        return r1;
    L_0x000f:
        r0 = getCurrentDpiFolder(r8);
        r2 = TAG;
        r3 = "find Appropriate path...";
        com.sina.weibo.sdk.utils.LogUtil.d(r2, r3);
        r2 = 0;
        r3 = -1;
        r4 = r3;
        r5 = r4;
    L_0x001e:
        r6 = PRE_INSTALL_DRAWBLE_PATHS;
        r6 = r6.length;
        if (r2 >= r6) goto L_0x0055;
    L_0x0023:
        r6 = PRE_INSTALL_DRAWBLE_PATHS;
        r6 = r6[r2];
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x002e;
    L_0x002d:
        r4 = r2;
    L_0x002e:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = PRE_INSTALL_DRAWBLE_PATHS;
        r7 = r7[r2];
        r6.append(r7);
        r7 = "/";
        r6.append(r7);
        r6.append(r9);
        r6 = r6.toString();
        r7 = isFileExisted(r8, r6);
        if (r7 == 0) goto L_0x0052;
    L_0x004c:
        if (r4 != r2) goto L_0x004f;
    L_0x004e:
        return r6;
    L_0x004f:
        if (r4 >= 0) goto L_0x0056;
    L_0x0051:
        r5 = r2;
    L_0x0052:
        r2 = r2 + 1;
        goto L_0x001e;
    L_0x0055:
        r2 = r3;
    L_0x0056:
        if (r5 <= 0) goto L_0x0068;
    L_0x0058:
        if (r2 <= 0) goto L_0x0068;
    L_0x005a:
        r8 = r4 - r2;
        r8 = java.lang.Math.abs(r8);
        r4 = r4 - r5;
        r0 = java.lang.Math.abs(r4);
        if (r8 > r0) goto L_0x006c;
    L_0x0067:
        goto L_0x0072;
    L_0x0068:
        if (r5 <= 0) goto L_0x006e;
    L_0x006a:
        if (r2 >= 0) goto L_0x006e;
    L_0x006c:
        r3 = r5;
        goto L_0x007b;
    L_0x006e:
        if (r5 >= 0) goto L_0x0074;
    L_0x0070:
        if (r2 <= 0) goto L_0x0074;
    L_0x0072:
        r3 = r2;
        goto L_0x007b;
    L_0x0074:
        r8 = TAG;
        r0 = "Not find the appropriate path for drawable";
        com.sina.weibo.sdk.utils.LogUtil.e(r8, r0);
    L_0x007b:
        if (r3 >= 0) goto L_0x0085;
    L_0x007d:
        r8 = TAG;
        r9 = "Not find the appropriate path for drawable";
        com.sina.weibo.sdk.utils.LogUtil.e(r8, r9);
        return r1;
    L_0x0085:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = PRE_INSTALL_DRAWBLE_PATHS;
        r0 = r0[r3];
        r8.append(r0);
        r0 = "/";
        r8.append(r0);
        r8.append(r9);
        r8 = r8.toString();
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ResourceManager.getAppropriatePathOfDrawable(android.content.Context, java.lang.String):java.lang.String");
    }

    private static String getCurrentDpiFolder(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        return i <= GlMapUtil.DEVICE_DISPLAY_DPI_LOW ? DRAWABLE_LDPI : (i <= GlMapUtil.DEVICE_DISPLAY_DPI_LOW || i > GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL) ? (i <= GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL || i > GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) ? (i <= GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN || i > GlMapUtil.DEVICE_DISPLAY_DPI_HIGH) ? DRAWABLE_XXHDPI : DRAWABLE_XHDPI : DRAWABLE_HDPI : DRAWABLE_MDPI;
    }

    public static Drawable getDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064 A:{SYNTHETIC, Splitter:B:23:0x0064} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b A:{SYNTHETIC, Splitter:B:28:0x006b} */
    private static android.graphics.drawable.Drawable getDrawableFromAssert(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
        r0 = r8.getAssets();
        r1 = 0;
        r9 = r0.open(r9);	 Catch:{ IOException -> 0x005d, all -> 0x005a }
        if (r9 == 0) goto L_0x004f;
    L_0x000b:
        r4 = android.graphics.BitmapFactory.decodeStream(r9);	 Catch:{ IOException -> 0x004d }
        r0 = r8.getResources();	 Catch:{ IOException -> 0x004d }
        r0 = r0.getDisplayMetrics();	 Catch:{ IOException -> 0x004d }
        if (r10 == 0) goto L_0x003d;
    L_0x0019:
        r10 = r8.getResources();	 Catch:{ IOException -> 0x004d }
        r10 = r10.getConfiguration();	 Catch:{ IOException -> 0x004d }
        r3 = new android.content.res.Resources;	 Catch:{ IOException -> 0x004d }
        r8 = r8.getAssets();	 Catch:{ IOException -> 0x004d }
        r3.<init>(r8, r0, r10);	 Catch:{ IOException -> 0x004d }
        r8 = new android.graphics.drawable.NinePatchDrawable;	 Catch:{ IOException -> 0x004d }
        r5 = r4.getNinePatchChunk();	 Catch:{ IOException -> 0x004d }
        r6 = new android.graphics.Rect;	 Catch:{ IOException -> 0x004d }
        r10 = 0;
        r6.<init>(r10, r10, r10, r10);	 Catch:{ IOException -> 0x004d }
        r7 = 0;
        r2 = r8;
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ IOException -> 0x004d }
        r1 = r8;
        goto L_0x004f;
    L_0x003d:
        r10 = r0.densityDpi;	 Catch:{ IOException -> 0x004d }
        r4.setDensity(r10);	 Catch:{ IOException -> 0x004d }
        r10 = new android.graphics.drawable.BitmapDrawable;	 Catch:{ IOException -> 0x004d }
        r8 = r8.getResources();	 Catch:{ IOException -> 0x004d }
        r10.<init>(r8, r4);	 Catch:{ IOException -> 0x004d }
        r1 = r10;
        goto L_0x004f;
    L_0x004d:
        r8 = move-exception;
        goto L_0x005f;
    L_0x004f:
        if (r9 == 0) goto L_0x0067;
    L_0x0051:
        r9.close();	 Catch:{ IOException -> 0x0055 }
        goto L_0x0067;
    L_0x0055:
        r8 = move-exception;
        r8.printStackTrace();
        goto L_0x0067;
    L_0x005a:
        r8 = move-exception;
        r9 = r1;
        goto L_0x0069;
    L_0x005d:
        r8 = move-exception;
        r9 = r1;
    L_0x005f:
        r8.printStackTrace();	 Catch:{ all -> 0x0068 }
        if (r9 == 0) goto L_0x0067;
    L_0x0064:
        r9.close();	 Catch:{ IOException -> 0x0055 }
    L_0x0067:
        return r1;
    L_0x0068:
        r8 = move-exception;
    L_0x0069:
        if (r9 == 0) goto L_0x0073;
    L_0x006b:
        r9.close();	 Catch:{ IOException -> 0x006f }
        goto L_0x0073;
    L_0x006f:
        r9 = move-exception;
        r9.printStackTrace();
    L_0x0073:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ResourceManager.getDrawableFromAssert(android.content.Context, java.lang.String, boolean):android.graphics.drawable.Drawable");
    }

    public static Locale getLanguage() {
        Locale locale = Locale.getDefault();
        return (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale) || (locale.getLanguage().equals("zh") && (locale.getCountry().contains("CN") || locale.getCountry().contains("TW")))) ? locale : Locale.ENGLISH;
    }

    public static Drawable getNinePatchDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), true);
    }

    public static String getString(Context context, String str, String str2, String str3) {
        Locale language = getLanguage();
        return (Locale.SIMPLIFIED_CHINESE.equals(language) || ("zh".equals(language.getLanguage()) && language.getCountry().contains("CN"))) ? str2 : (Locale.TRADITIONAL_CHINESE.equals(language) || ("zh".equals(language.getLanguage()) && language.getCountry().contains("TW"))) ? str3 : str;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e A:{SYNTHETIC, Splitter:B:24:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069 A:{SYNTHETIC, Splitter:B:30:0x0069} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:25:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:26:0x0062, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:27:0x0063, code skipped:
            r4.printStackTrace();
     */
    private static boolean isFileExisted(android.content.Context r4, java.lang.String r5) {
        /*
        r0 = 0;
        if (r4 == 0) goto L_0x0072;
    L_0x0003:
        r1 = android.text.TextUtils.isEmpty(r5);
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0072;
    L_0x000a:
        r4 = r4.getAssets();
        r1 = 0;
        r4 = r4.open(r5);	 Catch:{ IOException -> 0x0041 }
        r1 = TAG;	 Catch:{ IOException -> 0x003d, all -> 0x003a }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003d, all -> 0x003a }
        r2.<init>();	 Catch:{ IOException -> 0x003d, all -> 0x003a }
        r3 = "file [";
        r2.append(r3);	 Catch:{ IOException -> 0x003d, all -> 0x003a }
        r2.append(r5);	 Catch:{ IOException -> 0x003d, all -> 0x003a }
        r3 = "] existed";
        r2.append(r3);	 Catch:{ IOException -> 0x003d, all -> 0x003a }
        r2 = r2.toString();	 Catch:{ IOException -> 0x003d, all -> 0x003a }
        com.sina.weibo.sdk.utils.LogUtil.d(r1, r2);	 Catch:{ IOException -> 0x003d, all -> 0x003a }
        r5 = 1;
        if (r4 == 0) goto L_0x0039;
    L_0x0031:
        r4.close();	 Catch:{ IOException -> 0x0035 }
        goto L_0x0039;
    L_0x0035:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0039:
        return r5;
    L_0x003a:
        r5 = move-exception;
        r1 = r4;
        goto L_0x0067;
    L_0x003d:
        r1 = r4;
        goto L_0x0041;
    L_0x003f:
        r5 = move-exception;
        goto L_0x0067;
    L_0x0041:
        r4 = TAG;	 Catch:{ all -> 0x003f }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003f }
        r2.<init>();	 Catch:{ all -> 0x003f }
        r3 = "file [";
        r2.append(r3);	 Catch:{ all -> 0x003f }
        r2.append(r5);	 Catch:{ all -> 0x003f }
        r5 = "] NOT existed";
        r2.append(r5);	 Catch:{ all -> 0x003f }
        r5 = r2.toString();	 Catch:{ all -> 0x003f }
        com.sina.weibo.sdk.utils.LogUtil.d(r4, r5);	 Catch:{ all -> 0x003f }
        if (r1 == 0) goto L_0x0066;
    L_0x005e:
        r1.close();	 Catch:{ IOException -> 0x0062 }
        goto L_0x0066;
    L_0x0062:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0066:
        return r0;
    L_0x0067:
        if (r1 == 0) goto L_0x0071;
    L_0x0069:
        r1.close();	 Catch:{ IOException -> 0x006d }
        goto L_0x0071;
    L_0x006d:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0071:
        throw r5;
    L_0x0072:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ResourceManager.isFileExisted(android.content.Context, java.lang.String):boolean");
    }

    public static String readCountryFromAsset(Context context, String str) {
        IOException e;
        String str2 = "";
        try {
            InputStream open = context.getAssets().open(str);
            if (open == null) {
                return str2;
            }
            DataInputStream dataInputStream = new DataInputStream(open);
            byte[] bArr = new byte[dataInputStream.available()];
            dataInputStream.read(bArr);
            str = new String(bArr, HttpUtils.ENCODING_UTF_8);
            try {
                open.close();
                return str;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            str = str2;
            e.printStackTrace();
            return str;
        }
    }
}
