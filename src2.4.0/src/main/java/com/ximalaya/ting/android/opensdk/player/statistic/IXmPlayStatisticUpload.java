package com.ximalaya.ting.android.opensdk.player.statistic;

import com.ximalaya.ting.android.opensdk.model.history.XmPlayRecord;

public interface IXmPlayStatisticUpload {
    void release();

    void upLoadData(XmPlayRecord xmPlayRecord);
}
