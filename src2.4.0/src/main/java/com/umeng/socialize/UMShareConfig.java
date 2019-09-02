package com.umeng.socialize;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.interfaces.CompressListener;
import com.umeng.socialize.utils.O00000Oo;
import defpackage.dh;

public final class UMShareConfig {
    public static final int AUTH_TYPE_SSO = 1;
    public static final int AUTH_TYPE_WEBVIEW = 2;
    public static final int KAKAO_ACCOUNT = 2;
    public static final int KAKAO_STORY = 1;
    public static final int KAKAO_TALK = 0;
    public static final int LINED_IN_BASE_PROFILE = 0;
    public static final int LINED_IN_FULL_PROFILE = 1;
    public static final int LINKED_IN_FRIEND_SCOPE_ANYONE = 0;
    public static final int LINKED_IN_FRIEND_SCOPE_CONNECTIONS = 1;
    private CompressListener compressListener;
    private int facebookAuthType;
    private boolean isHideQzoneOnQQFriendList;
    public boolean isNeedAuthOnGetUserInfo;
    private boolean isOpenShareEditActivity = true;
    private boolean isOpenWXAnalytics;
    private int kakaoAuthType;
    private int linkedInFriendScope;
    private int linkedInProfileScope;
    private String platformName = "";
    private int sinaAuthType;

    public UMShareConfig() {
        boolean z = false;
        this.isOpenWXAnalytics = false;
        setShareToLinkedInFriendScope(Config.LinkedInShareCode);
        if (Config.QQWITHQZONE == 2) {
            z = true;
        }
        setShareToQQFriendQzoneItemHide(z);
        setShareToQQPlatformName(Config.appName);
        setSinaAuthType(1);
        setFacebookAuthType(1);
        setKaKaoAuthType(Config.KaKaoLoginType);
        isNeedAuthOnGetUserInfo(Config.isNeedAuth);
        setLinkedInProfileScope(Config.LinkedInProfileScope);
    }

    public final String getAppName() {
        if (TextUtils.isEmpty(this.platformName)) {
            Context O000000o = O00000Oo.O000000o();
            if (O000000o != null) {
                CharSequence loadLabel = O000000o.getApplicationInfo().loadLabel(O000000o.getPackageManager());
                if (!TextUtils.isEmpty(loadLabel)) {
                    this.platformName = loadLabel.toString();
                }
            }
        }
        return this.platformName;
    }

    public CompressListener getCompressListener() {
        return this.compressListener;
    }

    public boolean getOpenWXAnalytics() {
        return this.isOpenWXAnalytics;
    }

    public final boolean isFacebookAuthWithWebView() {
        return this.facebookAuthType == 2;
    }

    public final boolean isHideQzoneOnQQFriendList() {
        return this.isHideQzoneOnQQFriendList;
    }

    public final boolean isKakaoAuthWithAccount() {
        return this.kakaoAuthType == 2;
    }

    public final boolean isKakaoAuthWithStory() {
        return this.kakaoAuthType == 1;
    }

    public final boolean isKakaoAuthWithTalk() {
        return this.kakaoAuthType == 0;
    }

    public final boolean isLinkedInProfileBase() {
        return this.linkedInProfileScope == 0;
    }

    public final boolean isLinkedInShareToAnyone() {
        return this.linkedInFriendScope == 0;
    }

    public UMShareConfig isNeedAuthOnGetUserInfo(boolean z) {
        this.isNeedAuthOnGetUserInfo = z;
        return this;
    }

    public final boolean isNeedAuthOnGetUserInfo() {
        return this.isNeedAuthOnGetUserInfo;
    }

    public UMShareConfig isOpenShareEditActivity(boolean z) {
        this.isOpenShareEditActivity = z;
        dh.O000000o(z);
        return this;
    }

    public final boolean isOpenShareEditActivity() {
        return this.isOpenShareEditActivity;
    }

    public final boolean isSinaAuthWithWebView() {
        return this.sinaAuthType == 2;
    }

    public void setCompressListener(CompressListener compressListener) {
        this.compressListener = compressListener;
    }

    public UMShareConfig setFacebookAuthType(int i) {
        if (i == 1 || i == 2) {
            this.facebookAuthType = i;
        }
        return this;
    }

    public UMShareConfig setKaKaoAuthType(int i) {
        if (i == 0 || i == 2 || i == 1) {
            this.kakaoAuthType = i;
        }
        return this;
    }

    public UMShareConfig setLinkedInProfileScope(int i) {
        if (i == 0 || i == 1) {
            this.linkedInProfileScope = i;
        }
        return this;
    }

    public void setOpenWXAnalytics(boolean z) {
        this.isOpenWXAnalytics = z;
    }

    public UMShareConfig setShareToLinkedInFriendScope(int i) {
        if (i == 0 || i == 1) {
            this.linkedInFriendScope = i;
        }
        return this;
    }

    public UMShareConfig setShareToQQFriendQzoneItemHide(boolean z) {
        this.isHideQzoneOnQQFriendList = z;
        return this;
    }

    public UMShareConfig setShareToQQPlatformName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.platformName = str;
        }
        return this;
    }

    public UMShareConfig setSinaAuthType(int i) {
        if (i == 1 || i == 2) {
            this.sinaAuthType = i;
        }
        return this;
    }
}
