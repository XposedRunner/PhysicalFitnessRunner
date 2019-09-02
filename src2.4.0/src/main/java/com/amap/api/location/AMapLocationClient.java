package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import com.loc.O000OOo;
import com.loc.O0OOOOO;
import com.loc.O0o0000;
import com.loc.OO0000;
import com.loc.OO0Oo0;
import com.loc.OO0o000;
import s.h.e.l.l.C;

public class AMapLocationClient {
    Context a;
    LocationManagerBase b;

    static {
        C.i(1);
    }

    public AMapLocationClient(Context context) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AMapLocationClient", "AMapLocationClient 1");
                return;
            }
        }
        this.a = context.getApplicationContext();
        this.b = a(this.a, null);
    }

    public AMapLocationClient(Context context, Intent intent) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AMapLocationClient", "AMapLocationClient 2");
                return;
            }
        }
        this.a = context.getApplicationContext();
        this.b = a(this.a, intent);
    }

    private static LocationManagerBase a(Context context, Intent intent) {
        LocationManagerBase locationManagerBase;
        try {
            OO0Oo0 O00000Oo = O0o0000.O00000Oo();
            OO0000.O000000o(context, O00000Oo);
            boolean O00000o0 = OO0000.O00000o0(context);
            OO0000.O000000o(context);
            if (O00000o0) {
                locationManagerBase = (LocationManagerBase) O000OOo.O000000o(context, O00000Oo, OO0o000.O00000o0("IY29tLmFtYXAuYXBpLmxvY2F0aW9uLkxvY2F0aW9uTWFuYWdlcldyYXBwZXI="), O0OOOOO.class, new Class[]{Context.class, Intent.class}, new Object[]{context, intent});
            } else {
                locationManagerBase = new O0OOOOO(context, intent);
            }
        } catch (Throwable unused) {
            locationManagerBase = new O0OOOOO(context, intent);
        }
        return locationManagerBase == null ? new O0OOOOO(context, intent) : locationManagerBase;
    }

    public static native String getDeviceId(Context context);

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.a = str;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "setApiKey");
        }
    }

    public void disableBackgroundLocation(boolean z) {
        try {
            if (this.b != null) {
                this.b.disableBackgroundLocation(z);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "disableBackgroundLocation");
        }
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        try {
            if (this.b != null) {
                this.b.enableBackgroundLocation(i, notification);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "enableBackgroundLocation");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            if (this.b != null) {
                return this.b.getLastKnownLocation();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "getLastKnownLocation");
        }
        return null;
    }

    public native String getVersion();

    public boolean isStarted() {
        try {
            if (this.b != null) {
                return this.b.isStarted();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "isStarted");
        }
        return false;
    }

    public void onDestroy() {
        try {
            if (this.b != null) {
                this.b.onDestroy();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "onDestroy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            try {
                throw new IllegalArgumentException("listener参数不能为null");
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AMapLocationClient", "setLocationListener");
                return;
            }
        }
        if (this.b != null) {
            this.b.setLocationListener(aMapLocationListener);
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            try {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            } catch (Throwable th) {
                O0o0000.O000000o(th, "AMapLocationClient", "setLocationOption");
                return;
            }
        }
        if (this.b != null) {
            this.b.setLocationOption(aMapLocationClientOption);
        }
    }

    public void startAssistantLocation() {
        try {
            if (this.b != null) {
                this.b.startAssistantLocation();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "startAssistantLocation");
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            if (this.b != null) {
                this.b.startAssistantLocation(webView);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "startAssistantLocation1");
        }
    }

    public void startLocation() {
        try {
            if (this.b != null) {
                this.b.startLocation();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "startLocation");
        }
    }

    public void stopAssistantLocation() {
        try {
            if (this.b != null) {
                this.b.stopAssistantLocation();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "stopAssistantLocation");
        }
    }

    public void stopLocation() {
        try {
            if (this.b != null) {
                this.b.stopLocation();
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "stopLocation");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (this.b != null) {
                this.b.unRegisterLocationListener(aMapLocationListener);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "AMapLocationClient", "unRegisterLocationListener");
        }
    }
}
