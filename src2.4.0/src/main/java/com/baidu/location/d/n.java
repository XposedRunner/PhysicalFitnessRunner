package com.baidu.location.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

enum n extends b {
    n(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    /* Access modifiers changed, original: 0000 */
    public List<String> a(JSONObject jSONObject, String str, int i) {
        int i2;
        int i3;
        Iterator keys = jSONObject.keys();
        ArrayList arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (keys.hasNext()) {
            JSONArray jSONArray;
            StringBuffer stringBuffer2 = new StringBuffer();
            String str2 = (String) keys.next();
            b.b(stringBuffer, str2, str, 0);
            try {
                jSONArray = jSONObject.getJSONArray(str2);
            } catch (JSONException unused) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                        String string = jSONObject2.has("st") ? jSONObject2.getString("st") : null;
                        String string2 = jSONObject2.has("stn") ? jSONObject2.getString("stn") : null;
                        Object valueOf = jSONObject2.has("x") ? Double.valueOf(jSONObject2.getDouble("x")) : null;
                        Object valueOf2 = jSONObject2.has("y") ? Double.valueOf(jSONObject2.getDouble("y")) : null;
                        if (stringBuffer2.length() > 0) {
                            stringBuffer2.append(",");
                        }
                        stringBuffer2.append("(NULL,\"");
                        stringBuffer2.append(str2);
                        stringBuffer2.append("\",\"");
                        stringBuffer2.append(string);
                        stringBuffer2.append("\",\"");
                        stringBuffer2.append(string2);
                        stringBuffer2.append("\",");
                        stringBuffer2.append(valueOf);
                        stringBuffer2.append(",");
                        stringBuffer2.append(valueOf2);
                        stringBuffer2.append(")");
                    } catch (JSONException unused2) {
                    }
                    if (i4 % 50 == 49 && stringBuffer2.length() > 0) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCSITE", stringBuffer2.toString()}));
                        stringBuffer2.setLength(0);
                    }
                }
                if (stringBuffer2.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCSITE", stringBuffer2.toString()}));
                }
            }
        }
        if (stringBuffer.length() > 0) {
            r4 = new Object[2];
            i2 = 0;
            r4[0] = "RGCUPDATE";
            i3 = 1;
            r4[1] = stringBuffer;
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", r4));
        } else {
            i3 = 1;
            i2 = 0;
        }
        Object[] objArr = new Object[i3];
        objArr[i2] = Integer.valueOf(i);
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCSITE WHERE _id NOT IN (SELECT _id FROM RGCSITE LIMIT %d);", objArr));
        return arrayList;
    }
}
