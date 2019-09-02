package com.baidu.mapsdkplatform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static final String a = "a";
    private static Set<Integer> d = new HashSet();
    private static List<JNIBaseMap> e = new ArrayList();
    private long b;
    private JNIBaseMap c;

    public a() {
        this.b = 0;
        this.c = null;
        this.c = new JNIBaseMap();
    }

    public static int a(long j, int i, int i2, int i3) {
        return JNIBaseMap.MapProc(j, i, i2, i3);
    }

    public static List<JNIBaseMap> b() {
        return e;
    }

    public static void b(long j, boolean z) {
        JNIBaseMap.SetMapCustomEnable(j, z);
    }

    public long a() {
        return this.b;
    }

    public long a(int i, int i2, String str) {
        return this.c.AddLayer(this.b, i, i2, str);
    }

    public String a(int i, int i2) {
        return this.c.ScrPtToGeoPoint(this.b, i, i2);
    }

    public String a(int i, int i2, int i3, int i4) {
        return this.c.GetNearlyObjID(this.b, (long) i, i2, i3, i4);
    }

    public String a(String str) {
        return this.c.OnSchcityGet(this.b, str);
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.c.setCustomTrafficColor(this.b, j, j2, j3, j4, z);
    }

    public void a(long j, boolean z) {
        this.c.ShowLayers(this.b, j, z);
    }

    public void a(Bundle bundle) {
        this.c.SetMapStatus(this.b, bundle);
    }

    public void a(String str, Bundle bundle) {
        this.c.SaveScreenToLocal(this.b, str, bundle);
    }

    public void a(boolean z) {
        this.c.ShowSatelliteMap(this.b, z);
    }

    public void a(Bundle[] bundleArr) {
        this.c.addOverlayItems(this.b, bundleArr, bundleArr.length);
    }

    public boolean a(int i) {
        this.b = e.size() == 0 ? this.c.Create() : this.c.CreateDuplicate(((JNIBaseMap) e.get(0)).a);
        this.c.a = this.b;
        e.add(this.c);
        d.add(Integer.valueOf(i));
        this.c.SetCallback(this.b, null);
        return true;
    }

    public boolean a(int i, boolean z) {
        return this.c.OnRecordReload(this.b, i, z);
    }

    public boolean a(int i, boolean z, int i2) {
        return this.c.OnRecordStart(this.b, i, z, i2);
    }

    public boolean a(long j) {
        return this.c.LayersIsShow(this.b, j);
    }

    public boolean a(long j, long j2) {
        return this.c.SwitchLayer(this.b, j, j2);
    }

    public boolean a(String str, String str2) {
        return this.c.SwitchBaseIndoorMapFloor(this.b, str, str2);
    }

    public boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return this.c.Init(this.b, str, str2, str3, str4, str5, str6, str7, i != 0 ? String.valueOf(i) : null, str8, i2, i3, i4, i5, i6, i7, i8);
    }

    public boolean a(boolean z, boolean z2) {
        return this.c.OnRecordImport(this.b, z, z2);
    }

    public int[] a(int[] iArr, int i, int i2) {
        return this.c.GetScreenBuf(this.b, iArr, i, i2);
    }

    public String b(int i, int i2) {
        return this.c.GeoPtToScrPoint(this.b, i, i2);
    }

    public void b(long j) {
        this.c.UpdateLayers(this.b, j);
    }

    public void b(Bundle bundle) {
        this.c.setMapStatusLimits(this.b, bundle);
    }

    public void b(boolean z) {
        this.c.ShowHotMap(this.b, z);
    }

    public boolean b(int i) {
        this.c.Release(this.b);
        e.remove(this.c);
        d.remove(Integer.valueOf(i));
        this.b = 0;
        return true;
    }

    public boolean b(int i, boolean z) {
        return this.c.OnRecordRemove(this.b, i, z);
    }

    public boolean b(int i, boolean z, int i2) {
        return this.c.OnRecordSuspend(this.b, i, z, i2);
    }

    public float c(Bundle bundle) {
        return this.c.GetZoomToBound(this.b, bundle);
    }

    public int c(int i) {
        return this.c.SetMapControlMode(this.b, i);
    }

    public void c() {
        this.c.OnPause(this.b);
    }

    public void c(boolean z) {
        this.c.ShowTrafficMap(this.b, z);
    }

    public boolean c(long j) {
        return this.c.cleanSDKTileDataCache(this.b, j);
    }

    public void d() {
        this.c.OnResume(this.b);
    }

    public void d(long j) {
        this.c.ClearLayer(this.b, j);
    }

    public void d(boolean z) {
        this.c.enableDrawHouseHeight(this.b, z);
    }

    public boolean d(int i) {
        return this.c.OnRecordAdd(this.b, i);
    }

    public boolean d(Bundle bundle) {
        return this.c.updateSDKTile(this.b, bundle);
    }

    public String e(int i) {
        return this.c.OnRecordGetAt(this.b, i);
    }

    public String e(long j) {
        return this.c.getCompassPosition(this.b, j);
    }

    public void e() {
        this.c.OnBackground(this.b);
    }

    public void e(boolean z) {
        this.c.ShowBaseIndoorMap(this.b, z);
    }

    public boolean e(Bundle bundle) {
        return this.c.addtileOverlay(this.b, bundle);
    }

    public void f() {
        this.c.OnForeground(this.b);
    }

    public void f(Bundle bundle) {
        this.c.addOneOverlayItem(this.b, bundle);
    }

    public void g() {
        this.c.ResetImageRes(this.b);
    }

    public void g(Bundle bundle) {
        this.c.updateOneOverlayItem(this.b, bundle);
    }

    public Bundle h() {
        return this.c.GetMapStatus(this.b);
    }

    public void h(Bundle bundle) {
        this.c.removeOneOverlayItem(this.b, bundle);
    }

    public Bundle i() {
        return this.c.getMapStatusLimits(this.b);
    }

    public Bundle j() {
        return this.c.getDrawingMapStatus(this.b);
    }

    public boolean k() {
        return this.c.GetBaiduHotMapCityInfo(this.b);
    }

    public String l() {
        return this.c.OnRecordGetAll(this.b);
    }

    public String m() {
        return this.c.OnHotcityGet(this.b);
    }

    public void n() {
        this.c.PostStatInfo(this.b);
    }

    public boolean o() {
        return this.c.isDrawHouseHeightEnable(this.b);
    }

    public void p() {
        this.c.clearHeatMapLayerCache(this.b);
    }

    public MapBaseIndoorMapInfo q() {
        JSONException e;
        String str = this.c.getfocusedBaseIndoorMapInfo(this.b);
        if (str == null) {
            return null;
        }
        String str2 = "";
        String str3 = new String();
        ArrayList arrayList = new ArrayList(1);
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optString("focusindoorid");
            try {
                str2 = jSONObject.optString("curfloor");
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("floorlist");
                    if (optJSONArray == null) {
                        return null;
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(optJSONArray.get(i).toString());
                    }
                    return new MapBaseIndoorMapInfo(str, str2, arrayList);
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    return new MapBaseIndoorMapInfo(str, str2, arrayList);
                }
            } catch (JSONException e3) {
                e = e3;
                str2 = str3;
                e.printStackTrace();
                return new MapBaseIndoorMapInfo(str, str2, arrayList);
            }
        } catch (JSONException e4) {
            e = e4;
            str = str2;
            str2 = str3;
            e.printStackTrace();
            return new MapBaseIndoorMapInfo(str, str2, arrayList);
        }
    }

    public boolean r() {
        return this.c.IsBaseIndoorMapMode(this.b);
    }

    public void s() {
        this.c.setBackgroundTransparent(this.b);
    }

    public void t() {
        this.c.resetBackgroundTransparent(this.b);
    }

    public float[] u() {
        if (this.c == null) {
            return null;
        }
        float[] fArr = new float[16];
        this.c.getProjectionMatrix(this.b, fArr, 16);
        return fArr;
    }

    public float[] v() {
        if (this.c == null) {
            return null;
        }
        float[] fArr = new float[16];
        this.c.getViewMatrix(this.b, fArr, 16);
        return fArr;
    }
}
