package com.ximalaya.ting.android.opensdk.auth.call;

import android.os.Bundle;
import com.ximalaya.ting.android.opensdk.auth.exception.XmlyException;

public interface IXmlyAuthListener {
    void onCancel();

    void onComplete(Bundle bundle);

    void onXmlyException(XmlyException xmlyException);
}
