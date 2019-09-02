package org.xutils.config;

import org.xutils.DbManager;
import org.xutils.DbManager.DaoConfig;
import org.xutils.DbManager.DbOpenListener;
import org.xutils.DbManager.DbUpgradeListener;
import org.xutils.common.util.LogUtil;
import org.xutils.ex.DbException;

public enum DbConfigs {
    HTTP(new DaoConfig().setDbName("xUtils_http_cache.db").setDbVersion(1).setDbOpenListener(new DbOpenListener() {
        public void onDbOpened(DbManager dbManager) {
        }
    }).setDbUpgradeListener(new DbUpgradeListener() {
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            try {
                dbManager.dropDb();
            } catch (DbException e) {
                LogUtil.e(e.getMessage(), e);
            }
        }
    })),
    COOKIE(new DaoConfig().setDbName("xUtils_http_cookie.db").setDbVersion(1).setDbOpenListener(new DbOpenListener() {
        public void onDbOpened(DbManager dbManager) {
        }
    }).setDbUpgradeListener(new DbUpgradeListener() {
        public void onUpgrade(DbManager dbManager, int i, int i2) {
            try {
                dbManager.dropDb();
            } catch (DbException e) {
                LogUtil.e(e.getMessage(), e);
            }
        }
    }));
    
    private DaoConfig config;

    private DbConfigs(DaoConfig daoConfig) {
        this.config = daoConfig;
    }

    public DaoConfig getConfig() {
        return this.config;
    }
}
