package com.qiyukf.nimlib.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.qiyukf.basesdk.c.d;
import com.umeng.commonsdk.framework.UMModuleRegister;
import org.json.JSONObject;

public final class b extends a {

    private static class a {
        private static final b a = new b();
    }

    private b() {
        this.a = a("loc");
        this.b = a("wifi");
        this.c = a("ipc_ack");
        this.d = a("self_kill");
        String d = d();
        StringBuilder stringBuilder = new StringBuilder("read sdk config from SP, ");
        stringBuilder.append(toString());
        com.qiyukf.basesdk.a.a.a(d, stringBuilder.toString());
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private static void a(String str, boolean z) {
        d.a(f(), str, z);
    }

    private static boolean a(String str) {
        return f().getBoolean(str, true);
    }

    public static b e() {
        return a.a;
    }

    private static SharedPreferences f() {
        Context a = com.qiyukf.nimlib.b.a();
        StringBuilder stringBuilder = new StringBuilder("NIMSDK_CONFIG_STRATEGY_");
        stringBuilder.append(com.qiyukf.nimlib.b.g());
        return a.getSharedPreferences(stringBuilder.toString(), 0);
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z = false;
            StringBuilder stringBuilder;
            try {
                boolean z2;
                if (jSONObject.has("loc")) {
                    z2 = jSONObject.getBoolean("loc");
                    if (z2 != this.a) {
                        this.a = z2;
                        z = true;
                    }
                }
                if (jSONObject.has("wifi")) {
                    z2 = jSONObject.getBoolean("wifi");
                    if (z2 != this.b) {
                        this.b = z2;
                        z = true;
                    }
                }
                if (jSONObject.has("ipc_ack")) {
                    z2 = jSONObject.getBoolean("ipc_ack");
                    if (z2 != this.c) {
                        this.c = z2;
                        z = true;
                    }
                }
                if (jSONObject.has("self_kill")) {
                    boolean z3 = jSONObject.getBoolean("self_kill");
                    if (z3 != this.d) {
                        this.d = z3;
                        z = true;
                    }
                }
                String d = d();
                stringBuilder = new StringBuilder("read sdk config from lbs, ");
                stringBuilder.append(toString());
                stringBuilder.append(", changed=");
                stringBuilder.append(z);
                com.qiyukf.basesdk.a.a.a(d, stringBuilder.toString());
                if (z) {
                    a("loc", this.a);
                    a("wifi", this.b);
                    a("ipc_ack", this.c);
                    a("self_kill", this.d);
                    d = d();
                    StringBuilder stringBuilder2 = new StringBuilder("write sdk config to SP, ");
                    stringBuilder2.append(toString());
                    com.qiyukf.basesdk.a.a.a(d, stringBuilder2.toString());
                    com.qiyukf.nimlib.f.d.c();
                    com.qiyukf.basesdk.a.a.a(d(), "notify sdk config to UI...");
                }
            } catch (Throwable th) {
                String d2 = d();
                stringBuilder = new StringBuilder("read sdk config from lbs error, e=");
                stringBuilder.append(th.getMessage());
                com.qiyukf.basesdk.a.a.a(d2, stringBuilder.toString());
            }
        }
    }

    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    /* Access modifiers changed, original: final */
    public final String b() {
        return UMModuleRegister.PUSH;
    }

    public final /* bridge */ /* synthetic */ String c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
