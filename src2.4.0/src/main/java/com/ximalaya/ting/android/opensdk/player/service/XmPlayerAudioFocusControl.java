package com.ximalaya.ting.android.opensdk.player.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.ximalaya.ting.android.opensdk.player.constants.PlayerConstants;
import com.ximalaya.ting.android.opensdk.util.Logger;
import java.util.Timer;
import java.util.TimerTask;

public class XmPlayerAudioFocusControl {
    private OnAudioFocusChangeListener audioFoucusListener = new OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("XmPlayerAudioFocusControl : onAudioFocusChange = ");
            stringBuilder.append(i);
            Logger.log(stringBuilder.toString());
            XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
            if (i == -1) {
                if (XmPlayerAudioFocusControl.this.isContinuePlay) {
                    XmPlayerAudioFocusControl.this.isContinuePlay = false;
                    return;
                }
                if (playerSrvice != null) {
                    playerSrvice.setLossAudioFocus(true);
                    playerSrvice.pausePlay();
                }
                if (XmPlayerAudioFocusControl.this.audioManager != null) {
                    XmPlayerAudioFocusControl.this.audioManager.abandonAudioFocus(XmPlayerAudioFocusControl.this.audioFoucusListener);
                }
            } else if (i == -2) {
                if (playerSrvice != null) {
                    if (playerSrvice.isPlaying()) {
                        playerSrvice.pausePlay();
                        XmPlayerAudioFocusControl.this.mIsStopAudioByFocus = true;
                    } else if (playerSrvice.getPlayControl() != null && playerSrvice.getPlayControl().getPlayerState() == 9) {
                        playerSrvice.setLossAudioFocus(true);
                        XmPlayerAudioFocusControl.this.mIsStopAudioByFocus = true;
                    }
                }
            } else if (i != 2) {
                if (i == 1) {
                    if (playerSrvice != null) {
                        playerSrvice.setLossAudioFocus(false);
                        if (XmPlayerAudioFocusControl.this.mIsStopAudioByFocus) {
                            playerSrvice.startPlay();
                            XmPlayerAudioFocusControl.this.mIsStopAudioByFocus = false;
                        }
                        playerSrvice.setVolume(1.0f, 1.0f);
                    }
                } else if (i == -3) {
                    if (playerSrvice != null) {
                        playerSrvice.setVolume(XmPlayerConfig.getInstance(XmPlayerAudioFocusControl.this.mContext).getReceviceDuckVolume(), XmPlayerConfig.getInstance(XmPlayerAudioFocusControl.this.mContext).getReceviceDuckVolume());
                    }
                } else if (i == 3 && playerSrvice != null) {
                    playerSrvice.setVolume(XmPlayerConfig.getInstance(XmPlayerAudioFocusControl.this.mContext).getReceviceDuckVolume(), XmPlayerConfig.getInstance(XmPlayerAudioFocusControl.this.mContext).getReceviceDuckVolume());
                }
            }
        }
    };
    private AudioManager audioManager;
    private boolean isContinuePlay = false;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!action.equals(PlayerConstants.ACTION_NOTIFICATION_EXIT)) {
                if (action.equals("android.intent.action.HEADSET_PLUG") || "android.media.AUDIO_BECOMING_NOISY".equals(action)) {
                    if (intent.getIntExtra("state", 0) != 1) {
                        if (XmPlayerAudioFocusControl.this.isContinuePlay) {
                            new Timer().schedule(new TimerTask() {
                                public void run() {
                                    XmPlayerAudioFocusControl.this.isContinuePlay = false;
                                }
                            }, 3000);
                            return;
                        }
                        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
                        if (playerSrvice != null && playerSrvice.isPlaying()) {
                            playerSrvice.pausePlay();
                        }
                    }
                } else if (!(action.equals("android.net.conn.CONNECTIVITY_CHANGE") || action.equals(PlayerConstants.ACTION_NOTIFICATION_SWITCH_PLAY_PAUSE) || action.equals(PlayerConstants.ACTION_NOTIFICATION_PLAY_NEXT))) {
                    action.equals(PlayerConstants.ACTION_NOTIFICATION_PLAY_PRE);
                }
            }
        }
    };
    private BroadcastReceiver mBroadcastReceiverPhoneCall = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
                XmPlayerAudioFocusControl.this.callStateRinging();
                return;
            }
            switch (((TelephonyManager) context.getSystemService("phone")).getCallState()) {
                case 0:
                    XmPlayerAudioFocusControl.this.callStateIdle();
                    return;
                case 1:
                    XmPlayerAudioFocusControl.this.callStateRinging();
                    return;
                case 2:
                    XmPlayerAudioFocusControl.this.callStateRinging();
                    return;
                default:
                    return;
            }
        }
    };
    private Context mContext;
    private boolean mIsStopAudioByFocus;
    private PhoneStateListener mPhoneStateListener = new PhoneStateListener() {
        public void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            switch (i) {
                case 0:
                    XmPlayerAudioFocusControl.this.callStateIdle();
                    return;
                case 1:
                    XmPlayerAudioFocusControl.this.callStateRinging();
                    return;
                case 2:
                    XmPlayerAudioFocusControl.this.callStateRinging();
                    return;
                default:
                    return;
            }
        }
    };
    private boolean telPauseFlag = false;
    private TelephonyManager telephonyManager;
    private TelephonyManager telephonyManager1;
    private TelephonyManager telephonyManager2;

    public XmPlayerAudioFocusControl(Context context) {
        this.mContext = context.getApplicationContext();
        initListener();
    }

    private void callStateIdle() {
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice != null && this.telPauseFlag) {
            playerSrvice.startPlay();
        }
        this.telPauseFlag = false;
    }

    private void callStateRinging() {
        XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
        if (playerSrvice != null && playerSrvice.isPlaying()) {
            this.telPauseFlag = true;
            playerSrvice.pausePlay();
        }
    }

    private void initListener() {
        if (this.mContext != null) {
            this.audioManager = (AudioManager) this.mContext.getSystemService("audio");
            if (XmPlayerConfig.getInstance(this.mContext).isSDKHandleHeadsetPlugAudioFocus()) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                this.mContext.registerReceiver(this.mBroadcastReceiver, intentFilter);
            }
            if (XmPlayerConfig.getInstance(this.mContext).isSDKHandlePhoneComeAudioFocus()) {
                initTelephonyManager();
                this.mContext.registerReceiver(this.mBroadcastReceiverPhoneCall, new IntentFilter());
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0028 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
    /* JADX WARNING: Missing block: B:7:?, code skipped:
            return;
     */
    private void initTelephonyManager() {
        /*
        r3 = this;
        r0 = r3.mContext;
        r1 = "phone";
        r0 = r0.getSystemService(r1);
        r0 = (android.telephony.TelephonyManager) r0;
        r3.telephonyManager = r0;
        r0 = r3.telephonyManager;
        r1 = r3.mPhoneStateListener;
        r2 = 32;
        r0.listen(r1, r2);
        r0 = r3.mContext;	 Catch:{ Exception -> 0x0028 }
        r1 = "phone1";
        r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x0028 }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x0028 }
        r3.telephonyManager1 = r0;	 Catch:{ Exception -> 0x0028 }
        r0 = r3.telephonyManager1;	 Catch:{ Exception -> 0x0028 }
        r1 = r3.mPhoneStateListener;	 Catch:{ Exception -> 0x0028 }
        r0.listen(r1, r2);	 Catch:{ Exception -> 0x0028 }
    L_0x0028:
        r0 = r3.mContext;	 Catch:{ Exception -> 0x003b }
        r1 = "phone2";
        r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x003b }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x003b }
        r3.telephonyManager2 = r0;	 Catch:{ Exception -> 0x003b }
        r0 = r3.telephonyManager2;	 Catch:{ Exception -> 0x003b }
        r1 = r3.mPhoneStateListener;	 Catch:{ Exception -> 0x003b }
        r0.listen(r1, r2);	 Catch:{ Exception -> 0x003b }
    L_0x003b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.service.XmPlayerAudioFocusControl.initTelephonyManager():void");
    }

    public AudioManager getAudioManager() {
        return this.audioManager;
    }

    public void needContinuePlay(boolean z) {
        this.isContinuePlay = z;
    }

    public void setAudioFocusAtStartState() {
        if (XmPlayerConfig.getInstance(this.mContext).isSDKHandleAudioFocus()) {
            try {
                this.audioManager.requestAudioFocus(this.audioFoucusListener, 3, 1);
                XmPlayerService playerSrvice = XmPlayerService.getPlayerSrvice();
                if (playerSrvice != null) {
                    playerSrvice.setLossAudioFocus(false);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void setAudioFocusAtStopState() {
        if (XmPlayerConfig.getInstance(this.mContext).isSDKHandleAudioFocus()) {
            this.audioManager.abandonAudioFocus(this.audioFoucusListener);
        }
    }

    public void setAudioPauseManual(boolean z) {
        this.mIsStopAudioByFocus = z ^ 1;
    }
}
