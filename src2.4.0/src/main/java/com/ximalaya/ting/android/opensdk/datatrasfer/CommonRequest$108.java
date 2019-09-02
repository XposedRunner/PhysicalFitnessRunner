package com.ximalaya.ting.android.opensdk.datatrasfer;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.util.Logger;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

class CommonRequest$108 implements Callback {
    final /* synthetic */ IDataCallBack val$callBack;

    CommonRequest$108(IDataCallBack iDataCallBack) {
        this.val$callBack = iDataCallBack;
    }

    public void onFailure(Call call, IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("authorize, request failed, error message = ");
        stringBuilder.append(iOException.getMessage());
        Logger.d("XiMaLaYaSDK", stringBuilder.toString());
        if (this.val$callBack != null) {
            String str = BaseCall.NET_ERR_CONTENT;
            if (ConstantsOpenSdk.isDebug) {
                str = iOException.getMessage();
                if (TextUtils.isEmpty(str)) {
                    str = BaseCall.NET_ERR_CONTENT;
                }
            }
            CommonRequest.delivery.postError(604, str, this.val$callBack);
        }
    }

    public void onResponse(Call call, Response response) throws IOException {
        int code = response.code();
        if (code == 302) {
            String str = response.headers().get("Location");
            if (!TextUtils.isEmpty(str)) {
                CommonRequest.delivery.postSuccess(this.val$callBack, str);
                return;
            }
            return;
        }
        CommonRequest.delivery.postError(code, response.body().string(), this.val$callBack);
    }
}
