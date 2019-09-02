package com.baidu.mapapi.http;

import android.os.Build.VERSION;
import com.baidu.mapapi.http.HttpClient.ProtoResultCallback;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.tencent.bugly.Bugly;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncHttpClient {
    private int a = 10000;
    private int b = 10000;
    private ExecutorService c = Executors.newCachedThreadPool();

    private static abstract class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        public abstract void a();

        public void run() {
            a();
        }
    }

    static {
        if (VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", Bugly.SDK_IS_DEV);
        }
    }

    public void get(String str, ProtoResultCallback protoResultCallback) {
        if (str == null) {
            throw new IllegalArgumentException("URI cannot be null");
        }
        this.c.submit(new a(this, protoResultCallback, str));
    }

    /* Access modifiers changed, original: protected */
    public boolean isAuthorized() {
        int permissionCheck = PermissionCheck.permissionCheck();
        return permissionCheck == 0 || permissionCheck == 602 || permissionCheck == 601;
    }
}
