package com.ximalaya.ting.android.opensdk.auth.utils;

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
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import java.io.InputStream;
import java.util.Locale;

/* compiled from: ResourceManager */
public class d {
    private static final String a = "com.ximalaya.ting.android.opensdk.auth.utils.d";
    private static final String b = "drawable";
    private static final String c = "drawable-ldpi";
    private static final String d = "drawable-mdpi";
    private static final String e = "drawable-hdpi";
    private static final String f = "drawable-xhdpi";
    private static final String g = "drawable-xxhdpi";
    private static final String[] h = new String[]{g, f, e, d, c, b};

    public static int a(Context context, int i) {
        return (int) (((double) (((float) i) * context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static ColorStateList a() {
        int[] iArr = new int[]{-6710887, -6710887, -6710887, -498622};
        int[][] iArr2 = new int[4][];
        iArr2[0] = new int[]{16842919};
        iArr2[1] = new int[]{16842913};
        iArr2[2] = new int[]{16842908};
        iArr2[3] = StateSet.WILD_CARD;
        return new ColorStateList(iArr2, iArr);
    }

    public static Drawable a(Context context, String str) {
        return a(context, c(context, str), false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064 A:{SYNTHETIC, Splitter:B:23:0x0064} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A:{SYNTHETIC, Splitter:B:29:0x006d} */
    private static android.graphics.drawable.Drawable a(android.content.Context r8, java.lang.String r9, boolean r10) {
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
        goto L_0x006b;
    L_0x005d:
        r8 = move-exception;
        r9 = r1;
    L_0x005f:
        r8.printStackTrace();	 Catch:{ all -> 0x006a }
        if (r9 == 0) goto L_0x0067;
    L_0x0064:
        r9.close();	 Catch:{ IOException -> 0x0055 }
    L_0x0067:
        r1 = (android.graphics.drawable.Drawable) r1;
        return r1;
    L_0x006a:
        r8 = move-exception;
    L_0x006b:
        if (r9 == 0) goto L_0x0075;
    L_0x006d:
        r9.close();	 Catch:{ IOException -> 0x0071 }
        goto L_0x0075;
    L_0x0071:
        r9 = move-exception;
        r9.printStackTrace();
    L_0x0075:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.auth.utils.d.a(android.content.Context, java.lang.String, boolean):android.graphics.drawable.Drawable");
    }

    public static StateListDrawable a(Context context, String str, String str2) {
        Drawable b = str.indexOf(".9") >= 0 ? b(context, str) : a(context, str);
        Drawable b2 = str2.indexOf(".9") >= 0 ? b(context, str2) : a(context, str2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, b2);
        stateListDrawable.addState(new int[]{16842913}, b2);
        stateListDrawable.addState(new int[]{16842908}, b2);
        stateListDrawable.addState(StateSet.WILD_CARD, b);
        return stateListDrawable;
    }

    private static StateListDrawable a(Context context, String str, String str2, String str3) {
        Drawable b = str.indexOf(".9") >= 0 ? b(context, str) : a(context, str);
        Drawable b2 = str3.indexOf(".9") >= 0 ? b(context, str3) : a(context, str3);
        Drawable b3 = str2.indexOf(".9") >= 0 ? b(context, str2) : a(context, str2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, b3);
        stateListDrawable.addState(new int[]{16842913}, b3);
        stateListDrawable.addState(new int[]{16842908}, b3);
        stateListDrawable.addState(new int[]{16842910}, b2);
        stateListDrawable.addState(StateSet.WILD_CARD, b);
        return stateListDrawable;
    }

    private static View a(Context context, String str, ViewGroup viewGroup) throws Exception {
        return LayoutInflater.from(context).inflate(context.getAssets().openXmlResourceParser(str), viewGroup);
    }

    private static String a(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        return i <= XmPlayerService.CODE_GET_SUBJECTDETAIL ? c : (i <= XmPlayerService.CODE_GET_SUBJECTDETAIL || i > 160) ? (i <= 160 || i > 240) ? (i <= 240 || i > 320) ? g : f : e : d;
    }

    private static String a(String str, String str2, String str3) {
        Object obj = Locale.getDefault();
        if (!(Locale.SIMPLIFIED_CHINESE.equals(obj) || Locale.TRADITIONAL_CHINESE.equals(obj))) {
            obj = Locale.ENGLISH;
        }
        return Locale.SIMPLIFIED_CHINESE.equals(obj) ? str2 : Locale.TRADITIONAL_CHINESE.equals(obj) ? str3 : str;
    }

    private static Drawable b(Context context, String str) {
        return a(context, c(context, str), true);
    }

    private static Locale b() {
        Locale locale = Locale.getDefault();
        return (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale)) ? locale : Locale.ENGLISH;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARNING: Missing block: B:37:0x0090, code skipped:
            if (java.lang.Math.abs(r4 - r2) <= java.lang.Math.abs(r4 - r5)) goto L_0x009d;
     */
    private static java.lang.String c(android.content.Context r8, java.lang.String r9) {
        /*
        r0 = android.text.TextUtils.isEmpty(r9);
        r1 = 0;
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r8 = a;
        r9 = "id is NOT correct!";
        com.ximalaya.ting.android.opensdk.auth.utils.Logger.e(r8, r9);
        return r1;
    L_0x000f:
        r0 = r8.getResources();
        r0 = r0.getDisplayMetrics();
        r0 = r0.densityDpi;
        r2 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        if (r0 > r2) goto L_0x0020;
    L_0x001d:
        r0 = "drawable-ldpi";
        goto L_0x003d;
    L_0x0020:
        r3 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        if (r0 <= r2) goto L_0x0029;
    L_0x0024:
        if (r0 > r3) goto L_0x0029;
    L_0x0026:
        r0 = "drawable-mdpi";
        goto L_0x003d;
    L_0x0029:
        r2 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
        if (r0 <= r3) goto L_0x0032;
    L_0x002d:
        if (r0 > r2) goto L_0x0032;
    L_0x002f:
        r0 = "drawable-hdpi";
        goto L_0x003d;
    L_0x0032:
        if (r0 <= r2) goto L_0x003b;
    L_0x0034:
        r2 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        if (r0 > r2) goto L_0x003b;
    L_0x0038:
        r0 = "drawable-xhdpi";
        goto L_0x003d;
    L_0x003b:
        r0 = "drawable-xxhdpi";
    L_0x003d:
        r2 = a;
        r3 = "find Appropriate path...";
        com.ximalaya.ting.android.opensdk.auth.utils.Logger.d(r2, r3);
        r2 = 0;
        r3 = -1;
        r4 = r3;
        r5 = r4;
    L_0x0048:
        r6 = h;
        r6 = r6.length;
        if (r2 >= r6) goto L_0x0080;
    L_0x004d:
        r6 = h;
        r6 = r6[r2];
        r6 = r6.equals(r0);
        if (r6 == 0) goto L_0x0058;
    L_0x0057:
        r4 = r2;
    L_0x0058:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = h;
        r7 = r7[r2];
        r6.append(r7);
        r7 = "/";
        r6.append(r7);
        r6.append(r9);
        r6 = r6.toString();
        r7 = d(r8, r6);
        if (r7 == 0) goto L_0x007d;
    L_0x0076:
        if (r4 != r2) goto L_0x0079;
    L_0x0078:
        return r6;
    L_0x0079:
        if (r4 < 0) goto L_0x007c;
    L_0x007b:
        goto L_0x0081;
    L_0x007c:
        r5 = r2;
    L_0x007d:
        r2 = r2 + 1;
        goto L_0x0048;
    L_0x0080:
        r2 = r3;
    L_0x0081:
        if (r5 <= 0) goto L_0x0093;
    L_0x0083:
        if (r2 <= 0) goto L_0x0093;
    L_0x0085:
        r8 = r4 - r2;
        r8 = java.lang.Math.abs(r8);
        r4 = r4 - r5;
        r0 = java.lang.Math.abs(r4);
        if (r8 > r0) goto L_0x0097;
    L_0x0092:
        goto L_0x009d;
    L_0x0093:
        if (r5 <= 0) goto L_0x0099;
    L_0x0095:
        if (r2 >= 0) goto L_0x0099;
    L_0x0097:
        r3 = r5;
        goto L_0x00a6;
    L_0x0099:
        if (r5 >= 0) goto L_0x009f;
    L_0x009b:
        if (r2 <= 0) goto L_0x009f;
    L_0x009d:
        r3 = r2;
        goto L_0x00a6;
    L_0x009f:
        r8 = a;
        r0 = "Not find the appropriate path for drawable";
        com.ximalaya.ting.android.opensdk.auth.utils.Logger.e(r8, r0);
    L_0x00a6:
        if (r3 >= 0) goto L_0x00b0;
    L_0x00a8:
        r8 = a;
        r9 = "Not find the appropriate path for drawable";
        com.ximalaya.ting.android.opensdk.auth.utils.Logger.e(r8, r9);
        return r1;
    L_0x00b0:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = h;
        r0 = r0[r3];
        r8.append(r0);
        r0 = "/";
        r8.append(r0);
        r8.append(r9);
        r8 = r8.toString();
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.auth.utils.d.c(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057 A:{SYNTHETIC, Splitter:B:24:0x0057} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0062 A:{SYNTHETIC, Splitter:B:30:0x0062} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:19|18|21|22|(0)|28) */
    /* JADX WARNING: Missing block: B:20:0x003b, code skipped:
            r5 = th;
     */
    /* JADX WARNING: Missing block: B:25:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:26:0x005b, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:27:0x005c, code skipped:
            r4.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:32:0x0066, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:33:0x0067, code skipped:
            r4.printStackTrace();
     */
    private static boolean d(android.content.Context r4, java.lang.String r5) {
        /*
        r0 = 0;
        if (r4 == 0) goto L_0x006b;
    L_0x0003:
        r1 = android.text.TextUtils.isEmpty(r5);
        if (r1 != 0) goto L_0x006b;
    L_0x0009:
        r4 = r4.getAssets();
        r1 = 0;
        r4 = r4.open(r5);	 Catch:{ IOException -> 0x003d }
        r1 = a;	 Catch:{ IOException -> 0x0039, all -> 0x0036 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0039, all -> 0x0036 }
        r3 = "file [";
        r2.<init>(r3);	 Catch:{ IOException -> 0x0039, all -> 0x0036 }
        r2.append(r5);	 Catch:{ IOException -> 0x0039, all -> 0x0036 }
        r3 = "] existed";
        r2.append(r3);	 Catch:{ IOException -> 0x0039, all -> 0x0036 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0039, all -> 0x0036 }
        com.ximalaya.ting.android.opensdk.auth.utils.Logger.d(r1, r2);	 Catch:{ IOException -> 0x0039, all -> 0x0036 }
        if (r4 == 0) goto L_0x0034;
    L_0x002c:
        r4.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0034;
    L_0x0030:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0034:
        r4 = 1;
        return r4;
    L_0x0036:
        r5 = move-exception;
        r1 = r4;
        goto L_0x0060;
    L_0x0039:
        r1 = r4;
        goto L_0x003d;
    L_0x003b:
        r5 = move-exception;
        goto L_0x0060;
    L_0x003d:
        r4 = a;	 Catch:{ all -> 0x003b }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003b }
        r3 = "file [";
        r2.<init>(r3);	 Catch:{ all -> 0x003b }
        r2.append(r5);	 Catch:{ all -> 0x003b }
        r5 = "] NOT existed";
        r2.append(r5);	 Catch:{ all -> 0x003b }
        r5 = r2.toString();	 Catch:{ all -> 0x003b }
        com.ximalaya.ting.android.opensdk.auth.utils.Logger.d(r4, r5);	 Catch:{ all -> 0x003b }
        if (r1 == 0) goto L_0x005f;
    L_0x0057:
        r1.close();	 Catch:{ IOException -> 0x005b }
        goto L_0x005f;
    L_0x005b:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x005f:
        return r0;
    L_0x0060:
        if (r1 == 0) goto L_0x006a;
    L_0x0062:
        r1.close();	 Catch:{ IOException -> 0x0066 }
        goto L_0x006a;
    L_0x0066:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x006a:
        throw r5;
    L_0x006b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.auth.utils.d.d(android.content.Context, java.lang.String):boolean");
    }

    private static Drawable e(Context context, String str) throws Exception {
        InputStream open = context.getAssets().open(str);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedValue typedValue = new TypedValue();
        typedValue.density = displayMetrics.densityDpi;
        Drawable createFromResourceStream = Drawable.createFromResourceStream(context.getResources(), typedValue, open, str);
        open.close();
        return createFromResourceStream;
    }
}
