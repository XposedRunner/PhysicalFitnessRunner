package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.loc.O0o0000;
import com.loc.OO0O0o0;

public class UmidtokenInfo {
    static Handler a = new Handler();
    static String b = null;
    static boolean c = true;
    private static AMapLocationClient d = null;
    private static long e = 30000;

    static class a implements AMapLocationListener {
        a() {
        }

        public final void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.d != null) {
                    UmidtokenInfo.a.removeCallbacksAndMessages(null);
                    UmidtokenInfo.d.onDestroy();
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return b;
    }

    public static void setLocAble(boolean z) {
        c = z;
    }

    public static synchronized void setUmidtoken(Context context, String str) {
        synchronized (UmidtokenInfo.class) {
            try {
                b = str;
                OO0O0o0.O000000o(str);
                if (d == null && c) {
                    a aVar = new a();
                    d = new AMapLocationClient(context);
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    d.setLocationOption(aMapLocationClientOption);
                    d.setLocationListener(aVar);
                    d.startLocation();
                    a.postDelayed(new Runnable() {
                        public final void run() {
                            try {
                                if (UmidtokenInfo.d != null) {
                                    UmidtokenInfo.d.onDestroy();
                                }
                            } catch (Throwable th) {
                                O0o0000.O000000o(th, "UmidListener", "postDelayed");
                            }
                        }
                    }, StatisticConfig.MIN_UPLOAD_INTERVAL);
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "UmidListener", "setUmidtoken");
            }
        }
    }
}
