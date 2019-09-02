package com.ximalaya.ting.android.opensdk.player.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.KeyEvent;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import com.ximalaya.ting.android.opensdk.util.Logger;

public class WireControlReceiver extends BroadcastReceiver {
    public static final int DELAY_MILLIS = 600;
    private static final String TAG = "WireControlReceiver";
    private static Handler clickHandler = new Handler();
    static Runnable doubleNextRunnable = new Runnable() {
        public void run() {
            WireControlReceiver.nextClickCount = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null) {
                playerSrvice.seekTo(playerSrvice.getPlayCurrPosition() + 15000);
            }
        }
    };
    static Runnable doublePreRunnable = new Runnable() {
        public void run() {
            WireControlReceiver.preClickCount = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null) {
                playerSrvice.seekTo(playerSrvice.getPlayCurrPosition() - 15000);
            }
        }
    };
    private static int lastLongRepeatCount;
    private static int nextClickCount;
    static Runnable playNextRunnable = new Runnable() {
        public void run() {
            WireControlReceiver.nextClickCount = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null) {
                playerSrvice.playNext();
            }
        }
    };
    private static int playOrPauseClickCount;
    static Runnable playOrPauseDoubleClickRunnable = new Runnable() {
        public void run() {
            WireControlReceiver.playOrPauseClickCount = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null) {
                playerSrvice.playNext();
            }
        }
    };
    static Runnable playOrPauseRunnable = new Runnable() {
        public void run() {
            WireControlReceiver.playOrPauseClickCount = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice == null) {
                return;
            }
            if (playerSrvice.isPlaying()) {
                playerSrvice.pausePlay();
            } else {
                playerSrvice.startPlay();
            }
        }
    };
    static Runnable playPreRunnable = new Runnable() {
        public void run() {
            WireControlReceiver.preClickCount = 0;
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (playerSrvice != null) {
                playerSrvice.playPre();
            }
        }
    };
    private static int preClickCount;

    private void seekOrNotif(boolean z, boolean z2) {
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice != null) {
            int duration = playerSrvice.getDuration();
            if (duration > 0) {
                int playCurrPosition = ((int) (((((float) (lastLongRepeatCount * duration)) * 1.0f) / 100.0f) * ((float) (z ? 1 : -1)))) + playerSrvice.getPlayCurrPosition();
                if (playCurrPosition > duration) {
                    playCurrPosition = duration;
                }
                if (z2) {
                    playerSrvice.notifProgress(playCurrPosition, duration);
                    return;
                }
                playerSrvice.seekTo(playCurrPosition);
                lastLongRepeatCount = 0;
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice != null && "android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
            KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (keyEvent != null) {
                if (keyEvent.getRepeatCount() > 0) {
                    lastLongRepeatCount = keyEvent.getRepeatCount();
                }
                StringBuilder stringBuilder;
                if (keyEvent.getAction() == 1) {
                    int keyCode = keyEvent.getKeyCode();
                    if (keyCode != 79) {
                        switch (keyCode) {
                            case 85:
                                break;
                            case 86:
                                Logger.logToSd("WireControlReceiver  1");
                                playerSrvice.pausePlay();
                                break;
                            case 87:
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("WireControlReceiver  4  ");
                                stringBuilder.append(lastLongRepeatCount);
                                Logger.logToSd(stringBuilder.toString());
                                if (lastLongRepeatCount <= 0) {
                                    nextClickCount++;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("WireControlReceiver  5  ");
                                    stringBuilder.append(nextClickCount);
                                    Logger.logToSd(stringBuilder.toString());
                                    if (nextClickCount < 2) {
                                        clickHandler.removeCallbacks(playNextRunnable);
                                        clickHandler.postDelayed(playNextRunnable, 600);
                                        break;
                                    }
                                    clickHandler.removeCallbacks(playNextRunnable);
                                    clickHandler.removeCallbacks(doubleNextRunnable);
                                    clickHandler.postDelayed(doubleNextRunnable, 600);
                                    break;
                                }
                                seekOrNotif(true, false);
                                break;
                            case 88:
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("WireControlReceiver  6  ");
                                stringBuilder.append(lastLongRepeatCount);
                                Logger.logToSd(stringBuilder.toString());
                                if (lastLongRepeatCount <= 0) {
                                    preClickCount++;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("WireControlReceiver  7  ");
                                    stringBuilder.append(preClickCount);
                                    Logger.logToSd(stringBuilder.toString());
                                    if (preClickCount < 2) {
                                        clickHandler.removeCallbacks(playPreRunnable);
                                        clickHandler.postDelayed(playPreRunnable, 600);
                                        break;
                                    }
                                    clickHandler.removeCallbacks(playPreRunnable);
                                    clickHandler.removeCallbacks(doublePreRunnable);
                                    clickHandler.postDelayed(doublePreRunnable, 600);
                                    break;
                                }
                                seekOrNotif(false, false);
                                break;
                            default:
                                switch (keyCode) {
                                    case XmPlayerService.CODE_GET_RADIO_LIST /*126*/:
                                        Logger.logToSd("WireControlReceiver  2");
                                        playerSrvice.startPlay();
                                        break;
                                    case XmPlayerService.CODE_GET_RADIO_SCHEDULES /*127*/:
                                        break;
                                }
                                break;
                        }
                    }
                    playOrPauseClickCount++;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("WireControlReceiver  3  == ");
                    stringBuilder2.append(playOrPauseClickCount);
                    Logger.logToSd(stringBuilder2.toString());
                    clickHandler.removeCallbacks(playOrPauseRunnable);
                    clickHandler.removeCallbacks(playOrPauseDoubleClickRunnable);
                    if (playOrPauseClickCount == 1) {
                        clickHandler.postDelayed(playOrPauseRunnable, 600);
                    } else if (playOrPauseClickCount == 2) {
                        clickHandler.postDelayed(playOrPauseDoubleClickRunnable, 400);
                    } else {
                        playOrPauseClickCount = 0;
                        playerSrvice.playPre();
                    }
                    try {
                        if (isOrderedBroadcast()) {
                            abortBroadcast();
                        }
                    } catch (Exception unused) {
                    }
                    return;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("WireControlReceiver  0  ");
                stringBuilder.append(keyEvent);
                stringBuilder.append("   ");
                stringBuilder.append(lastLongRepeatCount);
                Logger.logToSd(stringBuilder.toString());
                if (keyEvent.getKeyCode() == 87) {
                    if (lastLongRepeatCount > 0) {
                        seekOrNotif(true, true);
                    }
                } else if (keyEvent.getKeyCode() == 88 && lastLongRepeatCount > 0) {
                    seekOrNotif(false, true);
                }
            }
        }
    }
}
