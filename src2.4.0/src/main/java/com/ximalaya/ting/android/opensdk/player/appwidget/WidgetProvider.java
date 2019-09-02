package com.ximalaya.ting.android.opensdk.player.appwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.RemoteViews;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.appnotification.XmNotificationCreater;
import com.ximalaya.ting.android.opensdk.player.receive.PlayerReceiver;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.FileUtilBase;
import com.ximalaya.ting.android.opensdk.util.FileUtilBase.IBitmapDownOkCallBack;

public class WidgetProvider extends BaseAppWidgetProvider {
    private void commitUpdate(Context context, RemoteViews remoteViews) {
        AppWidgetManager instance = AppWidgetManager.getInstance(context);
        ComponentName componentName = new ComponentName(context, getClass());
        if (instance != null && remoteViews != null) {
            instance.updateAppWidget(componentName, remoteViews);
        }
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void setDataToView(Context context, Track track, RemoteViews remoteViews) {
        if (track != null && context != null && remoteViews != null) {
            try {
                if (XmPlayerService.getPlayerSrvice() != null) {
                    if (XmPlayerService.getPlayerSrvice().isPlaying()) {
                        remoteViews.setImageViewResource(getResourceId(context, "appwidget_playOrPause", "id"), getResourceId(context, "host_reflect_widget_pause", "drawable"));
                    } else {
                        remoteViews.setImageViewResource(getResourceId(context, "appwidget_playOrPause", "id"), getResourceId(context, "host_reflect_widget_play", "drawable"));
                    }
                }
                String trackTitle = track.getTrackTitle();
                CharSequence nickname = track.getAnnouncer() == null ? "" : track.getAnnouncer().getNickname();
                remoteViews.setTextViewText(getResourceId(context, "appwidget_title", "id"), trackTitle);
                remoteViews.setTextViewText(getResourceId(context, "appwidget_name", "id"), nickname);
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    updateRomoteBitmap(context, track, remoteViews);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateLayout(Context context) {
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice != null) {
            PlayableModel playableModel = playerSrvice.getPlayableModel();
            if (playableModel != null) {
                updateWedgitUI(context, (Track) playableModel);
            }
        }
    }

    private void updateRomoteBitmap(final Context context, Track track, final RemoteViews remoteViews) {
        int dp2px = dp2px(context, 55.0f);
        if (!checkAndroidVersion()) {
            dp2px = dp2px(context, 30.0f);
        }
        try {
            FileUtilBase.getBitmapByUrl(context, track, dp2px, dp2px, new IBitmapDownOkCallBack() {
                public void onSuccess(Bitmap bitmap) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        if (remoteViews != null) {
                            remoteViews.setInt(WidgetProvider.this.getResourceId(context, "appwidget_icon_small", "id"), "setImageResource", WidgetProvider.this.getResourceId(context, XmNotificationCreater.IMG_NOTIFYICON_DRAWABLE, "drawable"));
                        }
                    } else if (remoteViews != null) {
                        remoteViews.setImageViewBitmap(WidgetProvider.this.getResourceId(context, "appwidget_icon_small", "id"), bitmap);
                    }
                    if (remoteViews != null) {
                        WidgetProvider.this.commitUpdate(context, remoteViews);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateWedgitUI(Context context, Track track) {
        RemoteViews remoteViews = null;
        if (context != null) {
            try {
                remoteViews = new RemoteViews(context.getPackageName(), getResourceId(context, "host_reflect_appwidget_layout", "layout"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (remoteViews != null && track != null) {
            setDataToView(context, track, remoteViews);
            commitUpdate(context, remoteViews);
        }
    }

    private void updateWidgetForWallPaperChanged(Context context) {
        try {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), getResourceId(context, "host_reflect_appwidget_layout", "layout"));
            AppWidgetManager instance = AppWidgetManager.getInstance(context);
            if (remoteViews != null) {
                String str = XmNotificationCreater.ACTION_CONTROL_START_PAUSE;
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    str = XmNotificationCreater.ACTION_CONTROL_START_PAUSE_MAIN;
                }
                Intent intent = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                intent.setAction(str);
                remoteViews.setOnClickPendingIntent(getResourceId(context, "appwidget_playOrPause", "id"), PendingIntent.getBroadcast(context, 0, intent, 134217728));
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    intent = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                    intent.setAction(XmNotificationCreater.ACTION_CONTROL_PLAY_PRE_MAIN);
                    remoteViews.setOnClickPendingIntent(getResourceId(context, "appwidget_pre", "id"), PendingIntent.getBroadcast(context, 0, intent, 134217728));
                    intent = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                    intent.setAction(XmNotificationCreater.ACTION_CONTROL_PLAY_NEXT_MAIN);
                    remoteViews.setOnClickPendingIntent(getResourceId(context, "appwidget_next", "id"), PendingIntent.getBroadcast(context, 0, intent, 134217728));
                }
                Intent intent2 = new Intent("android.intent.action.VIEW");
                if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                    intent2.setData(Uri.parse("itingwelcom://open"));
                    remoteViews.setOnClickPendingIntent(getResourceId(context, "appwidget_icon_small", "id"), PendingIntent.getActivity(context, 0, intent2, 0));
                } else {
                    intent2.setData(Uri.parse("tingcar://open"));
                    remoteViews.setOnClickPendingIntent(getResourceId(context, "ll_open_app", "id"), PendingIntent.getActivity(context, 0, intent2, 0));
                }
                XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
                ComponentName componentName = new ComponentName(context, getClass());
                if (playerSrvice == null) {
                    instance.updateAppWidget(componentName, remoteViews);
                    return;
                }
                PlayableModel playableModel = playerSrvice.getPlayableModel();
                if (playableModel instanceof Track) {
                    setDataToView(context, (Track) playableModel, remoteViews);
                }
                instance.updateAppWidget(componentName, remoteViews);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkAndroidVersion() {
        return VERSION.SDK_INT >= 16;
    }

    public int getResourceId(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
    }

    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    public void onInitUI(Context context, Track track) {
        updateWedgitUI(context, track);
    }

    public void onPausePlay(Context context) {
        RemoteViews remoteViews = null;
        if (context != null) {
            try {
                remoteViews = new RemoteViews(context.getPackageName(), getResourceId(context, "host_reflect_appwidget_layout", "layout"));
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (remoteViews != null) {
            remoteViews.setImageViewResource(getResourceId(context, "appwidget_playOrPause", "id"), getResourceId(context, "host_reflect_widget_play", "drawable"));
            commitUpdate(context, remoteViews);
        }
    }

    public void onReceive(Context context, Intent intent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onReceive action ");
        stringBuilder.append(intent.getAction());
        Log.w("WidgetProvider", stringBuilder.toString());
        super.onReceive(context, intent);
        if (intent != null && "android.intent.action.WALLPAPER_CHANGED".equals(intent.getAction())) {
            updateWidgetForWallPaperChanged(context);
        }
    }

    public void onStartPlay(Context context) {
        updateLayout(context);
    }

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        try {
            if (iArr.length > 0) {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), getResourceId(context, "host_reflect_appwidget_layout", "layout"));
                if (remoteViews != null) {
                    String str = XmNotificationCreater.ACTION_CONTROL_START_PAUSE;
                    if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                        str = XmNotificationCreater.ACTION_CONTROL_START_PAUSE_MAIN;
                    }
                    Intent intent = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                    intent.setAction(str);
                    remoteViews.setOnClickPendingIntent(getResourceId(context, "appwidget_playOrPause", "id"), PendingIntent.getBroadcast(context, 0, intent, 134217728));
                    if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                        intent = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                        intent.setAction(XmNotificationCreater.ACTION_CONTROL_PLAY_PRE_MAIN);
                        remoteViews.setOnClickPendingIntent(getResourceId(context, "appwidget_pre", "id"), PendingIntent.getBroadcast(context, 0, intent, 134217728));
                        intent = new Intent(context.getApplicationContext(), PlayerReceiver.class);
                        intent.setAction(XmNotificationCreater.ACTION_CONTROL_PLAY_NEXT_MAIN);
                        remoteViews.setOnClickPendingIntent(getResourceId(context, "appwidget_next", "id"), PendingIntent.getBroadcast(context, 0, intent, 134217728));
                    }
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    if (context.getPackageName().equals("com.ximalaya.ting.android")) {
                        intent2.setData(Uri.parse("itingwelcom://open"));
                        remoteViews.setOnClickPendingIntent(getResourceId(context, "appwidget_icon_small", "id"), PendingIntent.getActivity(context, 0, intent2, 0));
                    } else {
                        intent2.setData(Uri.parse("tingcar://open"));
                        remoteViews.setOnClickPendingIntent(getResourceId(context, "ll_open_app", "id"), PendingIntent.getActivity(context, 0, intent2, 0));
                    }
                    XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
                    if (playerSrvice == null) {
                        appWidgetManager.updateAppWidget(iArr, remoteViews);
                        return;
                    }
                    PlayableModel playableModel = playerSrvice.getPlayableModel();
                    if (playableModel instanceof Track) {
                        setDataToView(context, (Track) playableModel, remoteViews);
                    }
                    appWidgetManager.updateAppWidget(iArr, remoteViews);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
