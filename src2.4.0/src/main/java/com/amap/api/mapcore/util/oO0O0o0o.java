package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DBOperation */
public class oO0O0o0o {
    private static Map<Class<? extends oO0Oo0O0>, oO0Oo0O0> O00000o = new HashMap();
    private oO00O0Oo O000000o;
    private SQLiteDatabase O00000Oo;
    private oO0Oo0O0 O00000o0;

    public oO0O0o0o(Context context, oO0Oo0O0 oo0oo0o0) {
        try {
            this.O000000o = new oO00O0Oo(context.getApplicationContext(), oo0oo0o0.O00000Oo(), null, oo0oo0o0.O00000o0(), oo0oo0o0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.O00000o0 = oo0oo0o0;
    }

    private ContentValues O000000o(Object obj, hz hzVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : O000000o(obj.getClass(), hzVar.b())) {
            field.setAccessible(true);
            O000000o(obj, field, contentValues);
        }
        return contentValues;
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
                oO0OoOO0.O000000o(th, "dbs", "grd");
            }
        }
        return this.O00000Oo;
    }

    public static synchronized oO0Oo0O0 O000000o(Class<? extends oO0Oo0O0> cls) throws IllegalAccessException, InstantiationException {
        oO0Oo0O0 oo0oo0o0;
        synchronized (oO0O0o0o.class) {
            if (O00000o.get(cls) == null) {
                O00000o.put(cls, cls.newInstance());
            }
            oo0oo0o0 = (oO0Oo0O0) O00000o.get(cls);
        }
        return oo0oo0o0;
    }

    private <T> T O000000o(Cursor cursor, Class<T> cls, hz hzVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] O000000o = O000000o((Class) cls, hzVar.b());
        int i = 0;
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        Object newInstance = declaredConstructor.newInstance(new Object[0]);
        int length = O000000o.length;
        while (i < length) {
            Field field = O000000o[i];
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(ia.class);
            if (annotation != null) {
                ia iaVar = (ia) annotation;
                int b = iaVar.b();
                int columnIndex = cursor.getColumnIndex(iaVar.a());
                switch (b) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        break;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        break;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        break;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        break;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        break;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                    default:
                        break;
                }
            }
            i++;
        }
        return newInstance;
    }

    private <T> String O000000o(hz hzVar) {
        return hzVar == null ? null : hzVar.a();
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

    private <T> void O000000o(SQLiteDatabase sQLiteDatabase, T t) {
        hz O00000Oo = O00000Oo(t.getClass());
        String O000000o = O000000o(O00000Oo);
        if (!TextUtils.isEmpty(O000000o) && t != null && sQLiteDatabase != null) {
            ContentValues O000000o2 = O000000o((Object) t, O00000Oo);
            if (O000000o2 != null) {
                sQLiteDatabase.insert(O000000o, null, O000000o2);
            }
        }
    }

    private void O000000o(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(ia.class);
        if (annotation != null) {
            ia iaVar = (ia) annotation;
            switch (iaVar.b()) {
                case 1:
                    contentValues.put(iaVar.a(), Short.valueOf(field.getShort(obj)));
                    break;
                case 2:
                    contentValues.put(iaVar.a(), Integer.valueOf(field.getInt(obj)));
                    break;
                case 3:
                    contentValues.put(iaVar.a(), Float.valueOf(field.getFloat(obj)));
                    break;
                case 4:
                    contentValues.put(iaVar.a(), Double.valueOf(field.getDouble(obj)));
                    break;
                case 5:
                    contentValues.put(iaVar.a(), Long.valueOf(field.getLong(obj)));
                    break;
                case 6:
                    contentValues.put(iaVar.a(), (String) field.get(obj));
                    break;
                case 7:
                    try {
                        contentValues.put(iaVar.a(), (byte[]) field.get(obj));
                        break;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        break;
                    }
            }
        }
    }

    private boolean O000000o(Annotation annotation) {
        return annotation != null;
    }

    private Field[] O000000o(Class<?> cls, boolean z) {
        return cls == null ? null : z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private SQLiteDatabase O00000Oo(boolean z) {
        try {
            if (this.O00000Oo == null || this.O00000Oo.isReadOnly()) {
                if (this.O00000Oo != null) {
                    this.O00000Oo.close();
                }
                this.O00000Oo = this.O000000o.getWritableDatabase();
            }
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "dbs", "gwd");
        }
        return this.O00000Oo;
    }

    private <T> hz O00000Oo(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(hz.class);
        return !O000000o(annotation) ? null : (hz) annotation;
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
    public <T> java.util.List<T> O000000o(java.lang.String r13, java.lang.Class<T> r14, boolean r15) {
        /*
        r12 = this;
        r0 = r12.O00000o0;
        monitor-enter(r0);
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00fd }
        r1.<init>();	 Catch:{ all -> 0x00fd }
        r2 = r12.O00000Oo(r14);	 Catch:{ all -> 0x00fd }
        r4 = r12.O000000o(r2);	 Catch:{ all -> 0x00fd }
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
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r13, r14, r2);	 Catch:{ all -> 0x00fd }
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
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r13, r14, r15);	 Catch:{ all -> 0x00fd }
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
        r3 = r12.O000000o(r13, r14, r2);	 Catch:{ Throwable -> 0x0066 }
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
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r13, r14, r2);	 Catch:{ all -> 0x00fd }
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
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r13, r14, r15);	 Catch:{ all -> 0x00fd }
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
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r14, r2, r3);	 Catch:{ all -> 0x00ad }
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
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r13, r1, r2);	 Catch:{ all -> 0x00fd }
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
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r13, r15, r1);	 Catch:{ all -> 0x00fd }
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
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r13, r14, r2);	 Catch:{ all -> 0x00fd }
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
        monitor-exit(r0);	 Catch:{ all -> 0x00fd }
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO0O0o0o.O000000o(java.lang.String, java.lang.Class, boolean):java.util.List");
    }

    public <T> void O000000o(T t) {
        O000000o((Object) t, false);
    }

    public void O000000o(Object obj, String str) {
        synchronized (this.O00000o0) {
            List O00000Oo = O00000Oo(str, obj.getClass());
            if (O00000Oo != null) {
                if (O00000Oo.size() != 0) {
                    O000000o(str, obj);
                }
            }
            O000000o(obj);
        }
    }

    public <T> void O000000o(T t, boolean z) {
        synchronized (this.O00000o0) {
            this.O00000Oo = O00000Oo(z);
            if (this.O00000Oo == null) {
                return;
            }
            try {
                O000000o(this.O00000Oo, (Object) t);
                if (this.O00000Oo != null) {
                    this.O00000Oo.close();
                    this.O00000Oo = null;
                }
            } catch (Throwable th) {
                try {
                    oO0OoOO0.O000000o(th, "dbs", "itd");
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

    public <T> void O000000o(String str, Class<T> cls) {
        synchronized (this.O00000o0) {
            String O000000o = O000000o(O00000Oo((Class) cls));
            if (TextUtils.isEmpty(O000000o)) {
                return;
            }
            this.O00000Oo = O00000Oo(false);
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
                    oO0OoOO0.O000000o(th, "dbs", "dld");
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

    public <T> void O000000o(String str, Object obj) {
        O000000o(str, obj, false);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0005, B:31:0x0048] */
    /* JADX WARNING: Missing block: B:41:0x0061, code skipped:
            if (r4.O00000Oo != null) goto L_0x0063;
     */
    /* JADX WARNING: Missing block: B:42:0x0063, code skipped:
            r4.O00000Oo.close();
            r4.O00000Oo = null;
     */
    public <T> void O000000o(java.lang.String r5, java.lang.Object r6, boolean r7) {
        /*
        r4 = this;
        r0 = r4.O00000o0;
        monitor-enter(r0);
        if (r6 != 0) goto L_0x0009;
    L_0x0005:
        monitor-exit(r0);	 Catch:{ all -> 0x0007 }
        return;
    L_0x0007:
        r5 = move-exception;
        goto L_0x006b;
    L_0x0009:
        r1 = r6.getClass();	 Catch:{ all -> 0x0007 }
        r1 = r4.O00000Oo(r1);	 Catch:{ all -> 0x0007 }
        r2 = r4.O000000o(r1);	 Catch:{ all -> 0x0007 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0007 }
        if (r3 == 0) goto L_0x001d;
    L_0x001b:
        monitor-exit(r0);	 Catch:{ all -> 0x0007 }
        return;
    L_0x001d:
        r6 = r4.O000000o(r6, r1);	 Catch:{ all -> 0x0007 }
        if (r6 != 0) goto L_0x0025;
    L_0x0023:
        monitor-exit(r0);	 Catch:{ all -> 0x0007 }
        return;
    L_0x0025:
        r1 = r4.O00000Oo(r7);	 Catch:{ all -> 0x0007 }
        r4.O00000Oo = r1;	 Catch:{ all -> 0x0007 }
        r1 = r4.O00000Oo;	 Catch:{ all -> 0x0007 }
        if (r1 != 0) goto L_0x0031;
    L_0x002f:
        monitor-exit(r0);	 Catch:{ all -> 0x0007 }
        return;
    L_0x0031:
        r1 = 0;
        r3 = r4.O00000Oo;	 Catch:{ Throwable -> 0x0045 }
        r3.update(r2, r6, r5, r1);	 Catch:{ Throwable -> 0x0045 }
        r5 = r4.O00000Oo;	 Catch:{ all -> 0x0007 }
        if (r5 == 0) goto L_0x005d;
    L_0x003b:
        r5 = r4.O00000Oo;	 Catch:{ all -> 0x0007 }
        r5.close();	 Catch:{ all -> 0x0007 }
    L_0x0040:
        r4.O00000Oo = r1;	 Catch:{ all -> 0x0007 }
        goto L_0x005d;
    L_0x0043:
        r5 = move-exception;
        goto L_0x005f;
    L_0x0045:
        r5 = move-exception;
        if (r7 != 0) goto L_0x0050;
    L_0x0048:
        r6 = "dbs";
        r7 = "udd";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r5, r6, r7);	 Catch:{ all -> 0x0043 }
        goto L_0x0053;
    L_0x0050:
        r5.printStackTrace();	 Catch:{ all -> 0x0043 }
    L_0x0053:
        r5 = r4.O00000Oo;	 Catch:{ all -> 0x0007 }
        if (r5 == 0) goto L_0x005d;
    L_0x0057:
        r5 = r4.O00000Oo;	 Catch:{ all -> 0x0007 }
        r5.close();	 Catch:{ all -> 0x0007 }
        goto L_0x0040;
    L_0x005d:
        monitor-exit(r0);	 Catch:{ all -> 0x0007 }
        return;
    L_0x005f:
        r6 = r4.O00000Oo;	 Catch:{ all -> 0x0007 }
        if (r6 == 0) goto L_0x006a;
    L_0x0063:
        r6 = r4.O00000Oo;	 Catch:{ all -> 0x0007 }
        r6.close();	 Catch:{ all -> 0x0007 }
        r4.O00000Oo = r1;	 Catch:{ all -> 0x0007 }
    L_0x006a:
        throw r5;	 Catch:{ all -> 0x0007 }
    L_0x006b:
        monitor-exit(r0);	 Catch:{ all -> 0x0007 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO0O0o0o.O000000o(java.lang.String, java.lang.Object, boolean):void");
    }

    /* JADX WARNING: Missing block: B:65:0x00ba, code skipped:
            return;
     */
    public <T> void O000000o(java.util.List<T> r6) {
        /*
        r5 = this;
        r0 = r5.O00000o0;
        monitor-enter(r0);
        if (r6 == 0) goto L_0x00b9;
    L_0x0005:
        r1 = r6.size();	 Catch:{ all -> 0x00b7 }
        if (r1 != 0) goto L_0x000d;
    L_0x000b:
        goto L_0x00b9;
    L_0x000d:
        r1 = 0;
        r1 = r5.O00000Oo(r1);	 Catch:{ all -> 0x00b7 }
        r5.O00000Oo = r1;	 Catch:{ all -> 0x00b7 }
        r1 = r5.O00000Oo;	 Catch:{ all -> 0x00b7 }
        if (r1 != 0) goto L_0x001a;
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x00b7 }
        return;
    L_0x001a:
        r1 = 0;
        r2 = r5.O00000Oo;	 Catch:{ Throwable -> 0x0062 }
        r2.beginTransaction();	 Catch:{ Throwable -> 0x0062 }
        r6 = r6.iterator();	 Catch:{ Throwable -> 0x0062 }
    L_0x0024:
        r2 = r6.hasNext();	 Catch:{ Throwable -> 0x0062 }
        if (r2 == 0) goto L_0x0034;
    L_0x002a:
        r2 = r6.next();	 Catch:{ Throwable -> 0x0062 }
        r3 = r5.O00000Oo;	 Catch:{ Throwable -> 0x0062 }
        r5.O000000o(r3, r2);	 Catch:{ Throwable -> 0x0062 }
        goto L_0x0024;
    L_0x0034:
        r6 = r5.O00000Oo;	 Catch:{ Throwable -> 0x0062 }
        r6.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0062 }
        r6 = r5.O00000Oo;	 Catch:{ Throwable -> 0x0047 }
        r6 = r6.inTransaction();	 Catch:{ Throwable -> 0x0047 }
        if (r6 == 0) goto L_0x004f;
    L_0x0041:
        r6 = r5.O00000Oo;	 Catch:{ Throwable -> 0x0047 }
        r6.endTransaction();	 Catch:{ Throwable -> 0x0047 }
        goto L_0x004f;
    L_0x0047:
        r6 = move-exception;
        r2 = "dbs";
        r3 = "ild";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r6, r2, r3);	 Catch:{ all -> 0x00b7 }
    L_0x004f:
        r6 = r5.O00000Oo;	 Catch:{ Throwable -> 0x0057 }
        r6.close();	 Catch:{ Throwable -> 0x0057 }
        r5.O00000Oo = r1;	 Catch:{ Throwable -> 0x0057 }
        goto L_0x008e;
    L_0x0057:
        r6 = move-exception;
        r1 = "dbs";
        r2 = "ild";
    L_0x005c:
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r6, r1, r2);	 Catch:{ all -> 0x00b7 }
        goto L_0x008e;
    L_0x0060:
        r6 = move-exception;
        goto L_0x0090;
    L_0x0062:
        r6 = move-exception;
        r2 = "dbs";
        r3 = "ild";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r6, r2, r3);	 Catch:{ all -> 0x0060 }
        r6 = r5.O00000Oo;	 Catch:{ Throwable -> 0x0078 }
        r6 = r6.inTransaction();	 Catch:{ Throwable -> 0x0078 }
        if (r6 == 0) goto L_0x0080;
    L_0x0072:
        r6 = r5.O00000Oo;	 Catch:{ Throwable -> 0x0078 }
        r6.endTransaction();	 Catch:{ Throwable -> 0x0078 }
        goto L_0x0080;
    L_0x0078:
        r6 = move-exception;
        r2 = "dbs";
        r3 = "ild";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r6, r2, r3);	 Catch:{ all -> 0x00b7 }
    L_0x0080:
        r6 = r5.O00000Oo;	 Catch:{ Throwable -> 0x0088 }
        r6.close();	 Catch:{ Throwable -> 0x0088 }
        r5.O00000Oo = r1;	 Catch:{ Throwable -> 0x0088 }
        goto L_0x008e;
    L_0x0088:
        r6 = move-exception;
        r1 = "dbs";
        r2 = "ild";
        goto L_0x005c;
    L_0x008e:
        monitor-exit(r0);	 Catch:{ all -> 0x00b7 }
        return;
    L_0x0090:
        r2 = r5.O00000Oo;	 Catch:{ Throwable -> 0x009e }
        r2 = r2.inTransaction();	 Catch:{ Throwable -> 0x009e }
        if (r2 == 0) goto L_0x00a6;
    L_0x0098:
        r2 = r5.O00000Oo;	 Catch:{ Throwable -> 0x009e }
        r2.endTransaction();	 Catch:{ Throwable -> 0x009e }
        goto L_0x00a6;
    L_0x009e:
        r2 = move-exception;
        r3 = "dbs";
        r4 = "ild";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r2, r3, r4);	 Catch:{ all -> 0x00b7 }
    L_0x00a6:
        r2 = r5.O00000Oo;	 Catch:{ Throwable -> 0x00ae }
        r2.close();	 Catch:{ Throwable -> 0x00ae }
        r5.O00000Oo = r1;	 Catch:{ Throwable -> 0x00ae }
        goto L_0x00b6;
    L_0x00ae:
        r1 = move-exception;
        r2 = "dbs";
        r3 = "ild";
        com.amap.api.mapcore.util.oO0OoOO0.O000000o(r1, r2, r3);	 Catch:{ all -> 0x00b7 }
    L_0x00b6:
        throw r6;	 Catch:{ all -> 0x00b7 }
    L_0x00b7:
        r6 = move-exception;
        goto L_0x00bb;
    L_0x00b9:
        monitor-exit(r0);	 Catch:{ all -> 0x00b7 }
        return;
    L_0x00bb:
        monitor-exit(r0);	 Catch:{ all -> 0x00b7 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO0O0o0o.O000000o(java.util.List):void");
    }

    public <T> List<T> O00000Oo(String str, Class<T> cls) {
        return O000000o(str, (Class) cls, false);
    }
}
