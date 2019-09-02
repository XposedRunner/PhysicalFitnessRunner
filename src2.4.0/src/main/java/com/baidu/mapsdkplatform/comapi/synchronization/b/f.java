package com.baidu.mapsdkplatform.comapi.synchronization.b;

import cn.jiguang.net.HttpUtils;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.mapsdkplatform.comapi.synchronization.d.a;
import com.baidu.mapsdkplatform.comapi.synchronization.d.c;
import com.baidu.mapsdkplatform.comapi.synchronization.d.d;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;

public class f {
    private static final String a = "f";
    private static boolean c = true;
    private static int d = 1;
    private d b = new d();

    public f(HistoryTraceQueryOptions historyTraceQueryOptions) {
        a(historyTraceQueryOptions);
    }

    public static void a(int i) {
        d = i;
    }

    private void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        d dVar;
        String str;
        String str2;
        this.b.a("order_id", b(historyTraceQueryOptions));
        this.b.a("original_order_id", historyTraceQueryOptions.getOrderId().toLowerCase());
        this.b.a("company", historyTraceQueryOptions.getUserId());
        this.b.a("order_attr", historyTraceQueryOptions.getDriverId());
        this.b.a("track_status", String.valueOf(historyTraceQueryOptions.getQueryOrderState()));
        this.b.a("status", String.valueOf(historyTraceQueryOptions.getCurrentOrderState()));
        if (CoordType.BD09LL != SDKInitializer.getCoordType() && CoordType.GCJ02 == SDKInitializer.getCoordType()) {
            dVar = this.b;
            str = "coord_type";
            str2 = CoordinateType.GCJ02;
        } else {
            dVar = this.b;
            str = "coord_type";
            str2 = "bd09ll";
        }
        dVar.a(str, str2);
        this.b.a("page_index", String.valueOf(d));
        d = 1;
        this.b.a("page_size", "5000");
        this.b.a("is_processed", "1");
        b();
    }

    private String b(HistoryTraceQueryOptions historyTraceQueryOptions) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(historyTraceQueryOptions.getUserId().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append(historyTraceQueryOptions.getOrderId().toLowerCase());
        stringBuffer.append("-");
        stringBuffer.append("9sc87244121ip32590fq234mn6641tx7".toLowerCase());
        String a = c.a(stringBuffer.toString());
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The orderId = ");
        stringBuilder.append(stringBuffer.toString());
        stringBuilder.append("; result = ");
        stringBuilder.append(a);
        a.a(str, stringBuilder.toString());
        return a;
    }

    private void b() {
        String authToken = SyncSysInfo.getAuthToken();
        if (authToken == null) {
            a.b(a, "Token is null, permission check again");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                String str = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Permission check result is: ");
                stringBuilder.append(permissionCheck);
                a.b(str, stringBuilder.toString());
                return;
            }
            authToken = SyncSysInfo.getAuthToken();
        }
        this.b.a("token", authToken);
    }

    private String c() {
        return c ? g.a() : g.b();
    }

    public String a() {
        StringBuffer stringBuffer = new StringBuffer(this.b.a());
        stringBuffer.append(SyncSysInfo.getPhoneInfo());
        String signMD5String = AppMD5.getSignMD5String(stringBuffer.toString());
        stringBuffer.append("&sign=");
        stringBuffer.append(signMD5String);
        StringBuffer stringBuffer2 = new StringBuffer(c());
        stringBuffer2.append(HttpUtils.URL_AND_PARA_SEPARATOR);
        stringBuffer2.append(stringBuffer);
        return stringBuffer2.toString();
    }
}
