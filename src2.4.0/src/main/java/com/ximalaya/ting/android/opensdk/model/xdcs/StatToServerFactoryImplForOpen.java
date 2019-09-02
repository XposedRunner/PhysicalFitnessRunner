package com.ximalaya.ting.android.opensdk.model.xdcs;

import com.ximalaya.ting.android.player.xdcs.IStatToServer;
import com.ximalaya.ting.android.player.xdcs.IStatToServerFactory;

public class StatToServerFactoryImplForOpen implements IStatToServerFactory {
    public IStatToServer getStatToServer() {
        return new StatToServerForOpen();
    }
}
