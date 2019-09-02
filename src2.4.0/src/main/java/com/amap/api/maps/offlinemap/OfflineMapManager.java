package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.mapcore.util.O00O0O0o;
import com.amap.api.mapcore.util.O00O0O0o.O000000o;
import com.amap.api.mapcore.util.O00O0o0;
import com.amap.api.mapcore.util.OOo000;
import com.amap.api.mapcore.util.bf;
import com.amap.api.mapcore.util.o0OO00OO;
import com.amap.api.mapcore.util.ooOOOOoo;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;
import java.util.Iterator;

public final class OfflineMapManager {
    O00O0o0 a;
    O00O0O0o b;
    private Context c;
    private OfflineMapDownloadListener d;
    private OfflineLoadedListener e;
    private Handler f = new Handler(this.c.getMainLooper());
    private Handler g = new Handler(this.c.getMainLooper());

    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, String str);

        void onDownload(int i, int i2, String str);

        void onRemove(boolean z, String str, String str2);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        a(context);
        o0OO00OO.O000000o().O000000o(this.c);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        try {
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a() throws AMapException {
        if (!OOo000.O00000o(this.c)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    private void a(Context context) {
        this.c = context.getApplicationContext();
        O00O0O0o.O00000Oo = false;
        this.b = O00O0O0o.O000000o(this.c);
        this.b.O000000o(new O000000o() {
            public void a() {
                if (OfflineMapManager.this.e != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        public void run() {
                            try {
                                OfflineMapManager.this.e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            public void a(final bf bfVar) {
                if (OfflineMapManager.this.d != null && bfVar != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        public void run() {
                            try {
                                OfflineMapManager.this.d.onDownload(bfVar.O00000o0().O00000Oo(), bfVar.getcompleteCode(), bfVar.getCity());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            public void b(final bf bfVar) {
                if (OfflineMapManager.this.d != null && bfVar != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        public void run() {
                            try {
                                if (!bfVar.O00000o0().equals(bfVar.O0000O0o)) {
                                    if (!bfVar.O00000o0().equals(bfVar.O000000o)) {
                                        OfflineMapManager.this.d.onCheckUpdate(false, bfVar.getCity());
                                        return;
                                    }
                                }
                                OfflineMapManager.this.d.onCheckUpdate(true, bfVar.getCity());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            public void c(final bf bfVar) {
                if (OfflineMapManager.this.d != null && bfVar != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        public void run() {
                            try {
                                if (bfVar.O00000o0().equals(bfVar.O000000o)) {
                                    OfflineMapManager.this.d.onRemove(true, bfVar.getCity(), "");
                                } else {
                                    OfflineMapManager.this.d.onRemove(false, bfVar.getCity(), "");
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        try {
            this.b.O000000o();
            this.a = this.b.O00000oo;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(String str, String str2) throws AMapException {
        this.b.O000000o(str);
    }

    private void b() {
        this.d = null;
    }

    public void destroy() {
        try {
            if (this.b != null) {
                this.b.O00000oO();
            }
            b();
            if (this.f != null) {
                this.f.removeCallbacksAndMessages(null);
            }
            this.f = null;
            if (this.g != null) {
                this.g.removeCallbacksAndMessages(null);
            }
            this.g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void downloadByCityCode(String str) throws AMapException {
        try {
            this.b.O00000oO(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void downloadByCityName(String str) throws AMapException {
        try {
            this.b.O00000o(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void downloadByProvinceName(String str) throws AMapException {
        try {
            a();
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName == null) {
                throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
            }
            Iterator it = itemByProvinceName.getCityList().iterator();
            while (it.hasNext()) {
                final String city = ((OfflineMapCity) it.next()).getCity();
                this.g.post(new Runnable() {
                    public void run() {
                        try {
                            OfflineMapManager.this.b.O00000o(city);
                        } catch (AMapException e) {
                            ooOOOOoo.O00000o0(e, "OfflineMapManager", "downloadByProvinceName");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            if (th instanceof AMapException) {
                AMapException aMapException = (AMapException) th;
            } else {
                ooOOOOoo.O00000o0(th, "OfflineMapManager", "downloadByProvinceName");
            }
        }
    }

    public ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.a.O00000o0();
    }

    public ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.a.O00000o();
    }

    public ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.a.O00000oO();
    }

    public ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.a.O00000oo();
    }

    public OfflineMapCity getItemByCityCode(String str) {
        return this.a.O000000o(str);
    }

    public OfflineMapCity getItemByCityName(String str) {
        return this.a.O00000Oo(str);
    }

    public OfflineMapProvince getItemByProvinceName(String str) {
        return this.a.O00000o0(str);
    }

    public ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.a.O00000Oo();
    }

    public ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.a.O000000o();
    }

    public void pause() {
        this.b.O00000o();
    }

    public void remove(String str) {
        try {
            if (this.b.O00000Oo(str)) {
                this.b.O00000o0(str);
            } else {
                OfflineMapProvince O00000o0 = this.a.O00000o0(str);
                if (O00000o0 != null) {
                    if (O00000o0.getCityList() != null) {
                        Iterator it = O00000o0.getCityList().iterator();
                        while (it.hasNext()) {
                            final String city = ((OfflineMapCity) it.next()).getCity();
                            this.g.post(new Runnable() {
                                public void run() {
                                    OfflineMapManager.this.b.O00000o0(city);
                                }
                            });
                        }
                    }
                }
                if (this.d != null) {
                    this.d.onRemove(false, str, "没有该城市");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void restart() {
    }

    public void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.e = offlineLoadedListener;
    }

    public void stop() {
        this.b.O00000o0();
    }

    public void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        a(itemByCityCode.getCity(), "cityname");
    }

    public void updateOfflineCityByName(String str) throws AMapException {
        a(str, "cityname");
    }

    public void updateOfflineMapProvinceByName(String str) throws AMapException {
        a(str, "cityname");
    }
}
