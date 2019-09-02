package com.ximalaya.ting.android.opensdk.player.appnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.receive.PlayerReceiver;
import com.ximalaya.ting.android.opensdk.util.FileUtilBase;
import com.ximalaya.ting.android.opensdk.util.FileUtilBase.IBitmapDownOkCallBack;
import com.ximalaya.ting.android.opensdk.util.Logger;

public class XmNotificationCreater {
    public static final String ACTION_CONTROL_CLOSE = "com.ximalaya.ting.android.ACTION_CLOSE";
    public static final String ACTION_CONTROL_CLOSE_MAIN = "com.ximalaya.ting.android.ACTION_CLOSE_MAIN";
    public static final String ACTION_CONTROL_PLAY_NEXT = "com.ximalaya.ting.android.ACTION_CONTROL_PLAY_NEXT";
    public static final String ACTION_CONTROL_PLAY_NEXT_MAIN = "com.ximalaya.ting.android.ACTION_CONTROL_PLAY_NEXT_MAIN";
    public static final String ACTION_CONTROL_PLAY_PRE = "com.ximalaya.ting.android.ACTION_CONTROL_PLAY_PRE";
    public static final String ACTION_CONTROL_PLAY_PRE_MAIN = "com.ximalaya.ting.android.ACTION_CONTROL_PLAY_PRE_MAIN";
    public static final String ACTION_CONTROL_RELEASE_SERVICE = "com.ximalaya.ting.android.ACTION_CONTROL_RELEASE_SERVICE";
    public static final String ACTION_CONTROL_START_PAUSE = "com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE";
    public static final String ACTION_CONTROL_START_PAUSE_LIVE = "com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE_LIVE";
    public static final String ACTION_CONTROL_START_PAUSE_MAIN = "com.ximalaya.ting.android.ACTION_CONTROL_START_PAUSE_MAIN";
    private static final String APK_CHANNEL_FOR_OPPO = "and-d8";
    public static final String CHANNEL_ID = "com.ximalaya.android.sdk";
    public static final String IMG_NOTIFYCLOSE = "img_notifyClose";
    public static final String IMG_NOTIFYICON = "img_notifyIcon";
    public static final String IMG_NOTIFYICON_DRAWABLE = "notification_default";
    public static final String IMG_NOTIFYICON_DRAWABLE_L = "notification_icon";
    public static final String IMG_NOTIFYICON_DRAWABLE_S = "ting";
    public static final String IMG_NOTIFYNEXT = "img_notifyNext";
    public static final String IMG_NOTIFYNEXT_DRAWABLE_DISABLE = "notify_btn_next_pressed";
    public static final String IMG_NOTIFYNEXT_DRAWABLE_DISABLE_LIGHT = "notify_btn_next_pressed";
    public static final String IMG_NOTIFYNEXT_DRAWABLE_NORMAL = "notify_btn_dark_next_normal_xml";
    public static final String IMG_NOTIFYNEXT_DRAWABLE_NORMAL_LIGHT = "notify_btn_light_next_normal_xml";
    public static final String IMG_NOTIFYPLAYORPAUSE = "img_notifyPlayOrPause";
    public static final String IMG_NOTIFYPLAYORPAUSE_DRAWABLE_PAUSE = "notify_btn_dark_play_normal_xml";
    public static final String IMG_NOTIFYPLAYORPAUSE_DRAWABLE_PAUSE_LIGHT = "notify_btn_light_play_normal_xml";
    public static final String IMG_NOTIFYPLAYORPAUSE_DRAWABLE_PLAY = "notify_btn_dark_pause_normal_xml";
    public static final String IMG_NOTIFYPLAYORPAUSE_DRAWABLE_PLAY_LIGHT = "notify_btn_light_pause_normal_xml";
    public static final String IMG_NOTIFYPLAYORPAUSE_DRAWABLE_SMALL_PAUSE = "notify_btn_dark_play2_normal_xml";
    public static final String IMG_NOTIFYPLAYORPAUSE_DRAWABLE_SMALL_PAUSE_LIGHT = "notify_btn_light_play2_normal_xml";
    public static final String IMG_NOTIFYPLAYORPAUSE_DRAWABLE_SMALL_PLAY = "notify_btn_dark_pause2_normal_xml";
    public static final String IMG_NOTIFYPLAYORPAUSE_DRAWABLE_SMALL_PLAY_LIGHT = "notify_btn_light_pause2_normal_xml";
    public static final String IMG_NOTIFYPRE = "img_notifyPre";
    public static final String IMG_NOTIFYPRE_DRAWABLE_DISABLE = "notify_btn_prev_pressed";
    public static final String IMG_NOTIFYPRE_DRAWABLE_DISABLE_LIGHT = "notify_btn_prev_pressed";
    public static final String IMG_NOTIFYPRE_DRAWABLE_NORMAL = "notify_btn_dark_prev_normal_xml";
    public static final String IMG_NOTIFYPRE_DRAWABLE_NORMAL_LIGHT = "notify_btn_light_prev_normal_xml";
    public static final String NOTIFICATION_EXTRY_KEY = "notification_entry";
    public static final String NOTIFICATION__EXTYR_DATA = "com.ximalaya.ting.android.EXTRY_NOTIFICATION_TO_MAINACTIVITY";
    public static final String REMOTEVIEW_LAYOUT = "view_notify_play";
    public static final String REMOTEVIEW_LAYOUT_BIG = "view_notify_play_big";
    public static final String REMOTEVIEW_LAYOUT_BIG_FOR_OPPO = "reflect_view_notify_play_big_for_oppo";
    public static final String REMOTEVIEW_LAYOUT_FOR_OPPO = "reflect_view_notify_play_for_oppo";
    public static final String TXT_NOTIFYMUSICNAME = "txt_notifyMusicName";
    public static final String TXT_NOTIFYNICKNAME = "txt_notifyNickName";
    public static final String VIEW_NOTIFY_DARK_PLAY = "view_notify_dark_play";
    public static final String VIEW_NOTIFY_DARK_PLAY_BIG = "view_notify_dark_play_big";
    public static final String VIEW_NOTIFY_DARK_PLAY_BIG_FOR_OPPO = "reflect_view_notify_dark_play_big_for_oppo";
    public static final String VIEW_NOTIFY_DARK_PLAY_FOR_OPPO = "reflect_view_notify_dark_play_for_oppo";
    private static XmNotificationCreater instanse;
    @Nullable
    public static String mApkChannel;
    private RemoteViews bigRemoteView;
    private PendingIntent closeIntent;
    private RemoteViews mBigRemoteView;
    private Context mContext;
    private RemoteViews mRemoteView;
    private RemoteViewDetailModel mRemoteViewDetailModel = new RemoteViewDetailModel(this, null);
    private PendingIntent nextIntent;
    private String packageName = "";
    private PendingIntent preIntent;
    private RemoteViews remoteView;
    private Resources res;
    private PendingIntent startOrPauseIntent;
    private int version = VERSION.SDK_INT;

    private class RemoteViewDetailModel {
        boolean isDark;
        boolean isDisableNextBtn;
        boolean isDisablePreBtn;
        boolean isPause;
        String nickName;
        Bitmap trackCoverBitmap;
        String trackDetail;

        private RemoteViewDetailModel() {
        }

        /* synthetic */ RemoteViewDetailModel(XmNotificationCreater xmNotificationCreater, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private XmNotificationCreater(Context context) {
        this.mContext = context;
        this.res = context.getResources();
        this.packageName = this.mContext.getPackageName();
    }

    private void chanageTextColor(boolean z, RemoteViews remoteViews, RemoteViews remoteViews2) {
        if (remoteViews != null) {
            NotificationColorUtils.setTitleTextColor(this.mContext, remoteViews, getResourceId(TXT_NOTIFYMUSICNAME, "id"));
            NotificationColorUtils.setContentTextColor(this.mContext, remoteViews, getResourceId(TXT_NOTIFYNICKNAME, "id"));
        }
        NotificationColorUtils.setTitleTextColor(this.mContext, remoteViews2, getResourceId(TXT_NOTIFYMUSICNAME, "id"));
        NotificationColorUtils.setContentTextColor(this.mContext, remoteViews2, getResourceId(TXT_NOTIFYNICKNAME, "id"));
    }

    private boolean checkAndroidVersion() {
        return this.version >= 16;
    }

    private RemoteViews createBigRemoteViews(Context context, boolean z) {
        if (!checkAndroidVersion()) {
            return null;
        }
        RemoteViews remoteViews = APK_CHANNEL_FOR_OPPO.equals(mApkChannel) ? z ? new RemoteViews(context.getPackageName(), getResourceId(VIEW_NOTIFY_DARK_PLAY_BIG_FOR_OPPO, "layout")) : new RemoteViews(context.getPackageName(), getResourceId(REMOTEVIEW_LAYOUT_BIG_FOR_OPPO, "layout")) : z ? new RemoteViews(context.getPackageName(), getResourceId(VIEW_NOTIFY_DARK_PLAY_BIG, "layout")) : new RemoteViews(context.getPackageName(), getResourceId(REMOTEVIEW_LAYOUT_BIG, "layout"));
        if (this.preIntent == null) {
            setPrePendingIntent(null);
        }
        if (this.preIntent != null) {
            remoteViews.setOnClickPendingIntent(getResourceId(IMG_NOTIFYPRE, "id"), this.preIntent);
        }
        if (this.closeIntent == null) {
            setClosePendingIntent(null);
        }
        if (this.closeIntent != null) {
            remoteViews.setOnClickPendingIntent(getResourceId(IMG_NOTIFYCLOSE, "id"), this.closeIntent);
        }
        if (this.startOrPauseIntent == null) {
            setStartOrPausePendingIntent(null);
        }
        if (this.startOrPauseIntent != null) {
            remoteViews.setOnClickPendingIntent(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), this.startOrPauseIntent);
        }
        if (this.nextIntent == null) {
            setNextPendingIntent(null);
        }
        if (this.nextIntent != null) {
            remoteViews.setOnClickPendingIntent(getResourceId(IMG_NOTIFYNEXT, "id"), this.nextIntent);
        }
        return remoteViews;
    }

    private RemoteViews createBigRemoteViewsForLive(Context context, PendingIntent pendingIntent, boolean z) {
        if (!checkAndroidVersion()) {
            return null;
        }
        RemoteViews remoteViews = z ? new RemoteViews(context.getPackageName(), getResourceId(VIEW_NOTIFY_DARK_PLAY_BIG, "layout")) : new RemoteViews(context.getPackageName(), getResourceId(REMOTEVIEW_LAYOUT_BIG, "layout"));
        if (pendingIntent != null) {
            remoteViews.setOnClickPendingIntent(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), pendingIntent);
        }
        return remoteViews;
    }

    private RemoteViews createRemoteViews(Context context, boolean z) {
        RemoteViews remoteViews = APK_CHANNEL_FOR_OPPO.equals(mApkChannel) ? z ? new RemoteViews(context.getPackageName(), getResourceId(VIEW_NOTIFY_DARK_PLAY_FOR_OPPO, "layout")) : new RemoteViews(context.getPackageName(), getResourceId(REMOTEVIEW_LAYOUT_FOR_OPPO, "layout")) : z ? new RemoteViews(context.getPackageName(), getResourceId(VIEW_NOTIFY_DARK_PLAY, "layout")) : new RemoteViews(context.getPackageName(), getResourceId(REMOTEVIEW_LAYOUT, "layout"));
        if (this.startOrPauseIntent == null) {
            setStartOrPausePendingIntent(null);
        }
        if (this.startOrPauseIntent != null) {
            remoteViews.setOnClickPendingIntent(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), this.startOrPauseIntent);
        }
        if (this.nextIntent == null) {
            setNextPendingIntent(null);
        }
        if (this.nextIntent != null) {
            remoteViews.setOnClickPendingIntent(getResourceId(IMG_NOTIFYNEXT, "id"), this.nextIntent);
        }
        if (this.closeIntent == null) {
            setClosePendingIntent(null);
        }
        if (this.closeIntent != null) {
            remoteViews.setOnClickPendingIntent(getResourceId(IMG_NOTIFYCLOSE, "id"), this.closeIntent);
        }
        return remoteViews;
    }

    private RemoteViews createRemoteViewsForLive(Context context, PendingIntent pendingIntent, boolean z) {
        RemoteViews remoteViews = z ? new RemoteViews(context.getPackageName(), getResourceId(VIEW_NOTIFY_DARK_PLAY, "layout")) : new RemoteViews(context.getPackageName(), getResourceId(REMOTEVIEW_LAYOUT, "layout"));
        if (pendingIntent != null) {
            remoteViews.setOnClickPendingIntent(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), pendingIntent);
        }
        return remoteViews;
    }

    private void disableNextBtn(boolean z, boolean z2) {
        if (checkAndroidVersion() && this.remoteView != null) {
            int resourceId = z ? z2 ? getResourceId("notify_btn_next_pressed", "drawable") : getResourceId("notify_btn_next_pressed", "drawable") : z2 ? getResourceId(IMG_NOTIFYNEXT_DRAWABLE_NORMAL_LIGHT, "drawable") : getResourceId(IMG_NOTIFYNEXT_DRAWABLE_NORMAL, "drawable");
            try {
                this.remoteView.setImageViewResource(getResourceId(IMG_NOTIFYNEXT, "id"), resourceId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (checkAndroidVersion() && this.bigRemoteView != null) {
            int resourceId2 = z ? z2 ? getResourceId("notify_btn_next_pressed", "drawable") : getResourceId("notify_btn_next_pressed", "drawable") : z2 ? getResourceId(IMG_NOTIFYNEXT_DRAWABLE_NORMAL_LIGHT, "drawable") : getResourceId(IMG_NOTIFYNEXT_DRAWABLE_NORMAL, "drawable");
            this.bigRemoteView.setImageViewResource(getResourceId(IMG_NOTIFYNEXT, "id"), resourceId2);
        }
    }

    private void disablePreBtn(boolean z, boolean z2) {
        if (checkAndroidVersion() && this.bigRemoteView != null) {
            int resourceId = z ? z2 ? getResourceId("notify_btn_prev_pressed", "drawable") : getResourceId("notify_btn_prev_pressed", "drawable") : z2 ? getResourceId(IMG_NOTIFYPRE_DRAWABLE_NORMAL_LIGHT, "drawable") : getResourceId(IMG_NOTIFYPRE_DRAWABLE_NORMAL, "drawable");
            try {
                this.bigRemoteView.setImageViewResource(getResourceId(IMG_NOTIFYPRE, "id"), resourceId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static XmNotificationCreater getInstanse(Context context) {
        if (instanse == null) {
            synchronized (XmNotificationCreater.class) {
                if (instanse == null) {
                    instanse = new XmNotificationCreater(context.getApplicationContext());
                }
            }
        }
        return instanse;
    }

    private int getResourceId(String str, String str2) {
        return this.res.getIdentifier(str, str2, this.mContext.getPackageName());
    }

    public static void release() {
        if (instanse != null) {
            instanse.mRemoteView = null;
            instanse.mBigRemoteView = null;
            instanse.remoteView = null;
            instanse.bigRemoteView = null;
            instanse = null;
        }
    }

    public static Builder setSmallIcon(Context context, Builder builder) {
        return builder.setSmallIcon(context.getResources().getIdentifier(VERSION.SDK_INT >= 21 ? IMG_NOTIFYICON_DRAWABLE_L : IMG_NOTIFYICON_DRAWABLE_S, "drawable", context.getPackageName()));
    }

    private void updateRemoteViewDetail(RemoteViewDetailModel remoteViewDetailModel, NotificationManager notificationManager, Notification notification, int i) {
        if (notificationManager != null && notification != null) {
            if (TextUtils.isEmpty(remoteViewDetailModel.nickName)) {
                remoteViewDetailModel.nickName = "喜马拉雅";
            }
            if (TextUtils.isEmpty(remoteViewDetailModel.trackDetail)) {
                remoteViewDetailModel.trackDetail = "随时随地 听我想听";
            }
            chanageTextColor(remoteViewDetailModel.isDark, this.bigRemoteView, this.remoteView);
            if (checkAndroidVersion() && this.bigRemoteView != null) {
                this.bigRemoteView.setTextViewText(getResourceId(TXT_NOTIFYMUSICNAME, "id"), remoteViewDetailModel.trackDetail);
                this.bigRemoteView.setTextViewText(getResourceId(TXT_NOTIFYNICKNAME, "id"), remoteViewDetailModel.nickName);
                if (remoteViewDetailModel.isDark) {
                    if (remoteViewDetailModel.isPause) {
                        this.bigRemoteView.setImageViewResource(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), getResourceId(IMG_NOTIFYPLAYORPAUSE_DRAWABLE_PAUSE_LIGHT, "drawable"));
                    } else {
                        this.bigRemoteView.setImageViewResource(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), getResourceId(IMG_NOTIFYPLAYORPAUSE_DRAWABLE_PLAY_LIGHT, "drawable"));
                    }
                } else if (remoteViewDetailModel.isPause) {
                    this.bigRemoteView.setImageViewResource(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), getResourceId(IMG_NOTIFYPLAYORPAUSE_DRAWABLE_PAUSE, "drawable"));
                } else {
                    this.bigRemoteView.setImageViewResource(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), getResourceId(IMG_NOTIFYPLAYORPAUSE_DRAWABLE_PLAY, "drawable"));
                }
            }
            this.remoteView.setTextViewText(getResourceId(TXT_NOTIFYMUSICNAME, "id"), remoteViewDetailModel.trackDetail);
            this.remoteView.setTextViewText(getResourceId(TXT_NOTIFYNICKNAME, "id"), remoteViewDetailModel.nickName);
            if (remoteViewDetailModel.isDark) {
                if (remoteViewDetailModel.isPause) {
                    this.remoteView.setImageViewResource(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), getResourceId(IMG_NOTIFYPLAYORPAUSE_DRAWABLE_SMALL_PAUSE_LIGHT, "drawable"));
                } else {
                    this.remoteView.setImageViewResource(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), getResourceId(IMG_NOTIFYPLAYORPAUSE_DRAWABLE_SMALL_PLAY_LIGHT, "drawable"));
                }
            } else if (remoteViewDetailModel.isPause) {
                this.remoteView.setImageViewResource(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), getResourceId(IMG_NOTIFYPLAYORPAUSE_DRAWABLE_SMALL_PAUSE, "drawable"));
            } else {
                this.remoteView.setImageViewResource(getResourceId(IMG_NOTIFYPLAYORPAUSE, "id"), getResourceId(IMG_NOTIFYPLAYORPAUSE_DRAWABLE_SMALL_PLAY, "drawable"));
            }
            disableNextBtn(remoteViewDetailModel.isDisableNextBtn, remoteViewDetailModel.isDark);
            disablePreBtn(remoteViewDetailModel.isDisablePreBtn, remoteViewDetailModel.isDark);
            if (remoteViewDetailModel.trackCoverBitmap == null || remoteViewDetailModel.trackCoverBitmap.isRecycled()) {
                if (this.remoteView != null) {
                    try {
                        this.remoteView.setInt(getResourceId(IMG_NOTIFYICON, "id"), "setImageResource", getResourceId(IMG_NOTIFYICON_DRAWABLE, "drawable"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (checkAndroidVersion() && this.bigRemoteView != null) {
                    try {
                        this.bigRemoteView.setInt(getResourceId(IMG_NOTIFYICON, "id"), "setImageResource", getResourceId(IMG_NOTIFYICON_DRAWABLE, "drawable"));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                if (this.remoteView != null) {
                    this.remoteView.setImageViewBitmap(getResourceId(IMG_NOTIFYICON, "id"), remoteViewDetailModel.trackCoverBitmap);
                }
                if (checkAndroidVersion() && this.bigRemoteView != null) {
                    this.bigRemoteView.setImageViewBitmap(getResourceId(IMG_NOTIFYICON, "id"), remoteViewDetailModel.trackCoverBitmap);
                }
            }
            try {
                notificationManager.notify(i, notification);
            } catch (Throwable unused) {
            }
        }
    }

    public <T> Notification createNotification(Context context, Class<T> cls) {
        boolean isDarkNotificationBar = NotificationColorUtils.isDarkNotificationBar(context);
        this.mBigRemoteView = createBigRemoteViews(context, isDarkNotificationBar);
        this.mRemoteView = createRemoteViews(context, isDarkNotificationBar);
        chanageTextColor(isDarkNotificationBar, this.mBigRemoteView, this.mRemoteView);
        Notification.Builder builder = VERSION.SDK_INT >= 26 ? new Notification.Builder(context, CHANNEL_ID) : new Notification.Builder(context);
        Intent intent = new Intent(context, cls);
        intent.putExtra(NOTIFICATION_EXTRY_KEY, NOTIFICATION__EXTYR_DATA);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 134217728)).setContentTitle("喜马拉雅").setContentText("随时随地 听我想听").setOngoing(true).setSmallIcon(getResourceId(VERSION.SDK_INT >= 21 ? IMG_NOTIFYICON_DRAWABLE_L : IMG_NOTIFYICON_DRAWABLE_S, "drawable"));
        if (VERSION.SDK_INT >= 16) {
            builder.setPriority(2);
        }
        if (VERSION.SDK_INT >= 24) {
            builder.setCustomContentView(this.mRemoteView);
            builder.setCustomBigContentView(this.mBigRemoteView);
        }
        Notification build = VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        if (VERSION.SDK_INT < 24) {
            build.contentView = this.mRemoteView;
            if (VERSION.SDK_INT >= 16) {
                build.bigContentView = this.mBigRemoteView;
            }
        }
        return build;
    }

    public <T> Notification initNotification(Context context, Class<T> cls) {
        setNextPendingIntent(null);
        setPrePendingIntent(null);
        setStartOrPausePendingIntent(null);
        setClosePendingIntent(null);
        return createNotification(context, cls);
    }

    public void setClosePendingIntent(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            String str = ACTION_CONTROL_CLOSE;
            if (this.packageName.equals("com.ximalaya.ting.android")) {
                str = ACTION_CONTROL_CLOSE_MAIN;
            }
            Intent intent = new Intent(str);
            intent.setClass(this.mContext, PlayerReceiver.class);
            this.closeIntent = PendingIntent.getBroadcast(this.mContext, 0, intent, 0);
            return;
        }
        this.closeIntent = pendingIntent;
    }

    public void setNextPendingIntent(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            String str = ACTION_CONTROL_PLAY_NEXT;
            if (this.packageName.equals("com.ximalaya.ting.android")) {
                str = ACTION_CONTROL_PLAY_NEXT_MAIN;
            }
            Intent intent = new Intent(str);
            intent.setClass(this.mContext, PlayerReceiver.class);
            this.nextIntent = PendingIntent.getBroadcast(this.mContext, 0, intent, 0);
            return;
        }
        this.nextIntent = pendingIntent;
    }

    public void setPrePendingIntent(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            String str = ACTION_CONTROL_PLAY_PRE;
            if (this.packageName.equals("com.ximalaya.ting.android")) {
                str = ACTION_CONTROL_PLAY_PRE_MAIN;
            }
            Intent intent = new Intent(str);
            intent.setClass(this.mContext, PlayerReceiver.class);
            this.preIntent = PendingIntent.getBroadcast(this.mContext, 0, intent, 0);
            return;
        }
        this.preIntent = pendingIntent;
    }

    public void setStartOrPausePendingIntent(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            String str = ACTION_CONTROL_START_PAUSE;
            if (this.packageName.equals("com.ximalaya.ting.android")) {
                str = ACTION_CONTROL_START_PAUSE_MAIN;
            }
            Intent intent = new Intent(str);
            intent.setClass(this.mContext, PlayerReceiver.class);
            this.startOrPauseIntent = PendingIntent.getBroadcast(this.mContext, 0, intent, 0);
            return;
        }
        this.startOrPauseIntent = pendingIntent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011a  */
    public void updateModelDetail(com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl r9, final android.app.NotificationManager r10, final android.app.Notification r11, final int r12, boolean r13) {
        /*
        r8 = this;
        if (r11 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r8.mContext;
        r0 = r8.createBigRemoteViews(r0, r13);
        r8.bigRemoteView = r0;
        r0 = r8.checkAndroidVersion();
        if (r0 == 0) goto L_0x001b;
    L_0x0011:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x001b;
    L_0x0017:
        r0 = r8.bigRemoteView;
        r11.bigContentView = r0;
    L_0x001b:
        r0 = r8.mContext;
        r0 = r8.createRemoteViews(r0, r13);
        r8.remoteView = r0;
        r0 = r8.remoteView;
        r11.contentView = r0;
        r0 = r9.getCurrentPlayableModel();
        r1 = 0;
        r2 = 0;
        r3 = 1;
        if (r0 == 0) goto L_0x012d;
    L_0x0030:
        r4 = r8.remoteView;
        if (r4 == 0) goto L_0x012d;
    L_0x0034:
        if (r10 == 0) goto L_0x012d;
    L_0x0036:
        r4 = r0;
        r4 = (com.ximalaya.ting.android.opensdk.model.track.Track) r4;
        r5 = r4.getTrackTitle();
        r6 = android.text.TextUtils.isEmpty(r5);
        if (r6 == 0) goto L_0x0045;
    L_0x0043:
        r5 = "";
    L_0x0045:
        r6 = "track";
        r7 = r0.getKind();
        r6 = r6.equals(r7);
        if (r6 != 0) goto L_0x008a;
    L_0x0051:
        r6 = "live_flv";
        r7 = r0.getKind();
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x005e;
    L_0x005d:
        goto L_0x008a;
    L_0x005e:
        r6 = "radio";
        r7 = r0.getKind();
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x006f;
    L_0x006a:
        r6 = r4.getTrackIntro();
        goto L_0x009a;
    L_0x006f:
        r6 = "schedule";
        r7 = r0.getKind();
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x0099;
    L_0x007b:
        r6 = r4.getAnnouncer();
        if (r6 == 0) goto L_0x0099;
    L_0x0081:
        r6 = r4.getAnnouncer();
        r6 = r6.getNickname();
        goto L_0x009a;
    L_0x008a:
        r6 = r4.getAnnouncer();
        if (r6 == 0) goto L_0x0099;
    L_0x0090:
        r6 = r4.getAnnouncer();
        r6 = r6.getNickname();
        goto L_0x009a;
    L_0x0099:
        r6 = r1;
    L_0x009a:
        r7 = android.text.TextUtils.isEmpty(r6);
        if (r7 == 0) goto L_0x00a2;
    L_0x00a0:
        r6 = "";
    L_0x00a2:
        r7 = r8.mRemoteViewDetailModel;
        r7.trackDetail = r5;
        r5 = r8.mRemoteViewDetailModel;
        r5.nickName = r6;
        r5 = r8.mRemoteViewDetailModel;
        r5.isDark = r13;
        r13 = r8.mRemoteViewDetailModel;
        r13.isPause = r2;
        r13 = r8.mRemoteViewDetailModel;
        r13.trackCoverBitmap = r1;
        if (r9 == 0) goto L_0x0107;
    L_0x00b8:
        r13 = r9.getPlayList();
        if (r13 == 0) goto L_0x0107;
    L_0x00be:
        r13 = r9.getPlayList();
        r13 = r13.size();
        if (r13 <= 0) goto L_0x0107;
    L_0x00c8:
        r13 = r9.getCurrIndex();
        r9 = r9.getPlayList();
        r9 = r9.size();
        r0 = r0 instanceof com.ximalaya.ting.android.opensdk.model.track.Track;
        if (r0 == 0) goto L_0x0107;
    L_0x00d8:
        if (r13 != 0) goto L_0x00ea;
    L_0x00da:
        r13 = r8.mRemoteViewDetailModel;
        r13.isDisablePreBtn = r3;
        if (r9 != r3) goto L_0x00e5;
    L_0x00e0:
        r9 = r8.mRemoteViewDetailModel;
        r9.isDisableNextBtn = r3;
        goto L_0x0107;
    L_0x00e5:
        r9 = r8.mRemoteViewDetailModel;
        r9.isDisableNextBtn = r2;
        goto L_0x0107;
    L_0x00ea:
        r0 = r9 + -1;
        if (r13 != r0) goto L_0x00ff;
    L_0x00ee:
        r13 = r8.mRemoteViewDetailModel;
        r13.isDisableNextBtn = r3;
        r13 = 2;
        if (r9 < r13) goto L_0x00fa;
    L_0x00f5:
        r9 = r8.mRemoteViewDetailModel;
        r9.isDisablePreBtn = r2;
        goto L_0x0107;
    L_0x00fa:
        r9 = r8.mRemoteViewDetailModel;
        r9.isDisablePreBtn = r3;
        goto L_0x0107;
    L_0x00ff:
        r9 = r8.mRemoteViewDetailModel;
        r9.isDisablePreBtn = r2;
        r9 = r8.mRemoteViewDetailModel;
        r9.isDisableNextBtn = r2;
    L_0x0107:
        r9 = r8.mRemoteViewDetailModel;
        r8.updateRemoteViewDetail(r9, r10, r11, r12);
        r9 = r8.mContext;
        r13 = 1115684864; // 0x42800000 float:64.0 double:5.51221563E-315;
        r9 = dp2px(r9, r13);
        r13 = r8.checkAndroidVersion();
        if (r13 == 0) goto L_0x0122;
    L_0x011a:
        r9 = r8.mContext;
        r13 = 1121714176; // 0x42dc0000 float:110.0 double:5.54200439E-315;
        r9 = dp2px(r9, r13);
    L_0x0122:
        r13 = r8.mContext;
        r0 = new com.ximalaya.ting.android.opensdk.player.appnotification.XmNotificationCreater$2;
        r0.<init>(r10, r11, r12);
        com.ximalaya.ting.android.opensdk.util.FileUtilBase.getBitmapByUrl(r13, r4, r9, r9, r0);
        goto L_0x0152;
    L_0x012d:
        r9 = r8.mRemoteViewDetailModel;
        r0 = "随时随地 听我想听";
        r9.trackDetail = r0;
        r9 = r8.mRemoteViewDetailModel;
        r0 = "喜马拉雅";
        r9.nickName = r0;
        r9 = r8.mRemoteViewDetailModel;
        r9.isDark = r13;
        r9 = r8.mRemoteViewDetailModel;
        r9.isPause = r2;
        r9 = r8.mRemoteViewDetailModel;
        r9.trackCoverBitmap = r1;
        r9 = r8.mRemoteViewDetailModel;
        r9.isDisableNextBtn = r3;
        r9 = r8.mRemoteViewDetailModel;
        r9.isDisablePreBtn = r3;
        r9 = r8.mRemoteViewDetailModel;
        r8.updateRemoteViewDetail(r9, r10, r11, r12);
    L_0x0152:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.appnotification.XmNotificationCreater.updateModelDetail(com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl, android.app.NotificationManager, android.app.Notification, int, boolean):void");
    }

    public void updateViewStateAtPause(NotificationManager notificationManager, Notification notification, int i, boolean z) {
        if (notification != null) {
            this.bigRemoteView = createBigRemoteViews(this.mContext, z);
            if (VERSION.SDK_INT >= 16) {
                notification.bigContentView = this.bigRemoteView;
            }
            this.remoteView = createRemoteViews(this.mContext, z);
            notification.contentView = this.remoteView;
            this.mRemoteViewDetailModel.isDark = z;
            this.mRemoteViewDetailModel.isPause = true;
            try {
                updateRemoteViewDetail(this.mRemoteViewDetailModel, notificationManager, notification, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateViewStateAtPauseForLive(NotificationManager notificationManager, Notification notification, int i, PendingIntent pendingIntent, boolean z) {
        if (notification != null) {
            this.bigRemoteView = createBigRemoteViewsForLive(this.mContext, pendingIntent, z);
            if (VERSION.SDK_INT >= 16) {
                notification.bigContentView = this.bigRemoteView;
            }
            this.remoteView = createRemoteViewsForLive(this.mContext, pendingIntent, z);
            notification.contentView = this.remoteView;
            this.mRemoteViewDetailModel.isDark = z;
            this.mRemoteViewDetailModel.isPause = true;
            this.mRemoteViewDetailModel.isDisablePreBtn = true;
            this.mRemoteViewDetailModel.isDisableNextBtn = true;
            updateRemoteViewDetail(this.mRemoteViewDetailModel, notificationManager, notification, i);
        }
    }

    public void updateViewStateAtStart(NotificationManager notificationManager, Notification notification, int i, boolean z) {
        if (notification != null) {
            this.bigRemoteView = createBigRemoteViews(this.mContext, z);
            if (VERSION.SDK_INT >= 16) {
                notification.bigContentView = this.bigRemoteView;
            }
            this.remoteView = createRemoteViews(this.mContext, z);
            notification.contentView = this.remoteView;
            this.mRemoteViewDetailModel.isDark = z;
            this.mRemoteViewDetailModel.isPause = false;
            updateRemoteViewDetail(this.mRemoteViewDetailModel, notificationManager, notification, i);
        }
    }

    public void updateViewStateAtStartForLive(long j, String str, String str2, String str3, final NotificationManager notificationManager, final Notification notification, final int i, PendingIntent pendingIntent, boolean z) {
        if (notification != null) {
            String str4 = "LiveAudio";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LiveplayerManager init id:");
            stringBuilder.append(i);
            stringBuilder.append(" ");
            stringBuilder.append(notification == null);
            stringBuilder.append(" coverUrl");
            stringBuilder.append(str);
            Log.i(str4, stringBuilder.toString());
            this.bigRemoteView = createBigRemoteViewsForLive(this.mContext, pendingIntent, z);
            if (checkAndroidVersion() && VERSION.SDK_INT >= 16) {
                notification.bigContentView = this.bigRemoteView;
            }
            this.remoteView = createRemoteViewsForLive(this.mContext, pendingIntent, z);
            notification.contentView = this.remoteView;
            if (str == null || "".equals(str) || this.remoteView == null || notificationManager == null) {
                this.mRemoteViewDetailModel.trackDetail = "随时随地 听我想听";
                this.mRemoteViewDetailModel.nickName = "喜马拉雅";
                this.mRemoteViewDetailModel.isDark = z;
                this.mRemoteViewDetailModel.isPause = false;
                this.mRemoteViewDetailModel.trackCoverBitmap = null;
                this.mRemoteViewDetailModel.isDisableNextBtn = true;
                this.mRemoteViewDetailModel.isDisablePreBtn = true;
                updateRemoteViewDetail(this.mRemoteViewDetailModel, notificationManager, notification, i);
            } else {
                int dp2px = dp2px(this.mContext, 64.0f);
                if (checkAndroidVersion()) {
                    dp2px = dp2px(this.mContext, 110.0f);
                }
                Track track = new Track();
                track.setDataId(j);
                track.setCoverUrlLarge(str);
                track.setCoverUrlMiddle(str);
                track.setCoverUrlSmall(str);
                this.mRemoteViewDetailModel.isDark = z;
                this.mRemoteViewDetailModel.isPause = false;
                this.mRemoteViewDetailModel.trackCoverBitmap = null;
                this.mRemoteViewDetailModel.isDisableNextBtn = true;
                this.mRemoteViewDetailModel.isDisablePreBtn = true;
                this.mRemoteViewDetailModel.nickName = str2;
                this.mRemoteViewDetailModel.trackDetail = str3;
                updateRemoteViewDetail(this.mRemoteViewDetailModel, notificationManager, notification, i);
                FileUtilBase.getBitmapByUrl(this.mContext, track, dp2px, dp2px, new IBitmapDownOkCallBack() {
                    public void onSuccess(Bitmap bitmap) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("getBitmapByUrl  onSuccess  ");
                        stringBuilder.append(bitmap);
                        Logger.log(stringBuilder.toString());
                        XmNotificationCreater.this.mRemoteViewDetailModel.trackCoverBitmap = bitmap;
                        XmNotificationCreater.this.updateRemoteViewDetail(XmNotificationCreater.this.mRemoteViewDetailModel, notificationManager, notification, i);
                    }
                });
            }
        }
    }
}
