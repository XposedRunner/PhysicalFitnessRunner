package com.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import com.loc.O000OO00.O000000o;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DBOperation */
public final class O000O0o {
    private static Map<Class<? extends O000O0o0>, O000O0o0> O00000o = new HashMap();
    private O000OO00 O000000o;
    private SQLiteDatabase O00000Oo;
    private O000O0o0 O00000o0;

    public O000O0o(Context context, O000O0o0 o000O0o0) {
        try {
            this.O000000o = new O000OO00(context.getApplicationContext(), o000O0o0.O000000o(), o000O0o0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.O00000o0 = o000O0o0;
    }

    public O000O0o(Context context, O000O0o0 o000O0o0, String str) {
        try {
            boolean equals = "mounted".equals(Environment.getExternalStorageState());
            if (!TextUtils.isEmpty(str) && equals) {
                context = new O000000o(context.getApplicationContext(), str);
            }
            this.O000000o = new O000OO00(context, o000O0o0.O000000o(), o000O0o0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.O00000o0 = o000O0o0;
    }

    private static ContentValues O000000o(Object obj, ap apVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : O000000o(obj.getClass(), apVar.b())) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(aq.class);
            if (annotation != null) {
                aq aqVar = (aq) annotation;
                switch (aqVar.b()) {
                    case 1:
                        contentValues.put(aqVar.a(), Short.valueOf(field.getShort(obj)));
                        break;
                    case 2:
                        contentValues.put(aqVar.a(), Integer.valueOf(field.getInt(obj)));
                        break;
                    case 3:
                        contentValues.put(aqVar.a(), Float.valueOf(field.getFloat(obj)));
                        break;
                    case 4:
                        contentValues.put(aqVar.a(), Double.valueOf(field.getDouble(obj)));
                        break;
                    case 5:
                        contentValues.put(aqVar.a(), Long.valueOf(field.getLong(obj)));
                        break;
                    case 6:
                        contentValues.put(aqVar.a(), (String) field.get(obj));
                        break;
                    case 7:
                        try {
                            contentValues.put(aqVar.a(), (byte[]) field.get(obj));
                            break;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        return contentValues;
    }

    private SQLiteDatabase O000000o() {
        try {
            if (this.O00000Oo == null || this.O00000Oo.isReadOnly()) {
                if (this.O00000Oo != null) {
                    this.O00000Oo.close();
                }
                this.O00000Oo = this.O000000o.getWritableDatabase();
            }
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "dbs", "gwd");
        }
        return this.O00000Oo;
    }

    private SQLiteDatabase O000000o(boolean z) {
        try {
            if (this.O00000Oo == null) {
                this.O00000Oo = this.O000000o.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (z) {
                th.printStackTrace();
            } else {
                O0000Oo.O000000o(th, "dbs", "grd");
            }
        }
        return this.O00000Oo;
    }

    public static synchronized O000O0o0 O000000o(Class<? extends O000O0o0> cls) throws IllegalAccessException, InstantiationException {
        O000O0o0 o000O0o0;
        synchronized (O000O0o.class) {
            if (O00000o.get(cls) == null) {
                O00000o.put(cls, cls.newInstance());
            }
            o000O0o0 = (O000O0o0) O00000o.get(cls);
        }
        return o000O0o0;
    }

    private static <T> T O000000o(Cursor cursor, Class<T> cls, ap apVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] O000000o = O000000o((Class) cls, apVar.b());
        int i = 0;
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        Object newInstance = declaredConstructor.newInstance(new Object[0]);
        int length = O000000o.length;
        while (i < length) {
            Field field = O000000o[i];
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(aq.class);
            if (annotation != null) {
                Object valueOf;
                aq aqVar = (aq) annotation;
                int b = aqVar.b();
                int columnIndex = cursor.getColumnIndex(aqVar.a());
                switch (b) {
                    case 1:
                        valueOf = Short.valueOf(cursor.getShort(columnIndex));
                        break;
                    case 2:
                        valueOf = Integer.valueOf(cursor.getInt(columnIndex));
                        break;
                    case 3:
                        valueOf = Float.valueOf(cursor.getFloat(columnIndex));
                        break;
                    case 4:
                        valueOf = Double.valueOf(cursor.getDouble(columnIndex));
                        break;
                    case 5:
                        valueOf = Long.valueOf(cursor.getLong(columnIndex));
                        break;
                    case 6:
                        valueOf = cursor.getString(columnIndex);
                        break;
                    case 7:
                        valueOf = cursor.getBlob(columnIndex);
                        break;
                    default:
                        break;
                }
                field.set(newInstance, valueOf);
            }
            i++;
        }
        return newInstance;
    }

    private static <T> String O000000o(ap apVar) {
        return apVar == null ? null : apVar.a();
    }

    public static String O000000o(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : map.keySet()) {
            if (obj != null) {
                stringBuilder.append(str);
                stringBuilder.append(" = '");
                stringBuilder.append((String) map.get(str));
                stringBuilder.append("'");
                obj = null;
            } else {
                stringBuilder.append(" and ");
                stringBuilder.append(str);
                stringBuilder.append(" = '");
                stringBuilder.append((String) map.get(str));
                stringBuilder.append("'");
            }
        }
        return stringBuilder.toString();
    }

    private static Field[] O000000o(Class<?> cls, boolean z) {
        return cls == null ? null : z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private static <T> ap O00000Oo(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(ap.class);
        return (annotation != null ? 1 : null) == null ? null : (ap) annotation;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00a5 A:{SYNTHETIC, Splitter:B:61:0x00a5} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00d7 A:{SYNTHETIC, Splitter:B:81:0x00d7} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00e9 A:{Catch:{ Throwable -> 0x00f1 }} */
    /* JADX WARNING: Missing block: B:33:0x0065, code skipped:
            return r1;
     */
    /* JADX WARNING: Missing block: B:98:0x00fc, code skipped:
            return r1;
     */
    public final <T> java.util.List<T> O000000o(java.lang.String r13, java.lang.Class<T> r14, boolean r15) {
        /*
        r12 = this;
        r0 = r12.O00000o0;
        monitor-enter(r0);
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00fd }
        r1.<init>();	 Catch:{ all -> 0x00fd }
        r2 = O00000Oo(r14);	 Catch:{ all -> 0x00fd }
        r4 = O000000o(r2);	 Catch:{ all -> 0x00fd }
        r3 = r12.O00000Oo;	 Catch:{ all -> 0x00fd }
        if (r3 != 0) goto L_0x001a;
    L_0x0014:
        r3 = r12.O000000o(r15);	 Catch:{ all -> 0x00fd }
        r12.O00000Oo = r3;	 Catch:{ all -> 0x00fd }
    L_0x001a:
        r3 = r12.O00000Oo;	 Catch:{ all -> 0x00fd }
        if (r3 == 0) goto L_0x00fb;
    L_0x001e:
        r3 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x00fd }
        if (r3 != 0) goto L_0x00fb;
    L_0x0024:
        if (r13 != 0) goto L_0x0028;
    L_0x0026:
        goto L_0x00fb;
    L_0x0028:
        r11 = 0;
        r3 = r12.O00000Oo;	 Catch:{ Throwable -> 0x00a1, all -> 0x009e }
        r5 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r6 = r13;
        r13 = r3.query(r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x00a1, all -> 0x009e }
        if (r13 != 0) goto L_0x0068;
    L_0x0037:
        r14 = r12.O00000Oo;	 Catch:{ Throwable -> 0x0066 }
        r14.close();	 Catch:{ Throwable -> 0x0066 }
        r12.O00000Oo = r11;	 Catch:{ Throwable -> 0x0066 }
        if (r13 == 0) goto L_0x004e;
    L_0x0040:
        r13.close();	 Catch:{ Throwable -> 0x0044 }
        goto L_0x004e;
    L_0x0044:
        r13 = move-exception;
        if (r15 != 0) goto L_0x004e;
    L_0x0047:
        r14 = "dbs";
        r2 = "sld";
        com.loc.O0000Oo.O000000o(r13, r14, r2);	 Catch:{ all -> 0x00fd }
    L_0x004e:
        r13 = r12.O00000Oo;	 Catch:{ Throwable -> 0x005a }
        if (r13 == 0) goto L_0x0064;
    L_0x0052:
        r13 = r12.O00000Oo;	 Catch:{ Throwable -> 0x005a }
        r13.close();	 Catch:{ Throwable -> 0x005a }
        r12.O00000Oo = r11;	 Catch:{ Throwable -> 0x005a }
        goto L_0x0064;
    L_0x005a:
        r13 = move-exception;
        if (r15 != 0) goto L_0x0064;
    L_0x005d:
        r14 = "dbs";
        r15 = "sld";
        com.loc.O0000Oo.O000000o(r13, r14, r15);	 Catch:{ all -> 0x00fd }
    L_0x0064:
        monitor-exit(r0);	 Catch:{ all -> 0x00fd }
        return r1;
    L_0x0066:
        r14 = move-exception;
        goto L_0x00a3;
    L_0x0068:
        r3 = r13.moveToNext();	 Catch:{ Throwable -> 0x0066 }
        if (r3 == 0) goto L_0x0076;
    L_0x006e:
        r3 = O000000o(r13, r14, r2);	 Catch:{ Throwable -> 0x0066 }
        r1.add(r3);	 Catch:{ Throwable -> 0x0066 }
        goto L_0x0068;
    L_0x0076:
        if (r13 == 0) goto L_0x0086;
    L_0x0078:
        r13.close();	 Catch:{ Throwable -> 0x007c }
        goto L_0x0086;
    L_0x007c:
        r13 = move-exception;
        if (r15 != 0) goto L_0x0086;
    L_0x007f:
        r14 = "dbs";
        r2 = "sld";
        com.loc.O0000Oo.O000000o(r13, r14, r2);	 Catch:{ all -> 0x00fd }
    L_0x0086:
        r13 = r12.O00000Oo;	 Catch:{ Throwable -> 0x0093 }
        if (r13 == 0) goto L_0x00f9;
    L_0x008a:
        r13 = r12.O00000Oo;	 Catch:{ Throwable -> 0x0093 }
        r13.close();	 Catch:{ Throwable -> 0x0093 }
        r12.O00000Oo = r11;	 Catch:{ Throwable -> 0x0093 }
        goto L_0x00f9;
    L_0x0093:
        r13 = move-exception;
        if (r15 != 0) goto L_0x00f9;
    L_0x0096:
        r14 = "dbs";
        r15 = "sld";
    L_0x009a:
        com.loc.O0000Oo.O000000o(r13, r14, r15);	 Catch:{ all -> 0x00fd }
        goto L_0x00f9;
    L_0x009e:
        r14 = move-exception;
        r13 = r11;
        goto L_0x00ae;
    L_0x00a1:
        r14 = move-exception;
        r13 = r11;
    L_0x00a3:
        if (r15 != 0) goto L_0x00d5;
    L_0x00a5:
        r2 = "dbs";
        r3 = "sld";
        com.loc.O0000Oo.O000000o(r14, r2, r3);	 Catch:{ all -> 0x00ad }
        goto L_0x00d5;
    L_0x00ad:
        r14 = move-exception;
    L_0x00ae:
        if (r13 == 0) goto L_0x00be;
    L_0x00b0:
        r13.close();	 Catch:{ Throwable -> 0x00b4 }
        goto L_0x00be;
    L_0x00b4:
        r13 = move-exception;
        if (r15 != 0) goto L_0x00be;
    L_0x00b7:
        r1 = "dbs";
        r2 = "sld";
        com.loc.O0000Oo.O000000o(r13, r1, r2);	 Catch:{ all -> 0x00fd }
    L_0x00be:
        r13 = r12.O00000Oo;	 Catch:{ Throwable -> 0x00ca }
        if (r13 == 0) goto L_0x00d4;
    L_0x00c2:
        r13 = r12.O00000Oo;	 Catch:{ Throwable -> 0x00ca }
        r13.close();	 Catch:{ Throwable -> 0x00ca }
        r12.O00000Oo = r11;	 Catch:{ Throwable -> 0x00ca }
        goto L_0x00d4;
    L_0x00ca:
        r13 = move-exception;
        if (r15 != 0) goto L_0x00d4;
    L_0x00cd:
        r15 = "dbs";
        r1 = "sld";
        com.loc.O0000Oo.O000000o(r13, r15, r1);	 Catch:{ all -> 0x00fd }
    L_0x00d4:
        throw r14;	 Catch:{ all -> 0x00fd }
    L_0x00d5:
        if (r13 == 0) goto L_0x00e5;
    L_0x00d7:
        r13.close();	 Catch:{ Throwable -> 0x00db }
        goto L_0x00e5;
    L_0x00db:
        r13 = move-exception;
        if (r15 != 0) goto L_0x00e5;
    L_0x00de:
        r14 = "dbs";
        r2 = "sld";
        com.loc.O0000Oo.O000000o(r13, r14, r2);	 Catch:{ all -> 0x00fd }
    L_0x00e5:
        r13 = r12.O00000Oo;	 Catch:{ Throwable -> 0x00f1 }
        if (r13 == 0) goto L_0x00f9;
    L_0x00e9:
        r13 = r12.O00000Oo;	 Catch:{ Throwable -> 0x00f1 }
        r13.close();	 Catch:{ Throwable -> 0x00f1 }
        r12.O00000Oo = r11;	 Catch:{ Throwable -> 0x00f1 }
        goto L_0x00f9;
    L_0x00f1:
        r13 = move-exception;
        if (r15 != 0) goto L_0x00f9;
    L_0x00f4:
        r14 = "dbs";
        r15 = "sld";
        goto L_0x009a;
    L_0x00f9:
        monitor-exit(r0);	 Catch:{ all -> 0x00fd }
        return r1;
    L_0x00fb:
        monitor-exit(r0);	 Catch:{ all -> 0x00fd }
        return r1;
    L_0x00fd:
        r13 = move-exception;
        monitor-exit(r0);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.O000O0o.O000000o(java.lang.String, java.lang.Class, boolean):java.util.List");
    }

    public final <T> void O000000o(T t) {
        synchronized (this.O00000o0) {
            this.O00000Oo = O000000o();
            if (this.O00000Oo == null) {
                return;
            }
            try {
                SQLiteDatabase sQLiteDatabase = this.O00000Oo;
                ap O00000Oo = O00000Oo(t.getClass());
                String O000000o = O000000o(O00000Oo);
                if (!(TextUtils.isEmpty(O000000o) || t == null)) {
                    if (sQLiteDatabase != null) {
                        ContentValues O000000o2 = O000000o((Object) t, O00000Oo);
                        if (O000000o2 != null) {
                            sQLiteDatabase.insert(O000000o, null, O000000o2);
                        }
                    }
                }
                if (this.O00000Oo != null) {
                    this.O00000Oo.close();
                    this.O00000Oo = null;
                }
            } catch (Throwable th) {
                try {
                    O0000Oo.O000000o(th, "dbs", "itd");
                    if (this.O00000Oo != null) {
                        this.O00000Oo.close();
                    }
                } catch (Throwable th2) {
                    if (this.O00000Oo != null) {
                        this.O00000Oo.close();
                        this.O00000Oo = null;
                    }
                }
            }
        }
    }

    public final void O000000o(Object obj, String str) {
        synchronized (this.O00000o0) {
            List O000000o = O000000o(str, obj.getClass(), false);
            if (O000000o != null) {
                if (O000000o.size() != 0) {
                    O000000o(str, obj);
                }
            }
            O000000o(obj);
        }
    }

    public final <T> void O000000o(String str, Class<T> cls) {
        synchronized (this.O00000o0) {
            String O000000o = O000000o(O00000Oo(cls));
            if (TextUtils.isEmpty(O000000o)) {
                return;
            }
            this.O00000Oo = O000000o();
            if (this.O00000Oo == null) {
                return;
            }
            try {
                this.O00000Oo.delete(O000000o, str, null);
                if (this.O00000Oo != null) {
                    this.O00000Oo.close();
                    this.O00000Oo = null;
                }
            } catch (Throwable th) {
                try {
                    O0000Oo.O000000o(th, "dbs", "dld");
                    if (this.O00000Oo != null) {
                        this.O00000Oo.close();
                    }
                } catch (Throwable th2) {
                    if (this.O00000Oo != null) {
                        this.O00000Oo.close();
                        this.O00000Oo = null;
                    }
                }
            }
        }
    }

    public final <T> void O000000o(String str, Object obj) {
        synchronized (this.O00000o0) {
            if (obj == null) {
                return;
            }
            ap O00000Oo = O00000Oo(obj.getClass());
            String O000000o = O000000o(O00000Oo);
            if (TextUtils.isEmpty(O000000o)) {
                return;
            }
            ContentValues O000000o2 = O000000o(obj, O00000Oo);
            if (O000000o2 == null) {
                return;
            }
            this.O00000Oo = O000000o();
            if (this.O00000Oo == null) {
                return;
            }
            try {
                this.O00000Oo.update(O000000o, O000000o2, str, null);
                if (this.O00000Oo != null) {
                    this.O00000Oo.close();
                    this.O00000Oo = null;
                }
            } catch (Throwable th) {
                try {
                    O0000Oo.O000000o(th, "dbs", "udd");
                    if (this.O00000Oo != null) {
                        this.O00000Oo.close();
                    }
                } catch (Throwable th2) {
                    if (this.O00000Oo != null) {
                        this.O00000Oo.close();
                        this.O00000Oo = null;
                    }
                }
            }
        }
    }

    public final <T> List<T> O00000Oo(String str, Class<T> cls) {
        return O000000o(str, (Class) cls, false);
    }
}
