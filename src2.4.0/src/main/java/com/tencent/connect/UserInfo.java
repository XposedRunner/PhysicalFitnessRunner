package com.tencent.connect;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.BaseApi.TempRequestListener;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.tauth.IUiListener;

/* compiled from: ProGuard */
public class UserInfo extends BaseApi {
    public static final String GRAPH_OPEN_ID = "oauth2.0/m_me";

    public UserInfo(Context context, QQToken qQToken) {
        super(qQToken);
    }

    public UserInfo(Context context, c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    public void getOpenId(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.b, e.a(), GRAPH_OPEN_ID, a(), Constants.HTTP_GET, new TempRequestListener(iUiListener));
    }

    public void getUserInfo(IUiListener iUiListener) {
        HttpUtils.requestAsync(this.b, e.a(), "user/get_simple_userinfo", a(), Constants.HTTP_GET, new TempRequestListener(iUiListener));
    }
}
