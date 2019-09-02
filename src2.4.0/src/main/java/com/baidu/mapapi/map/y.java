package com.baidu.mapapi.map;

import android.view.View;
import android.view.View.OnClickListener;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.mapsdkplatform.comapi.map.ab;

class y implements OnClickListener {
    final /* synthetic */ WearMapView a;

    y(WearMapView wearMapView) {
        this.a = wearMapView;
    }

    public void onClick(View view) {
        ab E = this.a.e.a().E();
        E.a += 1.0f;
        this.a.e.a().a(E, (int) SecExceptionCode.SEC_ERROR_STA_ENC);
    }
}
