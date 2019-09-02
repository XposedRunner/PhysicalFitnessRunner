package com.ximalaya.ting.android.opensdk.datatrasfer;

public class CommonRequest$ITokenStateChangeWrapper implements CommonRequest$ITokenStateChange {
    private long lastTokenLostedTime;
    private CommonRequest$ITokenStateChange mTokenStateChange;

    public CommonRequest$ITokenStateChangeWrapper(CommonRequest$ITokenStateChange commonRequest$ITokenStateChange) {
        this.mTokenStateChange = commonRequest$ITokenStateChange;
    }

    public boolean getTokenByRefreshAsync() {
        return this.mTokenStateChange != null ? this.mTokenStateChange.getTokenByRefreshAsync() : false;
    }

    public boolean getTokenByRefreshSync() {
        return this.mTokenStateChange != null ? this.mTokenStateChange.getTokenByRefreshSync() : false;
    }

    public void tokenLosted() {
        if (System.currentTimeMillis() - this.lastTokenLostedTime > 1000) {
            this.lastTokenLostedTime = System.currentTimeMillis();
            if (this.mTokenStateChange != null) {
                this.mTokenStateChange.tokenLosted();
            }
        }
    }
}
