package com.amap.api.mapcore.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jiguang.net.HttpUtils;
import com.tencent.open.SocialConstants;

/* compiled from: OfflineDBCreator */
public class O00Oo0o0 implements oO0Oo0O0 {
    private static volatile O00Oo0o0 O000000o;

    private O00Oo0o0() {
    }

    public static O00Oo0o0 O000000o() {
        if (O000000o == null) {
            synchronized (O00Oo0o0.class) {
                if (O000000o == null) {
                    O000000o = new O00Oo0o0();
                }
            }
        }
        return O000000o;
    }

    public void O000000o(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "DB", "onCreate");
                th.printStackTrace();
            }
        }
    }

    public void O000000o(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (sQLiteDatabase != null && i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
            Cursor query = sQLiteDatabase.query("update_item", null, null, null, null, null, null);
            if (query == null) {
                sQLiteDatabase.close();
                sQLiteDatabase = null;
            }
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex(SocialConstants.PARAM_URL));
                    String substring = string.substring(string.lastIndexOf(HttpUtils.PATHS_SEPARATOR) + 1);
                    substring = substring.substring(0, substring.lastIndexOf("."));
                    sQLiteDatabase.execSQL("update update_item set mPinyin=? where url =?", new String[]{substring, string});
                }
                query.close();
            }
        }
    }

    public String O00000Oo() {
        return "offlineDbV4.db";
    }

    public int O00000o0() {
        return 2;
    }
}
