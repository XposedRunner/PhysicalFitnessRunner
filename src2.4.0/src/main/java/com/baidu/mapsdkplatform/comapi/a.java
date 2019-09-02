package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.autonavi.amap.mapcore.tools.GLMapStaticValue;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck.b;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck.c;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.h;

public class a implements c {
    private static final String a = "a";
    private static a f = null;
    private static int g = -100;
    private Context b;
    private Handler c;
    private e d;
    private int e;

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        com.baidu.mapsdkplatform.comjni.tools.a.b();
    }

    private a() {
    }

    public static a a() {
        if (f == null) {
            f = new a();
        }
        return f;
    }

    private void a(Message message) {
        Intent intent;
        if (message.what != GLMapStaticValue.AM_PARAMETERNAME_SETISSTIMAP) {
            if (message.arg2 == 3) {
                this.b.sendBroadcast(new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR));
            }
            if (message.arg2 == 2 || message.arg2 == 404 || message.arg2 == 5 || message.arg2 == 8) {
                intent = new Intent(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
            } else {
                return;
            }
        } else if (message.arg1 == 0) {
            intent = new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK);
        } else {
            Intent intent2 = new Intent(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
            intent2.putExtra(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, message.arg1);
            intent2.putExtra(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, (String) message.obj);
            intent = intent2;
        }
        this.b.sendBroadcast(intent);
    }

    private void f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        if (this.b != null && this.d != null) {
            this.b.registerReceiver(this.d, intentFilter);
        }
    }

    private void g() {
        if (this.d != null && this.b != null) {
            this.b.unregisterReceiver(this.d);
        }
    }

    public void a(Context context) {
        this.b = context;
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.a == 0) {
                h.y = bVar.e;
                h.a(bVar.b, bVar.c);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Authentication Error\n");
                stringBuilder.append(bVar.toString());
                Log.e("baidumapsdk", stringBuilder.toString());
            }
            if (!(bVar.a == PermissionCheck.b || bVar.a == PermissionCheck.a || bVar.a == PermissionCheck.c)) {
                com.baidu.mapsdkplatform.comapi.util.c.a().a(bVar.f);
            }
            if (!(this.c == null || bVar.a == g)) {
                g = bVar.a;
                Message obtainMessage = this.c.obtainMessage();
                obtainMessage.what = GLMapStaticValue.AM_PARAMETERNAME_SETISSTIMAP;
                obtainMessage.arg1 = bVar.a;
                obtainMessage.obj = bVar.d;
                this.c.sendMessage(obtainMessage);
            }
        }
    }

    public void b() {
        if (this.e == 0) {
            if (this.b == null) {
                throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
            }
            this.d = new e();
            f();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.b);
        }
        this.e++;
    }

    public boolean c() {
        if (this.b == null) {
            throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
        }
        this.c = new b(this);
        h.b(this.b);
        com.baidu.mapsdkplatform.comapi.util.c.a().a(this.b);
        h.f();
        PermissionCheck.init(this.b);
        PermissionCheck.setPermissionCheckResultListener(this);
        PermissionCheck.permissionCheck();
        return true;
    }

    public void d() {
        this.e--;
        if (this.e == 0) {
            g();
            h.a();
        }
    }

    public Context e() {
        if (this.b != null) {
            return this.b;
        }
        throw new IllegalStateException("you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
    }
}
