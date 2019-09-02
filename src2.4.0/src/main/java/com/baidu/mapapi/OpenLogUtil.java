package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comjni.tools.a;

public class OpenLogUtil {
    private static ModuleName a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        a = moduleName;
        a.a(z, a.ordinal());
    }
}
