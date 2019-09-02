package com.tencent.open.b;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.tencent.open.a.f;

/* compiled from: ProGuard */
public class a {
    protected static final Uri a = Uri.parse("content://telephony/carriers/preferapn");

    public static String a(Context context) {
        int d = d(context);
        if (d == 2) {
            return "wifi";
        }
        if (d == 1) {
            return "cmwap";
        }
        if (d == 4) {
            return "cmnet";
        }
        if (d == 16) {
            return "uniwap";
        }
        if (d == 8) {
            return "uninet";
        }
        if (d == 64) {
            return "wap";
        }
        if (d == 32) {
            return "net";
        }
        if (d == 512) {
            return "ctwap";
        }
        if (d == 256) {
            return "ctnet";
        }
        if (d == 2048) {
            return "3gnet";
        }
        if (d == 1024) {
            return "3gwap";
        }
        String b = b(context);
        return (b == null || b.length() == 0) ? "none" : b;
    }

    public static String b(Context context) {
        StringBuilder stringBuilder;
        try {
            Cursor query = context.getContentResolver().query(a, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            String string = query.getString(query.getColumnIndex("apn"));
            if (query != null) {
                query.close();
            }
            return string;
        } catch (SecurityException e) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("getApn has exception: ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.APNUtil", stringBuilder.toString());
            return "";
        } catch (Exception e2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("getApn has exception: ");
            stringBuilder.append(e2.getMessage());
            f.e("openSDK_LOG.APNUtil", stringBuilder.toString());
            return "";
        }
    }

    public static String c(Context context) {
        try {
            Cursor query = context.getContentResolver().query(a, null, null, null, null);
            if (query == null) {
                return null;
            }
            query.moveToFirst();
            if (query.isAfterLast()) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            String string = query.getString(query.getColumnIndex("proxy"));
            if (query != null) {
                query.close();
            }
            return string;
        } catch (SecurityException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getApnProxy has exception: ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.APNUtil", stringBuilder.toString());
            return "";
        }
    }

    public static int d(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return 128;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 128;
            }
            if (activeNetworkInfo.getTypeName().toUpperCase().equals("WIFI")) {
                return 2;
            }
            String toLowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            if (toLowerCase.startsWith("cmwap")) {
                return 1;
            }
            if (!toLowerCase.startsWith("cmnet")) {
                if (!toLowerCase.startsWith("epc.tmobile.com")) {
                    if (toLowerCase.startsWith("uniwap")) {
                        return 16;
                    }
                    if (toLowerCase.startsWith("uninet")) {
                        return 8;
                    }
                    if (toLowerCase.startsWith("wap")) {
                        return 64;
                    }
                    if (toLowerCase.startsWith("net")) {
                        return 32;
                    }
                    if (toLowerCase.startsWith("ctwap")) {
                        return 512;
                    }
                    if (toLowerCase.startsWith("ctnet")) {
                        return 256;
                    }
                    if (toLowerCase.startsWith("3gwap")) {
                        return 1024;
                    }
                    if (toLowerCase.startsWith("3gnet")) {
                        return 2048;
                    }
                    if (toLowerCase.startsWith("#777")) {
                        String c = c(context);
                        return (c == null || c.length() <= 0) ? 256 : 512;
                    }
                    return 128;
                }
            }
            return 4;
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getMProxyType has exception: ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.APNUtil", stringBuilder.toString());
        }
    }

    public static String e(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "MOBILE";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : "MOBILE";
    }
}
