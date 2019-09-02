package com.ximalaya.ting.android.opensdk.player.service;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.FloatRange;
import com.ximalaya.ting.android.opensdk.constants.PreferenceConstantsInOpenSdk;
import com.yalantis.ucrop.view.CropImageView;

public class XmPlayerConfig {
    private static final int PREFERENCE_MODE = 0;
    private static XmPlayerConfig sInstance = null;
    private static byte[] sLock = new byte[0];
    private static boolean usePreventHijack = false;
    private static boolean useSystemLockScreen = true;
    private boolean isSDKHandleAudioFocus = false;
    private boolean isSDKHandleHeadsetPlugAudioFocus = false;
    private boolean isSDKHandlePhoneComeAudioFocus = false;
    private Context mAppCtx;
    private SharedPreferences mPreferences;
    private float volume = CropImageView.DEFAULT_ASPECT_RATIO;

    private XmPlayerConfig(Context context) {
        this.mAppCtx = context.getApplicationContext();
        init();
    }

    @TargetApi(9)
    private void apply(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public static XmPlayerConfig getInstance(Context context) {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new XmPlayerConfig(context);
                }
            }
        }
        return sInstance;
    }

    private void init() {
        this.mPreferences = this.mAppCtx.getSharedPreferences(PreferenceConstantsInOpenSdk.OPENSDK_FILENAME_XMPLAYER_CONFIG, 0);
    }

    public boolean getIsUseSystemPlayer() {
        return isUseSystemPlayer();
    }

    public float getReceviceDuckVolume() {
        if (this.volume != CropImageView.DEFAULT_ASPECT_RATIO) {
            return this.volume;
        }
        this.volume = this.mPreferences.getFloat(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_RECEVICE_AUDIO_FOCUS_TYPE_DUCK_VOLUME, 0.3f);
        return this.volume;
    }

    public boolean isBreakpointResume() {
        return this.mPreferences.getBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_BREAKPOINT_RESUME, true);
    }

    public boolean isSDKHandleAudioFocus() {
        if (!this.isSDKHandleAudioFocus) {
            this.isSDKHandleAudioFocus = this.mPreferences.getBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_HANDLE_AUDIO_FOCUS, true);
        }
        return this.isSDKHandleAudioFocus;
    }

    public boolean isSDKHandleHeadsetPlugAudioFocus() {
        if (!this.isSDKHandleHeadsetPlugAudioFocus) {
            this.isSDKHandleHeadsetPlugAudioFocus = this.mPreferences.getBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_HANDLE_HEADSET_PLUG_AUDIO_FOCUS, true);
        }
        return this.isSDKHandleHeadsetPlugAudioFocus;
    }

    public boolean isSDKHandlePhoneComeAudioFocus() {
        if (!this.isSDKHandleHeadsetPlugAudioFocus) {
            this.isSDKHandleHeadsetPlugAudioFocus = this.mPreferences.getBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_HANDLE_PHONECOME_AUDIO_FOCUS, true);
        }
        return this.isSDKHandlePhoneComeAudioFocus;
    }

    public boolean isUsePreventHijack() {
        if (!usePreventHijack) {
            usePreventHijack = this.mPreferences.getBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_USE_PREVENT_HIJACK, false);
        }
        return usePreventHijack;
    }

    public boolean isUseRadioHighBitrate() {
        return this.mPreferences.getBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_USE_RADIO_HIGH_BITRATE, false);
    }

    public boolean isUseSystemLockScreen() {
        if (useSystemLockScreen) {
            useSystemLockScreen = this.mPreferences.getBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_USE_SYSTEM_LOCK_SCREEN, true);
        }
        return useSystemLockScreen;
    }

    /* Access modifiers changed, original: protected */
    public boolean isUseSystemPlayer() {
        return this.mPreferences.getBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_USE_SYSTEM_PLAYER, false);
    }

    public boolean isUseTrackHighBitrate() {
        return this.mPreferences.getBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_USE_TRACK_HIGH_BITRATE, false);
    }

    public void release() {
        synchronized (sLock) {
            sInstance = null;
        }
    }

    public void setBreakpointResume(boolean z) {
        apply(this.mPreferences.edit().putBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_BREAKPOINT_RESUME, z));
    }

    public void setReceviceDuckVolume(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        apply(this.mPreferences.edit().putFloat(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_RECEVICE_AUDIO_FOCUS_TYPE_DUCK_VOLUME, f));
    }

    public void setSDKHandleAudioFocus(boolean z) {
        apply(this.mPreferences.edit().putBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_HANDLE_AUDIO_FOCUS, z));
    }

    public void setSDKHandleHeadsetPlugAudioFocus(boolean z) {
        apply(this.mPreferences.edit().putBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_HANDLE_HEADSET_PLUG_AUDIO_FOCUS, z));
    }

    public void setSDKHandlePhoneComeAudioFocus(boolean z) {
        apply(this.mPreferences.edit().putBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_HANDLE_PHONECOME_AUDIO_FOCUS, z));
    }

    public void setUseRadioHighBitrate(boolean z) {
        apply(this.mPreferences.edit().putBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_USE_RADIO_HIGH_BITRATE, z));
    }

    public void setUseSystemLockScreen(boolean z) {
        useSystemLockScreen = z;
        apply(this.mPreferences.edit().putBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_USE_SYSTEM_LOCK_SCREEN, z));
    }

    /* Access modifiers changed, original: protected */
    public void setUseSystemPlayer(boolean z) {
        apply(this.mPreferences.edit().putBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_USE_SYSTEM_PLAYER, z));
    }

    public void setUseTrackHighBitrate(boolean z) {
        apply(this.mPreferences.edit().putBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_USE_TRACK_HIGH_BITRATE, z));
    }

    public void usePreventHijack(boolean z) {
        usePreventHijack = z;
        apply(this.mPreferences.edit().putBoolean(PreferenceConstantsInOpenSdk.OPENSDK_KEY_SDK_USE_PREVENT_HIJACK, z));
    }
}
