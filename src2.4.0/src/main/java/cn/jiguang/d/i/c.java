package cn.jiguang.d.i;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.d.d.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public final class c {
    private static Boolean a;

    private static Bundle a(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : hashMap.keySet()) {
            bundle.putString(str, (String) hashMap.get(str));
        }
        return bundle;
    }

    public static d a(Context context, int i, int i2, a aVar, HashMap<String, String> hashMap) {
        if (aVar == null || context == null) {
            return null;
        }
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(aVar.a, aVar.b);
        intent.setComponent(componentName);
        if (VERSION.SDK_INT >= 12) {
            intent.setFlags(32);
        }
        Bundle a = a((HashMap) hashMap);
        if (a != null) {
            intent.putExtras(a);
        }
        d dVar = new d();
        dVar.a(componentName);
        if ((i2 & 2) != 0) {
            try {
                b bVar = new b(context, i == 1);
                if (context.getApplicationContext().bindService(intent, bVar, 1)) {
                    HashMap hashMap2 = b.a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(aVar.a);
                    stringBuilder.append(aVar.b);
                    hashMap2.put(stringBuilder.toString(), new WeakReference(bVar));
                    if (i == 2) {
                        dVar.a(2, true);
                    }
                } else {
                    dVar.a(2, false);
                }
            } catch (Throwable unused) {
                dVar.a(2, false);
            }
        }
        if ((i2 & 1) != 0) {
            try {
                if (context.startService(intent) != null) {
                    dVar.a(1, true);
                } else {
                    dVar.a(1, false);
                }
            } catch (Throwable unused2) {
                dVar.a(1, false);
            }
        }
        if ((i2 & 4) != 0) {
            try {
                if (!TextUtils.isEmpty(aVar.d)) {
                    ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
                    String str = aVar.d;
                    if (!str.startsWith("content://")) {
                        StringBuilder stringBuilder2 = new StringBuilder("content://");
                        stringBuilder2.append(str);
                        str = stringBuilder2.toString();
                    }
                    String b = b(hashMap);
                    if (!TextUtils.isEmpty(b)) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(str);
                        stringBuilder3.append(b);
                        str = stringBuilder3.toString();
                    }
                    contentResolver.query(Uri.parse(str), null, null, null, null);
                    dVar.a(4, true);
                    return dVar;
                }
            } catch (Throwable unused3) {
                dVar.a(4, false);
            }
        }
        return dVar;
    }

    public static boolean a(Context context) {
        if (a == null) {
            if (context == null) {
                return true;
            }
            try {
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction("cn.jpush.android.WAKED_NOT_REPORT");
                List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                Boolean valueOf = (queryIntentServices == null || queryIntentServices.isEmpty()) ? Boolean.valueOf(true) : Boolean.valueOf(false);
                a = valueOf;
            } catch (Throwable unused) {
                return true;
            }
        }
        return a.booleanValue();
    }

    private static String b(HashMap<String, String> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        Builder builder = new Builder();
        for (String str : hashMap.keySet()) {
            builder.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return builder.toString();
    }
}
