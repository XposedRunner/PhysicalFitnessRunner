package com.tencent.bugly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;

/* compiled from: BUGLY */
public abstract class a {
    public int id;
    public String moduleName;
    public String version;
    public String versionKey;

    public abstract String[] getTables();

    public abstract void init(Context context, boolean z, BuglyStrategy buglyStrategy);

    public void onDbCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (getTables() != null) {
                for (String str : getTables()) {
                    StringBuilder stringBuilder = new StringBuilder("DROP TABLE IF EXISTS ");
                    stringBuilder.append(str);
                    sQLiteDatabase.execSQL(stringBuilder.toString());
                }
                onDbCreate(sQLiteDatabase);
            }
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
        }
    }

    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            if (getTables() != null) {
                for (String str : getTables()) {
                    StringBuilder stringBuilder = new StringBuilder("DROP TABLE IF EXISTS ");
                    stringBuilder.append(str);
                    sQLiteDatabase.execSQL(stringBuilder.toString());
                }
                onDbCreate(sQLiteDatabase);
            }
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
        }
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
    }
}
