package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: SystemClassLoaderAdder */
public final class ai {
    private static int O000000o;

    /* compiled from: SystemClassLoaderAdder */
    public static final class O000000o {
        private oO0O00o0 O000000o;
        private String O00000Oo;
        private String O00000o0;

        public O000000o(oO0O00o0 oo0o00o0, String str, String str2) {
            this.O000000o = oo0o00o0;
            this.O00000Oo = str;
            this.O00000o0 = str2;
        }

        static /* synthetic */ void O000000o(ClassLoader classLoader, List list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object obj = t.O000000o((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList(list);
            t.O000000o(obj, "dexElements", (Object[]) t.O000000o(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file}));
        }

        public boolean O000000o(Context context, o0OO0o00 o0oo0o00) {
            boolean equals;
            ArrayList arrayList;
            File file;
            oO0O00o0 oo0o00o0 = this.O000000o;
            String str = this.O00000Oo;
            if (oo0o00o0 != null) {
                if (!(oo0o00o0.O0000O0o() || aa.O000000o(o0oo0o00))) {
                    new aj().O000000o(context, o0oo0o00);
                }
                if (oo0o00o0.O0000Oo0() && oo0o00o0.O00000o(context) && oo0o00o0.O0000O0o() && oo0o00o0.O0000OOo()) {
                    equals = oo0o00o0.O00000oo().equals(o0OO00o0.O000000o(str));
                    if (equals || aa.O000000o(o0oo0o00)) {
                        return false;
                    }
                    oO0O0O00.O000000o().O000000o(context);
                    oO0O0O00.O000000o().O000000o(o0oo0o00);
                    if (!oO0O0O00.O000000o().O000000o(this.O000000o.O00000o0().O0000OOo(), this.O000000o.O00000o0().O0000Oo0(), this.O000000o.O00000o0().O0000Oo()) || !oO0O00o0.O000000o(context, this.O000000o, o0oo0o00)) {
                        return false;
                    }
                    t.O00000o(this.O00000o0);
                    t.O00000oo(this.O00000o0);
                    arrayList = new ArrayList();
                    arrayList.add(new File(this.O00000Oo));
                    file = new File(this.O00000o0);
                    context.getApplicationContext();
                    try {
                        ai.O000000o((PathClassLoader) context.getClassLoader(), file, arrayList);
                        return true;
                    } catch (Throwable th) {
                        t.O000000o(th, "di");
                        return false;
                    }
                }
            }
            equals = false;
            if (equals) {
                return false;
            }
            oO0O0O00.O000000o().O000000o(context);
            oO0O0O00.O000000o().O000000o(o0oo0o00);
            if (!oO0O0O00.O000000o().O000000o(this.O000000o.O00000o0().O0000OOo(), this.O000000o.O00000o0().O0000Oo0(), this.O000000o.O00000o0().O0000Oo())) {
                return false;
            }
            t.O00000o(this.O00000o0);
            t.O00000oo(this.O00000o0);
            arrayList = new ArrayList();
            arrayList.add(new File(this.O00000Oo));
            file = new File(this.O00000o0);
            context.getApplicationContext();
            ai.O000000o((PathClassLoader) context.getClassLoader(), file, arrayList);
            return true;
        }
    }

    /* compiled from: SystemClassLoaderAdder */
    static final class O00000Oo {
        static /* synthetic */ void O000000o(ClassLoader classLoader, List list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            Object obj = t.O000000o((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            t.O000000o(obj, "dexElements", O00000Oo(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    throw ((IOException) it.next());
                }
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0019 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|5|6) */
        /* JADX WARNING: Missing block: B:7:0x003c, code skipped:
            r7 = move-exception;
     */
        /* JADX WARNING: Missing block: B:8:0x003d, code skipped:
            throw r7;
     */
        private static java.lang.Object[] O00000Oo(java.lang.Object r7, java.util.ArrayList<java.io.File> r8, java.io.File r9, java.util.ArrayList<java.io.IOException> r10) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException {
            /*
            r0 = 2;
            r1 = 1;
            r2 = 0;
            r3 = 3;
            r4 = "makeDexElements";
            r5 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.util.ArrayList.class;
            r5[r2] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.io.File.class;
            r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.util.ArrayList.class;
            r5[r0] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r4 = com.amap.api.mapcore.util.t.O000000o(r7, r4, r5);	 Catch:{ NoSuchMethodException -> 0x0019 }
            goto L_0x002d;
        L_0x0019:
            r4 = "makeDexElements";
            r5 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.util.List.class;
            r5[r2] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.io.File.class;
            r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.util.List.class;
            r5[r0] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r4 = com.amap.api.mapcore.util.t.O000000o(r7, r4, r5);	 Catch:{ NoSuchMethodException -> 0x003c }
        L_0x002d:
            r3 = new java.lang.Object[r3];
            r3[r2] = r8;
            r3[r1] = r9;
            r3[r0] = r10;
            r7 = r4.invoke(r7, r3);
            r7 = (java.lang.Object[]) r7;
            return r7;
        L_0x003c:
            r7 = move-exception;
            throw r7;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ai$O00000Oo.O00000Oo(java.lang.Object, java.util.ArrayList, java.io.File, java.util.ArrayList):java.lang.Object[]");
        }
    }

    /* compiled from: SystemClassLoaderAdder */
    static final class O00000o0 {
        static /* synthetic */ void O000000o(ClassLoader classLoader, List list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            Object obj = t.O000000o((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            t.O000000o(obj, "dexElements", O000000o(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    throw ((IOException) it.next());
                }
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0019 */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|5|6) */
        /* JADX WARNING: Missing block: B:9:0x0040, code skipped:
            return com.amap.api.mapcore.util.ai.O00000Oo.O000000o(r7, r8, r9, r10);
     */
        /* JADX WARNING: Missing block: B:10:0x0041, code skipped:
            r7 = move-exception;
     */
        /* JADX WARNING: Missing block: B:11:0x0042, code skipped:
            throw r7;
     */
        private static java.lang.Object[] O000000o(java.lang.Object r7, java.util.ArrayList<java.io.File> r8, java.io.File r9, java.util.ArrayList<java.io.IOException> r10) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException {
            /*
            r0 = 2;
            r1 = 1;
            r2 = 0;
            r3 = 3;
            r4 = "makePathElements";
            r5 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.util.List.class;
            r5[r2] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.io.File.class;
            r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.util.List.class;
            r5[r0] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r4 = com.amap.api.mapcore.util.t.O000000o(r7, r4, r5);	 Catch:{ NoSuchMethodException -> 0x0019 }
            goto L_0x002d;
        L_0x0019:
            r4 = "makePathElements";
            r5 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.util.ArrayList.class;
            r5[r2] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.io.File.class;
            r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.util.ArrayList.class;
            r5[r0] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r4 = com.amap.api.mapcore.util.t.O000000o(r7, r4, r5);	 Catch:{ NoSuchMethodException -> 0x003c }
        L_0x002d:
            r3 = new java.lang.Object[r3];
            r3[r2] = r8;
            r3[r1] = r9;
            r3[r0] = r10;
            r7 = r4.invoke(r7, r3);
            r7 = (java.lang.Object[]) r7;
            return r7;
        L_0x003c:
            r7 = com.amap.api.mapcore.util.ai.O00000Oo.O00000Oo(r7, r8, r9, r10);	 Catch:{ NoSuchMethodException -> 0x0041 }
            return r7;
        L_0x0041:
            r7 = move-exception;
            throw r7;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ai$O00000o0.O000000o(java.lang.Object, java.util.ArrayList, java.io.File, java.util.ArrayList):java.lang.Object[]");
        }
    }

    @SuppressLint({"NewApi"})
    public static void O000000o(PathClassLoader pathClassLoader, File file, List<File> list) throws Throwable {
        if (!list.isEmpty()) {
            if (VERSION.SDK_INT >= 23) {
                O00000o0.O000000o(pathClassLoader, list, file);
            } else if (VERSION.SDK_INT >= 19) {
                O00000Oo.O000000o(pathClassLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                O000000o.O000000o(pathClassLoader, list, file);
            } else {
                return;
            }
            O000000o = list.size();
            if (!((Boolean) t.O000000o(Class.forName("com.tencent.tinker.loader.TinkerTestDexLoad", true, pathClassLoader), "isPatch").get(null)).booleanValue()) {
                if (O000000o > 0) {
                    if (VERSION.SDK_INT >= 14) {
                        t.O000000o(t.O000000o((Object) pathClassLoader, "pathList").get(pathClassLoader), "dexElements", O000000o);
                    } else {
                        t.O000000o((Object) pathClassLoader, "mPaths", O000000o);
                        t.O000000o((Object) pathClassLoader, "mFiles", O000000o);
                        t.O000000o((Object) pathClassLoader, "mZips", O000000o);
                        try {
                            t.O000000o((Object) pathClassLoader, "mDexs", O000000o);
                        } catch (Exception unused) {
                        }
                    }
                }
                throw new o0O0oo0o("CHECK_DEX_INSTALL_FAIL");
            }
        }
    }
}
