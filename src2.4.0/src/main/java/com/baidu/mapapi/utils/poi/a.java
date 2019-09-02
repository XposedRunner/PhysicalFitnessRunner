package com.baidu.mapapi.utils.poi;

import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.http.HttpClient.HttpStateError;
import com.baidu.platform.comapi.pano.c;

final class a implements com.baidu.platform.comapi.pano.a.a<c> {
    final /* synthetic */ Context a;

    a(Context context) {
        this.a = context;
    }

    public void a(HttpStateError httpStateError) {
        String str;
        String str2;
        switch (b.b[httpStateError.ordinal()]) {
            case 1:
                str = "baidumapsdk";
                str2 = "current network is not available";
                break;
            case 2:
                str = "baidumapsdk";
                str2 = "network inner error, please check network";
                break;
            default:
                return;
        }
        Log.d(str, str2);
    }

    public void a(c cVar) {
        if (cVar == null) {
            Log.d("baidumapsdk", "pano info is null");
            return;
        }
        String str;
        String str2;
        switch (b.a[cVar.a().ordinal()]) {
            case 1:
                str = "baidumapsdk";
                str2 = "pano uid is error, please check param poi uid";
                break;
            case 2:
                str = "baidumapsdk";
                str2 = "pano id not found for this poi point";
                break;
            case 3:
                str = "baidumapsdk";
                str2 = "please check ak for permission";
                break;
            case 4:
                if (cVar.c() != 1) {
                    str = "baidumapsdk";
                    str2 = "this point do not support for pano show";
                    break;
                }
                try {
                    BaiduMapPoiSearch.b(cVar.b(), this.a);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            default:
                return;
        }
        Log.d(str, str2);
    }
}
