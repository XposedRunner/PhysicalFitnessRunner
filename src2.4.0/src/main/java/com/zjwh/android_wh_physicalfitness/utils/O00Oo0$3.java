package com.zjwh.android_wh_physicalfitness.utils;

import android.text.TextUtils;
import com.zjwh.android_wh_physicalfitness.entity.database.SportRecord;
import java.util.List;
import org.xutils.DbManager;

/* compiled from: Utils */
class O00Oo0$3 extends O00O0o00<Void> {
    O00Oo0$3() {
    }

    /* renamed from: O000000o */
    public Void call() throws Exception {
        DbManager O0000O0o = O00Oo0.O0000O0o();
        int i = 0;
        List findAll = O0000O0o.selector(SportRecord.class).where("isUpload", "=", Boolean.valueOf(false)).and("isGiveUp", "!=", Integer.valueOf(1)).findAll();
        StringBuilder stringBuilder = new StringBuilder();
        if (findAll != null && findAll.size() > 0) {
            stringBuilder.append("(");
            while (i < findAll.size()) {
                SportRecord sportRecord = (SportRecord) findAll.get(i);
                if (i > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append("'");
                stringBuilder.append(sportRecord.getTimestamp());
                stringBuilder.append("'");
                i++;
            }
            stringBuilder.append(")");
        }
        if (!TextUtils.isEmpty(stringBuilder.toString())) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("DELETE FROM sport_record WHERE timestamp NOT IN ");
            stringBuilder2.append(stringBuilder.toString());
            O0000O0o.executeUpdateDelete(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("DELETE FROM my_location WHERE flag NOT IN ");
            stringBuilder2.append(stringBuilder.toString());
            O0000O0o.executeUpdateDelete(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("DELETE FROM five_point WHERE flag NOT IN ");
            stringBuilder2.append(stringBuilder.toString());
            O0000O0o.executeUpdateDelete(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("DELETE FROM steps_record WHERE flag NOT IN ");
            stringBuilder2.append(stringBuilder.toString());
            O0000O0o.executeUpdateDelete(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("DELETE FROM speed_record WHERE flag NOT IN ");
            stringBuilder2.append(stringBuilder.toString());
            O0000O0o.executeUpdateDelete(stringBuilder2.toString());
        }
        return null;
    }
}
