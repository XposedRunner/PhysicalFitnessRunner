package org.xutils.db.table;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import java.util.Date;
import java.util.HashMap;

public final class DbModel {
    private HashMap<String, String> dataMap = new HashMap();

    public void add(String str, String str2) {
        this.dataMap.put(str, str2);
    }

    public boolean getBoolean(String str) {
        str = (String) this.dataMap.get(str);
        if (str == null) {
            return false;
        }
        return str.length() == 1 ? ClientOSType.IOS.equals(str) : Boolean.valueOf(str).booleanValue();
    }

    public HashMap<String, String> getDataMap() {
        return this.dataMap;
    }

    public Date getDate(String str) {
        return new Date(Long.valueOf((String) this.dataMap.get(str)).longValue());
    }

    public double getDouble(String str) {
        return Double.valueOf((String) this.dataMap.get(str)).doubleValue();
    }

    public float getFloat(String str) {
        return Float.valueOf((String) this.dataMap.get(str)).floatValue();
    }

    public int getInt(String str) {
        return Integer.valueOf((String) this.dataMap.get(str)).intValue();
    }

    public long getLong(String str) {
        return Long.valueOf((String) this.dataMap.get(str)).longValue();
    }

    public java.sql.Date getSqlDate(String str) {
        return new java.sql.Date(Long.valueOf((String) this.dataMap.get(str)).longValue());
    }

    public String getString(String str) {
        return (String) this.dataMap.get(str);
    }

    public boolean isEmpty(String str) {
        return TextUtils.isEmpty((CharSequence) this.dataMap.get(str));
    }
}
