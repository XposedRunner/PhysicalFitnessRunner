package com.baidu.location.f;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.location.LLSInterface;
import com.baidu.location.a.h;
import com.baidu.location.a.j;
import com.baidu.location.a.l;
import com.baidu.location.a.n;
import com.baidu.location.a.p;
import com.baidu.location.a.v;
import com.baidu.location.a.w;
import com.baidu.location.a.x;
import com.baidu.location.b.d;
import com.baidu.location.b.e;
import com.baidu.location.e.i;
import com.baidu.location.f;
import com.baidu.location.g.b;
import com.baidu.location.indoor.g;
import java.lang.ref.WeakReference;

public class a extends Service implements LLSInterface {
    static a a;
    private static long f;
    Messenger b = null;
    private Looper c;
    private HandlerThread d;
    private boolean e = false;

    public static class a extends Handler {
        private final WeakReference<a> a;

        public a(Looper looper, a aVar) {
            super(looper);
            this.a = new WeakReference(aVar);
        }

        public void handleMessage(Message message) {
            a aVar = (a) this.a.get();
            if (aVar != null) {
                if (f.isServing) {
                    Object obj;
                    switch (message.what) {
                        case 11:
                            aVar.a(message);
                            break;
                        case 12:
                            aVar.b(message);
                            break;
                        case 15:
                            aVar.c(message);
                            break;
                        case 22:
                            l.c().b(message);
                            break;
                        case 28:
                            l.c().a(true, true);
                            break;
                        case 41:
                            l.c().i();
                            break;
                        case 110:
                            g.a().c();
                            break;
                        case 111:
                            g.a().d();
                            break;
                        case 112:
                            g.a().b();
                            break;
                        case 113:
                            obj = message.obj;
                            if (obj != null) {
                                g.a().a((Bundle) obj);
                                break;
                            }
                            break;
                        case 114:
                            obj = message.obj;
                            if (obj != null) {
                                g.a().b((Bundle) obj);
                                break;
                            }
                            break;
                        case SecExceptionCode.SEC_ERROR_DYN_ENC_INVALID_PARAM /*401*/:
                            try {
                                message.getData();
                                break;
                            } catch (Exception unused) {
                                break;
                            }
                        case SecExceptionCode.SEC_ERROR_DYN_ENC_GET_ENCRYPT_KEY_FAILED /*405*/:
                            byte[] byteArray = message.getData().getByteArray("errorid");
                            if (byteArray != null && byteArray.length > 0) {
                                String str = new String(byteArray);
                                break;
                            }
                        case SecExceptionCode.SEC_ERROR_DYN_ENC_INVALID_ENCRYPTED_DATA /*406*/:
                            h.a().e();
                            break;
                        case SecExceptionCode.SEC_ERROR_STA_KEY_ENC_MISMATCH_KEY_DATA /*705*/:
                            com.baidu.location.a.a.a().a(message.getData().getBoolean("foreground"));
                            break;
                    }
                }
                if (message.what == 1) {
                    aVar.c();
                }
                if (message.what == 0) {
                    aVar.b();
                }
                super.handleMessage(message);
            }
        }
    }

    public static long a() {
        return f;
    }

    private void a(Message message) {
        Log.d("baidu_location_service", "baidu location service register ...");
        com.baidu.location.a.a.a().a(message);
        com.baidu.location.d.g.a();
        e.a().d();
        p.b().c();
    }

    private void b() {
        j.a().a(f.getServiceContext());
        e.a().b();
        b.a();
        x.a().e();
        n.a().b();
        h.a().b();
        com.baidu.location.e.e.a().b();
        com.baidu.location.e.b.a().b();
        l.c().d();
        com.baidu.location.d.a.a().c();
        d.a().b();
        com.baidu.location.b.f.a().b();
        com.baidu.location.b.a.a().b();
        i.a().c();
    }

    private void b(Message message) {
        com.baidu.location.a.a.a().b(message);
    }

    private void c() {
        i.a().e();
        com.baidu.location.d.g.a().n();
        com.baidu.location.e.e.a().e();
        x.a().f();
        e.a().c();
        d.a().c();
        com.baidu.location.b.b.a().c();
        com.baidu.location.b.a.a().c();
        com.baidu.location.a.b.a().b();
        com.baidu.location.e.b.a().c();
        l.c().e();
        g.a().d();
        h.a().c();
        w.d();
        com.baidu.location.a.a.a().b();
        n.a().c();
        Log.d("baidu_location_service", "baidu location service has stoped ...");
        if (!this.e) {
            Process.killProcess(Process.myPid());
        }
    }

    private void c(Message message) {
        com.baidu.location.a.a.a().c(message);
    }

    public double getVersion() {
        return 7.619999885559082d;
    }

    public IBinder onBind(Intent intent) {
        boolean z;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            b.g = extras.getString("key");
            b.f = extras.getString("sign");
            this.e = extras.getBoolean("kill_process");
            z = extras.getBoolean("cache_exception");
        } else {
            z = false;
        }
        if (!z) {
            Thread.setDefaultUncaughtExceptionHandler(com.baidu.location.b.f.a());
        }
        return this.b.getBinder();
    }

    public void onCreate(Context context) {
        f = System.currentTimeMillis();
        this.d = v.a();
        this.c = this.d.getLooper();
        a = this.c == null ? new a(Looper.getMainLooper(), this) : new a(this.c, this);
        this.b = new Messenger(a);
        a.sendEmptyMessage(0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("baidu location service start1 ...20181201...");
        stringBuilder.append(Process.myPid());
        Log.d("baidu_location_service", stringBuilder.toString());
    }

    public void onDestroy() {
        try {
            a.sendEmptyMessage(1);
        } catch (Exception unused) {
            Log.d("baidu_location_service", "baidu location service stop exception...");
            c();
            Process.killProcess(Process.myPid());
        }
        Log.d("baidu_location_service", "baidu location service stop ...");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public void onTaskRemoved(Intent intent) {
        Log.d("baidu_location_service", "baidu location service remove task...");
    }

    public boolean onUnBind(Intent intent) {
        return false;
    }
}
