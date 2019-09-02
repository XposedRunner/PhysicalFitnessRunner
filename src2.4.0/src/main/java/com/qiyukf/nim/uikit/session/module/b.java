package com.qiyukf.nim.uikit.session.module;

import com.qiyukf.nimlib.sdk.msg.model.IMMessage;

public interface b {
    boolean isAllowSendMessage(boolean z);

    boolean isLongClickEnabled();

    boolean sendMessage(IMMessage iMMessage, boolean z);

    void shouldCollapseInputPanel();
}
