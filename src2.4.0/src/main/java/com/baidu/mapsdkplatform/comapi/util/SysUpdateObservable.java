package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class SysUpdateObservable {
    private static volatile SysUpdateObservable a;
    private List<SysUpdateObserver> b;

    private SysUpdateObservable() {
        this.b = null;
        this.b = new ArrayList();
    }

    public static SysUpdateObservable getInstance() {
        if (a == null) {
            synchronized (SysUpdateObservable.class) {
                if (a == null) {
                    a = new SysUpdateObservable();
                }
            }
        }
        return a;
    }

    public void addObserver(SysUpdateObserver sysUpdateObserver) {
        this.b.add(sysUpdateObserver);
    }

    public void init() {
        for (SysUpdateObserver sysUpdateObserver : this.b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.init();
            }
        }
    }

    public void updateNetworkInfo(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkInfo(context);
            }
        }
    }

    public void updateNetworkProxy(Context context) {
        for (SysUpdateObserver sysUpdateObserver : this.b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updateNetworkProxy(context);
            }
        }
    }

    public void updatePhoneInfo() {
        for (SysUpdateObserver sysUpdateObserver : this.b) {
            if (sysUpdateObserver != null) {
                sysUpdateObserver.updatePhoneInfo();
            }
        }
    }
}
