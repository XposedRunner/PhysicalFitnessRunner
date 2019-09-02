package com.zjwh.android_wh_physicalfitness.utils;

import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import com.zjwh.android_wh_physicalfitness.entity.database.MyLocation;
import com.zjwh.android_wh_physicalfitness.entity.database.SportRecord;
import defpackage.gg;
import defpackage.kz;
import org.xutils.DbManager;
import org.xutils.db.Selector;
import org.xutils.db.sqlite.WhereBuilder;

/* compiled from: DbUtils */
public class O000O0o {
    public static SportRecord O000000o(int i) {
        return O000000o(-1, -1, i);
    }

    public static SportRecord O000000o(int i, int i2, int i3) {
        try {
            Selector and = O00Oo0.O0000O0o().selector(SportRecord.class).where("stopTime", "<=", Integer.valueOf(1000)).and("uid", "=", Integer.valueOf(i3));
            if (i > 0) {
                and.and("sportType", "=", Integer.valueOf(i));
            }
            if (i2 > 0) {
                and.and(gg.O0000Ooo, "=", Integer.valueOf(i2));
            }
            return (SportRecord) and.orderBy("id", true).findFirst();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void O000000o(final long j) {
        new O00O0o00() {
            public Object call() throws Exception {
                long currentTimeMillis = System.currentTimeMillis();
                DbManager O0000O0o = O00Oo0.O0000O0o();
                int delete = O0000O0o.delete(SportRecord.class, WhereBuilder.b("timestamp", "=", Long.valueOf(j)));
                int delete2 = O0000O0o.delete(MyLocation.class, WhereBuilder.b("flag", "=", Long.valueOf(j)));
                int delete3 = O0000O0o.delete(FivePoint.class, WhereBuilder.b("flag", "=", Long.valueOf(j)));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("removeSportRecord time: ");
                stringBuilder.append(System.currentTimeMillis() - currentTimeMillis);
                kz.O00000o0("TAG", stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("removeSportRecord sport: ");
                stringBuilder2.append(delete);
                stringBuilder2.append(" location: ");
                stringBuilder2.append(delete2);
                stringBuilder2.append(" point: ");
                stringBuilder2.append(delete3);
                kz.O00000o0("TAG", stringBuilder2.toString());
                return null;
            }
        }.execute();
    }

    private static void O000000o(DbManager dbManager, int i) {
        if (i <= 44) {
            try {
                dbManager.addColumn(MyLocation.class, "state");
                dbManager.addColumn(MyLocation.class, "stepDistance");
                dbManager.addColumn(MyLocation.class, "gLng");
                dbManager.addColumn(MyLocation.class, "gLat");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (i <= 44) {
            try {
                dbManager.addColumn(SportRecord.class, "policy");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void O000000o(DbManager dbManager, int i, int i2) {
        O000000o(dbManager, i);
        O00000Oo(dbManager, i);
    }

    private static void O00000Oo(DbManager dbManager, int i) {
        if (i <= 42) {
            try {
                dbManager.addColumn(MyLocation.class, "bdA");
                dbManager.addColumn(MyLocation.class, "bdD");
                dbManager.addColumn(MyLocation.class, "bdG");
                dbManager.addColumn(MyLocation.class, "bdS");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
