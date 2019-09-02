package com.qiyukf.nimlib.sdk;

import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;

public class SDKOptions {
    public static final SDKOptions DEFAULT = new SDKOptions();
    public String appKey;
    public String databaseEncryptKey;
    public boolean preloadAttach = true;
    public String sdkStorageRootPath;
    public StatusBarNotificationConfig statusBarNotificationConfig;
    public int thumbnailSize = 350;
    public UserInfoProvider userInfoProvider;
}
