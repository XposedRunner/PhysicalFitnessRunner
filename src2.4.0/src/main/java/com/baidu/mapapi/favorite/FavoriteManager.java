package com.baidu.mapapi.favorite;

import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.favrite.a;
import com.baidu.mapsdkplatform.comapi.map.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FavoriteManager {
    private static FavoriteManager a;
    private static a b;

    private FavoriteManager() {
    }

    public static FavoriteManager getInstance() {
        if (a == null) {
            a = new FavoriteManager();
        }
        return a;
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        String str;
        String str2;
        if (b == null) {
            str = "baidumapsdk";
            str2 = "you may have not call init method!";
        } else if (favoritePoiInfo == null || favoritePoiInfo.c == null) {
            str = "baidumapsdk";
            str2 = "object or pt can not be null!";
        } else if (favoritePoiInfo.b == null || favoritePoiInfo.b.equals("")) {
            Log.e("baidumapsdk", "poiName can not be null or empty!");
            return -1;
        } else {
            FavSyncPoi a = a.a(favoritePoiInfo);
            int a2 = b.a(a.b, a);
            if (a2 == 1) {
                favoritePoiInfo.a = a.a;
                favoritePoiInfo.g = Long.parseLong(a.h);
            }
            return a2;
        }
        Log.e(str, str2);
        return 0;
    }

    public boolean clearAllFavPois() {
        if (b != null) {
            return b.c();
        }
        Log.e("baidumapsdk", "you may have not call init method!");
        return false;
    }

    public boolean deleteFavPoi(String str) {
        if (b != null) {
            return (str == null || str.equals("")) ? false : b.a(str);
        } else {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
    }

    public void destroy() {
        if (b != null) {
            b.b();
            b = null;
            BMapManager.destroy();
            i.b();
        }
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        String f = b.f();
        if (f == null || f.equals("")) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(f);
            if (jSONObject.optInt("favpoinum") == 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("favcontents");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        arrayList.add(a.a(jSONObject2));
                    }
                }
                return arrayList;
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public FavoritePoiInfo getFavPoi(String str) {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        } else if (str == null || str.equals("")) {
            return null;
        } else {
            FavSyncPoi b = b.b(str);
            if (b != null) {
                return a.a(b);
            }
            return null;
        }
    }

    public void init() {
        if (b == null) {
            i.a();
            BMapManager.init();
            b = a.a();
        }
    }

    /* JADX WARNING: Missing block: B:21:0x0047, code skipped:
            return false;
     */
    public boolean updateFavPoi(java.lang.String r4, com.baidu.mapapi.favorite.FavoritePoiInfo r5) {
        /*
        r3 = this;
        r0 = b;
        r1 = 0;
        if (r0 != 0) goto L_0x000d;
    L_0x0005:
        r4 = "baidumapsdk";
        r5 = "you may have not call init method!";
    L_0x0009:
        android.util.Log.e(r4, r5);
        return r1;
    L_0x000d:
        if (r4 == 0) goto L_0x0047;
    L_0x000f:
        r0 = "";
        r0 = r4.equals(r0);
        if (r0 != 0) goto L_0x0047;
    L_0x0017:
        if (r5 != 0) goto L_0x001a;
    L_0x0019:
        return r1;
    L_0x001a:
        if (r5 == 0) goto L_0x0042;
    L_0x001c:
        r0 = r5.c;
        if (r0 != 0) goto L_0x0021;
    L_0x0020:
        goto L_0x0042;
    L_0x0021:
        r0 = r5.b;
        if (r0 == 0) goto L_0x003d;
    L_0x0025:
        r0 = r5.b;
        r2 = "";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0030;
    L_0x002f:
        goto L_0x003d;
    L_0x0030:
        r5.a = r4;
        r5 = com.baidu.mapapi.favorite.a.a(r5);
        r0 = b;
        r4 = r0.b(r4, r5);
        return r4;
    L_0x003d:
        r4 = "baidumapsdk";
        r5 = "poiName can not be null or empty!";
        goto L_0x0009;
    L_0x0042:
        r4 = "baidumapsdk";
        r5 = "object or pt can not be null!";
        goto L_0x0009;
    L_0x0047:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.favorite.FavoriteManager.updateFavPoi(java.lang.String, com.baidu.mapapi.favorite.FavoritePoiInfo):boolean");
    }
}
