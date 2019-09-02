package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class c {
    private Context a;
    private HashMap<String, String> b = null;
    private a<String> c = null;

    interface a<Result> {
        void a(Result result);
    }

    protected c(Context context) {
        this.a = context;
    }

    private HashMap<String, String> a(HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            String str2 = str2.toString();
            hashMap2.put(str2, hashMap.get(str2));
        }
        return hashMap2;
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

    /* Access modifiers changed, original: protected */
    public void a(HashMap<String, String> hashMap, a<String> aVar) {
        this.b = a((HashMap) hashMap);
        this.c = aVar;
        new Thread(new d(this)).start();
    }
}
