package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import java.util.HashSet;

class CommonRequest$1 extends HashSet<String> {
    final /* synthetic */ CommonRequest this$0;

    CommonRequest$1(CommonRequest commonRequest) {
        this.this$0 = commonRequest;
        add(CommonRequest.subUrlCore(DTransferConstants.GET_ADVERT));
        add(CommonRequest.subUrlCore(DTransferConstants.VERSION_REGULAR_REL));
        add(CommonRequest.subUrlCore(DTransferConstants.PLAY_TRACK_INFO));
    }
}
