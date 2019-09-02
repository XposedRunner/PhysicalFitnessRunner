package cn.jiguang.d.f;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.SdkType;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jiguang.api.utils.ProtocolUtil;
import cn.jiguang.d.a.d;
import cn.jiguang.d.e.a.a.b;
import cn.jiguang.d.h.f;
import cn.jiguang.d.h.h;
import cn.jiguang.e.c;
import cn.jpush.android.service.DownloadProvider;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import defpackage.O0000Oo0;
import java.io.File;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static final String a;
    private static final Object e = new Object();
    private static Boolean f;
    private static Boolean g;
    private static a i;
    private int b;
    private long[] c;
    private String d;
    private volatile boolean h;

    static {
        StringBuilder stringBuilder = new StringBuilder(".jpush");
        stringBuilder.append(File.separator);
        stringBuilder.append(".shareinfo");
        stringBuilder.append(File.separator);
        a = stringBuilder.toString();
    }

    private a() {
        JCoreInterface.putSingleExecutor("share_process_executor");
    }

    private static ActivityInfo a(String str, Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("cn.jpush.android.intent.DownloadActivity");
            intent.addCategory(str);
            intent.setPackage(str);
            ActivityInfo activityInfo = context.getPackageManager().resolveActivity(intent, 0).activityInfo;
            if ((activityInfo instanceof ActivityInfo) && activityInfo.exported && activityInfo.enabled && "jpush.custom".equals(activityInfo.taskAffinity) && activityInfo.theme == 16973840) {
                return activityInfo;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static a a() {
        if (i == null) {
            synchronized (e) {
                if (i == null) {
                    i = new a();
                }
            }
        }
        return i;
    }

    private c a(String str) {
        c cVar;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            cVar = new c(this);
            try {
                long optLong = jSONObject.optLong("u");
                String optString = jSONObject.optString("ak");
                String optString2 = jSONObject.optString("pn");
                String optString3 = jSONObject.optString("ud");
                int optInt = jSONObject.optInt("idc", -1);
                int optInt2 = jSONObject.optInt("sv");
                long optLong2 = jSONObject.optLong("uct", -1);
                cVar.d = optLong;
                cVar.c = optString3;
                cVar.f = optString;
                cVar.b = optInt;
                cVar.e = optString2;
                cVar.g = optInt2;
                cVar.h = optLong2;
                return cVar;
            } catch (Throwable unused) {
                return cVar;
            }
        } catch (Throwable unused2) {
            cVar = null;
            return cVar;
        }
    }

    private static String a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".DownloadProvider");
            str = stringBuilder.toString();
            if (!str.startsWith("content://")) {
                stringBuilder = new StringBuilder("content://");
                stringBuilder.append(str);
                str = stringBuilder.toString();
            }
            Uri parse = Uri.parse(str);
            JSONObject jSONObject = new JSONObject();
            Builder buildUpon = parse.buildUpon();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("kta", str2);
            }
            if (!(hashMap == null || hashMap.isEmpty())) {
                for (Entry entry : hashMap.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
            buildUpon.appendQueryParameter("kpgt", cn.jiguang.d.h.a.a.a(jSONObject.toString()));
            return contentResolver.getType(buildUpon.build());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent != null) {
            try {
                if ("asm".equals(intent.getAction())) {
                    Bundle extras = intent.getExtras();
                    extras.putString("action", "asm");
                    JCoreInterface.sendAction(context, cn.jiguang.d.a.a, extras);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (cn.jiguang.g.a.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    File b = b(str);
                    if (b.exists()) {
                        b.delete();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private c b(Context context, String str) {
        try {
            String a = a(context, str, "asai", null);
            if (a != null) {
                if (!TextUtils.isEmpty(a) && a.length() > 10) {
                    String b = cn.jiguang.d.h.a.a.b(a, "");
                    return TextUtils.isEmpty(b) ? null : a(b);
                }
            } else if (d(context) && cn.jiguang.g.a.a(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                str = f.b(b(str));
                if (!TextUtils.isEmpty(str)) {
                    c a2 = a(cn.jiguang.d.h.a.a.b(str, ""));
                    if (a2 != null) {
                        if (!cn.jiguang.g.a.i(context, a2.e)) {
                            a(context, a2.e);
                            return null;
                        } else if (a(a2.e, context) != null) {
                            return a2;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("scanShareProcessBean error:");
            stringBuilder.append(th.getMessage());
            c.c("ShareProcessManager", stringBuilder.toString());
        }
        return null;
    }

    private static File b(String str) {
        String a = cn.jiguang.g.a.a(str);
        if (!TextUtils.isEmpty(a)) {
            str = a;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(str);
        return new File(externalStorageDirectory, stringBuilder.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0090 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d A:{Catch:{ Throwable -> 0x00ad }} */
    private java.util.List<cn.jiguang.d.f.c> b(android.content.Context r10) {
        /*
        r9 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r10.getPackageManager();	 Catch:{ Throwable -> 0x00ad }
        r2 = new android.content.Intent;	 Catch:{ Throwable -> 0x00ad }
        r2.<init>();	 Catch:{ Throwable -> 0x00ad }
        r3 = cn.jiguang.api.JCoreInterface.getDaemonAction();	 Catch:{ Throwable -> 0x00ad }
        r2.setAction(r3);	 Catch:{ Throwable -> 0x00ad }
        r3 = 0;
        r1 = r1.queryIntentServices(r2, r3);	 Catch:{ Throwable -> 0x00ad }
        if (r1 == 0) goto L_0x00ad;
    L_0x001c:
        r2 = r1.size();	 Catch:{ Throwable -> 0x00ad }
        if (r2 != 0) goto L_0x0023;
    L_0x0022:
        return r0;
    L_0x0023:
        r2 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00ad }
        r2.<init>();	 Catch:{ Throwable -> 0x00ad }
        r4 = r3;
    L_0x0029:
        r5 = r1.size();	 Catch:{ Throwable -> 0x00ad }
        if (r4 >= r5) goto L_0x0093;
    L_0x002f:
        r5 = r1.get(r4);	 Catch:{ Throwable -> 0x00ad }
        r5 = (android.content.pm.ResolveInfo) r5;	 Catch:{ Throwable -> 0x00ad }
        r5 = r5.serviceInfo;	 Catch:{ Throwable -> 0x00ad }
        r6 = r5.name;	 Catch:{ Throwable -> 0x00ad }
        r5 = r5.packageName;	 Catch:{ Throwable -> 0x00ad }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x00ad }
        if (r6 != 0) goto L_0x0090;
    L_0x0041:
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x00ad }
        if (r6 != 0) goto L_0x0090;
    L_0x0047:
        r6 = r10.getPackageName();	 Catch:{ Throwable -> 0x00ad }
        r6 = r6.equals(r5);	 Catch:{ Throwable -> 0x00ad }
        if (r6 != 0) goto L_0x0090;
    L_0x0051:
        r6 = cn.jpush.android.service.DownloadProvider.class;
        r6 = cn.jiguang.g.a.a(r10, r5, r6);	 Catch:{ Throwable -> 0x00ad }
        if (r6 == 0) goto L_0x008a;
    L_0x0059:
        r7 = r6 instanceof android.content.pm.ProviderInfo;	 Catch:{ Throwable -> 0x00ad }
        if (r7 == 0) goto L_0x008a;
    L_0x005d:
        r6 = (android.content.pm.ProviderInfo) r6;	 Catch:{ Throwable -> 0x00ad }
        r7 = r6.exported;	 Catch:{ Throwable -> 0x00ad }
        if (r7 == 0) goto L_0x008a;
    L_0x0063:
        r7 = r6.enabled;	 Catch:{ Throwable -> 0x00ad }
        if (r7 == 0) goto L_0x008a;
    L_0x0067:
        r7 = r6.authority;	 Catch:{ Throwable -> 0x00ad }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Throwable -> 0x00ad }
        if (r7 != 0) goto L_0x008a;
    L_0x006f:
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ad }
        r7.<init>();	 Catch:{ Throwable -> 0x00ad }
        r7.append(r5);	 Catch:{ Throwable -> 0x00ad }
        r8 = ".DownloadProvider";
        r7.append(r8);	 Catch:{ Throwable -> 0x00ad }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00ad }
        r6 = r6.authority;	 Catch:{ Throwable -> 0x00ad }
        r6 = android.text.TextUtils.equals(r7, r6);	 Catch:{ Throwable -> 0x00ad }
        if (r6 == 0) goto L_0x008a;
    L_0x0088:
        r6 = 1;
        goto L_0x008b;
    L_0x008a:
        r6 = r3;
    L_0x008b:
        if (r6 == 0) goto L_0x0090;
    L_0x008d:
        r2.add(r5);	 Catch:{ Throwable -> 0x00ad }
    L_0x0090:
        r4 = r4 + 1;
        goto L_0x0029;
    L_0x0093:
        r1 = r2.iterator();	 Catch:{ Throwable -> 0x00ad }
    L_0x0097:
        r2 = r1.hasNext();	 Catch:{ Throwable -> 0x00ad }
        if (r2 == 0) goto L_0x00ad;
    L_0x009d:
        r2 = r1.next();	 Catch:{ Throwable -> 0x00ad }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x00ad }
        r2 = r9.b(r10, r2);	 Catch:{ Throwable -> 0x00ad }
        if (r2 == 0) goto L_0x0097;
    L_0x00a9:
        r0.add(r2);	 Catch:{ Throwable -> 0x00ad }
        goto L_0x0097;
    L_0x00ad:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.d.f.a.b(android.content.Context):java.util.List");
    }

    private static String c(Context context) {
        if (context == null) {
            return "-1";
        }
        if (!e(context) || d.s(context) == 1) {
            return "-4";
        }
        if (!cn.jiguang.d.d.f.a().f()) {
            return "-7";
        }
        int v = cn.jiguang.d.a.a.v();
        if (v < 0) {
            return "-3";
        }
        long c = d.c(context);
        if (c <= 0) {
            return "-2";
        }
        String r = d.r(context);
        long t = d.t(context);
        String b = cn.jiguang.d.a.b(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("u", c);
            jSONObject.put("p", d.e(context));
            jSONObject.put("ud", r);
            jSONObject.put("ak", b);
            jSONObject.put("idc", v);
            jSONObject.put("pn", context.getPackageName());
            jSONObject.put("sv", TransportMediator.KEYCODE_MEDIA_PLAY);
            jSONObject.put("uct", t);
            return cn.jiguang.d.h.a.a.a(jSONObject.toString());
        } catch (JSONException unused) {
            return O0000Oo0.O00000oo;
        }
    }

    private static boolean d(Context context) {
        if (g == null) {
            try {
                String str = Build.MANUFACTURER;
                String toLowerCase = "Xiaomi".toLowerCase();
                if (!TextUtils.isEmpty(str) && TextUtils.equals(toLowerCase, str.toLowerCase())) {
                    Boolean valueOf = Boolean.valueOf(false);
                    g = valueOf;
                    return valueOf.booleanValue();
                }
            } catch (Throwable unused) {
            }
            g = a(context.getPackageName(), context) != null ? Boolean.valueOf(true) : Boolean.valueOf(false);
        }
        return g.booleanValue();
    }

    private static boolean e(Context context) {
        if (f == null) {
            if (context == null) {
                return true;
            }
            try {
                Boolean valueOf;
                if (cn.jiguang.g.a.a(context, JCoreInterface.getDaemonAction(), true)) {
                    ComponentInfo a = cn.jiguang.g.a.a(context, context.getPackageName(), DownloadProvider.class);
                    if (a == null) {
                        valueOf = Boolean.valueOf(false);
                        f = valueOf;
                        return valueOf.booleanValue();
                    }
                    if (a.enabled && a.exported) {
                        if (!TextUtils.isEmpty(((ProviderInfo) a).authority)) {
                            Intent intent = new Intent();
                            intent.setPackage(context.getPackageName());
                            intent.setAction("cn.jiguang.android.share.close");
                            List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                            valueOf = (queryIntentServices == null || queryIntentServices.isEmpty()) ? Boolean.valueOf(true) : Boolean.valueOf(false);
                            f = valueOf;
                        }
                    }
                    valueOf = Boolean.valueOf(false);
                    f = valueOf;
                    return valueOf.booleanValue();
                }
                valueOf = Boolean.valueOf(false);
                f = valueOf;
                return valueOf.booleanValue();
            } catch (Throwable unused) {
                return true;
            }
        }
        return f.booleanValue();
    }

    public final String a(Context context, Uri uri) {
        if (uri == null) {
            return O0000Oo0.O00000oo;
        }
        try {
            String queryParameter = uri.getQueryParameter("kpgt");
            if (TextUtils.isEmpty(queryParameter)) {
                return O0000Oo0.O00000oo;
            }
            queryParameter = cn.jiguang.d.h.a.a.b(queryParameter, "");
            if (TextUtils.isEmpty(queryParameter)) {
                return "-6";
            }
            JSONObject jSONObject = new JSONObject(queryParameter);
            queryParameter = jSONObject.optString("kta");
            if (!TextUtils.isEmpty(queryParameter)) {
                if (queryParameter.equals("asai")) {
                    return c(context);
                }
                if (queryParameter.equals("asm")) {
                    if (e(context)) {
                        if (d.s(context) != 1) {
                            Bundle bundle = new Bundle();
                            bundle.putString("action", "asm");
                            bundle.putString("data", jSONObject.toString());
                            JCoreInterface.sendAction(context, cn.jiguang.d.a.a, bundle);
                            return "0";
                        }
                    }
                    return "-4";
                } else if (queryParameter.equals("asmr")) {
                    queryParameter = jSONObject.optString("mtmmi");
                    String optString = jSONObject.optString("ktmfp");
                    String optString2 = jSONObject.optString("ktma");
                    String optString3 = jSONObject.optString("ktmr");
                    String optString4 = jSONObject.optString("ktmu");
                    String optString5 = jSONObject.optString("asmrc", "0");
                    if (optString5.equals("0") && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                        long parseLong = Long.parseLong(optString4);
                        long parseLong2 = Long.parseLong(queryParameter);
                        long parseLong3 = Long.parseLong(optString3);
                        int sid = JCoreInterface.getSid();
                        OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
                        outputDataUtil.writeU16(0);
                        outputDataUtil.writeU8(2);
                        outputDataUtil.writeU8(4);
                        outputDataUtil.writeU64(parseLong3);
                        outputDataUtil.writeU32((long) sid);
                        outputDataUtil.writeU64(parseLong);
                        outputDataUtil.writeU16(0);
                        outputDataUtil.writeU8(0);
                        outputDataUtil.writeU64(parseLong2);
                        outputDataUtil.writeByteArrayincludeLength(optString2.getBytes());
                        outputDataUtil.writeU16At(outputDataUtil.current(), 0);
                        JCoreInterface.sendData(context, cn.jiguang.d.a.a, 4, outputDataUtil.toByteArray());
                    } else if (optString5.equals("1") && !TextUtils.isEmpty(optString4)) {
                        a(context, Long.parseLong(optString4));
                    } else if (optString5.equals("3") && !TextUtils.isEmpty(optString4)) {
                        a(context, Long.parseLong(optString4));
                        a(context, optString);
                    }
                }
            }
            return O0000Oo0.O00000oo;
        } catch (Throwable unused) {
        }
    }

    public final void a(int i, int i2) {
        if (i2 == 30 && i == 0) {
            this.b = 0;
        }
    }

    public final synchronized void a(Context context) {
        if (e(context)) {
            if (d.s(context) != 1) {
                if (!cn.jiguang.d.d.f.a().f()) {
                    return;
                }
                if (!this.h) {
                    this.h = true;
                    this.b = 0;
                    JCoreInterface.execute("share_process_executor", new b(this, context), new int[0]);
                    return;
                }
                return;
            }
        }
        a(context, context.getPackageName());
    }

    public final void a(Context context, int i) {
        if (i == 30 && !this.h) {
            this.b++;
            if (this.b <= 2 && this.c != null && this.c.length > 0 && !TextUtils.isEmpty(this.d)) {
                byte[] a = b.a(JCoreInterface.getNextRid(), JCoreInterface.getSid(), d.c(context), this.d, this.c);
                cn.jiguang.d.b.d.a();
                cn.jiguang.d.b.d.a(a, SdkType.JCORE.name(), 0);
            }
        }
    }

    public final void a(Context context, long j) {
        try {
            if (!TextUtils.isEmpty(this.d)) {
                byte[] b = b.b(JCoreInterface.getNextRid(), JCoreInterface.getSid(), d.c(context), this.d, new long[]{j});
                cn.jiguang.d.b.d.a();
                cn.jiguang.d.b.d.a(b, SdkType.JCORE.name(), 0);
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(Context context, long j, byte[] bArr) {
        if (!(j == 0 || bArr == null)) {
            try {
                cn.jiguang.d.e.a.d b = cn.jiguang.d.e.a.a.a.b(bArr);
                if (b.a().a() == 3) {
                    ByteBuffer b2 = b.b();
                    b2.get();
                    long j2 = b2.getLong();
                    String tlv2 = ProtocolUtil.getTlv2(b2);
                    if (!TextUtils.isEmpty(tlv2)) {
                        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(tlv2));
                        tlv2 = lineNumberReader.readLine();
                        if (!TextUtils.isEmpty(tlv2)) {
                            String readLine = lineNumberReader.readLine();
                            if (!TextUtils.isEmpty(readLine)) {
                                if (e(context)) {
                                    if (d.s(context) != 1) {
                                        if (cn.jiguang.g.a.i(context, tlv2)) {
                                            cn.jiguang.d.e.a.a.c a;
                                            String encodeToString = Base64.encodeToString(bArr, 10);
                                            Long b3 = b.a().b();
                                            Map hashMap = new HashMap();
                                            hashMap.put("ktm", encodeToString);
                                            hashMap.put("ktp", cn.jiguang.d.h.a.a.b());
                                            hashMap.put("ktma", readLine);
                                            StringBuilder stringBuilder = new StringBuilder();
                                            stringBuilder.append(j2);
                                            hashMap.put("mtmmi", stringBuilder.toString());
                                            hashMap.put("ktmfp", context.getPackageName());
                                            StringBuilder stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append(b3);
                                            hashMap.put("ktmr", stringBuilder2.toString());
                                            encodeToString = a(context, tlv2, "asm", hashMap);
                                            if (TextUtils.isEmpty(encodeToString)) {
                                                if (d(context)) {
                                                    ActivityInfo a2 = a(tlv2, context);
                                                    if (a2 != null) {
                                                        JSONObject a3 = h.a(hashMap);
                                                        Intent intent = new Intent("asm");
                                                        intent.setComponent(new ComponentName(a2.packageName, a2.name));
                                                        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
                                                        intent.addCategory(tlv2);
                                                        intent.putExtra("data", a3.toString());
                                                        context.startActivity(intent);
                                                        lineNumberReader.close();
                                                        return;
                                                    }
                                                    a = b.a();
                                                } else {
                                                    a = b.a();
                                                }
                                            } else if (encodeToString.equals("-4")) {
                                                a = b.a();
                                            } else {
                                                encodeToString.equals("0");
                                                lineNumberReader.close();
                                                return;
                                            }
                                            a(context, a.c());
                                            lineNumberReader.close();
                                            return;
                                        }
                                        a(context, b.a().c());
                                        a(context, tlv2);
                                        return;
                                    }
                                }
                                a(context, JCoreInterface.getUid());
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(Context context, Bundle bundle) {
        if (bundle != null) {
            try {
                String string = bundle.getString("data");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    string = jSONObject.optString("ktm");
                    String optString = jSONObject.optString("ktp");
                    String optString2 = jSONObject.optString("mtmmi");
                    String optString3 = jSONObject.optString("ktmfp");
                    String optString4 = jSONObject.optString("ktma");
                    String optString5 = jSONObject.optString("ktmr");
                    if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4))) {
                        Object obj;
                        Object obj2;
                        HashMap hashMap = new HashMap();
                        hashMap.put("mtmmi", optString2);
                        hashMap.put("ktmfp", optString3);
                        hashMap.put("ktma", optString4);
                        hashMap.put("ktmr", optString5);
                        byte[] decode = Base64.decode(string, 10);
                        cn.jiguang.d.d.f.a();
                        cn.jiguang.d.e.a.d a = cn.jiguang.d.e.a.a.a.a(decode, optString);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(a.a().c());
                        hashMap.put("ktmu", stringBuilder.toString());
                        if (e(context)) {
                            if (d.s(context) != 1) {
                                if (a.a().c() != JCoreInterface.getUid()) {
                                    obj = "asmrc";
                                    obj2 = "1";
                                    hashMap.put(obj, obj2);
                                    a(context, optString3, "asmr", hashMap);
                                }
                                hashMap.put("asmrc", "0");
                                cn.jiguang.d.d.b.a();
                                cn.jiguang.d.d.b.a(context, a.a(), a.b());
                                a(context, optString3, "asmr", hashMap);
                            }
                        }
                        obj = "asmrc";
                        obj2 = "3";
                        hashMap.put(obj, obj2);
                        a(context, optString3, "asmr", hashMap);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
