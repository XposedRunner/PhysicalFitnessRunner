package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class e {
    private Context a;
    private List<HashMap<String, String>> b = null;
    private a<String> c = null;

    interface a<Result> {
        void a(Result result);
    }

    protected e(Context context) {
        this.a = context;
    }

    private List<HashMap<String, String>> a(HashMap<String, String> hashMap, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length <= 0) {
            HashMap hashMap2 = new HashMap();
            for (String str : hashMap.keySet()) {
                String str2 = str2.toString();
                hashMap2.put(str2, hashMap.get(str2));
            }
            arrayList.add(hashMap2);
        } else {
            for (Object put : strArr) {
                HashMap hashMap3 = new HashMap();
                for (String str3 : hashMap.keySet()) {
                    String str32 = str32.toString();
                    hashMap3.put(str32, hashMap.get(str32));
                }
                hashMap3.put("mcode", put);
                arrayList.add(hashMap3);
            }
        }
        return arrayList;
    }

    private void a(String str) {
        JSONObject jSONObject;
        if (str == null) {
            str = "";
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.c != null) {
            this.c.a(jSONObject != null ? jSONObject.toString() : new JSONObject().toString());
        }
    }

    private void a(List<HashMap<String, String>> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("syncConnect start Thread id = ");
        stringBuilder.append(String.valueOf(Thread.currentThread().getId()));
        a.a(stringBuilder.toString());
        if (list == null || list.size() == 0) {
            a.c("syncConnect failed,params list is null or size is 0");
            return;
        }
        StringBuilder stringBuilder2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("syncConnect resuest ");
            stringBuilder2.append(i);
            stringBuilder2.append("  start!!!");
            a.a(stringBuilder2.toString());
            HashMap hashMap = (HashMap) list.get(i);
            g gVar = new g(this.a);
            if (gVar.a()) {
                String a = gVar.a(hashMap);
                if (a == null) {
                    a = "";
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("syncConnect resuest ");
                stringBuilder3.append(i);
                stringBuilder3.append("  result:");
                stringBuilder3.append(a);
                a.a(stringBuilder3.toString());
                arrayList.add(a);
                try {
                    JSONObject jSONObject = new JSONObject(a);
                    if (jSONObject.has("status") && jSONObject.getInt("status") == 0) {
                        a.a("auth end and break");
                        a(a);
                        return;
                    }
                } catch (JSONException unused) {
                    a.a("continue-------------------------------");
                }
            } else {
                a.a("Current network is not available.");
                arrayList.add(ErrorMessage.a("Current network is not available."));
            }
            a.a("syncConnect end");
            i++;
        }
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("--iiiiii:");
        stringBuilder2.append(i);
        stringBuilder2.append("<><>paramList.size():");
        stringBuilder2.append(list.size());
        stringBuilder2.append("<><>authResults.size():");
        stringBuilder2.append(arrayList.size());
        a.a(stringBuilder2.toString());
        if (list.size() > 0 && i == list.size() && arrayList.size() > 0 && i == arrayList.size()) {
            i--;
            if (i > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject((String) arrayList.get(i));
                    if (jSONObject2.has("status") && jSONObject2.getInt("status") != 0) {
                        a.a("i-1 result is not 0,return first result");
                        a((String) arrayList.get(0));
                    }
                } catch (JSONException e) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("JSONException:");
                    stringBuilder.append(e.getMessage());
                    a(ErrorMessage.a(stringBuilder.toString()));
                }
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(HashMap<String, String> hashMap, String[] strArr, a<String> aVar) {
        this.b = a((HashMap) hashMap, strArr);
        this.c = aVar;
        new Thread(new f(this)).start();
    }
}
