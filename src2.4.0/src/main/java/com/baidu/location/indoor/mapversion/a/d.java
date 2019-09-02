package com.baidu.location.indoor.mapversion.a;

import android.text.TextUtils;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
    private HashMap<String, c> a;
    private HashSet<a> b;
    private File c;
    private boolean d;
    private String e;
    private String f;

    public interface a {
        void a(boolean z);
    }

    private void a(boolean z) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(z);
        }
        this.d = false;
    }

    private boolean b(String str) {
        if (str != null) {
            try {
                if (str.equalsIgnoreCase("")) {
                    return false;
                }
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("item");
                this.a = new HashMap();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    c cVar = new c(optJSONArray.getJSONObject(i));
                    if (cVar.b() != null) {
                        if (cVar.c() != null) {
                            this.a.put(c.a(cVar.c()), cVar);
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private void c() {
        new Thread(new e(this)).start();
    }

    private boolean d() {
        try {
            File file = new File(this.c, this.e);
            long currentTimeMillis = System.currentTimeMillis();
            file.lastModified();
            if (file.exists()) {
                if (currentTimeMillis - file.lastModified() <= 604800000) {
                    StringBuilder stringBuilder = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    this.f = bufferedReader.readLine();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuilder.append(readLine);
                            stringBuilder.append("\n");
                        } else {
                            bufferedReader.close();
                            a(b(new String(Base64.decode(stringBuilder.toString(), 0))));
                            this.d = false;
                            return true;
                        }
                    }
                }
            }
            this.d = false;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.d = false;
        }
    }

    public c a(String str, String str2) {
        if (this.a == null || this.e == null || !str.equalsIgnoreCase(this.e)) {
            return null;
        }
        return (c) this.a.get(c.a(str2));
    }

    public void a(String str) {
        if (!this.d) {
            this.d = true;
            if (TextUtils.isEmpty(str)) {
                a(false);
            } else if (this.e != null && str.equalsIgnoreCase(this.e) && a()) {
                a(true);
            } else {
                this.e = str;
                this.f = null;
                if (!d()) {
                    c();
                }
            }
        }
    }

    public boolean a() {
        return this.a != null && this.a.size() > 0;
    }

    public String b() {
        if (a()) {
            Object[] toArray = this.a.keySet().toArray();
            if (toArray.length > 0 && this.a.get(toArray[0].toString()) != null) {
                return ((c) this.a.get(toArray[0].toString())).c();
            }
        }
        return "A001";
    }
}
