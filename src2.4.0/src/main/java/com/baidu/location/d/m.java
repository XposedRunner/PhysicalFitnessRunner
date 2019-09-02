package com.baidu.location.d;

import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

enum m extends b {
    m(String str, int i, String str2, String str3, String str4, int i2, int i3) {
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
                int i4 = 0;
                while (i4 < jSONArray.length()) {
                    try {
                        Double d;
                        Object valueOf;
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                        String string = jSONObject2.has("st") ? jSONObject2.getString("st") : null;
                        Object valueOf2 = jSONObject2.has(INoCaptchaComponent.x1) ? Double.valueOf(jSONObject2.getDouble(INoCaptchaComponent.x1)) : null;
                        Double valueOf3 = jSONObject2.has(INoCaptchaComponent.y1) ? Double.valueOf(jSONObject2.getDouble(INoCaptchaComponent.y1)) : null;
                        if (jSONObject2.has(INoCaptchaComponent.x2)) {
                            d = valueOf3;
                            valueOf = Double.valueOf(jSONObject2.getDouble(INoCaptchaComponent.x2));
                        } else {
                            d = valueOf3;
                            valueOf = null;
                        }
                        Object valueOf4 = jSONObject2.has(INoCaptchaComponent.y2) ? Double.valueOf(jSONObject2.getDouble(INoCaptchaComponent.y2)) : null;
                        if (!(string == null || valueOf2 == null || d == null || valueOf == null || valueOf4 == null)) {
                            if (stringBuffer2.length() > 0) {
                                stringBuffer2.append(",");
                            }
                            stringBuffer2.append("(NULL,\"");
                            stringBuffer2.append(str2);
                            stringBuffer2.append("\",\"");
                            stringBuffer2.append(string);
                            stringBuffer2.append("\",");
                            stringBuffer2.append(valueOf2);
                            stringBuffer2.append(",");
                            stringBuffer2.append(d);
                            stringBuffer2.append(",");
                            stringBuffer2.append(valueOf);
                            stringBuffer2.append(",");
                            stringBuffer2.append(valueOf4);
                            stringBuffer2.append(")");
                        }
                    } catch (JSONException unused2) {
                    }
                    if (i4 % 50 == 49 && stringBuffer2.length() > 0) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCROAD", stringBuffer2.toString()}));
                        stringBuffer2.setLength(0);
                    }
                    i4++;
                    JSONObject jSONObject3 = jSONObject;
                }
                if (stringBuffer2.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCROAD", stringBuffer2.toString()}));
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
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCROAD WHERE _id NOT IN (SELECT _id FROM RGCROAD LIMIT %d);", objArr));
        return arrayList;
    }
}
