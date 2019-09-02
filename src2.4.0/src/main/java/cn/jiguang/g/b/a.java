package cn.jiguang.g.b;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public final class a {
    private HashMap<String, Serializable> a = new HashMap(5);

    public static int a(Serializable serializable) {
        return serializable == null ? 0 : serializable instanceof String ? 1 : serializable instanceof Integer ? 2 : serializable instanceof Long ? 4 : serializable instanceof Boolean ? 3 : serializable instanceof Float ? 5 : serializable instanceof HashSet ? 6 : 0;
    }

    public static HashSet<String> a(SharedPreferences sharedPreferences, String str) {
        HashSet<String> hashSet = null;
        if (VERSION.SDK_INT >= 11) {
            Set<String> stringSet = sharedPreferences.getStringSet(str, null);
            if (stringSet != null) {
                if (stringSet instanceof HashSet) {
                    return (HashSet) stringSet;
                }
                hashSet = new HashSet();
                for (String str2 : stringSet) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    public final a a(String str, int i) {
        this.a.put(str, Integer.valueOf(i));
        return this;
    }

    public final a a(String str, long j) {
        this.a.put(str, Long.valueOf(j));
        return this;
    }

    public final a a(String str, Serializable serializable) {
        this.a.put(str, serializable);
        return this;
    }

    public final a a(String str, String str2) {
        this.a.put(str, str2);
        return this;
    }

    public final Set<Entry<String, Serializable>> a() {
        return this.a.entrySet();
    }

    public final int b() {
        return this.a.size();
    }

    public final <T extends Serializable> T b(String str, T t) {
        try {
            Serializable serializable = (Serializable) this.a.get(str);
            return serializable == null ? t : serializable;
        } catch (Throwable unused) {
            return t;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("values=");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}
