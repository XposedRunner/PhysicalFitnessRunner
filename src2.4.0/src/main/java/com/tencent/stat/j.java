package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.a.i;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.k;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

class j implements Runnable {
    private Context a = null;
    private Map<String, Integer> b = null;

    public j(Context context, Map<String, Integer> map) {
        this.a = context;
        if (map != null) {
            this.b = map;
        }
    }

    private NetworkMonitor a(String str, int i) {
        int i2;
        NetworkMonitor networkMonitor = new NetworkMonitor();
        Socket socket = new Socket();
        try {
            networkMonitor.setDomain(str);
            networkMonitor.setPort(i);
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, 30000);
            networkMonitor.setMillisecondsConsume(System.currentTimeMillis() - currentTimeMillis);
            networkMonitor.setRemoteIp(inetSocketAddress.getAddress().getHostAddress());
            if (socket != null) {
                socket.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (Throwable th) {
                    StatService.i.e(th);
                }
            }
            i2 = 0;
        } catch (IOException e) {
            try {
                StatService.i.e(e);
                if (socket != null) {
                    socket.close();
                }
            } catch (Throwable th2) {
                StatService.i.e(th2);
            }
        } catch (Throwable th3) {
            StatService.i.e(th3);
        }
        networkMonitor.setStatusCode(i2);
        return networkMonitor;
        i2 = -1;
        networkMonitor.setStatusCode(i2);
        return networkMonitor;
    }

    private Map<String, Integer> a() {
        HashMap hashMap = new HashMap();
        String a = StatConfig.a("__MTA_TEST_SPEED__", null);
        if (a == null || a.trim().length() == 0) {
            return hashMap;
        }
        for (String split : a.split(";")) {
            String[] split2 = split.split(",");
            if (split2 != null && split2.length == 2) {
                String str = split2[0];
                if (!(str == null || str.trim().length() == 0)) {
                    try {
                        hashMap.put(str, Integer.valueOf(Integer.valueOf(split2[1]).intValue()));
                    } catch (NumberFormatException e) {
                        StatService.i.e(e);
                    }
                }
            }
        }
        return hashMap;
    }

    public void run() {
        try {
            if (k.h(this.a)) {
                if (this.b == null) {
                    this.b = a();
                }
                if (this.b != null) {
                    if (this.b.size() != 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (Entry entry : this.b.entrySet()) {
                            StatLogger b;
                            Object stringBuilder;
                            String str = (String) entry.getKey();
                            if (str != null) {
                                if (str.length() != 0) {
                                    if (((Integer) entry.getValue()) == null) {
                                        b = StatService.i;
                                        StringBuilder stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append("port is null for ");
                                        stringBuilder2.append(str);
                                        stringBuilder = stringBuilder2.toString();
                                        b.w(stringBuilder);
                                    } else {
                                        jSONArray.put(a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).toJSONObject());
                                    }
                                }
                            }
                            b = StatService.i;
                            stringBuilder = "empty domain name.";
                            b.w(stringBuilder);
                        }
                        if (jSONArray.length() != 0) {
                            i iVar = new i(this.a, StatService.a(this.a, false));
                            iVar.a(jSONArray.toString());
                            if (StatService.c(this.a) != null) {
                                StatService.c(this.a).post(new k(iVar));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                StatService.i.w("empty domain list.");
            }
        } catch (Throwable th) {
            StatService.i.e(th);
        }
    }
}
