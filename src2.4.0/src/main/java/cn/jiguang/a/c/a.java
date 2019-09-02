package cn.jiguang.a.c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.jiguang.a.a.c.b;
import cn.jiguang.a.a.c.k;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.b.d;
import cn.jiguang.d.h.e;
import cn.jiguang.d.i.f;
import cn.jiguang.d.i.h;
import cn.jiguang.g.i;
import cn.jiguang.net.HttpUtils;
import com.tencent.open.SocialConstants;
import com.umeng.commonsdk.framework.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String a(Context context, int i) {
        JSONObject jSONObject = null;
        if (i != 53) {
            return null;
        }
        try {
            jSONObject = new JSONObject(cn.jiguang.d.a.a.e(context));
        } catch (JSONException unused) {
        }
        if (jSONObject == null) {
            e.d().a(context);
            jSONObject = b.a(context, e.d());
        }
        try {
            e.d();
            byte c = e.c(context);
            e.d();
            Object d = e.d(context);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rom_type", c);
            if (d == null) {
                d = "";
            }
            jSONObject2.put("regid", d);
            jSONObject.put("rom_info", jSONObject2);
        } catch (JSONException unused2) {
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("cmd", i);
            jSONObject3.put(c.a, jSONObject);
        } catch (JSONException unused3) {
        }
        return jSONObject3.toString();
    }

    private static JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            try {
                return new JSONObject(cn.jiguang.d.h.a.a.b(str, ""));
            } catch (Exception unused) {
                e.printStackTrace();
                return null;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static void a(int i) {
        try {
            if (cn.jiguang.d.a.d == null) {
                cn.jiguang.e.c.c("CtrlMessageProcessor", "processCtrlReportByCmd failed because JCore.mApplicationContext is null");
            } else if (i == 9) {
                c.b(cn.jiguang.d.a.d);
            } else if (i != 44) {
                switch (i) {
                    case 4:
                        c.a(cn.jiguang.d.a.d);
                        return;
                    case 5:
                        Context context = cn.jiguang.d.a.d;
                        a(d.a().b());
                        return;
                    case 6:
                        break;
                    default:
                        return;
                }
            } else {
                k.a(cn.jiguang.d.a.d);
            }
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("processCtrlReport exception:");
            stringBuilder.append(e.getMessage());
            cn.jiguang.e.c.c("CtrlMessageProcessor", stringBuilder.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e4 A:{Catch:{ Exception -> 0x00e8 }} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b3 A:{Catch:{ Exception -> 0x00e8 }} */
    public static void a(android.content.Context r11, android.os.Handler r12, long r13, cn.jiguang.api.JResponse r15) {
        /*
        r15 = (cn.jiguang.d.e.a.c) r15;
        r13 = r15.b();
        r14 = cn.jiguang.g.i.a(r13);
        r0 = 0;
        r1 = -1;
        if (r14 != 0) goto L_0x001b;
    L_0x000e:
        r13 = a(r13);
        if (r13 == 0) goto L_0x001c;
    L_0x0014:
        r14 = "cmd";
        r14 = r13.optInt(r14, r1);
        goto L_0x001d;
    L_0x001b:
        r13 = r0;
    L_0x001c:
        r14 = r1;
    L_0x001d:
        r2 = r15.a();
        r14 = a(r11, r14);
        r4 = cn.jiguang.d.a.d.c(r0);
        r6 = cn.jiguang.d.a.a.f();
        r15 = cn.jiguang.d.a.d.a();
        r0 = new cn.jiguang.api.utils.OutputDataUtil;
        r8 = 20480; // 0x5000 float:2.8699E-41 double:1.01185E-319;
        r0.<init>(r8);
        r8 = 0;
        r0.writeU16(r8);
        r9 = 1;
        r0.writeU8(r9);
        r10 = 25;
        r0.writeU8(r10);
        r0.writeU64(r6);
        r6 = (long) r15;
        r0.writeU32(r6);
        r0.writeU64(r4);
        r0.writeU16(r8);
        r0.writeU64(r2);
        if (r14 == 0) goto L_0x005e;
    L_0x0057:
        r14 = r14.getBytes();
        r0.writeByteArrayincludeLength(r14);
    L_0x005e:
        r14 = r0.current();
        r0.writeU16At(r14, r8);
        r14 = r0.toByteArray();
        r14 = cn.jiguang.d.e.a.a.b.a(r14, r9);
        if (r14 != 0) goto L_0x0083;
    L_0x006f:
        r14 = "CtrlMessageProcessor";
        r15 = new java.lang.StringBuilder;
        r0 = "reportCtrlReceived to report received failed - ";
        r15.<init>(r0);
        r15.append(r2);
        r15 = r15.toString();
        cn.jiguang.e.c.c(r14, r15);
        goto L_0x00a5;
    L_0x0083:
        r15 = cn.jiguang.d.g.c.a();
        r15 = r15.b();
        r14 = r15.a(r14);
        if (r14 == 0) goto L_0x00a4;
    L_0x0091:
        r14 = "CtrlMessageProcessor";
        r15 = new java.lang.StringBuilder;
        r0 = "Failed to report received - ";
        r15.<init>(r0);
        r15.append(r2);
        r15 = r15.toString();
        cn.jiguang.e.c.c(r14, r15);
    L_0x00a4:
        r1 = r8;
    L_0x00a5:
        if (r1 != 0) goto L_0x00f0;
    L_0x00a7:
        if (r13 == 0) goto L_0x00f0;
    L_0x00a9:
        r14 = "cmd";
        r14 = r13.optInt(r14);	 Catch:{ Exception -> 0x00e8 }
        r15 = 9;
        if (r14 == r15) goto L_0x00e4;
    L_0x00b3:
        switch(r14) {
            case 4: goto L_0x00e0;
            case 5: goto L_0x00dc;
            case 6: goto L_0x00f0;
            default: goto L_0x00b6;
        };	 Catch:{ Exception -> 0x00e8 }
    L_0x00b6:
        switch(r14) {
            case 21: goto L_0x00f0;
            case 22: goto L_0x00f0;
            default: goto L_0x00b9;
        };	 Catch:{ Exception -> 0x00e8 }
    L_0x00b9:
        switch(r14) {
            case 44: goto L_0x00d8;
            case 45: goto L_0x00d4;
            default: goto L_0x00bc;
        };	 Catch:{ Exception -> 0x00e8 }
    L_0x00bc:
        switch(r14) {
            case 50: goto L_0x00d0;
            case 51: goto L_0x00cc;
            case 52: goto L_0x00c8;
            case 53: goto L_0x00f0;
            case 54: goto L_0x00c4;
            case 55: goto L_0x00c0;
            default: goto L_0x00bf;
        };	 Catch:{ Exception -> 0x00e8 }
    L_0x00bf:
        return;
    L_0x00c0:
        b(r11, r13);	 Catch:{ Exception -> 0x00e8 }
        return;
    L_0x00c4:
        a(r11, r13);	 Catch:{ Exception -> 0x00e8 }
        return;
    L_0x00c8:
        f(r11, r13);	 Catch:{ Exception -> 0x00e8 }
        return;
    L_0x00cc:
        e(r11, r13);	 Catch:{ Exception -> 0x00e8 }
        return;
    L_0x00d0:
        d(r11, r13);	 Catch:{ Exception -> 0x00e8 }
        return;
    L_0x00d4:
        c(r11, r13);	 Catch:{ Exception -> 0x00e8 }
        return;
    L_0x00d8:
        cn.jiguang.a.a.c.k.a(r11);	 Catch:{ Exception -> 0x00e8 }
        return;
    L_0x00dc:
        a(r11, r12, r13);	 Catch:{ Exception -> 0x00e8 }
        return;
    L_0x00e0:
        cn.jiguang.a.c.c.a(r11);	 Catch:{ Exception -> 0x00e8 }
        return;
    L_0x00e4:
        cn.jiguang.a.c.c.b(r11);	 Catch:{ Exception -> 0x00e8 }
        return;
    L_0x00e8:
        r11 = move-exception;
        r12 = "CtrlMessageProcessor";
        r13 = "unexpected!";
        cn.jiguang.e.c.b(r12, r13, r11);
    L_0x00f0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.c.a.a(android.content.Context, android.os.Handler, long, cn.jiguang.api.JResponse):void");
    }

    private static void a(Context context, Handler handler, JSONObject jSONObject) {
        try {
            jSONObject = jSONObject.getJSONObject(c.a);
            if (jSONObject.optBoolean("disable")) {
                cn.jiguang.e.c.a("CtrlMessageProcessor", "lbs disabled...");
                cn.jiguang.a.b.a.a(context, false);
                return;
            }
            cn.jiguang.e.c.a("CtrlMessageProcessor", "lbs enabled...");
            cn.jiguang.a.b.a.a(context, true);
            cn.jiguang.a.b.a.b(context, true);
            long optLong = jSONObject.optLong("frequency", 0);
            cn.jiguang.d.a.d.a(context, "report_location_frequency", Long.valueOf(optLong > 0 ? optLong * 1000 : cn.jiguang.a.b.a.a(context)));
            a(handler);
        } catch (JSONException e) {
            cn.jiguang.e.c.a("CtrlMessageProcessor", "unexpected! has wrong with JSONException", e);
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject.has(c.a)) {
                jSONObject = jSONObject.getJSONObject(c.a);
            }
            long j = jSONObject.getLong("interval");
            if (j < 0) {
                cn.jiguang.d.a.d.a(context, "app_running_collect_enable", Boolean.valueOf(false));
                return;
            }
            int optInt = jSONObject.optInt("app_type", 0);
            int optInt2 = jSONObject.optInt("process_type", 0);
            if (j > 0) {
                cn.jiguang.d.a.d.a(context, new cn.jiguang.g.b.a().a("app_running_collect_enable", Boolean.valueOf(true)).a("app_running_collect_interval", Long.valueOf(j)).a("app_running_collect_app_type", Integer.valueOf(optInt)).a("app_running_collect_process_type", Integer.valueOf(optInt2)));
            } else {
                cn.jiguang.g.d.a(context, optInt, optInt2);
            }
        } catch (Exception unused) {
        }
    }

    private static void a(Handler handler) {
        Message.obtain(handler, 1002).sendToTarget();
    }

    private static void b(Context context, JSONObject jSONObject) {
        try {
            int optInt = jSONObject.getJSONObject(c.a).optInt("state", -1);
            if (optInt != -1) {
                if (optInt == 0) {
                    cn.jiguang.d.a.d.b(context, optInt);
                    return;
                }
                if (optInt == 1) {
                    cn.jiguang.d.a.d.b(context, optInt);
                    cn.jiguang.d.f.a.a().a(context, JCoreInterface.getUid());
                    cn.jiguang.d.f.a.a(context, context.getPackageName());
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void c(Context context, JSONObject jSONObject) {
        try {
            long optLong = jSONObject.getJSONObject(c.a).optLong("interval", 0);
            if (optLong > 0 && optLong <= cn.jiguang.a.b.a.a(context) / 1000) {
                cn.jiguang.d.a.d.a(context, "location_collect_frequency", Long.valueOf(optLong * 1000));
            }
        } catch (JSONException e) {
            cn.jiguang.e.c.a("CtrlMessageProcessor", "unexpected! has wrong with JSONException", e);
        }
    }

    private static void d(Context context, JSONObject jSONObject) {
        try {
            jSONObject = jSONObject.getJSONObject(c.a);
            int optInt = jSONObject.optInt("type");
            h c = f.a().c();
            String optString;
            String optString2;
            cn.jiguang.d.d.a aVar;
            switch (optInt) {
                case 1:
                    optString = jSONObject.optString("pkgName");
                    optString2 = jSONObject.optString("serviceName");
                    aVar = new cn.jiguang.d.d.a();
                    aVar.a = optString;
                    aVar.b = optString2;
                    c.a(context, aVar);
                    return;
                case 2:
                    optString = jSONObject.optString("pkgName");
                    optString2 = jSONObject.optString("serviceName");
                    aVar = new cn.jiguang.d.d.a();
                    aVar.a = optString;
                    aVar.b = optString2;
                    c.b(context, aVar);
                    return;
                default:
                    return;
            }
        } catch (Throwable unused) {
        }
    }

    private static void e(Context context, JSONObject jSONObject) {
        try {
            jSONObject = jSONObject.getJSONObject(c.a);
            int i = 0;
            boolean optBoolean = jSONObject.optBoolean("uploadnumber", false);
            String optString = jSONObject.optString("version", "");
            String optString2 = jSONObject.optString("app_id", "");
            String optString3 = jSONObject.optString("app_secret", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("carriers");
            if (optJSONArray != null) {
                while (i < optJSONArray.length()) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        String optString4 = jSONObject2.optString("carrier", "");
                        String optString5 = jSONObject2.optString(SocialConstants.PARAM_URL, "");
                        if (!(i.a(optString4) || i.a(optString5))) {
                            StringBuilder stringBuilder;
                            int a = cn.jiguang.a.a.c.i.a(optString4);
                            if (!optString5.startsWith("http://")) {
                                stringBuilder = new StringBuilder("http://");
                                stringBuilder.append(optString5);
                                optString5 = stringBuilder.toString();
                            }
                            if (!optString5.endsWith(HttpUtils.PATHS_SEPARATOR)) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(optString5);
                                stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
                                optString5 = stringBuilder.toString();
                            }
                            if (a != -1 && a >= 0) {
                                if (a < 3) {
                                    stringBuilder = new StringBuilder("number_url");
                                    stringBuilder.append(a);
                                    cn.jiguang.d.a.a.a(context, stringBuilder.toString(), optString5);
                                }
                            }
                        }
                    }
                    i++;
                }
            }
            if (!i.a(optString)) {
                cn.jiguang.d.a.a.a(context, "number_version", optString);
            }
            if (i.a(optString2)) {
                cn.jiguang.d.a.a.a(context, "number_appid", optString2);
            }
            if (i.a(optString3)) {
                cn.jiguang.d.a.a.a(context, "number_appsecret", optString3);
            }
            if (optBoolean) {
                cn.jiguang.a.b.a.c(context, true);
                if (!cn.jiguang.g.a.e(context).toUpperCase().startsWith("WIFI")) {
                    cn.jiguang.a.a.c.i.a(context);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void f(Context context, JSONObject jSONObject) {
        try {
            jSONObject = jSONObject.getJSONObject(c.a);
            boolean optBoolean = jSONObject.optBoolean("disable");
            long j = 0;
            if (!optBoolean && jSONObject.has("frequency")) {
                j = jSONObject.optLong("frequency", 0);
            }
            cn.jiguang.d.a.d.a(context, "arpinfo_report_enable", Boolean.valueOf(optBoolean ^ 1));
            cn.jiguang.d.a.d.a(context, "report_arpinfo_frequency", Long.valueOf(j * 1000));
            if (!optBoolean) {
                try {
                    cn.jiguang.a.a.a.c.a(context);
                } catch (Throwable unused) {
                }
            }
        } catch (JSONException e) {
            cn.jiguang.e.c.a("CtrlMessageProcessor", "unexpected! has wrong with JSONException", e);
        }
    }
}
