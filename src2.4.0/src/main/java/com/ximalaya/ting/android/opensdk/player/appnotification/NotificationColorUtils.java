package com.ximalaya.ting.android.opensdk.player.appnotification;

import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RemoteViews;
import android.widget.TextView;
import java.util.concurrent.CountDownLatch;

public class NotificationColorUtils {
    private static final double COLOR_THRESHOLD = 180.0d;
    public static int COLOR_UNDEF = 987654321;
    public static int EVENTCONTENT_COLOR = Color.parseColor("#b3ffffff");
    public static int EVENTCONTENT_TITLE_COLOR = -1;
    public static String NOTIFICATION_CONTENT = "ximalaya_content";
    public static int NOTIFICATION_LINE2_COLOR = Color.parseColor("#8a000000");
    public static String NOTIFICATION_TITLE = "ximalaya_title";
    public static int NOTIFICATION_TITLE_COLOR = Color.parseColor("#de000000");
    private static TextView contentView;
    public static boolean isTargerSDKVersion24More;
    private static NotificationColorModel mNotificationColorModel;
    private static TextView titleView;

    static class NotificationColorModel {
        private int contentColor = NotificationColorUtils.COLOR_UNDEF;
        private boolean isDarkNotificationBg = true;
        private int titleColor = NotificationColorUtils.COLOR_UNDEF;

        NotificationColorModel() {
        }

        public int getContentColor() {
            return this.contentColor;
        }

        public int getTitleColor() {
            return this.titleColor;
        }

        public boolean isDarkNotificationBg() {
            return this.isDarkNotificationBg;
        }

        public void setContentColor(int i) {
            this.contentColor = i;
        }

        public void setDarkNotificationBg(boolean z) {
            this.isDarkNotificationBg = z;
        }

        public void setTitleColor(int i) {
            this.titleColor = i;
        }
    }

    private static int getNotificationColor(Context context) {
        if (VERSION.SDK_INT >= 24 && isTargerSDKVersion24More) {
            return 0;
        }
        if (VERSION.SDK_INT <= 15) {
            return COLOR_UNDEF;
        }
        int identifier;
        try {
            identifier = context.getResources().getIdentifier(XmNotificationCreater.IMG_NOTIFYICON_DRAWABLE, "drawable", context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            identifier = 0;
        }
        Builder contentText = new Builder(context).setSmallIcon(identifier).setContentTitle(NOTIFICATION_TITLE).setContentText(NOTIFICATION_CONTENT);
        Notification build = contentText.build();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        getTextView(VERSION.SDK_INT >= 24 ? (ViewGroup) contentText.createContentView().apply(context, linearLayout) : (ViewGroup) build.contentView.apply(context, linearLayout), NOTIFICATION_TITLE, NOTIFICATION_CONTENT);
        if (titleView == null) {
            return COLOR_UNDEF;
        }
        int currentTextColor = titleView.getCurrentTextColor();
        mNotificationColorModel.setTitleColor(currentTextColor);
        if (contentView != null) {
            mNotificationColorModel.setContentColor(contentView.getCurrentTextColor());
        }
        return currentTextColor;
    }

    private static TextView getTextView(ViewGroup viewGroup, String str, String str2) {
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (textView.getText().equals(NOTIFICATION_TITLE)) {
                    titleView = textView;
                }
                if (textView.getText().equals(NOTIFICATION_CONTENT)) {
                    contentView = textView;
                }
            } else if (childAt instanceof ViewGroup) {
                getTextView((ViewGroup) childAt, str, str2);
            }
        }
        return null;
    }

    public static synchronized boolean isDarkNotificationBar(final Context context) {
        boolean isDarkNotificationBg;
        synchronized (NotificationColorUtils.class) {
            if (mNotificationColorModel == null) {
                mNotificationColorModel = new NotificationColorModel();
                int i = Looper.myLooper() == Looper.getMainLooper() ? 1 : 0;
                CountDownLatch countDownLatch = null;
                if (i == 0) {
                    countDownLatch = new CountDownLatch(1);
                }
                AnonymousClass1 anonymousClass1 = new Runnable() {
                    public void run() {
                        try {
                            int access$000 = NotificationColorUtils.getNotificationColor(context);
                            if (access$000 == NotificationColorUtils.COLOR_UNDEF) {
                                NotificationColorUtils.mNotificationColorModel.setTitleColor(NotificationColorUtils.COLOR_UNDEF);
                                NotificationColorUtils.mNotificationColorModel.setContentColor(NotificationColorUtils.COLOR_UNDEF);
                                NotificationColorUtils.mNotificationColorModel.setDarkNotificationBg(true);
                            } else {
                                NotificationColorUtils.mNotificationColorModel.setDarkNotificationBg(NotificationColorUtils.isTextColorSimilar(-16777216, access$000) ^ 1);
                            }
                        } catch (Exception unused) {
                            NotificationColorUtils.mNotificationColorModel.setTitleColor(NotificationColorUtils.COLOR_UNDEF);
                            NotificationColorUtils.mNotificationColorModel.setContentColor(NotificationColorUtils.COLOR_UNDEF);
                            NotificationColorUtils.mNotificationColorModel.setDarkNotificationBg(true);
                        }
                        if (NotificationColorUtils.mNotificationColorModel.getTitleColor() == NotificationColorUtils.COLOR_UNDEF && VERSION.SDK_INT >= 21) {
                            if (NotificationColorUtils.mNotificationColorModel.isDarkNotificationBg()) {
                                NotificationColorUtils.mNotificationColorModel.setTitleColor(NotificationColorUtils.EVENTCONTENT_TITLE_COLOR);
                            } else {
                                NotificationColorUtils.mNotificationColorModel.setTitleColor(NotificationColorUtils.NOTIFICATION_TITLE_COLOR);
                            }
                        }
                        if (NotificationColorUtils.mNotificationColorModel.getContentColor() == NotificationColorUtils.COLOR_UNDEF && VERSION.SDK_INT >= 21) {
                            if (NotificationColorUtils.mNotificationColorModel.isDarkNotificationBg()) {
                                NotificationColorUtils.mNotificationColorModel.setContentColor(NotificationColorUtils.EVENTCONTENT_COLOR);
                            } else {
                                NotificationColorUtils.mNotificationColorModel.setContentColor(NotificationColorUtils.NOTIFICATION_LINE2_COLOR);
                            }
                        }
                        if (countDownLatch != null) {
                            countDownLatch.countDown();
                        }
                    }
                };
                if (i != 0) {
                    anonymousClass1.run();
                } else {
                    new Handler(Looper.getMainLooper()).post(anonymousClass1);
                    if (countDownLatch != null) {
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            isDarkNotificationBg = mNotificationColorModel.isDarkNotificationBg();
        }
        return isDarkNotificationBg;
    }

    private static boolean isTextColorSimilar(int i, int i2) {
        i |= -16777216;
        i2 |= -16777216;
        int red = Color.red(i) - Color.red(i2);
        int green = Color.green(i) - Color.green(i2);
        i = Color.blue(i) - Color.blue(i2);
        return Math.sqrt((double) (((red * red) + (green * green)) + (i * i))) < COLOR_THRESHOLD;
    }

    public static void setContentTextColor(Context context, RemoteViews remoteViews, int i) {
        if (mNotificationColorModel == null) {
            isDarkNotificationBar(context);
        }
        if (mNotificationColorModel.getContentColor() == COLOR_UNDEF && VERSION.SDK_INT >= 21) {
            if (mNotificationColorModel.isDarkNotificationBg()) {
                mNotificationColorModel.setContentColor(EVENTCONTENT_COLOR);
            } else {
                mNotificationColorModel.setContentColor(NOTIFICATION_LINE2_COLOR);
            }
        }
        remoteViews.setTextColor(i, mNotificationColorModel.getContentColor());
    }

    public static void setTitleTextColor(Context context, RemoteViews remoteViews, int i) {
        if (mNotificationColorModel == null) {
            isDarkNotificationBar(context);
        }
        if (mNotificationColorModel.getTitleColor() == COLOR_UNDEF && VERSION.SDK_INT >= 21) {
            if (mNotificationColorModel.isDarkNotificationBg()) {
                mNotificationColorModel.setTitleColor(EVENTCONTENT_TITLE_COLOR);
            } else {
                mNotificationColorModel.setTitleColor(NOTIFICATION_TITLE_COLOR);
            }
        }
        remoteViews.setTextColor(i, mNotificationColorModel.getTitleColor());
    }
}
