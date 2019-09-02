package cn.jiguang.g.b;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import cn.jiguang.e.c;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map.Entry;

public final class b {
    public static a a(SharedPreferences sharedPreferences, a aVar) {
        a aVar2 = new a();
        if (aVar == null) {
            return aVar2;
        }
        for (Entry entry : aVar.a()) {
            String str = (String) entry.getKey();
            Serializable a = a(sharedPreferences, str, a.a((Serializable) entry.getValue()));
            if (a != null) {
                aVar2.a(str, a);
            }
        }
        return aVar2;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0060=Splitter:B:34:0x0060, B:14:0x0029=Splitter:B:14:0x0029} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0060 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:5:0x000e, B:19:0x003c] */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|16) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:34|35|36) */
    /* JADX WARNING: Missing block: B:16:0x0032, code skipped:
            return java.lang.Long.valueOf((long) r6.getInt(r7, 0));
     */
    /* JADX WARNING: Missing block: B:22:0x0045, code skipped:
            r8 = move-exception;
     */
    /* JADX WARNING: Missing block: B:24:?, code skipped:
            r2 = r6.getLong(r7, 0);
            r6 = (int) r2;
     */
    /* JADX WARNING: Missing block: B:25:0x004e, code skipped:
            if (((long) r6) == r2) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:27:0x0054, code skipped:
            return java.lang.Integer.valueOf(r6);
     */
    /* JADX WARNING: Missing block: B:28:0x0055, code skipped:
            throw r8;
     */
    /* JADX WARNING: Missing block: B:36:0x0064, code skipped:
            return cn.jiguang.g.b.a.a(r6, r7);
     */
    public static java.io.Serializable a(android.content.SharedPreferences r6, java.lang.String r7, int r8) {
        /*
        r0 = r6.contains(r7);
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = 0;
        r0 = 0;
        switch(r8) {
            case 0: goto L_0x005b;
            case 1: goto L_0x0056;
            case 2: goto L_0x003c;
            case 3: goto L_0x0033;
            case 4: goto L_0x0020;
            case 5: goto L_0x0016;
            case 6: goto L_0x0011;
            default: goto L_0x000e;
        };
    L_0x000e:
        r6 = new java.lang.IllegalArgumentException;	 Catch:{ Throwable -> 0x006b }
        goto L_0x0065;
    L_0x0011:
        r6 = cn.jiguang.g.b.a.a(r6, r7);	 Catch:{ Throwable -> 0x006b }
        return r6;
    L_0x0016:
        r8 = 0;
        r6 = r6.getFloat(r7, r8);	 Catch:{ Throwable -> 0x006b }
        r6 = java.lang.Float.valueOf(r6);	 Catch:{ Throwable -> 0x006b }
        return r6;
    L_0x0020:
        r2 = r6.getLong(r7, r2);	 Catch:{ ClassCastException -> 0x0029 }
        r8 = java.lang.Long.valueOf(r2);	 Catch:{ ClassCastException -> 0x0029 }
        return r8;
    L_0x0029:
        r6 = r6.getInt(r7, r0);	 Catch:{ Throwable -> 0x006b }
        r2 = (long) r6;	 Catch:{ Throwable -> 0x006b }
        r6 = java.lang.Long.valueOf(r2);	 Catch:{ Throwable -> 0x006b }
        return r6;
    L_0x0033:
        r6 = r6.getBoolean(r7, r0);	 Catch:{ Throwable -> 0x006b }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Throwable -> 0x006b }
        return r6;
    L_0x003c:
        r8 = r6.getInt(r7, r0);	 Catch:{ ClassCastException -> 0x0045 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ ClassCastException -> 0x0045 }
        return r8;
    L_0x0045:
        r8 = move-exception;
        r2 = r6.getLong(r7, r2);	 Catch:{ Throwable -> 0x006b }
        r6 = (int) r2;	 Catch:{ Throwable -> 0x006b }
        r4 = (long) r6;	 Catch:{ Throwable -> 0x006b }
        r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0055;
    L_0x0050:
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x006b }
        return r6;
    L_0x0055:
        throw r8;	 Catch:{ Throwable -> 0x006b }
    L_0x0056:
        r6 = r6.getString(r7, r1);	 Catch:{ Throwable -> 0x006b }
        return r6;
    L_0x005b:
        r8 = r6.getString(r7, r1);	 Catch:{ ClassCastException -> 0x0060 }
        return r8;
    L_0x0060:
        r6 = cn.jiguang.g.b.a.a(r6, r7);	 Catch:{ Throwable -> 0x006b }
        return r6;
    L_0x0065:
        r8 = "[SpHelper], action - readInternal , unsupport type";
        r6.<init>(r8);	 Catch:{ Throwable -> 0x006b }
        throw r6;	 Catch:{ Throwable -> 0x006b }
    L_0x006b:
        r6 = move-exception;
        r8 = "SpHelper";
        r0 = new java.lang.StringBuilder;
        r2 = "exception when get [";
        r0.<init>(r2);
        r0.append(r7);
        r7 = "]";
        r0.append(r7);
        r7 = r6.getMessage();
        r0.append(r7);
        r7 = r0.toString();
        cn.jiguang.e.c.c(r8, r7, r6);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.b.b.a(android.content.SharedPreferences, java.lang.String, int):java.io.Serializable");
    }

    public static <T extends Serializable> T a(SharedPreferences sharedPreferences, String str, T t) {
        try {
            Serializable a = a(sharedPreferences, str, a.a(t));
            return a == null ? t : a;
        } catch (Throwable th) {
            c.c("SpHelper", th.getMessage(), th);
            return t;
        }
    }

    private static <T extends Serializable> void a(Editor editor, String str, T t) {
        if (t == null) {
            editor.remove(str);
        } else if (t instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof Integer) {
            editor.putInt(str, ((Integer) t).intValue());
        } else if (t instanceof Long) {
            editor.putLong(str, ((Long) t).longValue());
        } else if (t instanceof Float) {
            editor.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof String) {
            editor.putString(str, (String) t);
        } else {
            if ((t instanceof HashSet) && VERSION.SDK_INT >= 11) {
                try {
                    editor.putStringSet(str, (HashSet) t);
                } catch (ClassCastException unused) {
                }
            }
        }
    }

    public static boolean a(SharedPreferences sharedPreferences, ContentValues contentValues) {
        if (contentValues == null) {
            return true;
        }
        Editor edit = sharedPreferences.edit();
        for (Entry entry : contentValues.valueSet()) {
            a(edit, (String) entry.getKey(), (Serializable) entry.getValue());
        }
        return edit.commit();
    }

    public static boolean b(SharedPreferences sharedPreferences, a aVar) {
        if (aVar == null) {
            return true;
        }
        Editor edit = sharedPreferences.edit();
        for (Entry entry : aVar.a()) {
            a(edit, (String) entry.getKey(), (Serializable) entry.getValue());
        }
        return edit.commit();
    }

    public static <T extends Serializable> boolean b(SharedPreferences sharedPreferences, String str, T t) {
        Editor edit = sharedPreferences.edit();
        a(edit, str, (Serializable) t);
        return edit.commit();
    }
}
