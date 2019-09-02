package com.loc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.loc.OO00OOO.O000000o;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: ConnectionServiceManager */
public class O0O0o00 {
    public boolean O000000o = false;
    private String O00000Oo = null;
    private boolean O00000o = true;
    private Context O00000o0 = null;
    private OO00OOO O00000oO = null;
    private ServiceConnection O00000oo = null;
    private ServiceConnection O0000O0o = null;
    private ServiceConnection O0000OOo = null;
    private String O0000Oo = "com.autonavi.minimap";
    private Intent O0000Oo0 = new Intent();
    private String O0000OoO = "com.amap.api.service.AMapService";
    private String O0000Ooo = "com.autonavi.minimap.LBSConnectionService";
    private boolean O0000o = false;
    private boolean O0000o0 = false;
    private boolean O0000o00 = false;
    private boolean O0000o0O = false;
    private boolean O0000o0o = false;
    private List<Intent> O0000oO = new ArrayList();
    private boolean O0000oO0 = false;
    private boolean O0000oOO = false;

    public O0O0o00(Context context) {
        this.O00000o0 = context;
        try {
            this.O00000Oo = oOo00.O00000Oo(O0OOO0.O000000o(OO00o00.O00000oo(context).getBytes(HttpUtils.ENCODING_UTF_8), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n"));
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ConnectionServiceManager", "ConnectionServiceManager");
        }
    }

    private AMapLocationServer O000000o(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("key")) {
            return null;
        }
        byte[] O00000Oo;
        try {
            O00000Oo = O0OOO0.O00000Oo(oOo00.O00000Oo(bundle.getString("key")), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n");
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ConnectionServiceManager", "parseData part");
            O00000Oo = null;
        }
        if (bundle.containsKey("result")) {
            try {
                JSONObject jSONObject = new JSONObject(new String(O0OOO0.O000000o(O00000Oo, oOo00.O00000Oo(bundle.getString("result"))), "utf-8"));
                if (jSONObject.has("error")) {
                    String string = jSONObject.getString("error");
                    if ("invaid type".equals(string)) {
                        this.O00000o = false;
                    }
                    if ("empty appkey".equals(string)) {
                        this.O00000o = false;
                    }
                    if ("refused".equals(string)) {
                        this.O00000o = false;
                    }
                    "failed".equals(string);
                    return null;
                }
                AMapLocationServer aMapLocationServer = new AMapLocationServer("");
                aMapLocationServer.b(jSONObject);
                aMapLocationServer.setProvider("lbs");
                aMapLocationServer.setLocationType(7);
                if (AMapLocation.COORD_TYPE_WGS84.equals(aMapLocationServer.e()) && O0o0000.O000000o(aMapLocationServer.getLatitude(), aMapLocationServer.getLongitude())) {
                    DPoint O000000o = O0o00.O000000o(this.O00000o0, aMapLocationServer.getLongitude(), aMapLocationServer.getLatitude());
                    aMapLocationServer.setLatitude(O000000o.getLatitude());
                    aMapLocationServer.setLongitude(O000000o.getLongitude());
                }
                return aMapLocationServer;
            } catch (Throwable th2) {
                O0o0000.O000000o(th2, O0O0o00.class.getName(), "parseData");
            }
        }
        return null;
    }

    private void O00000oo() {
        if (OoO0o.O00000o0(this.O00000o0)) {
            Intent intent = new Intent();
            intent.putExtra(LogBuilder.KEY_APPKEY, this.O00000Oo);
            intent.setComponent(new ComponentName(this.O0000Oo, this.O0000Ooo));
            try {
                this.O0000o0 = this.O00000o0.bindService(intent, this.O0000O0o, 1);
            } catch (Throwable unused) {
            }
            if (!this.O0000o0) {
                ArrayList O0000o0 = OoO0o.O0000o0();
                if (O0000o0 != null) {
                    Iterator it = O0000o0.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!str.equals(this.O0000Ooo)) {
                            intent.setComponent(new ComponentName(this.O0000Oo, str));
                            try {
                                this.O0000o0 = this.O00000o0.bindService(intent, this.O0000O0o, 1);
                            } catch (Throwable unused2) {
                            }
                            if (this.O0000o00) {
                                break;
                            }
                        }
                    }
                }
            }
            this.O0000o = true;
        }
    }

    private AMapLocationServer O0000O0o() {
        try {
            if (!this.O00000o || !this.O0000o00) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "corse");
            bundle.putString(LogBuilder.KEY_APPKEY, this.O00000Oo);
            bundle.putInt("opensdk", 1);
            if (this.O00000oO != null) {
                this.O00000oO.O000000o(bundle);
                if (bundle.size() > 0) {
                    return O000000o(bundle);
                }
            }
            return null;
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ConnectionServiceManager", "sendCommand");
        }
    }

    public final void O000000o() {
        try {
            if (this.O00000oo != null && this.O0000o0o) {
                this.O00000o0.unbindService(this.O00000oo);
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ConnectionServiceManager", "unbindService connService");
        }
        try {
            if (this.O0000O0o != null && this.O0000o) {
                this.O00000o0.unbindService(this.O0000O0o);
            }
        } catch (Throwable th2) {
            O0o0000.O000000o(th2, "ConnectionServiceManager", "unbindService pushService");
        }
        try {
            if (this.O0000OOo != null && this.O0000oO0) {
                this.O00000o0.unbindService(this.O0000OOo);
            }
        } catch (Throwable th22) {
            O0o0000.O000000o(th22, "ConnectionServiceManager", "unbindService otherService");
        }
        if (this.O0000oO != null && this.O0000oO.size() > 0) {
            for (Intent stopService : this.O0000oO) {
                this.O00000o0.stopService(stopService);
            }
        }
        this.O00000oO = null;
        this.O00000o0 = null;
        this.O00000oO = null;
        this.O00000oo = null;
        this.O0000O0o = null;
        this.O0000OOo = null;
        this.O00000o = true;
        this.O000000o = false;
        this.O0000o00 = false;
        this.O0000o0 = false;
        this.O0000o0O = false;
        this.O0000oOO = false;
        this.O0000o0o = false;
        this.O0000o = false;
        this.O0000oO0 = false;
        this.O0000oO.clear();
        this.O0000oO = null;
    }

    public final void O00000Oo() {
        try {
            if (this.O00000oo == null) {
                this.O00000oo = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        O0O0o00.this.O000000o = true;
                        O0O0o00.this.O00000oO = O000000o.O000000o(iBinder);
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        O0O0o00.this.O000000o = false;
                        O0O0o00.this.O00000oO = null;
                    }
                };
            }
            if (this.O0000O0o == null) {
                this.O0000O0o = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                    }
                };
            }
            if (this.O0000OOo == null) {
                this.O0000OOo = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                    }
                };
            }
        } catch (Throwable th) {
            O0o0000.O000000o(th, "ConnectionServiceManager", "init");
        }
    }

    public final void O00000o() {
        if (!this.O0000oO0 && !this.O0000oOO) {
            try {
                if (OoO0o.O0000O0o(this.O00000o0)) {
                    List<O0o0> O0000oo = OoO0o.O0000oo();
                    if (O0000oo != null && O0000oo.size() > 0) {
                        for (O0o0 o0o0 : O0000oo) {
                            if (o0o0 != null) {
                                if (o0o0.O000000o()) {
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName(o0o0.O00000Oo(), o0o0.O00000o0()));
                                    if (!TextUtils.isEmpty(o0o0.O00000oO())) {
                                        intent.setAction(o0o0.O00000oO());
                                    }
                                    List O00000o = o0o0.O00000o();
                                    if (O00000o != null && O00000o.size() > 0) {
                                        for (int i = 0; i < O00000o.size(); i++) {
                                            Iterator it = ((Map) O00000o.get(i)).entrySet().iterator();
                                            if (it.hasNext()) {
                                                Entry entry = (Entry) it.next();
                                                intent.putExtra(((String) entry.getKey()).toString(), ((String) entry.getValue()).toString());
                                            }
                                        }
                                    }
                                    if (o0o0.O00000oo()) {
                                        this.O00000o0.startService(intent);
                                        this.O0000oO.add(intent);
                                    }
                                    if (this.O00000o0.bindService(intent, this.O0000OOo, 1)) {
                                        this.O0000o0O = true;
                                    }
                                }
                            }
                        }
                    }
                    this.O0000oO0 = true;
                }
            } catch (Throwable th) {
                O0o0000.O000000o(th, "ConnectionServiceManager", "bindOtherService");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035 A:{Catch:{ Throwable -> 0x0077 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0031 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x003f A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{SYNTHETIC, EDGE_INSN: B:33:0x006f->B:26:0x006f ?: BREAK  } */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006b */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public final void O00000o0() {
        /*
        r6 = this;
        r0 = r6.O0000oOO;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 1;
        r1 = r6.O00000o0;	 Catch:{ Throwable -> 0x0077 }
        r1 = com.loc.OoO0o.O00000Oo(r1);	 Catch:{ Throwable -> 0x0077 }
        if (r1 == 0) goto L_0x0071;
    L_0x000e:
        r1 = r6.O0000Oo0;	 Catch:{ Throwable -> 0x0077 }
        r2 = "appkey";
        r3 = r6.O00000Oo;	 Catch:{ Throwable -> 0x0077 }
        r1.putExtra(r2, r3);	 Catch:{ Throwable -> 0x0077 }
        r1 = r6.O0000Oo0;	 Catch:{ Throwable -> 0x0077 }
        r2 = new android.content.ComponentName;	 Catch:{ Throwable -> 0x0077 }
        r3 = r6.O0000Oo;	 Catch:{ Throwable -> 0x0077 }
        r4 = r6.O0000OoO;	 Catch:{ Throwable -> 0x0077 }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x0077 }
        r1.setComponent(r2);	 Catch:{ Throwable -> 0x0077 }
        r1 = r6.O00000o0;	 Catch:{ Throwable -> 0x0031 }
        r2 = r6.O0000Oo0;	 Catch:{ Throwable -> 0x0031 }
        r3 = r6.O00000oo;	 Catch:{ Throwable -> 0x0031 }
        r1 = r1.bindService(r2, r3, r0);	 Catch:{ Throwable -> 0x0031 }
        r6.O0000o00 = r1;	 Catch:{ Throwable -> 0x0031 }
    L_0x0031:
        r1 = r6.O0000o00;	 Catch:{ Throwable -> 0x0077 }
        if (r1 != 0) goto L_0x006f;
    L_0x0035:
        r1 = com.loc.OoO0o.O0000o00();	 Catch:{ Throwable -> 0x0077 }
        if (r1 == 0) goto L_0x006f;
    L_0x003b:
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x0077 }
    L_0x003f:
        r2 = r1.hasNext();	 Catch:{ Throwable -> 0x0077 }
        if (r2 == 0) goto L_0x006f;
    L_0x0045:
        r2 = r1.next();	 Catch:{ Throwable -> 0x0077 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x0077 }
        r3 = r6.O0000OoO;	 Catch:{ Throwable -> 0x0077 }
        r3 = r2.equals(r3);	 Catch:{ Throwable -> 0x0077 }
        if (r3 != 0) goto L_0x003f;
    L_0x0053:
        r3 = r6.O0000Oo0;	 Catch:{ Throwable -> 0x0077 }
        r4 = new android.content.ComponentName;	 Catch:{ Throwable -> 0x0077 }
        r5 = r6.O0000Oo;	 Catch:{ Throwable -> 0x0077 }
        r4.<init>(r5, r2);	 Catch:{ Throwable -> 0x0077 }
        r3.setComponent(r4);	 Catch:{ Throwable -> 0x0077 }
        r2 = r6.O00000o0;	 Catch:{ Throwable -> 0x006b }
        r3 = r6.O0000Oo0;	 Catch:{ Throwable -> 0x006b }
        r4 = r6.O00000oo;	 Catch:{ Throwable -> 0x006b }
        r2 = r2.bindService(r3, r4, r0);	 Catch:{ Throwable -> 0x006b }
        r6.O0000o00 = r2;	 Catch:{ Throwable -> 0x006b }
    L_0x006b:
        r2 = r6.O0000o00;	 Catch:{ Throwable -> 0x0077 }
        if (r2 == 0) goto L_0x003f;
    L_0x006f:
        r6.O0000o0o = r0;	 Catch:{ Throwable -> 0x0077 }
    L_0x0071:
        r6.O00000oo();	 Catch:{ Throwable -> 0x0077 }
        r6.O00000o();	 Catch:{ Throwable -> 0x0077 }
    L_0x0077:
        r6.O0000oOO = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O0O0o00.O00000o0():void");
    }

    public final AMapLocationServer O00000oO() {
        if (!OoO0o.O0000Ooo()) {
            return null;
        }
        O00000o0();
        for (int i = 4; i > 0 && !this.O000000o; i--) {
            SystemClock.sleep(500);
        }
        if (this.O000000o) {
            AMapLocationServer O0000O0o = O0000O0o();
            if (O0000O0o != null) {
                return O0000O0o;
            }
        }
        return null;
    }
}
