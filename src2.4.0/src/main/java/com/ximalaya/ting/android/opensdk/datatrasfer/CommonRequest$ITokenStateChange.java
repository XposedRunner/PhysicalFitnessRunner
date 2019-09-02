package com.ximalaya.ting.android.opensdk.datatrasfer;

public interface CommonRequest$ITokenStateChange {
    boolean getTokenByRefreshAsync();

    boolean getTokenByRefreshSync();

    void tokenLosted();
}
