package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: StoreHelper */
public final class d {
    private static d a = null;
    private static Context b = null;
    private static String c = null;
    private static final String e = "mobclick_agent_user_";
    private static final String f = "mobclick_agent_header_";
    private static final String g = "mobclick_agent_cached_";
    private a d;

    /* compiled from: StoreHelper */
    public static class a {
        private final int a;
        private File b;
        private FilenameFilter c;

        public a(Context context) {
            this(context, ".um");
        }

        public a(Context context, String str) {
            this.a = 10;
            this.c = new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith("um");
                }
            };
            this.b = new File(context.getFilesDir(), str);
            if (!this.b.exists() || !this.b.isDirectory()) {
                this.b.mkdir();
            }
        }

        public void a(b bVar) {
            int i;
            File[] listFiles = this.b.listFiles(this.c);
            int i2 = 0;
            if (listFiles != null && listFiles.length >= 10) {
                Arrays.sort(listFiles);
                int length = listFiles.length - 10;
                for (i = 0; i < length; i++) {
                    listFiles[i].delete();
                }
            }
            if (listFiles != null && listFiles.length > 0) {
                bVar.a(this.b);
                i = listFiles.length;
                while (i2 < i) {
                    File file;
                    try {
                        if (bVar.b(listFiles[i2])) {
                            file = listFiles[i2];
                            file.delete();
                            i2++;
                        } else {
                            i2++;
                        }
                    } catch (Throwable unused) {
                        file = listFiles[i2];
                    }
                }
                bVar.c(this.b);
            }
        }

        public void a(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                try {
                    HelperUtils.writeFile(new File(this.b, String.format(Locale.US, "um_cache_%d.env", new Object[]{Long.valueOf(System.currentTimeMillis())})), bArr);
                } catch (Exception unused) {
                }
            }
        }

        public boolean a() {
            File[] listFiles = this.b.listFiles();
            return listFiles != null && listFiles.length > 0;
        }

        public void b() {
            File[] listFiles = this.b.listFiles(this.c);
            if (listFiles != null && listFiles.length > 0) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }

        public int c() {
            File[] listFiles = this.b.listFiles(this.c);
            return (listFiles == null || listFiles.length <= 0) ? 0 : listFiles.length;
        }
    }

    /* compiled from: StoreHelper */
    public interface b {
        void a(File file);

        boolean b(File file);

        void c(File file);
    }

    public d(Context context) {
        this.d = new a(context);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            b = context.getApplicationContext();
            c = context.getPackageName();
            if (a == null) {
                a = new d(context);
            }
            dVar = a;
        }
        return dVar;
    }

    private SharedPreferences f() {
        Context context = b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append(c);
        return context.getSharedPreferences(stringBuilder.toString(), 0);
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        return sharedPreferences != null ? sharedPreferences.getInt("vt", 0) : 0;
    }

    public void a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Editor edit = f().edit();
            edit.putString("au_p", str);
            edit.putString("au_u", str2);
            edit.commit();
        }
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(b);
        return sharedPreferences != null ? sharedPreferences.getString("st", null) : null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences f = f();
            String string = f.getString("au_p", null);
            String string2 = f.getString("au_u", null);
            if (!(string == null || string2 == null)) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }
}
