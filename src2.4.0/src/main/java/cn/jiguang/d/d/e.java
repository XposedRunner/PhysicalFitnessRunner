package cn.jiguang.d.d;

import cn.jiguang.e.c;
import java.net.InetAddress;
import java.net.UnknownHostException;

final class e extends Thread {
    private String a = null;
    private InetAddress b = null;

    public e(String str) {
        this.a = str;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized InetAddress a() {
        return this.b;
    }

    public final void run() {
        Throwable th;
        String str;
        String str2;
        try {
            this.b = InetAddress.getByName(this.a);
        } catch (UnknownHostException e) {
            th = e;
            str = "ConnectingHelper";
            str2 = "Unknown host exception!";
            c.a(str, str2, th);
        } catch (Throwable th2) {
            th = th2;
            str = "ConnectingHelper";
            str2 = "The failure appears to have been a lack of INTERNET !";
            c.a(str, str2, th);
        }
    }
}
