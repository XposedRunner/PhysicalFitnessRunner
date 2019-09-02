package com.baidu.location.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

enum o extends b {
    o(String str, int i, String str2, String str3, String str4, int i2, int i3) {
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
            b.b(stringBuffer, str2, str, 1);
            try {
                jSONArray = jSONObject.getJSONArray(str2);
            } catch (JSONException unused) {
                jSONArray = null;
            }
            if (jSONArray != null) {
                int i4 = 0;
                while (i4 < jSONArray.length()) {
                    JSONArray jSONArray2;
                    try {
                        Object valueOf;
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                        String string = jSONObject2.has("pid") ? jSONObject2.getString("pid") : null;
                        String string2 = jSONObject2.has("ne") ? jSONObject2.getString("ne") : null;
                        String string3 = jSONObject2.has("tp") ? jSONObject2.getString("tp") : null;
                        Object valueOf2 = jSONObject2.has("rk") ? Integer.valueOf(jSONObject2.getInt("rk")) : null;
                        Object valueOf3 = jSONObject2.has("x") ? Double.valueOf(jSONObject2.getDouble("x")) : null;
                        if (jSONObject2.has("y")) {
                            jSONArray2 = jSONArray;
                            try {
                                valueOf = Double.valueOf(jSONObject2.getDouble("y"));
                            } catch (JSONException unused2) {
                            }
                        } else {
                            jSONArray2 = jSONArray;
                            valueOf = null;
                        }
                        if (stringBuffer2.length() > 0) {
                            stringBuffer2.append(",");
                        }
                        stringBuffer2.append("(\"");
                        stringBuffer2.append(string);
                        stringBuffer2.append("\",\"");
                        stringBuffer2.append(str2);
                        stringBuffer2.append("\",\"");
                        stringBuffer2.append(string2);
                        stringBuffer2.append("\",\"");
                        stringBuffer2.append(string3);
                        stringBuffer2.append("\",");
                        stringBuffer2.append(valueOf3);
                        stringBuffer2.append(",");
                        stringBuffer2.append(valueOf);
                        stringBuffer2.append(",");
                        stringBuffer2.append(valueOf2);
                        stringBuffer2.append(")");
                    } catch (JSONException unused3) {
                        jSONArray2 = jSONArray;
                    }
                    if (i4 % 50 == 49) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCPOI", stringBuffer2.toString()}));
                        stringBuffer2.setLength(0);
                    }
                    i4++;
                    jSONArray = jSONArray2;
                    JSONObject jSONObject3 = jSONObject;
                }
                if (stringBuffer2.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCPOI", stringBuffer2.toString()}));
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
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCPOI WHERE pid NOT IN (SELECT pid FROM RGCPOI LIMIT %d);", objArr));
        return arrayList;
    }
}
