package com.ximalaya.ting.android.opensdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class BaseSharedPreferencesUtil {
    public static final int SHARE_MODEL = (VERSION.SDK_INT >= 24 ? 4 : 7);
    private SharedPreferences settings;

    public BaseSharedPreferencesUtil(Context context, String str) {
        this.settings = context.getSharedPreferences(str, SHARE_MODEL);
    }

    public BaseSharedPreferencesUtil(Context context, String str, int i) {
        this.settings = context.getSharedPreferences(str, i);
    }

    public void appendStringToList(String str, String str2) {
        ArrayList arrayList = getArrayList(str);
        if (!(arrayList == null || arrayList.contains(str2))) {
            arrayList.add(str2);
        }
        saveArrayList(str, arrayList);
    }

    @SuppressLint({"NewApi"})
    public void apply(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public void clear() {
        apply(this.settings.edit().clear());
    }

    public boolean contains(String str) {
        return this.settings.contains(str);
    }

    public ArrayList<String> getArrayList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.settings.getString(str, "{}"));
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return arrayList;
        }
    }

    public boolean getBoolean(String str) {
        return this.settings.getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return this.settings.getBoolean(str, z);
    }

    public ConcurrentHashMap<String, String> getConcurrentHashMapByKey(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        try {
            JSONObject jSONObject = new JSONObject(this.settings.getString(str, "{}"));
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    concurrentHashMap.put(str2, jSONObject.optString(str2));
                }
            }
            return concurrentHashMap;
        } catch (Exception unused) {
            return concurrentHashMap;
        }
    }

    public CopyOnWriteArrayList<String> getCopyOnWriteList(String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.settings.getString(str, "{}"));
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    copyOnWriteArrayList.add(jSONArray.optString(i));
                }
            }
            return copyOnWriteArrayList;
        } catch (Exception unused) {
            return copyOnWriteArrayList;
        }
    }

    public Double getDouble(String str) {
        str = this.settings.getString(str, null);
        if (str == null) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public float getFloat(String str) {
        return this.settings.getFloat(str, -1.0f);
    }

    public HashMap<String, String> getHashMapByKey(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(this.settings.getString(str, "{}"));
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    hashMap.put(str2, jSONObject.optString(str2));
                }
            }
            return hashMap;
        } catch (Exception unused) {
            return hashMap;
        }
    }

    public int getInt(String str, int i) {
        return this.settings.getInt(str, i);
    }

    public long getLong(String str) {
        return this.settings.getLong(str, -1);
    }

    public long getLong(String str, long j) {
        return this.settings.getLong(str, j);
    }

    public Boolean getOptBoolean(String str) {
        try {
            return Boolean.valueOf(Boolean.parseBoolean(this.settings.getString(str, null)));
        } catch (Exception unused) {
            return null;
        }
    }

    public Double getOptDouble(String str) {
        try {
            return Double.valueOf(Double.parseDouble(this.settings.getString(str, null)));
        } catch (Exception unused) {
            return null;
        }
    }

    public SharedPreferences getSettings() {
        return this.settings;
    }

    public String getString(String str) {
        return this.settings.getString(str, "");
    }

    public void removeByKey(String str) {
        apply(this.settings.edit().remove(str));
    }

    public void saveArrayList(String str, ArrayList<String> arrayList) {
        apply(this.settings.edit().putString(str, new Gson().toJson(arrayList)));
    }

    public void saveBoolean(String str, boolean z) {
        apply(this.settings.edit().putBoolean(str, z));
    }

    public void saveConcurrentHashMap(String str, ConcurrentHashMap<String, Object> concurrentHashMap) {
        apply(this.settings.edit().putString(str, new JSONObject(concurrentHashMap).toString()));
    }

    public void saveCopyOnWriteList(String str, CopyOnWriteArrayList<String> copyOnWriteArrayList) {
        apply(this.settings.edit().putString(str, new Gson().toJson(copyOnWriteArrayList)));
    }

    public void saveFloat(String str, float f) {
        apply(this.settings.edit().putFloat(str, f));
    }

    public void saveHashMap(String str, Map<String, String> map) {
        apply(this.settings.edit().putString(str, new JSONObject(map).toString()));
    }

    public void saveInt(String str, int i) {
        apply(this.settings.edit().putInt(str, i));
    }

    public void saveLong(String str, long j) {
        apply(this.settings.edit().putLong(str, j));
    }

    public void saveString(String str, String str2) {
        apply(this.settings.edit().putString(str, str2));
    }
}
