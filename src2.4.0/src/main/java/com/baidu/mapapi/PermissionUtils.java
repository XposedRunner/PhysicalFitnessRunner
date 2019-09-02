package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comapi.util.c;

public class PermissionUtils {

    private static class a {
        private static final PermissionUtils a = new PermissionUtils();
    }

    private PermissionUtils() {
    }

    /* synthetic */ PermissionUtils(a aVar) {
        this();
    }

    public static PermissionUtils getInstance() {
        return a.a;
    }

    public boolean isIndoorNaviAuthorized() {
        return c.a().b();
    }
}
