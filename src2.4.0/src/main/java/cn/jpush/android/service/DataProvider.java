package cn.jpush.android.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.g.b.d;

public class DataProvider extends ContentProvider {
    private static final String TAG = "DataProvider";

    private String getName(Uri uri) {
        CharSequence path;
        if (uri != null) {
            try {
                path = uri.getPath();
            } catch (Throwable unused) {
            }
        } else {
            path = null;
        }
        if (path == null) {
            path = null;
        } else if (path.charAt(0) == '/') {
            path = path.substring(1);
        }
        return !TextUtils.isEmpty(path) ? path : null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        String name = getName(uri);
        if (name == null) {
            return 0;
        }
        d a = d.a(getContext(), name);
        return (a != null && a.a()) ? 1 : 0;
    }

    public String getType(Uri uri) {
        int intValue;
        String name = getName(uri);
        if (name == null) {
            return null;
        }
        String queryParameter;
        try {
            queryParameter = uri.getQueryParameter("key");
            try {
                intValue = Integer.valueOf(uri.getQueryParameter("type")).intValue();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            queryParameter = null;
            intValue = -1;
            if (intValue >= 0) {
                return null;
            }
            return null;
        }
        if (intValue >= 0 || intValue > 6) {
            return null;
        }
        d a = d.a(getContext(), name);
        Object a2 = a != null ? a.a(queryParameter, intValue) : null;
        if (a2 != null) {
            return a2.toString();
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return uri;
    }

    public boolean onCreate() {
        return true;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006b */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|38) */
    /* JADX WARNING: Missing block: B:30:?, code skipped:
            android.util.Log.e(TAG, "selectionArgs should be int");
     */
    public android.database.Cursor query(android.net.Uri r8, java.lang.String[] r9, java.lang.String r10, java.lang.String[] r11, java.lang.String r12) {
        /*
        r7 = this;
        r10 = 0;
        if (r9 == 0) goto L_0x0083;
    L_0x0003:
        r12 = r9.length;
        if (r12 == 0) goto L_0x0083;
    L_0x0006:
        if (r11 == 0) goto L_0x0083;
    L_0x0008:
        r12 = r11.length;
        if (r12 == 0) goto L_0x0083;
    L_0x000b:
        r12 = r9.length;
        r0 = r11.length;
        if (r12 == r0) goto L_0x0010;
    L_0x000f:
        return r10;
    L_0x0010:
        r8 = r7.getName(r8);
        if (r8 != 0) goto L_0x0017;
    L_0x0016:
        return r10;
    L_0x0017:
        r12 = r7.getContext();	 Catch:{ Throwable -> 0x0079 }
        r8 = cn.jiguang.g.b.d.a(r12, r8);	 Catch:{ Throwable -> 0x0079 }
        if (r8 != 0) goto L_0x0022;
    L_0x0021:
        return r10;
    L_0x0022:
        r12 = r9.length;	 Catch:{ Throwable -> 0x0079 }
        r0 = new android.database.MatrixCursor;	 Catch:{ Throwable -> 0x0079 }
        r1 = 1;
        r0.<init>(r9, r1);	 Catch:{ Throwable -> 0x0079 }
        r2 = new java.lang.Object[r12];	 Catch:{ Throwable -> 0x0079 }
        r3 = 0;
        r4 = r3;
    L_0x002d:
        if (r4 >= r12) goto L_0x0075;
    L_0x002f:
        r5 = r9[r4];	 Catch:{ NumberFormatException -> 0x006b }
        r6 = r11[r4];	 Catch:{ NumberFormatException -> 0x006b }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ NumberFormatException -> 0x006b }
        r6 = r6.intValue();	 Catch:{ NumberFormatException -> 0x006b }
        r5 = r8.a(r5, r6);	 Catch:{ NumberFormatException -> 0x006b }
        r2[r4] = r5;	 Catch:{ NumberFormatException -> 0x006b }
        r5 = r2[r4];	 Catch:{ NumberFormatException -> 0x006b }
        if (r5 == 0) goto L_0x0072;
    L_0x0045:
        r5 = r2[r4];	 Catch:{ NumberFormatException -> 0x006b }
        r6 = java.lang.Boolean.valueOf(r3);	 Catch:{ NumberFormatException -> 0x006b }
        r5 = r5.equals(r6);	 Catch:{ NumberFormatException -> 0x006b }
        if (r5 == 0) goto L_0x0058;
    L_0x0051:
        r5 = java.lang.Integer.valueOf(r3);	 Catch:{ NumberFormatException -> 0x006b }
        r2[r4] = r5;	 Catch:{ NumberFormatException -> 0x006b }
        goto L_0x0072;
    L_0x0058:
        r5 = r2[r4];	 Catch:{ NumberFormatException -> 0x006b }
        r6 = java.lang.Boolean.valueOf(r1);	 Catch:{ NumberFormatException -> 0x006b }
        r5 = r5.equals(r6);	 Catch:{ NumberFormatException -> 0x006b }
        if (r5 == 0) goto L_0x0072;
    L_0x0064:
        r5 = java.lang.Integer.valueOf(r1);	 Catch:{ NumberFormatException -> 0x006b }
        r2[r4] = r5;	 Catch:{ NumberFormatException -> 0x006b }
        goto L_0x0072;
    L_0x006b:
        r5 = "DataProvider";
        r6 = "selectionArgs should be int";
        android.util.Log.e(r5, r6);	 Catch:{ Throwable -> 0x0079 }
    L_0x0072:
        r4 = r4 + 1;
        goto L_0x002d;
    L_0x0075:
        r0.addRow(r2);	 Catch:{ Throwable -> 0x0079 }
        return r0;
    L_0x0079:
        r8 = move-exception;
        r9 = "DataProvider";
        r8 = r8.getMessage();
        android.util.Log.e(r9, r8);
    L_0x0083:
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.DataProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null || contentValues.size() == 0) {
            return 0;
        }
        String name = getName(uri);
        if (name == null) {
            return 0;
        }
        d a = d.a(getContext(), name);
        if (a != null && a.a(contentValues)) {
            return contentValues.size();
        }
        return 0;
    }
}
