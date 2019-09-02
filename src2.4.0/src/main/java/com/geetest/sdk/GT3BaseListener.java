package com.geetest.sdk;

public interface GT3BaseListener {
    void onApi1Result(String str);

    void onApi2Result(String str);

    void onButtonClick();

    void onClosed(int i);

    void onDialogReady(String str);

    void onDialogResult(String str);

    void onFailed(GT3ErrorBean gT3ErrorBean);

    void onStatistics(String str);

    void onSuccess(String str);
}
