package com.alibaba.wireless.security.mainplugin;

import com.alibaba.wireless.security.framework.IRouterComponent;
import com.taobao.wireless.security.adapter.JNICLibrary;

public class a implements IRouterComponent {
    public Object doCommand(int i, Object... objArr) {
        return JNICLibrary.doCommandNative(i, objArr);
    }
}
