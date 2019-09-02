package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: SerialTracker */
public class j extends a {
    private static final String a = "serial";

    public j() {
        super(a);
    }

    public String f() {
        return DeviceConfig.getSerial();
    }
}
