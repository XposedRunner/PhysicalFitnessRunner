package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: OfflineMapDownloadList */
public class O00O0o0 {
    public ArrayList<OfflineMapProvince> O000000o = new ArrayList();
    private O00Oo O00000Oo;
    private Context O00000o0;

    public O00O0o0(Context context, Handler handler) {
        this.O00000o0 = context;
        this.O00000Oo = O00Oo.O000000o(context);
    }

    private void O000000o(O00Oo00 o00Oo00) {
        if (this.O00000Oo != null && o00Oo00 != null) {
            this.O00000Oo.O000000o(o00Oo00);
        }
    }

    private void O000000o(bf bfVar, OfflineMapCity offlineMapCity) {
        int O00000Oo = bfVar.O00000o0().O00000Oo();
        if (bfVar.O00000o0().equals(bfVar.O000000o)) {
            O00000Oo(bfVar.O0000ooO());
        } else {
            if (bfVar.O00000o0().equals(bfVar.O00000oo)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("saveJSONObjectToFile  CITY ");
                stringBuilder.append(bfVar.getCity());
                O00o.O000000o(stringBuilder.toString());
                O00000Oo(bfVar);
                bfVar.O0000ooO().O00000o0();
            }
            if (O000000o(bfVar.getcompleteCode(), bfVar.O00000o0().O00000Oo())) {
                O000000o(bfVar.O0000ooO());
            }
        }
        offlineMapCity.setState(O00000Oo);
        offlineMapCity.setCompleteCode(bfVar.getcompleteCode());
    }

    private void O000000o(bf bfVar, OfflineMapProvince offlineMapProvince) {
        int O00000Oo = bfVar.O00000o0().O00000Oo();
        if (O00000Oo == 6) {
            offlineMapProvince.setState(O00000Oo);
            offlineMapProvince.setCompleteCode(0);
            O00000Oo(new O00Oo00(offlineMapProvince, this.O00000o0));
            try {
                O00o.O00000Oo(offlineMapProvince.getProvinceCode(), this.O00000o0);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (O00000Oo(O00000Oo) && O000000o(offlineMapProvince)) {
            O00Oo00 o00Oo00;
            if (bfVar.getPinyin().equals(offlineMapProvince.getPinyin())) {
                offlineMapProvince.setState(O00000Oo);
                offlineMapProvince.setCompleteCode(bfVar.getcompleteCode());
                offlineMapProvince.setVersion(bfVar.getVersion());
                offlineMapProvince.setUrl(bfVar.getUrl());
                o00Oo00 = new O00Oo00(offlineMapProvince, this.O00000o0);
                o00Oo00.O000000o(bfVar.O000000o());
                o00Oo00.O00000o(bfVar.getCode());
            } else {
                offlineMapProvince.setState(O00000Oo);
                offlineMapProvince.setCompleteCode(100);
                o00Oo00 = new O00Oo00(offlineMapProvince, this.O00000o0);
            }
            o00Oo00.O00000o0();
            O000000o(o00Oo00);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("saveJSONObjectToFile  province ");
            stringBuilder.append(o00Oo00.O00000o());
            O00o.O000000o(stringBuilder.toString());
        }
    }

    private void O000000o(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
        offlineMapCity.setSize(offlineMapCity2.getSize());
        offlineMapCity.setCode(offlineMapCity2.getCode());
        offlineMapCity.setPinyin(offlineMapCity2.getPinyin());
        offlineMapCity.setJianpin(offlineMapCity2.getJianpin());
    }

    private void O000000o(OfflineMapProvince offlineMapProvince, OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
        offlineMapProvince.setSize(offlineMapProvince2.getSize());
        offlineMapProvince.setPinyin(offlineMapProvince2.getPinyin());
        offlineMapProvince.setJianpin(offlineMapProvince2.getJianpin());
    }

    private boolean O000000o(int i, int i2) {
        return i2 != 1 || i <= 2 || i >= 98;
    }

    private boolean O000000o(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator it = offlineMapProvince.getCityList().iterator();
        while (it.hasNext()) {
            if (((OfflineMapCity) it.next()).getState() != 4) {
                return false;
            }
        }
        return true;
    }

    private void O00000Oo(O00Oo00 o00Oo00) {
        if (this.O00000Oo != null) {
            this.O00000Oo.O00000Oo(o00Oo00);
        }
    }

    private void O00000Oo(bf bfVar) {
        File[] listFiles = new File(OOo000.O00000o0(this.O00000o0)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.exists() && file.getName().contains(bfVar.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                    file.delete();
                }
            }
        }
    }

    private boolean O00000Oo(int i) {
        return i == 4;
    }

    public OfflineMapCity O000000o(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.O000000o) {
            Iterator it = this.O000000o.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                    if (offlineMapCity.getCode().equals(str)) {
                        return offlineMapCity;
                    }
                }
            }
            return null;
        }
    }

    public ArrayList<OfflineMapProvince> O000000o() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.O000000o) {
            Iterator it = this.O000000o.iterator();
            while (it.hasNext()) {
                arrayList.add((OfflineMapProvince) it.next());
            }
        }
        return arrayList;
    }

    public void O000000o(bf bfVar) {
        String pinyin = bfVar.getPinyin();
        synchronized (this.O000000o) {
            Iterator it = this.O000000o.iterator();
            loop0:
            while (it.hasNext()) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
                if (offlineMapProvince != null) {
                    for (OfflineMapCity offlineMapCity : offlineMapProvince.getCityList()) {
                        if (offlineMapCity.getPinyin().trim().equals(pinyin.trim())) {
                            O000000o(bfVar, offlineMapCity);
                            O000000o(bfVar, offlineMapProvince);
                            break loop0;
                        }
                    }
                    continue;
                }
            }
        }
    }

    public void O000000o(List<OfflineMapProvince> list) {
        synchronized (this.O000000o) {
            if (this.O000000o.size() > 0) {
                for (int i = 0; i < this.O000000o.size(); i++) {
                    OfflineMapProvince offlineMapProvince = (OfflineMapProvince) this.O000000o.get(i);
                    for (OfflineMapProvince offlineMapProvince2 : list) {
                        if (offlineMapProvince.getPinyin().equals(offlineMapProvince2.getPinyin())) {
                            break;
                        } else if ((offlineMapProvince.getPinyin().equals("quanguogaiyaotu") || offlineMapProvince.getProvinceCode().equals("000001") || offlineMapProvince.getProvinceCode().equals("100000")) && offlineMapProvince2.getPinyin().equals("quanguogaiyaotu")) {
                            break;
                        }
                    }
                    OfflineMapProvince offlineMapProvince22 = null;
                    if (offlineMapProvince22 != null) {
                        O000000o(offlineMapProvince, offlineMapProvince22);
                        ArrayList cityList = offlineMapProvince.getCityList();
                        ArrayList cityList2 = offlineMapProvince22.getCityList();
                        for (int i2 = 0; i2 < cityList.size(); i2++) {
                            OfflineMapCity offlineMapCity;
                            OfflineMapCity offlineMapCity2 = (OfflineMapCity) cityList.get(i2);
                            Iterator it = cityList2.iterator();
                            while (it.hasNext()) {
                                offlineMapCity = (OfflineMapCity) it.next();
                                if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                                    break;
                                }
                            }
                            offlineMapCity = null;
                            if (offlineMapCity != null) {
                                O000000o(offlineMapCity2, offlineMapCity);
                            }
                        }
                    }
                }
            } else {
                for (OfflineMapProvince add : list) {
                    this.O000000o.add(add);
                }
            }
        }
    }

    public boolean O000000o(int i) {
        return i == 0 || i == 2 || i == 3 || i == 1 || i == 102 || i == 101 || i == 103 || i == -1;
    }

    public OfflineMapCity O00000Oo(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.O000000o) {
            Iterator it = this.O000000o.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity offlineMapCity = (OfflineMapCity) it2.next();
                    if (offlineMapCity.getCity().trim().equalsIgnoreCase(str.trim())) {
                        return offlineMapCity;
                    }
                }
            }
            return null;
        }
    }

    public ArrayList<OfflineMapCity> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.O000000o) {
            Iterator it = this.O000000o.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((OfflineMapProvince) it.next()).getCityList().iterator();
                while (it2.hasNext()) {
                    arrayList.add((OfflineMapCity) it2.next());
                }
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> O00000o() {
        ArrayList arrayList;
        synchronized (this.O000000o) {
            arrayList = new ArrayList();
            Iterator it = this.O000000o.iterator();
            while (it.hasNext()) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
                if (offlineMapProvince != null) {
                    if (offlineMapProvince.getState() == 4 || offlineMapProvince.getState() == 7) {
                        arrayList.add(offlineMapProvince);
                    }
                }
            }
        }
        return arrayList;
    }

    public OfflineMapProvince O00000o0(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.O000000o) {
            Iterator it = this.O000000o.iterator();
            while (it.hasNext()) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
                if (offlineMapProvince.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                    return offlineMapProvince;
                }
            }
            return null;
        }
    }

    public ArrayList<OfflineMapCity> O00000o0() {
        ArrayList arrayList;
        synchronized (this.O000000o) {
            arrayList = new ArrayList();
            Iterator it = this.O000000o.iterator();
            while (it.hasNext()) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
                if (offlineMapProvince != null) {
                    for (OfflineMapCity offlineMapCity : offlineMapProvince.getCityList()) {
                        if (offlineMapCity.getState() == 4 || offlineMapCity.getState() == 7) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapCity> O00000oO() {
        ArrayList arrayList;
        synchronized (this.O000000o) {
            arrayList = new ArrayList();
            Iterator it = this.O000000o.iterator();
            while (it.hasNext()) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
                if (offlineMapProvince != null) {
                    for (OfflineMapCity offlineMapCity : offlineMapProvince.getCityList()) {
                        if (O000000o(offlineMapCity.getState())) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<OfflineMapProvince> O00000oo() {
        ArrayList arrayList;
        synchronized (this.O000000o) {
            arrayList = new ArrayList();
            Iterator it = this.O000000o.iterator();
            while (it.hasNext()) {
                OfflineMapProvince offlineMapProvince = (OfflineMapProvince) it.next();
                if (offlineMapProvince != null) {
                    if (O000000o(offlineMapProvince.getState())) {
                        arrayList.add(offlineMapProvince);
                    }
                }
            }
        }
        return arrayList;
    }

    public void O0000O0o() {
        O0000OOo();
        this.O00000Oo = null;
        this.O00000o0 = null;
    }

    public void O0000OOo() {
        if (this.O000000o != null) {
            synchronized (this.O000000o) {
                this.O000000o.clear();
            }
        }
    }
}
