package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.baidu.mapapi.model.inner.Point;
import java.util.ArrayList;

public class a {
    public static double a(Point point, Point point2) {
        Bundle bundle = new Bundle();
        bundle.putDouble(INoCaptchaComponent.x1, (double) point.x);
        bundle.putDouble(INoCaptchaComponent.y1, (double) point.y);
        bundle.putDouble(INoCaptchaComponent.x2, (double) point2.x);
        bundle.putDouble(INoCaptchaComponent.y2, (double) point2.y);
        JNITools.GetDistanceByMC(bundle);
        return bundle.getDouble("distance");
    }

    public static com.baidu.mapapi.model.inner.a a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("strkey", str);
        JNITools.TransGeoStr2ComplexPt(bundle);
        com.baidu.mapapi.model.inner.a aVar = new com.baidu.mapapi.model.inner.a();
        Bundle bundle2 = bundle.getBundle("map_bound");
        if (bundle2 != null) {
            Bundle bundle3 = bundle2.getBundle("ll");
            if (bundle3 != null) {
                aVar.b = new Point((int) bundle3.getDouble("ptx"), (int) bundle3.getDouble("pty"));
            }
            bundle2 = bundle2.getBundle("ru");
            if (bundle2 != null) {
                aVar.c = new Point((int) bundle2.getDouble("ptx"), (int) bundle2.getDouble("pty"));
            }
        }
        ParcelItem[] parcelItemArr = (ParcelItem[]) bundle.getParcelableArray("poly_line");
        for (ParcelItem bundle4 : parcelItemArr) {
            if (aVar.d == null) {
                aVar.d = new ArrayList();
            }
            Bundle bundle5 = bundle4.getBundle();
            if (bundle5 != null) {
                ParcelItem[] parcelItemArr2 = (ParcelItem[]) bundle5.getParcelableArray("point_array");
                ArrayList arrayList = new ArrayList();
                for (ParcelItem bundle6 : parcelItemArr2) {
                    Bundle bundle7 = bundle6.getBundle();
                    if (bundle7 != null) {
                        arrayList.add(new Point((int) bundle7.getDouble("ptx"), (int) bundle7.getDouble("pty")));
                    }
                }
                arrayList.trimToSize();
                aVar.d.add(arrayList);
            }
        }
        aVar.d.trimToSize();
        aVar.a = (int) bundle.getDouble("type");
        return aVar;
    }

    public static String a() {
        return JNITools.GetToken();
    }

    public static void a(boolean z, int i) {
        JNITools.openLogEnable(z, i);
    }

    public static void b() {
        JNITools.initClass(new Bundle(), 0);
    }
}
