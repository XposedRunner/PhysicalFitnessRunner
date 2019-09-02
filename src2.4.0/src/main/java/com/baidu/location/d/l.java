package com.baidu.location.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

enum l extends b {
    l(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    /* Access modifiers changed, original: 0000 */
    public List<String> a(JSONObject jSONObject, String str, int i) {
        int i2;
        Iterator keys = jSONObject.keys();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            String string;
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                String string2 = jSONObject2.has("cy") ? jSONObject2.getString("cy") : null;
                String string3 = jSONObject2.has("cyc") ? jSONObject2.getString("cyc") : null;
                String string4 = jSONObject2.has("prov") ? jSONObject2.getString("prov") : null;
                String string5 = jSONObject2.has("ctc") ? jSONObject2.getString("ctc") : null;
                String string6 = jSONObject2.has("ct") ? jSONObject2.getString("ct") : null;
                string = jSONObject2.has("dist") ? jSONObject2.getString("dist") : null;
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append("(\"");
                stringBuffer.append(str2);
                stringBuffer.append("\",\"");
                stringBuffer.append(string2);
                stringBuffer.append("\",\"");
                stringBuffer.append(string3);
                stringBuffer.append("\",\"");
                stringBuffer.append(string4);
                stringBuffer.append("\",\"");
                stringBuffer.append(string6);
                stringBuffer.append("\",\"");
                stringBuffer.append(string5);
                stringBuffer.append("\",\"");
                stringBuffer.append(string);
                stringBuffer.append("\",");
                stringBuffer.append(System.currentTimeMillis() / 1000);
                stringBuffer.append(",\"\")");
                try {
                    b.b(stringBuffer2, str2, str, 0);
                } catch (JSONException unused) {
                }
            } catch (JSONException unused2) {
                string = str;
            }
            if (i3 % 50 == 49 && stringBuffer.length() > 0) {
                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCAREA", stringBuffer}));
                arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer2}));
                stringBuffer.setLength(0);
            }
            i3++;
        }
        if (stringBuffer.length() > 0) {
            Object[] objArr = new Object[2];
            objArr[0] = "RGCAREA";
            i2 = 1;
            objArr[1] = stringBuffer;
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", objArr));
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer2}));
            stringBuffer.setLength(0);
        } else {
            i2 = 1;
        }
        Object[] objArr2 = new Object[i2];
        objArr2[0] = Integer.valueOf(i);
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCAREA WHERE gridkey NOT IN (SELECT gridkey FROM RGCAREA LIMIT %d);", objArr2));
        return arrayList;
    }
}
