package com.ximalaya.ting.android.opensdk.player.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ximalaya.ting.android.opensdk.player.XmPlayerManager;
import com.ximalaya.ting.android.opensdk.player.appnotification.XmNotificationCreater;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayListControl;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerControl;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.Logger;

public class PlayerReceiver extends BroadcastReceiver {
    private static final String BYD_PACKAGE_NAME = "com.ximalaya.ting.android.car";
    private static final String TAG = "PLAYERRECEIVER";
    private int index = -1;
    private long mLastActionTimestamp;

    private void handleAction(Context context, Intent intent, XmPlayerService xmPlayerService, boolean z) {
        if (xmPlayerService != null) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("handleAction ");
            stringBuilder.append(intent.getAction());
            Logger.d(str, stringBuilder.toString());
            if (XmNotificationCreater.ACTION_CONTROL_CLOSE_MAIN.equals(intent.getAction()) || XmNotificationCreater.ACTION_CONTROL_CLOSE.equals(intent.getAction())) {
                Logger.log("process Main is running");
                if (xmPlayerService != null) {
                    xmPlayerService.closeNotification();
                }
                xmPlayerService.closeApp();
            } else if (intent.getAction().equals(XmNotificationCreater.ACTION_CONTROL_PLAY_PRE_MAIN) && xmPlayerService != null) {
                xmPlayerService.playPre();
            } else if (intent.getAction().equals(XmNotificationCreater.ACTION_CONTROL_PLAY_NEXT_MAIN) && xmPlayerService != null) {
                xmPlayerService.playNext();
            } else if (!intent.getAction().equals(XmNotificationCreater.ACTION_CONTROL_START_PAUSE_MAIN) || xmPlayerService == null) {
                if (xmPlayerService == null && context.getApplicationInfo().packageName.equalsIgnoreCase(BYD_PACKAGE_NAME)) {
                    XmPlayerManager.release();
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("tingcar://open"));
                    intent.addFlags(268435456);
                    if (intent.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(intent);
                    }
                } else if (xmPlayerService != null) {
                    if (intent.getAction().equals(XmNotificationCreater.ACTION_CONTROL_PLAY_NEXT)) {
                        xmPlayerService.playNext();
                    } else if (intent.getAction().equals(XmNotificationCreater.ACTION_CONTROL_PLAY_PRE)) {
                        xmPlayerService.playPre();
                    } else if (intent.getAction().equals(XmNotificationCreater.ACTION_CONTROL_START_PAUSE)) {
                        if (xmPlayerService.getPlayListSize() == 0 && context.getApplicationInfo().packageName.equalsIgnoreCase(BYD_PACKAGE_NAME)) {
                            intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse("tingcar://open"));
                            intent.addFlags(268435456);
                            if (intent.resolveActivity(context.getPackageManager()) != null) {
                                context.startActivity(intent);
                            }
                        } else if (xmPlayerService.isPlaying()) {
                            xmPlayerService.pausePlay();
                        } else {
                            xmPlayerService.startPlay(z);
                        }
                    }
                }
            } else if (xmPlayerService.isPlaying()) {
                xmPlayerService.pausePlay();
            } else {
                XmPlayerControl playControl = xmPlayerService.getPlayControl();
                XmPlayListControl playListControl = xmPlayerService.getPlayListControl();
                if (playControl == null || playListControl == null || playControl.getPlayerState() != 4) {
                    xmPlayerService.startPlay(z);
                } else {
                    int currIndex = playListControl.getCurrIndex();
                    if (currIndex == -1) {
                        currIndex = this.index;
                    }
                    if (currIndex != -1) {
                        xmPlayerService.play(currIndex);
                    }
                }
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction().equals(XmNotificationCreater.ACTION_CONTROL_RELEASE_SERVICE)) {
            XmPlayerManager.unBind();
            return;
        }
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (!((playerSrvice == null && XmNotificationCreater.ACTION_CONTROL_CLOSE_MAIN.equals(intent.getAction())) || playerSrvice == null)) {
            handleAction(context, intent, XmPlayerService.getPlayerSrvice(), false);
        }
    }
}
