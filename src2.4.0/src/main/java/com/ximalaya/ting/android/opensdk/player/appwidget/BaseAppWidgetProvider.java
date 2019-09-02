package com.ximalaya.ting.android.opensdk.player.appwidget;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.gson.Gson;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.model.PlayableModel;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.appnotification.XmNotificationCreater;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;

public abstract class BaseAppWidgetProvider extends AppWidgetProvider {
    public abstract void onInitUI(Context context, Track track);

    public abstract void onPausePlay(Context context);

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent != null) {
            Track track;
            PlayableModel playableModel;
            if (intent.getAction().equals(ConstantsOpenSdk.PAUSE_PLAYER_ACTION)) {
                onPausePlay(context);
            } else if (intent.getAction().equals(ConstantsOpenSdk.START_PLAYER_ACTION)) {
                onStartPlay(context);
            } else if (intent.getAction().equals(ConstantsOpenSdk.STATE_COMPLETE_ACTION)) {
                onPausePlay(context);
            } else if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
                String string = SharedPreferencesUtil.getInstance(context).getString("lasttrack");
                if (string != null) {
                    try {
                        track = (Track) new Gson().fromJson(string, Track.class);
                    } catch (Exception unused) {
                        track = null;
                    }
                    if (track != null) {
                        onInitUI(context, track);
                    }
                }
            } else if (intent.getAction().equals(ConstantsOpenSdk.UI_INIT_ACTION)) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    track = (Track) extras.get("track");
                    if (track != null) {
                        onInitUI(context, track);
                    }
                }
            } else if (intent.getAction().equals(XmNotificationCreater.ACTION_CONTROL_PLAY_PRE_MAIN)) {
                playableModel = XmPlayerService.getPlayerSrvice().getPlayableModel();
                if (playableModel != null) {
                    onInitUI(context, (Track) playableModel);
                }
            } else if (intent.getAction().equals(XmNotificationCreater.ACTION_CONTROL_PLAY_NEXT_MAIN)) {
                playableModel = XmPlayerService.getPlayerSrvice().getPlayableModel();
                if (playableModel != null) {
                    onInitUI(context, (Track) playableModel);
                }
            }
        }
    }

    public abstract void onStartPlay(Context context);
}
