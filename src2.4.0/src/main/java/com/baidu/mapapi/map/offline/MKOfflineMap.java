package com.baidu.mapapi.map.offline;

import com.baidu.mapsdkplatform.comapi.map.i;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.u;
import java.util.ArrayList;
import java.util.Iterator;

public class MKOfflineMap {
    public static final int TYPE_DOWNLOAD_UPDATE = 0;
    public static final int TYPE_NETWORK_ERROR = 2;
    public static final int TYPE_NEW_OFFLINE = 6;
    public static final int TYPE_VER_UPDATE = 4;
    private static final String a = "MKOfflineMap";
    private r b;
    private MKOfflineMapListener c;

    public void destroy() {
        this.b.d(0);
        this.b.b(null);
        this.b.b();
        i.b();
    }

    public ArrayList<MKOLUpdateElement> getAllUpdateInfo() {
        ArrayList e = this.b.e();
        if (e == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = e.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getUpdatElementFromLocalMapElement(((u) it.next()).a()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getHotCityList() {
        ArrayList c = this.b.c();
        if (c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = c.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo((q) it.next()));
        }
        return arrayList;
    }

    public ArrayList<MKOLSearchRecord> getOfflineCityList() {
        ArrayList d = this.b.d();
        if (d == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = d.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo((q) it.next()));
        }
        return arrayList;
    }

    public MKOLUpdateElement getUpdateInfo(int i) {
        u g = this.b.g(i);
        return g == null ? null : OfflineMapUtil.getUpdatElementFromLocalMapElement(g.a());
    }

    @Deprecated
    public int importOfflineData() {
        return importOfflineData(false);
    }

    @Deprecated
    public int importOfflineData(boolean z) {
        ArrayList e = this.b.e();
        int i = 0;
        if (e != null) {
            i = e.size();
        }
        int i2 = i;
        this.b.a(z, true);
        ArrayList e2 = this.b.e();
        if (e2 != null) {
            i = e2.size();
        }
        return i - i2;
    }

    public boolean init(MKOfflineMapListener mKOfflineMapListener) {
        i.a();
        this.b = r.a();
        if (this.b == null) {
            return false;
        }
        this.b.a(new a(this));
        this.c = mKOfflineMapListener;
        return true;
    }

    public boolean pause(int i) {
        return this.b.c(i);
    }

    public boolean remove(int i) {
        return this.b.e(i);
    }

    public ArrayList<MKOLSearchRecord> searchCity(String str) {
        ArrayList a = this.b.a(str);
        if (a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            arrayList.add(OfflineMapUtil.getSearchRecordFromLocalCityInfo((q) it.next()));
        }
        return arrayList;
    }

    public boolean start(int i) {
        if (this.b == null) {
            return false;
        }
        if (this.b.e() != null) {
            Iterator it = this.b.e().iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                if (uVar.a.a == i) {
                    return (uVar.a.j || uVar.a.l == 2 || uVar.a.l == 3 || uVar.a.l == 6) ? this.b.b(i) : false;
                }
            }
        }
        return this.b.a(i);
    }

    public boolean update(int i) {
        if (!(this.b == null || this.b.e() == null)) {
            Iterator it = this.b.e().iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                if (uVar.a.a == i) {
                    if (uVar.a.j) {
                        return this.b.f(i);
                    }
                }
            }
        }
        return false;
    }
}
