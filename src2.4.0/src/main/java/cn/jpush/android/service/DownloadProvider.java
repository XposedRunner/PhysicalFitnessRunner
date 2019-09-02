package cn.jpush.android.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.a;
import cn.jiguang.d.i.c;
import cn.jiguang.d.i.f;

public class DownloadProvider extends ContentProvider {
    private static final String TAG = "DownloadProvider";

    private void init() {
        try {
            if (a.d(getContext().getApplicationContext())) {
                JCoreInterface.register(getContext());
            }
        } catch (Throwable unused) {
        }
    }

    private void report(int i, boolean z, Uri uri) {
        if (c.a(getContext())) {
            try {
                String str = "";
                String str2 = "";
                String str3 = "";
                if (uri != null) {
                    str = uri.getQueryParameter("from_package");
                    str2 = uri.getQueryParameter("from_uid");
                    str3 = uri.getQueryParameter("awake_sequence");
                }
                f.a().b().a(getContext(), i, z, str, str2, str3);
            } catch (Throwable unused) {
            }
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        init();
        return 0;
    }

    public String getType(Uri uri) {
        init();
        return cn.jiguang.d.f.a.a().a(getContext(), uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        init();
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        report(4, a.i, uri);
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        init();
        return 0;
    }
}
