package org.xutils;

import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import java.io.File;
import org.xutils.DbManager.DbOpenListener;
import org.xutils.DbManager.TableCreateListener;

public class DbManager$DaoConfig {
    private String DB_PWD = "";
    private boolean allowTransaction = true;
    private File dbDir;
    private String dbName = "xUtils.db";
    private DbOpenListener dbOpenListener;
    private DbManager$DbUpgradeListener dbUpgradeListener;
    private int dbVersion = 1;
    private TableCreateListener tableCreateListener;

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DbManager$DaoConfig dbManager$DaoConfig = (DbManager$DaoConfig) obj;
        if (!this.dbName.equals(dbManager$DaoConfig.dbName) || (this.dbDir != null ? !this.dbDir.equals(dbManager$DaoConfig.dbDir) : dbManager$DaoConfig.dbDir != null)) {
            z = false;
        }
        return z;
    }

    public String getDBpwd() {
        return this.DB_PWD;
    }

    public File getDbDir() {
        return this.dbDir;
    }

    public String getDbName() {
        return this.dbName;
    }

    public DbOpenListener getDbOpenListener() {
        return this.dbOpenListener;
    }

    public DbManager$DbUpgradeListener getDbUpgradeListener() {
        return this.dbUpgradeListener;
    }

    public int getDbVersion() {
        return this.dbVersion;
    }

    public TableCreateListener getTableCreateListener() {
        return this.tableCreateListener;
    }

    public int hashCode() {
        return (31 * this.dbName.hashCode()) + (this.dbDir != null ? this.dbDir.hashCode() : 0);
    }

    public boolean isAllowTransaction() {
        return this.allowTransaction;
    }

    public DbManager$DaoConfig setAllowTransaction(boolean z) {
        this.allowTransaction = z;
        return this;
    }

    public DbManager$DaoConfig setDbDir(File file) {
        this.dbDir = file;
        return this;
    }

    public DbManager$DaoConfig setDbName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.dbName = str;
        }
        return this;
    }

    public DbManager$DaoConfig setDbOpenListener(DbOpenListener dbOpenListener) {
        this.dbOpenListener = dbOpenListener;
        return this;
    }

    public DbManager$DaoConfig setDbUpgradeListener(DbManager$DbUpgradeListener dbManager$DbUpgradeListener) {
        this.dbUpgradeListener = dbManager$DbUpgradeListener;
        return this;
    }

    public DbManager$DaoConfig setDbVersion(int i) {
        this.dbVersion = i;
        return this;
    }

    public DbManager$DaoConfig setDbpwd(String str) {
        this.DB_PWD = str;
        return this;
    }

    public DbManager$DaoConfig setTableCreateListener(TableCreateListener tableCreateListener) {
        this.tableCreateListener = tableCreateListener;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(this.dbDir));
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(this.dbName);
        return stringBuilder.toString();
    }
}
