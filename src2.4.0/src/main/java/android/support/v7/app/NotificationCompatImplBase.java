package android.support.v7.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompatBase;
import android.support.v7.appcompat.R;
import android.widget.RemoteViews;
import java.util.List;

@TargetApi(9)
@RequiresApi(9)
class NotificationCompatImplBase {
    private static final int MAX_ACTION_BUTTONS = 3;
    static final int MAX_MEDIA_BUTTONS = 5;
    static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;

    NotificationCompatImplBase() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01dc  */
    public static android.widget.RemoteViews applyStandardTemplate(android.content.Context r17, java.lang.CharSequence r18, java.lang.CharSequence r19, java.lang.CharSequence r20, int r21, int r22, android.graphics.Bitmap r23, java.lang.CharSequence r24, boolean r25, long r26, int r28, int r29, int r30, boolean r31) {
        /*
        r0 = r17;
        r1 = r18;
        r2 = r19;
        r3 = r20;
        r4 = r21;
        r5 = r22;
        r6 = r23;
        r7 = r24;
        r8 = r26;
        r10 = r29;
        r11 = r17.getResources();
        r12 = new android.widget.RemoteViews;
        r13 = r17.getPackageName();
        r14 = r30;
        r12.<init>(r13, r14);
        r13 = -1;
        r14 = r28;
        if (r14 >= r13) goto L_0x002a;
    L_0x0028:
        r14 = 1;
        goto L_0x002b;
    L_0x002a:
        r14 = 0;
    L_0x002b:
        r13 = android.os.Build.VERSION.SDK_INT;
        r15 = 16;
        if (r13 < r15) goto L_0x005e;
    L_0x0031:
        r13 = android.os.Build.VERSION.SDK_INT;
        r15 = 21;
        if (r13 >= r15) goto L_0x005e;
    L_0x0037:
        if (r14 == 0) goto L_0x004c;
    L_0x0039:
        r13 = android.support.v7.appcompat.R.id.notification_background;
        r14 = "setBackgroundResource";
        r15 = android.support.v7.appcompat.R.drawable.notification_bg_low;
        r12.setInt(r13, r14, r15);
        r13 = android.support.v7.appcompat.R.id.icon;
        r14 = "setBackgroundResource";
        r15 = android.support.v7.appcompat.R.drawable.notification_template_icon_low_bg;
        r12.setInt(r13, r14, r15);
        goto L_0x005e;
    L_0x004c:
        r13 = android.support.v7.appcompat.R.id.notification_background;
        r14 = "setBackgroundResource";
        r15 = android.support.v7.appcompat.R.drawable.notification_bg;
        r12.setInt(r13, r14, r15);
        r13 = android.support.v7.appcompat.R.id.icon;
        r14 = "setBackgroundResource";
        r15 = android.support.v7.appcompat.R.drawable.notification_template_icon_bg;
        r12.setInt(r13, r14, r15);
    L_0x005e:
        r15 = 8;
        if (r6 == 0) goto L_0x00ac;
    L_0x0062:
        r13 = android.os.Build.VERSION.SDK_INT;
        r14 = 16;
        if (r13 < r14) goto L_0x0074;
    L_0x0068:
        r13 = android.support.v7.appcompat.R.id.icon;
        r14 = 0;
        r12.setViewVisibility(r13, r14);
        r13 = android.support.v7.appcompat.R.id.icon;
        r12.setImageViewBitmap(r13, r6);
        goto L_0x0079;
    L_0x0074:
        r13 = android.support.v7.appcompat.R.id.icon;
        r12.setViewVisibility(r13, r15);
    L_0x0079:
        if (r5 == 0) goto L_0x00e1;
    L_0x007b:
        r13 = android.support.v7.appcompat.R.dimen.notification_right_icon_size;
        r13 = r11.getDimensionPixelSize(r13);
        r14 = android.support.v7.appcompat.R.dimen.notification_small_icon_background_padding;
        r14 = r11.getDimensionPixelSize(r14);
        r14 = r14 * 2;
        r14 = r13 - r14;
        r15 = android.os.Build.VERSION.SDK_INT;
        r8 = 21;
        if (r15 < r8) goto L_0x009b;
    L_0x0091:
        r0 = createIconWithBackground(r0, r5, r13, r14, r10);
        r5 = android.support.v7.appcompat.R.id.right_icon;
        r12.setImageViewBitmap(r5, r0);
        goto L_0x00a5;
    L_0x009b:
        r8 = android.support.v7.appcompat.R.id.right_icon;
        r9 = -1;
        r0 = createColoredBitmap(r0, r5, r9);
        r12.setImageViewBitmap(r8, r0);
    L_0x00a5:
        r0 = android.support.v7.appcompat.R.id.right_icon;
        r8 = 0;
        r12.setViewVisibility(r0, r8);
        goto L_0x00e1;
    L_0x00ac:
        r8 = 0;
        if (r5 == 0) goto L_0x00e1;
    L_0x00af:
        r9 = android.support.v7.appcompat.R.id.icon;
        r12.setViewVisibility(r9, r8);
        r8 = android.os.Build.VERSION.SDK_INT;
        r9 = 21;
        if (r8 < r9) goto L_0x00d7;
    L_0x00ba:
        r8 = android.support.v7.appcompat.R.dimen.notification_large_icon_width;
        r8 = r11.getDimensionPixelSize(r8);
        r9 = android.support.v7.appcompat.R.dimen.notification_big_circle_margin;
        r9 = r11.getDimensionPixelSize(r9);
        r8 = r8 - r9;
        r9 = android.support.v7.appcompat.R.dimen.notification_small_icon_size_as_large;
        r9 = r11.getDimensionPixelSize(r9);
        r0 = createIconWithBackground(r0, r5, r8, r9, r10);
        r5 = android.support.v7.appcompat.R.id.icon;
        r12.setImageViewBitmap(r5, r0);
        goto L_0x00e1;
    L_0x00d7:
        r8 = android.support.v7.appcompat.R.id.icon;
        r9 = -1;
        r0 = createColoredBitmap(r0, r5, r9);
        r12.setImageViewBitmap(r8, r0);
    L_0x00e1:
        if (r1 == 0) goto L_0x00e8;
    L_0x00e3:
        r0 = android.support.v7.appcompat.R.id.title;
        r12.setTextViewText(r0, r1);
    L_0x00e8:
        if (r2 == 0) goto L_0x00f1;
    L_0x00ea:
        r0 = android.support.v7.appcompat.R.id.text;
        r12.setTextViewText(r0, r2);
        r14 = 1;
        goto L_0x00f2;
    L_0x00f1:
        r14 = 0;
    L_0x00f2:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x00fc;
    L_0x00f8:
        if (r6 == 0) goto L_0x00fc;
    L_0x00fa:
        r0 = 1;
        goto L_0x00fd;
    L_0x00fc:
        r0 = 0;
    L_0x00fd:
        if (r3 == 0) goto L_0x010d;
    L_0x00ff:
        r0 = android.support.v7.appcompat.R.id.info;
        r12.setTextViewText(r0, r3);
        r0 = android.support.v7.appcompat.R.id.info;
        r1 = 0;
        r12.setViewVisibility(r0, r1);
    L_0x010a:
        r6 = 1;
        r14 = 1;
        goto L_0x0141;
    L_0x010d:
        if (r4 <= 0) goto L_0x0138;
    L_0x010f:
        r0 = android.support.v7.appcompat.R.integer.status_bar_notification_info_maxnum;
        r0 = r11.getInteger(r0);
        if (r4 <= r0) goto L_0x0123;
    L_0x0117:
        r0 = android.support.v7.appcompat.R.id.info;
        r1 = android.support.v7.appcompat.R.string.status_bar_notification_info_overflow;
        r1 = r11.getString(r1);
        r12.setTextViewText(r0, r1);
        goto L_0x0131;
    L_0x0123:
        r0 = java.text.NumberFormat.getIntegerInstance();
        r1 = android.support.v7.appcompat.R.id.info;
        r3 = (long) r4;
        r0 = r0.format(r3);
        r12.setTextViewText(r1, r0);
    L_0x0131:
        r0 = android.support.v7.appcompat.R.id.info;
        r1 = 0;
        r12.setViewVisibility(r0, r1);
        goto L_0x010a;
    L_0x0138:
        r1 = android.support.v7.appcompat.R.id.info;
        r3 = 8;
        r12.setViewVisibility(r1, r3);
        r6 = r14;
        r14 = r0;
    L_0x0141:
        if (r7 == 0) goto L_0x0167;
    L_0x0143:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x0167;
    L_0x0149:
        r0 = android.support.v7.appcompat.R.id.text;
        r12.setTextViewText(r0, r7);
        if (r2 == 0) goto L_0x015f;
    L_0x0150:
        r0 = android.support.v7.appcompat.R.id.text2;
        r12.setTextViewText(r0, r2);
        r0 = android.support.v7.appcompat.R.id.text2;
        r1 = 0;
        r12.setViewVisibility(r0, r1);
        r0 = 1;
        r8 = 8;
        goto L_0x016a;
    L_0x015f:
        r0 = android.support.v7.appcompat.R.id.text2;
        r8 = 8;
        r12.setViewVisibility(r0, r8);
        goto L_0x0169;
    L_0x0167:
        r8 = 8;
    L_0x0169:
        r0 = 0;
    L_0x016a:
        if (r0 == 0) goto L_0x018b;
    L_0x016c:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x018b;
    L_0x0172:
        if (r31 == 0) goto L_0x0181;
    L_0x0174:
        r0 = android.support.v7.appcompat.R.dimen.notification_subtext_size;
        r0 = r11.getDimensionPixelSize(r0);
        r0 = (float) r0;
        r1 = android.support.v7.appcompat.R.id.text;
        r2 = 0;
        r12.setTextViewTextSize(r1, r2, r0);
    L_0x0181:
        r1 = android.support.v7.appcompat.R.id.line1;
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0 = r12;
        r0.setViewPadding(r1, r2, r3, r4, r5);
    L_0x018b:
        r0 = 0;
        r2 = r26;
        r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r4 == 0) goto L_0x01cc;
    L_0x0193:
        if (r25 == 0) goto L_0x01bd;
    L_0x0195:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x01bd;
    L_0x019b:
        r0 = android.support.v7.appcompat.R.id.chronometer;
        r1 = 0;
        r12.setViewVisibility(r0, r1);
        r0 = android.support.v7.appcompat.R.id.chronometer;
        r1 = "setBase";
        r4 = android.os.SystemClock.elapsedRealtime();
        r9 = java.lang.System.currentTimeMillis();
        r13 = r4 - r9;
        r4 = r2 + r13;
        r12.setLong(r0, r1, r4);
        r0 = android.support.v7.appcompat.R.id.chronometer;
        r1 = "setStarted";
        r14 = 1;
        r12.setBoolean(r0, r1, r14);
        goto L_0x01cc;
    L_0x01bd:
        r14 = 1;
        r0 = android.support.v7.appcompat.R.id.time;
        r15 = 0;
        r12.setViewVisibility(r0, r15);
        r0 = android.support.v7.appcompat.R.id.time;
        r1 = "setTime";
        r12.setLong(r0, r1, r2);
        goto L_0x01cd;
    L_0x01cc:
        r15 = 0;
    L_0x01cd:
        r0 = android.support.v7.appcompat.R.id.right_side;
        if (r14 == 0) goto L_0x01d3;
    L_0x01d1:
        r1 = r15;
        goto L_0x01d4;
    L_0x01d3:
        r1 = r8;
    L_0x01d4:
        r12.setViewVisibility(r0, r1);
        r0 = android.support.v7.appcompat.R.id.line3;
        if (r6 == 0) goto L_0x01dc;
    L_0x01db:
        goto L_0x01dd;
    L_0x01dc:
        r15 = r8;
    L_0x01dd:
        r12.setViewVisibility(r0, r15);
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.NotificationCompatImplBase.applyStandardTemplate(android.content.Context, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, int, android.graphics.Bitmap, java.lang.CharSequence, boolean, long, int, int, int, boolean):android.widget.RemoteViews");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    public static android.widget.RemoteViews applyStandardTemplateWithActions(android.content.Context r0, java.lang.CharSequence r1, java.lang.CharSequence r2, java.lang.CharSequence r3, int r4, int r5, android.graphics.Bitmap r6, java.lang.CharSequence r7, boolean r8, long r9, int r11, int r12, int r13, boolean r14, java.util.ArrayList<android.support.v4.app.NotificationCompat.Action> r15) {
        /*
        r1 = applyStandardTemplate(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14);
        r2 = android.support.v7.appcompat.R.id.actions;
        r1.removeAllViews(r2);
        r2 = 0;
        if (r15 == 0) goto L_0x002d;
    L_0x000c:
        r3 = r15.size();
        if (r3 <= 0) goto L_0x002d;
    L_0x0012:
        r4 = 3;
        if (r3 <= r4) goto L_0x0016;
    L_0x0015:
        r3 = r4;
    L_0x0016:
        r4 = r2;
    L_0x0017:
        if (r4 >= r3) goto L_0x002b;
    L_0x0019:
        r5 = r15.get(r4);
        r5 = (android.support.v4.app.NotificationCompat.Action) r5;
        r5 = generateActionButton(r0, r5);
        r6 = android.support.v7.appcompat.R.id.actions;
        r1.addView(r6, r5);
        r4 = r4 + 1;
        goto L_0x0017;
    L_0x002b:
        r0 = 1;
        goto L_0x002e;
    L_0x002d:
        r0 = r2;
    L_0x002e:
        if (r0 == 0) goto L_0x0031;
    L_0x0030:
        goto L_0x0033;
    L_0x0031:
        r2 = 8;
    L_0x0033:
        r0 = android.support.v7.appcompat.R.id.actions;
        r1.setViewVisibility(r0, r2);
        r0 = android.support.v7.appcompat.R.id.action_divider;
        r1.setViewVisibility(r0, r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.NotificationCompatImplBase.applyStandardTemplateWithActions(android.content.Context, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, int, android.graphics.Bitmap, java.lang.CharSequence, boolean, long, int, int, int, boolean, java.util.ArrayList):android.widget.RemoteViews");
    }

    public static void buildIntoRemoteViews(Context context, RemoteViews remoteViews, RemoteViews remoteViews2) {
        hideNormalContent(remoteViews);
        remoteViews.removeAllViews(R.id.notification_main_column);
        remoteViews.addView(R.id.notification_main_column, remoteViews2.clone());
        remoteViews.setViewVisibility(R.id.notification_main_column, 0);
        if (VERSION.SDK_INT >= 21) {
            remoteViews.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(context), 0, 0);
        }
    }

    public static int calculateTopPadding(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.notification_top_pad);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
        float constrain = (constrain(context.getResources().getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
        return Math.round(((1.0f - constrain) * ((float) dimensionPixelSize)) + (constrain * ((float) dimensionPixelSize2)));
    }

    public static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private static Bitmap createColoredBitmap(Context context, int i, int i2) {
        return createColoredBitmap(context, i, i2, 0);
    }

    private static Bitmap createColoredBitmap(Context context, int i, int i2, int i3) {
        Drawable drawable = context.getResources().getDrawable(i);
        i = i3 == 0 ? drawable.getIntrinsicWidth() : i3;
        if (i3 == 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i3, Config.ARGB_8888);
        drawable.setBounds(0, 0, i, i3);
        if (i2 != 0) {
            drawable.mutate().setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_IN));
        }
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap createIconWithBackground(Context context, int i, int i2, int i3, int i4) {
        int i5 = R.drawable.notification_icon_background;
        if (i4 == 0) {
            i4 = 0;
        }
        Bitmap createColoredBitmap = createColoredBitmap(context, i5, i4, i2);
        Canvas canvas = new Canvas(createColoredBitmap);
        Drawable mutate = context.getResources().getDrawable(i).mutate();
        mutate.setFilterBitmap(true);
        i2 = (i2 - i3) / 2;
        i3 += i2;
        mutate.setBounds(i2, i2, i3, i3);
        mutate.setColorFilter(new PorterDuffColorFilter(-1, Mode.SRC_ATOP));
        mutate.draw(canvas);
        return createColoredBitmap;
    }

    private static RemoteViews generateActionButton(Context context, Action action) {
        Object obj = action.actionIntent == null ? 1 : null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), obj != null ? getActionTombstoneLayoutResource() : getActionLayoutResource());
        remoteViews.setImageViewBitmap(R.id.action_image, createColoredBitmap(context, action.getIcon(), context.getResources().getColor(R.color.notification_action_color_filter)));
        remoteViews.setTextViewText(R.id.action_text, action.title);
        if (obj == null) {
            remoteViews.setOnClickPendingIntent(R.id.action_container, action.actionIntent);
        }
        if (VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(R.id.action_container, action.title);
        }
        return remoteViews;
    }

    @TargetApi(11)
    @RequiresApi(11)
    private static <T extends NotificationCompatBase.Action> RemoteViews generateContentViewMedia(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent, boolean z3) {
        int[] iArr2 = iArr;
        RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, i, 0, bitmap, charSequence4, z, j, i2, 0, z3 ? R.layout.notification_template_media_custom : R.layout.notification_template_media, true);
        int size = list.size();
        int min = iArr2 == null ? 0 : Math.min(iArr2.length, 3);
        applyStandardTemplate.removeAllViews(R.id.media_actions);
        if (min > 0) {
            for (int i3 = 0; i3 < min; i3++) {
                if (i3 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i3), Integer.valueOf(size - 1)}));
                }
                applyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton(context, (NotificationCompatBase.Action) list.get(iArr2[i3])));
            }
        }
        Context context2 = context;
        if (z2) {
            applyStandardTemplate.setViewVisibility(R.id.end_padder, 8);
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 0);
            applyStandardTemplate.setOnClickPendingIntent(R.id.cancel_action, pendingIntent);
            applyStandardTemplate.setInt(R.id.cancel_action, "setAlpha", context.getResources().getInteger(R.integer.cancel_button_image_alpha));
        } else {
            applyStandardTemplate.setViewVisibility(R.id.end_padder, 0);
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    @TargetApi(11)
    @RequiresApi(11)
    private static RemoteViews generateMediaActionButton(Context context, NotificationCompatBase.Action action) {
        Object obj = action.getActionIntent() == null ? 1 : null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_media_action);
        remoteViews.setImageViewResource(R.id.action0, action.getIcon());
        if (obj == null) {
            remoteViews.setOnClickPendingIntent(R.id.action0, action.getActionIntent());
        }
        if (VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(R.id.action0, action.getTitle());
        }
        return remoteViews;
    }

    @TargetApi(11)
    @RequiresApi(11)
    public static <T extends NotificationCompatBase.Action> RemoteViews generateMediaBigView(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, int i3, List<T> list, boolean z2, PendingIntent pendingIntent, boolean z3) {
        int min = Math.min(list.size(), 5);
        RemoteViews applyStandardTemplate = applyStandardTemplate(context, charSequence, charSequence2, charSequence3, i, 0, bitmap, charSequence4, z, j, i2, i3, getBigMediaLayoutResource(z3, min), false);
        applyStandardTemplate.removeAllViews(R.id.media_actions);
        if (min > 0) {
            for (int i4 = 0; i4 < min; i4++) {
                applyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton(context, (NotificationCompatBase.Action) list.get(i4)));
            }
        }
        Context context2 = context;
        if (z2) {
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 0);
            applyStandardTemplate.setInt(R.id.cancel_action, "setAlpha", context.getResources().getInteger(R.integer.cancel_button_image_alpha));
            applyStandardTemplate.setOnClickPendingIntent(R.id.cancel_action, pendingIntent);
        } else {
            applyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
        }
        return applyStandardTemplate;
    }

    private static int getActionLayoutResource() {
        return R.layout.notification_action;
    }

    private static int getActionTombstoneLayoutResource() {
        return R.layout.notification_action_tombstone;
    }

    @TargetApi(11)
    @RequiresApi(11)
    private static int getBigMediaLayoutResource(boolean z, int i) {
        if (i <= 3) {
            return z ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_narrow;
        }
        return z ? R.layout.notification_template_big_media_custom : R.layout.notification_template_big_media;
    }

    private static void hideNormalContent(RemoteViews remoteViews) {
        remoteViews.setViewVisibility(R.id.title, 8);
        remoteViews.setViewVisibility(R.id.text2, 8);
        remoteViews.setViewVisibility(R.id.text, 8);
    }

    @TargetApi(11)
    @RequiresApi(11)
    public static <T extends NotificationCompatBase.Action> RemoteViews overrideContentViewMedia(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent, boolean z3) {
        RemoteViews generateContentViewMedia = generateContentViewMedia(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, i2, list, iArr, z2, pendingIntent, z3);
        notificationBuilderWithBuilderAccessor.getBuilder().setContent(generateContentViewMedia);
        if (z2) {
            notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
        }
        return generateContentViewMedia;
    }

    @TargetApi(16)
    @RequiresApi(16)
    public static <T extends NotificationCompatBase.Action> void overrideMediaBigContentView(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, int i3, List<T> list, boolean z2, PendingIntent pendingIntent, boolean z3) {
        Notification notification2 = notification;
        notification2.bigContentView = generateMediaBigView(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, i2, i3, list, z2, pendingIntent, z3);
        if (z2) {
            notification2.flags |= 2;
        }
    }
}
