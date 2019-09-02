package com.ximalaya.ting.android.opensdk.player.service;

import android.content.Context;
import com.ximalaya.ting.android.player.XMediaPlayerWrapper;
import com.ximalaya.ting.android.player.XMediaplayerImpl;

public class XmMediaPlayerFactory {
    private static boolean isUseSystemPlayer;

    public static XMediaplayerImpl getMediaPlayer(Context context) {
        return new XMediaPlayerWrapper(context, true, isUseSystemPlayer);
    }

    public static void setPlayerMode(boolean z) {
        isUseSystemPlayer = z;
    }
}
